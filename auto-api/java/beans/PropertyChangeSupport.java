package java.beans;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    private transient Object sourceBean;
    private transient List<PropertyChangeListener> listeners
            = new CopyOnWriteArrayList<PropertyChangeListener>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.343 -0400", hash_original_method = "09D4558045FC0782254B0D972DDA4620", hash_generated_method = "25EAF0B3E588940C4CBF4626DF00B138")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PropertyChangeSupport(Object sourceBean) {
        dsTaint.addTaint(sourceBean.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        // ---------- Original Method ----------
        //if (sourceBean == null) {
            //throw new NullPointerException();
        //}
        //this.sourceBean = sourceBean;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.343 -0400", hash_original_method = "D1E4CD5A5886FF38C6EBB02BBA228540", hash_generated_method = "8AA5C883CD2203B1FA9EA1A7C58D3CF4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
        dsTaint.addTaint(propertyName);
        dsTaint.addTaint(newValue.dsTaint);
        dsTaint.addTaint(oldValue.dsTaint);
        firePropertyChange(new PropertyChangeEvent(sourceBean, propertyName, oldValue, newValue));
        // ---------- Original Method ----------
        //firePropertyChange(new PropertyChangeEvent(sourceBean, propertyName, oldValue, newValue));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.343 -0400", hash_original_method = "A0BCBFEE8B29A622C3E205B05C4F1C89", hash_generated_method = "11664F07174A7793C9BA64CF7932758B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void fireIndexedPropertyChange(String propertyName, int index,
            Object oldValue, Object newValue) {
        dsTaint.addTaint(propertyName);
        dsTaint.addTaint(newValue.dsTaint);
        dsTaint.addTaint(index);
        dsTaint.addTaint(oldValue.dsTaint);
        firePropertyChange(new IndexedPropertyChangeEvent(sourceBean,
                propertyName, oldValue, newValue, index));
        // ---------- Original Method ----------
        //firePropertyChange(new IndexedPropertyChangeEvent(sourceBean,
                //propertyName, oldValue, newValue, index));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.348 -0400", hash_original_method = "0EBF9025D0E458F5C219DE65A639C89B", hash_generated_method = "0E511D9668CBBD86099F5EE61476E150")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        dsTaint.addTaint(propertyName);
        dsTaint.addTaint(listener.dsTaint);
        {
            Iterator<PropertyChangeListener> var2EF0AB58C6C68BCCEAD203841EAE48D2_1276078662 = (listeners).iterator();
            var2EF0AB58C6C68BCCEAD203841EAE48D2_1276078662.hasNext();
            PropertyChangeListener p = var2EF0AB58C6C68BCCEAD203841EAE48D2_1276078662.next();
            {
                {
                    boolean var897B663CD4C4CB6BA8F6D1044DCEC033_1043651265 = (equals(propertyName, listener, p));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.349 -0400", hash_original_method = "A38B8477985ECBF9EAC6EDFBD5290064", hash_generated_method = "8E0E58B1FEFED242D8C2FFCF4C7E02EA")
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
                boolean var3A6BDFDC1FE549AF952A757BBA045BB6_1680154699 = (!Objects.equal(aName, bName));
            } //End collapsed parenthetic
            aName = null;
        } //End block
        boolean var41C279D4F3CBC6C06EF0AAC866E76EA0_415898934 = (aName == null && Objects.equal(a, b));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.349 -0400", hash_original_method = "930FBD19A78990F5C4E139AC4C6BB362", hash_generated_method = "24B88AE5B9CC7A2F644D5F163562323A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.357 -0400", hash_original_method = "00BBD2172CC9916DE5C9C28A0EEFE748", hash_generated_method = "A150B539417ABF40498905444CA17F28")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PropertyChangeListener[] getPropertyChangeListeners(String propertyName) {
        dsTaint.addTaint(propertyName);
        List<PropertyChangeListener> result;
        result = new ArrayList<PropertyChangeListener>();
        {
            Iterator<PropertyChangeListener> var2EF0AB58C6C68BCCEAD203841EAE48D2_713392637 = (listeners).iterator();
            var2EF0AB58C6C68BCCEAD203841EAE48D2_713392637.hasNext();
            PropertyChangeListener p = var2EF0AB58C6C68BCCEAD203841EAE48D2_713392637.next();
            {
                {
                    boolean varAE522C398F4F52E8D2E17642AC1E3980_1014275237 = (p instanceof PropertyChangeListenerProxy && Objects.equal(
                    propertyName, ((PropertyChangeListenerProxy) p).getPropertyName()));
                    {
                        result.add(p);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        PropertyChangeListener[] var9D118B967079476A6048E3B55CD691FB_54458260 = (result.toArray(new PropertyChangeListener[result.size()]));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.357 -0400", hash_original_method = "94226D71E0146D875204CC2A0C5CDB43", hash_generated_method = "C0BD34B385B95BD5051878063F1ABA80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void firePropertyChange(String propertyName, boolean oldValue, boolean newValue) {
        dsTaint.addTaint(propertyName);
        dsTaint.addTaint(newValue);
        dsTaint.addTaint(oldValue);
        firePropertyChange(propertyName, Boolean.valueOf(oldValue), Boolean.valueOf(newValue));
        // ---------- Original Method ----------
        //firePropertyChange(propertyName, Boolean.valueOf(oldValue), Boolean.valueOf(newValue));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.357 -0400", hash_original_method = "FA6574139DFC76BE59E80FCDD5F143D2", hash_generated_method = "FAF921220ED23A39C0D7F903D1B1B1E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void fireIndexedPropertyChange(String propertyName, int index,
            boolean oldValue, boolean newValue) {
        dsTaint.addTaint(propertyName);
        dsTaint.addTaint(newValue);
        dsTaint.addTaint(index);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.358 -0400", hash_original_method = "4552BA18F0B2B2784BB1DA1C74165B61", hash_generated_method = "19F066AF4181C7DCBE96915BA87C9210")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void firePropertyChange(String propertyName, int oldValue, int newValue) {
        dsTaint.addTaint(propertyName);
        dsTaint.addTaint(newValue);
        dsTaint.addTaint(oldValue);
        firePropertyChange(propertyName, Integer.valueOf(oldValue), Integer.valueOf(newValue));
        // ---------- Original Method ----------
        //firePropertyChange(propertyName, Integer.valueOf(oldValue), Integer.valueOf(newValue));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.358 -0400", hash_original_method = "9EC839909A8D5EF002D63B05CCF8C26F", hash_generated_method = "22D2AD041D637BF74CB93ECFF4E1AED7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void fireIndexedPropertyChange(String propertyName, int index,
            int oldValue, int newValue) {
        dsTaint.addTaint(propertyName);
        dsTaint.addTaint(newValue);
        dsTaint.addTaint(index);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.360 -0400", hash_original_method = "610737304108759554633F933F40913E", hash_generated_method = "A2F8A2B96895D1E9832F3ADD648CF538")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasListeners(String propertyName) {
        dsTaint.addTaint(propertyName);
        {
            Iterator<PropertyChangeListener> var2EF0AB58C6C68BCCEAD203841EAE48D2_1771733675 = (listeners).iterator();
            var2EF0AB58C6C68BCCEAD203841EAE48D2_1771733675.hasNext();
            PropertyChangeListener p = var2EF0AB58C6C68BCCEAD203841EAE48D2_1771733675.next();
            {
                {
                    boolean varC6683AE05AE205EEBE7DE3E77BC1203D_1753911074 = (!(p instanceof PropertyChangeListenerProxy) || Objects.equal(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.363 -0400", hash_original_method = "4F7D9482670A9321D94398F71FD2BB67", hash_generated_method = "F0A1054A74D3CD0F30281C996DA8CD5B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        {
            Iterator<PropertyChangeListener> var2EF0AB58C6C68BCCEAD203841EAE48D2_1208014287 = (listeners).iterator();
            var2EF0AB58C6C68BCCEAD203841EAE48D2_1208014287.hasNext();
            PropertyChangeListener p = var2EF0AB58C6C68BCCEAD203841EAE48D2_1208014287.next();
            {
                {
                    boolean var3BC5A6B93A29BCE34F0CAE9616E5C283_498956307 = (equals(null, listener, p));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.363 -0400", hash_original_method = "A89A578774CE20B40D54565B383BCFA8", hash_generated_method = "AF7060955222C62F91DD93730CD104FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.363 -0400", hash_original_method = "20AEE88E0780907A1527FDFF7FD94398", hash_generated_method = "FC61500A2B9AD0CEA7E78AF51F6E39C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PropertyChangeListener[] getPropertyChangeListeners() {
        PropertyChangeListener[] var4466635FC56A12094E725EF14ED2C01B_1323561718 = (listeners.toArray(new PropertyChangeListener[0]));
        return (PropertyChangeListener[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return listeners.toArray(new PropertyChangeListener[0]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.368 -0400", hash_original_method = "2B46BB9E8064A4DB5FBAF8D8B87BA3A9", hash_generated_method = "AE591C942C00133505D2D5F8C6C328A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeObject(ObjectOutputStream out) throws IOException {
        dsTaint.addTaint(out.dsTaint);
        Map<String, PropertyChangeSupport> map;
        map = new Hashtable<String, PropertyChangeSupport>();
        {
            Iterator<PropertyChangeListener> var2EF0AB58C6C68BCCEAD203841EAE48D2_862745410 = (listeners).iterator();
            var2EF0AB58C6C68BCCEAD203841EAE48D2_862745410.hasNext();
            PropertyChangeListener p = var2EF0AB58C6C68BCCEAD203841EAE48D2_862745410.next();
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
            Iterator<PropertyChangeListener> var2EF0AB58C6C68BCCEAD203841EAE48D2_962061702 = (listeners).iterator();
            var2EF0AB58C6C68BCCEAD203841EAE48D2_962061702.hasNext();
            PropertyChangeListener p = var2EF0AB58C6C68BCCEAD203841EAE48D2_962061702.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.373 -0400", hash_original_method = "CF711F06198DA67AA575F0B0D8CAC00C", hash_generated_method = "945CCCEC41376023F9ED3F98A69DD41D")
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
                Iterator<Map.Entry<String, PropertyChangeSupport>> var2252B949334EC1D3A32F8AF79DB6E578_949128043 = (children.entrySet()).iterator();
                var2252B949334EC1D3A32F8AF79DB6E578_949128043.hasNext();
                Map.Entry<String, PropertyChangeSupport> entry = var2252B949334EC1D3A32F8AF79DB6E578_949128043.next();
                {
                    {
                        Iterator<PropertyChangeListener> varCEC0968346B069DFE30CD20B98B4E2C0_409146169 = (entry.getValue().listeners).iterator();
                        varCEC0968346B069DFE30CD20B98B4E2C0_409146169.hasNext();
                        PropertyChangeListener p = varCEC0968346B069DFE30CD20B98B4E2C0_409146169.next();
                        {
                            listeners.add(new PropertyChangeListenerProxy(entry.getKey(), p));
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        PropertyChangeListener listener;
        {
            boolean var66B95270497A7267E90227CA86A4BDCB_374243512 = ((listener = (PropertyChangeListener) in.readObject()) != null);
            {
                listeners.add(listener);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.379 -0400", hash_original_method = "DE96EEBF0F3556789E0EE7EC3C8C89E3", hash_generated_method = "96390BD8EE5860785D9A9F9746659D8A")
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
            boolean var528E4634B4B1D2E9EA48F357A05A1813_29956821 = (newValue != null && oldValue != null && newValue.equals(oldValue));
        } //End collapsed parenthetic
        {
            Iterator<PropertyChangeListener> var2EF0AB58C6C68BCCEAD203841EAE48D2_1817842183 = (listeners).iterator();
            var2EF0AB58C6C68BCCEAD203841EAE48D2_1817842183.hasNext();
            PropertyChangeListener p = var2EF0AB58C6C68BCCEAD203841EAE48D2_1817842183.next();
            {
                {
                    PropertyChangeListenerProxy proxy;
                    proxy = (PropertyChangeListenerProxy) p;
                    {
                        boolean varB68E3ECE4D43BF3B63B0B4947E649B49_448283489 = (!Objects.equal(proxy.getPropertyName(), propertyName));
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

    
    private static final long serialVersionUID = 6401253773779951803l;
    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("source", Object.class),
        new ObjectStreamField("children", Object.class),
        new ObjectStreamField("propertyChangeSupportSerializedDataVersion", int.class),
    };
}

