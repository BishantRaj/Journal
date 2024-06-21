package com.edigest.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.edigest.entity.JournalEntry;
import com.edigest.repository.JournalEntryRepository;

@Service
public class JournalEntryService {
	
	@Autowired
	private JournalEntryRepository repo;

	public void saveEntry(JournalEntry journalEntry) {
		repo.save(journalEntry);
	}
	
	public List<JournalEntry>getAll(){
		return repo.findAll();
	}
	
	public Optional<JournalEntry> getOne(ObjectId id) {
		return repo.findById(id);
	}
	
	public void delOne(ObjectId id) {
		repo.deleteById(id);
		
	}
}
