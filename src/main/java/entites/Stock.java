package entites;

import java.util.List;

public class Stock {
    private List<Produit> produits;

    public Stock(List<Produit> produits) {
        this.produits = produits;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Stock)) {
            return false;
        }

        Stock autre = (Stock)obj;

        return this.produits.equals(autre.getProduits());
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }
}
