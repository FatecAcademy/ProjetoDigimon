package com.projeto.digimon.controller.adapter;

import com.projeto.digimon.controller.dto.request.DigimonRequest;
import com.projeto.digimon.controller.dto.response.DigimonResponse;
import com.projeto.digimon.entity.Digimon;

import java.util.UUID;

public class DigimonControllerAdapter {

    private DigimonControllerAdapter(){}

    public static Digimon castRequest(DigimonRequest request){
        return new Digimon(
                UUID.randomUUID().toString(),
                request.nome(),
                request.xAntibody()
        );
    }

    public static DigimonResponse castResponse(Digimon digimon) {
        return new DigimonResponse(
                digimon.id(),
                digimon.nome(),
                digimon.xAntibody()
        );
    }

}
