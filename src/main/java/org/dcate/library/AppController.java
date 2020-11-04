package org.dcate.library;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AppController {
	
	@RequestMapping({"/"})
	public String loadUI() {
		log.info("#loadUI - loading UI");
		return "forward:/index.html";
	}

}
