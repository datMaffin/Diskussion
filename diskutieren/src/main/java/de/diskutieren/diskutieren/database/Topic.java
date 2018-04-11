package de.diskutieren.diskutieren.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * model for a topic
 * a topic is a container of arguments
 */

@Entity(name = "topics")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int topicID;

    @NotNull
    private String name;
    private LocalDate date_created;

    @NotNull
    private String id;


    public Topic() {
        date_created = LocalDate.now();
    }

    public long getTopicID() {
        return topicID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate_created() {
        return date_created;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
