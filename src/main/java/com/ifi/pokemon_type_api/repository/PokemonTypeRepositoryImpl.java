package com.ifi.pokemon_type_api.repository;

import com.ifi.pokemon_type_api.bo.PokemonType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PokemonTypeRepositoryImpl implements PokemonTypeRepository {
    private List<PokemonType> pokemons;

    public PokemonTypeRepositoryImpl() {
        try {
            var pokemonsStream = new ClassPathResource("pokemons.json").getInputStream();

            var objectMapper = new ObjectMapper();
            var pokemonsArray = objectMapper.readValue(pokemonsStream, PokemonType[].class);
            this.pokemons = Arrays.asList(pokemonsArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PokemonType findPokemonTypeById(int id) {
        System.out.println("Loading Pokemon information for Pokemon id " + id);
        for (PokemonType p : pokemons) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    @Override
    public PokemonType findPokemonTypeByName(String name) {
        System.out.println("Loading Pokemon information for Pokemon name " + name);
        for (PokemonType p : pokemons) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public List<PokemonType> findAllPokemonType() {
        return pokemons;
    }

    @Override
    public List<PokemonType> findPokemonByType(String type1, String type2) {
        System.out.println("Loading Pokemon information by type" + type1);
        List<PokemonType> lis = new ArrayList<PokemonType>();
        if (type2 == null) {
            for (PokemonType p : pokemons) {
                if (p.getTypes().contains(type1)) {
                    lis.add(p);
                }
            }
            return lis;
        }
        if( type2 != null){
            for (PokemonType p : pokemons) {
                if ( (p.getTypes().contains(type1)) && (p.getTypes().contains(type2))) {
                    lis.add(p);
                }
            }
            return lis;
        }
        return new ArrayList<>();
    }
}
