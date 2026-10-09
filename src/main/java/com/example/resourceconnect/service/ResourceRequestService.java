package com.example.resourceconnect.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.resourceconnect.entity.ResourceRequest;
import com.example.resourceconnect.repository.ResourceRequestRepository;

@Service
public class ResourceRequestService {

    private final ResourceRequestRepository requestRepository;

    public ResourceRequestService(ResourceRequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public ResourceRequest createRequest(ResourceRequest request) {
        request.setStatus("PENDING");
        return requestRepository.save(request);
    }

    public List<ResourceRequest> getMyRequests(String email) {
        return requestRepository.findByRequesterEmail(email);
    }

    public List<ResourceRequest> getOwnerRequests(String ownerName) {
        return requestRepository.findByOwnerName(ownerName);
    }

    public ResourceRequest updateStatus(Long id, String status) {

        ResourceRequest request =
                requestRepository.findById(id).orElse(null);

        if (request == null) {
            return null;
        }

        request.setStatus(status);

        return requestRepository.save(request);
    }
}