package com.jszbtb.ContentManagement.shrioController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("toPage")
public class JumpPage {
	
	@RequestMapping("{page}")
	public String jumpPage(@PathVariable("page") String toPage){
		return toPage;
	}
}
