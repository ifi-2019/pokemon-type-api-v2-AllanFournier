package com.ifi.pokemon_type_api.controller;

import com.ifi.pokemon_type_api.bo.PokemonType;
import com.ifi.pokemon_type_api.service.PokemonTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemon-types")
public class PokemonTypeController {

    final PokemonTypeService pokemonTypeService;

    @Autowired
    public PokemonTypeController(PokemonTypeService pokemonTypeService) {
        this.pokemonTypeService = pokemonTypeService;
    }

    @GetMapping("/{id}")
    PokemonType getPokemonTypeFromId(@PathVariable int id){
        return pokemonTypeService.getPokemonType(id);
    }

    @GetMapping(value = "/",params =  "name")
    PokemonType getPokemonTypeByName(String name){
        return pokemonTypeService.getPokemonTypeByName(name);
    }

    @GetMapping(value = "/",params =  "types")
    public List<PokemonType> getPokemonByType(@RequestParam List<String> types){ return pokemonTypeService.getPokemonByType(types); }

    @GetMapping({""})
    public List<PokemonType> getAllPokemonTypes() {
        return pokemonTypeService.getAllPokemonTypes();
    }
}
