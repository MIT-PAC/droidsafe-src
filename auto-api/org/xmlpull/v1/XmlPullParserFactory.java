package org.xmlpull.v1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class XmlPullParserFactory {
    final static Class referenceContextClass;
    public static final String PROPERTY_NAME =
        "org.xmlpull.v1.XmlPullParserFactory";
    private static final String RESOURCE_NAME =
        "/META-INF/services/" + PROPERTY_NAME;
    protected ArrayList parserClasses;
    protected String classNamesLocation;
    protected ArrayList serializerClasses;
    protected HashMap features = new HashMap();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.158 -0400", hash_original_method = "59320E09A9AFF113592C1ECE87FC559F", hash_generated_method = "C0EDA38BDB6CACBC74F0ADE3F49C0C41")
    @DSModeled(DSC.SAFE)
    protected XmlPullParserFactory() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.158 -0400", hash_original_method = "37707163E7D75DA023F216E9B819E8F1", hash_generated_method = "20FF5F86EDCAC61552A477E5433633DA")
    @DSModeled(DSC.SAFE)
    public void setFeature(String name, boolean state) throws XmlPullParserException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(state);
        features.put(name, state);
        // ---------- Original Method ----------
        //features.put(name, state);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.159 -0400", hash_original_method = "C9956302BBB91FCF3572BD64EE7FBD09", hash_generated_method = "08AB59BC2626194F13CD9A46BAAF61A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getFeature(String name) {
        dsTaint.addTaint(name);
        Boolean value;
        value = (Boolean) features.get(name);
        {
            Object var6066D23D9A6461E4B2F098A3809389EA_188108340 = (value.booleanValue());
        } //End flattened ternary
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Boolean value = (Boolean) features.get(name);
        //return value != null ? value.booleanValue() : false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.159 -0400", hash_original_method = "7D3BF21C0D11A10F81ABD73B19B61390", hash_generated_method = "57003545CF519F7A6F7EC6C99A916A62")
    @DSModeled(DSC.SAFE)
    public void setNamespaceAware(boolean awareness) {
        dsTaint.addTaint(awareness);
        features.put (XmlPullParser.FEATURE_PROCESS_NAMESPACES, awareness);
        // ---------- Original Method ----------
        //features.put (XmlPullParser.FEATURE_PROCESS_NAMESPACES, awareness);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.159 -0400", hash_original_method = "DD0A1E37D5A6E0D61FD3265D348DFEF0", hash_generated_method = "EC8F2411F3A3429D6F80C5916321B4BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isNamespaceAware() {
        boolean var3FD27A2EFBE4A7A65AD63CB804EAB050_2012956011 = (getFeature (XmlPullParser.FEATURE_PROCESS_NAMESPACES));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getFeature (XmlPullParser.FEATURE_PROCESS_NAMESPACES);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.159 -0400", hash_original_method = "756F754F40CB32AB0AD4E4D0A9342AA0", hash_generated_method = "4D2D36A0826676A09FC74F222CD9B2CD")
    @DSModeled(DSC.SAFE)
    public void setValidating(boolean validating) {
        dsTaint.addTaint(validating);
        features.put (XmlPullParser.FEATURE_VALIDATION, validating);
        // ---------- Original Method ----------
        //features.put (XmlPullParser.FEATURE_VALIDATION, validating);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.159 -0400", hash_original_method = "B31DF449D9A1DA367D662873CDA0DA23", hash_generated_method = "1F99BCB864103C1715C62F6F376A5A35")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isValidating() {
        boolean var6F68DA4464BCEA344DEE15C9F6BDC670_1415210423 = (getFeature (XmlPullParser.FEATURE_VALIDATION));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getFeature (XmlPullParser.FEATURE_VALIDATION);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.159 -0400", hash_original_method = "0194E8A94417A2CEABB2D1EB1F726482", hash_generated_method = "25EECCFEC8D3CBCD99A6C1565CB0785A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public XmlPullParser newPullParser() throws XmlPullParserException {
        throw new XmlPullParserException
                ("Factory initialization was incomplete - has not tried "+classNamesLocation);
        {
            boolean var3D82E95C11EF86747BE6ED44EE020845_105966100 = (parserClasses.size() == 0);
            throw new XmlPullParserException
                ("No valid parser classes found in "+classNamesLocation);
        } //End collapsed parenthetic
        final StringBuilder issues;
        issues = new StringBuilder();
        {
            int i;
            i = 0;
            boolean varBFF54ABC51CDB5C0223EF1311B3F6729_585125471 = (i < parserClasses.size());
            {
                final Class ppClass;
                ppClass = (Class) parserClasses.get(i);
                try 
                {
                    final XmlPullParser pp;
                    pp = (XmlPullParser) ppClass.newInstance();
                    {
                        Iterator iter;
                        iter = features.keySet().iterator();
                        boolean var0719F6DF13666099B3F99B9DD393E1F6_1556712703 = (iter.hasNext());
                        {
                            final String key;
                            key = (String) iter.next();
                            final Boolean value;
                            value = (Boolean) features.get(key);
                            {
                                boolean var163E0911A6F57376CB2B8D6AEFFB149C_22539329 = (value != null && value.booleanValue());
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
        throw new XmlPullParserException ("could not create parser: "+issues);
        return (XmlPullParser)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.159 -0400", hash_original_method = "72277D8D6A4CD4D2004A6DECEFEB4DA7", hash_generated_method = "716C8BD073FF9B43470FFE0F5B467BC6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public XmlSerializer newSerializer() throws XmlPullParserException {
        {
            throw new XmlPullParserException
                ("Factory initialization incomplete - has not tried "+classNamesLocation);
        } //End block
        {
            boolean var93BB30BF15516BDCA5F9575DF78ED5C3_493464343 = (serializerClasses.size() == 0);
            {
                throw new XmlPullParserException
                ("No valid serializer classes found in "+classNamesLocation);
            } //End block
        } //End collapsed parenthetic
        final StringBuilder issues;
        issues = new StringBuilder ();
        {
            int i;
            i = 0;
            boolean var9F8AF5C1EC8A5AA3B50C5AF781952836_221655415 = (i < serializerClasses.size ());
            {
                final Class ppClass;
                ppClass = (Class) serializerClasses.get(i);
                try 
                {
                    final XmlSerializer ser;
                    ser = (XmlSerializer) ppClass.newInstance();
                } //End block
                catch (Exception ex)
                {
                    issues.append (ppClass.getName () + ": "+ ex.toString ()+"; ");
                } //End block
            } //End block
        } //End collapsed parenthetic
        throw new XmlPullParserException ("could not create serializer: "+issues);
        return (XmlSerializer)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.159 -0400", hash_original_method = "FDB67D996B87AFA9828831030DD04774", hash_generated_method = "CF201CA93963A12DA7AA2B504A495C37")
    public static XmlPullParserFactory newInstance() throws XmlPullParserException {
        return newInstance(null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:18.159 -0400", hash_original_method = "2957323A9BBFD5C32789AB8ACDA9401B", hash_generated_method = "33B7660B68BBE32A4B9C2521C1B79CDA")
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

    
    static {
        XmlPullParserFactory f = new XmlPullParserFactory();
        referenceContextClass = f.getClass();
    }
    
}


