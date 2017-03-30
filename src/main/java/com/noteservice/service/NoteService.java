package com.noteservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.noteservice.pojo.Note;
import com.noteservice.pojo.NoteDTO;
import com.noteservice.repositories.NotesRepository;

public class NoteService implements INoteService {

	private NotesRepository notesRepository;
	
	@Autowired
	public void setNotesRepository(NotesRepository notesRepository) {
		this.notesRepository = notesRepository;
	}

	@Override
	public NoteDTO createNote(NoteDTO note) {
		return null;
	}

	@Override
	public NoteDTO updateNote(NoteDTO note) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteNote(NoteDTO note) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteNoteById(String NoteId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public NoteDTO getNoteById(String id) {
		Note note = notesRepository.getOne(new Long(id));
		NoteDTO noteDto = new NoteDTO(note.getId(), note.getTitle(), note.getNote());
		noteDto.setCreatedDate(note.getCreatedDate());
		noteDto.setUpdatedDate(note.getUpdatedDate());
		return noteDto;
	}

	@Override
	public List<NoteDTO> getNotes() {
		List<Note> notes = notesRepository.findAll();
		List<NoteDTO> noteDtos = new ArrayList<>(); 
		NoteDTO notedto = null;
		for (Note note : notes) {
			notedto = new  NoteDTO(note.getId(),note.getTitle(),note.getNote());
			notedto.setCreatedDate(note.getCreatedDate());
			notedto.setUpdatedDate(note.getUpdatedDate());
			noteDtos.add(notedto);
		}
		return noteDtos;
	}
}
