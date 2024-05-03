package org.hikuro.hikucraft.repository;

public interface Repository<T, ID> {

	T getById(ID id) throws Exception;

	void save(T entity) throws Exception;

	void update(T entity) throws Exception;

	void delete(ID id) throws Exception;

	default boolean exists(ID id) {
		try {
			this.getById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
