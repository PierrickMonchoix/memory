package com.pierrickmonchoix.memoryserver.business;

/**
 * une personne est un joueur qui n'a pas encore passé le login, il n'est pas
 * cnore connecté
 */
public class Personne {

    private String pseudo;

    public Personne(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
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
        Personne other = (Personne) obj;
        if (pseudo == null) {
            if (other.pseudo != null)
                return false;
        } else if (!pseudo.equals(other.pseudo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Personne [pseudo=" + pseudo + "]";
    }

}
