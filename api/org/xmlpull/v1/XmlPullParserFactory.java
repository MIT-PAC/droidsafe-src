package org.xmlpull.v1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class XmlPullParserFactory {

    /**
     * Create a new instance of a PullParserFactory that can be used
     * to create XML pull parsers (see class description for more
     * details).
     *
     * @return a new instance of a PullParserFactory, as returned by newInstance (null, null);
     */
    @DSComment("no input, no suspicious activity to abstract method")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.125 -0500", hash_original_method = "FDB67D996B87AFA9828831030DD04774", hash_generated_method = "CF201CA93963A12DA7AA2B504A495C37")
    
public static XmlPullParserFactory newInstance () throws XmlPullParserException {
        return newInstance(null, null);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.129 -0500", hash_original_method = "2957323A9BBFD5C32789AB8ACDA9401B", hash_generated_method = "E17ECAC088F67E7E851A0EDD655019DD")
    
public static XmlPullParserFactory newInstance (String classNames, Class context)
        throws XmlPullParserException {

        /*
        if (context == null) {
            //NOTE: make sure context uses the same class loader as API classes
            //      this is the best we can do without having access to context classloader in J2ME
            //      if API is in the same classloader as implementation then this will work
            context = referenceContextClass;
        }

        String  classNamesLocation = null;

        if (classNames == null || classNames.length() == 0 || "DEFAULT".equals(classNames)) {
            try {
                InputStream is = context.getResourceAsStream (RESOURCE_NAME);

                if (is == null) throw new XmlPullParserException
                        ("resource not found: "+RESOURCE_NAME
                             +" make sure that parser implementing XmlPull API is available");
                final StringBuilder sb = new StringBuilder();

                while (true) {
                    final int ch = is.read();
                    if (ch < 0) break;
                    else if (ch > ' ')
                        sb.append((char) ch);
                }
                is.close ();

                classNames = sb.toString ();
            }
            catch (Exception e) {
                throw new XmlPullParserException (null, null, e);
            }
            classNamesLocation = "resource "+RESOURCE_NAME+" that contained '"+classNames+"'";
        } else {
            classNamesLocation =
                "parameter classNames to newInstance() that contained '"+classNames+"'";
        }
        */
        classNames = "org.kxml2.io.KXmlParser,org.kxml2.io.KXmlSerializer";

        XmlPullParserFactory factory = null;
        final ArrayList parserClasses = new ArrayList();
        final ArrayList serializerClasses = new ArrayList();
        int pos = 0;

        while (pos < classNames.length ()) {
            int cut = classNames.indexOf (',', pos);

            if (cut == -1) cut = classNames.length ();
            final String name = classNames.substring (pos, cut);

            Class candidate = null;
            Object instance = null;

            try {
                candidate = Class.forName (name);
                // necessary because of J2ME .class issue
                instance = candidate.newInstance ();
            }
            catch (Exception e) {}

            if (candidate != null) {
                boolean recognized = false;
                if (instance instanceof XmlPullParser) {
                    parserClasses.add(candidate);
                    recognized = true;
                }
                if (instance instanceof XmlSerializer) {
                    serializerClasses.add(candidate);
                    recognized = true;
                }
                if (instance instanceof XmlPullParserFactory) {
                    if (factory == null) {
                        factory = (XmlPullParserFactory) instance;
                    }
                    recognized = true;
                }
                if (!recognized) {
                    throw new XmlPullParserException ("incompatible class: "+name);
                }
            }
            pos = cut + 1;
        }

        if (factory == null) {
            factory = new XmlPullParserFactory ();
        }
        factory.parserClasses = parserClasses;
        factory.serializerClasses = serializerClasses;
        factory.classNamesLocation = "org.kxml2.io.kXmlParser,org.kxml2.io.KXmlSerializer";
        return factory;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.081 -0500", hash_original_field = "3742FB62CB5112FCF7BDF7526BC8191C", hash_generated_field = "883198D89D71761DBB74BFD5A655879D")

     static Class referenceContextClass;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.084 -0500", hash_original_field = "A56E5319A37849D3B7C93AF58147B2AD", hash_generated_field = "C6E7862EC1172DC262780F881FC06DEC")

    public static final String PROPERTY_NAME =
        "org.xmlpull.v1.XmlPullParserFactory";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.086 -0500", hash_original_field = "00E0F3E761546C7AD8F0BF9B3886946B", hash_generated_field = "857B4961AF71D0398E9BF439994827F2")

    private static final String RESOURCE_NAME =
        "/META-INF/services/" + PROPERTY_NAME;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.089 -0500", hash_original_field = "C06A7F068F852EB78059D820A38AFC03", hash_generated_field = "878D036EAB1344134C01960C2D67C553")

    //    "org.xmlpull.xpp3.XmlPullParser,org.kxml2.io.KXmlParser";

    protected ArrayList parserClasses;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.091 -0500", hash_original_field = "178D027C48D58C53B7F7DA305D8F3745", hash_generated_field = "4B69BDE61BD215652CA9D56912ECEE01")

    protected String classNamesLocation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.093 -0500", hash_original_field = "2115E1EF8711BCAE252E39271BFFDEAD", hash_generated_field = "A56B50284BF3A9A7CDBB5BF303434496")

    protected ArrayList serializerClasses;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.096 -0500", hash_original_field = "1ED7D14D596CC9841E075441007F0AB6", hash_generated_field = "2433B5B679656583A2F6E8E5BB139F19")

    protected HashMap features = new HashMap();

    /**
     * Protected constructor to be called by factory implementations.
     */

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.099 -0500", hash_original_method = "59320E09A9AFF113592C1ECE87FC559F", hash_generated_method = "FA362A326E78E98959AFC1700BB3C521")
    
protected XmlPullParserFactory() {
    }

    /**
     * Set the features to be set when XML Pull Parser is created by this factory.
     * <p><b>NOTE:</b> factory features are not used for XML Serializer.
     *
     * @param name string with URI identifying feature
     * @param state if true feature will be set; if false will be ignored
     */

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.102 -0500", hash_original_method = "37707163E7D75DA023F216E9B819E8F1", hash_generated_method = "4DDF60F750C5C1A768ACF458011AB841")
    
public void setFeature(String name, boolean state) throws XmlPullParserException {
        features.put(name, state);
    }

    /**
     * Return the current value of the feature with given name.
     * <p><b>NOTE:</b> factory features are not used for XML Serializer.
     *
     * @param name The name of feature to be retrieved.
     * @return The value of named feature.
     *     Unknown features are <string>always</strong> returned as false
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.105 -0500", hash_original_method = "C9956302BBB91FCF3572BD64EE7FBD09", hash_generated_method = "68F4C36DBC649591A0AEEB495A1DF349")
    
public boolean getFeature (String name) {
        Boolean value = (Boolean) features.get(name);
        return value != null ? value.booleanValue() : false;
    }

    /**
     * Specifies that the parser produced by this factory will provide
     * support for XML namespaces.
     * By default the value of this is set to false.
     *
     * @param awareness true if the parser produced by this code
     *    will provide support for XML namespaces;  false otherwise.
     */

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.108 -0500", hash_original_method = "7D3BF21C0D11A10F81ABD73B19B61390", hash_generated_method = "6A0488D3310840EFAF8243BCE74765E0")
    
public void setNamespaceAware(boolean awareness) {
        features.put (XmlPullParser.FEATURE_PROCESS_NAMESPACES, awareness);
    }

    /**
     * Indicates whether or not the factory is configured to produce
     * parsers which are namespace aware
     * (it simply set feature XmlPullParser.FEATURE_PROCESS_NAMESPACES to true or false).
     *
     * @return  true if the factory is configured to produce parsers
     *    which are namespace aware; false otherwise.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.111 -0500", hash_original_method = "DD0A1E37D5A6E0D61FD3265D348DFEF0", hash_generated_method = "993B7A16D49BFB39DEAEA6DF2B396C59")
    
public boolean isNamespaceAware() {
        return getFeature (XmlPullParser.FEATURE_PROCESS_NAMESPACES);
    }

    /**
     * Specifies that the parser produced by this factory will be validating
     * (it simply set feature XmlPullParser.FEATURE_VALIDATION to true or false).
     *
     * By default the value of this is set to false.
     *
     * @param validating - if true the parsers created by this factory  must be validating.
     */

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.113 -0500", hash_original_method = "756F754F40CB32AB0AD4E4D0A9342AA0", hash_generated_method = "5B60EDCCF8D221FF3AC4105A064D8592")
    
public void setValidating(boolean validating) {
        features.put (XmlPullParser.FEATURE_VALIDATION, validating);
    }

    /**
     * Indicates whether or not the factory is configured to produce parsers
     * which validate the XML content during parse.
     *
     * @return   true if the factory is configured to produce parsers
     * which validate the XML content during parse; false otherwise.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.116 -0500", hash_original_method = "B31DF449D9A1DA367D662873CDA0DA23", hash_generated_method = "F9ACE3351C702548782D5E8CB13F7469")
    
public boolean isValidating() {
        return getFeature (XmlPullParser.FEATURE_VALIDATION);
    }
    static {
        XmlPullParserFactory f = new XmlPullParserFactory();
        referenceContextClass = f.getClass();
    }

    /**
     * Creates a new instance of a XML Pull Parser
     * using the currently configured factory features.
     *
     * @return A new instance of a XML Pull Parser.
     * @throws XmlPullParserException if a parser cannot be created which satisfies the
     * requested configuration.
     */

    @DSComment("no input, no suspicious activity and output is just an instance of a parser")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.119 -0500", hash_original_method = "0194E8A94417A2CEABB2D1EB1F726482", hash_generated_method = "C0016DE88A673311BBA5B3D10DAC16C8")
    
public XmlPullParser newPullParser() throws XmlPullParserException {

        if (parserClasses == null) throw new XmlPullParserException
                ("Factory initialization was incomplete - has not tried "+classNamesLocation);

        if (parserClasses.size() == 0) throw new XmlPullParserException
                ("No valid parser classes found in "+classNamesLocation);

        final StringBuilder issues = new StringBuilder();

        for (int i = 0; i < parserClasses.size(); i++) {
            final Class ppClass = (Class) parserClasses.get(i);
            try {
                final XmlPullParser pp = (XmlPullParser) ppClass.newInstance();

                for (Iterator iter = features.keySet().iterator(); iter.hasNext(); ) {
                    final String key = (String) iter.next();
                    final Boolean value = (Boolean) features.get(key);
                    if(value != null && value.booleanValue()) {
                        pp.setFeature(key, true);
                    }
                }
                return pp;

            } catch(Exception ex) {
                issues.append (ppClass.getName () + ": "+ ex.toString ()+"; ");
            }
        }

        throw new XmlPullParserException ("could not create parser: "+issues);
    }

    /**
     * Creates a new instance of a XML Serializer.
     *
     * <p><b>NOTE:</b> factory features are not used for XML Serializer.
     *
     * @return A new instance of a XML Serializer.
     * @throws XmlPullParserException if a parser cannot be created which satisfies the
     * requested configuration.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.123 -0500", hash_original_method = "72277D8D6A4CD4D2004A6DECEFEB4DA7", hash_generated_method = "30DB49AE89C5C9FED8A64249CF2111A3")
    
public XmlSerializer newSerializer() throws XmlPullParserException {

        if (serializerClasses == null) {
            throw new XmlPullParserException
                ("Factory initialization incomplete - has not tried "+classNamesLocation);
        }
        if(serializerClasses.size() == 0) {
            throw new XmlPullParserException
                ("No valid serializer classes found in "+classNamesLocation);
        }

        final StringBuilder issues = new StringBuilder ();

        for (int i = 0; i < serializerClasses.size (); i++) {
            final Class ppClass = (Class) serializerClasses.get(i);
            try {
                final XmlSerializer ser = (XmlSerializer) ppClass.newInstance();

                return ser;

            } catch(Exception ex) {
                issues.append (ppClass.getName () + ": "+ ex.toString ()+"; ");
            }
        }

        throw new XmlPullParserException ("could not create serializer: "+issues);
    }
}

