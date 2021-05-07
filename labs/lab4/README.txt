CSC 172 Lab

Contact 
-----------------------------------------
Uzair Tahamid Siam
email: usiam@u.rochester.edu
URID: 31434546 / NETID: usiam
Partner; Abrar Rahman Protyasha
Lab session - M/W 6:15 - 7:30
-----------------------------------------

Synopsis
----------------------------------------
Lab 4 aims to make us implement some basic functionality for manipulating DNA and RNA sequences through the use of linkedlists and enums.

Classes
---------
Node, LinkedList, FileIO, Sequences, DNAList

Node, LinkedList, and FileIO classes are utilitary classes that are essential to the program.

The Sequence class consists of a type defined by enum and one of the elements in the DNA/RNA array in the form of a linkedlist. All methods in this class are for one single element in the array i.e. one linkedlist.

DNAList class consists of the main method as well as other methods that essentially run the methods in Sequence class like insert, remove, copy, etc. for all the linkedlists (i.e. all the instructions/commands in the test text file) on a certain linkedlist defined by 'pos.'

Compiling instructions
---------------------------------------
javac [all source files]  =>  java DNAList [array-size] [input-file]