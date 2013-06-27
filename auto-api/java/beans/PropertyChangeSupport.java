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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.006 -0400", hash_original_field = "9403382C8BE8BF444B950899205C2500", hash_generated_field = "C4FC1B92735A56C9579E71916FC2FFF8")

    private transient Object sourceBean;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.006 -0400", hash_original_field = "C8AFA772AB39DB9A6080A66F42ACFC51", hash_generated_field = "13B011C46465CF2D1279D361F5E6B98B")

    private transient List<PropertyChangeListener> listeners = new CopyOnWriteArrayList<PropertyChangeListener>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.006 -0400", hash_original_method = "09D4558045FC0782254B0D972DDA4620", hash_generated_method = "39B1CDC484434CC2B0EED5F31CEF7956")
    public  PropertyChangeSupport(Object sourceBean) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        this.sourceBean = sourceBean;
        // ---------- Original Method ----------
        //if (sourceBean == null) {
            //throw new NullPointerException();
        //}
        //this.sourceBean = sourceBean;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.007 -0400", hash_original_method = "D1E4CD5A5886FF38C6EBB02BBA228540", hash_generated_method = "843D9BCAABAF7A5E080EA06427EE2F50")
    public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
        firePropertyChange(new PropertyChangeEvent(sourceBean, propertyName, oldValue, newValue));
        addTaint(propertyName.getTaint());
        addTaint(oldValue.getTaint());
        addTaint(newValue.getTaint());
        // ---------- Original Method ----------
        //firePropertyChange(new PropertyChangeEvent(sourceBean, propertyName, oldValue, newValue));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.007 -0400", hash_original_method = "A0BCBFEE8B29A622C3E205B05C4F1C89", hash_generated_method = "173F6B6472614DDEF16A9FD9FCF4B71C")
    public void fireIndexedPropertyChange(String propertyName, int index,
            Object oldValue, Object newValue) {
        firePropertyChange(new IndexedPropertyChangeEvent(sourceBean,
                propertyName, oldValue, newValue, index));
        addTaint(propertyName.getTaint());
        addTaint(index);
        addTaint(oldValue.getTaint());
        addTaint(newValue.getTaint());
        // ---------- Original Method ----------
        //firePropertyChange(new IndexedPropertyChangeEvent(sourceBean,
                //propertyName, oldValue, newValue, index));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.033 -0400", hash_original_method = "0EBF9025D0E458F5C219DE65A639C89B", hash_generated_method = "1D6974C8270026BC4995712B46E522D9")
    public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        {
            Iterator<PropertyChangeListener> var2EF0AB58C6C68BCCEAD203841EAE48D2_640202466 = (listeners).iterator();
            var2EF0AB58C6C68BCCEAD203841EAE48D2_640202466.hasNext();
            PropertyChangeListener p = var2EF0AB58C6C68BCCEAD203841EAE48D2_640202466.next();
            {
                {
                    boolean var897B663CD4C4CB6BA8F6D1044DCEC033_226055022 = (equals(propertyName, listener, p));
                    {
                        listeners.remove(p);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(propertyName.getTaint());
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //for (PropertyChangeListener p : listeners) {
            //if (equals(propertyName, listener, p)) {
                //listeners.remove(p);
                //return;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.034 -0400", hash_original_method = "A38B8477985ECBF9EAC6EDFBD5290064", hash_generated_method = "76EA393B4D617CFF3DC81E2F3CFAF44B")
    private boolean equals(String aName, EventListener a, EventListener b) {
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
                boolean var3A6BDFDC1FE549AF952A757BBA045BB6_48729592 = (!Objects.equal(aName, bName));
            } //End collapsed parenthetic
            aName = null;
        } //End block
        boolean var41C279D4F3CBC6C06EF0AAC866E76EA0_1952918698 = (aName == null && Objects.equal(a, b));
        addTaint(aName.getTaint());
        addTaint(a.getTaint());
        addTaint(b.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_480243317 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_480243317;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.035 -0400", hash_original_method = "930FBD19A78990F5C4E139AC4C6BB362", hash_generated_method = "4DFD8864531EBC6CE256C082F56E5929")
    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        {
            listeners.add(new PropertyChangeListenerProxy(propertyName, listener));
        } //End block
        addTaint(propertyName.getTaint());
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //if (listener != null && propertyName != null) {
            //listeners.add(new PropertyChangeListenerProxy(propertyName, listener));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.087 -0400", hash_original_method = "00BBD2172CC9916DE5C9C28A0EEFE748", hash_generated_method = "61E5A17320DF3FF44B798A5D9273B3B0")
    public PropertyChangeListener[] getPropertyChangeListeners(String propertyName) {
        PropertyChangeListener[] varB4EAC82CA7396A68D541C85D26508E83_1186114367 = null; //Variable for return #1
        List<PropertyChangeListener> result;
        result = new ArrayList<PropertyChangeListener>();
        {
            Iterator<PropertyChangeListener> var2EF0AB58C6C68BCCEAD203841EAE48D2_73531042 = (listeners).iterator();
            var2EF0AB58C6C68BCCEAD203841EAE48D2_73531042.hasNext();
            PropertyChangeListener p = var2EF0AB58C6C68BCCEAD203841EAE48D2_73531042.next();
            {
                {
                    boolean varAE522C398F4F52E8D2E17642AC1E3980_1617797780 = (p instanceof PropertyChangeListenerProxy && Objects.equal(
                    propertyName, ((PropertyChangeListenerProxy) p).getPropertyName()));
                    {
                        result.add(p);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1186114367 = result.toArray(new PropertyChangeListener[result.size()]);
        addTaint(propertyName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1186114367.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1186114367;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.087 -0400", hash_original_method = "94226D71E0146D875204CC2A0C5CDB43", hash_generated_method = "0CD9F2061F93F73FC815BDE760A43283")
    public void firePropertyChange(String propertyName, boolean oldValue, boolean newValue) {
        firePropertyChange(propertyName, Boolean.valueOf(oldValue), Boolean.valueOf(newValue));
        addTaint(propertyName.getTaint());
        addTaint(oldValue);
        addTaint(newValue);
        // ---------- Original Method ----------
        //firePropertyChange(propertyName, Boolean.valueOf(oldValue), Boolean.valueOf(newValue));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.088 -0400", hash_original_method = "FA6574139DFC76BE59E80FCDD5F143D2", hash_generated_method = "FEEADF74314959CC26A86A67CC2C5503")
    public void fireIndexedPropertyChange(String propertyName, int index,
            boolean oldValue, boolean newValue) {
        {
            fireIndexedPropertyChange(propertyName, index,
                    Boolean.valueOf(oldValue), Boolean.valueOf(newValue));
        } //End block
        addTaint(propertyName.getTaint());
        addTaint(index);
        addTaint(oldValue);
        addTaint(newValue);
        // ---------- Original Method ----------
        //if (oldValue != newValue) {
            //fireIndexedPropertyChange(propertyName, index,
                    //Boolean.valueOf(oldValue), Boolean.valueOf(newValue));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.088 -0400", hash_original_method = "4552BA18F0B2B2784BB1DA1C74165B61", hash_generated_method = "3D5982FB43F085F080CFDE1E81FDBB24")
    public void firePropertyChange(String propertyName, int oldValue, int newValue) {
        firePropertyChange(propertyName, Integer.valueOf(oldValue), Integer.valueOf(newValue));
        addTaint(propertyName.getTaint());
        addTaint(oldValue);
        addTaint(newValue);
        // ---------- Original Method ----------
        //firePropertyChange(propertyName, Integer.valueOf(oldValue), Integer.valueOf(newValue));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.088 -0400", hash_original_method = "9EC839909A8D5EF002D63B05CCF8C26F", hash_generated_method = "FB8BC9BCDBBB4E9F98315DFD2CD60A68")
    public void fireIndexedPropertyChange(String propertyName, int index,
            int oldValue, int newValue) {
        {
            fireIndexedPropertyChange(propertyName, index,
                    Integer.valueOf(oldValue), Integer.valueOf(newValue));
        } //End block
        addTaint(propertyName.getTaint());
        addTaint(index);
        addTaint(oldValue);
        addTaint(newValue);
        // ---------- Original Method ----------
        //if (oldValue != newValue) {
            //fireIndexedPropertyChange(propertyName, index,
                    //Integer.valueOf(oldValue), Integer.valueOf(newValue));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.117 -0400", hash_original_method = "610737304108759554633F933F40913E", hash_generated_method = "299E1D0205D2699CE67FF48F13BE2145")
    public boolean hasListeners(String propertyName) {
        {
            Iterator<PropertyChangeListener> var2EF0AB58C6C68BCCEAD203841EAE48D2_1550594254 = (listeners).iterator();
            var2EF0AB58C6C68BCCEAD203841EAE48D2_1550594254.hasNext();
            PropertyChangeListener p = var2EF0AB58C6C68BCCEAD203841EAE48D2_1550594254.next();
            {
                {
                    boolean varC6683AE05AE205EEBE7DE3E77BC1203D_376026614 = (!(p instanceof PropertyChangeListenerProxy) || Objects.equal(
                    propertyName, ((PropertyChangeListenerProxy) p).getPropertyName()));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(propertyName.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_59849486 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_59849486;
        // ---------- Original Method ----------
        //for (PropertyChangeListener p : listeners) {
            //if (!(p instanceof PropertyChangeListenerProxy) || Objects.equal(
                    //propertyName, ((PropertyChangeListenerProxy) p).getPropertyName())) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.166 -0400", hash_original_method = "4F7D9482670A9321D94398F71FD2BB67", hash_generated_method = "CC3B80CB4D640F91827498B88C61571B")
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        {
            Iterator<PropertyChangeListener> var2EF0AB58C6C68BCCEAD203841EAE48D2_364430382 = (listeners).iterator();
            var2EF0AB58C6C68BCCEAD203841EAE48D2_364430382.hasNext();
            PropertyChangeListener p = var2EF0AB58C6C68BCCEAD203841EAE48D2_364430382.next();
            {
                {
                    boolean var3BC5A6B93A29BCE34F0CAE9616E5C283_1886055963 = (equals(null, listener, p));
                    {
                        listeners.remove(p);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //for (PropertyChangeListener p : listeners) {
            //if (equals(null, listener, p)) {
                //listeners.remove(p);
                //return;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.167 -0400", hash_original_method = "A89A578774CE20B40D54565B383BCFA8", hash_generated_method = "0F8527006327BA3F52BAC57816C45971")
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        {
            listeners.add(listener);
        } //End block
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //if (listener != null) {
            //listeners.add(listener);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.167 -0400", hash_original_method = "20AEE88E0780907A1527FDFF7FD94398", hash_generated_method = "BBF205CB562C88A35D29C316AF02FFF2")
    public PropertyChangeListener[] getPropertyChangeListeners() {
        PropertyChangeListener[] varB4EAC82CA7396A68D541C85D26508E83_1845304077 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1845304077 = listeners.toArray(new PropertyChangeListener[0]);
        varB4EAC82CA7396A68D541C85D26508E83_1845304077.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1845304077;
        // ---------- Original Method ----------
        //return listeners.toArray(new PropertyChangeListener[0]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.246 -0400", hash_original_method = "2B46BB9E8064A4DB5FBAF8D8B87BA3A9", hash_generated_method = "BF9CCF1301C16155DEB4D377914F9020")
    private void writeObject(ObjectOutputStream out) throws IOException {
        Map<String, PropertyChangeSupport> map;
        map = new Hashtable<String, PropertyChangeSupport>();
        {
            Iterator<PropertyChangeListener> var2EF0AB58C6C68BCCEAD203841EAE48D2_270863503 = (listeners).iterator();
            var2EF0AB58C6C68BCCEAD203841EAE48D2_270863503.hasNext();
            PropertyChangeListener p = var2EF0AB58C6C68BCCEAD203841EAE48D2_270863503.next();
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
            Iterator<PropertyChangeListener> var2EF0AB58C6C68BCCEAD203841EAE48D2_2514120 = (listeners).iterator();
            var2EF0AB58C6C68BCCEAD203841EAE48D2_2514120.hasNext();
            PropertyChangeListener p = var2EF0AB58C6C68BCCEAD203841EAE48D2_2514120.next();
            {
                {
                    out.writeObject(p);
                } //End block
            } //End block
        } //End collapsed parenthetic
        out.writeObject(null);
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.368 -0400", hash_original_method = "CF711F06198DA67AA575F0B0D8CAC00C", hash_generated_method = "15CED657D9AF2D2ED1F3A4C0C0DCF08D")
    @SuppressWarnings("unchecked")
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField readFields;
        readFields = in.readFields();
        sourceBean = readFields.get("source", null);
        listeners = new CopyOnWriteArrayList<PropertyChangeListener>();
        Map<String, PropertyChangeSupport> children;
        children = (Map<String, PropertyChangeSupport>) readFields.get("children", null);
        {
            {
                Iterator<Map.Entry<String, PropertyChangeSupport>> var2252B949334EC1D3A32F8AF79DB6E578_1706371870 = (children.entrySet()).iterator();
                var2252B949334EC1D3A32F8AF79DB6E578_1706371870.hasNext();
                Map.Entry<String, PropertyChangeSupport> entry = var2252B949334EC1D3A32F8AF79DB6E578_1706371870.next();
                {
                    {
                        Iterator<PropertyChangeListener> varCEC0968346B069DFE30CD20B98B4E2C0_1854512144 = (entry.getValue().listeners).iterator();
                        varCEC0968346B069DFE30CD20B98B4E2C0_1854512144.hasNext();
                        PropertyChangeListener p = varCEC0968346B069DFE30CD20B98B4E2C0_1854512144.next();
                        {
                            listeners.add(new PropertyChangeListenerProxy(entry.getKey(), p));
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        PropertyChangeListener listener;
        {
            boolean var66B95270497A7267E90227CA86A4BDCB_885894542 = ((listener = (PropertyChangeListener) in.readObject()) != null);
            {
                listeners.add(listener);
            } //End block
        } //End collapsed parenthetic
        addTaint(in.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.421 -0400", hash_original_method = "DE96EEBF0F3556789E0EE7EC3C8C89E3", hash_generated_method = "B8F31F8D443D88F6D87271B5194FFB21")
    public void firePropertyChange(PropertyChangeEvent event) {
        String propertyName;
        propertyName = event.getPropertyName();
        Object oldValue;
        oldValue = event.getOldValue();
        Object newValue;
        newValue = event.getNewValue();
        {
            boolean var528E4634B4B1D2E9EA48F357A05A1813_1834951944 = (newValue != null && oldValue != null && newValue.equals(oldValue));
        } //End collapsed parenthetic
        {
            Iterator<PropertyChangeListener> var2EF0AB58C6C68BCCEAD203841EAE48D2_358527264 = (listeners).iterator();
            var2EF0AB58C6C68BCCEAD203841EAE48D2_358527264.hasNext();
            PropertyChangeListener p = var2EF0AB58C6C68BCCEAD203841EAE48D2_358527264.next();
            {
                {
                    PropertyChangeListenerProxy proxy;
                    proxy = (PropertyChangeListenerProxy) p;
                    {
                        boolean varB68E3ECE4D43BF3B63B0B4947E649B49_81240739 = (!Objects.equal(proxy.getPropertyName(), propertyName));
                    } //End collapsed parenthetic
                    p = (PropertyChangeListener) proxy.getListener();
                } //End block
                p.propertyChange(event);
            } //End block
        } //End collapsed parenthetic
        addTaint(event.getTaint());
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.421 -0400", hash_original_field = "2C6C732DF3D1290F7C668084A8539FB1", hash_generated_field = "114945CBB1AFFEABCC385B72B836FA53")

    private static long serialVersionUID = 6401253773779951803l;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.421 -0400", hash_original_field = "8DCC5B1B2AAC1C0FEA60100A42EA9662", hash_generated_field = "D5A170EB5DA81CEF077F0EE83A32273F")

    private static ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("source", Object.class),
        new ObjectStreamField("children", Object.class),
        new ObjectStreamField("propertyChangeSupportSerializedDataVersion", int.class),
    };
}

