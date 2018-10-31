package io.battlerune.content.mysterybox2.impl;

import io.battlerune.content.mysterybox2.MysteryBox;
import io.battlerune.game.world.items.Item;

/**
 *  All Vs One Box
 * @author Adam_#6723
 */
public class DoubleThreat extends MysteryBox {
    @Override
    protected String name() {
        return "Double Threat Box";
    }

    @Override
    protected int item() {
        return 6855;
    }

    @Override
    protected int rareValue() {
        return 20_000_000;
    }

    @Override
    protected Item[] rewards() {
        return new Item[]{
                new Item(995, 1000000), // COINS
                new Item(11907, 1), // TRIDENT_OF_THE_SEAS
                new Item(13265, 1), // ABYSSAL_DAGGER
                new Item(11791, 1), // STAFF_OF_THE_DEAD
                new Item(11824, 1), // ZAMORAKIAN_SPEAR
                new Item(11832, 1), // BANDOS_CHESTPLATE
                new Item(11834, 1), // BANDOS_TASSETS
                new Item(11826, 1), // ARMADYL_HELMET
                new Item(11828, 1), // ARMADYL_CHESTPLATE
                new Item(11830, 1), // ARMADYL_CHAINSKIRT
                new Item(11785, 1), // ARMADYL_CROSSBOW
                new Item(11838, 1), // SARADOMIN_SWORD
                new Item(11802, 1), // ARMADYL_GODSWORD
                new Item(11804, 1), // BANDOS_GODSWORD
                new Item(11806, 1), // SARADOMIN_GODSWORD
				new Item(10557, 1), // collector icon
				new Item(21024, 1), // ancestral robe bottom
				new Item(21021, 1), // ancestral top
				new Item(21018, 1), // ancestral hat
                new Item(11808, 1), // ZAMORAK_GODSWORD
                new Item(13739, 1),
                new Item(13832, 1),
                new Item(13805, 1),
                new Item(13816, 1),
				new Item(21000, 1), // twisted buckler
				new Item(21006, 1), // kodai wand
				new Item(21003, 1), // elder maul
				new Item(21015, 1), // Dinh bulwark
				new Item(20997, 1), // twisted bow
				new Item(12817, 1), // ely ss
				new Item(12821, 1), // spectral ss
				new Item(12825, 1), // arcane ss
				new Item(12819, 1), // ely sigil
				new Item(12823, 1), // spectral sigil
				new Item(12827, 1), // arcane sigil
				new Item(21225, 1),
				new Item(13703, 1), 
				new Item(13704, 1), 
				new Item(13705, 1), 
				new Item(13687, 1),
				new Item(13686, 1),
				new Item(20035, 1), // Samurai kasa
				new Item(20038, 1), // Samurai shirt
				new Item(20044, 1), // Samurai greaves
				new Item(20041, 1), // Samurai gloves
				new Item(20047, 1), // Samurai boots
				new Item(13576, 1), // Dragon warhammer
				new Item(1050, 1), // Santa hat
				new Item(12890, 1), // santa gloves
				new Item(13652, 1), // dragon claws
				new Item(12888, 1), // Santa jacket
				new Item(12891, 1), // Santa boots
				new Item(12821, 1), // spectral ss
				new Item(12825, 1), // arcane ss
				new Item(13343, 1), // black santa hat
				new Item(10556, 1), // attacker icon
				new Item(10557, 1), // collector icon
				new Item(10558, 1), // defender icon
				new Item(10559, 1), // healer icon
				new Item(11810, 1), // Arma hilt
				new Item(11812, 1), // Bandos hilt
				new Item(11814, 1), // Sara hilt
				new Item(11816, 1), // Zam hilt
				new Item(13235, 1), // eternal boots
				new Item(13237, 1), // peg boots
				new Item(13239, 1), // prim boots
				new Item(13652, 1), // Dragon Claws
				new Item(11785, 1), // Arma crossbow
				new Item(12926, 1), // Toxic blowpipe
				new Item(21079, 1), // arcane prayer scroll
				new Item(21034, 1), // dexterous prayer scroll
				new Item(1055, 1), // blue h'ween
				new Item(1959, 1), // pumpkin
				new Item(21012, 1), // Dragon hunter cbow
				new Item(11283, 1), // DFS
				new Item(21021, 1), // ancestral top
				new Item(21018, 1), // ancestral hat
				new Item(12002, 1), // occult necklace
				new Item(21024, 1), // ancestral robe bottom
				new Item(11785, 1), // Arma crossbow
				new Item(13202, 1), // ring of gods (i)
				new Item(19707, 1), // eternal glory
				new Item(11889, 1), // zam hasta
				new Item(11791, 1), // SOTD
				new Item(19710, 1), // ring of suffering (i)
				new Item(12831, 1), // blessed ss
		        new Item(2581, 1), // Robin hood hat
		        new Item(19707, 1), // Amulet of eternal glory
				new Item(12926, 1), // Toxic blowpipe
				new Item(11283, 1), // DFS
				new Item(12357, 1), // katana
				new Item(21021, 1), // ancestral top
				new Item(21018, 1), // ancestral hat
				new Item(11840, 1), // Dragon boots
				new Item(12881, 1), // Ahrim set
				new Item(12883, 1), // Kail's set
				new Item(12873, 1), // Guthen set
				new Item(12879, 1), // Torag set
				new Item(12875, 1), // Verac set
				new Item(13831, 1),
				new Item(13833, 1),
				new Item(13207, 1),
				new Item(22125, 1),
				new Item(13740 ,1),
				new Item(13739 ,1),
				new Item(16647 ,1),
				new Item(16648, 1), new Item(16647, 1), new Item(16649, 1), new Item(16650, 1),
				new Item(16651, 1), new Item(16653, 1), new Item(16654, 1), new Item(16655, 1), new Item(16656, 1),
				new Item(21225 ,1),
				new Item(13805 ,1),
				new Item(13713 ,1),
				new Item(13703, 1), new Item(13704, 1), new Item(13705, 1), new Item(13687, 1),
				new Item(13686, 1),
				new Item(17157, 1), new Item(17162, 1), new Item(17159, 1), new Item(17158, 1),
				new Item(13207, 1), new Item(13209, 1), new Item(13210, 1), new Item(13213, 1),
				new Item(13212, 1), new Item(13214, 1), new Item(13661, 1), new Item(13662, 1),
				new Item(13190, 1),
				new Item(13191, 1),

        };
    }
}
