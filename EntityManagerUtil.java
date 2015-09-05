/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author mateus
 */
public class EntityManagerUtil {
    
        static EntityManagerFactory emf = null;
        
        public static EntityManager getEntityManager(){
            if(emf==null){
                try{
                    emf = Persistence.createEntityManagerFactory("TrabalhoSIPU");
                }catch(Exception e){
                    
                }
            }
            return emf.createEntityManager();
        }
}
