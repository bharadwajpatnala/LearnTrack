# JVM Basics

## JDK
The JDK is a set of tools we need to write and develop java programs.

## JRE
JRE provides the environment and libraries needed to run a Java application.

## JVM
JVM is responsible for running Java bytecode. When we compile a Java program, Java code is converted into bytecode. The JVM reads this bytecode and executes it. It also manages memory and removes objects that are no longer needed through garabage collector.

## What is bytecode?
When we write a Java code, the computer cannot directly understand the code we write. So, Java first converts our code into another format called bytecode. The JVM takes this bytecode and runs the program on our computer.

## What does “write once, run anywhere” mean?
One of the advantage of Java is taht we don't normally need to rewrite our program for every operating system.
For example: Suppose I write a java program on my windows laptop. Java converts my code into bytecode. If another computer uses Linux or macOs, the same bytecode can run there too, provided that a compatible JVM is available and the program doesn't depend on anything specific to Windows. 