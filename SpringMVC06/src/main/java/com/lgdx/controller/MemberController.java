package com.lgdx.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lgdx.entity.Member;
import com.lgdx.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("/login.do")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login.do")
	public String login(Member vo, HttpSession session) {
		Member info = service.login(vo);
		System.out.println(info);
		
		if(info!=null) {
			session.setAttribute("info", info);
		}
		return "redirect:/boardList.do";
	}
	
	@GetMapping("/join.do")
	public String join() {
		return "join";
	}
	
	@PostMapping("/join.do")
	public String join(Member vo) {
		service.join(vo);
		return "redirect:/boardList.do";
	}
	
	@GetMapping("/logout.do")
	public String logout(HttpSession session) {
		session.removeAttribute("info");
		session.invalidate();
		return "redirect:/boardList.do";
	}
//	
//	@GetMapping("/memberInsert.do")
//	public String memberInsert() {
//		return "memberInsert";
//	}
//	
//	@PostMapping("/memberInsert.do")
//	public String memberInsert(Member vo) {
//		service.memberInsert(vo);
//		return "redirect:/boardList.do";
//	}
//	
//	@GetMapping("/memberDelete.do")
//	public String memberDelete(@RequestParam("id") String id) {
//		service.memberDelete(id);
//		return "redirect:/boardList.do";
//	}
//	
//	@GetMapping("/memberUpdate.do")
//	public String memberUpdate(@RequestParam("id") String id, Model model) {
//		Member vo = service.memberList(id);
//		model.addAttribute("vo",vo);
//		return "redirect:/boardList.do";
//	}
}
