Homework HW4
=============

In this homework, you are expected to run Python or Java programs on FutureSystems or on your local machine. A few examples for beginners will help you to understand how to write and run Java or Python programs on your environment.

First Program
--------------
This code explains how to display a simple string on your screen. You can download or write your own code using your editor.

Java
^^^^^
:download: `https://raw.githubusercontent.com/cglmoocs/bdaafall2015/master/JavaFiles/FirstProgram.java`

.. code-block:: java

  /**
  * Sample Program to print out a message
  * 
  * Compile : javac FirstProgram.java
  * 	Run    : java FirstProgram
  */
  public class FirstProgram {	
  	public static void main(String[] args){
		  System.out.println("My first program on Big Data Applications and Analytics!");
	  }
  }

This example prints out the message on your screen by ``println`` method in the ``System`` class.
In Java Programming, you need to complie your code to execute.

Compiling and Execution
"""""""""""""""""""""""""""

::
  
  javac FirstProgram.java
   
Now, you will have FirstProgram.class file on your system. Java Compiler (javac) creates Java bytecode with a ``.class`` extension. We will execute the class file with ``java`` command.

::

  java FirstProgram
  My first program on Big Data Applications and Analytics!


Python
^^^^^^^
Let's write a same program in Python.

:download: `https://raw.githubusercontent.com/cglmoocs/PythonFiles/master/FirstProgram.py`

.. code-block:: python

   # Run python FirstProgram.py
   print 'My first program on Big Data Applications and Analytics!'
   
Python function ``print`` simply displays a message on your screen. Compiling is not necessary in Python. You can run your code directly with ``python`` command.

::

   python FirstProgram.py
   My first program on Big Data Applications and Analytics!
   

First Program with system information
----------------------------------------------

Java
^^^^^^

We now understand how to print out a message using Python or Java. System information such as time, date, user name or hostname (machine name) can be displayed as well with built-in functions in each language.

:download: `https://raw.githubusercontent.com/cglmoocs/bdaafall2015/master/JavaFiles/FirstProgramWithSystemInfo.java`

.. code-block:: java

   import java.util.Date;
   import java.text.DateFormat;
   import java.text.SimpleDateFormat;
   import java.net.InetAddress;
   import java.net.UnknownHostException;

   /**
    *  * Sample Program with system information
    *  *
    *  * Compile : javac FirstProgramWithSystemInfo.java
    *  *   Run    : java FirstProgramWithSystemInfo
    *  */
   public class FirstProgramWithSystemInfo {
           public static void main(String[] args){
   
                   System.out.println("My first program with System Information!");
   
                   // Print Date with Time
                   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                   Date date = new Date();
                   System.out.println("Today is: " + dateFormat.format(date));
                   // Print Username
                   System.out.println("Username is: " + System.getProperty("user.name"));
                   // Print hostname
                   try {
                           java.net.InetAddress localMachine = java.net.InetAddress.getLocalHost();
                           System.out.println("Hostname is: " + localMachine.getHostName());
                   } catch (UnknownHostException e) {
                           e.printStackTrace();
                           System.out.println("No host name: " + e.getMessage());
                   }
           }
   }

Compiling and Execution
""""""""""""""""""""""""""""""

::

    javac FirstProgramWithSystemInfo.java
    
::
 
    java FirstProgramWithSystemInfo
    My first program with System Information!
    Today is: 2015/01/01 18:54:10
    Username is: albert
    Hostname is: bigdata-host


Python
^^^^^^^^^^


:download: `https://raw.githubusercontent.com/cglmoocs/bdaafall2015/master/PythonFiles/FirstProgramWithSystemInfo.py`

.. code-block:: python

   from datetime import datetime
   import getpass
   import socket

   # Run python FirstProgramWithSystemInfo.py
   print ('My first program with System Information!')

   print ("Today is: " + str(datetime.now()))
   print ("Username is: " + getpass.getuser())
   print ("Hostname is: " + socket.gethostname())

Execution
"""""""""""""

::

   python  FirstProgramWithSystemInfo.py
   My first program with System Information!
   Today is: 2015-01-01 18:58:10.937227
   Username is: albert
   Hostname is: bigdata-host
   
Submission of First Program
-------------------------------

screenshot image or text file 

(25%)

Physics files
-----------------
5 or 6 examples

1. run and save image files with slight changes (at least 3 examples)
(75%)
2. run on local
3. run on futuresystems (+ 10%)
4. run on ipython notebook (+ 10%)

