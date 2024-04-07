package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IPokemonTrainerFactoryTest {

    private IPokemonTrainerFactory trainerFactory;

    @Before
    public void setUp() {
        trainerFactory = new PokemonTrainerFactory();
    }

    @Test
    public void testCreateTrainer() {
        PokemonTrainer trainer = trainerFactory.createTrainer("Mustapha", Team.MYSTIC, new PokedexFactory());
        assertNotNull("Le dresseur de Pokémon ne doit pas être null", trainer);
        assertEquals("Le nom du dresseur ne correspond pas", "Mustapha", trainer.getName());
        assertEquals("L'équipe du dresseur ne correspond pas", Team.MYSTIC, trainer.getTeam());
    }
}

