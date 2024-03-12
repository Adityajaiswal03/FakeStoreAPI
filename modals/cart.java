package dev.aditya.cartservice.modals;

import lombok.Getter;
import lombok.Setter;
import java.util.*;
@Getter
@Setter
public class cart {
    private Long id;
    private  Long userId;
    private String date;
    List<product> products;

}
