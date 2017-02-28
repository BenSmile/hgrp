/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.InfosAccouchement;

/**
 *
 * @author dtp
 */
@Stateless
public class InfosAccouchementFacade extends AbstractFacade<InfosAccouchement> {

    @PersistenceContext(unitName = "hrgpwebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InfosAccouchementFacade() {
        super(InfosAccouchement.class);
    }
    
}
