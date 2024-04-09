package fr.univavignon.pokedex.api;

/**
 * Factory interface for class that create Pokedex instance.
 * This factory is responsible for the creation of Pokedex instance.
 */
public class PokedexFactory implements IPokedexFactory {

    /**
     * Create and return a new Pokedex instance.
     *
     * @param metadataProvider Pokemon metadata provider.
     * @param pokemonFactory Factory to create the pokemon of the pokedex.
     * @return The created Pokedex instance.
     */
    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        return new Pokedex(metadataProvider, pokemonFactory);
    }
}

