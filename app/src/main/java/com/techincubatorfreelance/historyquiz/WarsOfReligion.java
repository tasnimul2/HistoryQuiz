package com.techincubatorfreelance.historyquiz;

public class WarsOfReligion {
    /*
    Game 7: Europe: Wars of Religion
    1. Complete the assigned reading
    2. Follow the instructions to play the game

    Date 1: 1570-1700 (Environmental, Economic)
    Fact 1:1: Little Ice Age
    Fact 1:2: Grain price increased 630%
    Fact 1:3: Lower temperatures, low crop yields
    Fact 1:4: Frequent crop failures, famines

    Date 2: 1560-1598 (French Wars of Religion)
    Fact 2-1: Huguenots vs. Catholic League
    Fact 2-2: St. Bartholomew’s Day massacre
    Fact 2-3: 1598 Henry of Navarre is crowned Henry IV
    Fact 2-4: Edict of Nantes establishes toleration

    Date 3: 1556-1648 (Spain and Netherlands)
    Fact 3-1: Philip II persecutes Moriscos, Conversos
    Fact 3-2: Duke of Alba creates Council of Troubles
    Fact 3-3: “Spanish fury” destroys Brussels, Ghent, Antwerp
    Fact 3-4: 1581 northern provinces declare independence

    Date 4: 1553-1648 (England, Thirty Years War)
    Fact 4-1: Francis Drake defeats the Spanish Armada, 1588
    Fact 4-2: Edict of Restitution, 1629
    Fact 4-3: Gustavus Adolphus invades northern Germany
    Fact 4-4: Treaty of Westphalia
     */


    //______________________ Date 1: 1570-1700 (Environmental, Economic) __________________//
    public String date1(int index){
        String[] answer = { "Little Ice Age",
                "Grain price increased 630%",
                "Lower temperatures, low crop yields",
                "Frequent crop failures, famines"};

        return answer[index];
    }

    // ___________________Date 2: 1560-1598 (French Wars of Religion)________________//
    public String date2(int index){
        String[] answer = { "Huguenots vs. Catholic League",
                "St. Bartholomew’s Day massacre",
                "1598 Henry of Navarre is crowned Henry IV",
                "Edict of Nantes establishes toleration"};



        return answer[index];
    }
    //_________________Date 3: 1556-1648 (Spain and Netherlands)___________________//
    public String date3(int index){
        String[] answer = { "Philip II persecutes Moriscos, Conversos",
                "Duke of Alba creates Council of Troubles",
                "\"Spanish fury \" destroys Brussels, Ghent, Antwerp",
                "1581 northern provinces declare independence "};


        return answer[index];
    }
    //____________Date 4: 1553-1648 (England, Thirty Years War) ___________//
    public String date4(int index){
        String[] answer = { "Francis Drake defeats the Spanish Armada, 1588",
                "Edict of Restitution, 1629",
                "Gustavus Adolphus invades northern Germany",
                "Treaty of Westphalia"};


        return answer[index];
    }
}
