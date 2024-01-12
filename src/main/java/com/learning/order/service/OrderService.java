package com.learning.order.service;

import com.learning.order.dto.OrderDTO;
import com.learning.order.dto.OrderDTOFromFE;
import com.learning.order.dto.UserDTO;
import com.learning.order.entity.Order;
import com.learning.order.mapper.OrderMapper;
import com.learning.order.repo.OrderRepo;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    SequenceGenerator sequenceGenerator;

    @Autowired
    RestTemplate restTemplate;

    public OrderDTO saveOrderIndb(OrderDTOFromFE orderDetails){
        Integer  newOrderId =sequenceGenerator.generateNextOrderId();
       UserDTO userDTO = fetchUserDetailsFromUserId(orderDetails.getUserId());
        Order orderTobeSaved = new Order(newOrderId, orderDetails.getFoodItemList(), orderDetails.getRestaurant(),userDTO);
        orderRepo.save(orderTobeSaved);
        return OrderMapper.INSTANCE.mapOrderToOrderDTO(orderTobeSaved);
    }

    private UserDTO fetchUserDetailsFromUserId(Integer userId) {
        return restTemplate.getForObject("http://User-SERVICE/user/fetchUserById/" + userId, UserDTO.class);

    }

}
