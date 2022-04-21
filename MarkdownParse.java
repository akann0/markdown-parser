//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);
            // if any of []() do not exist, end loop
            if (openBracket == -1 || closeBracket == -1 || 
            openParen == -1 || closeParen == -1){
                currentIndex = markdown.length();
                break;
            }
            
            else if(markdown.indexOf("!", openBracket - 1) == openBracket - 1 
            && openBracket > 0){
                // if said link is an image, don't count it
                currentIndex = closeParen + 1;
        
            }
            // only count if []() is all on the same line
            else if (markdown.indexOf("\n", openBracket) == -1 ||
            markdown.indexOf("\n", openBracket) >= closeParen) {
                toReturn.add(markdown.substring(openParen + 1, closeParen));
                currentIndex = closeParen + 1;
            }
            else{ currentIndex = markdown.indexOf("\n", openBracket);}
            //System.out.println(currentIndex);
        }

        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
        System.out.println("The links are: ");
	    System.out.println(links);
    }
}
