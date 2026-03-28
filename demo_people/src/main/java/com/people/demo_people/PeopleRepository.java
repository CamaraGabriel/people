package com.people.demo_people;
//import com.people.demo_people.*;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PeopleRepository extends JpaRepository<PeopleModel, Long>{
    
}


