from datetime import datetime
import getpass
import socket

# Run python FirstProgramWithSystemInfo.py
print ('My first program with System Information!')

print ("Today is: " + str(datetime.now()))
print ("Username is: " + getpass.getuser())
print ("Hostname is: " + socket.gethostname())
