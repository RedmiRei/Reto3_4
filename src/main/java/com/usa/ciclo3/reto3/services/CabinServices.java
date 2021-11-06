package com.usa.ciclo3.reto3.services;

import com.usa.ciclo3.reto3.model.Cabin;
import com.usa.ciclo3.reto3.repository.CabinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CabinServices {

    @Autowired
    private CabinRepository cabinRepository;

    public List<Cabin> getAll(){

        return cabinRepository.getAll();
    }

    public Optional<Cabin> getCabin(int id) {

        return cabinRepository.getCabin(id);
    }

    public Cabin save(Cabin cabin){
        if(cabin.getId()==null){
            return cabinRepository.save(cabin);
        }else{
            Optional<Cabin> e=cabinRepository.getCabin(cabin.getId());
            if(e.isEmpty()){
                return cabinRepository.save(cabin);
            }else{
                return cabin;
            }
        }
    }

    public Cabin update(Cabin cabin){
        if(cabin.getId()!=null){
            Optional<Cabin> e=cabinRepository.getCabin(cabin.getId());
            if(!e.isEmpty()){
                if(cabin.getName()!=null){
                    e.get().setName(cabin.getName());
                }
                if(cabin.getBrand()!=null){
                    e.get().setBrand(cabin.getBrand()) ;
                }
                if(cabin.getRooms() !=null){
                    e.get().setRooms(cabin.getRooms());
                }
                if(cabin.getDescription()!=null){
                    e.get().setDescription(cabin.getDescription());
                }
                if(cabin.getCategory()!=null){
                    e.get().setCategory(cabin.getCategory());
                }
                cabinRepository.save(e.get());
                return e.get();
            }else{
                return cabin;
            }
        }else{
            return cabin;
        }
    }


    public boolean deleteCabin(int id) {
        Boolean aBoolean = getCabin(id).map(cabin -> {
            cabinRepository.delete(cabin);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}


