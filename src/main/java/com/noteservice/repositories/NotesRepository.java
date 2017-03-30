package com.noteservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.noteservice.pojo.Note;

public interface NotesRepository extends JpaRepository<Note, Long>{

}
