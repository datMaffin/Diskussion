package de.diskutieren.diskutieren.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * model for an argument
 */

@Entity(name = "arguments")
public class Argument {

    /*controller sets the id */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int argumentID;

    int topicID;

    private String thesis;
    private String example;
    private String reason;

    private int upvotes = 0;

    /**
     * if argument is a pro-topic argument
     */
    private boolean isPro;

    private LocalDate dateCreated;

    public Argument() {
        this.dateCreated = LocalDate.now();
    }

    public String getThesis() {
        return thesis;
    }

    public void setThesis(String thesis) {
        this.thesis = thesis;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(int upvotes) {
        this.upvotes = upvotes;
    }

    public boolean isPro() {
        return isPro;
    }

    public void setIsPro(boolean is_pro) {
        this.isPro = is_pro;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Integer getArgumentID() {
        return argumentID;
    }

    public void setArgumentID(int argumentID) {
        this.argumentID = argumentID;
    }

    public int getTopicID() {
        return topicID;
    }

    public void setTopicID(int topicID) {
        this.topicID = topicID;
    }

    public void voteUp() {
        this.upvotes++;
    }
}

