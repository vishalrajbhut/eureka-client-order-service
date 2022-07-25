package com.test.orderservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    private Integer PaymentId;
    private String PaymentStatus;
    private Double Price;
    private Integer OrderId;
}
