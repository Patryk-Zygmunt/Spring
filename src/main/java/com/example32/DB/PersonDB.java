package com.example32.DB;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

/**
 * Created by Linus on 08.04.2017.
 */

@Repository
public interface PersonDB extends JpaRepository<Person, Long> {

  // public Person findByName(String Name);
    @Query(value = "select p from Person p where p.Name like %?1")
    Person findByName(String name);


}

