.. _dfsio:

Distributed I/O Benchmark of HDFS 
========================================

DFSIO is a built-in benchmark tool for HDFS I/O test. The jar file can be found at /opt/hadoop/share/hadoop/mapreduce/hadoop-mapreduce-client-jobclient-2.7.1.jar. 

Default Directory
----------------------

``/benchmarks/TestDFSIO``

Use fs commands to see the contents e.g. 

.. code::

     hadoop fs -cat /benchmarks/TestDFSIO/io_write/part*

.. https://support.pivotal.io/hc/en-us/articles/200864057-Running-DFSIO-mapreduce-benchmark-test

Run Write/Read
---------------

.. code::

    hadoop jar /opt/hadoop/share/hadoop/mapreduce/hadoop-mapreduce-client-jobclient-2.7.1.jar TestDFSIO -write -nrFiles 16 -fileSize 1GB -resFile /tmp/$USER-dfsio-write.txt

OR

.. code::

    hadoop jar /opt/hadoop/share/hadoop/mapreduce/hadoop-mapreduce-client-jobclient-2.7.1.jar TestDFSIO -read -nrFiles 16 -fileSize 1GB -resFile /tmp/$USER-dfsio-read.txt

Clean Up
---------

This command deletes files on the output directory (/benchmakrs/TestDFSIO) on HDFS.

.. code::

   hadoop jar /opt/hadoop/share/hadoop/mapreduce/hadoop-mapreduce-client-jobclient-2.7.1.jar TestDFSIO -clean
   
Options
---------

* -nrFiles: the number of files (equal to the number of map tasks)
* -fileSize: the size of a file to generate B|KB|MB|GB|TB is allowed

Useful Links
--------------

* http://www.michael-noll.com/blog/2011/04/09/benchmarking-and-stress-testing-an-hadoop-cluster-with-terasort-testdfsio-nnbench-mrbench/
* https://support.pivotal.io/hc/en-us/articles/200864057-Running-DFSIO-mapreduce-benchmark-test
