package com.tigran.supermarketamscrapper.entity;

import com.tigran.supermarketamscrapper.dto.ElectronicDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Data
@NoArgsConstructor
@Table(name = "electronics")
public class Electronic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "description")
    private String description;
    @Column(name = "link")
    private String link;
    @Column(name = "discount")
    private String discount;
    @Column(name = "price")
    private double price;
    @Column(name = "oldPrice")
    private double oldPrice;

    public Electronic(ElectronicDto dto) {
        this.description = dto.getDescription();
        this.discount = dto.getDiscount();
        this.link = dto.getLink();
        this.price = dto.getPrice();
        this.oldPrice = dto.getOldPrice();
    }
}
