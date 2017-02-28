/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.DonneesObjectives;

/**
 *
 * @author dtp
 */
@Stateless
public class DonneesObjectivesFacade extends AbstractFacade<DonneesObjectives> {

    @PersistenceContext(unitName = "hrgpwebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DonneesObjectivesFacade() {
        super(DonneesObjectives.class);
    }
    
}
