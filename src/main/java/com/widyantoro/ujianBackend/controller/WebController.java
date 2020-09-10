package com.widyantoro.ujianBackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/")
public class WebController {
	@GetMapping("form1")
	public String formulir1() {
		return "form1";
	}
	@GetMapping("form2")
	public String formulir2() {
		return "form2";
	}
	@GetMapping("form3")
	public String formulir3() {
		return "form3";
	}
	@GetMapping("home")
	public String sdbar() {
		return "home";
	}
	@GetMapping("login")
	public String tab() {
		return "login";
	}
	

}
