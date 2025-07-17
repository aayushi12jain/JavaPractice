package com.example.notesapi.repository;

import com.example.notesapi.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    // You get basic CRUD methods for free:
    // findById, save, deleteById, findAll, etc.
}
