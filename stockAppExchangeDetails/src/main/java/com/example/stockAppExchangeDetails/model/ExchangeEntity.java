package com.example.stockAppExchangeDetails.model;

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
public class ExchangeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer exchangeId;
    private String exchangeName;
    private String remarks;
}
