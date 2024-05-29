package com.doo.ubico.api.response.aula;

import java.util.ArrayList;
import java.util.List;

import com.doo.ubico.api.response.Response;
import com.doo.ubico.dto.AulaDTO;



public class AulaResponse extends Response<AulaDTO> {

    public AulaResponse(){
        setMensajes(new ArrayList<String>());
        setDatos(new ArrayList<AulaDTO>());
    }



}
