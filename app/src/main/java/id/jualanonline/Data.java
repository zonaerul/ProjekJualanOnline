package id.jualanonline;

public class Data {
    String namaproduk, namapengguna, images, harga;
    public Data(String namapengguna, String namaproduk, String images,String harga){
        this.namapengguna = namapengguna;
        this.namaproduk = namaproduk;
        this.images = images;
        this.harga = harga;
    }
    public void setNamapengguna(String namapengguna) {
        this.namapengguna = namapengguna;
    }

    public void setNamaproduk(String namaproduk) {
        this.namaproduk = namaproduk;
    }

    public String getNamapengguna() {
        return namapengguna;
    }

    public String getHarga() {
        return harga;
    }

    public String getNamaproduk() {
        return namaproduk;
    }

    public String getImages() {
        return images;
    }
}
