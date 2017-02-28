/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.util.GregorianCalendar;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 *
 * @author Ben Kafirongo
 */
public class AntecedantCPNListerner {

    @PrePersist
    @PreUpdate
    private void verifierDate(AntecedentCpn ac) {
        if (ac.getDdr() != null) {
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(ac.getDdr());
            gc.add(GregorianCalendar.MONTH, 9);
            gc.add(GregorianCalendar.DATE, 10);
            ac.setDpa(gc.getTime());
        }
        else {
            ac.setDpa(null);
        }
    }
}
