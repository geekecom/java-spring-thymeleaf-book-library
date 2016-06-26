package library.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import library.model.Loan;

@Service
@Repository
@Transactional
public class LoanDAO {

	private static final Logger logger = LoggerFactory.getLogger(LoanDAO.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void addLoan(Loan loan) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(loan);
		logger.info("Loan saved successfully, Loan Details=" + loan);
	}

	public void updateLoan(Loan loan) {
		Session session = this.sessionFactory.getCurrentSession();
			session.update(loan);
		logger.info("Loan updated successfully, Loan Details=" + loan);
	}

	@SuppressWarnings("unchecked")
	public List<Loan> listLoan() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Loan> loanList = session.createQuery("from Loan").list();
		for (Loan loan : loanList) {
			logger.info("Loan List::" + loan);
		}
		return loanList;
	}

	public Loan getLoanById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Loan loan = (Loan) session.load(Loan.class, new Integer(id));
		logger.info("Loan loaded successfully, Loan details=" + loan);
		return loan;
	}

	public void removeLoan(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Loan loan = (Loan) session.load(Loan.class, new Integer(id));
		if (null != loan) {
			session.delete(loan);
			logger.info("Loan deleted successfully, Loan details=" + loan);
		}
		logger.info("[ERROR] Loan undeleted successfully, Loan details=" + loan);
	}

}
