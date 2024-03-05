package fr.univavignon.pokedex.api;

import fr.univavignon.pokedex.api.IPokedex;
import fr.univavignon.pokedex.api.Pokemon;
import fr.univavignon.pokedex.api.PokemonMetadata;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class IPokedexTest {

    private IPokedex pokedex;
    private Pokemon bulbizarre;
    private Pokemon aquali;
    private Comparator<Pokemon> compareByIndex;
    private Comparator<Pokemon> compareByCp;
    private Comparator<Pokemon> compareByName;

    @Before
    public void setUp() throws Exception {

        pokedex = Mockito.mock(IPokedex.class);
        bulbizarre = new Pokemon(0, "Bulbizarre",126,126,90,  613, 64, 4000, 4, 56);
        aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);


        when(pokedex.size()).thenReturn(2);
        when(pokedex.addPokemon(bulbizarre)).thenReturn(0);
        when(pokedex.addPokemon(aquali)).thenReturn(1);
        when(pokedex.getPokemon(0)).thenReturn(bulbizarre);
        when(pokedex.getPokemon(1)).thenReturn(aquali);
        when(pokedex.getPokemons()).thenReturn(Arrays.asList(bulbizarre, aquali));

        compareByIndex = Comparator.comparingInt(Pokemon::getIndex);
        compareByCp = Comparator.comparingInt(Pokemon::getCp);
        compareByName = Comparator.comparing(Pokemon::getName);

        when(pokedex.getPokemons(compareByIndex)).thenReturn(Arrays.asList(bulbizarre, aquali));
        when(pokedex.getPokemons(compareByCp)).thenReturn(Arrays.asList(aquali, bulbizarre));
        when(pokedex.getPokemons(compareByName)).thenReturn(Arrays.asList(aquali, bulbizarre));


    }

    @Test
    public void testAddPokemon() {
        assertEquals("Ajout de Bulbizarre devrait retourner l'index 0", 0, pokedex.addPokemon(bulbizarre));
        assertEquals("Ajout d'Aquali devrait retourner l'index 1", 1, pokedex.addPokemon(aquali));
    }

    @Test
    public void testSize() {
        assertEquals("La taille du Pokédex devrait être 2", 2, pokedex.size());
    }

    @Test
    public void testGetPokemon() throws Exception {
        assertEquals("Récupération de Bulbizarre par son index devrait fonctionner", bulbizarre, pokedex.getPokemon(0));
        assertEquals("Récupération d'Aquali par son index devrait fonctionner", aquali, pokedex.getPokemon(1));
    }

    @Test
    public void testGetPokemons() {
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals("Le Pokédex devrait contenir exactement 2 Pokémon", 2, pokemons.size());
        assertEquals("Le premier Pokémon devrait être Bulbizarre", bulbizarre, pokemons.get(0));
        assertEquals("Le deuxième Pokémon devrait être Aquali", aquali, pokemons.get(1));
    }


    @Test
    public void testGetPokemonsWithComparators() {
        // Test par index
        List<Pokemon> pokemonsByIndex = pokedex.getPokemons(compareByIndex);
        assertEquals("Les Pokémons devraient être triés par index", Arrays.asList(bulbizarre, aquali), pokemonsByIndex);

        // Test par CP
        List<Pokemon> pokemonsByCp = pokedex.getPokemons(compareByCp);
        assertEquals("Les Pokémons devraient être triés par CP", Arrays.asList(aquali, bulbizarre), pokemonsByCp);

        // Test par nom
        List<Pokemon> pokemonsByName = pokedex.getPokemons(compareByName);
        assertEquals("Les Pokémons devraient être triés par nom", Arrays.asList(aquali, bulbizarre), pokemonsByName);
    }
}

