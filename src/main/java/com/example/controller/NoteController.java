package com.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.example.domain.Note;
import com.example.repository.NoteRepository;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
@Tag(name = "Note API", description = "방명록 API")
public class NoteController {

    private final NoteRepository noteRepository;

    @GetMapping
    @Operation(summary = "모든 메시지 조회")
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @PostMapping
    @Operation(summary = "메시지 작성")
    public Note createNote(@RequestBody Note note) {
        return noteRepository.save(note);
    }
}
