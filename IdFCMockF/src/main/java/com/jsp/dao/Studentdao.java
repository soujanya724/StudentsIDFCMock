package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.dto.Studentdto;




public class Studentdao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public void insert(Studentdto d)
	{
		entityTransaction.begin();
		entityManager.persist(d);
		entityTransaction.commit();
	}
	
	
	public Studentdto findbystdid(int stdid){
		Studentdto studentdto=entityManager.find(Studentdto.class, stdid);
	    return studentdto;
		
	}
	
	public List<Studentdto> fetchAll(){
		javax.persistence.Query query=entityManager.createQuery("select q from Studentdto q");
		List<Studentdto> data=query.getResultList();
		return data;
	}
	public void delete(Studentdto d)
	{
		entityTransaction.begin();
		entityManager.remove(d);
		entityTransaction.commit();
	}


	public  void updatedata(Studentdto d) {
		
		entityTransaction.begin();
		entityManager.merge(d);
		entityTransaction.commit();
	}
	
}
