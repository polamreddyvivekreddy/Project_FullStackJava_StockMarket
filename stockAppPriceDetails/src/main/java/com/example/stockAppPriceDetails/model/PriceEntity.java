package com.example.stockAppPriceDetails.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class PriceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer companyId;
    private Integer stockCurrentPrice;
    private String address;
    private String date;
    private String stockExchange;
    private String time;

}
