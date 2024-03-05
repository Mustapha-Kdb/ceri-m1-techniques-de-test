package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class IPokemonTrainerFactoryTest {

    private IPokemonTrainerFactory pokemonTrainerFactory;
    private IPokedexFactory pokedexFactory;

    @Before
    public void setUp() {
        pokemonTrainerFactory = mock(IPokemonTrainerFactory.class);
        pokedexFactory = mock(IPokedexFactory.class);
    }

    @Test
    public void createPokemonTrainerTest() {

        String trainerName = "Mustapha";
        Team team = Team.VALOR;
        IPokedex pokedex = Mockito.mock(IPokedex.class);

        when(pokemonTrainerFactory.createTrainer(trainerName, team, pokedexFactory)).thenReturn(new PokemonTrainer(trainerName, team, pokedex));

        PokemonTrainer trainer = pokemonTrainerFactory.createTrainer(trainerName, team, pokedexFactory);

        assertNotNull("Le trainer créé est null", trainer);
        assertEquals("Le nom du dresseur ne correspond pas", trainerName, trainer.getName());
        assertEquals("L'équipe du dresseur ne correspond pas", team, trainer.getTeam());
        assertEquals("L'IPokedex du dresseur ne correspond pas", pokedex, trainer.getPokedex());
    }
}

