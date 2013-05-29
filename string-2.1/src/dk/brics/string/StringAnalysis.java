package dk.brics.string;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import soot.ArrayType;
import soot.G;
import soot.Hierarchy;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Type;
import soot.Unit;
import soot.ValueBox;
import soot.jimple.InvokeExpr;
import soot.jimple.ReturnStmt;
import soot.jimple.Stmt;
import soot.toolkits.graph.CompleteUnitGraph;
import dk.brics.automaton.Automaton;
import dk.brics.string.diagnostics.DiagnosticsStrategy;
import dk.brics.string.diagnostics.IntermediateCompletedEvent;
import dk.brics.string.diagnostics.NullDiagnosticsStrategy;
import dk.brics.string.external.ExternalVisibility;
import dk.brics.string.external.PublicExternalVisibility;
import dk.brics.string.external.Resolver;
import dk.brics.string.flow.FlowGraph;
import dk.brics.string.flow.Node;
import dk.brics.string.flow.operations.FlowGraph2Grammar;
import dk.brics.string.grammar.AutomatonProduction;
import dk.brics.string.grammar.BinaryProduction;
import dk.brics.string.grammar.EpsilonProduction;
import dk.brics.string.grammar.Grammar;
import dk.brics.string.grammar.Nonterminal;
import dk.brics.string.grammar.PairProduction;
import dk.brics.string.grammar.Production;
import dk.brics.string.grammar.ProductionVisitor;
import dk.brics.string.grammar.UnaryProduction;
import dk.brics.string.grammar.UnitProduction;
import dk.brics.string.grammar.operations.Grammar2MLFA;
import dk.brics.string.intermediate.Application;
import dk.brics.string.intermediate.Statement;
import dk.brics.string.intermediate.StringStatement;
import dk.brics.string.intermediate.operations.AliasAnalysis;
import dk.brics.string.intermediate.operations.AliasAssertionAnalysis;
import dk.brics.string.intermediate.operations.OperationAssertionAnalysis;
import dk.brics.string.intermediate.operations.FieldUsageAnalysis;
import dk.brics.string.intermediate.operations.Intermediate2FlowGraph;
import dk.brics.string.intermediate.operations.LivenessAnalysis;
import dk.brics.string.intermediate.operations.ReachingDefinitions;
import dk.brics.string.java.Jimple2Intermediate;
import dk.brics.string.java.Jimple2IntermediateFactoryImpl;
import dk.brics.string.java.StaticStringTypes;
import dk.brics.string.java.StaticStringTypesNull;
import dk.brics.string.java.TaintAnalysisStrategy;
import dk.brics.string.mlfa.MLFA;
import dk.brics.string.mlfa.MLFAStatePair;
import dk.brics.string.mlfa.operations.MLFA2Automaton;
import dk.brics.string.stringoperations.Basic;

/**
 * A <code>StringAnalysis</code> object encapsulates a string analysis performed
 * on a collection of classes.
 * The class also contains some convenience methods for loading and traversing
 * the classes to be analyzed.<p>
 */
@SuppressWarnings("unchecked")
public class StringAnalysis {

    private static List<Resolver> resolvers = new ArrayList<Resolver>();

    private Jimple2Intermediate jt;
    private MLFA2Automaton mlfa2aut;
    private Map<ValueBox, MLFAStatePair> map;
    private Map<SootClass, MLFAStatePair> tostring_map;

    private Map<ValueBox, String> sourcefile_map;
    private Map<ValueBox, String> class_map;
    private Map<ValueBox, String> method_map;
    private Map<ValueBox, Integer> line_map;
    private int num_exps;

    private Map<ValueBox, Nonterminal> hs_nt_map;
    private Grammar hs_grammar;

    private static Logger log = LoggerFactory.getLogger(StringAnalysis.class);

    /* fields used during the analysis, but not afterwards */
    private transient DiagnosticsStrategy diagnostics;
    private transient ExternalVisibility externallyVisible;
    private transient TaintAnalysisStrategy taintAnalysisStrategy;
    private transient Collection<ValueBox> hotspots;
    
    private StaticStringTypes staticStringTypes;

    // LWG: New. Allow application classes to be filtered from soot.Scene
    private static Collection<SootClass> applicationClasses = null;

    static {
        initializeSoot();
    }

    // Make sure we get line numbers
    private static void initializeSoot() { // cannot avoid static methods because of Soot :-(
        soot.Scene.v().loadBasicClasses();
        soot.options.Options.v().parse(new String[]{"-keep-line-number"});
    }

    /**
     * Resets Soot's globals and the list of resolvers.
     * GMK: Commenting out, to integrate with droidsafe.
     **/

    /*
    public static void reset() {
        G.reset();
        initializeSoot();
        clearResolvers();
    }
    */

    // LWG: New. Allow application classes to be filtered from soot.Scene
    public static void setApplicationClasses(Collection<SootClass> appClasses) {
    	applicationClasses = appClasses;
    }
    
    // LWG: New. Allow application classes to be filtered from soot.Scene
    public static Collection<SootClass> getApplicationClasses() {
    	if (applicationClasses == null)
    		applicationClasses = Scene.v().getApplicationClasses();
    	return applicationClasses;
    }

    /**
     * Adds the given resolver to the list of active resolvers used
     * during the string analysis.
     *
     * @param r the resolver to add.
     * @see dk.brics.string.external.Resolver
     */
    public static void addResolver(Resolver r) {
        resolvers.add(r);
    }

    /**
     * Removes the given resolver from the list of active resolvers used
     * during the string analysis.
     *
     * @param r the resolver to remove.
     * @see dk.brics.string.external.Resolver
     */
    public static void removeResolver(Resolver r) {
        resolvers.remove(r);
    }

    /**
     * Removes all active resolvers.
     *
     * @see dk.brics.string.external.Resolver
     */
    public static void clearResolvers() {
        resolvers = new ArrayList<Resolver>();
    }

    /**
     * Performs a string analysis on the current application classes.
     * All expressions are considered hot spots.
     */
    public StringAnalysis() {
        this(null, null, null);
    }

    /**
     * Performs a string analysis on the current application classes.
     * All expressions are considered hot spots.
     *
     * @param ext defines which methods are externally visible.
     */
    public StringAnalysis(ExternalVisibility ext) {
        this(null, ext, null);
    }

    /**
     * Performs a string analysis on the current application classes.
     *
     * @param hotspots a set of {@link soot.ValueBox} objects indicating
     *                 the desired hot spots
     */
    public StringAnalysis(Collection<ValueBox> hotspots) {
        this(hotspots, null, null);
    }

    public StringAnalysis(Collection<ValueBox> hotspots, ExternalVisibility ext) {
        this(hotspots, ext, null);
    }

    public StringAnalysis(Collection<ValueBox> hotspots, ExternalVisibility ext, TaintAnalysisStrategy taintAnalysisStrategy) {
        this(hotspots, ext, taintAnalysisStrategy, null);
    }

    /**
     * Performs a string analysis on the current application classes.
     *
     * @param hotspots          a set of {@link soot.ValueBox} objects indicating
     *                          the desired hot spots
     * @param externallyVisible defines which methods are externally visible.
     */
    public StringAnalysis(Collection<ValueBox> hotspots, 
                        ExternalVisibility externallyVisible, 
                        TaintAnalysisStrategy taintAnalysisStrategy,
                          DiagnosticsStrategy diagnostics) {
        this(hotspots, externallyVisible, taintAnalysisStrategy, null, diagnostics);
    }
    
    public StringAnalysis(Collection<ValueBox> hotspots, 
                        ExternalVisibility externallyVisible, 
                        TaintAnalysisStrategy taintAnalysisStrategy,
                        StaticStringTypes staticStringTypes,
                          DiagnosticsStrategy diagnostics) {
        this.hotspots = hotspots;
        this.externallyVisible = externallyVisible;
        this.taintAnalysisStrategy = taintAnalysisStrategy;
        this.staticStringTypes = staticStringTypes;
        this.diagnostics = diagnostics;
        execute();
    }

    /**
     * Runs string analysis from the Jimple-stage to the (final) Automaton-stage. Parameters must be stored in fields before running this.
     */
    private void execute() {
        log.info("Analyzing...");

        // Assign some default strategies, if none were specified
        if (externallyVisible == null) {
            externallyVisible = new PublicExternalVisibility();
        }
        if (staticStringTypes == null) {
            staticStringTypes = new StaticStringTypesNull();
        }
        if (diagnostics == null) {
            diagnostics = new NullDiagnosticsStrategy();
        }

        diagnostics.analysisStarted();

        //
        //	Create intermediate code
        //
        jt = new Jimple2Intermediate(new Jimple2IntermediateFactoryImpl(externallyVisible, taintAnalysisStrategy, staticStringTypes, resolvers));
        Application app = jt.translateApplicationClasses(hotspots);
        Map<ValueBox, Statement> m1 = jt.getTranslationMap();
        num_exps = m1.size() + jt.getNumberOfExpsSkipped();
        
        // release memory
        // G.reset();
        
        //
        //	Analyze the intermediate code
        //
        log.info("Performing field usage analysis...");
        FieldUsageAnalysis fieldUsage = new FieldUsageAnalysis(app.getMethods());
        log.info("Performing liveness analysis...");
        LivenessAnalysis liveness = new LivenessAnalysis(app);
        log.info("Performing alias assertion analysis...");
        AliasAssertionAnalysis aliasAssertions = new AliasAssertionAnalysis(app);
        log.info("Performing alias analysis...");
        AliasAnalysis alias = new AliasAnalysis(app, liveness, fieldUsage, aliasAssertions);
        log.info("Performing reaching definitions analysis...");
        ReachingDefinitions reachingDefinitions = new ReachingDefinitions(app, liveness, alias);
        
        // if no hotspots were specified, make every expression a hotspot by default
        if (hotspots == null) {
            hotspots = m1.keySet(); // take everything by default
        }

        // get the intermediate statements corresponding to each hotspot
        Set<Statement> hotspot_statements = new HashSet<Statement>();
        for (ValueBox b : hotspots) {
            Statement stm = m1.get(b);
            if (stm == null) {
                log.info("Invalid hotspot");
                continue;
            }
            hotspot_statements.add(stm);
        }
        
        // find invalid assertion statements
        OperationAssertionAnalysis assertions = new OperationAssertionAnalysis(app, reachingDefinitions);
        
        if (log.isDebugEnabled()) {
            log.debug(app.toDot(reachingDefinitions, alias, assertions, hotspot_statements));
        }
        
        // End of intermediate creation. Notify diagnostics.
        diagnostics.intermediateCompleted(new IntermediateCompletedEvent(app, liveness, alias, reachingDefinitions, assertions,
				hotspot_statements));

        //
        //	Create flow graph
        //
        log.info("Generating flow graph...");
        Intermediate2FlowGraph tr = new Intermediate2FlowGraph(app);
        FlowGraph g = tr.convert(alias, reachingDefinitions, assertions);
        
        // Notify diagnostics of flow graph
        diagnostics.flowGraphCompleted(g);
        
        Map<Statement, Node> m2 = tr.getTranslationMap();
        if (log.isDebugEnabled()) {
            log.debug("Statement -> Node:");
            for (Map.Entry<Statement, Node> me : m2.entrySet()) {
                log.debug("  " + me.getKey() + " -> " + me.getValue());
            }
        }
        log.info("Simplifying flow graph...");
        Map<Node, Node> m3 = g.simplify();
        Set<Node> nodes = new HashSet<Node>();
        for (Statement ss : hotspot_statements) {
            Node beforeSimplifyNode = m2.get(ss);
            Node n = m3.get(beforeSimplifyNode);
            if (n != null) {
                nodes.add(n);
            }
        }
        for (StringStatement ss : jt.getToStringHotspotMap().values()) {
            Node n = m3.get(m2.get(ss));
            if (n != null) {
                nodes.add(n);
            }
        }
        for (Node n : m3.keySet()) { // TODO: inefficient, use entrySet iterator instead
            Node n2 = m3.get(n);
            if (n.isTaint() && n2 != null) {
                n2.setTaint(true);
            }
        }
        if (log.isDebugEnabled()) {
            log.debug(g.toDot(nodes));
        }
        log.info("Transforming into grammar...");
        FlowGraph2Grammar f2g = new FlowGraph2Grammar(g);
        Grammar r = f2g.convert();
        Set<Nonterminal> hs_nt = new HashSet<Nonterminal>();
        for (Node hn : nodes) {
            hs_nt.add(f2g.getNonterminal(hn));
        }
        if (log.isDebugEnabled()) {
            log.debug(r.toString() + "Hotspots: " + hs_nt);
        }

        // Approximate grammar
        log.info("Cutting operation cycles...");
        r.approximateOperationCycles();
        log.info("Performing regular approximation...");
        r.approximateNonLinear(hs_nt);
        if (log.isDebugEnabled()) {
            log.debug(r.toString() + "Hotspots: " + hs_nt);
        }
        log.info("Converting to MLFA...");

        Grammar2MLFA gm = new Grammar2MLFA(r);
        MLFA mlfa = gm.convert();

        propagateTaint(r);

        for (Node n : nodes) {
            Nonterminal nt = f2g.getNonterminal(n);
            MLFAStatePair sp = gm.getMLFAStatePair(nt);
            if (nt.isTaint()) {
                sp.setTaint(true);
            }
        }
        log.debug(mlfa.toString());

        // Make map
        map = new HashMap<ValueBox, MLFAStatePair>();
        for (ValueBox box : hotspots) {
            Node n = m3.get(m2.get(m1.get(box)));
            if (n != null) {
                Nonterminal nt = f2g.getNonterminal(n);
                MLFAStatePair sp = gm.getMLFAStatePair(nt);
                map.put(box, sp);
            }
        }

        // Save the nonterminal map.
        hs_nt_map = new HashMap<ValueBox, Nonterminal>();
        hs_grammar = r;
        for (ValueBox box : hotspots) {
            Node n = m3.get(m2.get(m1.get(box)));
            if (n != null) {
                Nonterminal nt = f2g.getNonterminal(n);
                hs_nt_map.put(box, nt);
            }
        }


        tostring_map = new HashMap<SootClass, MLFAStatePair>();
        Map<SootClass, StringStatement> tostring_hotspot_map = jt.getToStringHotspotMap();
        for (Map.Entry<SootClass, StringStatement> tse : tostring_hotspot_map.entrySet()) {
            SootClass tsc = tse.getKey();
            StringStatement ss = tse.getValue();
            Node n = m3.get(m2.get(ss));
            if (n != null) {
                Nonterminal nt = f2g.getNonterminal(n);
                MLFAStatePair sp = gm.getMLFAStatePair(nt);
                tostring_map.put(tsc, sp);
            }
        }
        sourcefile_map = jt.getSourceFileMap();
        class_map = jt.getClassNameMap();
        method_map = jt.getMethodNameMap();
        line_map = jt.getLineNumberMap();

        mlfa2aut = new MLFA2Automaton(mlfa);
    }

    private void propagateTaint(Grammar r) {
        final boolean done[] = {false};
        ProductionVisitor v = new ProductionVisitor() {
            public void visitAutomatonProduction(Nonterminal a, AutomatonProduction p) {

            }

            public void visitBinaryProduction(Nonterminal a, BinaryProduction p) {
                if (p.getNonterminal1().isTaint() || p.getNonterminal2().isTaint()) {
                    if (!a.isTaint()) {
                        done[0] = false;
                    }
                    a.setTaint(true);
                }
            }

            public void visitEpsilonProduction(Nonterminal a, EpsilonProduction p) {
            }

            public void visitPairProduction(Nonterminal a, PairProduction p) {
                if (p.getNonterminal1().isTaint() || p.getNonterminal2().isTaint()) {
                    if (!a.isTaint()) {
                        done[0] = false;
                    }
                    a.setTaint(true);
                }
            }

            public void visitUnaryProduction(Nonterminal a, UnaryProduction p) {
                if (p.getNonterminal().isTaint()) {
                    if (!a.isTaint()) {
                        done[0] = false;
                    }

                    a.setTaint(true);
                }

            }

            public void visitUnitProduction(Nonterminal a, UnitProduction p) {
                if (p.getNonterminal().isTaint()) {
                    if (!a.isTaint()) {
                        done[0] = false;
                    }

                    a.setTaint(true);
                }
            }
        };

        while (!done[0]) {
            done[0] = true;
            for (Nonterminal n : r.getNonterminals()) {
                for (Production p : n.getProductions()) {
                    p.visitBy(n, v);
                }
            }
        }
    }

    /**
     * Returns whether or not the given expression has a type that
     * the string analysis is able to handle.
     *
     * @param box the Soot value box containing the expression.
     * @return <code>true</code> if the expression has type {@link java.lang.String},
     *         {@link java.lang.StringBuffer}, {@link java.lang.StringBuilder},
     *         or array (of any dimension) of {@link java.lang.String};
     *         <code>false</code> otherwise;
     */
    public static boolean hasValidType(ValueBox box) {
        Type t = box.getValue().getType();
        if (t instanceof RefType) {
            if (((RefType) t).getSootClass().getName().equals("java.lang.String")) {
                return true;
            }
            if (((RefType) t).getSootClass().getName().equals("java.lang.StringBuffer")) {
                return true;
            }
            if (((RefType) t).getSootClass().getName().equals("java.lang.StringBuilder")) {
                return true;
            }
        }
        if (t instanceof ArrayType) {
            Type bt = ((ArrayType) t).baseType;
            if (bt instanceof RefType && ((RefType) bt).getSootClass().getName().equals("java.lang.String")) {
                return true;
            }
        }
        return false;
    }

    /**
     * Computes the automaton describing the possible string
     * values at the given expression.
     * The expression given can have any type. If the type is
     * {@link java.lang.String}, {@link java.lang.StringBuffer}, {@link java.lang.StringBuilder}, or
     * array (of any dimension) of {@link java.lang.String},
     * the inferred result is returned directly. If it is of a simple type
     * or a wrapper class, the corresponding type automaton is returned.
     * Otherwise, the inferred result for the return values of the
     * relevant <code>toString</code> methods is returned.
     * If a specific set of hotspots has been supplied to the analysis,
     * and the expression is of one of the string types metioned above,
     * the expression given must be one of these hotspots.
     *
     * @param box the Soot value box containing the expression.
     * @return an automaton whose language contains all possible run-time values
     *         of the given expression.
     * @throws IllegalArgumentException if the expression is not a marked hotspot.
     */
    public final Automaton getAutomaton(ValueBox box) {
        if (!hasValidType(box)) {
            return getTypeAutomaton(box.getValue().getType());
        }
        if (!map.containsKey(box)) {
            throw new IllegalArgumentException("Expression is not a marked hotspot");
        }
        MLFAStatePair sp = map.get(box);
        return mlfa2aut.extract(sp);
    }


    public final Nonterminal getNonterminal(ValueBox box) {
        if (!hs_nt_map.containsKey(box)) {
            throw new IllegalArgumentException("Expression is not a marked hotspot");
        }
        Nonterminal nt = hs_nt_map.get(box);
        return nt;
    }

    public final Grammar getGrammar() {
        return hs_grammar;
    }


    /**
     * Returns whether the strings that this valuebox contains can be taint.
     * The strategy is defined by {@link dk.brics.string.java.TaintAnalysisStrategy}.
     */
    public boolean isTaint(ValueBox box) {
        MLFAStatePair sp = map.get(box);
        return sp.isTaint();
    }

    /**
     * Computes the automaton describing the possible string
     * values that can occur as a result of converting the given
     * type into a string.
     * If the type is a simple type or a wrapper class,
     * the corresponding type automaton is returned.
     * Otherwise, the result is the union of the inferred results
     * for the return values of the <code>toString</code> methods of
     * the type and all its subclasses.
     *
     * @param t the Soot type.
     * @return an automaton whose language contains all possible values
     *         of the result of converting this type into a string.
     */
    public final Automaton getTypeAutomaton(Type t) {
        Automaton ta = jt.getTypeAutomaton(t);
        if (ta != null) {
            return ta;
        }
        if (t instanceof RefType) {
            SootClass c = ((RefType) t).getSootClass();
            if (tostring_map.containsKey(c)) {
                MLFAStatePair sp = tostring_map.get(c);
                return mlfa2aut.extract(sp);
            }
        }
        return Basic.makeAnyString();
    }

    /**
     * Returns the name of the source file containing the given expression.
     *
     * @param box the expression.
     * @return the source file name.
     */
    public final String getSourceFile(ValueBox box) {
        return sourcefile_map.get(box);
    }

    /**
     * Returns the name of the class containing the given expression.
     *
     * @param box the expression.
     * @return the fully qualified class name.
     */
    public final String getClassName(ValueBox box) {
        return class_map.get(box);
    }

    /**
     * Returns the name of the method containing the given expression.
     *
     * @param box the expression.
     * @return the method name.
     */
    public final String getMethodName(ValueBox box) {
        return method_map.get(box);
    }

    /**
     * Returns the source line number of the given expression.
     *
     * @param box the expression.
     * @return the line number.
     */
    public final int getLineNumber(ValueBox box) {
        return line_map.get(box);
    }

    /**
     * Loads the named class into the Soot scene,
     * marks it as an application class, and generates bodies
     * for all of its concrete methods.
     *
     * @param name the fully qualified name of the class to be loaded.
     * @return soot's representation of the class
     */
    public static SootClass loadClass(String name) {
        SootClass c = Scene.v().loadClassAndSupport(name);
        c.setApplicationClass();
        Iterator mi = c.getMethods().iterator();
        while (mi.hasNext()) {
            SootMethod sm = (SootMethod) mi.next();
            if (sm.isConcrete()) {
                sm.retrieveActiveBody();
            }
        }
        return c;
    }
    
    /**
     * Adds the specified directory or jar file to the internal classpath, so library classes
     * can be loaded from there. The classes in the directory or jar file will not be considered
     * application classes.
     * @param dir classpath to append. May contain either one directoy or jar file, or several ones separated by {@link File#pathSeparator}.
     */
    public static void addDirectoryToClassPath(String dir) {
        Scene.v().setSootClassPath(Scene.v().getSootClassPath() + File.pathSeparator + dir);
    }
    
    /**
     * Adds all <tt>jar</tt> files found in the specified directory to the internal classpath, so
     * library classes can be loaded from those. The classes in the jar files will not be considered
     * application classes.
     * @param libDir path to a directory containing jar files.
     * @return <tt>true</tt> if at least one jar file was found.
     */
    public static boolean addJarsToClassPath(String libDir) {
        File lib = new File(libDir);
        File[] jars = lib.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.isFile() && file.getName().toLowerCase().endsWith(".jar");
            }
        });
        StringBuilder b = new StringBuilder(Scene.v().getSootClassPath());
        for (File jar : jars) {
            b.append(File.pathSeparator);
            b.append(jar.getPath());
        }
        Scene.v().setSootClassPath(b.toString());
        return (jars.length > 0);
    }
    
    /**
     * Loads all classes in the specified directory, where the directory
     * refers to the root of the package tree.
     * <p/>
     * The classes are loaded immediately, so make sure the classpath is set accordingly
     * using {@link #addJarsToClassPath(String)} or {@link #addDirectoryToClassPath(String)} first.
     * If classes should be loaded from more than one directory, all directories should first
     * be added to the classpath and then loaded.
     * @param dir directory root of the package tree
     * @return the number of classes loaded
     */
    public static int loadDirectory(String dir) throws IOException {
        File file = new File(dir);
        if (!file.isDirectory() && !dir.toLowerCase().endsWith(".jar"))
            throw new RuntimeException(dir + " is not a directory or jar file");
        if (!Scene.v().getSootClassPath().contains(dir)) {
            Scene.v().setSootClassPath(Scene.v().getSootClassPath() + File.pathSeparatorChar + dir);
        }
        if (file.isDirectory()) {
            return loadDirectorySub(file, "");
        } else {
            int count = 0;
            JarFile jar = new JarFile(file);
            Enumeration<JarEntry> e = jar.entries();
            while (e.hasMoreElements()) {
                JarEntry entry = e.nextElement();

                if (entry.isDirectory() || !entry.getName().endsWith(".class"))
                    continue;
                
                String name = entry.getName().substring(0, entry.getName().length() - 6);
                name = name.replace('/', '.');
                loadClass(name);
                count++;
            }
            return count;
        }
    }
    private static int loadDirectorySub(File dir, String prefix) {
        int count = 0;
        File[] files = dir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isDirectory() || (pathname.isFile() && pathname.getName().endsWith(".class"));
            }
        });
        for (File file : files) {
            if (file.isDirectory()) {
                count += loadDirectorySub(file, prefix + file.getName() + ".");
            } else {
                String classname = file.getName().substring(0, file.getName().length() - 6);
                loadClass(prefix + classname);
                count++;
            }
        }
        return count;
    }

    /**
     * Returns the total number of analyzable expressions in the program.
     *
     * @return the number of expressions in the analyzed program that has
     *         a type that the string analysis is able to handle.
     */
    public final int getNumExps() {
        return num_exps;
    }

    /**
     * Returns a list containing all expressions occurring as
     * argument to the specified method.
     *
     * @param sig    the signature of the method to collect arguments to, e.g.
     *               <code>"&lt;java.io.PrintStream: void println(java.lang.String)&gt"</code>.
     * @param argnum the index of the argument to the call
     * @return a newly created mutable list of Soot's representation of those expressions.
     */
    public static List<ValueBox> getArgumentExpressions(String sig, int argnum) {
        ArrayList<ValueBox> list = new ArrayList<ValueBox>();
        // LWG: Allow application classes to be filtered from soot.Scene
        Iterator aci = getApplicationClasses().iterator(); // Scene.v().getApplicationClasses()
        while (aci.hasNext()) {
            SootClass ac = (SootClass) aci.next();
            Iterator mi = ac.getMethods().iterator();
            while (mi.hasNext()) {
                SootMethod sm = (SootMethod) mi.next();
                if (sm.isConcrete()) {
                    CompleteUnitGraph cug = new CompleteUnitGraph(sm.retrieveActiveBody());
                    Iterator si = cug.iterator();
                    while (si.hasNext()) {
                        Stmt stmt = (Stmt) si.next();
                        if (stmt.containsInvokeExpr()) {
                            InvokeExpr expr = stmt.getInvokeExpr();
                            if (expr.getMethodRef().getSignature().equals(sig)) {
                                ValueBox box = expr.getArgBox(argnum);
                                list.add(box);
                            }
                        }
                    }
                }
            }
        }
        return list;
    }
    
    /**
     * Returns a list of all expressions that occur as the return value from the
     * specified method or any method that overrides/implements it.
     * @param sig the signature of the method to collect return expression from, e.g.
     *               <code>"&lt;com.example.Action: String getSomeURL()&gt"</code>.
     * @return a newly created list of Soot's representation of those expressions.
     */
    public static List<ValueBox> getReturnExpressions(String sig) {
        ArrayList<ValueBox> list = new ArrayList<ValueBox>();
        SootMethod targetMethod = Scene.v().getMethod(sig);
        Hierarchy h = Scene.v().getActiveHierarchy();
        if (h == null)
            h = new Hierarchy();
        List<SootMethod> methods = h.resolveAbstractDispatch(targetMethod.getDeclaringClass(), targetMethod);
        for (SootMethod method : methods) {
            if (!method.isConcrete())
                continue;
            for (Unit unit : method.retrieveActiveBody().getUnits()) {
                if (unit instanceof ReturnStmt) {
                    ReturnStmt ret = (ReturnStmt)unit;
                    list.add(ret.getOpBox());
                }
            }
        }
        return list;
    }
}
