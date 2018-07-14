import java.util.*;
public class Rand7sidedDie {

    public int rand5(Random r){
        int randNo = ((r.nextInt(5))*5)+(r.nextInt(5))+1;
        return (randNo <=21) ? randNo : rand5(r);
    }

    public int rand7(Random r){
        return (rand5(r)%7)+1;
    }


    public static void main(String[] args) {
        Rand7sidedDie obj =new Rand7sidedDie();
        Random r = new Random();

        System.out.println(obj.rand7(r));

    }
}
