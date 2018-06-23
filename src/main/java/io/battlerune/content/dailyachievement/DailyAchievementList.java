package io.battlerune.content.dailyachievement;

import com.google.common.collect.ImmutableSet;

import io.battlerune.game.world.entity.skill.Skill;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Holds all the Daily achievements
 *
 * @author Adam - discord = Adam_#6723
 */
public enum DailyAchievementList {
    /* Easy achievements */
    KILL_A_MAN(100, DailyAchievementKey.KILL_A_MAN, DailyAchievementDifficulty.EASY, "Kill 100 Men"),
    BURY_BONES(100, DailyAchievementKey.BURY_BONES, DailyAchievementDifficulty.EASY, "Bury 100S bones (any)"),
    BURN_AN_OAK_LOG(50, DailyAchievementKey.BURN_AN_OAK_LOG, DailyAchievementDifficulty.EASY, "Burn 50 Oak Log"),
    CATCH_A_SALMON(100, DailyAchievementKey.CATCH_A_SALMON, DailyAchievementDifficulty.EASY, "Catch 100 Salmon Fish"),  
    TRIVIABOT(25, DailyAchievementKey.TRIVIABOT, DailyAchievementDifficulty.EASY, "Answer 25 TriviaBot questions"),
    HIGH_ALCHEMY(100, DailyAchievementKey.HIGH_ALCHEMY, DailyAchievementDifficulty.EASY, "Cast high alchemy spell 100 times"),
    SKILL_MASTERY(3, DailyAchievementKey.SKILL_MASTERY, DailyAchievementDifficulty.EASY, "Achieve level 99 in 3 skill"),
    KILLER(10, DailyAchievementKey.KILLER, DailyAchievementDifficulty.EASY, "Kill 10 players"),
    CUT100TREES1(500, DailyAchievementKey.CUT100TREES, DailyAchievementDifficulty.EASY, "Chop down 500 trees"),
    KILL_KRAKEN_I(25, DailyAchievementKey.KILL_KRAKEN, DailyAchievementDifficulty.EASY, "Kill Kraken 25 Times"),
    STEAL_FROM_STALL(30, DailyAchievementKey.STEAL_FROM_STALL, DailyAchievementDifficulty.EASY, "Steal from a stall"),

    /* Medium achievements */
    CUT100TREES(500, DailyAchievementKey.CUT100TREES, DailyAchievementDifficulty.MEDIUM, "Cut 500 Trees (any)"),
    BURN100ANY(500, DailyAchievementKey.BURN100ANY, DailyAchievementDifficulty.MEDIUM, "Burn 500 logs (any)"),
    MINE_100_ORE(500, DailyAchievementKey.MINE_100_ORE, DailyAchievementDifficulty.MEDIUM, "Mine 500 ore (any)"),
   // FLETCH250ADAMANET(500, DailyAchievementKey.FLETCH250ADAMANET, DailyAchievementDifficulty.MEDIUM, "Fletch 500 Adamanet Cbows"),   
    SKILL_MASTERY_I(3, DailyAchievementKey.SKILL_MASTERY, DailyAchievementDifficulty.MEDIUM, "Achieve level 99 in 3 skills"),
    TRIVIABOT_I(100, DailyAchievementKey.TRIVIABOT, DailyAchievementDifficulty.MEDIUM, "Answer 100 TriviaBot questions"),
    KILLER_I(50, DailyAchievementKey.KILLER, DailyAchievementDifficulty.MEDIUM, "Kill 50 players"),
    WOODCUTTING_I(1000, DailyAchievementKey.CUT100TREES, DailyAchievementDifficulty.MEDIUM, "Chop down 1000 trees"),
    CRYSTAL_CHEST_I(50, DailyAchievementKey.CRYSTAL_CHEST, DailyAchievementDifficulty.MEDIUM, "Open 50 crystal chests"),
    KILL_GLOD(100, DailyAchievementKey.KILL_GLOD, DailyAchievementDifficulty.MEDIUM, "Kill the glod 25 Times"),
    CRAFT_BLOODRUNE(500, DailyAchievementKey.CRAFT_BLOODRUNE, DailyAchievementDifficulty.MEDIUM, "Craft 500 Blood runes"),
    HIGH_ALCHEMY_I(500, DailyAchievementKey.HIGH_ALCHEMY, DailyAchievementDifficulty.MEDIUM, "Cast high alchemy spell 500 times"),
    STEAL_FROM_STALL1(250, DailyAchievementKey.STEAL_FROM_STALL, DailyAchievementDifficulty.MEDIUM, "Steal from 250 stall"),




    /* Hard achievements */
    SKILL_MASTERY_II(Skill.SKILL_COUNT, DailyAchievementKey.SKILL_MASTERY, DailyAchievementDifficulty.HARD, "Achieve level 99 in all skills"),
    EXPERIENCE_MASTERY(5, DailyAchievementKey.EXPERIENCE_MASTERY, DailyAchievementDifficulty.HARD, "Earn 200M EXP in 5 skills"),
    TRIVIABOT_II(100, DailyAchievementKey.TRIVIABOT_II, DailyAchievementDifficulty.HARD, "Answer 100 TriviaBot questions"),
    KILLER_II(150, DailyAchievementKey.KILLER, DailyAchievementDifficulty.HARD, "Kill 150 players"),
    WOODCUTTING_II(1500, DailyAchievementKey.WOODCUTTING, DailyAchievementDifficulty.HARD, "Chop down 1,500 trees"),
    CRYSTAL_CHEST_II(150, DailyAchievementKey.CRYSTAL_CHEST, DailyAchievementDifficulty.HARD, "Open 150 crystal chests"),
    COMPLETE_RFD_MINIQUEST(1, DailyAchievementKey.COMPLETE_RFD, DailyAchievementDifficulty.HARD, "Complete RFD Miniquest"),
    KILL_SKOTIZO(250, DailyAchievementKey.KILL_SKOTIZO, DailyAchievementDifficulty.HARD, "Kill the Skotizo 100 Times"),

    /* Elite achievements */
    BOSSPOINT(5000, DailyAchievementKey.BOSSPOINT, DailyAchievementDifficulty.ELITE, "Gain 5000 Boss Points"),
    EXPERIENCE_MASTERY_II(Skill.SKILL_COUNT, DailyAchievementKey.EXPERIENCE_MASTERY, DailyAchievementDifficulty.ELITE, "Earn 200M EXP in all skills"),
    TRIVIABOT_III(1000, DailyAchievementKey.TRIVIABOT, DailyAchievementDifficulty.ELITE, "Answer 1000 TriviaBot questions"),
    KILLER_III(1000, DailyAchievementKey.KILLER, DailyAchievementDifficulty.ELITE, "Kill 1,000 players"),
    KILLER_IV(2500, DailyAchievementKey.KILLER, DailyAchievementDifficulty.ELITE, "Kill 2500 players"),
    WOODCUTTING_III(5000, DailyAchievementKey.CUT100TREES, DailyAchievementDifficulty.ELITE, "Chop down 5,000 trees"),
    KILL_GANO(1000, DailyAchievementKey.KILL_GANO, DailyAchievementDifficulty.ELITE, "Kill the Gano 1000 Times"),
    CUT100TREES2(5000, DailyAchievementKey.CUT100TREES, DailyAchievementDifficulty.ELITE, "Cut 5000 Trees (any)"),
    STEAL_FROM_STALL2(5000, DailyAchievementKey.STEAL_FROM_STALL, DailyAchievementDifficulty.ELITE, "Steal from 5000 stall"),
    HIGH_ALCHEMY_II(5000, DailyAchievementKey.HIGH_ALCHEMY, DailyAchievementDifficulty.ELITE, "Cast high alchemy spell 5000 times"),

    
;
    /** Caches our enum values. */
    private static final ImmutableSet<DailyAchievementList> VALUES = ImmutableSet.copyOf(values());

    /** The amount required to complete the achievement. */
    private final int amount;

    /** The key of this achievement */
    private final DailyAchievementKey key;

    /** The achievement difficulty. */
    private final DailyAchievementDifficulty difficulty;

    /* The achievement task string. */
    private final String task;

    /** Constructs a new <code>AchievementList<code>. */
    DailyAchievementList(int amount, DailyAchievementKey key, DailyAchievementDifficulty difficulty, String task) {
        this.amount = amount;
        this.key = key;
        this.difficulty = difficulty;
        this.task = task;
    }

    /** Gets the amount required to complete the achievement. */
    public int getAmount() {
        return amount;
    }

    /** Gets the achievement key. */
    public DailyAchievementKey getKey() {
        return key;
    }

    /** Gets the achievement difficulty */
    public DailyAchievementDifficulty getDifficulty() {
        return difficulty;
    }

    /** Gets the achievement task. */
    public String getTask() {
        return task;
    }

    /** Gets the achievements as a list. */
    public static List<DailyAchievementList> asList(DailyAchievementDifficulty difficulty) {
        return VALUES.stream().filter(a -> a.getDifficulty() == difficulty).sorted(Comparator.comparing(Enum::name)).collect(Collectors.toList());
    }

    /** Gets the total amount of achievements. */
    public static int getTotal() {
        return values().length;
    }
}