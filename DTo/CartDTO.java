package dev.aditya.cartservice.DTo;

import dev.aditya.cartservice.modals.product;

import java.util.List;

public class CartDTO {
    private Long id;
    private  Long userId;
    private String date;
    List<product> products;
}
