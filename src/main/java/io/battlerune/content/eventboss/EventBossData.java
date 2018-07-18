package io.battlerune.content.eventboss;

/**
 * Holds the Boss Data for the Event interface
 * @author Adam_#6723
 *
 */
public enum EventBossData {


   GALVEK_INFO(1, "Galvek", new String[] {
			"Combat Lvl: @whi@609", "Health: @whi@1200", "Max Hit: @whi@54"
		   }),
	
	ARENA_INFO(1, "Arena", new String[] {
           ""
			}),
	
	SKOTIZO_INFO(1, "Skotizo", new String[] {
		""	
	
	}),
	
	
	
	;

	private int npcid;
	private String npcName;
	private String[] content;

	EventBossData(int npcid, String npcName, String[] content) {
		this.npcid = npcid;
		this.npcName = npcName;
		this.content = content;
	}



	public String getnpcName() {
		return npcName;
	}

	public String[] getContent() {
		return content;
	}
	
	public int getnpci() {
		return npcid;
	}

}
