package com.example.resourceconnect.service;

import com.example.resourceconnect.entity.Resource;
import com.example.resourceconnect.repository.ResourceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService {

    private final ResourceRepository resourceRepository;

    public ResourceService(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    public Resource addResource(Resource resource) {
        return resourceRepository.save(resource);
    }

    public Resource updateResource(Long id, Resource newResource) {

        Resource existingResource =
                resourceRepository.findById(id).orElse(null);

        if (existingResource == null) {
            return null;
        }

        existingResource.setTitle(newResource.getTitle());
        existingResource.setDescription(newResource.getDescription());
        existingResource.setSubject(newResource.getSubject());
        existingResource.setResourceType(newResource.getResourceType());
        existingResource.setResourceUrl(newResource.getResourceUrl());

        return resourceRepository.save(existingResource);
    }

    public void deleteResource(Long id) {
        resourceRepository.deleteById(id);
    }
}