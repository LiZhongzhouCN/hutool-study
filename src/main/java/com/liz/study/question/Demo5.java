package com.liz.study.question;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liz
 * @Description:
 * @date: 2020/4/17 0:32
 */
public class Demo5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String[] array = scanner.nextLine().split(" ");
        List<String> list = new ArrayList<>(Arrays.asList(array));
        Arrays.stream(array)
                .collect(Collectors.groupingBy(String::toString, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                .keySet().forEach(s -> {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(s))
                    list.remove(i);
            }
        });
        list.forEach(c -> {
            sb.append(c).append(" ");
        });
        System.out.println(sb.toString().trim());
    }
}
