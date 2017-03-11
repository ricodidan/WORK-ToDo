package id.sch.smktelkom_mlg.worktodo.model;

import java.io.Serializable;

/**
 * Created by Enrico_Didan on 25/02/2017.
 */

public class Item implements Serializable {
    public String judul;
    public String deskripsi;
    public String detail;
    public String lokasi;
    public String foto;

    public Item(String judul, String deskripsi, String detail, String lokasi,
                String foto) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.detail = detail;
        this.lokasi = lokasi;
        this.foto = foto;
    }
}
