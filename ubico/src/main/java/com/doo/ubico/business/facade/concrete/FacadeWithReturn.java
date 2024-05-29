package com.doo.ubico.business.facade.concrete;

public interface FacadeWithReturn <T,K>{
	K execute (T dto);
}
