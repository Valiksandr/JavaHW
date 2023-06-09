
    /**
 *  Домашнее задание к семинару нумер 1:
 * 1. Выбросить случайное целое число в диапазоне от -1000 до 1000 и сохранить в i
 * 2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
 * 3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
 * 4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
 * */

 import java.util.Random;
 public class Zadacha_1 {  
     public static int getRandomInt() {
         int min = -1000;
         int max = 1000;
         int diff = max - min;
         int randInt = new Random().nextInt(diff + 1) + min;
         return randInt;
     }
 
     public static int getHighestOneBitPosition(int number) {
         if (number < 0) {
             number *= -1;
         }
         int position = 0;
         while (number != 1) {
             number >>= 1;
             position++;
         }
         return position;
     }
 
     public static int[] getDivisibleByNumInRange(int rangeStart, int number) {
         String strNumbers = "";
         for (int i = rangeStart; i < Short.MAX_VALUE; i++) {
             if (i % number == 0){
                 strNumbers += String.format("%d ", i);
             }
         }
         strNumbers = strNumbers.trim();
         String[] arrStrNumbers = strNumbers.split(" ");
         int[] arrNumbers = new int[arrStrNumbers.length];
         for (int i = 0; i < arrNumbers.length; i++) {
             arrNumbers[i] = Integer.parseInt(arrStrNumbers[i]);
         }
         return arrNumbers;
     }
 
     public static int[] getNotDivisibleByNumInRange(int rangeStart, int number) {
         String strNumbers = "";
         for (int i = rangeStart; i > Short.MIN_VALUE; i--) {
             if (i % number != 0) {
                 strNumbers += String.format("%d ", i);
             }
         }
         strNumbers = strNumbers.trim();
         String[] arrStrNumbers = strNumbers.split(" ");
         int[] arrNumbers = new int[arrStrNumbers.length];
         for (int i = 0; i < arrNumbers.length; i++) {
             arrNumbers[i] = Integer.parseInt(arrStrNumbers[i]);
         }
         return arrNumbers;
     }
 
     public static void main(String[] args) {
         int i = getRandomInt();
         int n = getHighestOneBitPosition(i);
         int[] m1 = getDivisibleByNumInRange(i, n);
         int[] m2 = getNotDivisibleByNumInRange(i, n);
     }
    }