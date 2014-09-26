/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package java.util.prefs;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.EventListener;
import java.util.EventObject;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import libcore.io.Base64;
import libcore.util.EmptyArray;

/**
 * This abstract class is a partial implementation of the abstract class
 * Preferences, which can be used to simplify {@code Preferences} provider's
 * implementation. This class defines nine abstract SPI methods, which must be
 * implemented by a preference provider.
 *
 * @since 1.4
 * @see Preferences
 */
public abstract class AbstractPreferences extends Preferences {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.188 -0400", hash_original_field = "98A1A38B483F1FB28607DEDC3AB25FFA", hash_generated_field = "D995D9943D0377A8679F080E8DA0A6FC")

    /** the unhandled events collection */
    private static final List<EventObject> events = new LinkedList<EventObject>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.188 -0400", hash_original_field = "4D867E839D09B00F8774A25B9D9092C4", hash_generated_field = "59C5BA2CE23567616AEF202D03FB69A4")

    private static final EventDispatcher dispatcher = new EventDispatcher("Preference Event Dispatcher");

    /*
     * -----------------------------------------------------------
     * Class initializer
     * -----------------------------------------------------------
     */
    static {
        dispatcher.setDaemon(true);
        dispatcher.start();
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @DSSpec(DSCat.SPEC_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.189 -0400", hash_original_method = "0713070578C1A485FA650FCE93E6C361", hash_generated_method = "7B8886BDBCDCC644EEE3F1C382DA590F")
            
@Override
            public void run() {
                Preferences uroot = Preferences.userRoot();
                Preferences sroot = Preferences.systemRoot();
                try {
                    uroot.flush();
                } catch (BackingStoreException e) {
                    // ignore
                }
                try {
                    sroot.flush();
                } catch (BackingStoreException e) {
                    // ignore
                }
            }
        });
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.190 -0400", hash_original_field = "6B3E165DC71502B5AA0239CA1D2CB989", hash_generated_field = "C2769C6511A9D1508A975EBF55284385")

    /** true if this node is in user preference hierarchy */
    boolean userNode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.190 -0400", hash_original_field = "5E7C45D6B25B1E31F92C48548080E9E3", hash_generated_field = "43010D881587B0B2D90E7ECC164397D5")

    /**
     * The object used to lock this node.
     */
    protected  Object lock;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.191 -0400", hash_original_field = "568CCDE1E9DA57F1BABF45C5CEA21147", hash_generated_field = "DFD5B7A91378AB7DFE58371B99787DCF")

    protected boolean newNode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.191 -0400", hash_original_field = "0F9CA38544B16CB37F58347D900CB7CB", hash_generated_field = "9BDD9CF68F151C7362985C56D0B53CD2")

    private Map<String, AbstractPreferences> cachedNode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.191 -0400", hash_original_field = "9242A547DDC57AE14D512557320B91DA", hash_generated_field = "4177C4FAC3F8257C03DB9906F2A5F210")

    private List<EventListener> nodeChangeListeners;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.192 -0400", hash_original_field = "9AF238BA75E727C6535218235489D666", hash_generated_field = "F7D10F7A64B81780B683A1072AEE7E6B")

    private List<EventListener> preferenceChangeListeners;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.192 -0400", hash_original_field = "C378C7BAB85880D9234DD1B66D3C089D", hash_generated_field = "587DE6D008376A0CF1DF9DD48190EEF8")

    private String nodeName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.192 -0400", hash_original_field = "09BF6CC99C6BD5307B96356BCDB9EF4B", hash_generated_field = "CB3F30602AF6854F7F801FE77F9D1E79")

    private AbstractPreferences parentPref;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.193 -0400", hash_original_field = "81EC29B9EE54802853E2DC99C77B86D1", hash_generated_field = "CD8038912C96C519CC5279078B36BB93")

    private boolean isRemoved;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.193 -0400", hash_original_field = "4D55C07EC8677306D3EB5A6DCCFED201", hash_generated_field = "7FF42ACFA35FB666D08AA33CEE582982")

    private AbstractPreferences root;

    /*
     * -----------------------------------------------------------
     * Constructors
     * -----------------------------------------------------------
     */
    /**
     * Constructs a new {@code AbstractPreferences} instance using the given
     * parent node and node name.
     *
     * @param parent
     *            the parent node of the new node or {@code null} to indicate
     *            that the new node is a root node.
     * @param name
     *            the name of the new node or an empty string to indicate that
     *            this node is called "root".
     * @throws IllegalArgumentException
     *             if the name contains a slash character or is empty if {@code
     *             parent} is not {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.194 -0400", hash_original_method = "0807678F2729AF86B80791A672B3F67B", hash_generated_method = "94C6F9ADAC5794F8826525A129AA4C91")
    
protected AbstractPreferences(AbstractPreferences parent, String name) {
        if ((parent == null ^ name.length() == 0) || name.indexOf("/") >= 0) {
            throw new IllegalArgumentException();
        }
        root = (parent == null) ? this : parent.root;
        nodeChangeListeners = new LinkedList<EventListener>();
        preferenceChangeListeners = new LinkedList<EventListener>();
        isRemoved = false;
        cachedNode = new HashMap<String, AbstractPreferences>();
        nodeName = name;
        parentPref = parent;
        lock = new Object();
        userNode = root.userNode;
    }

    /*
     * -----------------------------------------------------------
     * Methods
     * -----------------------------------------------------------
     */
    /**
     * Returns an array of all cached child nodes.
     *
     * @return the array of cached child nodes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.194 -0400", hash_original_method = "1525D0DC0F6073566820EAD4A6162E60", hash_generated_method = "5E1FB5E5135FAD8F3806DD923EC39770")
    
protected final AbstractPreferences[] cachedChildren() {
        return cachedNode.values().toArray(new AbstractPreferences[cachedNode.size()]);
    }

    /**
     * Returns the child node with the specified name or {@code null} if it
     * doesn't exist. Implementers can assume that the name supplied to this
     * method will be a valid node name string (conforming to the node naming
     * format) and will not correspond to a node that has been cached or
     * removed.
     *
     * @param name
     *            the name of the desired child node.
     * @return the child node with the given name or {@code null} if it doesn't
     *         exist.
     * @throws BackingStoreException
     *             if the backing store is unavailable or causes an operation
     *             failure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.195 -0400", hash_original_method = "2DB2CB908F4C4DE64C6EB092C8C44315", hash_generated_method = "373046A7E0A82393FC007BB4CDB0B4F7")
    
protected AbstractPreferences getChild(String name)
            throws BackingStoreException {
        synchronized (lock) {
            checkState();
            AbstractPreferences result = null;
            String[] childrenNames = childrenNames();
            for (String childrenName : childrenNames) {
                if (childrenName.equals(name)) {
                    result = childSpi(name);
                    break;
                }
            }
            return result;
        }

    }

    /**
     * Returns whether this node has been removed by invoking the method {@code
     * removeNode()}.
     *
     * @return {@code true}, if this node has been removed, {@code false}
     *         otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.195 -0400", hash_original_method = "576E6472508CF5DA519F254384E47534", hash_generated_method = "836E67DBFA98ADFB380336FAEA009784")
    
protected boolean isRemoved() {
        synchronized (lock) {
            return isRemoved;
        }
    }

    /**
     * Flushes changes of this node to the backing store. This method should
     * only flush this node and should not include the descendant nodes. Any
     * implementation that wants to provide functionality to flush all nodes
     * at once should override the method {@link #flush() flush()}.
     *
     * @throws BackingStoreException
     *             if the backing store is unavailable or causes an operation
     *             failure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.195 -0400", hash_original_method = "54979670B71F4EF4FE0F77EB3A3E2B55", hash_generated_method = "207C20183262C1A4A0F4B7C3251640F3")
    
protected abstract void flushSpi() throws BackingStoreException;

    /**
     * Returns the names of all of the child nodes of this node or an empty
     * array if this node has no children. The names of cached children are not
     * required to be returned.
     *
     * @return the names of this node's children.
     * @throws BackingStoreException
     *             if the backing store is unavailable or causes an operation
     *             failure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.196 -0400", hash_original_method = "5330FCBC34CFA1077DBEB73BF8285DA8", hash_generated_method = "A53884A540ED6A4F2E1D668128788370")
    
protected abstract String[] childrenNamesSpi() throws BackingStoreException;

    /**
     * Returns the child preference node with the given name, creating it
     * if it does not exist. The caller of this method should ensure that the
     * given name is valid and that this node has not been removed or cached.
     * If the named node has just been removed, the implementation
     * of this method must create a new one instead of reactivating the removed
     * one.
     * <p>
     * The new creation is not required to be persisted immediately until the
     * flush method will be invoked.
     * </p>
     *
     * @param name
     *            the name of the child preference to be returned.
     * @return the child preference node.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.196 -0400", hash_original_method = "7C3F597D10C6355597756BCD38068AE5", hash_generated_method = "66E73DAFC00F5B6759C3A9018F84D565")
    
protected abstract AbstractPreferences childSpi(String name);

    /**
     * Puts the given key-value pair into this node. Caller of this method
     * should ensure that both of the given values are valid and that this
     * node has not been removed.
     *
     * @param name
     *            the given preference key.
     * @param value
     *            the given preference value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.196 -0400", hash_original_method = "4204BF65604304AAE2A843AF49ABD91D", hash_generated_method = "8BF04B0FFEF0BACC5CA21C5B6D5F8032")
    
protected abstract void putSpi(String name, String value);

    /**
     * Gets the preference value mapped to the given key. The caller of this
     * method should ensure that the given key is valid and that this node has
     * not been removed. This method should not throw any exceptions but if it
     * does, the caller will ignore the exception, regarding it as a {@code
     * null} return value.
     *
     * @param key
     *            the given key to be searched for.
     * @return the preference value mapped to the given key.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.197 -0400", hash_original_method = "F4D6722F80B021FA3B2E4A59E55E99EF", hash_generated_method = "6FA292109189A2C9A83756EA5221B92B")
    
protected abstract String getSpi(String key);

    /**
     * Returns an array of all preference keys of this node or an empty array if
     * no preferences have been found. The caller of this method should ensure
     * that this node has not been removed.
     *
     * @return the array of all preference keys.
     * @throws BackingStoreException
     *             if the backing store is unavailable or causes an operation
     *             failure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.197 -0400", hash_original_method = "3EDC37A4663998769C3132942090B9D6", hash_generated_method = "FF2E3708D6F96E7EB22CACDE95F7F9E4")
    
protected abstract String[] keysSpi() throws BackingStoreException;

    /**
     * Removes this node from the preference hierarchy tree. The caller of this
     * method should ensure that this node has no child nodes, which means the
     * method {@link Preferences#removeNode() Preferences.removeNode()} should
     * invoke this method multiple-times in bottom-up pattern. The removal is
     * not required to be persisted until after it is flushed.
     *
     * @throws BackingStoreException
     *             if the backing store is unavailable or causes an operation
     *             failure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.197 -0400", hash_original_method = "3F31ADB82981FE16C17490A4BE9E688F", hash_generated_method = "9DB5B398153B49337B931218F2C90BE2")
    
protected abstract void removeNodeSpi() throws BackingStoreException;

    /**
     * Removes the preference with the specified key. The caller of this method
     * should ensure that the given key is valid and that this node has not been
     * removed.
     *
     * @param key
     *            the key of the preference that is to be removed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.198 -0400", hash_original_method = "A8EA8023F0D89EB1348419F252780819", hash_generated_method = "5300C71B3ED4056032DC612C1FCAFFE7")
    
protected abstract void removeSpi(String key);

    /**
     * Synchronizes this node with the backing store. This method should only
     * synchronize this node and should not include the descendant nodes. An
     * implementation that wants to provide functionality to synchronize all
     * nodes at once should override the method {@link #sync() sync()}.
     *
     * @throws BackingStoreException
     *             if the backing store is unavailable or causes an operation
     *             failure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.198 -0400", hash_original_method = "F598F7825C22E32987223DD7C2218989", hash_generated_method = "BBB58C9D91489EB315894F7BF16F4A6E")
    
protected abstract void syncSpi() throws BackingStoreException;

    /*
     * -----------------------------------------------------------
     * Methods inherited from Preferences
     * -----------------------------------------------------------
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.199 -0400", hash_original_method = "FBA8C196DBDC4C4821569F7F0738DA11", hash_generated_method = "EC6513EF93ED4FD942258759E755DE57")
    
@Override
    public String absolutePath() {
        if (parentPref == null) {
            return "/";
        } else if (parentPref == root) {
            return "/" + nodeName;
        }
        return parentPref.absolutePath() + "/" + nodeName;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.199 -0400", hash_original_method = "D129EF35AD8B246686EC0C036E528D1B", hash_generated_method = "C9237DC964BA51BEB2F307D1DF4E69B0")
    
@Override
    public String[] childrenNames() throws BackingStoreException {
        synchronized (lock) {
            checkState();
            TreeSet<String> result = new TreeSet<String>(cachedNode.keySet());
            String[] names = childrenNamesSpi();
            for (int i = 0; i < names.length; i++) {
                result.add(names[i]);
            }
            return result.toArray(new String[result.size()]);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.200 -0400", hash_original_method = "C0D051A8F0EDD17482AE35C7C2C7F85F", hash_generated_method = "4F9345BF24C41AD6EF76F8233F8C8C12")
    
@Override
    public void clear() throws BackingStoreException {
        synchronized (lock) {
            for (String key : keys()) {
                remove(key);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.200 -0400", hash_original_method = "DF19BA243BC848B434BE86186B12A779", hash_generated_method = "E3A342BAF76012E28091CFD2C1836027")
    
@Override
    public void exportNode(OutputStream ostream) throws IOException, BackingStoreException {
        if (ostream == null) {
            throw new NullPointerException("ostream == null");
        }
        checkState();
        XMLParser.exportPrefs(this, ostream, false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.201 -0400", hash_original_method = "5A3738A17CF7D6E96AEF88A597866079", hash_generated_method = "C779491296E3973429467CA558B8292F")
    
@Override
    public void exportSubtree(OutputStream ostream) throws IOException, BackingStoreException {
        if (ostream == null) {
            throw new NullPointerException("ostream == null");
        }
        checkState();
        XMLParser.exportPrefs(this, ostream, true);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.201 -0400", hash_original_method = "09DA7A8C138DCF5F841D1FA25C63AD01", hash_generated_method = "3970226471AA76BF041AB780CADC397E")
    
@Override
    public void flush() throws BackingStoreException {
        synchronized (lock) {
            flushSpi();
        }
        AbstractPreferences[] cc = cachedChildren();
        int i;
        for (i = 0; i < cc.length; i++) {
            cc[i].flush();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.202 -0400", hash_original_method = "6487933045A817C6C37718859ADBD75A", hash_generated_method = "36249DDF448DFF39F217A416E210C508")
    
@Override
    public String get(String key, String deflt) {
        if (key == null) {
            throw new NullPointerException("key == null");
        }
        String result = null;
        synchronized (lock) {
            checkState();
            try {
                result = getSpi(key);
            } catch (Exception e) {
                // ignored
            }
        }
        return (result == null ? deflt : result);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.202 -0400", hash_original_method = "639DF37CDA0AB7A4938611339DB542FA", hash_generated_method = "1C7E79542866062A710030255FBAE8B8")
    
@Override
    public boolean getBoolean(String key, boolean deflt) {
        String result = get(key, null);
        if (result == null) {
            return deflt;
        }
        if ("true".equalsIgnoreCase(result)) {
            return true;
        } else if ("false".equalsIgnoreCase(result)) {
            return false;
        } else {
            return deflt;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.203 -0400", hash_original_method = "9DB9B962AB6EC4D5CF9C8A9308FC2D05", hash_generated_method = "0D95CA862540D37710804D0A89A05048")
    
@Override
    public byte[] getByteArray(String key, byte[] deflt) {
        String svalue = get(key, null);
        if (svalue == null) {
            return deflt;
        }
        if (svalue.length() == 0) {
            return EmptyArray.BYTE;
        }
        try {
            byte[] bavalue = svalue.getBytes(StandardCharsets.US_ASCII);
            if (bavalue.length % 4 != 0) {
                return deflt;
            }
            return Base64.decode(bavalue);
        } catch (Exception e) {
            return deflt;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.203 -0400", hash_original_method = "109E1C00F8D7E70022B4C7414F30B872", hash_generated_method = "65905E0F16FACB1C0F11ADBC3E0924EC")
    
@Override
    public double getDouble(String key, double deflt) {
        String result = get(key, null);
        if (result == null) {
            return deflt;
        }
        try {
            return Double.parseDouble(result);
        } catch (NumberFormatException e) {
            return deflt;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.204 -0400", hash_original_method = "9036785226A7D289AFD12282534D27B8", hash_generated_method = "8895D0B9C714BBA022CB849062B0476B")
    
@Override
    public float getFloat(String key, float deflt) {
        String result = get(key, null);
        if (result == null) {
            return deflt;
        }
        try {
            return Float.parseFloat(result);
        } catch (NumberFormatException e) {
            return deflt;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.204 -0400", hash_original_method = "471461DDFBFCB22BAA1CB33E8F37483B", hash_generated_method = "268A346C8260B5EAA36EF7E0FACF31A3")
    
@Override
    public int getInt(String key, int deflt) {
        String result = get(key, null);
        if (result == null) {
            return deflt;
        }
        try {
            return Integer.parseInt(result);
        } catch (NumberFormatException e) {
            return deflt;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.205 -0400", hash_original_method = "BB689AECBDEF7F62A8A185A04695B6FA", hash_generated_method = "D0F7B47352E2031CDC9A31231DF4BC56")
    
@Override
    public long getLong(String key, long deflt) {
        String result = get(key, null);
        if (result == null) {
            return deflt;
        }
        try {
            return Long.parseLong(result);
        } catch (NumberFormatException e) {
            return deflt;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.205 -0400", hash_original_method = "D97680DCE50F144AB0A3E9FE153F9E33", hash_generated_method = "7A4B6A5E95C4304841E8EE8FEA39C405")
    
@Override
    public boolean isUserNode() {
        return root == Preferences.userRoot();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.206 -0400", hash_original_method = "B0B15A1AE0BD860B1A20048A2563F5C1", hash_generated_method = "2CD24A3D66285A82EB77342325358722")
    
@Override
    public String[] keys() throws BackingStoreException {
        synchronized (lock) {
            checkState();
            return keysSpi();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.206 -0400", hash_original_method = "70A62793D56028D18CD0BECCF1959386", hash_generated_method = "1A61C77879333D34462FEB349E424A17")
    
@Override
    public String name() {
        return nodeName;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.207 -0400", hash_original_method = "B0B054E2ED8B73BE7E06ADFD1A1D1D4C", hash_generated_method = "F4C7EB8AEE666FDF5EA2E31E4D586B34")
    
@Override
    public Preferences node(String name) {
        AbstractPreferences startNode = null;
        synchronized (lock) {
            checkState();
            validateName(name);
            if (name.isEmpty()) {
                return this;
            } else if ("/".equals(name)) {
                return root;
            }
            if (name.startsWith("/")) {
                startNode = root;
                name = name.substring(1);
            } else {
                startNode = this;
            }
        }
        try {
            return startNode.nodeImpl(name, true);
        } catch (BackingStoreException e) {
            // should not happen
            return null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.207 -0400", hash_original_method = "03B7D06904403C2641B97A35DC9B6C54", hash_generated_method = "C015F3416225794E911EE217C7CAC6CB")
    
private void validateName(String name) {
        if (name.endsWith("/") && name.length() > 1) {
            throw new IllegalArgumentException("Name cannot end with '/'");
        }
        if (name.indexOf("//") >= 0) {
            throw new IllegalArgumentException("Name cannot contain consecutive '/' characters");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.208 -0400", hash_original_method = "C40BCF68871D14D0C22569A2DF32D9E0", hash_generated_method = "043A4A5D2BF4599CCC757E7DC1EB63A6")
    
private AbstractPreferences nodeImpl(String path, boolean createNew)
            throws BackingStoreException {
        String[] names = path.split("/");
        AbstractPreferences currentNode = this;
        AbstractPreferences temp;
        for (String name : names) {
            synchronized (currentNode.lock) {
                temp = currentNode.cachedNode.get(name);
                if (temp == null) {
                    temp = getNodeFromBackend(createNew, currentNode, name);
                }
            }
            currentNode = temp;
            if (currentNode == null) {
                break;
            }
        }
        return currentNode;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.208 -0400", hash_original_method = "2975F341D9852102A0A02FD901434075", hash_generated_method = "122D5320C2788889550593F16EF433A8")
    
private AbstractPreferences getNodeFromBackend(boolean createNew,
            AbstractPreferences currentNode, String name) throws BackingStoreException {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("Name '" + name + "' too long");
        }
        AbstractPreferences temp;
        if (createNew) {
            temp = currentNode.childSpi(name);
            currentNode.cachedNode.put(name, temp);
            if (temp.newNode && currentNode.nodeChangeListeners.size() > 0) {
                currentNode.notifyChildAdded(temp);
            }
        } else {
            temp = currentNode.getChild(name);
        }
        return temp;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.209 -0400", hash_original_method = "C90FCB799512FC48E5A3DDEAE2C3684F", hash_generated_method = "1ED2E9D8F6B21C18D300C303033BC07D")
    
@Override
    public boolean nodeExists(String name) throws BackingStoreException {
        if (name == null) {
            throw new NullPointerException("name == null");
        }
        AbstractPreferences startNode = null;
        synchronized (lock) {
            if (isRemoved()) {
                if (name.isEmpty()) {
                    return false;
                }
                throw new IllegalStateException("This node has been removed");
            }
            validateName(name);
            if (name.isEmpty() || "/".equals(name)) {
                return true;
            }
            if (name.startsWith("/")) {
                startNode = root;
                name = name.substring(1);
            } else {
                startNode = this;
            }
        }
        try {
            Preferences result = startNode.nodeImpl(name, false);
            return (result != null);
        } catch(IllegalArgumentException e) {
            return false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.210 -0400", hash_original_method = "9DFA8F53CA82403F384A5DD89B5BDD9B", hash_generated_method = "A854AC20502EC78EA635EDB6325305DC")
    
@Override
    public Preferences parent() {
        checkState();
        return parentPref;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.210 -0400", hash_original_method = "F461E6CA4DE34BEFDFD8AC6C2C0583FC", hash_generated_method = "752502813E915BF2A83F24B486B96547")
    
private void checkState() {
        if (isRemoved()) {
            throw new IllegalStateException("This node has been removed");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.210 -0400", hash_original_method = "C66E5D4C1B7769693290424068A3AD67", hash_generated_method = "14EB84FFE453044270F222E9C3FB5C6F")
    
@Override
    public void put(String key, String value) {
        if (key == null) {
            throw new NullPointerException("key == null");
        } else if (value == null) {
            throw new NullPointerException("value == null");
        }
        if (key.length() > MAX_KEY_LENGTH || value.length() > MAX_VALUE_LENGTH) {
            throw new IllegalArgumentException();
        }
        synchronized (lock) {
            checkState();
            putSpi(key, value);
        }
        notifyPreferenceChange(key, value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.211 -0400", hash_original_method = "9FE1F120DB162000B2D2A52EDFA1B7C6", hash_generated_method = "B31AEBA6956F6F038C6687185E4B16D1")
    
@Override
    public void putBoolean(String key, boolean value) {
        put(key, String.valueOf(value));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.211 -0400", hash_original_method = "7AE77D468DC57040978F0BF60975CB80", hash_generated_method = "E30A31CFFB92713E7337EE517D278C25")
    
@Override
    public void putByteArray(String key, byte[] value) {
        put(key, Base64.encode(value));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.212 -0400", hash_original_method = "D807E7AAFF1189D688AFBB37EC5AEE5D", hash_generated_method = "69EAC497E90827E33C4BDB6C37EAF0FD")
    
@Override
    public void putDouble(String key, double value) {
        put(key, Double.toString(value));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.212 -0400", hash_original_method = "78A15A7EB7210871258D355D3953315E", hash_generated_method = "1B350CEFD217AC1976A601B6609A1038")
    
@Override
    public void putFloat(String key, float value) {
        put(key, Float.toString(value));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.212 -0400", hash_original_method = "AE2431E7B109634FBF2EF5BD3DC2AEFB", hash_generated_method = "42B852AD272A53146420F2881A6C65E2")
    
@Override
    public void putInt(String key, int value) {
        put(key, Integer.toString(value));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.213 -0400", hash_original_method = "71B32FB95B59E74CEDAE989D53D5BCD2", hash_generated_method = "1321A4C35AE53CBD7BBC92D5E9C21BF9")
    
@Override
    public void putLong(String key, long value) {
        put(key, Long.toString(value));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.213 -0400", hash_original_method = "46648D24F35C727E94D531D8621F1E1E", hash_generated_method = "60FFAB1210C123E100224B500530029B")
    
@Override
    public void remove(String key) {
        synchronized (lock) {
            checkState();
            removeSpi(key);
        }
        notifyPreferenceChange(key, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.214 -0400", hash_original_method = "39F5CA47E4BCDFE80745F0E3F00C0D5E", hash_generated_method = "1CDFF94AA9204DD065BC8CE6C211FD10")
    
@Override
    public void removeNode() throws BackingStoreException {
        if (root == this) {
            throw new UnsupportedOperationException("Cannot remove root node");
        }
        synchronized (parentPref.lock) {
            removeNodeImpl();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.214 -0400", hash_original_method = "78CB6306E0BC01AAC2459F3D8E528FB4", hash_generated_method = "BB9366C9D6E3ABFB511DFD89B0961E89")
    
private void removeNodeImpl() throws BackingStoreException {
        synchronized (lock) {
            checkState();
            String[] childrenNames = childrenNamesSpi();
            for (String childrenName : childrenNames) {
                if (cachedNode.get(childrenName) == null) {
                    AbstractPreferences child = childSpi(childrenName);
                    cachedNode.put(childrenName, child);
                }
            }

            final Collection<AbstractPreferences> values = cachedNode.values();
            final AbstractPreferences[] children = values.toArray(new AbstractPreferences[values.size()]);
            for (AbstractPreferences child : children) {
                child.removeNodeImpl();
            }
            removeNodeSpi();
            isRemoved = true;
            parentPref.cachedNode.remove(nodeName);
        }
        if (parentPref.nodeChangeListeners.size() > 0) {
            parentPref.notifyChildRemoved(this);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.215 -0400", hash_original_method = "EA2BD952BD87B9744B2410314D594682", hash_generated_method = "838FE4E15AC84B30C8C77B874F667160")
    
@Override
    public void addNodeChangeListener(NodeChangeListener ncl) {
        if (ncl == null) {
            throw new NullPointerException("ncl == null");
        }
        checkState();
        synchronized (nodeChangeListeners) {
            nodeChangeListeners.add(ncl);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.215 -0400", hash_original_method = "F8DCD0439FDEBF1A569484A407C50CDD", hash_generated_method = "EF2A82A288A60F7199D6250D5C62B8CA")
    
@Override
    public void addPreferenceChangeListener(PreferenceChangeListener pcl) {
        if (pcl == null) {
            throw new NullPointerException("pcl == null");
        }
        checkState();
        synchronized (preferenceChangeListeners) {
            preferenceChangeListeners.add(pcl);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.216 -0400", hash_original_method = "951CA38CFD6B14E3191E6B7B20317326", hash_generated_method = "7964BCACC3DEF61075C1F94366B31C64")
    
@Override
    public void removeNodeChangeListener(NodeChangeListener ncl) {
        checkState();
        synchronized (nodeChangeListeners) {
            int pos;
            if ((pos = nodeChangeListeners.indexOf(ncl)) == -1) {
                throw new IllegalArgumentException();
            }
            nodeChangeListeners.remove(pos);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.216 -0400", hash_original_method = "C1E9427CB5B4BE882168803C3DEA0C75", hash_generated_method = "07D2460C5CADDDBF26E5941ACEDC2234")
    
@Override
    public void removePreferenceChangeListener(PreferenceChangeListener pcl) {
        checkState();
        synchronized (preferenceChangeListeners) {
            int pos;
            if ((pos = preferenceChangeListeners.indexOf(pcl)) == -1) {
                throw new IllegalArgumentException();
            }
            preferenceChangeListeners.remove(pos);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.218 -0400", hash_original_method = "8D078FAB1746AA61D755CBE918F17B12", hash_generated_method = "8BCB46BC3FDB87A0F1F653558EFEF704")
    
@Override
    public void sync() throws BackingStoreException {
        synchronized (lock) {
            checkState();
            syncSpi();
        }
        for (AbstractPreferences child : cachedChildren()) {
            child.sync();
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.218 -0400", hash_original_method = "DC2DEE4C60A3DE38C649D2B8F6B4E410", hash_generated_method = "146762C7A78D708FEE4EA3C2C5C5C4F7")
    
@Override
    public String toString() {
        return (isUserNode() ? "User" : "System") + " Preference Node: " + absolutePath();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.218 -0400", hash_original_method = "65AD46C2EB753C71EA56F7D39A48DF3D", hash_generated_method = "847C18F4B506FC1074D07DE4CCC13913")
    
private void notifyChildAdded(Preferences child) {
        NodeChangeEvent nce = new NodeAddEvent(this, child);
        synchronized (events) {
            events.add(nce);
            events.notifyAll();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.219 -0400", hash_original_method = "39847A372326885BCE41D06964B72A3B", hash_generated_method = "143D2EBCF3F6BBEF0C957C292DE0DEAA")
    
private void notifyChildRemoved(Preferences child) {
        NodeChangeEvent nce = new NodeRemoveEvent(this, child);
        synchronized (events) {
            events.add(nce);
            events.notifyAll();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.219 -0400", hash_original_method = "28045A459F68F6FC999733F430D0C2E0", hash_generated_method = "9E4B691ED392072E8BBEE78E724DAF16")
    
private void notifyPreferenceChange(String key, String newValue) {
        PreferenceChangeEvent pce = new PreferenceChangeEvent(this, key, newValue);
        synchronized (events) {
            events.add(pce);
            events.notifyAll();
        }
    }

    private static class EventDispatcher extends Thread {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.220 -0400", hash_original_method = "491662CDBB464C35B9003C04ACE1C3EE", hash_generated_method = "491662CDBB464C35B9003C04ACE1C3EE")
        
EventDispatcher(String name){
            super(name);
        }

        @DSSpec(DSCat.SPEC_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.220 -0400", hash_original_method = "536021F1E13E81D3927E4466D90AFCE8", hash_generated_method = "2D719AA03C22873F47BDE6D26556479F")
        
@Override
        public void run() {
            while (true) {
                EventObject event;
                try {
                    event = getEventObject();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    continue;
                }
                AbstractPreferences pref = (AbstractPreferences) event.getSource();
                if (event instanceof NodeAddEvent) {
                    dispatchNodeAdd((NodeChangeEvent) event,
                            pref.nodeChangeListeners);
                } else if (event instanceof NodeRemoveEvent) {
                    dispatchNodeRemove((NodeChangeEvent) event,
                            pref.nodeChangeListeners);
                } else if (event instanceof PreferenceChangeEvent) {
                    dispatchPrefChange((PreferenceChangeEvent) event,
                            pref.preferenceChangeListeners);
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.221 -0400", hash_original_method = "D6A2F83156833BE876E527D6701B8805", hash_generated_method = "C2274C2107E9DBCE94A7DDB36A60B785")
        
private EventObject getEventObject() throws InterruptedException {
            synchronized (events) {
                if (events.isEmpty()) {
                    events.wait();
                }
                EventObject event = events.get(0);
                events.remove(0);
                return event;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.221 -0400", hash_original_method = "D70FEE84D37143DCFA5B50B9E14A8BBC", hash_generated_method = "B4636CE82015F5344E73AAFDA90A049C")
        
private void dispatchPrefChange(PreferenceChangeEvent event,
                List<EventListener> preferenceChangeListeners) {
            synchronized (preferenceChangeListeners) {
                for (EventListener preferenceChangeListener : preferenceChangeListeners) {
                    ((PreferenceChangeListener) preferenceChangeListener).preferenceChange(event);
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.222 -0400", hash_original_method = "8D92F8D15D776264ED01259C91584FEF", hash_generated_method = "E4BAF5A38E41C49D1B98D1DDDCD2E5FD")
        
private void dispatchNodeRemove(NodeChangeEvent event,
                List<EventListener> nodeChangeListeners) {
            synchronized (nodeChangeListeners) {
                for (EventListener nodeChangeListener : nodeChangeListeners) {
                    ((NodeChangeListener) nodeChangeListener).childRemoved(event);
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.222 -0400", hash_original_method = "4B5D9693FA2131BCEF122B28CB3F2A2C", hash_generated_method = "92E1A456B7523B3D3AD688FA122E4D28")
        
private void dispatchNodeAdd(NodeChangeEvent event,
                List<EventListener> nodeChangeListeners) {
            synchronized (nodeChangeListeners) {
                for (EventListener nodeChangeListener : nodeChangeListeners) {
                    NodeChangeListener ncl = (NodeChangeListener) nodeChangeListener;
                    ncl.childAdded(event);
                }
            }
        }
    }

    private static class NodeAddEvent extends NodeChangeEvent {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.224 -0400", hash_original_field = "7D07EDF60BE7D52BF87500AC6D8FE154", hash_generated_field = "712212474A80BD328114C4C1DC66CBA3")

        private static final long serialVersionUID = 1L;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.224 -0400", hash_original_method = "802F28B42B0D53C63BCBB7878B78F66E", hash_generated_method = "9D7DE52449417E10225164F2CD67917C")
        
public NodeAddEvent(Preferences p, Preferences c) {
            super(p, c);
        }
    }

    private static class NodeRemoveEvent extends NodeChangeEvent {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.225 -0400", hash_original_field = "7D07EDF60BE7D52BF87500AC6D8FE154", hash_generated_field = "712212474A80BD328114C4C1DC66CBA3")

        private static final long serialVersionUID = 1L;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.225 -0400", hash_original_method = "36B4F2AA31ED24B2FFEB21CB60261720", hash_generated_method = "8488FE54E253768FE007CA1AFB84636D")
        
public NodeRemoveEvent(Preferences p, Preferences c) {
            super(p, c);
        }
    }
}
