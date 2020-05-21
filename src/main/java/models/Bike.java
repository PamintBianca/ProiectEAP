package models;

public class Bike {
    private int idbike;
    private int idcompany;
    private boolean isAvailable;

    public Bike(int idbike, int idcompany, boolean isAvailable) {
        this.idbike = idbike;
        this.idcompany = idcompany;
        this.isAvailable = isAvailable;
    }

    public int getIdbike() {
        return idbike;
    }

    public void setIdbike(int idbike) {
        this.idbike = idbike;
    }

    public int getIdcompany() {
        return idcompany;
    }

    public void setIdcompany(int idcompany) {
        this.idcompany = idcompany;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "idbike=" + idbike +
                ", idcompany=" + idcompany +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
