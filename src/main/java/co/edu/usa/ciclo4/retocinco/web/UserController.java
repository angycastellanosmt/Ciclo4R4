/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.ciclo4.retocinco.web;

import co.edu.usa.ciclo4.retocinco.model.User;
import co.edu.usa.ciclo4.retocinco.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author angycastel
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {
    /*
    Instancia de la clase de servicio
    */
    @Autowired
    private UserService userService;
    
    /*
    Método para listar todos los usuarios
    */
    @GetMapping("/all")
    public List<User>getAll(){
        return userService.getAll();
    }
    
    /*
    Método para identificar usuarios por el id
    */
    @GetMapping("/{id}")
    public Optional<User>getUser(@PathVariable("id")int id){
        return userService.getUser(id);
    }
    
    /*
    Método para guardar el registro del nuevo usuario
    */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }
    
    /*
    Método para actualizar el registro de los usuarios
    */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User updateUser(@RequestBody User user){
     return userService.updateUser(user);
    }
    
    /*
    Método para borrar usuarios por el id
    */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int id){
        return userService.delete(id);
    }
    
    /*
    Método para verificar si el correo existe o no para hacer el post
    */
    @GetMapping("/emailexist/{email}")
    public boolean emailExists(@PathVariable("email")String email){
        return userService.emailExist(email);
    }
    
    /*
    Método para verificar si la combinación correo y contraseña existen
    */
    @GetMapping("/{email}/{password}")
    public User autenticarUser(@PathVariable("email")String email, @PathVariable("password")String password){
    return userService.autenticarUsuario(email, password);
    }  
 
    @GetMapping("/birthday/{month}")
    public List<User> birthtDayList(@PathVariable("month") String monthBirthtDay) {
        return userService.birthtDayList(monthBirthtDay);
    }
}
