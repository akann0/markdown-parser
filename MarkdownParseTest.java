import static org.junit.Assert.*;

import org.junit.*;

import java.beans.Transient;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.*;

public class MarkdownParseTest { //creates the class
    @Test //lets junit know to run the next function as a test
    public void addition() { //this is a function
        assertEquals(2, 1 + 1); //if theses two terms are not equal, declares an error
    }

    @Test
    public void tutorial() throws IOException{
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of("https://something.com", "some-thing.html"), links);
    }

    @Test
    public void tutorial2() throws IOException{
        Path fileName = Path.of("test-file2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of("https://something.com", "some-page.html"), links);
    }
    
    
    @Test
    public void tutorial3() throws IOException{
        for (int i = 3; i < 8; i++) {
            Path fileName = Path.of("test-file" + i + ".md");
            String content = Files.readString(fileName);
            ArrayList<String> links = MarkdownParse.getLinks(content);
            assertEquals(List.of(), links);
        }
    }

    @Test
    public void tutorial4() throws IOException{
        Path fileName = Path.of("test-file8.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of("a link on the first line"), links);
    }

    @Test
    public void tutorial5() throws IOException{
        Path fileName = Path.of("Tester.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of("https://www.youtube.com/watch?v=dQw4w9WgXcQ", "https://www.google.com/"), links);
    }

    @Test
    public void tutorial6() throws IOException{
        Path fileName = Path.of("Week8Test1.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of("`google.com", "google.com", "ucsd.edu"), links);
    }

    @Test
    public void tutorial7() throws IOException{
        Path fileName = Path.of("Week8Test2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of("a.com","a.com(())","example.com"), links);
    }

    @Test
    public void tutorial8() throws IOException{
        Path fileName = Path.of("Week8Test3.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of(
        "https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule"), links);
    }
}