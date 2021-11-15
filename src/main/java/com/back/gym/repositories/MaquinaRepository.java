package com.back.gym.repositories;

import com.back.gym.models.MaquinaModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaquinaRepository extends MongoRepository<MaquinaModel,String> {
    
}
