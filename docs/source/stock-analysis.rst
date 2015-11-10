.. _stock_analysis:

Stock Analysis
==================

The stock analysis software from https://github.com/iotcloud/stock-analysis is provided in OpenStack Kilo FutureSystems.

VM Image Name
--------------

stock-analysis-02Nov2015

Minimum Flavor
---------------

m1.small

How to start Example
---------------------

With your key and network information, you can start a new virtual instance with the stock analysis image like:

.. code::

      NETID=`nova network-list | grep $OS_TENANT_NAME-net | awk {'print $2'}`
      nova boot --image stock-analysis-02Nov2015 --flavor m1.small --key-name YOURKEY $USER-stock-analysis --nic net-id=$NETID

.. note::  Replace YOURKEY with your registered keyname. $USER-stock-analysis is a label to your instance, you can change the name.

FAQs
-----

Having problems of using OpenStack Kilo? Find :ref:`FAQs <openstack_kilo>`

