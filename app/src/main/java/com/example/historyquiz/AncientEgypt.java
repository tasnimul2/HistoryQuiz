package com.example.historyquiz;

public class AncientEgypt {

    /*Sliding Puzzle, Game 1: Ancient Egypt
    1. Complete the assigned reading
    2. Follow the instructions to play the game

    Date 1: 1640 BCE-1570 BCE
    Fact 1:1: Hyksos invade Egypt
    Fact 1:2: Second Intermediate Period
    Fact 1:3: Kingdom of Kush invades upper Egypt
    Fact 1:4: Foreign rulers in upper and lower Egypt

    Date 2: 1570 BCE – 1075 BCE (Military)
    Fact 2-1: Adoption of Hyksos bronze weapons
    Fact 2-2: Greater use of Chariots
    Fact 2-3: Use of composite bow
    Fact 2-4: Large standing armies

    Date 3: 1570 BCE – 1075 BCE (Political)
    Fact 3-1: Egyptian New Kingdom
    Fact 3-2: Pharaoh Amoses I defeats the Hyksos
    Fact 3-3: Thutmose III invaded Nubia, Syria, Palestine
    Fact 3-4: Construction of Valley of Kings tombs

    Date 4: 1285 BCE (Military, Art, Literature)
    Fact 4-1: Rameses II vs. Hittite Muwatallis
    Fact 4-2: Battle of Kadesh
    Fact 4-3: “The Battle of Kadesh” (poem)
    Fact 4-4: Pictorial reliefs at Abu Simbel, Luxor, Ramasseum
    */


    public AncientEgypt(){};

    //______________________ Date 1: 1640 BCE-1570 BCE__________________//
    public String date1(int index){
        String[] answer = { "Hyksos invade Egypt",
                "Second Intermediate Period",
                "Kingdom of Kush invades upper Egypt",
                "Foreign rulers in upper and lower Egypt"};


        return answer[index];
    }

    // ___________________Date 2: 1570 BCE – 1075 BCE (Military)________________//
    public String date2(int index){
        String[] answer = { "Adoption of Hyksos bronze weapons",
                "Greater use of Chariots",
                "Use of composite bow",
                "Large standing armies"};



        return answer[index];
    }
    //_________________Date 3: 1570 BCE – 1075 BCE (Political)____________________//
    public String date3(int index){
        String[] answer = { "Egyptian New Kingdom",
                "Pharaoh Amoses I defeats the Hyksos",
                "Thutmose III invaded Nubia, Syria, Palestine",
                "Construction of Valley of Kings tombs"};


        return answer[index];
    }
    //____________Date 4: 1285 BCE (Military, Art, Literature)___________//
    public String date4(int index){
        String[] answer = { "Rameses II vs. Hittite Muwatallis",
                "Battle of Kadesh",
                " 'The Battle of Kadesh' (poem)",
                "Pictorial reliefs at Abu Simbel, Luxor, Ramasseum"};


        return answer[index];
    }


}
