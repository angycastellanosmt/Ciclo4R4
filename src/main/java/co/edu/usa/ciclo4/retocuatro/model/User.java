/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.ciclo4.retocuatro.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author angycastel
 */
@Document(collection = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor


public class User {
    @Id

private Integer id;

private String identification;

private String name;

private Date birthtDay;

private String monthBirthtDay;

private String address;

private String cellPhone;

private String email;

private String password;

private String zone;

private String type;

}

