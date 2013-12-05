package droidsafe.analyses.infoflow;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.ImmutableList;

import soot.MethodOrMethodContext;
import soot.Scene;
import soot.SootMethod;
import soot.jimple.toolkits.callgraph.TransitiveTargets;
import soot.toolkits.graph.Block;

public class MemoryReadAnalysis {
    private static MemoryReadAnalysis v;

    public static void run() {
        v = new MemoryReadAnalysis(InterproceduralControlFlowGraph.v());
    }

    static MemoryReadAnalysis v() {
        return v;
    }

    private InterproceduralControlFlowGraph controlFlowGraph;

    private Map<SootMethod, ImmutableList<AddressField>> methodToAddressFieldsRecursively = new HashMap<SootMethod, ImmutableList<AddressField>>();
    private Map<SootMethod, ImmutableList<Address>> methodToAddressesRecursively = new HashMap<SootMethod, ImmutableList<Address>>();

    private Map<SootMethod, Set<AddressField>> methodToAddressFields = new DefaultHashMap<SootMethod, Set<AddressField>>(Collections.<AddressField>emptySet());
    private Map<SootMethod, Set<Address>> methodToAddresses = new DefaultHashMap<SootMethod, Set<Address>>(Collections.<Address>emptySet());

    private MemoryReadAnalysis(InterproceduralControlFlowGraph controlFlowGraph) {
        this.controlFlowGraph = controlFlowGraph;
        doAnalysis();
    }

    private void doAnalysis() {
        for (Map.Entry<SootMethod, List<Block>> methodBlocks : controlFlowGraph.methodToBlocks.entrySet()) {
            SootMethod method = methodBlocks.getKey();
            List<Block> blocks = methodBlocks.getValue();
            methodToAddressFields.put(method, AddressField.read(blocks));
            methodToAddresses.put(method, Address.arraysRead(blocks));
        }
    }

    TransitiveTargets transitiveTargets = null;

    ImmutableList<AddressField> addressFieldsReadRecursively(SootMethod method) {
        if (methodToAddressFieldsRecursively.containsKey(method)) {
            return methodToAddressFieldsRecursively.get(method);
        }

        HashSet<AddressField> addressFields = new HashSet<AddressField>(methodToAddressFields.get(method));
        if (transitiveTargets == null) {
            transitiveTargets = new TransitiveTargets(Scene.v().getCallGraph());
        }
        Iterator<MethodOrMethodContext> tgtMethods = transitiveTargets.iterator(method);
        while (tgtMethods.hasNext()) {
            SootMethod tgtMethod = (SootMethod)tgtMethods.next();
            addressFields.addAll(methodToAddressFields.get(tgtMethod));
        }
        ImmutableList<AddressField> addrFlds = ImmutableList.copyOf(addressFields);
        methodToAddressFieldsRecursively.put(method, addrFlds);
        return addrFlds;
    }

    ImmutableList<Address> arraysReadRecursively(SootMethod method) {
        if (methodToAddressesRecursively.containsKey(method)) {
            return methodToAddressesRecursively.get(method);
        }

        HashSet<Address> addresses = new HashSet<Address>(methodToAddresses.get(method));
        if (transitiveTargets == null) {
            transitiveTargets = new TransitiveTargets(Scene.v().getCallGraph());
        }
        Iterator<MethodOrMethodContext> tgtMethods = transitiveTargets.iterator(method);
        while (tgtMethods.hasNext()) {
            SootMethod tgtMethod = (SootMethod)tgtMethods.next();
            addresses.addAll(methodToAddresses.get(tgtMethod));
        }
        ImmutableList<Address> addrs = ImmutableList.copyOf(addresses);
        methodToAddressesRecursively.put(method, addrs);
        return addrs;
    }
}
