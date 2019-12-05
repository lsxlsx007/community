package life.lsx.mycommunity.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName User
 * @Description TODO
 * @Author lsx
 * @Date 2019/11/25 14:57
 * @Version 1.0
 */
@Data
public class User {
    private int id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;
    private BigDecimal height;

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        User user1 = new User();
        user1.setName("张三");
        user1.setHeight(new BigDecimal(56.8));
        User user2 = new User();
        user2.setName("李三");
        user2.setHeight(new BigDecimal(50.8));
        User user3 = new User();
        user3.setName("李四");
        user3.setHeight(new BigDecimal(45.9));
        User user4 = new User();
        user4.setName("张前三");
        user4.setHeight(new BigDecimal(46.3));
        User user5 = new User();
        user5.setName("张五");
        user5.setHeight(new BigDecimal(52.3));
        User user6 = new User();
        user6.setName("李二");
        user6.setHeight(new BigDecimal(50));
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);
        list.add(user6);
        List<String> normalNameList = list.stream().filter(u -> u.getHeight().compareTo(new BigDecimal(50))<=0)
                                                   .sorted(Comparator.comparing(User::getHeight)).map(User::getName)
                                                   .collect(Collectors.toList());
        List<String> normalNameList1 = list.parallelStream().filter(u -> u.getHeight().compareTo(new BigDecimal(50))<=0)
                .sorted(Comparator.comparing(User::getHeight)).map(User::getName)
                .collect(Collectors.toList());
        System.out.println(normalNameList);
        System.out.println(normalNameList1);
    }

}
