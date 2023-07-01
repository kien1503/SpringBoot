package com.example.assignment.kienptph26901.service.impl;

import com.example.assignment.kienptph26901.entity.HoaDon;
import com.example.assignment.kienptph26901.repository.HoaDonRepository;
import com.example.assignment.kienptph26901.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HoaDonServiceImpl implements HoaDonService {
    @Autowired
    private HoaDonRepository hoaDonRepository;

    @Override
    public Page<HoaDon> getAll(Integer pageNo, Integer size) {
        return hoaDonRepository.findAll(PageRequest.of(pageNo, size));
    }

    @Override
    public List<HoaDon> getHD() {
        return hoaDonRepository.findAll();
    }

    @Override
    public HoaDon getOne(UUID id) {
        return hoaDonRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(HoaDon hoaDon) {
        hoaDonRepository.save(hoaDon);
    }

    @Override
    public void delete(UUID id) {
        hoaDonRepository.deleteById(id);
    }
}
