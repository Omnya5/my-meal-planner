package pl.strzygowska.mymealplanner.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.strzygowska.mymealplanner.model.Note;
import pl.strzygowska.mymealplanner.service.NoteService;

import javax.validation.Valid;

@Controller
public class NoteController {

    @Autowired
    private NoteService noteService;

    private static Logger logger = LoggerFactory.getLogger(PageController.class);

    @RequestMapping(value = "/viewNotes", method = RequestMethod.GET)
    ModelAndView viewNotes(ModelAndView modelAndView, @RequestParam(name="p", defaultValue = "1") Integer pageNumber) {
        modelAndView.setViewName("app.viewNotes");
        Page<Note> page = noteService.getPage(pageNumber);
        modelAndView.getModel().put("page", page);
        return modelAndView;
    }

    @RequestMapping(value = "/addNote", method = RequestMethod.GET)
    ModelAndView addNote(ModelAndView modelAndView, @ModelAttribute("note") Note note) {
        modelAndView.setViewName("app.addNote");
        getAndPassLatestNote(modelAndView);
        return modelAndView;
    }

    @RequestMapping(value = "/addNote", method = RequestMethod.POST)
    ModelAndView addNote(ModelAndView modelAndView, @Valid @ModelAttribute("note") Note note, BindingResult bindingResult) {
        modelAndView.setViewName("app.addNote");
        if(!bindingResult.hasErrors()) {
            noteService.save(note);
            modelAndView.getModel().put("note", new Note());
        }
        getAndPassLatestNote(modelAndView);
        logger.info("**************************Result:   " + bindingResult.toString());
        return modelAndView;
    }

    private void getAndPassLatestNote(ModelAndView modelAndView){
        Note latestNote = noteService.getLatest();
        modelAndView.getModel().put("latestNote", latestNote);
    }
}
