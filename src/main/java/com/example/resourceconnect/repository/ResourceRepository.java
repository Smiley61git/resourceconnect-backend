package com.example.resourceconnect.repository;

import com.example.resourceconnect.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Long> {

}