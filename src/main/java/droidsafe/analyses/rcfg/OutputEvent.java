package droidsafe.analyses.rcfg;

import java.util.Formatter;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Context;
import soot.SootMethod;
import soot.Type;
import soot.Unit;
import soot.Value;
import soot.ValueBox;
import soot.jimple.DynamicInvokeExpr;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.SpecialInvokeExpr;
import soot.jimple.toolkits.callgraph.Edge;
import soot.jimple.toolkits.pta.IAllocNode;
import soot.jimple.toolkits.pta.IStringConstantNode;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.pta.PTAMethodInformation;
import droidsafe.utils.SourceLocationTag;
import droidsafe.utils.Utils;

/**
 * This class represents an API call in the rCFG.  It is associated with an rCFG node (an input event).  
 * Each output event currently has an underlying soot method, a context edge, a calling edge, and possibly a 
 * receiver.  
 * 
 * @author mgordon
 *
 */
public class OutputEvent implements PTAMethodInformation {
    /** logger field */
    private static final Logger logger = LoggerFactory.getLogger(OutputEvent.class);
    private Edge invokeEdge;
    /** The invoke expression call to an API method, might be null EX finalize*/
    private InvokeExpr invokeExpr;
    /** The parent RFCG Node */
    private RCFGNode parent;
    /** Source locations of the calls for this output event for the given input event */
    private SourceLocationTag linesTag = null;
    /** The receiver nodes that triggers this output event */
    private Set<IAllocNode> receiverNodes;
    /** the types of the receivers */
    private Set<Type> receiverNodeTypes;

    /**
     * Create an output event from an edge, context edge, ... 
     */
    public OutputEvent(Edge edge, RCFGNode p, 
                       SourceLocationTag ln) {
        this.invokeEdge = edge;
        this.parent = p;
        this.receiverNodes = new HashSet<IAllocNode>();
        this.receiverNodeTypes = new HashSet<Type>();
        this.linesTag = ln;

        setInvoke();
    }

    public void addReceiverNode(IAllocNode an) {
        receiverNodes.add(an);
        receiverNodeTypes.add(an.getType());
    }

    /**
     * Try to grab the invoke expression from the context
     */
    private void setInvoke() {
        Unit context = invokeEdge.srcUnit();
        invokeExpr = null;

        if (context == null) {
            return;
        }

        for (Object vb : context.getUseAndDefBoxes()) {
            Value value = ((ValueBox)vb).getValue();

            if (value instanceof InvokeExpr) {
                InvokeExpr ie = (InvokeExpr)value;
                logger.debug("Found invoke in output event {} matches {}?", ie, this.getTarget());
                //old check that does not work for threads since start calls run...
                //if (Hierarchy.v().canResolveTo(ie.getMethodRef(), this.getTarget())) 
                if (invokeExpr != null) {
                    logger.error("Found multiple matches for calling context in context statement {}.",
                        context);
                    droidsafe.main.Main.exit(1);
                }
                invokeExpr = ie;
            }
        }

        if (invokeExpr == null) {
            logger.error("Cannot find context invoke expr in context: {}.", context);
            droidsafe.main.Main.exit(1);
        }


        //do some checks for things we might not fully understand yet.
        if (invokeExpr instanceof DynamicInvokeExpr) {
            logger.error("Do not understand type of invoke expr: {}", invokeExpr.getClass());
            droidsafe.main.Main.exit(1);
        }
    }

    /**
     * Return the invoke expression associated with this output event.
     */
    public InvokeExpr getInvokeExpr() {
        return invokeExpr;
    }

    /** 
     * Return the number of args in the invoke expression.
     */
    public int getNumArgs() {
        return invokeExpr.getArgCount();
    }

    /**
     * Return true if the method call has a receiver.
     * @return
     */
    public boolean hasReceiver() {
        return !receiverNodes.isEmpty(); 
    }


    /**
     * Return the value of the receiver, probably a field or local variable.
     */
    public Value getReceiver() {
        if (!hasReceiver()) {
            logger.error("Trying to get receiver for output event without one: {}.", this.toString());
            droidsafe.main.Main.exit(1);
        }

        return ((InstanceInvokeExpr)invokeExpr).getBase();
    }


    /**
     * Return the points to set of the receiver (if it exists) in the context of this
     * output event.
     */
    public Set<IAllocNode> getReceiverPTSet() {
        getReceiver();

        return receiverNodes; 
    }

    /**
     * Return true if the receiver is a pointer.
     */
    public boolean isReceiverPointer() {
        return PTABridge.v().isPointer(getReceiver());
    }

    /**
     * Return the type of the receiver value.
     */
    public Type getReceiverType() {
        return getReceiver().getType();
    }

    /**
     * Return the type of the value for the argument, does not look 
     * at the points to set.
     */
    public Type getArgumentType(int i) {
        return getArgValue(i).getType();
    }

    /**
     * Return the points to set for the pointer argument at index i.
     */
    public Set<? extends IAllocNode> getArgPTSet(int i) {
        Value v = getArgValue(i);

        return PTABridge.v().getPTSet(v, invokeEdge.srcCtxt() );
    }

    /**
     * Return a set of all the alloc nodes that all the of the args can point to.
     */
    public Set<IAllocNode> getAllArgsPTSet() {
        HashSet<IAllocNode> nodes = new HashSet<IAllocNode>();

        for (int i = 0; i < getNumArgs(); i++) {
            if (isArgPointer(i))
                nodes.addAll(getArgPTSet(i));
        }

        return nodes;
    }

    /**
     * Return the context
     */
    public Edge getEdge() {
        return invokeEdge;
    }

    /**
     * Get the target soot method of this output event.
     * @return
     */
    public SootMethod getTarget() {
        return invokeEdge.tgt();
    }

    /**
     * Return the argument expression for the call to the API method.
     */
    public Value getArgValue(int i) {
        if (i > getNumArgs()) { 
            logger.error("Trying to invalid argument {} for output event {}.", i, getTarget());
            droidsafe.main.Main.exit(1);
        }

        return invokeExpr.getArg(i);
    }

    /**
     * Return true if arg i value is a pointer in the PT graph.
     */
    public boolean isArgPointer(int i) {
        return PTABridge.v().isPointer(getArgValue(i));
    }

    /**
     * Return the enclosing RCFGNode.
     */
    public RCFGNode getParent() {
        return parent;
    }

    /** 
     * Get the source location tag for this output event.
     */
    public SourceLocationTag getSourceLocationTag() {
        return linesTag;
    }

    /**
     * Return a string representation of the OutputEvent.
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        Formatter formatter = new Formatter(str, Locale.US);
        str.append(getTarget() + "\n");

        if (hasReceiver()) {
            formatter.format("\tReceiver: %s (%s)\n", getReceiver(), getReceiver().getClass());
            str.append("\t\tPT Set:\n");

            for (IAllocNode receiverNode : receiverNodes)
                formatter.format("\t\tNode: %s (%s)\n", receiverNode, receiverNode.getClass());

            for (int i = 0; i < getNumArgs(); i++) {
                if (isArgPointer(i)) {
                    Set<? extends IAllocNode> nodes = getArgPTSet(i);
                    formatter.format("\tArg %d (size %d)\n", i, nodes.size());
                    for (IAllocNode node : nodes) {
                        formatter.format("\t\tNode: %s (%s), New expr: %s (%s)\n", 
                            node, node.getClass(), node.getNewExpr(), 
                            node.getNewExpr().getClass());

                    }
                } else {
                    formatter.format("\tArg %d: %s (%s)\n", i, getArgValue(i).getClass(), getArgValue(i));
                }
            }
        }
        formatter.close();
        return str.toString();
    }

}
