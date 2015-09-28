JAVAC=javac
JVM=java
PRG1=HiggsClassIVSeeds
CLASSPATH=".:$(HOME)/Dependencies/*"
sources = $(wildcard *.java)
classes = $(sources:.java=.class)

all: $(classes)

run : all
	$(JVM) -classpath $(CLASSPATH) $(PRG1)

clean :
	rm -f *.class

%.class : %.java
	$(JAVAC) -classpath $(CLASSPATH) $<
