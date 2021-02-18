package pl.strzygowska.mymealplanner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.strzygowska.mymealplanner.model.Ingredient;
import pl.strzygowska.mymealplanner.model.IngredientDao;

import java.util.List;

@Service
public class IngredientService {

    @Autowired
    IngredientDao ingredientDao;

    public void save(Ingredient ingredient){
        ingredientDao.save(ingredient);
    }

    public List<Ingredient> findAll(){
        return ingredientDao.findAll();
    }


}
