import os, sys
import time
import threading
import hazelcast

environ = os.environ

from hazelcast.config import ClientProperties

from gov.fda.messagingclient import BigMessage


    # Function to be called when a message is published
def print_on_message(topic_message):
    print("main: Got message:" + topic_message.message + " \n", file=sys.stdout, flush=True)
   

def DoTopicHandling():
   config = hazelcast.ClientConfig()
   environ[ClientProperties.INVOCATION_TIMEOUT_SECONDS.name] = "2"
   client=hazelcast.client.HazelcastClient(config)
   if client:            

        topic = client.get_topic("STARTFLOW.Q")
    
        topic.add_listener(print_on_message)
        time.sleep(3)            
        topic.publish(BigMessage(1234, "ME","Hello to world").toString()) 
        time.sleep(5)

def DoQueueHandling():
   config = hazelcast.ClientConfig()
   environ[ClientProperties.INVOCATION_TIMEOUT_SECONDS.name] = "2"
   client=hazelcast.client.HazelcastClient(config)
   if client:            

        queue = client.get_queue("FLOW")
    
        queue.add_listener(print_on_message)
        time.sleep(3)            
        queue.offer(BigMessage(1234, "ME","Hello to world").toString()) 
        time.sleep(5)

def DoCheckQueue():
   config = hazelcast.ClientConfig()
   environ[ClientProperties.INVOCATION_TIMEOUT_SECONDS.name] = "2"
   client=hazelcast.client.HazelcastClient(config)
   if client:            
    queue = client.get_queue("FLOW")
    if queue:
        print("main: from python\n Queue FLOW:" + str(queue.take().result()) , file=sys.stdout, flush=True)
       
   
def main():
    print("main: hello from python\n", file=sys.stdout, flush=True)
    DoCheckQueue()
    print("main: bye from python\n", file=sys.stdout, flush=True)
main()