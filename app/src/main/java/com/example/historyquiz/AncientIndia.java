package com.example.historyquiz;

public class AncientIndia {

    /*
    *
    Date 1: 1500 BCE-500 BCE (General)
    Fact 1:1: Decline of Indus Valley Civilization
    Fact 1:2: Indo-Aryan arrival in Punjab
    Fact 1:3: Migration from Bactria
    Fact 1:4: Cattle-raising pastoralist people

    Date 2: 1500 BCE-400 CE (Art and Culture)
    Fact 2-1: Compilation of the Mahabharata
    Fact 2-2: Compilation of the Ramayana
    Fact 2-3: Painted Grey Ware pottery
    Fact 2-4: Compilation of the Vedas

    Date 3: 1500 BCE – 500 BCE (Religion)
    Fact 3-1: Drinking of soma
    Fact 3-2: Indra, the god of thunder
    Fact 3-3: Agni, the god of fire
    Fact 3-4: Sacrifice as ritual

    Date 4: 1500 BCE – 500 BCE (Socio-Political)
    Fact 4-1: Emergence of caste
    Fact 4-2: Tribal kingdom (rashtra)
    Fact 4-3: Tribal Assemblies (sabha, samiti)
    Fact 4-4: King helped by priests and generals
    *
    */


    //______________________ Date 1: 1500 BCE-500 BCE (General)__________________//
    public String date1(int index){
        String[] answer = { "Decline of Indus Valley Civilization",
                "Indo-Aryan arrival in Punjab",
                "Migration from Bactria",
                "Cattle-raising pastoralist people"};

        return answer[index];
    }

    // ___________________Date 2: 1500 BCE-400 CE (Art and Culture)________________//
    public String date2(int index){
        String[] answer = { "Compilation of the Mahabharata",
                "Compilation of the Ramayana",
                "Painted Grey Ware pottery",
                "Compilation of the Vedas"};



        return answer[index];
    }
    //_________________Date 3: 1500 BCE – 500 BCE (Religion)____________________//
    public String date3(int index){
        String[] answer = { " Drinking of soma",
                "Indra, the god of thunder",
                "Agni, the god of fire",
                "Sacrifice as ritual"};


        return answer[index];
    }
    //____________Date 4: 1500 BCE – 500 BCE (Socio-Political)___________//
    public String date4(int index){
        String[] answer = { "Emergence of caste",
                "Tribal kingdom (rashtra)",
                "Tribal Assemblies (sabha, samiti)",
                "King helped by priests and generals"};


        return answer[index];
    }
}
