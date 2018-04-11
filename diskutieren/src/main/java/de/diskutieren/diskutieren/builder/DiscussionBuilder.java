package de.diskutieren.diskutieren.builder;

import de.diskutieren.diskutieren.database.Discussion;
import de.diskutieren.diskutieren.database.Topic;

import java.util.ArrayList;
import java.util.List;


public class DiscussionBuilder {

    private List<String> topics = new ArrayList<>(10);

    private String newTopic = "";
    private String newDiscussion = "";


    public String getNewTopic() {
        return newTopic;
    }

    public void setNewTopic(String newTopic) {
        this.newTopic = newTopic;
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    public String getNewDiscussion() {
        return newDiscussion;
    }

    public void setNewDiscussion(String newDiscussion) {
        this.newDiscussion = newDiscussion;
    }

    /**
     * adds the title of the new topic to the list
     * list will be saved @see saveDiscussion
     */
    public void moveNewTopicToOthers() {
        this.topics.add(newTopic);
        this.newTopic = "";
    }

    /**
     * saves whole discussion with topics
     *
     * @return
     */
    public Discussion saveDiscussion() {
        Discussion discussion = new Discussion();
        discussion.setName(this.newDiscussion);

        moveNewTopicToOthers();

        for (String name : topics) {
            if(name.isEmpty()) continue;
            Topic topic = new Topic();
            topic.setName(name);
            topic.setId(discussion.getId());

            discussion.addTopic(topic);
        }

        return discussion;
    }
}
