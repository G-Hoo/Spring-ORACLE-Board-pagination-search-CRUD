package com.board.web.controller;

import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.board.web.composite.Complex;

@SessionAttributes("context")
@Controller

public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model,HttpSession session) {
		logger.info("HomeController - home() {}","Enter");
		
		session.setAttribute("context",Complex.ContextFactory.create());
		logger.info("===context===  : {}",Complex.ContextFactory.create());
		return "home";
	}
}
