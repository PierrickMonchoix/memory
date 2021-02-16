package com.pierrickmonchoix.memoryserver.business;

/**
 * un player est une personne qui a reussi a passer le lgoin, connexion réussie.
 */
public class Player {

    private String pseudo;

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public Player(String pseudo) {
        this.pseudo = pseudo;
    }

    

    @Override
    public String toString() {
        return "Player [pseudo=" + pseudo + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((pseudo == null) ? 0 : pseudo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Player other = (Player) obj;
        if (pseudo == null) {
            if (other.pseudo != null)
                return false;
        } else if (!pseudo.equals(other.pseudo))
            return false;
        return true;
    }

}
