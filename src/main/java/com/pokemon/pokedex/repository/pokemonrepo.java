package com.pokemon.pokedex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokemon.pokedex.entity.pokemon;

@Repository
public interface pokemonrepo extends JpaRepository<pokemon, Long> { 
    pokemon findByNome(String name);

    List<pokemon> findBytipo1(String tipo1);

    List<pokemon> findBytipo2(String tipo2);
}

