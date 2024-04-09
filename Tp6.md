### Raport de l'Implémentation de RocketPokemonFactory

1. **Statistiques Fixes pour "Ash's Pikachu"**
    - *L'attribution de statistiques fixes à "Ash's Pikachu" risque de déséquilibrer le jeu.*

2. **Génération Aléatoire de Statistiques**
    - *La génération aléatoire de statistiques pour les Pokémon peut entraîner une grande variabilité de puissance, déséquilibrant le jeu.*

3. **Absence d'Utilisation des Métadonnées**
    - *`RocketPokemonFactory` n'utilise pas `metadataProvider` pour définir les statistiques des Pokémon.*

4. **Gestion des Indices Inconnus**
    - *Le traitement des indices inconnus en retournant "MISSINGNO" peut introduire des incohérences ou des erreurs dans l'application.*

5. **Calcul de IV**
    - *fixation arbitraire des IV à 1 (sauf pour "Ash's Pikachu").*
