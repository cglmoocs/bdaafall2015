.. _hadoop_basics:

Apache Hadoop Basics
===========================

There are basic commands and web interfaces that you will frequently use while you run jobs on Apache Hadoop. This tutorial introduces the basic commands and web interfaces. You can find more details on the web e.g. `Hadoop Basics by HortonWorks <http://hortonworks.com/wp-content/uploads/downloads/2013/07/Hortonworks.ApacheHadoopBasics.v1.0.pdf>`_, or `Hadoop Tutorial by TutorialPoint.com <http://www.tutorialspoint.com/hadoop/>`_

Hadoop commands
---------------

- Hadoop fs
   - ls
      - ``hadoop fs -ls FILENAME`` (-ls works like ls command to see a list of directory contents)
   - cat
      - ``hadoop fs -cat FILENAME`` (-cat works like cat command to see the contents of the file)
   - rm
      - ``hadoop fs -rmr DIRECTORY_NAME_TO_DELETE`` (-rmr works like rm -r command to delete directories and the files recursively

- hadoop jar
   - run a jar file which is a Java package e.g. WordCount is in hadoop-mapreduce-examples-2.7.1.jar
   
- Other commands related to file system can be found by:

.. code::

    $ hadoop fs
    Usage: hadoop fs [generic options]
      [-appendToFile <localsrc> ... <dst>]
    	     [-cat [-ignoreCrc] <src> ...]
    [-checksum <src> ...]
    [-chgrp [-R] GROUP PATH...]
    [-chmod [-R] <MODE[,MODE]... | OCTALMODE> PATH...]
    [-chown [-R] [OWNER][:[GROUP]] PATH...]
    [-copyFromLocal [-f] [-p] [-l] <localsrc> ... <dst>]
    [-copyToLocal [-p] [-ignoreCrc] [-crc] <src> ... <localdst>]
    [-count [-q] [-h] <path> ...]
    [-cp [-f] [-p | -p[topax]] <src> ... <dst>]
    [-createSnapshot <snapshotDir> [<snapshotName>]]
    [-deleteSnapshot <snapshotDir> <snapshotName>]
    [-df [-h] [<path> ...]]
    [-du [-s] [-h] <path> ...]
    [-expunge]
    [-find <path> ... <expression> ...]
    [-get [-p] [-ignoreCrc] [-crc] <src> ... <localdst>]
    [-getfacl [-R] <path>]
    [-getfattr [-R] {-n name | -d} [-e en] <path>]
    [-getmerge [-nl] <src> <localdst>]
    [-help [cmd ...]]
    [-ls [-d] [-h] [-R] [<path> ...]]
    [-mkdir [-p] <path> ...]
    [-moveFromLocal <localsrc> ... <dst>]
    [-moveToLocal <src> <localdst>]
    [-mv <src> ... <dst>]
    [-put [-f] [-p] [-l] <localsrc> ... <dst>]
    [-renameSnapshot <snapshotDir> <oldName> <newName>]
    [-rm [-f] [-r|-R] [-skipTrash] <src> ...]
    [-rmdir [--ignore-fail-on-non-empty] <dir> ...]
    [-setfacl [-R] [{-b|-k} {-m|-x <acl_spec>} <path>]|[--set <acl_spec> <path>]]
    [-setfattr {-n name [-v value] | -x name} <path>]
    [-setrep [-R] [-w] <rep> <path> ...]
    [-stat [format] <path> ...]
    [-tail [-f] <file>]
    [-test -[defsz] <path>]
    [-text [-ignoreCrc] <src> ...]
    [-touchz <path> ...]
    [-truncate [-w] <length> <path> ...]
    [-usage [cmd ...]]

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

Hadoop Web Interface
------------------------

- ResourceManager: 8088 e.g. http://149.165.159.121:8088/cluster
- NameNode: 50070 e.g. http://149.165.159.149:50070/
- JobHistoryServer: 19888
