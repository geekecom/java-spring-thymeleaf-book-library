package library.controller;

import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import library.dao.MemberDAO;
import library.model.Member;

@Controller
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@ModelAttribute("member")
	public Member getMemberObject() {
		return new Member();
	}

	@Autowired
	private MemberDAO memberDAO;

	@RequestMapping(value = "/member")
	public String listMember(Map<String, Object> model) {
		// model.put("member", new Member());
		model.put("memberList", this.memberDAO.listMember());
		return "member";
	}

	// For add and update member both
	@RequestMapping(value = "/member/add")
	public String addMember(@Valid Member member, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			logger.info("[ERROR] Member no valid: " + member.toString());
		} else {
			this.memberDAO.addMember(member);
		}
		return "redirect:/member";
	}

	@RequestMapping("member/remove/{id_member}")
	public String removeMember(@PathVariable("id_member") Integer id_member) {

		this.memberDAO.removeMember(id_member);
		return "redirect:/member";
	}

	@RequestMapping("member/edit/{id_member}")
	public String editMember(@PathVariable("id_member") int id_member, Model model) {
		Member member = memberDAO.getMemberById(id_member);
		model.addAttribute("member", member);
		return "member-edit";
	}
	
	@RequestMapping("member/edit")
	public String editMember(@Valid Member member, Model model) {
		memberDAO.updateMember(member);
		return "redirect:/member";
	}

}