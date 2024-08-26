package com.example.CallerLog.Functions;


public class ContactDTO {
    private String name;
    private String phoneNumber;
    private int spamCount;

    public ContactDTO(String name, String phoneNumber, int spamCount) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.spamCount = spamCount;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSpamCount() {
        return spamCount;
    }

    public void setSpamCount(int spamCount) {
        this.spamCount = spamCount;
    }
}
