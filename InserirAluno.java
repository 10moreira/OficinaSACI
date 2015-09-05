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
public class InserirAluno {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       EntityManager em = EntityManagerUtil.getEntityManager();
        
        Aluno alun = new Aluno();
        Mensalidade mens = em.find(Mensalidade.class, 1);
        
        alun.setNome("Leandro");
        alun.setEmail("mario@gmail.com");
        alun.setTelefone(32471089);
        alun.setMens(mens);
        
        em.getTransaction().begin();
        em.persist(alun);
        em.getTransaction().commit();
    }
    
}
