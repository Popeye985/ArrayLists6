package com.company;

import com.sun.jdi.connect.Connector;

import java.util.ArrayList;

    public class Bank {
        private ArrayList<BankRekening> rekeningen = new ArrayList<>();

        public void addRekening(BankRekening rek) {


            if (getRekening(rek.getRekeningnummer()) != null) {
                throw new IllegalArgumentException("Rekening is niet uniek");
            }
            rekeningen.add(rek);
        }


        public ArrayList <String> getRekeningnummers() {
            ArrayList<String> rekeningnummers = new ArrayList<>();
            for (BankRekening rek:rekeningen){
                String rekeningnummer = rek.getRekeningnummer();
                rekeningnummers.add(rekeningnummer);
            }

            return rekeningnummers;
        }

        public BankRekening getRekening(String rekeningnummer) {
            for (BankRekening bankRekening: rekeningen){
                if (bankRekening.getRekeningnummer().equals(rekeningnummer)){
                    return bankRekening;
                }
            }return null;


        }

        public boolean bestaatBankrekening (String rekeningnummer) {
            if (getRekening(rekeningnummer)!= null) {
                return true;
            }else return false;
        }

        public void stortGeld(String rekeningnummer, int i) {
            if (bestaatBankrekening(rekeningnummer) == false) {throw new IllegalArgumentException("Bankrekening bestaat niet."); }
                BankRekening rekening = getRekening(rekeningnummer);
                rekening.storten(i);



        }
    }


