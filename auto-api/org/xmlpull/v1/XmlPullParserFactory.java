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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.357 -0400", hash_original_field = "14BEBD4FE8FDA41093F759C7F277FE01", hash_generated_field = "54143D5A47805B96D87F2B494B2365A9")

    protected ArrayList parserClasses;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.357 -0400", hash_original_field = "BA35A57009C6C35F5CC29B7CA958266B", hash_generated_field = "4B69BDE61BD215652CA9D56912ECEE01")

    protected String classNamesLocation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.368 -0400", hash_original_field = "A734FC4B2E273BBD063C98E5B345794A", hash_generated_field = "A56B50284BF3A9A7CDBB5BF303434496")

    protected ArrayList serializerClasses;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.368 -0400", hash_original_field = "542B7A8D073CF2CF5BF366A27BC8964F", hash_generated_field = "2433B5B679656583A2F6E8E5BB139F19")

    protected HashMap features = new HashMap();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.368 -0400", hash_original_method = "59320E09A9AFF113592C1ECE87FC559F", hash_generated_method = "68325C6D2BA66CB5DC2172316E778C58")
    protected  XmlPullParserFactory() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.368 -0400", hash_original_method = "37707163E7D75DA023F216E9B819E8F1", hash_generated_method = "F5F0BA7C52918C10EF7BDB64256C0957")
    public void setFeature(String name, boolean state) throws XmlPullParserException {
        features.put(name, state);
        addTaint(name.getTaint());
        addTaint(state);
        // ---------- Original Method ----------
        //features.put(name, state);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.369 -0400", hash_original_method = "C9956302BBB91FCF3572BD64EE7FBD09", hash_generated_method = "679867694EFFA7574E8B86B0CCF694A5")
    public boolean getFeature(String name) {
        Boolean value;
        value = (Boolean) features.get(name);
        {
            Object var6066D23D9A6461E4B2F098A3809389EA_730107250 = (value.booleanValue());
        } //End flattened ternary
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_244260162 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_244260162;
        // ---------- Original Method ----------
        //Boolean value = (Boolean) features.get(name);
        //return value != null ? value.booleanValue() : false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.369 -0400", hash_original_method = "7D3BF21C0D11A10F81ABD73B19B61390", hash_generated_method = "AB033C5CAFBCC9E250C304AF3C9BC0B3")
    public void setNamespaceAware(boolean awareness) {
        features.put (XmlPullParser.FEATURE_PROCESS_NAMESPACES, awareness);
        addTaint(awareness);
        // ---------- Original Method ----------
        //features.put (XmlPullParser.FEATURE_PROCESS_NAMESPACES, awareness);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.369 -0400", hash_original_method = "DD0A1E37D5A6E0D61FD3265D348DFEF0", hash_generated_method = "8FF0041E1F267540B150D0B9C3BDDC3E")
    public boolean isNamespaceAware() {
        boolean var3FD27A2EFBE4A7A65AD63CB804EAB050_1468059632 = (getFeature (XmlPullParser.FEATURE_PROCESS_NAMESPACES));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1462860841 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1462860841;
        // ---------- Original Method ----------
        //return getFeature (XmlPullParser.FEATURE_PROCESS_NAMESPACES);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.370 -0400", hash_original_method = "756F754F40CB32AB0AD4E4D0A9342AA0", hash_generated_method = "C724B64BE6DF8D7686E69A3A2D756654")
    public void setValidating(boolean validating) {
        features.put (XmlPullParser.FEATURE_VALIDATION, validating);
        addTaint(validating);
        // ---------- Original Method ----------
        //features.put (XmlPullParser.FEATURE_VALIDATION, validating);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.370 -0400", hash_original_method = "B31DF449D9A1DA367D662873CDA0DA23", hash_generated_method = "EDEB8514DD102C7ED18C89DB718959BA")
    public boolean isValidating() {
        boolean var6F68DA4464BCEA344DEE15C9F6BDC670_685655228 = (getFeature (XmlPullParser.FEATURE_VALIDATION));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1128204161 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1128204161;
        // ---------- Original Method ----------
        //return getFeature (XmlPullParser.FEATURE_VALIDATION);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.371 -0400", hash_original_method = "0194E8A94417A2CEABB2D1EB1F726482", hash_generated_method = "9EE4CDCE1E5989FA0F23ACA4C6C4D9D7")
    public XmlPullParser newPullParser() throws XmlPullParserException {
        XmlPullParser varB4EAC82CA7396A68D541C85D26508E83_1037513522 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException
                ("Factory initialization was incomplete - has not tried "+classNamesLocation);
        {
            boolean var3D82E95C11EF86747BE6ED44EE020845_2090132960 = (parserClasses.size() == 0);
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException
                ("No valid parser classes found in "+classNamesLocation);
        } //End collapsed parenthetic
        StringBuilder issues;
        issues = new StringBuilder();
        {
            int i;
            i = 0;
            boolean varBFF54ABC51CDB5C0223EF1311B3F6729_1416520477 = (i < parserClasses.size());
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
                        boolean var0719F6DF13666099B3F99B9DD393E1F6_217231947 = (iter.hasNext());
                        {
                            String key;
                            key = (String) iter.next();
                            Boolean value;
                            value = (Boolean) features.get(key);
                            {
                                boolean var163E0911A6F57376CB2B8D6AEFFB149C_1263214973 = (value != null && value.booleanValue());
                                {
                                    pp.setFeature(key, true);
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                    varB4EAC82CA7396A68D541C85D26508E83_1037513522 = pp;
                } //End block
                catch (Exception ex)
                {
                    issues.append (ppClass.getName () + ": "+ ex.toString ()+"; ");
                } //End block
            } //End block
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException ("could not create parser: "+issues);
        varB4EAC82CA7396A68D541C85D26508E83_1037513522.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1037513522;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.383 -0400", hash_original_method = "72277D8D6A4CD4D2004A6DECEFEB4DA7", hash_generated_method = "226DFEEC0D495D9FD4F8EB83204EA14A")
    public XmlSerializer newSerializer() throws XmlPullParserException {
        XmlSerializer varB4EAC82CA7396A68D541C85D26508E83_2015238090 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException
                ("Factory initialization incomplete - has not tried "+classNamesLocation);
        } //End block
        {
            boolean var93BB30BF15516BDCA5F9575DF78ED5C3_1988803444 = (serializerClasses.size() == 0);
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
            boolean var9F8AF5C1EC8A5AA3B50C5AF781952836_1186282609 = (i < serializerClasses.size ());
            {
                Class ppClass;
                ppClass = (Class) serializerClasses.get(i);
                try 
                {
                    XmlSerializer ser;
                    ser = (XmlSerializer) ppClass.newInstance();
                    varB4EAC82CA7396A68D541C85D26508E83_2015238090 = ser;
                } //End block
                catch (Exception ex)
                {
                    issues.append (ppClass.getName () + ": "+ ex.toString ()+"; ");
                } //End block
            } //End block
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException ("could not create serializer: "+issues);
        varB4EAC82CA7396A68D541C85D26508E83_2015238090.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2015238090;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.392 -0400", hash_original_field = "85E092DE17CB1169218C8B191C4D88D4", hash_generated_field = "883198D89D71761DBB74BFD5A655879D")

    static Class referenceContextClass;
    static {
        XmlPullParserFactory f = new XmlPullParserFactory();
        referenceContextClass = f.getClass();
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.393 -0400", hash_original_field = "33FC263AFDBB4EEDBBE1504047AE9A37", hash_generated_field = "C6E7862EC1172DC262780F881FC06DEC")

    public static final String PROPERTY_NAME =
        "org.xmlpull.v1.XmlPullParserFactory";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.393 -0400", hash_original_field = "2A2F7FF4F241CDA2C6261B43F6383287", hash_generated_field = "CF1DB141E063ED36059511DDA8808CEB")

    private static String RESOURCE_NAME = "/META-INF/services/" + PROPERTY_NAME;
}

