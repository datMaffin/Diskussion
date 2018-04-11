package de.diskutieren.diskutieren.startPage;

import de.diskutieren.diskutieren.builder.DiscussionBuilder;
import de.diskutieren.diskutieren.database.Discussion;
import de.diskutieren.diskutieren.database.Topic;
import de.diskutieren.diskutieren.database.TopicRepository;
import de.diskutieren.diskutieren.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StartPageController implements IStartPageController {

    @Autowired
    private DataService dataService;
    @Autowired
    private TopicRepository topicRepository;


    @GetMapping("/")
    public String prepare(ModelMap model) {
        model.addAttribute("build", new DiscussionBuilder());
        return "home";
    }

    @PostMapping(value = "/")
    public String createDiscussion(@ModelAttribute("build") DiscussionBuilder discussionBuilder, ModelMap model,
                                   @RequestParam(value = "action", required = true) String action) {
        if (action.equals("Start")) {

            discussionBuilder.moveNewTopicToOthers();
            Discussion d = discussionBuilder.saveDiscussion();

            dataService.saveDiscussion(d);

            if (!d.getName().isEmpty()) {
                if (d.getTopics().size() > 1) {
                    model.addAttribute("discussion", d);
                    return "redirect:/d/" + d.getId();
                } else {
                    model.addAttribute("topic", d.getTopics().get(0));
                    return "redirect:/d/" + d.getId() + "/" + d.getTopics().get(0).getTopicID();
                }
            }

        } else if (action.equals("[more topics]")) {
            discussionBuilder.moveNewTopicToOthers();
            model.addAttribute("build", discussionBuilder);
            return "home";
        }

        model.addAttribute("build", new DiscussionBuilder());
        return "home";
    }


    @Override
    public void saveDiscussion(Discussion discussion) {
        dataService.saveDiscussion(discussion);
    }

    /**
     * creats new topics by given topic names
     *
     * @param topicNames
     */
    @Override
    public void saveTopicsByTitle(List<String> topicNames) {
        topicNames.forEach(topicName -> {
            Topic topic = new Topic();
            topic.setName(topicName);

            topicRepository.save(topic);
        });
    }
}
