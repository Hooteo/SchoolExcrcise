/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import org.hibernate.SessionFactory;
import classi.*;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author FSEVERI\benetti3004
 */
public class Utility {

    private static SessionFactory factory;
    
        public Utility(SessionFactory f){
        Utility.factory = f;
    }
        
    public void aggiungiDipartimento(Dipartimento d){
    Session sessione = factory.openSession();
    Transaction transazione = null;
    try{
        transazione = sessione.beginTransaction();
        sessione.save(d);
        transazione.commit();
    }catch(HibernateException e){
        if(transazione!=null) transazione.rollback();
    }finally{
        sessione.close();
    }
    }
        
        
         public List leggiDipartimenti(){
        Session sessione = factory.openSession();
        Transaction transazione = null;
        try{
            transazione = sessione.beginTransaction();
            List dipartimenti = sessione.createQuery("FROM Dipartimento").list();
            transazione.commit();
            return dipartimenti;
        }catch(HibernateException e){
            if(transazione!=null) transazione.rollback();
        }finally{
            sessione.close();
        }
        return null;
    }
    
    public Dipartimento leggiDipartimento(Integer id){
        List dipartimenti = leggiDipartimenti();
        Dipartimento d;
        for(Iterator i = dipartimenti.iterator();i.hasNext();){
            d = (Dipartimento)i.next();
            if(d.getId_dipartimento()==id)return d;
        }
        return null;
    }   
        
        
        
     public void modificaDipartimento(Integer id, String nome){
        Session sessione = factory.openSession();
        Transaction transazione = null;
        try{
            transazione = sessione.beginTransaction();
            Dipartimento d = (Dipartimento) sessione.get(Dipartimento.class,id);
            d.setNome(nome);
            sessione.update(d);
            transazione.commit();
        }catch(HibernateException e){
            if(transazione!=null) transazione.rollback();
        }finally{
            sessione.close();
        }
    }
    
    public void eliminaDipartimento(Integer id){
        Session sessione = factory.openSession();
        Transaction transazione = null;
        try{
            transazione = sessione.beginTransaction();
            Dipartimento d = (Dipartimento) sessione.get(Dipartimento.class, id);
            sessione.delete(d);
            transazione.commit();
        }catch(HibernateException e){
            if(transazione!=null) transazione.rollback();
        }finally{
            sessione.close();
        }
    }
    
    public void aggiungiPersona(Persona p){
        Session sessione = factory.openSession();
        Transaction transazione = null;
        try{
            transazione = sessione.beginTransaction();
            sessione.save(p);
            transazione.commit();
        }catch(HibernateException e){
            if(transazione!=null)transazione.rollback();
        }
        finally{
            sessione.close();
        }
    }
    
    public List leggiPersone(){
        Session sessione = factory.openSession();
        Transaction transazione = null;
        try{
            transazione = sessione.beginTransaction();
            List jobs = sessione.createQuery("FROM Persona").list();
            transazione.commit();
            return jobs;
        }catch(HibernateException e){
            if(transazione!=null) transazione.rollback();
        }finally{
            sessione.close();
        }
        return null;
    }
    
    public Persona leggiPersona(Integer id){
        List jobs = leggiPersone();
        Persona p;
        for(Iterator i = jobs.iterator();i.hasNext();){
            p = (Persona)i.next();
            if(p.getId_persona()==id)return p;
        }
        return null;
    }
    
    public void aggiungiJob(Job j){
        Session sessione = factory.openSession();
        Transaction transazione = null;
        try{
            transazione = sessione.beginTransaction();
            sessione.save(j);
            transazione.commit();
        }catch(HibernateException e){
            if(transazione!=null)transazione.rollback();
        }
        finally{
            sessione.close();
        }
    }
    
    public List leggiJobs(){
        Session sessione = factory.openSession();
        Transaction transazione = null;
        try{
            transazione = sessione.beginTransaction();
            List jobs = sessione.createQuery("FROM Job").list();
            transazione.commit();
            return jobs;
        }catch(HibernateException e){
            if(transazione!=null) transazione.rollback();
        }finally{
            sessione.close();
        }
        return null;
    }
    
    public Job leggiJob(Integer id){
        List jobs = leggiJobs();
        Job j;
        for(Iterator i = jobs.iterator();i.hasNext();){
            j = (Job)i.next();
            if(j.getId_job()==id)return j;
        }
        return null;
    }   
}
