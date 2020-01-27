package com.techincubatorfreelance.historyquiz;

public class Game1 {
     /*
    Date 1: 1920s
    Fact 1:1: 10% unemployment in Britain, Germany, Sweden
    Fact 1:2: 20,000-30,000 billion Marks of debt
    Fact 1:3: 132 billion Gold Marks reparations
    Fact 1:4: Collapse of the monetary system from Germany to the USSR

    Date 2: 1929-1933 (economics)
    Fact 2-1: New York Stock Exchange Crash, 29 October
    Fact 2-2: US net income fell by 76 per cent in 2 years
    Fact 2-3: Great Slump
    Fact 2-4: Unemployment: 22% (UK), 27% (USA), 44% (Germany)

    Date 3: 1930s
    Fact 3-1: German economy 25 per cent above 1929
    Fact 3-2: Franklin Roosevelt’s New Deal
    Fact 3-3: Aggressive imperialist regime in Japan
    Fact 3-4: Hitler takes power in Germany

    Date 4: 1928-1932 (world politics)
    Fact 4-1: Getulio Vargas takes power in Brazil
    Fact 4-2: Muslim Brotherhood founded in Egypt
    Fact 4-3: Second Gandhian mass movement
    Fact 4-4: De Valera wins Irish elections
     */

    public Game1(){}

    //___________________________time period : 1920s_________________//
    public String date1(int index){
        String[] answer = { "10% unemployment in Britain, Germany, Sweden",
                "20,000-30,000 billion Marks of debt",
                "132 billion Gold Marks reparations",
                "Collapse of the monetary system from Germany to the USSR"};

        int[] key = {0,1,2,3};

        return answer[index];
    }

    //_________________Time period : 1929-1933 (economics)___________//
    public String date2(int index){
        String[] answer = { "New York Stock Exchange Crash, 29 October",
                "US net income fell by 76 per cent in 2 years",
                "Great Slump",
                "Unemployment: 22% (UK), 27% (USA), 44% (Germany)"};
        int[] key = {4,5,6,7};
        return answer[index];
    }

    //________________Time period : 1930s______________________//
    public String date3(int index){
        String[] answer = { "German economy 25 per cent above 1929",
                "Franklin Roosevelt’s New Deal",
                "Aggressive imperialist regime in Japan",
                "Hitler takes power in Germany "};

        int[] key = {8,9,10,11};
        return answer[index];
    }

    //__________Time period : 1928-1932 (world politics)________//
    public String date4(int index){
        String[] answer = { "Getulio Vargas takes power in Brazil",
                "Muslim Brotherhood founded in Egypt",
                "Second Gandhian mass movement",
                "De Valera wins Irish elections"};
        int[] key = {12,13,14,15};
        return answer[index];
    }
}
