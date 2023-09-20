package com.example.EF.Repository;

import com.example.EF.Domain.Sprint;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SprintRepository extends CrudRepository<Sprint, Integer>{
    
}
