package fr.univavignon.pokedex.api;

public class PokedexFactory implements IPokedexFactory {

    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        // Retourne une nouvelle instance de Pokedex en utilisant les fournisseurs de métadonnées et de Pokemon
        return new Pokedex(metadataProvider, pokemonFactory);
    }
}

