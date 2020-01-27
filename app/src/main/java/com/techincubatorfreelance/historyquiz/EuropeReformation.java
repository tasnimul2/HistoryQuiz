package com.techincubatorfreelance.historyquiz;

public class EuropeReformation {
    /*
     Europe: Protestant and Catholic Reformation
    1. Complete the assigned reading
    2. Follow the instructions to play the game

    Date 1: 1517 – 1564 (Martin Luther and John Calvin)
    Fact 1:1: The Ninety-Five Theses
    Fact 1:2: Faith in Salvation, Predestination
    Fact 1:3: Creation of the Geneva Consistory
    Fact 1:4: Protestantism supported by Frederick the Wise

    Date 2: 1527-1559 (English Reformation)
    Fact 2-1: Henry VIII’s marriage triggered crisis
    Fact 2-2: Acts of Supremacy and Succession
    Fact 2-3: Establishment of Church of England
    Fact 2-4: England, Scotland divide over churches

    Date 3: 1534-1563 (Catholic Reformation, People)
    Fact 3-1: Pope Paul III
    Fact 3-2: Popes Paul IV, Pius IV
    Fact 3-3: Ignatius of Loyola
    Fact 3-4: St. Teresa of Avila

    Date 4: 1534-1563 (Catholic Reformation, Institutions)
    Fact 4-1: Inquisition created as office
    Fact 4-2: Council of Trent
    Fact 4-3: Index of Forbidden Books
    Fact 4-4: Order of Jesuits, Carmelites, Capuchins
     */

    //______________________ Date 1: 1517 – 1564 (Martin Luther and John Calvin)__________________//
    public String date1(int index){
        String[] answer = { "The Ninety-Five Theses",
                "Faith in Salvation, Predestination",
                "Creation of the Geneva Consistory",
                "Protestantism supported by Frederick the Wise"};

        return answer[index];
    }

    // ___________________Date 2: 1527-1559 (English Reformation) ________________//
    public String date2(int index){
        String[] answer = { "Henry VIII’s marriage triggered crisis",
                "Acts of Supremacy and Succession",
                "Establishment of Church of England",
                "England, Scotland divide over churches"};



        return answer[index];
    }
    //_________________Date 3: 1534-1563 (Catholic Reformation, People) ___________________//
    public String date3(int index){
        String[] answer = { "Pope Paul III",
                "Popes Paul IV, Pius IV",
                "Ignatius of Loyola",
                "St. Teresa of Avila"};


        return answer[index];
    }
    //____________Date 4: 1534-1563 (Catholic Reformation, Institutions) ___________//
    public String date4(int index){
        String[] answer = { "Inquisition created as office",
                "Council of Trent",
                "Index of Forbidden Books",
                "Order of Jesuits, Carmelites, Capuchins"};


        return answer[index];
    }
}
