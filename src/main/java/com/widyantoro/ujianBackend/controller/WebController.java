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
	@GetMapping("sidebar")
	public String sdbar() {
		return "sidebar";
	}
	@GetMapping("table")
	public String tab() {
		return "Tableform";
	}
	

}
