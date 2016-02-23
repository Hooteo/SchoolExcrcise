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
@Table(name="job")
public class Job implements Serializable {
    
    @Id @GeneratedValue
    private int id_job;
    
    @Column
    private String nome;
    @ManyToMany (mappedBy="jobs")
    private Set<Persona> persone;
   /* 
    @OneToMany
    @JoinColumn(name="job")
    private Set <Persona> persone;
    */
    
    public Job(){}

    public Job(String nome) {
        this.nome = nome;
    }

    public int getId_job() {
        return id_job;
    }

    public String getNome() {
        return nome;
    }

    public void setId_job(int id_job) {
        this.id_job = id_job;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    

    @Override
    public String toString() {
        return "Job{" + "id_job=" + id_job + ", nome=" + nome + ", persone=" + persone + '}';
    } 

    public void setPersone(Set<Persona> persone) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
