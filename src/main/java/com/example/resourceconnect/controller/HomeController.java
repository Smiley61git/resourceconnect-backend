
package com.example.resourceconnect.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public Map<String, String> home() {
        return Map.of(
            "application", "ResourceConnect",
            "message", "Welcome to ResourceConnect!",
            "status", "Backend is running successfully"
        );
    }
}