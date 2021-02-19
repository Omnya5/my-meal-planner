package pl.strzygowska.mymealplanner.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.strzygowska.mymealplanner.service.NoteService;

@Controller
public class PageController {

    @Autowired
    private NoteService noteService;

    private static Logger logger = LoggerFactory.getLogger(PageController.class);

    @RequestMapping("/about")
    String about() {
        return "app.about";
    }

    @RequestMapping("/countCalories")
    String countCalories() {
        return "app.countCalories";
    }
}
