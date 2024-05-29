package com.doo.ubico.api.response.aula;


import com.doo.ubico.dto.BloqueDTO;
import java.util.ArrayList;
import java.util.List;

public class BloqueResponse {
    private List<BloqueDTO> datos;
    private List<String> mensajes;

    public BloqueResponse() {
        this.datos = new ArrayList<>();
        this.mensajes = new ArrayList<>();
    }

    public List<BloqueDTO> getDatos() {
        return datos;
    }

    public void setDatos(List<BloqueDTO> datos) {
        this.datos = datos;
    }

    public List<String> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<String> mensajes) {
        this.mensajes = mensajes;
    }
}
