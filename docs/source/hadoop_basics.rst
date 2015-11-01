Apache Hadoop Basics
===========================

There are basic commands and web interfaces that you will frequently use while you run jobs on Apache Hadoop. This tutorial introduces the basic commands and web interfaces. You can find more details on the web e.g. `Hadoop Basics by HortonWorks <http://hortonworks.com/wp-content/uploads/downloads/2013/07/Hortonworks.ApacheHadoopBasics.v1.0.pdf>`_, or `Hadoop Tutorial by TutorialPoint.com <http://www.tutorialspoint.com/hadoop/>`_

Hadoop command
---------------

- Hadoop fs
   - ls
   - cat
   - rm

- hadoop jar
   - run jar

Hadoop built-in example
----------------------------

* Find Jar from /opt/hadoop/ i.e. /opt/hadoop/share/hadoop/mapreduce/hadoop-*examples*.jar

-   aggregatewordcount: An Aggregate based map/reduce program that counts the words in the input files.
-   aggregatewordhist: An Aggregate based map/reduce program that computes the histogram of the words in the input files.
-   bbp: A map/reduce program that uses Bailey-Borwein-Plouffe to compute exact digits of Pi.
-   dbcount: An example job that count the pageview counts from a database.
-   distbbp: A map/reduce program that uses a BBP-type formula to compute exact bits of Pi.
-   grep: A map/reduce program that counts the matches of a regex in the input.
-   join: A job that effects a join over sorted, equally partitioned datasets
-   multifilewc: A job that counts words from several files.
-   pentomino: A map/reduce tile laying program to find solutions to pentomino problems.
-   pi: A map/reduce program that estimates Pi using a quasi-Monte Carlo method.
-   randomtextwriter: A map/reduce program that writes 10GB of random textual data per node.
-   randomwriter: A map/reduce program that writes 10GB of random data per node.
-   secondarysort: An example defining a secondary sort to the reduce.
-   sort: A map/reduce program that sorts the data written by the random writer.
-   sudoku: A sudoku solver.
-   teragen: Generate data for the terasort
-   terasort: Run the terasort
-   teravalidate: Checking results of terasort
-   wordcount: A map/reduce program that counts the words in the input files.
-   wordmean: A map/reduce program that counts the average length of the words in the input files.
-   wordmedian: A map/reduce program that counts the median length of the words in the input files.
-   wordstandarddeviation: A map/reduce program that counts the standard deviation of the length of the words in the input files.
