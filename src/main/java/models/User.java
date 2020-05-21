package models;

public class User {
    private int iduser;
    private String email;
    private String parola;
    private String nume;
    private String prenume;

    public User(int iduser, String email, String parola, String nume, String prenume) {
        this.iduser = iduser;
        this.email = email;
        this.parola = parola;
        this.nume = nume;
        this.prenume = prenume;
    }

    public User(String email, String parola, String nume, String prenume) {
        this.email = email;
        this.parola = parola;
        this.nume = nume;
        this.prenume = prenume;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
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

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    @Override
    public String toString() {
        return "User{" +
                "iduser=" + iduser +
                ", email='" + email + '\'' +
                ", parola='" + parola + '\'' +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                '}';
    }
}
