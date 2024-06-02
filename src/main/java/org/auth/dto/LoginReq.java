// src/main/java/org/Auth/dto/LoginReq.java
package org.auth.dto;

import lombok.Data;

@Data
public class LoginReq {
    private String email;
    private String password;
}