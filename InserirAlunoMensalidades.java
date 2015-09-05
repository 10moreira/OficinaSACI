/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhosi;

import EntityManager.EntityManagerUtil;
import javax.persistence.EntityManager;
import model.Aluno;
import model.Mensalidade;

/**
 *
 * @author mateus
 */
public class InserirAlunoMensalidades {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        EntityManager em = EntityManagerUtil.getEntityManager();
        
        Aluno alun = em.find(Aluno.class, 1);
        Mensalidade mens = em.find(Mensalidade.class, 1);
        
        mens.adicionaAluno(alun);
        em.getTransaction().begin();
        em.persist(alun);
        em.getTransaction().commit();

        
        for(Aluno alu: mens.getListaAlunos()){
            System.out.print("\nMes: " + alu.getNome());
        }
    }
}
