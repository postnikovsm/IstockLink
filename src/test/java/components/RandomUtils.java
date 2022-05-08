package components;


import java.util.Random;

public class RandomUtils {
    public static String getRandomString(int length) {
        // абвгдеежзийклмнопрстуфхцчщъыьэюя
        String SALTCHARS = "abcdefghijklmnoprqrstuvwxyz0123456789";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        while (result.length() < length) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            result.append(SALTCHARS.charAt(index));
        }

        return result.toString();
    }
    public static int rnd(int max)
    {
        return (int) (Math.random() * ++max);
    }


    public static String getRandomOnlyString(int length) {
        // абвгдеежзийклмнопрстуфхцчщъыьэюя
        String SALTCHARS = "abcdefghijklmnoprqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        while (result.length() < length) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            result.append(SALTCHARS.charAt(index));
        }

        return result.toString();
    }
}