package pl.strzygowska.mymealplanner.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 2, max = 100, message = "{addIngredients.name.size}")
    @NotBlank(message = "{addIngredients.name.blank}")
    @Column(unique = true)
    private String name;

    @Column(columnDefinition = "integer default 0")
    @Min(value = 0, message = "{addIngredients.calories.min}")
    @Max(value = 10000, message = "{addIngredients.calories.max}")
    private Integer calories;

    @Column(columnDefinition = "integer default 0")
    @Min(value = 0, message = "{addIngredients.gi.min}")
    @Max(value = 200, message = "{addIngredients.gi.max}")
    private Integer gi;

    public Ingredient() {
    }

    public Ingredient(@Size(min = 2, max = 100, message = "{addIngredients.name.size}") @NotBlank(message = "{addIngredients.name.blank}") String name) {
        this.name = name;
    }

    public Ingredient(@Size(min = 2, max = 100, message = "{addIngredients.name.size}") @NotBlank(message = "{addIngredients.name.blank}") String name, Integer calories, Integer gi) {
        this.name = name;
        this.calories = calories;
        this.gi = gi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Integer getGi() {
        return gi;
    }

    public void setGi(Integer gi) {
        this.gi = gi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return id.equals(that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(calories, that.calories) &&
                Objects.equals(gi, that.gi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, calories, gi);
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", calories=" + calories +
                ", gi=" + gi +
                '}';
    }
}
