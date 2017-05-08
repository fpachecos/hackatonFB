package br.com.cielo.settlement.adjustmentpaymenttype.dto;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * Representa��o do resultado dos domicilios bancarios do ajuste.
 * 
 * @author <a href="mailto:eyvdbm@prestadorcbmp.com.br>Evandro da cunha luz</a>
 * @version $Id$
 *
 */
public class DomicileBankAdjustProduct {

  /**
   * Domicilio que possui o maior saldo
   */
  private Set<DomicileBankAdjust> domicilies;



  public Set<DomicileBankAdjust> getDomicilies() {
    return domicilies;
  }



  public void setDomicilies(Set<DomicileBankAdjust> domicilies) {
    this.domicilies = domicilies;
  }



  public DomicileBankAdjustProduct add(DomicileBankAdjust domicile) {
    if (domicile != null) {
      if (this.domicilies == null) {
        this.setDomicilies(new HashSet<DomicileBankAdjust>());
      }

      this.getDomicilies().add(domicile);
    }


    return this;
  }



}
