import java.util.*;
public class Rand5sidedDie {

    public int rand7(Random r){

        int randNo = r.nextInt(7)+1;
        if (randNo<=5) {
            return randNo;
        }
        else return rand7(r);
    }

    public int rand5(Random r){
        return rand7(r);
    }

    public static void main(String[] args) {
        Random r = new Random();
        Rand5sidedDie obj = new Rand5sidedDie();
        System.out.println(obj.rand5(r));
    }
}
