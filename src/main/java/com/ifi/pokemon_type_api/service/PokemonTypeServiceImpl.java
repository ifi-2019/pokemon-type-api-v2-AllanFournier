package com.ifi.pokemon_type_api.service;

import com.ifi.pokemon_type_api.bo.PokemonType;

import com.ifi.pokemon_type_api.repository.PokemonTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService{

    final PokemonTypeRepository pokemonTypeRepository;

    @Autowired
    public PokemonTypeServiceImpl(PokemonTypeRepository pokemonRepository){
        this.pokemonTypeRepository = pokemonRepository;
    }

    @Override
    public PokemonType getPokemonType(int id) {
        return this.pokemonTypeRepository.findPokemonTypeById(id);
    }

    @Override
    public PokemonType getPokemonTypeByName(String name){return  this.pokemonTypeRepository.findPokemonTypeByName(name);}

    @Override
    public List<PokemonType> getAllPokemonTypes(){
        return this.pokemonTypeRepository.findAllPokemonType();
    }

    @Override
    public List<PokemonType> getPokemonByType(List<String> type){
        if(type.size() == 2 ){
            return this.pokemonTypeRepository.findPokemonByType(type.get(0),type.get(1));
        } else {
            return this.pokemonTypeRepository.findPokemonByType(type.get(0),null);
        }
    }
}
