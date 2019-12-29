package gov.fda.messagingclient;

import java.io.File;

import com.hazelcast.config.Config;
import com.hazelcast.config.GroupConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class ApplicationNode{
	public static void main(String[] args) {
		System.setProperty("hazelcast.config", String.format( "classpath:%s", "hazelcast.xml"));
		HazelcastInstance  hzInstance = Hazelcast.newHazelcastInstance();
	}
}