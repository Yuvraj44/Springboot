package com.example.CallerLog.Functions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.CallerLog.User.Contact;
import com.example.CallerLog.User.ContactRepo;
import com.example.CallerLog.User.UserRepo;
import com.example.CallerLog.User.callUser;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactFunc {
	   @Autowired
	    private ContactRepo contactRepository;
	   @Autowired 
	   private UserRepo userRepository;
	    
	    
	    @PostMapping("/add")
	    public ResponseEntity<?> addContact(@RequestHeader("phone") String phone, @RequestBody Contact contact) {
	        callUser user = userRepository.findByPhoneNumber(phone)
	                                      .orElseThrow(() -> new RuntimeException("User not found"));
	        contact.setUser(user);
	        contactRepository.save(contact);
	        return ResponseEntity.ok("Contact added successfully");
	    }
	    
	    @PostMapping("/mark-spam")
	    public ResponseEntity<?> markAsSpam(@RequestParam String phoneNumber) {
	        List<Contact> contacts = contactRepository.findByPhoneNumber(phoneNumber);
	        if (contacts.isEmpty()) {
	            Contact newContact = new Contact();
	            newContact.setPhoneNumber(phoneNumber);
	            newContact.setSpamCount(1);
	            contactRepository.save(newContact);
	        } else {
	            contacts.forEach(contact -> {
	                contact.setSpamCount(contact.getSpamCount() + 1);
	                contactRepository.save(contact);
	            });
	        }
	        return ResponseEntity.ok("Number marked as spam");
	    }

}
