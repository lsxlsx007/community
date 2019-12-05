package life.lsx.mycommunity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @ClassName Dish
 * @Description TODO
 * @Author lsx
 * @Date 2019/12/5 14:16
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dish {
    private String name;
    private boolean vegetarian;
    private int calories;
    private Type type;
    public enum Type { MEAT, FISH, OTHER }

    public static void main(String[] args) {
        new Dish();
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH) );

         List<String> list = menu.stream().filter(t->t.isVegetarian()==false).map(Dish::getName).collect(toList());
//        System.out.println(list);
        List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
//        words.forEach(item-> System.out.println(item));

        List<String> uniqueCharacters =
                words.stream()
                        .map(w -> w.split(""))
                        .flatMap(Arrays::stream)
                        .distinct()
                        .collect(Collectors.toList());
//        uniqueCharacters.forEach(item-> System.out.print(item+","));

        List<Integer> arr = Arrays.asList(1,2,3,4);
        List<Integer> newArr = arr.stream().map(item->item*item).collect(Collectors.toList());
//        newArr.forEach(item-> System.out.print(item+","));

        List<Integer> numbers1 = Arrays.asList(1, 8, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs = numbers1.stream().flatMap(i -> numbers2.stream().map(j -> new int[]{i, j})).collect(toList());
        pairs.forEach(item-> {
            for(int i:item){
                System.out.print(i+",");
            }
            System.out.println();
        });

        if(menu.stream().anyMatch(Dish::isVegetarian)){
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }
        Integer sum = numbers1.stream().reduce(0,(a,b)->a+b);
        System.out.println("sum: "+sum);
    }
}
