package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest {

    IPokemonMetadataProvider pokemonMetadataProvider;

    @Before
    public void setUp() throws PokedexException {
        pokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
    }

    @Test
    public void getPokemonMetadataTest() throws PokedexException {

        int index = 0;
        String name = "Bulbizarre";
        int attack = 126;
        int defense = 126;
        int stamina = 90;

        PokemonMetadata expectedMetadata = new PokemonMetadata(index, name, attack, defense, stamina);

        when(pokemonMetadataProvider.getPokemonMetadata(index)).thenReturn(expectedMetadata);

        PokemonMetadata metadata = pokemonMetadataProvider.getPokemonMetadata(index);

        assertEquals("L'index du Pokémon ne correspond pas", expectedMetadata.getIndex(), metadata.getIndex());
        assertEquals("Le nom du Pokémon ne correspond pas", expectedMetadata.getName(), metadata.getName());
        assertEquals("L'attaque du Pokémon ne correspond pas", expectedMetadata.getAttack(), metadata.getAttack());
        assertEquals("La défense du Pokémon ne correspond pas", expectedMetadata.getDefense(), metadata.getDefense());
        assertEquals("La stamina du Pokémon ne correspond pas", expectedMetadata.getStamina(), metadata.getStamina());
    }
}
