package com.javarush.task.task20.task2013;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Externalizable Person
*/
public class Solution {
    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person() {

        }

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeInt(age);
            out.writeObject(mother);
            out.writeObject(father);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            firstName = (String) in.readObject();
            lastName = (String) in.readObject();
            age = in.readInt();
            mother = (Person)in.readObject();
            father = (Person)in.readObject();
            children = (List)in.readObject();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Enter file name:");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();

        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        Person person = new Person("FirstName", "LastName", 30);
        person.setMother(new Person("FirstName", "LastName", 50));
        person.setFather(new Person("FirstName", "LastName", 60));

        ArrayList<Person> children = new ArrayList<>();
        children.add(new Person("FirstName", "LastName", 5));
        person.setChildren(children);

        person.writeExternal(objectOutputStream);

        bufferedReader.close();
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Person externalizedPerson = new Person();
        externalizedPerson.readExternal(objectInputStream);

        fileInputStream.close();
        objectInputStream.close();
        objectOutputStream.close();
    }
}
