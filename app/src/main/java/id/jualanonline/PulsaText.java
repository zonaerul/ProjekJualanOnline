package id.jualanonline;

import android.content.Context;

public class PulsaText {
    String nominal, discount, bayar;
    public PulsaText(String nominal, String discount, String bayar){
        this.nominal = nominal;
        this.discount = discount;
        this.bayar = bayar;
    }

    public String getBayar() {
        return bayar;
    }

    public String getDiscount() {
        return discount;
    }

    public String getNominal() {
        return nominal;
    }
}
