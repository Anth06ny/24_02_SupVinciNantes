package com.example.a24_02_supvincinantes;

import com.example.a24_02_supvincinantes.exo.ExoKotlinKt;
import com.example.a24_02_supvincinantes.model.CarBean;

public class Temp {

    public class Toto {
        private String blabla;

        public Toto(String blabla) {
            this.blabla = blabla;

            System.out.println("Coucou");
        }

        public String getBlabla() {
            return blabla;
        }

        public void setBlabla(String blabla) {
            this.blabla = blabla;
        }
    }

    public static void main(String[] args) {
        ExoKotlinKt.boulangerie(1,2,3);

        CarBean carBean = new CarBean();
    }
}
