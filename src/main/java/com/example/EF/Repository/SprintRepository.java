package com.example.EF.Repository;

import com.example.EF.Domain.Sprint;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface SprintRepository extends MongoRepository<Sprint, String>{
    
}
