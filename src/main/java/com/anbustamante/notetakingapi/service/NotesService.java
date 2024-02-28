package com.anbustamante.notetakingapi.service;

import com.anbustamante.notetakingapi.dao.NotesDao;
import com.anbustamante.notetakingapi.dto.Notes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesService {
    @Autowired
    private NotesDao notesDao;

    public List<Notes> getNotes() {
        return notesDao.findAll();
    }

    public Notes getNote(String Id) {
        return notesDao.findById(Integer.parseInt(Id)).get();
    }

    public Notes deleteNote(String id) {
        Notes note = getNote(id);
        notesDao.delete(note);
        return note;
    }

    public Notes addNote(Notes note) {
        return notesDao.save(note);
    }

    public Notes updateNote(Notes note) {
        return notesDao.save(note);
    }

    public String archiveNote(String id) {
        Notes note = getNote(id);

        if(note.getActive() == 1){
            note.setActive(0);
            notesDao.save(note);
            return "Note unarchived";
        } else {
            note.setActive(1);
            notesDao.save(note);
            return "Note archived";
        }

    }

    public List<Notes> getArchivedNotes() {
        return notesDao.findByActive(0);
    }

    public List<Notes> getUnarchivedNotes() {
        return notesDao.findByActive(1);
    }
}
