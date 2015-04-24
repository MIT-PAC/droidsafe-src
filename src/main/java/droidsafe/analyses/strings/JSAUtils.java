/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */

package droidsafe.analyses.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Body;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Unit;
import soot.ValueBox;
import soot.jimple.InvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Edge;
import dk.brics.string.StringAnalysis;
import droidsafe.android.system.API;
import droidsafe.utils.SootUtils;

/**
 * Class containing utility methods for JSA
 *
 * @author dpetters
 */
public class JSAUtils {

    /**
     *  The logging output.
     */
    private static final Logger logger = LoggerFactory.getLogger(JSAUtils.class);

    /**
     * Set JSA hotspots to be every method signature in attr modeling that has a string as a parameter
     */
    /*
    public static void setUpHotspots(){
        Reflections reflections = new Reflections(ValueAnalysis.MODEL_PACKAGE);

        Set<Class<? extends VAModel>> modeledClasses = 
            reflections.getSubTypesOf(VAModel.class);

        for(Class<? extends VAModel> modeledClass : modeledClasses){
            Method modeledMethods[] = modeledClass.getDeclaredMethods();

            for (Method modeledMethod : modeledMethods) {
                ArrayList<Integer> paramOfInterestIndexes = new ArrayList<Integer>();

                String signature = "<";
                signature += modeledClass.getName().replace(ValueAnalysis.MODEL_PACKAGE_PREFIX, "") + ": ";
                signature += modeledMethod.getReturnType().getName().replace(ValueAnalysis.MODEL_PACKAGE_PREFIX, "")
                          + " ";
                signature += modeledMethod.getName().replace("_init_", "<init>");

                signature += "(";
                Class<?>[] paramClasses = modeledMethod.getParameterTypes();
                Type[] genericParamTypes = modeledMethod.getGenericParameterTypes();
                for(int i = 0; i < genericParamTypes.length; i++) {
                    Class paramClass = paramClasses[i];
                    String paramTypeString = paramClass.getName();
                    if(paramTypeString.equals("java.util.Set")) {
                        Type genericParamType = genericParamTypes[i];
                        if(genericParamType instanceof ParameterizedType) {
                            ParameterizedType parameterizedType = (ParameterizedType)genericParamType;
                            Type typeParamForBaseInterface = parameterizedType.getActualTypeArguments()[0];
                            if(typeParamForBaseInterface instanceof Class) {
                                Class typeParamForBaseInterfaceClass = (Class)typeParamForBaseInterface;
                                paramTypeString = typeParamForBaseInterfaceClass.getName()
                                                  .replace(ValueAnalysis.MODEL_PACKAGE_PREFIX, "");
                                if(   paramTypeString.equals("java.lang.String") 
                                   || paramTypeString.equals("java.lang.CharSequence")
                                   || paramTypeString.equals("java.lang.StringBuffer")
                                   || paramTypeString.equals("java.lang.StringBuilder")) {
                                    paramOfInterestIndexes.add(i);
                                } else if(typeParamForBaseInterfaceClass.equals(ValueAnalysisBoolean.class)){
                                    paramTypeString = "boolean";
                                } else if(typeParamForBaseInterfaceClass.equals(ValueAnalysisByte.class)){
                                    paramTypeString = "byte";
                                } else if(typeParamForBaseInterfaceClass.equals(ValueAnalysisChar.class)){
                                    paramTypeString = "char";
                                } else if(typeParamForBaseInterfaceClass.equals(ValueAnalysisDouble.class)){
                                    paramTypeString = "double";
                                } else if(typeParamForBaseInterfaceClass.equals(ValueAnalysisFloat.class)){
                                    paramTypeString = "float";
                                } else if(typeParamForBaseInterfaceClass.equals(ValueAnalysisInt.class)){
                                    paramTypeString = "int";
                                } else if(typeParamForBaseInterfaceClass.equals(ValueAnalysisLong.class)){
                                    paramTypeString = "long";
                                } else if(typeParamForBaseInterfaceClass.equals(ValueAnalysisShort.class)){
                                    paramTypeString = "short";
                                }
                            }
                        }
                    }
                    signature += paramTypeString;
                    if(i+1 < genericParamTypes.length){
                        signature += ",";
                    }
                }
                signature += ")>";
                if(paramOfInterestIndexes.size() > 0){
                    for(Integer index : paramOfInterestIndexes){
                        JSAStrings.v().addArgumentHotspots(signature, index);
                    }
                }
            }
        }
    }
     */

    //    public static void setupSpecHotspots()
    //    {
    //        for (SootMethod m : API.v().getAllSystemMethods()) {
    //            if (m.isDeclared()) {
    //                try {
    //                    String sig = m.getSignature();
    //                    int i = 0;
    //                    for (soot.Type t : m.getParameterTypes()) {
    //                        if (SootUtils.isStringOrSimilarType(t)) {
    //                            List<ValueBox> hs = JSAStrings.v().addArgumentHotspots(sig, i);
    //                        }
    //                        i++;     
    //                    }
    //                } catch (Exception e) {
    //                    logger.error("Exception when adding hotspot for method.", e);
    //                }
    //                // FIXME: Return hotspots are raising an exception.
    //                /*
    //                    if (SootUtils.isStringType(m.getReturnType())) {
    //                        System.out.println(String.format("addReturnHotspots(%s)", sig));
    //                        JSAStrings.v().addReturnHotspot(sig);
    //                    }
    //                 */
    //            }
    //        }
    //    }

    /**
     * Set JSA hotspots to be all system methods that have a string as a parameter.
     */
    public static void setupSpecHotspots() {
        Set<SootMethod> systemMethods = getSystemMethodsWithStringArgs();
        CallGraph cg = Scene.v().getCallGraph();
        Map<SootMethod, List<InvokeExpr>> methodToInvokeExprsMap = new HashMap<SootMethod, List<InvokeExpr>>();
        // LWG: Allow application classes to be filtered from soot.Scene
        Iterator aci = StringAnalysis.getApplicationClasses().iterator(); // Scene.v().getApplicationClasses()
        while (aci.hasNext()) {
            SootClass ac = (SootClass) aci.next();
            Iterator mi = ac.getMethods().iterator();
            while (mi.hasNext()) {
                SootMethod sm = (SootMethod) mi.next();
                if (sm.isConcrete()) {
                    Body body = null;
                    try {
                        body = sm.retrieveActiveBody();
                    }
                    catch (Exception ex) {
                        logger.info("Exception retrieving method body {}", ex);
                        continue;
                    }
                    for (Unit unit : body.getUnits()) {
                        Stmt stmt = (Stmt) unit;
                        if (stmt.containsInvokeExpr()) {
                            boolean containsHotspot = false;
                            InvokeExpr expr = stmt.getInvokeExpr();
                            SootMethod tgt = null;
                            //find first system method
                            Iterator<Edge> edges = cg.edgesOutOf(stmt);                            
                            while (edges.hasNext() && !containsHotspot) {
                                tgt = edges.next().getTgt().method();
                                if (systemMethods.contains(tgt)) {
                                    containsHotspot = true;
                                }
                            }

                            if (containsHotspot) {
                                List<InvokeExpr> exprs = methodToInvokeExprsMap.get(tgt);
                                if (exprs == null) {
                                    exprs = new ArrayList<InvokeExpr>();
                                    methodToInvokeExprsMap.put(tgt, exprs);
                                }
                                exprs.add(expr);
                            }
                        }
                    }
                }
            }
        }
        for (SootMethod method: methodToInvokeExprsMap.keySet()) {
            String sig = method.getSignature();
            int i = 0;
            for (soot.Type t : method.getParameterTypes()) {
                if (SootUtils.isStringOrSimilarType(t)) {
                    List<ValueBox> sigSpots = new ArrayList<ValueBox>();
                    for (InvokeExpr expr: methodToInvokeExprsMap.get(method)) {
                        ValueBox box = expr.getArgBox(i);
                        sigSpots.add(box);
                    }
                    JSAStrings.v().addArgumentHotspots(sig, i, sigSpots);
                }
                i++;
            }
        }
    }

    private static Set<SootMethod> getSystemMethodsWithStringArgs() {
        Set<SootMethod> result = new HashSet<SootMethod>();
        for (SootMethod m : API.v().getAllSystemMethods()) {
            // android generated method which is not declared causes error during signature computation
            if (m.isDeclared() && hasStringArgs(m))
                result.add(m);
        } 
        return result;
    }

    private static boolean hasStringArgs(SootMethod method) {
        for (soot.Type t : method.getParameterTypes()) {
            if (SootUtils.isStringOrSimilarType(t))
                return true;
        }
        return false;
    }
}
