package pl.sda.spring.serwis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.spring.serwis.dto.Order.*;
import pl.sda.spring.serwis.model.Order;
import pl.sda.spring.serwis.service.OrderService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/list/{order_id}")
    public ResponseEntity<Order> getOrderData(@PathVariable(name = "order_id") Long id) {
        Optional<Order> searchedOrder = orderService.getOrderData(id);
        if (searchedOrder.isPresent()) {
            return ResponseEntity.ok(searchedOrder.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<OrderDto>> listOrders() {
        return ResponseEntity.ok(orderService.getOrderList());
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<Order> editOrder(@PathVariable(name = "id") Long id, @RequestBody EditOrderDto dto) {
        Optional<Order> editedOrder = orderService.editOrder(id, dto);
        if (editedOrder.isPresent()) {
            return ResponseEntity.ok(editedOrder.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public void registerMobile(@RequestBody RegisterOrderDto dto){
        orderService.registerOrder(dto);
    }

    @PostMapping("/remove")
    public ResponseEntity<RemoveOrderDto> removeOrder(@RequestBody RemoveOrderDto dto){
        Optional<Order> removeOrder = orderService.removeOrder(dto.getRemove_id(),dto);
        if(removeOrder.isPresent()){
            ResponseEntity.ok(new DeletedOrderDto(removeOrder.get()));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
