Sample Software Project
===============================================================================

Software projects will involve running an analysis on a data set.
You will be provided with a Hadoop cluster running MapReduce version 1 (see `<HadoopClusterAccess.html>`_).
Your goal will be to use the Hadoop cluster to run a "Big Data" computation.

One possible approach is the Terabyte Sort procedure.
The components are:

- **TeraGen**: create the data
- **TeraSort**: analyze the data using MapReduce
- **TeraValidate**: validation of the output


Invocation
-------------------------------------------------------------------------------

The ``teragen`` command accepts two parameters:

1. number of 100-byte rows
2. the output directory


``hadoop jar $HADOOP_HOME/share/hadoop/mapreduce/hadoop-mapreduce-examples-2.7.1.jar teragen $COUNT /user/$USER/tera-gen``

``hadoop jar $HADOOP_HOME/share/hadoop/mapreduce/hadoop-mapreduce-examples-2.7.1.jar terasort /user/$USER/tera-gen /user/$USER/tera-sort``

``hadoop jar $HADOOP_HOME/share/hadoop/mapreduce/hadoop-mapreduce-examples-2.7.1.jar teravalidate /user/$USER/tera-sort /user/$USER/tera-validate``


Exercise
-------------------------------------------------------------------------------

Run the Terabyte Sort procedure for various sizes of data:

- 1 GB
- 10 GB
- 100 GB


For each component (``tera{gen,sort,validate}``), report the execution time, data read and written (in GB) as well as the cumulative values.




Previous Projects
===============================================================================

The following are projects from previous classes:

Paper
-------------------------------------------------------------------------------

- Review of Recommender Systems: technology & applications
- Review of Big Data in Bioinformatics
- Review of Data visualization including high dimensional data
- Design of a NoSQL database for a specialized application


Software
-------------------------------------------------------------------------------

- Use R to analyze a particular dataset (business or sports)
