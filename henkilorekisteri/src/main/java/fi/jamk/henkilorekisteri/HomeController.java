package fi.jamk.henkilorekisteri;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import java.util.List;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private henkiloDAO personDao;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		
		List<henkilo> henkiloLista = personDao.getAll();
		
		System.out.println(henkiloLista);
		
		model.addAttribute("henkiloListaus", henkiloLista);
		
		return "home";
	}
	
	@RequestMapping(value="/{name}", method=RequestMethod.GET)
	public String getView(@PathVariable String name, Model model) {
		List<henkilo> henkiloLista = personDao.getByName(name);
		
		System.out.println(name);
		
		System.out.println(henkiloLista);
		
		model.addAttribute("henkiloListaus", henkiloLista);
		
		
		return "home";
	}
	
}
