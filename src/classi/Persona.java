/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classi;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author FSEVERI\benetti3004
 */
@Entity
@Table(name="persone")

public class Persona implements Serializable {
    @Id @GeneratedValue
    private int id_persona;
    @Column
    private String nome;  
    
    
    @ManyToOne
    @JoinColumn(name="fk_dipartimento") //,referencedColumnName="id_dipartimento"
    private Dipartimento dipartimento;
   
    
    @ManyToMany
    @JoinTable(name="assegnazione_compiti",
            joinColumns={@JoinColumn(name="fk_persona")}, 
            inverseJoinColumns={@JoinColumn(name="fk_job")})
    private Set<Job> jobs;
     
   
    public Persona(){}
    
    public Persona(String nome,Dipartimento dipart){
        this.nome=nome;
        this.dipartimento= dipart;
       
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public int getId_persona(){
        return this.id_persona;
    } 
    public Dipartimento getDipartimento(){
        return this.dipartimento;
    }
    
    
    public void setNome(String nome){
        this.nome=nome;
    }
    
    public void setId_persona(int id){
        this.id_persona=id;
    } 
    public void setDipartimento(Dipartimento dipart){
        this.dipartimento=dipart;
    } 

    public void setJobs(Set<Job> jobs) {
        this.jobs = jobs;
    }

    public void setFk_dipartimento(Dipartimento fk_dipartimento) {
        this.dipartimento = fk_dipartimento;
    }

    public Set<Job> getJobs() {
        return jobs;
    }

    @Override
    public String toString() {
        return "Persona{" + "id_persona=" + id_persona + ", nome=" + nome + ", dipartimento=" + dipartimento + ", jobs=" + jobs + '}';
    }
    
}