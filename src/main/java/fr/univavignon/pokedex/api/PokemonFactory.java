package fr.univavignon.pokedex.api;

// add comments
/**
 * Factory interface for class that aims to create Pokemon instance.
 * This factory is used to decouple the Pokemon creation from the rest of the code.
 * It allows to create Pokemon instances without knowing the concrete implementation of the Pokemon class.
 * The PokemonFactory class implements this interface.
 *
 * @see Pokemon
 * @see IPokemonMetadataProvider
 * @see PokemonMetadata
 * @see PokedexException
 */
public class PokemonFactory implements IPokemonFactory {
    /**
     * Pokemon metadata provider.
     */
    private IPokemonMetadataProvider metadataProvider;

    /**
     * Constructor.
     *
     * @param metadataProvider Pokemon metadata provider.
     */
    public PokemonFactory(IPokemonMetadataProvider metadataProvider) {
        this.metadataProvider = metadataProvider;
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
        PokemonMetadata metadata = null;
        try {
            metadata = metadataProvider.getPokemonMetadata(index);
        } catch (PokedexException e) {
            e.printStackTrace();
        }
        double iv = (cp + hp + dust + candy) / metadata.getAttack() + metadata.getDefense() + metadata.getStamina();
        return new Pokemon(index, metadata.getName(), metadata.getAttack(), metadata.getDefense(), metadata.getStamina(), cp, hp, dust, candy, iv);
    }
}


