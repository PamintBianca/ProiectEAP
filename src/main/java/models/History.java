package models;

import java.util.Date;

public class History {
    private int idbike;
    private int iduser;
    private Date datastart;
    private Date datastop;

    public History(int idbike, int iduser, Date datastart, Date datastop) {
        this.idbike = idbike;
        this.iduser = iduser;
        this.datastart = datastart;
        this.datastop = datastop;
    }

    public int getIdbike() {
        return idbike;
    }

    public void setIdbike(int idbike) {
        this.idbike = idbike;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public Date getDatastart() {
        return datastart;
    }

    public void setDatastart(Date datastart) {
        this.datastart = datastart;
    }

    public Date getDatastop() {
        return datastop;
    }

    public void setDatastop(Date datastop) {
        this.datastop = datastop;
    }

    @Override
    public String toString() {
        return "History{" +
                "idbike=" + idbike +
                ", iduser=" + iduser +
                ", datastart=" + datastart +
                ", datastop=" + datastop +
                '}';
    }
}
