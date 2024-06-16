package com.pokemon.pokedex.controller;

import java.util.List;
import java.util.Optional;

import com.pokemon.pokedex.service.pokedexservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pokemon.pokedex.entity.pokedex;
import com.pokemon.pokedex.entity.pokemon;
import com.pokemon.pokedex.model.pokedexModel;

@RestController
@RequestMapping("api/pokedex")
public class pokedexController {

    private final pokedexservice pokedexService;
    
    @Autowired 
    public pokedexController(pokedexservice pokedexService) {
        this.pokedexService = pokedexService;    
    }

    @GetMapping("/id")
    public Optional<pokedex> getpokemonById(@RequestParam Long id) {
        return pokedexService.findById(id);
    }

    @PostMapping("/salvar")
    public ResponseEntity<pokedex> addPokedex(@RequestBody pokedexModel pokedex) throws Exception {
        pokedex pokemonRecebido = pokedexService.salvarPokedex(pokedex);
        return ResponseEntity.ok(pokemonRecebido);
    }

    @PostMapping("/addPokemon")
    public ResponseEntity<pokedex> getpokemonBytipo1(@RequestParam Long pokedexId, @RequestParam String pokemonName) throws Exception{
        return ResponseEntity.ok(pokedexService.addPokemonInPokedex(pokedexId, pokemonName));
    }

}
