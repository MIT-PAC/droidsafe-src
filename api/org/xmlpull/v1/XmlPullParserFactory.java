package org.xmlpull.v1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class XmlPullParserFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.140 -0400", hash_original_field = "14BEBD4FE8FDA41093F759C7F277FE01", hash_generated_field = "54143D5A47805B96D87F2B494B2365A9")

    protected ArrayList parserClasses;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.140 -0400", hash_original_field = "BA35A57009C6C35F5CC29B7CA958266B", hash_generated_field = "4B69BDE61BD215652CA9D56912ECEE01")

    protected String classNamesLocation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.140 -0400", hash_original_field = "A734FC4B2E273BBD063C98E5B345794A", hash_generated_field = "A56B50284BF3A9A7CDBB5BF303434496")

    protected ArrayList serializerClasses;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.140 -0400", hash_original_field = "542B7A8D073CF2CF5BF366A27BC8964F", hash_generated_field = "2433B5B679656583A2F6E8E5BB139F19")

    protected HashMap features = new HashMap();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.141 -0400", hash_original_method = "59320E09A9AFF113592C1ECE87FC559F", hash_generated_method = "68325C6D2BA66CB5DC2172316E778C58")
    protected  XmlPullParserFactory() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.141 -0400", hash_original_method = "37707163E7D75DA023F216E9B819E8F1", hash_generated_method = "F5F0BA7C52918C10EF7BDB64256C0957")
    public void setFeature(String name, boolean state) throws XmlPullParserException {
        features.put(name, state);
        addTaint(name.getTaint());
        addTaint(state);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.142 -0400", hash_original_method = "C9956302BBB91FCF3572BD64EE7FBD09", hash_generated_method = "7ADA40B5C09B4928F686A823E29B5DCD")
    public boolean getFeature(String name) {
        Boolean value = (Boolean) features.get(name);
        {
            Object var6066D23D9A6461E4B2F098A3809389EA_1453551268 = (value.booleanValue());
        } 
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1793319356 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1793319356;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.142 -0400", hash_original_method = "7D3BF21C0D11A10F81ABD73B19B61390", hash_generated_method = "AB033C5CAFBCC9E250C304AF3C9BC0B3")
    public void setNamespaceAware(boolean awareness) {
        features.put (XmlPullParser.FEATURE_PROCESS_NAMESPACES, awareness);
        addTaint(awareness);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.142 -0400", hash_original_method = "DD0A1E37D5A6E0D61FD3265D348DFEF0", hash_generated_method = "4BADA00FEB2FE1C131F69846B2745F62")
    public boolean isNamespaceAware() {
        boolean var3FD27A2EFBE4A7A65AD63CB804EAB050_321980207 = (getFeature (XmlPullParser.FEATURE_PROCESS_NAMESPACES));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_131739929 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_131739929;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.142 -0400", hash_original_method = "756F754F40CB32AB0AD4E4D0A9342AA0", hash_generated_method = "C724B64BE6DF8D7686E69A3A2D756654")
    public void setValidating(boolean validating) {
        features.put (XmlPullParser.FEATURE_VALIDATION, validating);
        addTaint(validating);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.142 -0400", hash_original_method = "B31DF449D9A1DA367D662873CDA0DA23", hash_generated_method = "90F95296D4B7D867EBD52EF804C9BB93")
    public boolean isValidating() {
        boolean var6F68DA4464BCEA344DEE15C9F6BDC670_1917893387 = (getFeature (XmlPullParser.FEATURE_VALIDATION));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1098525021 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1098525021;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.143 -0400", hash_original_method = "0194E8A94417A2CEABB2D1EB1F726482", hash_generated_method = "58F275ADB9A6491D40907A93785C3947")
    public XmlPullParser newPullParser() throws XmlPullParserException {
        XmlPullParser varB4EAC82CA7396A68D541C85D26508E83_124094545 = null; 
        if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException
                ("Factory initialization was incomplete - has not tried "+classNamesLocation);
        {
            boolean var3D82E95C11EF86747BE6ED44EE020845_1531362377 = (parserClasses.size() == 0);
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException
                ("No valid parser classes found in "+classNamesLocation);
        } 
        final StringBuilder issues = new StringBuilder();
        {
            int i = 0;
            boolean varBFF54ABC51CDB5C0223EF1311B3F6729_1176396639 = (i < parserClasses.size());
            {
                final Class ppClass = (Class) parserClasses.get(i);
                try 
                {
                    final XmlPullParser pp = (XmlPullParser) ppClass.newInstance();
                    {
                        Iterator iter = features.keySet().iterator();
                        boolean var0719F6DF13666099B3F99B9DD393E1F6_2026357844 = (iter.hasNext());
                        {
                            final String key = (String) iter.next();
                            final Boolean value = (Boolean) features.get(key);
                            {
                                boolean var163E0911A6F57376CB2B8D6AEFFB149C_1708191251 = (value != null && value.booleanValue());
                                {
                                    pp.setFeature(key, true);
                                } 
                            } 
                        } 
                    } 
                    varB4EAC82CA7396A68D541C85D26508E83_124094545 = pp;
                } 
                catch (Exception ex)
                {
                    issues.append (ppClass.getName () + ": "+ ex.toString ()+"; ");
                } 
            } 
        } 
        if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException ("could not create parser: "+issues);
        varB4EAC82CA7396A68D541C85D26508E83_124094545.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_124094545;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.144 -0400", hash_original_method = "72277D8D6A4CD4D2004A6DECEFEB4DA7", hash_generated_method = "CFF01BD0A82838DC124A38A2F9FF24D3")
    public XmlSerializer newSerializer() throws XmlPullParserException {
        XmlSerializer varB4EAC82CA7396A68D541C85D26508E83_1455159600 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException
                ("Factory initialization incomplete - has not tried "+classNamesLocation);
        } 
        {
            boolean var93BB30BF15516BDCA5F9575DF78ED5C3_1463793708 = (serializerClasses.size() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException
                ("No valid serializer classes found in "+classNamesLocation);
            } 
        } 
        final StringBuilder issues = new StringBuilder ();
        {
            int i = 0;
            boolean var9F8AF5C1EC8A5AA3B50C5AF781952836_263222331 = (i < serializerClasses.size ());
            {
                final Class ppClass = (Class) serializerClasses.get(i);
                try 
                {
                    final XmlSerializer ser = (XmlSerializer) ppClass.newInstance();
                    varB4EAC82CA7396A68D541C85D26508E83_1455159600 = ser;
                } 
                catch (Exception ex)
                {
                    issues.append (ppClass.getName () + ": "+ ex.toString ()+"; ");
                } 
            } 
        } 
        if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException ("could not create serializer: "+issues);
        varB4EAC82CA7396A68D541C85D26508E83_1455159600.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1455159600;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static XmlPullParserFactory newInstance() throws XmlPullParserException {
        return newInstance(null, null);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.145 -0400", hash_original_field = "85E092DE17CB1169218C8B191C4D88D4", hash_generated_field = "883198D89D71761DBB74BFD5A655879D")

    static Class referenceContextClass;
    static {
        XmlPullParserFactory f = new XmlPullParserFactory();
        referenceContextClass = f.getClass();
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.145 -0400", hash_original_field = "33FC263AFDBB4EEDBBE1504047AE9A37", hash_generated_field = "C6E7862EC1172DC262780F881FC06DEC")

    public static final String PROPERTY_NAME =
        "org.xmlpull.v1.XmlPullParserFactory";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:49.145 -0400", hash_original_field = "2A2F7FF4F241CDA2C6261B43F6383287", hash_generated_field = "857B4961AF71D0398E9BF439994827F2")

    private static final String RESOURCE_NAME = "/META-INF/services/" + PROPERTY_NAME;
}

