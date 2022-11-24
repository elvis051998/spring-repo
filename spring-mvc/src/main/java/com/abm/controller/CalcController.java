package com.abm.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalcController {

	@RequestMapping(value="/result", method = RequestMethod.POST)
	public String calculate(@RequestParam("no1") int no1, @RequestParam("no2") int no2,
			Map<String, Object> model) {
		int result = no1 + no2;
		model.put("answer", result);
		model.put("no1", no1);
		model.put("no2", no2);
		return "calC.jsp";
	}
}
