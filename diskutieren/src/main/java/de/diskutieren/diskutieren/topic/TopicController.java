package de.diskutieren.diskutieren.topic;

import de.diskutieren.diskutieren.builder.ArgumentBuilder;
import de.diskutieren.diskutieren.database.Argument;
import de.diskutieren.diskutieren.database.TopicRepository;
import de.diskutieren.diskutieren.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private DataService dataService;

    @RequestMapping(value = "/d/{id}/{topicID}")
    public String topic(ModelMap model, @PathVariable String id, @PathVariable String topicID) {
        int tpID = new Integer(topicID);
        ArrayList<Argument> arguments = new ArrayList<>();
        for (Argument a : dataService.loadArguments()) {
            if (a.getTopicID() == tpID) {
                arguments.add(a);
            }
        }

        model.addAttribute("discID", id);
        model.addAttribute("topicID", topicID);
        model.addAttribute("args", arguments);
        model.addAttribute("topic", dataService.topicFromId(tpID));
        return "topic";
    }

    @RequestMapping(value = "/d/{id}/{topicID}/add-argument")
    public String addArgument(@PathVariable String id, @PathVariable String topicID, ModelMap model) {
        model.addAttribute("newArgument", new ArgumentBuilder());
        model.addAttribute("discID", id);
        model.addAttribute("topicID", topicID);
        return "add-argument";
    }

    @PostMapping(value = "/d/{id}/{topicID}/add-argument2")
    public String createArgument(@PathVariable String id, @PathVariable String topicID,
                                 @ModelAttribute(value = "newArgument") ArgumentBuilder builder) {

        Argument argument = new Argument();

        long nextArgumentID = topicRepository.count() + 1;

        if (nextArgumentID > Integer.MAX_VALUE) {
            throw new IndexOutOfBoundsException();
        }

        argument.setArgumentID((int) nextArgumentID);

        argument.setTopicID(Integer.valueOf(topicID));

        argument.setIsPro(builder.getIsPro());
        argument.setExample(builder.getExample());
        argument.setReason(builder.getReason());
        argument.setThesis(builder.getThese());

        dataService.saveArgument(argument);

        return "redirect:/d/" + id + "/" + topicID;
    }

    @RequestMapping(value = "/d/{id}/{topicID}/{argID}/up-vote")
    public String upVote(@PathVariable String id, @PathVariable String topicID, @PathVariable String argID) {
                dataService.voteForArgument(Integer.valueOf(argID));

                return "redirect:/d/"+ id + "/" + topicID;
    }
}
