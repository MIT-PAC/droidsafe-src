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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.147 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.148 -0400", hash_original_field = "2AF72F100C356273D46284F6FD1DFC08", hash_generated_field = "F3CA80FC5F7B3B542DC8B1C8FD91731C")

    private double version;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.148 -0400", hash_original_field = "239623964829E21A6BEC8B51CD66FB1E", hash_generated_field = "AEF8D804C6A6E39F2A136B97DEDD88CA")

    private transient String versionString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.148 -0400", hash_original_field = "CAF9B6B99962BF5C2264824231D7A40C", hash_generated_field = "1F50CB615F8F0AB19DCF28D9BAFF4DD4")

    private String info;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.148 -0400", hash_original_field = "426DF410C50A922A7FCCB45E28CFB99B", hash_generated_field = "3D346C5395708831B6A443E01975CD82")

    private transient int providerNumber = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.148 -0400", hash_original_field = "90D27D782F6C6A467A120DC0EA3CABA4", hash_generated_field = "D2A7F737A7D1793E39403AC0C5DE42B9")

    private transient TwoKeyHashMap<String, String, Service> serviceTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.148 -0400", hash_original_field = "C8290F032C183B62C8206C67F6F9691A", hash_generated_field = "B06FB286EE00C306B86D2F80CC057271")

    private transient TwoKeyHashMap<String, String, Service> aliasTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.148 -0400", hash_original_field = "51EA4BA55D4773B26DE32A2D9219C113", hash_generated_field = "974CEA24FA2B0A232602FB5D7E8DE337")

    private transient TwoKeyHashMap<String, String, Service> propertyServiceTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.148 -0400", hash_original_field = "0C259300D051D5E7246B301C0DD26E65", hash_generated_field = "496EDC5FF7DCB745D06FD58901D71D88")

    private transient TwoKeyHashMap<String, String, Service> propertyAliasTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.148 -0400", hash_original_field = "2157E7B4176C83B64377DBFE7F76F07E", hash_generated_field = "8BBAB31DBAA82BF49B07B5E12D0CF85B")

    private transient Properties changedProperties;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.148 -0400", hash_original_field = "3124884BBCB44722A70DEA4CA0A5EEDF", hash_generated_field = "78CA56FA7454490EF4843EE66CC1589B")

    private transient Provider.Service returnedService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.148 -0400", hash_original_field = "608855017360FBF6AA459F927179D0DF", hash_generated_field = "A17CE05D31CA338777E2E3315B0B2BB2")

    private transient String lastAlgorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.148 -0400", hash_original_field = "201DB549B9B6C1D90243C19553DE6893", hash_generated_field = "26FDBDCE6D172CC943C76DDD3CE0C4F1")

    private transient String lastServiceName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.148 -0400", hash_original_field = "79C5FB5C2352B93E380EDFDC155D6452", hash_generated_field = "BA27D1D25E16A8C025C9D2F64E31C9C5")

    private transient Set<Service> lastServicesSet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.148 -0400", hash_original_field = "AF709187F08859A6E70DA4496782164A", hash_generated_field = "3F98FC0FC213ABB6A1D68A8492E264D1")

    private transient String lastType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.148 -0400", hash_original_field = "C51F06888C4D2B6BFD3C97C9199539C4", hash_generated_field = "734DC09FAD571851B677CBD6C2E18D22")

    private transient Provider.Service lastServicesByType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.151 -0400", hash_original_method = "CD3EC30E89504BC69886C014A5CD7A7E", hash_generated_method = "C4D627FD8EDE0CA93E2598F924F902BC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.156 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "D66A74EBEBDE7870A3E4C3424823BFFB")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_96310793 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_96310793 = name;
        varB4EAC82CA7396A68D541C85D26508E83_96310793.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_96310793;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.156 -0400", hash_original_method = "849DADC9512AC29CFF5A5EB4D1517425", hash_generated_method = "BA50CD6DD07EB6B604DDF160144B3C6C")
    public double getVersion() {
        double varE8CD7DA078A86726031AD64F35F5A6C0_1499776185 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1499776185;
        // ---------- Original Method ----------
        //return version;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.156 -0400", hash_original_method = "90F1C2C1B854E8544A3CF05D4B3BD6E7", hash_generated_method = "AA82036741F94AE67016AFACF0D47AAE")
    public String getInfo() {
        String varB4EAC82CA7396A68D541C85D26508E83_1625739787 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1625739787 = info;
        varB4EAC82CA7396A68D541C85D26508E83_1625739787.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1625739787;
        // ---------- Original Method ----------
        //return info;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.157 -0400", hash_original_method = "58EC0A1A07497E3FA377B5366380E5E3", hash_generated_method = "5C00FBF136E041A762543CF555C901E2")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_84183723 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_84183723 = name + " version " + version;
        varB4EAC82CA7396A68D541C85D26508E83_84183723.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_84183723;
        // ---------- Original Method ----------
        //return name + " version " + version;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.162 -0400", hash_original_method = "53793BFB01C9C5B2BDDE9F63C2E38535", hash_generated_method = "A19DC41C7A8FE29FEA9015506AFF42CE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.162 -0400", hash_original_method = "EB6BD048CAF9E12CFD99EC1891725291", hash_generated_method = "5F36F54A477EC7438189B9017F68463C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.162 -0400", hash_original_method = "CE4C2613BF29D966F3F961299EB30975", hash_generated_method = "A9B51435AF0F7EBFCFADA8C2F3FCC4CD")
    @Override
    public synchronized void putAll(Map<?,?> t) {
        myPutAll(t);
        addTaint(t.getTaint());
        // ---------- Original Method ----------
        //myPutAll(t);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.170 -0400", hash_original_method = "F898BA9F30F0CED7EAABA59AE5C4F6F9", hash_generated_method = "01A200E0AA5490DBD9A0098A54FF2DA1")
    private void myPutAll(Map<?,?> t) {
        {
            changedProperties = new Properties();
        } //End block
        Iterator<? extends Map.Entry<?, ?>> it;
        it = t.entrySet().iterator();
        Object key;
        Object value;
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1244493122 = (it.hasNext());
            {
                Map.Entry<?, ?> entry;
                entry = it.next();
                key = entry.getKey();
                {
                    boolean var39D76CDDB13616FD0D42E75AC7C012F1_1874246236 = (key instanceof String && ((String) key).startsWith("Provider."));
                } //End collapsed parenthetic
                value = entry.getValue();
                super.put(key, value);
                {
                    boolean var557FC3098495809338F3BC3135E1280B_201554484 = (changedProperties.remove(key) == null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.171 -0400", hash_original_method = "70D9A28808783B7E2708BCE915ECB209", hash_generated_method = "B6E6C8569E5B743E49D6F02B4484767B")
    @Override
    public synchronized Set<Map.Entry<Object,Object>> entrySet() {
        Set<Map.Entry<Object,Object>> varB4EAC82CA7396A68D541C85D26508E83_2012537156 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2012537156 = Collections.unmodifiableSet(super.entrySet());
        varB4EAC82CA7396A68D541C85D26508E83_2012537156.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2012537156;
        // ---------- Original Method ----------
        //return Collections.unmodifiableSet(super.entrySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.172 -0400", hash_original_method = "45BA03BABBCEC97C3CDEDDFAAD34C546", hash_generated_method = "4351B129299231D5FBAB327731E707C3")
    @Override
    public Set<Object> keySet() {
        Set<Object> varB4EAC82CA7396A68D541C85D26508E83_1368392323 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1368392323 = Collections.unmodifiableSet(super.keySet());
        varB4EAC82CA7396A68D541C85D26508E83_1368392323.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1368392323;
        // ---------- Original Method ----------
        //return Collections.unmodifiableSet(super.keySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.176 -0400", hash_original_method = "4FF8F6E11AAD8FB860F173913A5840CE", hash_generated_method = "F06041064AEBB1B892C0994EC93479C9")
    @Override
    public Collection<Object> values() {
        Collection<Object> varB4EAC82CA7396A68D541C85D26508E83_1322082087 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1322082087 = Collections.unmodifiableCollection(super.values());
        varB4EAC82CA7396A68D541C85D26508E83_1322082087.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1322082087;
        // ---------- Original Method ----------
        //return Collections.unmodifiableCollection(super.values());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.184 -0400", hash_original_method = "6B0BAE35C6955DE6DEF5897424A78326", hash_generated_method = "8ECD80A1432FBD7D338EDFBB2784C94F")
    @Override
    public synchronized Object put(Object key, Object value) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1615616051 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_671979444 = null; //Variable for return #2
        {
            boolean var615FFDC8C58E5DA9131CFD1E840EB61D_1895537803 = (key instanceof String && ((String) key).startsWith("Provider."));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1615616051 = null;
            } //End block
        } //End collapsed parenthetic
        {
            Services.setNeedRefresh();
        } //End block
        {
            boolean varF5120E22219DB168E3E6D91BEC202FF4_604011875 = (changedProperties != null && changedProperties.remove(key) == null);
            {
                removeFromPropertyServiceTable(key);
            } //End block
        } //End collapsed parenthetic
        {
            changedProperties = new Properties();
        } //End block
        changedProperties.put(key, value);
        varB4EAC82CA7396A68D541C85D26508E83_671979444 = super.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_643973123; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_643973123 = varB4EAC82CA7396A68D541C85D26508E83_1615616051;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_643973123 = varB4EAC82CA7396A68D541C85D26508E83_671979444;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_643973123.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_643973123;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.186 -0400", hash_original_method = "8EA23C4ABA882E49A95AE531F4BFEB20", hash_generated_method = "DAA6C402D0837B6C6AE2255D0F32D7EE")
    @Override
    public synchronized Object remove(Object key) {
        Object varB4EAC82CA7396A68D541C85D26508E83_444264924 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_1468003954 = null; //Variable for return #2
        {
            boolean var615FFDC8C58E5DA9131CFD1E840EB61D_861542343 = (key instanceof String && ((String) key).startsWith("Provider."));
            {
                varB4EAC82CA7396A68D541C85D26508E83_444264924 = null;
            } //End block
        } //End collapsed parenthetic
        {
            Services.setNeedRefresh();
        } //End block
        {
            boolean varF5120E22219DB168E3E6D91BEC202FF4_848095262 = (changedProperties != null && changedProperties.remove(key) == null);
            {
                removeFromPropertyServiceTable(key);
                {
                    boolean var88F5A1A88583F68F084FEAD07CBA365C_1278347627 = (changedProperties.size() == 0);
                    {
                        changedProperties = null;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1468003954 = super.remove(key);
        addTaint(key.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_1647776668; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1647776668 = varB4EAC82CA7396A68D541C85D26508E83_444264924;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1647776668 = varB4EAC82CA7396A68D541C85D26508E83_1468003954;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1647776668.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1647776668;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.195 -0400", hash_original_method = "73ADEB588A693290C2EBE420EE1B60DD", hash_generated_method = "593516EC24633EB91E2ECD5587B8067A")
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
            boolean var83392DFFAC381D73DD8A3765EFB03BDF_642135912 = (checkAttribute(servAlg, attribute, val));
        } //End block
        addTaint(serv.getTaint());
        addTaint(alg.getTaint());
        addTaint(attribute.getTaint());
        addTaint(val.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1735206120 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1735206120;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.195 -0400", hash_original_method = "205FEBDC4595F3CAF3DB8C26A01A3B21", hash_generated_method = "6D905DB8F22E88C3357DB98CDA21C8FB")
    private boolean checkAttribute(String servAlg, String attribute, String val) {
        String attributeValue;
        attributeValue = getPropertyIgnoreCase(servAlg + ' ' + attribute);
        {
            {
                boolean var9AAE8A593FFFFD550F3379BD45AFB455_1008427378 = (attribute.equalsIgnoreCase("KeySize"));
                {
                    {
                        boolean var2CCBDA5D9949774AEDDE95DD101E1B5B_1894468419 = (Integer.parseInt(attributeValue) >= Integer.parseInt(val));
                    } //End collapsed parenthetic
                } //End block
                {
                    {
                        boolean varBE561380D0BC947AE323F09089366FE2_1870232951 = (attributeValue.equalsIgnoreCase(val));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(servAlg.getTaint());
        addTaint(attribute.getTaint());
        addTaint(val.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_698742120 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_698742120;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.196 -0400", hash_original_method = "6418C82159D4FAB251CB16B6C408D61D", hash_generated_method = "BA9FDE46C0F8402C6FB4936CC36C7FAA")
     void setProviderNumber(int n) {
        providerNumber = n;
        // ---------- Original Method ----------
        //providerNumber = n;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.219 -0400", hash_original_method = "6209D7B36FBC76163C52BAAF1CE53C35", hash_generated_method = "2B86EA9D37677E713274E67016B160B7")
     int getProviderNumber() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_78375807 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_78375807;
        // ---------- Original Method ----------
        //return providerNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.224 -0400", hash_original_method = "6BFCD4E62487080CD7F60A29BC4CC43B", hash_generated_method = "B53B17E0F211F4A9A45D63AED0799036")
    synchronized Provider.Service getService(String type) {
        Provider.Service varB4EAC82CA7396A68D541C85D26508E83_61179660 = null; //Variable for return #1
        Provider.Service varB4EAC82CA7396A68D541C85D26508E83_1839097724 = null; //Variable for return #2
        Provider.Service varB4EAC82CA7396A68D541C85D26508E83_1348611962 = null; //Variable for return #3
        updatePropertyServiceTable();
        {
            boolean varE8D1884AAD74E2F5DA1CD399B1822ECD_663857282 = (lastServicesByType != null && type.equals(lastType));
            {
                varB4EAC82CA7396A68D541C85D26508E83_61179660 = lastServicesByType;
            } //End block
        } //End collapsed parenthetic
        Provider.Service service;
        {
            Iterator<Service> it;
            it = getServices().iterator();
            boolean var03729FD53960D8DCA3A41A13A0229637_1466516184 = (it.hasNext());
            {
                service = it.next();
                {
                    boolean var4C71E495B2DBF2BB72C8225160CEBE9A_184295056 = (type.equals(service.type));
                    {
                        lastType = type;
                        lastServicesByType = service;
                        varB4EAC82CA7396A68D541C85D26508E83_1839097724 = service;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1348611962 = null;
        Provider.Service varA7E53CE21691AB073D9660D615818899_1118404713; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1118404713 = varB4EAC82CA7396A68D541C85D26508E83_61179660;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1118404713 = varB4EAC82CA7396A68D541C85D26508E83_1839097724;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1118404713 = varB4EAC82CA7396A68D541C85D26508E83_1348611962;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1118404713.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1118404713;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.225 -0400", hash_original_method = "6DABE02DE2A4DD1C36F9592BEF5E1C73", hash_generated_method = "773D520D882941438E4AFF2B232589FE")
    public synchronized Provider.Service getService(String type,
            String algorithm) {
        Provider.Service varB4EAC82CA7396A68D541C85D26508E83_78690208 = null; //Variable for return #1
        Provider.Service varB4EAC82CA7396A68D541C85D26508E83_1537028481 = null; //Variable for return #2
        Provider.Service varB4EAC82CA7396A68D541C85D26508E83_182727399 = null; //Variable for return #3
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            boolean var5D9786D09CE430680B17444C7FCE5061_639105287 = (type.equals(lastServiceName) && algorithm.equalsIgnoreCase(lastAlgorithm));
            {
                varB4EAC82CA7396A68D541C85D26508E83_78690208 = returnedService;
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
            varB4EAC82CA7396A68D541C85D26508E83_1537028481 = returnedService;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_182727399 = null;
        Provider.Service varA7E53CE21691AB073D9660D615818899_99252900; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_99252900 = varB4EAC82CA7396A68D541C85D26508E83_78690208;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_99252900 = varB4EAC82CA7396A68D541C85D26508E83_1537028481;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_99252900 = varB4EAC82CA7396A68D541C85D26508E83_182727399;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_99252900.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_99252900;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.226 -0400", hash_original_method = "8008CDA805FE131E4E7ECE670E22E200", hash_generated_method = "176C29001E7F0923E0866D94D5F8D65A")
    public synchronized Set<Provider.Service> getServices() {
        Set<Provider.Service> varB4EAC82CA7396A68D541C85D26508E83_2121331246 = null; //Variable for return #1
        Set<Provider.Service> varB4EAC82CA7396A68D541C85D26508E83_430806022 = null; //Variable for return #2
        updatePropertyServiceTable();
        {
            varB4EAC82CA7396A68D541C85D26508E83_2121331246 = lastServicesSet;
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
        varB4EAC82CA7396A68D541C85D26508E83_430806022 = lastServicesSet;
        Set<Provider.Service> varA7E53CE21691AB073D9660D615818899_539687147; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_539687147 = varB4EAC82CA7396A68D541C85D26508E83_2121331246;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_539687147 = varB4EAC82CA7396A68D541C85D26508E83_430806022;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_539687147.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_539687147;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.258 -0400", hash_original_method = "3E5E06298B83C020AD9BCF69B9E3CE94", hash_generated_method = "A94C6B7419400DAA1BE73886E5906BDA")
    protected synchronized void putService(Provider.Service s) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            boolean varF52B1BD6E65C5078A2BDD1FFCE56BDE7_1354289225 = ("Provider".equals(s.getType()));
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
                Iterator<String> var53A703E015EC0F90D15F82B6703EC2ED_1680780415 = (s.getAliases()).iterator();
                var53A703E015EC0F90D15F82B6703EC2ED_1680780415.hasNext();
                String alias = var53A703E015EC0F90D15F82B6703EC2ED_1680780415.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.280 -0400", hash_original_method = "D2521231A8F61254D866781010E5F7B6", hash_generated_method = "B9E32E5EF48EFAF4B38D2BCEB000ECBB")
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
                Iterator<String> var0B0914451AB60F2FBE3FA1B1B21C1A4E_1556115054 = (s.getAliases()).iterator();
                var0B0914451AB60F2FBE3FA1B1B21C1A4E_1556115054.hasNext();
                String alias = var0B0914451AB60F2FBE3FA1B1B21C1A4E_1556115054.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.310 -0400", hash_original_method = "FD9674DD64603638CEEAFAAECA2377E1", hash_generated_method = "5EA0A207E38168679010CDA61C801938")
    private void serviceInfoToProperties(Provider.Service s) {
        super.put(s.type + "." + s.algorithm, s.className);
        {
            {
                Iterator<String> i;
                i = s.aliases.iterator();
                boolean varD8B5E52A597500CBD863E52A46B42708_1954779212 = (i.hasNext());
                {
                    super.put("Alg.Alias." + s.type + "." + i.next(), s.algorithm);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                Iterator<Map.Entry<String, String>> varEC591D00247358B530BCEAA3DE5F4B70_1813789965 = (s.attributes.entrySet()).iterator();
                varEC591D00247358B530BCEAA3DE5F4B70_1813789965.hasNext();
                Map.Entry<String, String> entry = varEC591D00247358B530BCEAA3DE5F4B70_1813789965.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.326 -0400", hash_original_method = "E3342D080F10DDAA1FF9ED29EA29694F", hash_generated_method = "D9F653F5C74E3C1EA2E9CB770CC6A225")
    private void serviceInfoFromProperties(Provider.Service s) {
        super.remove(s.type + "." + s.algorithm);
        {
            {
                Iterator<String> i;
                i = s.aliases.iterator();
                boolean varD8B5E52A597500CBD863E52A46B42708_1731281475 = (i.hasNext());
                {
                    super.remove("Alg.Alias." + s.type + "." + i.next());
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                Iterator<Map.Entry<String, String>> varEC591D00247358B530BCEAA3DE5F4B70_912781704 = (s.attributes.entrySet()).iterator();
                varEC591D00247358B530BCEAA3DE5F4B70_912781704.hasNext();
                Map.Entry<String, String> entry = varEC591D00247358B530BCEAA3DE5F4B70_912781704.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.444 -0400", hash_original_method = "C88E49400116B5906A9CAC0E8D20528B", hash_generated_method = "1EF34B2B0CA7460530FD636836478F98")
    private void removeFromPropertyServiceTable(Object key) {
        String k;
        k = (String) key;
        {
            boolean var51D0AB19C0E4EAD46591A8C66CC40542_1142303561 = (k.startsWith("Provider."));
        } //End collapsed parenthetic
        Provider.Service s;
        String serviceName;
        String algorithm;
        algorithm = null;
        String attribute;
        attribute = null;
        int i;
        {
            boolean varB2EA1E0E9D7C7EEC2C9BF24E8B1510EA_1128245231 = (k.startsWith("Alg.Alias."));
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
                        boolean var4A1B8BE89C779B21458638B02948AC2A_2124345898 = (it
                        .hasNext());
                        {
                            s = it.next();
                            {
                                boolean var6F8C4AE25185D3231A2E4FD7E4E357C3_646397082 = (s.aliases.contains(aliasName));
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
                        Iterator<String> var3BE46C9A129D4D7F74F143C9623D7876_136299800 = (ser.aliases).iterator();
                        var3BE46C9A129D4D7F74F143C9623D7876_136299800.hasNext();
                        String alias = var3BE46C9A129D4D7F74F143C9623D7876_136299800.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.477 -0400", hash_original_method = "C12B51396475B7F4EF23B74D619C33FD", hash_generated_method = "BFB789CD77543EF9A4F16073ABCFD6CE")
    private void updatePropertyServiceTable() {
        Object _key;
        Object _value;
        Provider.Service s;
        String serviceName;
        String algorithm;
        {
            boolean var9C86F49586631F13D865CF4B9FA9A44B_1015891574 = (changedProperties == null || changedProperties.isEmpty());
        } //End collapsed parenthetic
        {
            Iterator<Map.Entry<Object, Object>> it;
            it = changedProperties.entrySet().iterator();
            boolean var9D0EDA54CCAB017AFE33C830CCA36C58_815060131 = (it
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
                    boolean var2F2AA442FA156A8F8BA53B7B622AD8C8_456943324 = (key.startsWith("Provider"));
                } //End collapsed parenthetic
                int i;
                {
                    boolean var95164A0B30E45315F7A1F2560FE7C960_1636720944 = (key.startsWith("Alg.Alias."));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.484 -0400", hash_original_method = "FD7619437CD0960F1AEBA32A154F0328", hash_generated_method = "9C6A342A2081A7D73BA214C115FEC8EA")
    private void servicesChanged() {
        lastServicesByType = null;
        lastServiceName = null;
        lastServicesSet = null;
        // ---------- Original Method ----------
        //lastServicesByType = null;
        //lastServiceName = null;
        //lastServicesSet = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.488 -0400", hash_original_method = "768CFC89B63FD1F782E3758D2BCFC6C0", hash_generated_method = "BEA2C42DB158CE6C3270D65A149F3B2E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.488 -0400", hash_original_method = "62DD35352FE8FA7B38C17798ED376C47", hash_generated_method = "DFD67E99FDE9144A42187020C5132AED")
    private String getPropertyIgnoreCase(String key) {
        String varB4EAC82CA7396A68D541C85D26508E83_1431987647 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1452088217 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_510434913 = null; //Variable for return #3
        String res;
        res = getProperty(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1431987647 = res;
        } //End block
        {
            Enumeration<?> e;
            e = propertyNames();
            boolean var3EB0A96682EDBE15308427BAC1EC4A4E_965424500 = (e.hasMoreElements());
            {
                String propertyName;
                propertyName = (String) e.nextElement();
                {
                    boolean var7026A60BEF5468325737B39ADF42B3F9_2120971425 = (key.equalsIgnoreCase(propertyName));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1452088217 = getProperty(propertyName);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_510434913 = null;
        addTaint(key.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1082227617; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1082227617 = varB4EAC82CA7396A68D541C85D26508E83_1431987647;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1082227617 = varB4EAC82CA7396A68D541C85D26508E83_1452088217;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1082227617 = varB4EAC82CA7396A68D541C85D26508E83_510434913;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1082227617.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1082227617;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.491 -0400", hash_original_method = "C9BE26B06AA230EA20C77B7F366C53C8", hash_generated_method = "33B05CAC88D7518817CBC9CBBAA8281A")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.491 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

        private Provider provider;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.491 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

        private String type;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.491 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

        private String algorithm;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.491 -0400", hash_original_field = "6F66E878C62DB60568A3487869695820", hash_generated_field = "B28341EF6B88AA3CAD2D37FF14C9DC00")

        private String className;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.492 -0400", hash_original_field = "9299DA2529C98FCCCE0E32B476BA3266", hash_generated_field = "7D96162B1AE01DA7357D6662D8D2C584")

        private List<String> aliases;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.492 -0400", hash_original_field = "736B91750E516139ACC13C5EB6564F92", hash_generated_field = "1CEAC23D4A656E23182C27FC3A78AEDE")

        private Map<String,String> attributes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.492 -0400", hash_original_field = "B6FA15360B4CDCE4806BF9A0580C8F0F", hash_generated_field = "28101B8550628F94A8DDB23FAF399E56")

        private Class<?> implementation;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.492 -0400", hash_original_field = "77FDFBF3D811B72BC9BBBE747A722F58", hash_generated_field = "668E14A773F053D0B44156BD480B724E")

        private String lastClassName;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.513 -0400", hash_original_method = "82CB06DCD943152835D64FFE915BA566", hash_generated_method = "729BA8513727B47508A50A1E8982676B")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.513 -0400", hash_original_method = "4CA8000463C36260BD9C3E4A41E197CE", hash_generated_method = "B6CF76ACA7EA87EC655EC0B011ECA49F")
         void addAlias(String alias) {
            {
                boolean var5374BEA4A10DF1C27BAE96F18BD3D766_321532143 = ((aliases == null) || (aliases.size() == 0));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.513 -0400", hash_original_method = "2623207C72797F9950DF9980B680F416", hash_generated_method = "1201C8A176B13B233E29887362EBA4FA")
         void putAttribute(String name, String value) {
            {
                boolean varEB4E27A2355C4FBDE3011F0D25AF36B4_2068622089 = ((attributes == null) || (attributes.size() == 0));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.514 -0400", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "84B8AE99ABDF97DBF3E5EC28585ED2FC")
        public final String getType() {
            String varB4EAC82CA7396A68D541C85D26508E83_2101566775 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2101566775 = type;
            varB4EAC82CA7396A68D541C85D26508E83_2101566775.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2101566775;
            // ---------- Original Method ----------
            //return type;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.515 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "EBA03C9949B01DA857FAA032246C92E4")
        public final String getAlgorithm() {
            String varB4EAC82CA7396A68D541C85D26508E83_1471685243 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1471685243 = algorithm;
            varB4EAC82CA7396A68D541C85D26508E83_1471685243.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1471685243;
            // ---------- Original Method ----------
            //return algorithm;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.518 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "289C55A257052D222FA9385DF4D79909")
        public final Provider getProvider() {
            Provider varB4EAC82CA7396A68D541C85D26508E83_694055876 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_694055876 = provider;
            varB4EAC82CA7396A68D541C85D26508E83_694055876.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_694055876;
            // ---------- Original Method ----------
            //return provider;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.518 -0400", hash_original_method = "8415940D3A1E5651F883E391EC68DA41", hash_generated_method = "E7EEC2F91C3BBBB4A302151D9136B4E8")
        public final String getClassName() {
            String varB4EAC82CA7396A68D541C85D26508E83_948676719 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_948676719 = className;
            varB4EAC82CA7396A68D541C85D26508E83_948676719.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_948676719;
            // ---------- Original Method ----------
            //return className;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.530 -0400", hash_original_method = "0C10317D01C11D1034B9356679E58CA0", hash_generated_method = "7E377A364099FE4FB27E9A78F47B9BD8")
        public final String getAttribute(String name) {
            String varB4EAC82CA7396A68D541C85D26508E83_608694561 = null; //Variable for return #1
            String varB4EAC82CA7396A68D541C85D26508E83_1935599726 = null; //Variable for return #2
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_608694561 = null;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1935599726 = attributes.get(name);
            addTaint(name.getTaint());
            String varA7E53CE21691AB073D9660D615818899_1657087316; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1657087316 = varB4EAC82CA7396A68D541C85D26508E83_608694561;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1657087316 = varB4EAC82CA7396A68D541C85D26508E83_1935599726;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1657087316.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1657087316;
            // ---------- Original Method ----------
            //if (name == null) {
                //throw new NullPointerException();
            //}
            //if (attributes == null) {
                //return null;
            //}
            //return attributes.get(name);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.531 -0400", hash_original_method = "7A6F8F40D5019A1C644CF7CAD3518923", hash_generated_method = "B10BB91302798B68380C2A324D090DB2")
         List<String> getAliases() {
            List<String> varB4EAC82CA7396A68D541C85D26508E83_1244455440 = null; //Variable for return #1
            {
                aliases = new ArrayList<String>(0);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1244455440 = aliases;
            varB4EAC82CA7396A68D541C85D26508E83_1244455440.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1244455440;
            // ---------- Original Method ----------
            //if (aliases == null){
                //aliases = new ArrayList<String>(0);
            //}
            //return aliases;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.533 -0400", hash_original_method = "802A5A00EF15D2BF7FB674CB175B5DD7", hash_generated_method = "D75CDD49CFDB090F3AA42BF63B1C46D3")
        public Object newInstance(Object constructorParameter) throws NoSuchAlgorithmException {
            Object varB4EAC82CA7396A68D541C85D26508E83_1585822882 = null; //Variable for return #1
            Object varB4EAC82CA7396A68D541C85D26508E83_1725472361 = null; //Variable for return #2
            {
                boolean var3339E2EE99840D316B470BF831351DB9_1550910745 = (implementation == null || !className.equals(lastClassName));
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
                    varB4EAC82CA7396A68D541C85D26508E83_1585822882 = implementation.newInstance();
                } //End block
                catch (Exception e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new NoSuchAlgorithmException(
                            type + " " + algorithm + " implementation not found", e);
                } //End block
            } //End block
            {
                boolean varF38959283B90E1EE47D3A31C8BA89AD9_449926052 = (!supportsParameter(constructorParameter));
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
                    boolean var51E19F4634C2BA7E86B66347BB7D2C93_1652397598 = (type.equalsIgnoreCase("CertStore"));
                    {
                        parameterTypes[0] = Class.forName("java.security.cert.CertStoreParameters");
                    } //End block
                    {
                        parameterTypes[0] = constructorParameter.getClass();
                    } //End block
                } //End collapsed parenthetic
                varB4EAC82CA7396A68D541C85D26508E83_1725472361 = implementation.getConstructor(parameterTypes)
                        .newInstance(initargs);
            } //End block
            catch (Exception e)
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchAlgorithmException(type + " " + algorithm
                        + " implementation not found", e);
            } //End block
            addTaint(constructorParameter.getTaint());
            Object varA7E53CE21691AB073D9660D615818899_83422991; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_83422991 = varB4EAC82CA7396A68D541C85D26508E83_1585822882;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_83422991 = varB4EAC82CA7396A68D541C85D26508E83_1725472361;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_83422991.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_83422991;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.556 -0400", hash_original_method = "A158C77880B526D8A49B8720A1D647AC", hash_generated_method = "D98A0B564BA5F8DFB94F5DD199F6710B")
        public boolean supportsParameter(Object parameter) {
            addTaint(parameter.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1653523426 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1653523426;
            // ---------- Original Method ----------
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.556 -0400", hash_original_method = "CD20F19EDED4066F9FA28FD55133940E", hash_generated_method = "610ED7189FAE438785C1B0122B6837C7")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1906088579 = null; //Variable for return #1
            String result;
            result = "Provider " + provider.getName() + " Service "
                    + type + "." + algorithm + " " + className;
            {
                result = result + "\nAliases " + aliases.toString();
            } //End block
            {
                result = result + "\nAttributes " + attributes.toString();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1906088579 = result;
            varB4EAC82CA7396A68D541C85D26508E83_1906088579.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1906088579;
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.557 -0400", hash_original_field = "7CC76EFC2B264F3D1AA5774D56F0CEA6", hash_generated_field = "B648AB29FEB386A3CFFA6A4D36095DA1")

    private static long serialVersionUID = -4298000515446427739L;
}

