package madvirus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import madvirus.dao.MemberDao;
import madvirus.exception.MemberNotFoundException;
import madvirus.exception.WrongIdPasswordException;
import madvirus.model.Member;
import madvirus.model.auth.AuthInfo;

@Service
public class AuthService {
	
	private MemberDao memberDao;

	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	} 
	
	public AuthInfo authenticate(String email, String password) {
		//회원조회 
		Member member = memberDao.selectByEmail(email);
		// 없으면 예외발생
		if(member == null) throw new MemberNotFoundException("회원정보가 없습니다. : " + email);
		// 비밀번호 매칭 검사 - 틀리면 예외발생
		if(!member.matchPassword(password)) throw new WrongIdPasswordException();
		// 권한정보 생성 후 리턴 
		return new AuthInfo(member.getId(), member.getEmail(), member.getName()); 
	}
	
	
	
}
