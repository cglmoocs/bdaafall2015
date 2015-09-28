KMeans clustering
=================

This example shows KMeans clustering based on the sample data.

Prerequisite
------------

- mahout libraries (0.7 distribution)
- mahout core library (0.7)
- hadoop core library (0.7)

Sample Data
-----------

You should have a csv format file (named sample.csv) in the ./kmeans/ directory.

- kmeans/sample.csv

Run
---

::

	$ make		# Compile Java
	$ make run	# Run Java

Download mahout libraries
-------------------------

This example uses the kmeans clustering libraries from Apache Mahout 0.7. The libraries are required when the program executes and being compiled.

./lib/ directory contains the library files of the mahout 0.7.

.. note::
	Make sure you have the internet connection.
	Make sure you have `curl` program.

::

	$ make lib	# download and extract libraries
