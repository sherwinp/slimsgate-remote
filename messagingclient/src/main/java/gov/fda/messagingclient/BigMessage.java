package gov.fda.messagingclient;

import java.io.Serializable;

public class BigMessage implements Serializable {
	private static final long serialVersionUID = 1L;
	private final int pk;
	private final String id;
	private final String description;
	public BigMessage(int pk, String id, String description){
		super();
		this.pk = pk;
		this.id = id.trim().replace((CharSequence)"\"", (CharSequence)"");
		this.description = description.trim().replace((CharSequence)"\"", (CharSequence)"");
	}
	@Override
	public String toString() {
		return String.format("{\"type\":\"%s\", \"pk\":\"%s\", \"id\":\"%s\",\"description\":\"%s\"}", 
				BigMessage.class.getCanonicalName(), pk, id, description);
	}
}
