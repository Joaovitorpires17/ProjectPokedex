package com.pokemon.pokedex.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemon.pokedex.entity.pokemon;
import com.pokemon.pokedex.repository.pokemonrepo;

@Service
public class pokemonservice {
    
    //instancinado o repositorio dentro do service
    private final pokemonrepo pokemonRepository;

    @Autowired
    public pokemonservice(pokemonrepo pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    // funçoes
    public pokemon salvarPokemon(pokemon pokemon) {
        return pokemonRepository.save(pokemon);

    }

    public pokemon getpokemonByName(String name) {
        return pokemonRepository.findByNome(name);
    }

    public Optional<pokemon> getpokemonById(Long id) {
        return pokemonRepository.findById(id);
    }

    public List<pokemon> getpokemonBytipo1(String tipo1) {
        return pokemonRepository.findBytipo1(tipo1);
    }

    public List<pokemon> getpokemonBytipo2(String tipo2) {
        return pokemonRepository.findBytipo2(tipo2);
    }
     

}
