package org.xml.sax.helpers;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.Enumeration;
import java.util.Hashtable;

public class NamespaceSupport {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.354 -0500", hash_original_field = "8DE519BED5914C49639CE7F2987B16A9", hash_generated_field = "8DEE82483ED300797D3AA22429D118FC")

    // Constants.
    ////////////////////////////////////////////////////////////////////

    /**
     * The XML Namespace URI as a constant.
     * The value is <code>http://www.w3.org/XML/1998/namespace</code>
     * as defined in the "Namespaces in XML" * recommendation.
     *
     * <p>This is the Namespace URI that is automatically mapped
     * to the "xml" prefix.</p>
     */
    public static final String XMLNS =
    "http://www.w3.org/XML/1998/namespace";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.356 -0500", hash_original_field = "6AF3D2D1B4B66E8926720CD35978907B", hash_generated_field = "1571E423031924244408A7D28A741EE6")

    public static final String NSDECL =
    "http://www.w3.org/xmlns/2000/";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.359 -0500", hash_original_field = "77C5D95C23E8F8DBCEF901F7E769F074", hash_generated_field = "0A58893494FE31226DF50FC333D4E439")

    private static final Enumeration EMPTY_ENUMERATION = Collections.enumeration(Collections.emptyList());
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.394 -0500", hash_original_field = "1BF4BE8B5196A638FAE1357682005778", hash_generated_field = "8497C1EFA9FA325954ED265655983D38")

    // Internal state.
    ////////////////////////////////////////////////////////////////////

    private Context contexts[];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.396 -0500", hash_original_field = "4B8A3454CE5D1D0E620985BEFF8A3F3F", hash_generated_field = "16BCC2B5B5C19EE2FA8800AE041E507F")

    private Context currentContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.399 -0500", hash_original_field = "CC6B826D976681D593BC01B528C28600", hash_generated_field = "6E7F5C2FF9D13C809071AD4BD4B43575")

    private int contextPos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.401 -0500", hash_original_field = "7ADEFCE56A5E80EE0DB8462716E759B4", hash_generated_field = "93D47AA8737E27469EC5299DD6FB86D0")

    private boolean namespaceDeclUris;

    ////////////////////////////////////////////////////////////////////
    // Constructor.
    ////////////////////////////////////////////////////////////////////

    /**
     * Create a new Namespace support object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.362 -0500", hash_original_method = "1F62AD2938072A93E19EAFFCDA555D07", hash_generated_method = "E522C6EE17CC779935F0D04DE1F1F350")
    
public NamespaceSupport ()
    {
    reset();
    }

    ////////////////////////////////////////////////////////////////////
    // Context management.
    ////////////////////////////////////////////////////////////////////

    /**
     * Reset this Namespace support object for reuse.
     *
     * <p>It is necessary to invoke this method before reusing the
     * Namespace support object for a new session.  If namespace
     * declaration URIs are to be supported, that flag must also
     * be set to a non-default value.
     * </p>
     *
     * @see #setNamespaceDeclUris
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.364 -0500", hash_original_method = "2A27A75937E4BE02DA5FD7B031C4079A", hash_generated_method = "23BC72FFEAC2A16A0D3A8E2F49EBED8E")
    
public void reset ()
    {
    contexts = new Context[32];
    namespaceDeclUris = false;
    contextPos = 0;
    contexts[contextPos] = currentContext = new Context();
    currentContext.declarePrefix("xml", XMLNS);
    }

    /**
     * Start a new Namespace context.
     * The new context will automatically inherit
     * the declarations of its parent context, but it will also keep
     * track of which declarations were made within this context.
     *
     * <p>Event callback code should start a new context once per element.
     * This means being ready to call this in either of two places.
     * For elements that don't include namespace declarations, the
     * <em>ContentHandler.startElement()</em> callback is the right place.
     * For elements with such a declaration, it'd done in the first
     * <em>ContentHandler.startPrefixMapping()</em> callback.
     * A boolean flag can be used to
     * track whether a context has been started yet.  When either of
     * those methods is called, it checks the flag to see if a new context
     * needs to be started.  If so, it starts the context and sets the
     * flag.  After <em>ContentHandler.startElement()</em>
     * does that, it always clears the flag.
     *
     * <p>Normally, SAX drivers would push a new context at the beginning
     * of each XML element.  Then they perform a first pass over the
     * attributes to process all namespace declarations, making
     * <em>ContentHandler.startPrefixMapping()</em> callbacks.
     * Then a second pass is made, to determine the namespace-qualified
     * names for all attributes and for the element name.
     * Finally all the information for the
     * <em>ContentHandler.startElement()</em> callback is available,
     * so it can then be made.
     *
     * <p>The Namespace support object always starts with a base context
     * already in force: in this context, only the "xml" prefix is
     * declared.</p>
     *
     * @see org.xml.sax.ContentHandler
     * @see #popContext
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.367 -0500", hash_original_method = "B186F7F0BF353B1A746862E337C50A69", hash_generated_method = "7727160CCA8A9EE39BE8CC36CB939BC2")
    
public void pushContext ()
    {
    int max = contexts.length;

    contexts [contextPos].declsOK = false;
    contextPos++;

                // Extend the array if necessary
    if (contextPos >= max) {
        Context newContexts[] = new Context[max*2];
        System.arraycopy(contexts, 0, newContexts, 0, max);
        max *= 2;
        contexts = newContexts;
    }

                // Allocate the context if necessary.
    currentContext = contexts[contextPos];
    if (currentContext == null) {
        contexts[contextPos] = currentContext = new Context();
    }

                // Set the parent, if any.
    if (contextPos > 0) {
        currentContext.setParent(contexts[contextPos - 1]);
    }
    }

    /**
     * Revert to the previous Namespace context.
     *
     * <p>Normally, you should pop the context at the end of each
     * XML element.  After popping the context, all Namespace prefix
     * mappings that were previously in force are restored.</p>
     *
     * <p>You must not attempt to declare additional Namespace
     * prefixes after popping a context, unless you push another
     * context first.</p>
     *
     * @see #pushContext
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.369 -0500", hash_original_method = "D28ACF4ED7DED6C7ED370F52380381BA", hash_generated_method = "21646247B3F1AB7BA202FFA1C126FBBF")
    
public void popContext ()
    {
    contexts[contextPos].clear();
    contextPos--;
    if (contextPos < 0) {
        throw new EmptyStackException();
    }
    currentContext = contexts[contextPos];
    }

    ////////////////////////////////////////////////////////////////////
    // Operations within a context.
    ////////////////////////////////////////////////////////////////////

    /**
     * Declare a Namespace prefix.  All prefixes must be declared
     * before they are referenced.  For example, a SAX driver (parser)
     * would scan an element's attributes
     * in two passes:  first for namespace declarations,
     * then a second pass using {@link #processName processName()} to
     * interpret prefixes against (potentially redefined) prefixes.
     *
     * <p>This method declares a prefix in the current Namespace
     * context; the prefix will remain in force until this context
     * is popped, unless it is shadowed in a descendant context.</p>
     *
     * <p>To declare the default element Namespace, use the empty string as
     * the prefix.</p>
     *
     * <p>Note that you must <em>not</em> declare a prefix after
     * you've pushed and popped another Namespace context, or
     * treated the declarations phase as complete by processing
     * a prefixed name.</p>
     *
     * <p>Note that there is an asymmetry in this library: {@link
     * #getPrefix getPrefix} will not return the "" prefix,
     * even if you have declared a default element namespace.
     * To check for a default namespace,
     * you have to look it up explicitly using {@link #getURI getURI}.
     * This asymmetry exists to make it easier to look up prefixes
     * for attribute names, where the default prefix is not allowed.</p>
     *
     * @param prefix The prefix to declare, or the empty string to
     *    indicate the default element namespace.  This may never have
     *    the value "xml" or "xmlns".
     * @param uri The Namespace URI to associate with the prefix.
     * @return true if the prefix was legal, false otherwise
     *
     * @see #processName
     * @see #getURI
     * @see #getPrefix
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.372 -0500", hash_original_method = "90A3EE210CAE689DFC3CD58893529A76", hash_generated_method = "0600ACAE5A6A3ED2A754973DEE4FC515")
    
public boolean declarePrefix (String prefix, String uri)
    {
    if (prefix.equals("xml") || prefix.equals("xmlns")) {
        return false;
    } else {
        currentContext.declarePrefix(prefix, uri);
        return true;
    }
    }

    /**
     * Process a raw XML qualified name, after all declarations in the
     * current context have been handled by {@link #declarePrefix
     * declarePrefix()}.
     *
     * <p>This method processes a raw XML qualified name in the
     * current context by removing the prefix and looking it up among
     * the prefixes currently declared.  The return value will be the
     * array supplied by the caller, filled in as follows:</p>
     *
     * <dl>
     * <dt>parts[0]</dt>
     * <dd>The Namespace URI, or an empty string if none is
     *  in use.</dd>
     * <dt>parts[1]</dt>
     * <dd>The local name (without prefix).</dd>
     * <dt>parts[2]</dt>
     * <dd>The original raw name.</dd>
     * </dl>
     *
     * <p>All of the strings in the array will be internalized.  If
     * the raw name has a prefix that has not been declared, then
     * the return value will be null.</p>
     *
     * <p>Note that attribute names are processed differently than
     * element names: an unprefixed element name will receive the
     * default Namespace (if any), while an unprefixed attribute name
     * will not.</p>
     *
     * @param qName The XML qualified name to be processed.
     * @param parts An array supplied by the caller, capable of
     *        holding at least three members.
     * @param isAttribute A flag indicating whether this is an
     *        attribute name (true) or an element name (false).
     * @return The supplied array holding three internalized strings
     *        representing the Namespace URI (or empty string), the
     *        local name, and the XML qualified name; or null if there
     *        is an undeclared prefix.
     * @see #declarePrefix
     * @see java.lang.String#intern */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.374 -0500", hash_original_method = "568BC23E816C8735D1D944210F1F3C08", hash_generated_method = "E4254185344404BDB9DC61A69485A76A")
    
public String [] processName (String qName, String parts[],
                  boolean isAttribute)
    {
    String myParts[] = currentContext.processName(qName, isAttribute);
    if (myParts == null) {
        return null;
    } else {
        parts[0] = myParts[0];
        parts[1] = myParts[1];
        parts[2] = myParts[2];
        return parts;
    }
    }

    /**
     * Look up a prefix and get the currently-mapped Namespace URI.
     *
     * <p>This method looks up the prefix in the current context.
     * Use the empty string ("") for the default Namespace.</p>
     *
     * @param prefix The prefix to look up.
     * @return The associated Namespace URI, or null if the prefix
     *         is undeclared in this context.
     * @see #getPrefix
     * @see #getPrefixes
     */
    @DSSource({DSSourceKind.FILE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.376 -0500", hash_original_method = "AC6673E983BE229DBE393CCBB4A72E75", hash_generated_method = "03FD0CE5F473571E708DB9317FA1B856")
    
public String getURI (String prefix)
    {
    return currentContext.getURI(prefix);
    }

    /**
     * Return an enumeration of all prefixes whose declarations are
     * active in the current context.
     * This includes declarations from parent contexts that have
     * not been overridden.
     *
     * <p><strong>Note:</strong> if there is a default prefix, it will not be
     * returned in this enumeration; check for the default prefix
     * using the {@link #getURI getURI} with an argument of "".</p>
     *
     * @return An enumeration of prefixes (never empty).
     * @see #getDeclaredPrefixes
     * @see #getURI
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.379 -0500", hash_original_method = "A5B18FED447546E052ABC48FA9E4C291", hash_generated_method = "13E9351D9FFB02163EC2102FAB7D1318")
    
public Enumeration getPrefixes ()
    {
    return currentContext.getPrefixes();
    }

    /**
     * Return one of the prefixes mapped to a Namespace URI.
     *
     * <p>If more than one prefix is currently mapped to the same
     * URI, this method will make an arbitrary selection; if you
     * want all of the prefixes, use the {@link #getPrefixes}
     * method instead.</p>
     *
     * <p><strong>Note:</strong> this will never return the empty (default) prefix;
     * to check for a default prefix, use the {@link #getURI getURI}
     * method with an argument of "".</p>
     *
     * @param uri the namespace URI
     * @return one of the prefixes currently mapped to the URI supplied,
     *         or null if none is mapped or if the URI is assigned to
     *         the default namespace
     * @see #getPrefixes(java.lang.String)
     * @see #getURI
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.381 -0500", hash_original_method = "EEA9ABC8ACBC17B2454F5F5D40E93A34", hash_generated_method = "1B0C362F53E442DD756F1F73E397C763")
    
public String getPrefix (String uri)
    {
    return currentContext.getPrefix(uri);
    }

    /**
     * Return an enumeration of all prefixes for a given URI whose
     * declarations are active in the current context.
     * This includes declarations from parent contexts that have
     * not been overridden.
     *
     * <p>This method returns prefixes mapped to a specific Namespace
     * URI.  The xml: prefix will be included.  If you want only one
     * prefix that's mapped to the Namespace URI, and you don't care
     * which one you get, use the {@link #getPrefix getPrefix}
     *  method instead.</p>
     *
     * <p><strong>Note:</strong> the empty (default) prefix is <em>never</em> included
     * in this enumeration; to check for the presence of a default
     * Namespace, use the {@link #getURI getURI} method with an
     * argument of "".</p>
     *
     * @param uri The Namespace URI.
     * @return An enumeration of prefixes (never empty).
     * @see #getPrefix
     * @see #getDeclaredPrefixes
     * @see #getURI
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.384 -0500", hash_original_method = "E9FAC6924E2013A13EA977C97AEA2AF7", hash_generated_method = "2916EBF06540C1330069ED9DE88433E1")
    
public Enumeration getPrefixes(String uri) {
        ArrayList<String> prefixes = new ArrayList<String>();
        Enumeration allPrefixes = getPrefixes();
        while (allPrefixes.hasMoreElements()) {
            String prefix = (String) allPrefixes.nextElement();
            if (uri.equals(getURI(prefix))) {
                prefixes.add(prefix);
            }
        }
        return Collections.enumeration(prefixes);
    }
    
    final class Context {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.428 -0500", hash_original_field = "CF0B92985AF9DC8DD4202061605E7021", hash_generated_field = "D4510924EB225588E6B0EC7DDBD1B6B6")

    // Protected state.
    ////////////////////////////////////////////////////////////////

    Hashtable prefixTable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.431 -0500", hash_original_field = "40686847BD0275762FCF55168889D3C9", hash_generated_field = "40686847BD0275762FCF55168889D3C9")

    Hashtable uriTable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.434 -0500", hash_original_field = "90E334191890A4914B17EA7FAF986992", hash_generated_field = "90E334191890A4914B17EA7FAF986992")

    Hashtable elementNameTable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.436 -0500", hash_original_field = "F042A8F63CE2471660EB97BB2E6F44AE", hash_generated_field = "F042A8F63CE2471660EB97BB2E6F44AE")

    Hashtable attributeNameTable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.438 -0500", hash_original_field = "8E657056ECC4C162CFF6080FBFCD63F6", hash_generated_field = "8E657056ECC4C162CFF6080FBFCD63F6")

    String defaultNS = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.440 -0500", hash_original_field = "E1C9F736B16FF7122A0BB4347159B956", hash_generated_field = "E1C9F736B16FF7122A0BB4347159B956")

    boolean declsOK = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.442 -0500", hash_original_field = "121FA267850D1F940635A7F4BA9985BA", hash_generated_field = "FC055A3C6E1CD8E2D34929A4B3D42721")

    // Internal state.
    ////////////////////////////////////////////////////////////////

    private ArrayList<String> declarations = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.445 -0500", hash_original_field = "9015D8BA134276FB259AAE9E5030140F", hash_generated_field = "98CD992C81C807EFBCB961B2F6E16972")

    private boolean declSeen = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.447 -0500", hash_original_field = "6DF678280DC762759E031118D14107E3", hash_generated_field = "1E04AB28ECFE4BCC38F06ACD519BB459")

    private Context parent = null;

    /**
     * Create the root-level Namespace context.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.404 -0500", hash_original_method = "CD5C82C799E78C74801FDB521CEE7324", hash_generated_method = "CD5C82C799E78C74801FDB521CEE7324")
        
Context ()
    {
        copyTables();
    }

    /**
     * (Re)set the parent of this Namespace context.
     * The context must either have been freshly constructed,
     * or must have been cleared.
     *
     * @param context The parent Namespace context object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.406 -0500", hash_original_method = "E1D3B844E1B48DBC46153D5E5632428F", hash_generated_method = "E1D3B844E1B48DBC46153D5E5632428F")
        
void setParent (Context parent)
    {
        this.parent = parent;
        declarations = null;
        prefixTable = parent.prefixTable;
        uriTable = parent.uriTable;
        elementNameTable = parent.elementNameTable;
        attributeNameTable = parent.attributeNameTable;
        defaultNS = parent.defaultNS;
        declSeen = false;
        declsOK = true;
    }

    /**
     * Makes associated state become collectible,
     * invalidating this context.
     * {@link #setParent} must be called before
     * this context may be used again.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.408 -0500", hash_original_method = "9488BC4AFF7634EA1262BEB181C9541E", hash_generated_method = "9488BC4AFF7634EA1262BEB181C9541E")
        
void clear ()
    {
        parent = null;
        prefixTable = null;
        uriTable = null;
        elementNameTable = null;
        attributeNameTable = null;
        defaultNS = null;
    }

    /**
     * Declare a Namespace prefix for this context.
     *
     * @param prefix The prefix to declare.
     * @param uri The associated Namespace URI.
     * @see org.xml.sax.helpers.NamespaceSupport#declarePrefix
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.411 -0500", hash_original_method = "4549801F41C68E0A6A490696C062C72D", hash_generated_method = "8B62B5695F36760CAD8EDCDC235C2C64")
        
void declarePrefix(String prefix, String uri) {
        // Lazy processing...
        if (!declsOK) {
            throw new IllegalStateException ("can't declare any more prefixes in this context");
        }
        if (!declSeen) {
            copyTables();
        }
        if (declarations == null) {
            declarations = new ArrayList<String>();
        }

        prefix = prefix.intern();
        uri = uri.intern();
        if ("".equals(prefix)) {
            if ("".equals(uri)) {
                defaultNS = null;
            } else {
                defaultNS = uri;
            }
        } else {
            prefixTable.put(prefix, uri);
            uriTable.put(uri, prefix); // may wipe out another prefix
        }
        declarations.add(prefix);
    }

    /**
     * Process an XML qualified name in this context.
     *
     * @param qName The XML qualified name.
     * @param isAttribute true if this is an attribute name.
     * @return An array of three strings containing the
     *         URI part (or empty string), the local part,
     *         and the raw name, all internalized, or null
     *         if there is an undeclared prefix.
     * @see org.xml.sax.helpers.NamespaceSupport#processName
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.414 -0500", hash_original_method = "33259345EBD99FFF49F4E1AAD2529013", hash_generated_method = "296CADF2DCFE4D340DC221E4F2AE1D69")
        
String [] processName (String qName, boolean isAttribute)
    {
        String name[];
        Hashtable table;

                    // detect errors in call sequence
        declsOK = false;

                // Select the appropriate table.
        if (isAttribute) {
        table = attributeNameTable;
        } else {
        table = elementNameTable;
        }

                // Start by looking in the cache, and
                // return immediately if the name
                // is already known in this content
        name = (String[])table.get(qName);
        if (name != null) {
        return name;
        }

                // We haven't seen this name in this
                // context before.  Maybe in the parent
                // context, but we can't assume prefix
                // bindings are the same.
        name = new String[3];
        name[2] = qName.intern();
        int index = qName.indexOf(':');

                // No prefix.
        if (index == -1) {
        if (isAttribute) {
            if (qName == "xmlns" && namespaceDeclUris)
            name[0] = NSDECL;
            else
            name[0] = "";
        } else if (defaultNS == null) {
            name[0] = "";
        } else {
            name[0] = defaultNS;
        }
        name[1] = name[2];
        }

                // Prefix
        else {
        String prefix = qName.substring(0, index);
        String local = qName.substring(index+1);
        String uri;
        if ("".equals(prefix)) {
            uri = defaultNS;
        } else {
            uri = (String)prefixTable.get(prefix);
        }
        if (uri == null
            || (!isAttribute && "xmlns".equals (prefix))) {
            return null;
        }
        name[0] = uri;
        name[1] = local.intern();
        }

                // Save in the cache for future use.
                // (Could be shared with parent context...)
        table.put(name[2], name);
        return name;
    }

    /**
     * Look up the URI associated with a prefix in this context.
     *
     * @param prefix The prefix to look up.
     * @return The associated Namespace URI, or null if none is
     *         declared.
     * @see org.xml.sax.helpers.NamespaceSupport#getURI
     */
    @DSSource({DSSourceKind.FILE_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.417 -0500", hash_original_method = "33F968ABABCEBD2BA0661937EB8377F0", hash_generated_method = "33F968ABABCEBD2BA0661937EB8377F0")
        
String getURI (String prefix)
    {
        if ("".equals(prefix)) {
        return defaultNS;
        } else if (prefixTable == null) {
        return null;
        } else {
        return (String)prefixTable.get(prefix);
        }
    }

    /**
     * Look up one of the prefixes associated with a URI in this context.
     *
     * <p>Since many prefixes may be mapped to the same URI,
     * the return value may be unreliable.</p>
     *
     * @param uri The URI to look up.
     * @return The associated prefix, or null if none is declared.
     * @see org.xml.sax.helpers.NamespaceSupport#getPrefix
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.419 -0500", hash_original_method = "62121EA4CFF0891BFB2032F7AF8FE7A1", hash_generated_method = "62121EA4CFF0891BFB2032F7AF8FE7A1")
        
String getPrefix (String uri)
    {
        if (uriTable == null) {
        return null;
        } else {
        return (String)uriTable.get(uri);
        }
    }

    /**
     * Return an enumeration of prefixes declared in this context.
     *
     * @return An enumeration of prefixes (possibly empty).
     * @see org.xml.sax.helpers.NamespaceSupport#getDeclaredPrefixes
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.421 -0500", hash_original_method = "B116CF358C1D0DA8CF46DFF106939FC0", hash_generated_method = "B116CF358C1D0DA8CF46DFF106939FC0")
        
Enumeration getDeclaredPrefixes() {
        return (declarations == null) ? EMPTY_ENUMERATION : Collections.enumeration(declarations);
    }

    /**
     * Return an enumeration of all prefixes currently in force.
     *
     * <p>The default prefix, if in force, is <em>not</em>
     * returned, and will have to be checked for separately.</p>
     *
     * @return An enumeration of prefixes (never empty).
     * @see org.xml.sax.helpers.NamespaceSupport#getPrefixes
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.423 -0500", hash_original_method = "D02303EBFA8DB4A97AF291339C2FB52B", hash_generated_method = "D02303EBFA8DB4A97AF291339C2FB52B")
        
Enumeration getPrefixes ()
    {
        if (prefixTable == null) {
        return EMPTY_ENUMERATION;
        } else {
        return prefixTable.keys();
        }
    }

    ////////////////////////////////////////////////////////////////
    // Internal methods.
    ////////////////////////////////////////////////////////////////

    /**
     * Copy on write for the internal tables in this context.
     *
     * <p>This class is optimized for the normal case where most
     * elements do not contain Namespace declarations.</p>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.426 -0500", hash_original_method = "26D71A046B8A5E21DEFC65FB89CD9FDA", hash_generated_method = "2293476E78FCC8BDA181F927AEA93BD1")
        
private void copyTables ()
    {
        if (prefixTable != null) {
        prefixTable = (Hashtable)prefixTable.clone();
        } else {
        prefixTable = new Hashtable();
        }
        if (uriTable != null) {
        uriTable = (Hashtable)uriTable.clone();
        } else {
        uriTable = new Hashtable();
        }
        elementNameTable = new Hashtable();
        attributeNameTable = new Hashtable();
        declSeen = true;
    }
        
    }

    /**
     * Return an enumeration of all prefixes declared in this context.
     *
     * <p>The empty (default) prefix will be included in this
     * enumeration; note that this behaviour differs from that of
     * {@link #getPrefix} and {@link #getPrefixes}.</p>
     *
     * @return An enumeration of all prefixes declared in this
     *         context.
     * @see #getPrefixes
     * @see #getURI
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.386 -0500", hash_original_method = "410BA98433560BB4462E66EC18960649", hash_generated_method = "4A7CDE4864CE969CC5C614E3BC067989")
    
public Enumeration getDeclaredPrefixes ()
    {
    return currentContext.getDeclaredPrefixes();
    }

    /**
     * Controls whether namespace declaration attributes are placed
     * into the {@link #NSDECL NSDECL} namespace
     * by {@link #processName processName()}.  This may only be
     * changed before any contexts have been pushed.
     *
     * @param value the namespace declaration attribute state. A value of true
     *              enables this feature, a value of false disables it.
     *
     * @since SAX 2.1alpha
     *
     * @exception IllegalStateException when attempting to set this
     *    after any context has been pushed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.389 -0500", hash_original_method = "D57A861BE58AF20E8C88DE55C319347D", hash_generated_method = "60DAD705249B8CCB7BA321F3E665BDA6")
    
public void setNamespaceDeclUris (boolean value)
    {
    if (contextPos != 0)
        throw new IllegalStateException ();
    if (value == namespaceDeclUris)
        return;
    namespaceDeclUris = value;
    if (value)
        currentContext.declarePrefix ("xmlns", NSDECL);
    else {
        contexts[contextPos] = currentContext = new Context();
        currentContext.declarePrefix("xml", XMLNS);
    }
    }

    /**
     * Returns true if namespace declaration attributes are placed into
     * a namespace.  This behavior is not the default.
     *
     * @return true if namespace declaration attributes are enabled, false
     *         otherwise.
     * @since SAX 2.1alpha
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:49.392 -0500", hash_original_method = "704394E46FC1A63E6F1F5F09E7A57B00", hash_generated_method = "8FAF493A55EDB5B9A9A1EEB1456CF4B2")
    
public boolean isNamespaceDeclUris ()
    { return namespaceDeclUris; }
}

