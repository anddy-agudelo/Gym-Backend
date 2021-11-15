package com.back.gym.repositories;

import com.back.gym.models.SedesModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SedesRepository extends MongoRepository<SedesModel,String> {
    
}
