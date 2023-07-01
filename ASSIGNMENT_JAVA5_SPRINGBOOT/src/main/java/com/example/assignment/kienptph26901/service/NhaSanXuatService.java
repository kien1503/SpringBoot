package com.example.assignment.kienptph26901.service;

import com.example.assignment.kienptph26901.entity.NhaSanXuat;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface NhaSanXuatService {

    Page<NhaSanXuat> getAll(Integer pageNo, Integer size);

    List<NhaSanXuat> getNSX();

    NhaSanXuat getOne(UUID id);

    void saveOrUpdate(NhaSanXuat nhaSanXuat);

    void delete(UUID id);

}
