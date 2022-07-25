package com.test.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orderdto {
    public Integer Id;
    public String Name;
    public Integer Qty;
    public Double Price;
}
