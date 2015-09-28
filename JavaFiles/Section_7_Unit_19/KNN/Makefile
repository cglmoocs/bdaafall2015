JAVAC=javac
JVM=java
CLASSPATH=".:$(HOME)/Dependencies/*"
sources = $(wildcard *.java)
classes = $(sources:.java=.class)

PRG1=KNNClient

all: $(classes)

run : all
	$(JVM) -classpath $(CLASSPATH) $(PRG1)

clean :
	rm -f *.class

%.class : %.java
	$(JAVAC) -classpath $(CLASSPATH) $<
