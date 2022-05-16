package com.tigran.supermarketamscrapper.service;

import com.tigran.supermarketamscrapper.dto.ElectronicDto;
import com.tigran.supermarketamscrapper.entity.Electronic;
import com.tigran.supermarketamscrapper.repo.ElectronicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ElectronicService {

    @Autowired
    private ElectronicRepository electronicRepository;


    public List<Electronic> getAllElectronics() {
        return electronicRepository.findAll();
    }

    public void addElectronic(ElectronicDto dto) {
        Electronic electronic = new Electronic(dto);
        Electronic byLink = electronicRepository.findByLink(electronic.getLink());
        if (byLink == null) {
            System.out.println("your item was added successfully");
            electronicRepository.save(electronic);
        }else{
            System.out.println("this item was already added");
        }


    }
}
