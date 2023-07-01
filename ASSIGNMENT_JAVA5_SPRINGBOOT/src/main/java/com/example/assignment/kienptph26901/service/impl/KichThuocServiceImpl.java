package com.example.assignment.kienptph26901.service.impl;

import com.example.assignment.kienptph26901.entity.KichThuoc;
import com.example.assignment.kienptph26901.repository.KichThuocRepository;
import com.example.assignment.kienptph26901.service.KichThuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class KichThuocServiceImpl implements KichThuocService {
    @Autowired
    private KichThuocRepository kichThuocRepository;

    @Override
    public Page<KichThuoc> getAll(Integer pageNo, Integer size) {
        return kichThuocRepository.findAll(PageRequest.of(pageNo, size));
    }

    @Override
    public List<KichThuoc> getKT() {
        return kichThuocRepository.findAll();
    }

    @Override
    public KichThuoc getOne(UUID id) {
        return kichThuocRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(KichThuoc kichThuoc) {
        kichThuocRepository.save(kichThuoc);
    }

    @Override
    public void delete(UUID id) {
        kichThuocRepository.deleteById(id);
    }
}
