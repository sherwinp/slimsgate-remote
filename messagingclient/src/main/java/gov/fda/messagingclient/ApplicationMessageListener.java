package gov.fda.messagingclient;
import java.util.logging.Logger;

import com.hazelcast.core.ITopic;
import com.hazelcast.core.Message;
import com.hazelcast.core.MessageListener;
public class ApplicationMessageListener implements MessageListener<String>{
	
	@Override
	public void onMessage(Message<String> message) {
		Logger log = Logger.getLogger(ApplicationMessageListener.class.getTypeName());
		log.info(String.format("------  Message in ApplicationNode -- java agent -----\n%s\n%s\n", 
				message.getMessageObject().toString(), 
				message.getPublishingMember().toString()));
	}

}
