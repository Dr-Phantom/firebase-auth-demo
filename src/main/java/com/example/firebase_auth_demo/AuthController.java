package com.example.firebase_auth_demo;

import com.example.firebase_auth_demo.dto.LoginRequest;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest loginRequest) {
        try {
            String idToken = loginRequest.getIdToken();
            if (idToken == null || idToken.isEmpty()) {
                throw new IllegalArgumentException("ID token is required");
            }
            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
            String email = decodedToken.getEmail();

            Map<String, String> response = new HashMap<>();
            response.put("message", "Login successful");
            response.put("email", email);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "Invalid token: " + e.getMessage());
            return ResponseEntity.status(401).body(error);
        }
    }
}