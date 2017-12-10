package kr.ac.hansung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class LoginController {

	@RequestMapping("/login")
	public String shwLogin( @RequestParam(value="error", required=false) String error, 
			@RequestParam(value="logout", required=false) String logout, Model model) {
		if(error!=null) {
			model.addAttribute("errorMsg", "이름과 패스워드를 확인하십시오.");
		}

		if(logout !=null) {
			model.addAttribute("logoutMsg", "로그아웃 되었습니다.");
		}
		return "login";
	}

}