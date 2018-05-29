package com.javarush.task.task20.task2011;

import java.io.*;

/*
Externalizable для апартаментов
*/
public class Solution {

    public static class Apartment implements Externalizable {

        private String address;
        private int year;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() { super(); }

        public Apartment(String adr, int y) {
            address = adr;
            year = y;
        }

        /**
         * Prints out the fields. used for testing!
         */
        public String toString() {
            return("Address: " + address + "\n" + "Year: " + year);
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(address);
            out.writeInt(year);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            this.address = (String) in.readObject();
            this.year = in.readInt();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Enter file name:");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();

        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        Apartment apartment = new Apartment("BakerStreet", 221);
        apartment.writeExternal(objectOutputStream);

        bufferedReader.close();
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Apartment externalizedApartment = new Apartment();
        externalizedApartment.readExternal(objectInputStream);
        System.out.println(externalizedApartment.toString());

        fileInputStream.close();
        objectInputStream.close();
        objectOutputStream.close();
    }
}
