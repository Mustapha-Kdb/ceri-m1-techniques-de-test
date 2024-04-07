package fr.univavignon.pokedex.api;

public class PokemonTrainerFactory implements IPokemonTrainerFactory {

    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        // Crée un Pokedex pour le nouvel entraîneur
        IPokedex pokedex = pokedexFactory.createPokedex(new PokemonMetadataProvider(), new PokemonFactory(new PokemonMetadataProvider()));

        // Retourne une nouvelle instance de PokemonTrainer avec le Pokedex créé
        return new PokemonTrainer(name, team, pokedex);
    }
}
