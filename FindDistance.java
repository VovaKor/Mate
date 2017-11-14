import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Твоя задача создать консольное приложение, которое принимало бы на вход
 * ряд чисел и выводило расстояние между двумя наименьшими. Например, 
 * дано ряд чисел: "23 45 34 12 45 4 38 56 2 49 100". Наименьшие числа в нем 2 и 4. 
 * Расстояние между ними - 3.
 * 
 * @author Vova Korobko
 */
public class FindDistance {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите ряд чисел, разделенных пробелами");
        
        String[] inputString;
        int[] numbers = new int[]{};
        try {
            inputString = reader.readLine().split(" ");
            numbers = new int[inputString.length];
            for(int i = 0; i < inputString.length; i++){
                numbers[i] = Integer.parseInt(inputString[i]);
            }
        } catch (IOException ex) {
            Logger.getLogger(FindDistance.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int firstMin = numbers[0];
        int firstMinIndex = 0;
        int secondMin = firstMin;
        int secondMinIndex = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < firstMin) {
                firstMin = numbers[i];
                firstMinIndex = i;
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > firstMin && numbers[i] < secondMin) {
                secondMin = numbers[i];
                secondMinIndex = i;
            }
        }
        
        System.out.println("Расстояние между числами = " + Math.abs(firstMinIndex - secondMinIndex));
    }
}
