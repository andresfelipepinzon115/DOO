package com.doo.ubico.api.response.aula;


import com.doo.ubico.dto.TipoAulaDTO;
import java.util.ArrayList;
import java.util.List;

public class TipoAulaResponse {
    private List<TipoAulaDTO> datos;
    private List<String> mensajes;

    public TipoAulaResponse() {
        this.datos = new ArrayList<>();
        this.mensajes = new ArrayList<>();
    }

    public List<TipoAulaDTO> getDatos() {
        return datos;
    }

    public void setDatos(List<TipoAulaDTO> datos) {
        this.datos = datos;
    }

    public List<String> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<String> mensajes) {
        this.mensajes = mensajes;
    }
}
