package library.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations Hibernate provid_loanes JPA implementation
 * 
 * @author Lorenzo Lerate
 *
 */
@Entity
@Table(name = "loan")
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_loan;

	private Integer id_book;
	private Integer id_member;
	private Date start_date;
	private Date finish_date;
	private Date return_date;

	public Loan() {
	}

	public int getId_loan() {
		return id_loan;
	}

	public void setId_loan(int id_loan) {
		this.id_loan = id_loan;
	}

	public Integer getId_book() {
		return id_book;
	}

	public void setId_book(Integer id_book) {
		this.id_book = id_book;
	}

	public Integer getId_member() {
		return id_member;
	}

	public void setId_member(Integer id_member) {
		this.id_member = id_member;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getFinish_date() {
		return finish_date;
	}

	public void setFinish_date(Date finish_date) {
		this.finish_date = finish_date;
	}

	public Date getReturn_date() {
		return return_date;
	}

	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}

	@Override
	public String toString() {
		return "Loan [id_loan=" + id_loan + ", id_book=" + id_book + ", id_member=" + id_member + ", start_date="
				+ start_date + ", finish_date=" + finish_date + ", return_date=" + return_date + "]";
	}
	
}