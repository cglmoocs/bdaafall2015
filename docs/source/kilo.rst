.. _openstack_kilo:

OpenStack Kilo FutureSystems
==============================

OpenStack Kilo is available on FutureSystems. Here are instructions how to get access to OpenStack Kilo FutureSystems.

Nova Client on India
---------------------

Kilo account information is enabled by:

.. code:

   source ~/.cloudmesh/clouds/india/kilo/openrc.sh

You will see instances or images on Kilo now by nova client tools, e.g. nova list.

Start a New Instance
---------------------

nova boot --image Ubuntu-14.04-64 --key-name KEYNAME --flavor m1.small $USER-first-instance --nic net-id=5120857b-c49c-4c05-a37e-8bee0b7df776

.. note: replace KEYNAME with your registered key name. Replace other options e.g. image or flavor as you wish.

Horizon Web Interface
--------------------------

Openstack provides a web interface to manage cloud resources easily. Usage reports, current quota or Heat stacks are visible on the web.

* Use your OS_USERNAME and OS_PASSWORD to login.  ``~/.cloudmesh/clouds/india/kilo/openrc.sh`` contains your ``OS_`` variables.
* https://openstack.futuresystems.org/horizon/project/
