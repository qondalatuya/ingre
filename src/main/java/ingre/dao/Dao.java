package ingre.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ingre.util.HibernateUtil;

public class Dao<T,K extends Serializable>{
	
	SessionFactory factory = HibernateUtil.getSessionFactory();
	
	private Class<T> clazz;

    protected Dao(Class<T> clazz) {
        this.clazz = clazz;
    }
    	
	public void save(T t){
		Session session = factory.getCurrentSession();
		Transaction tx =session.beginTransaction();
		try{
			session.save(t);
			tx.commit();
		}catch (HibernateException e) {
			tx.rollback();
		}
	}
	
	public T getById( K id){
		
		Session session = factory.getCurrentSession();
		Transaction tx =session.beginTransaction();
		T t = null;
		try{
			t = (T) session.get( clazz , id);
			tx.commit();
		} catch (HibernateException e){
			tx.rollback();
		}
		return t;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getAll(){
		Session session = factory.getCurrentSession();
		Transaction tx =session.beginTransaction();
		List<T> lista = null;
		try{
			lista = session.createQuery("from " + clazz.getName()).getResultList();
			tx.commit();
		} catch (HibernateException e){
			tx.rollback();
		}
		return lista;
		
	}
	
	public void update(T t){
		Session session = factory.getCurrentSession();
		Transaction tx =session.beginTransaction();
		try{
			session.update(t);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
		}
	}
	
	public void delete (T t){
		Session session = factory.getCurrentSession();
		Transaction tx =session.beginTransaction();
		try {
			session.delete(t);
			tx.commit();
		} catch (HibernateException e){
			tx.rollback();
		}
	}
	
		
}
