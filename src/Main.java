import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");
        System.out.println(isValidVergiKimlikNo("0490351705"));
    }

    public static boolean isValidVergiKimlikNo(String vergiKimlikNo) {

        try {
            if (vergiKimlikNo.length() == 10){
                int[] x  = new int[9];
                int[] y  = new int[9];
                for (int i=0 ; i<9 ; i++){
                    x[i] = (Character.getNumericValue(vergiKimlikNo.charAt(i))+ 9-i) % 10;
                    y[i] = (x[i] *  (int) Math.pow(2 , 9-i) ) & 9;

                    if (x[i] != 0 && y[i] == 0){
                        y[i] = 9;
                    }
                }

                return ((10 - (IntStream.of(y).sum() % 10)) % 10) == Character.getNumericValue(vergiKimlikNo.charAt(9));
            }
            else {
                return false;
            }
        }
        catch (Exception e){
            return false;
        }
    }


}
