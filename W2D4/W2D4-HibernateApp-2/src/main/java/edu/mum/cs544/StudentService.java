package edu.mum.cs544;

public class StudentService {
	private StudentDAO studentdao;

	public StudentService() {
		studentdao = new StudentDAO();
	}

	public Student getStudent(long studentid) {
		EntityManagerHelper.getCurrent().getTransaction().begin();
		try {
			return studentdao.load(studentid);
		} finally {
			EntityManagerHelper.getCurrent().getTransaction().commit();
			EntityManagerHelper.getCurrent().close();
		}
	}
}
