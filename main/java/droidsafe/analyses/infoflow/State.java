package droidsafe.analyses.infoflow;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.tuple.ImmutablePair;

import com.google.common.collect.ImmutableSet;

import soot.Local;
import soot.SootField;
import soot.Unit;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.toolkits.callgraph.Edge;

class EdgeLocal implements Comparable<EdgeLocal> {
    private static final HashMap<ImmutablePair<Edge, Local>, EdgeLocal> cache = new HashMap<ImmutablePair<Edge, Local>, EdgeLocal>();

    Edge entryEdge;
    Local local;

    private EdgeLocal(Edge entryEdge, Local local) {
        assert entryEdge != null && local != null;
        this.entryEdge = entryEdge;
        this.local = local;
    }

    static EdgeLocal v(Edge entryEdge, Local local) {
        ImmutablePair<Edge, Local> key = ImmutablePair.of(entryEdge, local);
        EdgeLocal value = cache.get(key);
        if (value == null) {
            value = new EdgeLocal(entryEdge, local);
            cache.put(key, value);
        }
        return value;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof EdgeLocal)) {
            return false;
        }
        EdgeLocal that = (EdgeLocal)object;

        return this.entryEdge.equals(that.entryEdge) && this.local.equals(that.local);
    }

    @Override
    public int hashCode() {
        return 31 * (31 * 17 + entryEdge.hashCode()) + local.hashCode();
    }

    @Override
    public String toString() {
        return "(" + entryEdge + ", " + local + ")";
    }

    @Override
    public int compareTo(EdgeLocal that) {
        int entryEdge = this.entryEdge.toString().compareTo(that.entryEdge.toString());
        if (entryEdge != 0) {
            return entryEdge;
        } else {
            return this.local.toString().compareTo(that.local.toString());
        }
    }
}

class Locals {
    static final Locals EMPTY = new Locals();

    private DefaultHashMap<EdgeLocal, ImmutableSet<InfoValue>> locals;

    Locals() {
        locals = new DefaultHashMap<EdgeLocal, ImmutableSet<InfoValue>>(ImmutableSet.<InfoValue>of());
    }

    Locals(Locals that) {
        this.locals = new DefaultHashMap<EdgeLocal, ImmutableSet<InfoValue>>(that.locals);
    }

    ImmutableSet<InfoValue> putS(Edge entryEdge, Local local, HashSet<InfoValue> values) {
        return putS(entryEdge, local, ImmutableSet.<InfoValue>copyOf(values));
    }

    ImmutableSet<InfoValue> putS(Edge entryEdge, Local local, ImmutableSet<InfoValue> values) {
        if (values != null && !values.isEmpty()) {
            return locals.put(EdgeLocal.v(entryEdge, local), values);
        } else {
            return locals.remove(EdgeLocal.v(entryEdge, local));
        }
    }

    ImmutableSet<InfoValue> putW(Edge entryEdge, Local local, ImmutableSet<InfoValue> values) {
        EdgeLocal edgeLocal = EdgeLocal.v(entryEdge, local);
        ImmutableSet<InfoValue> oldValues = locals.get(edgeLocal);
        if (values != null && !values.isEmpty()) {
            HashSet<InfoValue> newValues = new HashSet<InfoValue>(oldValues);
            newValues.addAll(values);
            return locals.put(edgeLocal, ImmutableSet.<InfoValue>copyOf(newValues));
        } else {
            return oldValues;
        }
    }

    ImmutableSet<InfoValue> remove(Edge entryEdge, Local local) {
        return remove(EdgeLocal.v(entryEdge, local));
    }

    private ImmutableSet<InfoValue> remove(EdgeLocal edgeLocal) {
        return locals.remove(edgeLocal);
    }
    
    ImmutableSet<InfoValue> get(Edge entryEdge, Local local) {
        return get(EdgeLocal.v(entryEdge, local));
    }
    
    private ImmutableSet<InfoValue> get(EdgeLocal edgeLocal) {
        return locals.get(edgeLocal);
    }
    
    Locals merge(Locals that) {
        Locals locals = new Locals();
        for (Map.Entry<EdgeLocal, ImmutableSet<InfoValue>> edgeLocalValues : this.locals.entrySet()) {
            EdgeLocal edgeLocal = edgeLocalValues.getKey();
            ImmutableSet<InfoValue> values = edgeLocalValues.getValue();
            if (that.locals.containsKey(edgeLocal)) {
                HashSet<InfoValue> mergedValues = new HashSet<InfoValue>(values);
                mergedValues.addAll(that.locals.get(edgeLocal));
                locals.locals.put(edgeLocal, ImmutableSet.copyOf(mergedValues));
            } else {
                locals.locals.put(edgeLocal, values);
            }
        }
        for (Map.Entry<EdgeLocal, ImmutableSet<InfoValue>> edgeLocalValues : that.locals.entrySet()) {
            EdgeLocal edgeLocal = edgeLocalValues.getKey();
            if (!this.locals.containsKey(edgeLocal)) {
                locals.locals.put(edgeLocal, edgeLocalValues.getValue());
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
       
       if (this.locals.size() != that.locals.size()) {
           return false;
       }
       try {
           for (Map.Entry<EdgeLocal, ImmutableSet<InfoValue>> localValues : this.locals.entrySet()) {
               if (!(localValues.getValue().equals(that.locals.get(localValues.getKey())))) {
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
        return locals.toString();
    }
    
    int size() {
        return locals.size();
    }

    Collection<ImmutableSet<InfoValue>> values() {
        return locals.values();
    }
    
    Locals minus(Locals that) {
        Locals locals = new Locals();
        for (Map.Entry<EdgeLocal, ImmutableSet<InfoValue>> edgeLocalValues : this.locals.entrySet()) {
            EdgeLocal edgeLocal = edgeLocalValues.getKey();
            HashSet<InfoValue> values = new HashSet<InfoValue>(edgeLocalValues.getValue());
            values.removeAll(that.get(edgeLocal));
            locals.putS(edgeLocal.entryEdge, edgeLocal.local, ImmutableSet.<InfoValue>copyOf(values));
        }
        return locals;
    }
}

class AddressField implements Comparable<AddressField> {
    private static final HashMap<ImmutablePair<Address, SootField>, AddressField> cache = new HashMap<ImmutablePair<Address, SootField>, AddressField>();

    Address address;
    SootField field;

    private AddressField(Address address, SootField field) {
        assert address != null && field != null;
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
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (!(that instanceof AddressField)) {
            return false;
        }
        AddressField addressField = (AddressField)that;

        return this.address.equals(addressField.address) && this.field.equals(addressField.field);
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
}

class EdgeAddressField implements Comparable<EdgeAddressField> {
    private static final HashMap<ImmutablePair<Edge, AddressField>, EdgeAddressField> cache = new HashMap<ImmutablePair<Edge, AddressField>, EdgeAddressField>();

    Edge entryEdge;
    AddressField addressField;

    private EdgeAddressField(Edge entryEdge, AddressField addressField) {
        assert entryEdge != null && addressField != null;
        this.entryEdge = entryEdge;
        this.addressField = addressField;
    }

    static EdgeAddressField v(Edge entryEdge, Address address, SootField field) {
        return v(entryEdge, AddressField.v(address, field));
    }

    static EdgeAddressField v(Edge entryEdge, AddressField addressField) {
        ImmutablePair<Edge, AddressField> key = ImmutablePair.of(entryEdge, addressField);
        EdgeAddressField value = cache.get(key);
        if (value == null) {
            value = new EdgeAddressField(entryEdge, addressField);
            cache.put(key, value);
        }
        return value;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof EdgeAddressField)) {
            return false;
        }
        EdgeAddressField that = (EdgeAddressField)object;

        return this.entryEdge.equals(that.entryEdge) && this.addressField.equals(that.addressField);
    }

    @Override
    public int hashCode() {
        return 31 * (31 * 17 + entryEdge.hashCode()) + addressField.hashCode();
    }

    @Override
    public String toString() {
        return "(" + entryEdge + ", " + addressField.address + "," + addressField.field + ")";
    }

    @Override
    public int compareTo(EdgeAddressField that) {
        int entryEdge = this.entryEdge.toString().compareTo(that.entryEdge.toString());
        if (entryEdge != 0) {
            return entryEdge;
        } else {
            return this.addressField.compareTo(that.addressField);
        }
    }
}

class AddressFieldToValues {
    static final AddressFieldToValues EMPTY = new AddressFieldToValues();
    
    private DefaultHashMap<AddressField, ImmutableSet<InfoValue>> addressFieldToValues;
    
    AddressFieldToValues() {
        addressFieldToValues = new DefaultHashMap<AddressField, ImmutableSet<InfoValue>>(ImmutableSet.<InfoValue>of());
    }
    
    ImmutableSet<InfoValue> get(Address address, SootField field) {
        return get(AddressField.v(address, field));
    }

    ImmutableSet<InfoValue> get(AddressField addressField) {
        return addressFieldToValues.get(addressField);
    }

    ImmutableSet<InfoValue> putS(AddressField addressField, ImmutableSet<InfoValue> values) {
        return addressFieldToValues.put(addressField, values);
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
    private DefaultHashMap<EdgeAddressField, ImmutableSet<InfoValue>> instances;

    Instances() {
        instances = new DefaultHashMap<EdgeAddressField, ImmutableSet<InfoValue>>(ImmutableSet.<InfoValue>of());
    }

    Instances(Instances that) {
        this.instances = new DefaultHashMap<EdgeAddressField, ImmutableSet<InfoValue>>(that.instances);
    }

    ImmutableSet<InfoValue> get(Edge entryEdge, Address address, SootField field) {
        return instances.get(EdgeAddressField.v(entryEdge, address, field)); 
    }

    AddressFieldToValues get(Edge entryEdge) {
        AddressFieldToValues addressFieldToValues = new AddressFieldToValues();
        for (Map.Entry<EdgeAddressField, ImmutableSet<InfoValue>> edgeAddressFieldValues : instances.entrySet()) {
            EdgeAddressField edgeAddressField = edgeAddressFieldValues.getKey();
            ImmutableSet<InfoValue> values = edgeAddressFieldValues.getValue();
            if (edgeAddressField.entryEdge.equals(entryEdge)) {
                addressFieldToValues.putS(AddressField.v(edgeAddressField.addressField.address, edgeAddressField.addressField.field), values);
            }
        }
        return addressFieldToValues;
    }

    private HashMap<EdgeAddress, FieldToValues> edgeAddressToFieldToValues;

    // XXX: put*() must not be called after calling get(Edge, Address). Otherwise, subsequent get(Edge, Address)' return value may be invalid. 
    FieldToValues get(Edge entryEdge, Address address) {
        if (edgeAddressToFieldToValues == null) {
            edgeAddressToFieldToValues = new HashMap<EdgeAddress, FieldToValues>();
        }
        
        EdgeAddress edgeAddress = EdgeAddress.v(entryEdge, address);
        
        if (edgeAddressToFieldToValues.containsKey(edgeAddress)) {
            return edgeAddressToFieldToValues.get(edgeAddress);
        }
        
        FieldToValues fieldToValues = new FieldToValues();
        for (Map.Entry<EdgeAddressField, ImmutableSet<InfoValue>> edgeAddressFieldValues : instances.entrySet()) {
            EdgeAddressField edgeAddressField = edgeAddressFieldValues.getKey();
            ImmutableSet<InfoValue> values = edgeAddressFieldValues.getValue();
            if (edgeAddressField.entryEdge.equals(entryEdge) && edgeAddressField.addressField.address.equals(address)) {
                fieldToValues.putS(edgeAddressField.addressField.field, values);
            }
        }
        edgeAddressToFieldToValues.put(edgeAddress, fieldToValues);
        return fieldToValues;
    }
    
    void putSAll(Edge entryEdge, AddressFieldToValues addressFieldToValues) {
        for (Map.Entry<AddressField, ImmutableSet<InfoValue>> addressFieldValues : addressFieldToValues.entrySet()) {
            AddressField addressField = addressFieldValues.getKey();
            ImmutableSet<InfoValue> values = addressFieldValues.getValue();
            putS(entryEdge, addressField, values);
        }
    }

    ImmutableSet<InfoValue> putS(Edge entryEdge, AddressField addressField, ImmutableSet<InfoValue> values) {
        return instances.put(EdgeAddressField.v(entryEdge, addressField), values);
    }
    
    void putWAll(Edge entryEdge, AddressFieldToValues addressFieldToValues) {
        for (Map.Entry<AddressField, ImmutableSet<InfoValue>> addressFieldValues : addressFieldToValues.entrySet()) {
            AddressField addressField = addressFieldValues.getKey();
            ImmutableSet<InfoValue> values = addressFieldValues.getValue();
            putW(entryEdge, addressField, values);
        }
    }

    ImmutableSet<InfoValue> putW(Edge entryEdge, AddressField addressField, ImmutableSet<InfoValue> values) {
        return putW(entryEdge, addressField.address, addressField.field, values);
    }

    ImmutableSet<InfoValue> putW(Edge entryEdge, Address address, SootField field, ImmutableSet<InfoValue> values) {
        EdgeAddressField edgeAddressField = EdgeAddressField.v(entryEdge, address, field);
        ImmutableSet<InfoValue> oldValues = instances.get(edgeAddressField);
        if (values != null && !values.isEmpty()) {
            HashSet<InfoValue> newValues = new HashSet<InfoValue>(oldValues);
            newValues.addAll(values);
            return instances.put(edgeAddressField, ImmutableSet.<InfoValue>copyOf(newValues));
        } else {
            return oldValues;
        }
    }

    Set<Map.Entry<EdgeAddressField, ImmutableSet<InfoValue>>> entrySet() {
        return instances.entrySet();
    }
    
    int size() {
        return instances.size();
    }

    Collection<ImmutableSet<InfoValue>> values() {
        return instances.values();
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

        if (this.instances.size() != that.instances.size()) {
            return false;
        }
        try {
            for (Map.Entry<EdgeAddressField, ImmutableSet<InfoValue>> edgeAddressFieldValues : this.instances.entrySet()) {
                if (!(edgeAddressFieldValues.getValue().equals(that.instances.get(edgeAddressFieldValues.getKey())))) {
                    return false;
                }
//                if (edgeAddressFieldValues.getValue().size() != that.instances.get(edgeAddressFieldValues.getKey()).size()) {
//                    return false;
//                }
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
        return instances.toString();
    }
    
    Instances minus(Instances that) {
        Instances instances = new Instances();
        for (Map.Entry<EdgeAddressField, ImmutableSet<InfoValue>> edgeAddressFieldValues : this.instances.entrySet()) {
            EdgeAddressField edgeAddressField = edgeAddressFieldValues.getKey();
            HashSet<InfoValue> values = new HashSet<InfoValue>(edgeAddressFieldValues.getValue());
            values.removeAll(that.get(edgeAddressField.entryEdge, edgeAddressField.addressField.address, edgeAddressField.addressField.field));
            instances.putS(edgeAddressField.entryEdge, edgeAddressField.addressField, ImmutableSet.<InfoValue>copyOf(values));
        }
        return instances;
    }
}

class EdgeAddress implements Comparable<EdgeAddress> {
    private static final HashMap<ImmutablePair<Edge, Address>, EdgeAddress> cache = new HashMap<ImmutablePair<Edge, Address>, EdgeAddress>();

    Edge entryEdge;
    Address address;

    private EdgeAddress(Edge entryEdge, Address address) {
        assert entryEdge != null && address != null;
        this.entryEdge = entryEdge;
        this.address = address;
    }

    static EdgeAddress v(Edge entryEdge, Address address) {
        ImmutablePair<Edge, Address> key = ImmutablePair.of(entryEdge, address);
        EdgeAddress value = cache.get(key);
        if (value == null) {
            value = new EdgeAddress(entryEdge, address);
            cache.put(key, value);
        }
        return value;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof EdgeAddress)) {
            return false;
        }
        EdgeAddress that = (EdgeAddress)object;

        return this.entryEdge.equals(that.entryEdge) && this.address.equals(that.address);
    }

    @Override
    public int hashCode() {
        return 31 * (31 * 17 + entryEdge.hashCode()) + address.hashCode();
    }

    @Override
    public String toString() {
        return "(" + entryEdge + ", " + address + ")";
    }

    @Override
    public int compareTo(EdgeAddress that) {
        int entryEdge = this.entryEdge.toString().compareTo(that.entryEdge.toString());
        if (entryEdge != 0) {
            return entryEdge;
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
    private DefaultHashMap<EdgeAddress, ImmutableSet<InfoValue>> arrays;

    Arrays() {
        this.arrays = new DefaultHashMap<EdgeAddress, ImmutableSet<InfoValue>>(ImmutableSet.<InfoValue>of());
    }

    Arrays(Arrays that) {
        this.arrays = new DefaultHashMap<EdgeAddress, ImmutableSet<InfoValue>>(that.arrays);
    }

    AddressToValues get(Edge entryEdge) {
        AddressToValues addressToValues = new AddressToValues();
        for (Map.Entry<EdgeAddress, ImmutableSet<InfoValue>> edgeAddressValues : arrays.entrySet()) {
            EdgeAddress edgeAddress = edgeAddressValues.getKey();
            ImmutableSet<InfoValue> values = edgeAddressValues.getValue();
            if (edgeAddress.entryEdge.equals(entryEdge)) {
                addressToValues.putS(edgeAddress.address, values);
            }
        }
        return addressToValues;
    }

    ImmutableSet<InfoValue> get(Edge entryEdge, Address address) {
        return get(EdgeAddress.v(entryEdge, address));
    }
    
    ImmutableSet<InfoValue> get(EdgeAddress edgeAddress) {
        return arrays.get(edgeAddress);
    }

    void putWAll(Edge entryEdge, AddressToValues addressToValues) {
        for (Map.Entry<Address, ImmutableSet<InfoValue>> addressValues : addressToValues.entrySet()) {
            Address address = addressValues.getKey();
            ImmutableSet<InfoValue> values = addressValues.getValue();
            putW(entryEdge, address, values);
        }
    }

    ImmutableSet<InfoValue> putW(Edge entryEdge, Address address, ImmutableSet<InfoValue> values) {
        EdgeAddress edgeAddress = EdgeAddress.v(entryEdge, address);
        ImmutableSet<InfoValue> oldValues = arrays.get(edgeAddress);
        if (values != null && !values.isEmpty()) {
            HashSet<InfoValue> newValues = new HashSet<InfoValue>(oldValues);
            newValues.addAll(values);
            return arrays.put(edgeAddress, ImmutableSet.<InfoValue>copyOf(newValues));
        } else {
            return oldValues;
        }
    }

    void putSAll(Edge entryEdge, AddressToValues addressToValues) {
        for (Map.Entry<Address, ImmutableSet<InfoValue>> addressValues : addressToValues.entrySet()) {
            Address address = addressValues.getKey();
            ImmutableSet<InfoValue> values = addressValues.getValue();
            putS(entryEdge, address, values);
        }
    }

    ImmutableSet<InfoValue> putS(Edge entryEdge, Address address, ImmutableSet<InfoValue> values) {
        return arrays.put(EdgeAddress.v(entryEdge, address), values);
    }
    
    int size() {
        return arrays.size();
    }
    
    Collection<ImmutableSet<InfoValue>> values() {
        return arrays.values();
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
           for (Map.Entry<EdgeAddress, ImmutableSet<InfoValue>> edgeAddressValues : this.arrays.entrySet()) {
               if (!(edgeAddressValues.getValue().equals(that.arrays.get(edgeAddressValues.getKey())))) {
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
    
    Arrays minus(Arrays that) {
        Arrays arrays = new Arrays();
        for (Map.Entry<EdgeAddress, ImmutableSet<InfoValue>> edgeAddressValues : this.arrays.entrySet()) {
            EdgeAddress edgeAddress = edgeAddressValues.getKey();
            HashSet<InfoValue> values = new HashSet<InfoValue>(edgeAddressValues.getValue());
            values.removeAll(that.get(edgeAddress));
            arrays.putS(edgeAddress.entryEdge, edgeAddress.address, ImmutableSet.<InfoValue>copyOf(values));
        }
        return arrays;
    }
}

class EdgeField implements Comparable<EdgeField> {
    private static final HashMap<ImmutablePair<Edge, SootField>, EdgeField> cache = new HashMap<ImmutablePair<Edge, SootField>, EdgeField>();

    Edge entryEdge;
    SootField field;

    private EdgeField(Edge entryEdge, SootField field) {
        assert entryEdge != null && field != null;
        this.entryEdge = entryEdge;
        this.field = field;
    }

    static EdgeField v(Edge entryEdge, SootField field) {
        ImmutablePair<Edge, SootField> key = ImmutablePair.of(entryEdge, field);
        EdgeField value = cache.get(key);
        if (value == null) {
            value = new EdgeField(entryEdge, field);
            cache.put(key, value);
        }
        return value;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof EdgeField)) {
            return false;
        }
        EdgeField that = (EdgeField)object;

        return this.entryEdge.equals(that.entryEdge) && this.field.equals(that.field);
    }

    @Override
    public int hashCode() {
        return 31 * (31 * 17 + entryEdge.hashCode()) + field.hashCode();
    }

    @Override
    public String toString() {
        return "(" + entryEdge + ", " + field.getSignature() + ")";
    }

    @Override
    public int compareTo(EdgeField that) {
        int entryEdge = this.entryEdge.toString().compareTo(that.entryEdge.toString());
        if (entryEdge != 0) {
            return entryEdge;
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
    private DefaultHashMap<EdgeField, ImmutableSet<InfoValue>> statics;

    Statics() {
        this.statics = new DefaultHashMap<EdgeField, ImmutableSet<InfoValue>>(ImmutableSet.<InfoValue>of());
    }
    Statics(Statics that) {
        this.statics = new DefaultHashMap<EdgeField, ImmutableSet<InfoValue>>(that.statics);
    }

    FieldToValues get(Edge entryEdge) {
        FieldToValues fieldToValues = new FieldToValues();
        for (Map.Entry<EdgeField, ImmutableSet<InfoValue>> edgeFieldValues : statics.entrySet()) {
            EdgeField edgeField = edgeFieldValues.getKey();
            ImmutableSet<InfoValue> values = edgeFieldValues.getValue();
            if (edgeField.entryEdge.equals(entryEdge)) {
                fieldToValues.putS(edgeField.field, values);
            }
        }
        return fieldToValues;
    }

    ImmutableSet<InfoValue> get(Edge entryEdge, SootField field) {
        return get(EdgeField.v(entryEdge, field));
    }
    
    ImmutableSet<InfoValue> get(EdgeField edgeField) {
        return statics.get(edgeField);
    }

    void putWAll(Edge entryEdge, FieldToValues fieldToValues) {
        for (Map.Entry<SootField, ImmutableSet<InfoValue>> fieldValues : fieldToValues.entrySet()) {
            SootField field = fieldValues.getKey();
            ImmutableSet<InfoValue> values = fieldValues.getValue();
            putW(entryEdge, field, values);
        }
    }

    ImmutableSet<InfoValue> putW(Edge entryEdge, SootField field, ImmutableSet<InfoValue> values) {
        EdgeField edgeField = EdgeField.v(entryEdge, field);
        ImmutableSet<InfoValue> oldValues = statics.get(edgeField);
        if (values != null && !values.isEmpty()) {
            HashSet<InfoValue> newValues = new HashSet<InfoValue>(oldValues);
            newValues.addAll(values);
            return statics.put(edgeField, ImmutableSet.<InfoValue>copyOf(newValues));
        } else {
            return oldValues;
        }
    }

    void putSAll(Edge entryEdge, FieldToValues fieldToValues) {
        for (Map.Entry<SootField, ImmutableSet<InfoValue>> fieldValues : fieldToValues.entrySet()) {
            SootField field = fieldValues.getKey();
            ImmutableSet<InfoValue> values = fieldValues.getValue();
            putS(entryEdge, field, values);
        }
    }

    ImmutableSet<InfoValue> putS(Edge entryEdge, SootField field, ImmutableSet<InfoValue> values) {
        return statics.put(EdgeField.v(entryEdge, field), values);
    }
    
    int size() {
        return statics.size();
    }
    
    Collection<ImmutableSet<InfoValue>> values() {
        return statics.values();
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
           for (Map.Entry<EdgeField, ImmutableSet<InfoValue>> edgeFieldValues : this.statics.entrySet()) {
               if (!(edgeFieldValues.getValue().equals(that.statics.get(edgeFieldValues.getKey())))) {
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

    Statics minus(Statics that) {
        Statics statics = new Statics();
        for (Map.Entry<EdgeField, ImmutableSet<InfoValue>> edgeFieldValues : this.statics.entrySet()) {
            EdgeField edgeField = edgeFieldValues.getKey();
            HashSet<InfoValue> values = new HashSet<InfoValue>(edgeFieldValues.getValue());
            values.removeAll(that.get(edgeField));
            statics.putS(edgeField.entryEdge, edgeField.field, ImmutableSet.<InfoValue>copyOf(values));
        }
        return statics;
    }
}

class State {
    Locals locals;
    Instances instances;
    Arrays arrays;
    Statics statics;

    State(Locals locals, Instances instances, Arrays arrays, Statics statics) {
        assert locals != null && instances != null && arrays != null && statics != null;
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
    
    State minus(State that) {
        return new State(this.locals.minus(that.locals), this.instances.minus(that.instances), this.arrays.minus(that.arrays), this.statics.minus(that.statics));
    }
}

class Address implements InfoValue, Comparable<Address> {
    private static Map<AllocNode, Address> allocNodeToAddress = new HashMap<AllocNode, Address>();

    private final AllocNode allocNode;

    private Address(AllocNode allocNode) {
        assert allocNode != null;
        this.allocNode = allocNode;
    }

    public static Address v(AllocNode allocNode) {
        assert allocNode != null;
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
}
