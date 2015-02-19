package com.quick.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.quick.entities.Person;
import com.quick.service.PersonService;

@Controller
public class HomeController {

	@Autowired
	private PersonService personService;

	private static boolean populatedFlag;

	@RequestMapping("/index")
	public String home(){
		if(!populatedFlag){
			Person p0 = new Person();
			p0.setFirstName("efoe");
			p0.setLastName("Akolly");
			Person p1 = new Person();
			p1.setFirstName("Alex");
			p1.setLastName("Akolly");

			personService.createPerson(p0);
			personService.createPerson(p1);
			populatedFlag = true;
		}
		return "index";
	}

	@RequestMapping(value="/result", method=RequestMethod.POST)
	public String processForm(@RequestParam("fName") String fName, @RequestParam("lName") String lName){
		Person p = new Person();
		p.setFirstName(fName);
		p.setLastName(lName);
		personService.createPerson(p);
		return "result";
	}

	@RequestMapping(value="/display", method=RequestMethod.GET)
	public ModelAndView display(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display");
		List<Person> persons = personService.listAllPersons();
		mv.addObject("persons", persons);
		return mv;
	}

	/*
    @RequestMapping(value="/delete", method=RequestMethod.POST)
    public ModelAndView delete(@RequestParam("id") String id){
        System.out.println("ID :: " + id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("display");
        long personId = Long.parseLong(id);
        personService.deletePerson(personId);
        List<Person> persons = personService.getAll();
        mv.addObject("persons", persons);
        return mv;
    }*/
}
