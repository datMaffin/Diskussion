package de.diskutieren.diskutieren.services;

import de.diskutieren.diskutieren.database.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Load and save to/from database
 */
@Service
public class DataService {

    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private DiscussionRepository discussionRepository;
    @Autowired
    private ArgumentRepository argumentRepository;

    /**
     * @param discussion    the discussion object in question
     */
    public void saveDiscussion(Discussion discussion) {
        discussionRepository.save(discussion);

        for (Topic topic : discussion.getTopics()) {
            if (!topic.getName().isEmpty()) {
                topicRepository.save(topic);
            }
        }

    }

    public void saveArgument(Argument argument) {
        argumentRepository.save(argument);
    }

    /**
     * loads the discussion by ID
     */
    public Discussion loadDiscussion(String id) {
        return discussionRepository.findByid(id);
    }

    /**
     * loads Topics by Discussion ID
     * using TopicRepository
     *
     * @param id DiscussionID
     * @return List<Topic>
     */
    public ArrayList<Topic> loadTopics(String id) {
        return StreamSupport.stream(topicRepository.findAll().spliterator(), false)
                .filter(t -> t.getId().equals(id))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public Topic topicFromId(int topicID) {
        return topicRepository.findById(topicID)
                .orElse(null);
    }

    public ArrayList<Argument> loadArguments() {
        return (ArrayList<Argument>) argumentRepository.findAll();
    }

    public void voteForArgument(int argumentID) {
        // TODO: does not work
        argumentRepository.findById(argumentID)
                .ifPresent(Argument::voteUp);
    }
}
