package gr.codelearn.spring.showcase.app.service;

import java.util.List;

public interface BaseService<T, ID> {
	T create(T clazz);

	List<T> createAll(List<T> clazzes);

	List<T> createAll(T... clazzes);

	void update(T clazz);

	void delete(T clazz);

	void deleteById(ID id);

	boolean exists(T clazz);

	T find(ID id);

	List<T> findAll();
}
