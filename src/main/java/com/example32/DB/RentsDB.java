package com.example32.DB;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Linus on 14.05.2017.
 */
@Repository
public interface RentsDB extends JpaRepository<Rents, Long> {

    // public Person findByName(String Name);
 /*   @Query(value = "select p from Person p where p.Name like %?1")
    Person findByName(String name);
*/

}

