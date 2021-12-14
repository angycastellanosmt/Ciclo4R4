/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.ciclo4.retocuatro.service;

import co.edu.usa.ciclo4.retocuatro.model.Order;
import co.edu.usa.ciclo4.retocuatro.repository.OrderRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author angycastel
 */
@Service
public class OrderService {
    
    
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    public Optional<Order> getOrder(int id) {
        return orderRepository.getOrder(id);
    }

    public Order saveOrder (Order order) {
        
        //obtiene el maximo id existente en la coleccion
        Optional<Order> orderIdMaxima = orderRepository.lastOrderId();
        
        //si el id de la orden que se recibe como parametro es nulo, entonces valida el maximo id existente en base de datos
        if (order.getId() == null) {
            //valida el maximo id generado, si no hay ninguno aun el primer id sera 1
            if (orderIdMaxima.isEmpty())
                order.setId(1);
            //si retorna informacion suma 1 al maximo id existente y lo asigna como el codigo de la orden
            else
                order.setId(orderIdMaxima.get().getId() + 1);
        }
        
        Optional<Order> e = orderRepository.getOrder(order.getId());
        if (e.isEmpty()) {
            return orderRepository.save(order);            
        }else{
            return order;
        }        
    }

    public Order update(Order order) {

        if (order.getId() != null) {
            Optional<Order> orderDb = orderRepository.getOrder(order.getId());
            if (!orderDb.isEmpty()) {
                if (order.getStatus() != null) {
                    orderDb.get().setStatus(order.getStatus());
                }
                orderRepository.update(orderDb.get());
                return orderDb.get();
            } else {
                return order;
            }
        } else {
            return order;
        }
    }

    public boolean delete(int id) {
        Boolean aBoolean = getOrder(id).map(order -> {
            orderRepository.delete(order);
            return true;
        }).orElse(false);
        return aBoolean;
    }
//    //Ordenes de pedido asociadas a los asesores de una zona
    public List<Order>getOrderByZone(String zone){
        return orderRepository.getOrderbyZone(zone);
    }
    
    //Ordenes de pedido asociadas a un vendedor
    public List<Order> ordersSalesManByID(Integer id){
        return orderRepository.ordersSalesManByID(id);
    }
    
    //Ordenes de pedido asociadas a un asesor y a una fecha
   // public List<Order> ordersSalesManByDate(String dateStr, int id) {
//        return orderRepository.ordersSalesManByDate(dateStr, id);
//    }
//    
    public List<Order> orderSalesManByState(String state, Integer id) {
       return orderRepository.ordersSalesManByState(state, id);
    }
    
     public List<Order> ordersSalesManByDate(String dateStr, Integer id) {
        return orderRepository.ordersSalesManByDate(dateStr,id);
    }
}

    

