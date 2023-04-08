package com.jsp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.jsp.dao.Studentdao;
import com.jsp.dto.Studentdto;






@Controller
public class Studentcontroller {

	

	@RequestMapping("/studentsignup")
	public ModelAndView signup() {
		ModelAndView modelAndView = new ModelAndView("studentsignup.jsp");
	     Studentdto studentdto=new Studentdto();
		modelAndView.addObject("studobject",studentdto);
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping("/studentinsert")
	public String savedata(Studentdto recobject) {
		Studentdao studentdao=new Studentdao();
		studentdao.insert(recobject);
		return "saved successfully";
	}
	
	
	
	
	@RequestMapping("/delete")
	public ModelAndView delete() {
		ModelAndView modelAndView=new ModelAndView("sdelete.jsp");
	    Studentdto studentdto=new Studentdto();
		modelAndView.addObject("deletebyemail",studentdto);
		return modelAndView;
	
	}
	
	
	@ResponseBody
	@RequestMapping("/deleteperson")
	public String deletePerson(Studentdto em){
	Studentdao studentdao=new Studentdao();
	Studentdto studentdto=studentdao.findbystdid(em.getStdid());
	studentdao.delete(studentdto);
	return "data delete successfully"+studentdto.getStdid();
	
		
	
	}
	
	@RequestMapping("/fetch")
	public ModelAndView fetch() {
		ModelAndView modelAndView=new ModelAndView("Studfetch.jsp");
		Studentdto studentdto=new Studentdto();
		modelAndView.addObject("fetchkey",studentdto );
		return modelAndView;
	
	}
	
	
	
	@ResponseBody
	@RequestMapping("/fetch1")
	public ModelAndView display(int stdid){
		Studentdao studentdao=new Studentdao();
		ModelAndView view=new ModelAndView("studdisplay.jsp");
        Studentdto studentdto=studentdao.findbystdid(stdid);
		view.addObject("requestkey",studentdto);
		return view;
		
	}
	
	@RequestMapping("/update")
	public ModelAndView update() {
		ModelAndView modelAndView=new ModelAndView("supdate.jsp");
		Studentdto studentdto=new Studentdto();
		modelAndView.addObject("updatekey",studentdto );
		return modelAndView;
	
	}
	
	
	@ResponseBody
	@RequestMapping("/updated")
	public String updated(Studentdto recobject){
		Studentdao studentdao=new Studentdao();
		Studentdto studentdto=studentdao.findbystdid(recobject.getStdid());
		
		studentdto.setEmailid(recobject.getEmailid());
		studentdto.setStdname(recobject.getStdname());
		
		studentdao.updatedata(studentdto);
		return "data updated successfully";
		
	}
	
	
	
	
	
	
	
	@RequestMapping("/DisplayAll")
	public ModelAndView displayall(){
	Studentdao studentdao=new Studentdao();
		List<Studentdto> list=studentdao.fetchAll();
		ModelAndView andView=new ModelAndView("Displayall.jsp");
		andView.addObject("key", list);
		return andView;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
