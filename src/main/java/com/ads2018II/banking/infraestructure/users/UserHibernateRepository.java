package com.ads2018II.banking.infraestructure.users;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ads2018II.banking.domain.entity.users.User;
import com.ads2018II.banking.domain.repository.users.UserRepository;
import com.ads2018II.banking.infraestructure.common.hibernate.BaseHibernateRepository;

@Transactional
@Repository
public class UserHibernateRepository extends BaseHibernateRepository<User> implements UserRepository {
	public User getById(long userId) {
		User user = null;
		Criteria criteria = getSession().createCriteria(User.class, "u");
		criteria.createAlias("u.claims", "c", JoinType.LEFT_OUTER_JOIN);
		criteria.add(Restrictions.eq("u.id", userId));
		user = (User) criteria.uniqueResult();
		return user;
	}
	
	public User getByName(String name) {
		User user = null;
		Criteria criteria = getSession().createCriteria(User.class, "u");
		criteria.createAlias("u.claims", "c");
		criteria.add(Restrictions.eq("u.name", name));
		user = (User) criteria.uniqueResult();
		return user;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getPaginated(int page, int pageSize) {
		List<User> users = null;
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.setFirstResult(page);
		criteria.setMaxResults(pageSize);
		users = criteria.list();
		return users;
	}
	
	public User save(User user) {
		return super.save(user);
	}
}