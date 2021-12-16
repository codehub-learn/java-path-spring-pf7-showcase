package gr.codelearn.spring.showcase.app.service;

import gr.codelearn.spring.showcase.app.base.AbstractLogComponent;
import gr.codelearn.spring.showcase.app.domain.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class BaseServiceImpl<T extends BaseModel> extends AbstractLogComponent
		implements BaseService<T, Long> {
	abstract JpaRepository<T, Long> getRepository();

	@Override
	public T create(final T entity) {
		logger.trace("Creating {}.", entity);
		return getRepository().save(entity);
	}

	@Override
	public List<T> createAll(T... entities) {
		return createAll(Arrays.asList(entities));
	}

	@Override
	public List<T> createAll(final List<T> entities) {
		logger.debug("Creating {} objects.", entities.size());
		return getRepository().saveAll(entities);
	}

	@Override
	public void update(final T entity) {
		logger.trace("Updating {}.", entity);
		getRepository().save(entity);
	}

	@Override
	public void delete(final T clazz) {
		logger.trace("Deleting {}.", clazz);
		getRepository().delete(clazz);
	}

	@Override
	public void deleteById(final Long id) {
		logger.trace("Deleting entity with id {}.", id);
		getRepository().deleteById(id);
	}

	@Override
	public boolean exists(final T entity) {
		logger.trace("Checking whether {} exists.", entity);
		return getRepository().existsById(entity.getId());
	}

	@Override
	public List<T> findAll() {
		logger.trace("Retrieving all data.");
		return getRepository().findAll();
	}

	@Override
	public T find(Long id) {
		/*
		 * T findById(ID id) (name in the old API) / Optional<T> findById(ID id) (name in the new API) relies on
		 * EntityManager.find() that performs an entity eager loading.
		 *
		 * T getById(ID id) relies on EntityManager.getReference() that performs an entity lazy loading. So to ensure
		 * the effective loading of the entity, invoking a method on it is required.
		 */
		logger.debug("Find object with id {}.", id);
		return getRepository().findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public T get(Long id) {
		/*
		 * T findById(ID id) (name in the old API) / Optional<T> findById(ID id) (name in the new API) relies on
		 * EntityManager.find() that performs an entity eager loading.
		 *
		 * T getById(ID id) relies on EntityManager.getReference() that performs an entity lazy loading. So to ensure
		 * the effective loading of the entity, invoking a method on it is required.
		 */
		logger.debug("Get object with id {}.", id);
		return getRepository().getById(id);
	}
}
