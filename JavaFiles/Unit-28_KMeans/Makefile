JAVAC=javac
JVM=java
CLASSPATH=".:$(HOME)/Dependencies/*:./lib/*"
sources = $(wildcard *.java)
classes = $(sources:.java=.class)

PRG1=KMeans

all: $(classes)

lib:
	curl http://repo.maven.apache.org/maven2/org/apache/mahout/mahout-distribution/0.7/mahout-distribution-0.7.tar.gz -o mahout-distribution-0.7.tar.gz
	tar xvzf mahout-distribution-0.7.tar.gz --strip-components=1 mahout-distribution-0.7/lib/
	rm -f mahout-distribution-0.7.tar.gz

run : lib all
	$(JVM) -classpath $(CLASSPATH) $(PRG1)

clean :
	rm -f *.class
	rm -rf kmeans/output
	rm -rf kmeans/input
	rm -rf kmeans/clusters

%.class : %.java
	$(JAVAC) -classpath $(CLASSPATH) $<
