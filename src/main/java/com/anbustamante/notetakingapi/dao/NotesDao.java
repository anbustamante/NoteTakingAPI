package com.anbustamante.notetakingapi.dao;

import com.anbustamante.notetakingapi.dto.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotesDao extends JpaRepository<Notes,Integer> {

    List<Notes> findByActive(int i);
}
