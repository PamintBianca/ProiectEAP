package models;

public class Company {

    private int idcompany;
    private String email;
    private String parola;
    private String nume;

    public Company(int idcompany, String email, String parola, String nume) {
        this.idcompany = idcompany;
        this.email = email;
        this.parola = parola;
        this.nume = nume;
    }

    public int getIdcompany() {
        return idcompany;
    }

    public void setIdcompany(int idcompany) {
        this.idcompany = idcompany;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public String toString() {
        return "Company{" +
                "idcompany=" + idcompany +
                ", email='" + email + '\'' +
                ", parola='" + parola + '\'' +
                ", nume='" + nume + '\'' +
                '}';
    }
}
