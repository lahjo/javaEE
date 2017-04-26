package fi.jamk.henkilorekisteri;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private henkiloDAO personDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("requesting path: /, user location: ", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		
		List<henkilo> henkiloLista = personDao.getAll();
		model.addAttribute("henkiloListaus", henkiloLista);
		
		return "home";
	}
	
	@RequestMapping(value="/{name}", method=RequestMethod.GET)
	public String getView(@PathVariable String name, Model model) {
		List<henkilo> henkiloLista = personDao.getByName(name);
		
		System.out.println(name);
		
		model.addAttribute("henkiloListaus", henkiloLista);
		
		return "home";
	}
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public String filterHome(henkilo person, @RequestParam String name, Locale locale) {
		logger.info("requesting path: /{Name}, user location: ", locale);
		
		person.setEtunimi(name);
		
		return "redirect:/" + person.getEtunimi();
	}
	
	@RequestMapping(value="/{name}", method = RequestMethod.POST)
	public String secondfilterHome(henkilo person, @RequestParam String name, Locale locale) {
		logger.info("requesting path: /{Name}, user location: ", locale);
		
		person.setEtunimi(name);
		
		return "redirect:/" + person.getEtunimi();
	}
}
