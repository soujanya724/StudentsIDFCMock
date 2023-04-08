package com.jsp.jese8.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

import com.jsp.jese8.dto.Empdto;
import com.mysql.cj.Query;
@Component
public class Empdao {

	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public void insert(Empdto d)
	{
		entityTransaction.begin();
		entityManager.persist(d);
		entityTransaction.commit();
	}
	
	public Empdto findbyemail(String email){
		Empdto empdto=entityManager.find(Empdto.class, email);
	    return empdto;
		
	}
	
	public List<Empdto> fetchAll(){
		javax.persistence.Query query=entityManager.createQuery("select q from Empdto q");
		List<Empdto> data=query.getResultList();
		return data;
		
		
		
		
	}
	
	public void deleteData(Empdto empdto){
		entityTransaction.begin();
		entityManager.remove(empdto);
		entityTransaction.commit();
		
	}


public void updatedata(Empdto empdto) {
	
	entityTransaction.begin();
	
	
	 entityManager.merge(empdto);
	 entityTransaction.commit();
	 
}


	
}
