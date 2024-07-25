package com.example.LogIn.Registration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class RegRequest {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
}
