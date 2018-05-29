package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/*
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("2002.txt", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            List<User> users = new ArrayList<>();

            User user1 = new User();
            user1.setFirstName("A");
            user1.setLastName("B");
            user1.setBirthDate(new GregorianCalendar(1991, 07, 29).getTime());
            user1.setMale(true);
            user1.setCountry(User.Country.RUSSIA);
            users.add(user1);

            User user2 = new User();
            user2.setFirstName("S");
            user2.setLastName("W");
            user2.setBirthDate(new GregorianCalendar(1991, 07, 29).getTime());
            user2.setMale(false);
            user2.setCountry(User.Country.UKRAINE);
            users.add(user2);

            javaRush.users = users;

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush javaRush2 = new JavaRush();
            User user3 = new User();
            user3.setFirstName("A");
            user3.setLastName("V");
            user3.setBirthDate(new GregorianCalendar(1991, 07, 29).getTime());
            user3.setMale(true);
            user3.setCountry(User.Country.OTHER);
            javaRush2.users.add(user3);

            javaRush2.save(outputStream);

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject) ? "Equals" : "Not equals");

            JavaRush loadedObject2 = new JavaRush();
            loadedObject2.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush2.equals(loadedObject2) ? "Equals" : "Not equals");

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();
        private static BufferedReader bufferedReader;

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println(users.size());
            for (User user : users) {
                String userFirstName = user.getFirstName();
                String userLastName = user.getLastName();
                Date userBirthDate = user.getBirthDate();
                User.Country userCountry = user.getCountry();
                printWriter.print(userFirstName == null ? " " : userFirstName);
                printWriter.print(";");
                printWriter.print(userLastName == null ? " " : userLastName);
                printWriter.print(";");
                printWriter.print(userBirthDate == null ? Long.toString(new GregorianCalendar(1900, 01, 01).getTime().getTime()) : Long.toString(userBirthDate.getTime()));
                printWriter.print(";");
                printWriter.print(user.isMale() ? "m" : "w");
                printWriter.print(";");
                printWriter.println(userCountry == null ? " " : userCountry.toString());
            }
            printWriter.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            if (bufferedReader == null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            }
            List<User> users = new ArrayList<>();
            String userLine;
            int usersCount = 0;
            if (bufferedReader.ready()) {
                usersCount = Integer.parseInt(bufferedReader.readLine());
            }
            if (usersCount == 0) return;
            for (int i = 0; i < usersCount; ++i) {
                userLine = bufferedReader.readLine();
                String[] userFields = userLine.split(";");
                String userFirstName = userFields[0];
                String userLastName = userFields[1];
                String userCountry = userFields[4];
                User user = new User();
                user.setFirstName(" ".equals(userFirstName) ? null : userFirstName);
                user.setLastName(" ".equals(userLastName) ? null : userLastName);
                user.setBirthDate(new Date(Long.parseLong(userFields[2])));
                user.setMale(userFields[3].equals("m") ? true : false);
                user.setCountry(" ".equals(userCountry) ? null : User.Country.valueOf(userCountry));
                users.add(user);
            }
            this.users = users;

            if (!bufferedReader.ready()) {
                bufferedReader.close();
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
