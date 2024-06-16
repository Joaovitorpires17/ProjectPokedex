package com.pokemon.pokedex.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pokemon.pokedex.entity.pokemon;
import com.pokemon.pokedex.service.pokemonservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/pokemon")
public class pokemoncontroller {
    private final pokemonservice pokemonService;
    
    @Autowired 
    public pokemoncontroller(pokemonservice pokemonService) {
        this.pokemonService = pokemonService;    
    }

    @PostMapping("/add")
    public ResponseEntity<pokemon> addPokemon(@RequestBody pokemon pokemon) {
        pokemon pokemonRecebido = pokemonService.salvarPokemon(pokemon);
        
        return ResponseEntity.ok(pokemonRecebido);

    }

    @GetMapping("/nome")
    public pokemon getpokemonByName(@RequestParam String name) {
        return pokemonService.getpokemonByName(name);
    }
    
    @GetMapping("/id")
    public Optional<pokemon> getpokemonById(@RequestParam Long id) {
        return pokemonService.getpokemonById(id);
    }
    
    @GetMapping("/tipo1")
    public List<pokemon> getpokemonBytipo1(@RequestParam String tipo1) {
        return pokemonService.getpokemonBytipo1(tipo1);
    }

    @GetMapping("/tipo2")
    public List<pokemon> getpokemonBytipo2(@RequestParam String tipo2) {
        return pokemonService.getpokemonBytipo2(tipo2);
    }
}
