package java.beans;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

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
    private static final long serialVersionUID = 6401253773779951803l;
    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("source", Object.class),
        new ObjectStreamField("children", Object.class),
        new ObjectStreamField("propertyChangeSupportSerializedDataVersion", int.class),
    };
    private transient Object sourceBean;
    private transient List<PropertyChangeListener> listeners
            = new CopyOnWriteArrayList<PropertyChangeListener>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.359 -0400", hash_original_method = "09D4558045FC0782254B0D972DDA4620", hash_generated_method = "0EA9A94DD2C9C87BC736E4CB6D9FA3AD")
    @DSModeled(DSC.SAFE)
    public PropertyChangeSupport(Object sourceBean) {
        dsTaint.addTaint(sourceBean.dsTaint);
        {
            throw new NullPointerException();
        } //End block
        // ---------- Original Method ----------
        //if (sourceBean == null) {
            //throw new NullPointerException();
        //}
        //this.sourceBean = sourceBean;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.360 -0400", hash_original_method = "D1E4CD5A5886FF38C6EBB02BBA228540", hash_generated_method = "21D9D7BC88376A30F3873B4A8F5029BF")
    @DSModeled(DSC.SAFE)
    public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
        dsTaint.addTaint(propertyName);
        dsTaint.addTaint(newValue.dsTaint);
        dsTaint.addTaint(oldValue.dsTaint);
        firePropertyChange(new PropertyChangeEvent(sourceBean, propertyName, oldValue, newValue));
        // ---------- Original Method ----------
        //firePropertyChange(new PropertyChangeEvent(sourceBean, propertyName, oldValue, newValue));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.360 -0400", hash_original_method = "A0BCBFEE8B29A622C3E205B05C4F1C89", hash_generated_method = "ABF6D868727D1CE76C51E63DAF8DBBF8")
    @DSModeled(DSC.SAFE)
    public void fireIndexedPropertyChange(String propertyName, int index,
            Object oldValue, Object newValue) {
        dsTaint.addTaint(propertyName);
        dsTaint.addTaint(index);
        dsTaint.addTaint(newValue.dsTaint);
        dsTaint.addTaint(oldValue.dsTaint);
        firePropertyChange(new IndexedPropertyChangeEvent(sourceBean,
                propertyName, oldValue, newValue, index));
        // ---------- Original Method ----------
        //firePropertyChange(new IndexedPropertyChangeEvent(sourceBean,
                //propertyName, oldValue, newValue, index));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.360 -0400", hash_original_method = "0EBF9025D0E458F5C219DE65A639C89B", hash_generated_method = "D526F2451E57F4740DB2B2D9B21A0D69")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        dsTaint.addTaint(propertyName);
        dsTaint.addTaint(listener.dsTaint);
        {
            Iterator<PropertyChangeListener> seatecAstronomy42 = listeners.iterator();
            seatecAstronomy42.hasNext();
            PropertyChangeListener p = seatecAstronomy42.next();
            {
                {
                    boolean var897B663CD4C4CB6BA8F6D1044DCEC033_905049790 = (equals(propertyName, listener, p));
                    {
                        listeners.remove(p);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (PropertyChangeListener p : listeners) {
            //if (equals(propertyName, listener, p)) {
                //listeners.remove(p);
                //return;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.360 -0400", hash_original_method = "A38B8477985ECBF9EAC6EDFBD5290064", hash_generated_method = "4D9F25774ECBDF27DE5AA7C508924FF9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean equals(String aName, EventListener a, EventListener b) {
        dsTaint.addTaint(aName);
        dsTaint.addTaint(b.dsTaint);
        dsTaint.addTaint(a.dsTaint);
        {
            PropertyChangeListenerProxy bProxy;
            bProxy = (PropertyChangeListenerProxy) b;
            String bName;
            bName = bProxy.getPropertyName();
            b = bProxy.getListener();
            {
                PropertyChangeListenerProxy aProxy;
                aProxy = (PropertyChangeListenerProxy) a;
                aName = aProxy.getPropertyName();
                a = aProxy.getListener();
            } //End block
            {
                boolean var3A6BDFDC1FE549AF952A757BBA045BB6_1509906187 = (!Objects.equal(aName, bName));
            } //End collapsed parenthetic
            aName = null;
        } //End block
        boolean var41C279D4F3CBC6C06EF0AAC866E76EA0_733174750 = (aName == null && Objects.equal(a, b));
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.360 -0400", hash_original_method = "930FBD19A78990F5C4E139AC4C6BB362", hash_generated_method = "53A560591834EF0F16AAD9D28BF75A22")
    @DSModeled(DSC.SAFE)
    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        dsTaint.addTaint(propertyName);
        dsTaint.addTaint(listener.dsTaint);
        {
            listeners.add(new PropertyChangeListenerProxy(propertyName, listener));
        } //End block
        // ---------- Original Method ----------
        //if (listener != null && propertyName != null) {
            //listeners.add(new PropertyChangeListenerProxy(propertyName, listener));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.360 -0400", hash_original_method = "00BBD2172CC9916DE5C9C28A0EEFE748", hash_generated_method = "E7E693BCFC1B646E901CAD80073CF20D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PropertyChangeListener[] getPropertyChangeListeners(String propertyName) {
        dsTaint.addTaint(propertyName);
        List<PropertyChangeListener> result;
        result = new ArrayList<PropertyChangeListener>();
        {
            Iterator<PropertyChangeListener> seatecAstronomy42 = listeners.iterator();
            seatecAstronomy42.hasNext();
            PropertyChangeListener p = seatecAstronomy42.next();
            {
                {
                    boolean varAE522C398F4F52E8D2E17642AC1E3980_2086641918 = (p instanceof PropertyChangeListenerProxy && Objects.equal(
                    propertyName, ((PropertyChangeListenerProxy) p).getPropertyName()));
                    {
                        result.add(p);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        PropertyChangeListener[] var9D118B967079476A6048E3B55CD691FB_1278518292 = (result.toArray(new PropertyChangeListener[result.size()]));
        return (PropertyChangeListener[])dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.360 -0400", hash_original_method = "94226D71E0146D875204CC2A0C5CDB43", hash_generated_method = "D5A3D26E426E5FF1D6DBC98931DC46E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void firePropertyChange(String propertyName, boolean oldValue, boolean newValue) {
        dsTaint.addTaint(propertyName);
        dsTaint.addTaint(newValue);
        dsTaint.addTaint(oldValue);
        firePropertyChange(propertyName, Boolean.valueOf(oldValue), Boolean.valueOf(newValue));
        // ---------- Original Method ----------
        //firePropertyChange(propertyName, Boolean.valueOf(oldValue), Boolean.valueOf(newValue));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.360 -0400", hash_original_method = "FA6574139DFC76BE59E80FCDD5F143D2", hash_generated_method = "2A299725E3C505E4CBEA7530113BF013")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void fireIndexedPropertyChange(String propertyName, int index,
            boolean oldValue, boolean newValue) {
        dsTaint.addTaint(propertyName);
        dsTaint.addTaint(index);
        dsTaint.addTaint(newValue);
        dsTaint.addTaint(oldValue);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.360 -0400", hash_original_method = "4552BA18F0B2B2784BB1DA1C74165B61", hash_generated_method = "D92D32305860EAC16777C255332C6D18")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void firePropertyChange(String propertyName, int oldValue, int newValue) {
        dsTaint.addTaint(propertyName);
        dsTaint.addTaint(newValue);
        dsTaint.addTaint(oldValue);
        firePropertyChange(propertyName, Integer.valueOf(oldValue), Integer.valueOf(newValue));
        // ---------- Original Method ----------
        //firePropertyChange(propertyName, Integer.valueOf(oldValue), Integer.valueOf(newValue));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.360 -0400", hash_original_method = "9EC839909A8D5EF002D63B05CCF8C26F", hash_generated_method = "77A720A8B88CBF702FEA27EB4A36B83F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void fireIndexedPropertyChange(String propertyName, int index,
            int oldValue, int newValue) {
        dsTaint.addTaint(propertyName);
        dsTaint.addTaint(index);
        dsTaint.addTaint(newValue);
        dsTaint.addTaint(oldValue);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.361 -0400", hash_original_method = "610737304108759554633F933F40913E", hash_generated_method = "DF0ABF2D3CC5721969A5F05B793B301B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasListeners(String propertyName) {
        dsTaint.addTaint(propertyName);
        {
            Iterator<PropertyChangeListener> seatecAstronomy42 = listeners.iterator();
            seatecAstronomy42.hasNext();
            PropertyChangeListener p = seatecAstronomy42.next();
            {
                {
                    boolean varC6683AE05AE205EEBE7DE3E77BC1203D_1102687243 = (!(p instanceof PropertyChangeListenerProxy) || Objects.equal(
                    propertyName, ((PropertyChangeListenerProxy) p).getPropertyName()));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //for (PropertyChangeListener p : listeners) {
            //if (!(p instanceof PropertyChangeListenerProxy) || Objects.equal(
                    //propertyName, ((PropertyChangeListenerProxy) p).getPropertyName())) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.361 -0400", hash_original_method = "4F7D9482670A9321D94398F71FD2BB67", hash_generated_method = "DFE0945B835460197FBB757CD7CA1D93")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        {
            Iterator<PropertyChangeListener> seatecAstronomy42 = listeners.iterator();
            seatecAstronomy42.hasNext();
            PropertyChangeListener p = seatecAstronomy42.next();
            {
                {
                    boolean var3BC5A6B93A29BCE34F0CAE9616E5C283_1207881022 = (equals(null, listener, p));
                    {
                        listeners.remove(p);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (PropertyChangeListener p : listeners) {
            //if (equals(null, listener, p)) {
                //listeners.remove(p);
                //return;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.361 -0400", hash_original_method = "A89A578774CE20B40D54565B383BCFA8", hash_generated_method = "B1EFAF30A2358C15E1E2FB0D13A8431F")
    @DSModeled(DSC.SAFE)
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        {
            listeners.add(listener);
        } //End block
        // ---------- Original Method ----------
        //if (listener != null) {
            //listeners.add(listener);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.361 -0400", hash_original_method = "20AEE88E0780907A1527FDFF7FD94398", hash_generated_method = "FFDB852CF7784903D8ABD6FEC9F00AB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PropertyChangeListener[] getPropertyChangeListeners() {
        PropertyChangeListener[] var4466635FC56A12094E725EF14ED2C01B_1302544930 = (listeners.toArray(new PropertyChangeListener[0]));
        return (PropertyChangeListener[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return listeners.toArray(new PropertyChangeListener[0]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.361 -0400", hash_original_method = "2B46BB9E8064A4DB5FBAF8D8B87BA3A9", hash_generated_method = "8FB07A2CD0994A71EC64AA3735A0C390")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeObject(ObjectOutputStream out) throws IOException {
        dsTaint.addTaint(out.dsTaint);
        Map<String, PropertyChangeSupport> map;
        map = new Hashtable<String, PropertyChangeSupport>();
        {
            Iterator<PropertyChangeListener> seatecAstronomy42 = listeners.iterator();
            seatecAstronomy42.hasNext();
            PropertyChangeListener p = seatecAstronomy42.next();
            {
                {
                    PropertyChangeListenerProxy proxy;
                    proxy = (PropertyChangeListenerProxy) p;
                    PropertyChangeListener listener;
                    listener = (PropertyChangeListener) proxy.getListener();
                    {
                        PropertyChangeSupport list;
                        list = map.get(proxy.getPropertyName());
                        {
                            list = new PropertyChangeSupport(sourceBean);
                            map.put(proxy.getPropertyName(), list);
                        } //End block
                        list.listeners.add(listener);
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        ObjectOutputStream.PutField putFields;
        putFields = out.putFields();
        putFields.put("source", sourceBean);
        putFields.put("children", map);
        out.writeFields();
        {
            Iterator<PropertyChangeListener> seatecAstronomy42 = listeners.iterator();
            seatecAstronomy42.hasNext();
            PropertyChangeListener p = seatecAstronomy42.next();
            {
                {
                    out.writeObject(p);
                } //End block
            } //End block
        } //End collapsed parenthetic
        out.writeObject(null);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.361 -0400", hash_original_method = "CF711F06198DA67AA575F0B0D8CAC00C", hash_generated_method = "03645C25BEADDC30FAE048E41BCA7258")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        dsTaint.addTaint(in.dsTaint);
        ObjectInputStream.GetField readFields;
        readFields = in.readFields();
        sourceBean = readFields.get("source", null);
        listeners = new CopyOnWriteArrayList<PropertyChangeListener>();
        Map<String, PropertyChangeSupport> children;
        children = (Map<String, PropertyChangeSupport>) readFields.get("children", null);
        {
            {
                Iterator<Map.Entry<String, PropertyChangeSupport>> seatecAstronomy42 = children.entrySet().iterator();
                seatecAstronomy42.hasNext();
                Map.Entry<String, PropertyChangeSupport> entry = seatecAstronomy42.next();
                {
                    {
                        PropertyChangeListener p = entry.getValue().listeners.get(0);
                        {
                            listeners.add(new PropertyChangeListenerProxy(entry.getKey(), p));
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        PropertyChangeListener listener;
        {
            boolean var66B95270497A7267E90227CA86A4BDCB_1109101224 = ((listener = (PropertyChangeListener) in.readObject()) != null);
            {
                listeners.add(listener);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.361 -0400", hash_original_method = "DE96EEBF0F3556789E0EE7EC3C8C89E3", hash_generated_method = "45C9DBEB683455B252A32FF3DF28F5BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void firePropertyChange(PropertyChangeEvent event) {
        dsTaint.addTaint(event.dsTaint);
        String propertyName;
        propertyName = event.getPropertyName();
        Object oldValue;
        oldValue = event.getOldValue();
        Object newValue;
        newValue = event.getNewValue();
        {
            boolean var528E4634B4B1D2E9EA48F357A05A1813_91185404 = (newValue != null && oldValue != null && newValue.equals(oldValue));
        } //End collapsed parenthetic
        {
            Iterator<PropertyChangeListener> seatecAstronomy42 = listeners.iterator();
            seatecAstronomy42.hasNext();
            PropertyChangeListener p = seatecAstronomy42.next();
            {
                {
                    PropertyChangeListenerProxy proxy;
                    proxy = (PropertyChangeListenerProxy) p;
                    {
                        boolean varB68E3ECE4D43BF3B63B0B4947E649B49_1040673339 = (!Objects.equal(proxy.getPropertyName(), propertyName));
                    } //End collapsed parenthetic
                    p = (PropertyChangeListener) proxy.getListener();
                } //End block
                p.propertyChange(event);
            } //End block
        } //End collapsed parenthetic
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

    
}


