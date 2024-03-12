package dev.aditya.cartservice.services;

import dev.aditya.cartservice.modals.cart;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.*;
@Service
public class cartServiceImpl implements cartServices{
    private final String url="https://fakestoreapi.com/carts";
    private final RestTemplate restTemplate=new RestTemplate();
    public cart getCartById(int id){
        String call=url;
        call+="/";
        return restTemplate.getForObject(call+id,cart.class);
    }
    public List<cart> getAll(){
         cart[] c=restTemplate.getForObject(url,cart[].class);
         if(c!=null)
            return Arrays.stream(c).toList();
         return null;
    }
    //Not WORKING PROPERLY
    public List<cart> getDateRange( String startdate, String enddate){
        String call=url;
        if(!startdate.isEmpty()){
            call+="?startdate="+startdate;
        }
        if(!enddate.isEmpty()){
            call+="&enddate="+enddate;
        }
        cart[] c=restTemplate.getForObject(call,cart[].class);
        if(c!=null){
            return Arrays.stream(c).toList();
        }
        return null;
    }
    public List<cart> getUserCart(int id){
        String call=url;
        call+="/user/";
        cart[] c=restTemplate.getForObject(call+id,cart[].class);
        if(c!=null)
         return Arrays.stream(c).toList();
        return null;
    }
    public cart createCart(cart newCart){
        restTemplate.postForObject(url, newCart, cart.class);
        return newCart;
    }
    public cart updateCart(int id,cart newCart){
        cart oldCart=getCartById(id);
        if(oldCart!=null){
            restTemplate.put(url+"/"+id, newCart);
        }
        return newCart;
    }

    public cart deleteCart(int id){
        cart oldCart=getCartById(id);
        if(oldCart!=null){
            restTemplate.delete(url+"/"+id);
        }
        return oldCart;
    }
}


