/*
 * Copyright 2004 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.commons.logging.impl;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.*;

/**
 * <p>Implementation of <code>Hashtable</code> that uses <code>WeakReference</code>'s
 * to hold its keys thus allowing them to be reclaimed by the garbage collector.
 * The associated values are retained using strong references.</p>
 *
 * <p>This class follows the symantics of <code>Hashtable</code> as closely as
 * possible. It therefore does not accept null values or keys.</p>
 *
 * <p><strong>Note:</strong>
 * This is <em>not</em> intended to be a general purpose hash table replacement.
 * This implementation is also tuned towards a particular purpose: for use as a replacement
 * for <code>Hashtable</code> in <code>LogFactory</code>. This application requires
 * good liveliness for <code>get</code> and <code>put</code>. Various tradeoffs
 * have been made with this in mind.
 * </p>
 * <p>
 * <strong>Usage:</strong> typical use case is as a drop-in replacement 
 * for the <code>Hashtable</code> used in <code>LogFactory</code> for J2EE enviroments
 * running 1.3+ JVMs. Use of this class <i>in most cases</i> (see below) will
 * allow classloaders to be collected by the garbage collector without the need 
 * to call {@link org.apache.commons.logging.LogFactory#release(ClassLoader) LogFactory.release(ClassLoader)}.
 * </p>
 *
 * <p><code>org.apache.commons.logging.LogFactory</code> checks whether this class
 * can be supported by the current JVM, and if so then uses it to store
 * references to the <code>LogFactory</code> implementationd it loads 
 * (rather than using a standard Hashtable instance). 
 * Having this class used instead of <code>Hashtable</code> solves
 * certain issues related to dynamic reloading of applications in J2EE-style
 * environments. However this class requires java 1.3 or later (due to its use
 * of <code>java.lang.ref.WeakReference</code> and associates).
 * And by the way, this extends <code>Hashtable</code> rather than <code>HashMap</code>
 * for backwards compatibility reasons. See the documentation
 * for method <code>LogFactory.createFactoryStore</code> for more details.</p>
 *
 * <p>The reason all this is necessary is due to a issue which
 * arises during hot deploy in a J2EE-like containers. 
 * Each component running in the container owns one or more classloaders; when
 * the component loads a LogFactory instance via the component classloader
 * a reference to it gets stored in the static LogFactory.factories member,
 * keyed by the component's classloader so different components don't
 * stomp on each other. When the component is later unloaded, the container
 * sets the component's classloader to null with the intent that all the 
 * component's classes get garbage-collected. However there's still a
 * reference to the component's classloader from a key in the "global"
 * <code>LogFactory</code>'s factories member! If <code>LogFactory.release()</code>
 * is called whenever component is unloaded, the classloaders will be correctly
 * garbage collected; this <i>should</i> be done by any container that 
 * bundles commons-logging by default. However, holding the classloader
 * references weakly ensures that the classloader will be garbage collected
 * without the container performing this step. </p>
 *
 * <p>
 * <strong>Limitations:</strong>
 * There is still one (unusual) scenario in which a component will not 
 * be correctly unloaded without an explicit release. Though weak references
 * are used for its keys, it is necessary to use strong references for its values.
 * </p>
 * 
 * <p> If the abstract class <code>LogFactory</code> is 
 * loaded by the container classloader but a subclass of 
 * <code>LogFactory</code> [LogFactory1] is loaded by the component's 
 * classloader and an instance stored in the static map associated with the
 * base LogFactory class, then there is a strong reference from the LogFactory
 * class to the LogFactory1 instance (as normal) and a strong reference from
 * the LogFactory1 instance to the component classloader via
 * <code>getClass().getClassLoader()</code>. This chain of references will prevent 
 * collection of the child classloader.</p>
 *
 * <p>
 * Such a situation occurs when the commons-logging.jar is
 * loaded by a parent classloader (e.g. a server level classloader in a
 * servlet container) and a custom <code>LogFactory</code> implementation is
 * loaded by a child classloader (e.g. a web app classloader).</p>
 * 
 * <p>To avoid this scenario, ensure
 * that any custom LogFactory subclass is loaded by the same classloader as 
 * the base <code>LogFactory</code>. Creating custom LogFactory subclasses is,
 * however, rare. The standard LogFactoryImpl class should be sufficient
 * for most or all users.</p>
 *
 *
 * @author Brian Stansberry
 * 
 * @since 1.1
 */
public final class WeakHashtable extends Hashtable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.633 -0400", hash_original_field = "9FEA6B12AB81A380CAB0A2784B308092", hash_generated_field = "7DB3899695A4084D838900595445990A")

    private static final int MAX_CHANGES_BEFORE_PURGE = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.633 -0400", hash_original_field = "B988034B61807ACC6BC2978CD7F04295", hash_generated_field = "0ACC8C76E7B3FD2C3B4D7160A27340BB")

    private static final int PARTIAL_PURGE_COUNT     = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.634 -0400", hash_original_field = "17E7F4AEB83E562317436919BA7E8169", hash_generated_field = "2C07B6DFF34E076AE5BA3CE8EB64C4D5")

    private ReferenceQueue queue = new ReferenceQueue();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.634 -0400", hash_original_field = "A62ECF91A680A19B3CF29248863ED69D", hash_generated_field = "6C7D1686969CB456353E6196BC780595")

    private int changeCount = 0;
    
    /**
     * Constructs a WeakHashtable with the Hashtable default
     * capacity and load factor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.635 -0400", hash_original_method = "86AA9C59ED40178E51985D4D12BA68D0", hash_generated_method = "2A75AA41DE19506BB1DEB703F27B1912")
    
public WeakHashtable() {}
    
    /**
     *@see Hashtable
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.635 -0400", hash_original_method = "09811560F9C75DCDF79A321FD91DFA89", hash_generated_method = "5C16B5D6767DEA51BCC5D833F29BBFB9")
    
public boolean containsKey(Object key) {
        // purge should not be required
        Referenced referenced = new Referenced(key);
        return super.containsKey(referenced);
    }
    
    /**
     *@see Hashtable
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.636 -0400", hash_original_method = "6A3380A61F3A78FE8B7102CCF52DAA8C", hash_generated_method = "59935578ADB024FD39B83C9708E40156")
    
public Enumeration elements() {
        purge();
        return super.elements();
    }
    
    /**
     *@see Hashtable
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.636 -0400", hash_original_method = "430EC1D03DDE99E6BF26E59E4863FC54", hash_generated_method = "5B2764EDF41BD1FEC9EC57104474605F")
    
public Set entrySet() {
        purge();
        Set referencedEntries = super.entrySet();
        Set unreferencedEntries = new HashSet();
        for (Iterator it=referencedEntries.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            Referenced referencedKey = (Referenced) entry.getKey();
            Object key = referencedKey.getValue();
            Object value = entry.getValue();
            if (key != null) {
                Entry dereferencedEntry = new Entry(key, value);
                unreferencedEntries.add(dereferencedEntry);
            }
        }
        return unreferencedEntries;
    }
    
    /**
     *@see Hashtable
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.637 -0400", hash_original_method = "9F5FC06C56A6055250205BD8B04ABBB0", hash_generated_method = "6AE9900107D2120A0747CE2BE2ECF778")
    
public Object get(Object key) {
        // for performance reasons, no purge
        Referenced referenceKey = new Referenced(key);
        return super.get(referenceKey);
    }
    
    /**
     *@see Hashtable
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.639 -0400", hash_original_method = "CA110102E6F1D2C3DDDF2AE738408FAB", hash_generated_method = "B5E9A4BA7AECA47E28590F562DE6C1A1")
    
public Enumeration keys() {
        purge();
        final Enumeration enumer = super.keys();
        return new Enumeration() {
            @DSSafe(DSCat.SAFE_LIST)
        public boolean hasMoreElements() {
                return enumer.hasMoreElements();
            }
            @DSSafe(DSCat.SAFE_LIST)
        public Object nextElement() {
                 Referenced nextReference = (Referenced) enumer.nextElement();
                 return nextReference.getValue();
            }
        };
    }
        
    /**
     *@see Hashtable
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.640 -0400", hash_original_method = "DE2069F003160F0BCBC7E64E96DDA4C0", hash_generated_method = "3C5BB9E9A2689D35D0462024E6808485")
    
public Set keySet() {
        purge();
        Set referencedKeys = super.keySet();
        Set unreferencedKeys = new HashSet();
        for (Iterator it=referencedKeys.iterator(); it.hasNext();) {
            Referenced referenceKey = (Referenced) it.next();
            Object keyValue = referenceKey.getValue();
            if (keyValue != null) {
                unreferencedKeys.add(keyValue);
            }
        }
        return unreferencedKeys;
    }
    
    /**
     *@see Hashtable
     */    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.641 -0400", hash_original_method = "8B867E98CE1FAAA660D56DAEE542C57D", hash_generated_method = "B64B35594FB0877A5AF071D0E6C5CC1A")
    
public Object put(Object key, Object value) {
        // check for nulls, ensuring symantics match superclass
        if (key == null) {
            throw new NullPointerException("Null keys are not allowed");
        }
        if (value == null) {
            throw new NullPointerException("Null values are not allowed");
        }

        // for performance reasons, only purge every 
        // MAX_CHANGES_BEFORE_PURGE times
        if (changeCount++ > MAX_CHANGES_BEFORE_PURGE) {
            purge();
            changeCount = 0;
        }
        // do a partial purge more often
        else if ((changeCount % PARTIAL_PURGE_COUNT) == 0) {
            purgeOne();
        }
        
        Object result = null;
        Referenced keyRef = new Referenced(key, queue);
        return super.put(keyRef, value);
    }
    
    /**
     *@see Hashtable
     */    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.642 -0400", hash_original_method = "E40797E446F09CAA9F108D8065CE8423", hash_generated_method = "11FA7EBBD1F8C538DFEADE3DC49E80A2")
    
public void putAll(Map t) {
        if (t != null) {
            Set entrySet = t.entrySet();
            for (Iterator it=entrySet.iterator(); it.hasNext();) {
                Map.Entry entry = (Map.Entry) it.next();
                put(entry.getKey(), entry.getValue());
            }
        }
    }
    
    /**
     *@see Hashtable
     */      
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.642 -0400", hash_original_method = "3DE4307A53CD10A418C1CEF6B9A191DC", hash_generated_method = "5CA4740D6C870BDF9CC8A0D8C36DFAFD")
    
public Collection values() {
        purge();
        return super.values();
    }
    
    /**
     *@see Hashtable
     */     
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.643 -0400", hash_original_method = "3799724B79C2F221D4EA17D05FB18E0B", hash_generated_method = "83846065A396CF228AFE20FB543FBD55")
    
public Object remove(Object key) {
        // for performance reasons, only purge every 
        // MAX_CHANGES_BEFORE_PURGE times
        if (changeCount++ > MAX_CHANGES_BEFORE_PURGE) {
            purge();
            changeCount = 0;
        }
        // do a partial purge more often
        else if ((changeCount % PARTIAL_PURGE_COUNT) == 0) {
            purgeOne();
        }
        return super.remove(new Referenced(key));
    }
    
    /**
     *@see Hashtable
     */    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.643 -0400", hash_original_method = "FD4FE4E64C891E9632BF675C397F5B4B", hash_generated_method = "308365B0A0ED340B2DF33D41046E490C")
    
public boolean isEmpty() {
        purge();
        return super.isEmpty();
    }
    
    /**
     *@see Hashtable
     */    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.644 -0400", hash_original_method = "40B0A01A5E49FB1B2F713FB0E3DC2327", hash_generated_method = "EDFF417FEBACCBBABBBACE7FAF2643C6")
    
public int size() {
        purge();
        return super.size();
    }
    
    /**
     *@see Hashtable
     */        
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.644 -0400", hash_original_method = "445A868828BAC5F0478089A3E1CC19B7", hash_generated_method = "73C7849DB2C26CAD14D4EDC348817F57")
    
public String toString() {
        purge();
        return super.toString();
    }
    
    /**
     * @see Hashtable
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.644 -0400", hash_original_method = "DB55C67BFC6DCE186138DA970944794E", hash_generated_method = "F573AA46CB2A1E3320754A2DA5FE75C0")
    
protected void rehash() {
        // purge here to save the effort of rehashing dead entries
        purge();
        super.rehash();
    }
    
    /**
     * Purges all entries whose wrapped keys
     * have been garbage collected.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.645 -0400", hash_original_method = "26F27EFAAE453C1D35ADA3C242EE997E", hash_generated_method = "99B8A2EB100BB92F57B66ECEEB658FA7")
    
private void purge() {
        synchronized (queue) {
            WeakKey key;
            while ((key = (WeakKey) queue.poll()) != null) {
                super.remove(key.getReferenced());
            }
        }
    }
    
    /**
     * Purges one entry whose wrapped key 
     * has been garbage collected.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.646 -0400", hash_original_method = "DBAFCB33512F3BBC9B4B2170EE57E152", hash_generated_method = "2BD1292746950290FAAB984D2EC79E9C")
    
private void purgeOne() {
        
        synchronized (queue) {
            WeakKey key = (WeakKey) queue.poll();
            if (key != null) {
                super.remove(key.getReferenced());
            }
        }
    }
    
    /** Entry implementation */
    private final static class Entry implements Map.Entry {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.646 -0400", hash_original_field = "1BF3787529F85519119096A6E55F756E", hash_generated_field = "61465DAF5E23066387FADBB5DEA64CC8")
    
        private  Object key;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.647 -0400", hash_original_field = "01495BEB834F5098BB0B06183674C819", hash_generated_field = "D3245881F91753AD0C508E1E9B72D31F")

        private  Object value;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.647 -0400", hash_original_method = "35E97661F3F1559A19EB4A2E368D9214", hash_generated_method = "86A9F68F641631DA02C7F33AA011D617")
        
private Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.648 -0400", hash_original_method = "63EDE4DC98940778CD8C3564DBC21CD5", hash_generated_method = "B3FC9773E5899CFD89CDFEDC1BA320B0")
        
public boolean equals(Object o) {
            boolean result = false;
            if (o != null && o instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) o;
                result =    (getKey()==null ?
                                            entry.getKey() == null : 
                                            getKey().equals(entry.getKey()))
                            &&
                            (getValue()==null ?
                                            entry.getValue() == null : 
                                            getValue().equals(entry.getValue()));
            }
            return result;
        }
        
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.648 -0400", hash_original_method = "E4EEDAD4762B78241799D43402645998", hash_generated_method = "A93C462116A0B8F9310AFD0E38B2FBED")
        
public int hashCode() {

            return (getKey()==null ? 0 : getKey().hashCode()) ^
                (getValue()==null ? 0 : getValue().hashCode());
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.649 -0400", hash_original_method = "DFE2CE7F6A7735CFA5F9BFAD2E3A7F88", hash_generated_method = "CE4B9EEE8A6D6A9099395C8D4AD1C76E")
        
public Object setValue(Object value) {
            throw new UnsupportedOperationException("Entry.setValue is not supported.");
        }
        
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.650 -0400", hash_original_method = "B4F085CF9776332A868AEA05C2B06886", hash_generated_method = "8F1C34090E292F1C2F621B605A6DF10D")
        
public Object getValue() {
            return value;
        }
        
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.650 -0400", hash_original_method = "F9893E453620413D700BE3F8D3AD5BCD", hash_generated_method = "38A4577B5543A154F7283FB9DB333AE0")
        
public Object getKey() {
            return key;
        }
    }
    
    /** Wrapper giving correct symantics for equals and hashcode */
    private final static class Referenced {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.651 -0400", hash_original_field = "1F8033CDC4198A8069F6303A620AB297", hash_generated_field = "467D05D2627336CA4D5D7ACDE6AE96C6")
        
        private  WeakReference reference;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.652 -0400", hash_original_field = "5A19588B577A4926772CAE314F19FADE", hash_generated_field = "38607001336EF9DE010EF92F750652A2")

        private  int           hashCode;

        /**
         * 
         * @throws NullPointerException if referant is <code>null</code>
         */        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.652 -0400", hash_original_method = "57906A8CCD2A7AFD8B32CDA522A51462", hash_generated_method = "40879A116BBC496B0177118B1DDF84D5")
        
private Referenced(Object referant) {
            reference = new WeakReference(referant);
            // Calc a permanent hashCode so calls to Hashtable.remove()
            // work if the WeakReference has been cleared
            hashCode  = referant.hashCode();
        }
        
        /**
         * 
         * @throws NullPointerException if key is <code>null</code>
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.653 -0400", hash_original_method = "AAC6A505C84037D9F2F10B97AB333CC0", hash_generated_method = "EBE13B31CFA1AFFF312035DAE01804AE")
        
private Referenced(Object key, ReferenceQueue queue) {
            reference = new WeakKey(key, queue, this);
            // Calc a permanent hashCode so calls to Hashtable.remove()
            // work if the WeakReference has been cleared
            hashCode  = key.hashCode();

        }
        
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.653 -0400", hash_original_method = "8BA9483852C95CF52834EFFEFBE67C86", hash_generated_method = "D0F3A8177610A3EF652F64918BF6799D")
        
public int hashCode() {
            return hashCode;
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.654 -0400", hash_original_method = "3769B1437FAE7651F332EE0407863BA4", hash_generated_method = "07978CD6751853151E43BAD4A2A183FB")
        
private Object getValue() {
            return reference.get();
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.655 -0400", hash_original_method = "4545B6AF944B2503B68ED877FC6C9013", hash_generated_method = "772D301BC4D757831BF62EF65CEAC5FB")
        
public boolean equals(Object o) {
            boolean result = false;
            if (o instanceof Referenced) {
                Referenced otherKey = (Referenced) o;
                Object thisKeyValue = getValue();
                Object otherKeyValue = otherKey.getValue();
                if (thisKeyValue == null) {                     
                    result = (otherKeyValue == null);
                    
                    // Since our hashcode was calculated from the original
                    // non-null referant, the above check breaks the 
                    // hashcode/equals contract, as two cleared Referenced
                    // objects could test equal but have different hashcodes.
                    // We can reduce (not eliminate) the chance of this
                    // happening by comparing hashcodes.
                    if (result == true) {
                        result = (this.hashCode() == otherKey.hashCode());
                    }
                    // In any case, as our c'tor does not allow null referants
                    // and Hashtable does not do equality checks between 
                    // existing keys, normal hashtable operations should never 
                    // result in an equals comparison between null referants
                }
                else
                {
                    result = thisKeyValue.equals(otherKeyValue);
                }
            }
            return result;
        }
    }
    
    /**
     * WeakReference subclass that holds a hard reference to an
     * associated <code>value</code> and also makes accessible
     * the Referenced object holding it.
     */
    private final static class WeakKey extends WeakReference {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.656 -0400", hash_original_field = "63A22C42B063B3F2D153853A42BEC2C9", hash_generated_field = "A4AAA925204E418193E0FB1A138D182F")

        private  Referenced referenced;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.657 -0400", hash_original_method = "FD44B1E2AD103DAA80C42D5FE48646E3", hash_generated_method = "98F433F80FCA8328EDD3ABE3B70B168D")
        
private WeakKey(Object key, 
                        ReferenceQueue queue,
                        Referenced referenced) {
            super(key, queue);
            this.referenced = referenced;
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.657 -0400", hash_original_method = "9F7DAB5D582FA47732755340195C476B", hash_generated_method = "514CAAEEB2534FB4B9342DF71213441F")
        
private Referenced getReferenced() {
            return referenced;
        }
     }
}
