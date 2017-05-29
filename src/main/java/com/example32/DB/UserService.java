package com.example32.DB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Linus on 06.05.2017.
 */
@Service
public class UserService {
    private final PersonDB personDB;

    @Autowired
    public UserService (PersonDB personDB){this.personDB=personDB;
    }

    public Person getPersonByName(String Name){
       System.out.print(personDB.findByName(Name));
        return personDB.findByName(Name);

    }




}
