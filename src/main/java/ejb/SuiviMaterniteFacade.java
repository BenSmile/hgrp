/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.SuiviMaternite;

/**
 *
 * @author dtp
 */
@Stateless
public class SuiviMaterniteFacade extends AbstractFacade<SuiviMaternite> {

    @PersistenceContext(unitName = "hrgpwebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SuiviMaterniteFacade() {
        super(SuiviMaternite.class);
    }
    
}
