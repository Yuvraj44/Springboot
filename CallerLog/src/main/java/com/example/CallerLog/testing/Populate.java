package com.example.CallerLog.testing;

import com.example.CallerLog.User.callUser;
import com.example.CallerLog.User.Contact;
import com.example.CallerLog.User.UserRepo;
import com.example.CallerLog.User.ContactRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Populate implements CommandLineRunner {

    private final UserRepo userRepo;
    private final ContactRepo contactRepo;
    private final PasswordEncoder passwordEncoder;

    public Populate(UserRepo userRepo, ContactRepo contactRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.contactRepo = contactRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        // Sample users
        callUser user1 = new callUser();
        user1.setName("John Doe");
        user1.setPhoneNumber("1234567890");
        user1.setEmail("john.doe@example.com");
        user1.setPassword(passwordEncoder.encode("password123"));
        userRepo.save(user1);

        callUser user2 = new callUser();
        user2.setName("Jane Smith");
        user2.setPhoneNumber("0987654321");
        user2.setEmail("jane.smith@example.com");
        user2.setPassword(passwordEncoder.encode("password456"));
        userRepo.save(user2);

        // Sample contacts for user1
        Contact contact1 = new Contact();
        contact1.setName("Alice");
        contact1.setPhoneNumber("1111111111");
        contact1.setSpamCount(0);
        contact1.setUser(user1);

        Contact contact2 = new Contact();
        contact2.setName("Bob");
        contact2.setPhoneNumber("2222222222");
        contact2.setSpamCount(1);
        contact2.setUser(user1);

        contactRepo.saveAll(Arrays.asList(contact1, contact2));

        // Sample contacts for user2
        Contact contact3 = new Contact();
        contact3.setName("Charlie");
        contact3.setPhoneNumber("3333333333");
        contact3.setSpamCount(2);
        contact3.setUser(user2);

        Contact contact4 = new Contact();
        contact4.setName("Dave");
        contact4.setPhoneNumber("4444444444");
        contact4.setSpamCount(0);
        contact4.setUser(user2);

        contactRepo.saveAll(Arrays.asList(contact3, contact4));

        System.out.println("Sample data loaded!");
    }
}

