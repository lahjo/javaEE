package fi.jamk.henkilorekisteri;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ApiController {

	private static final Logger logger = LoggerFactory.getLogger(ApiController.class);
	
	@Inject
	private henkiloDAO personDao;
	
	@RequestMapping(value = "api/", method = RequestMethod.GET)
	public String home(Model model) {
		
		logger.info("API Controller!.");
		
		return "home";
	}
}
