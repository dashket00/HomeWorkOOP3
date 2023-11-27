import java.lang.reflect.Field;

class Apple {
    private String color;

    public Apple(String color) {
        this.color = color;
    }
}

public class AppleDemo {
    public static void main(String[] args) {
        Apple apple = new Apple("Red");

        try {
            Field colorField = Apple.class.getDeclaredField("color");
            // Разрешить доступ к полю
            colorField.setAccessible(true);

            // Вывести начальный цвет
            System.out.println("Initial color: " + colorField.get(apple));

            // Попытка изменить значение цвета через рефлексию
            colorField.set(apple, "Green");

            System.out.println("Changed color: " + colorField.get(apple));

            // Обработка исключения
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}