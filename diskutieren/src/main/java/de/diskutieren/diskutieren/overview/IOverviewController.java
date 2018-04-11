package de.diskutieren.diskutieren.overview;

import de.diskutieren.diskutieren.database.Discussion;
import de.diskutieren.diskutieren.database.Topic;

import java.util.List;

public interface IOverviewController {

    /**
     * loads the discussion
     * @param id disussionId
     * @return Disussion
     */
    public Discussion loadDiscussion(String id);

    /**
     * load all Topics by discussion ID
     * @param ID
     * @return
     */
    List<Topic> loadTopicsByID(String ID);
}
