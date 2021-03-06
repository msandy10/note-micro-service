package com.noteservice.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.noteservice.pojo.Note;
import com.noteservice.pojo.NoteDTO;
import com.noteservice.repositories.NotesRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class NoteServiceTest {
	private NoteService noteService;
	private NotesRepository repositoryMock;

	@Before
	public void setUp() {
		repositoryMock = Mockito.mock(NotesRepository.class);
		noteService = new NoteService();
		noteService.setNotesRepository(repositoryMock);
	}
	
	@Test
	public void testListNotes() {
		List<Note> notes = new ArrayList<>();
		notes.add(new Note("Sample title", "Note sasasasd", new Date(), new Date()));
		
		when(repositoryMock.findAll()).thenReturn(notes);

		List<NoteDTO> userdtos = noteService.getNotes();
		assertNotNull(userdtos);
		assertTrue(userdtos.size() == 1);
		
		notes.add(new Note("Sample title", "Note sasasasd", new Date(), new Date()));
		userdtos = noteService.getNotes();
		assertNotNull(userdtos);
		assertTrue(userdtos.size() == 2);
	}

	@Test
	public void testGetNoteById() {
		Long id = new Random().nextLong();
		Note note = new Note("Sample title", "Note sasasasd", new Date(), new Date());
		note.setId(id);
		when(repositoryMock.findOne(id)).thenReturn(note);

		NoteDTO noteDTO = noteService.getNoteById(id.toString());
		assertNotNull(noteDTO);
		assertThat(note.getTitle(),is(noteDTO.getTitle()));
		assertThat(note.getNote(),is(noteDTO.getNote()));
	}

	/*@Test
	public void testCreateNote() {
		Long id = new Random().nextLong();
		Note note = new Note("Sample title", "Note sasasasd", new Date(), new Date());
		Note note2 = new Note("Sample title", "Note sasasasd", new Date(), new Date());
		NoteDTO noteDTO = new NoteDTO("Sample title", "Note sasasasd");
		note.setId(id);
		when(repositoryMock.save(note)).thenReturn(note2);

		NoteDTO newNoteDTO = noteService.createNote(noteDTO);
		assertNotNull(newNoteDTO);
		assertNotNull(newNoteDTO.getId());
		assertThat(note.getTitle(),is(newNoteDTO.getTitle()));
		assertThat(note.getNote(),is(newNoteDTO.getNote()));
	}
*/
}
