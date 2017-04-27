package fi.jamk.henkilorekisteri;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApiController {

	private static final Logger logger = LoggerFactory.getLogger(ApiController.class);
	
	@Inject
	private henkiloDAO personDao;

	@RequestMapping(value = "api/", method = RequestMethod.GET, headers="Accept=application/json")
	public @ResponseBody void getEmpty() {
		logger.info("API Controller!.");

	}
	
	@RequestMapping(value = "api/{name}", method = RequestMethod.GET, headers="Accept=application/json")
	public @ResponseBody List<henkilo> getHenkilo(@PathVariable String name) {
		logger.info("API Controller!.");
		
		List<henkilo> person = personDao.getByName(name);
		
		return person;
	}
	
	@RequestMapping(value = "api/henkilotunnus/{ssn}", method = RequestMethod.GET, headers="Accept=application/json")
	public @ResponseBody List<henkilo> getHenkiloBySnn(@PathVariable String ssn) {
		logger.info("API Controller!.");
		
		List<henkilo> person = personDao.getBySnn(ssn);
		
		return person;
	}
}
