/**
 * 
 */
package fr.epita.srikanth.services;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import fr.epita.srikanth.datamodel.Identity;
import fr.epita.srikanth.services.HibernateAddressDAO.Dao;

/**
 * @author srikanth
 *
 */

@Repository
public class IdentityDAO implements DAO<Identity>{
	
	@Inject
	SessionFactory sf;
	
	
	
	public void write(Identity identity){
		Session session = sf.openSession1();
		Transaction transaction = session.beginTransaction();
		session.save(identity);
		transaction.commit();
		session.close();
	}
	
	public void update(Identity identity){
		Session session = sf.openSession1();
		Transaction transaction = session.beginTransaction();
		session.update(identity);
		transaction.commit();
		session.close();
	}
	 
	public void delete(Identity identity){
		
		Session session = sf.openSession1();
		Transaction transaction = session.beginTransaction();
		session.delete(identity);
		transaction.commit();
		session.close();
	}
	
	public List<Identity> search(Identity identity){
		Session session = sf.openSession1();

		String queryString = "from Identity as identity where identity.displayName like :displayName";
		Query query = session.createQuery(queryString);
		query.setParameter("displayName", "%" + identity.getDisplayName()+"%");
		List<Identity> identityList = query.list();
		session.close();
		return identityList;
	}

}
