package io.battlerune.content.halloffame;

import java.util.Comparator;

/**
 * Compares 2 values to return the biggest
 * 
 * @author Nerik#8690
 *
 */
public class FameBoardComparer implements Comparator<FameBoardPlayer> {

	@Override
	public int compare(FameBoardPlayer o1, FameBoardPlayer o2) {
		return Integer.compare(o1.getKills(), o2.getKills());
	}

}
