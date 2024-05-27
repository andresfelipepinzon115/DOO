<<<<<<< Updated upstream
package co.edu.uco.tiendachepito.crosscutting.crosscutting.exception;

import co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.enums.Lugar;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.helpers.ObjectHelper;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.helpers.TextHelper;

public class TiendaChepitoException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    protected String mensajeUsuario;
    protected Lugar lugar;

    public TiendaChepitoException(String mensajeTecnico, String mensajeUsuario, Lugar lugar, Throwable excepcionRaiz) {
        super(mensajeTecnico, excepcionRaiz);
        setMensajeUsuario(mensajeUsuario);
        setLugar(lugar);
    }

    public TiendaChepitoException(final String mensajeUsuario, final Lugar lugar) {
        super(mensajeUsuario);
        setMensajeUsuario(mensajeUsuario);
        setLugar(lugar);
    }

    public TiendaChepitoException(String mensajeTecnico, String mensajeUsuario, Lugar lugar) {
        super(mensajeTecnico);
        setMensajeUsuario(mensajeUsuario);
        setLugar(lugar);
    }

    private final void setMensajeUsuario(final String mensajeUsuario) {
        this.mensajeUsuario = TextHelper.applyTrim(mensajeUsuario);
    }

    private final void setLugar(final Lugar lugar) {
        this.lugar = ObjectHelper.getObjectHelper().getDefault(lugar, Lugar.DEFAULT);
    }

    public final String getMensajeUsuario() {
        return mensajeUsuario;
    }

    public final Lugar getLugar() {
        return lugar;
    }
}

=======
package com.doo.ubico.crosscutting.exception;

import com.doo.ubico.crosscutting.exception.enums.Lugar;
import com.doo.ubico.crosscutting.helpers.ObjectHelper;
import com.doo.ubico.crosscutting.helpers.TextHelper;

public class UbicoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	protected String mensajeUsuario;
	protected Lugar lugar;

	public UbicoException(String mensajeTecnico, String mensajeUsuario, Lugar lugar, Throwable excepcionRaiz) {
		super(mensajeTecnico, excepcionRaiz);
		setMensajeUsuario(mensajeUsuario);
		setLugar(lugar);
	}

	public UbicoException(final String mensajeUsuario, final Lugar lugar) {
		super(mensajeUsuario);
		setMensajeUsuario(mensajeUsuario);
		setLugar(lugar);
	}

	public UbicoException(String mensajeTecnico, String mensajeUsuario, Lugar lugar) {
		super(mensajeTecnico);
		setMensajeUsuario(mensajeUsuario);
		setLugar(lugar);
	}

	private final void setMensajeUsuario(final String mensajeUsuario) {
		this.mensajeUsuario = TextHelper.applyTrim(mensajeUsuario);
	}

	private final void setLugar(final Lugar lugar) {
		this.lugar = ObjectHelper.getObjectHelper().getDefault(lugar, Lugar.DEFAULT);
	}

	public final String getMensajeUsuario() {
		return mensajeUsuario;
	}

	public final Lugar getLugar() {
		return lugar;
	}
	
}
>>>>>>> Stashed changes
