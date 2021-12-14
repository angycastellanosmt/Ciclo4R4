/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.usa.ciclo4.retocuatro.repository.crud;

import co.edu.usa.ciclo4.retocuatro.model.Gadget;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author angycastel
 */
public interface GadgetCrudRepository extends MongoRepository<Gadget,Integer>{
    
}
