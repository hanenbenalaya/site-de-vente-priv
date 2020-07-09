package com.hanen.site.de.vente.priv.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Identifier {
	public  static long i=1;
	 private long rang;
	 public Identifier(){
		 this.rang=this.i;
		 this.i++;
	 }

}
