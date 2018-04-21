package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public class UserDaoImpl extends AbstractDao<Long, User> {

	@Override
	public User save(User entity) {
		return super.save(entity);
	}

	@Override
	public void saveOrUpdate(User entity) {
		super.saveOrUpdate(entity);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getByKey(long id) {
		return (Map<String, Object>) getCriteria().add(Restrictions.eq("id", id))
				.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getAllUsers() {
		return getCriteria().setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();

	}

	public void removeById(Long id) {
		User user = new User();
		user.setId(id);
		EntityManager em = super.getEntityManager();
		em.remove(em.contains(user) ? user : em.merge(user));

	}

	@SuppressWarnings("unchecked")
	public void removeByUsername(String username) {
		Map<String, Object> user = (Map<String, Object>) getCriteria().add(Restrictions.eq("username", username))
				.setProjection(Projections.property("id")).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP)
				.uniqueResult();

		removeById(Long.parseLong(user.get("id").toString()));
	}

}
