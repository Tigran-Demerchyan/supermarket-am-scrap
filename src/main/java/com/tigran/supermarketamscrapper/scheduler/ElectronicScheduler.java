package com.tigran.supermarketamscrapper.scheduler;

import com.tigran.supermarketamscrapper.controller.ElectronicController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ElectronicScheduler {

    @Autowired
    private ElectronicController electronicController;

    @Scheduled(fixedRate = 20_000)
    public void addElectronic() throws IOException {
        electronicController.addElectronic();
    }
}
