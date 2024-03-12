package dev.aditya.cartservice.controller;
import dev.aditya.cartservice.modals.cart;
import dev.aditya.cartservice.services.cartServices;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class cartController {
    public cartServices cartServices;
    public cartController(cartServices cartServices) {
        this.cartServices = cartServices;
    }

    @GetMapping("/carts/{id}")
    public cart getCartById(@PathVariable("id") int id) {
        return cartServices.getCartById(id);
    }
    @GetMapping("/carts")
    public List<cart> getAll(){
        return cartServices.getAll();
    }

    @GetMapping("carts/{startdate}/{enddate}")
    public List<cart> getDateRange(@PathVariable("startdate")String s,@PathVariable("enddate")String e){
        return cartServices.getDateRange(s,e);
    }
    @GetMapping("carts/user/{id}")
    public List<cart> getUserCart(@PathVariable("id") int id){
        return cartServices.getUserCart(id);
    }

    @PostMapping("/carts")
    public cart createCart(@RequestBody cart newCart){
        return  cartServices.createCart(newCart);
    }
    @PutMapping("/carts/{id}")
    public cart updateCart(@PathVariable("id") int id, @RequestBody cart newCart){
        return cartServices.updateCart(id,newCart);
    }
    @DeleteMapping("/carts/{id}")
    public cart deleteCart(@PathVariable("id") int id){
        return cartServices.deleteCart(id);
    }

}
