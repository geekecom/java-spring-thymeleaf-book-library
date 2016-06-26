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

import library.model.Member;

@Service
@Repository
@Transactional
public class MemberDAO {

	private static final Logger logger = LoggerFactory.getLogger(MemberDAO.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void addMember(Member member) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(member);
		logger.info("Member saved successfully, Member Details=" + member);
	}

	public void updateMember(Member member) {
		Session session = this.sessionFactory.getCurrentSession();
			session.update(member);
		logger.info("Member updated successfully, Member Details=" + member);
	}

	@SuppressWarnings("unchecked")
	public List<Member> listMember() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Member> memberList = session.createQuery("from Member").list();
		for (Member member : memberList) {
			logger.info("Member List::" + member);
		}
		return memberList;
	}

	public Member getMemberById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Member member = (Member) session.load(Member.class, new Integer(id));
		logger.info("Member loaded successfully, Member details=" + member);
		return member;
	}

	public void removeMember(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Member member = (Member) session.load(Member.class, new Integer(id));
		if (null != member) {
			session.delete(member);
			logger.info("Member deleted successfully, Member details=" + member);
		}
		logger.info("[ERROR] Member undeleted successfully, Member details=" + member);
	}

}
