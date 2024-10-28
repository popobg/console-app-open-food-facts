package entites;

public class Allergene {
    private String libelle;

    public Allergene(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Allergene)) {
            return false;
        }

        Allergene autre = (Allergene)obj;
        return this.libelle.equals(autre.getLibelle());
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
