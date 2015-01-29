package dk.brics.string;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Unit;
import soot.ValueBox;
import soot.jimple.FieldRef;
import soot.jimple.InvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.StringConstant;
import dk.brics.automaton.Automaton;
import dk.brics.automaton.RegExp;
import dk.brics.string.external.FieldResolution;
import dk.brics.string.external.MethodResolution;
import dk.brics.string.external.Resolver;

/**
 * Encapsulation of the analysis of a program
 * using the string analysis runtime library.
 * <p/>
 * This class serves two purposes:
 * <ul>
 * <li>It implements the {@link dk.brics.string.external.Resolver} interface to
 * identify {@link dk.brics.string.runtime.Strings#cast Strings.cast}
 * calls and tell the string analysis about the assumption.</li>
 * <li>It locates all hotspots, indicated by
 * {@link dk.brics.string.runtime.Strings#analyze Strings.analyze} and
 * {@link dk.brics.string.runtime.Strings#check Strings.check} calls.
 * </ul>
 * <p/>
 * The following code will analyze a program with respect to the runtime methods.
 * The resolver is added to the list of active resolvers to make the analysis aware
 * of the results of {@link dk.brics.string.runtime.Strings#cast Strings.cast} calls,
 * and the hotspots used in the analysis are the expressions occurring as the first
 * argument to {@link dk.brics.string.runtime.Strings#analyze Strings.analyze} and
 * {@link dk.brics.string.runtime.Strings#check Strings.check} calls.
 * <pre>
 *  RuntimeResolver rr = new RuntimeResolver();
 *  StringAnalysis.addResolver(rr);
 *  StringAnalysis sa = new StringAnalysis(rr.getHotspotExps());
 * </pre>
 * The {@link dk.brics.string.StringAnalysis} object <code>sa</code> will now contain
 * the results of the analysis. Run through the set of {@link dk.brics.string.RuntimeHotspot}
 * objects returned by the {@link dk.brics.string.RuntimeResolver#getHotspots getHotspots}
 * method and compare the result given by the string analysis to the expected result given
 * for the hotspot.
 *
 * @see dk.brics.string.StringAnalysis#addResolver StringAnalysis.addResolver
 * @see dk.brics.string.RuntimeHotspot
 * @see dk.brics.string.AnalyzeRuntime
 * @see dk.brics.string.InvalidRuntimeUseException
 */
@SuppressWarnings("unchecked")
public class RuntimeResolver implements Resolver {

    private BindingAutomatonProvider bindings;

    private List<RuntimeHotspot> hotspots = new ArrayList<RuntimeHotspot>();

    private Logger log = LoggerFactory.getLogger(RuntimeResolver.class);

    /**
     * Initializes a <code>RuntimeResolver</code> for the current
     * application classes.
     * <p/>
     * First, all {@link dk.brics.string.runtime.Strings#bind Strings.bind}
     * calls in the program are collected, so that the regular expressions
     * occurring in runtime method calls can be correctly resolved.<br>
     * Second, all {@link dk.brics.string.runtime.Strings#analyze Strings.analyze} and
     * {@link dk.brics.string.runtime.Strings#check Strings.check} calls are
     * internally marked as hotspots. These can be queried using the
     * {@link dk.brics.string.RuntimeResolver#getHotspots getHotspots} and
     * {@link dk.brics.string.RuntimeResolver#getHotspotExps getHotspotExps} methods.
     *
     * @throws InvalidRuntimeUseException if some invalid use of the runtime
     *                                    library is encountered.
     */
    public RuntimeResolver(BindingAutomatonProvider bindings) {
        this.bindings = bindings;
        log.info("Finding runtime support methods...");
        findHotspots();
    }
    public RuntimeResolver() {
        this(new BindingAutomatonProvider());
    }
    
    /**
     * Returns the runtime method hotspots for the program.
     *
     * @return a list of {@link dk.brics.string.RuntimeHotspot} objects
     *         describing the runtime method hotspots.
     */
    public List<RuntimeHotspot> getHotspots() {
        return hotspots;
    }

    /**
     * Returns the string expressions corresponding to the
     * runtime method hotspots for the program.
     *
     * @return a list of {@link soot.ValueBox} objects indicating the
     *         expressions marked as hotspots.
     */
    public List<ValueBox> getHotspotExps() {
        List<ValueBox> exps = new ArrayList<ValueBox>();
        for (RuntimeHotspot rh : hotspots) {
            exps.add(rh.spot);
        }
        return exps;
    }
    
    void findHotspots() {
        // Find all hotspots
        Iterator aci = Scene.v().getApplicationClasses().iterator();
        while (aci.hasNext()) {
            SootClass ac = (SootClass) aci.next();
            Iterator mi = ac.getMethods().iterator();
            while (mi.hasNext()) {
                SootMethod sm = (SootMethod) mi.next();
                if (sm.isConcrete()) {
                    
                    for (Unit unit : sm.getActiveBody().getUnits()) {
                        Stmt stmt = (Stmt) unit;
                        if (stmt.containsInvokeExpr()) {
                            InvokeExpr expr = stmt.getInvokeExpr();
                            if (expr.getMethod().getSignature().equals("<dk.brics.string.runtime.Strings: java.lang.String analyze(java.lang.String,java.lang.String)>")) {
                                ValueBox spot = expr.getArgBox(0);
                                Automaton expected = getRegExp(expr).toAutomaton(bindings);
                                hotspots.add(new RuntimeHotspot(spot, expected, HotspotKind.ANALYZE));
                            } else
                            if (expr.getMethod().getSignature().equals("<dk.brics.string.runtime.Strings: java.lang.String analyze(java.lang.String,java.net.URL)>")) {
                                ValueBox spot = expr.getArgBox(0);
                                Automaton expected = bindings.getFromURL(bindings.getConstantURL(expr.getArg(1)));
                                hotspots.add(new RuntimeHotspot(spot, expected, HotspotKind.ANALYZE));
                            } else
                            if (expr.getMethod().getSignature().equals("<dk.brics.string.runtime.Strings: java.lang.String check(java.lang.String,java.lang.String)>")) {
                                ValueBox spot = expr.getArgBox(0);
                                Automaton expected = getRegExp(expr).toAutomaton(bindings);
                                hotspots.add(new RuntimeHotspot(spot, expected, HotspotKind.CHECK));
                            } else
                            if (expr.getMethod().getSignature().equals("<dk.brics.string.runtime.Strings: java.lang.String check(java.lang.String,java.net.URL)>")) {
                                ValueBox spot = expr.getArgBox(0);
                                Automaton expected = bindings.getFromURL(bindings.getConstantURL(expr.getArg(1)));
                                hotspots.add(new RuntimeHotspot(spot, expected, HotspotKind.CHECK));
                            }
                        }
                    }
                }
            }
        }
    }
    
//    private URL getURL(InvokeExpr expr, Value lastURLInstantiated, String lastURL) {
//        if (!expr.getArg(1).equals(lastURLInstantiated)) {
//            throw new InvalidRuntimeUseException("Non-constant URL");
//        }
//        try {
//            return new URL(lastURL);
//        } catch (MalformedURLException ex) {
//            throw new InvalidRuntimeUseException(ex);
//        }
//    }
    
    String getName(InvokeExpr expr) {
        if (expr.getArg(0) instanceof StringConstant) {
            return ((StringConstant)expr.getArg(0)).value;
        } else {
            throw new InvalidRuntimeUseException("Non-constant name");
        }
    }

    RegExp getRegExp(InvokeExpr expr) {
        if (expr.getArg(1) instanceof StringConstant) {
            return new RegExp(((StringConstant) expr.getArg(1)).value);
        } else {
            throw new InvalidRuntimeUseException("Non-constant regexp");
        }
    }

    /**
     * If the given target method is {@link dk.brics.string.runtime.Strings#cast Strings.cast},
     * returns the automaton given as a regular expression or automaton URL in the cast.
     * <p/>
     * If the given target method is {@link dk.brics.string.runtime.Strings#cast Strings.analyze},
     * returns the value box for the first argument.
     *
     * @param expr   the invocation to be resolved.
     * @param target the target method.
     * @return the automaton given in the cast, or <code>null</code>.
     * @throws InvalidRuntimeUseException if some invalid use of the runtime
     *                                    library is encountered.
     */
    public MethodResolution resolveMethod(InvokeExpr expr, SootMethod target) {
        if (target.getSignature().equals("<dk.brics.string.runtime.Strings: java.lang.String cast(java.lang.String,java.lang.String)>")) {
        	MethodResolution resolution = new MethodResolution(expr.getArgCount());
            resolution.setReturnedAutomaton(getRegExp(expr).toAutomaton(bindings));
            return resolution;
        }
        else if (target.getSignature().equals("<dk.brics.string.runtime.Strings: java.lang.String cast(java.lang.String,java.net.URL)>")) {
        	MethodResolution resolution = new MethodResolution(expr.getArgCount());
        	resolution.setReturnedAutomaton(bindings.getFromURL(bindings.getConstantURL(expr.getArg(1))));
            return resolution;
        }
        else if (target.getSignature().equals("<dk.brics.string.runtime.Strings: java.lang.String analyze(java.lang.String,java.lang.String)>")) {
        	MethodResolution resolution = new MethodResolution(expr.getArgCount());
        	resolution.setReturnedArgument(0);
            return resolution;
        }
        else if (target.getSignature().equals("<dk.brics.string.runtime.Strings: java.lang.String analyze(java.lang.String,java.net.URL)>")) {
        	MethodResolution resolution = new MethodResolution(expr.getArgCount());
        	resolution.setReturnedArgument(0);
            return resolution;
        }
        return null;
    }

    /**
     * No special fields are resolved.
     *
     * @param expr the field to be resolved.
     * @return <code>null</code>.
     */
    public FieldResolution resolveField(FieldRef expr) {
        return null;
    }
}
