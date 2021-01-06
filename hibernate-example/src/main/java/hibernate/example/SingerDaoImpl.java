package hibernate.example;

import hibernate.example.entities.Singer;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Repository("singerDao")
public class SingerDaoImpl implements SingerDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Singer> findAll() {
		return sessionFactory.getCurrentSession()
			.createQuery("from Singer s")
			.list();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Singer> findAllWithAlbum() {
		return sessionFactory.getCurrentSession()
			.getNamedQuery("Singer.findAllWithAlbum")
			.list();
	}

	@Override
	@Transactional(readOnly = true)
	public Singer findById(Long id) {
		return (Singer)sessionFactory.getCurrentSession()
			.getNamedQuery("Singer.findById")
			.setParameter("id", id)
			.uniqueResult();
	}

	@Override
	public Singer save(Singer singer) {
		sessionFactory.getCurrentSession().saveOrUpdate(singer);
		return singer;
	}

	@Override
	public void delete(Singer singer) {
		sessionFactory.getCurrentSession()
			.delete(singer);
	}
}
