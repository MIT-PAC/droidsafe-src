/* Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package java.util.prefs;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.util.ServiceLoader;

/**
 * An instance of the class {@code Preferences} represents one node in a
 * preference tree, which provides a mechanism to store and access configuration
 * data in a hierarchical way. Two hierarchy trees are maintained, one for
 * system preferences shared by all users and the other for user preferences
 * specific to the user. {@code Preferences} hierarchy trees and data are stored
 * in an implementation-dependent back-end.
 * <p>
 * Every node has one name and one unique absolute path following the same
 * notational conventions as directories in a file system. The root node's
 * name is "", and other node name strings cannot contain the slash character
 * and cannot be empty. The root node's absolute path is "/", and all other
 * nodes' absolute paths are constructed in the standard way: &lt;parent's
 * absolute path&gt; + "/" + &lt;node's name&gt;. Since the set of nodes forms a
 * tree with the root node at its base, all absolute paths start with the slash
 * character. Every node has one relative path to each of its ancestors. The
 * relative path doesn't start with slash: it equals the node's absolute path
 * with leading substring removed corresponding to the ancestor's absolute path
 * and a slash.
 * <p>
 * Modification to preferences data may be asynchronous, which means that
 * preference update method calls may return immediately instead of blocking.
 * The {@code flush()} and {@code sync()} methods force the back-end to
 * synchronously perform all pending updates, but the implementation is
 * permitted to perform the modifications on the underlying back-end data
 * at any time between the moment the request is made and the moment the
 * {@code flush()} or {@code sync()} method returns. Please note that if the JVM
 * exits normally, the implementation must assure all modifications are
 * persisted implicitly.
 * <p>
 * When invoking a method that retrieves preferences, the user must provide
 * a default value. The default value is returned when the preferences cannot
 * be found or the back-end is unavailable. Some other methods will throw
 * {@code BackingStoreException} when the back-end is unavailable.
 * </p>
 * <p>
 * Preferences can be exported to and imported from an XML files. These
 * documents must have an XML DOCTYPE declaration:
 * <pre>{@code
 * <!DOCTYPE preferences SYSTEM "http://java.sun.com/dtd/preferences.dtd">
 * }</pre>
 * This system URI is not really accessed by network, it is only a
 * identification string. Visit the DTD location to see the actual format
 * permitted.
 * <p>
 * There must be a concrete {@code PreferencesFactory} type for every concrete
 * {@code Preferences} type developed. Every J2SE implementation must provide a
 * default implementation for every supported platform, and must also provide a
 * means of replacing the default implementation. This implementation uses the
 * system property {@code java.util.prefs.PreferencesFactory} to determine which
 * preferences implementation to use.
 * <p>
 * The methods of this class are thread-safe. If multiple JVMs are using the
 * same back-end concurrently, the back-end won't be corrupted, but no other
 * behavior guarantees are made.
 *
 * @see PreferencesFactory
 *
 * @since 1.4
 */
public abstract class Preferences {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.538 -0400", hash_original_field = "3358B2A50526B2BBE6C7E511A21FDA35", hash_generated_field = "BCF8FDA59EE652A80365B6DEC91E24CC")

    public static final int MAX_KEY_LENGTH = 80;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.538 -0400", hash_original_field = "FC1C8C3F5DFBCFB670F4E8AE4C9FC57E", hash_generated_field = "9DBE04190D9F954B8B25A9504D93A088")

    public static final int MAX_NAME_LENGTH = 80;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.539 -0400", hash_original_field = "6C15C4D580870F6BE79A70FAB7071C8B", hash_generated_field = "066BB686C63381A5AE6084936220EBEF")

    public static final int MAX_VALUE_LENGTH = 8192;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.539 -0400", hash_original_field = "BE5B6606A63CFDF628C9A2AEAD241A2E", hash_generated_field = "A0F0822361472E6B420537C112D41366")

    private static final PreferencesFactory factory = findPreferencesFactory();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.539 -0400", hash_original_method = "722F8210868ABBB8384B4815D2CD2349", hash_generated_method = "889E716D84F8BD250518A2D5E2480408")
    
private static PreferencesFactory findPreferencesFactory() {
        // Try the system property first...
        PreferencesFactory result = ServiceLoader.loadFromSystemProperty(PreferencesFactory.class);
        if (result != null) {
            return result;
        }
        // Then use ServiceLoader for META-INF/services/...
        for (PreferencesFactory impl : ServiceLoader.load(PreferencesFactory.class)) {
            return impl;
        }
        // Finally return a default...
        return new FilePreferencesFactoryImpl();
    }

    /**
     * Imports all the preferences from an XML document using the given input
     * stream.
     * <p>
     * This XML document uses the UTF-8 encoding and must be written according
     * to the DTD in its DOCTYPE declaration, which must be the following:
     *
     * <pre>
     * &lt;!DOCTYPE preferences SYSTEM &quot;http://java.sun.com/dtd/preferences.dtd&quot;&gt;
     * </pre>
     *
     * <i>Please note that (unlike the methods of this class that don't concern
     * serialization), this call is not thread-safe.</i>
     * </p>
     *
     * @param istream
     *            the input stream to read the data from.
     * @throws InvalidPreferencesFormatException
     *             if the data read from the given input stream is not from a
     *             valid XML document.
     * @throws IOException
     *             if an error occurs while importing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.546 -0400", hash_original_method = "49DD3450A1B2FDE027DA8ABA574F65D4", hash_generated_method = "7A0E3427E26874BA43EA23BB13F11AF2")
    
public static void importPreferences (InputStream istream) throws InvalidPreferencesFormatException, IOException {
        if (istream == null){
            throw new MalformedURLException("Inputstream cannot be null");
        }
        XMLParser.importPrefs(istream);
    }

    /**
     * Returns the system preference node for the package of the given class.
     * The absolute path of the returned node is one slash followed by the given
     * class's full package name, replacing each period character ('.') with
     * a slash. For example, the absolute path of the preference associated with
     * the class Object would be "/java/lang". As a special case, the unnamed
     * package is associated with a preference node "/&lt;unnamed&gt;". This
     * method will create the node and its ancestors as needed. Any nodes created
     * by this method won't necessarily be persisted until the method {@code
     * flush()} is invoked.
     *
     * @param c
     *            the given class.
     * @return the system preference node for the package of the given class.
     * @throws NullPointerException
     *             if the given class is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.552 -0400", hash_original_method = "43C5B27567707DF4F41AF43B8D1A2671", hash_generated_method = "486798417DF11CDE6E143FAB159B53E3")
    
public static Preferences systemNodeForPackage (Class<?> c) {
        return factory.systemRoot().node(getNodeName(c));
    }

    /**
     * Returns the root node of the system preference hierarchy.
     *
     * @return the system preference hierarchy root node.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.553 -0400", hash_original_method = "AF375BF2524F7DDA8BC8534F14474EFC", hash_generated_method = "0C67B96950861968B171D2734792172D")
    
public static Preferences systemRoot() {
        return factory.systemRoot();
    }

    /**
     * Returns the user preference node for the package of the given class.
     * The absolute path of the returned node is one slash followed by the given
     * class's full package name, replacing each period character ('.') with
     * a slash. For example, the absolute path of the preference associated with
     * the class Object would be "/java/lang". As a special case, the unnamed
     * package is associated with a preference node "/&lt;unnamed&gt;". This
     * method will create the node and its ancestors as needed. Any nodes created
     * by this method won't necessarily be persisted until the method {@code
     * flush()} is invoked.
     *
     * @param c
     *            the given class.
     * @return the user preference node for the package of the given class.
     * @throws NullPointerException
     *             if the given class is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.553 -0400", hash_original_method = "D3C1764EAE87D2F55F852C038943DA3D", hash_generated_method = "5BAE56E33C3C5C346DB0DAFC0E4C069F")
    
public static Preferences userNodeForPackage (Class<?> c) {
        return factory.userRoot().node(getNodeName(c));
    }

    //parse node's absolute path from class instance
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.554 -0400", hash_original_method = "8601AB979F42B7A63CAB3F51E5DA50EE", hash_generated_method = "9C0670FE0D615F42DB93E29B453BC84B")
    
private static String getNodeName(Class<?> c){
        Package p = c.getPackage();
        if (p == null){
            return "/<unnamed>";
        }
        return "/"+p.getName().replace('.', '/');
    }

    /**
     * Returns the root node of the user preference hierarchy.
     *
     * @return the user preference hierarchy root node.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.554 -0400", hash_original_method = "02C0CB29BBAAE29D38F4E15880B3DC79", hash_generated_method = "F32E3C4BDE6C2ECB7A329F5FECC0496C")
    
public static Preferences userRoot() {
        return factory.userRoot();
    }

    /**
     * Default constructor, for use by subclasses only.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.540 -0400", hash_original_method = "D37A4F930E3EC7EDAB09C90C529D4033", hash_generated_method = "A24C9222E7D3A01CF3CF77812BF3B620")
    
protected Preferences() {
    }

    /**
     * Gets the absolute path string of this preference node.
     *
     * @return the preference node's absolute path string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.540 -0400", hash_original_method = "2CAEB7506A95134245ED0A6DB50B3479", hash_generated_method = "555D4738883FCF0EE9421B382FBE13AC")
    
public abstract String absolutePath();

    /**
     * Returns the names of all children of this node or an empty array if this
     * node has no children.
     *
     * @return the names of all children of this node.
     * @throws BackingStoreException
     *             if backing store is unavailable or causes an operation
     *             failure.
     * @throws IllegalStateException
     *             if this node has been removed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.541 -0400", hash_original_method = "FD5E9073BB382BC58918B70EC8729CD4", hash_generated_method = "CB2D50B555824920C32369CD8463D7A9")
    
public abstract String[] childrenNames() throws BackingStoreException;

    /**
     * Removes all preferences of this node.
     *
     * @throws BackingStoreException
     *             if backing store is unavailable or causes an operation
     *             failure.
     * @throws IllegalStateException
     *             if this node has been removed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.541 -0400", hash_original_method = "DD8015B8340F781C2BAFD6ACBEBCD3E9", hash_generated_method = "05C18F57BB7E9DA419DEAEF2AF041009")
    
public abstract void clear() throws BackingStoreException;

    /**
     * Exports all of the preferences of this node to a XML document using the
     * given output stream.
     * <p>
     * This XML document uses the UTF-8 encoding and is written according to the
     * DTD in its DOCTYPE declaration, which is the following:
     *
     * <pre>
     * &lt;!DOCTYPE preferences SYSTEM &quot;http://java.sun.com/dtd/preferences.dtd&quot;&gt;
     * </pre>
     *
     * <i>Please note that (unlike the methods of this class that don't concern
     * serialization), this call is not thread-safe.</i>
     * </p>
     *
     * @param ostream
     *            the output stream to write the XML-formatted data to.
     * @throws IOException
     *             if an error occurs while exporting.
     * @throws BackingStoreException
     *             if the backing store is unavailable or causes an operation
     *             failure.
     * @throws IllegalStateException
     *             if this node has been removed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.541 -0400", hash_original_method = "181B15E8E87ABB6DACA7AB74C1375D15", hash_generated_method = "1B15E1808524DA04F4FE03F87506E0BF")
    
public abstract void exportNode(OutputStream ostream) throws IOException, BackingStoreException;

    /**
     * Exports all of the preferences of this node and all its descendants to a
     * XML document using the given output stream.
     * <p>
     * This XML document uses the UTF-8 encoding and is written according to the
     * DTD in its DOCTYPE declaration, which is the following:
     *
     * <pre>
     * &lt;!DOCTYPE preferences SYSTEM &quot;http://java.sun.com/dtd/preferences.dtd&quot;&gt;
     * </pre>
     *
     * <i>Please note that (unlike the methods of this class that don't concern
     * serialization), this call is not thread-safe.</i>
     * </p>
     *
     * @param ostream
     *            the output stream to write the XML-formatted data to.
     * @throws IOException
     *             if an error occurs while exporting.
     * @throws BackingStoreException
     *             if the backing store is unavailable or causes an operation
     *             failure.
     * @throws IllegalStateException
     *             if this node has been removed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.542 -0400", hash_original_method = "43C4BD552087534D05153F9D7D1FD497", hash_generated_method = "04A95BF3921C7FE97C82395E14BC3304")
    
public abstract void exportSubtree(OutputStream ostream) throws IOException,
            BackingStoreException;

    /**
     * Forces all pending updates to this node and its descendants to be
     * persisted in the backing store.
     * <p>
     * If this node has been removed, the invocation of this method only flushes
     * this node, not its descendants.
     * </p>
     *
     * @throws BackingStoreException
     *             if the backing store is unavailable or causes an operation
     *             failure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.542 -0400", hash_original_method = "2F0C605B36E483B6D7E140817710ABD1", hash_generated_method = "54FF8B135A907244EC5F82A7E03A2D93")
    
public abstract void flush() throws BackingStoreException;

    /**
     * Gets the {@code String} value mapped to the given key or its default
     * value if no value is mapped or no backing store is available.
     * <p>
     * Some implementations may store default values in backing stores. In this
     * case, if there is no value mapped to the given key, the stored default
     * value is returned.
     * </p>
     *
     * @param key
     *            the preference key.
     * @param deflt
     *            the default value, which will be returned if no value is
     *            mapped to the given key or no backing store is available.
     * @return the preference value mapped to the given key.
     * @throws IllegalStateException
     *             if this node has been removed.
     * @throws NullPointerException
     *             if the parameter {@code key} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.542 -0400", hash_original_method = "EE931DE42C5703514E2CB89F8410866C", hash_generated_method = "8C3C88668D440F58DD19EE4F0F774FF1")
    
public abstract String get(String key, String deflt);

    /**
     * Gets the {@code boolean} value mapped to the given key or its default
     * value if no value is mapped, if the backing store is unavailable, or if
     * the value is invalid.
     * <p>
     * The only valid values are the {@code String} "true", which represents
     * {@code true} and "false", which represents {@code false}, ignoring case.
     * </p>
     * <p>
     * Some implementations may store default values in backing stores. In this
     * case, if there is no value mapped to the given key, the stored default
     * value is returned.
     * </p>
     *
     * @param key
     *            the preference key.
     * @param deflt
     *            the default value, which will be returned if no value is
     *            mapped to the given key, if the backing store is unavailable,
     *            or if the value is invalid.
     * @return the boolean value mapped to the given key.
     * @throws IllegalStateException
     *             if this node has been removed.
     * @throws NullPointerException
     *             if the parameter {@code key} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.543 -0400", hash_original_method = "758138F3CB803B12AB36D348E42C6E0C", hash_generated_method = "339F459EE54BC8E92930C17872901F8A")
    
public abstract boolean getBoolean(String key, boolean deflt);

    /**
     * Gets the {@code byte} array value mapped to the given key or its default
     * value if no value is mapped, if the backing store is unavailable, or if
     * the value is an invalid string.
     * <p>
     * To be valid, the value string must be Base64-encoded binary data. The
     * Base64 encoding is as defined in <a
     * href="http://www.ietf.org/rfc/rfc2045.txt">RFC 2045</a>, section 6.8.
     * </p>
     * <p>
     * Some implementations may store default values in backing stores. In this
     * case, if there is no value mapped to the given key, the stored default
     * value is returned.
     * </p>
     *
     * @param key
     *            the preference key.
     * @param deflt
     *            the default value, which will be returned if no value is
     *            mapped to the given key, if the backing store is unavailable,
     *            or if the value is invalid.
     * @return the byte array value mapped to the given key.
     * @throws IllegalStateException
     *             if this node has been removed.
     * @throws NullPointerException
     *             if the parameter {@code key} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.543 -0400", hash_original_method = "91A548F62145FE0A6FE0EA6B2DA0A2C2", hash_generated_method = "2C4D86B6C20575CB93FC90B2536A0E83")
    
public abstract byte[] getByteArray(String key, byte[] deflt);

    /**
     * Gets the {@code double} value mapped to the given key or its default
     * value if no value is mapped, if the backing store is unavailable, or if
     * the value is an invalid string.
     * <p>
     * To be valid, the value string must be a string that can be converted to a
     * {@code double} by {@link Double#parseDouble(String)
     * Double.parseDouble(String)}.
     * <p>
     * Some implementations may store default values in backing stores. In this
     * case, if there is no value mapped to the given key, the stored default
     * value is returned.
     * </p>
     *
     * @param key
     *            the preference key.
     * @param deflt
     *            the default value, which will be returned if no value is
     *            mapped to the given key, if the backing store is unavailable, or if the
     *            value is invalid.
     * @return the double value mapped to the given key.
     * @throws IllegalStateException
     *             if this node has been removed.
     * @throws NullPointerException
     *             if the parameter {@code key} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.544 -0400", hash_original_method = "89B77E666F697913E8874A56A04F5DB3", hash_generated_method = "22FCE9C4FE205419A210D552350873B5")
    
public abstract double getDouble(String key, double deflt);

    /**
     * Gets the {@code float} value mapped to the given key or its default value
     * if no value is mapped, if the backing store is unavailable, or if the
     * value is an invalid string.
     * <p>
     * To be valid, the value string must be a string that can be converted to a
     * {@code float} by {@link Float#parseFloat(String)
     * Float.parseFloat(String)}.
     * </p>
     * <p>
     * Some implementations may store default values in backing stores. In this
     * case, if there is no value mapped to the given key, the stored default
     * value is returned.
     * </p>
     *
     * @param key
     *            the preference key.
     * @param deflt
     *            the default value, which will be returned if no value is
     *            mapped to the given key, if the backing store is unavailable, or if the
     *            value is invalid.
     * @return the float value mapped to the given key.
     * @throws IllegalStateException
     *             if this node has been removed.
     * @throws NullPointerException
     *             if the parameter {@code key} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.544 -0400", hash_original_method = "08C9C73A7859347FEBCA7D7D72B639FE", hash_generated_method = "9CCA40AC2357EB890C89DD6B441A91BA")
    
public abstract float getFloat(String key, float deflt);

    /**
     * Gets the {@code int} value mapped to the given key or its default value
     * if no value is mapped, if the backing store is unavailable, or if the
     * value is an invalid string.
     * <p>
     * To be valid, the value string must be a string that can be converted to
     * an {@code int} by {@link Integer#parseInt(String)
     * Integer.parseInt(String)}.
     * </p>
     * <p>
     * Some implementations may store default values in backing stores. In this
     * case, if there is no value mapped to the given key, the stored default
     * value is returned.
     * </p>
     *
     * @param key
     *            the preference key.
     * @param deflt
     *            the default value, which will be returned if no value is
     *            mapped to the given key, if the backing store is unavailable,
     *            or if the value is invalid.
     * @return the integer value mapped to the given key.
     * @throws IllegalStateException
     *             if this node has been removed.
     * @throws NullPointerException
     *             if the parameter {@code key} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.545 -0400", hash_original_method = "7BB37224F5DB937D0DA109546D4D86BC", hash_generated_method = "7209E09BFC8B4AA177934E7A7571879D")
    
public abstract int getInt(String key, int deflt);

    /**
     * Gets the {@code long} value mapped to the given key or its default value
     * if no value is mapped, if the backing store is unavailable, or if the
     * value is an invalid string.
     * <p>
     * To be valid, the value string must be a string that can be converted to a
     * {@code long} by {@link Long#parseLong(String) Long.parseLong(String)}.
     * </p>
     * <p>
     * Some implementations may store default values in backing stores. In this
     * case, if there is no value mapped to the given key, the stored default
     * value is returned.
     * </p>
     *
     * @param key
     *            the preference key.
     * @param deflt
     *            the default value, which will be returned if no value is
     *            mapped to the given key, if the backing store is unavailable,
     *            or if the value is invalid.
     * @return the long value mapped to the given key.
     * @throws IllegalStateException
     *             if this node has been removed.
     * @throws NullPointerException
     *             if the parameter {@code key} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.545 -0400", hash_original_method = "B6717E9BA231D8A5E79A6650A8248A25", hash_generated_method = "517E5B62550AA6ACDF382E8847CAFAFB")
    
public abstract long getLong(String key, long deflt);

    /**
     * Returns whether this is a user preference node.
     *
     * @return {@code true}, if this is a user preference node, {@code false} if
     *         this is a system preference node.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.546 -0400", hash_original_method = "475FDD44C4480BB407713F103A3B514E", hash_generated_method = "9A2515099F6372428E3DE54EBB9CD2BF")
    
public abstract boolean isUserNode();

    /**
     * Returns all preference keys stored in this node or an empty array if no
     * key was found.
     *
     * @return the list of all preference keys of this node.
     * @throws BackingStoreException
     *             if the backing store is unavailable or causes an operation
     *             failure.
     * @throws IllegalStateException
     *             if this node has been removed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.546 -0400", hash_original_method = "57D6C0F003AADEFBA18E3B7D77A76168", hash_generated_method = "91E0AC9E230BA4E4A222637E9F8B6441")
    
public abstract String[] keys() throws BackingStoreException;

    /**
     * Returns the name of this node.
     *
     * @return the name of this node.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.547 -0400", hash_original_method = "59DC59559869131973EBA440F645EE9C", hash_generated_method = "EEA2E47D568357A6AE3CFCE2BCDC0A75")
    
public abstract String name();

    /**
     * Returns the preference node with the given path name. The path name can
     * be relative or absolute. The requested node and its ancestors will
     * be created if they do not exist.
     * <p>
     * The path is treated as relative to this node if it doesn't start with a
     * slash, otherwise it will be treated as an absolute path.
     * </p>
     *
     * @param path
     *            the path name of the requested preference node.
     * @return the requested preference node.
     * @throws IllegalStateException
     *             if this node has been removed.
     * @throws IllegalArgumentException
     *             if the path name is invalid.
     * @throws NullPointerException
     *             if the given path is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.547 -0400", hash_original_method = "FA03310188118606A4C8C17E5F262B3D", hash_generated_method = "A17AF8157F6B64EA9A96800FBD24F60A")
    
public abstract Preferences node(String path);

    /**
     * Returns whether the preference node with the given path name exists. The
     * path is treated as relative to this node if it doesn't start with a slash,
     * otherwise it is treated as an absolute path.
     * <p>
     * Please note that if this node has been removed, an invocation of this
     * node will throw an {@code IllegalStateException} unless the given path is
     * an empty string, which will return {@code false}.
     * </p>
     *
     * @param path
     *            the path name of the preference node to query.
     * @return {@code true}, if the queried preference node exists, {@code false}
     *         otherwise.
     * @throws IllegalStateException
     *             if this node has been removed and the path is not an empty
     *             string.
     * @throws IllegalArgumentException
     *             if the path name is invalid.
     * @throws NullPointerException
     *             if the given path is {@code null}.
     * @throws BackingStoreException
     *             if the backing store is unavailable or causes an operation
     *             failure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.547 -0400", hash_original_method = "EC97540EFF7053FE86C5D71802F601F4", hash_generated_method = "CD3D7A5871AF5D942593D51DB8007B1A")
    
public abstract boolean nodeExists(String path) throws BackingStoreException;

    /**
     * Returns the parent preference node of this node or {@code null} if this
     * node is the root node.
     *
     * @return the parent preference node of this node.
     * @throws IllegalStateException
     *             if this node has been removed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.547 -0400", hash_original_method = "F54902CC6AF0903249535A5C29D1D2B4", hash_generated_method = "23F3D24056A0E94444204E17E314B64C")
    
public abstract Preferences parent();

    /**
     * Adds a new preference to this node using the given key and value or
     * updates the value if a preference with the given key already exists.
     *
     * @param key
     *            the preference key to be added or updated.
     * @param value
     *            the preference value for the given key.
     * @throws NullPointerException
     *             if the given key or value is {@code null}.
     * @throws IllegalArgumentException
     *             if the given key's length is bigger than {@code
     *             MAX_KEY_LENGTH} or the value's length is bigger than {@code
     *             MAX_VALUE_LENGTH}.
     * @throws IllegalStateException
     *             if this node has been removed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.548 -0400", hash_original_method = "257AB3B50849626914FA6EFED91223BD", hash_generated_method = "B8538008DF44DA30777D903708E04477")
    
public abstract void put(String key, String value);

    /**
     * Adds a new preference with a {@code boolean} value to this node using the
     * given key and value or updates the value if a preference with the given
     * key already exists.
     *
     * @param key
     *            the preference key to be added or updated.
     * @param value
     *            the preference {@code boolean} value for the given key.
     * @throws NullPointerException
     *             if the given key is {@code null}.
     * @throws IllegalArgumentException
     *             if the given key's length is bigger than {@code
     *             MAX_KEY_LENGTH}.
     * @throws IllegalStateException
     *             if this node has been removed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.548 -0400", hash_original_method = "CBF059B658ED923759D70CFF63C6876C", hash_generated_method = "64A76F177AF5386B02AC2C7EEEB5239D")
    
public abstract void putBoolean(String key, boolean value);

    /**
     * Adds a new preference to this node using the given key and the string
     * form of the given value or updates the value if a preference with the
     * given key already exists.
     * <p>
     * The string form of the value is the Base64-encoded binary data of the
     * given byte array. The Base64 encoding is as defined in <a
     * href="http://www.ietf.org/rfc/rfc2045.txt">RFC 2045</a>, section 6.8.
     * </p>
     *
     * @param key
     *            the preference key to be added or updated.
     * @param value
     *            the preference value for the given key.
     * @throws NullPointerException
     *             if the given key or value is {@code null}.
     * @throws IllegalArgumentException
     *             if the given key's length is bigger than {@code
     *             MAX_KEY_LENGTH} or value's length is bigger than three
     *             quarters of {@code MAX_KEY_LENGTH}.
     * @throws IllegalStateException
     *             if this node has been removed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.548 -0400", hash_original_method = "1FFC62375FCE10F5895AB64D8D33C2CA", hash_generated_method = "A16059A2E03C07FBCB166B3BC09DE8D2")
    
public abstract void putByteArray(String key, byte[] value);

    /**
     * Adds a new preference to this node using the given key and {@code double}
     * value or updates the value if a preference with the
     * given key already exists.
     * <p>
     * The value is stored in its string form, which is the result of invoking
     * {@link Double#toString(double) Double.toString(double)}.
     * </p>
     *
     * @param key
     *            the preference key to be added or updated.
     * @param value
     *            the preference value for the given key.
     * @throws NullPointerException
     *             if the given key is {@code null}.
     * @throws IllegalArgumentException
     *             if the given key's length is bigger than {@code
     *             MAX_KEY_LENGTH}.
     * @throws IllegalStateException
     *             if this node has been removed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.549 -0400", hash_original_method = "FA612F060939EF8FB370823B22ED0A69", hash_generated_method = "E88EABB7748D05252CD6F5C615D53F1D")
    
public abstract void putDouble(String key, double value);

    /**
     * Adds a new preference to this node using the given key and {@code float}
     * value or updates the value if a preference with the
     * given key already exists.
     * <p>
     * The value is stored in its string form, which is the result of invoking
     * {@link Float#toString(float) Float.toString(float)}.
     * </p>
     *
     * @param key
     *            the preference key to be added or updated.
     * @param value
     *            the preference value for the given key.
     * @throws NullPointerException
     *             if the given key is {@code null}.
     * @throws IllegalArgumentException
     *             if the given key's length is bigger than {@code
     *             MAX_KEY_LENGTH}.
     * @throws IllegalStateException
     *             if this node has been removed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.549 -0400", hash_original_method = "4B2383188C58F5737A2D6D5361C4CE95", hash_generated_method = "827C35B8884C258B6B7DA848E16F7474")
    
public abstract void putFloat(String key, float value);

    /**
     * Adds a new preference to this node using the given key and {@code int}
     * value or updates the value if a preference with the
     * given key already exists.
     * <p>
     * The value is stored in its string form, which is the result of invoking
     * {@link Integer#toString(int) Integer.toString(int)}.
     * </p>
     *
     * @param key
     *            the preference key to be added or updated.
     * @param value
     *            the preference value for the given key.
     * @throws NullPointerException
     *             if the given key is {@code null}.
     * @throws IllegalArgumentException
     *             if the given key's length is bigger than {@code
     *             MAX_KEY_LENGTH}.
     * @throws IllegalStateException
     *             if this node has been removed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.549 -0400", hash_original_method = "F39D8FB6015A2A4376BD7AF0F2773F7F", hash_generated_method = "426BCFC6351854F4BE579B4E3339FADF")
    
public abstract void putInt(String key, int value);

    /**
     * Adds a new preference to this node using the given key and {@code long}
     * value or updates the value if a preference with the
     * given key already exists.
     * <p>
     * The value is stored in its string form, which is the result of invoking
     * {@link Long#toString(long) Long.toString(long)}.
     * </p>
     *
     * @param key
     *            the preference key to be added or updated.
     * @param value
     *            the preference value for the given key.
     * @throws NullPointerException
     *             if the given key is {@code null}.
     * @throws IllegalArgumentException
     *             if the given key's length is bigger than {@code
     *             MAX_KEY_LENGTH}.
     * @throws IllegalStateException
     *             if this node has been removed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.550 -0400", hash_original_method = "439D3AA3E2B2775DD68872895507EB5B", hash_generated_method = "FF8DB265FF1186057E95BE117F6D494E")
    
public abstract void putLong(String key, long value);

    /**
     * Removes the preference mapped to the given key from this node.
     *
     * @param key
     *            the key of the preference to be removed.
     * @throws NullPointerException
     *             if the given key is {@code null}.
     * @throws IllegalStateException
     *             if this node has been removed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.550 -0400", hash_original_method = "C7F0AF23F3A46FDFBA57DAC8E1EC6EDD", hash_generated_method = "F1970EC781E3D8230E4B77B91468C2FD")
    
public abstract void remove(String key);

    /**
     * Removes this preference node with all its descendants. The removal won't
     * necessarily be persisted until the method {@code flush()} is invoked.
     *
     * @throws BackingStoreException
     *             if the backing store is unavailable or causes an operation
     *             failure.
     * @throws IllegalStateException
     *             if this node has been removed.
     * @throws UnsupportedOperationException
     *             if this is a root node.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.550 -0400", hash_original_method = "926AF3082D36C231542AA6B975ACE2CB", hash_generated_method = "8F997E0A088CAA16866540CC8B6E4283")
    
public abstract void removeNode() throws BackingStoreException;

    /**
     * Registers a {@code NodeChangeListener} instance for this node, which will
     * handle {@code NodeChangeEvent}s. {@code NodeChangeEvent}s will be fired
     * when a child node has been added to or removed from this node.
     *
     * @param ncl
     *            the listener to be registered.
     * @throws NullPointerException
     *             if the given listener is {@code null}.
     * @throws IllegalStateException
     *             if this node has been removed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.551 -0400", hash_original_method = "405826F6565BE1534373103749CD4708", hash_generated_method = "6075BC861B87D4BFFC11D6605581F7C1")
    
public abstract void addNodeChangeListener(NodeChangeListener ncl);

    /**
     * Registers a {@code PreferenceChangeListener} instance for this node,
     * which will handle {@code PreferenceChangeEvent}s. {@code
     * PreferenceChangeEvent}s will be fired when a preference has been added
     * to, removed from, or updated for this node.
     *
     * @param pcl
     *            the listener to be registered.
     * @throws NullPointerException
     *             if the given listener is {@code null}.
     * @throws IllegalStateException
     *             if this node has been removed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.551 -0400", hash_original_method = "E90B90A7BE152CD0C204DA806D8E337D", hash_generated_method = "1C562E4807635F4F9BDA0793D96FFCDC")
    
public abstract void addPreferenceChangeListener (PreferenceChangeListener pcl);

    /**
     * Removes the given {@code NodeChangeListener} instance from this node.
     *
     * @param ncl
     *            the listener to be removed.
     * @throws IllegalArgumentException
     *             if the given listener is {@code null}.
     * @throws IllegalStateException
     *             if this node has been removed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.551 -0400", hash_original_method = "4203AE6EFE46CDC4F16FA259DE2B93AA", hash_generated_method = "D916857F9AB55FA5E6F2F96B7C459861")
    
public abstract void removeNodeChangeListener (NodeChangeListener ncl);

    /**
     * Removes the given {@code PreferenceChangeListener} instance from this
     * node.
     *
     * @param pcl
     *            the listener to be removed.
     * @throws IllegalArgumentException
     *             if the given listener is {@code null}.
     * @throws IllegalStateException
     *             if this node has been removed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.552 -0400", hash_original_method = "E90CBF9864712464F5CC00EB87521744", hash_generated_method = "7D332D6646B319AA1BB6A60F697CDE01")
    
public abstract void removePreferenceChangeListener (PreferenceChangeListener pcl);

    /**
     * Synchronizes the data of this preference node and its descendants with
     * the back-end preference store. Any changes found in the back-end data
     * should be reflected in this node and its descendants, and at the same
     * time any local changes to this node and descendants should be persisted.
     *
     * @throws BackingStoreException
     *             if the backing store is unavailable or causes an operation
     *             failure.
     * @throws IllegalStateException
     *             if this node has been removed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.552 -0400", hash_original_method = "440C1F99FCB6667641C4F5F89DC4532C", hash_generated_method = "131F28E7442F303E1FD0ADB560F2A4E4")
    
public abstract void sync() throws BackingStoreException;

    /**
     * Returns a string representation of this node. The format is "User/System
     * Preference Node: " followed by this node's absolute path.
     *
     * @return the string representation of this node.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:10.554 -0400", hash_original_method = "D4E4943029EE450E10D723A13B21ADBA", hash_generated_method = "756F2EF371660D429BB5FEF72144B300")
    
@Override
    public abstract String toString();
}
