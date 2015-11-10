.. _nist_nbis:

NIST Biometric Image Software v5.0
=====================================

The NIST Biometric Image Software (NBIS) distribution developed by the National Institute of Standards and Technology (NIST) is available on OpenStack Kilo FutureSystems with the special dataset 27A.

Virtual Image Name
--------------------

nist-nbis-03Nov2015

Minimum Flavor
----------------

m1.small

Special Database 27A
---------------------

Fingerprint images are provided in 1000ppi and 500ppi. [1]

* /sd27a
* /sd27a/1000ppi
* /sd27a/500ppi-Legacy

[1] http://www.nist.gov/itl/iad/ig/sd27a.cfm

Start to a NIST-NBIS Instance Example
--------------------------------------

.. code::
 
    nova boot --image nist-nbis-03Nov2015 --flavor m1.small --key-name YOURKEY $USER-NIST-NBIS --nic net-id=5120857b-c49c-4c05-a37e-8bee0b7df776

.. note:: Replace YOURKEY with your registered key name. Change other parameters like a flavor or an instance name, as you wish.

FAQs
-----

Having problems of using OpenStack Kilo? Find :ref:`FAQs <openstack_kilo>`
