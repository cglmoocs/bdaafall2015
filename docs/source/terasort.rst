.. _terasort:

TeraSort Hadoop Benchmark Example
===============================================================================

Hadoop provides terabyte (TB) sort competition to run Hadoop benchmarking with
sorting large data files e.g. 1TB or 1PB (1000x 1TB). The performance of HDFS
and MapReduce workloads are evaluated with the speed of TeraSort computation,
for example, sorting 1 terabyte was done in 3.48 minutes in 2008 by Yahoo! Inc.
with 910 x 4 dual-core processors, but sorting 494.6 terabytes was done in the
same amount of time in 2013 with 2100 nodes x hexa-core processors. The
combination of hardware setup and software configuration does accelerate the
performance of Hadoop and TeraSort program is used to measure the performance
of your Hadoop.  There are three packages to conduct the benchmark: TeraGen
which generates input data given by the size, TeraSort which sorts the
input data files, and TeraValidate which validates the results. The elapsed
time of TeraSort is the measure of the performance of Hadoop.

Get Started
-------------------------------------------------------------------------------

* Login to Frontend
* Check HDFS by ```hadoop dfs -ls```

TeraGen
-------------------------------------------------------------------------------

* Generate a input data with 1GB (Change the size as you wish)

::

   hadoop jar /opt/hadoop/share/hadoop/mapreduce/hadoop-*examples*.jar  teragen `expr 1024 \* 1024 \* 1024` /user/$USER/terasort-input

Options
^^^^^^^^^

Add this option between ``teragen`` and the size above. This is a number of map
tasks.

* -Dmapred.map.tasks=(vcpu numbers - 1)


TeraSort
-------------------------------------------------------------------------------

::

   hadoop jar /opt/hadoop/share/hadoop/mapreduce/hadoop-*examples*.jar  terasort /user/$USER/terasort-input /user/$USER/terasort-output

Options
^^^^^^^

Add this option between ``terasort`` and the size above. This is a number of
reduce tasks.

* -Dmapred.reduce.task=(vcpu numbers divided by 2)

TeraValidate
-------------------------------------------------------------------------------

::

   hadoop jar /opt/hadoop/share/hadoop/mapreduce/hadoop-*examples*.jar teravalidate   /user/$USER/terasort-output /user/$USER/terasort-report

Options
^^^^^^^^^

One reduce task is fine because teravalidate is a simple program to combine
results.

* -Dmapred.reduce.task=1


Clean Up
-------------------------------------------------------------------------------

After your benchmark, don't forget to delete input and output directories for
TeraSort. Otherwise the free space of HDFS will be consumed quickly.


References
-------------------------------------------------------------------------------

* Sort Benchmark home Page: http://sortbenchmark.org/
