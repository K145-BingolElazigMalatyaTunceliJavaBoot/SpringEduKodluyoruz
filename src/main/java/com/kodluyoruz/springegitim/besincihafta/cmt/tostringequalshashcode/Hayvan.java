package com.kodluyoruz.springegitim.besincihafta.cmt.tostringequalshashcode;
import lombok.*;

import java.util.Objects;

//@Getter
//@Setter
//@Data
@ToString(exclude = "id")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Hayvan{
    @Getter
    String name;

    @Getter
    @Setter
    String id;

//    @Override
    public String getId() {
        return "5";
    }

    public void setName(String name) {
        this.name = name;
    }

    //    @Override
//    public String toString() {
//        return name;
//    }



}
