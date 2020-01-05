package com.example.historyquiz;

public class Game2 {

     /*
    Date 1: 600 BCE-321BCE
    Fact 1:1: 16 Mahajanapadas
    Fact 1:2: Shakyas, Koliyas, Mallas
    Fact 1:3: Hereditary kingship, Ashwamedha sacrifice
    Fact 1:4: Kashi, Kosala, Magadha, Vriji rivalry

    Date 2: 550 BCE-321 BCE
    Fact 2-1: Rise of Magadha
    Fact 2-2: Bimbisara and Ajatashatru
    Fact 2-3: Mahapadma Nanda usurped throne
    Fact 2-4: Nanda institutes efficient tax collection, canal building

    Date 3: c.530 BCE-c.327 BCE
    Fact 3-1: Cyrus, the Achaemenid Emperor crosses the Hindu Kush
    Fact 3-2: Herodotus describes Indian fighters in Persian armies
    Fact 3-3: Alexander of Macedon conquers Persia
    Fact 3-4: The Battle of Hydaspes against King Porus

    Date 4: c.599 BCE-c.483 BCE
    Fact 4-1: Buddhism and Jainism
    Fact 4-2: Emphasis on ahimsa
    Fact 4-3: “Four Noble Truths” (Buddhism)
    Fact 4-4: Purified soul rests in bliss (Jainism)
     */

    public Game2(){}

    //______________________ Date 1: 600 BCE-321BCE __________________//
    public String date1(int index){
        String[] answer = { "16 Mahajanapadas",
                "Shakyas, Koliyas, Mallas",
                "Hereditary kingship, Ashwamedha sacrifice",
                "Kashi, Kosala, Magadha, Vriji rivalry "};

        int[] key = {16,17,18,19};

        return answer[index];
    }

    // ___________________Date 2: 550 BCE-321 BCE________________//
    public String date2(int index){
        String[] answer = { "Rise of Magadha",
                "Bimbisara and Ajatashatru",
                "Mahapadma Nanda usurped throne",
                "Nanda institutes efficient tax collection, canal building"};

        int[] key = {20,20,22,23};

        return answer[index];
    }
    //_________________Date 3: c.530 BCE-c.327 BCE____________________//
    public String date3(int index){
        String[] answer = { "Cyrus, the Achaemenid Emperor crosses the Hindu Kush",
                "Herodotus describes Indian fighters in Persian armies",
                "Alexander of Macedon conquers Persia",
                "The Battle of Hydaspes against King Porus "};
        int[] key = {24,25,26,27};

        return answer[index];
    }
    //_______________________________Date 4: c.599 BCE-c.483 BCE______________//
    public String date4(int index){
        String[] answer = { "Buddhism and Jainism",
                "Emphasis on ahimsa",
                "Four Noble Truths (Buddhism)",
                "Purified soul rests in bliss (Jainism)"};

        int[] key = {28,29,30,31};
        return answer[index];
    }
}
