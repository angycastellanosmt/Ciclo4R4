/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.usa.ciclo4.retocinco.service;

import co.edu.usa.ciclo4.retocinco.model.Gadget;
import co.edu.usa.ciclo4.retocinco.repository.GadgetRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author angycastel
 */
@Service
public class GadgetService {
    @Autowired
    private GadgetRepository gadgetRepository;
    
    public List<Gadget> getAll(){
    return gadgetRepository.getAll();
}
    
    public Optional<Gadget> getGadget(int id){
        return gadgetRepository.getGadget(id);
    }
    
    public Gadget saveGadget (Gadget gadget){
        if (gadget.getId()==null){
            return gadget;
        }else{
            return gadgetRepository.save(gadget);
        }
    }
    
    public Gadget updateGadget (Gadget gadget){
        
        if (gadget.getId()!= null){
            Optional<Gadget> gadgetaux = gadgetRepository.getGadget(gadget.getId());
            if(gadgetaux.isPresent()){
                if(gadget.getBrand()!=null){
                    gadgetaux.get().setBrand(gadget.getBrand());
                }
                if(gadget.getCategory()!=null){
                    gadgetaux.get().setCategory(gadget.getCategory());
                }
                
                if(gadget.getName()!=null){
                    gadgetaux.get().setName(gadget.getName());
                }
                if(gadget.getDescription()!=null){
                    gadgetaux.get().setDescription(gadget.getDescription());
                }
                if(gadget.getPrice()!=0.0){
                    gadgetaux.get().setPrice(gadget.getPrice());
                }
                if(gadget.getQuantity()!=0){
                    gadgetaux.get().setQuantity(gadget.getQuantity());
                }
                if(gadget.getPhotography()!=null){
                    gadgetaux.get().setPhotography(gadget.getPhotography());
                }
                gadgetaux.get().setAvailability(gadget.isAvailability());
                gadgetRepository.save(gadgetaux.get());
                return gadgetaux.get();
            }else{
                return gadget;
            }
        }else{
            return gadget;
        }
    }
    
    public boolean delete(Integer id){
        Boolean aBoolean = getGadget(id).map(gadget -> {
            gadgetRepository.delete(gadget);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    public List<Gadget> findGadgetByDescrip(String description){
       // return gadgetRepository.findGadgetByDescrip("(?i)"+description);
        return gadgetRepository.findGadgetByDescrip(description);
    }
    
    public List<Gadget>findByPriceLessThanEqual(double price) {
        return gadgetRepository.findByPriceLessThanEqual(price);
    }

   

}

