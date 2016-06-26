package library.controller;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import library.dao.LoanDAO;
import library.dao.MemberDAO;
import library.model.Book;
import library.model.Loan;
import library.model.Member;

@Controller
public class LoanController {

	private static final Logger logger = LoggerFactory.getLogger(LoanController.class);

	@ModelAttribute("loan")
	public Loan getLoanObject() {
		return new Loan();
	}

	@Autowired
	private LoanDAO loanDAO;

	@Autowired
	private MemberDAO memberDAO;

	private Loan loan;

	@RequestMapping(value = "/loan")
	public String listLoan(Map<String, Object> model) {
		// model.put("loan", new Loan());
		model.put("loanList", this.loanDAO.listLoan());
		return "loan";
	}

	// For add and update loan both
	@RequestMapping(value = "/loan/add/{id_book}")
	public String addLoanSelectMember(@PathVariable("id_book") Integer id_book, Model model) {
		List<Member> memberList = this.memberDAO.listMember();
		this.loan = new Loan();
		this.loan.setId_book(id_book);
		model.addAttribute("memberList", memberList);
		return "loan-select-member";
	}

	@RequestMapping(value = "/loan/add/finish/{id_member}")
	public String addLoanSelectMember(@PathVariable("id_member") Integer id_member) {
		Calendar calendar = Calendar.getInstance();
		Date start_date = new Date(calendar.getTimeInMillis());
		calendar.add(Calendar.DAY_OF_MONTH, 14);
		Date finish_date = new Date(calendar.getTimeInMillis());

		loan.setId_member(id_member);
		loan.setStart_date(start_date);
		loan.setFinish_date(finish_date);
		loanDAO.addLoan(loan);
		return "redirect:/book";
	}

	@RequestMapping("loan/remove/{id_loan}")
	public String removeLoan(@PathVariable("id_loan") int id_loan) {

		this.loanDAO.removeLoan(id_loan);
		return "redirect:/loan";
	}

	@RequestMapping("loan/edit/{id_loan}")
	public String editLoan(@PathVariable("id_loan") Integer id_loan, Model model) {
		Loan loan = loanDAO.getLoanById(id_loan);
		model.addAttribute("loan", loan);
		return "loan-edit";
	}

	@RequestMapping("loan/edit")
	public String editLoan(@Valid Loan loan, Model model) {
		loanDAO.updateLoan(loan);
		return "redirect:/loan";
	}

	@RequestMapping("loan/return/{id_loan}")
	public String returnLoan(@PathVariable("id_loan") Integer id_loan, Model model) {
		Calendar calendar = Calendar.getInstance();
		Date return_date = new Date(calendar.getTimeInMillis());
		this.loan = loanDAO.getLoanById(id_loan);
		this.loan.setReturn_date(return_date);
		loanDAO.updateLoan(this.loan);
		return "redirect:/loan";
	}

}