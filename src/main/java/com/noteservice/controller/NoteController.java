package com.noteservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.noteservice.pojo.NoteDTO;
import com.noteservice.service.INoteService;

@RestController
@RequestMapping("/notes")
public class NoteController {

	private static final String USER_HAS_BEEN_UPDATED_SUCCESFULLY = "User has been updated succesfully";
	private static final String USER_HAS_BEEN_CRETED_SUCCESFULLY = "User has been creted succesfully";
	private static final String USER_HAS_BEEN_DELETED_SUCCESFULLY = "User has been deletd succesfully";
	@Autowired
	INoteService noteService;
	
	@GetMapping
	public ResponseEntity<List<NoteDTO>> getUsers(){
		List<NoteDTO> notes =noteService.getNotes();
		return new ResponseEntity<List<NoteDTO>>(notes, HttpStatus.OK);
	}
	
	@GetMapping
	@RequestMapping("/{noteId}")
	public ResponseEntity<NoteDTO> getNoteById(@PathVariable String noteId){
		NoteDTO notes =noteService.getNoteById(noteId);
		return new ResponseEntity<NoteDTO>(notes, HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<String> creteUser(@Valid @RequestBody NoteDTO notes){
		noteService.createNote(notes);
		return new ResponseEntity<String>(USER_HAS_BEEN_CRETED_SUCCESFULLY, HttpStatus.CREATED);
	}
	
	
	@PutMapping
	public ResponseEntity<String> updateUser(@RequestBody NoteDTO noteDTO){
		noteService.updateNote(noteDTO);
		return new ResponseEntity<String>(USER_HAS_BEEN_UPDATED_SUCCESFULLY, HttpStatus.ACCEPTED);
	}

/*	@DeleteMapping
	@RequestMapping("/{id}")
	public ResponseEntity<String> deleteNoteByID(@PathVariable String id){
		noteService.deleteNoteById(id);
		return new ResponseEntity<String>(USER_HAS_BEEN_UPDATED_SUCCESFULLY, HttpStatus.ACCEPTED);
	}*/
	
	@DeleteMapping
	public ResponseEntity<String> deleteNote(@RequestBody NoteDTO noteDTO){
		noteService.deleteNote(noteDTO);
		return new ResponseEntity<String>(USER_HAS_BEEN_DELETED_SUCCESFULLY, HttpStatus.OK);
	}
}
