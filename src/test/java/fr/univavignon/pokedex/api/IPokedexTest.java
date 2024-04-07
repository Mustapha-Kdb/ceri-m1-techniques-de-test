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
        metadataProvider = new PokemonMetadataProvider(); // Assurez-vous que cela renvoie des données réalistes pour les tests
        pokemonFactory = new PokemonFactory(metadataProvider);
        pokedex = new Pokedex(metadataProvider, pokemonFactory);

        // Création et ajout de Pokémon pour les besoins des tests
        Pokemon bulbasaur = pokemonFactory.createPokemon(0, 613, 64, 4000, 4); // Bulbasaur
        Pokemon aquali = pokemonFactory.createPokemon(133, 2729, 202, 5000, 4); // Ivysaur, exemple
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
    public void testGetPokemonsWithOrder() {
        List<Pokemon> pokemonsByCp = pokedex.getPokemons(Comparator.comparingInt(Pokemon::getCp));
        assertTrue("Les Pokémon doivent être triés par CP dans l'ordre croissant",
                pokemonsByCp.get(0).getCp() <= pokemonsByCp.get(1).getCp());
        List<Pokemon> pokemonsByName = pokedex.getPokemons(Comparator.comparing(Pokemon::getName));
        assertTrue("Les Pokémon doivent être triés par nom dans l'ordre alphabétique",
                pokemonsByName.get(0).getName().compareTo(pokemonsByName.get(1).getName()) <= 0);
        List<Pokemon> pokemonsByIndex = pokedex.getPokemons(Comparator.comparingInt(Pokemon::getIndex));
        assertTrue("Les Pokémon doivent être triés par index dans l'ordre croissant",
                pokemonsByIndex.get(0).getIndex() <= pokemonsByIndex.get(1).getIndex());

    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonWithInvalidId() throws PokedexException {
        pokedex.getPokemon(10); // ID invalide, doit lancer une PokedexException
    }
}


