/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhosi;

import EntityManager.EntityManagerUtil;
import javax.persistence.EntityManager;
import model.Mensalidade;

/**
 *
 * @author mateus
 */
public class InserirMensalidade {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       EntityManager em = EntityManagerUtil.getEntityManager();
       
       Mensalidade mens = new Mensalidade();
       
       mens.setMes("Dezembro");
       mens.setValor(20.00);
       
       em.getTransaction().begin();
       em.persist(mens);
       em.getTransaction().commit();
       
    }
    
}
