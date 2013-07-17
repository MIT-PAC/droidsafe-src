package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.307 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.307 -0400", hash_original_field = "2AF72F100C356273D46284F6FD1DFC08", hash_generated_field = "F3CA80FC5F7B3B542DC8B1C8FD91731C")

    private double version;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.307 -0400", hash_original_field = "239623964829E21A6BEC8B51CD66FB1E", hash_generated_field = "AEF8D804C6A6E39F2A136B97DEDD88CA")

    private transient String versionString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.307 -0400", hash_original_field = "CAF9B6B99962BF5C2264824231D7A40C", hash_generated_field = "1F50CB615F8F0AB19DCF28D9BAFF4DD4")

    private String info;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.307 -0400", hash_original_field = "426DF410C50A922A7FCCB45E28CFB99B", hash_generated_field = "3D346C5395708831B6A443E01975CD82")

    private transient int providerNumber = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.307 -0400", hash_original_field = "90D27D782F6C6A467A120DC0EA3CABA4", hash_generated_field = "D2A7F737A7D1793E39403AC0C5DE42B9")

    private transient TwoKeyHashMap<String, String, Service> serviceTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.307 -0400", hash_original_field = "C8290F032C183B62C8206C67F6F9691A", hash_generated_field = "B06FB286EE00C306B86D2F80CC057271")

    private transient TwoKeyHashMap<String, String, Service> aliasTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.307 -0400", hash_original_field = "51EA4BA55D4773B26DE32A2D9219C113", hash_generated_field = "974CEA24FA2B0A232602FB5D7E8DE337")

    private transient TwoKeyHashMap<String, String, Service> propertyServiceTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.307 -0400", hash_original_field = "0C259300D051D5E7246B301C0DD26E65", hash_generated_field = "496EDC5FF7DCB745D06FD58901D71D88")

    private transient TwoKeyHashMap<String, String, Service> propertyAliasTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.307 -0400", hash_original_field = "2157E7B4176C83B64377DBFE7F76F07E", hash_generated_field = "8BBAB31DBAA82BF49B07B5E12D0CF85B")

    private transient Properties changedProperties;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.307 -0400", hash_original_field = "3124884BBCB44722A70DEA4CA0A5EEDF", hash_generated_field = "78CA56FA7454490EF4843EE66CC1589B")

    private transient Provider.Service returnedService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.307 -0400", hash_original_field = "608855017360FBF6AA459F927179D0DF", hash_generated_field = "A17CE05D31CA338777E2E3315B0B2BB2")

    private transient String lastAlgorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.307 -0400", hash_original_field = "201DB549B9B6C1D90243C19553DE6893", hash_generated_field = "26FDBDCE6D172CC943C76DDD3CE0C4F1")

    private transient String lastServiceName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.307 -0400", hash_original_field = "79C5FB5C2352B93E380EDFDC155D6452", hash_generated_field = "BA27D1D25E16A8C025C9D2F64E31C9C5")

    private transient Set<Service> lastServicesSet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.307 -0400", hash_original_field = "AF709187F08859A6E70DA4496782164A", hash_generated_field = "3F98FC0FC213ABB6A1D68A8492E264D1")

    private transient String lastType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.307 -0400", hash_original_field = "C51F06888C4D2B6BFD3C97C9199539C4", hash_generated_field = "734DC09FAD571851B677CBD6C2E18D22")

    private transient Provider.Service lastServicesByType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.308 -0400", hash_original_method = "CD3EC30E89504BC69886C014A5CD7A7E", hash_generated_method = "C4D627FD8EDE0CA93E2598F924F902BC")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.309 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "4916E745AA7F66FEBAF9916BF2C971D7")
    public String getName() {
String varB017984728AC60AD1F0BF8734F33F15C_1526037376 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_1526037376.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_1526037376;
        // ---------- Original Method ----------
        //return name;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.309 -0400", hash_original_method = "849DADC9512AC29CFF5A5EB4D1517425", hash_generated_method = "AB905EB0BF21C09087ADD04FE71C3B5F")
    public double getVersion() {
        double var2AF72F100C356273D46284F6FD1DFC08_247399172 = (version);
                double varE8CD7DA078A86726031AD64F35F5A6C0_1706276181 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1706276181;
        // ---------- Original Method ----------
        //return version;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.309 -0400", hash_original_method = "90F1C2C1B854E8544A3CF05D4B3BD6E7", hash_generated_method = "4EE97BB78DC3429561CAA430F6438FEF")
    public String getInfo() {
String var43CF3338FDBA93597A9562D3166E9DC4_150258674 =         info;
        var43CF3338FDBA93597A9562D3166E9DC4_150258674.addTaint(taint);
        return var43CF3338FDBA93597A9562D3166E9DC4_150258674;
        // ---------- Original Method ----------
        //return info;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.309 -0400", hash_original_method = "58EC0A1A07497E3FA377B5366380E5E3", hash_generated_method = "2646852FC0CC1FF2036AC3B2BC30CE00")
    @Override
    public String toString() {
String var50E90DE824F2DD490679392189EDA33C_1054371514 =         name + " version " + version;
        var50E90DE824F2DD490679392189EDA33C_1054371514.addTaint(taint);
        return var50E90DE824F2DD490679392189EDA33C_1054371514;
        // ---------- Original Method ----------
        //return name + " version " + version;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.310 -0400", hash_original_method = "53793BFB01C9C5B2BDDE9F63C2E38535", hash_generated_method = "51F2BDED737F22F77F16FE87E2A29BF1")
    @Override
    public synchronized void clear() {
        super.clear();
        if(serviceTable != null)        
        {
            serviceTable.clear();
        } //End block
        if(propertyServiceTable != null)        
        {
            propertyServiceTable.clear();
        } //End block
        if(aliasTable != null)        
        {
            aliasTable.clear();
        } //End block
        if(propertyAliasTable != null)        
        {
            propertyAliasTable.clear();
        } //End block
        changedProperties = null;
        putProviderInfo();
        if(providerNumber != -1)        
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.311 -0400", hash_original_method = "EB6BD048CAF9E12CFD99EC1891725291", hash_generated_method = "0CDD80B9CC8CC73B60130FCD06F2D900")
    @Override
    public synchronized void load(InputStream inStream) throws IOException {
        addTaint(inStream.getTaint());
        Properties tmp = new Properties();
        tmp.load(inStream);
        myPutAll(tmp);
        // ---------- Original Method ----------
        //Properties tmp = new Properties();
        //tmp.load(inStream);
        //myPutAll(tmp);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.311 -0400", hash_original_method = "CE4C2613BF29D966F3F961299EB30975", hash_generated_method = "FF14B13433ABABBF0B387A5998853671")
    @Override
    public synchronized void putAll(Map<?,?> t) {
        addTaint(t.getTaint());
        myPutAll(t);
        // ---------- Original Method ----------
        //myPutAll(t);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.312 -0400", hash_original_method = "F898BA9F30F0CED7EAABA59AE5C4F6F9", hash_generated_method = "B048ACB4D9B7591C5029ED46774097C6")
    private void myPutAll(Map<?,?> t) {
        addTaint(t.getTaint());
        if(changedProperties == null)        
        {
            changedProperties = new Properties();
        } //End block
        Iterator<? extends Map.Entry<?, ?>> it = t.entrySet().iterator();
        Object key;
        Object value;
        while
(it.hasNext())        
        {
            Map.Entry<?, ?> entry = it.next();
            key = entry.getKey();
            if(key instanceof String && ((String) key).startsWith("Provider."))            
            {
                continue;
            } //End block
            value = entry.getValue();
            super.put(key, value);
            if(changedProperties.remove(key) == null)            
            {
                removeFromPropertyServiceTable(key);
            } //End block
            changedProperties.put(key, value);
        } //End block
        if(providerNumber != -1)        
        {
            Services.setNeedRefresh();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.312 -0400", hash_original_method = "70D9A28808783B7E2708BCE915ECB209", hash_generated_method = "C6347300EF6E6A7BCA780184DF5BE7BF")
    @Override
    public synchronized Set<Map.Entry<Object,Object>> entrySet() {
Set<Map.Entry<Object,Object>> varD57B937898B8DAAF433086023CDE0FFC_1847306332 =         Collections.unmodifiableSet(super.entrySet());
        varD57B937898B8DAAF433086023CDE0FFC_1847306332.addTaint(taint);
        return varD57B937898B8DAAF433086023CDE0FFC_1847306332;
        // ---------- Original Method ----------
        //return Collections.unmodifiableSet(super.entrySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.313 -0400", hash_original_method = "45BA03BABBCEC97C3CDEDDFAAD34C546", hash_generated_method = "CA163F3803AFBFEA323578BCB31F4FC4")
    @Override
    public Set<Object> keySet() {
Set<Object> varC576E95CEF2DB749DB3850658FFE6F1C_850752919 =         Collections.unmodifiableSet(super.keySet());
        varC576E95CEF2DB749DB3850658FFE6F1C_850752919.addTaint(taint);
        return varC576E95CEF2DB749DB3850658FFE6F1C_850752919;
        // ---------- Original Method ----------
        //return Collections.unmodifiableSet(super.keySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.313 -0400", hash_original_method = "4FF8F6E11AAD8FB860F173913A5840CE", hash_generated_method = "FD1B4A44D737129E82541E1F33C2035A")
    @Override
    public Collection<Object> values() {
Collection<Object> varF31BFB95E4035986BE22A02616A5652D_2061564753 =         Collections.unmodifiableCollection(super.values());
        varF31BFB95E4035986BE22A02616A5652D_2061564753.addTaint(taint);
        return varF31BFB95E4035986BE22A02616A5652D_2061564753;
        // ---------- Original Method ----------
        //return Collections.unmodifiableCollection(super.values());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.313 -0400", hash_original_method = "6B0BAE35C6955DE6DEF5897424A78326", hash_generated_method = "0846169D79FC7DB78BAFF67CB393A4B4")
    @Override
    public synchronized Object put(Object key, Object value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        if(key instanceof String && ((String) key).startsWith("Provider."))        
        {
Object var540C13E9E156B687226421B24F2DF178_177160110 =             null;
            var540C13E9E156B687226421B24F2DF178_177160110.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_177160110;
        } //End block
        if(providerNumber != -1)        
        {
            Services.setNeedRefresh();
        } //End block
        if(changedProperties != null && changedProperties.remove(key) == null)        
        {
            removeFromPropertyServiceTable(key);
        } //End block
        if(changedProperties == null)        
        {
            changedProperties = new Properties();
        } //End block
        changedProperties.put(key, value);
Object var34EAB73DB44693D365A6742CBB445BED_1851328752 =         super.put(key, value);
        var34EAB73DB44693D365A6742CBB445BED_1851328752.addTaint(taint);
        return var34EAB73DB44693D365A6742CBB445BED_1851328752;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.314 -0400", hash_original_method = "8EA23C4ABA882E49A95AE531F4BFEB20", hash_generated_method = "EE439239324610DB25114B3EF2D03293")
    @Override
    public synchronized Object remove(Object key) {
        addTaint(key.getTaint());
        if(key instanceof String && ((String) key).startsWith("Provider."))        
        {
Object var540C13E9E156B687226421B24F2DF178_1867162822 =             null;
            var540C13E9E156B687226421B24F2DF178_1867162822.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1867162822;
        } //End block
        if(providerNumber != -1)        
        {
            Services.setNeedRefresh();
        } //End block
        if(changedProperties != null && changedProperties.remove(key) == null)        
        {
            removeFromPropertyServiceTable(key);
            if(changedProperties.size() == 0)            
            {
                changedProperties = null;
            } //End block
        } //End block
Object varBACBF699252AC3FDC76153D632679B1D_375596264 =         super.remove(key);
        varBACBF699252AC3FDC76153D632679B1D_375596264.addTaint(taint);
        return varBACBF699252AC3FDC76153D632679B1D_375596264;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.315 -0400", hash_original_method = "73ADEB588A693290C2EBE420EE1B60DD", hash_generated_method = "2A9CBD931F852723AD0BFA453BE6F9AD")
     boolean implementsAlg(String serv, String alg, String attribute, String val) {
        addTaint(val.getTaint());
        addTaint(attribute.getTaint());
        addTaint(alg.getTaint());
        addTaint(serv.getTaint());
        String servAlg = serv + "." + alg;
        String prop = getPropertyIgnoreCase(servAlg);
        if(prop == null)        
        {
            alg = getPropertyIgnoreCase("Alg.Alias." + servAlg);
            if(alg != null)            
            {
                servAlg = serv + "." + alg;
                prop = getPropertyIgnoreCase(servAlg);
            } //End block
        } //End block
        if(prop != null)        
        {
            if(attribute == null)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1830584013 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1318756641 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1318756641;
            } //End block
            boolean var780F01F84340806DE300DADF194ECA40_20952779 = (checkAttribute(servAlg, attribute, val));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1473228348 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1473228348;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_204076890 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_560538881 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_560538881;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.315 -0400", hash_original_method = "205FEBDC4595F3CAF3DB8C26A01A3B21", hash_generated_method = "2585AD6A88338662B2AD9D4E9E0849FE")
    private boolean checkAttribute(String servAlg, String attribute, String val) {
        addTaint(val.getTaint());
        addTaint(attribute.getTaint());
        addTaint(servAlg.getTaint());
        String attributeValue = getPropertyIgnoreCase(servAlg + ' ' + attribute);
        if(attributeValue != null)        
        {
            if(attribute.equalsIgnoreCase("KeySize"))            
            {
                if(Integer.parseInt(attributeValue) >= Integer.parseInt(val))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_2115202055 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1988983819 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1988983819;
                } //End block
            } //End block
            else
            {
                if(attributeValue.equalsIgnoreCase(val))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_2127134664 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_470281967 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_470281967;
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1917289671 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2020297816 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2020297816;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.315 -0400", hash_original_method = "6418C82159D4FAB251CB16B6C408D61D", hash_generated_method = "BA9FDE46C0F8402C6FB4936CC36C7FAA")
     void setProviderNumber(int n) {
        providerNumber = n;
        // ---------- Original Method ----------
        //providerNumber = n;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.316 -0400", hash_original_method = "6209D7B36FBC76163C52BAAF1CE53C35", hash_generated_method = "195E6BB6EFCEB538FBC179FA02F64A6B")
     int getProviderNumber() {
        int varBC53644233DA12363BC91D331C131157_1584167113 = (providerNumber);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1836217142 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1836217142;
        // ---------- Original Method ----------
        //return providerNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.316 -0400", hash_original_method = "6BFCD4E62487080CD7F60A29BC4CC43B", hash_generated_method = "F8298225742B7323EF1F093303E7C6E1")
    synchronized Provider.Service getService(String type) {
        updatePropertyServiceTable();
        if(lastServicesByType != null && type.equals(lastType))        
        {
Provider.Service varDE6AB80C9B01FF02BB70F0394329E4A1_1155455278 =             lastServicesByType;
            varDE6AB80C9B01FF02BB70F0394329E4A1_1155455278.addTaint(taint);
            return varDE6AB80C9B01FF02BB70F0394329E4A1_1155455278;
        } //End block
        Provider.Service service;
for(Iterator<Service> it = getServices().iterator();it.hasNext();)
        {
            service = it.next();
            if(type.equals(service.type))            
            {
                lastType = type;
                lastServicesByType = service;
Provider.Service var18881A382C668272945CA08D6E19E173_475358402 =                 service;
                var18881A382C668272945CA08D6E19E173_475358402.addTaint(taint);
                return var18881A382C668272945CA08D6E19E173_475358402;
            } //End block
        } //End block
Provider.Service var540C13E9E156B687226421B24F2DF178_6808040 =         null;
        var540C13E9E156B687226421B24F2DF178_6808040.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_6808040;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.318 -0400", hash_original_method = "6DABE02DE2A4DD1C36F9592BEF5E1C73", hash_generated_method = "C50F312B9644CA33D8784D86207EECBD")
    public synchronized Provider.Service getService(String type,
            String algorithm) {
        if(type == null || algorithm == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1235185503 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1235185503.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1235185503;
        } //End block
        if(type.equals(lastServiceName) && algorithm.equalsIgnoreCase(lastAlgorithm))        
        {
Provider.Service var3FAC47A7F66C9B2243E30C2F0FA5FC28_105302928 =             returnedService;
            var3FAC47A7F66C9B2243E30C2F0FA5FC28_105302928.addTaint(taint);
            return var3FAC47A7F66C9B2243E30C2F0FA5FC28_105302928;
        } //End block
        String alg = algorithm.toUpperCase(Locale.US);
        Object o = null;
        if(serviceTable != null)        
        {
            o = serviceTable.get(type, alg);
        } //End block
        if(o == null && aliasTable != null)        
        {
            o = aliasTable.get(type, alg);
        } //End block
        if(o == null)        
        {
            updatePropertyServiceTable();
        } //End block
        if(o == null && propertyServiceTable != null)        
        {
            o = propertyServiceTable.get(type, alg);
        } //End block
        if(o == null && propertyAliasTable != null)        
        {
            o = propertyAliasTable.get(type, alg);
        } //End block
        if(o != null)        
        {
            lastServiceName = type;
            lastAlgorithm = algorithm;
            returnedService = (Provider.Service) o;
Provider.Service var3FAC47A7F66C9B2243E30C2F0FA5FC28_987804131 =             returnedService;
            var3FAC47A7F66C9B2243E30C2F0FA5FC28_987804131.addTaint(taint);
            return var3FAC47A7F66C9B2243E30C2F0FA5FC28_987804131;
        } //End block
Provider.Service var540C13E9E156B687226421B24F2DF178_1948769733 =         null;
        var540C13E9E156B687226421B24F2DF178_1948769733.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1948769733;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.319 -0400", hash_original_method = "8008CDA805FE131E4E7ECE670E22E200", hash_generated_method = "B3FE8ECDB381DA951BB6BC0BCD7F30D3")
    public synchronized Set<Provider.Service> getServices() {
        updatePropertyServiceTable();
        if(lastServicesSet != null)        
        {
Set<Provider.Service> varABF821BB60DE39D2BC9A23B426D87819_746130318 =             lastServicesSet;
            varABF821BB60DE39D2BC9A23B426D87819_746130318.addTaint(taint);
            return varABF821BB60DE39D2BC9A23B426D87819_746130318;
        } //End block
        if(serviceTable != null)        
        {
            lastServicesSet = new HashSet<Service>(serviceTable.values());
        } //End block
        else
        {
            lastServicesSet = new HashSet<Service>();
        } //End block
        if(propertyServiceTable != null)        
        {
            lastServicesSet.addAll(propertyServiceTable.values());
        } //End block
        lastServicesSet = Collections.unmodifiableSet(lastServicesSet);
Set<Provider.Service> varABF821BB60DE39D2BC9A23B426D87819_1382128701 =         lastServicesSet;
        varABF821BB60DE39D2BC9A23B426D87819_1382128701.addTaint(taint);
        return varABF821BB60DE39D2BC9A23B426D87819_1382128701;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.319 -0400", hash_original_method = "3E5E06298B83C020AD9BCF69B9E3CE94", hash_generated_method = "42AE11C36E028A79907331C92F32982E")
    protected synchronized void putService(Provider.Service s) {
        addTaint(s.getTaint());
        if(s == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1777854461 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1777854461.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1777854461;
        } //End block
        if("Provider".equals(s.getType()))        
        {
            return;
        } //End block
        servicesChanged();
        if(serviceTable == null)        
        {
            serviceTable = new TwoKeyHashMap<String, String, Service>(128);
        } //End block
        serviceTable.put(s.type, s.algorithm.toUpperCase(Locale.US), s);
        if(s.aliases != null)        
        {
            if(aliasTable == null)            
            {
                aliasTable = new TwoKeyHashMap<String, String, Service>(256);
            } //End block
for(String alias : s.getAliases())
            {
                aliasTable.put(s.type, alias.toUpperCase(Locale.US), s);
            } //End block
        } //End block
        serviceInfoToProperties(s);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.320 -0400", hash_original_method = "D2521231A8F61254D866781010E5F7B6", hash_generated_method = "01AAEF002E6BFC6409D81CA500F7A725")
    protected synchronized void removeService(Provider.Service s) {
        addTaint(s.getTaint());
        if(s == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1763373598 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1763373598.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1763373598;
        } //End block
        servicesChanged();
        if(serviceTable != null)        
        {
            serviceTable.remove(s.type, s.algorithm.toUpperCase(Locale.US));
        } //End block
        if(aliasTable != null && s.aliases != null)        
        {
for(String alias : s.getAliases())
            {
                aliasTable.remove(s.type, alias.toUpperCase(Locale.US));
            } //End block
        } //End block
        serviceInfoFromProperties(s);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.320 -0400", hash_original_method = "FD9674DD64603638CEEAFAAECA2377E1", hash_generated_method = "757B8995BEDF8740FBDE08E0A781B786")
    private void serviceInfoToProperties(Provider.Service s) {
        addTaint(s.getTaint());
        super.put(s.type + "." + s.algorithm, s.className);
        if(s.aliases != null)        
        {
for(Iterator<String> i = s.aliases.iterator();i.hasNext();)
            {
                super.put("Alg.Alias." + s.type + "." + i.next(), s.algorithm);
            } //End block
        } //End block
        if(s.attributes != null)        
        {
for(Map.Entry<String, String> entry : s.attributes.entrySet())
            {
                super.put(s.type + "." + s.algorithm + " " + entry.getKey(),
                        entry.getValue());
            } //End block
        } //End block
        if(providerNumber != -1)        
        {
            Services.setNeedRefresh();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.320 -0400", hash_original_method = "E3342D080F10DDAA1FF9ED29EA29694F", hash_generated_method = "70FAE20E246FC72C24D52443F390DDA8")
    private void serviceInfoFromProperties(Provider.Service s) {
        addTaint(s.getTaint());
        super.remove(s.type + "." + s.algorithm);
        if(s.aliases != null)        
        {
for(Iterator<String> i = s.aliases.iterator();i.hasNext();)
            {
                super.remove("Alg.Alias." + s.type + "." + i.next());
            } //End block
        } //End block
        if(s.attributes != null)        
        {
for(Map.Entry<String, String> entry : s.attributes.entrySet())
            {
                super.remove(s.type + "." + s.algorithm + " " + entry.getKey());
            } //End block
        } //End block
        if(providerNumber != -1)        
        {
            Services.setNeedRefresh();
        } //End block
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.321 -0400", hash_original_method = "C88E49400116B5906A9CAC0E8D20528B", hash_generated_method = "2A8E7CFD229A5E53F7903E2AC18099A7")
    private void removeFromPropertyServiceTable(Object key) {
        addTaint(key.getTaint());
        if(key == null || !(key instanceof String))        
        {
            return;
        } //End block
        String k = (String) key;
        if(k.startsWith("Provider."))        
        {
            return;
        } //End block
        Provider.Service s;
        String serviceName;
        String algorithm = null;
        String attribute = null;
        int i;
        if(k.startsWith("Alg.Alias."))        
        {
            String aliasName;
            String service_alias = k.substring(10);
            i = service_alias.indexOf('.');
            serviceName = service_alias.substring(0, i);
            aliasName = service_alias.substring(i + 1);
            if(propertyAliasTable != null)            
            {
                propertyAliasTable.remove(serviceName, aliasName.toUpperCase(Locale.US));
            } //End block
            if(propertyServiceTable != null)            
            {
for(Iterator<Service> it = propertyServiceTable.values().iterator();it
                        .hasNext();)
                {
                    s = it.next();
                    if(s.aliases.contains(aliasName))                    
                    {
                        s.aliases.remove(aliasName);
                        return;
                    } //End block
                } //End block
            } //End block
            return;
        } //End block
        int j = k.indexOf('.');
        if(j == -1)        
        {
            return;
        } //End block
        i = k.indexOf(' ');
        if(i == -1)        
        {
            serviceName = k.substring(0, j);
            algorithm = k.substring(j + 1);
            if(propertyServiceTable != null)            
            {
                Provider.Service ser = propertyServiceTable.remove(serviceName,
                        algorithm.toUpperCase(Locale.US));
                if(ser != null && propertyAliasTable != null
                        && ser.aliases != null)                
                {
for(String alias : ser.aliases)
                    {
                        propertyAliasTable.remove(serviceName, alias.toUpperCase(Locale.US));
                    } //End block
                } //End block
            } //End block
        } //End block
        else
        {
            attribute = k.substring(i + 1);
            serviceName = k.substring(0, j);
            algorithm = k.substring(j + 1, i);
            if(propertyServiceTable != null)            
            {
                Object o = propertyServiceTable.get(serviceName, algorithm.toUpperCase(Locale.US));
                if(o != null)                
                {
                    s = (Provider.Service) o;
                    s.attributes.remove(attribute);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.324 -0400", hash_original_method = "C12B51396475B7F4EF23B74D619C33FD", hash_generated_method = "59A4818189A0EC8995B4F5535294CC25")
    private void updatePropertyServiceTable() {
        Object _key;
        Object _value;
        Provider.Service s;
        String serviceName;
        String algorithm;
        if(changedProperties == null || changedProperties.isEmpty())        
        {
            return;
        } //End block
for(Iterator<Map.Entry<Object, Object>> it = changedProperties.entrySet().iterator();it
                .hasNext();)
        {
            Map.Entry<Object, Object> entry = it.next();
            _key = entry.getKey();
            _value = entry.getValue();
            if(_key == null || _value == null || !(_key instanceof String)
                    || !(_value instanceof String))            
            {
                continue;
            } //End block
            String key = (String) _key;
            String value = (String) _value;
            if(key.startsWith("Provider"))            
            {
                continue;
            } //End block
            int i;
            if(key.startsWith("Alg.Alias."))            
            {
                String aliasName;
                String service_alias = key.substring(10);
                i = service_alias.indexOf('.');
                serviceName = service_alias.substring(0, i);
                aliasName = service_alias.substring(i + 1);
                algorithm = value;
                String algUp = algorithm.toUpperCase(Locale.US);
                Object o = null;
                if(propertyServiceTable == null)                
                {
                    propertyServiceTable = new TwoKeyHashMap<String, String, Service>(128);
                } //End block
                else
                {
                    o = propertyServiceTable.get(serviceName, algUp);
                } //End block
                if(o != null)                
                {
                    s = (Provider.Service) o;
                    s.addAlias(aliasName);
                    if(propertyAliasTable == null)                    
                    {
                        propertyAliasTable = new TwoKeyHashMap<String, String, Service>(256);
                    } //End block
                    propertyAliasTable.put(serviceName, aliasName.toUpperCase(Locale.US), s);
                } //End block
                else
                {
                    String className = (String) changedProperties
                            .get(serviceName + "." + algorithm);
                    if(className != null)                    
                    {
                        List<String> l = new ArrayList<String>();
                        l.add(aliasName);
                        s = new Provider.Service(this, serviceName, algorithm,
                                className, l, new HashMap<String, String>());
                        propertyServiceTable.put(serviceName, algUp, s);
                        if(propertyAliasTable == null)                        
                        {
                            propertyAliasTable = new TwoKeyHashMap<String, String, Service>(256);
                        } //End block
                        propertyAliasTable.put(serviceName, aliasName.toUpperCase(Locale.US), s);
                    } //End block
                } //End block
                continue;
            } //End block
            int j = key.indexOf('.');
            if(j == -1)            
            {
                continue;
            } //End block
            i = key.indexOf(' ');
            if(i == -1)            
            {
                serviceName = key.substring(0, j);
                algorithm = key.substring(j + 1);
                String alg = algorithm.toUpperCase(Locale.US);
                Object o = null;
                if(propertyServiceTable != null)                
                {
                    o = propertyServiceTable.get(serviceName, alg);
                } //End block
                if(o != null)                
                {
                    s = (Provider.Service) o;
                    s.className = value;
                } //End block
                else
                {
                    s = new Provider.Service(this, serviceName, algorithm,
                            value, Collections.<String>emptyList(),
                            Collections.<String,String>emptyMap());
                    if(propertyServiceTable == null)                    
                    {
                        propertyServiceTable = new TwoKeyHashMap<String, String, Service>(128);
                    } //End block
                    propertyServiceTable.put(serviceName, alg, s);
                } //End block
            } //End block
            else
            {
                serviceName = key.substring(0, j);
                algorithm = key.substring(j + 1, i);
                String attribute = key.substring(i + 1);
                String alg = algorithm.toUpperCase(Locale.US);
                Object o = null;
                if(propertyServiceTable != null)                
                {
                    o = propertyServiceTable.get(serviceName, alg);
                } //End block
                if(o != null)                
                {
                    s = (Provider.Service) o;
                    s.putAttribute(attribute, value);
                } //End block
                else
                {
                    String className = (String) changedProperties
                            .get(serviceName + "." + algorithm);
                    if(className != null)                    
                    {
                        Map<String, String> m = new HashMap<String, String>();
                        m.put(attribute, value);
                        s = new Provider.Service(this, serviceName, algorithm,
                                className, new ArrayList<String>(), m);
                        if(propertyServiceTable == null)                        
                        {
                            propertyServiceTable = new TwoKeyHashMap<String, String, Service>(128);
                        } //End block
                        propertyServiceTable.put(serviceName, alg, s);
                    } //End block
                } //End block
            } //End block
        } //End block
        servicesChanged();
        changedProperties = null;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.325 -0400", hash_original_method = "FD7619437CD0960F1AEBA32A154F0328", hash_generated_method = "9C6A342A2081A7D73BA214C115FEC8EA")
    private void servicesChanged() {
        lastServicesByType = null;
        lastServiceName = null;
        lastServicesSet = null;
        // ---------- Original Method ----------
        //lastServicesByType = null;
        //lastServiceName = null;
        //lastServicesSet = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.325 -0400", hash_original_method = "768CFC89B63FD1F782E3758D2BCFC6C0", hash_generated_method = "BEA2C42DB158CE6C3270D65A149F3B2E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.325 -0400", hash_original_method = "62DD35352FE8FA7B38C17798ED376C47", hash_generated_method = "8591E84DAC78F9C06F298E8D51CB4675")
    private String getPropertyIgnoreCase(String key) {
        addTaint(key.getTaint());
        String res = getProperty(key);
        if(res != null)        
        {
String varB5053E025797B3BF768F5C37934C244D_614365811 =             res;
            varB5053E025797B3BF768F5C37934C244D_614365811.addTaint(taint);
            return varB5053E025797B3BF768F5C37934C244D_614365811;
        } //End block
for(Enumeration<?> e = propertyNames();e.hasMoreElements();)
        {
            String propertyName = (String) e.nextElement();
            if(key.equalsIgnoreCase(propertyName))            
            {
String varA461F56DE9B992995E45656BBAF6D5D9_1562369417 =                 getProperty(propertyName);
                varA461F56DE9B992995E45656BBAF6D5D9_1562369417.addTaint(taint);
                return varA461F56DE9B992995E45656BBAF6D5D9_1562369417;
            } //End block
        } //End block
String var540C13E9E156B687226421B24F2DF178_614732304 =         null;
        var540C13E9E156B687226421B24F2DF178_614732304.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_614732304;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.326 -0400", hash_original_method = "C9BE26B06AA230EA20C77B7F366C53C8", hash_generated_method = "C349757B0405244ECF57CED8F47A32D0")
    private void readObject(java.io.ObjectInputStream in) throws NotActiveException, IOException, ClassNotFoundException {
        addTaint(in.getTaint());
        in.defaultReadObject();
        versionString = String.valueOf(version);
        providerNumber = -1;
        // ---------- Original Method ----------
        //in.defaultReadObject();
        //versionString = String.valueOf(version);
        //providerNumber = -1;
    }

    
    public static class Service {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.326 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

        private Provider provider;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.326 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

        private String type;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.326 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

        private String algorithm;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.326 -0400", hash_original_field = "6F66E878C62DB60568A3487869695820", hash_generated_field = "B28341EF6B88AA3CAD2D37FF14C9DC00")

        private String className;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.326 -0400", hash_original_field = "9299DA2529C98FCCCE0E32B476BA3266", hash_generated_field = "7D96162B1AE01DA7357D6662D8D2C584")

        private List<String> aliases;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.326 -0400", hash_original_field = "736B91750E516139ACC13C5EB6564F92", hash_generated_field = "1CEAC23D4A656E23182C27FC3A78AEDE")

        private Map<String,String> attributes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.326 -0400", hash_original_field = "B6FA15360B4CDCE4806BF9A0580C8F0F", hash_generated_field = "28101B8550628F94A8DDB23FAF399E56")

        private Class<?> implementation;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.326 -0400", hash_original_field = "77FDFBF3D811B72BC9BBBE747A722F58", hash_generated_field = "668E14A773F053D0B44156BD480B724E")

        private String lastClassName;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.327 -0400", hash_original_method = "82CB06DCD943152835D64FFE915BA566", hash_generated_method = "29ABF79400E199F7C692BE7C5B76BE97")
        public  Service(Provider provider, String type, String algorithm,
                String className, List<String> aliases, Map<String, String> attributes) {
            if(provider == null || type == null || algorithm == null
                    || className == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_466188067 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_466188067.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_466188067;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.328 -0400", hash_original_method = "4CA8000463C36260BD9C3E4A41E197CE", hash_generated_method = "CF0BA3367A87E1DE3BEDC49227B27E26")
         void addAlias(String alias) {
            addTaint(alias.getTaint());
            if((aliases == null) || (aliases.size() == 0))            
            {
                aliases = new ArrayList<String>();
            } //End block
            aliases.add(alias);
            // ---------- Original Method ----------
            //if ((aliases == null) || (aliases.size() == 0)) {
                //aliases = new ArrayList<String>();
            //}
            //aliases.add(alias);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.328 -0400", hash_original_method = "2623207C72797F9950DF9980B680F416", hash_generated_method = "718DEF75A5DE09EB088C9329DCEC13C8")
         void putAttribute(String name, String value) {
            addTaint(value.getTaint());
            addTaint(name.getTaint());
            if((attributes == null) || (attributes.size() == 0))            
            {
                attributes = new HashMap<String,String>();
            } //End block
            attributes.put(name, value);
            // ---------- Original Method ----------
            //if ((attributes == null) || (attributes.size() == 0)) {
                //attributes = new HashMap<String,String>();
            //}
            //attributes.put(name, value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.328 -0400", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "55C2F72DB88F35E1C8A58C64BE8FC6BF")
        public final String getType() {
String varC5B9F25B4EEAD3E8E2C33F9429204397_500193164 =             type;
            varC5B9F25B4EEAD3E8E2C33F9429204397_500193164.addTaint(taint);
            return varC5B9F25B4EEAD3E8E2C33F9429204397_500193164;
            // ---------- Original Method ----------
            //return type;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.328 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "122BA87087EF36BC4629AEE0BDD7F8D5")
        public final String getAlgorithm() {
String var44A46B4003FC81ACB0223385BA1FA818_989127464 =             algorithm;
            var44A46B4003FC81ACB0223385BA1FA818_989127464.addTaint(taint);
            return var44A46B4003FC81ACB0223385BA1FA818_989127464;
            // ---------- Original Method ----------
            //return algorithm;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.328 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "E15F8E0D6765959A1235D9EA2981F60D")
        public final Provider getProvider() {
Provider varC1EB7B12CCABB27D431E5B91E5FF9ECB_1001293568 =             provider;
            varC1EB7B12CCABB27D431E5B91E5FF9ECB_1001293568.addTaint(taint);
            return varC1EB7B12CCABB27D431E5B91E5FF9ECB_1001293568;
            // ---------- Original Method ----------
            //return provider;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.328 -0400", hash_original_method = "8415940D3A1E5651F883E391EC68DA41", hash_generated_method = "0CA6FCDFBABF593DF39A45DD65C36AFB")
        public final String getClassName() {
String varF57DF2C3C72C0BA8574176BD3A4AA127_1334609813 =             className;
            varF57DF2C3C72C0BA8574176BD3A4AA127_1334609813.addTaint(taint);
            return varF57DF2C3C72C0BA8574176BD3A4AA127_1334609813;
            // ---------- Original Method ----------
            //return className;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.329 -0400", hash_original_method = "0C10317D01C11D1034B9356679E58CA0", hash_generated_method = "4D6A2BB48A00B3A6E3F4B2CC433A1DBD")
        public final String getAttribute(String name) {
            addTaint(name.getTaint());
            if(name == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_617158373 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_617158373.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_617158373;
            } //End block
            if(attributes == null)            
            {
String var540C13E9E156B687226421B24F2DF178_1347443246 =                 null;
                var540C13E9E156B687226421B24F2DF178_1347443246.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1347443246;
            } //End block
String var0FC38B75002B91F7AC64538254F3139B_206780135 =             attributes.get(name);
            var0FC38B75002B91F7AC64538254F3139B_206780135.addTaint(taint);
            return var0FC38B75002B91F7AC64538254F3139B_206780135;
            // ---------- Original Method ----------
            //if (name == null) {
                //throw new NullPointerException();
            //}
            //if (attributes == null) {
                //return null;
            //}
            //return attributes.get(name);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.329 -0400", hash_original_method = "7A6F8F40D5019A1C644CF7CAD3518923", hash_generated_method = "87785EE830BF7F1CA50CA12624CA6A5A")
         List<String> getAliases() {
            if(aliases == null)            
            {
                aliases = new ArrayList<String>(0);
            } //End block
List<String> varC4595C5D23CE6BCE27277A7A63A8884D_1910564076 =             aliases;
            varC4595C5D23CE6BCE27277A7A63A8884D_1910564076.addTaint(taint);
            return varC4595C5D23CE6BCE27277A7A63A8884D_1910564076;
            // ---------- Original Method ----------
            //if (aliases == null){
                //aliases = new ArrayList<String>(0);
            //}
            //return aliases;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.330 -0400", hash_original_method = "802A5A00EF15D2BF7FB674CB175B5DD7", hash_generated_method = "9C7D8A6FC7C6293BC68FB66EC6DF8384")
        public Object newInstance(Object constructorParameter) throws NoSuchAlgorithmException {
            addTaint(constructorParameter.getTaint());
            if(implementation == null || !className.equals(lastClassName))            
            {
                ClassLoader cl = provider.getClass().getClassLoader();
                if(cl == null)                
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
                    NoSuchAlgorithmException var340B962BBAFCC29E2FBF0C494BA22619_561089721 = new NoSuchAlgorithmException(type + " " + algorithm + " implementation not found: " + e);
                    var340B962BBAFCC29E2FBF0C494BA22619_561089721.addTaint(taint);
                    throw var340B962BBAFCC29E2FBF0C494BA22619_561089721;
                } //End block
            } //End block
            if(constructorParameter == null)            
            {
                try 
                {
Object varA51B251B917C25E5A6F890FEB4DA82F6_319897591 =                     implementation.newInstance();
                    varA51B251B917C25E5A6F890FEB4DA82F6_319897591.addTaint(taint);
                    return varA51B251B917C25E5A6F890FEB4DA82F6_319897591;
                } //End block
                catch (Exception e)
                {
                    NoSuchAlgorithmException varFE975696FAAC863E4BFAD89E5739D05E_438694616 = new NoSuchAlgorithmException(
                            type + " " + algorithm + " implementation not found", e);
                    varFE975696FAAC863E4BFAD89E5739D05E_438694616.addTaint(taint);
                    throw varFE975696FAAC863E4BFAD89E5739D05E_438694616;
                } //End block
            } //End block
            if(!supportsParameter(constructorParameter))            
            {
                InvalidParameterException varF9889E1B91A376ADDF2ACA65983F9F24_821451344 = new InvalidParameterException(type + ": service cannot use the parameter");
                varF9889E1B91A376ADDF2ACA65983F9F24_821451344.addTaint(taint);
                throw varF9889E1B91A376ADDF2ACA65983F9F24_821451344;
            } //End block
            Class[] parameterTypes = new Class[1];
            Object[] initargs = { constructorParameter };
            try 
            {
                if(type.equalsIgnoreCase("CertStore"))                
                {
                    parameterTypes[0] = Class.forName("java.security.cert.CertStoreParameters");
                } //End block
                else
                {
                    parameterTypes[0] = constructorParameter.getClass();
                } //End block
Object var6688C2BA9FE406E726A7A7FF4A097B4F_670758757 =                 implementation.getConstructor(parameterTypes)
                        .newInstance(initargs);
                var6688C2BA9FE406E726A7A7FF4A097B4F_670758757.addTaint(taint);
                return var6688C2BA9FE406E726A7A7FF4A097B4F_670758757;
            } //End block
            catch (Exception e)
            {
                NoSuchAlgorithmException varFE975696FAAC863E4BFAD89E5739D05E_1235531354 = new NoSuchAlgorithmException(type + " " + algorithm
                        + " implementation not found", e);
                varFE975696FAAC863E4BFAD89E5739D05E_1235531354.addTaint(taint);
                throw varFE975696FAAC863E4BFAD89E5739D05E_1235531354;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.330 -0400", hash_original_method = "A158C77880B526D8A49B8720A1D647AC", hash_generated_method = "385ED1D2F504DB75CD53928FBC6B1586")
        public boolean supportsParameter(Object parameter) {
            addTaint(parameter.getTaint());
            boolean varB326B5062B2F0E69046810717534CB09_1942353980 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1334034267 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1334034267;
            // ---------- Original Method ----------
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.331 -0400", hash_original_method = "CD20F19EDED4066F9FA28FD55133940E", hash_generated_method = "73B1DE17C1B7C599513FBFB950C242B3")
        @Override
        public String toString() {
            String result = "Provider " + provider.getName() + " Service "
                    + type + "." + algorithm + " " + className;
            if(aliases != null)            
            {
                result = result + "\nAliases " + aliases.toString();
            } //End block
            if(attributes != null)            
            {
                result = result + "\nAttributes " + attributes.toString();
            } //End block
String varDC838461EE2FA0CA4C9BBB70A15456B0_1868765986 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_1868765986.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1868765986;
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.331 -0400", hash_original_field = "7CC76EFC2B264F3D1AA5774D56F0CEA6", hash_generated_field = "6AA3DBE008BE39E45A084DC1795F57FB")

    private static final long serialVersionUID = -4298000515446427739L;
}

