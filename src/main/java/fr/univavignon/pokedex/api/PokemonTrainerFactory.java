package fr.univavignon.pokedex.api;

/**
 * Factory interface for class that create PokemonTrainer instance.
 *
 * This factory is responsible for the creation of PokemonTrainer instance.
 *
 * @see PokemonTrainer
 * @see Team
 * @see IPokedexFactory
 * @see IPokemonTrainerFactory
 * @see IPokemonMetadataProvider
 * @see IPokemonFactory
 * @see IPokedex
 * @see PokemonMetadataProvider
 */
public class PokemonTrainerFactory implements IPokemonTrainerFactory {

    /**
     * Create and return a new PokemonTrainer instance.
     *
     * @param name Name of the trainer.
     * @param team Team of the trainer.
     * @param pokedexFactory Factory to create the pokedex of the trainer.
     * @return The created PokemonTrainer instance.
     */
    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        IPokedex pokedex = pokedexFactory.createPokedex(new PokemonMetadataProvider(), new PokemonFactory(new PokemonMetadataProvider()));
        return new PokemonTrainer(name, team, pokedex);
    }
}
