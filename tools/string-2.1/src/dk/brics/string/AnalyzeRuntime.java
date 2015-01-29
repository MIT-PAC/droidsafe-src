package dk.brics.string;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.ValueBox;
import dk.brics.automaton.Automaton;
import dk.brics.string.annotation.AnnotationAnalyzer;
import dk.brics.string.annotation.StaticTypeError;
import dk.brics.string.external.ExternalVisibility;
import dk.brics.string.external.MainExternalVisibility;
import dk.brics.string.external.PublicExternalVisibility;
import dk.brics.string.external.Resolver;

/**
 * An executable front-end for analyzing programs using the string analysis
 * runtime library.
 * <p/>
 * The given classes are analyzed using the string analysis, and the results
 * are compared to the expected results as given in all
 * {@link dk.brics.string.runtime.Strings#analyze Strings.analyze} and
 * {@link dk.brics.string.runtime.Strings#check Strings.check} calls.
 * <p/>
 * For all {@link dk.brics.string.runtime.Strings#analyze Strings.analyze} calls,
 * there are three cases:
 * <ul>
 * <li>The inferred language is identical to the expected language.<br>
 * The message &quot;<tt>Exact match!</tt>&quot; is printed.</li>
 * <li>The inferred language is a subset of the expected language.<br>
 * The message &quot;<tt>Always satisfied!</tt>&quot; is printed.</li>
 * <li>There exist one or more strings in the inferred language that
 * are not in the expected language.<br>
 * One shortest example of such a string is printed.</li>
 * </ul>
 * <p/>
 * For all {@link dk.brics.string.runtime.Strings#check Strings.check} calls,
 * there are also three cases:
 * <ul>
 * <li>The inferred language is a subset of the expected language, indicating
 * that the check always succeeds.<br>
 * The message &quot;<tt>Always satisfied!</tt>&quot; is printed.</li>
 * <li>The inferred language is disjoint from the expected language, indicating
 * that the check always fails.<br>
 * The message &quot;<tt>Never satisfied!</tt>&quot; is printed.</li>
 * <li>Otherwise, nothing is printed.</li>
 * </ul>
 */
public class AnalyzeRuntime {
    private static Logger log = LoggerFactory.getLogger(AnalyzeRuntime.class);
    
    /**
     * Initializes the log4j system to print all messages from {@link AnalyzeRuntime}
     * in <tt>System.out</tt>, and suppress all other non-error messages.
     */
    public static void setupLogger() {
       // GMK: Removed this junk to work with slf4j
       /*
        log.addAppender(new AppenderSkeleton() {
            @Override
            protected void append(LoggingEvent e) {
                if (e.getLevel() == Level.ERROR)
                    System.err.println("ERROR " + e.getRenderedMessage());
                else
                    System.out.println(e.getRenderedMessage());
            }
            @Override
            public void close() {
            }
            @Override
            public boolean requiresLayout() {
                return false;
            }
        });
        log.setLevel(Level.ALL);
       */
        // Logger.getRootLogger().setLevel(Level.ERROR);
    }

    // Not instantiable
    private AnalyzeRuntime() {
    }
    
    private static String parseClassname(String classname) {
        if (classname.endsWith(".class")) {
            return classname.substring(0, classname.length() - 6).replace('/', '.');
        } else {
            return classname;
        }
    }
    
    /**
     * Main method for the runtime system.
     * <p/>
     * Any number of arguments may be given. The types of arguments are:
     * <ul>
     *  <li><tt>-dir=</tt><i>directory or jar</i><br>
           Use all class files found in the specified jar file or directory 
           (and its subdirectories, recursively) as application classes. 
           The directory must refer to the root package.
           The directory or jar file does not have to be on the classpath.
     *  <li><i>classname</i><br>
     *     Use the class with the specified fully qualified name or filename as an application class. 
     *     The class must be on the classpath.
     *  <li><tt>-lib=</tt><i>directory or jar</i><br>
           Add every jar file in the specified directory to the classpath, or just the specified 
           file if a jar file was specified. This will typically point to the analyzed project's <tt>lib</tt>
           directory. 
     *  <li><tt>-resolver=</tt><i>classname</i><br>
     *          Use the class with the specified fully qualified name or filename as a resolver 
     *          in the analysis. The class must be on the classpath. 
     *          It must have a constructor taking no arguments and it must implement the {@link Resolver} 
     *          interface.
     *  <li><tt>-externalvisibility=</tt><i>classname or a special identifier</i><br>
     *          Use the class with the specified fully qualified name or filename as a resolver 
     *          in the analysis. The class must be on the classpath. 
     *          It must have a constructor taking no arguments and it must implement the {@link Resolver} 
     *          interface.
     *          Instead of a classname, one may specify one of the predefined strategies using the
     *          identifier <tt>public</tt> or <tt>main</tt>, which are shorthands for
     *          {@link PublicExternalVisibility} and {@link MainExternalVisibility}, respectively.
     * </ul>
     * 
     * @param args a list of arguments, as described above
     */
    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException {
        setupLogger();
        
        log.info("JSA 2.0 -- Runtime System Analyzer");
        
        Debug.init();
        long time0 = System.currentTimeMillis();
        
        boolean foundClasses = false;
        List<Class<?>> customResolvers = new LinkedList<Class<?>>();
        Class<?> external = null;
        log.info("Loading classes...");
        for (int i = 0; i < args.length; i++) {
            // load directory
            if (args[i].startsWith("-dir=")) {
                String dir = args[i].substring(5);
                if (dir.startsWith("\"")) // remove quotes
                    dir = dir.substring(1, dir.length()-1);
                int count = StringAnalysis.loadDirectory(dir);
                if (count == 0) {
                    log.info("No classes were found in " + dir);
                } else {
                    foundClasses = true;
                }
            
            // resolver
            } else if (args[i].startsWith("-resolver=")) {
                String classname = parseClassname(args[i].substring(10));
                try {
                    customResolvers.add(Class.forName(classname));
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException("Could not find resolver class " + classname);
                }
                
            // external visiblity
            } else if (args[i].startsWith("-externalvisibility=")) {
                String classname = parseClassname(args[i].substring(20));
                
                // only one external visiblity may be set
                if (external != null) {
                    throw new RuntimeException("At most one external visibility class may be specified");
                }
                
                // check the predefined identifiers, for convenience
                if (classname.equals("main")) {
                    external = MainExternalVisibility.class;
                } else if (classname.equals("public")) {
                    external = PublicExternalVisibility.class;
                } else {
                    // otherwise try to load it as a classname
                    try {
                        external = Class.forName(classname);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException("Could not find external visibility class " + classname);
                    }
                }
            
            // library classpath
            } else if (args[i].startsWith("-lib=")) {
                String dir = args[i].substring("-lib=".length());
                if (dir.toLowerCase().endsWith(".jar")) {
                    // add as single jar file
                    StringAnalysis.addDirectoryToClassPath(dir);
                } else {
                    // add every jar file in the specified directory
                    boolean found = StringAnalysis.addJarsToClassPath(dir);
                    if (!found) {
                        log.warn("No jar files found in " + dir);
                    }
                }
                
            // load class
            }  else {
                String classname = parseClassname(args[i]);
                StringAnalysis.loadClass(classname);
                foundClasses = true;
            }
        }
        
        // if no classes were found, print a help file
        if (!foundClasses) {
            printHelp();
            return;
        }
        
        long time1 = System.currentTimeMillis();
        
        // collect hotspots
        BindingAutomatonProvider bindings = new BindingAutomatonProvider();
        
        RuntimeResolver rr = new RuntimeResolver(bindings);
        List<RuntimeHotspot> runtimeHotspots = rr.getHotspots();
        
        AnnotationAnalyzer aa = new AnnotationAnalyzer(bindings);
        Set<ValueBox> annotationHotspots = aa.getHotspots();
        
        // if there were static type errors in the @Type annotations then report those and abort
        if (aa.getErrors().size() > 0) {
            log.error("STATIC TYPE ERRORS");
            for (StaticTypeError error : aa.getErrors()) {
                log.error(error.getMessage());
            }
            return;
        }
        
        int numHotspots = runtimeHotspots.size() + annotationHotspots.size();
        log.info("HOTSPOTS");
        log.info("From runtime system: " + runtimeHotspots.size());
        log.info("From annotations:    " + annotationHotspots.size());
        log.info("Total:               " + numHotspots);
        
        List<ValueBox> allHotspots = new ArrayList<ValueBox>();
        allHotspots.addAll(rr.getHotspotExps());
        allHotspots.addAll(annotationHotspots);
        
        // add resolvers
        StringAnalysis.addResolver(rr);
        
        // add custom resolvers
        for (Class<?> clazz : customResolvers) {
            Object o = clazz.newInstance();
            if (!(o instanceof Resolver)) {
                throw new RuntimeException(clazz.getCanonicalName() + " does not implement " + Resolver.class.getCanonicalName());
            }
            Resolver resolver = (Resolver)o;
            StringAnalysis.addResolver(resolver);
        }
        
        // create external visibility
        ExternalVisibility ext = null;
        if (external != null) {
            Object o = external.newInstance();
            if (!(o instanceof ExternalVisibility)) {
                throw new RuntimeException(external.getCanonicalName() + " does not implement " + ExternalVisibility.class.getCanonicalName());
            }
            ext = (ExternalVisibility) o;
        }
        
        StringAnalysis sa = new StringAnalysis(allHotspots, ext);
        
        long time2 = System.currentTimeMillis();
        
        // report results for runtime hotspots
        for (RuntimeHotspot rh : runtimeHotspots) {
            ValueBox e = rh.spot;
            String sf = sa.getSourceFile(e);
            int line = sa.getLineNumber(e);
            String kind = "";
            if (rh.kind == HotspotKind.ANALYZE) {
                kind = "Strings.analyze()";
            } else if (rh.kind == HotspotKind.CHECK) {
                kind = "Strings.check()";
            } else {
                log.error("unrecognized runtime method!");
                System.exit(1);
            }
            log.info("Checking " + kind + " at line " + line + " in " + sf + "...");
            Automaton a = sa.getAutomaton(e);
            Automaton expected_neg = rh.expected.complement();
            if (rh.kind == HotspotKind.ANALYZE) {
                Automaton diff = a.intersection(expected_neg);
                if (diff.isEmpty()) {
                    if (a.equals(rh.expected)) {
                        log.info("Exact match!");
                    } else {
                        log.info("Always satisfied!");
                    }
                } else {
                    log.info("Dissatisfied by:");
                    log.info("\"" + Misc.escape(diff.getShortestExample(true)) + "\"");
                }
            } else if (rh.kind == HotspotKind.CHECK) {
                if (a.intersection(expected_neg).isEmpty()) {
                    log.info("Always satisfied!");
                } else if (a.intersection(rh.expected).isEmpty()) {
                    log.info("Never satisfied!");
                }
            }
        }
        
        // report results for annotation hotspots
        for (ValueBox box : annotationHotspots) {
            String sf = sa.getSourceFile(box);
            int line = sa.getLineNumber(box);
            Automaton auto = sa.getAutomaton(box);
            Automaton expected = aa.getAutomaton(box);
            System.out.print(sf + ":" + line + " ");
            if (!auto.subsetOf(expected)) {
                Automaton violating = auto.minus(expected);
                String example = Misc.escape(violating.getShortestExample(true));
                String type = aa.getDescription(expected);
                if (type.length() > 25) // 25 is completely arbitrary
                    type = type.substring(0, 21) + "...";
                log.info("ERROR: The type \"" + type + "\" is violated by:");
                log.info("    \"" + example + "\"");
            } else {
                System.out.println("OK");
            }
        }
        
        long time3 = System.currentTimeMillis();

        log.info("Loading time: " + time(time1 - time0));
        log.info("Analysis time: " + time(time2 - time1));
        log.info("Extraction time: " + time(time3 - time2));
    }

    private static String time(long t) {
        return t / 1000 + "." + String.valueOf(1000 + (t % 1000)).substring(1);
    }
    
    private static void printHelp() {
        log.info("No classes to analyze were found.");
        log.info("Any number of the following arguments may be specified:");
        log.info("<classname>");
        log.info("\t Analyzes the specified class. Must be on the classpath.");
        log.info("-dir=<directory or jar file>");
        log.info("\t Analyzes all classes in the specified directory or jar file.");
        log.info("\t If a directory is specified, it must be the root package.");
        log.info("-resolver=<classname>");
        log.info("\t Includes an instance of the specified class as a resolver in the analysis.");
        log.info("\t The class must be on the classpath.");
        log.info("-externalvisibility=<classname>");
        log.info("\t Uses the specified class as the external visibility in the analysis.");
        log.info("\t The class must be on the classpath.");
    }
}
