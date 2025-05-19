package com.lgdx.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

        if (info != null) {
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

    // 미사용 멤버 관리 기능은 주석 처리 유지 (필요시 사용 가능)
}
