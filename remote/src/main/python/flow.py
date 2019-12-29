import sys
import os
from slims.slims import Slims, _SlimsApi
from slims.flowrun import FlowRun

'''
https://buildmedia.readthedocs.org/media/pdf/slims-python-api/latest/slims-python-api.pdf

to communicate using https: in dev environment:

>>> from requests.utils import DEFAULT_CA_BUNDLE_PATH
>>> print(DEFAULT_CA_BUNDLE_PATH)
use location of certifi package cacert file to add selfsigned certs for server endpoint as neccessary.
This will require downloading server's cert and added pem formart cert to end of certifi pem file.
'''

def execute(flow_run):
   pass

def main():
   
   print("main: hello from python\n", file=sys.stdout, flush=True)
   
   slims = Slims("bigtest", "http://127.0.0.1:5703")
   

   print("main: bye from python\n", file=sys.stdout, flush=True)     
main()
