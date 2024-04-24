sudo apt-get remove openjdk*

sudo apt update

sudo apt install openjdk-8-jdk openjdk-8-jre

Terminal 1:
>> idlj -fall ReverseModule.idl

>> javac *.java ReverseModule/*.java

>> orbd -ORBInitialPort 1056&

>> java ReverseServer -ORBInitiaPort 1056&

>> Reverse Object Created

Terminal 2:
>> java ReverseClient -ORBInitialPort 1056 -ORBInitialHost localhost
