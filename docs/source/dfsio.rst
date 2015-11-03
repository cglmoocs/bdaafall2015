.. _dfsio:

Distributed I/O Benchmark of HDFS (TBD)
========================================

DFSIO is a built-in benchmark tool for HDFS I/O test. 

https://support.pivotal.io/hc/en-us/articles/200864057-Running-DFSIO-mapreduce-benchmark-test

Run Write
------------

.. code::

    hadoop jar /opt/hadoop/share/hadoop/mapreduce/hadoop-mapreduce-client-jobclient-2.7.1.jar TestDFSIO -write -nrFiles 16 -fileSize 1GB -resFile /tmp/TestDFSIOwrite.txt
