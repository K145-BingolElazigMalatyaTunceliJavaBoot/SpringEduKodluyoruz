package com.kodluyoruz.springegitim.dorduncuhafta.pazar.requestDto;

public class SaveEngineerRequestDto {

    private String name;
    private String lastName;

    private String tckn;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTckn() {
        return tckn;
    }

    public void setTckn(String tckn) {
        this.tckn = tckn;
    }
}
