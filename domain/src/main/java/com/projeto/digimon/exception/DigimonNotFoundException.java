package com.projeto.digimon.exception;


public class DigimonNotFoundException extends RuntimeException {
    public DigimonNotFoundException(String id) {
        super("Digimon não encontrado: " + id);
    }
}
