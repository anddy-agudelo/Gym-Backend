package com.back.gym.repositories;

import com.back.gym.models.SuscripcionModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuscripcionRepository extends MongoRepository<SuscripcionModel,String> {
    
}
