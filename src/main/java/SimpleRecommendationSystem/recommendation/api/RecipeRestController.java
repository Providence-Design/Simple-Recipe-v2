package SimpleRecommendationSystem.recommendation.api;

import SimpleRecommendationSystem.recommendation.model.Recipe;
import SimpleRecommendationSystem.recommendation.services.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recipe")
public class RecipeRestController {

    @Autowired
    private final RecipeRepository recipeRepository;

    public RecipeRestController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @GetMapping
    public List<Recipe> getRecipe(@RequestParam(required = false) String name, @RequestParam(required = false) String ingredient, @RequestParam(required = false) String instruction) {
        System.out.println("my recipe name:" + name);
        if (name != null) {
            return recipeRepository.getByNameV2(name);
        }

        if (ingredient != null) {
            System.out.println("My recipe name given the ingredient " + " " + ingredient);
            return recipeRepository.getByIngredient(ingredient);
        }

        if (instruction != null) {
            System.out.println("Given instruction name return recipes that have that instruction" + " " + instruction);
            return recipeRepository.getByInstruction(instruction);
        }

        return recipeRepository.getRecipes();
    }
}
