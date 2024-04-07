package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {
    private static final Map<Integer, PokemonMetadata> metadataMap = new HashMap<>();

    static {
        // Initialisation des métadonnées pour Bulbizarre et Aquali
        metadataMap.put(0, new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
        metadataMap.put(133, new PokemonMetadata(133, "Aquali", 186, 168, 260));
        // Exemple pour test
        metadataMap.put(4, new PokemonMetadata(4, "Charmander", 150, 100, 90));

    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (!metadataMap.containsKey(index)) {
            throw new PokedexException("Métadonnées non trouvées pour l'index: " + index);
        }
        return metadataMap.get(index);
    }
}
