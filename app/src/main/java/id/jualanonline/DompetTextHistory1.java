package id.jualanonline;

public class DompetTextHistory1 {
    String pengeluaran, pemasukan,history, waktu;
    int icon;
    public DompetTextHistory1(String history,int icon,String waktu, String pengeluaran, String pemasukan){
        this.pengeluaran = pengeluaran;
        this.pemasukan = pemasukan;
        this.history = history;
        this.waktu = waktu;
        this.icon = icon;
    }

    public String getHistory() {
        return history;
    }

    public int getIcon() {
        return icon;
    }

    public String getWaktu() {
        return waktu;
    }

    public String getPemasukan() {
        return pemasukan;
    }

    public String getPengeluaran() {
        return pengeluaran;
    }
}
