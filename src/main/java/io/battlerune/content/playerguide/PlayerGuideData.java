package io.battlerune.content.playerguide;
 
/**
 * Stores the player guide data
 *
 * @author Nerik#8690 & Herb#7084
 *
 */
public enum PlayerGuideData {
 
   
    Introduction(-9485, PlayerGuideDifficulty.EASY, "Introduction",
            new String[] { "If you need any information based on Runity,",
                    "select one of the related options",
                    "on the left hand side",
                    "",
                    "I will then give you information on",
                    "the topic within this section.", }),
 
    Economy_Information(-9484, PlayerGuideDifficulty.EASY, "Main Currency?",
            new String[] { "Our economy is built by the players,", "We have introduced 1Bill and 500 Mill Tickets.",
                    "Bosses mainly drop these tickets", "They can also be obtained from MBoxe's",
                    "& From donating & Voting.", "They can be spent in various shops ", "all over Runity",
                    "such as the Rare Store and Customs store", "& PVM & Misc Items Store!", "","","","","","","","","" }),
 
    Money_Making(-9483, PlayerGuideDifficulty.EASY, "Making Bank?",
            new String[] { "There are various ways in which a player can obtain money on runity.",
                    "One of most effective ways is PvM'ing", "& Skilling.",
                    "Runity Has over 30+ Bosses with various drops.", "NPC Drops can be found here ::drops",
                    "teleports can be accessed on the bottom left Tab.",
                    "Custom Item's can be obtained from these bosses,", "Aswell as Mystery boxes.",
                    "There are more money making guide's", "by watching Jordan's Video.","","","","","","","",""}),
   
    Voting(-9482, PlayerGuideDifficulty.EASY, "voting",
            new String[] { "The command ::vote allows you to access the",
                    "vote page. Voting for out world will increase the",
                    "amount of players venturing the land.",
                    "",
                    "Voting will also allow you to recieve vote",
                    "points which can use to obtain various,",
                    "unobtainable items from the onlinecstore.","","","","","","","","","" }),
   
    Achievements(-9481, PlayerGuideDifficulty.EASY, "Achievements",
            new String[] { "Achievements are completed through various",
                    "types of activity. You may view the list by",
                    "clicking on tjhe tab next to your inventory.",
                    "Each achievements will list the task, your",
                    "progression and the reward points when completed.","","","","","","","","",""}),
   
    Player_Functions(-9480, PlayerGuideDifficulty.EASY, "Player Functions",
            new String[] { "You may interact with other plyers in Runity.",
                    "Functions such as trading, dueling, folowing",
                    "and messaging players are most common.",
                    "Other functions include clan chats, useful when",
                    "teaming up with players for events such as the",
                    "Wilderness, bossing, minigames and more.","","","","","","","","",""}),
   
    Teleporting(-9479, PlayerGuideDifficulty.EASY, "Teleporting",
            new String[] { "To teleport, use a spellbook button to open up the teleport",
                    "interface.","","","","","","","","",""}),
   
    Shops(-9478, PlayerGuideDifficulty.EASY, "Shops",
            new String[] { "Shops are located north west of Edgeville bank. You may",
                    "teleport there using ::shops",
                    "",
                    "You will find most Npcs you would need at the ::Shops area.",
                    "Be sure to right click the Npcs and fully explore their",
                    "options!","","","","","","","","",""}),
   
    Minigames(-9477, PlayerGuideDifficulty.EASY, "Minigames",
            new String[] { "The most popular minigames on Runity is",
                    "staking at ::duel and gambling at ::gamble",
                    "Use your money wisely and never go all in!","","","","","","","","",""}),
   
    Altar(-9476, PlayerGuideDifficulty.EASY, "Altar",
            new String[] { "The altar located in the building north of Edgeville bank.","","","","","","","","",""}),
   
    Commands(-9475, PlayerGuideDifficulty.EASY, "Commands",
            new String[] { "You may view the entire command list by typing in",
                           "::commands.","","","","","","","","",""}),
   
    Donate(-9474, PlayerGuideDifficulty.EASY, "Donate",
            new String[] { "You can help support Runity and help it grow by",
                           "Donating. You will be rewarded alot of wealth.",
                           "There are also tonnes of perks for Donators!",
                           "Type in ::donate to view the full list of perks!","","","","","","","","",""}),
   
    Help_me(-9473, PlayerGuideDifficulty.EASY, "Help me",
            new String[] { "- Contact a staff member on ::staff",
                           "- Ask a question in the Runity clan chat for",
                           "other veteran players to answer you.",
                           "- Contat a staff member on ::discord",
                           "- Ask for help on the ::forums","","","","","","","","",""}),
    ;
 
 
    private int buttonId;
    private PlayerGuideDifficulty difficulty;
    private String title;
    private String[] content;
 
    PlayerGuideData(int buttonId, PlayerGuideDifficulty difficulty, String title, String[] content) {
        this.buttonId = buttonId;
        this.difficulty = difficulty;
        this.title = title;
        this.content = content;
    }
 
    public int getButtonId() {
        return buttonId;
    }
 
    public PlayerGuideDifficulty getDifficulty() {
        return difficulty;
    }
 
    public String getTitle() {
        return title;
    }
 
    public String[] getContent() {
        return content;
    }
 
}