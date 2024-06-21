package com.edigest.controller;

import java.util.*;

import org.springframework.web.bind.annotation.RestController;

import com.edigest.entity.JournalEntry;

import org.bson.types.ObjectId;
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
@RequestMapping("/journal")
public class JournalEntryController {
	
	private Map<ObjectId,JournalEntry> journalEntries=new HashMap<>();
	
	@GetMapping
	public List<JournalEntry>getAll(){
		return new ArrayList<>(journalEntries.values());
	}
	
	@GetMapping("/id/{myId}")
	public JournalEntry getOne(@PathVariable ObjectId myId){
		return journalEntries.get(myId);
	}
	
	@PostMapping
	public boolean createEntry(@RequestBody JournalEntry myEntry) {
		if(journalEntries.containsKey(myEntry.getId()))
			return false;
		journalEntries.put(myEntry.getId(), myEntry);
		return true;
	}
	@PutMapping("/edit/{myId}")
	public boolean editEntry(@PathVariable ObjectId myId,@RequestBody JournalEntry myEntry) {
		journalEntries.put(myEntry.getId(), myEntry);
		return true;
	}
	
	@DeleteMapping("/del/{myId}")
	public boolean delete(@PathVariable ObjectId myId) {
		if(!journalEntries.containsKey(myId))
			return false;
		journalEntries.remove(myId);
		return true;
	}
}
