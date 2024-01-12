package com.learning.order.entity;

import com.learning.order.dto.FoodItemDTO;
import com.learning.order.dto.Restaurant;
import com.learning.order.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("order")
public class Order {
    private Integer orderId;
    private List<FoodItemDTO> foodItemDTOList;
    private Restaurant restaurant;
    private UserDTO userDTO;


  /*  public Order(Integer newOrderId, List<FoodItemDTO> foodItemDTOList, Restaurant restaurant) {
        this.orderId = newOrderId;
        this.foodItemDTOList = foodItemDTOList;
        this.restaurant = restaurant;
    }*/
}
