package entites;

import java.util.HashMap;
import java.util.List;

public class Produit {
    private final Categorie categorie;
    private Marque marque;
    private String nom;
    private String scoreNutritionnel;
    private HashMap<String, Double> valeursEnergetiques100g;
    private Boolean presenceHuilePalme;
    private List<Ingredient> ingredients;
    private List<Allergene> allergenes;
    private List<Additif> additifs;

    public Produit(String nom, Marque marque, Categorie categorie, List<Allergene> allergenes, List<Additif> additifs, List<Ingredient> ingredients, String scoreNutritionnel, HashMap<String, Double> valeursEnergetiques100g, Boolean presenceHuilePalme) {
        this.nom = nom;
        this.marque = marque;
        this.categorie = categorie;
        this.allergenes = allergenes;
        this.additifs = additifs;
        this.ingredients = ingredients;
        this.scoreNutritionnel = scoreNutritionnel;
        this.valeursEnergetiques100g = valeursEnergetiques100g;
        this.presenceHuilePalme = presenceHuilePalme;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Produit)) {
            return false;
        }

        Produit autre = (Produit)obj;

        if (!(this.categorie.equals(autre.getCategorie())
                && this.marque.equals(autre.getMarque())
                && this.nom.equals(autre.getNom())
                && this.scoreNutritionnel.equals(autre.getScoreNutritionnel())
                && this.presenceHuilePalme.equals(autre.getPresenceHuilePalme())
                && this.valeursEnergetiques100g.equals(autre.getValeursEnergetiques100g()))) {
            return false;
        }

        // Vérifie que les listes sont identiques, quel que soit leur ordre
        if (!(this.additifs.containsAll(autre.getAdditifs()) && autre.getAdditifs().containsAll(this.additifs))) {
            return false;
        }

        if (!(this.allergenes.containsAll(autre.getAllergenes()) && autre.getAllergenes().containsAll(this.allergenes))) {
            return false;
        }

        if (!(this.ingredients.containsAll(autre.getIngredients()) && autre.getIngredients().containsAll(this.ingredients))) {
            return false;
        }

        return true;
    }

    public List<Additif> getAdditifs() {
        return additifs;
    }

    public List<Allergene> getAllergenes() {
        return allergenes;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public Marque getMarque() {
        return marque;
    }

    public String getNom() {
        return nom;
    }

    public Boolean getPresenceHuilePalme() {
        return presenceHuilePalme;
    }

    public String getScoreNutritionnel() {
        return scoreNutritionnel;
    }

    public HashMap<String, Double> getValeursEnergetiques100g() {
        return valeursEnergetiques100g;
    }

    public void setAdditifs(List<Additif> additifs) {
        this.additifs = additifs;
    }

    public void setAllergenes(List<Allergene> allergenes) {
        this.allergenes = allergenes;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPresenceHuilePalme(Boolean presenceHuilePalme) {
        this.presenceHuilePalme = presenceHuilePalme;
    }

    public void setScoreNutritionnel(String scoreNutritionnel) {
        this.scoreNutritionnel = scoreNutritionnel;
    }

    public void setValeursEnergetiques100g(HashMap<String, Double> valeursEnergetiques100g) {
        this.valeursEnergetiques100g = valeursEnergetiques100g;
    }
}
