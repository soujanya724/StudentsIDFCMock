package com.jsp.jese8.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.jese8.dao.Empdao;
import com.jsp.jese8.dto.Empdto;

@Controller
public class Empcontroller {
	// @Autowired
	//Empdto emp;

	@RequestMapping("/signup")
	public ModelAndView signup() {
		ModelAndView modelAndView = new ModelAndView("signup.jsp");
		Empdto emp = new Empdto();
		modelAndView.addObject("empobject", emp);
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping("/insert")
	public String savedata(Empdto recobject) {
		Empdao empdao = new Empdao();
		empdao.insert(recobject);
		return "saved successfully";
	}
	
	@RequestMapping("/delete")
	public ModelAndView delete() {
		ModelAndView modelAndView=new ModelAndView("delete.jsp");
		Empdto empdto=new Empdto();
		modelAndView.addObject("deletebyemail",empdto );
		return modelAndView;
	
	}
	
	
	@ResponseBody
	@RequestMapping("/deleteperson")
	public String deletePerson(Empdto empdto){
		Empdao em=new Empdao();
		Empdto empdto2=em.findbyemail(empdto.getEmail());
		em.deleteData(empdto2);
		return "data deleted successfully"+ empdto2.getEmail();
		
	}
	
	
	@RequestMapping("/update")
	public ModelAndView update() {
		ModelAndView modelAndView=new ModelAndView("update.jsp");
		Empdto empdto=new Empdto();
		modelAndView.addObject("updatekey",empdto );
		return modelAndView;
	
	}
	
	
	@ResponseBody
	@RequestMapping("/updated")
	public String updated(Empdto recobject){
		Empdao em=new Empdao();
		Empdto empdto=em.findbyemail(recobject.getEmail());
		empdto.setName(recobject.getName());
//		empdto.setPhone(recobject.getPhone());
//		empdto.setPwd(recobject.getPwd());
//		empdto.setRole(recobject.getRole());
		em.updatedata(empdto);
		return "data updated successfully";
		
	}
	
	
	@RequestMapping("/fetch")
	public ModelAndView fetch() {
		ModelAndView modelAndView=new ModelAndView("fetch.jsp");
		Empdto empdto=new Empdto();
		modelAndView.addObject("fetch",empdto );
		return modelAndView;
	
	}
	
	
	
	@ResponseBody
	@RequestMapping("/fetch1")
	public ModelAndView display(String email){
		Empdao empdao=new Empdao();
		ModelAndView view=new ModelAndView("display.jsp");
		Empdto empdto=empdao.findbyemail(email);
		view.addObject("requestkey", empdto);
		return view;
		
	}
		
	@RequestMapping("/displayAll")
	public ModelAndView displayall(){
		Empdao empdao=new Empdao();
		List<Empdto> empdtos=empdao.fetchAll();
		ModelAndView andView=new ModelAndView("displayall.jsp");
		andView.addObject("key", empdtos);
		return andView;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
