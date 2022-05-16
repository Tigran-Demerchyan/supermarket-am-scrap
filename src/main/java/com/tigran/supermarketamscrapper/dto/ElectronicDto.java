package com.tigran.supermarketamscrapper.dto;

import com.tigran.supermarketamscrapper.entity.Electronic;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ElectronicDto {
    private String description;
    private String discount;
    private String link;
    private double price;
    private double oldPrice;

    public ElectronicDto(Electronic electronic) {
        this.description = electronic.getDescription();
        this.discount = electronic.getDiscount();
        this.link = electronic.getLink();
        this.price = electronic.getPrice();
        this.oldPrice = electronic.getOldPrice();
    }
}
