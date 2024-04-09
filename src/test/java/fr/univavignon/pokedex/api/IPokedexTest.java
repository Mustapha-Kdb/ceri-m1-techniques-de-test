package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import java.util.Comparator;
import java.util.List;
import static org.junit.Assert.*;

public class IPokedexTest {

    private IPokedex pokedex;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        metadataProvider = new PokemonMetadataProvider();
        pokemonFactory = new PokemonFactory(metadataProvider);
        pokedex = new Pokedex(metadataProvider, pokemonFactory);

        Pokemon bulbasaur = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        Pokemon aquali = pokemonFactory.createPokemon(133, 2729, 202, 5000, 4);
        pokedex.addPokemon(bulbasaur);
        pokedex.addPokemon(aquali);
    }

    @Test
    public void testAddPokemon() {
        Pokemon charmander = pokemonFactory.createPokemon(4, 829, 78, 5000, 4); // Charmander, exemple
        pokedex.addPokemon(charmander);
        assertEquals("Le Pokédex doit augmenter de taille après l'ajout d'un Pokémon", 3, pokedex.size());

    }

    @Test
    public void testGetPokemon() throws PokedexException {
        Pokemon pokemon = pokedex.getPokemon(0); // Récupérer Bulbasaur ajouté dans setUp()
        assertNotNull("Le Pokémon récupéré ne doit pas être null", pokemon);
        assertEquals("Le Pokémon récupéré doit avoir l'index 0", 0, pokemon.getIndex());
        assertEquals("Le Pokémon récupéré doit avoir le nom 'Bulbizarre'", "Bulbizarre", pokemon.getName());
    }

    @Test
    public void testSize() {
        assertEquals("Le Pokédex doit contenir 2 Pokémon", 2, pokedex.size());
    }

    @Test
    public void testGetPokemons() {
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals("Le Pokédex doit retourner tous les Pokémon", 2, pokemons.size());
    }

    @Test
    public void testSortPokemonsByName() {
        List<Pokemon> sortedByName = pokedex.getPokemons(PokemonComparators.NAME);
        assertTrue("Les Pokémon devraient être triés par nom", sortedByName.get(0).getIndex() == 133);
    }

    @Test
    public void testSortPokemonsByCp() {
        List<Pokemon> sortedByCp = pokedex.getPokemons(PokemonComparators.CP);
        assertTrue("Les Pokémon devraient être triés par CP", sortedByCp.get(0).getCp() <= sortedByCp.get(1).getCp());
    }

    @Test
    public void testSortPokemonsByIndex() {
        List<Pokemon> sortedByIndex = pokedex.getPokemons(PokemonComparators.INDEX);
        assertTrue("Les Pokémon devraient être triés par index", sortedByIndex.get(0).getIndex() < sortedByIndex.get(1).getIndex());
    }

    @Test
    public void testCreatePokemon() {
        int index = 0;
        int cp = 613;
        int hp = 64;
        int dust =  4000;
        int candy = 4;
        Pokemon createdPokemon = pokedex.createPokemon(index, cp, hp, dust, candy);

        assertNotNull("Le Pokémon créé ne doit pas être null", createdPokemon);
        assertEquals("L'index du Pokémon créé doit correspondre", index, createdPokemon.getIndex());
    }

    @Test
    public void testGetPokemonMetadataValidIndex() throws PokedexException {
        int index = 0;
        PokemonMetadata metadata = pokedex.getPokemonMetadata(index);

        assertNotNull("Les métadonnées du Pokémon ne doivent pas être null", metadata);
        assertEquals("L'index des métadonnées doit correspondre", index, metadata.getIndex());
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonMetadataInvalidIndex() throws PokedexException {
        int invalidIndex = 10000;
        pokedex.getPokemonMetadata(invalidIndex);
    }


    @Test(expected = PokedexException.class)
    public void testGetPokemonWithInvalidId() throws PokedexException {
        pokedex.getPokemon(10); // ID invalide, doit lancer une PokedexException
    }
}


