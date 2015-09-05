/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author mateus
 */
@Entity
@Table(name="Aluno")
public class Aluno implements Serializable{
    
    @Id
    @Column(name="matricula")
    @SequenceGenerator(name="SEQ_Alun", sequenceName="GEN_Alun_ID", allocationSize= 1)   
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "SEQ_Alun")
    private Integer matricula;
    
    @Column(name="nome", length = 40, nullable = false)
    private String nome;
    @Column(name = "email", length = 40, nullable = false)
    private String email;
    @Column(name = "telefone", length = 15, nullable = false)
    private Integer telefone;
    
    @ManyToOne
    @JoinColumn(name="mes", referencedColumnName = "id", nullable= false)
    private Mensalidade mens;
    
    
    public Aluno() {
    
    }

    
    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Mensalidade getMens() {
        return mens;
    }

    public void setMens(Mensalidade mens) {
        this.mens = mens;
    }

  
}

