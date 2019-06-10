package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.MANDATORY) 
public class StudentDAO {

	@PersistenceContext
	private EntityManager em;

	public Student load(long studentid) {
//		EntityManager em = EntityManagerHelper.getCurrent();
//		EntityGraph<Student> graph = em.createEntityGraph(Student.class);
//		graph.addAttributeNodes("courselist");
//		Map<String, Object> hints = new HashMap<String, Object>();
//		hints.put("javax.persistence.fetchgraph", graph);
		return em.find(Student.class, studentid);//, hints);
	}
}
