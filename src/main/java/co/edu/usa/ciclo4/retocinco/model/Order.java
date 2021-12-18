/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.ciclo4.retocinco.model;

import java.util.Date;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author angycastel
 */

@Document(collection = "orders")

@Data

@NoArgsConstructor

@AllArgsConstructor

public class Order {
 
    
public static String PENDING = "Pendiente";

public static String APROVED = "Aprobada";

public static String REJECTED = "Rechazada";

@Id

private Integer id;

private Date registerDay;

private String status;

private User salesMan;

private Map<Integer, Gadget> products;

private Map<Integer, Integer> quantities;

}
