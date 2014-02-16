package droidsafe.analyses.infoflow;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.tuple.ImmutablePair;

import com.google.common.collect.ImmutableSet;

import soot.Context;
import soot.Immediate;
import soot.Local;
import soot.MethodOrMethodContext;
import soot.RefLikeType;
import soot.Scene;
import soot.SootField;
import soot.SootMethod;
import soot.Unit;
import soot.Value;
import soot.jimple.ArrayRef;
import soot.jimple.AssignStmt;
import soot.jimple.Constant;
import soot.jimple.DynamicInvokeExpr;
import soot.jimple.InstanceFieldRef;
import soot.jimple.InterfaceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.SpecialInvokeExpr;
import soot.jimple.StaticInvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.VirtualInvokeExpr;
import soot.jimple.toolkits.callgraph.Targets;
import soot.jimple.toolkits.pta.IAllocNode;
import soot.toolkits.graph.Block;
import droidsafe.analyses.pta.PTABridge;
import droidsafe.main.Config;

class ContextLocal implements Comparable<ContextLocal> {
    private static final HashMap<ImmutablePair<Context, Local>, ContextLocal> cache = new HashMap<ImmutablePair<Context, Local>, ContextLocal>();

    Context context;
    Local local;

    private ContextLocal(Context context, Local local) {
        if (Config.v().strict) {
            assert context != null && local != null;
        }
        this.context = context;
        this.local = local;
    }

    static ContextLocal v(Context context, Local local) {
        ImmutablePair<Context, Local> key = ImmutablePair.of(context, local);
        ContextLocal value = cache.get(key);
        if (value == null) {
            value = new ContextLocal(context, local);
            cache.put(key, value);
        }
        return value;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ContextLocal)) {
            return false;
        }
        ContextLocal that = (ContextLocal)object;

        return this.context.equals(that.context) && this.local.equals(that.local);
    }

    @Override
    public int hashCode() {
        return 31 * (31 * 17 + context.hashCode()) + local.hashCode();
    }

    @Override
    public String toString() {
        return "(" + context + ", " + local + ")";
    }

    @Override
    public int compareTo(ContextLocal that) {
        int context = this.context.toString().compareTo(that.context.toString());
        if (context != 0) {
            return context;
        } else {
            return this.local.toString().compareTo(that.local.toString());
        }
    }
}

class Locals {
    static final Locals EMPTY = new Locals();

    private DefaultHashMap<ContextLocal, ImmutableSet<InfoValue>> contextLocalToValues;

    Locals() {
        contextLocalToValues = new DefaultHashMap<ContextLocal, ImmutableSet<InfoValue>>(ImmutableSet.<InfoValue>of());
    }

    Locals(Locals that) {
        this.contextLocalToValues = new DefaultHashMap<ContextLocal, ImmutableSet<InfoValue>>(that.contextLocalToValues);
    }

    ImmutableSet<InfoValue> putS(Context context, Local local, HashSet<InfoValue> values) {
        return putS(context, local, ImmutableSet.<InfoValue>copyOf(values));
    }

    ImmutableSet<InfoValue> putS(Context context, Local local, ImmutableSet<InfoValue> values) {
        if (values != null && !values.isEmpty()) {
            return contextLocalToValues.put(ContextLocal.v(context, local), values);
        } else {
            return contextLocalToValues.remove(ContextLocal.v(context, local));
        }
    }

    ImmutableSet<InfoValue> putW(Context context, Local local, ImmutableSet<InfoValue> values) {
        ContextLocal contextLocal = ContextLocal.v(context, local);
        ImmutableSet<InfoValue> oldValues = contextLocalToValues.get(contextLocal);
        if (values != null && !values.isEmpty()) {
            HashSet<InfoValue> newValues = new HashSet<InfoValue>(oldValues);
            newValues.addAll(values);
            return contextLocalToValues.put(contextLocal, ImmutableSet.<InfoValue>copyOf(newValues));
        } else {
            return oldValues;
        }
    }

    private ImmutableSet<InfoValue> remove(ContextLocal contextLocal) {
        return contextLocalToValues.remove(contextLocal);
    }

    ImmutableSet<InfoValue> remove(Context context, Local local) {
        return remove(ContextLocal.v(context, local));
    }

    private ImmutableSet<InfoValue> get(ContextLocal contextLocal) {
        return contextLocalToValues.get(contextLocal);
    }

    ImmutableSet<InfoValue> get(Context context, Local local) {
        return get(ContextLocal.v(context, local));
    }

    Locals merge(Locals that) {
        Locals locals = new Locals();
        for (Map.Entry<ContextLocal, ImmutableSet<InfoValue>> contextLocalValues : this.contextLocalToValues.entrySet()) {
            ContextLocal contextLocal = contextLocalValues.getKey();
            ImmutableSet<InfoValue> values = contextLocalValues.getValue();
            if (that.contextLocalToValues.containsKey(contextLocal)) {
                HashSet<InfoValue> mergedValues = new HashSet<InfoValue>(values);
                mergedValues.addAll(that.contextLocalToValues.get(contextLocal));
                locals.contextLocalToValues.put(contextLocal, ImmutableSet.copyOf(mergedValues));
            } else {
                locals.contextLocalToValues.put(contextLocal, values);
            }
        }
        for (Map.Entry<ContextLocal, ImmutableSet<InfoValue>> contextLocalValues : that.contextLocalToValues.entrySet()) {
            ContextLocal contextLocal = contextLocalValues.getKey();
            if (!this.contextLocalToValues.containsKey(contextLocal)) {
                locals.contextLocalToValues.put(contextLocal, contextLocalValues.getValue());
            }
        }
        return locals;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Locals)) {
            return false;
        }
        Locals that = (Locals)object;

        if (this.contextLocalToValues.size() != that.contextLocalToValues.size()) {
            return false;
        }
        try {
            for (Map.Entry<ContextLocal, ImmutableSet<InfoValue>> localValues : this.contextLocalToValues.entrySet()) {
                if (!(localValues.getValue().equals(that.contextLocalToValues.get(localValues.getKey())))) {
                    return false;
                }
            }
        } catch (ClassCastException unused) {
            return false;
        } catch (NullPointerException unused) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return contextLocalToValues.toString();
    }
}

class AddressField implements Comparable<AddressField> {
    private static final HashMap<ImmutablePair<Address, SootField>, AddressField> cache = new HashMap<ImmutablePair<Address, SootField>, AddressField>();

    Address address;
    SootField field;

    private AddressField(Address address, SootField field) {
        if (Config.v().strict) {
            assert address != null && field != null;
        }
        this.address = address;
        this.field = field;
    }

    static AddressField v(Address address, SootField field) {
        ImmutablePair<Address, SootField> key = ImmutablePair.of(address, field);
        AddressField addressField = cache.get(key);
        if (addressField == null) {
            addressField = new AddressField(address, field);
            cache.put(key, addressField);
        }
        return addressField;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof AddressField)) {
            return false;
        }
        AddressField that = (AddressField)object;

        return this.address.equals(that.address) && this.field.equals(that.field);
    }

    @Override
    public int hashCode() {
        return 31 * (31 * 7 + address.hashCode()) + field.hashCode();
    }

    @Override
    public String toString() {
        return "(" + address + ", " + field.getSignature() + ")";
    }

    @Override
    public int compareTo(AddressField that) {
        int address = this.address.compareTo(that.address);
        if (address != 0) {
            return address;
        } else {
            return this.field.getSignature().compareTo(that.field.getSignature());
        }
    }

    static Set<AddressField> read(List<Block> blocks) {
        Set<AddressField> addressFields = new HashSet<AddressField>();
        for (Block block : blocks) {
            Iterator<Unit> units = block.iterator();
            while (units.hasNext()) {
                Unit unit = units.next();
                Set<AddressField> addrFlds = null;
                if (unit instanceof AssignStmt) {
                    addrFlds = read((AssignStmt)unit);
                }
                if (addrFlds != null) {
                    addressFields.addAll(addrFlds);
                }
            }
        }
        return addressFields;
    }

    static Set<AddressField> read(AssignStmt stmt) {
        Set<AddressField> addressFields = null;
        Value rValue = stmt.getRightOp();
        if (rValue instanceof InstanceFieldRef) {
            addressFields = read(stmt, (InstanceFieldRef)rValue);
        } else if (rValue instanceof InvokeExpr) {
            addressFields = read(stmt, (InvokeExpr)rValue);
        }
        return addressFields;
    }

    static Set<AddressField> read(AssignStmt stmt, InstanceFieldRef instanceFieldRef) {
        Set<AddressField> addressFields = null;
        SootField field = instanceFieldRef.getField();
        if (!(field.getType() instanceof RefLikeType)) {
            addressFields = new HashSet<AddressField>();
            Value base = instanceFieldRef.getBase();
            for (IAllocNode allocNode : PTABridge.v().getPTSet(base)) {
                addressFields.add(AddressField.v(Address.v(allocNode), field));
            }
        }
        return addressFields;
    }

    static Set<AddressField> read(AssignStmt stmt, InvokeExpr invokeExpr) {
        Set<AddressField> addressFields = null;
        boolean isGetTaint = false;
        Iterator<MethodOrMethodContext> targets = new Targets(Scene.v().getCallGraph().edgesOutOf(stmt));
        while (targets.hasNext()) {
            SootMethod method = (SootMethod)targets.next();
            if (ObjectUtils.v().isGetTaint(method)) {
                isGetTaint = true;
                break;
            }
        }
        if (isGetTaint) {
            addressFields = new HashSet<AddressField>();
            for (InfoValue value : receiver(stmt, invokeExpr)) {
                addressFields.add(AddressField.v((Address)value, ObjectUtils.v().taint));
            }
        }
        return addressFields;
    }

    private static Set<InfoValue> receiver(final Stmt stmt, final InvokeExpr invokeExpr) {
        MyAbstractInvokeExprSwitch invokeExprSwitch = new MyAbstractInvokeExprSwitch() {
            @Override
            public void caseInterfaceInvokeExpr(InterfaceInvokeExpr interfaceInvokeExpr) {
                // interface_invoke_expr = "interfaceinvoke" immediate ".[" + method_signature "]" "(" immediate_list ")"
                Immediate immediate = (Immediate)interfaceInvokeExpr.getBase();
                setResult(evaluate(stmt, immediate));
            }

            @Override
            public void caseSpecialInvokeExpr(SpecialInvokeExpr specialInvokeExpr) {
                // special_invoke_expr = "specialinvoke" immediate ".[" method_signature "]" "(" immediate_list ")";
                Immediate immediate = (Immediate)specialInvokeExpr.getBase();
                setResult(evaluate(stmt, immediate));
            }

            @Override
            public void caseStaticInvokeExpr(StaticInvokeExpr staticInvokeExpr) {
                // static_invoke_expr = "staticinvoke" "[" method_signature "]" "(" immediate_list ")";
                setResult(Collections.<InfoValue>emptySet());

            }

            @Override
            public void caseVirtualInvokeExpr(VirtualInvokeExpr virtualInvokeExpr) {
                // virtual_invoke_expr = "virtualinvoke" immediate ".[" method_signamter "]" "(" immediate_list ")";
                Immediate immediate = (Immediate)virtualInvokeExpr.getBase();
                setResult(evaluate(stmt, immediate));
            }

            @Override
            public void caseDynamicInvokeExpr(DynamicInvokeExpr dynamicInvokeExpr) {
                throw new UnsupportedOperationException(stmt.toString());
            }
        };
        invokeExpr.apply(invokeExprSwitch);
        return (Set<InfoValue>)invokeExprSwitch.getResult();
    }

    static private Set<InfoValue> evaluate(final Stmt stmt, Immediate immediate) {
        // immediate = constant | local;
        MyAbstractImmediateSwitch immediateSwitch = new MyAbstractImmediateSwitch() {
            // immediate = constant | ...;
            // constant = double_constant | float_constant | int_constant | long_constant | string_constant | null_constant | class_constant;
            @Override
            public void caseConstant(Constant constant) {
                setResult(Collections.<InfoValue>emptySet());
            }

            // immediate = ... | local;
            @Override
            public void caseLocal(Local local) {
                HashSet<InfoValue> values = new HashSet<InfoValue>();
                for (IAllocNode allocNode : PTABridge.v().getPTSet(local)) {
                    values.add(Address.v(allocNode));
                }
                setResult(values);
            }
        };
        immediate.apply(immediateSwitch);
        return (Set<InfoValue>)immediateSwitch.getResult();
    }
}

class AddressFieldToValues {
    static final AddressFieldToValues EMPTY = new AddressFieldToValues();

    private DefaultHashMap<AddressField, ImmutableSet<InfoValue>> addressFieldToValues;

    AddressFieldToValues() {
        addressFieldToValues = new DefaultHashMap<AddressField, ImmutableSet<InfoValue>>(ImmutableSet.<InfoValue>of());
    }

    AddressFieldToValues(AddressFieldToValues that) {
        addressFieldToValues = new DefaultHashMap<AddressField, ImmutableSet<InfoValue>>(that.addressFieldToValues);
    }

    ImmutableSet<InfoValue> putS(AddressField addressField, ImmutableSet<InfoValue> values) {
        return addressFieldToValues.put(addressField, values);
    }

    void putSAll(AddressFieldToValues that) {
        for (Map.Entry<AddressField, ImmutableSet<InfoValue>> addressFieldValues : that.entrySet()) {
            AddressField addressField = addressFieldValues.getKey();
            ImmutableSet<InfoValue> values = addressFieldValues.getValue();
            putS(addressField, values);
        }
    }

    ImmutableSet<InfoValue> putW(AddressField addressField, ImmutableSet<InfoValue> values) {
        ImmutableSet<InfoValue> oldValues = addressFieldToValues.get(addressField);
        if (values != null && !values.isEmpty()) {
            HashSet<InfoValue> newValues = new HashSet<InfoValue>(oldValues);
            newValues.addAll(values);
            return addressFieldToValues.put(addressField, ImmutableSet.<InfoValue>copyOf(newValues));
        } else {
            return oldValues;
        }
    }

    ImmutableSet<InfoValue> putW(Address address, SootField field, ImmutableSet<InfoValue> values) {
        return putW(AddressField.v(address, field), values);
    }

    void putWAll(AddressFieldToValues that) {
        for (Map.Entry<AddressField, ImmutableSet<InfoValue>> addressFieldValues : that.entrySet()) {
            AddressField addressField = addressFieldValues.getKey();
            ImmutableSet<InfoValue> values = addressFieldValues.getValue();
            putW(addressField, values);
        }
    }

    ImmutableSet<InfoValue> get(AddressField addressField) {
        return addressFieldToValues.get(addressField);
    }

    ImmutableSet<InfoValue> get(Address address, SootField field) {
        return get(AddressField.v(address, field));
    }

    AddressFieldToValues merge(AddressFieldToValues that) {
        AddressFieldToValues addressFieldToValues = new AddressFieldToValues();
        for (Map.Entry<AddressField, ImmutableSet<InfoValue>> addressFieldValues : this.addressFieldToValues.entrySet()) {
            AddressField addressField = addressFieldValues.getKey();
            ImmutableSet<InfoValue> values = addressFieldValues.getValue();
            if (that.addressFieldToValues.containsKey(addressField)) {
                Set<InfoValue> mergedValues = new HashSet<InfoValue>(values);
                mergedValues.addAll(that.addressFieldToValues.get(addressField));
                addressFieldToValues.addressFieldToValues.put(addressField, ImmutableSet.copyOf(mergedValues));
            } else {
                addressFieldToValues.addressFieldToValues.put(addressField, values);
            }
        }
        for (Map.Entry<AddressField, ImmutableSet<InfoValue>> addressFieldValues : that.addressFieldToValues.entrySet()) {
            AddressField addressField = addressFieldValues.getKey();
            if (!this.addressFieldToValues.containsKey(addressField)) {
                addressFieldToValues.addressFieldToValues.put(addressField, addressFieldValues.getValue());
            }
        }
        return addressFieldToValues;
    }

    Set<Map.Entry<AddressField, ImmutableSet<InfoValue>>> entrySet() {
        return addressFieldToValues.entrySet();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof AddressFieldToValues)) {
            return false;
        }
        AddressFieldToValues that = (AddressFieldToValues)object;

        if (this.addressFieldToValues.size() != that.addressFieldToValues.size()) {
            return false;
        }
        try {
            for (Map.Entry<AddressField, ImmutableSet<InfoValue>> addressFieldValues : this.addressFieldToValues.entrySet()) {
                if (!(addressFieldValues.getValue().equals(that.addressFieldToValues.get(addressFieldValues.getKey())))) {
                    return false;
                }
            }
        } catch (ClassCastException unused) {
            return false;
        } catch (NullPointerException unused) {
            return false;
        }

        return true;
    }
}

class Instances {
    private DefaultHashMap<Context, AddressFieldToValues> contextToAddressFieldToValues;

    Instances() {
        contextToAddressFieldToValues = new DefaultHashMap<Context, AddressFieldToValues>(AddressFieldToValues.EMPTY);
    }

    Instances(Instances that) {
        this.contextToAddressFieldToValues = new DefaultHashMap<Context, AddressFieldToValues>(AddressFieldToValues.EMPTY);
        for (Map.Entry<Context, AddressFieldToValues> contextAddressFieldToValues : that.contextToAddressFieldToValues.entrySet()) {
            Context context = contextAddressFieldToValues.getKey();
            AddressFieldToValues addressFieldToValues = contextAddressFieldToValues.getValue();
            this.contextToAddressFieldToValues.put(context, new AddressFieldToValues(addressFieldToValues));
        }
    }

    ImmutableSet<InfoValue> putS(Context context, AddressField addressField, ImmutableSet<InfoValue> values) {
        return contextToAddressFieldToValues.get(context).putS(addressField, values);
    }

    void putSAll(Context context, AddressFieldToValues addressFieldToValues) {
        contextToAddressFieldToValues.get(context).putSAll(addressFieldToValues);
    }

    ImmutableSet<InfoValue> putW(Context context, AddressField addressField, ImmutableSet<InfoValue> values) {
        return contextToAddressFieldToValues.get(context).putW(addressField, values);
    }

    ImmutableSet<InfoValue> putW(Context context, Address address, SootField field, ImmutableSet<InfoValue> values) {
        return contextToAddressFieldToValues.get(context).putW(address, field, values);
    }

    void putWAll(Context context, AddressFieldToValues addressFieldToValues) {
        contextToAddressFieldToValues.get(context).putWAll(addressFieldToValues);
    }

    ImmutableSet<InfoValue> get(Context context, Address address, SootField field) {
        return contextToAddressFieldToValues.get(context).get(address, field);
    }

    AddressFieldToValues get(Context context) {
        return contextToAddressFieldToValues.get(context);
    }

    private HashMap<ContextAddress, FieldToValues> contextAddressToFieldToValues;

    // XXX: put*() must not be called after calling get(Edge, Address). Otherwise, subsequent get(Edge, Address)'s return value may be invalid.
    FieldToValues get(Context context, Address address) {
        if (contextAddressToFieldToValues == null) {
            contextAddressToFieldToValues = new HashMap<ContextAddress, FieldToValues>();
        }

        ContextAddress contextAddress = ContextAddress.v(context, address);

        if (contextAddressToFieldToValues.containsKey(contextAddress)) {
            return contextAddressToFieldToValues.get(contextAddress);
        }

        FieldToValues fieldToValues = new FieldToValues();
        for (Map.Entry<AddressField, ImmutableSet<InfoValue>> addressFieldValues : contextToAddressFieldToValues.get(context).entrySet()) {
            AddressField addressField = addressFieldValues.getKey();
            ImmutableSet<InfoValue> values = addressFieldValues.getValue();
            if (addressField.address.equals(address)) {
                fieldToValues.putS(addressField.field, values);
            }
        }
        contextAddressToFieldToValues.put(contextAddress, fieldToValues);
        return fieldToValues;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Instances)) {
            return false;
        }
        Instances that = (Instances)object;

        if (this.contextToAddressFieldToValues.size() != that.contextToAddressFieldToValues.size()) {
            return false;
        }
        try {
            for (Map.Entry<Context, AddressFieldToValues> contextAddressFieldToValues : this.contextToAddressFieldToValues.entrySet()) {
                if (!(contextAddressFieldToValues.getValue().equals(that.contextToAddressFieldToValues.get(contextAddressFieldToValues.getKey())))) {
                    return false;
                }
            }
        } catch (ClassCastException unused) {
            return false;
        } catch (NullPointerException unused) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return contextToAddressFieldToValues.toString();
    }
}

class ContextAddress implements Comparable<ContextAddress> {
    private static final HashMap<ImmutablePair<Context, Address>, ContextAddress> cache = new HashMap<ImmutablePair<Context, Address>, ContextAddress>();

    Context context;
    Address address;

    private ContextAddress(Context context, Address address) {
        if (Config.v().strict) {
            assert context != null && address != null;
        }
        this.context = context;
        this.address = address;
    }

    static ContextAddress v(Context context, Address address) {
        ImmutablePair<Context, Address> key = ImmutablePair.of(context, address);
        ContextAddress value = cache.get(key);
        if (value == null) {
            value = new ContextAddress(context, address);
            cache.put(key, value);
        }
        return value;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ContextAddress)) {
            return false;
        }
        ContextAddress that = (ContextAddress)object;

        return this.context.equals(that.context) && this.address.equals(that.address);
    }

    @Override
    public int hashCode() {
        return 31 * (31 * 17 + context.hashCode()) + address.hashCode();
    }

    @Override
    public String toString() {
        return "(" + context + ", " + address + ")";
    }

    @Override
    public int compareTo(ContextAddress that) {
        int context = this.context.toString().compareTo(that.context.toString());
        if (context != 0) {
            return context;
        } else {
            return this.address.compareTo(that.address);
        }
    }
}

class AddressToValues {
    static final AddressToValues EMPTY = new AddressToValues();

    private DefaultHashMap<Address, ImmutableSet<InfoValue>> addressToValues;

    AddressToValues() {
        addressToValues = new DefaultHashMap<Address, ImmutableSet<InfoValue>>(ImmutableSet.<InfoValue>of());
    }

    ImmutableSet<InfoValue> get(Address address) {
        return addressToValues.get(address);
    }

    ImmutableSet<InfoValue> putS(Address address, ImmutableSet<InfoValue> values) {
        return addressToValues.put(address, values);
    }

    AddressToValues merge(AddressToValues that) {
        AddressToValues addressToValues = new AddressToValues();
        for (Map.Entry<Address, ImmutableSet<InfoValue>> addressValues : this.addressToValues.entrySet()) {
            Address address = addressValues.getKey();
            ImmutableSet<InfoValue> values = addressValues.getValue();
            if (that.addressToValues.containsKey(address)) {
                HashSet<InfoValue> mergedValues = new HashSet<InfoValue>(values);
                mergedValues.addAll(that.addressToValues.get(address));
                addressToValues.addressToValues.put(address, ImmutableSet.copyOf(mergedValues));
            } else {
                addressToValues.addressToValues.put(address, values);
            }
        }
        for (Map.Entry<Address, ImmutableSet<InfoValue>> addressValues : that.addressToValues.entrySet()) {
            Address address = addressValues.getKey();
            if (!this.addressToValues.containsKey(address)) {
                addressToValues.addressToValues.put(address, addressValues.getValue());
            }
        }
        return addressToValues;
    }

    Set<Map.Entry<Address, ImmutableSet<InfoValue>>> entrySet() {
        return addressToValues.entrySet();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof AddressToValues)) {
            return false;
        }
        AddressToValues that = (AddressToValues)object;

        if (this.addressToValues.size() != that.addressToValues.size()) {
            return false;
        }
        try {
            for (Map.Entry<Address, ImmutableSet<InfoValue>> addressValues : this.addressToValues.entrySet()) {
                if (!(addressValues.getValue().equals(that.addressToValues.get(addressValues.getKey())))) {
                    return false;
                }
            }
        } catch (ClassCastException unused) {
            return false;
        } catch (NullPointerException unused) {
            return false;
        }

        return true;
    }
}

class Arrays {
    private DefaultHashMap<ContextAddress, ImmutableSet<InfoValue>> arrays;

    Arrays() {
        this.arrays = new DefaultHashMap<ContextAddress, ImmutableSet<InfoValue>>(ImmutableSet.<InfoValue>of());
    }

    Arrays(Arrays that) {
        this.arrays = new DefaultHashMap<ContextAddress, ImmutableSet<InfoValue>>(that.arrays);
    }

    ImmutableSet<InfoValue> putS(Context context, Address address, ImmutableSet<InfoValue> values) {
        return arrays.put(ContextAddress.v(context, address), values);
    }

    void putSAll(Context context, AddressToValues addressToValues) {
        for (Map.Entry<Address, ImmutableSet<InfoValue>> addressValues : addressToValues.entrySet()) {
            Address address = addressValues.getKey();
            ImmutableSet<InfoValue> values = addressValues.getValue();
            putS(context, address, values);
        }
    }

    ImmutableSet<InfoValue> putW(Context context, Address address, ImmutableSet<InfoValue> values) {
        ContextAddress contextAddress = ContextAddress.v(context, address);
        ImmutableSet<InfoValue> oldValues = arrays.get(contextAddress);
        if (values != null && !values.isEmpty()) {
            HashSet<InfoValue> newValues = new HashSet<InfoValue>(oldValues);
            newValues.addAll(values);
            return arrays.put(contextAddress, ImmutableSet.<InfoValue>copyOf(newValues));
        } else {
            return oldValues;
        }
    }

    void putWAll(Context context, AddressToValues addressToValues) {
        for (Map.Entry<Address, ImmutableSet<InfoValue>> addressValues : addressToValues.entrySet()) {
            Address address = addressValues.getKey();
            ImmutableSet<InfoValue> values = addressValues.getValue();
            putW(context, address, values);
        }
    }

    ImmutableSet<InfoValue> get(ContextAddress contextAddress) {
        return arrays.get(contextAddress);
    }

    ImmutableSet<InfoValue> get(Context context, Address address) {
        return get(ContextAddress.v(context, address));
    }

    AddressToValues get(Context context) {
        AddressToValues addressToValues = new AddressToValues();
        for (Map.Entry<ContextAddress, ImmutableSet<InfoValue>> contextAddressValues : arrays.entrySet()) {
            ContextAddress contextAddress = contextAddressValues.getKey();
            ImmutableSet<InfoValue> values = contextAddressValues.getValue();
            if (contextAddress.context.equals(context)) {
                addressToValues.putS(contextAddress.address, values);
            }
        }
        return addressToValues;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Arrays)) {
            return false;
        }
        Arrays that = (Arrays)object;

        if (this.arrays.size() != that.arrays.size()) {
            return false;
        }
        try {
            for (Map.Entry<ContextAddress, ImmutableSet<InfoValue>> contextAddressValues : this.arrays.entrySet()) {
                if (!(contextAddressValues.getValue().equals(that.arrays.get(contextAddressValues.getKey())))) {
                    return false;
                }
            }
        } catch (ClassCastException unused) {
            return false;
        } catch (NullPointerException unused) {
            return false;
        }

        return true;
    }
}

class ContextField implements Comparable<ContextField> {
    private static final HashMap<ImmutablePair<Context, SootField>, ContextField> cache = new HashMap<ImmutablePair<Context, SootField>, ContextField>();

    Context context;
    SootField field;

    private ContextField(Context context, SootField field) {
        if (Config.v().strict) {
            assert context != null && field != null;
        }
        this.context= context;
        this.field = field;
    }

    static ContextField v(Context context, SootField field) {
        ImmutablePair<Context, SootField> key = ImmutablePair.of(context, field);
        ContextField value = cache.get(key);
        if (value == null) {
            value = new ContextField(context, field);
            cache.put(key, value);
        }
        return value;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ContextField)) {
            return false;
        }
        ContextField that = (ContextField)object;

        return this.context.equals(that.context) && this.field.equals(that.field);
    }

    @Override
    public int hashCode() {
        return 31 * (31 * 17 + context.hashCode()) + field.hashCode();
    }

    @Override
    public String toString() {
        return "(" + context + ", " + field.getSignature() + ")";
    }

    @Override
    public int compareTo(ContextField that) {
        int context = this.context.toString().compareTo(that.context.toString());
        if (context != 0) {
            return context;
        } else {
            return this.field.getSignature().compareTo(that.field.getSignature());
        }
    }
}

class FieldToValues {
    static final FieldToValues EMPTY = new FieldToValues();

    private DefaultHashMap<SootField, ImmutableSet<InfoValue>> fieldToValues;

    FieldToValues() {
        fieldToValues = new DefaultHashMap<SootField, ImmutableSet<InfoValue>>(ImmutableSet.<InfoValue>of());
    }

    ImmutableSet<InfoValue> get(SootField field) {
        return fieldToValues.get(field);
    }

    ImmutableSet<InfoValue> putS(SootField field, ImmutableSet<InfoValue> values) {
        return fieldToValues.put(field, values);
    }

    FieldToValues merge(FieldToValues that) {
        FieldToValues fieldToValues = new FieldToValues();
        for (Map.Entry<SootField, ImmutableSet<InfoValue>> fieldValues : this.fieldToValues.entrySet()) {
            SootField field= fieldValues.getKey();
            ImmutableSet<InfoValue> values = fieldValues.getValue();
            if (that.fieldToValues.containsKey(field)) {
                HashSet<InfoValue> mergedValues = new HashSet<InfoValue>(values);
                mergedValues.addAll(that.fieldToValues.get(field));
                fieldToValues.fieldToValues.put(field, ImmutableSet.copyOf(mergedValues));
            } else {
                fieldToValues.fieldToValues.put(field, values);
            }
        }
        for (Map.Entry<SootField, ImmutableSet<InfoValue>> fieldValues : that.fieldToValues.entrySet()) {
            SootField field = fieldValues.getKey();
            if (!this.fieldToValues.containsKey(field)) {
                fieldToValues.fieldToValues.put(field, fieldValues.getValue());
            }
        }
        return fieldToValues;
    }

    Set<Map.Entry<SootField, ImmutableSet<InfoValue>>> entrySet() {
        return fieldToValues.entrySet();
    }

    Collection<ImmutableSet<InfoValue>> values() {
        return fieldToValues.values();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof FieldToValues)) {
            return false;
        }
        FieldToValues that = (FieldToValues)object;

        if (this.fieldToValues.size() != that.fieldToValues.size()) {
            return false;
        }
        try {
            for (Map.Entry<SootField, ImmutableSet<InfoValue>> fieldValues : this.fieldToValues.entrySet()) {
                if (!(fieldValues.getValue().equals(that.fieldToValues.get(fieldValues.getKey())))) {
                    return false;
                }
            }
        } catch (ClassCastException unused) {
            return false;
        } catch (NullPointerException unused) {
            return false;
        }

        return true;
    }
}

class Statics {
    private DefaultHashMap<ContextField, ImmutableSet<InfoValue>> statics;

    Statics() {
        this.statics = new DefaultHashMap<ContextField, ImmutableSet<InfoValue>>(ImmutableSet.<InfoValue>of());
    }
    Statics(Statics that) {
        this.statics = new DefaultHashMap<ContextField, ImmutableSet<InfoValue>>(that.statics);
    }

    FieldToValues get(Context context) {
        FieldToValues fieldToValues = new FieldToValues();
        for (Map.Entry<ContextField, ImmutableSet<InfoValue>> contextFieldValues : statics.entrySet()) {
            ContextField contextField = contextFieldValues.getKey();
            ImmutableSet<InfoValue> values = contextFieldValues.getValue();
            if (contextField.context.equals(context)) {
                fieldToValues.putS(contextField.field, values);
            }
        }
        return fieldToValues;
    }

    ImmutableSet<InfoValue> putS(Context context, SootField field, ImmutableSet<InfoValue> values) {
        return statics.put(ContextField.v(context, field), values);
    }

    void putSAll(Context context, FieldToValues fieldToValues) {
        for (Map.Entry<SootField, ImmutableSet<InfoValue>> fieldValues : fieldToValues.entrySet()) {
            SootField field = fieldValues.getKey();
            ImmutableSet<InfoValue> values = fieldValues.getValue();
            putS(context, field, values);
        }
    }

    ImmutableSet<InfoValue> putW(Context context, SootField field, ImmutableSet<InfoValue> values) {
        ContextField contextField = ContextField.v(context, field);
        ImmutableSet<InfoValue> oldValues = statics.get(contextField);
        if (values != null && !values.isEmpty()) {
            HashSet<InfoValue> newValues = new HashSet<InfoValue>(oldValues);
            newValues.addAll(values);
            return statics.put(contextField, ImmutableSet.<InfoValue>copyOf(newValues));
        } else {
            return oldValues;
        }
    }

    void putWAll(Context context, FieldToValues fieldToValues) {
        for (Map.Entry<SootField, ImmutableSet<InfoValue>> fieldValues : fieldToValues.entrySet()) {
            SootField field = fieldValues.getKey();
            ImmutableSet<InfoValue> values = fieldValues.getValue();
            putW(context, field, values);
        }
    }

    ImmutableSet<InfoValue> get(ContextField contextField) {
        return statics.get(contextField);
    }

    ImmutableSet<InfoValue> get(Context context, SootField field) {
        return get(ContextField.v(context, field));
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Statics)) {
            return false;
        }
        Statics that = (Statics)object;

        if (this.statics.size() != that.statics.size()) {
            return false;
        }
        try {
            for (Map.Entry<ContextField, ImmutableSet<InfoValue>> contextFieldValues : this.statics.entrySet()) {
                if (!(contextFieldValues.getValue().equals(that.statics.get(contextFieldValues.getKey())))) {
                    return false;
                }
            }
        } catch (ClassCastException unused) {
            return false;
        } catch (NullPointerException unused) {
            return false;
        }

        return true;
    }
}

class State {
    Locals locals;
    Instances instances;
    Arrays arrays;
    Statics statics;

    State(Locals locals, Instances instances, Arrays arrays, Statics statics) {
        if (Config.v().strict) {
            assert locals != null && instances != null && arrays != null && statics != null;
        }
        this.locals = locals;
        this.instances = instances;
        this.arrays = arrays;
        this.statics = statics;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof State)) {
            return false;
        }
        State that = (State)object;

        return this.locals.equals(that.locals) && this.instances.equals(that.instances) && this.arrays.equals(that.arrays) && this.statics.equals(that.statics);
    }
}

class Address implements InfoValue, Comparable<Address> {
    private static Map<IAllocNode, Address> allocNodeToAddress = new HashMap<IAllocNode, Address>();

    final IAllocNode allocNode;

    private Address(IAllocNode allocNode) {
        if (Config.v().strict) {
            assert allocNode != null;
        }
        this.allocNode = allocNode;
    }

    public static Address v(IAllocNode allocNode) {
        if (Config.v().strict) {
            assert allocNode != null;
        }
        Address address = allocNodeToAddress.get(allocNode);
        if (address == null) {
            address = new Address(allocNode);
            allocNodeToAddress.put(allocNode, address);
        }
        return address;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (!(that instanceof Address)) {
            return false;
        }
        Address address = (Address)that;

        return this.allocNode.equals(address.allocNode);
    }

    @Override
    public int hashCode() {
        return allocNode.hashCode();
    }

    @Override
    public String toString() {
        return allocNode.toString();
    }

    @Override
    public int compareTo(Address that) {
        return allocNode.getNumber() - that.allocNode.getNumber();
    }

    static Set<Address> arraysRead(List<Block> blocks) {
        Set<Address> addresses = new HashSet<Address>();
        for (Block block : blocks) {
            Iterator<Unit> units = block.iterator();
            while (units.hasNext()) {
                Unit unit = units.next();
                if (unit instanceof AssignStmt) {
                    Set<Address> addrs = arraysRead((AssignStmt)unit);
                    if (addrs != null) {
                        addresses.addAll(addrs);
                    }
                }
            }
        }
        return addresses;
    }

    private static Set<Address> arraysRead(AssignStmt stmt) {
        Set<Address> addresses = null;
        Value rValue = stmt.getRightOp();
        if (rValue instanceof ArrayRef) {
            addresses = arraysRead(stmt, (ArrayRef)rValue);
        }
        return addresses;
    }

    private static Set<Address> arraysRead(AssignStmt stmt, ArrayRef arrayRef) {
        Set<Address> addresses = null;
        if (!(arrayRef.getType() instanceof RefLikeType)) {
            addresses = new HashSet<Address>();
            for (IAllocNode allocNode : PTABridge.v().getPTSet(arrayRef.getBase())) {
                addresses.add(Address.v(allocNode));
            }
        }
        return addresses;
    }
}
