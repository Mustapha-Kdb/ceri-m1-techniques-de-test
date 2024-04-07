package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        pokemonFactory = new PokemonFactory(new PokemonMetadataProvider());
    }

    @Test
    public void testCreatePokemon() {
        Pokemon pokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertNotNull("Le Pokémon créé ne doit pas être null", pokemon);
        assertEquals("L'index du Pokémon ne correspond pas", 0, pokemon.getIndex());
        assertEquals("Le nom du Pokémon ne correspond pas", "Bulbizarre", pokemon.getName());
        assertEquals("Les CP du Pokémon ne correspondent pas", 613, pokemon.getCp());
        assertEquals("Les HP du Pokémon ne correspondent pas", 64, pokemon.getHp());
        assertEquals("La poussière d'étoile du Pokémon ne correspond pas", 4000, pokemon.getDust());
        assertEquals("Les bonbons du Pokémon ne correspondent pas", 4, pokemon.getCandy());
    }
}

