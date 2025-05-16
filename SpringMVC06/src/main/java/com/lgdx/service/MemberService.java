package com.lgdx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lgdx.entity.Member;
import com.lgdx.repository.MemberRepository;

@Service
public class MemberService {
 
 @Autowired
 MemberRepository repository;

 public void join(Member vo) {
  repository.save(vo);
 }

 public Member login(Member vo) {
  String id = vo.getId();
  String pw = vo.getPw();
  
  return repository.findByIdAndPw(id, pw);
  
 }

//	public List<Member> MemberList(){
//		return repository.findAll();
//	}
//	
//	public Member memberList(String id) {
//		Optional<Member> vo = repository.findById(id);
//		return vo.get();
//	}
//	
//	public void memberInsert(Member vo) {
//		repository.save(vo);
//	}
//	
//	public void memberDelete(String id) {
//		repository.deleteById(id);
//	}
//	
//	public void memberUpdate(Member vo) {
//		repository.save(vo);
//	}
}
