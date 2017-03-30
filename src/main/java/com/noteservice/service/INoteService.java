package com.noteservice.service;

import java.util.List;

import com.noteservice.pojo.NoteDTO;

public interface INoteService {
	NoteDTO createNote(NoteDTO note);
	NoteDTO updateNote(NoteDTO note);
	void deleteNote(NoteDTO note);
	void deleteNoteById(String NoteId);
	NoteDTO getNoteById(String id);
	List<NoteDTO> getNotes();
}
