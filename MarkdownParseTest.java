import static org.junit.Assert.*;

import org.junit.*;
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

}