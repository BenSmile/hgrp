/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.AntecedentCpn;

/**
 *
 * @author dtp
 */
@Stateless
public class AntecedentCpnFacade extends AbstractFacade<AntecedentCpn> {

    @PersistenceContext(unitName = "hrgpwebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AntecedentCpnFacade() {
        super(AntecedentCpn.class);
    }
    
}
