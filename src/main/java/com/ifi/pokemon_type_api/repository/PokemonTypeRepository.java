package com.ifi.pokemon_type_api.repository;

import com.ifi.pokemon_type_api.bo.PokemonType;

import java.util.List;

public interface PokemonTypeRepository {
    PokemonType findPokemonTypeById(int id);
    PokemonType findPokemonTypeByName(String name);
    List<PokemonType> findAllPokemonType();
    List<PokemonType> findPokemonByType(String type1,String type2);
}
