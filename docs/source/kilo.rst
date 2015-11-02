.. _openstack_kilo:

OpenStack Kilo FutureSystems
==============================

OpenStack Kilo is available on FutureSystems. Here are instructions how to get access to OpenStack Kilo FutureSystems.

Nova Client on India
---------------------

Kilo account information is enabled by:

.. code::

   source ~/.cloudmesh/clouds/india/kilo/openrc.sh

You will see instances or images on Kilo now by nova client tools, e.g. nova list.

Start a New Instance
---------------------

.. code::

    nova boot --image Ubuntu-14.04-64 --key-name KEYNAME --flavor m1.small $USER-first-instance --nic net-id=5120857b-c49c-4c05-a37e-8bee0b7df776

.. note:: replace KEYNAME with your registered key name. Replace other options e.g. image or flavor as you wish.

Horizon Web Interface
--------------------------

Openstack provides a web interface to manage cloud resources easily. Usage reports, current quota or Heat stacks are visible on the web.

* Use your OS_USERNAME and OS_PASSWORD to login.  ``~/.cloudmesh/clouds/india/kilo/openrc.sh`` contains your ``OS_`` variables.
* https://openstack.futuresystems.org/horizon/project/

FAQ
------

Q. My ssh connection was denied with the message like below. What should I do?

.. code::

      @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
      @    WARNING: REMOTE HOST IDENTIFICATION HAS CHANGED!     @
      @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

A. SSH checks ssh server's fingerprint to verify the identity of the machine that you connect. You will see the message above if the fingerprint doesn't match with one you saved on your local machine (~/.ssh/known_hosts) when you ssh into the machine first time. In the cloud computing, however, you may encounter this message very often wihtout a real vulnerability. It is because that you use a same ip address with a newly deployed virtual machine which has a new fingerprint. We can ignore the host key checking or remove the fingerprint saved on a local machine by:

* Add the following options to ``ssh`` command

.. code::

     -o UserKnownHostsFile=/dev/null -o StrictHostKeyChecking=no

OR

* Remove the fingerprint in your ``~/.ssh/known_hosts`` file

.. code::

     ssh-keygen -f $HOME/.ssh/known_hosts -R HOSTNAME_OR_IPADDRESS
     
.. note::

     Replace HOSTNAME_OR_IPADDRESS with your destination
