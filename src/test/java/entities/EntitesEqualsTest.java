package entities;

import entites.*;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Classe test vérifiant le comportement des méthodes customisées
 * "equals" implémentées dans les classes du package entites.
 */
public class EntitesEqualsTest {
    // Attributs de classe
    Additif additif1 = new Additif("Additif identique");
    Additif additif2 = new Additif("Additif identique");
    Additif additif3 = new Additif("Additif différent");

    Allergene allergene1 = new Allergene("Allergène identique");
    Allergene allergene2 = new Allergene("Allergène identique");
    Allergene allergene3 = new Allergene("Allergène différent");

    Categorie categorie1 = new Categorie("Categorie identique");
    Categorie categorie2 = new Categorie("Categorie identique");
    Categorie categorie3 = new Categorie("Categorie différent");

    Ingredient ingredient1 = new Ingredient("Ingredient identique");
    Ingredient ingredient2 = new Ingredient("Ingredient identique");
    Ingredient ingredient3 = new Ingredient("Ingredient différent");

    Marque marque1 = new Marque("Marque identique");
    Marque marque2 = new Marque("Marque identique");
    Marque marque3 = new Marque("Marque différente");

    ArrayList<Additif> additifs1 = new ArrayList<>(Arrays.asList(additif1, additif3));
    ArrayList<Additif> additifs2 = new ArrayList<>(Arrays.asList(additif3, additif1));
    ArrayList<Additif> additifs3 = new ArrayList<>(List.of(additif2));

    ArrayList<Allergene> allergenes1 = new ArrayList<>(List.of(allergene1));
    ArrayList<Allergene> allergenes3 = new ArrayList<>(List.of(allergene2));

    ArrayList<Ingredient> ingredients1 = new ArrayList<>(List.of(ingredient1));
    ArrayList<Ingredient> ingredients3 = new ArrayList<>(Arrays.asList(ingredient2, ingredient3));

    // double brace initialization: worse performance than adding one by one
    // but it saves us some space and time here because it allow us to have our
    // HashMap already filled with data.
    HashMap<String, Double> valeursNRJ1 = new HashMap<>() {{
        put("NRJ", 2.3);
    }};
    HashMap<String, Double> valeursNRJ2 = new HashMap<>() {{
        put("NRJ", 2.3);
    }};
    HashMap<String, Double> valeursNRJ3 = new HashMap<>() {{
        put("NRJ", 2.3);
        put("NRJ2", 4.81);
    }};

    Produit produit1 = new Produit("produit", marque1, categorie1, allergenes1, additifs1, ingredients1, "A", valeursNRJ1, false);
    Produit produit2 = new Produit("produit", marque2, categorie2, allergenes1, additifs2, ingredients1, "A", valeursNRJ2, false);
    Produit produit3 = new Produit("produit", marque1, categorie1, allergenes3, additifs3, ingredients3, "A", valeursNRJ1, false);
    Produit produit4 = new Produit("produit", marque1, categorie1, allergenes1, additifs1, ingredients1, "A", valeursNRJ3, false);

    @Test
    void testEqualsAdditif() {
        // ACT
        boolean itemsIdentiques = additif1.equals(additif2);
        boolean itemsDifferents = additif2.equals(additif3);

        //ASSERT
        assertTrue(itemsIdentiques);
        assertFalse(itemsDifferents);
    }

    @Test
    void testEqualsAllergene() {
        // ARRANGE
        Allergene allergene4 = new Allergene("allergène différent");

        // ACT
        boolean itemsIdentiques = allergene1.equals(allergene2);
        boolean itemsDifferents = allergene1.equals(allergene3);
        // casse différente
        boolean itemsDifferents2 = allergene3.equals(allergene4);

        //ASSERT
        assertTrue(itemsIdentiques);
        assertFalse(itemsDifferents);
        assertFalse(itemsDifferents2);
    }

    @Test
    void testEqualsCategorie() {
        // ACT
        boolean itemsIdentiques = categorie1.equals(categorie2);
        boolean itemsDifferents = categorie1.equals(categorie3);

        //ASSERT
        assertTrue(itemsIdentiques);
        assertFalse(itemsDifferents);
    }

    @Test
    void testEqualsIngredient() {
        // ACT
        boolean itemsIdentiques = ingredient1.equals(ingredient2);
        boolean itemsDifferents = ingredient1.equals(ingredient3);

        //ASSERT
        assertTrue(itemsIdentiques);
        assertFalse(itemsDifferents);
    }

    @Test
    void testEqualsMarque() {
        // ACT
        boolean itemsIdentiques = marque1.equals(marque2);
        boolean itemsDifferents = marque1.equals(marque3);

        //ASSERT
        assertTrue(itemsIdentiques);
        assertFalse(itemsDifferents);
    }

    @Test
    void testEqualsProduit() {
        // Fonctionne même si les listes ne sont pas dans le même ordre grâce
        // grâce à l'implémentation customisée de la méthode equals de Produit.
        boolean itemsIdentiques = produit1.equals(produit2);
        boolean itemsDifferents1 = produit1.equals(produit3);
        boolean itemsDifferents2 = produit1.equals(produit4);

        assertTrue(itemsIdentiques);
        assertFalse(itemsDifferents1);
        assertFalse(itemsDifferents2);
    }

    @Test
    void testEqualsStock() {
        // ARRANGE
        Stock stock1 = new Stock(Arrays.asList(produit1, produit2));
        Stock stock2 = new Stock(Arrays.asList(produit2, produit1));
        Stock stock3 = new Stock(Collections.singletonList(produit1));

        // ACT
        boolean itemsIdentiques = stock1.equals(stock2);
        boolean itemsDifferents = stock2.equals(stock3);

        //ASSERT
        assertTrue(itemsIdentiques);
        assertFalse(itemsDifferents);
    }

}
