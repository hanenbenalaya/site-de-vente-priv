package com.hanen.site.de.vente.priv.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PanierItems {
	private long clt_id ;
	private long mnt_tot;
	private Prod[] product_list=new Prod[100];
	
	 
}
