package gr.codelearn.spring.showcase.app.service;

import gr.codelearn.spring.showcase.app.base.AbstractLogComponent;
import gr.codelearn.spring.showcase.app.domain.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class BaseServiceImpl<T extends BaseModel> extends AbstractLogComponent
		implements BaseService<T, Long> {
	public abstract JpaRepository<T, Long> getRepository();

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
	public List<T> createAll(final T... clazzes) {
		return createAll(Arrays.asList(clazzes));
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
	public List<T> createAll(final List<T> clazzes) {
		final List<T> updatedEntities = new ArrayList<>();
		for (final T clazz : clazzes) {
			updatedEntities.add(create(clazz));
		}
		return updatedEntities;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
	public T create(final T clazz) {
		logger.trace("Creating {}.", clazz);
		return getRepository().save(clazz);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
	public void update(final T clazz) {
		logger.trace("Updating {}.", clazz);
		getRepository().save(clazz);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
	public void delete(final T clazz) {
		logger.trace("Deleting {}.", clazz);
		getRepository().delete(clazz);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
	public void deleteById(final Long id) {
		final T entityFound = getRepository().getById(id);
		logger.trace("Deleting {}.", entityFound);
		getRepository().deleteById(id);
	}

	@Override
	public boolean exists(final T clazz) {
		logger.trace("Checking whether {} exists.", clazz);
		return getRepository().existsById(clazz.getId());
	}

	@Override
	public List<T> findAll() {
		logger.trace("Retrieving all data.");
		return getRepository().findAll();
	}

	@Override
	public T find(Long id) {
		return getRepository().findById(id).orElseThrow(NoSuchElementException::new);
	}
}
