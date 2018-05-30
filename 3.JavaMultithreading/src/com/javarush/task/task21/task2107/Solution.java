package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Глубокое клонирование карты
*/
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    public Solution clone() throws CloneNotSupportedException{
        Solution solution  = new Solution();
        for (Map.Entry<String, User> x :this.users.entrySet())
        {
            int age = x.getValue().age;
            String name = x.getValue().name;
            solution.users.put(x.getKey(), new User(age, name));

        }
        return solution;
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || o.getClass() == this.getClass()) {
                return false;
            }

            User user = (User) o;
            if (age != user.age) return false;
            if (name != null ? !name.equals(user.name) : user.name == null) return false;
            return true;
        }

        @Override
        public int hashCode() {
            return 31 * age + (name != null ? name.hashCode() : 0);
        }

        @Override
        public User clone() throws CloneNotSupportedException{
            return new User(age, name);
        }
    }
}
