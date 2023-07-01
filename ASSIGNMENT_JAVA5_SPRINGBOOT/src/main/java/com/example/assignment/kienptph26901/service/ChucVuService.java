package com.example.assignment.kienptph26901.service;

import com.example.assignment.kienptph26901.entity.ChucVu;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface ChucVuService {

    Page<ChucVu> getAll(Integer pageNo, Integer size);

    List<ChucVu> getCV();

    ChucVu getOne(UUID id);

    void saveOrUpdate(ChucVu chucVu);

    void delete(UUID id);

}
