package pl.sda.spring.serwis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.spring.serwis.dto.Order.EditOrderDto;
import pl.sda.spring.serwis.dto.Order.OrderDto;
import pl.sda.spring.serwis.dto.Order.RegisterOrderDto;
import pl.sda.spring.serwis.dto.Order.RemoveOrderDto;
import pl.sda.spring.serwis.model.Order;
import pl.sda.spring.serwis.repository.OrderRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Optional<Order> getOrderData(Long id) {
        return orderRepository.findById(id);
    }

    public List<OrderDto> getOrderList() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(order -> OrderDto.createDto(order))
                .collect(Collectors.toList());
    }

    public void registerOrder(RegisterOrderDto dto) {
        Order newOrder = new Order(
                dto.getRegister_title(),
                dto.getRegister_description()
        );
        orderRepository.save(newOrder);
    }

    public Optional<Order> removeOrder(Long id, RemoveOrderDto dto){
        if(id!=null){
            Optional<Order> searchedOrder = orderRepository.findById(id);
            if(searchedOrder.isPresent()){
                Order order = searchedOrder.get();
                if(order.getTitle().equals(dto.getRemove_title()) && order.getDescription().equals(dto.getRemove_description())){
                    orderRepository.delete(order);
                    return Optional.of(order);
                }
            }
        }
        return Optional.empty();
    }

    public Optional<Order> editOrder(Long id, EditOrderDto dto){
        Optional<Order> searchedOrder = orderRepository.findById(id);
        if(searchedOrder.isPresent()){
            Order order = searchedOrder.get();

            if(dto.getEdit_description() != null){
                order.setDescription(dto.getEdit_description());
            }

            order = orderRepository.save(order);

            return Optional.of(order);
        }
        return Optional.empty();
    }

}
