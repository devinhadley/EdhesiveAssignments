import java.util.Scanner;

class Assignment4 {
    public static void main(String[] args) { // Variable names are messed up due to improper ordering of loops. Had to get rid of repeats before getting rid of vowels. 

        Scanner scan = new Scanner(System.in);
        System.out.println("Type the message to be shortened");
        String input = scan.nextLine();
        String refined = input.toLowerCase();
        String noVowels = "";
        String result = "";
        String forbidden = " ";
        String result2 = "";



        int repeatRemoved = 0;
        int vowelRemoved = 0;


        String numString = "";



        for (int i = 0; i < refined.length(); i++) { // Removes repeated letters.
            if (i + 2 > refined.length()) {
                result += refined.substring(i, i + 1); // Checks if letter is repeated
            } else {
                if (!refined.substring(i, i + 1).equals(refined.substring(i + 1, i + 2))) {
                    result += refined.substring(i, i + 1);
                } else {

                    if (!refined.substring(i, i + 1).matches("(.*)[aeiou](.*)")) { // If repeated  letter is a vowel, it is treated as a vowel remove not a repeat remove.  Uses the matches method which takes a java regular expression
                        repeatRemoved++;
                    } else {
                        vowelRemoved++;
                    }


                }

            }
        }




        for (int i = 0; i < result.length(); i++) { // Removes vowels
            if (i == 0 || result.substring(i - 1, i).equals(" ")) {
                noVowels += result.substring(i, i + 1);
            } else {
                if (result.substring(i, i + 1).matches("(.*)[aeiou](.*)")) { // Checks if letter is vowel
                    vowelRemoved++;
                } else {
                    noVowels += result.substring(i, i + 1);
                }
            }

        }






        System.out.println("\nAlgorithm 1");
        System.out.println("Vowels removed: " + vowelRemoved);
        System.out.println("Repeats removed: " + (repeatRemoved));
        System.out.println("Algorithm 1 message: " + noVowels);
        System.out.println("Algorithm 1 characters saved: " + (vowelRemoved + repeatRemoved));

        String tempString = "";
        String used_letters = "";
        int unique_letters = 0;

        for (int i = 0; i < refined.length(); i++) {
            int temp_counter = 1;
            String currentLetter = refined.substring(i, i + 1);

            if (used_letters.contains(currentLetter) || currentLetter.equals(" ")) {
                continue;
            } // If letter has alreay been counted, the iteration/letter is skipped. 


            used_letters += currentLetter;
            unique_letters++;
            for (int j = i + 1; j < refined.length(); j++) { // Counts how many letters are the same as the current letter.

                if (currentLetter.equals(refined.substring(j, j + 1))) {

                    temp_counter++;
                }



            }

            tempString += temp_counter + refined.substring(i, i + 1);

        }


        System.out.println("\nAlgorithm 2");
        System.out.println("Unique characters found: " + unique_letters);
        System.out.println("Algorithm 2 message: " + tempString);
        System.out.println("Algorithm 2 characters saved: " + (refined.length() - tempString.length()));


    }
}
