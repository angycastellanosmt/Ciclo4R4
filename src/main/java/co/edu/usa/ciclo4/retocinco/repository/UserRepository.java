/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.ciclo4.retocinco.repository;

import co.edu.usa.ciclo4.retocinco.model.User;
import co.edu.usa.ciclo4.retocinco.repository.crud.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author angycastel
 */
@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;

    public List<User> getAll() {
        return userCrudRepository.findAll();
    }

    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }

    public User save(User user) {
        return userCrudRepository.save(user);
    }

    /*public void update(User user) {
        userCrudRepository.save(user);
    }*/
    public boolean emailExist(String email) {
        Optional<User> user = userCrudRepository.findByEmail(email);
        return user.isPresent();
    }

    public Optional<User> autenticarUsuario(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }

    public void delete(User user) {
        userCrudRepository.delete(user);
    }

    //Método para obtener el último id
    public Optional<User> lastUserId() {
        return userCrudRepository.findTopByOrderByIdDesc();
    }
    
     public List<User> birthtDayList(String monthBirthtDay) {
        return userCrudRepository.findByMonthBirthtDay(monthBirthtDay);
    }
}

