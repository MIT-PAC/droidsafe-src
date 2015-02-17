package droidsafe.analyses.infoflow;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang3.tuple.ImmutablePair;

import com.google.common.collect.ImmutableSet;

import droidsafe.main.Config;
import droidsafe.utils.JimpleRelationships;
import soot.Context;
import soot.Local;
import soot.SootField;
import soot.SootMethod;
import soot.jimple.Expr;
import soot.jimple.Stmt;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.toolkits.pta.IAllocNode;
import soot.toolkits.graph.Block;

class ContextLocal {
    private static final HashMap<ImmutablePair<Context, Local>, ContextLocal> cache = new HashMap<ImmutablePair<Context, Local>, ContextLocal>();

    static void invalidateCache() {
        ContextLocal.cache.clear();
    }

    Context context;
    Local local;

    private ContextLocal(Context context, Local local) {
        assert local != null;
        this.context = context;
        this.local = local;
    }

    static ContextLocal v(Context context, Local local) {
        ImmutablePair<Context, Local> key = ImmutablePair.of(context, local);
        ContextLocal value = ContextLocal.cache.get(key);
        if (value == null) {
            value = new ContextLocal(context, local);
            ContextLocal.cache.put(key, value);
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

        return this.local.equals(that.local) && ((this.context == null && that.context == null) || (this.context != null && this.context.equals(that.context)));
    }

    @Override
    public int hashCode() {
        return 31 * (31 * 17 + (this.context != null ? this.context.hashCode() : 0)) + this.local.hashCode();
    }

    @Override
    public String toString() {
        return "(" + this.context + ", " + this.local + ")";
    }
}

class Locals {
    static final Locals EMPTY = new Locals();

    private DefaultHashMap<ContextLocal, ImmutableSet<InfoValue>> contextLocalToValues;

    Locals() {
        this.contextLocalToValues = new DefaultHashMap<ContextLocal, ImmutableSet<InfoValue>>(ImmutableSet.<InfoValue>of());
    }

    Locals(Locals that) {
        this.contextLocalToValues = new DefaultHashMap<ContextLocal, ImmutableSet<InfoValue>>(that.contextLocalToValues);
    }

    ImmutableSet<InfoValue> putS(ContextLocal contextLocal, ImmutableSet<InfoValue> values) {
        if (values != null && !values.isEmpty()) {
            return this.contextLocalToValues.put(contextLocal, values);
        } else {
            return this.contextLocalToValues.remove(contextLocal);
        }
    }

    ImmutableSet<InfoValue> putS(Context context, Local local, ImmutableSet<InfoValue> values) {
        return putS(ContextLocal.v(context, local), values);
    }

    ImmutableSet<InfoValue> putS(Context context, Local local, HashSet<InfoValue> values) {
        return putS(ContextLocal.v(context, local), ImmutableSet.<InfoValue>copyOf(values));
    }


    ImmutableSet<InfoValue> putW(ContextLocal contextLocal, ImmutableSet<InfoValue> values) {
        ImmutableSet<InfoValue> oldValues = this.contextLocalToValues.get(contextLocal);
        if (values != null && !values.isEmpty()) {
            HashSet<InfoValue> newValues = new HashSet<InfoValue>(oldValues);
            newValues.addAll(values);
            return this.contextLocalToValues.put(contextLocal, ImmutableSet.<InfoValue>copyOf(newValues));
        } else {
            return oldValues;
        }
    }

    ImmutableSet<InfoValue> putW(Context context, Local local, ImmutableSet<InfoValue>values) {
        return putW(ContextLocal.v(context,  local), values);
    }
    
    ImmutableSet<InfoValue> putW(Context context, Local local, HashSet<InfoValue> values) {
        return putW(ContextLocal.v(context,  local), ImmutableSet.<InfoValue>copyOf(values));
    }
    
    private ImmutableSet<InfoValue> remove(ContextLocal contextLocal) {
        return this.contextLocalToValues.remove(contextLocal);
    }

    ImmutableSet<InfoValue> remove(Context context, Local local) {
        return remove(ContextLocal.v(context, local));
    }

    private ImmutableSet<InfoValue> get(ContextLocal contextLocal) {
        return this.contextLocalToValues.get(contextLocal);
    }

    ImmutableSet<InfoValue> get(Context context, Local local) {
        return get(ContextLocal.v(context, local));
    }

    void printContextLocals(String tgtValue, Writer writer) throws IOException {
        assert Config.v().infoFlowValues != null;
        for (Map.Entry<ContextLocal, ImmutableSet<InfoValue>> contextLocalValues : this.contextLocalToValues.entrySet()) {
            ImmutableSet<InfoValue> values = contextLocalValues.getValue();
            for (InfoValue value : values) {
                if (value.toString().equals(tgtValue)) {
                    writer.write("|LOCAL|");
                    ContextLocal contextLocal = contextLocalValues.getKey();
                    Local local = contextLocal.local;
                    SootMethod method = InformationFlowAnalysis.v().superControlFlowGraph.localToMethod.get(local);
                    writer.write(" |METHOD| " + (method != null ? method.toString() : "null"));
                    writer.write(" |LOCAL| " + local);
                    writer.write(" |CONTEXT| " + contextLocal.context);
                    writer.write('\n');
                    break;
                }
            }
        }
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
            for (Map.Entry<ContextLocal, ImmutableSet<InfoValue>> contextLocalValues : this.contextLocalToValues.entrySet()) {
                ContextLocal contextLocal = contextLocalValues.getKey();
                ImmutableSet<InfoValue> thisValues = contextLocalValues.getValue();
                ImmutableSet<InfoValue> thatValues = that.contextLocalToValues.get(contextLocal);
                if (!(thisValues.equals(thatValues))) {
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
    
    int size() {
        return this.contextLocalToValues.size();
    }
}

class AllocNodeField  {
    private static final HashMap<ImmutablePair<IAllocNode, SootField>, AllocNodeField> cache = new HashMap<ImmutablePair<IAllocNode, SootField>, AllocNodeField>();

    static void invalidateCache() {
        AllocNodeField.cache.clear();
    }

    IAllocNode allocNode;
    SootField field;

    private AllocNodeField(IAllocNode allocNode, SootField field) {
        assert allocNode != null && field != null;
        this.allocNode = allocNode;
        this.field = field;
    }

    static AllocNodeField v(IAllocNode allocNode, SootField field) {
        ImmutablePair<IAllocNode, SootField> key = ImmutablePair.of(allocNode, field);
        AllocNodeField allocNodeField = cache.get(key);
        if (allocNodeField == null) {
            allocNodeField = new AllocNodeField(allocNode, field);
            cache.put(key, allocNodeField);
        }
        return allocNodeField;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof AllocNodeField)) {
            return false;
        }
        AllocNodeField that = (AllocNodeField)object;

        return this.field.equals(that.field) && this.allocNode.equals(that.allocNode);
    }

    @Override
    public int hashCode() {
        return 31 * (31 * 7 + this.allocNode.hashCode()) + this.field.hashCode();
    }

    @Override
    public String toString() {
        return "(" + this.allocNode + ", " + this.field.getSignature() + ")";
    }
}

class Instances {
    private DefaultHashMap<AllocNodeField, ImmutableSet<InfoValue>> allocNodeFieldToValues;

    Instances() {
        this.allocNodeFieldToValues = new DefaultHashMap<AllocNodeField, ImmutableSet<InfoValue>>(ImmutableSet.<InfoValue>of());
    }

    Instances(Instances that) {
        this.allocNodeFieldToValues = new DefaultHashMap<AllocNodeField, ImmutableSet<InfoValue>>(that.allocNodeFieldToValues);
    }

    ImmutableSet<InfoValue> putS(AllocNodeField allocNodeField, ImmutableSet<InfoValue> values) {
        return this.allocNodeFieldToValues.put(allocNodeField, values);
    }

    ImmutableSet<InfoValue> putS(IAllocNode allocNode, SootField field, ImmutableSet<InfoValue> values) {
        return putS(AllocNodeField.v(allocNode, field), values);
    }

    ImmutableSet<InfoValue> putW(AllocNodeField allocNodeField, ImmutableSet<InfoValue> values) {
      ImmutableSet<InfoValue> oldValues = this.allocNodeFieldToValues.get(allocNodeField);
      if (values != null && !values.isEmpty()) {
          HashSet<InfoValue> newValues = new HashSet<InfoValue>(oldValues);
          newValues.addAll(values);
          return this.allocNodeFieldToValues.put(allocNodeField, ImmutableSet.<InfoValue>copyOf(newValues));
      } else {
          return oldValues;
      }
    }

    ImmutableSet<InfoValue> putW(IAllocNode allocNode, SootField field, ImmutableSet<InfoValue> values) {
        return putW(AllocNodeField.v(allocNode, field), values);
    }

    ImmutableSet<InfoValue> get(AllocNodeField allocNodeField) {
        return this.allocNodeFieldToValues.get(allocNodeField);
    }

    ImmutableSet<InfoValue> get(IAllocNode allocNode, SootField field) {
        return get(AllocNodeField.v(allocNode, field));
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

        if (this.allocNodeFieldToValues.size() != that.allocNodeFieldToValues.size()) {
            return false;
        }
        try {
            for (Map.Entry<AllocNodeField, ImmutableSet<InfoValue>> allocNodeFieldValues : this.allocNodeFieldToValues.entrySet()) {
                AllocNodeField allocNodeField = allocNodeFieldValues.getKey();
                ImmutableSet<InfoValue> thisValues = allocNodeFieldValues.getValue();
                ImmutableSet<InfoValue> thatValues = that.allocNodeFieldToValues.get(allocNodeField);
                if (!(thisValues.equals(thatValues))) {
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
    
    int size() {
        return this.allocNodeFieldToValues.size();
    }
    
    void printAllocNodeFields(String tgtValue, Writer writer) throws IOException {
        assert Config.v().infoFlowValues != null;
        for (Map.Entry<AllocNodeField, ImmutableSet<InfoValue>> allocNodeFieldValues : this.allocNodeFieldToValues.entrySet()) {
            ImmutableSet<InfoValue> values = allocNodeFieldValues.getValue();
            for (InfoValue value : values) {
                if (value.toString().equals(tgtValue)) {
                    writer.write("|INSTANCE|");
                    AllocNodeField allocNodeField = allocNodeFieldValues.getKey();
                    AllocNode allocNode = (AllocNode)allocNodeField.allocNode;
                    SootMethod method = allocNode.getMethod();
                    writer.write(" |METHOD| " + method);
                    Object newExpr = allocNode.getNewExpr();
                    if (newExpr instanceof Expr) {
                        Stmt stmt = JimpleRelationships.v().getEnclosingStmt((Expr)newExpr);
                        writer.write(" |STMT| " + stmt);
                    }
                    writer.write(" |ALLOCNODE| " + allocNode);
                    SootField field = allocNodeField.field;
                    writer.write(" |FIELD| " + field);
                    writer.write('\n');
                    break;
                }
            }
        }
    }
}

class Arrays {
    private DefaultHashMap<IAllocNode, ImmutableSet<InfoValue>> arrays;

    Arrays() {
        this.arrays = new DefaultHashMap<IAllocNode, ImmutableSet<InfoValue>>(ImmutableSet.<InfoValue>of());
    }

    Arrays(Arrays that) {
        this.arrays = new DefaultHashMap<IAllocNode, ImmutableSet<InfoValue>>(that.arrays);
    }

    ImmutableSet<InfoValue> putS(IAllocNode allocNode, ImmutableSet<InfoValue> values) {
        return this.arrays.put(allocNode, values);
    }

    ImmutableSet<InfoValue> putW(IAllocNode allocNode, ImmutableSet<InfoValue> values) {
        ImmutableSet<InfoValue> oldValues = this.arrays.get(allocNode);
        if (values != null && !values.isEmpty()) {
            HashSet<InfoValue> newValues = new HashSet<InfoValue>(oldValues);
            newValues.addAll(values);
            return this.arrays.put(allocNode, ImmutableSet.<InfoValue>copyOf(newValues));
        } else {
            return oldValues;
        }
    }

    ImmutableSet<InfoValue> get(IAllocNode allocNode) {
        return this.arrays.get(allocNode);
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
            for (Entry<IAllocNode, ImmutableSet<InfoValue>> allocNodeValues : this.arrays.entrySet()) {
                IAllocNode allocNode = allocNodeValues.getKey();
                ImmutableSet<InfoValue> thisValues = allocNodeValues.getValue();
                ImmutableSet<InfoValue> thatValues = that.arrays.get(allocNode);
                if (!(thisValues.equals(thatValues))) {
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
    
    int size() {
        return this.arrays.size();
    }
    
    void printAllocNodes(String tgtValue, Writer writer) throws IOException {
        assert Config.v().infoFlowValues != null;
        for (Map.Entry<IAllocNode, ImmutableSet<InfoValue>> allocNodeValues : this.arrays.entrySet()) {
            ImmutableSet<InfoValue> values = allocNodeValues.getValue();
            for (InfoValue value : values) {
                if (value.toString().equals(tgtValue)) {
                    writer.write("|ARRAY|");
                    AllocNode allocNode = (AllocNode)allocNodeValues.getKey();
                    SootMethod method = allocNode.getMethod();
                    writer.write(" |METHOD| " + method);
                    Object newExpr = allocNode.getNewExpr();
                    if (newExpr instanceof Expr) {
                        Stmt stmt = JimpleRelationships.v().getEnclosingStmt((Expr)newExpr);
                        writer.write(" |STMT| " + stmt);
                    }
                    writer.write(" |ALLOCNODE| " + allocNode);
                    writer.write('\n');
                    break;
                }
            }
        }
    }
}

class Statics {
    private DefaultHashMap<SootField, ImmutableSet<InfoValue>> statics;

    Statics() {
        this.statics = new DefaultHashMap<SootField, ImmutableSet<InfoValue>>(ImmutableSet.<InfoValue>of());
    }
    Statics(Statics that) {
        this.statics = new DefaultHashMap<SootField, ImmutableSet<InfoValue>>(that.statics);
    }

    ImmutableSet<InfoValue> putW(SootField field, ImmutableSet<InfoValue> values) {
        ImmutableSet<InfoValue> oldValues = this.statics.get(field);
        if (values != null && !values.isEmpty()) {
            HashSet<InfoValue> newValues = new HashSet<InfoValue>(oldValues);
            newValues.addAll(values);
            return this.statics.put(field, ImmutableSet.<InfoValue>copyOf(newValues));
        } else {
            return oldValues;
        }
    }

    ImmutableSet<InfoValue> get(SootField field) {
        return this.statics.get(field);
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
            for (Map.Entry<SootField, ImmutableSet<InfoValue>> fieldValues : this.statics.entrySet()) {
                SootField field = fieldValues.getKey();
                ImmutableSet<InfoValue> thisValues = fieldValues.getValue();
                ImmutableSet<InfoValue> thatValues = that.statics.get(field);
                if (!(thisValues.equals(thatValues))) {
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
    
    int size() {
        return this.statics.size();
    }
    
    void printFields(String tgtValue, Writer writer) throws IOException {
        assert Config.v().infoFlowValues != null;
        for (Map.Entry<SootField, ImmutableSet<InfoValue>> fieldValues : this.statics.entrySet()) {
            ImmutableSet<InfoValue> values = fieldValues.getValue();
            for (InfoValue value : values) {
                if (value.toString().equals(tgtValue)) {
                    writer.write("|STATIC|");
                    SootField field = fieldValues.getKey();
                    writer.write(" |FIELD| " + field);
                    writer.write('\n');
                    break;
                }
            }
        }
    }
}

class State {
    Locals locals;
    Instances instances;
    Arrays arrays;
    Statics statics;
    HashMap<Block, Set<InfoValue>> iflows;

    State() {
        this.locals = new Locals();
        this.instances = new Instances();
        this.arrays = new Arrays();
        this.statics = new Statics();
        this.iflows = new HashMap<Block, Set<InfoValue>>();
    }

    State(State that) {
        this.locals = new Locals(that.locals);
        this.instances = new Instances(that.instances);
        this.arrays = new Arrays(that.arrays);
        this.statics = new Statics(that.statics);
        this.iflows = new HashMap<Block, Set<InfoValue>>(that.iflows);
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

        return this.locals.equals(that.locals) && this.instances.equals(that.instances) 
        		&& this.arrays.equals(that.arrays) && this.statics.equals(that.statics) &&
        		this.iflows.equals(that.iflows);
    }
}