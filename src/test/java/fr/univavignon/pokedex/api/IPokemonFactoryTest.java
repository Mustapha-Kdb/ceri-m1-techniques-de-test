package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

public class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() throws Exception {
        pokemonFactory = Mockito.mock(IPokemonFactory.class);
    }

    @Test
    public void createPokemonTest() {
        // Example1
        int index = 0;
        String name = "Bulbizarre";
        int attack = 126;
        int defense = 126;
        int stamina = 90;
        int cp = 613;
        int hp = 64;
        int dust = 4000;
        int candy = 4;
        double iv = 56.0;

        Pokemon expectedPokemon = new Pokemon(index, name, attack,defense, stamina, cp, hp, dust, candy, iv);

        when(pokemonFactory.createPokemon(index, cp, hp, dust, candy)).thenReturn(expectedPokemon);

        Pokemon createdPokemon = pokemonFactory.createPokemon(index, cp, hp, dust, candy);

        assertNotNull("Le Pokémon créé est null", createdPokemon);
        assertEquals("Le nom du Pokémon ne correspond pas", expectedPokemon.getName(), createdPokemon.getName());
        assertEquals("Les CP du Pokémon ne correspondent pas", expectedPokemon.getCp(), createdPokemon.getCp());
        assertEquals("Les HP du Pokémon ne correspondent pas", expectedPokemon.getHp(), createdPokemon.getHp());
        assertEquals("La poussière d'étoile du Pokémon ne correspond pas", expectedPokemon.getDust(), createdPokemon.getDust());
        assertEquals("Les bonbons du Pokémon ne correspondent pas", expectedPokemon.getCandy(), createdPokemon.getCandy());
        assertEquals("L'IV du Pokémon ne correspond pas", expectedPokemon.getIv(), createdPokemon.getIv(), 0.001);
    }
}

