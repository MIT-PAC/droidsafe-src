import com.java2html.*;

/**
 * This class demonstrates the use of the Java2HTML API
 *
 * Ensure the you have the file j2h.jar on your classpath
 *
 */
public class TestExample {

    public static void main(String[] args) throws Exception {

        Java2HTML java2HTML = new Java2HTML();

        try {
            java2HTML.setTitle("Demonstrates use of the Java2HTML API");
            java2HTML.setDestination("C:\\test");
            java2HTML.setMarginSize(4);
            java2HTML.setTabSize(4);
            java2HTML.setFooter(true);
            java2HTML.setFooter(false);

            // Specifies Java Sources
            String[] javaSources = new String[] {"C:\\projects\\test\\src\\java"};
            java2HTML.setJavaDirectorySource(javaSources);

            // Specifies JavaDoc Options
            JavaDoc javaDoc = new JavaDoc( new java.io.File("C:\\jdk1.3.1\\docs\\api"), "http://java.sun.com/products/jdk/1.3/docs/api");
            JavaDoc[] javaDocs=  new JavaDoc[] {javaDoc};
            java2HTML.setJavaDoc(javaDocs);

            // Generate Java2HTML output to C:\test Directory
            java2HTML.buildJava2HTML();
        }
        catch (BadOptionException e) {
            System.err.println("Bad Option: " + e.getMessage());
        }

    }

}


