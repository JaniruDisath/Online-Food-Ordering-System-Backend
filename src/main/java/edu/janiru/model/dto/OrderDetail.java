package edu.janiru.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDetail {
    private String orderID;
    private String itemId;
    private int orderQty;
    private double discount;
}
