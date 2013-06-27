package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.660 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.661 -0400", hash_original_field = "2AF72F100C356273D46284F6FD1DFC08", hash_generated_field = "F3CA80FC5F7B3B542DC8B1C8FD91731C")

    private double version;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.661 -0400", hash_original_field = "239623964829E21A6BEC8B51CD66FB1E", hash_generated_field = "AEF8D804C6A6E39F2A136B97DEDD88CA")

    private transient String versionString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.661 -0400", hash_original_field = "CAF9B6B99962BF5C2264824231D7A40C", hash_generated_field = "1F50CB615F8F0AB19DCF28D9BAFF4DD4")

    private String info;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.661 -0400", hash_original_field = "426DF410C50A922A7FCCB45E28CFB99B", hash_generated_field = "3D346C5395708831B6A443E01975CD82")

    private transient int providerNumber = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.661 -0400", hash_original_field = "90D27D782F6C6A467A120DC0EA3CABA4", hash_generated_field = "D2A7F737A7D1793E39403AC0C5DE42B9")

    private transient TwoKeyHashMap<String, String, Service> serviceTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.661 -0400", hash_original_field = "C8290F032C183B62C8206C67F6F9691A", hash_generated_field = "B06FB286EE00C306B86D2F80CC057271")

    private transient TwoKeyHashMap<String, String, Service> aliasTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.661 -0400", hash_original_field = "51EA4BA55D4773B26DE32A2D9219C113", hash_generated_field = "974CEA24FA2B0A232602FB5D7E8DE337")

    private transient TwoKeyHashMap<String, String, Service> propertyServiceTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.661 -0400", hash_original_field = "0C259300D051D5E7246B301C0DD26E65", hash_generated_field = "496EDC5FF7DCB745D06FD58901D71D88")

    private transient TwoKeyHashMap<String, String, Service> propertyAliasTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.661 -0400", hash_original_field = "2157E7B4176C83B64377DBFE7F76F07E", hash_generated_field = "8BBAB31DBAA82BF49B07B5E12D0CF85B")

    private transient Properties changedProperties;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.661 -0400", hash_original_field = "3124884BBCB44722A70DEA4CA0A5EEDF", hash_generated_field = "78CA56FA7454490EF4843EE66CC1589B")

    private transient Provider.Service returnedService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.661 -0400", hash_original_field = "608855017360FBF6AA459F927179D0DF", hash_generated_field = "A17CE05D31CA338777E2E3315B0B2BB2")

    private transient String lastAlgorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.661 -0400", hash_original_field = "201DB549B9B6C1D90243C19553DE6893", hash_generated_field = "26FDBDCE6D172CC943C76DDD3CE0C4F1")

    private transient String lastServiceName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.661 -0400", hash_original_field = "79C5FB5C2352B93E380EDFDC155D6452", hash_generated_field = "BA27D1D25E16A8C025C9D2F64E31C9C5")

    private transient Set<Service> lastServicesSet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.661 -0400", hash_original_field = "AF709187F08859A6E70DA4496782164A", hash_generated_field = "3F98FC0FC213ABB6A1D68A8492E264D1")

    private transient String lastType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.662 -0400", hash_original_field = "C51F06888C4D2B6BFD3C97C9199539C4", hash_generated_field = "734DC09FAD571851B677CBD6C2E18D22")

    private transient Provider.Service lastServicesByType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.680 -0400", hash_original_method = "CD3EC30E89504BC69886C014A5CD7A7E", hash_generated_method = "C4D627FD8EDE0CA93E2598F924F902BC")
    protected  Provider(String name, double version, String info) {
        this.name = name;
        this.version = version;
        this.info = info;
        versionString = String.valueOf(version);
        putProviderInfo();
        // ---------- Original Method ----------
        //this.name = name;
        //this.version = version;
        //this.info = info;
        //versionString = String.valueOf(version);
        //putProviderInfo();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.680 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "53B03B7E527550D0915D4AF86B575C10")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1342378909 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1342378909 = name;
        varB4EAC82CA7396A68D541C85D26508E83_1342378909.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1342378909;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.680 -0400", hash_original_method = "849DADC9512AC29CFF5A5EB4D1517425", hash_generated_method = "FDA80E186DBB8F95DA22E9A8D943C908")
    public double getVersion() {
        double varE8CD7DA078A86726031AD64F35F5A6C0_1955797727 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1955797727;
        // ---------- Original Method ----------
        //return version;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.681 -0400", hash_original_method = "90F1C2C1B854E8544A3CF05D4B3BD6E7", hash_generated_method = "22E30029E00242C0C633E7EFD5C2E781")
    public String getInfo() {
        String varB4EAC82CA7396A68D541C85D26508E83_112978835 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_112978835 = info;
        varB4EAC82CA7396A68D541C85D26508E83_112978835.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_112978835;
        // ---------- Original Method ----------
        //return info;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.684 -0400", hash_original_method = "58EC0A1A07497E3FA377B5366380E5E3", hash_generated_method = "3396BB3C7ADA1B6CDBB3DAEF512106EE")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1347186693 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1347186693 = name + " version " + version;
        varB4EAC82CA7396A68D541C85D26508E83_1347186693.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1347186693;
        // ---------- Original Method ----------
        //return name + " version " + version;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.686 -0400", hash_original_method = "53793BFB01C9C5B2BDDE9F63C2E38535", hash_generated_method = "A19DC41C7A8FE29FEA9015506AFF42CE")
    @Override
    public synchronized void clear() {
        super.clear();
        {
            serviceTable.clear();
        } //End block
        {
            propertyServiceTable.clear();
        } //End block
        {
            aliasTable.clear();
        } //End block
        {
            propertyAliasTable.clear();
        } //End block
        changedProperties = null;
        putProviderInfo();
        {
            Services.setNeedRefresh();
        } //End block
        servicesChanged();
        // ---------- Original Method ----------
        //super.clear();
        //if (serviceTable != null) {
            //serviceTable.clear();
        //}
        //if (propertyServiceTable != null) {
            //propertyServiceTable.clear();
        //}
        //if (aliasTable != null) {
            //aliasTable.clear();
        //}
        //if (propertyAliasTable != null) {
            //propertyAliasTable.clear();
        //}
        //changedProperties = null;
        //putProviderInfo();
        //if (providerNumber != -1) {
            //Services.setNeedRefresh();
        //}
        //servicesChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.706 -0400", hash_original_method = "EB6BD048CAF9E12CFD99EC1891725291", hash_generated_method = "5F36F54A477EC7438189B9017F68463C")
    @Override
    public synchronized void load(InputStream inStream) throws IOException {
        Properties tmp;
        tmp = new Properties();
        tmp.load(inStream);
        myPutAll(tmp);
        addTaint(inStream.getTaint());
        // ---------- Original Method ----------
        //Properties tmp = new Properties();
        //tmp.load(inStream);
        //myPutAll(tmp);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.707 -0400", hash_original_method = "CE4C2613BF29D966F3F961299EB30975", hash_generated_method = "A9B51435AF0F7EBFCFADA8C2F3FCC4CD")
    @Override
    public synchronized void putAll(Map<?,?> t) {
        myPutAll(t);
        addTaint(t.getTaint());
        // ---------- Original Method ----------
        //myPutAll(t);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.711 -0400", hash_original_method = "F898BA9F30F0CED7EAABA59AE5C4F6F9", hash_generated_method = "62534AA578DE7422DDD67094CA43F1E3")
    private void myPutAll(Map<?,?> t) {
        {
            changedProperties = new Properties();
        } //End block
        Iterator<? extends Map.Entry<?, ?>> it;
        it = t.entrySet().iterator();
        Object key;
        Object value;
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_376337618 = (it.hasNext());
            {
                Map.Entry<?, ?> entry;
                entry = it.next();
                key = entry.getKey();
                {
                    boolean var39D76CDDB13616FD0D42E75AC7C012F1_1018402660 = (key instanceof String && ((String) key).startsWith("Provider."));
                } //End collapsed parenthetic
                value = entry.getValue();
                super.put(key, value);
                {
                    boolean var557FC3098495809338F3BC3135E1280B_798394294 = (changedProperties.remove(key) == null);
                    {
                        removeFromPropertyServiceTable(key);
                    } //End block
                } //End collapsed parenthetic
                changedProperties.put(key, value);
            } //End block
        } //End collapsed parenthetic
        {
            Services.setNeedRefresh();
        } //End block
        addTaint(t.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.726 -0400", hash_original_method = "70D9A28808783B7E2708BCE915ECB209", hash_generated_method = "0F1837A48DF999579CA7ADC6744D92AF")
    @Override
    public synchronized Set<Map.Entry<Object,Object>> entrySet() {
        Set<Map.Entry<Object,Object>> varB4EAC82CA7396A68D541C85D26508E83_58081196 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_58081196 = Collections.unmodifiableSet(super.entrySet());
        varB4EAC82CA7396A68D541C85D26508E83_58081196.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_58081196;
        // ---------- Original Method ----------
        //return Collections.unmodifiableSet(super.entrySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.727 -0400", hash_original_method = "45BA03BABBCEC97C3CDEDDFAAD34C546", hash_generated_method = "C35DE6F6FFB11C283799665E00D35500")
    @Override
    public Set<Object> keySet() {
        Set<Object> varB4EAC82CA7396A68D541C85D26508E83_729459425 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_729459425 = Collections.unmodifiableSet(super.keySet());
        varB4EAC82CA7396A68D541C85D26508E83_729459425.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_729459425;
        // ---------- Original Method ----------
        //return Collections.unmodifiableSet(super.keySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.728 -0400", hash_original_method = "4FF8F6E11AAD8FB860F173913A5840CE", hash_generated_method = "9E55FDEE0F3C519C79316537580D1BA1")
    @Override
    public Collection<Object> values() {
        Collection<Object> varB4EAC82CA7396A68D541C85D26508E83_1746599058 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1746599058 = Collections.unmodifiableCollection(super.values());
        varB4EAC82CA7396A68D541C85D26508E83_1746599058.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1746599058;
        // ---------- Original Method ----------
        //return Collections.unmodifiableCollection(super.values());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.728 -0400", hash_original_method = "6B0BAE35C6955DE6DEF5897424A78326", hash_generated_method = "7675606BBE9B2215A71DF206C195688C")
    @Override
    public synchronized Object put(Object key, Object value) {
        Object varB4EAC82CA7396A68D541C85D26508E83_578220143 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_546446863 = null; //Variable for return #2
        {
            boolean var615FFDC8C58E5DA9131CFD1E840EB61D_1431230072 = (key instanceof String && ((String) key).startsWith("Provider."));
            {
                varB4EAC82CA7396A68D541C85D26508E83_578220143 = null;
            } //End block
        } //End collapsed parenthetic
        {
            Services.setNeedRefresh();
        } //End block
        {
            boolean varF5120E22219DB168E3E6D91BEC202FF4_1234151773 = (changedProperties != null && changedProperties.remove(key) == null);
            {
                removeFromPropertyServiceTable(key);
            } //End block
        } //End collapsed parenthetic
        {
            changedProperties = new Properties();
        } //End block
        changedProperties.put(key, value);
        varB4EAC82CA7396A68D541C85D26508E83_546446863 = super.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_1948094176; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1948094176 = varB4EAC82CA7396A68D541C85D26508E83_578220143;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1948094176 = varB4EAC82CA7396A68D541C85D26508E83_546446863;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1948094176.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1948094176;
        // ---------- Original Method ----------
        //if (key instanceof String && ((String) key).startsWith("Provider.")) {
            //return null;
        //}
        //if (providerNumber != -1) {
            //Services.setNeedRefresh();
        //}
        //if (changedProperties != null && changedProperties.remove(key) == null) {
            //removeFromPropertyServiceTable(key);
        //}
        //if (changedProperties == null) {
            //changedProperties = new Properties();
        //}
        //changedProperties.put(key, value);
        //return super.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.745 -0400", hash_original_method = "8EA23C4ABA882E49A95AE531F4BFEB20", hash_generated_method = "88AD63E7A7F3AF3778E9163B6EE45762")
    @Override
    public synchronized Object remove(Object key) {
        Object varB4EAC82CA7396A68D541C85D26508E83_8018450 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_1969526181 = null; //Variable for return #2
        {
            boolean var615FFDC8C58E5DA9131CFD1E840EB61D_189437574 = (key instanceof String && ((String) key).startsWith("Provider."));
            {
                varB4EAC82CA7396A68D541C85D26508E83_8018450 = null;
            } //End block
        } //End collapsed parenthetic
        {
            Services.setNeedRefresh();
        } //End block
        {
            boolean varF5120E22219DB168E3E6D91BEC202FF4_1787434447 = (changedProperties != null && changedProperties.remove(key) == null);
            {
                removeFromPropertyServiceTable(key);
                {
                    boolean var88F5A1A88583F68F084FEAD07CBA365C_199275756 = (changedProperties.size() == 0);
                    {
                        changedProperties = null;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1969526181 = super.remove(key);
        addTaint(key.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_1540719382; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1540719382 = varB4EAC82CA7396A68D541C85D26508E83_8018450;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1540719382 = varB4EAC82CA7396A68D541C85D26508E83_1969526181;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1540719382.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1540719382;
        // ---------- Original Method ----------
        //if (key instanceof String && ((String) key).startsWith("Provider.")) {
            //return null;
        //}
        //if (providerNumber != -1) {
            //Services.setNeedRefresh();
        //}
        //if (changedProperties != null && changedProperties.remove(key) == null) {
            //removeFromPropertyServiceTable(key);
            //if (changedProperties.size() == 0) {
                //changedProperties = null;
            //}
        //}
        //return super.remove(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.746 -0400", hash_original_method = "73ADEB588A693290C2EBE420EE1B60DD", hash_generated_method = "1E1A93958B4B1EDC1497E30C573F129F")
     boolean implementsAlg(String serv, String alg, String attribute, String val) {
        String servAlg;
        servAlg = serv + "." + alg;
        String prop;
        prop = getPropertyIgnoreCase(servAlg);
        {
            alg = getPropertyIgnoreCase("Alg.Alias." + servAlg);
            {
                servAlg = serv + "." + alg;
                prop = getPropertyIgnoreCase(servAlg);
            } //End block
        } //End block
        {
            boolean var83392DFFAC381D73DD8A3765EFB03BDF_927867507 = (checkAttribute(servAlg, attribute, val));
        } //End block
        addTaint(serv.getTaint());
        addTaint(alg.getTaint());
        addTaint(attribute.getTaint());
        addTaint(val.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_914259290 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_914259290;
        // ---------- Original Method ----------
        //String servAlg = serv + "." + alg;
        //String prop = getPropertyIgnoreCase(servAlg);
        //if (prop == null) {
            //alg = getPropertyIgnoreCase("Alg.Alias." + servAlg);
            //if (alg != null) {
                //servAlg = serv + "." + alg;
                //prop = getPropertyIgnoreCase(servAlg);
            //}
        //}
        //if (prop != null) {
            //if (attribute == null) {
                //return true;
            //}
            //return checkAttribute(servAlg, attribute, val);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.746 -0400", hash_original_method = "205FEBDC4595F3CAF3DB8C26A01A3B21", hash_generated_method = "C327DBA494855B425F8A4009CE1BF96B")
    private boolean checkAttribute(String servAlg, String attribute, String val) {
        String attributeValue;
        attributeValue = getPropertyIgnoreCase(servAlg + ' ' + attribute);
        {
            {
                boolean var9AAE8A593FFFFD550F3379BD45AFB455_1665279380 = (attribute.equalsIgnoreCase("KeySize"));
                {
                    {
                        boolean var2CCBDA5D9949774AEDDE95DD101E1B5B_583590190 = (Integer.parseInt(attributeValue) >= Integer.parseInt(val));
                    } //End collapsed parenthetic
                } //End block
                {
                    {
                        boolean varBE561380D0BC947AE323F09089366FE2_1045958387 = (attributeValue.equalsIgnoreCase(val));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(servAlg.getTaint());
        addTaint(attribute.getTaint());
        addTaint(val.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_822790487 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_822790487;
        // ---------- Original Method ----------
        //String attributeValue = getPropertyIgnoreCase(servAlg + ' ' + attribute);
        //if (attributeValue != null) {
            //if (attribute.equalsIgnoreCase("KeySize")) {
                //if (Integer.parseInt(attributeValue) >= Integer.parseInt(val)) {
                    //return true;
                //}
            //} else { 
                //if (attributeValue.equalsIgnoreCase(val)) {
                    //return true;
                //}
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.747 -0400", hash_original_method = "6418C82159D4FAB251CB16B6C408D61D", hash_generated_method = "BA9FDE46C0F8402C6FB4936CC36C7FAA")
     void setProviderNumber(int n) {
        providerNumber = n;
        // ---------- Original Method ----------
        //providerNumber = n;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.747 -0400", hash_original_method = "6209D7B36FBC76163C52BAAF1CE53C35", hash_generated_method = "F1942263B2B2B57F9219A5EF5733FA42")
     int getProviderNumber() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1398523773 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1398523773;
        // ---------- Original Method ----------
        //return providerNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.748 -0400", hash_original_method = "6BFCD4E62487080CD7F60A29BC4CC43B", hash_generated_method = "3B48A48DF03759E070DA8FE66DEE21E5")
    synchronized Provider.Service getService(String type) {
        Provider.Service varB4EAC82CA7396A68D541C85D26508E83_1748488813 = null; //Variable for return #1
        Provider.Service varB4EAC82CA7396A68D541C85D26508E83_1349473231 = null; //Variable for return #2
        Provider.Service varB4EAC82CA7396A68D541C85D26508E83_168745913 = null; //Variable for return #3
        updatePropertyServiceTable();
        {
            boolean varE8D1884AAD74E2F5DA1CD399B1822ECD_683695837 = (lastServicesByType != null && type.equals(lastType));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1748488813 = lastServicesByType;
            } //End block
        } //End collapsed parenthetic
        Provider.Service service;
        {
            Iterator<Service> it;
            it = getServices().iterator();
            boolean var03729FD53960D8DCA3A41A13A0229637_1642008119 = (it.hasNext());
            {
                service = it.next();
                {
                    boolean var4C71E495B2DBF2BB72C8225160CEBE9A_971663412 = (type.equals(service.type));
                    {
                        lastType = type;
                        lastServicesByType = service;
                        varB4EAC82CA7396A68D541C85D26508E83_1349473231 = service;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_168745913 = null;
        Provider.Service varA7E53CE21691AB073D9660D615818899_1660565617; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1660565617 = varB4EAC82CA7396A68D541C85D26508E83_1748488813;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1660565617 = varB4EAC82CA7396A68D541C85D26508E83_1349473231;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1660565617 = varB4EAC82CA7396A68D541C85D26508E83_168745913;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1660565617.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1660565617;
        // ---------- Original Method ----------
        //updatePropertyServiceTable();
        //if (lastServicesByType != null && type.equals(lastType)) {
            //return lastServicesByType;
        //}
        //Provider.Service service;
        //for (Iterator<Service> it = getServices().iterator(); it.hasNext();) {
            //service = it.next();
            //if (type.equals(service.type)) {
                //lastType = type;
                //lastServicesByType = service;
                //return service;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.768 -0400", hash_original_method = "6DABE02DE2A4DD1C36F9592BEF5E1C73", hash_generated_method = "5BFD364D13D869BB16A72C32CCBA019B")
    public synchronized Provider.Service getService(String type,
            String algorithm) {
        Provider.Service varB4EAC82CA7396A68D541C85D26508E83_1006163840 = null; //Variable for return #1
        Provider.Service varB4EAC82CA7396A68D541C85D26508E83_1133286053 = null; //Variable for return #2
        Provider.Service varB4EAC82CA7396A68D541C85D26508E83_832307948 = null; //Variable for return #3
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            boolean var5D9786D09CE430680B17444C7FCE5061_1344507408 = (type.equals(lastServiceName) && algorithm.equalsIgnoreCase(lastAlgorithm));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1006163840 = returnedService;
            } //End block
        } //End collapsed parenthetic
        String alg;
        alg = algorithm.toUpperCase(Locale.US);
        Object o;
        o = null;
        {
            o = serviceTable.get(type, alg);
        } //End block
        {
            o = aliasTable.get(type, alg);
        } //End block
        {
            updatePropertyServiceTable();
        } //End block
        {
            o = propertyServiceTable.get(type, alg);
        } //End block
        {
            o = propertyAliasTable.get(type, alg);
        } //End block
        {
            lastServiceName = type;
            lastAlgorithm = algorithm;
            returnedService = (Provider.Service) o;
            varB4EAC82CA7396A68D541C85D26508E83_1133286053 = returnedService;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_832307948 = null;
        Provider.Service varA7E53CE21691AB073D9660D615818899_1068162805; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1068162805 = varB4EAC82CA7396A68D541C85D26508E83_1006163840;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1068162805 = varB4EAC82CA7396A68D541C85D26508E83_1133286053;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1068162805 = varB4EAC82CA7396A68D541C85D26508E83_832307948;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1068162805.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1068162805;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.769 -0400", hash_original_method = "8008CDA805FE131E4E7ECE670E22E200", hash_generated_method = "5BB02B7E0EF587DDBC275CFBBA5E6262")
    public synchronized Set<Provider.Service> getServices() {
        Set<Provider.Service> varB4EAC82CA7396A68D541C85D26508E83_128287887 = null; //Variable for return #1
        Set<Provider.Service> varB4EAC82CA7396A68D541C85D26508E83_868406016 = null; //Variable for return #2
        updatePropertyServiceTable();
        {
            varB4EAC82CA7396A68D541C85D26508E83_128287887 = lastServicesSet;
        } //End block
        {
            lastServicesSet = new HashSet<Service>(serviceTable.values());
        } //End block
        {
            lastServicesSet = new HashSet<Service>();
        } //End block
        {
            lastServicesSet.addAll(propertyServiceTable.values());
        } //End block
        lastServicesSet = Collections.unmodifiableSet(lastServicesSet);
        varB4EAC82CA7396A68D541C85D26508E83_868406016 = lastServicesSet;
        Set<Provider.Service> varA7E53CE21691AB073D9660D615818899_2138693526; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2138693526 = varB4EAC82CA7396A68D541C85D26508E83_128287887;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2138693526 = varB4EAC82CA7396A68D541C85D26508E83_868406016;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2138693526.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2138693526;
        // ---------- Original Method ----------
        //updatePropertyServiceTable();
        //if (lastServicesSet != null) {
            //return lastServicesSet;
        //}
        //if (serviceTable != null) {
            //lastServicesSet = new HashSet<Service>(serviceTable.values());
        //} else {
            //lastServicesSet = new HashSet<Service>();
        //}
        //if (propertyServiceTable != null) {
            //lastServicesSet.addAll(propertyServiceTable.values());
        //}
        //lastServicesSet = Collections.unmodifiableSet(lastServicesSet);
        //return lastServicesSet;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.793 -0400", hash_original_method = "3E5E06298B83C020AD9BCF69B9E3CE94", hash_generated_method = "841887BCA8826F72418FCB6B9B3C2512")
    protected synchronized void putService(Provider.Service s) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            boolean varF52B1BD6E65C5078A2BDD1FFCE56BDE7_1819753176 = ("Provider".equals(s.getType()));
        } //End collapsed parenthetic
        servicesChanged();
        {
            serviceTable = new TwoKeyHashMap<String, String, Service>(128);
        } //End block
        serviceTable.put(s.type, s.algorithm.toUpperCase(Locale.US), s);
        {
            {
                aliasTable = new TwoKeyHashMap<String, String, Service>(256);
            } //End block
            {
                Iterator<String> var53A703E015EC0F90D15F82B6703EC2ED_494640173 = (s.getAliases()).iterator();
                var53A703E015EC0F90D15F82B6703EC2ED_494640173.hasNext();
                String alias = var53A703E015EC0F90D15F82B6703EC2ED_494640173.next();
                {
                    aliasTable.put(s.type, alias.toUpperCase(Locale.US), s);
                } //End block
            } //End collapsed parenthetic
        } //End block
        serviceInfoToProperties(s);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //if (s == null) {
            //throw new NullPointerException();
        //}
        //if ("Provider".equals(s.getType())) { 
            //return;
        //}
        //servicesChanged();
        //if (serviceTable == null) {
            //serviceTable = new TwoKeyHashMap<String, String, Service>(128);
        //}
        //serviceTable.put(s.type, s.algorithm.toUpperCase(Locale.US), s);
        //if (s.aliases != null) {
            //if (aliasTable == null) {
                //aliasTable = new TwoKeyHashMap<String, String, Service>(256);
            //}
            //for (String alias : s.getAliases()) {
                //aliasTable.put(s.type, alias.toUpperCase(Locale.US), s);
            //}
        //}
        //serviceInfoToProperties(s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.817 -0400", hash_original_method = "D2521231A8F61254D866781010E5F7B6", hash_generated_method = "B83A6530564E0CC1722D71C4D430A10A")
    protected synchronized void removeService(Provider.Service s) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        servicesChanged();
        {
            serviceTable.remove(s.type, s.algorithm.toUpperCase(Locale.US));
        } //End block
        {
            {
                Iterator<String> var0B0914451AB60F2FBE3FA1B1B21C1A4E_1644297261 = (s.getAliases()).iterator();
                var0B0914451AB60F2FBE3FA1B1B21C1A4E_1644297261.hasNext();
                String alias = var0B0914451AB60F2FBE3FA1B1B21C1A4E_1644297261.next();
                {
                    aliasTable.remove(s.type, alias.toUpperCase(Locale.US));
                } //End block
            } //End collapsed parenthetic
        } //End block
        serviceInfoFromProperties(s);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //if (s == null) {
            //throw new NullPointerException();
        //}
        //servicesChanged();
        //if (serviceTable != null) {
            //serviceTable.remove(s.type, s.algorithm.toUpperCase(Locale.US));
        //}
        //if (aliasTable != null && s.aliases != null) {
            //for (String alias: s.getAliases()) {
                //aliasTable.remove(s.type, alias.toUpperCase(Locale.US));
            //}
        //}
        //serviceInfoFromProperties(s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.834 -0400", hash_original_method = "FD9674DD64603638CEEAFAAECA2377E1", hash_generated_method = "C03F615BB72C581FCA42A1A650359256")
    private void serviceInfoToProperties(Provider.Service s) {
        super.put(s.type + "." + s.algorithm, s.className);
        {
            {
                Iterator<String> i;
                i = s.aliases.iterator();
                boolean varD8B5E52A597500CBD863E52A46B42708_2135362217 = (i.hasNext());
                {
                    super.put("Alg.Alias." + s.type + "." + i.next(), s.algorithm);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                Iterator<Map.Entry<String, String>> varEC591D00247358B530BCEAA3DE5F4B70_119571678 = (s.attributes.entrySet()).iterator();
                varEC591D00247358B530BCEAA3DE5F4B70_119571678.hasNext();
                Map.Entry<String, String> entry = varEC591D00247358B530BCEAA3DE5F4B70_119571678.next();
                {
                    super.put(s.type + "." + s.algorithm + " " + entry.getKey(),
                        entry.getValue());
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            Services.setNeedRefresh();
        } //End block
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //super.put(s.type + "." + s.algorithm, s.className);
        //if (s.aliases != null) {
            //for (Iterator<String> i = s.aliases.iterator(); i.hasNext();) {
                //super.put("Alg.Alias." + s.type + "." + i.next(), s.algorithm);
            //}
        //}
        //if (s.attributes != null) {
            //for (Map.Entry<String, String> entry : s.attributes.entrySet()) {
                //super.put(s.type + "." + s.algorithm + " " + entry.getKey(),
                        //entry.getValue());
            //}
        //}
        //if (providerNumber != -1) {
            //Services.setNeedRefresh();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.858 -0400", hash_original_method = "E3342D080F10DDAA1FF9ED29EA29694F", hash_generated_method = "D2CC991D12210C92FC850726BE1B83A6")
    private void serviceInfoFromProperties(Provider.Service s) {
        super.remove(s.type + "." + s.algorithm);
        {
            {
                Iterator<String> i;
                i = s.aliases.iterator();
                boolean varD8B5E52A597500CBD863E52A46B42708_1131561408 = (i.hasNext());
                {
                    super.remove("Alg.Alias." + s.type + "." + i.next());
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                Iterator<Map.Entry<String, String>> varEC591D00247358B530BCEAA3DE5F4B70_1915656970 = (s.attributes.entrySet()).iterator();
                varEC591D00247358B530BCEAA3DE5F4B70_1915656970.hasNext();
                Map.Entry<String, String> entry = varEC591D00247358B530BCEAA3DE5F4B70_1915656970.next();
                {
                    super.remove(s.type + "." + s.algorithm + " " + entry.getKey());
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            Services.setNeedRefresh();
        } //End block
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //super.remove(s.type + "." + s.algorithm);
        //if (s.aliases != null) {
            //for (Iterator<String> i = s.aliases.iterator(); i.hasNext();) {
                //super.remove("Alg.Alias." + s.type + "." + i.next());
            //}
        //}
        //if (s.attributes != null) {
            //for (Map.Entry<String, String> entry : s.attributes.entrySet()) {
                //super.remove(s.type + "." + s.algorithm + " " + entry.getKey());
            //}
        //}
        //if (providerNumber != -1) {
            //Services.setNeedRefresh();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.986 -0400", hash_original_method = "C88E49400116B5906A9CAC0E8D20528B", hash_generated_method = "A49FFA8546DF43F21C840EE57AA9AC48")
    private void removeFromPropertyServiceTable(Object key) {
        String k;
        k = (String) key;
        {
            boolean var51D0AB19C0E4EAD46591A8C66CC40542_1943003812 = (k.startsWith("Provider."));
        } //End collapsed parenthetic
        Provider.Service s;
        String serviceName;
        String algorithm;
        algorithm = null;
        String attribute;
        attribute = null;
        int i;
        {
            boolean varB2EA1E0E9D7C7EEC2C9BF24E8B1510EA_1554659046 = (k.startsWith("Alg.Alias."));
            {
                String aliasName;
                String service_alias;
                service_alias = k.substring(10);
                i = service_alias.indexOf('.');
                serviceName = service_alias.substring(0, i);
                aliasName = service_alias.substring(i + 1);
                {
                    propertyAliasTable.remove(serviceName, aliasName.toUpperCase(Locale.US));
                } //End block
                {
                    {
                        Iterator<Service> it;
                        it = propertyServiceTable.values().iterator();
                        boolean var4A1B8BE89C779B21458638B02948AC2A_804782502 = (it
                        .hasNext());
                        {
                            s = it.next();
                            {
                                boolean var6F8C4AE25185D3231A2E4FD7E4E357C3_1923610396 = (s.aliases.contains(aliasName));
                                {
                                    s.aliases.remove(aliasName);
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        int j;
        j = k.indexOf('.');
        i = k.indexOf(' ');
        {
            serviceName = k.substring(0, j);
            algorithm = k.substring(j + 1);
            {
                Provider.Service ser;
                ser = propertyServiceTable.remove(serviceName,
                        algorithm.toUpperCase(Locale.US));
                {
                    {
                        Iterator<String> var3BE46C9A129D4D7F74F143C9623D7876_1291222672 = (ser.aliases).iterator();
                        var3BE46C9A129D4D7F74F143C9623D7876_1291222672.hasNext();
                        String alias = var3BE46C9A129D4D7F74F143C9623D7876_1291222672.next();
                        {
                            propertyAliasTable.remove(serviceName, alias.toUpperCase(Locale.US));
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End block
        {
            attribute = k.substring(i + 1);
            serviceName = k.substring(0, j);
            algorithm = k.substring(j + 1, i);
            {
                Object o;
                o = propertyServiceTable.get(serviceName, algorithm.toUpperCase(Locale.US));
                {
                    s = (Provider.Service) o;
                    s.attributes.remove(attribute);
                } //End block
            } //End block
        } //End block
        addTaint(key.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.012 -0400", hash_original_method = "C12B51396475B7F4EF23B74D619C33FD", hash_generated_method = "D5B932B20F69C636CD442312E6D46C73")
    private void updatePropertyServiceTable() {
        Object _key;
        Object _value;
        Provider.Service s;
        String serviceName;
        String algorithm;
        {
            boolean var9C86F49586631F13D865CF4B9FA9A44B_1859356116 = (changedProperties == null || changedProperties.isEmpty());
        } //End collapsed parenthetic
        {
            Iterator<Map.Entry<Object, Object>> it;
            it = changedProperties.entrySet().iterator();
            boolean var9D0EDA54CCAB017AFE33C830CCA36C58_902457384 = (it
                .hasNext());
            {
                Map.Entry<Object, Object> entry;
                entry = it.next();
                _key = entry.getKey();
                _value = entry.getValue();
                String key;
                key = (String) _key;
                String value;
                value = (String) _value;
                {
                    boolean var2F2AA442FA156A8F8BA53B7B622AD8C8_1815114550 = (key.startsWith("Provider"));
                } //End collapsed parenthetic
                int i;
                {
                    boolean var95164A0B30E45315F7A1F2560FE7C960_775026158 = (key.startsWith("Alg.Alias."));
                    {
                        String aliasName;
                        String service_alias;
                        service_alias = key.substring(10);
                        i = service_alias.indexOf('.');
                        serviceName = service_alias.substring(0, i);
                        aliasName = service_alias.substring(i + 1);
                        algorithm = value;
                        String algUp;
                        algUp = algorithm.toUpperCase(Locale.US);
                        Object o;
                        o = null;
                        {
                            propertyServiceTable = new TwoKeyHashMap<String, String, Service>(128);
                        } //End block
                        {
                            o = propertyServiceTable.get(serviceName, algUp);
                        } //End block
                        {
                            s = (Provider.Service) o;
                            s.addAlias(aliasName);
                            {
                                propertyAliasTable = new TwoKeyHashMap<String, String, Service>(256);
                            } //End block
                            propertyAliasTable.put(serviceName, aliasName.toUpperCase(Locale.US), s);
                        } //End block
                        {
                            String className;
                            className = (String) changedProperties
                            .get(serviceName + "." + algorithm);
                            {
                                List<String> l;
                                l = new ArrayList<String>();
                                l.add(aliasName);
                                s = new Provider.Service(this, serviceName, algorithm,
                                className, l, new HashMap<String, String>());
                                propertyServiceTable.put(serviceName, algUp, s);
                                {
                                    propertyAliasTable = new TwoKeyHashMap<String, String, Service>(256);
                                } //End block
                                propertyAliasTable.put(serviceName, aliasName.toUpperCase(Locale.US), s);
                            } //End block
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                int j;
                j = key.indexOf('.');
                i = key.indexOf(' ');
                {
                    serviceName = key.substring(0, j);
                    algorithm = key.substring(j + 1);
                    String alg;
                    alg = algorithm.toUpperCase(Locale.US);
                    Object o;
                    o = null;
                    {
                        o = propertyServiceTable.get(serviceName, alg);
                    } //End block
                    {
                        s = (Provider.Service) o;
                        s.className = value;
                    } //End block
                    {
                        s = new Provider.Service(this, serviceName, algorithm,
                            value, Collections.<String>emptyList(),
                            Collections.<String,String>emptyMap());
                        {
                            propertyServiceTable = new TwoKeyHashMap<String, String, Service>(128);
                        } //End block
                        propertyServiceTable.put(serviceName, alg, s);
                    } //End block
                } //End block
                {
                    serviceName = key.substring(0, j);
                    algorithm = key.substring(j + 1, i);
                    String attribute;
                    attribute = key.substring(i + 1);
                    String alg;
                    alg = algorithm.toUpperCase(Locale.US);
                    Object o;
                    o = null;
                    {
                        o = propertyServiceTable.get(serviceName, alg);
                    } //End block
                    {
                        s = (Provider.Service) o;
                        s.putAttribute(attribute, value);
                    } //End block
                    {
                        String className;
                        className = (String) changedProperties
                            .get(serviceName + "." + algorithm);
                        {
                            Map<String, String> m;
                            m = new HashMap<String, String>();
                            m.put(attribute, value);
                            s = new Provider.Service(this, serviceName, algorithm,
                                className, new ArrayList<String>(), m);
                            {
                                propertyServiceTable = new TwoKeyHashMap<String, String, Service>(128);
                            } //End block
                            propertyServiceTable.put(serviceName, alg, s);
                        } //End block
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        servicesChanged();
        changedProperties = null;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.012 -0400", hash_original_method = "FD7619437CD0960F1AEBA32A154F0328", hash_generated_method = "9C6A342A2081A7D73BA214C115FEC8EA")
    private void servicesChanged() {
        lastServicesByType = null;
        lastServiceName = null;
        lastServicesSet = null;
        // ---------- Original Method ----------
        //lastServicesByType = null;
        //lastServiceName = null;
        //lastServicesSet = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.013 -0400", hash_original_method = "768CFC89B63FD1F782E3758D2BCFC6C0", hash_generated_method = "BEA2C42DB158CE6C3270D65A149F3B2E")
    private void putProviderInfo() {
        super.put("Provider.id name", (name != null) ? name : "null");
        super.put("Provider.id version", versionString);
        super.put("Provider.id info", (info != null) ? info : "null");
        super.put("Provider.id className", this.getClass().getName());
        // ---------- Original Method ----------
        //super.put("Provider.id name", (name != null) ? name : "null");
        //super.put("Provider.id version", versionString);
        //super.put("Provider.id info", (info != null) ? info : "null");
        //super.put("Provider.id className", this.getClass().getName());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.013 -0400", hash_original_method = "62DD35352FE8FA7B38C17798ED376C47", hash_generated_method = "525E27000ECB7E824026361F7E415A32")
    private String getPropertyIgnoreCase(String key) {
        String varB4EAC82CA7396A68D541C85D26508E83_1729097745 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1999055354 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_545225908 = null; //Variable for return #3
        String res;
        res = getProperty(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1729097745 = res;
        } //End block
        {
            Enumeration<?> e;
            e = propertyNames();
            boolean var3EB0A96682EDBE15308427BAC1EC4A4E_758735753 = (e.hasMoreElements());
            {
                String propertyName;
                propertyName = (String) e.nextElement();
                {
                    boolean var7026A60BEF5468325737B39ADF42B3F9_1533302218 = (key.equalsIgnoreCase(propertyName));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1999055354 = getProperty(propertyName);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_545225908 = null;
        addTaint(key.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1086723293; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1086723293 = varB4EAC82CA7396A68D541C85D26508E83_1729097745;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1086723293 = varB4EAC82CA7396A68D541C85D26508E83_1999055354;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1086723293 = varB4EAC82CA7396A68D541C85D26508E83_545225908;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1086723293.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1086723293;
        // ---------- Original Method ----------
        //String res = getProperty(key);
        //if (res != null) {
            //return res;
        //}
        //for (Enumeration<?> e = propertyNames(); e.hasMoreElements(); ) {
            //String propertyName = (String) e.nextElement();
            //if (key.equalsIgnoreCase(propertyName)) {
                //return getProperty(propertyName);
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.014 -0400", hash_original_method = "C9BE26B06AA230EA20C77B7F366C53C8", hash_generated_method = "33B05CAC88D7518817CBC9CBBAA8281A")
    private void readObject(java.io.ObjectInputStream in) throws NotActiveException, IOException, ClassNotFoundException {
        in.defaultReadObject();
        versionString = String.valueOf(version);
        providerNumber = -1;
        addTaint(in.getTaint());
        // ---------- Original Method ----------
        //in.defaultReadObject();
        //versionString = String.valueOf(version);
        //providerNumber = -1;
    }

    
    public static class Service {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.014 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

        private Provider provider;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.014 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

        private String type;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.014 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

        private String algorithm;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.014 -0400", hash_original_field = "6F66E878C62DB60568A3487869695820", hash_generated_field = "B28341EF6B88AA3CAD2D37FF14C9DC00")

        private String className;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.014 -0400", hash_original_field = "9299DA2529C98FCCCE0E32B476BA3266", hash_generated_field = "7D96162B1AE01DA7357D6662D8D2C584")

        private List<String> aliases;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.014 -0400", hash_original_field = "736B91750E516139ACC13C5EB6564F92", hash_generated_field = "1CEAC23D4A656E23182C27FC3A78AEDE")

        private Map<String,String> attributes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.014 -0400", hash_original_field = "B6FA15360B4CDCE4806BF9A0580C8F0F", hash_generated_field = "28101B8550628F94A8DDB23FAF399E56")

        private Class<?> implementation;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.014 -0400", hash_original_field = "77FDFBF3D811B72BC9BBBE747A722F58", hash_generated_field = "668E14A773F053D0B44156BD480B724E")

        private String lastClassName;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.028 -0400", hash_original_method = "82CB06DCD943152835D64FFE915BA566", hash_generated_method = "729BA8513727B47508A50A1E8982676B")
        public  Service(Provider provider, String type, String algorithm,
                String className, List<String> aliases, Map<String, String> attributes) {
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            this.provider = provider;
            this.type = type;
            this.algorithm = algorithm;
            this.className = className;
            this.aliases = ((aliases != null) && (aliases.size() == 0))
                    ? Collections.<String>emptyList() : aliases;
            this.attributes =
                    ((attributes != null) && (attributes.size() == 0))
                    ? Collections.<String,String>emptyMap() : attributes;
            // ---------- Original Method ----------
            //if (provider == null || type == null || algorithm == null
                    //|| className == null) {
                //throw new NullPointerException();
            //}
            //this.provider = provider;
            //this.type = type;
            //this.algorithm = algorithm;
            //this.className = className;
            //this.aliases = ((aliases != null) && (aliases.size() == 0))
                    //? Collections.<String>emptyList() : aliases;
            //this.attributes =
                    //((attributes != null) && (attributes.size() == 0))
                    //? Collections.<String,String>emptyMap() : attributes;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.029 -0400", hash_original_method = "4CA8000463C36260BD9C3E4A41E197CE", hash_generated_method = "224CDB5C44E56D34F6069DDCF68E2723")
         void addAlias(String alias) {
            {
                boolean var5374BEA4A10DF1C27BAE96F18BD3D766_1694850423 = ((aliases == null) || (aliases.size() == 0));
                {
                    aliases = new ArrayList<String>();
                } //End block
            } //End collapsed parenthetic
            aliases.add(alias);
            addTaint(alias.getTaint());
            // ---------- Original Method ----------
            //if ((aliases == null) || (aliases.size() == 0)) {
                //aliases = new ArrayList<String>();
            //}
            //aliases.add(alias);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.030 -0400", hash_original_method = "2623207C72797F9950DF9980B680F416", hash_generated_method = "F1313DF0EF00E97855845C2984991AC0")
         void putAttribute(String name, String value) {
            {
                boolean varEB4E27A2355C4FBDE3011F0D25AF36B4_46199574 = ((attributes == null) || (attributes.size() == 0));
                {
                    attributes = new HashMap<String,String>();
                } //End block
            } //End collapsed parenthetic
            attributes.put(name, value);
            addTaint(name.getTaint());
            addTaint(value.getTaint());
            // ---------- Original Method ----------
            //if ((attributes == null) || (attributes.size() == 0)) {
                //attributes = new HashMap<String,String>();
            //}
            //attributes.put(name, value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.030 -0400", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "35EB3EFACE7CD77D1BA277F0F9145578")
        public final String getType() {
            String varB4EAC82CA7396A68D541C85D26508E83_136613286 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_136613286 = type;
            varB4EAC82CA7396A68D541C85D26508E83_136613286.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_136613286;
            // ---------- Original Method ----------
            //return type;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.031 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "1275168BFAAEEC0858CD6FE51BA1CFCF")
        public final String getAlgorithm() {
            String varB4EAC82CA7396A68D541C85D26508E83_1374595834 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1374595834 = algorithm;
            varB4EAC82CA7396A68D541C85D26508E83_1374595834.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1374595834;
            // ---------- Original Method ----------
            //return algorithm;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.031 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "E30923D25D409E48A31A82C884AE3C77")
        public final Provider getProvider() {
            Provider varB4EAC82CA7396A68D541C85D26508E83_1596402249 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1596402249 = provider;
            varB4EAC82CA7396A68D541C85D26508E83_1596402249.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1596402249;
            // ---------- Original Method ----------
            //return provider;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.032 -0400", hash_original_method = "8415940D3A1E5651F883E391EC68DA41", hash_generated_method = "EED4B32C33C519EDFAB6D2994EEB4909")
        public final String getClassName() {
            String varB4EAC82CA7396A68D541C85D26508E83_854288710 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_854288710 = className;
            varB4EAC82CA7396A68D541C85D26508E83_854288710.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_854288710;
            // ---------- Original Method ----------
            //return className;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.036 -0400", hash_original_method = "0C10317D01C11D1034B9356679E58CA0", hash_generated_method = "7A572AE22E94A958939061E2BE678D32")
        public final String getAttribute(String name) {
            String varB4EAC82CA7396A68D541C85D26508E83_1342302583 = null; //Variable for return #1
            String varB4EAC82CA7396A68D541C85D26508E83_1715556587 = null; //Variable for return #2
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1342302583 = null;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1715556587 = attributes.get(name);
            addTaint(name.getTaint());
            String varA7E53CE21691AB073D9660D615818899_780457048; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_780457048 = varB4EAC82CA7396A68D541C85D26508E83_1342302583;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_780457048 = varB4EAC82CA7396A68D541C85D26508E83_1715556587;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_780457048.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_780457048;
            // ---------- Original Method ----------
            //if (name == null) {
                //throw new NullPointerException();
            //}
            //if (attributes == null) {
                //return null;
            //}
            //return attributes.get(name);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.047 -0400", hash_original_method = "7A6F8F40D5019A1C644CF7CAD3518923", hash_generated_method = "51EB010605CC3CC690E888E1BC3E7B9C")
         List<String> getAliases() {
            List<String> varB4EAC82CA7396A68D541C85D26508E83_1366307537 = null; //Variable for return #1
            {
                aliases = new ArrayList<String>(0);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1366307537 = aliases;
            varB4EAC82CA7396A68D541C85D26508E83_1366307537.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1366307537;
            // ---------- Original Method ----------
            //if (aliases == null){
                //aliases = new ArrayList<String>(0);
            //}
            //return aliases;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.049 -0400", hash_original_method = "802A5A00EF15D2BF7FB674CB175B5DD7", hash_generated_method = "FD8837632B573A3FB94C639191529F93")
        public Object newInstance(Object constructorParameter) throws NoSuchAlgorithmException {
            Object varB4EAC82CA7396A68D541C85D26508E83_1389722360 = null; //Variable for return #1
            Object varB4EAC82CA7396A68D541C85D26508E83_1726699766 = null; //Variable for return #2
            {
                boolean var3339E2EE99840D316B470BF831351DB9_1071854221 = (implementation == null || !className.equals(lastClassName));
                {
                    ClassLoader cl;
                    cl = provider.getClass().getClassLoader();
                    {
                        cl = ClassLoader.getSystemClassLoader();
                    } //End block
                    try 
                    {
                        implementation = Class.forName(className, true, cl);
                        lastClassName = className;
                    } //End block
                    catch (Exception e)
                    {
                        if (DroidSafeAndroidRuntime.control) throw new NoSuchAlgorithmException(type + " " + algorithm + " implementation not found: " + e);
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                try 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1389722360 = implementation.newInstance();
                } //End block
                catch (Exception e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new NoSuchAlgorithmException(
                            type + " " + algorithm + " implementation not found", e);
                } //End block
            } //End block
            {
                boolean varF38959283B90E1EE47D3A31C8BA89AD9_955994769 = (!supportsParameter(constructorParameter));
                {
                    if (DroidSafeAndroidRuntime.control) throw new InvalidParameterException(type + ": service cannot use the parameter");
                } //End block
            } //End collapsed parenthetic
            Class[] parameterTypes;
            parameterTypes = new Class[1];
            Object[] initargs;
            try 
            {
                {
                    boolean var51E19F4634C2BA7E86B66347BB7D2C93_1086137019 = (type.equalsIgnoreCase("CertStore"));
                    {
                        parameterTypes[0] = Class.forName("java.security.cert.CertStoreParameters");
                    } //End block
                    {
                        parameterTypes[0] = constructorParameter.getClass();
                    } //End block
                } //End collapsed parenthetic
                varB4EAC82CA7396A68D541C85D26508E83_1726699766 = implementation.getConstructor(parameterTypes)
                        .newInstance(initargs);
            } //End block
            catch (Exception e)
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchAlgorithmException(type + " " + algorithm
                        + " implementation not found", e);
            } //End block
            addTaint(constructorParameter.getTaint());
            Object varA7E53CE21691AB073D9660D615818899_2137889289; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_2137889289 = varB4EAC82CA7396A68D541C85D26508E83_1389722360;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_2137889289 = varB4EAC82CA7396A68D541C85D26508E83_1726699766;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_2137889289.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_2137889289;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.062 -0400", hash_original_method = "A158C77880B526D8A49B8720A1D647AC", hash_generated_method = "D5F0E04112F8D81182FB5D6F04865DAB")
        public boolean supportsParameter(Object parameter) {
            addTaint(parameter.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_892290730 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_892290730;
            // ---------- Original Method ----------
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.063 -0400", hash_original_method = "CD20F19EDED4066F9FA28FD55133940E", hash_generated_method = "F997E426D2007FB7FA012FC0BF9EB52D")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1696541422 = null; //Variable for return #1
            String result;
            result = "Provider " + provider.getName() + " Service "
                    + type + "." + algorithm + " " + className;
            {
                result = result + "\nAliases " + aliases.toString();
            } //End block
            {
                result = result + "\nAttributes " + attributes.toString();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1696541422 = result;
            varB4EAC82CA7396A68D541C85D26508E83_1696541422.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1696541422;
            // ---------- Original Method ----------
            //String result = "Provider " + provider.getName() + " Service "
                    //+ type + "." + algorithm + " " + className;
            //if (aliases != null) {
                //result = result + "\nAliases " + aliases.toString();
            //}
            //if (attributes != null) {
                //result = result + "\nAttributes " + attributes.toString();
            //}
            //return result;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.063 -0400", hash_original_field = "7CC76EFC2B264F3D1AA5774D56F0CEA6", hash_generated_field = "B648AB29FEB386A3CFFA6A4D36095DA1")

    private static long serialVersionUID = -4298000515446427739L;
}

