package org.xmlpull.v1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class XmlPullParserFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.642 -0400", hash_original_field = "14BEBD4FE8FDA41093F759C7F277FE01", hash_generated_field = "54143D5A47805B96D87F2B494B2365A9")

    protected ArrayList parserClasses;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.642 -0400", hash_original_field = "BA35A57009C6C35F5CC29B7CA958266B", hash_generated_field = "4B69BDE61BD215652CA9D56912ECEE01")

    protected String classNamesLocation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.642 -0400", hash_original_field = "A734FC4B2E273BBD063C98E5B345794A", hash_generated_field = "A56B50284BF3A9A7CDBB5BF303434496")

    protected ArrayList serializerClasses;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.642 -0400", hash_original_field = "542B7A8D073CF2CF5BF366A27BC8964F", hash_generated_field = "2433B5B679656583A2F6E8E5BB139F19")

    protected HashMap features = new HashMap();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.642 -0400", hash_original_method = "59320E09A9AFF113592C1ECE87FC559F", hash_generated_method = "68325C6D2BA66CB5DC2172316E778C58")
    protected  XmlPullParserFactory() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.643 -0400", hash_original_method = "37707163E7D75DA023F216E9B819E8F1", hash_generated_method = "281866DA3490845B831FACC4BFF03D24")
    public void setFeature(String name, boolean state) throws XmlPullParserException {
        addTaint(state);
        addTaint(name.getTaint());
        features.put(name, state);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.643 -0400", hash_original_method = "C9956302BBB91FCF3572BD64EE7FBD09", hash_generated_method = "6E5220E24580D1330A58B68FFB04E522")
    public boolean getFeature(String name) {
        addTaint(name.getTaint());
        Boolean value = (Boolean) features.get(name);
        boolean varDC48A27EDADE465507184A31325067DD_1442606607 = (value != null ? value.booleanValue() : false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_260779688 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_260779688;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.643 -0400", hash_original_method = "7D3BF21C0D11A10F81ABD73B19B61390", hash_generated_method = "2A65F06D4BE9FBAA0C357B468191C460")
    public void setNamespaceAware(boolean awareness) {
        addTaint(awareness);
        features.put (XmlPullParser.FEATURE_PROCESS_NAMESPACES, awareness);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.643 -0400", hash_original_method = "DD0A1E37D5A6E0D61FD3265D348DFEF0", hash_generated_method = "7C0C50E3A9594A5ED4256C14CF55C3C8")
    public boolean isNamespaceAware() {
        boolean var6315A68DCC9052F6A43C9B5B41FEF245_688010425 = (getFeature (XmlPullParser.FEATURE_PROCESS_NAMESPACES));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_796586533 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_796586533;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.644 -0400", hash_original_method = "756F754F40CB32AB0AD4E4D0A9342AA0", hash_generated_method = "ECF89D5A161A9AC4587B1B6D69A60AC9")
    public void setValidating(boolean validating) {
        addTaint(validating);
        features.put (XmlPullParser.FEATURE_VALIDATION, validating);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.644 -0400", hash_original_method = "B31DF449D9A1DA367D662873CDA0DA23", hash_generated_method = "30E4DE98CE922764B6D3F1D044B8249D")
    public boolean isValidating() {
        boolean var7071369F79CC67F9563C3D976C3FB483_1684637412 = (getFeature (XmlPullParser.FEATURE_VALIDATION));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1402881375 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1402881375;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.644 -0400", hash_original_method = "0194E8A94417A2CEABB2D1EB1F726482", hash_generated_method = "2CA8FAB2873EBA2F6647C6CAF92071FC")
    public XmlPullParser newPullParser() throws XmlPullParserException {
    if(parserClasses == null)        
        {
        XmlPullParserException var9BA65B1FEA8F788406824A6FF583F78A_560152715 = new XmlPullParserException
                ("Factory initialization was incomplete - has not tried "+classNamesLocation);
        var9BA65B1FEA8F788406824A6FF583F78A_560152715.addTaint(taint);
        throw var9BA65B1FEA8F788406824A6FF583F78A_560152715;
        }
    if(parserClasses.size() == 0)        
        {
        XmlPullParserException varCC427323E7049EEBA44DEBE96C9DFF7A_149320080 = new XmlPullParserException
                ("No valid parser classes found in "+classNamesLocation);
        varCC427323E7049EEBA44DEBE96C9DFF7A_149320080.addTaint(taint);
        throw varCC427323E7049EEBA44DEBE96C9DFF7A_149320080;
        }
        final StringBuilder issues = new StringBuilder();
for(int i = 0;i < parserClasses.size();i++)
        {
            final Class ppClass = (Class) parserClasses.get(i);
            try 
            {
                final XmlPullParser pp = (XmlPullParser) ppClass.newInstance();
for(Iterator iter = features.keySet().iterator();iter.hasNext();)
                {
                    final String key = (String) iter.next();
                    final Boolean value = (Boolean) features.get(key);
    if(value != null && value.booleanValue())                    
                    {
                        pp.setFeature(key, true);
                    } 
                } 
XmlPullParser var6B083770A9017854BE96B8873F66785B_1004891980 =                 pp;
                var6B083770A9017854BE96B8873F66785B_1004891980.addTaint(taint);
                return var6B083770A9017854BE96B8873F66785B_1004891980;
            } 
            catch (Exception ex)
            {
                issues.append (ppClass.getName () + ": "+ ex.toString ()+"; ");
            } 
        } 
        XmlPullParserException var70853AEE3D8A231D2863B4DB9E5A409A_586926440 = new XmlPullParserException ("could not create parser: "+issues);
        var70853AEE3D8A231D2863B4DB9E5A409A_586926440.addTaint(taint);
        throw var70853AEE3D8A231D2863B4DB9E5A409A_586926440;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.645 -0400", hash_original_method = "72277D8D6A4CD4D2004A6DECEFEB4DA7", hash_generated_method = "70782774B2D16DB0CB83A7672E4FE5CE")
    public XmlSerializer newSerializer() throws XmlPullParserException {
    if(serializerClasses == null)        
        {
            XmlPullParserException var827A074F8D267967AE8E445BC221BB7E_1935544734 = new XmlPullParserException
                ("Factory initialization incomplete - has not tried "+classNamesLocation);
            var827A074F8D267967AE8E445BC221BB7E_1935544734.addTaint(taint);
            throw var827A074F8D267967AE8E445BC221BB7E_1935544734;
        } 
    if(serializerClasses.size() == 0)        
        {
            XmlPullParserException varDFF88D1B04C06EF39538B1EBDDC41291_1717282461 = new XmlPullParserException
                ("No valid serializer classes found in "+classNamesLocation);
            varDFF88D1B04C06EF39538B1EBDDC41291_1717282461.addTaint(taint);
            throw varDFF88D1B04C06EF39538B1EBDDC41291_1717282461;
        } 
        final StringBuilder issues = new StringBuilder ();
for(int i = 0;i < serializerClasses.size ();i++)
        {
            final Class ppClass = (Class) serializerClasses.get(i);
            try 
            {
                final XmlSerializer ser = (XmlSerializer) ppClass.newInstance();
XmlSerializer var0BEA34000EE709D03EB4BC9DC3C2B533_765608132 =                 ser;
                var0BEA34000EE709D03EB4BC9DC3C2B533_765608132.addTaint(taint);
                return var0BEA34000EE709D03EB4BC9DC3C2B533_765608132;
            } 
            catch (Exception ex)
            {
                issues.append (ppClass.getName () + ": "+ ex.toString ()+"; ");
            } 
        } 
        XmlPullParserException varEDB43EB3E2ECB9AA2EEF51B749857ADB_486163145 = new XmlPullParserException ("could not create serializer: "+issues);
        varEDB43EB3E2ECB9AA2EEF51B749857ADB_486163145.addTaint(taint);
        throw varEDB43EB3E2ECB9AA2EEF51B749857ADB_486163145;
        
        
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.646 -0400", hash_original_field = "85E092DE17CB1169218C8B191C4D88D4", hash_generated_field = "883198D89D71761DBB74BFD5A655879D")

    static Class referenceContextClass;
    static {
        XmlPullParserFactory f = new XmlPullParserFactory();
        referenceContextClass = f.getClass();
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.646 -0400", hash_original_field = "33FC263AFDBB4EEDBBE1504047AE9A37", hash_generated_field = "C6E7862EC1172DC262780F881FC06DEC")

    public static final String PROPERTY_NAME =
        "org.xmlpull.v1.XmlPullParserFactory";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.646 -0400", hash_original_field = "2A2F7FF4F241CDA2C6261B43F6383287", hash_generated_field = "857B4961AF71D0398E9BF439994827F2")

    private static final String RESOURCE_NAME = "/META-INF/services/" + PROPERTY_NAME;
}

