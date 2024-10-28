package tools;

import entites.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataParserTest {
    ArrayList<String> lignes = new ArrayList(Arrays.asList(
            "categorie|marque|nom|nutritionGradeFr|ingredients|energie100g|graisse100g|sucres100g|fibres100g|proteines100g|sel100g|vitA100g|vitD100g|vitE100g|vitK100g|vitC100g|vitB1100g|vitB2100g|vitPP100g|vitB6100g|vitB9100g|vitB12100g|calcium100g|magnesium100g|iron100g|fer100g|betaCarotene100g|presenceHuilePalme|allergenes|additifs|",
            "Additifs alimentaires|La Droguerie Écologique|Bicarbonate Soude Alimentaire|b|Bicarbonate de sodium : 99 % minimum.|0|0|0||0|0|||||||||||||||||0||E500 - Carbonates de sodium,E500ii - Carbonate acide de sodium|",
            "Plats préparés à la viande|La Cuisine d'Océane|Veau de l'Aveyron et du Segala au Marengo|b|Pommes de terre 22 %, veau de l'Aveyron et du Ségala Label Rouge IGP 22 %, eau,_champignons_, épaississants : gomme xanthane et gomme guar, poivre.|356|4.3|2.3||5.6|0.7|||||||||||||||||0||E14XX - Amidons modifiés,E270 - Acide lactique,E412 - Gomme de guar|",
            "Surgelés|Carrefour|Cake Jambon, Emmental, Olives vertes et noires|c|_Oeufs_ frais, jambon cuit supérieur 15%, sel, dextrose, oignons frits, sucre, extrait de levure, antioxydant : ascorbate de sodium, conservateur : nitrite de sodium), farine de _blé_, _lait_ frais, _emmental_ 12%, huile d'olive vierge extra, olives vertes dénoyautées 5.4%, olives noires confites en rondelle 5.4%, poudre à lever : diphosphate disodique et carbonate acide de sodium, amidon de _blé_, ciboulette, extrait de poivre|1185|20|1.6|1.3|13|1|||||||||||||||||0||Oeufs, céleri, blé, lait, emmental, blé|E250 - Nitrite de sodium,E301 - Ascorbate de sodium,E330 - Acide citrique,E450 - Sels métalliques de diphosphates,E450i - Pyrophosphate de sodium acide,E500 - Carbonates de sodium,E500ii - Carbonate acide de sodium|"));

    @Test
    void testParseData() {
        // ARRANGE
        HashMap<String, Double> valeursNutriProduit1 = new HashMap<>() {{
            put("energie100g", 0.0);
            put("graisse100g", 0.0);
            put("sucres100g", 0.0);
            put("fibres100g", null);
            put("proteines100g", 0.0);
            put("sel100g", 0.0);
            put("vitA100g", null);
            put("vitD100g", null);
            put("vitE100g", null);
            put("vitK100g", null);
            put("vitC100g", null);
            put("vitB1100g", null);
            put("vitB2100g", null);
            put("vitPP100g", null);
            put("vitB6100g", null);
            put("vitB9100g", null);
            put("vitB12100g", null);
            put("calcium100g", null);
            put("magnesium100g", null);
            put("iron100g", null);
            put("fer100g", null);
            put("betaCarotene100g", null);
        }};

        HashMap<String, Double> valeursNutriProduit2 = new HashMap<>() {{
            put("energie100g", 356.0);
            put("graisse100g", 4.3);
            put("sucres100g", 2.3);
            put("fibres100g", null);
            put("proteines100g", 5.6);
            put("sel100g", 0.7);
            put("vitA100g", null);
            put("vitD100g", null);
            put("vitE100g", null);
            put("vitK100g", null);
            put("vitC100g", null);
            put("vitB1100g", null);
            put("vitB2100g", null);
            put("vitPP100g", null);
            put("vitB6100g", null);
            put("vitB9100g", null);
            put("vitB12100g", null);
            put("calcium100g", null);
            put("magnesium100g", null);
            put("iron100g", null);
            put("fer100g", null);
            put("betaCarotene100g", null);
        }};

        Produit produit1 = new Produit(
                "Bicarbonate Soude Alimentaire",
                new Marque("la droguerie écologique"),
                new Categorie("additifs alimentaires"),
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new Additif("e500 - carbonates de sodium"), new Additif("e500ii - carbonate acide de sodium"))),
                new ArrayList<>(List.of(new Ingredient("Bicarbonate de sodium : 99 % minimum"))),
                "B",
                valeursNutriProduit1,
                false
        );

        Produit produit2 = new Produit(
                "Veau de l'Aveyron et du Segala au Marengo",
                new Marque("la cuisine d'océane"),
                new Categorie("plats préparés à la viande"),
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new Additif("e14xx - amidons modifiés"), new Additif("e270 - acide lactique"), new Additif("e412 - gomme de guar"))),
                new ArrayList<>(Arrays.asList(new Ingredient("Pommes de terre 22 %"), new Ingredient("veau de l'Aveyron et du Ségala Label Rouge IGP 22 %"), new Ingredient("eau"), new Ingredient("champignons"), new Ingredient("épaississants : gomme xanthane et gomme guar"), new Ingredient("poivre"))),
                "B",
                valeursNutriProduit2,
                false
        );

        Stock expected = new Stock(new ArrayList<>(Arrays.asList(produit1, produit2)));
        DataParser dataParser = new DataParser();

        // ACT
        Stock actual = dataParser.parseData(lignes);

        // ASSERT
        assertEquals(expected, actual);
    }
}