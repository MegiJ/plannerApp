package pl.project.plannerapp;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.*;

@ComponentScan(
        basePackages = {
                "org.bitbucket.tek.nik.simplifiedswagger", "pl.project.plannerapp"
        }
)
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        //SpringApplication.run(Main.class, args);
        Set<String> namesSet = new HashSet<>();
        namesSet.add("Magda");
        List<Integer> integerList = new LinkedList<>();
        integerList.add(10);
        // System.out.println(integerList.get(0));
        Queue<Integer> normalQueue = new LinkedList<>();
        normalQueue.add(10);
        normalQueue.add(9);
        normalQueue.add(8);
        normalQueue.add(9);
        normalQueue.add(13);
        System.out.println(normalQueue);
        System.out.println(normalQueue.peek());
    }
}