package guru.springframework.sfgrecipeapp.repositories;

import guru.springframework.sfgrecipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
