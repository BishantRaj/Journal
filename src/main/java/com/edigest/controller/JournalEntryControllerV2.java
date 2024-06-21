package com.edigest.controller;

import java.time.LocalDateTime;
import java.util.*;

import org.springframework.web.bind.annotation.RestController;

import com.edigest.entity.JournalEntry;
import com.edigest.service.JournalEntryService;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class JournalEntryControllerV2 {
	@Autowired
	private JournalEntryService journalEntryService;

	
	@GetMapping("/")
	public List<JournalEntry>getAll(){
		return journalEntryService.getAll();
	}
	
	@GetMapping("/id/{myId}")
	public JournalEntry getOne(@PathVariable ObjectId myId){
		return journalEntryService.getOne(myId).orElse(null);
	}
	
	@PostMapping("/")
	public boolean createEntry(@RequestBody JournalEntry myEntry) {
		myEntry.setDate(LocalDateTime.now());
		journalEntryService.saveEntry(myEntry);
		return true;
	}
	@PutMapping("/edit/{myId}")
	public boolean editEntry(@PathVariable ObjectId myId,@RequestBody JournalEntry myEntry) {
		JournalEntry old=journalEntryService.getOne(myId).orElse(null);
		if(old!=null) {
		old.setTitle(myEntry.getTitle()!=null && !myEntry.getTitle().equals("")?myEntry.getTitle():old.getTitle());
		old.setContents(myEntry.getContents()!=null && !myEntry.getContents().equals("")?myEntry.getContents():old.getContents());
		journalEntryService.saveEntry(old);
		return true;
		}
		return false;
	}
	
	@DeleteMapping("/del/{myId}")
	public boolean delete(@PathVariable ObjectId myId) {
		journalEntryService.delOne(myId);
		return true;
	}
}
