package com.movie.layer.common.util;

public enum ExceptionMessage {

    INCORRECT_GENRE("El Genero ingresdo es Invalido."),
    MOVIE_NOT_FOUND("La Pelicula buscada No existe."),
    CHARACTER_NOT_FOUND("El Personaje ingresado No existe.");


    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
