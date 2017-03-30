package com.noteservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.noteservice.pojo.Note;

public interface NotesRepository extends JpaRepository<Note, Long>{
	List<Note> getNotesByCreatedBy(String user);
}
