package io.battlerune.content.eventboss;

/**
 * Holds the Boss Data for the Event interface
 * @author Adam_#6723
 *
 */
public enum EventBossData {


   GALVEK_INFO( "Galvek", new String[] {
			"123", "test yo negur ass"
		   }),
	
	ARENA_INFO( "Arena", new String[] {
           ""
			}),
	
	SKOTIZO_INFO("Skotizo", new String[] {
		""	
	
	}),
	
	
	
	;

	private String npcName;
	private String[] content;

	EventBossData(String npcName, String[] content) {
		this.npcName = npcName;
		this.content = content;
	}



	public String getnpcName() {
		return npcName;
	}

	public String[] getContent() {
		return content;
	}

}
