package com.example.assignment.kienptph26901.service;

import com.example.assignment.kienptph26901.entity.KichThuoc;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface KichThuocService {

    Page<KichThuoc> getAll(Integer pageNo, Integer size);

    List<KichThuoc> getKT();

    KichThuoc getOne(UUID id);

    void saveOrUpdate(KichThuoc kichThuoc);

    void delete(UUID id);

}
