package com.kodluyoruz.springegitim.dorduncuhafta.pazar.requestDto;

public class UpdateEngineerRequestDto {

    private String soyad;
    private int id;

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
