<<<<<<< Updated upstream
package co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.custom;


import co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.TiendaChepitoException;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.enums.Lugar;

public final class CrosscuttingTiendaChepitoException extends TiendaChepitoException {
=======
package com.doo.ubico.crosscutting.exception.custom;

import com.doo.ubico.crosscutting.exception.UbicoException;
import com.doo.ubico.crosscutting.exception.enums.Lugar;

public final class CrosscuttingUbicoException extends UbicoException {
>>>>>>> Stashed changes

	private static final long serialVersionUID = 1L;
	private static final Lugar lugar = Lugar.CROSSCUTTING;

<<<<<<< Updated upstream
	public CrosscuttingTiendaChepitoException(final String mensajeUsuario) {
		super(mensajeUsuario, lugar);
	}

	public CrosscuttingTiendaChepitoException(final String mensajeTecnico, final String mensajeUsuario) {
		super(mensajeTecnico, mensajeUsuario, lugar);
	}

	public CrosscuttingTiendaChepitoException(final String mensajeTecnico, final String mensajeUsuario,
=======
	public CrosscuttingUbicoException(final String mensajeUsuario) {
		super(mensajeUsuario, lugar);
	}

	public CrosscuttingUbicoException(final String mensajeTecnico, final String mensajeUsuario) {
		super(mensajeTecnico, mensajeUsuario, lugar);
	}

	public CrosscuttingUbicoException(final String mensajeTecnico, final String mensajeUsuario,
>>>>>>> Stashed changes
			final Throwable excepcionRaiz) {
		super(mensajeTecnico, mensajeUsuario, lugar, excepcionRaiz);
	}
}
