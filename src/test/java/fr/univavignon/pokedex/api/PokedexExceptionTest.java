package fr.univavignon.pokedex.api;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokedexExceptionTest {

    @Test
    public void testExceptionMessage() {
        String expectedMessage = "Pas de pokedex aujourd'hui !";
        PokedexException exception = new PokedexException(expectedMessage);
        assertEquals(expectedMessage, exception.getMessage());
    }

}
