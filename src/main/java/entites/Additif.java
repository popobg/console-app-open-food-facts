package entites;

public class Additif {
    private String libelle;

    public Additif(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Additif)) {
            return false;
        }

        Additif autre = (Additif)obj;
        return this.libelle.equals(autre.getLibelle());
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
