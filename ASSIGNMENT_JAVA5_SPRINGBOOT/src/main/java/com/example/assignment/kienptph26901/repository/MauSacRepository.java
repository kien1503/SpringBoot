package com.example.assignment.kienptph26901.repository;

import com.example.assignment.kienptph26901.entity.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MauSacRepository extends JpaRepository<MauSac, UUID> {
}
