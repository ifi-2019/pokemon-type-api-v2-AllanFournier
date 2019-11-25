package com.ifi.pokemon_type_api.service;

import com.ifi.pokemon_type_api.bo.PokemonType;

import java.util.List;

public interface PokemonTypeService {
    PokemonType getPokemonType(int id);
    PokemonType getPokemonTypeByName(String name);
    List<PokemonType> getPokemonByType(List<String> type);
    List<PokemonType> getAllPokemonTypes();
}
