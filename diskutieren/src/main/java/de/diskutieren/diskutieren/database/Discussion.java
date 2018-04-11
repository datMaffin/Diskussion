package de.diskutieren.diskutieren.database;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * model for a discussion
 * a discussion is a container of topics
 */
@Entity(name = "discussions")
public class Discussion {

    @Id
    private String id;
    private transient ArrayList<Topic> topics = new ArrayList<>();
    @NotNull
    private String name;
    private LocalDate date_created;

    public Discussion() {
        date_created = LocalDate.now();
        id = UUID.randomUUID().toString().replace("-", "");
    }

    public String getId() {
        return id;
    }

    public ArrayList<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics.addAll(topics);
    }

    public void setTopics(ArrayList<Topic> topics) {
        this.topics = topics;
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

    public void addTopic(Topic newTopic) {
        this.topics.add(newTopic);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDate_created(LocalDate date_created) {
        this.date_created = date_created;
    }
}
