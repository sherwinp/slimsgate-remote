package gov.fda.client;

import gov.fda.messagingclient.ApplicationNode;

public class MessagingHost implements Runnable {

	@Override
	public void run() {
		ApplicationNode.main(new String[] {});
		
	}
}