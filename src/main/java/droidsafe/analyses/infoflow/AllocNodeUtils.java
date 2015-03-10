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

package droidsafe.analyses.infoflow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import soot.ArrayType;
import soot.G;
import soot.RefType;
import soot.SootField;
import soot.Type;
import soot.jimple.toolkits.pta.IAllocNode;
import droidsafe.analyses.pta.PTABridge;

class AllocNodeUtils {
    HashMap<IAllocNode, Set<IAllocNode>> allocNodeToReachableAllocNodes = new HashMap<IAllocNode, Set<IAllocNode>>();

    Set<IAllocNode> reachableAllocNodes(IAllocNode allocNode) {
        HashSet<IAllocNode> visitedAllocNodes = new HashSet<IAllocNode>();
        return reachableAllocNodes(allocNode, visitedAllocNodes);
        //return reachableAllocNodesDebug(allocNode, visitedAllocNodes, allocNode.getType().toString());
    }
    
    Set<IAllocNode> reachableAllocNodes(IAllocNode allocNode, Set<IAllocNode> visitedAllocNodes) {
        visitedAllocNodes.add(allocNode);

        if (this.allocNodeToReachableAllocNodes.containsKey(allocNode)) {
            return this.allocNodeToReachableAllocNodes.get(allocNode);
        }

        Set<IAllocNode> reachableAllocNodes = new HashSet<IAllocNode>();
        reachableAllocNodes.add(allocNode);
        Set<IAllocNode> directlyReachableAllocNodes = new HashSet<IAllocNode>();
        Type type = allocNode.getType();
        if (type instanceof RefType) {
            if (allocNode instanceof soot.jimple.spark.pag.AllocNode) {
                Set<soot.jimple.spark.pag.AllocDotField> allocDotFields = ((soot.jimple.spark.pag.AllocNode)allocNode).getFields();
                for (soot.jimple.spark.pag.AllocDotField allocDotField : allocDotFields) {
                    // FIXME FIXME       FIXME       FIXME                   FIXME
                    // FIXME             FIXME             FIXME       FIXME
                    // FIXME FIXME       FIXME                   FIXME
                    // FIXME             FIXME             FIXME       FIXME
                    // FIXME             FIXME       FIXME                   FIXME
                    try {
                        SootField field = (SootField)allocDotField.getField();
                        Set<IAllocNode> allocNodes = (Set<IAllocNode>) PTABridge.v().getPTSet(allocNode, field);
                        directlyReachableAllocNodes.addAll(allocNodes);
                    } catch (RuntimeException exception) {
                        exception.printStackTrace(G.v().out);
                    }
                }
            } else if (allocNode instanceof soot.jimple.paddle.AllocNode) {
                Iterator allocDotFields = ((soot.jimple.paddle.AllocNode)allocNode).fields();
                while (allocDotFields.hasNext()) {
                    soot.jimple.paddle.AllocDotField allocDotField = (soot.jimple.paddle.AllocDotField)allocDotFields.next();
                    // FIXME FIXME       FIXME       FIXME                   FIXME
                    // FIXME             FIXME             FIXME       FIXME
                    // FIXME FIXME       FIXME                   FIXME
                    // FIXME             FIXME             FIXME       FIXME
                    // FIXME             FIXME       FIXME                   FIXME
                    try {
                        SootField field = (SootField)allocDotField.field();
                        Set<IAllocNode> allocNodes = (Set<IAllocNode>) PTABridge.v().getPTSet(allocNode, field);
                        directlyReachableAllocNodes.addAll(allocNodes);
                    } catch (RuntimeException exception) {
                        exception.printStackTrace(G.v().out);
                    }
                }
            }
        } else if (type instanceof ArrayType) {
            directlyReachableAllocNodes.addAll(PTABridge.v().getPTSetOfArrayElement(allocNode));
        }
        for (IAllocNode directlyReachableAllocNode : directlyReachableAllocNodes) {
            if (!(visitedAllocNodes.contains(directlyReachableAllocNode))) {
                reachableAllocNodes.addAll(reachableAllocNodes(directlyReachableAllocNode, visitedAllocNodes));
            }
        }
        this.allocNodeToReachableAllocNodes.put(allocNode, reachableAllocNodes);

        return reachableAllocNodes;
    }

    Set<IAllocNode> reachableAllocNodesDebug(IAllocNode allocNode, Set<IAllocNode> visitedAllocNodes, String prefix) {
        visitedAllocNodes.add(allocNode);

        if (this.allocNodeToReachableAllocNodes.containsKey(allocNode)) {
            return this.allocNodeToReachableAllocNodes.get(allocNode);
        }

        Set<IAllocNode> reachableAllocNodes = new HashSet<IAllocNode>();
        reachableAllocNodes.add(allocNode);
        Map<SootField, Set<IAllocNode>> directlyReachableAllocNodes = new HashMap<SootField, Set<IAllocNode>>();
        Type type = allocNode.getType();
        if (type instanceof RefType) {
            if (allocNode instanceof soot.jimple.spark.pag.AllocNode) {
                Set<soot.jimple.spark.pag.AllocDotField> allocDotFields = ((soot.jimple.spark.pag.AllocNode)allocNode).getFields();
                for (soot.jimple.spark.pag.AllocDotField allocDotField : allocDotFields) {
                    // FIXME FIXME       FIXME       FIXME                   FIXME
                    // FIXME             FIXME             FIXME       FIXME
                    // FIXME FIXME       FIXME                   FIXME
                    // FIXME             FIXME             FIXME       FIXME
                    // FIXME             FIXME       FIXME                   FIXME

                    SootField field = (SootField)allocDotField.getField();                    
                    Set<IAllocNode> allocNodes = (Set<IAllocNode>) PTABridge.v().getPTSet(allocNode, field);
                    System.out.println(prefix + "." + field);
                    for (IAllocNode node : allocNodes) {
                        System.out.println("\t" + node);
                    }
                    directlyReachableAllocNodes.put(field, allocNodes);
                }
            }
        } else if (type instanceof ArrayType) {
            directlyReachableAllocNodes.put(new SootField("element", RefType.v("java.lang.Object")), 
                (Set<IAllocNode>) PTABridge.v().getPTSetOfArrayElement(allocNode));
        }
        for (Map.Entry<SootField, Set<IAllocNode>> entry : directlyReachableAllocNodes.entrySet()) {
            for (IAllocNode directlyReachableAllocNode : entry.getValue()) {
                if (!(visitedAllocNodes.contains(directlyReachableAllocNode))) {
                    String fieldString = "<UNKNOWN>";
                    try {
                        fieldString = entry.getKey().toString();
                    } catch (Exception e){
                        
                    }
                    reachableAllocNodes.addAll(reachableAllocNodesDebug(directlyReachableAllocNode, visitedAllocNodes, prefix + "." + fieldString));
                }
            }
        }
        this.allocNodeToReachableAllocNodes.put(allocNode, reachableAllocNodes);

        return reachableAllocNodes;
    }
}
