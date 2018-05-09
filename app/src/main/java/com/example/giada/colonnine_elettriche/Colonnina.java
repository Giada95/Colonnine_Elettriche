package com.example.giada.colonnine_elettriche;

import java.io.Serializable;

/**
 * Created by Giada on 24/04/2018.
 */

    enum TipoSupporto {
        chademo50, type2, type22kW, scame, combo
    }


    public class Colonnina implements Serializable{
        private String Indirizzogenerico;
        private String gestore;
        private TipoSupporto supporto[];

        public Colonnina(){

        }

        public Colonnina(String Indirizzogenerico,String gestore,TipoSupporto supporto[])
        {this.Indirizzogenerico=Indirizzogenerico;
        this.gestore=gestore;
        this.supporto=supporto;
        }

        public String getIndirizzogenerico() {
            return Indirizzogenerico;
        }

        public void setIndirizzogenerico(String Indirizzogenerico) {this.Indirizzogenerico = Indirizzogenerico;}

        public String getGestore() {return gestore;}

        public void setGestore(String gestore) {
            this.gestore = gestore;
        }

        public TipoSupporto[] getSupporto() {return supporto;}

        StringBuilder sb = new StringBuilder();

        public String getNomiSupporti() {



            for (TipoSupporto tipoSupporto: supporto) {
                sb.append(getNomeSupporto(tipoSupporto) + " - ");

            }
            return sb.toString();
        }

        public String getNomeSupporto(TipoSupporto tipoSupporto) {

            switch (tipoSupporto) {
                case chademo50:
                    return "Chademo50";

                case type2:
                    return "Tipo2";
                case type22kW:
                    return "Type22kw";
                case scame:
                    return "Scame";
                case combo:
                    return "Combo";

            }
        return sb.toString();}

        public void setSupporto(TipoSupporto[] supporto) {
            this.supporto = supporto;}



    }


