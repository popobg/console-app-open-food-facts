package entites;

public class Ingredient {
    private String libelle;

    public Ingredient(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Ingredient)) {
            return false;
        }

        Ingredient autre = (Ingredient)obj;

        return this.libelle.equals(autre.getLibelle());
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
