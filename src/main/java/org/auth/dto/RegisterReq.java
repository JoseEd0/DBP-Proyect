// src/main/java/org/Auth/dto/RegisterReq.java
package org.auth.dto;

import lombok.Data;

@Data
public class RegisterReq {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
}