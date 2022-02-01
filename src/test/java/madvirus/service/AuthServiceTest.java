package madvirus.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import config.RootConfig;
import config.ServletConfig;
import madvirus.exception.MemberNotFoundException;
import madvirus.exception.WrongIdPasswordException;
import madvirus.model.auth.AuthInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class})
@WebAppConfiguration
public class AuthServiceTest {
	
	@Autowired
	private AuthService authService; 

	@Test(expected = MemberNotFoundException.class)
	public void authenticateMemberNotFoundExceptionTest() {
		authService.authenticate("lee222222@naver.com", "1234");
	}
	
	@Test(expected = WrongIdPasswordException.class)
	public void authenticateWrongIdPasswordExceptionTest() {
		authService.authenticate("lee2@naver.com", "1111");
	}
	
	@Test
	public void authenticateTest() {
		AuthInfo authInfo = authService.authenticate("lee@naver.com", "1234");
		assertEquals("이광협", authInfo.getName());
	}

}
