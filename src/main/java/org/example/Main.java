package org.example;

import org.example.serialization.TestClass;

import java.io.*;

public class Main {
    public static void main(String[] args)
    {
        TestClass testClass = new TestClass(1, "text");
        String filename = "file.ser";

        try
        {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(testClass);

            out.close();
            file.close();

            System.out.println("Object has been serialized.");
        }
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }

        // Deserialization
        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            TestClass testClass1 = (TestClass) in.readObject();

            in.close();
            file.close();

            System.out.println("Object has been deserialized: ");
            System.out.println("private int num = " + testClass1.getNum());
            System.out.println("public transient String str= " + testClass1.str);
        }
        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }
    }
}