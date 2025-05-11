package com.contrastsecurity.demo.providersearch;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProviderSearchDAO {
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public List<Object[]> getProvidersInZipCode(String zipCode) {
        EntityManager em = entityManagerFactory.createEntityManager();
        String q = "select * from PROVIDERS where public_listing is true and zip_code = :parameter0";
        Query query = em.createNativeQuery(q).setParameter("parameter0", zipCode);
        List<Object[]> results = query.getResultList();
        return results;
    }
}


