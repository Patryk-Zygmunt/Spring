package com.example32.DB;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * Created by Linus on 06.05.2017.
 */
@Entity
public class Rents {
    @GeneratedValue
    @Id
    private long id;

    @Column
    private long carID;

    @Column
    private long personID;

    @Column
    private LocalDateTime time;

    public long getId() {
        return id;
    }

    public long getCarID() {
        return carID;
    }

    public long getPersonID() {
        return personID;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
