package com.example.historyquiz;

public class MongolKhanates {
    /*
    Game 6: Mongol Khanates

    Date 1: 1206-1220 (Mongol Unification, Conquest)
    Fact 1:1: Kurultai of leading Chieftains
    Fact 1:2: Conquest of Tanguts, Jurchen, Qara Khitai
    Fact 1:3: Capture of Bukhara, 1220
    Fact 1:4: Capture of Samarkand, 1220

    Date 2: 1235-1241 (Mongol Invasion of Europe)
    Fact 2-1: 1236 Subutai campaign in Russia
    Fact 2-2: 1240 capture of Kiev
    Fact 2-3: Attack on Poland (1241)
    Fact 2-4: Battle of Mohi (Hungary)

    Date 3: 1251-1260 (Mongol Invasion of the Middle East)
    Fact 3-1: 1251 Möngke Khan resumes conquests
    Fact 3-2: 1257 Hülegü Khan attacks Baghdad
    Fact 3-3: 1258 Destruction of Baghdad
    Fact 3-4: 1260 Mamluks defeat Mongols at Ain Jalut

    Date 4: 1251-1292 (Mongol Invasion of East and Southeast Asia)
    Fact 4-1: 1271 Kublai Khan becomes Yuan Emperor
    Fact 4-2: 1274 First failed invasion of Japan
    Fact 4-3: 1281 Second failed invasion of Japan
    Fact 4-4: 1285-1292 Invasions of Vietnam, Java, Burma
     */

    //______________________ Date 1: 1206-1220 (Mongol Unification, Conquest) __________________//
    public String date1(int index){
        String[] answer = { "Kurultai of leading Chieftains",
                "Conquest of Tanguts, Jurchen, Qara Khitai",
                "Capture of Bukhara, 1220",
                "Capture of Samarkand, 1220"};



        return answer[index];
    }

    // ___________________Date 2: 1235-1241 (Mongol Invasion of Europe)________________//
    public String date2(int index){
        String[] answer = { "1236 Subutai campaign in Russia",
                "1240 capture of Kiev",
                "Attack on Poland (1241)",
                "Battle of Mohi (Hungary)"};



        return answer[index];
    }
    //_________________Date 3: 1251-1260 (Mongol Invasion of the Middle East) ____________________//
    public String date3(int index){
        String[] answer = { "1251 Möngke Khan resumes conquests",
                "1257 Hülegü Khan attacks Baghdad",
                "1258 Destruction of Baghdad",
                "1260 Mamluks defeat Mongols at Ain Jalut"};


        return answer[index];
    }
    //_______________Date 4: 1251-1292 (Mongol Invasion of East and Southeast Asia) ______________//
    public String date4(int index){
        String[] answer = { "1271 Kublai Khan becomes Yuan Emperor",
                "1274 First failed invasion of Japan",
                "1281 Second failed invasion of Japan",
                "1285-1292 Invasions of Vietnam, Java, Burma"};


        return answer[index];
    }
}
