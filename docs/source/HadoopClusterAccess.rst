.. _hc_access:

Hadoop Cluster Access
===============================================================================

This document describes getting access to the Hadoop cluster for the course.

Prerequisites
-------------------------------------------------------------------------------

You will need

1. An a account with FutureSystems
2. To be a member of FutureSystems project 475
3. Have uploaded an ssh key to the portal


Access
-------------------------------------------------------------------------------

..
  TODO: add ip address for hadoop cluster

The cluster frontend is located at ``<IP_ADDRESS>``, :ref:`frontend ip <frontend>`

Login using ssh:

.. code::

   ssh -i $PATH_TO_SSH_PUBLIC_KEY $PORTAL_USERNAME@$HADOOP_IP


In the above:

- ``$PATH_TO_SSH_PUBLIC_KEY`` is the location of the public key that has been added to the futuresystems portal
- ``$PORTAL_USERNAME`` is the username on the futuresystems portal
- ``$HADOOP_IP`` is the IP address of the hadoop frontend node



Usage
-------------------------------------------------------------------------------

Hadoop is installed under ``/opt/hadoop``, and you can refer to this location
using ``$HADOOP_HOME``.

See

.. code::

   hadoop fs


and


.. code::

   hadoop jar $HADOOP_HOME/share/hadoop/mapreduce/hadoop-mapreduce-examples*.jar

for more details.

Sharing Files by `share` directory
-------------------------------------------------------------------------------

``share`` directory is provided in the $HOME directory by glusterFS. Any files 
in this directory is shared between frontend{1,2,3} nodes in the Hadoop cluster.

