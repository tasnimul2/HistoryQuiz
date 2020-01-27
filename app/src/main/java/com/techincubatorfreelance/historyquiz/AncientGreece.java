package com.techincubatorfreelance.historyquiz;

public class AncientGreece {
    /*
    Date 1: 800 BCE-500 BCE (General)
    Fact 1:1: Archaic Age
    Fact 1:2: Syllabic alphabet
    Fact 1:3: Rise of polis
    Fact 1:4: Greek colonies in Ionia

    Date 2: 800 BCE-500 BCE (Culture)
    Fact 2-1: Homer’s Iliad and Odyssey
    Fact 2-2: Poems celebrate areta
    Fact 2-3: Public discussions in the agora
    Fact 2-4: Sense of civic virtue

    Date 3: 700 BCE – 479 BCE (Socio-political)
    Fact 3-1: Athens and Sparta rise
    Fact 3-2: Krypteia oppressed slave helots
    Fact 3-3: Solon abolishes Athenian debt-slavery
    Fact 3-4: Cleisthenes allowed vote for free men

    Date 4: 700 BCE -479 BCE (Military, Diplomacy)
    Fact 4-1: Cyrus and Darius expand Persian Empire
    Fact 4-2: Marathon and Pheidippides
    Fact 4-3: Thermopylae and Leonidas
    Fact 4-4: Naval battle of Salamis

    */

    //______________________ Date 1: 800 BCE-500 BCE (General)__________________//
    public String date1(int index){
        String[] answer = { "Archaic Age",
                "Syllabic alphabet",
                "Rise of polis",
                "Greek colonies in Ionia"};


        return answer[index];
    }

    // ___________________Date 2: 800 BCE-500 BCE (Culture)________________//
    public String date2(int index){
        String[] answer = { "Homer’s Iliad and Odyssey",
                "Poems celebrate areta",
                "Public discussions in the agora",
                "Sense of civic virtue"};



        return answer[index];
    }
    //_________________Date 3: 700 BCE – 479 BCE (Socio-political)____________________//
    public String date3(int index){
        String[] answer = { "Athens and Sparta rise",
                "Krypteia oppressed slave helots",
                "Solon abolishes Athenian debt-slavery",
                "Cleisthenes allowed vote for free men"};


        return answer[index];
    }
    //____________Date 4: 700 BCE -479 BCE (Military, Diplomacy)___________//
    public String date4(int index){
        String[] answer = { "Cyrus and Darius expand Persian Empire",
                "Marathon and Pheidippides",
                "Thermopylae and Leonidas",
                "Naval battle of Salamis"};


        return answer[index];
    }
}
