package ingre.dao;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import ingre.model.AnEntity;

@Repository
public class SpringDao extends HibernateDaoSupport {
	
	public AnEntity getById(int id){
		return getHibernateTemplate().get(AnEntity.class, id);
	}
	
	public void save(AnEntity ent){
		getHibernateTemplate().save(ent);
	}
}
