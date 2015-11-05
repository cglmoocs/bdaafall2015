.. _mrbench:

Mrbench: A benchmark for mapreduce framework
===============================================

Options
----------

If you run mrbench with ``-help``, you will find available options.

.. code::

    $ hadoop jar /opt/hadoop/share/hadoop/mapreduce/hadoop-mapreduce-client-jobclient-2.7.1.jar mrbench -help
    MRBenchmark.0.0.2
    Usage: mrbench [-baseDir <base DFS path for output/input, default is /benchmarks/MRBench>] [-jar <local path to job jar file containing Mapper and Reducer implementations, default is current jar file>] [-numRuns <number of times to run the job, default is 1>] [-maps <number of maps for each run, default is 2>] [-reduces <number of reduces for each run, default is 1>] [-inputLines <number of input lines to generate, default is 1>] [-inputType <type of input to generate, one of ascending (default), descending, random>] [-verbose]

* -baseDir: User your home directory e.g. /user/$USER/MRBench
* -jar: Use this option to change the locaion of your jar file if you want to use a jar in a different location
* -numRuns: Use this option to define the number of iteration of jobs
* -maps: Default value is 2. Change this option to optimize
* -reduces: Default value is 1. Change this option to optimize
* -inputLines: Default value is 1. Change this option to optimize
* -inputType: ascending|descending|random for input
* -verbose: informal messages will be printed while MRBench runs

Outputs
--------

See the last two lines like:

.. code::

    DataLines	Maps	Reduces	AvgTime (milliseconds)
    1		2	1	20977

This explains 2 maps and 1 reduce ran in 20 seconds.

The sample outputs look like:

.. code::

    MRBenchmark.0.0.2
    15/11/05 18:43:03 INFO mapred.MRBench: creating control file: 1 numLines, ASCENDING sortOrder
    15/11/05 18:43:03 INFO mapred.MRBench: created control file: /benchmarks/MRBench/mr_input/input_-514227965.txt
    15/11/05 18:43:03 INFO mapred.MRBench: Running job 0: input=hdfs://futuresystems/benchmarks/MRBench/mr_input    output=hdfs://futuresystems/benchmarks/MRBench/mr_output/output_978384127
    15/11/05 18:43:04 INFO client.ConfiguredRMFailoverProxyProvider: Failing over to rm2
    15/11/05 18:43:04 INFO mapred.FileInputFormat: Total input paths to process : 1
    15/11/05 18:43:04 INFO mapreduce.JobSubmitter: number of splits:2
    15/11/05 18:43:05 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1446575549992_0003
    15/11/05 18:43:05 INFO impl.YarnClientImpl: Submitted application application_1446575549992_0003
    15/11/05 18:43:05 INFO mapreduce.Job: The url to track the job: http://tmaster2:8088/proxy/application_1446575549992_0003/
    15/11/05 18:43:05 INFO mapreduce.Job: Running job: job_1446575549992_0003
    15/11/05 18:43:12 INFO mapreduce.Job: Job job_1446575549992_0003 running in uber mode : false
    15/11/05 18:43:12 INFO mapreduce.Job:  map 0% reduce 0%
    15/11/05 18:43:18 INFO mapreduce.Job:  map 100% reduce 0%
    15/11/05 18:43:24 INFO mapreduce.Job:  map 100% reduce 100%
    15/11/05 18:43:24 INFO mapreduce.Job: Job job_1446575549992_0003 completed successfully
    15/11/05 18:43:24 INFO mapreduce.Job: Counters: 49
      File System Counters
		FILE: Number of bytes read=13
		FILE: Number of bytes written=355108
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=245
		HDFS: Number of bytes written=3
		HDFS: Number of read operations=9
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=2
		  Job Counters 
		Launched map tasks=2
		Launched reduce tasks=1
		Rack-local map tasks=2
		Total time spent by all maps in occupied slots (ms)=6086
		Total time spent by all reduces in occupied slots (ms)=3303
		Total time spent by all map tasks (ms)=6086
		Total time spent by all reduce tasks (ms)=3303
		Total vcore-seconds taken by all map tasks=6086
		Total vcore-seconds taken by all reduce tasks=3303
		Total megabyte-seconds taken by all map tasks=6232064
		Total megabyte-seconds taken by all reduce tasks=3382272
		  Map-Reduce Framework
		Map input records=1
		Map output records=1
		Map output bytes=5
		Map output materialized bytes=19
		Input split bytes=242
		Combine input records=0
		Combine output records=0
		Reduce input groups=1
		Reduce shuffle bytes=19
		Reduce input records=1
		Reduce output records=1
		Spilled Records=2
		Shuffled Maps =2
		Failed Shuffles=0
		Merged Map outputs=2
		GC time elapsed (ms)=98
		CPU time spent (ms)=1990
		Physical memory (bytes) snapshot=726786048
		Virtual memory (bytes) snapshot=2518798336
		Total committed heap usage (bytes)=560988160
		  Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
		  File Input Format Counters 
		Bytes Read=3
		  File Output Format Counters 
		Bytes Written=3
		DataLines	Maps	Reduces	AvgTime (milliseconds)
		  1		2	1	20977


References
--------------

* Kim, Kiyoung, et al. "Mrbench: A benchmark for mapreduce framework." Parallel and Distributed Systems, 2008. ICPADS'08. 14th IEEE International Conference on. IEEE, 2008. [`pdf <http://www.researchgate.net/profile/Heon_Yeom/publication/221040832_MRBench__A_Benchmark_for_Map-Reduce_Framework/links/0fcfd50fc8e28b5b4b000000.pdf>`_]
