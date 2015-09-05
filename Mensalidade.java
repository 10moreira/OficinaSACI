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
@Table(name="Mensalidade")
public class Mensalidade implements Serializable {
    
    @Id
    @Column(name="id")
    @SequenceGenerator(name="SEQ_Mens", sequenceName="GEN_Mens_ID", allocationSize= 1)
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "SEQ_Mens")
    private Integer id;
    @Column(name = "mes", length = 15, nullable = false)
    private String mes;
    @Column(name = "valor", length = 10, nullable = false)
    private Double valor;

    @OneToMany(mappedBy="matricula")
    @Cascade((org.hibernate.annotations.CascadeType.SAVE_UPDATE))
    @LazyCollection(LazyCollectionOption.EXTRA)
    private Collection<Aluno> listaAlunos = new ArrayList<Aluno>();
    
    public Mensalidade() {
    }

   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

   public void adicionaAluno(Aluno alun) {
       alun.setMens(this);
       getListaAlunos().add(alun);
    }

    public Collection<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(Collection<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }
    
}
