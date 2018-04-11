package de.diskutieren.diskutieren.overview;

import de.diskutieren.diskutieren.database.Discussion;
import de.diskutieren.diskutieren.database.Topic;
import de.diskutieren.diskutieren.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

/**
 * Controller for Overview
 * will be directed from startPage
 */
@Controller
public class OverviewController implements IOverviewController {

    @Autowired
    private DataService dataService;

    @GetMapping("/d/{id}")
    public String showTopics(@PathVariable String id, Model model) {

        Discussion discussion = loadDiscussion(id);
        discussion.setTopics(loadTopicsByID(id));
        model.addAttribute("discussion", discussion);

        return "overview";

    }

    @Override
    public Discussion loadDiscussion(String id) {
        return dataService.loadDiscussion(id);
    }

    @Override
    public ArrayList<Topic> loadTopicsByID(String id) {
        return dataService.loadTopics(id);
    }

}
