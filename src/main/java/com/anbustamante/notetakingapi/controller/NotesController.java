package com.anbustamante.notetakingapi.controller;

import com.anbustamante.notetakingapi.dto.Notes;
import com.anbustamante.notetakingapi.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/notes")
public class NotesController {
    @Autowired
    private NotesService notesService;
    @GetMapping()
    public ResponseEntity<List<Notes>> getAllNotes(){
        return ResponseEntity.ok(notesService.getNotes());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Notes> getNote(@PathVariable String id){
        return ResponseEntity.ok(notesService.getNote(id));
    }
    @GetMapping("/archive/{id}")
    public ResponseEntity<String> archiveNote(@PathVariable String id){
        return ResponseEntity.ok(notesService.archiveNote(id));
    }
    @GetMapping("/archived")
    public ResponseEntity<List<Notes>> getArchivedNotes() {
        return ResponseEntity.ok(notesService.getArchivedNotes());
    }
    @GetMapping("/unarchived")
    public ResponseEntity<List<Notes>> getUnarchivedNotes() {
        return ResponseEntity.ok(notesService.getUnarchivedNotes());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Notes> deleteNote(@PathVariable String id) {
        return ResponseEntity.ok(notesService.deleteNote(id));
    }
    @PostMapping()
    public ResponseEntity<Notes> addNote(@RequestBody Notes note) {
        return ResponseEntity.ok(notesService.addNote(note));
    }
    @PutMapping()
    public ResponseEntity<Notes> updateNote(@RequestBody Notes note) {
        return ResponseEntity.ok(notesService.updateNote(note));
    }
}
