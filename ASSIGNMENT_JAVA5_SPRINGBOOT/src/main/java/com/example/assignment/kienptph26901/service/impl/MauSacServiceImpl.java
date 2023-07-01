package com.example.assignment.kienptph26901.service.impl;

import com.example.assignment.kienptph26901.entity.MauSac;
import com.example.assignment.kienptph26901.repository.MauSacRepository;
import com.example.assignment.kienptph26901.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MauSacServiceImpl implements MauSacService {

    @Autowired
    private MauSacRepository mauSacRepository;

    @Override
    public Page<MauSac> getAll(Integer pageNo, Integer size) {
        return mauSacRepository.findAll(PageRequest.of(pageNo, size));
    }

    @Override
    public List<MauSac> getMS() {
        return mauSacRepository.findAll();
    }

    @Override
    public MauSac getOne(UUID id) {
        return mauSacRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(MauSac mauSac) {
        mauSacRepository.save(mauSac);
    }

    @Override
    public void delete(UUID id) {
        mauSacRepository.deleteById(id);
    }
}
