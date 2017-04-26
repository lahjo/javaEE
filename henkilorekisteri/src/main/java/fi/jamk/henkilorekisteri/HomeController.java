package fi.jamk.henkilorekisteri;

import java.util.Locale;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
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
	private sql jdbcMethod = new sql();
	
	@RequestMapping(method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("requesting path: /, user location: ", locale);
		
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
	
	@RequestMapping(value="/lisaaHenkilo", method=RequestMethod.GET)
	public String getNewPerson(Model model, Locale locale) {
		logger.info("requesting path: /lisaaHenkilo, user location: ", locale);
		
		return "lisaaHenkilo";
	}
	
	@RequestMapping(value="muokkaaHenkilo/{ssn}", method=RequestMethod.GET)
	public String getEditPersonView(@PathVariable String ssn, Model model) {
		logger.info("requesting path: /muokkaaHenkilo/{ssn}, user location: ");
		
		List<henkilo> henkiloLista = personDao.getBySnn(ssn);
		
		logger.info(ssn);
		
		model.addAttribute("henkiloListaus", henkiloLista);
		
		return "muokkaaHenkilo";
	}
	
	@RequestMapping(value="poistaHenkilo/{ssn}", method=RequestMethod.GET)
	public String getDeletePerson(@PathVariable String ssn, Model model) {
		logger.info("requesting path: poistaHenkilo/{ssn}, user location: ");
		
		jdbcMethod.delete(ssn);
		
		return "redirect:/";
	}

	@RequestMapping(value="/lisaaHenkilo/", method = RequestMethod.POST)
	public String AddNewPerson(henkilo person, Locale locale,
			@RequestParam MultiValueMap<String, String> params) {
		
		logger.info("requesting path: /lisaaHenkilo, method: POST, user location: ", locale);

		person.setEtunimi(params.get("etunimi").toString().replace("]", "")
				   							   			  .replace("[", ""));
		
		person.setSukunimi(params.get("sukunimi").toString().replace("]", "")
				   								 			.replace("[", ""));
		
		person.setHenkilotunnus(params.get("henkilotunnus").toString().replace("]", "")
				   													  .replace("[", ""));
		
		person.setPuhelinnumero(params.get("puhelinnumero").toString().replace("]", "")
					  .replace("[", ""));
		
		person.setSahkoposti(params.get("sahkoposti").toString().replace("]", "")
				  .replace("[", ""));
	
		
		person.setTyosuhdealkanut(params.get("tyosuhdealkanut").toString().replace("]", "")
																		  .replace("[", ""));
		
		person.setTilinumero(params.get("tilinumero").toString().replace("]", "")
				   												.replace("[", ""));
		
		person.setVeronumero(params.get("veronumero").toString().replace("]", "")
				   												.replace("[", ""));
		
		personDao.inserNewPerson(person);
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/muokkaaHenkilo/{ssn}", method = RequestMethod.POST)
	public String editPerson(henkilo person, Locale locale,
			@RequestParam MultiValueMap<String, String> params) {
		
		logger.info("requesting path: /muokkaaHenkilo/{ssn}, method: POST, user location: ", locale);
		
		person.setSukunimi(params.get("sukunimi").toString().replace("]", "")
				   								 			.replace("[", ""));
		
		person.setPuhelinnumero(params.get("puhelinnumero").toString().replace("]", "")
					  .replace("[", ""));
		
		person.setSahkoposti(params.get("sahkoposti").toString().replace("]", "")
				  .replace("[", ""));
	
		
		person.setTyosuhdealkanut(params.get("tyosuhdealkanut").toString().replace("]", "")
																		  .replace("[", ""));
		
		person.setTilinumero(params.get("tilinumero").toString().replace("]", "")
				   												.replace("[", ""));
		
		person.setVeronumero(params.get("veronumero").toString().replace("]", "")
				   												.replace("[", ""));

		
		jdbcMethod.update(person.getSukunimi(), person.getHenkilotunnus(), person.getPuhelinnumero(), person.getSahkoposti(),
						  person.getTyosuhdealkanut(), person.getTilinumero(), person.getVeronumero());
	
		return "redirect:/";
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
