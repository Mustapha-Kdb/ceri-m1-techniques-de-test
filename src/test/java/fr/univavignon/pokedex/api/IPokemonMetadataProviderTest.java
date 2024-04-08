package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IPokemonMetadataProviderTest {

    private IPokemonMetadataProvider metadataProvider;

    @Before
    public void setUp() {
        metadataProvider = new PokemonMetadataProvider();
    }
    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        PokemonMetadata metadata = metadataProvider.getPokemonMetadata(0);
        assertNotNull("Les métadonnées du Pokémon ne doivent pas être null", metadata);
        assertEquals("L'index du Pokémon ne correspond pas", 0, metadata.getIndex());
        assertEquals("Le nom du Pokémon ne correspond pas", "Bulbizarre", metadata.getName());
        assertEquals("Les attaques du Pokémon ne correspondent pas", 126, metadata.getAttack());
        assertEquals("La défense du Pokémon ne correspond pas", 126, metadata.getDefense());
        assertEquals("L'endurance du Pokémon ne correspond pas", 90, metadata.getStamina());
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonMetadataInvalidIndex() throws PokedexException {
        metadataProvider.getPokemonMetadata(47);
    }
}
