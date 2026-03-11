package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    /**
     * Constructeur de la classe Item
     * @param name nom de l'item
     * @param sellIn nombre de jours restants avant la fin de la vente
     * @param quality qualite de l'item
     */
    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    /**
     * Méthode toString pour afficher l'item
     * @return chaine de caractere representant l'item
     */
   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
