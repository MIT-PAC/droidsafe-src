package droidsafe.analyses.infoflow;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import soot.Local;
import soot.SootClass;
import soot.SootField;
import soot.jimple.Constant;
import soot.jimple.ParameterRef;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.toolkits.callgraph.Edge;

public class States {
    private DefaultHashMap<Edge, FrameHeapStatics> contextToFrameHeapStatics;

    private static final FrameHeapStatics emptyFrameHeapStatics = new FrameHeapStatics();

    States() {
        contextToFrameHeapStatics = new DefaultHashMap<Edge, FrameHeapStatics>(emptyFrameHeapStatics);
    }

    States merge(States that) {
        States states = new States();
        for (Map.Entry<Edge, FrameHeapStatics> contextFrameHeapStatics : this.contextToFrameHeapStatics.entrySet()) {
            Edge context = contextFrameHeapStatics.getKey();
            if (that.contextToFrameHeapStatics.containsKey(context)) {
                states.contextToFrameHeapStatics.put(context, contextFrameHeapStatics.getValue().merge(that.contextToFrameHeapStatics.get(context)));
            } else {
                states.contextToFrameHeapStatics.put(context, contextFrameHeapStatics.getValue());
            }
        }
        for (Map.Entry<Edge, FrameHeapStatics> contextFrameHeapStatics : that.contextToFrameHeapStatics.entrySet()) {
            Edge context = contextFrameHeapStatics.getKey();
            if (!contextToFrameHeapStatics.containsKey(context)) {
                states.contextToFrameHeapStatics.put(context, contextFrameHeapStatics.getValue());
            }
        }
        return states;
    }

    FrameHeapStatics put(Edge context, FrameHeapStatics frameHeapStatics) {
        return contextToFrameHeapStatics.put(context, frameHeapStatics);
    }

    FrameHeapStatics get(Edge context) {
        return contextToFrameHeapStatics.get(context);
    }

    Set<Map.Entry<Edge, FrameHeapStatics>> entrySet() {
        return contextToFrameHeapStatics.entrySet();
    }

    Set<Edge> keySet() {
        return contextToFrameHeapStatics.keySet();
    }

    Collection<FrameHeapStatics> values() {
        return contextToFrameHeapStatics.values();
    }

    public boolean equals(Object that) {
        if (that instanceof States) {
            return contextToFrameHeapStatics.equals(((States)that).contextToFrameHeapStatics);
        } else {
            return false;
        }
    }

    States subtract(States that) {
        States states = new States();
        for (Map.Entry<Edge, FrameHeapStatics> edgeFrameHeapStatics : this.contextToFrameHeapStatics.entrySet()) {
            Edge edge = edgeFrameHeapStatics.getKey();
            FrameHeapStatics frameHeapStatics = edgeFrameHeapStatics.getValue();
            states.contextToFrameHeapStatics.put(edge, frameHeapStatics.subtract(that.get(edge)));
        }
        return states;
    }

    public String toString() {
        return contextToFrameHeapStatics.toString();
    }
}

class FrameHeapStatics {
    Frame frame;
    Heap heap;
    Statics statics;

    FrameHeapStatics() {
        this.frame = new Frame();
        this.heap = new Heap();
        this.statics = new Statics();
    }

    FrameHeapStatics(Frame frame, Heap heap, Statics statics) {
        this.frame = frame;
        this.heap = heap;
        this.statics = statics;
    }

    FrameHeapStatics merge(FrameHeapStatics that) {
        return new FrameHeapStatics(this.frame.merge(that.frame), this.heap.merge(that.heap), this.statics.merge(that.statics));
    }

    public boolean equals(Object that) {
        if (that instanceof FrameHeapStatics) {
            FrameHeapStatics frameHeapStatics = (FrameHeapStatics)that;
            return this.frame.equals(frameHeapStatics.frame) && this.heap.equals(frameHeapStatics.heap) && this.statics.equals(frameHeapStatics.statics);
        } else {
            return false;
        }
    }

    FrameHeapStatics subtract(FrameHeapStatics that) {
        return new FrameHeapStatics(this.frame.subtract(that.frame), this.heap.subtract(that.heap), this.statics.subtract(that.statics));
    }

    public String toString() {
        return "(" + frame + ", " + heap + ", " + statics + ")";
    }
}

class Frame {
    @SuppressWarnings("serial")
    private class MyParameterRef extends ParameterRef {
        MyParameterRef(ParameterRef param) {
            super(param.getType(), param.getIndex());
        }

        public boolean equals(Object that) {
            return equivTo(that);
        }

        public int hashCode() {
            return equivHashCode();
        }
    }

    DefaultHashMap<Local, Set<MyValue>> locals;
    DefaultHashMap<MyParameterRef, Set<MyValue>> params;

    private static final Set<MyValue> emptyValues = new HashSet<MyValue>();

    Frame() {
        locals = new DefaultHashMap<Local, Set<MyValue>>(emptyValues);
        params = new DefaultHashMap<MyParameterRef, Set<MyValue>>(emptyValues);
    }

    Frame(Frame that, DefaultHashMap<MyParameterRef, Set<MyValue>> params) {
        this.locals = new DefaultHashMap<Local, Set<MyValue>>(that.locals);
        this.params = params;
    }

    Frame(DefaultHashMap<Local, Set<MyValue>> locals, DefaultHashMap<MyParameterRef, Set<MyValue>> params) {
        this.locals = locals;
        this.params = params;
    }

    Frame merge(Frame that) {
        Frame frame = new Frame();

        for (Map.Entry<Local, Set<MyValue>> localValues : this.locals.entrySet()) {
            Set<MyValue> values = localValues.getValue();
            if (values != null) {       // TODO: is this legal?
                Local local = localValues.getKey();
                if (that.locals.containsKey(local)) {
                    Set<MyValue> vals = new HashSet<MyValue>(values);
                    vals.addAll(that.locals.get(local));
                    frame.locals.put(local, vals);
                } else {
                    frame.locals.put(local, values);
                }
            }
        }
        for (Map.Entry<Local, Set<MyValue>> localValues : that.locals.entrySet()) {
            Set<MyValue> values = localValues.getValue();
            if (values != null) {       // TODO: is this legal?
                Local local = localValues.getKey();
                if (!frame.locals.containsKey(local)) {
                    frame.locals.put(local, values);
                }
            }
        }

        for (Map.Entry<MyParameterRef, Set<MyValue>> parameterRefValues : this.params.entrySet()) {
            Set<MyValue> values = parameterRefValues.getValue();
            if (parameterRefValues.getValue() != null) {        // TODO: is this legal?
                MyParameterRef parameterRef = parameterRefValues.getKey();
                if (that.params.containsKey(parameterRef)) {
                    Set<MyValue> vals = new HashSet<MyValue>(values);
                    vals.addAll(that.params.get(parameterRef));
                    frame.params.put(parameterRef, vals);
                } else {
                    frame.params.put(parameterRef, values);
                }
            }
        }
        for (Map.Entry<MyParameterRef, Set<MyValue>> parameterRefValues : that.params.entrySet()) {
            Set<MyValue> values = parameterRefValues.getValue();
            if (values != null) {       // TODO: is this legal?
                MyParameterRef parameterRef = parameterRefValues.getKey();
                if (!frame.params.containsKey(parameterRef)) {
                    frame.params.put(parameterRef, values);
                }
            }
        }

        return frame;
    }

    Set<MyValue> put(Local local, Set<MyValue> values) {
        return locals.put(local, values);
    }

    Set<MyValue> get(Local local) {
        return locals.get(local);
    }

    Set<MyValue> remove(Local local) {
        return locals.remove(local);
    }

    Set<MyValue> put(ParameterRef parameterRef, Set<MyValue> values) {
        return params.put(new MyParameterRef(parameterRef), values);
    }

    Set<MyValue> get(ParameterRef parameterRef) {
        return params.get(new MyParameterRef(parameterRef));
    }

    public boolean equals(Object that) {
        if (that instanceof Frame) {
            Frame frame = (Frame)that;
            return locals.equals(frame.locals) && params.equals(frame.params);
        } else {
            return false;
        }
    }

    Frame subtract(Frame that) {
        Frame frame = new Frame();
        for (Map.Entry<Local, Set<MyValue>> localValues : this.locals.entrySet()) {
            Local local = localValues.getKey();
            Set<MyValue> values = localValues.getValue();
            if (that.locals.containsKey(local)) {
                Set<MyValue> vals = new HashSet<MyValue>();
                if (values != null) {
                    vals.addAll(values);
                }
                if (that.locals.get(local) != null) {
                    vals.removeAll(that.locals.get(local));
                }
                if (!vals.isEmpty()) {
                    frame.locals.put(local, vals);
                }
            } else {
                if (values != null && !values.isEmpty()) {
                    frame.locals.put(local, values);
                }
            }
        }
        for (Map.Entry<MyParameterRef, Set<MyValue>> parameterRefValues : this.params.entrySet()) {
            MyParameterRef parameterRef = parameterRefValues.getKey();
            Set<MyValue> values = parameterRefValues.getValue();
            if (that.params.containsKey(parameterRef)) {
                Set<MyValue> vals = new HashSet<MyValue>();
                if (values != null) {
                    vals.addAll(values);
                }
                if (that.params.get(parameterRef) != null) {
                    vals.removeAll(that.params.get(parameterRef));
                }
                if (!vals.isEmpty()) {
                    frame.params.put(parameterRef, vals);
                }
            } else {
                if (values != null && !values.isEmpty()) {
                    frame.params.put(parameterRef, values);
                }
            }
        }
        return frame;
    }

    public String toString() {
        return "(" + locals + ", " + params + ")";
    }
}

class Heap {
    Instances instances;
    Arrays arrays;

    Heap() {
        instances = new Instances();
        arrays = new Arrays();
    }

    Heap(Instances instances, Arrays arrays) {
        this.instances = instances;
        this.arrays = arrays;
    }

    Heap merge(Heap that) {
        return new Heap(this.instances.merge(that.instances), this.arrays.merge(that.arrays));
    }

    public boolean equals(Object that) {
        if (that instanceof Heap) {
            Heap heap = (Heap)that;
            return this.instances.equals(heap.instances) && this.arrays.equals(heap.arrays);
        } else {
            return false;
        }
    }

    Heap subtract(Heap that) {
        return new Heap(this.instances.subtract(that.instances), this.arrays.subtract(that.arrays));
    }

    public String toString() {
        return "(" + instances + ", " + arrays + ")";
    }
}

class Instances {
    private DefaultHashMap<Address, DefaultHashMap<SootField, Set<MyValue>>> addressToFieldToValues;

    private static final Set<MyValue> emptyValues = new HashSet<MyValue>();
    private static final DefaultHashMap<SootField, Set<MyValue>> emptyFieldToValues = new DefaultHashMap<SootField, Set<MyValue>>(emptyValues);

    Instances() {
        addressToFieldToValues = new DefaultHashMap<Address, DefaultHashMap<SootField, Set<MyValue>>>(emptyFieldToValues);
    }

    Instances(Instances that) {
        this.addressToFieldToValues = new DefaultHashMap<Address, DefaultHashMap<SootField, Set<MyValue>>>(that.addressToFieldToValues);
    }

    Instances merge(Instances that) {
        Instances instances = new Instances();
        for (Map.Entry<Address, DefaultHashMap<SootField, Set<MyValue>>> addressFieldToValues : addressToFieldToValues.entrySet()) {
            Address address = addressFieldToValues.getKey();
            instances.addressToFieldToValues.put(address, new DefaultHashMap<SootField, Set<MyValue>>(emptyValues));
            DefaultHashMap<SootField, Set<MyValue>> fieldToValues = instances.addressToFieldToValues.get(address);
            for (Map.Entry<SootField, Set<MyValue>> fieldValues : addressFieldToValues.getValue().entrySet()) {
                fieldToValues.put(fieldValues.getKey(), new HashSet<MyValue>(fieldValues.getValue()));
            }
        }
        for (Map.Entry<Address, DefaultHashMap<SootField, Set<MyValue>>> addressFieldToValues : that.addressToFieldToValues.entrySet()) {
            Address address = addressFieldToValues.getKey();
            if (instances.addressToFieldToValues.containsKey(address)) {
                DefaultHashMap<SootField, Set<MyValue>> fieldToValues = instances.addressToFieldToValues.get(address);
                for (Map.Entry<SootField, Set<MyValue>> fieldValues : addressFieldToValues.getValue().entrySet()) {
                    SootField field = fieldValues.getKey();
                    if (fieldToValues.containsKey(field)) {
                        fieldToValues.get(field).addAll(fieldValues.getValue());
                    } else {
                        fieldToValues.put(field, fieldValues.getValue());
                    }
                }
            } else {
                instances.addressToFieldToValues.put(address, addressFieldToValues.getValue());
            }
        }
        return instances;
    }

    Set<MyValue> put(Address address, SootField field, Set<MyValue> values) {
        DefaultHashMap<SootField, Set<MyValue>> fieldToValuesOld = addressToFieldToValues.get(address);
        Set<MyValue> valuesOld = fieldToValuesOld.get(field);
        Set<MyValue> valuesNew = new HashSet<MyValue>(valuesOld);
        valuesNew.addAll(values);
        DefaultHashMap<SootField, Set<MyValue>> fieldToValuesNew = new DefaultHashMap<SootField, Set<MyValue>>(fieldToValuesOld);
        fieldToValuesNew.put(field, valuesNew);
        addressToFieldToValues.put(address, fieldToValuesNew);
        return valuesOld;
    }

    Set<MyValue> get(Address address, SootField field) {
        return addressToFieldToValues.get(address).get(field);
    }

    public boolean equals(Object that) {
        if (that instanceof Instances) {
            return this.addressToFieldToValues.equals(((Instances)that).addressToFieldToValues);
        } else {
            return false;
        }
    }

    Instances subtract(Instances that) {
        Instances instances = new Instances();
        for (Map.Entry<Address, DefaultHashMap<SootField, Set<MyValue>>> addressFieldToValues : this.addressToFieldToValues.entrySet()) {
            Address address = addressFieldToValues.getKey();
            if (that.addressToFieldToValues.containsKey(address)) {
                DefaultHashMap<SootField, Set<MyValue>> fieldToValues = new DefaultHashMap<SootField, Set<MyValue>>(emptyValues);
                for (Map.Entry<SootField, Set<MyValue>> fieldValues : addressFieldToValues.getValue().entrySet()) {
                    SootField field = fieldValues.getKey();
                    Set<MyValue> values = fieldValues.getValue();
                    if (that.addressToFieldToValues.get(address).containsKey(field)) {
                        Set<MyValue> vals = new HashSet<MyValue>(values);
                        vals.removeAll(that.addressToFieldToValues.get(address).get(field));
                        if (!vals.isEmpty()) {
                            fieldToValues.put(field, vals);
                        }
                    } else {
                        if (!values.isEmpty()) {
                            fieldToValues.put(field, values);
                        }
                    }
                }
                if (!fieldToValues.isEmpty()) {
                    instances.addressToFieldToValues.put(address, fieldToValues);
                }
            } else {
                DefaultHashMap<SootField, Set<MyValue>> fieldToValues = new DefaultHashMap<SootField, Set<MyValue>>(emptyValues);
                for (Map.Entry<SootField, Set<MyValue>> fieldValues : addressFieldToValues.getValue().entrySet()) {
                    SootField field = fieldValues.getKey();
                    Set<MyValue> values = fieldValues.getValue();
                    if (!values.isEmpty()) {
                        fieldToValues.put(field, values);
                    }
                }
                if (!fieldToValues.isEmpty()) {
                    instances.addressToFieldToValues.put(address, fieldToValues);
                }
            }
        }
        return instances;
    }

    public String toString() {
        return addressToFieldToValues.toString();
    }
}

class Arrays {
    private DefaultHashMap<Address, Set<MyValue>> addressToValues;

    private static final Set<MyValue> emptyValues = new HashSet<MyValue>();

    Arrays() {
        addressToValues = new DefaultHashMap<Address, Set<MyValue>>(emptyValues);
    }

    Arrays(Arrays that) {
        this.addressToValues = new DefaultHashMap<Address, Set<MyValue>>(that.addressToValues);
    }

    Arrays merge(Arrays that) {
        Arrays arrays = new Arrays();

        for (Map.Entry<Address, Set<MyValue>> addressValues : this.addressToValues.entrySet()) {
            Set<MyValue> values = addressValues.getValue();
            if (values != null) {       // TODO: is this legal?
                Address address = addressValues.getKey();
                if (that.addressToValues.containsKey(address)) {
                    Set<MyValue> vals = new HashSet<MyValue>(values);
                    vals.addAll(that.addressToValues.get(address));
                    arrays.addressToValues.put(address, vals);
                } else {
                    arrays.addressToValues.put(address, values);
                }
            }
        }
        for (Map.Entry<Address, Set<MyValue>> addressValues : that.addressToValues.entrySet()) {
            Set<MyValue> values = addressValues.getValue();
            if (values != null) {       // TODO: is this legal?
                Address address = addressValues.getKey();
                if (!arrays.addressToValues.containsKey(address)) {
                    arrays.addressToValues.put(address, values);
                }
            }
        }

        return arrays;
    }

    Set<MyValue> put(Address address, Set<MyValue> values) {
        return addressToValues.put(address, values);
    }

    Set<MyValue> get(Address address) {
        return addressToValues.get(address);
    }

    public boolean equals(Object that) {
        if (that instanceof Arrays) {
            return this.addressToValues.equals(((Arrays)that).addressToValues);
        } else {
            return false;
        }
    }

    Arrays subtract(Arrays that) {
        Arrays arrays = new Arrays();
        for (Map.Entry<Address, Set<MyValue>> addressValues : this.addressToValues.entrySet()) {
            Address address = addressValues.getKey();
            Set<MyValue> values = addressValues.getValue();
            if (that.addressToValues.containsKey(address)) {
                Set<MyValue> vals = new HashSet<MyValue>();
                if (values != null) {
                    vals.addAll(values);
                }
                if (that.addressToValues.get(address) != null) {
                    vals.removeAll(that.addressToValues.get(address));
                }
                if (!vals.isEmpty()) {
                    arrays.addressToValues.put(address, vals);
                }
            } else {
                if (values != null && !values.isEmpty()) {
                    arrays.addressToValues.put(address, values);
                }
            }
        }
        return arrays;
    }

    public String toString() {
        return addressToValues.toString();
    }
}

class Statics {
    private DefaultHashMap<SootClass, DefaultHashMap<SootField, Set<MyValue>>> classToFieldToValues;

    private static final Set<MyValue> emptyValues = new HashSet<MyValue>();
    private static final DefaultHashMap<SootField, Set<MyValue>> emptyFieldToValues = new DefaultHashMap<SootField, Set<MyValue>>(emptyValues);

    Statics() {
        classToFieldToValues = new DefaultHashMap<SootClass, DefaultHashMap<SootField, Set<MyValue>>>(emptyFieldToValues);
    }

    Statics(Statics that) {
        classToFieldToValues = new DefaultHashMap<SootClass, DefaultHashMap<SootField, Set<MyValue>>>(that.classToFieldToValues);
    }

    Statics merge(Statics that) {
        Statics statics = new Statics();
        for (Map.Entry<SootClass, DefaultHashMap<SootField, Set<MyValue>>> classFieldToValues : this.classToFieldToValues.entrySet()) {
            SootClass klass = classFieldToValues.getKey();
            statics.classToFieldToValues.put(klass, new DefaultHashMap<SootField, Set<MyValue>>(emptyValues));
            Map<SootField, Set<MyValue>> fieldToValues = statics.classToFieldToValues.get(klass);
            for (Map.Entry<SootField, Set<MyValue>> fieldValues : classFieldToValues.getValue().entrySet()) {
                fieldToValues.put(fieldValues.getKey(), new HashSet<MyValue>(fieldValues.getValue()));
            }
        }
        for (Map.Entry<SootClass, DefaultHashMap<SootField, Set<MyValue>>> classFieldToValues : that.classToFieldToValues.entrySet()) {
            SootClass klass = classFieldToValues.getKey();
            if (statics.classToFieldToValues.containsKey(klass)) {
                DefaultHashMap<SootField, Set<MyValue>> fieldToValues = statics.classToFieldToValues.get(klass);
                for (Map.Entry<SootField, Set<MyValue>> fieldValues : classFieldToValues.getValue().entrySet()) {
                    SootField field = fieldValues.getKey();
                    if (fieldToValues.containsKey(field)) {
                        fieldToValues.get(field).addAll(fieldValues.getValue());
                    } else {
                        fieldToValues.put(field, fieldValues.getValue());
                    }
                }
            } else {
                statics.classToFieldToValues.put(klass, classFieldToValues.getValue());
            }
        }
        return statics;
    }

    Set<MyValue> put(SootClass klass, SootField field, Set<MyValue> values) {
        DefaultHashMap<SootField, Set<MyValue>> fieldToValuesOld = classToFieldToValues.get(klass);
        Set<MyValue> valuesOld = fieldToValuesOld.get(field);
        DefaultHashMap<SootField, Set<MyValue>> fieldToValuesNew = new DefaultHashMap<SootField, Set<MyValue>>(fieldToValuesOld);
        fieldToValuesNew.put(field, values);
        classToFieldToValues.put(klass, fieldToValuesNew);
        return valuesOld;
    }

    Set<MyValue> get(SootClass klass, SootField field) {
        return classToFieldToValues.get(klass).get(field);
    }

    Set<MyValue> remove(SootClass klass, SootField field) {
        DefaultHashMap<SootField, Set<MyValue>> fieldToValuesOld = classToFieldToValues.get(klass);
        Set<MyValue> valuesOld = fieldToValuesOld.get(field);
        DefaultHashMap<SootField, Set<MyValue>> fieldToValuesNew = new DefaultHashMap<SootField, Set<MyValue>>(fieldToValuesOld);
        fieldToValuesNew.remove(field);
        classToFieldToValues.put(klass, fieldToValuesNew);
        return valuesOld;
    }

    public boolean equals(Object that) {
        if (that instanceof Statics) {
            return this.classToFieldToValues.equals(((Statics)that).classToFieldToValues);
        } else {
            return false;
        }
    }

    Statics subtract(Statics that) {
        Statics statics = new Statics();
        for (Map.Entry<SootClass, DefaultHashMap<SootField, Set<MyValue>>> classFieldToValues : this.classToFieldToValues.entrySet()) {
            SootClass klass = classFieldToValues.getKey();
            if (that.classToFieldToValues.containsKey(klass)) {
                DefaultHashMap<SootField, Set<MyValue>> fieldToValues = new DefaultHashMap<SootField, Set<MyValue>>(emptyValues);
                for (Map.Entry<SootField, Set<MyValue>> fieldValues : classFieldToValues.getValue().entrySet()) {
                    SootField field = fieldValues.getKey();
                    Set<MyValue> values = fieldValues.getValue();
                    if (that.classToFieldToValues.get(klass).containsKey(field)) {
                        Set<MyValue> vals = new HashSet<MyValue>(values);
                        vals.removeAll(that.classToFieldToValues.get(klass).get(field));
                        if (!vals.isEmpty()) {
                            fieldToValues.put(field, vals);
                        }
                    } else {
                        if (!values.isEmpty()) {
                            fieldToValues.put(field, values);
                        }
                    }
                }
                if (!fieldToValues.isEmpty()) {
                    statics.classToFieldToValues.put(klass, fieldToValues);
                }
            } else {
                DefaultHashMap<SootField, Set<MyValue>> fieldToValues = new DefaultHashMap<SootField, Set<MyValue>>(emptyValues);
                for (Map.Entry<SootField, Set<MyValue>> fieldValues : classFieldToValues.getValue().entrySet()) {
                    SootField field = fieldValues.getKey();
                    Set<MyValue> values = fieldValues.getValue();
                    if (!values.isEmpty()) {
                        fieldToValues.put(field, values);
                    }
                }
                if (!fieldToValues.isEmpty()) {
                    statics.classToFieldToValues.put(klass, fieldToValues);
                }
            }
        }
        return statics;
    }

    public String toString() {
        return classToFieldToValues.toString();
    }
}

abstract class MyValue {
}

class MyConstant extends MyValue {
    private Constant constant;

    MyConstant(Constant constant) {
        this.constant = constant;
    }

    public boolean equals(Object that) {
        if (that instanceof MyConstant) {
            return constant.equivTo(((MyConstant)that).constant);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return constant.equivHashCode();
    }

    public String toString() {
        return constant.toString();
    }
}

class Address extends MyValue {
    private final AllocNode allocNode;

    Address(AllocNode node) {
        allocNode = node;
    }

    public boolean equals(Object that) {
        if (that instanceof Address) {
            return allocNode.equals(((Address)that).allocNode);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return allocNode.hashCode();
    }

    public String toString() {
        return allocNode.toString();
    }
}
