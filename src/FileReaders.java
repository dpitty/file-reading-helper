import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReaders {
    public static void main(String[] args) {
        System.out.println("We're gonna be RICH!");

        /*Menu options for choosing which code blocks to suggest:
            1. Objective (select one... or many??):
                -a block of code that loops through every line in the file
                -a block of code that loops through every word in the file
                -a function that returns a list of lines
                -a function that returns a list of words
                -a function that returns a string encompassing the whole file
                *Selection filters out irrelevant options
            2. Off-limits tools (choose many):
                -FileReader and BufferedReader
                -Scanner
                -Try-With-Resources blocks
                -List as interface
                *Selection filters out irrelevant options
            3. Experience level (choose one*):
                -Beginner (verbose is better)
                -Intermediate
                -Advanced (dense is better)
                *Selection may determine rank/order of suggestions?
            4. Display format
                -Block of code to insert into program
                -Standalone function
                -Complete program
                *TODO, this requres features that aren't ready
        */
    }

}
class FileLoopers {


    /*
    A note on selecting which structure to use for file reading:
    >Try-catch-finally is perhaps the most academic and universally accepted?
    >Try-with-resources is 

    */

    //Use a try-catch-finally block and a while(true) loop
    //to process each line in the file.
    //Note on "what is pathString?" - it could be as simple as a file name.
    public void loopByLineTCF(String pathString) {
        //String pathString = "./myFileName.txt";
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(pathString));
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                /* YOUR CODE HERE
                 * e.g.: System.out.println(line); will console-print every line
                 * Or, you can do something else with each "line"
                 */
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //import Java.util.FileReader;
    //import Java.util.BufferedReader;
    //import java.io.IOException; 


    //Use try-with-resources block and a while(true)
    // loop to process each line of a file
    //Try-with-resources is handy because it auto-closes the file reading
    // tool (here, the BufferedReader). We don't have to close it manually,
    // which reduces the chance of an unnoticed bug.
    public void loopByLineTWR(String pathString) {
        //String pathString = "./myFileName.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(pathString))) {
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                /* YOUR CODE HERE
                 * e.g.: System.out.println(line); will console-print every line
                 * Or, you can do something else with each "line"
                 */            
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    //import Java.util.FileReader;
    //import Java.util.BufferedReader;
    //import java.io.IOException;


    //Same as loopByLineTWR, but replaces familiar while(true) loop
    //with a compact loop in the style of C(++) file streams.
    public void loopByLineTWRDense(String pathString) {
        //String pathString = "./myFileName.txt";
        String line; // This will reference one line at a time
        try (BufferedReader reader = new BufferedReader(new FileReader(pathString))) {
            while((line = reader.readLine()) != null) {
                /* YOUR CODE HERE
                 * e.g.: System.out.println(line); will console-print every line
                 * Or, you can do something else with each "line"
                 */            
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    //import Java.util.FileReader;
    //import Java.util.BufferedReader;
    //import java.io.IOException;


    //Same as loopByLineTWR, but showing a Scanner option,
    //in case BufferedReader hasn't been introduced
    public void loopByLineTWRScanner(String pathString) {
        //String pathString = "./myFileName.txt";
        try (Scanner scanner = new Scanner(new File(pathString))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                /* YOUR CODE HERE
                 * e.g.: System.out.println(line); will console-print every line
                 * Or, you can do something else with each "line"
                 */            
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    //import java.io.File;
    //import Java.util.Scanner;
    //import java.io.IOException;

    //Same as loopByLineTCF, but illutrating a configuration with
    //more verbose, explicit variable naming. Also showing explicit comments
    //and more detailed exception handling.
    public void loopByLineTCFVerbose(String pathString) {
        //String pathString = "./myFileName.txt";
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            // FileReader reads text files in a default (or specified) encoding.
            fileReader = new FileReader(pathString);
            // BufferedReader wraps a FileReader for faster performance
            bufferedReader = new BufferedReader(fileReader);
            // readLine() extracts one line at a time, saving it to the String line
            while(true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                /* YOUR CODE HERE */
            }         
        }
        catch(FileNotFoundException e) { //Tip: FNFException v IOExeception
            System.out.println("Unable to find file '" + pathString + "'");                
            e.printStackTrace();
        }
        catch(IOException e) {
            System.out.println("Error while reading file '" + pathString + "'");                  
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //import Java.util.FileReader;
    //import Java.util.BufferedReader;
    //import java.io.IOException;
    //import java.io.FileNotFoundException;
    //https://www.caveofprogramming.com/java/java-file-reading-and-writing-files-in-java.html


    //Use BufferedReader to get lines, then split lines on " " for words
    public void loopByWordTWR(String pathString) {
        //String pathString = "./myFileName.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(pathString))) {
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                String[] wordsInLine = line.split(" ");
                for (int i = 0; i < wordsInLine.length; i++) {
                    String word = wordsInLine[i];
                /* YOUR CODE HERE
                 * e.g.: System.out.println(word); will console-print every word
                 * Or, you can do something else with each word
                 */    
                }        
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    //Ditto for verbose?


    public void loopByWordTWRDense(String pathString) {
        //String pathString = "./myFileName.txt";
        String line; // This will reference one line at a time
        try (BufferedReader reader = new BufferedReader(new FileReader(pathString))) {
            while((line = reader.readLine()) != null) {
                for (String word : line.split(" ")) {
                /* YOUR CODE HERE
                 * e.g.: System.out.println(word); will console-print every word
                 * Or, you can do something else with each word
                 */     
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    //Scanner.hasNext(), .next(), delimits on whitespace by default
    //so it conveniently retrieves words (does not handle clean-up)
    public void loopByWordTWRScanner(String pathString) {
        //String pathString = "./myFileName.txt";
        try (Scanner scanner = new Scanner(new File(pathString))) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                //YOUR CODE HERE
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }


    //Set up a Scanner with System.in to retrieve keyboard input
    //Use a do-while loop to try opening a file with until success
    public BufferedReader repromptForValidFile() {
        Scanner userInput = new Scanner(System.in);
        BufferedReader reader = null;
        do {
            System.out.println("Enter file name :"); 
            try {
                reader = new BufferedReader(new FileReader(userInput.nextLine())); //dense. consider two lines?
            } catch (FileNotFoundException e) {
              System.out.println("File not found! Please try again. ");
           }
        } while(reader == null);
        return reader;
    }
    //import java.io.FileNotFoundException;
    //import java.util.Scanner
    //import java.util.FileReader
    //import java.util.BufferedReader


    //Same as repromptForValidFile, but uses while(true) with break;
    // instead of do-while, since some classes haven't taught do-while.
    public BufferedReader repromptForValidFileBeginner() {
        Scanner userInput = new Scanner(System.in);
        BufferedReader reader = null;
        while(true) {
            System.out.println("Enter file name :"); 
            try {
                reader = new BufferedReader(new FileReader(userInput.nextLine())); //dense. consider two lines?
            } catch (FileNotFoundException e) {
                System.out.println("File not found! Please try again. ");
            }
            if (reader != null) {
                break;
            }
        }
        return reader;
    }
    //import java.io.FileNotFoundException;
    //import java.util.Scanner
    //import java.util.FileReader
    //import java.util.BufferedReader
}


class FilesToCollectionsBuilders {

    //Can quickly substitute: List<String>, ArrayList<String>, Set<String>, TreeSet<String>, HashSet<String>

    public List<String> listOfLinesTCF(String pathString) {
        //String pathString = "./myFileName.txt";
        BufferedReader reader = null;
        List<String> listOfLines = new ArrayList<String>();
        try {
            reader = new BufferedReader(new FileReader(pathString));
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                listOfLines.add(line); //put a line into the list of lines
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return listOfLines;
    }
    //import java.util.FileReader;
    //import Java.util.BufferedReader;
    //import java.io.IOException; 
    //import java.util.ArrayList;
    //import java.util.List;


    public List<String> listOfLinesTWR(String pathString) {
        //String pathString = "./myFileName.txt";
        List<String> listOfLines = new ArrayList<String>();
        try (BufferedReader reader = new BufferedReader(new FileReader(pathString))) {
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                listOfLines.add(line);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        return listOfLines;
    }
    //import Java.util.FileReader;
    //import Java.util.BufferedReader;
    //import java.io.IOException;
    //import java.util.ArrayList;
    //import java.util.List;


    public List<String> listOfLinesTWRDense(String pathString) {
        //String pathString = "./myFileName.txt";
        String line; // This will reference one line at a time
        List<String> listOfLines = new ArrayList<String>();
        try (BufferedReader reader = new BufferedReader(new FileReader(pathString))) {
            while((line = reader.readLine()) != null) {
                listOfLines.add(line);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        return listOfLines;
    }
    //import Java.util.FileReader;
    //import Java.util.BufferedReader;
    //import java.io.IOException;
    //import java.util.ArrayList;
    //import java.util.List;

    public List<String> listOfLinesTWRScanner(String pathString) {
        //String pathString = "./myFileName.txt";
        List<String> listOfLines = new ArrayList<String>();
        try (Scanner scanner = new Scanner(new File(pathString))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                listOfLines.add(line); //compress to one line? ^
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        return listOfLines;
    }
    //import java.io.File;
    //import Java.util.Scanner;
    //import java.io.IOException;
    //import java.util.ArrayList;
    //import java.util.List;

    public List<String> listOfLinesTCFVerbose(String pathString) {
        //String pathString = "./myFileName.txt";
        //"String line" will reference one line at a time
        List<String> listOfLines = new ArrayList<String>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            // FileReader reads text files in a default (or specified) encoding.
            fileReader = new FileReader(pathString);
            // BufferedReader wraps a FileReader for faster performance
            bufferedReader = new BufferedReader(fileReader);
            // readLine() extracts one line at a time, saving it to the String line
            while(true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                listOfLines.add(line);
            }         
        }
        catch(FileNotFoundException e) { //Tip: FNFException v IOExeception
            System.out.println("Unable to find file '" + pathString + "'");                
            e.printStackTrace();
        }
        catch(IOException e) {
            System.out.println("Error while reading file '" + pathString + "'");                  
            e.printStackTrace();
        } finally {
            if(bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return listOfLines;
    }
    //import Java.util.FileReader;
    //import Java.util.BufferedReader;
    //import java.io.IOException;
    //import java.io.FileNotFoundException;
    //https://www.caveofprogramming.com/java/java-file-reading-and-writing-files-in-java.html
    //import java.util.ArrayList;
    //import java.util.List;

    //https://stackoverflow.com/questions/5343689/java-reading-a-file-into-an-arraylist
    public List<String> listOfLinesDense(String pathString) {
        List<String> result = null;
        try {
            result = Files.readAllLines(Paths.get(pathString), Charset.defaultCharset());
            //^arguably too-dense line
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    //import java.nio.file.Files;
    //import java.nio.charset.Charset;
    //import java.util.List;


    //Get lines with BufferedReader, then split on " " to get words,
    //This is the verbose-ish version.
    // Can use while((line = reader.readLine()) != null), and for (String word : line.split(" "));
    public List<String> listOfWordsTWR(String pathString) {
        //String pathString = "./myFileName.txt";
        List<String> listOfWords = new ArrayList<String>();
        try (BufferedReader reader = new BufferedReader(new FileReader(pathString))) {
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                String[] wordsInLine = line.split(" ");
                for (int i = 0; i < wordsInLine.length; i++) {
                    String word = wordsInLine[i];
                    listOfWords.add(word);
                }        
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        return listOfWords;
    }


    //Scanner.hasNext(), .next(), delimits on whitespace by default
    //so it conveniently retrieves words (does not handle clean-up)
    public List<String> listOfWordsTWRScanner(String pathString) {
        //String pathString = "./myFileName.txt";
        List<String> listOfWords = new ArrayList<String>();
        try (Scanner scanner = new Scanner(new File(pathString))) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                listOfWords.add(word); 
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        return listOfWords;
    }
    //Tweak to accommodate Set<String> setOfWords.. HashSet, TreeSet ... 


    public String fileAsOneString(String pathString) {
        String result = null;
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(pathString));
            result = new String(encoded);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }//https://stackoverflow.com/questions/326390/how-do-i-create-a-java-string-from-the-contents-of-a-file
}