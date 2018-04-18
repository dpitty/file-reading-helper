//File opening using a try-catch-finally block

export const tryCatchFinally = `String pathString = "./myFileName.txt"; //Your file path goes here
ArrayList<String> listOfLines = new ArrayList<String>();
BufferedReader reader = null;
try {
    reader = new BufferedReader(new FileReader(pathString));
    while (true) {
        String line = reader.readLine();
        if (line == null) {
            break;
        }
    }
}
catch (IOException ex) { //general Exception class for many kinds of IO Exceptions
    System.err.println(ex.getMessage());
    e.printStacktrace(); //to System.err. Red font?
}
finally {
    if (reader != null) {
        reader.close();
    }
}

String pathString="./myFileName.txt";
ArrayList<String>listOfLines=new ArrayList<String>();
BufferedReader reader=null;
try{reader=new BufferedReader(new FileReader(pathString));
    while(true){String line=reader.readLine();
    if(line==null){break;
}}}
catch(IOException ex){System.err.println(ex.getMessage());
    e.printStacktrace();
}
finally{reader.close();
}`;

export const tooltips = {
    BufferedReader: `A common file reader. It would be nice if we could say new BufferedReader(pathString). But Java wasn't built to be friendly to new programmers - it was built to sustain enterprise-scale software.`,
    new: `When we *intantiate* an object, we use the keyword new. {{Explanation of the new keyword}} {{When do we NOT use new? (When a function returns a ready-made object for us)}}`,
    IOException: ` A pretty complicated protocol the designers of Java invented, and then decided to force on all Java programmers. Click here to learn {{how}} exceptions work. Click here to learn {{why}} they exist.`,

    null: ` null often means "this thing doesn't exist." Any *object* can be null. Here, it's useful for us to write that "reader" is null by default, so that later we can test "reader != null" to know that "reader" changed to being a bona-fide, *initialize*d object.`,

    break: ` break is a handy line of code. It causes the program to exit the loop and continue where it left off. You'll often see "break" inside if-statements, where the if-statement describes a sensible reason to stop looping.`
};
