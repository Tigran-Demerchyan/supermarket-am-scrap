package com.tigran.supermarketamscrapper.controller;

import com.tigran.supermarketamscrapper.dto.ElectronicDto;
import com.tigran.supermarketamscrapper.entity.Electronic;
import com.tigran.supermarketamscrapper.scrapper.ElectronicScrapper;
import com.tigran.supermarketamscrapper.service.ElectronicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/electronics")
public class ElectronicController {
    @Autowired
    private ElectronicService electronicService;



    @GetMapping
    public List<ElectronicDto>getAllElectronics(){
        List<Electronic> allElectronics = electronicService.getAllElectronics();
       return allElectronics.stream()
                .map(e -> new ElectronicDto(e))
                .collect(Collectors.toList());
    }

    @PostMapping("/save")

    public void addElectronic() throws IOException {
        ElectronicScrapper scrapper=new ElectronicScrapper();
        List<ElectronicDto> allElectronic = scrapper.getAllElectronic();

        allElectronic.stream()
                .forEach(e->electronicService.addElectronic(e));
    }
}
