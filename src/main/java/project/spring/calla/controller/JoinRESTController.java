package project.spring.calla.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.spring.calla.service.JoinService;

@RestController
@RequestMapping(value="/member")
public class JoinRESTController {
	private static final Logger logger =
			LoggerFactory.getLogger(JoinRESTController.class);
	
	@Autowired
	private JoinService joinService;
	
	@PostMapping // 1 리턴시 중복확인 성공 @RequestParam("member_Id")을 String id에 넣는 key-value방식인듯
	public int checkId(@RequestParam("memberId") String id) {
		logger.info("checkId호출");
		logger.info(id); // 컨트롤러로 넘어오면서 = 붙음
		try {
			id = URLDecoder.decode(id, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info(id); // JSP에서 입력한 아이디에 " = " 붙어서 콘솔에나옴 그래서 중복체크가 제대로 안됨

		return joinService.checkId(id);
	} // end checkId
		
	
	
	
	
	}
	
	

