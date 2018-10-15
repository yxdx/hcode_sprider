package tw.proj.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tw.proj.dao.BlogDao;
import tw.proj.entity.Blog;

import javax.annotation.Resource;

/**
 * @author MY
 */
@Repository("blogDao")
@Transactional(propagation= Propagation.REQUIRED,rollbackForClassName="Exception")
public class BlogDaoImpl implements BlogDao {
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public void add(Blog blog) {
		sessionFactory.getCurrentSession().saveOrUpdate(blog);
	}
}
