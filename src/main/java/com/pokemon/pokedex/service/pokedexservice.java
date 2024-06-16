package com.pokemon.pokedex.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemon.pokedex.entity.pokedex;
import com.pokemon.pokedex.entity.pokemon;
import com.pokemon.pokedex.model.pokedexModel;
import com.pokemon.pokedex.repository.pokedexrepo;
import com.pokemon.pokedex.repository.pokemonrepo;

@Service
public class pokedexservice {
    //instancinado o repositorio dentro do service
    
    private final pokedexrepo pokedexRepository;

    @Autowired
    private pokemonservice pokemonservice;

    @Autowired
    public pokedexservice(pokedexrepo pokedexRepository) {
        this.pokedexRepository = pokedexRepository;
     
    }

    public pokedex salvarPokedex(pokedexModel pokedexModel) throws Exception{
        pokedex pokedex = new pokedex(); // CRIANDO POKEDEX
        List<pokemon> pokemonList = new ArrayList<>(); // CRIANDO LISTA DE POKEMONS
        try {
            for(int i = 0; i < pokedexModel.getPokemonsName().size(); i++){ // EXECUTA ENQUANTO I FOR MENOR QUE O TAMANHO DA LISTA
                pokemonList.add(pokemonservice.getpokemonByName(pokedexModel.getPokemonsName().get(i))); // INCLUINDO NA LISTA O POKEMON ENCONTRADO PELO NOME
            }
            pokedex.setPokemons(pokemonList); // INCLUINDO A LISTA NA POKEDEX
            pokedex.setProprietario(pokedexModel.getProprietario()); // INCLUINDO O PROPRIETARIO NA POKEDEX
            return pokedexRepository.save(pokedex); // SALVANDOP POKEDEX
        } catch (Exception e) {
            throw new Exception("Erro ao buscar pokemon.", e); 
            //jogar uma nova excecao
        }
    }

    public pokedex addPokemonInPokedex(Long pokedexId, String pokemonName) throws Exception{  // ADD POKEMON NA POKEDEX, RECEBENDO POKEDEXIiD LONG E STRING POKEMON NAME 
        try {
            Optional<pokedex> pokedexExistente = pokedexRepository.findById(pokedexId); // RETORNANDO POKEDEX PELO ID
            if (!pokedexExistente.isPresent()) {  
                throw new Exception("Pokedex não encontrada com o ID: " + pokedexId); // CASO NÃO ACHE DA ERRO
            }
            pokedex pokedex = pokedexExistente.get(); // PEGANDO POKEDEX EXISTENTE E ADICIONANDO NA ENTIDADE POKEDEX
            List<pokemon> pokemonList = new ArrayList<>(); // CRIANDO UMA NOVA LISTA POKEMON LIST
            pokemonList.add(pokemonservice.getpokemonByName(pokemonName)); // ADICIONANDO POKEMON PELO NOME
            for(int i = 0; i < pokedex.getPokemons().size(); i++){ // EXECUTA ENQUANTO I FOR MENOR QUE A QUANTIDADE DE POKEMON EXISTENTE NA POKEDEX
                pokemonList.add(pokedex.getPokemons().get(i)); // ADICIONAR POKEMON EXISTENTE NA LISTA
            }
            pokedex.setPokemons(pokemonList); // SALVANDO POKEDEX
            return pokedexRepository.save(pokedex);
        } catch (Exception e) {
            throw new Exception("Erro ao buscar pokemon.", e);
        }
    }

    public Optional<pokedex> findById(Long id){
        return pokedexRepository.findById(id);
    }
}
