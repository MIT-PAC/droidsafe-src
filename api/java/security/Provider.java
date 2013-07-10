package java.security;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;
import java.io.NotActiveException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.apache.harmony.luni.util.TwoKeyHashMap;
import org.apache.harmony.security.fortress.Services;

public abstract class Provider extends Properties {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.602 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.602 -0400", hash_original_field = "2AF72F100C356273D46284F6FD1DFC08", hash_generated_field = "F3CA80FC5F7B3B542DC8B1C8FD91731C")

    private double version;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.602 -0400", hash_original_field = "239623964829E21A6BEC8B51CD66FB1E", hash_generated_field = "AEF8D804C6A6E39F2A136B97DEDD88CA")

    private transient String versionString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.602 -0400", hash_original_field = "CAF9B6B99962BF5C2264824231D7A40C", hash_generated_field = "1F50CB615F8F0AB19DCF28D9BAFF4DD4")

    private String info;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.602 -0400", hash_original_field = "426DF410C50A922A7FCCB45E28CFB99B", hash_generated_field = "3D346C5395708831B6A443E01975CD82")

    private transient int providerNumber = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.602 -0400", hash_original_field = "90D27D782F6C6A467A120DC0EA3CABA4", hash_generated_field = "D2A7F737A7D1793E39403AC0C5DE42B9")

    private transient TwoKeyHashMap<String, String, Service> serviceTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.602 -0400", hash_original_field = "C8290F032C183B62C8206C67F6F9691A", hash_generated_field = "B06FB286EE00C306B86D2F80CC057271")

    private transient TwoKeyHashMap<String, String, Service> aliasTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.602 -0400", hash_original_field = "51EA4BA55D4773B26DE32A2D9219C113", hash_generated_field = "974CEA24FA2B0A232602FB5D7E8DE337")

    private transient TwoKeyHashMap<String, String, Service> propertyServiceTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.602 -0400", hash_original_field = "0C259300D051D5E7246B301C0DD26E65", hash_generated_field = "496EDC5FF7DCB745D06FD58901D71D88")

    private transient TwoKeyHashMap<String, String, Service> propertyAliasTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.603 -0400", hash_original_field = "2157E7B4176C83B64377DBFE7F76F07E", hash_generated_field = "8BBAB31DBAA82BF49B07B5E12D0CF85B")

    private transient Properties changedProperties;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.603 -0400", hash_original_field = "3124884BBCB44722A70DEA4CA0A5EEDF", hash_generated_field = "78CA56FA7454490EF4843EE66CC1589B")

    private transient Provider.Service returnedService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.603 -0400", hash_original_field = "608855017360FBF6AA459F927179D0DF", hash_generated_field = "A17CE05D31CA338777E2E3315B0B2BB2")

    private transient String lastAlgorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.603 -0400", hash_original_field = "201DB549B9B6C1D90243C19553DE6893", hash_generated_field = "26FDBDCE6D172CC943C76DDD3CE0C4F1")

    private transient String lastServiceName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.603 -0400", hash_original_field = "79C5FB5C2352B93E380EDFDC155D6452", hash_generated_field = "BA27D1D25E16A8C025C9D2F64E31C9C5")

    private transient Set<Service> lastServicesSet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.603 -0400", hash_original_field = "AF709187F08859A6E70DA4496782164A", hash_generated_field = "3F98FC0FC213ABB6A1D68A8492E264D1")

    private transient String lastType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.603 -0400", hash_original_field = "C51F06888C4D2B6BFD3C97C9199539C4", hash_generated_field = "734DC09FAD571851B677CBD6C2E18D22")

    private transient Provider.Service lastServicesByType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.603 -0400", hash_original_method = "CD3EC30E89504BC69886C014A5CD7A7E", hash_generated_method = "C4D627FD8EDE0CA93E2598F924F902BC")
    protected  Provider(String name, double version, String info) {
        this.name = name;
        this.version = version;
        this.info = info;
        versionString = String.valueOf(version);
        putProviderInfo();
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.604 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "BE01B038A23644FF74C9E9923606E094")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1670595863 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1670595863 = name;
        varB4EAC82CA7396A68D541C85D26508E83_1670595863.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1670595863;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.604 -0400", hash_original_method = "849DADC9512AC29CFF5A5EB4D1517425", hash_generated_method = "59338BDDFD799C01306411A0DAC59183")
    public double getVersion() {
        double varE8CD7DA078A86726031AD64F35F5A6C0_803023441 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_803023441;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.604 -0400", hash_original_method = "90F1C2C1B854E8544A3CF05D4B3BD6E7", hash_generated_method = "2ADDEEBA7395246246A69A45FCE15FAC")
    public String getInfo() {
        String varB4EAC82CA7396A68D541C85D26508E83_181584505 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_181584505 = info;
        varB4EAC82CA7396A68D541C85D26508E83_181584505.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_181584505;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.605 -0400", hash_original_method = "58EC0A1A07497E3FA377B5366380E5E3", hash_generated_method = "FDBB5E14A2CFAD1ABB5623504D79AA4E")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1839059551 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1839059551 = name + " version " + version;
        varB4EAC82CA7396A68D541C85D26508E83_1839059551.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1839059551;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.606 -0400", hash_original_method = "53793BFB01C9C5B2BDDE9F63C2E38535", hash_generated_method = "A19DC41C7A8FE29FEA9015506AFF42CE")
    @Override
    public synchronized void clear() {
        super.clear();
        {
            serviceTable.clear();
        } 
        {
            propertyServiceTable.clear();
        } 
        {
            aliasTable.clear();
        } 
        {
            propertyAliasTable.clear();
        } 
        changedProperties = null;
        putProviderInfo();
        {
            Services.setNeedRefresh();
        } 
        servicesChanged();
        
        
        
            
        
        
            
        
        
            
        
        
            
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.607 -0400", hash_original_method = "EB6BD048CAF9E12CFD99EC1891725291", hash_generated_method = "B3B9EAD32DC6E226819616E80D60B159")
    @Override
    public synchronized void load(InputStream inStream) throws IOException {
        Properties tmp = new Properties();
        tmp.load(inStream);
        myPutAll(tmp);
        addTaint(inStream.getTaint());
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.607 -0400", hash_original_method = "CE4C2613BF29D966F3F961299EB30975", hash_generated_method = "A9B51435AF0F7EBFCFADA8C2F3FCC4CD")
    @Override
    public synchronized void putAll(Map<?,?> t) {
        myPutAll(t);
        addTaint(t.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.608 -0400", hash_original_method = "F898BA9F30F0CED7EAABA59AE5C4F6F9", hash_generated_method = "364A731C38FD55B9680F608C48266A43")
    private void myPutAll(Map<?,?> t) {
        {
            changedProperties = new Properties();
        } 
        Iterator<? extends Map.Entry<?, ?>> it = t.entrySet().iterator();
        Object key;
        Object value;
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_186964795 = (it.hasNext());
            {
                Map.Entry<?, ?> entry = it.next();
                key = entry.getKey();
                {
                    boolean var39D76CDDB13616FD0D42E75AC7C012F1_856252504 = (key instanceof String && ((String) key).startsWith("Provider."));
                } 
                value = entry.getValue();
                super.put(key, value);
                {
                    boolean var557FC3098495809338F3BC3135E1280B_220843006 = (changedProperties.remove(key) == null);
                    {
                        removeFromPropertyServiceTable(key);
                    } 
                } 
                changedProperties.put(key, value);
            } 
        } 
        {
            Services.setNeedRefresh();
        } 
        addTaint(t.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.608 -0400", hash_original_method = "70D9A28808783B7E2708BCE915ECB209", hash_generated_method = "EB48C6AAA58CC5C265D262844D74A60F")
    @Override
    public synchronized Set<Map.Entry<Object,Object>> entrySet() {
        Set<Map.Entry<Object,Object>> varB4EAC82CA7396A68D541C85D26508E83_522063911 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_522063911 = Collections.unmodifiableSet(super.entrySet());
        varB4EAC82CA7396A68D541C85D26508E83_522063911.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_522063911;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.609 -0400", hash_original_method = "45BA03BABBCEC97C3CDEDDFAAD34C546", hash_generated_method = "450D49A45DD25D880B634AA9AFAA0918")
    @Override
    public Set<Object> keySet() {
        Set<Object> varB4EAC82CA7396A68D541C85D26508E83_1690262323 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1690262323 = Collections.unmodifiableSet(super.keySet());
        varB4EAC82CA7396A68D541C85D26508E83_1690262323.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1690262323;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.609 -0400", hash_original_method = "4FF8F6E11AAD8FB860F173913A5840CE", hash_generated_method = "3437D79A042219D522C8AE1C97866F25")
    @Override
    public Collection<Object> values() {
        Collection<Object> varB4EAC82CA7396A68D541C85D26508E83_987740283 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_987740283 = Collections.unmodifiableCollection(super.values());
        varB4EAC82CA7396A68D541C85D26508E83_987740283.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_987740283;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.610 -0400", hash_original_method = "6B0BAE35C6955DE6DEF5897424A78326", hash_generated_method = "44A71E915018B28A70ACFE48507BEC7D")
    @Override
    public synchronized Object put(Object key, Object value) {
        Object varB4EAC82CA7396A68D541C85D26508E83_237501702 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_202382672 = null; 
        {
            boolean var615FFDC8C58E5DA9131CFD1E840EB61D_2081286628 = (key instanceof String && ((String) key).startsWith("Provider."));
            {
                varB4EAC82CA7396A68D541C85D26508E83_237501702 = null;
            } 
        } 
        {
            Services.setNeedRefresh();
        } 
        {
            boolean varF5120E22219DB168E3E6D91BEC202FF4_320261093 = (changedProperties != null && changedProperties.remove(key) == null);
            {
                removeFromPropertyServiceTable(key);
            } 
        } 
        {
            changedProperties = new Properties();
        } 
        changedProperties.put(key, value);
        varB4EAC82CA7396A68D541C85D26508E83_202382672 = super.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_1746346561; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1746346561 = varB4EAC82CA7396A68D541C85D26508E83_237501702;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1746346561 = varB4EAC82CA7396A68D541C85D26508E83_202382672;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1746346561.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1746346561;
        
        
            
        
        
            
        
        
            
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.611 -0400", hash_original_method = "8EA23C4ABA882E49A95AE531F4BFEB20", hash_generated_method = "58EB3FF56ABB622453ACB638074781A3")
    @Override
    public synchronized Object remove(Object key) {
        Object varB4EAC82CA7396A68D541C85D26508E83_384006954 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_1691662353 = null; 
        {
            boolean var615FFDC8C58E5DA9131CFD1E840EB61D_1776836917 = (key instanceof String && ((String) key).startsWith("Provider."));
            {
                varB4EAC82CA7396A68D541C85D26508E83_384006954 = null;
            } 
        } 
        {
            Services.setNeedRefresh();
        } 
        {
            boolean varF5120E22219DB168E3E6D91BEC202FF4_586389482 = (changedProperties != null && changedProperties.remove(key) == null);
            {
                removeFromPropertyServiceTable(key);
                {
                    boolean var88F5A1A88583F68F084FEAD07CBA365C_1654146729 = (changedProperties.size() == 0);
                    {
                        changedProperties = null;
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1691662353 = super.remove(key);
        addTaint(key.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_1568577229; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1568577229 = varB4EAC82CA7396A68D541C85D26508E83_384006954;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1568577229 = varB4EAC82CA7396A68D541C85D26508E83_1691662353;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1568577229.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1568577229;
        
        
            
        
        
            
        
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.611 -0400", hash_original_method = "73ADEB588A693290C2EBE420EE1B60DD", hash_generated_method = "C406A11FFDD83C962C2ACE99945C8DF4")
     boolean implementsAlg(String serv, String alg, String attribute, String val) {
        String servAlg = serv + "." + alg;
        String prop = getPropertyIgnoreCase(servAlg);
        {
            alg = getPropertyIgnoreCase("Alg.Alias." + servAlg);
            {
                servAlg = serv + "." + alg;
                prop = getPropertyIgnoreCase(servAlg);
            } 
        } 
        {
            boolean var83392DFFAC381D73DD8A3765EFB03BDF_634191208 = (checkAttribute(servAlg, attribute, val));
        } 
        addTaint(serv.getTaint());
        addTaint(alg.getTaint());
        addTaint(attribute.getTaint());
        addTaint(val.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1829051077 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1829051077;
        
        
        
        
            
            
                
                
            
        
        
            
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.612 -0400", hash_original_method = "205FEBDC4595F3CAF3DB8C26A01A3B21", hash_generated_method = "18BBB83B55E7DD039132F4A44DBE88E6")
    private boolean checkAttribute(String servAlg, String attribute, String val) {
        String attributeValue = getPropertyIgnoreCase(servAlg + ' ' + attribute);
        {
            {
                boolean var9AAE8A593FFFFD550F3379BD45AFB455_1223213048 = (attribute.equalsIgnoreCase("KeySize"));
                {
                    {
                        boolean var2CCBDA5D9949774AEDDE95DD101E1B5B_1049395350 = (Integer.parseInt(attributeValue) >= Integer.parseInt(val));
                    } 
                } 
                {
                    {
                        boolean varBE561380D0BC947AE323F09089366FE2_374420675 = (attributeValue.equalsIgnoreCase(val));
                    } 
                } 
            } 
        } 
        addTaint(servAlg.getTaint());
        addTaint(attribute.getTaint());
        addTaint(val.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_545819080 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_545819080;
        
        
        
            
                
                    
                
            
                
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.612 -0400", hash_original_method = "6418C82159D4FAB251CB16B6C408D61D", hash_generated_method = "BA9FDE46C0F8402C6FB4936CC36C7FAA")
     void setProviderNumber(int n) {
        providerNumber = n;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.612 -0400", hash_original_method = "6209D7B36FBC76163C52BAAF1CE53C35", hash_generated_method = "816C65685015F47E4AA208DACCCDAC39")
     int getProviderNumber() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_373272808 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_373272808;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.613 -0400", hash_original_method = "6BFCD4E62487080CD7F60A29BC4CC43B", hash_generated_method = "DB466ED334F33F53B1FBAC38CC56EB3F")
    synchronized Provider.Service getService(String type) {
        Provider.Service varB4EAC82CA7396A68D541C85D26508E83_52657147 = null; 
        Provider.Service varB4EAC82CA7396A68D541C85D26508E83_755802166 = null; 
        Provider.Service varB4EAC82CA7396A68D541C85D26508E83_116348288 = null; 
        updatePropertyServiceTable();
        {
            boolean varE8D1884AAD74E2F5DA1CD399B1822ECD_283482395 = (lastServicesByType != null && type.equals(lastType));
            {
                varB4EAC82CA7396A68D541C85D26508E83_52657147 = lastServicesByType;
            } 
        } 
        Provider.Service service;
        {
            Iterator<Service> it = getServices().iterator();
            boolean var03729FD53960D8DCA3A41A13A0229637_841192264 = (it.hasNext());
            {
                service = it.next();
                {
                    boolean var4C71E495B2DBF2BB72C8225160CEBE9A_416480139 = (type.equals(service.type));
                    {
                        lastType = type;
                        lastServicesByType = service;
                        varB4EAC82CA7396A68D541C85D26508E83_755802166 = service;
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_116348288 = null;
        Provider.Service varA7E53CE21691AB073D9660D615818899_589263633; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_589263633 = varB4EAC82CA7396A68D541C85D26508E83_52657147;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_589263633 = varB4EAC82CA7396A68D541C85D26508E83_755802166;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_589263633 = varB4EAC82CA7396A68D541C85D26508E83_116348288;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_589263633.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_589263633;
        
        
        
            
        
        
        
            
            
                
                
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.614 -0400", hash_original_method = "6DABE02DE2A4DD1C36F9592BEF5E1C73", hash_generated_method = "43EF7D015D86A523D93AF3A24014FF32")
    public synchronized Provider.Service getService(String type,
            String algorithm) {
        Provider.Service varB4EAC82CA7396A68D541C85D26508E83_2126327327 = null; 
        Provider.Service varB4EAC82CA7396A68D541C85D26508E83_999733178 = null; 
        Provider.Service varB4EAC82CA7396A68D541C85D26508E83_123279396 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        {
            boolean var5D9786D09CE430680B17444C7FCE5061_1867904375 = (type.equals(lastServiceName) && algorithm.equalsIgnoreCase(lastAlgorithm));
            {
                varB4EAC82CA7396A68D541C85D26508E83_2126327327 = returnedService;
            } 
        } 
        String alg = algorithm.toUpperCase(Locale.US);
        Object o = null;
        {
            o = serviceTable.get(type, alg);
        } 
        {
            o = aliasTable.get(type, alg);
        } 
        {
            updatePropertyServiceTable();
        } 
        {
            o = propertyServiceTable.get(type, alg);
        } 
        {
            o = propertyAliasTable.get(type, alg);
        } 
        {
            lastServiceName = type;
            lastAlgorithm = algorithm;
            returnedService = (Provider.Service) o;
            varB4EAC82CA7396A68D541C85D26508E83_999733178 = returnedService;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_123279396 = null;
        Provider.Service varA7E53CE21691AB073D9660D615818899_1237272766; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1237272766 = varB4EAC82CA7396A68D541C85D26508E83_2126327327;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1237272766 = varB4EAC82CA7396A68D541C85D26508E83_999733178;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1237272766 = varB4EAC82CA7396A68D541C85D26508E83_123279396;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1237272766.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1237272766;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.615 -0400", hash_original_method = "8008CDA805FE131E4E7ECE670E22E200", hash_generated_method = "40EC8FC146CE77F49C5E1CD093E6DDB0")
    public synchronized Set<Provider.Service> getServices() {
        Set<Provider.Service> varB4EAC82CA7396A68D541C85D26508E83_1797450408 = null; 
        Set<Provider.Service> varB4EAC82CA7396A68D541C85D26508E83_1560152026 = null; 
        updatePropertyServiceTable();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1797450408 = lastServicesSet;
        } 
        {
            lastServicesSet = new HashSet<Service>(serviceTable.values());
        } 
        {
            lastServicesSet = new HashSet<Service>();
        } 
        {
            lastServicesSet.addAll(propertyServiceTable.values());
        } 
        lastServicesSet = Collections.unmodifiableSet(lastServicesSet);
        varB4EAC82CA7396A68D541C85D26508E83_1560152026 = lastServicesSet;
        Set<Provider.Service> varA7E53CE21691AB073D9660D615818899_93940921; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_93940921 = varB4EAC82CA7396A68D541C85D26508E83_1797450408;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_93940921 = varB4EAC82CA7396A68D541C85D26508E83_1560152026;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_93940921.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_93940921;
        
        
        
            
        
        
            
        
            
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.619 -0400", hash_original_method = "3E5E06298B83C020AD9BCF69B9E3CE94", hash_generated_method = "CA9C40642D392D231AE919E571C4E56A")
    protected synchronized void putService(Provider.Service s) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        {
            boolean varF52B1BD6E65C5078A2BDD1FFCE56BDE7_1078471789 = ("Provider".equals(s.getType()));
        } 
        servicesChanged();
        {
            serviceTable = new TwoKeyHashMap<String, String, Service>(128);
        } 
        serviceTable.put(s.type, s.algorithm.toUpperCase(Locale.US), s);
        {
            {
                aliasTable = new TwoKeyHashMap<String, String, Service>(256);
            } 
            {
                Iterator<String> var53A703E015EC0F90D15F82B6703EC2ED_958390088 = (s.getAliases()).iterator();
                var53A703E015EC0F90D15F82B6703EC2ED_958390088.hasNext();
                String alias = var53A703E015EC0F90D15F82B6703EC2ED_958390088.next();
                {
                    aliasTable.put(s.type, alias.toUpperCase(Locale.US), s);
                } 
            } 
        } 
        serviceInfoToProperties(s);
        addTaint(s.getTaint());
        
        
            
        
        
            
        
        
        
            
        
        
        
            
                
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.622 -0400", hash_original_method = "D2521231A8F61254D866781010E5F7B6", hash_generated_method = "504670D848652B3A2793A5607F99F3AB")
    protected synchronized void removeService(Provider.Service s) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        servicesChanged();
        {
            serviceTable.remove(s.type, s.algorithm.toUpperCase(Locale.US));
        } 
        {
            {
                Iterator<String> var0B0914451AB60F2FBE3FA1B1B21C1A4E_671705019 = (s.getAliases()).iterator();
                var0B0914451AB60F2FBE3FA1B1B21C1A4E_671705019.hasNext();
                String alias = var0B0914451AB60F2FBE3FA1B1B21C1A4E_671705019.next();
                {
                    aliasTable.remove(s.type, alias.toUpperCase(Locale.US));
                } 
            } 
        } 
        serviceInfoFromProperties(s);
        addTaint(s.getTaint());
        
        
            
        
        
        
            
        
        
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.624 -0400", hash_original_method = "FD9674DD64603638CEEAFAAECA2377E1", hash_generated_method = "63774F3696928C3ABBDCE52C9D96414D")
    private void serviceInfoToProperties(Provider.Service s) {
        super.put(s.type + "." + s.algorithm, s.className);
        {
            {
                Iterator<String> i = s.aliases.iterator();
                boolean varD8B5E52A597500CBD863E52A46B42708_1735971482 = (i.hasNext());
                {
                    super.put("Alg.Alias." + s.type + "." + i.next(), s.algorithm);
                } 
            } 
        } 
        {
            {
                Iterator<Map.Entry<String, String>> varEC591D00247358B530BCEAA3DE5F4B70_936021728 = (s.attributes.entrySet()).iterator();
                varEC591D00247358B530BCEAA3DE5F4B70_936021728.hasNext();
                Map.Entry<String, String> entry = varEC591D00247358B530BCEAA3DE5F4B70_936021728.next();
                {
                    super.put(s.type + "." + s.algorithm + " " + entry.getKey(),
                        entry.getValue());
                } 
            } 
        } 
        {
            Services.setNeedRefresh();
        } 
        addTaint(s.getTaint());
        
        
        
            
                
            
        
        
            
                
                        
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.627 -0400", hash_original_method = "E3342D080F10DDAA1FF9ED29EA29694F", hash_generated_method = "10065B49350169A3D42044672E05C8FC")
    private void serviceInfoFromProperties(Provider.Service s) {
        super.remove(s.type + "." + s.algorithm);
        {
            {
                Iterator<String> i = s.aliases.iterator();
                boolean varD8B5E52A597500CBD863E52A46B42708_526181373 = (i.hasNext());
                {
                    super.remove("Alg.Alias." + s.type + "." + i.next());
                } 
            } 
        } 
        {
            {
                Iterator<Map.Entry<String, String>> varEC591D00247358B530BCEAA3DE5F4B70_925979581 = (s.attributes.entrySet()).iterator();
                varEC591D00247358B530BCEAA3DE5F4B70_925979581.hasNext();
                Map.Entry<String, String> entry = varEC591D00247358B530BCEAA3DE5F4B70_925979581.next();
                {
                    super.remove(s.type + "." + s.algorithm + " " + entry.getKey());
                } 
            } 
        } 
        {
            Services.setNeedRefresh();
        } 
        addTaint(s.getTaint());
        
        
        
            
                
            
        
        
            
                
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.638 -0400", hash_original_method = "C88E49400116B5906A9CAC0E8D20528B", hash_generated_method = "199B27991A6E203551BC30F40A04AFAB")
    private void removeFromPropertyServiceTable(Object key) {
        String k = (String) key;
        {
            boolean var51D0AB19C0E4EAD46591A8C66CC40542_308650152 = (k.startsWith("Provider."));
        } 
        Provider.Service s;
        String serviceName;
        String algorithm = null;
        String attribute = null;
        int i;
        {
            boolean varB2EA1E0E9D7C7EEC2C9BF24E8B1510EA_1990214241 = (k.startsWith("Alg.Alias."));
            {
                String aliasName;
                String service_alias = k.substring(10);
                i = service_alias.indexOf('.');
                serviceName = service_alias.substring(0, i);
                aliasName = service_alias.substring(i + 1);
                {
                    propertyAliasTable.remove(serviceName, aliasName.toUpperCase(Locale.US));
                } 
                {
                    {
                        Iterator<Service> it = propertyServiceTable.values().iterator();
                        boolean var4A1B8BE89C779B21458638B02948AC2A_670247192 = (it
                        .hasNext());
                        {
                            s = it.next();
                            {
                                boolean var6F8C4AE25185D3231A2E4FD7E4E357C3_264175920 = (s.aliases.contains(aliasName));
                                {
                                    s.aliases.remove(aliasName);
                                } 
                            } 
                        } 
                    } 
                } 
            } 
        } 
        int j = k.indexOf('.');
        i = k.indexOf(' ');
        {
            serviceName = k.substring(0, j);
            algorithm = k.substring(j + 1);
            {
                Provider.Service ser = propertyServiceTable.remove(serviceName,
                        algorithm.toUpperCase(Locale.US));
                {
                    {
                        Iterator<String> var3BE46C9A129D4D7F74F143C9623D7876_968136592 = (ser.aliases).iterator();
                        var3BE46C9A129D4D7F74F143C9623D7876_968136592.hasNext();
                        String alias = var3BE46C9A129D4D7F74F143C9623D7876_968136592.next();
                        {
                            propertyAliasTable.remove(serviceName, alias.toUpperCase(Locale.US));
                        } 
                    } 
                } 
            } 
        } 
        {
            attribute = k.substring(i + 1);
            serviceName = k.substring(0, j);
            algorithm = k.substring(j + 1, i);
            {
                Object o = propertyServiceTable.get(serviceName, algorithm.toUpperCase(Locale.US));
                {
                    s = (Provider.Service) o;
                    s.attributes.remove(attribute);
                } 
            } 
        } 
        addTaint(key.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.640 -0400", hash_original_method = "C12B51396475B7F4EF23B74D619C33FD", hash_generated_method = "E1BC39756C2F7325111DD392EE64722B")
    private void updatePropertyServiceTable() {
        Object _key;
        Object _value;
        Provider.Service s;
        String serviceName;
        String algorithm;
        {
            boolean var9C86F49586631F13D865CF4B9FA9A44B_779743274 = (changedProperties == null || changedProperties.isEmpty());
        } 
        {
            Iterator<Map.Entry<Object, Object>> it = changedProperties.entrySet().iterator();
            boolean var9D0EDA54CCAB017AFE33C830CCA36C58_940510703 = (it
                .hasNext());
            {
                Map.Entry<Object, Object> entry = it.next();
                _key = entry.getKey();
                _value = entry.getValue();
                String key = (String) _key;
                String value = (String) _value;
                {
                    boolean var2F2AA442FA156A8F8BA53B7B622AD8C8_729967789 = (key.startsWith("Provider"));
                } 
                int i;
                {
                    boolean var95164A0B30E45315F7A1F2560FE7C960_790949677 = (key.startsWith("Alg.Alias."));
                    {
                        String aliasName;
                        String service_alias = key.substring(10);
                        i = service_alias.indexOf('.');
                        serviceName = service_alias.substring(0, i);
                        aliasName = service_alias.substring(i + 1);
                        algorithm = value;
                        String algUp = algorithm.toUpperCase(Locale.US);
                        Object o = null;
                        {
                            propertyServiceTable = new TwoKeyHashMap<String, String, Service>(128);
                        } 
                        {
                            o = propertyServiceTable.get(serviceName, algUp);
                        } 
                        {
                            s = (Provider.Service) o;
                            s.addAlias(aliasName);
                            {
                                propertyAliasTable = new TwoKeyHashMap<String, String, Service>(256);
                            } 
                            propertyAliasTable.put(serviceName, aliasName.toUpperCase(Locale.US), s);
                        } 
                        {
                            String className = (String) changedProperties
                            .get(serviceName + "." + algorithm);
                            {
                                List<String> l = new ArrayList<String>();
                                l.add(aliasName);
                                s = new Provider.Service(this, serviceName, algorithm,
                                className, l, new HashMap<String, String>());
                                propertyServiceTable.put(serviceName, algUp, s);
                                {
                                    propertyAliasTable = new TwoKeyHashMap<String, String, Service>(256);
                                } 
                                propertyAliasTable.put(serviceName, aliasName.toUpperCase(Locale.US), s);
                            } 
                        } 
                    } 
                } 
                int j = key.indexOf('.');
                i = key.indexOf(' ');
                {
                    serviceName = key.substring(0, j);
                    algorithm = key.substring(j + 1);
                    String alg = algorithm.toUpperCase(Locale.US);
                    Object o = null;
                    {
                        o = propertyServiceTable.get(serviceName, alg);
                    } 
                    {
                        s = (Provider.Service) o;
                        s.className = value;
                    } 
                    {
                        s = new Provider.Service(this, serviceName, algorithm,
                            value, Collections.<String>emptyList(),
                            Collections.<String,String>emptyMap());
                        {
                            propertyServiceTable = new TwoKeyHashMap<String, String, Service>(128);
                        } 
                        propertyServiceTable.put(serviceName, alg, s);
                    } 
                } 
                {
                    serviceName = key.substring(0, j);
                    algorithm = key.substring(j + 1, i);
                    String attribute = key.substring(i + 1);
                    String alg = algorithm.toUpperCase(Locale.US);
                    Object o = null;
                    {
                        o = propertyServiceTable.get(serviceName, alg);
                    } 
                    {
                        s = (Provider.Service) o;
                        s.putAttribute(attribute, value);
                    } 
                    {
                        String className = (String) changedProperties
                            .get(serviceName + "." + algorithm);
                        {
                            Map<String, String> m = new HashMap<String, String>();
                            m.put(attribute, value);
                            s = new Provider.Service(this, serviceName, algorithm,
                                className, new ArrayList<String>(), m);
                            {
                                propertyServiceTable = new TwoKeyHashMap<String, String, Service>(128);
                            } 
                            propertyServiceTable.put(serviceName, alg, s);
                        } 
                    } 
                } 
            } 
        } 
        servicesChanged();
        changedProperties = null;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.641 -0400", hash_original_method = "FD7619437CD0960F1AEBA32A154F0328", hash_generated_method = "9C6A342A2081A7D73BA214C115FEC8EA")
    private void servicesChanged() {
        lastServicesByType = null;
        lastServiceName = null;
        lastServicesSet = null;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.642 -0400", hash_original_method = "768CFC89B63FD1F782E3758D2BCFC6C0", hash_generated_method = "BEA2C42DB158CE6C3270D65A149F3B2E")
    private void putProviderInfo() {
        super.put("Provider.id name", (name != null) ? name : "null");
        super.put("Provider.id version", versionString);
        super.put("Provider.id info", (info != null) ? info : "null");
        super.put("Provider.id className", this.getClass().getName());
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.643 -0400", hash_original_method = "62DD35352FE8FA7B38C17798ED376C47", hash_generated_method = "906522DCB0F25C6AA2D77FBDD7E1C76D")
    private String getPropertyIgnoreCase(String key) {
        String varB4EAC82CA7396A68D541C85D26508E83_920149551 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1298094647 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1078678938 = null; 
        String res = getProperty(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_920149551 = res;
        } 
        {
            Enumeration<?> e = propertyNames();
            boolean var3EB0A96682EDBE15308427BAC1EC4A4E_2098140399 = (e.hasMoreElements());
            {
                String propertyName = (String) e.nextElement();
                {
                    boolean var7026A60BEF5468325737B39ADF42B3F9_902499015 = (key.equalsIgnoreCase(propertyName));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1298094647 = getProperty(propertyName);
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1078678938 = null;
        addTaint(key.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1801720453; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1801720453 = varB4EAC82CA7396A68D541C85D26508E83_920149551;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1801720453 = varB4EAC82CA7396A68D541C85D26508E83_1298094647;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1801720453 = varB4EAC82CA7396A68D541C85D26508E83_1078678938;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1801720453.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1801720453;
        
        
        
            
        
        
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.644 -0400", hash_original_method = "C9BE26B06AA230EA20C77B7F366C53C8", hash_generated_method = "33B05CAC88D7518817CBC9CBBAA8281A")
    private void readObject(java.io.ObjectInputStream in) throws NotActiveException, IOException, ClassNotFoundException {
        in.defaultReadObject();
        versionString = String.valueOf(version);
        providerNumber = -1;
        addTaint(in.getTaint());
        
        
        
        
    }

    
    public static class Service {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.644 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

        private Provider provider;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.644 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

        private String type;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.644 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

        private String algorithm;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.644 -0400", hash_original_field = "6F66E878C62DB60568A3487869695820", hash_generated_field = "B28341EF6B88AA3CAD2D37FF14C9DC00")

        private String className;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.644 -0400", hash_original_field = "9299DA2529C98FCCCE0E32B476BA3266", hash_generated_field = "7D96162B1AE01DA7357D6662D8D2C584")

        private List<String> aliases;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.644 -0400", hash_original_field = "736B91750E516139ACC13C5EB6564F92", hash_generated_field = "1CEAC23D4A656E23182C27FC3A78AEDE")

        private Map<String,String> attributes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.644 -0400", hash_original_field = "B6FA15360B4CDCE4806BF9A0580C8F0F", hash_generated_field = "28101B8550628F94A8DDB23FAF399E56")

        private Class<?> implementation;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.645 -0400", hash_original_field = "77FDFBF3D811B72BC9BBBE747A722F58", hash_generated_field = "668E14A773F053D0B44156BD480B724E")

        private String lastClassName;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.646 -0400", hash_original_method = "82CB06DCD943152835D64FFE915BA566", hash_generated_method = "729BA8513727B47508A50A1E8982676B")
        public  Service(Provider provider, String type, String algorithm,
                String className, List<String> aliases, Map<String, String> attributes) {
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } 
            this.provider = provider;
            this.type = type;
            this.algorithm = algorithm;
            this.className = className;
            this.aliases = ((aliases != null) && (aliases.size() == 0))
                    ? Collections.<String>emptyList() : aliases;
            this.attributes =
                    ((attributes != null) && (attributes.size() == 0))
                    ? Collections.<String,String>emptyMap() : attributes;
            
            
                    
                
            
            
            
            
            
            
                    
            
                    
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.647 -0400", hash_original_method = "4CA8000463C36260BD9C3E4A41E197CE", hash_generated_method = "48FA5D9D73E4A50BBF45464CBD7BE3EE")
         void addAlias(String alias) {
            {
                boolean var5374BEA4A10DF1C27BAE96F18BD3D766_788082826 = ((aliases == null) || (aliases.size() == 0));
                {
                    aliases = new ArrayList<String>();
                } 
            } 
            aliases.add(alias);
            addTaint(alias.getTaint());
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.647 -0400", hash_original_method = "2623207C72797F9950DF9980B680F416", hash_generated_method = "13AD87CF06C3CE63DE58863D1D88A1B9")
         void putAttribute(String name, String value) {
            {
                boolean varEB4E27A2355C4FBDE3011F0D25AF36B4_308748620 = ((attributes == null) || (attributes.size() == 0));
                {
                    attributes = new HashMap<String,String>();
                } 
            } 
            attributes.put(name, value);
            addTaint(name.getTaint());
            addTaint(value.getTaint());
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.648 -0400", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "1554FD12C7087797632692F2D89597B4")
        public final String getType() {
            String varB4EAC82CA7396A68D541C85D26508E83_1725031610 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1725031610 = type;
            varB4EAC82CA7396A68D541C85D26508E83_1725031610.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1725031610;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.648 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "FD465BB5ADAF9BA5F0D394D64B6CEA66")
        public final String getAlgorithm() {
            String varB4EAC82CA7396A68D541C85D26508E83_553382122 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_553382122 = algorithm;
            varB4EAC82CA7396A68D541C85D26508E83_553382122.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_553382122;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.649 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "578A995B1F48CCFC92267C436E0D184D")
        public final Provider getProvider() {
            Provider varB4EAC82CA7396A68D541C85D26508E83_147422320 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_147422320 = provider;
            varB4EAC82CA7396A68D541C85D26508E83_147422320.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_147422320;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.649 -0400", hash_original_method = "8415940D3A1E5651F883E391EC68DA41", hash_generated_method = "CD9776548396DE0B4A2A1088DD59DAA8")
        public final String getClassName() {
            String varB4EAC82CA7396A68D541C85D26508E83_1399461796 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1399461796 = className;
            varB4EAC82CA7396A68D541C85D26508E83_1399461796.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1399461796;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.650 -0400", hash_original_method = "0C10317D01C11D1034B9356679E58CA0", hash_generated_method = "EB6AB2248F6A9FD44C414CF4094D8EBC")
        public final String getAttribute(String name) {
            String varB4EAC82CA7396A68D541C85D26508E83_166617135 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_146773061 = null; 
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_166617135 = null;
            } 
            varB4EAC82CA7396A68D541C85D26508E83_146773061 = attributes.get(name);
            addTaint(name.getTaint());
            String varA7E53CE21691AB073D9660D615818899_330459868; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_330459868 = varB4EAC82CA7396A68D541C85D26508E83_166617135;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_330459868 = varB4EAC82CA7396A68D541C85D26508E83_146773061;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_330459868.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_330459868;
            
            
                
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.650 -0400", hash_original_method = "7A6F8F40D5019A1C644CF7CAD3518923", hash_generated_method = "D3502A969B94CDCAF21856A0B94B2C87")
         List<String> getAliases() {
            List<String> varB4EAC82CA7396A68D541C85D26508E83_1042321411 = null; 
            {
                aliases = new ArrayList<String>(0);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1042321411 = aliases;
            varB4EAC82CA7396A68D541C85D26508E83_1042321411.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1042321411;
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.651 -0400", hash_original_method = "802A5A00EF15D2BF7FB674CB175B5DD7", hash_generated_method = "C7D3DCA7D89F95D0D1433D760B59F035")
        public Object newInstance(Object constructorParameter) throws NoSuchAlgorithmException {
            Object varB4EAC82CA7396A68D541C85D26508E83_384908664 = null; 
            Object varB4EAC82CA7396A68D541C85D26508E83_1538274565 = null; 
            {
                boolean var3339E2EE99840D316B470BF831351DB9_1982262449 = (implementation == null || !className.equals(lastClassName));
                {
                    ClassLoader cl = provider.getClass().getClassLoader();
                    {
                        cl = ClassLoader.getSystemClassLoader();
                    } 
                    try 
                    {
                        implementation = Class.forName(className, true, cl);
                        lastClassName = className;
                    } 
                    catch (Exception e)
                    {
                        if (DroidSafeAndroidRuntime.control) throw new NoSuchAlgorithmException(type + " " + algorithm + " implementation not found: " + e);
                    } 
                } 
            } 
            {
                try 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_384908664 = implementation.newInstance();
                } 
                catch (Exception e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new NoSuchAlgorithmException(
                            type + " " + algorithm + " implementation not found", e);
                } 
            } 
            {
                boolean varF38959283B90E1EE47D3A31C8BA89AD9_282538529 = (!supportsParameter(constructorParameter));
                {
                    if (DroidSafeAndroidRuntime.control) throw new InvalidParameterException(type + ": service cannot use the parameter");
                } 
            } 
            Class[] parameterTypes = new Class[1];
            Object[] initargs = { constructorParameter };
            try 
            {
                {
                    boolean var51E19F4634C2BA7E86B66347BB7D2C93_1886656419 = (type.equalsIgnoreCase("CertStore"));
                    {
                        parameterTypes[0] = Class.forName("java.security.cert.CertStoreParameters");
                    } 
                    {
                        parameterTypes[0] = constructorParameter.getClass();
                    } 
                } 
                varB4EAC82CA7396A68D541C85D26508E83_1538274565 = implementation.getConstructor(parameterTypes)
                        .newInstance(initargs);
            } 
            catch (Exception e)
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchAlgorithmException(type + " " + algorithm
                        + " implementation not found", e);
            } 
            addTaint(constructorParameter.getTaint());
            Object varA7E53CE21691AB073D9660D615818899_178249381; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_178249381 = varB4EAC82CA7396A68D541C85D26508E83_384908664;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_178249381 = varB4EAC82CA7396A68D541C85D26508E83_1538274565;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_178249381.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_178249381;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.652 -0400", hash_original_method = "A158C77880B526D8A49B8720A1D647AC", hash_generated_method = "E09A15C12B67C48B11A1309AF35CF7B4")
        public boolean supportsParameter(Object parameter) {
            addTaint(parameter.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1671162061 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1671162061;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.653 -0400", hash_original_method = "CD20F19EDED4066F9FA28FD55133940E", hash_generated_method = "D05C5421CEDCE5BF4C013A968A37C336")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_800250960 = null; 
            String result = "Provider " + provider.getName() + " Service "
                    + type + "." + algorithm + " " + className;
            {
                result = result + "\nAliases " + aliases.toString();
            } 
            {
                result = result + "\nAttributes " + attributes.toString();
            } 
            varB4EAC82CA7396A68D541C85D26508E83_800250960 = result;
            varB4EAC82CA7396A68D541C85D26508E83_800250960.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_800250960;
            
            
                    
            
                
            
            
                
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.653 -0400", hash_original_field = "7CC76EFC2B264F3D1AA5774D56F0CEA6", hash_generated_field = "6AA3DBE008BE39E45A084DC1795F57FB")

    private static final long serialVersionUID = -4298000515446427739L;
}

