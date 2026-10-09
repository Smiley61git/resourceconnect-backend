package com.example.resourceconnect.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.resourceconnect.entity.ResourceRequest;
import com.example.resourceconnect.service.ResourceRequestService;

@RestController
@RequestMapping("/api/requests")
@CrossOrigin(origins = {
    "http://localhost:5173",
    "http://localhost:5174",
    "https://resourceconnect-frontend.onrender.com"
})
public class ResourceRequestController {

    private final ResourceRequestService requestService;

    public ResourceRequestController(ResourceRequestService requestService) {
        this.requestService = requestService;
    }

    @PostMapping
    public ResponseEntity<ResourceRequest> createRequest(
            @RequestBody ResourceRequest request) {

        ResourceRequest savedRequest =
                requestService.createRequest(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedRequest);
    }

    @GetMapping("/my")
    public ResponseEntity<List<ResourceRequest>> getMyRequests(
            @RequestParam String email) {

        return ResponseEntity.ok(
                requestService.getMyRequests(email)
        );
    }

    @GetMapping("/owner")
    public ResponseEntity<List<ResourceRequest>> getOwnerRequests(
            @RequestParam String ownerName) {

        return ResponseEntity.ok(
                requestService.getOwnerRequests(ownerName)
        );
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<?> updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        ResourceRequest updatedRequest =
                requestService.updateStatus(id, status);

        if (updatedRequest == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Request not found");
        }

        return ResponseEntity.ok(updatedRequest);
    }
}
