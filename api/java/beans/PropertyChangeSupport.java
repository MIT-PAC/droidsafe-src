package java.beans;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import libcore.util.Objects;

public class PropertyChangeSupport implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.181 -0400", hash_original_field = "9403382C8BE8BF444B950899205C2500", hash_generated_field = "C4FC1B92735A56C9579E71916FC2FFF8")

    private transient Object sourceBean;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.181 -0400", hash_original_field = "C8AFA772AB39DB9A6080A66F42ACFC51", hash_generated_field = "13B011C46465CF2D1279D361F5E6B98B")

    private transient List<PropertyChangeListener> listeners = new CopyOnWriteArrayList<PropertyChangeListener>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.182 -0400", hash_original_method = "09D4558045FC0782254B0D972DDA4620", hash_generated_method = "85510C3ADE807BE52C694DB0EDED7C22")
    public  PropertyChangeSupport(Object sourceBean) {
        if(sourceBean == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_761429852 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_761429852.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_761429852;
        } //End block
        this.sourceBean = sourceBean;
        // ---------- Original Method ----------
        //if (sourceBean == null) {
            //throw new NullPointerException();
        //}
        //this.sourceBean = sourceBean;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.182 -0400", hash_original_method = "D1E4CD5A5886FF38C6EBB02BBA228540", hash_generated_method = "6D9D5F96AB343F4C70381CC74E1BC1DF")
    public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
        addTaint(newValue.getTaint());
        addTaint(oldValue.getTaint());
        addTaint(propertyName.getTaint());
        firePropertyChange(new PropertyChangeEvent(sourceBean, propertyName, oldValue, newValue));
        // ---------- Original Method ----------
        //firePropertyChange(new PropertyChangeEvent(sourceBean, propertyName, oldValue, newValue));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.183 -0400", hash_original_method = "A0BCBFEE8B29A622C3E205B05C4F1C89", hash_generated_method = "89491ECC60ECE6D9DEC053DE46F832EC")
    public void fireIndexedPropertyChange(String propertyName, int index,
            Object oldValue, Object newValue) {
        addTaint(newValue.getTaint());
        addTaint(oldValue.getTaint());
        addTaint(index);
        addTaint(propertyName.getTaint());
        firePropertyChange(new IndexedPropertyChangeEvent(sourceBean,
                propertyName, oldValue, newValue, index));
        // ---------- Original Method ----------
        //firePropertyChange(new IndexedPropertyChangeEvent(sourceBean,
                //propertyName, oldValue, newValue, index));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.183 -0400", hash_original_method = "0EBF9025D0E458F5C219DE65A639C89B", hash_generated_method = "9C1100870BD815C46324C478361CD17A")
    public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        addTaint(listener.getTaint());
        addTaint(propertyName.getTaint());
for(PropertyChangeListener p : listeners)
        {
            if(equals(propertyName, listener, p))            
            {
                listeners.remove(p);
                return;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //for (PropertyChangeListener p : listeners) {
            //if (equals(propertyName, listener, p)) {
                //listeners.remove(p);
                //return;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.184 -0400", hash_original_method = "A38B8477985ECBF9EAC6EDFBD5290064", hash_generated_method = "587BA60AA0828CCF3E1A987A38764CD3")
    private boolean equals(String aName, EventListener a, EventListener b) {
        addTaint(b.getTaint());
        addTaint(a.getTaint());
        addTaint(aName.getTaint());
        while
(b instanceof PropertyChangeListenerProxy)        
        {
            PropertyChangeListenerProxy bProxy = (PropertyChangeListenerProxy) b;
            String bName = bProxy.getPropertyName();
            b = bProxy.getListener();
            if(aName == null)            
            {
                if(!(a instanceof PropertyChangeListenerProxy))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_200060172 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_815705166 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_815705166;
                } //End block
                PropertyChangeListenerProxy aProxy = (PropertyChangeListenerProxy) a;
                aName = aProxy.getPropertyName();
                a = aProxy.getListener();
            } //End block
            if(!Objects.equal(aName, bName))            
            {
                boolean var68934A3E9455FA72420237EB05902327_737554672 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1871522433 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1871522433;
            } //End block
            aName = null;
        } //End block
        boolean var881BE61EA94846CE7E8F42516504422F_327247195 = (aName == null && Objects.equal(a, b));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_121680366 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_121680366;
        // ---------- Original Method ----------
        //while (b instanceof PropertyChangeListenerProxy) {
            //PropertyChangeListenerProxy bProxy = (PropertyChangeListenerProxy) b; 
            //String bName = bProxy.getPropertyName();
            //b = bProxy.getListener();
            //if (aName == null) {
                //if (!(a instanceof PropertyChangeListenerProxy)) {
                    //return false;
                //}
                //PropertyChangeListenerProxy aProxy = (PropertyChangeListenerProxy) a; 
                //aName = aProxy.getPropertyName();
                //a = aProxy.getListener();
            //}
            //if (!Objects.equal(aName, bName)) {
                //return false; 
            //}
            //aName = null;
        //}
        //return aName == null && Objects.equal(a, b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.185 -0400", hash_original_method = "930FBD19A78990F5C4E139AC4C6BB362", hash_generated_method = "2E18155DA94EEAFA64498D8BACADF7DF")
    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        addTaint(listener.getTaint());
        addTaint(propertyName.getTaint());
        if(listener != null && propertyName != null)        
        {
            listeners.add(new PropertyChangeListenerProxy(propertyName, listener));
        } //End block
        // ---------- Original Method ----------
        //if (listener != null && propertyName != null) {
            //listeners.add(new PropertyChangeListenerProxy(propertyName, listener));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.186 -0400", hash_original_method = "00BBD2172CC9916DE5C9C28A0EEFE748", hash_generated_method = "6CD255F9C5A450FE082494B0D97FE57C")
    public PropertyChangeListener[] getPropertyChangeListeners(String propertyName) {
        addTaint(propertyName.getTaint());
        List<PropertyChangeListener> result = new ArrayList<PropertyChangeListener>();
for(PropertyChangeListener p : listeners)
        {
            if(p instanceof PropertyChangeListenerProxy && Objects.equal(
                    propertyName, ((PropertyChangeListenerProxy) p).getPropertyName()))            
            {
                result.add(p);
            } //End block
        } //End block
PropertyChangeListener[] varF0EACBCF567A9F951330FD2EA45DDC95_1899880797 =         result.toArray(new PropertyChangeListener[result.size()]);
        varF0EACBCF567A9F951330FD2EA45DDC95_1899880797.addTaint(taint);
        return varF0EACBCF567A9F951330FD2EA45DDC95_1899880797;
        // ---------- Original Method ----------
        //List<PropertyChangeListener> result = new ArrayList<PropertyChangeListener>();
        //for (PropertyChangeListener p : listeners) {
            //if (p instanceof PropertyChangeListenerProxy && Objects.equal(
                    //propertyName, ((PropertyChangeListenerProxy) p).getPropertyName())) {
                //result.add(p);
            //}
        //}
        //return result.toArray(new PropertyChangeListener[result.size()]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.187 -0400", hash_original_method = "94226D71E0146D875204CC2A0C5CDB43", hash_generated_method = "40DDF6D8D350A3B3156E59F89172B298")
    public void firePropertyChange(String propertyName, boolean oldValue, boolean newValue) {
        addTaint(newValue);
        addTaint(oldValue);
        addTaint(propertyName.getTaint());
        firePropertyChange(propertyName, Boolean.valueOf(oldValue), Boolean.valueOf(newValue));
        // ---------- Original Method ----------
        //firePropertyChange(propertyName, Boolean.valueOf(oldValue), Boolean.valueOf(newValue));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.187 -0400", hash_original_method = "FA6574139DFC76BE59E80FCDD5F143D2", hash_generated_method = "10F9132FED8DCACCC1A074030947780D")
    public void fireIndexedPropertyChange(String propertyName, int index,
            boolean oldValue, boolean newValue) {
        addTaint(newValue);
        addTaint(oldValue);
        addTaint(index);
        addTaint(propertyName.getTaint());
        if(oldValue != newValue)        
        {
            fireIndexedPropertyChange(propertyName, index,
                    Boolean.valueOf(oldValue), Boolean.valueOf(newValue));
        } //End block
        // ---------- Original Method ----------
        //if (oldValue != newValue) {
            //fireIndexedPropertyChange(propertyName, index,
                    //Boolean.valueOf(oldValue), Boolean.valueOf(newValue));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.187 -0400", hash_original_method = "4552BA18F0B2B2784BB1DA1C74165B61", hash_generated_method = "A372750564831C34C268A3F8269A25CD")
    public void firePropertyChange(String propertyName, int oldValue, int newValue) {
        addTaint(newValue);
        addTaint(oldValue);
        addTaint(propertyName.getTaint());
        firePropertyChange(propertyName, Integer.valueOf(oldValue), Integer.valueOf(newValue));
        // ---------- Original Method ----------
        //firePropertyChange(propertyName, Integer.valueOf(oldValue), Integer.valueOf(newValue));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.187 -0400", hash_original_method = "9EC839909A8D5EF002D63B05CCF8C26F", hash_generated_method = "7649C52BA939BE15865F9CD35A0E91A4")
    public void fireIndexedPropertyChange(String propertyName, int index,
            int oldValue, int newValue) {
        addTaint(newValue);
        addTaint(oldValue);
        addTaint(index);
        addTaint(propertyName.getTaint());
        if(oldValue != newValue)        
        {
            fireIndexedPropertyChange(propertyName, index,
                    Integer.valueOf(oldValue), Integer.valueOf(newValue));
        } //End block
        // ---------- Original Method ----------
        //if (oldValue != newValue) {
            //fireIndexedPropertyChange(propertyName, index,
                    //Integer.valueOf(oldValue), Integer.valueOf(newValue));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.188 -0400", hash_original_method = "610737304108759554633F933F40913E", hash_generated_method = "D3F03920FD483AF40C4922E5D75CC334")
    public boolean hasListeners(String propertyName) {
        addTaint(propertyName.getTaint());
for(PropertyChangeListener p : listeners)
        {
            if(!(p instanceof PropertyChangeListenerProxy) || Objects.equal(
                    propertyName, ((PropertyChangeListenerProxy) p).getPropertyName()))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_718501681 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1252373558 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1252373558;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1421789910 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1281067978 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1281067978;
        // ---------- Original Method ----------
        //for (PropertyChangeListener p : listeners) {
            //if (!(p instanceof PropertyChangeListenerProxy) || Objects.equal(
                    //propertyName, ((PropertyChangeListenerProxy) p).getPropertyName())) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.189 -0400", hash_original_method = "4F7D9482670A9321D94398F71FD2BB67", hash_generated_method = "BC6E7C4D8BA01B8D08E4CB4989BBEC6B")
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        addTaint(listener.getTaint());
for(PropertyChangeListener p : listeners)
        {
            if(equals(null, listener, p))            
            {
                listeners.remove(p);
                return;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //for (PropertyChangeListener p : listeners) {
            //if (equals(null, listener, p)) {
                //listeners.remove(p);
                //return;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.189 -0400", hash_original_method = "A89A578774CE20B40D54565B383BCFA8", hash_generated_method = "053A4FEBF983A83CDE3127A17D07F16B")
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        addTaint(listener.getTaint());
        if(listener != null)        
        {
            listeners.add(listener);
        } //End block
        // ---------- Original Method ----------
        //if (listener != null) {
            //listeners.add(listener);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.189 -0400", hash_original_method = "20AEE88E0780907A1527FDFF7FD94398", hash_generated_method = "4076F66BC625309D7F7497174F92048E")
    public PropertyChangeListener[] getPropertyChangeListeners() {
PropertyChangeListener[] var8E8BCC75E96F024B72E78A7CD5C9975D_635972848 =         listeners.toArray(new PropertyChangeListener[0]);
        var8E8BCC75E96F024B72E78A7CD5C9975D_635972848.addTaint(taint);
        return var8E8BCC75E96F024B72E78A7CD5C9975D_635972848;
        // ---------- Original Method ----------
        //return listeners.toArray(new PropertyChangeListener[0]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.189 -0400", hash_original_method = "2B46BB9E8064A4DB5FBAF8D8B87BA3A9", hash_generated_method = "7642612CFDC1008E79030C52170B316C")
    private void writeObject(ObjectOutputStream out) throws IOException {
        addTaint(out.getTaint());
        Map<String, PropertyChangeSupport> map = new Hashtable<String, PropertyChangeSupport>();
for(PropertyChangeListener p : listeners)
        {
            if(p instanceof PropertyChangeListenerProxy && !(p instanceof Serializable))            
            {
                PropertyChangeListenerProxy proxy = (PropertyChangeListenerProxy) p;
                PropertyChangeListener listener = (PropertyChangeListener) proxy.getListener();
                if(listener instanceof Serializable)                
                {
                    PropertyChangeSupport list = map.get(proxy.getPropertyName());
                    if(list == null)                    
                    {
                        list = new PropertyChangeSupport(sourceBean);
                        map.put(proxy.getPropertyName(), list);
                    } //End block
                    list.listeners.add(listener);
                } //End block
            } //End block
        } //End block
        ObjectOutputStream.PutField putFields = out.putFields();
        putFields.put("source", sourceBean);
        putFields.put("children", map);
        out.writeFields();
for(PropertyChangeListener p : listeners)
        {
            if(p instanceof Serializable)            
            {
                out.writeObject(p);
            } //End block
        } //End block
        out.writeObject(null);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.190 -0400", hash_original_method = "CF711F06198DA67AA575F0B0D8CAC00C", hash_generated_method = "FC956BF2F2FC6D617370C9B5BA962084")
    @SuppressWarnings("unchecked")
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        addTaint(in.getTaint());
        ObjectInputStream.GetField readFields = in.readFields();
        sourceBean = readFields.get("source", null);
        listeners = new CopyOnWriteArrayList<PropertyChangeListener>();
        Map<String, PropertyChangeSupport> children = (Map<String, PropertyChangeSupport>) readFields.get("children", null);
        if(children != null)        
        {
for(Map.Entry<String, PropertyChangeSupport> entry : children.entrySet())
            {
for(PropertyChangeListener p : entry.getValue().listeners)
                {
                    listeners.add(new PropertyChangeListenerProxy(entry.getKey(), p));
                } //End block
            } //End block
        } //End block
        PropertyChangeListener listener;
        while
((listener = (PropertyChangeListener) in.readObject()) != null)        
        {
            listeners.add(listener);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.190 -0400", hash_original_method = "DE96EEBF0F3556789E0EE7EC3C8C89E3", hash_generated_method = "FF40E0C70B70131388F2D6A0BB7132CE")
    public void firePropertyChange(PropertyChangeEvent event) {
        addTaint(event.getTaint());
        String propertyName = event.getPropertyName();
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
        if(newValue != null && oldValue != null && newValue.equals(oldValue))        
        {
            return;
        } //End block
        notifyEachListener        :
for(PropertyChangeListener p : listeners)
        {
            while
(p instanceof PropertyChangeListenerProxy)            
            {
                PropertyChangeListenerProxy proxy = (PropertyChangeListenerProxy) p;
                if(!Objects.equal(proxy.getPropertyName(), propertyName))                
                {
                    continue notifyEachListener;
                } //End block
                p = (PropertyChangeListener) proxy.getListener();
            } //End block
            p.propertyChange(event);
        } //End block
        // ---------- Original Method ----------
        //String propertyName = event.getPropertyName();
        //Object oldValue = event.getOldValue();
        //Object newValue = event.getNewValue();
        //if (newValue != null && oldValue != null && newValue.equals(oldValue)) {
            //return;
        //}
        //notifyEachListener:
        //for (PropertyChangeListener p : listeners) {
            //while (p instanceof PropertyChangeListenerProxy) {
                //PropertyChangeListenerProxy proxy = (PropertyChangeListenerProxy) p;
                //if (!Objects.equal(proxy.getPropertyName(), propertyName)) {
                    //continue notifyEachListener;
                //}
                //p = (PropertyChangeListener) proxy.getListener();
            //}
            //p.propertyChange(event);
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.191 -0400", hash_original_field = "2C6C732DF3D1290F7C668084A8539FB1", hash_generated_field = "A48B1648CDA8E4C2690D9A8D916781AA")

    private static final long serialVersionUID = 6401253773779951803l;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.191 -0400", hash_original_field = "8DCC5B1B2AAC1C0FEA60100A42EA9662", hash_generated_field = "1971F9E630460B6A7EA7F81588D7F7D1")

    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("source", Object.class),
        new ObjectStreamField("children", Object.class),
        new ObjectStreamField("propertyChangeSupportSerializedDataVersion", int.class),
    };
}

