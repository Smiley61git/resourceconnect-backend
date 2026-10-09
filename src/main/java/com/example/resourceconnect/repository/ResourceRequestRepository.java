package com.example.resourceconnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.resourceconnect.entity.ResourceRequest;

public interface ResourceRequestRepository
        extends JpaRepository<ResourceRequest, Long> {

    List<ResourceRequest> findByRequesterEmail(String requesterEmail);

    List<ResourceRequest> findByOwnerName(String ownerName);
}