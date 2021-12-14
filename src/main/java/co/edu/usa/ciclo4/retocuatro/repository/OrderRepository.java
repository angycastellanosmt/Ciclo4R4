/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.ciclo4.retocuatro.repository;

import co.edu.usa.ciclo4.retocuatro.model.Order;
import co.edu.usa.ciclo4.retocuatro.repository.crud.OrderCrudRepository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

/**
 *
 * @author angycastel
 */
@Repository
public class OrderRepository {
    @Autowired
    private OrderCrudRepository orderCrudRepository;
    
    //Atributo de relación
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Order> getAll() {
        return (List<Order>) orderCrudRepository.findAll();
    }

    public Optional<Order> getOrder(int id) {
        return orderCrudRepository.findById(id);
    }

    public Order save(Order order) {
        return orderCrudRepository.save(order);
    }

    public void update(Order order) {
        orderCrudRepository.save(order);
    }

    public void delete(Order order) {
        orderCrudRepository.delete(order);
    }
    
    public Optional<Order> lastOrderId(){
        return orderCrudRepository.findTopByOrderByIdDesc();
    }
    
   public List<Order> getOrderbyZone(String zone){
       return orderCrudRepository.findBySalesManZone(zone);
   }
   
   /*
   Método para recuperar un listado delas ordenes de un vendedor
   */
   public List<Order> ordersSalesManByID(Integer id){
       Query query = new Query();
       Criteria dateCriteria=Criteria.where("salesMan.id").is(id);
       query.addCriteria(dateCriteria);
       List<Order> orders = mongoTemplate.find(query, Order.class);
       return orders;
   }
   
   /*
   Método para recuperar un listado de ordenes por vendedor y por estado
   */
   public List<Order> ordersSalesManByState(String state, Integer id){
   Query query = new Query();
   Criteria datecriteria = Criteria.where("salesMan.id").is(id).and("status").is(state);
   query.addCriteria(datecriteria);
   List<Order> orders = mongoTemplate.find(query,Order.class);
    return orders;
   }
   
   /*
   Método para recuperar unlistado de ordenes por fecha y vendedor
   */
         public List<Order> ordersSalesManByDate(String dateStr, Integer id) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Query query = new Query();
        
        Criteria dateCriteria = Criteria.where("registerDay")
                        .gte(LocalDate.parse(dateStr, dtf).minusDays(1).atStartOfDay())
                        .lt(LocalDate.parse(dateStr, dtf).plusDays(1).atStartOfDay())
                        .and("salesMan.id").is(id);
       query.addCriteria(dateCriteria); 
        List<Order> orders = mongoTemplate.find(query,Order.class);
        
        return orders;       
    }       
    }