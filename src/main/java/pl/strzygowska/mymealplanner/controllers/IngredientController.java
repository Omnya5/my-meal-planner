package pl.strzygowska.mymealplanner.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.strzygowska.mymealplanner.model.Ingredient;
import pl.strzygowska.mymealplanner.service.IngredientService;

import javax.validation.Valid;

@Controller
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    private static Logger logger = LoggerFactory.getLogger(PageController.class);

    @RequestMapping(value="/addIngredients", method = RequestMethod.GET)
    ModelAndView addIngredients(ModelAndView modelAndView) {
        modelAndView.setViewName("app.addIngredients");
        Ingredient ingredient = new Ingredient();
        modelAndView.getModel().put("ingredient", ingredient);
        return modelAndView;
    }

    @RequestMapping(value="/addIngredients", method = RequestMethod.POST)
    ModelAndView addIngredients(ModelAndView modelAndView, @Valid Ingredient ingredient, BindingResult bindingResult) {
        modelAndView.setViewName("app.addIngredients");
        if(!bindingResult.hasErrors()){
            ingredientService.save(ingredient);
            modelAndView.getModel().put("ingredient", new Ingredient());
        }
        return modelAndView;
    }

    @RequestMapping(value="/", method = RequestMethod.GET)
    ModelAndView home(ModelAndView modelAndView) {
        modelAndView.setViewName("app.homepage");

        modelAndView.getModel().put("ingredientsList", ingredientService.findAll());
        return modelAndView;
    }

}
