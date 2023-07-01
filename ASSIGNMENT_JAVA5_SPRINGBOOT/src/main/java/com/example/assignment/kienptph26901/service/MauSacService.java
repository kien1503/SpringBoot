package com.example.assignment.kienptph26901.service;

import com.example.assignment.kienptph26901.entity.MauSac;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface MauSacService {

    Page<MauSac> getAll(Integer pageNo, Integer size);

    List<MauSac> getMS();

    MauSac getOne(UUID id);

    void saveOrUpdate(MauSac mauSac);

    void delete(UUID id);

}
