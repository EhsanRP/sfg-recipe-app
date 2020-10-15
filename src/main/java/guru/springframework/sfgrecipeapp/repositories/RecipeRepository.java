package guru.springframework.sfgrecipeapp.repositories;

import guru.springframework.sfgrecipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
