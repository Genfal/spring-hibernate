package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        CarService carService = context.getBean(CarService.class);

        User user1 = new User("name1", "lastname1", "user1@mail.ru");
        User user2 = new User("name2", "lastname2", "user2@mail.ru");
        User user3 = new User("name3", "lastname3", "user3@mail.ru");

        Car car1 = new Car("Tesla", 512, user1);
        Car car2 = new Car("Hyundai", 15, user2);
        Car car3 = new Car("Volvo", 10000, user3);

        user1.setCar(car1);
        user2.setCar(car2);
        user3.setCar(car3);

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);

        carService.add(car1);
        carService.add(car2);
        carService.add(car3);

        User findedUser1 = carService.getUser("Tesla", 512);
        User findedUser2 = carService.getUser("Hyundai", 15);
        User findedUser3 = carService.getUser("Volvo", 10000);

        System.out.println(findedUser1.getFirstName());
        System.out.println(findedUser2.getFirstName());
        System.out.println(findedUser3.getFirstName());

        context.close();
    }
}
