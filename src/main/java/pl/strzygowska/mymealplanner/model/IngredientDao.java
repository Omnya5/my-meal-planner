package pl.strzygowska.mymealplanner.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientDao extends JpaRepository<Ingredient, Long> {
}
