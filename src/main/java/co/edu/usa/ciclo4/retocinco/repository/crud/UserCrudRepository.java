/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.usa.ciclo4.retocinco.repository.crud;

import co.edu.usa.ciclo4.retocinco.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author angycastel
 */
public interface UserCrudRepository extends MongoRepository<User, Integer> {

    public Optional<User> findByEmail(String email);

    public Optional<User> findByEmailAndPassword(String email, String password);

//Para seleccionar el usuario con el id maximo
    Optional<User> findTopByOrderByIdDesc();
    
    List<User> findByMonthBirthtDay(String monthBirthtDay);
}
