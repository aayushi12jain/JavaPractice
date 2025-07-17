package com.example.notesapi.controller;

import com.example.notesapi.model.Note;
import com.example.notesapi.repository.NoteRepository;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import com.example.notesapi.model.TagResponse;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private final NoteRepository noteRepository;
    private final RestTemplate restTemplate;

    public NoteController(NoteRepository noteRepository, RestTemplate restTemplate) {
        this.noteRepository = noteRepository;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/")
    public String hello() {
        return "App is up!";
    }

    @GetMapping
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        return noteRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /*
     * @PostMapping
     * public Note createNote(@RequestBody Note note) {
     * return noteRepository.save(note);
     * }
     */

    @PostMapping
    public Note createNote(@RequestBody Note noteRequest) {
        Note savedNote = noteRepository.save(noteRequest);

        // Call Scala service to get tags
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> payload = new HashMap<>();
        payload.put("content", savedNote.getContent());

        HttpEntity<Map<String, String>> request = new HttpEntity<>(payload, headers);

        try {
            ResponseEntity<TagResponse> response = restTemplate.postForEntity(
                    "http://localhost:8081/tags",
                    request,
                    TagResponse.class);

            List<String> tags = response.getBody().getTags();

            // (Optional) Save the tags back to the note and update
            savedNote.setTags(tags);
            savedNote = noteRepository.save(savedNote); // re-save with tags

        } catch (Exception e) {
            System.err.println("Failed to get tags: " + e.getMessage());
        }

        return savedNote;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody Note noteRequest) {
        return noteRepository.findById(id)
                .map(note -> {
                    note.setTitle(noteRequest.getTitle());
                    note.setContent(noteRequest.getContent());
                    return ResponseEntity.ok(noteRepository.save(note));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        return noteRepository.findById(id)
                .map(note -> {
                    noteRepository.delete(note);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
