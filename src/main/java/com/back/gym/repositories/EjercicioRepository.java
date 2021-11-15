package com.back.gym.repositories;

import com.back.gym.models.EjercicioModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EjercicioRepository extends MongoRepository<EjercicioModel,String>{
    
}
