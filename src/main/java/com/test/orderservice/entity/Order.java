package com.test.orderservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="ORDER_TB")
public class Order {
    @Id
    private Integer Id;
    private String Name;
    private Integer Qty;
    private Double Price;
}
