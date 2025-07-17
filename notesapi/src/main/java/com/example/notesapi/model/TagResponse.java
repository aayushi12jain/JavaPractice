package com.example.notesapi.model;

import java.util.List;

public class TagResponse {
    private List<String> tags;

    public TagResponse() {
    }

    public TagResponse(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
