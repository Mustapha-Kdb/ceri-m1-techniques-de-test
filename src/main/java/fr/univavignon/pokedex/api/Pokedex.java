package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Pokedex API interface.
 * This interface represents the pokedex, it is responsible for the management of the pokemons.
 * The pokedex is a collection of pokemons.
 * The pokedex is responsible for the management of the pokemons.
 */
public class Pokedex implements IPokedex {
    /** List of pokemons. **/
    private final List<Pokemon> pokemonList = new ArrayList<>();
    /** Pokemon metadata provider. **/
    private final IPokemonMetadataProvider metadataProvider;
    /** Pokemon factory. **/
    private final IPokemonFactory pokemonFactory;

    /**
     * Constructor.
     *
     * @param metadataProvider Pokemon metadata provider.
     * @param pokemonFactory Factory to create the pokemon of the pokedex.
     */
    public Pokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        this.metadataProvider = metadataProvider;
        this.pokemonFactory = pokemonFactory;
    }

    /**
     * Get the metadata of the pokemon at the given index.
     *
     * @param index Index of the pokemon.
     * @return The metadata of the pokemon at the given index.
     * @throws PokedexException If the index is invalid.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return metadataProvider.getPokemonMetadata(index);
    }

    /**
     * Create and return a new Pokemon instance.
     *
     * @param index Index of the Pokemon.
     * @param cp CP of the Pokemon.
     * @param hp HP of the Pokemon.
     * @param dust Dust of the Pokemon.
     * @param candy Candy of the Pokemon.
     * @return The created Pokemon instance.
     */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }

    /**
     * Add a pokemon to the pokedex.
     *
     * @param pokemon Pokemon to add.
     * @return The index of the added pokemon.
     */
    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemonList.add(pokemon);
        return pokemonList.size() - 1;
    }

    /**
     * Get the pokemon at the given index.
     *
     * @param id Index of the pokemon.
     * @return The pokemon at the given index.
     * @throws PokedexException If the index is invalid.
     */
    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        if (id < 0 || id >= pokemonList.size()) {
            throw new PokedexException("Index de Pokémon invalide : " + id);
        }
        return pokemonList.get(id);
    }

    /**
     * Get all the pokemons in the pokedex.
     *
     * @return The list of all the pokemons in the pokedex.
     */
    @Override
    public List<Pokemon> getPokemons() {
        return new ArrayList<>(pokemonList);
    }

    /**
     * Get all the pokemons in the pokedex sorted by the given order.
     *
     * @param order Comparator to sort the pokemons.
     * @return The list of all the pokemons in the pokedex sorted by the given order.
     */
    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        return pokemonList.stream().sorted(order).collect(Collectors.toList());
    }

    /**
     * Get the number of pokemons in the pokedex.
     *
     * @return The number of pokemons in the pokedex.
     */
    @Override
    public int size() {
        return pokemonList.size();
    }
}





