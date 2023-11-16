package org.example.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TestClass implements Serializable {
    private int num;
    public transient String str;
    public int getNum() {
        return num;
    }
    public TestClass(int num, String str) {
        this.num = num;
        this.str = str;
    }
    private void writeObject(ObjectOutputStream oos) {
        try {
            // all without transient
            oos.defaultWriteObject();
            // str with transient
            oos.writeObject(str);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    private void readObject(ObjectInputStream ois) {
        try {
            // all without transient
            ois.defaultReadObject();
            // str with transient
            this.str = (String) ois.readObject();

        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
