package dk.brics.string;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Unit;
import soot.Value;
import soot.jimple.InvokeExpr;
import soot.jimple.SpecialInvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.StringConstant;
import dk.brics.automaton.Automaton;
import dk.brics.automaton.AutomatonProvider;
import dk.brics.automaton.RegExp;

public class BindingAutomatonProvider implements AutomatonProvider {
    
    private HashMap<String, Automaton> automaton_bind = new HashMap<String, Automaton>();
    private HashMap<String, RegExp> regexp_bind = new HashMap<String, RegExp>();
    private Map<URI, Automaton> uri_cache = new HashMap<URI, Automaton>(); // don't use URLs in collections
    private HashMap<Value, String> url_map = new HashMap<Value, String>();
    
    public BindingAutomatonProvider() {
        findBinds();
    }

    void findBinds() {
        // Find all bind calls
        Iterator<SootClass> aci = Scene.v().getApplicationClasses().iterator();
        while (aci.hasNext()) {
            SootClass ac = aci.next();
            Iterator<SootMethod> mi = ac.getMethods().iterator();
            while (mi.hasNext()) {
                SootMethod sm = mi.next();
                if (sm.isConcrete()) {
                    for (Unit unit : sm.getActiveBody().getUnits()) {
                        Stmt stmt = (Stmt) unit;
                        
                        if (stmt.containsInvokeExpr()) {
                            InvokeExpr expr = stmt.getInvokeExpr();
                            if (expr instanceof SpecialInvokeExpr &&
                                    expr.getMethod().getSignature().equals("<java.net.URL: void <init>(java.lang.String)>") &&
                                    expr.getArg(0) instanceof StringConstant) {
                                Value value = ((SpecialInvokeExpr)expr).getBase();
                                String url = ((StringConstant)expr.getArg(0)).value;
                                url_map.put(value, url);
                            }
                            if (expr.getMethod().getSignature().equals("<dk.brics.string.runtime.Strings: void bind(java.lang.String,java.lang.String)>")) {
                                String name = getName(expr);
                                RegExp re = getRegExp(expr);
                                regexp_bind.put(name, re);
                            }
                            if (expr.getMethod().getSignature().equals("<dk.brics.string.runtime.Strings: void bind(java.lang.String,java.net.URL)>")) {
                                String name = getName(expr);
                                URL url = getConstantURL(expr.getArg(1));
                                automaton_bind.put(name, getFromURL(url));
                            }
                        }
                    }
                }
            }
        }
        // since bindings may reference each other like an acyclic graph, we should compile them in the correct order
        // we do a topological sorting to get this right
        // this also detects cycles and throws an exception if necessary
        List<String> list = new LinkedList<String>();
        Set<String> working = new HashSet<String>();
        for (String id : regexp_bind.keySet()) {
            topsort(id, list, working);
        }
        for (String id : list) {
            automaton_bind.put(id, regexp_bind.get(id).toAutomaton(automaton_bind));
        }
        // free some memory
        regexp_bind = null;
    }
    
    private void topsort(String id, List<String> result, Set<String> working) {
        if (working.contains(id))
            throw new InvalidRuntimeUseException("Circular binding of regular expression involving \"" + id + "\"");
        if (result.contains(id))
            return; // already done
        working.add(id);
        for (String required : regexp_bind.get(id).getIdentifiers()) {
            topsort(required, result, working);
        }
        working.remove(id);
        result.add(id);
    }

    private String getName(InvokeExpr expr) {
        if (expr.getArg(0) instanceof StringConstant) {
            return ((StringConstant)expr.getArg(0)).value;
        } else {
            throw new InvalidRuntimeUseException("Non-constant name");
        }
    }

    private RegExp getRegExp(InvokeExpr expr) {
        if (expr.getArg(1) instanceof StringConstant) {
            return new RegExp(((StringConstant) expr.getArg(1)).value);
        } else {
            throw new InvalidRuntimeUseException("Non-constant regexp");
        }
    }
    
    public URL getConstantURL(Value value) {
        if (!url_map.containsKey(value)) {
            throw new InvalidRuntimeUseException("Non-constant URL");
        }
        try {
            String urlString = url_map.get(value);
            return new URL(urlString);
        } catch (MalformedURLException ex) {
            throw new InvalidRuntimeUseException(ex);
        }
    }
    
    public Automaton getFromURL(URL url) {
        try {
            URI uri = new URI(url.toString());
            if (uri_cache.containsKey(uri)) {
                return uri_cache.get(uri);
            }
            Automaton a = Automaton.load(url);
            uri_cache.put(uri, a);
            return a;
        } catch (Exception e) {
            throw new InvalidRuntimeUseException("Invalid automaton URL: " + url);
        }
    }
    
    public Automaton getAutomaton(String name) {
        return automaton_bind.get(name);
    }
}
