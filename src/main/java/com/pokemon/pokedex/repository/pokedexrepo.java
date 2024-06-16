package com.pokemon.pokedex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokemon.pokedex.entity.pokedex;

@Repository
public interface pokedexrepo extends JpaRepository<pokedex, Long>{

}
