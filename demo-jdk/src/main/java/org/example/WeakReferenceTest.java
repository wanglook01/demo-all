package org.example;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.lang.ref.WeakReference;

public class WeakReferenceTest {

    @Getter
    @Setter
    @NoArgsConstructor
    @ToString
    public static class Person {
        private Integer id;

        public Person(Integer id) {
            this.id = id;
        }
    }

    @Getter
    @Setter
    public static class ThreadLocalMap extends WeakReference<Person> {
        private Person value;

        public ThreadLocalMap(Person referent, Person p) {
            super(referent);
            value = p;
        }
    }


    public static void main(String[] args) throws Exception {
        weakTest();
        System.out.println("--------");
        threadLocalMap();
    }

    public static void weakTest() throws Exception {
        WeakReference<Person> weakReference = new WeakReference<>(new Person(10));
        System.out.println(weakReference.get());
        System.gc();
        Thread.sleep(1000);
        System.out.println(weakReference.get());
    }

    public static void threadLocalMap() throws Exception {
        ThreadLocalMap threadLocalMap = new ThreadLocalMap(new Person(1), new Person(2));
        System.out.println(threadLocalMap.get());
        System.out.println(threadLocalMap.getValue());
        System.gc();
        Thread.sleep(1000);
        System.out.println(threadLocalMap.get());
        System.out.println(threadLocalMap.getValue());
    }


}
