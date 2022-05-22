package org.example.main;

import org.apache.http.util.Args;
import org.example.model.Child;
import org.example.model.Parent;

public class Main {
    public static void main(String[] args) {
        Parent menu = new Child("a");
        System.out.println("Main Child: " + menu.getName());

        System.out.println("Main Parent: " + new Parent().getName());

        final String result = Args.notBlank("", "Exception!");
        final String result2 = Args.notBlank("Not Blank", "Exception!");
        System.out.println(result);
        System.out.println(result2);

    }
}