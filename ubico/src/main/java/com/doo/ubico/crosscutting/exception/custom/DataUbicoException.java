<<<<<<< Updated upstream
package co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.custom;


import co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.TiendaChepitoException;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.enums.Lugar;

public final class DataTiendaChepitoException extends TiendaChepitoException {
=======
package com.doo.ubico.crosscutting.exception.custom;

import com.doo.ubico.crosscutting.exception.UbicoException;
import com.doo.ubico.crosscutting.exception.enums.Lugar;


public final class DataUbicoException extends UbicoException {
>>>>>>> Stashed changes

	private static final long serialVersionUID = 1L;
	private static final Lugar lugar = Lugar.DATA;

<<<<<<< Updated upstream
	public DataTiendaChepitoException(final String mensajeUsuario) {
		super(mensajeUsuario, lugar);
	}

	public DataTiendaChepitoException(final String mensajeTecnico, final String mensajeUsuario) {
		super(mensajeTecnico, mensajeUsuario, lugar);
	}

	public DataTiendaChepitoException(final String mensajeTecnico, final String mensajeUsuario, final Throwable excepcionRaiz) {
=======
	public DataUbicoException(final String mensajeUsuario) {
		super(mensajeUsuario, lugar);
	}

	public DataUbicoException(final String mensajeTecnico, final String mensajeUsuario) {
		super(mensajeTecnico, mensajeUsuario, lugar);
	}

	public DataUbicoException(final String mensajeTecnico, final String mensajeUsuario, final Throwable excepcionRaiz) {
>>>>>>> Stashed changes
		super(mensajeTecnico, mensajeUsuario, lugar, excepcionRaiz);
	}
}
