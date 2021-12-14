/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.ciclo4.retocuatro.service;

import co.edu.usa.ciclo4.retocuatro.model.User;
import co.edu.usa.ciclo4.retocuatro.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author angycastel
 */
@Service
public class UserService {

    /**
     * Variable para instanciar el repositorio
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Método para retornar una lista de usuarios a partir del repositorio
     *
     * @return Lista de usuarios desde el repositorio
     */
    public List<User> getAll() {
        return userRepository.getAll();
    }

    /**
     * Método para obtener un usuario a partir del repositorio
     *
     * @param id: id del usuario
     * @return un usuario a partir del repositorio
     */
    public Optional<User> getUser(int id) {
        return userRepository.getUser(id);
    }

    /*
    public User saveUser (User user){
        if(user.getId()==null){
            return user;
        }else{
            Optional<User> useraux= userRepository.getUser(user.getId());
            if (useraux.isEmpty()){    
            if(emailExist(user.getEmail())==false){
                return userRepository.save(user);
            }else{
                return user;
            }
            }else{
        return user;
    }
     */
    /**
     * Método para crear un usuario a partir del repositorio
     *
     * @param user: atributos del usuario
     * @return
     */
    public User saveUser(User user) {

        //obtiene el máximo id existente en la colección
        Optional<User> userIdMaximo = userRepository.lastUserId();
        //si el id del usuario que se recibe como parámetro ess nulo, entonces valida el máximo generado
        if (user.getId() == null) {
            //valida el maximo id generado, si nohay ninguno aun, el primer id sera 1
            if (userIdMaximo.isEmpty()) {
                user.setId(1);
                //si retorna información suma 1 al máximo id existente y lo asigna como el id del user que le envio
            } else {
                user.setId(userIdMaximo.get().getId() + 1);
            }
        }
        Optional<User> useraux = userRepository.getUser(user.getId());
        if (useraux.isEmpty()) {
            if (emailExist(user.getEmail()) == false) {
                return userRepository.save(user);
            } else {
                return user;
            }
        } else {
            return user;
        }

    }

    /**
     * Método para validar si un correo existe o no
     *
     * @param email: correo a validar
     * @return un booleano que indica si el correo existe o no a partir del repo
     */
    public boolean emailExist(String email) {
        return userRepository.emailExist(email);
    }

    /**
     * Método para actualizar los atributos de un usuario
     *
     * @param user: usuario a actualizar con sus atributos
     * @return un usuario actualizado con base en el atributo actualizado
     */
    public User updateUser(User user) {
        if (user.getId() != null) {
            Optional<User> useraux = userRepository.getUser(user.getId());
            if (!useraux.isEmpty()) {
                if (user.getIdentification() != null) {
                    useraux.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    useraux.get().setName(user.getName());
                }
                if (user.getAddress() != null) {
                    useraux.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    useraux.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    useraux.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    useraux.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    useraux.get().setZone(user.getZone());
                }

                return userRepository.save(useraux.get());
                //return useraux.get();
            } else {
                return user;
            }
        } else {
            return user;
        }

    }

    /**
     * Método para borrar un usuario
     *
     * @param userId: id del usuario a eliminar
     * @return un booleano de usuario eliminado o no
     */
    public boolean delete(int userId) {
        Boolean aBoolean = getUser(userId).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    /**
     * Método para obtener un usuario cuyo email y password coincidan
     *
     * @param email: correo del usuario
     * @param password: contraseña del usuario
     * @return el usuario cuya combinación de email y password coinciden
     */
    public User autenticarUsuario(String email, String password) {
        Optional<User> usuario = userRepository.autenticarUsuario(email, password);
        if (usuario.isEmpty()) {
            // return new User (email, password, "NO DEFINIDO");
            return new User();
        } else {
            return usuario.get();
        }
    }

}
