package org.xmlpull.v1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class XmlPullParserFactory {
    protected ArrayList parserClasses;
    protected String classNamesLocation;
    protected ArrayList serializerClasses;
    protected HashMap features = new HashMap();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.456 -0400", hash_original_method = "59320E09A9AFF113592C1ECE87FC559F", hash_generated_method = "68325C6D2BA66CB5DC2172316E778C58")
    @DSModeled(DSC.SAFE)
    protected XmlPullParserFactory() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.457 -0400", hash_original_method = "37707163E7D75DA023F216E9B819E8F1", hash_generated_method = "5B6561BA65DD3252A95BDDBFAA00F4D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFeature(String name, boolean state) throws XmlPullParserException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(state);
        features.put(name, state);
        // ---------- Original Method ----------
        //features.put(name, state);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.457 -0400", hash_original_method = "C9956302BBB91FCF3572BD64EE7FBD09", hash_generated_method = "57AF5DFFB43C9245739C642A03E390A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getFeature(String name) {
        dsTaint.addTaint(name);
        Boolean value;
        value = (Boolean) features.get(name);
        {
            Object var6066D23D9A6461E4B2F098A3809389EA_2124443244 = (value.booleanValue());
        } //End flattened ternary
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Boolean value = (Boolean) features.get(name);
        //return value != null ? value.booleanValue() : false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.457 -0400", hash_original_method = "7D3BF21C0D11A10F81ABD73B19B61390", hash_generated_method = "5E4CD9426C3A34FF5316C8D3F2CF6D91")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setNamespaceAware(boolean awareness) {
        dsTaint.addTaint(awareness);
        features.put (XmlPullParser.FEATURE_PROCESS_NAMESPACES, awareness);
        // ---------- Original Method ----------
        //features.put (XmlPullParser.FEATURE_PROCESS_NAMESPACES, awareness);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.457 -0400", hash_original_method = "DD0A1E37D5A6E0D61FD3265D348DFEF0", hash_generated_method = "58EE9A3657888FF5DD38CE965E6DCB01")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isNamespaceAware() {
        boolean var3FD27A2EFBE4A7A65AD63CB804EAB050_1475273541 = (getFeature (XmlPullParser.FEATURE_PROCESS_NAMESPACES));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getFeature (XmlPullParser.FEATURE_PROCESS_NAMESPACES);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.457 -0400", hash_original_method = "756F754F40CB32AB0AD4E4D0A9342AA0", hash_generated_method = "2EE4BB06A53E30BE708D6A2DE4F1838C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setValidating(boolean validating) {
        dsTaint.addTaint(validating);
        features.put (XmlPullParser.FEATURE_VALIDATION, validating);
        // ---------- Original Method ----------
        //features.put (XmlPullParser.FEATURE_VALIDATION, validating);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.458 -0400", hash_original_method = "B31DF449D9A1DA367D662873CDA0DA23", hash_generated_method = "2446FD14932D36EB5EA96AD6B374245E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isValidating() {
        boolean var6F68DA4464BCEA344DEE15C9F6BDC670_801197006 = (getFeature (XmlPullParser.FEATURE_VALIDATION));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getFeature (XmlPullParser.FEATURE_VALIDATION);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.458 -0400", hash_original_method = "0194E8A94417A2CEABB2D1EB1F726482", hash_generated_method = "AF7CF483A0BAD2CC9350DD55E96DACF6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public XmlPullParser newPullParser() throws XmlPullParserException {
        if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException
                ("Factory initialization was incomplete - has not tried "+classNamesLocation);
        {
            boolean var3D82E95C11EF86747BE6ED44EE020845_52296674 = (parserClasses.size() == 0);
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException
                ("No valid parser classes found in "+classNamesLocation);
        } //End collapsed parenthetic
        StringBuilder issues;
        issues = new StringBuilder();
        {
            int i;
            i = 0;
            boolean varBFF54ABC51CDB5C0223EF1311B3F6729_237271921 = (i < parserClasses.size());
            {
                Class ppClass;
                ppClass = (Class) parserClasses.get(i);
                try 
                {
                    XmlPullParser pp;
                    pp = (XmlPullParser) ppClass.newInstance();
                    {
                        Iterator iter;
                        iter = features.keySet().iterator();
                        boolean var0719F6DF13666099B3F99B9DD393E1F6_134958091 = (iter.hasNext());
                        {
                            String key;
                            key = (String) iter.next();
                            Boolean value;
                            value = (Boolean) features.get(key);
                            {
                                boolean var163E0911A6F57376CB2B8D6AEFFB149C_438172587 = (value != null && value.booleanValue());
                                {
                                    pp.setFeature(key, true);
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                catch (Exception ex)
                {
                    issues.append (ppClass.getName () + ": "+ ex.toString ()+"; ");
                } //End block
            } //End block
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException ("could not create parser: "+issues);
        return (XmlPullParser)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:43.458 -0400", hash_original_method = "72277D8D6A4CD4D2004A6DECEFEB4DA7", hash_generated_method = "746521FBF2E18F522BA3BB809F2F67B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public XmlSerializer newSerializer() throws XmlPullParserException {
        {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException
                ("Factory initialization incomplete - has not tried "+classNamesLocation);
        } //End block
        {
            boolean var93BB30BF15516BDCA5F9575DF78ED5C3_33809665 = (serializerClasses.size() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException
                ("No valid serializer classes found in "+classNamesLocation);
            } //End block
        } //End collapsed parenthetic
        StringBuilder issues;
        issues = new StringBuilder ();
        {
            int i;
            i = 0;
            boolean var9F8AF5C1EC8A5AA3B50C5AF781952836_1186277215 = (i < serializerClasses.size ());
            {
                Class ppClass;
                ppClass = (Class) serializerClasses.get(i);
                try 
                {
                    XmlSerializer ser;
                    ser = (XmlSerializer) ppClass.newInstance();
                } //End block
                catch (Exception ex)
                {
                    issues.append (ppClass.getName () + ": "+ ex.toString ()+"; ");
                } //End block
            } //End block
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException ("could not create serializer: "+issues);
        return (XmlSerializer)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        public static XmlPullParserFactory newInstance() throws XmlPullParserException {
        return newInstance(null, null);
    }

    
        public static XmlPullParserFactory newInstance(String classNames, Class context) throws XmlPullParserException {
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

    
    final static Class referenceContextClass;
    static {
        XmlPullParserFactory f = new XmlPullParserFactory();
        referenceContextClass = f.getClass();
    }
    
    public static final String PROPERTY_NAME =
        "org.xmlpull.v1.XmlPullParserFactory";
    private static final String RESOURCE_NAME =
        "/META-INF/services/" + PROPERTY_NAME;
}

