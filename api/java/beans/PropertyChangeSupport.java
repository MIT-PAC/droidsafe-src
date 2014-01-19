package java.beans;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.435 -0500", hash_original_field = "7F45435A85DB6970CD266585EE9099E0", hash_generated_field = "A48B1648CDA8E4C2690D9A8D916781AA")

    private static final long serialVersionUID = 6401253773779951803l;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.439 -0500", hash_original_field = "D7CED9D2EA315F5E04B6143AA1156FC3", hash_generated_field = "1971F9E630460B6A7EA7F81588D7F7D1")

    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("source", Object.class),
        new ObjectStreamField("children", Object.class),
        new ObjectStreamField("propertyChangeSupportSerializedDataVersion", int.class),
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.441 -0500", hash_original_field = "F055581026D36C36805717A9901B0CA0", hash_generated_field = "C4FC1B92735A56C9579E71916FC2FFF8")

    private transient Object sourceBean;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.444 -0500", hash_original_field = "9A03797089C5BCB294E29E999DE6BA13", hash_generated_field = "13B011C46465CF2D1279D361F5E6B98B")

    private transient List<PropertyChangeListener> listeners
            = new CopyOnWriteArrayList<PropertyChangeListener>();

    /**
     * Creates a new instance that uses the source bean as source for any event.
     *
     * @param sourceBean
     *            the bean used as source for all events.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.447 -0500", hash_original_method = "09D4558045FC0782254B0D972DDA4620", hash_generated_method = "E1EE394D1A61777FB4D9A7601F314391")
    
public PropertyChangeSupport(Object sourceBean) {
        if (sourceBean == null) {
            throw new NullPointerException();
        }
        this.sourceBean = sourceBean;
    }

    /**
     * Fires a {@link PropertyChangeEvent} with the given name, old value and
     * new value. As source the bean used to initialize this instance is used.
     * If the old value and the new value are not null and equal the event will
     * not be fired.
     *
     * @param propertyName
     *            the name of the property
     * @param oldValue
     *            the old value of the property
     * @param newValue
     *            the new value of the property
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.449 -0500", hash_original_method = "D1E4CD5A5886FF38C6EBB02BBA228540", hash_generated_method = "4500F7D7B96139FC9F339E7E9B7D4B8F")
    
public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
        firePropertyChange(new PropertyChangeEvent(sourceBean, propertyName, oldValue, newValue));
    }

    /**
     * Fires an {@link IndexedPropertyChangeEvent} with the given name, old
     * value, new value and index. As source the bean used to initialize this
     * instance is used. If the old value and the new value are not null and
     * equal the event will not be fired.
     *
     * @param propertyName
     *            the name of the property
     * @param index
     *            the index
     * @param oldValue
     *            the old value of the property
     * @param newValue
     *            the new value of the property
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.451 -0500", hash_original_method = "A0BCBFEE8B29A622C3E205B05C4F1C89", hash_generated_method = "8E071AFF7AA0FEBA4391E859234A5842")
    
public void fireIndexedPropertyChange(String propertyName, int index,
            Object oldValue, Object newValue) {
        firePropertyChange(new IndexedPropertyChangeEvent(sourceBean,
                propertyName, oldValue, newValue, index));
    }

    /**
     * Unsubscribes {@code listener} from change notifications for the property
     * named {@code propertyName}. If multiple subscriptions exist for {@code
     * listener}, it will receive one fewer notifications when the property
     * changes. If the property name or listener is null or not subscribed, this
     * method silently does nothing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.454 -0500", hash_original_method = "0EBF9025D0E458F5C219DE65A639C89B", hash_generated_method = "F9340CDAB020CDE17574AC2ED0931761")
    
public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        for (PropertyChangeListener p : listeners) {
            if (equals(propertyName, listener, p)) {
                listeners.remove(p);
                return;
            }
        }
    }

    /**
     * Returns true if two chains of PropertyChangeListenerProxies have the same
     * names in the same order and bottom out in the same event listener. This
     * method's signature is asymmetric to avoid allocating a proxy: if
     * non-null, {@code aName} represents the first property name and {@code a}
     * is its listener.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.456 -0500", hash_original_method = "A38B8477985ECBF9EAC6EDFBD5290064", hash_generated_method = "7F70B7EBC33CEF5EF493D6A553ED7861")
    
private boolean equals(String aName, EventListener a, EventListener b) {
        /*
         * Each iteration of the loop attempts to match a pair of property names
         * from a and b. If they don't match, the chains must not be equal!
         */
        while (b instanceof PropertyChangeListenerProxy) {
            PropertyChangeListenerProxy bProxy = (PropertyChangeListenerProxy) b; // unwrap b
            String bName = bProxy.getPropertyName();
            b = bProxy.getListener();
            if (aName == null) {
                if (!(a instanceof PropertyChangeListenerProxy)) {
                    return false;
                }
                PropertyChangeListenerProxy aProxy = (PropertyChangeListenerProxy) a; // unwrap a
                aName = aProxy.getPropertyName();
                a = aProxy.getListener();
            }
            if (!Objects.equal(aName, bName)) {
                return false; // not equal; a and b subscribe to different properties
            }
            aName = null;
        }
        return aName == null && Objects.equal(a, b);
    }

    /**
     * Subscribes {@code listener} to change notifications for the property
     * named {@code propertyName}. If the listener is already subscribed, it
     * will receive an additional notification when the property changes. If the
     * property name or listener is null, this method silently does nothing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.459 -0500", hash_original_method = "930FBD19A78990F5C4E139AC4C6BB362", hash_generated_method = "6BAF42DE70446C5DF119E532761D4B7B")
    
public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        if (listener != null && propertyName != null) {
            listeners.add(new PropertyChangeListenerProxy(propertyName, listener));
        }
    }

    /**
     * Returns the subscribers to be notified when {@code propertyName} changes.
     * This includes both listeners subscribed to all property changes and
     * listeners subscribed to the named property only.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.462 -0500", hash_original_method = "00BBD2172CC9916DE5C9C28A0EEFE748", hash_generated_method = "BC5FA728DB99FC198A593276D73D77F1")
    
public PropertyChangeListener[] getPropertyChangeListeners(String propertyName) {
        List<PropertyChangeListener> result = new ArrayList<PropertyChangeListener>();
        for (PropertyChangeListener p : listeners) {
            if (p instanceof PropertyChangeListenerProxy && Objects.equal(
                    propertyName, ((PropertyChangeListenerProxy) p).getPropertyName())) {
                result.add(p);
            }
        }
        return result.toArray(new PropertyChangeListener[result.size()]);
    }

    /**
     * Fires a property change of a boolean property with the given name. If the
     * old value and the new value are not null and equal the event will not be
     * fired.
     *
     * @param propertyName
     *            the property name
     * @param oldValue
     *            the old value
     * @param newValue
     *            the new value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.465 -0500", hash_original_method = "94226D71E0146D875204CC2A0C5CDB43", hash_generated_method = "0E57D1215E56B565A5A9140D3D9229F7")
    
public void firePropertyChange(String propertyName, boolean oldValue, boolean newValue) {
        firePropertyChange(propertyName, Boolean.valueOf(oldValue), Boolean.valueOf(newValue));
    }

    /**
     * Fires a property change of a boolean property with the given name. If the
     * old value and the new value are not null and equal the event will not be
     * fired.
     *
     * @param propertyName
     *            the property name
     * @param index
     *            the index of the changed property
     * @param oldValue
     *            the old value
     * @param newValue
     *            the new value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.468 -0500", hash_original_method = "FA6574139DFC76BE59E80FCDD5F143D2", hash_generated_method = "714C647AB4A599AF52FFAB6E11C1DD6A")
    
public void fireIndexedPropertyChange(String propertyName, int index,
            boolean oldValue, boolean newValue) {
        if (oldValue != newValue) {
            fireIndexedPropertyChange(propertyName, index,
                    Boolean.valueOf(oldValue), Boolean.valueOf(newValue));
        }
    }

    /**
     * Fires a property change of an integer property with the given name. If
     * the old value and the new value are not null and equal the event will not
     * be fired.
     *
     * @param propertyName
     *            the property name
     * @param oldValue
     *            the old value
     * @param newValue
     *            the new value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.470 -0500", hash_original_method = "4552BA18F0B2B2784BB1DA1C74165B61", hash_generated_method = "694519006DA62B461A7E77A1249FEC18")
    
public void firePropertyChange(String propertyName, int oldValue, int newValue) {
        firePropertyChange(propertyName, Integer.valueOf(oldValue), Integer.valueOf(newValue));
    }

    /**
     * Fires a property change of an integer property with the given name. If
     * the old value and the new value are not null and equal the event will not
     * be fired.
     *
     * @param propertyName
     *            the property name
     * @param index
     *            the index of the changed property
     * @param oldValue
     *            the old value
     * @param newValue
     *            the new value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.473 -0500", hash_original_method = "9EC839909A8D5EF002D63B05CCF8C26F", hash_generated_method = "DF0229F21216314F348B00745AA102AF")
    
public void fireIndexedPropertyChange(String propertyName, int index,
            int oldValue, int newValue) {
        if (oldValue != newValue) {
            fireIndexedPropertyChange(propertyName, index,
                    Integer.valueOf(oldValue), Integer.valueOf(newValue));
        }
    }

    /**
     * Returns true if there are listeners registered to the property with the
     * given name.
     *
     * @param propertyName
     *            the name of the property
     * @return true if there are listeners registered to that property, false
     *         otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.475 -0500", hash_original_method = "610737304108759554633F933F40913E", hash_generated_method = "550FDCCC3D0D68E65A1A01B4F9B772A4")
    
public boolean hasListeners(String propertyName) {
        for (PropertyChangeListener p : listeners) {
            if (!(p instanceof PropertyChangeListenerProxy) || Objects.equal(
                    propertyName, ((PropertyChangeListenerProxy) p).getPropertyName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Unsubscribes {@code listener} from change notifications for all
     * properties. If the listener has multiple subscriptions, it will receive
     * one fewer notification when properties change. If the property name or
     * listener is null or not subscribed, this method silently does nothing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.478 -0500", hash_original_method = "4F7D9482670A9321D94398F71FD2BB67", hash_generated_method = "306FD9F325B4A1877C92AD3A1044E799")
    
public void removePropertyChangeListener(PropertyChangeListener listener) {
        for (PropertyChangeListener p : listeners) {
            if (equals(null, listener, p)) {
                listeners.remove(p);
                return;
            }
        }
    }

    /**
     * Subscribes {@code listener} to change notifications for all properties.
     * If the listener is already subscribed, it will receive an additional
     * notification. If the listener is null, this method silently does nothing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.480 -0500", hash_original_method = "A89A578774CE20B40D54565B383BCFA8", hash_generated_method = "C93EBF6D393DD850C33A55A4967F1BAD")
    
public void addPropertyChangeListener(PropertyChangeListener listener) {
        if (listener != null) {
            listeners.add(listener);
        }
    }

    /**
     * Returns all subscribers. This includes both listeners subscribed to all
     * property changes and listeners subscribed to a single property.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.483 -0500", hash_original_method = "20AEE88E0780907A1527FDFF7FD94398", hash_generated_method = "9A47B5F9519785DE53630EA3549CB4E8")
    
public PropertyChangeListener[] getPropertyChangeListeners() {
        return listeners.toArray(new PropertyChangeListener[0]); // 0 to avoid synchronization
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.485 -0500", hash_original_method = "2B46BB9E8064A4DB5FBAF8D8B87BA3A9", hash_generated_method = "C78C87E92685BB4BAE1CD194694CCC1D")
    
private void writeObject(ObjectOutputStream out) throws IOException {
        /*
         * The serialized form of this class uses PropertyChangeSupport to group
         * PropertyChangeListeners subscribed to the same property name.
         */
        Map<String, PropertyChangeSupport> map = new Hashtable<String, PropertyChangeSupport>();
        for (PropertyChangeListener p : listeners) {
            if (p instanceof PropertyChangeListenerProxy && !(p instanceof Serializable)) {
                PropertyChangeListenerProxy proxy = (PropertyChangeListenerProxy) p;
                PropertyChangeListener listener = (PropertyChangeListener) proxy.getListener();
                if (listener instanceof Serializable) {
                    PropertyChangeSupport list = map.get(proxy.getPropertyName());
                    if (list == null) {
                        list = new PropertyChangeSupport(sourceBean);
                        map.put(proxy.getPropertyName(), list);
                    }
                    list.listeners.add(listener);
                }
            }
        }

        ObjectOutputStream.PutField putFields = out.putFields();
        putFields.put("source", sourceBean);
        putFields.put("children", map);
        out.writeFields();

        for (PropertyChangeListener p : listeners) {
            if (p instanceof Serializable) {
                out.writeObject(p);
            }
        }
        out.writeObject(null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.489 -0500", hash_original_method = "CF711F06198DA67AA575F0B0D8CAC00C", hash_generated_method = "AA1DF8A46C86151031D36BB0D5195FC0")
    
@SuppressWarnings("unchecked")
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField readFields = in.readFields();
        sourceBean = readFields.get("source", null);
        listeners = new CopyOnWriteArrayList<PropertyChangeListener>();

        Map<String, PropertyChangeSupport> children
                = (Map<String, PropertyChangeSupport>) readFields.get("children", null);
        if (children != null) {
            for (Map.Entry<String, PropertyChangeSupport> entry : children.entrySet()) {
                for (PropertyChangeListener p : entry.getValue().listeners) {
                    listeners.add(new PropertyChangeListenerProxy(entry.getKey(), p));
                }
            }
        }

        PropertyChangeListener listener;
        while ((listener = (PropertyChangeListener) in.readObject()) != null) {
            listeners.add(listener);
        }
    }

    /**
     * Publishes a property change event to all listeners of that property. If
     * the event's old and new values are equal (but non-null), no event will be
     * published.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.492 -0500", hash_original_method = "DE96EEBF0F3556789E0EE7EC3C8C89E3", hash_generated_method = "F5F44E5AF2FF70EBF213A4EA1344F183")
    
public void firePropertyChange(PropertyChangeEvent event) {
        String propertyName = event.getPropertyName();
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
        if (newValue != null && oldValue != null && newValue.equals(oldValue)) {
            return;
        }

        notifyEachListener:
        for (PropertyChangeListener p : listeners) {
            // unwrap listener proxies until we get a mismatched name or the real listener
            while (p instanceof PropertyChangeListenerProxy) {
                PropertyChangeListenerProxy proxy = (PropertyChangeListenerProxy) p;
                if (!Objects.equal(proxy.getPropertyName(), propertyName)) {
                    continue notifyEachListener;
                }
                p = (PropertyChangeListener) proxy.getListener();
            }
            p.propertyChange(event);
        }
    }
}

