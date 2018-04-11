package de.diskutieren.diskutieren.startPage;

import de.diskutieren.diskutieren.database.Discussion;

import java.util.List;

/**
 * Interface for the Startpage
 * create Discussion
 * create Topics
 */
public interface IStartPageController {

    /**
     * saves a new Discussion
     * @param discussion
     */
    public void saveDiscussion(Discussion discussion);

    /**
     * creats new topics by given topic names
     * @param topicNames
     */
    public void saveTopicsByTitle(List<String> topicNames);
}
