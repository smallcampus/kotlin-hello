package com.hkm.example;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

/**
 * Created by makhotin on 8/12/2016.
 */
public class JavaMain {

    public static void main(String[] args) {
        System.out.println("Hello");

        //================================
        //Basic Object declaration
        //================================
        final JavaModel javaModel =
                new JavaModel("java title", "java content", new ArrayList<>());

        final KotlinModel kotlinModel =
                new KotlinModel("kotlin title", "kotlin content", new ArrayList<>(),null,null);


        //================================
        //Copy function
        //================================
        final JavaModel javaModelCopy = new JavaModel(javaModel.getTitle(), javaModel.getContent(), javaModel.getTags());
        final KotlinModel kotlinModelCopy = kotlinModel.copy(null,null,null,null,null);


        //================================
        //Default values
        //================================
        String title = javaModel.getTitle(); //Very difficult to enforce immutability
        if (title==null) {
            title = "No Title";
        }

        //================================
        // Logical Assignment
        //================================
        String content = javaModel.getContent(); //Very difficult to enforce immutability
        if (content==null) {
            content = "";
        }
        if (javaModel.getTitle()==null || javaModel.getTitle().isEmpty()) {
            content = "";
        }


        //================================
        // Interface and lambda
        //================================
        javaModel.setSingleListener(text -> System.out.println(text));
        javaModel.setMultiListener(new JavaModel.JavaMultiMethodInterface() {
            @Override
            public String returnSomething() {
                return "something";
            }

            @Override
            public void doSomething(String text) {
                System.out.println(text);
            }
        });

        new KotlinModel(null, null, null,
                new Function1<String, Unit>() {
                    @Override
                    public Unit invoke(String s) {
                        System.out.println(s);
                        return null;
                    }
                },
                new KotlinMultiMethodInterface() {
                    @Override
                    public void doSomething(@NotNull String text) {
                        System.out.println(text);
                    }

                    @Nullable
                    @Override
                    public String returnSomething() {
                        return "something";
                    }
                });


        //================================
        // Map Reduce
        //================================
        List<Integer> list = Arrays.asList(58,586,30,12,23);
        int sum = list.stream()
                .filter(num -> num%2==0)        //Filter even numbers only
                .map(num -> num*10)             //Times 10
                .reduce(Math::addExact)         //Sum them up
                .orElseGet(() -> 0);
    }


}
