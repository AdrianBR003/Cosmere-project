package com.cosmere_backend.API.Controller;

import com.cosmere_backend.API.DTO.CCharacterDTO;
import com.cosmere_backend.Model.CCharacter;
import com.cosmere_backend.Service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
public class CCharacterController {
    @Autowired
    private CharacterService characterService;

    // GET
    @GetMapping
    public List<CCharacterDTO> getAllCharacters() {
        List<CCharacterDTO> characters = characterService.getAllCharacters();
        System.out.println("Characters: " + characters.toString());
        return characters;
    }

    @GetMapping("/{id}")
    public CCharacterDTO getCharacterById(@PathVariable Long id) {
        return characterService.getCharacterById(id);
    }

    // CREATE
    @PostMapping
    public CCharacter createCharacter(@RequestBody CCharacter character) {
        return characterService.createCharacter(character);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteCharacter(@PathVariable Long id) {
        characterService.deleteCharacter(id);
    }
}
