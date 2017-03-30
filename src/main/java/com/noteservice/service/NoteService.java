package com.noteservice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noteservice.pojo.Note;
import com.noteservice.pojo.NoteDTO;
import com.noteservice.repositories.NotesRepository;

@Service
public class NoteService implements INoteService {

	private NotesRepository notesRepository;
	
	@Autowired
	public void setNotesRepository(NotesRepository notesRepository) {
		this.notesRepository = notesRepository;
	}

	@Override
	public NoteDTO createNote(NoteDTO note) {
		Date currentDate = new Date();
		Note noteEntity = new Note(note.getTitle(),note.getNote(),currentDate,currentDate);
		Note newNoteEntity = notesRepository.save(noteEntity);
		note.setCreatedDate(currentDate);
		note.setUpdatedDate(currentDate);
		note.setId(newNoteEntity.getId());
		return note;
	}

	@Override
	public NoteDTO updateNote(NoteDTO note) {
		Date currentDate = new Date();
		Note noteEntity = new Note(note.getTitle(),note.getNote(),note.getCreatedDate(),currentDate);
		noteEntity = notesRepository.save(noteEntity);
		note.setUpdatedDate(currentDate);
		return note;
	}

	@Override
	public void deleteNote(NoteDTO note) {
		Note noteEntity = new Note(note.getTitle(), note.getNote(),note.getCreatedDate(),note.getUpdatedDate());
		noteEntity.setId(note.getId());
		notesRepository.delete(noteEntity);
	}

	@Override
	public void deleteNoteById(String noteId) {
		notesRepository.delete(new Long(noteId));
		
	}

	@Override
	public NoteDTO getNoteById(String id) {
		Note note = notesRepository.findOne(new Long(id));
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
