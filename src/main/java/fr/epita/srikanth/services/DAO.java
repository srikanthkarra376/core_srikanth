package fr.epita.srikanth.services;

import java.util.List;

/**
 * @author srikanth
 *
 */
public interface DAO<T> {
	
	public void write(T instance);
	public void delete(T instance);
	public void update(T instance);
	public List<T> search(T instance);

}
