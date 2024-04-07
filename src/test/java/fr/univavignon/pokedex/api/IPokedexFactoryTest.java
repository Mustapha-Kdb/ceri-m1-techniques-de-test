package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class IPokedexFactoryTest {

    private IPokedexFactory pokedexFactory;
    private IPokemonMetadataProvider metadataProvider;

    @Before
    public void setUp() {
        // Initialisez ici la dépendance de PokemonMetadataProvider
        metadataProvider = new PokemonMetadataProvider();
        // Maintenant, passez metadataProvider comme argument à PokemonFactory
        pokedexFactory = new PokedexFactory();
    }

    @Test
    public void testCreatePokedex() {
        // Assurez-vous que PokedexFactory crée un Pokedex avec les dépendances nécessaires
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, new PokemonFactory(metadataProvider));
        assertNotNull("Le Pokedex ne doit pas être null", pokedex);
        assertEquals("Le Pokedex nouvellement créé doit être vide", 0, pokedex.size());

    }
}
