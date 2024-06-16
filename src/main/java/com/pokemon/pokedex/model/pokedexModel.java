package com.pokemon.pokedex.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class pokedexModel {

    private long id;
    private String proprietario;
    private List<String> pokemonsName;
    //modelo para receber as informaçoes da pokedex

}
