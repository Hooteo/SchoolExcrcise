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
@Table(name="dipartimenti")

public class Dipartimento implements Serializable {
  
    @Id @GeneratedValue
    private int id_dipartimento;

    @Column
    private String nome;   
    @Column
    private String sede; 
    
    @OneToMany(mappedBy="dipartimento")
    
    private Set<Persona> persone;
    
    public Dipartimento(){}
    public Dipartimento(String nome,String sede) {
        this.nome = nome;
        this.sede=sede;
    }

    public int getId_dipartimento() {
        return id_dipartimento;
    }

    public String getNome() {
        return nome;
    }

    public String getSede() {
        return sede;
    }

    public Set<Persona> getPersone() {
        return persone;
    }

    public void setId_dipartimento(int id_dipartimento) {
        this.id_dipartimento = id_dipartimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public void setPersone(Set<Persona> persone) {
        this.persone = persone;
    }    

    @Override
    public String toString() {
        return "Dipartimento{" + "id_dipartimento=" + id_dipartimento + ", nome=" + nome + ", sede=" + sede + ", persone=" + persone + '}';
    }
    
    
}