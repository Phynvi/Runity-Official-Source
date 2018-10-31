package io.battlerune.content.activity.impl.duovsall;

public final class DuoVsAllData {

	/**
	 * @author Adam_#6723
	 * Stores the NPC Data for All Vs One
	 */
	
	public static enum WaveData {
		//Wave 1 = KBD / giant roc.
		//Wave 2 = corp , melee / mage 
		//Wave 3 = Three dagganoth monsters.
		//Wave 4 = Bandos God & Minions
		//Wave 5 = K'reeara and minions.
		//Wave 6 = Commander Zilayan and minions
		//Wave 7 = Zamorak Boss an minions
		//Wave 8 = barrows brotherS
		//Wave 9 = Mage trio 
		//Wave 10 = Zulrah and giant roc
		//wave 11 = cerberus and crazy arch
		//wave 12 = Vorkath & giant mole
		//wave 13 = Mage arena 2 bosses
		//wave 14 = cerberus, tstanon
		//wave 15 = kbd x2
		//wave 16 = lizaradman shaman x2
		//wave 17 = chaos fanataic, crazy arch.
		//wave 18 = skotizo
		//wave 19 = 
		//wave 22 = 
		WAVE_1(239, 763), WAVE_2(319), WAVE_3(2265, 2266, 2267), WAVE_4(2215, 2217, 2218, 2216),
		
		WAVE_5(3162, 3165, 3164, 3163), 
		WAVE_6(2205, 2206, 2207, 2208),
		WAVE_7(3129, 3132, 3130, 3131),
		WAVE_8(6766), 
		WAVE_9(6767, 6766), 
		WAVE_10(7938, 7940, 7939), WAVE_11(6619), WAVE_12(6618), 
		WAVE_13(7860, 7858, 7859),
		WAVE_14(5862, 3130, 2218, 2216),
		WAVE_15(239, 239),
		WAVE_16(6766, 6767),
		WAVE_17(6618, 6619),
		WAVE_18(7286),
		WAVE_19(6504), 
		WAVE_20(3127), 
		WAVE_21(7585, 8060, 3162), 
		WAVE_22(7700, 3127),
		WAVE_23(5862, 7935), 
		WAVE_24(7859),
		WAVE_25(7860),
		WAVE_26(7860, 7858, 7859),
		WAVE_27(8060), 
		WAVE_28(5129), 
		WAVE_29(8095),
		WAVE_30(3125, 3123, 2193, 2189),
		WAVE_31(3125, 3125),
		WAVE_32(3127, 3128, 3128, 3128, 3128, 3128),
		WAVE_33(239),
		WAVE_34(7039),
		WAVE_35(6618),
		WAVE_36(6619),
		WAVE_37(2042),
		WAVE_38(3127),
		WAVE_39(6609),
		WAVE_40(2265, 2266, 2267),
		WAVE_41(6615),
		WAVE_42(7860),
		WAVE_43(7286),
		WAVE_44(6504),
		WAVE_45(3162),
		WAVE_46(1207),
		WAVE_47(7936),
		WAVE_48(7940),
		WAVE_49(7932),
		WAVE_50(7937),
		WAVE_51(7939),
		WAVE_52(7935),
		WAVE_53(7934),
		WAVE_54(7931),
		WAVE_55(7938),
		WAVE_56(7585),
		WAVE_57(7859),
		WAVE_58(7860),
		WAVE_59(239),
		WAVE_60(7859, 7860),
		WAVE_61(8060),
		WAVE_62(3132),
		WAVE_63(3131),
		WAVE_64(5862),
		WAVE_65(3130),
		WAVE_66(6504),
		WAVE_67(7700, 3127),
		WAVE_68(5129),
		WAVE_69(8095),
WAVE_70(239, 763), WAVE_71(319), WAVE_72(3129), WAVE_73(2265, 2266, 2267), WAVE_74(2215, 2217, 2218, 2216),
		WAVE_75(3162, 3165, 3164, 3163), 
		WAVE_76(2205, 2206, 2207, 2208),
		WAVE_77(3129, 3132, 3130, 3131),
		WAVE_78(6766), 
		WAVE_79(6767, 6766), 
		WAVE_80(3125, 3123, 2193, 2189),
		WAVE_81(3125, 3125),
		WAVE_82(3127, 3128, 3128, 3128, 3128, 3128),
		WAVE_83(2265, 2266, 2267),
		WAVE_84(1672, 1673, 1674, 1675, 1676, 1677),
		WAVE_85(7938, 7940, 7939),
		WAVE_86(2265, 2266, 2267),
		WAVE_87(7700),
		WAVE_88(7700, 7700, 3127, 3127),
		WAVE_89(5129),
		WAVE_90(8095),
		WAVE_91(7700, 3128, 8095, 5129, 8060),


		
		
		
		;
		/* WAVE_2(6593, 6499), WAVE_3(2265, 2267, 2266, 5947), WAVE_4(6766, 6766),
		WAVE_5(4005, 7940, 7939), WAVE_6(6619, 6618, 5874, 5874), WAVE_7(2215, 2217, 2218, 2216),
		WAVE_8(2205, 2207), WAVE_9(3162, 3165, 3164, 3163), WAVE_10(3129, 3132, 3130, 3131),
		WAVE_11(6505, 7148, 7149, 7148), WAVE_12(6609, 1160, 1157, 1158), WAVE_13(3024, 6615, 6616, 6616),
		WAVE_14(5862, 7935), WAVE_15(5129), WAVE_16(8095);*/

		private final int[] monster;

		WaveData(int... monster) {
			this.monster = monster;
		}

		public int[] getMonster() {
			return monster;
		}

		public static WaveData getOrdinal(int ordinal) {
			for (WaveData wave : values()) {
				if (wave.ordinal() == ordinal)
					return wave;
			}
			return null;
		}
		
		public static WaveData getNext(int current) {
			return getOrdinal(current + 1);
		}
		
		public static WaveData getOrdinal1(int ordinal) {
			for (WaveData wave : values()) {
				if (wave.ordinal() == ordinal + 1)
					return wave;
			}
			return null;
		}
	}
}
