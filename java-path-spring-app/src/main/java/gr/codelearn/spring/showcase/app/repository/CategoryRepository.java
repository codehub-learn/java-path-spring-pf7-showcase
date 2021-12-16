package gr.codelearn.spring.showcase.app.repository;

import gr.codelearn.spring.showcase.app.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	/*
	These methods could be included as normal BookRepository methods, however there is no need, since
	JpaRepository offers them out of the box
		List<Category> findAll();

		Page<Category> findAll(Pageable pageable);

		Optional<Category> findById(Long id);

		Book save(Category category);

		void deleteById(Long id);
    */
	Category findByDescription(String description);
}
