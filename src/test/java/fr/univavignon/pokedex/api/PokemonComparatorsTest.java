package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Comparator;

import static org.junit.Assert.assertTrue;

public class PokemonComparatorsTest {

    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private Comparator<Pokemon> nameComparator;
    private Comparator<Pokemon> indexComparator;
    private Comparator<Pokemon> cpComparator;

    @Before
    public void setUp() {
        pokemon1 = Mockito.mock(Pokemon.class);
        pokemon2 = Mockito.mock(Pokemon.class);

        Mockito.when(pokemon1.getName()).thenReturn("Bulbizarre");
        Mockito.when(pokemon2.getName()).thenReturn("Aquali");

        Mockito.when(pokemon1.getIndex()).thenReturn(0);
        Mockito.when(pokemon2.getIndex()).thenReturn(133);

        Mockito.when(pokemon1.getCp()).thenReturn(613);
        Mockito.when(pokemon2.getCp()).thenReturn(2729);

        nameComparator = PokemonComparators.NAME;
        indexComparator = PokemonComparators.INDEX;
        cpComparator = PokemonComparators.CP;
    }

    @Test
    public void testCompareByName() {
        assertTrue("Aquali est suposé etre avant Bulbizarre", nameComparator.compare(pokemon1, pokemon2) > 0);
    }

    @Test
    public void testCompareByIndex() {
        assertTrue("Pokemon d'index 0 est suposé etre avant index 133", indexComparator.compare(pokemon1, pokemon2) < 0);
    }

    @Test
    public void testCompareByCp() {
        assertTrue("Aquali avec plus grand CP est suposé avant Bulbizarre", cpComparator.compare(pokemon1, pokemon2) < 0);
    }
}