package br.edu.utfpr.pb.oo24s.trabalhof.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
    private static EntityManagerFactory emf;
    
    public static EntityManager getEntityManager(){
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("trabalhof-PU");
        }
        return emf.createEntityManager();
    }
}
