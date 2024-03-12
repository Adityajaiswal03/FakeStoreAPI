package dev.aditya.cartservice.services;

import dev.aditya.cartservice.modals.cart;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


public interface cartServices {
    public cart getCartById(int id);
    public List<cart> getAll();
    public List<cart> getDateRange( String startdate, String enddate);
    public List<cart> getUserCart(int id);
    public cart createCart(cart newCart);
    public cart updateCart(int id,cart newCart);
    public cart deleteCart(int id);
}
