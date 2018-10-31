package id.ac.polinema.sharedpreferenceandsqlite;

import java.io.Serializable;

public class DataModel implements Serializable {
    private String nama;
    private int id;

    // contrustor(empty)
    public DataModel() {
    }

    public DataModel(String nama, int id) {
        this.nama = nama;
        this.id = id;
    }

    public DataModel(String nama){
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
