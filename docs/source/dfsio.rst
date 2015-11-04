.. _dfsio:

Distributed I/O Benchmark of HDFS 
========================================

DFSIO is a built-in benchmark tool for HDFS I/O test. The jar file can be found at /opt/hadoop/share/hadoop/mapreduce/hadoop-mapreduce-client-jobclient-2.7.1.jar. 

Base Directory to Store Test Results
-----------------------------------------------

``/benchmarks/TestDFSIO``

If there are outputs, use fs commands to see the contents e.g. 

.. code::

     hadoop fs -cat /benchmarks/TestDFSIO/io_write/part*


Run Write/Read
---------------

Read or Write test can be done by:

.. code::

    hadoop jar /opt/hadoop/share/hadoop/mapreduce/hadoop-mapreduce-client-jobclient-2.7.1.jar TestDFSIO -write -nrFiles 16 -fileSize 1GB -resFile /tmp/$USER-dfsio-write.txt

OR

.. code::

    hadoop jar /opt/hadoop/share/hadoop/mapreduce/hadoop-mapreduce-client-jobclient-2.7.1.jar TestDFSIO -read -nrFiles 16 -fileSize 1GB -resFile /tmp/$USER-dfsio-read.txt

.. note:: Change the number of files and the size of files to find better throughput.

Clean Up
---------

Don't forget to clean up test results after the completion, otherwise available storage space will be consumsed by the benchmark output files. The following command deletes files on the output directory (/benchmakrs/TestDFSIO) on HDFS.

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
