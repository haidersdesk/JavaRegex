package RegularExpressions;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTests {

    public static List<Result>  result = new ArrayList<>();
    public static int matchCounter = 0;

    public static void main(String[] args) throws FileNotFoundException {

        // All the alphabets
        String Alphabet = "[aA][bB][cC][dD][eE][fF][gG][hH][iI][jJ][kK][lL][mM][nN][oO][pP][qQ][rR][sS][tT][uU][vV][wW][xX][yY][zZ]";
        reader(Alphabet, "All Alphabet", true);

        // Name find ola or OLA
        String ola = "ola|Ola|OLA{1}";
        reader(ola, "Name find ola", true);

        // 3 to 5 a
        String numberOfA = "a{3,5}";
        reader(numberOfA, "a: 3-5", false);
        result.add(new Result("a: 3-5", matchCounter));
        reader(numberOfA, "a: 3-5", true);
        matchCounter = 0;

       // Non Alphanumeric Values
        String nonAlphaNumeric = "[^A-Za-z0-9]";
        reader(nonAlphaNumeric, "Non Alphanumeric Values", false);
        result.add(new Result("Non Alphanumeric Values", matchCounter));
        matchCounter = 0;


        //Emails
        String emails = "[A-Za-z0-9._%-]+@[A-Za-z0-9._-]+\\.[A-Za-z]{2,3}";
        reader(emails, "Emails", false);
        result.add(new Result("Emails", matchCounter));
        reader(emails, "Emails", true);
        matchCounter = 0;

        //Telephone Numbers
        String telephone = "0{1,}[0-9]{1,3}[\\s/,-]?[0-9]{5,}";
        reader(telephone, "Tel Numbers", false);
        result.add(new Result("Tel Numbers", matchCounter));
        reader(telephone, "Tel Numbers", true);
        matchCounter = 0;

        //4 equals
        String fourEquals = "([a-zA-Z])\\1{3}";
        reader(fourEquals, "4 equal letters", false);
        result.add(new Result("4 equal letters", matchCounter));
        reader(fourEquals, "4 equal letters",true);
        matchCounter = 0;

        //Register Number
        String register = "[a-zA-Z]{3}[/_][0-9]{3}";
        reader(register, "Register Numbers", true);

        //Brackets with text or numbers
        String brackets = "[(][\\s?a-zA-Z\\s?]+[)]|[(][\\s?0-9\\s?]+[)]|[(][\\s]+[)]";
        reader(brackets, "brackets", true);


        //If and For Loops
        String loops = "if[(]|for[(]";
        reader(loops, "If or For Loop", true);

        // Print list result
        System.out.println(result);


    }

    //Scanner*************************************************************************
    public static void reader(String inputPattern, String matchGroup, boolean matchExists) throws FileNotFoundException {
        File file = new File("text.txt");
        Scanner scanner = new Scanner(file);

        int lineCount = 1;

        while (scanner.hasNextLine()) {
            String text = scanner.nextLine();
            finder(text, inputPattern, matchGroup, lineCount, matchExists);

            lineCount++;
        }
        scanner.close();
    }


    // FINDER*************************************************************************
    public static void finder(String text, String pattern, String matchGroup, int lineNr, boolean exists) {
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(text);

        while (matcher.find()) {

            if (matcher.group().length() != 0) {
               if(exists){

                   result.add(new Result(matchGroup, matcher.group(),lineNr,matcher.start(),matcher.end() ));

               }else{

                   matchCounter++;

               }

            }


        }
    }




}
