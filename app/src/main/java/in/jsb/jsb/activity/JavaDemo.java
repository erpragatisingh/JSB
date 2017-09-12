package in.jsb.jsb.activity;

/**
 * Created by pragati.singh on 8/24/2017.
 */

public class JavaDemo {


    public static void main(String[] args) {

        try {

            System.out.println("djvbdvdvuv  " + testVales());

          System.exit(0);


        }catch (Exception d){
            System.out.println("Exception");
        }finally {
            System.out.println("finally");
        }


    }

   static Boolean testVales(){

        try {

            System.out.println("testVales method");

             return false;

        }catch (Exception d){
            System.out.println("Exception");
        }finally {
            System.out.println("finally");
            return true;
        }
    }


}
