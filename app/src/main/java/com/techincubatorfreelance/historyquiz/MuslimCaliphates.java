package com.techincubatorfreelance.historyquiz;

public class MuslimCaliphates {

    /*
    Date 1: 632 CE-661 CE (Rashidun Caliphate)
    Fact 1:1: Caliphs Abu Bakr, Umar, Uthman, Ali
    Fact 1:2: Rule by diwan (bureaucracy) &amp; sharia (law)
    Fact 1:3: Navy created by Uthman
    Fact 1:4: First Fitna (civil war)

    Date 2: 661 CE-750 CE (Political)
    Fact 2-1: Umayyad Caliphate
    Fact 2-2: Capital moves to Damascus
    Fact 2-3: Arabic became official language
    Fact 2-4: Second Fitna (civil war)

    Date 3: 750 CE -1258 CE (Political, Cultural)
    Fact 3-1: Abbasid Caliphate, Baghdad
    Fact 3-2: Translation of Greek works
    Fact 3-3: “One Thousand and One Nights”
    Fact 3-4: Mongol destruction of Baghdad

    Date 4: 756 CE – 1453 (Political, Cultural)
    Fact 4-1: Caliphate of Cordoba
    Fact 4-2: Almoravids and Almohads
    Fact 4-3: Maimonides, Kitab Rujar, Fatimid Caliphate
    Fact 4-4: Ottoman seizure of Constantinople
     */



    //______________________ Date 1: 632 CE-661 CE (Rashidun Caliphate)__________________//
    public String date1(int index){
        String[] answer = { "Caliphs Abu Bakr, Umar, Uthman, Ali",
                "Rule by diwan (bureaucracy) & sharia (law)",
                "Navy created by Uthman",
                "First Fitna (civil war)"};

        return answer[index];
    }

    // ___________________Date 2: 661 CE-750 CE (Political)________________//
    public String date2(int index){
        String[] answer = { "Umayyad Caliphate",
                "Capital moves to Damascus",
                "Arabic became official language",
                "Second Fitna (civil war)"};



        return answer[index];
    }
    //_________________Date 3: 750 CE -1258 CE (Political, Cultural)___________________//
    public String date3(int index){
        String[] answer = { " Abbasid Caliphate, Baghdad",
                "Translation of Greek works",
                " \"One Thousand and One Nights\" ",
                "Mongol destruction of Baghdad"};


        return answer[index];
    }
    //____________Date 4: 756 CE – 1453 (Political, Cultural)___________//
    public String date4(int index){
        String[] answer = { "Caliphate of Cordoba",
                "Almoravids and Almohads",
                "Maimonides, Kitab Rujar, Fatimid Caliphate",
                "Ottoman seizure of Constantinople"};


        return answer[index];
    }
}
