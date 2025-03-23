import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.StandardOpenOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
// import java.io.FileWriter;
// import java.io.BufferedWriter;



//add save feature to the end of each story!
public class StoryHolder{

    public static String storyName1 = "fake.txt";
    public static String retrieveStoryname(){
        return storyName1;
    }
    public static void setStoryName(String storyName){
        storyName1 = storyName;
    }

    public static void AddToFile(String addedText){
        String fileName = retrieveStoryname();

        try {
            Files.write(Paths.get(fileName),
                Collections.singletonList(addedText),
                StandardOpenOption.APPEND,
                StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //re-usable print function
    public static void printSum(String string2print){
        System.out.println(string2print);
        AddToFile(string2print);
    }
    //add section to save user input to a txt file in here?

    //clears off the screen, moves the cursor
    public static void ClrScrn(){
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
        printSum("");
    }

    //reads from user input, parse through to ensure the provided input is a number, ensure number is within our range (1 or 2), then 
    //send it back to the main program
    public static int AskUser(String option1, String option2) throws IOException{
        //open the BufferedReader
        BufferedReader myReader = new BufferedReader(new InputStreamReader(System.in));
        Boolean LoopStat = true;
        int pathSplit = 0;

        printSum("1. "+ option1 +".");
        printSum("2. "+ option2 + ".");

        while (LoopStat) {
            Boolean InnerLoop = true;
            while (InnerLoop){
                try{
                    pathSplit = Integer.parseInt(myReader.readLine());
                    break;
                }
                catch (NumberFormatException exceptionReader){
                    ClrScrn();
                    printSum("Be sure to only input NUMBERS into this field.");
                    printSum("\n1. "+ option1 +".");
                    printSum("2."+ option2 + ".");
                }
            }

            if (pathSplit == 1 || pathSplit == 2){
                //printSum("Huzzah ! ~ Maredawg"); random line used for debugging
                if (pathSplit == 1){
                    AddToFile("You chose: 1. "+ option1 +".");
                }
                else {
                    AddToFile("You chose: 2. "+ option2 +".");
                }
                break;
            }
            else{
                ClrScrn();
                printSum("There's only two options, there isn't any "+ pathSplit + ".");
                printSum("\n1. "+ option1 +".");
                printSum("2. "+ option2 + ".");
            }

        }
       
        return pathSplit;
    }

    //prints off the user's invetory and their coin
    public static void RetrieveInv(int userMoney){
        printSum("\nInventory:          Gold/Money: "+ userMoney + "\n");
    }

    //prints off a message when the user first gets coin
    public static void MoneyMessage(){
        printSum("**You've unlocked access to the currency menu, it will now appear under dialog boxes.**");
        printSum("**Certain encounters have unique interactions if you choose to use your currency.**");
    }

    public static void NullEnding(){
        ClrScrn();
        printSum("You don’t accept Gonti’s offer. You were never meant to do this much in your life, and you’d \r\n" + //
        "prefer to sit back and take life slowly. Eventually you start work as a carpenter, and raise a \r\n" + //
        "family in Trent. Life is comfortable, but even Trent’s great walls cannot protect your family from everything. \r\n" + //
        "Close to the birth of your first grandchild, a large band of raiders launches an all-out assault on \r\n" + //
        "Trent. All military attention is diverted towards protecting the city, and the battle lasts for \r\n" + //
        "decades.\r\n" + //
        "Near the end of your life, the raiders are vanquished, but the walls have taken so much damage \r\n" + //
        "that the incoming plague from the South ravages the already weakened city. Trent, the last great \r\n" + //
        "pillar of mankind, falls into despair as man struggles to run to places the plague hasn’t touched.\r\n" + //
        "");
    printSum("THE END (ENDING 2/4 THE NULL ENDING)");
    }

    public static void TheEnd(int MoneyAmount) throws IOException{
        printSum("Press Enter to continue....");
        BufferedReader myReader = new BufferedReader(new InputStreamReader(System.in));
        String falseVar = (myReader.readLine());

        ClrScrn();
        printSum("You enter the central Spire of Trent. Several armored sentinels stand guard in the building, with \r\n" + //
                        "a small throne in the center. A man, almost made of smoke, wearing a metallic mask that seems \r\n" + //
                        "to flicker to life sits upon it, clothed in ancient, threadbear robes. He immediately turns to you, \r\n" + //
                        "and grabs your attention with the glimmering mask. “You aren’t of Trent, but you arrive all the \r\n" + //
                        "same, we don’t get many that don’t already reside within her walls”. He stares intensely at you, \r\n" + //
                        "or maybe he’s just staring normally, it’s kind of hard to tell. He sighs, “I can’t even trust my own\r\n" + //
                        "these days, let alone the rare outsider”. \r\n" + //
                        "A black orb raises from the ground and the smoke seeping from the man’s visage seems to be \r\n" + //
                        "drawn towards it. As the smoke wraps itself around the orb, you feel your mind start to twist and \r\n" + //
                        "turn, it feels as if the smoke is enveloping your head. After a few minutes, the man stops. “Ah, I \r\n" + //
                        "see. Your story makes sense, you’ve forgotten everything after the attack, but I can still glimpse \r\n" + //
                        "those lost memories in your mind. I am Gonti, the Minister of Trent. You come from a city very \r\n" + //
                        "far to the South, one that was destroyed in the same way many near Trent have been.”\r\n" + //
                        "\r\n" + //
                        "“There used to be hundreds of small settlements surrounding Trent, before this place was a \r\n" + //
                        "desert, and even now. Pillaging bands of raiders, like the ones that took you here, ravaged \r\n" + //
                        "these small towns unto the point of destruction. Your city, was wiped out by a spreading plague, \r\n" + //
                        "and one I am all too familiar with. The last survivors, yourself included, escaped on a barge, \r\n" + //
                        "only to be attacked and shot down.”\r\n" + //
                        "\r\n" + //
                        "Gonti’s smoke seems to twist and billow around in the air as if he’s deep in thought. \r\n" + //
                        "“Hmmmmm…” he mutters, “I may have use of you”\r\n" + //
                        "");
        printSum("Press Enter to continue...");
        falseVar = (myReader.readLine());

        if (MoneyAmount == 10){
            printSum("“You are new to this fight, but I think there is much promise with you. I saw how you dealt with \r\n" + //
                                "those thieves, and you are quite resourceful. I need someone who can wander to find what they, \r\n" + //
                                "or we, are looking for. I need you to lead my new anti-aircraft patrols. My intelligence tells me that the \r\n" + //
                                "raiders are planning something big, I need your help to ward it off, make the skies safe again, so \r\n" + //
                                "that others may safely seek refuge in Trent.”\r\n" + //
                                "\r\n" + //
                                "“Will you help me?”\r\n" + //
                                "");
            int choice2 = AskUser("Yes", "No");
            if (choice2 == 1){
                printSum("You help initiate the creation of Trent’s anti-aircraft teams. Your men spend months preparing \r\n" + //
                                        "and equipping several defense barges, and when an all-out raider assault threatens the city, \r\n" + //
                                        "your patrols decimate them into oblivion. The traveling bands of raiders and marauders are \r\n" + //
                                        "practically extinct by the time your first child is born. Trent lives in peace for several years, and \r\n" + //
                                        "gains a much larger population as a result of safer skies, thanks to you.\r\n" + //
                                        "Years later, a plague from the South creeps into Trent, but the influx of people from around the \r\n" + //
                                        "globe brings together different scientists with different methods. The plague is cured shortly after \r\n" + //
                                        "it infects Trent. Around 5% of the city succumbs to the plague, but Trent remains stronger than ever, and continues to flourish.\r\n" + //
                                        "With the plague and raider threats completely neutralized, hope returns to the wasteland, and settlements begin to pop up around Trent, humanity expands.\r\n" + //
                                        "");
                printSum("THE END (ENDING 3/4 SCION OF THE SKIES ENDING)");
            }
            else if (choice2 == 2){
                NullEnding();
            }
        }
        else if (MoneyAmount == 15){
            printSum("“You lack experience in the ways of this world, but you still have much use. I am in need of bay \r\n" + //
                                "captains to protect and guard the air-ports of Trent from raiders and marauders. The pay would \r\n" + //
                                "be quite well, and you would have a chance to protect our city from those who harmed yours.”\r\n" + //
                                "\r\n" + //
                                "“Do you accept?”\r\n" + //
                                "");
            int choice1 = AskUser("Yes", "No");
            if (choice1 == 2){
                NullEnding();
            }
            else if (choice1 == 1){
                printSum("You start off as the captain of one of Trent’s several air bays, and defend it from numerous \r\n" + //
                                        "raider attacks and attempts to sneak in. Gonti and the rest of Trent’s government notice the  \r\n" + //
                                        "good work you put in, and you’re promoted from bay captain to marshall of all Trent’s \r\n" + //
                                        "surrounding airways. Gonti’s warning pays off, and you successfully deter a massive raider \r\n" + //
                                        "assault. The city still takes casualties, as the war rages on for several years, but the raiders are \r\n" + //
                                        "severely weakened, and dissolve into the tumbling sands of the desert. \r\n" + //
                                        "Years later, a plague from the South creeps towards Trent. The city has the resources to fend it \r\n" + //
                                        "off, as less manpower is devoted to driving off raiders, but it still affects the city. \r\n" + //
                                        "Around the same time your first child leaves on their own, the plague is deterred. Trent remains \r\n" + //
                                        "standing tall, a scarred city, but the survivors prosper.\r\n" + //
                                        "");
                                        printSum("THE END (ENDING 1/4 THE LORD OF THE PORTS ENDING)");
            }
        }
        

    }

    public static void TheEndV2(int MoneyAmount) throws IOException{
        printSum("Press Enter to continue....");
        BufferedReader myReader = new BufferedReader(new InputStreamReader(System.in));
        String falseVar = (myReader.readLine());

        ClrScrn();
        printSum("The harsh desert sun blinds you for a moment, but as your eyes adjust, you see a small skiff \r\n" + //
                        "buzzing and whirring about in the sunset. You start to wave them down, and the skiff \r\n" + //
                        "immediately makes a beeline for you. It comes to a sudden stop, and then one its operators \r\n" + //
                        "hops out, making a small crater in the sand. “Not many enter that swamp, and much less come \r\n" + //
                        "out, where are you heading?”. You tell him you may be headed for Trent, and he says; “Huh, we \r\n" + //
                        "come from Trent, and no one’s recently headed out this way. You must be from somewhere \r\n" + //
                        "else… C’mon we’ve got someone who’ll want to meet ya”. The other skippers practically pull \r\n" + //
                        "you onto the ship, and it zooms off towards Trent.\r\n" + //
                        "\r\n" + //
                        "A few hours later, the city pops into your field of vision. The city is enclosed with massive, \r\n" + //
                        "ancient red stone walls. A central spire sticks out from the center like the stem of an \r\n" + //
                        "upside-down mushroom made of stone. The rest of the city seems to bulge out from the city \r\n" + //
                        "walls, hardly being contained. The skiff passes through a military checkpoint to go into the city. \r\n" + //
                        "You sort of gather that this group has some type of clearance, and isn’t just a group of \r\n" + //
                        "scavengers. As you near the central spire of Trent, one scavengers radios something to an \r\n" + //
                        "unknown person, and a massive stone door lifts up, uncovering a hidden air bay in the higher \r\n" + //
                        "parts of the spire.\r\n" + //
                        "\r\n" + //
                        "An elevator guides your descent to the main chamber, and when you arrive…\r\n" + //
                        "");
        printSum("Press Enter to continue....");
        falseVar = (myReader.readLine());
        ClrScrn();

        printSum("Several armored sentinels stand guard around the chamber, with a small throne in the center. A \r\n" + //
                        "man, almost made of smoke, wearing a metallic mask that seems to flicker to life sits upon it, \r\n" + //
                        "clothed in ancient, threadbear robes. He immediately turns to you, and grabs your attention with \r\n" + //
                        "the glimmering mask. “Ah, it seems my scouts have brought me something, but is it of value?”. \r\n" + //
                        "The skipper that seems to be the leader of the group, steps forward, “We found this one near \r\n" + //
                        "the settlement of Gerso, wandering in the desert”. The man of smoke, turns to you, but it’s \r\n" + //
                        "difficult to tell if he’s staring at you with the glowing eyes and mask. “Ah Gerso, we were \r\n" + //
                        "preparing to accept more of their people, surely you passed by it in the desert?” he asks.\r\n" + //
                        "\r\n" + //
                        "You explain that you wandered through a battered and plague-ridden settlement that looked like \r\n" + //
                        "it’d been long abandoned, and give a general description of it. “We last contacted Gerso two \r\n" + //
                        "weeks ago… this plague is spreading faster than we thought.” the smoky man says, “it may be \r\n" + //
                        "time to fight the plague harder and stronger”. He turns back to you, “You must be a little \r\n" + //
                        "confused. My name is Gonti, Minister of Trent, and a plague is spreading, swallowing \r\n" + //
                        "settlements whole, and we do not have the manpower to research and defend against it, as \r\n" + //
                        "constant raider attacks keep our militia quite busy.”\r\n" + //
                        "\r\n" + //
                        "Gonti seems to think, the smoke twists and curls in the air, and then he turns to you. “Let me \r\n" + //
                        "see what knowledge you have, after all, you have survived the plague swamps.” A black orb \r\n" + //
                        "raises from the ground and the smoke seeping from the man’s visage seems to be drawn \r\n" + //
                        "towards it. As the smoke wraps itself around the orb, you feel your mind start to twist and \r\n" + //
                        "turn, it feels as if the smoke is enveloping your head. After a few minutes, the man stops. “Ah, I \r\n" + //
                        "see, you have much familiarity with the plague, more than you know.” “You’ve forgotten your \r\n" + //
                        "memories since the barge crash, but you come from a city to the South that was also destroyed \r\n" + //
                        "by the plague, and your barge carried some of the last survivors.”\r\n" + //
                        "\r\n" + //
                        "“I think I may have use for you…\r\n" + //
                        "");
        printSum("Press Enter to continue....");
        falseVar = (myReader.readLine());
        ClrScrn();
        if (MoneyAmount == 5){
            printSum("“You lack experience in the ways of this world, but you still have much use. I am in need of bay \r\n" + //
                                "captains to protect and guard the air-ports of Trent from raiders and marauders. This would give \r\n" + //
                                "me more manpower to send towards combating the plague. The pay would be quite well, and \r\n" + //
                                "you would have a chance to protect our city from those who harmed yours.”\r\n" + //
                                "\r\n" + //
                                "“Do you accept?”\r\n" + //
                                "");
            int choice3 = AskUser("Yes", "No");
            if (choice3 == 1){
                printSum("You start off as the captain of one of Trent’s several air bays, and defend it from numerous \r\n" + //
                                        "raider attacks and attempts to sneak in. Gonti and the rest of Trent’s government notice the  \r\n" + //
                                        "good work you put in, and you’re promoted from bay captain to marshall of all Trent’s \r\n" + //
                                        "surrounding airways. Gonti’s warning pays off, and you successfully deter a massive raider \r\n" + //
                                        "assault. The city still takes casualties, as the war rages on for several years, but the raiders are \r\n" + //
                                        "severely weakened, and dissolve into the tumbling sands of the desert. \r\n" + //
                                        "Years later, a plague from the South creeps towards Trent. The city has the resources to fend it \r\n" + //
                                        "off, as less manpower is devoted to driving off raiders, but it still affects the city. \r\n" + //
                                        "Around the same time your first child leaves on their own, the plague is deterred. Trent remains \r\n" + //
                                        "standing tall, a scarred city, but the survivors prosper.\r\n" + //
                                        "");
                printSum("THE END (ENDING 3/4 SCION OF THE SKIES ENDING)");
            }
            else if (choice3 == 2){
                NullEnding();
            }


        }
        else if (MoneyAmount == 30){
            printSum("“I saw what you did to help that swamp witch out. I need someone who doesn’t miss a single \r\n" + //
                                "detail in the ever changing landscape of plague-infected areas. I want you to lead my new \r\n" + //
                                "plague combatant team, and help destroy this infection before it reaches us.”\r\n" + //
                                "\r\n" + //
                                "“Will you accept?”\r\n" + //
                                "");
            int choice4 = AskUser("Yes", "No");
            if (choice4 == 2){
                NullEnding();
            }
            else if (choice4 == 1){
                printSum("You lead Trent’s new anti-plague infection research team. By directly monitoring the plague's \r\n" + //
                                        "impact, your research eliminates it completely in a manner of years. Later, a massive raider \r\n" + //
                                        "attack threatens Trent’s safety, but almost all of the city’s manpower is devoted to its protection. \r\n" + //
                                        "The raiders relentlessly assault the city, but the battle lasts for only a few weeks. The raiders are \r\n" + //
                                        "left neutralized, and Trent prospers as a shining light of civilization. \r\n" + //
                                        "Near the end of your life, multiple cities have sprung up across the globe, and humanity can \r\n" + //
                                        "expand beyond the confines of Trent. Life returns to the Earth, and you rest easy knowing that \r\n" + //
                                        "humanity won’t just survive, but thrive.\r\n" + //
                                        "");
                printSum("THE END (ENDING 4/4 PROPSPERITY OF TRENT)");
            }
        }

    }


    public static void main(String[] args) throws IOException{
        
        //declare the money value as blank, and then clear off any remaining junk on the screen
        int Money = 0;
        Boolean LifeStatus = true;
        printSum("Give your Story a name:");
        BufferedReader myReader = new BufferedReader(new InputStreamReader(System.in));
        String storyTitle = (myReader.readLine());
        setStoryName(storyTitle+".txt"
        );


        ClrScrn();

        printSum("A chill, unsettling desert wind blows grains of sand past your face as you awaken.\r\n" + //
                        "Your eyes slowly crack open to see you’re inside of a decomposing, rusty structure. \r\n" + //
                        "It appears as if it’s been around for a thousand years, but constantly maintained and repaired \r\n" + //
                        "with slightly less old, but still just as rusty, patches of scrap metal. \r\n" + //
                        "You’ve regained more awareness, and see that a large crack in the hull of this metallic beast is \r\n" + //
                        "the source of desert wind and sand, but behind you the metallic structure groans, and the \r\n" + //
                        "darkness of its hallways entices you.\r\n" + //
                        "");

        //call the AskUser function here, returns the appriopiate pathsplit variable
        int pathSplit1 = AskUser("Leave the barge", "Explore the barge");

        if (pathSplit1 == 1){
            printSum("The howl of the desert entrances your deranged mind, and you slowly wander out from the\r\n" + //
                                "barge into the sandy wasteland. You wander for what seems like days, weeks, perhaps even \r\n" + //
                                "months, but you know it isn’t as it seems, the roar of the sandstorms whispers into your crazed \r\n" + //
                                "ears. Eventually you collapse near the edge of a blackened, oily looking swamp. After a few \r\n" + //
                                "hours of much needed rest, you continue wandering into the depths of the swamp. Along you \r\n" + //
                                "way, you spot a small, rotting hut in the distance.\r\n" + //
                                "");
            int pathSplit11 = AskUser("Continue wandering deeper into the swamp", "Investigate the hut");
            if (pathSplit11 == 1){
                printSum("You decide the hut isn’t the best place to stop at, and continue to march on. The fog and toxicity \r\n" + //
                                        "of the swamp encroaches upon your brain, and the lack of any food or drink muddles your mind.\r\n" + //
                                        "This deep into the swamp, very little vegetation persits, and it slowly becomes a sea of black \r\n" + //
                                        "ooze. In your delirium, you march straight into a deeper pool of tar, and lack the strength to pull \r\n" + //
                                        "yourself out\r\n" + //
                                        "\r\n" + //
                                        "YOU DIED\r\n" + //
                                        "");
                LifeStatus = false;
            }
            else if (pathSplit11 == 2){
                printSum("It’s been days since you’ve eaten or drank clean water, the hut seems like the place to stop. As \r\n" + //
                                        "you trudge your way over to it, you hear the clink of some tin cans in the distance. A hobbled, \r\n" + //
                                        "old woman wearily opens the door to the hut, casting an uneasy stare at you. You explain that \r\n" + //
                                        "you mean no harm, and she lets you in. “This swamp isn’t for the living, you need to leave. But \r\n" + //
                                        "before you go, I will give you some coin and grub in exchange for a little bit ‘o labor.”\r\n" + //
                                        "");
                int pathSplit112 = AskUser("Leave the swamp", "Help the old witch out");
                if (pathSplit112 == 2){
                    printSum("Some food and water sound very promising to the well-being of your current lifespan, so you \r\n" + //
                                                "decide to help the witch out. You split moldy-looking wood, patch holes in the hut’s roof, and \r\n" + //
                                                "repair a few fence posts. The witch graciously gives you much more than you deserve, but \r\n" + //
                                                "seems happy to have some help, and company. She bids you on your way, and points in the \r\n" + //
                                                "direction of the nearest settlement.\r\n" + //
                                                "You wander on, and can almost taste the desert heat as you near the swamp’s edge, and see \r\n" + //
                                                "the deserted ruins of a town. The filth of the swamp seems to have swallowed up the town \r\n" + //
                                                "entirely, something is not as it seems. A weathered and moss infested sign holds several \r\n" + //
                                                "wooden arrow-shaped signs that point to various towns and cities, most point deeper into the \r\n" + //
                                                "swamp. One points outward, into the desert, and reads Trent, city of the Gonti. The description \r\n" + //
                                                "for Trent says it’s only a day and half away, so you wander back into the desert…\r\n" + //
                                                "");
                    Money += 30;
                    MoneyMessage();
                    RetrieveInv(Money);
                    TheEndV2(Money);
                }
                else if (pathSplit112 == 1){
                    printSum("You don’t need to waste time helping a poor old woman out, so you move on. It might be worth it \r\n" + //
                                                "to heed her warning about the swamp, so you head back towards the desert, there’s bound to \r\n" + //
                                                "be something else, or just more sand. The lack of food and water severely cripple your \r\n" + //
                                                "movement, and you feel as if you might die. The swamp may be able to meet your needs,\r\n" + //
                                                "but something’s not right about it, and you’re unsure if dehydration or poison will grant your\r\n" + //
                                                "demise.\r\n" + //
                                                "");
                    int pathSplit1121 = AskUser("Forage from the swamp", "Move on");
                    if (pathSplit1121 == 1){
                        printSum("You cave into drinking the swamp’s mystery liquid, and eating some slimy moss \r\n" + //
                                                        "growing on the sides of trees. It fills you a little, but then you pass out again. You can almost \r\n" + //
                                                        "taste the desert heat as you near the swamp’s edge, and you see the deserted ruins of a town.\r\n" + //
                                                        "The filth of the swamp seems to have swallowed up the town entirely, something is not as it seems. A weathered and moss infested sign holds several wooden arrow-shaped signs that \r\n" + //
                                                        "point to various towns and cities, most point deeper into the swamp. One points outward, into \r\n" + //
                                                        "the desert, and reads Trent, city of the Gonti. It’s description says it’s only a day and half away, \r\n" + //
                                                        "so you wander back into the desert. \r\n" + //
                                                        "The heat feels worse, and the swamp flora starts to boil your insides. You fall to the ground in \r\n" + //
                                                        "agony, regretting not working for some real food. Your vision starts to blur, and in the distance, \r\n" + //
                                                        "you see a small skiff surfing above the sands, it’s the last thing you ever see.\r\n" + //
                                                        "\r\n" + //
                                                        "YOU DIED\r\n" + //
                                                        "");
                        LifeStatus = false;
                    }
                    else if (pathSplit1121 == 2){
                        printSum("You decide the swamp doesn’t offer any more life than death itself does. You wander on , and can almost taste the desert heat as you near the swamp’s edge, and you see the deserted ruins \r\n" + //
                                                        "of a town. The filth of the swamp seems to have swallowed up the town entirely, something is \r\n" + //
                                                        "not as it seems. A weathered and moss infested sign holds several wooden arrow-shaped signs \r\n" + //
                                                        "that point to various towns and cities, most point deeper into the swamp. One points outward, \r\n" + //
                                                        "into the desert, and reads Trent, city of the Gonti. The center of this town has a well, and its \r\n" + //
                                                        "water greatly aids your dying body. Upon scrounging some more, you find some moldy bread \r\n" + //
                                                        "and tainted meat, but it still suffices. You also find some leftover coin in a few house, whoever  \r\n" + //
                                                        "left here, left fast. Turning back towards the town’s sign, the description for Trent says it’s only a \r\n" + //
                                                        "day and half away, so you wander back into the desert…\r\n" + //
                                                        "");
                        Money += 5;
                        MoneyMessage();
                        RetrieveInv(Money);
                        TheEndV2(Money);
                    }
                }
                if (LifeStatus == true){
                    printSum("");
                }
            }

        }
        else if (pathSplit1 == 2){
            ClrScrn();
            printSum("A rounded, rusted metal door bids your welcome into the belly of this iron beast, and you\r\n" + //
                                "twist the round handle until it squeals open. All around you lie pieces of miscellaneous odds \r\n" + //
                                "and ends, and nothing to stand out to you, this seems to be a junk barge. At the end of the \r\n" + //
                                "room, you notice another smaller, and less mutilated metal door. Upon opening it, a small\r\n" + //
                                "neon green light flickers to life, and you see piles upon piles of shimmering gold and other\r\n" + //
                                "precious metals. Something clinks quite loudly from the upper decks of the barge, and you hear footsteps accompanied by yelling.\r\n" + //
                                "");

            int pathSplit1_2 = AskUser("Secure yourself in the gold vault", "Investigate the noise");

            if (pathSplit1_2 == 1){
                ClrScrn();
                printSum("You quickly throw the vault door shut, ensuring the gold lays trapped, along with you, in the \r\n" + //
                                        "room. The light flickers some more, and starts to slowly fade. You can tell this door locks from \r\n" + //
                                        "the outside, and in a quick act of desperation, you start to pile chests and larger golden relics in\r\n" + //
                                        "in front of the door, maybe these looters won’t find you. The yelling and clamoring gets louder, \r\n" + //
                                        "and then suddenly stops. You hear some light snickering and small, almost scurrying \r\n" + //
                                        "movements. A very faint ticking noise starts, and then the footsteps start again, this time, \r\n" + //
                                        "accompanied by louder jeers and laughs.The ticking stops, and a loud explosion sends the\r\n" + //
                                        "entire treasury at you.\r\n" + //
                                        "\r\n" + //
                                        "YOU DIED\r\n" + //
                                        "");
                LifeStatus = false;
            }
            else if (pathSplit1_2 == 2){
                ClrScrn();
                printSum("You tear open the rusted door, and a crowd of shady looking scavengers slink in. “Hey you, \r\n" + //
                                        "you’ve saved us quite a lot of time by cracking that door open, how ‘bout we repay the favor?”. \r\n" + //
                                        "They allow you to take a more than fair portion of the loot, and even offer you a ride into the \r\n" + //
                                        "nearest city. The ride takes a few days, and maybe you didn’t realize how large this desert really \r\n" + //
                                        "is. You arrive at the city of Trent, high, ancient stone walls cover the edges of the city, but \r\n" + //
                                        "the buildings inside are so crammed they appear to be oozing out of the walls. The scavengers\r\n" + //
                                        "say their goodbyes to you, and you begin to explore this place for yourself. After some \r\n" + //
                                        "wandering, you see a sign point to a large building residing in the central region of Trent. It \r\n" + //
                                        "resembles the city walls more than any other building, and appears to be very old.\r\n" + //
                                        "");
                Money += 15;
                MoneyMessage();
                RetrieveInv(Money);
                //remember to add the new function to calculate inventory and money count...
                //**You've unlocked access to the buy menu */
                int pathSplit1_2_2 = AskUser("Visit the Central Spire", "Wander around some more");
                if (pathSplit1_2_2 == 1){
                    TheEnd(Money);
                }
                else if (pathSplit1_2_2 == 2){
                    ClrScrn();
                    printSum("As you wander, darkness slowly creeps over Trent. You pass through an alley, trying to find a \r\n" + //
                                                "shortcut to the the bustling streets, when a large group of thieves emerges from the shadows, \r\n" + //
                                                "blocking your path. “Trent doesn’t often see newcomers, and when she does, they don’t leave.” \r\n" + //
                                                "The thieves slowly creep closer towards you, and it starts to look certain that this might be a \r\n" + //
                                                "fight you don’t win.\r\n" + //
                                                "");
                    RetrieveInv(Money);
                    int pathSplit1222 = AskUser("Stay and Fight", "Attempt to bribe");
                    if (pathSplit1222 == 1 ){
                        ClrScrn();
                        printSum("You’ve handled punks like this on barges before, the only issue is there’s about four more of \r\n" + //
                                                        "them then there is of you. You stand your ground pretty well, but they eventually overwhelm you.\r\n" + //
                                                        "\r\n" + //
                                                        "YOU DIED\r\n" + //
                                                        "");
                        LifeStatus = false;
                    }
                    else if (pathSplit1222 == 2){
                        Money -= 5;
                        printSum("You’ve been in some pretty nasty fights onboard the junk barges, but you know when the odds \r\n" + //
                                                        "are lined up against you. You offer the thieves 5 of your gold, and they scurry off, leaving you, \r\n" + //
                                                        "and the rest of your small fortune, untouched. After wandering for a little longer, you slowly find \r\n" + //
                                                        "yourself being more and more drawn towards the center of the city….\r\n" + //
                                                        "");
                        
                        TheEnd(Money);
                    }
                }
                    
            }
        }
        else {
            printSum("How did you even get here?");
        }
 
    }

    
}