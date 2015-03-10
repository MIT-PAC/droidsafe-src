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

package droidsafe.analyses;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import soot.MethodOrMethodContext;
import soot.Scene;
import soot.SootMethod;
import soot.jimple.toolkits.callgraph.CallGraph;
import soot.jimple.toolkits.callgraph.Edge;
import soot.jimple.toolkits.callgraph.EdgePredicate;
import soot.jimple.toolkits.callgraph.Filter;
import soot.jimple.toolkits.callgraph.ReachableMethods;
import soot.util.queue.QueueReader;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.android.system.API;

public class CallGraphDumper {

    public CallGraphDumper() {
        // TODO Auto-generated constructor stub
    }
    
    /*
    public static void countReachableMethodsFrom(Edge edge, 
                                                 Map<MethodOrMethodContext, Integer> counts) {
        CallGraph cg = PTABridge.v().getCallGraph();
        
        Iterator<Edge> edges = cg.edgesOutOf(edge.getTgt());
        
        int total = 0;
        
        while (edges.hasNext()) {
            Edge edge = edges.next();
            
            countReachableMethodsFrom(edge.getTgt(), counts);
            total += counts.get(edge.getTgt());
        }
        
        if (!counts.containsKey(momc)) {
            
        }
    }
    */
    
    static EdgePredicate noStaticInits = new EdgePredicate() {

        @Override
        public boolean want(Edge e) {
            return !("<clinit>".equals(e.tgt().getName()));
        }
           
       };
    
    private static Set<MethodOrMethodContext> reachableFromNoClinits(SootMethod method) {
        Set<MethodOrMethodContext> c = new HashSet<MethodOrMethodContext>();            
        c.add(method);
        Filter filter = new Filter(noStaticInits);
        //filter on static initializers, hopefully they won't show in the stats, 
        //or any calls that they make...
        ReachableMethods rm = new ReachableMethods(PTABridge.v().getCallGraph(), c.iterator(), filter);
        rm.update();
        
        Set<MethodOrMethodContext> ret = new HashSet<MethodOrMethodContext>();
        
        QueueReader<MethodOrMethodContext> qr = rm.listener();
        while (qr.hasNext()) {
            ret.add(qr.next());
        }
        
        return ret;
        
    }
    
    public static void runGEXF(String fileStr) {
        System.out.println("Dumping call graph.");
        FileWriter fw;
        try {
            fw = new FileWriter(fileStr);

            fw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                     "<gexf xmlns=\"http://www.gexf.net/1.2draft\" version=\"1.2\">\n" +
                     "<meta lastmodifieddate=\"2009-03-20\">\n" +  
                     "<creator>Gexf.net</creator>\n" +
                     "<description>DroidSafe Call Graph</description>\n" +
                     "</meta>\n" +
                     "<graph mode=\"static\" defaultedgetype=\"directed\">\n");

            StringBuffer edges = new StringBuffer();
            StringBuffer nodes = new StringBuffer();
            int edgeID = 0;
            
            Set<MethodOrMethodContext> momcs;
            //momcs = PTABridge.v().getReachableMethodContexts();
            
            SootMethod theOne = Scene.v().getMethod("<java.net.InterfaceAddress: java.lang.String toString()>");
            momcs = reachableFromNoClinits(theOne.method());
                        
            for (MethodOrMethodContext src : momcs) {
                if ("<clinit>".equals(src.method().getName()))
                    continue;
                
                String methodL = src.toString();
                methodL = methodL.replaceAll("<|>", "");
                nodes.append("<node id=\"" + src.hashCode() + "\" label=\"" + methodL + "\"/>\n");
                //edges
                Iterator<Edge> edgesIt = PTABridge.v().getCallGraph().edgesOutOf(src);
                while (edgesIt.hasNext()) {
                    Edge edge = edgesIt.next();
                    if ("<clinit>".equals(edge.tgt().getName())  || !momcs.contains(edge.getTgt()))
                        continue;
                    
                    edges.append("<edge id=\"" + edgeID + 
                        "\" source=\"" + edge.getSrc().hashCode() + "\" target=\"" + edge.getTgt().hashCode() + "\"/>\n");
                    
                    edgeID++;
                }
            }
            
            fw.write("<nodes>\n");
            fw.write(nodes.toString());
            fw.write("</nodes>\n");
            
            fw.write("<edges>\n");
            fw.write(edges.toString());
            fw.write("</edges>\n");
            
            fw.write("</graph>\n" + 
                     "</gexf>\n");
                    
            fw.close();
        } catch (IOException e) {
            System.err.println("Error writing call graph dot file");
            droidsafe.main.Main.exit(1);
        }
    }

    public static void run(String fileStr) {
        System.out.println("Dumping call graph.");
        FileWriter fw;
        try {
            fw = new FileWriter(fileStr);

            fw.write("digraph CallGraph {\n");

            //get the harness main and all the edges in the call graph
            //from it, and for each edge to an entry point, create and populate
            //the rCFG node
            Set<Edge> visitedEdges = 
                    new HashSet<Edge>();
            Map<String, Set<MethodOrMethodContext>> classSubgraphNodes = 
                    new HashMap<String, Set<MethodOrMethodContext>>();
            Map<String, Set<Edge>> classSubgraphEdges = 
                    new HashMap<String, Set<Edge>>();

            int uniqueID = 0;

            for (MethodOrMethodContext src : PTABridge.v().getReachableMethodContexts()) {
                if (API.v().isSystemMethod(src.method()))
                    continue;

                String className = src.method().getDeclaringClass().getName();

                if (!classSubgraphNodes.containsKey(className)) {
                    classSubgraphNodes.put(className, new HashSet<MethodOrMethodContext>());
                }

                classSubgraphNodes.get(className).add(src);

                Iterator<Edge> edges = PTABridge.v().getCallGraph().edgesOutOf(src);
                while (edges.hasNext()) {
                    Edge edge = edges.next();

                    if (!API.v().reportInSpec(edge.tgt()) && API.v().isSystemMethod(edge.tgt()))
                        continue;

                    boolean isAPI = API.v().reportInSpec(edge.tgt());

                    if (!visitedEdges.contains(edge)) {
                        String tgtID = Integer.toString(edge.getTgt().hashCode());

                        if (isAPI) {
                            //create unique id for api calls so they show up multiple times
                            tgtID += uniqueID++;
                            fw.write(getMethodDotLabel(edge.getTgt(), true, tgtID));
                        }

                        if (className.equals(edge.tgt().method().getDeclaringClass().getName())) {
                            if (!classSubgraphEdges.containsKey(className)) {
                                classSubgraphEdges.put(className, new HashSet<Edge>());
                            }

                            classSubgraphEdges.get(className).add(edge);
                        } else {
                            fw.write(edge.getSrc().hashCode() + "->" + tgtID + ";\n");
                        }

                        visitedEdges.add(edge);

                    }

                }
            }

            for (String pack : classSubgraphNodes.keySet()) {
                String label = pack.replace('.', '_').replace('$', '_');
                fw.write("subgraph " + label + "{\n");
                fw.write("label = \"" + pack + "\";\n");
                fw.write("color=blue;\n");
                for (MethodOrMethodContext m : classSubgraphNodes.get(pack)) {
                    fw.write(getMethodDotLabel(m, false, Integer.toString(m.hashCode())));
                }
                if (classSubgraphEdges.containsKey(pack)) {
                    for (Edge e : classSubgraphEdges.get(pack)) {
                        fw.write(e.getSrc().hashCode() + "->" + e.getTgt().hashCode() + ";\n");
                    }
                }

                fw.write("}\n");
            }

            fw.write("}");
            fw.close();
        } catch (IOException e) {
            System.err.println("Error writing call graph dot file");
            droidsafe.main.Main.exit(1);
        }
    }

    /**
     * Return dot label for methods for dot call graph generation.
     */
    private static String getMethodDotLabel(MethodOrMethodContext m, boolean isAPI, String uniqueID) {
        StringBuffer buf = new StringBuffer();
        if (isAPI)
            buf.append(uniqueID + " [label=\"");
        else 
            buf.append(uniqueID + " [label=\"");
        buf.append(m.method().getDeclaringClass() + "\\n");
        buf.append(m.method().getSubSignature() + "\"");
        if (isAPI)
            buf.append(",color=red,style=filled");
        buf.append("];\n");
        return buf.toString();
    }

}
