package com.example.CallerLog.Functions;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.CallerLog.User.Contact;
import com.example.CallerLog.User.ContactRepo;
import com.example.CallerLog.User.UserRepo;
import com.example.CallerLog.User.callUser;

@RestController
@RequestMapping("/search")
public class SearchFunc {

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private ContactRepo contactRepository;

    @GetMapping("/by-name")
    public ResponseEntity<?> searchByName(@RequestParam String name) {
        List<Contact> contacts = contactRepository.findByNameContainingIgnoreCase(name);
        Set<ContactDTO> contactSet = contacts.stream()
                .map(contact -> new ContactDTO(contact.getName(), contact.getPhoneNumber(), contact.getSpamCount()))
                .collect(Collectors.toSet());

        return ResponseEntity.ok(contactSet);
    }

    @GetMapping("/by-phone")
    public ResponseEntity<?> searchByPhone(@RequestParam String phoneNumber) {
        Optional<callUser> user = userRepository.findByPhoneNumber(phoneNumber);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            List<Contact> contacts = contactRepository.findByPhoneNumber(phoneNumber);
            Set<ContactDTO> contactSet = contacts.stream()
                    .map(contact -> new ContactDTO(contact.getName(), contact.getPhoneNumber(), contact.getSpamCount()))
                    .collect(Collectors.toSet());
            return ResponseEntity.ok(contactSet);
        }
    }
}

