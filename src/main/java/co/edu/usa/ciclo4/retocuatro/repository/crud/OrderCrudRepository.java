/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.usa.ciclo4.retocuatro.repository.crud;

import co.edu.usa.ciclo4.retocuatro.model.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author angycastel
 */
public interface OrderCrudRepository extends MongoRepository<Order, Integer>{
    //Retorna las ordenes de pedido que coincidan con la zona recibida como parámetro
    @Query("{'salesMan.zone':?0}")
    List<Order>findBySalesManZone (final String zone);
    
    //Retorna las órdenes por estado
    @Query("{status: ?0}")
    List<Order> findByStatus(final String status);
    
    //Para seleccionar la orden con el id maximo
    Optional<Order> findTopByOrderByIdDesc();

}

