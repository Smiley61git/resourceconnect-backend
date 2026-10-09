package com.example.resourceconnect.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.resourceconnect.entity.Resource;
import com.example.resourceconnect.service.ResourceService;

@RestController
@RequestMapping("/api/resources")
@CrossOrigin(origins = "http://localhost:5173")
public class ResourceController {

    private final ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @GetMapping
    public ResponseEntity<List<Resource>> getAllResources() {
        return ResponseEntity.ok(
                resourceService.getAllResources()
        );
    }

    @PostMapping
    public ResponseEntity<Resource> addResource(
            @RequestBody Resource resource) {

        Resource savedResource =
                resourceService.addResource(resource);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedResource);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateResource(
            @PathVariable Long id,
            @RequestBody Resource resource) {

        Resource updatedResource =
                resourceService.updateResource(id, resource);

        if (updatedResource == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Resource not found");
        }

        return ResponseEntity.ok(updatedResource);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteResource(
            @PathVariable Long id) {

        resourceService.deleteResource(id);

        return ResponseEntity.ok(
                "Resource deleted successfully"
        );
    }
}