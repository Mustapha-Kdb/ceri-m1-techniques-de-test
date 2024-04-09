package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RocketPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        pokemonFactory = new RocketPokemonFactory();
    }

    @Test
    public void testCreatePokemonWithValidIndex() throws PokedexException {
        int index = 1; // Bulbasaur
        Pokemon pokemon = pokemonFactory.createPokemon(index, 500, 50, 3000, 3);
        assertNotNull("Le Pokémon ne doit pas être null", pokemon);
        assertEquals("Le nom du Pokémon doit être Bulbasaur", "Bulbasaur", pokemon.getName());
        assertTrue("L'attaque doit être générée aléatoirement et positive", pokemon.getAttack() > 0);
        assertTrue("La défense doit être générée aléatoirement et positive", pokemon.getDefense() > 0);
        assertTrue("L'endurance doit être générée aléatoirement et positive", pokemon.getStamina() > 0);
        assertEquals("IV doit être 1", 1, pokemon.getIv(), 0);
    }

    @Test
    public void testCreatePokemonWithInvalidIndex() throws PokedexException {
        int index = -2; // INVALID
        Pokemon pokemon = pokemonFactory.createPokemon(index, 500, 50, 3000, 3);
        assertNotNull("Le Pokémon ne doit pas être null", pokemon);
        assertEquals("Le nom du Pokémon doit être MISSINGNO pour un index invalide", "MISSINGNO", pokemon.getName());
    }

    @Test
    public void testCreatePokemonWithSpecialIndex() throws PokedexException {
        int index = -1; // Ash's Pikachu
        Pokemon pokemon = pokemonFactory.createPokemon(index, 500, 50, 3000, 3);
        assertNotNull("Le Pokémon ne doit pas être null", pokemon);
        assertEquals("Le nom du Pokémon doit être Ash's Pikachu pour l'index spécial -1", "Ash's Pikachu", pokemon.getName());
        assertEquals("L'attaque pour Ash's Pikachu doit être 1000", 1000, pokemon.getAttack());
        assertEquals("La défense pour Ash's Pikachu doit être 1000", 1000, pokemon.getDefense());
        assertEquals("L'endurance pour Ash's Pikachu doit être 1000", 1000, pokemon.getStamina());
        assertEquals("IV pour Ash's Pikachu doit être 0", 0, pokemon.getIv(), 0);
    }
}
