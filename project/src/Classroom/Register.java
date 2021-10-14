package Classroom;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Register {
List<Nameable> names = new ArrayList<Nameable>();


    public Register(List<Nameable> objs) {
        this.names = objs;
    }

    List<String> getRegister(){


      return  names.stream().map(Nameable::getName).collect(Collectors.toList());


    }

    List<Nameable> getRegisterByLevel (Level level ){
    return  names.stream() .filter(x -> x.getLevel().equals(level))
                .collect(Collectors.toList());

    }


    public void printReport(List<Nameable> nameable) {
        Map<Level, List<Nameable>> collect =
                nameable.stream().collect(Collectors.groupingBy(Nameable::getLevel));
        collect.forEach((level, nameable1) -> {
            System.out.println(level);
            nameable1.forEach(System.out::println);
        });
    }

    @Override
    public String toString() {
        return "Register{" +
                "names=" + names +
                '}';
    }
}
