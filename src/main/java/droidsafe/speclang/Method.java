
package droidsafe.speclang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Context;
import soot.Local;
import soot.MethodContext;
import soot.MethodOrMethodContext;
import soot.PrimType;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Type;
import soot.Unit;
import soot.Value;
import soot.jimple.Constant;
import soot.jimple.Expr;
import soot.jimple.InvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.toolkits.callgraph.Edge;
import soot.jimple.toolkits.pta.IAllocNode;
import soot.tagkit.LineNumberTag;
import droidsafe.analyses.infoflow.InfoUnit;
import droidsafe.analyses.infoflow.InfoValue;
import droidsafe.analyses.infoflow.InformationFlowAnalysis;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.pta.PTAMethodInformation;
import droidsafe.android.system.API;
import droidsafe.android.system.InfoKind;
import droidsafe.android.system.Permissions;
import droidsafe.main.Config;
import droidsafe.utils.CannotFindMethodException;
import droidsafe.utils.JimpleRelationships;
import droidsafe.utils.SootUtils;
import droidsafe.utils.SourceLocationTag;

public class Method implements Comparable<Method> {
    private static final Logger logger = LoggerFactory.getLogger(Method.class);

    /** Concrete Soot Method */
    private SootMethod sootMethod;
    /** argument full qualified types */
    private ArgumentValue[] args;
    /** receiver (could be a type or an object reference) */
    private ArgumentValue receiverValues;
    /** locations where this method, either a call or a handler appear in source */
    private List<SourceLocationTag> lines;
    /** Points to information for this method call */
    private PTAMethodInformation ptaInfo;

    /** receiver raw info flow information, used to cache the info kinds so we do not query info flow more than once */
    private Map<InfoKind, Set<Stmt>> recFlows;
    /** argument info kinds set, used to cache the info kinds so we do not query info flow more than once */
    private Map<InfoKind, Set<Stmt>>[] argFlows;
    /** argument info kinds set, used to cache the info kinds so we do not query info flow more than once 
     * use memory access analysis*/
    private Map<InfoKind, Set<Stmt>>[] argFlowsPrecise;
    /** info flows of memory touched by this method and any methods called, cached here */
    private Map<InfoKind, Set<Stmt>> methodFlows;

    /** if the target method is synthetic, then we try to find the real target through the synthetic method
     *  if this is non-null, then this is the real target of this method in user code     */
    private SootMethod realTarget = null;

    public Method(SootMethod method, PTAMethodInformation ptaInfo, ArgumentValue[] args, ArgumentValue receiver) {
        this.sootMethod = method;
        this.args = args;
        this.receiverValues = receiver;
        lines = new ArrayList<SourceLocationTag>();
        logger.info("Creating method: {} with receiever {}", method, receiver);
        this.ptaInfo = ptaInfo;
        argFlows = new Map[ptaInfo.getNumArgs()];
        argFlowsPrecise = new Map[ptaInfo.getNumArgs()];
        cacheArgSourceInfoFlows();
        cacheRecInfoFlows();
    }

    public PTAMethodInformation getPTAInfo() {
        return ptaInfo;
    }
    
    /**
     * Call this method to check if the target method is a synthetic method in a user class, and if so,
     * find the real target through the synthetic method.  This is used to report correct line numbers
     * for synthetic methods in user code that are entry points.
     */
    public void checkForSynthetic() {
        if (!API.v().isSystemMethod(sootMethod) && SootUtils.isSynthetic(sootMethod)) {
            //specific set of tests to see if we can find a real user method that is called
            //and replace

            MethodOrMethodContext thisMomc = sootMethod;

            Context context = ptaInfo.getEdge().tgtCtxt();

            if (context != null)
                thisMomc = MethodContext.v(sootMethod, context);

            SootMethod newTarget = null;

            Iterator<Edge> edges  = Scene.v().getCallGraph().edgesOutOf(thisMomc);

            while (edges.hasNext()) {
                Edge edge = edges.next();
                SootMethod target = edge.tgt();                

                if (!edge.isExplicit())                    
                    continue;

                if (!target.getName().equals(sootMethod.getName()))
                    return;

                /* return type may change!
                if (!SootUtils.isSubTypeOfIncluding(target.getReturnType(), sootMethod.getReturnType()))
                    return;
                 */

                if (sootMethod.getParameterCount() != target.getParameterCount())
                    return;

                for (int i = 0; i < target.getParameterCount(); i++) {
                    if (!SootUtils.isSubTypeOfIncluding(target.getParameterType(i), sootMethod.getParameterType(i))) {
                        return;
                    }
                }

                //found potential match see if we have see it before
                //if not then two potential matches and we don't handle that!
                if (newTarget != null && !newTarget.equals(target))
                    return;

                newTarget = target;
            }

            //if we get here all tests pass!
            //replace the original method reference with the target of this sythetic method

            realTarget = newTarget;
        }
    }

    public InvokeExpr getInvokeExpr() {
        return ptaInfo.getInvokeExpr();
    }
    
    public SootMethod getSootMethod() {
        return sootMethod;
    }

    /**
     * check to see if these two method objects refer to the same method
     * even though they have different concrete param values, but only if they
     * have the same receiver (type or allocnode).
     * 
     * @param meth2 the method to check against
     * @return true if same underlying method that is called.
     */
    public boolean isSameMethod(Method meth2) {
        return (!meth2.getSootMethod().equals(sootMethod));
    }

    /**
     * Change the types of the arguments to agree with the underlying soot method
     */
    public void setTypes() {
        if (!(sootMethod.getSubSignature().equals(this.getSubSignature()))) {
            for (int i = 0; i < this.args.length; i++) {
                this.args[i].setType(sootMethod.getParameterType(i));
            }
        }
    }

    /**
     * Add a line number tag to this method remembering where it was called 
     * or defined. 
     */
    public void addLineTag(SourceLocationTag tag) {
        if (!lines.contains(tag))
            lines.add(tag);
    }

    /**
     * Return true if this method call enables the given method.  Meanings its restrictions
     * are a superset of the given method.  Right now this means that we check all the concrete 
     * values of the given method to see if they are enabled by this method.
     */
    public boolean isMethodCallEnabled(Method testMe) {
        if (!isSameMethod(testMe)) {
            //Messages.log(String.format("%s != %s\n", toSignatureString(), testMe.toSignatureString()));
            return false;
        }
        //loop through all the args of testme to see if they are enabled by this method
        for (int i = 0; i < testMe.args.length; i++) {
            //only check if the spec method (this) defined concrete values
            if (this.args[i].isConcreteList()) {
                if (!testMe.args[i].isConcreteList())
                    return false;

                if (!((ConcreteListArgumentValue)args[i]).doesEnable((ConcreteListArgumentValue)testMe.args[i]))
                    return false;
            }

        }

        return true;
    }

    /**
     * For all arguments of the method, add the method argument restrictions from meth2
     * into the method argument values of this method. 
     * 
     * @param meth2
     */
    public void incorporateMethod(Method meth2) {
        logger.info("Calling incorporate method on: {}", meth2);

        if (!isSameMethod(meth2)) {
            logger.error("Error: Trying to combine concrete value restrictions on different methods!");
            droidsafe.main.Main.exit(1);
        }


        for (int i = 0; i < args.length; i++) {
            args[i] = ArgumentValue.combine(args[i], meth2.args[i], getActualArgType(i)); 
        }

        //combine the line numbers the method to incorporate and resort them
        for (SourceLocationTag tag: meth2.lines){
            if (!this.lines.contains(tag))
                this.lines.add(tag);
        }

        Collections.sort(lines);
    }

    /**
     * Return a set of allocation nodes for possible new expression that can reach receiver of this method.
     */
    public Set<? extends IAllocNode> getReceiverAllocNodes() {
        if (ptaInfo == null || !ptaInfo.hasReceiver() || !PTABridge.v().isPointer(ptaInfo.getReceiver()))
            return new HashSet<IAllocNode>();

        return ptaInfo.getReceiverPTSet();
    }

    /**
     * Return the set of allocation nodes for new expression that could reach the argument i,  
     * assuming it is a pointer value.  Return empty set of any problems.
     */
    public Set<? extends IAllocNode> getArgAllocNodes(int i) {
        if (ptaInfo == null || !PTABridge.v().isPointer(ptaInfo.getArgValue(i)))
            return new HashSet<IAllocNode>();

        return ptaInfo.getArgPTSet(i);
    }

    public boolean hasReceiver() {
        return receiverValues != null && !receiverValues.equals("");			
    }

    /**
     * Return the method in Soot's Subsignature format.
     */
    public String getSubSignature() {
        return sootMethod.getSubSignature();
    }

    /**
     * Return the signature for the method in Soot format. 
     */
    public String getSignature() {
        return  sootMethod.getSignature();
    }

    /**
     * Return a string that conforms to the security specification language.
     */
    @Override
    public String toString() {
        return toString(false);
    }

    public String toString(boolean flagUnsupported) {
        StringBuilder ret = new StringBuilder();

        if (!lines.isEmpty() && !Config.v().noSourceInfo) {
            for (SourceLocationTag line : lines) {
                ret.append("// " + line + "\n");
            }
        }

        for (String str : Permissions.v().getPermissions(sootMethod)) 
            ret.append("// Requires permission: " + str + "\n");

        if (API.v().isIPCCallback(sootMethod)) {
            if (API.v().isRemoteIPCCallback(sootMethod))
                ret.append("// Possible remote IPC callback method\n");
            else 
                ret.append("// Possible IPC callback method\n");
        }
        
        

        if (!getSourcesInfoKinds().isEmpty()) {
            //print resolved high-level information flows
            Map<InfoKind, Set<Stmt>> recSourceKinds = getReceiverSourceInfoUnits();
            Set<InfoKind> sinkKinds = getSinkInfoKinds();
            Set<InfoKind> methodKinds = getMethodInfoKinds();

            ret.append("// InfoFlows: \n");

            if (hasReceiver()) {
                ret.append("//    receiver:\n");

                for (Map.Entry<InfoKind, Set<Stmt>> src : recSourceKinds.entrySet()) { 
                    if (!src.getKey().isSensitive())
                        continue;
                    ret.append("//\t    " + src.getKey() + ": \n");
                    for (Stmt stmt : src.getValue()) {
                        ret.append("//\t        " + stmt+"\n");
                    }
                }
            }

            ret.append("//    args:\n");
            for (int i = 0; i < ptaInfo.getNumArgs(); i++) {
                Map<InfoKind, Set<Stmt>> infoMap = getArgSourceInfoUnits(i);
                if (infoMap.isEmpty())
                    continue;
                ret.append("//\t    " + i + "\n");
                for (Map.Entry<InfoKind, Set<Stmt>> src : infoMap.entrySet()) {
                    if (!src.getKey().isSensitive())
                        continue;    
                    ret.append("//\t        " + src.getKey() + ": \n");
                    for (Stmt stmt : src.getValue()) {
                        ret.append("//\t            " + stmt+"\n");
                    }
                }
            }

            ret.append("//    (Method accesses:");
            for (InfoKind src : methodKinds) { 
                ret.append(" " + src);
            }

            ret.append(")\n//    (Category of Sink:");

            for (InfoKind sink : sinkKinds)
                ret.append(" " + sink);

            ret.append(")\n");
        }

        if (ptaInfo.hasReceiver()) {
            //loop over all alloc nodes of receiver, must be a reference to have a receiver!
            Set<SootClass> receiverClass = new HashSet<SootClass>();
            for (IAllocNode node : ptaInfo.getReceiverPTSet()) {
                if (node.getType() instanceof RefType) {
                    receiverClass.add(((RefType)node.getType()).getSootClass());
                }
            }


            ret.append("//Receiver types: ");
            for (SootClass clz : receiverClass) {
                ret.append(clz + " ");
            }
            ret.append("\n");
        }

        if (flagUnsupported && !API.v().isSupportedMethod(sootMethod))
            ret.append("**");

        return ret + toSignatureString();
    }

    /** Return the permissions this method requires **/
    public Set<String> getPermissions() {
        return Permissions.v().getPermissions(sootMethod);
    }

    /**
     * Returns the signature portion of the string in security spec format
     * with arg values and not arg types from the soot method
     */
    public String toSignatureString() {

        String ret = "";

        if (hasReceiver()) 
            ret += receiverValues;
        else 
            ret += getCname();

        ret += ": " + getRtype() + " " + this.getName() + "(";

        for (int i = 0; i < args.length; i++) {
            if (i > 0)
                ret += ", ";
            ret += args[i].toString();
        }

        return ret + ")";
    }

    /**
     * Returns the lines that contain calls to this method
     */
    public List<SourceLocationTag> getLines() {
        return lines;
    }

    public String toXML() {
        String ret = "<method name=\"" + getName() + "\" class=\"" + 
                getCname() + "\" rtype=\"" + getRtype() +  "\" receiver=\"" + receiverValues + "\">\n"; 

        for (ArgumentValue arg : args)
            ret += "<arg type = \"" + arg + "\"/>";

        ret += "</method>";

        return ret;
    }

    /**
     * Try to find the line number of the declaration of this method.
     * Must be using byte code and not dex file conversion.
     */
    public SourceLocationTag getDeclSourceLocation() {

        //check to see if this method is defined, if not, return null
        if (!Scene.v().containsMethod(getSignature()))
            return null;

        if (realTarget != null)
            return SootUtils.getMethodLocation(realTarget);
        else 
            return SootUtils.getMethodLocation(sootMethod);
    }

    /**
     * Check if the method is valid to appear in the body (block) of an event block.
     * Since an API callback can be overriden, we have to check the superclasses.
     * 
     * @return
     */
    public boolean checkValidSpecMethod() {
        return API.v().isSupportedMethod(sootMethod);
    }

    /**
     * If this method is defined as a sink method with a high level sink type, 
     * return the InfoKinds of this method.  Otherwise, return an empty list. 
     */
    public Set<InfoKind> getSinkInfoKinds() {
        if (API.v().hasSinkInfoKind(sootMethod)) {
            return API.v().getSinkInfoKinds(sootMethod);
        }
        return new HashSet<InfoKind>();
    }

    private void cacheRecInfoFlows() {
        //call the information flow results
        if (InformationFlowAnalysis.v() == null || !hasReceiver()) {
            recFlows = Collections.<InfoKind, Set<Stmt>>emptyMap();
            return;
        }

        recFlows = new HashMap<InfoKind, Set<Stmt>>();

        //loop over all alloc nodes of receiver, must be a reference to have a receiver!
        for (IAllocNode node : ptaInfo.getReceiverPTSet()) {
            //for each information flow result
            for (InfoValue iv : 
                InformationFlowAnalysis.v().getTaints(node, ptaInfo.getEdge().getTgt())) {

                //get high level taint
                for (InfoKind infoK : InfoKind.getSourceInfoKinds(iv)) {
                    //rememeber we have high-level taint
                    if (!recFlows.containsKey(infoK)) 
                        recFlows.put(infoK, new HashSet<Stmt>());
                    //add stmt if we have one
                    if (iv instanceof InfoUnit && ((InfoUnit)iv).getUnit() instanceof Stmt)
                        recFlows.get(infoK).add((Stmt)((InfoUnit)iv).getUnit());
                }

            }
        }
    }

    /**
     * For the receiver of this method, return the set of all api calls in user code that 
     * could reach the receiver (or one of its fields).
     */
    public Map<InfoKind, Set<Stmt>> getReceiverSourceInfoUnits() {
        return recFlows;
    }

    public int getNumArgs() {
        return ptaInfo.getNumArgs();
    }
    
    private void cacheArgSourceInfoFlows() {
        for (int i = 0; i < ptaInfo.getNumArgs(); i++) {
            argFlows[i] = new HashMap<InfoKind, Set<Stmt>>();
            argFlowsPrecise[i] = new HashMap<InfoKind, Set<Stmt>>();

            //no result
            if (InformationFlowAnalysis.v() == null)
                continue;

            Set<InfoValue> infoValues = new HashSet<InfoValue>();
            Set<InfoValue> infoValuesPrecise = new HashSet<InfoValue>();

            if (ptaInfo.isArgPointer(i)) {
                for (IAllocNode node : ptaInfo.getArgPTSet(i)) {
                    infoValuesPrecise.addAll(InformationFlowAnalysis.v().getTaints(node, ptaInfo.getEdge().getTgt()));
                    infoValues.addAll(InformationFlowAnalysis.v().getTaints(node));
                }
            } else if (ptaInfo.getArgValue(i) instanceof Local && 
                    ptaInfo.getArgValue(i).getType() instanceof PrimType){
                //System.out.println(ptaInfo.getEdge().getSrc());
                //System.out.println(JimpleRelationships.v().getEnclosingStmt(ptaInfo.getInvokeExpr()));                
                //System.out.println(ptaInfo.getArgValue(i) + "\n");
                infoValues = 
                        InformationFlowAnalysis.v().getTaints(ptaInfo.getEdge().getSrc(), (Local)ptaInfo.getArgValue(i));
                //for primitives, the precise and non-precise are the same since access analysis is not used
                infoValuesPrecise = infoValues; 
            } else if (ptaInfo.getArgValue(i) instanceof Constant) {
                //do nothing for constants
            } else {
                logger.error("Unknown value or type for argument when retreiveing infovalue: {} {} {}", 
                    ptaInfo.getEdge().getTgt(), ptaInfo.getArgValue(i), ptaInfo.getArgValue(i).getType());
            }

            //at this point we have info values set
            for (InfoValue iv : infoValues) {
                //get high level taint
                for (InfoKind infoK : InfoKind.getSourceInfoKinds(iv)) {
                    //rememeber we have high-level taint
                    if (!argFlows[i].containsKey(infoK)) 
                        argFlows[i].put(infoK, new HashSet<Stmt>());
                    //add stmt if we have one
                    if (iv instanceof InfoUnit && ((InfoUnit)iv).getUnit() instanceof Stmt)
                        argFlows[i].get(infoK).add((Stmt)((InfoUnit)iv).getUnit());
                }
            }
            
            //now record precise results using memory access analysis
            for (InfoValue iv : infoValuesPrecise) {
                //get high level taint
                for (InfoKind infoK : InfoKind.getSourceInfoKinds(iv)) {
                    //rememeber we have high-level taint
                    if (!argFlowsPrecise[i].containsKey(infoK)) 
                        argFlowsPrecise[i].put(infoK, new HashSet<Stmt>());
                    //add stmt if we have one
                    if (iv instanceof InfoUnit && ((InfoUnit)iv).getUnit() instanceof Stmt)
                        argFlowsPrecise[i].get(infoK).add((Stmt)((InfoUnit)iv).getUnit());
                }
            }
        }
    }

    /**
     * For argument at i return the set of all api calls in user code that could reach the 
     * argument (or one of its fields).  If Config.v().preciseInfoFlow is true, use memory
     * access analysis on the argument (if a reference). 
     */
    public Map<InfoKind, Set<Stmt>> getArgSourceInfoUnits(int i) {
        if (Config.v().preciseInfoFlow)
            return argFlowsPrecise[i];
        else
            return argFlows[i];
    }
    
    /**
     * For argument at i return the set of all api calls in user code that could reach the 
     * argument (or one of its fields).
     */
    public Map<InfoKind, Set<Stmt>> getArgSourceInfoUnitsConservative(int i) {
        return argFlows[i];
    }
    
    /**
     * For argument at i return the set of all api calls in user code that could reach the 
     * argument (or one of its fields), use memory access analysis
     */
    public Map<InfoKind, Set<Stmt>> getArgSourceInfoUnitsPrecise(int i) {
        return argFlowsPrecise[i];
    }
    
    /**
     * Return map of high level flow to stmt for flows that result from memory accessed reachable code of the 
     * method.
     */
    public Map<InfoKind, Set<Stmt>> getMethodInfoUnits() {
        return methodFlows;
    }

    /**
     * For argument at i, return set of high level information kinds that the argument is possible tainted with
     * If the config option "preciseinfoflow" is true, memory access analysis will be employed.
     * 
     */
    public Set<InfoKind> getArgInfoKinds(int i) {
        if (Config.v().preciseInfoFlow) {
            return getArgInfoKindsPrecise(i);
        } else {
            return getArgInfoKindsConservative(i);
        }
    }

    /**
     * For argument at i, return the set of high level information kinds that the argument could possibly 
     * be tainted with.  Conservatively report on all taints reachable from memory of argument (does not
     * use memory access analysis).
     */
    public Set<InfoKind> getArgInfoKindsConservative(int i) {
        if (InformationFlowAnalysis.v() == null)
            return Collections.emptySet(); 
        //info flow result is cached
        Set<InfoKind> highLevelKinds = new HashSet<InfoKind>();

        for (InfoKind kind : argFlows[i].keySet()) {
            if (kind.isSensitive()) 
                highLevelKinds.add(kind);
        }

        return highLevelKinds;
    }

    /**
     * For argument at i, return the set of high level information kinds that the argument could possibly 
     * be tainted with.  Use memory access analysis.
     */
    public Set<InfoKind> getArgInfoKindsPrecise(int i) {
        if (InformationFlowAnalysis.v() == null)
            return Collections.emptySet(); 
        //info flow result is cached
        Set<InfoKind> highLevelKinds = new HashSet<InfoKind>();

        for (InfoKind kind : argFlowsPrecise[i].keySet()) {
            if (kind.isSensitive()) 
                highLevelKinds.add(kind);
        }

        return highLevelKinds;
    }
    
    /**
     * For receiver, return the set of high-level information kinds that the receiver could possibly be 
     * tainted with.	 
     */
    public Set<InfoKind> getRecInfoKinds() {
        if (InformationFlowAnalysis.v() == null || !hasReceiver()) 
            return Collections.emptySet(); 

        //info flow result is cached
        Set<InfoKind> highLevelKinds = new HashSet<InfoKind>();

        for (InfoKind kind : recFlows.keySet()) {
            if (kind.isSensitive()) 
                highLevelKinds.add(kind);
        }

        return highLevelKinds;
    }

    /**
     * Return high level info kinds for all memory that this method touches.  Does not include all taint 
     * on receiver or arguments (but could include accesses of receiver or arguments).
     */
    public Set<InfoKind> getMethodInfoKinds() {
        methodFlows = new LinkedHashMap<InfoKind, Set<Stmt>>();
        
        if (InformationFlowAnalysis.v() == null || Config.v().reportOnlyArgFlows)
            return Collections.<InfoKind>emptySet();

        Set<InfoKind> methodKinds = new HashSet<InfoKind>();
        for (InfoValue iv : InformationFlowAnalysis.v().getTaints(ptaInfo.getEdge().getTgt())) {
            for (InfoKind kind : InfoKind.getSourceInfoKinds(iv)) {
                if (kind.isSensitive()) {
                    if (!methodFlows.containsKey(kind))
                        methodFlows.put(kind, new LinkedHashSet<Stmt>());
                    
                    if (iv instanceof InfoUnit && ((InfoUnit)iv).getUnit() instanceof Stmt)
                        methodFlows.get(kind).add((Stmt)((InfoUnit)iv).getUnit());
                    
                    methodKinds.add(kind);
                }
            }
        }

        return methodKinds;
    }

    /**
     *  Return the high level InfoKinds for all possible access of the target method.
     */
    public Set<InfoKind> getSourcesInfoKinds() {
        if (InformationFlowAnalysis.v() == null)
            return Collections.<InfoKind>emptySet();

        Set<InfoKind> kinds = new HashSet<InfoKind>();

        kinds.addAll(getRecInfoKinds());
        kinds.addAll(getMethodInfoKinds());

        for (int i = 0; i < sootMethod.getParameterCount(); i++) 
            kinds.addAll(getArgInfoKinds(i));

        return kinds;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(args);
        result = prime * result + ((lines == null) ? 0 : lines.hashCode());
        result = prime * result + ((ptaInfo == null) ? 0 : ptaInfo.hashCode());
        result = prime * result + ((receiverValues == null) ? 0 : receiverValues.hashCode());
        result = prime * result + ((sootMethod == null) ? 0 : sootMethod.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Method other = (Method) obj;
        if (!Arrays.equals(args, other.args)) return false;
        if (lines == null) {
            if (other.lines != null) return false;
        } else if (!lines.equals(other.lines)) return false;
        if (ptaInfo == null) {
            if (other.ptaInfo != null) return false;
        } else if (!ptaInfo.equals(other.ptaInfo)) return false;
        if (receiverValues == null) {
            if (other.receiverValues != null) return false;
        } else if (!receiverValues.equals(other.receiverValues)) return false;
        if (sootMethod == null) {
            if (other.sootMethod != null) return false;
        } else if (!sootMethod.equals(other.sootMethod)) return false;
        return true;
    }


    public void setReceiverValues(ArgumentValue rec) {
        this.receiverValues = rec;
    }

    public String getCname() {
        return sootMethod.getDeclaringClass().getName();
    }

    public String getName() {
        return sootMethod.getName();
    }

    public ArgumentValue[] getArgs() {
        return args;
    }

    public ArgumentValue getReceiverValues() {
        return receiverValues;
    }

    public String getRtype() {
        return sootMethod.getReturnType().toString();
    }

    public void setArg(int i, ArgumentValue v) {
        args[i] = v;
    }

    public Type getActualArgType(int i) {
        return sootMethod.getParameterType(i);
    }

    /**
     * Return a string of all the information of this method object: line numbers, receiver and signature.
     */
    public String toCompleteString() {
        String ret = "";

        if (!lines.isEmpty() && !Config.v().noSourceInfo) {
            for (SourceLocationTag line : lines) {
                ret += "// " + line + "\n";
            }
        }

        ret += toSignatureString();

        return ret;
    }

    /** 
     * Compare method m to this method.  Right now it puts them in order based on line
     * number annotation, but if that is not present, it does a lexigraphical order of 
     * the receiver and method name.
     */
    @Override
    public int compareTo (Method m) {
        return this.toCompleteString().compareTo(m.toCompleteString());
    }
}
