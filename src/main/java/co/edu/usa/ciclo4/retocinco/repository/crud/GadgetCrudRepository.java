/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.usa.ciclo4.retocinco.repository.crud;

import co.edu.usa.ciclo4.retocinco.model.Gadget;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author angycastel
 */
public interface GadgetCrudRepository extends MongoRepository<Gadget,Integer>{
    
    //Retorna los gadget que contienen el texto dado en el campo descripción
        @Query("{'description':{'$regex':'?0','$options':'i'}}")
         List<Gadget> findGadgetByDescription (final String description);
         
         List<Gadget> findByPriceLessThanEqual(double precio);
    
}

