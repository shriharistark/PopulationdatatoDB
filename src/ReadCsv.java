import com.sun.org.apache.bcel.internal.generic.POP;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by hari on 25/09/17.
 */
public class ReadCsv {

    /* This class populates the array list using csv input
    * Adds each line of input as a new array element
    * */

    String FILENAMEREAD = "src/input.csv";      //specify input file here
    FileReader fr = null;
    BufferedReader br = null;
    BufferedWriter bwr = null;

    String text;

    ArrayList<Population> list = new ArrayList<>();    //Resultant array


    public ArrayList<Population> addtolist(){

        int invalidinputlinelog = 2;

        try {
            br = new BufferedReader(new FileReader(FILENAMEREAD));
            boolean firstline = true;

            //Check line by line
            while((text = br.readLine())!= null){

                //skip first line
                if(firstline) {
                    firstline = false;
                    continue;
                }

                String[] items = text.split(",");

                //skip invalid inputs
                if(items.length < 9) {
                    System.out.println("Invalid input detected at line: " + invalidinputlinelog);
                    invalidinputlinelog++;
                    continue;
                }

                for(int i = 0 ; i<items.length ; i++){

                    Population pop = new Population();
                    pop.setState_code(Integer.parseInt(items[i]));
                    pop.setDistrict_code(Integer.parseInt(items[++i]));
                    pop.setSub_district_code(Integer.parseInt(items[++i]));
                    pop.setLevel((items[++i]));
                    pop.setArea_name((items[++i]));
                    pop.setNoofvillages(Integer.parseInt(items[++i]));
                    pop.setTotal_population(Integer.parseInt(items[++i]));
                    pop.setMale_population(Integer.parseInt(items[++i]));
                    pop.setFemale_population(Integer.parseInt(items[++i]));

                    list.add(pop);
                }

                invalidinputlinelog++;
            }

        } catch (IOException e ) {
            e.printStackTrace();
        }

//        catch (ArrayIndexOutOfBoundsException i){
//            i.printStackTrace();
//            System.out.println("array error: "+(i));
//        }

        return list;

    }


    public static void main(String[] args) {

    }
}
