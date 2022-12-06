package SimpleRecommendationSystem.recommendation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class RecommendationApplication {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(RecommendationApplication.class, args);
	}

//	@Bean
//	public RecipeService recipeService(){
//		return new RecipeService(new RecipeRepository(new IngredientRepository(new JdbcTemplate()), new InstructionRepository(new JdbcTemplate()), new JdbcTemplate()));
//	}

}
