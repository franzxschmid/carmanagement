package de.gfn.carmanagement.entity;

//Mutterklasse beschreibt eine abstrakte Entität
public abstract class AbstractEntity {
    
    protected int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
