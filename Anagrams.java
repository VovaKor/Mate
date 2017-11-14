import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * На вход консольного приложения передается строка слов, разделенных пробелами. 
 * Твоя задача сделать из слов анаграммы ("задом наперед") при этом оставив порядок слов 
 * неизменными. Результат вывести в консоль. Пример "мама мыла раму" => "амам алым умар"
 * При решении задачи нельзя использовать дополнительную память. В том числе, когда это 
 * происходит в неявном виде при вызове функций стандартной библиотеки.
 * 
 * @author Vova Korobko
 */
public class Anagrams {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите строку слов, разделенных пробелами");
        
        String inputString = "";
        try {
            inputString = reader.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Anagrams.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == ' ') {
                for (int j = i - 1; j >= 0; j--) {

                    if (inputString.charAt(j) == ' ') {
                        break;
                    }
                    System.out.print(inputString.charAt(j));
                }
                System.out.print(inputString.charAt(i));

            } else if (i == inputString.length() - 1) {
                for (int j = i; j >= 0; j--) {

                    if (inputString.charAt(j) == ' ') {
                        break;
                    }
                    System.out.print(inputString.charAt(j));
                }
            }

        }
    }
}
