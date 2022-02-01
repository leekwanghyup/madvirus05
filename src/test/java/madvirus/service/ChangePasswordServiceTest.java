package madvirus.service;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import config.RootConfig;
import config.ServletConfig;
import madvirus.dao.MemberDao;
import madvirus.exception.MemberNotFoundException;
import madvirus.exception.WrongIdPasswordException;
import madvirus.model.Member;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class})
@WebAppConfiguration
public class ChangePasswordServiceTest {

	@Autowired
	private ChangePasswordService service;
	
	@Autowired
	private MemberDao memberDao;
	
	@Test(expected = MemberNotFoundException.class)
	public void changePasswordMemberNotFoundExceptionTest() {
		service.changePassword("lee2222@naver.com", "1234", "4567");
	}
	
	@Test(expected = WrongIdPasswordException.class)
	public void changePasswordWrongIdPasswordExceptionTest() {
		service.changePassword("lee2@naver.com", "1111", "4567");
	}
	
	@Test
	@Ignore
	public void changePasswordTest() {
		service.changePassword("test@naver.com", "test1234", "update1234");
		Member member = memberDao.selectByEmail("test@naver.com");
		assertEquals("update1234", member.getPassword());
	}

}
