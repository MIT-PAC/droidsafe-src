package java.security;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.324 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.324 -0400", hash_original_field = "2AF72F100C356273D46284F6FD1DFC08", hash_generated_field = "F3CA80FC5F7B3B542DC8B1C8FD91731C")

    private double version;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.324 -0400", hash_original_field = "239623964829E21A6BEC8B51CD66FB1E", hash_generated_field = "AEF8D804C6A6E39F2A136B97DEDD88CA")

    private transient String versionString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.324 -0400", hash_original_field = "CAF9B6B99962BF5C2264824231D7A40C", hash_generated_field = "1F50CB615F8F0AB19DCF28D9BAFF4DD4")

    private String info;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.324 -0400", hash_original_field = "426DF410C50A922A7FCCB45E28CFB99B", hash_generated_field = "3D346C5395708831B6A443E01975CD82")

    private transient int providerNumber = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.324 -0400", hash_original_field = "90D27D782F6C6A467A120DC0EA3CABA4", hash_generated_field = "D2A7F737A7D1793E39403AC0C5DE42B9")

    private transient TwoKeyHashMap<String, String, Service> serviceTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.325 -0400", hash_original_field = "C8290F032C183B62C8206C67F6F9691A", hash_generated_field = "B06FB286EE00C306B86D2F80CC057271")

    private transient TwoKeyHashMap<String, String, Service> aliasTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.325 -0400", hash_original_field = "51EA4BA55D4773B26DE32A2D9219C113", hash_generated_field = "974CEA24FA2B0A232602FB5D7E8DE337")

    private transient TwoKeyHashMap<String, String, Service> propertyServiceTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.325 -0400", hash_original_field = "0C259300D051D5E7246B301C0DD26E65", hash_generated_field = "496EDC5FF7DCB745D06FD58901D71D88")

    private transient TwoKeyHashMap<String, String, Service> propertyAliasTable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.325 -0400", hash_original_field = "2157E7B4176C83B64377DBFE7F76F07E", hash_generated_field = "8BBAB31DBAA82BF49B07B5E12D0CF85B")

    private transient Properties changedProperties;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.325 -0400", hash_original_field = "3124884BBCB44722A70DEA4CA0A5EEDF", hash_generated_field = "78CA56FA7454490EF4843EE66CC1589B")

    private transient Provider.Service returnedService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.325 -0400", hash_original_field = "608855017360FBF6AA459F927179D0DF", hash_generated_field = "A17CE05D31CA338777E2E3315B0B2BB2")

    private transient String lastAlgorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.325 -0400", hash_original_field = "201DB549B9B6C1D90243C19553DE6893", hash_generated_field = "26FDBDCE6D172CC943C76DDD3CE0C4F1")

    private transient String lastServiceName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.325 -0400", hash_original_field = "79C5FB5C2352B93E380EDFDC155D6452", hash_generated_field = "BA27D1D25E16A8C025C9D2F64E31C9C5")

    private transient Set<Service> lastServicesSet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.325 -0400", hash_original_field = "AF709187F08859A6E70DA4496782164A", hash_generated_field = "3F98FC0FC213ABB6A1D68A8492E264D1")

    private transient String lastType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.326 -0400", hash_original_field = "C51F06888C4D2B6BFD3C97C9199539C4", hash_generated_field = "734DC09FAD571851B677CBD6C2E18D22")

    private transient Provider.Service lastServicesByType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.327 -0400", hash_original_method = "CD3EC30E89504BC69886C014A5CD7A7E", hash_generated_method = "C4D627FD8EDE0CA93E2598F924F902BC")
    protected  Provider(String name, double version, String info) {
        this.name = name;
        this.version = version;
        this.info = info;
        versionString = String.valueOf(version);
        putProviderInfo();
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.328 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "789D32E6E27F738CA308B82475BF3030")
    public String getName() {
String varB017984728AC60AD1F0BF8734F33F15C_40123290 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_40123290.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_40123290;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.328 -0400", hash_original_method = "849DADC9512AC29CFF5A5EB4D1517425", hash_generated_method = "8DF60A22786C52A6717A39A02D8A8AF4")
    public double getVersion() {
        double var2AF72F100C356273D46284F6FD1DFC08_929000179 = (version);
                double varE8CD7DA078A86726031AD64F35F5A6C0_554422004 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_554422004;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.329 -0400", hash_original_method = "90F1C2C1B854E8544A3CF05D4B3BD6E7", hash_generated_method = "F42F7844B88B4A36F48B8E042DE87ECE")
    public String getInfo() {
String var43CF3338FDBA93597A9562D3166E9DC4_1159343604 =         info;
        var43CF3338FDBA93597A9562D3166E9DC4_1159343604.addTaint(taint);
        return var43CF3338FDBA93597A9562D3166E9DC4_1159343604;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.329 -0400", hash_original_method = "58EC0A1A07497E3FA377B5366380E5E3", hash_generated_method = "354CEFEB8346EDE28DC37E36302BBD5A")
    @Override
    public String toString() {
String var50E90DE824F2DD490679392189EDA33C_618753076 =         name + " version " + version;
        var50E90DE824F2DD490679392189EDA33C_618753076.addTaint(taint);
        return var50E90DE824F2DD490679392189EDA33C_618753076;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.330 -0400", hash_original_method = "53793BFB01C9C5B2BDDE9F63C2E38535", hash_generated_method = "51F2BDED737F22F77F16FE87E2A29BF1")
    @Override
    public synchronized void clear() {
        super.clear();
    if(serviceTable != null)        
        {
            serviceTable.clear();
        } 
    if(propertyServiceTable != null)        
        {
            propertyServiceTable.clear();
        } 
    if(aliasTable != null)        
        {
            aliasTable.clear();
        } 
    if(propertyAliasTable != null)        
        {
            propertyAliasTable.clear();
        } 
        changedProperties = null;
        putProviderInfo();
    if(providerNumber != -1)        
        {
            Services.setNeedRefresh();
        } 
        servicesChanged();
        
        
        
            
        
        
            
        
        
            
        
        
            
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.330 -0400", hash_original_method = "EB6BD048CAF9E12CFD99EC1891725291", hash_generated_method = "0CDD80B9CC8CC73B60130FCD06F2D900")
    @Override
    public synchronized void load(InputStream inStream) throws IOException {
        addTaint(inStream.getTaint());
        Properties tmp = new Properties();
        tmp.load(inStream);
        myPutAll(tmp);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.331 -0400", hash_original_method = "CE4C2613BF29D966F3F961299EB30975", hash_generated_method = "FF14B13433ABABBF0B387A5998853671")
    @Override
    public synchronized void putAll(Map<?,?> t) {
        addTaint(t.getTaint());
        myPutAll(t);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.332 -0400", hash_original_method = "F898BA9F30F0CED7EAABA59AE5C4F6F9", hash_generated_method = "B048ACB4D9B7591C5029ED46774097C6")
    private void myPutAll(Map<?,?> t) {
        addTaint(t.getTaint());
    if(changedProperties == null)        
        {
            changedProperties = new Properties();
        } 
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
            } 
            value = entry.getValue();
            super.put(key, value);
    if(changedProperties.remove(key) == null)            
            {
                removeFromPropertyServiceTable(key);
            } 
            changedProperties.put(key, value);
        } 
    if(providerNumber != -1)        
        {
            Services.setNeedRefresh();
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.332 -0400", hash_original_method = "70D9A28808783B7E2708BCE915ECB209", hash_generated_method = "62AF018044E9CF7B46A19FA4E9D3E0AA")
    @Override
    public synchronized Set<Map.Entry<Object,Object>> entrySet() {
Set<Map.Entry<Object,Object>> varD57B937898B8DAAF433086023CDE0FFC_1089969298 =         Collections.unmodifiableSet(super.entrySet());
        varD57B937898B8DAAF433086023CDE0FFC_1089969298.addTaint(taint);
        return varD57B937898B8DAAF433086023CDE0FFC_1089969298;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.332 -0400", hash_original_method = "45BA03BABBCEC97C3CDEDDFAAD34C546", hash_generated_method = "31D1239FF3B161BCD61E84BB5CC99C2B")
    @Override
    public Set<Object> keySet() {
Set<Object> varC576E95CEF2DB749DB3850658FFE6F1C_1804142262 =         Collections.unmodifiableSet(super.keySet());
        varC576E95CEF2DB749DB3850658FFE6F1C_1804142262.addTaint(taint);
        return varC576E95CEF2DB749DB3850658FFE6F1C_1804142262;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.333 -0400", hash_original_method = "4FF8F6E11AAD8FB860F173913A5840CE", hash_generated_method = "C21CFC76AD5A1DFE06BC83D7CB4DA716")
    @Override
    public Collection<Object> values() {
Collection<Object> varF31BFB95E4035986BE22A02616A5652D_331998560 =         Collections.unmodifiableCollection(super.values());
        varF31BFB95E4035986BE22A02616A5652D_331998560.addTaint(taint);
        return varF31BFB95E4035986BE22A02616A5652D_331998560;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.334 -0400", hash_original_method = "6B0BAE35C6955DE6DEF5897424A78326", hash_generated_method = "BC67EC2C3BD2C1E580CC1F0C6A09643A")
    @Override
    public synchronized Object put(Object key, Object value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
    if(key instanceof String && ((String) key).startsWith("Provider."))        
        {
Object var540C13E9E156B687226421B24F2DF178_1856509490 =             null;
            var540C13E9E156B687226421B24F2DF178_1856509490.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1856509490;
        } 
    if(providerNumber != -1)        
        {
            Services.setNeedRefresh();
        } 
    if(changedProperties != null && changedProperties.remove(key) == null)        
        {
            removeFromPropertyServiceTable(key);
        } 
    if(changedProperties == null)        
        {
            changedProperties = new Properties();
        } 
        changedProperties.put(key, value);
Object var34EAB73DB44693D365A6742CBB445BED_938195428 =         super.put(key, value);
        var34EAB73DB44693D365A6742CBB445BED_938195428.addTaint(taint);
        return var34EAB73DB44693D365A6742CBB445BED_938195428;
        
        
            
        
        
            
        
        
            
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.335 -0400", hash_original_method = "8EA23C4ABA882E49A95AE531F4BFEB20", hash_generated_method = "EEF1804264A3650EDC306034F693BD91")
    @Override
    public synchronized Object remove(Object key) {
        addTaint(key.getTaint());
    if(key instanceof String && ((String) key).startsWith("Provider."))        
        {
Object var540C13E9E156B687226421B24F2DF178_818420744 =             null;
            var540C13E9E156B687226421B24F2DF178_818420744.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_818420744;
        } 
    if(providerNumber != -1)        
        {
            Services.setNeedRefresh();
        } 
    if(changedProperties != null && changedProperties.remove(key) == null)        
        {
            removeFromPropertyServiceTable(key);
    if(changedProperties.size() == 0)            
            {
                changedProperties = null;
            } 
        } 
Object varBACBF699252AC3FDC76153D632679B1D_944125132 =         super.remove(key);
        varBACBF699252AC3FDC76153D632679B1D_944125132.addTaint(taint);
        return varBACBF699252AC3FDC76153D632679B1D_944125132;
        
        
            
        
        
            
        
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.336 -0400", hash_original_method = "73ADEB588A693290C2EBE420EE1B60DD", hash_generated_method = "D908BEC46715C96AFB7B5705E426BF8B")
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
            } 
        } 
    if(prop != null)        
        {
    if(attribute == null)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1019494129 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_812050180 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_812050180;
            } 
            boolean var780F01F84340806DE300DADF194ECA40_1968617336 = (checkAttribute(servAlg, attribute, val));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_841821543 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_841821543;
        } 
        boolean var68934A3E9455FA72420237EB05902327_106162976 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1253054899 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1253054899;
        
        
        
        
            
            
                
                
            
        
        
            
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.337 -0400", hash_original_method = "205FEBDC4595F3CAF3DB8C26A01A3B21", hash_generated_method = "03B8DEFC43AF409045C48066018B5E40")
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
                    boolean varB326B5062B2F0E69046810717534CB09_436478825 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1775723868 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1775723868;
                } 
            } 
            else
            {
    if(attributeValue.equalsIgnoreCase(val))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_63963792 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1173846336 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1173846336;
                } 
            } 
        } 
        boolean var68934A3E9455FA72420237EB05902327_1461948615 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2112013440 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2112013440;
        
        
        
            
                
                    
                
            
                
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.338 -0400", hash_original_method = "6418C82159D4FAB251CB16B6C408D61D", hash_generated_method = "BA9FDE46C0F8402C6FB4936CC36C7FAA")
     void setProviderNumber(int n) {
        providerNumber = n;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.338 -0400", hash_original_method = "6209D7B36FBC76163C52BAAF1CE53C35", hash_generated_method = "45ED5B722FA7588009D882CC6D8E6E67")
     int getProviderNumber() {
        int varBC53644233DA12363BC91D331C131157_1283667977 = (providerNumber);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_718909934 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_718909934;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.339 -0400", hash_original_method = "6BFCD4E62487080CD7F60A29BC4CC43B", hash_generated_method = "8FE913D5B154696849FC8D077D3C0405")
    synchronized Provider.Service getService(String type) {
        updatePropertyServiceTable();
    if(lastServicesByType != null && type.equals(lastType))        
        {
Provider.Service varDE6AB80C9B01FF02BB70F0394329E4A1_811349301 =             lastServicesByType;
            varDE6AB80C9B01FF02BB70F0394329E4A1_811349301.addTaint(taint);
            return varDE6AB80C9B01FF02BB70F0394329E4A1_811349301;
        } 
        Provider.Service service;
for(Iterator<Service> it = getServices().iterator();it.hasNext();)
        {
            service = it.next();
    if(type.equals(service.type))            
            {
                lastType = type;
                lastServicesByType = service;
Provider.Service var18881A382C668272945CA08D6E19E173_503835754 =                 service;
                var18881A382C668272945CA08D6E19E173_503835754.addTaint(taint);
                return var18881A382C668272945CA08D6E19E173_503835754;
            } 
        } 
Provider.Service var540C13E9E156B687226421B24F2DF178_1453226377 =         null;
        var540C13E9E156B687226421B24F2DF178_1453226377.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1453226377;
        
        
        
            
        
        
        
            
            
                
                
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.340 -0400", hash_original_method = "6DABE02DE2A4DD1C36F9592BEF5E1C73", hash_generated_method = "FB17ADFF302A186CD8B10FC038227CAE")
    public synchronized Provider.Service getService(String type,
            String algorithm) {
    if(type == null || algorithm == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_633185419 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_633185419.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_633185419;
        } 
    if(type.equals(lastServiceName) && algorithm.equalsIgnoreCase(lastAlgorithm))        
        {
Provider.Service var3FAC47A7F66C9B2243E30C2F0FA5FC28_1013080195 =             returnedService;
            var3FAC47A7F66C9B2243E30C2F0FA5FC28_1013080195.addTaint(taint);
            return var3FAC47A7F66C9B2243E30C2F0FA5FC28_1013080195;
        } 
        String alg = algorithm.toUpperCase(Locale.US);
        Object o = null;
    if(serviceTable != null)        
        {
            o = serviceTable.get(type, alg);
        } 
    if(o == null && aliasTable != null)        
        {
            o = aliasTable.get(type, alg);
        } 
    if(o == null)        
        {
            updatePropertyServiceTable();
        } 
    if(o == null && propertyServiceTable != null)        
        {
            o = propertyServiceTable.get(type, alg);
        } 
    if(o == null && propertyAliasTable != null)        
        {
            o = propertyAliasTable.get(type, alg);
        } 
    if(o != null)        
        {
            lastServiceName = type;
            lastAlgorithm = algorithm;
            returnedService = (Provider.Service) o;
Provider.Service var3FAC47A7F66C9B2243E30C2F0FA5FC28_1828929265 =             returnedService;
            var3FAC47A7F66C9B2243E30C2F0FA5FC28_1828929265.addTaint(taint);
            return var3FAC47A7F66C9B2243E30C2F0FA5FC28_1828929265;
        } 
Provider.Service var540C13E9E156B687226421B24F2DF178_1898160129 =         null;
        var540C13E9E156B687226421B24F2DF178_1898160129.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1898160129;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.342 -0400", hash_original_method = "8008CDA805FE131E4E7ECE670E22E200", hash_generated_method = "F6689EFDD3204A105D758D904FCEE500")
    public synchronized Set<Provider.Service> getServices() {
        updatePropertyServiceTable();
    if(lastServicesSet != null)        
        {
Set<Provider.Service> varABF821BB60DE39D2BC9A23B426D87819_1853880284 =             lastServicesSet;
            varABF821BB60DE39D2BC9A23B426D87819_1853880284.addTaint(taint);
            return varABF821BB60DE39D2BC9A23B426D87819_1853880284;
        } 
    if(serviceTable != null)        
        {
            lastServicesSet = new HashSet<Service>(serviceTable.values());
        } 
        else
        {
            lastServicesSet = new HashSet<Service>();
        } 
    if(propertyServiceTable != null)        
        {
            lastServicesSet.addAll(propertyServiceTable.values());
        } 
        lastServicesSet = Collections.unmodifiableSet(lastServicesSet);
Set<Provider.Service> varABF821BB60DE39D2BC9A23B426D87819_399623806 =         lastServicesSet;
        varABF821BB60DE39D2BC9A23B426D87819_399623806.addTaint(taint);
        return varABF821BB60DE39D2BC9A23B426D87819_399623806;
        
        
        
            
        
        
            
        
            
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.343 -0400", hash_original_method = "3E5E06298B83C020AD9BCF69B9E3CE94", hash_generated_method = "1FDBCF22C595D3CA4C51BA60CCD0E781")
    protected synchronized void putService(Provider.Service s) {
        addTaint(s.getTaint());
    if(s == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1811231586 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1811231586.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1811231586;
        } 
    if("Provider".equals(s.getType()))        
        {
            return;
        } 
        servicesChanged();
    if(serviceTable == null)        
        {
            serviceTable = new TwoKeyHashMap<String, String, Service>(128);
        } 
        serviceTable.put(s.type, s.algorithm.toUpperCase(Locale.US), s);
    if(s.aliases != null)        
        {
    if(aliasTable == null)            
            {
                aliasTable = new TwoKeyHashMap<String, String, Service>(256);
            } 
for(String alias : s.getAliases())
            {
                aliasTable.put(s.type, alias.toUpperCase(Locale.US), s);
            } 
        } 
        serviceInfoToProperties(s);
        
        
            
        
        
            
        
        
        
            
        
        
        
            
                
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.343 -0400", hash_original_method = "D2521231A8F61254D866781010E5F7B6", hash_generated_method = "6D813F1438A101E68E5B3B97006D754E")
    protected synchronized void removeService(Provider.Service s) {
        addTaint(s.getTaint());
    if(s == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_2066518105 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_2066518105.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_2066518105;
        } 
        servicesChanged();
    if(serviceTable != null)        
        {
            serviceTable.remove(s.type, s.algorithm.toUpperCase(Locale.US));
        } 
    if(aliasTable != null && s.aliases != null)        
        {
for(String alias : s.getAliases())
            {
                aliasTable.remove(s.type, alias.toUpperCase(Locale.US));
            } 
        } 
        serviceInfoFromProperties(s);
        
        
            
        
        
        
            
        
        
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.344 -0400", hash_original_method = "FD9674DD64603638CEEAFAAECA2377E1", hash_generated_method = "757B8995BEDF8740FBDE08E0A781B786")
    private void serviceInfoToProperties(Provider.Service s) {
        addTaint(s.getTaint());
        super.put(s.type + "." + s.algorithm, s.className);
    if(s.aliases != null)        
        {
for(Iterator<String> i = s.aliases.iterator();i.hasNext();)
            {
                super.put("Alg.Alias." + s.type + "." + i.next(), s.algorithm);
            } 
        } 
    if(s.attributes != null)        
        {
for(Map.Entry<String, String> entry : s.attributes.entrySet())
            {
                super.put(s.type + "." + s.algorithm + " " + entry.getKey(),
                        entry.getValue());
            } 
        } 
    if(providerNumber != -1)        
        {
            Services.setNeedRefresh();
        } 
        
        
        
            
                
            
        
        
            
                
                        
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.345 -0400", hash_original_method = "E3342D080F10DDAA1FF9ED29EA29694F", hash_generated_method = "70FAE20E246FC72C24D52443F390DDA8")
    private void serviceInfoFromProperties(Provider.Service s) {
        addTaint(s.getTaint());
        super.remove(s.type + "." + s.algorithm);
    if(s.aliases != null)        
        {
for(Iterator<String> i = s.aliases.iterator();i.hasNext();)
            {
                super.remove("Alg.Alias." + s.type + "." + i.next());
            } 
        } 
    if(s.attributes != null)        
        {
for(Map.Entry<String, String> entry : s.attributes.entrySet())
            {
                super.remove(s.type + "." + s.algorithm + " " + entry.getKey());
            } 
        } 
    if(providerNumber != -1)        
        {
            Services.setNeedRefresh();
        } 
        
        
        
            
                
            
        
        
            
                
            
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.347 -0400", hash_original_method = "C88E49400116B5906A9CAC0E8D20528B", hash_generated_method = "2A8E7CFD229A5E53F7903E2AC18099A7")
    private void removeFromPropertyServiceTable(Object key) {
        addTaint(key.getTaint());
    if(key == null || !(key instanceof String))        
        {
            return;
        } 
        String k = (String) key;
    if(k.startsWith("Provider."))        
        {
            return;
        } 
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
            } 
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
                    } 
                } 
            } 
            return;
        } 
        int j = k.indexOf('.');
    if(j == -1)        
        {
            return;
        } 
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
                    } 
                } 
            } 
        } 
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
                } 
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.353 -0400", hash_original_method = "C12B51396475B7F4EF23B74D619C33FD", hash_generated_method = "59A4818189A0EC8995B4F5535294CC25")
    private void updatePropertyServiceTable() {
        Object _key;
        Object _value;
        Provider.Service s;
        String serviceName;
        String algorithm;
    if(changedProperties == null || changedProperties.isEmpty())        
        {
            return;
        } 
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
            } 
            String key = (String) _key;
            String value = (String) _value;
    if(key.startsWith("Provider"))            
            {
                continue;
            } 
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
                } 
                else
                {
                    o = propertyServiceTable.get(serviceName, algUp);
                } 
    if(o != null)                
                {
                    s = (Provider.Service) o;
                    s.addAlias(aliasName);
    if(propertyAliasTable == null)                    
                    {
                        propertyAliasTable = new TwoKeyHashMap<String, String, Service>(256);
                    } 
                    propertyAliasTable.put(serviceName, aliasName.toUpperCase(Locale.US), s);
                } 
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
                        } 
                        propertyAliasTable.put(serviceName, aliasName.toUpperCase(Locale.US), s);
                    } 
                } 
                continue;
            } 
            int j = key.indexOf('.');
    if(j == -1)            
            {
                continue;
            } 
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
                } 
    if(o != null)                
                {
                    s = (Provider.Service) o;
                    s.className = value;
                } 
                else
                {
                    s = new Provider.Service(this, serviceName, algorithm,
                            value, Collections.<String>emptyList(),
                            Collections.<String,String>emptyMap());
    if(propertyServiceTable == null)                    
                    {
                        propertyServiceTable = new TwoKeyHashMap<String, String, Service>(128);
                    } 
                    propertyServiceTable.put(serviceName, alg, s);
                } 
            } 
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
                } 
    if(o != null)                
                {
                    s = (Provider.Service) o;
                    s.putAttribute(attribute, value);
                } 
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
                        } 
                        propertyServiceTable.put(serviceName, alg, s);
                    } 
                } 
            } 
        } 
        servicesChanged();
        changedProperties = null;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.355 -0400", hash_original_method = "FD7619437CD0960F1AEBA32A154F0328", hash_generated_method = "9C6A342A2081A7D73BA214C115FEC8EA")
    private void servicesChanged() {
        lastServicesByType = null;
        lastServiceName = null;
        lastServicesSet = null;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.355 -0400", hash_original_method = "768CFC89B63FD1F782E3758D2BCFC6C0", hash_generated_method = "BEA2C42DB158CE6C3270D65A149F3B2E")
    private void putProviderInfo() {
        super.put("Provider.id name", (name != null) ? name : "null");
        super.put("Provider.id version", versionString);
        super.put("Provider.id info", (info != null) ? info : "null");
        super.put("Provider.id className", this.getClass().getName());
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.356 -0400", hash_original_method = "62DD35352FE8FA7B38C17798ED376C47", hash_generated_method = "4EF3963D2EE453E1417C93CAD633B0F5")
    private String getPropertyIgnoreCase(String key) {
        addTaint(key.getTaint());
        String res = getProperty(key);
    if(res != null)        
        {
String varB5053E025797B3BF768F5C37934C244D_1657915674 =             res;
            varB5053E025797B3BF768F5C37934C244D_1657915674.addTaint(taint);
            return varB5053E025797B3BF768F5C37934C244D_1657915674;
        } 
for(Enumeration<?> e = propertyNames();e.hasMoreElements();)
        {
            String propertyName = (String) e.nextElement();
    if(key.equalsIgnoreCase(propertyName))            
            {
String varA461F56DE9B992995E45656BBAF6D5D9_83897046 =                 getProperty(propertyName);
                varA461F56DE9B992995E45656BBAF6D5D9_83897046.addTaint(taint);
                return varA461F56DE9B992995E45656BBAF6D5D9_83897046;
            } 
        } 
String var540C13E9E156B687226421B24F2DF178_590479116 =         null;
        var540C13E9E156B687226421B24F2DF178_590479116.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_590479116;
        
        
        
            
        
        
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.357 -0400", hash_original_method = "C9BE26B06AA230EA20C77B7F366C53C8", hash_generated_method = "C349757B0405244ECF57CED8F47A32D0")
    private void readObject(java.io.ObjectInputStream in) throws NotActiveException, IOException, ClassNotFoundException {
        addTaint(in.getTaint());
        in.defaultReadObject();
        versionString = String.valueOf(version);
        providerNumber = -1;
        
        
        
        
    }

    
    public static class Service {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.357 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

        private Provider provider;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.357 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

        private String type;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.357 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

        private String algorithm;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.358 -0400", hash_original_field = "6F66E878C62DB60568A3487869695820", hash_generated_field = "B28341EF6B88AA3CAD2D37FF14C9DC00")

        private String className;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.358 -0400", hash_original_field = "9299DA2529C98FCCCE0E32B476BA3266", hash_generated_field = "7D96162B1AE01DA7357D6662D8D2C584")

        private List<String> aliases;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.358 -0400", hash_original_field = "736B91750E516139ACC13C5EB6564F92", hash_generated_field = "1CEAC23D4A656E23182C27FC3A78AEDE")

        private Map<String,String> attributes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.358 -0400", hash_original_field = "B6FA15360B4CDCE4806BF9A0580C8F0F", hash_generated_field = "28101B8550628F94A8DDB23FAF399E56")

        private Class<?> implementation;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.358 -0400", hash_original_field = "77FDFBF3D811B72BC9BBBE747A722F58", hash_generated_field = "668E14A773F053D0B44156BD480B724E")

        private String lastClassName;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.361 -0400", hash_original_method = "82CB06DCD943152835D64FFE915BA566", hash_generated_method = "80D77271F158B4849E70B238CD0EDC30")
        public  Service(Provider provider, String type, String algorithm,
                String className, List<String> aliases, Map<String, String> attributes) {
    if(provider == null || type == null || algorithm == null
                    || className == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1018855462 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_1018855462.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_1018855462;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.361 -0400", hash_original_method = "4CA8000463C36260BD9C3E4A41E197CE", hash_generated_method = "CF0BA3367A87E1DE3BEDC49227B27E26")
         void addAlias(String alias) {
            addTaint(alias.getTaint());
    if((aliases == null) || (aliases.size() == 0))            
            {
                aliases = new ArrayList<String>();
            } 
            aliases.add(alias);
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.362 -0400", hash_original_method = "2623207C72797F9950DF9980B680F416", hash_generated_method = "718DEF75A5DE09EB088C9329DCEC13C8")
         void putAttribute(String name, String value) {
            addTaint(value.getTaint());
            addTaint(name.getTaint());
    if((attributes == null) || (attributes.size() == 0))            
            {
                attributes = new HashMap<String,String>();
            } 
            attributes.put(name, value);
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.362 -0400", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "2F2988B66A1CBD98E652E0D1B3E32B36")
        public final String getType() {
String varC5B9F25B4EEAD3E8E2C33F9429204397_270076391 =             type;
            varC5B9F25B4EEAD3E8E2C33F9429204397_270076391.addTaint(taint);
            return varC5B9F25B4EEAD3E8E2C33F9429204397_270076391;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.363 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "B9885B66D8764A7323DF145D01B0E107")
        public final String getAlgorithm() {
String var44A46B4003FC81ACB0223385BA1FA818_1346875154 =             algorithm;
            var44A46B4003FC81ACB0223385BA1FA818_1346875154.addTaint(taint);
            return var44A46B4003FC81ACB0223385BA1FA818_1346875154;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.363 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "A9E730E2AB30996D5BCEDF5FDBF5459D")
        public final Provider getProvider() {
Provider varC1EB7B12CCABB27D431E5B91E5FF9ECB_1021658440 =             provider;
            varC1EB7B12CCABB27D431E5B91E5FF9ECB_1021658440.addTaint(taint);
            return varC1EB7B12CCABB27D431E5B91E5FF9ECB_1021658440;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.363 -0400", hash_original_method = "8415940D3A1E5651F883E391EC68DA41", hash_generated_method = "656BBB7BFE1C90CB5A9004EDD9EB8B19")
        public final String getClassName() {
String varF57DF2C3C72C0BA8574176BD3A4AA127_1928075779 =             className;
            varF57DF2C3C72C0BA8574176BD3A4AA127_1928075779.addTaint(taint);
            return varF57DF2C3C72C0BA8574176BD3A4AA127_1928075779;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.364 -0400", hash_original_method = "0C10317D01C11D1034B9356679E58CA0", hash_generated_method = "C7620BDA28B2D60C9B514E4C7E622A22")
        public final String getAttribute(String name) {
            addTaint(name.getTaint());
    if(name == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1407415671 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_1407415671.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_1407415671;
            } 
    if(attributes == null)            
            {
String var540C13E9E156B687226421B24F2DF178_1641916409 =                 null;
                var540C13E9E156B687226421B24F2DF178_1641916409.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1641916409;
            } 
String var0FC38B75002B91F7AC64538254F3139B_1886339521 =             attributes.get(name);
            var0FC38B75002B91F7AC64538254F3139B_1886339521.addTaint(taint);
            return var0FC38B75002B91F7AC64538254F3139B_1886339521;
            
            
                
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.365 -0400", hash_original_method = "7A6F8F40D5019A1C644CF7CAD3518923", hash_generated_method = "21B1AE808C966DD62A7F735B34BB80DE")
         List<String> getAliases() {
    if(aliases == null)            
            {
                aliases = new ArrayList<String>(0);
            } 
List<String> varC4595C5D23CE6BCE27277A7A63A8884D_1023743584 =             aliases;
            varC4595C5D23CE6BCE27277A7A63A8884D_1023743584.addTaint(taint);
            return varC4595C5D23CE6BCE27277A7A63A8884D_1023743584;
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.367 -0400", hash_original_method = "802A5A00EF15D2BF7FB674CB175B5DD7", hash_generated_method = "19A568946E63F35ED2A69A459808D77D")
        public Object newInstance(Object constructorParameter) throws NoSuchAlgorithmException {
            addTaint(constructorParameter.getTaint());
    if(implementation == null || !className.equals(lastClassName))            
            {
                ClassLoader cl = provider.getClass().getClassLoader();
    if(cl == null)                
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
                    NoSuchAlgorithmException var340B962BBAFCC29E2FBF0C494BA22619_496838485 = new NoSuchAlgorithmException(type + " " + algorithm + " implementation not found: " + e);
                    var340B962BBAFCC29E2FBF0C494BA22619_496838485.addTaint(taint);
                    throw var340B962BBAFCC29E2FBF0C494BA22619_496838485;
                } 
            } 
    if(constructorParameter == null)            
            {
                try 
                {
Object varA51B251B917C25E5A6F890FEB4DA82F6_1513532893 =                     implementation.newInstance();
                    varA51B251B917C25E5A6F890FEB4DA82F6_1513532893.addTaint(taint);
                    return varA51B251B917C25E5A6F890FEB4DA82F6_1513532893;
                } 
                catch (Exception e)
                {
                    NoSuchAlgorithmException varFE975696FAAC863E4BFAD89E5739D05E_1141776120 = new NoSuchAlgorithmException(
                            type + " " + algorithm + " implementation not found", e);
                    varFE975696FAAC863E4BFAD89E5739D05E_1141776120.addTaint(taint);
                    throw varFE975696FAAC863E4BFAD89E5739D05E_1141776120;
                } 
            } 
    if(!supportsParameter(constructorParameter))            
            {
                InvalidParameterException varF9889E1B91A376ADDF2ACA65983F9F24_1369480329 = new InvalidParameterException(type + ": service cannot use the parameter");
                varF9889E1B91A376ADDF2ACA65983F9F24_1369480329.addTaint(taint);
                throw varF9889E1B91A376ADDF2ACA65983F9F24_1369480329;
            } 
            Class[] parameterTypes = new Class[1];
            Object[] initargs = { constructorParameter };
            try 
            {
    if(type.equalsIgnoreCase("CertStore"))                
                {
                    parameterTypes[0] = Class.forName("java.security.cert.CertStoreParameters");
                } 
                else
                {
                    parameterTypes[0] = constructorParameter.getClass();
                } 
Object var6688C2BA9FE406E726A7A7FF4A097B4F_95079013 =                 implementation.getConstructor(parameterTypes)
                        .newInstance(initargs);
                var6688C2BA9FE406E726A7A7FF4A097B4F_95079013.addTaint(taint);
                return var6688C2BA9FE406E726A7A7FF4A097B4F_95079013;
            } 
            catch (Exception e)
            {
                NoSuchAlgorithmException varFE975696FAAC863E4BFAD89E5739D05E_1963999809 = new NoSuchAlgorithmException(type + " " + algorithm
                        + " implementation not found", e);
                varFE975696FAAC863E4BFAD89E5739D05E_1963999809.addTaint(taint);
                throw varFE975696FAAC863E4BFAD89E5739D05E_1963999809;
            } 
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.368 -0400", hash_original_method = "A158C77880B526D8A49B8720A1D647AC", hash_generated_method = "8C2E1AC53C0B3EED64708255AC052B2F")
        public boolean supportsParameter(Object parameter) {
            addTaint(parameter.getTaint());
            boolean varB326B5062B2F0E69046810717534CB09_727807824 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_959803364 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_959803364;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.369 -0400", hash_original_method = "CD20F19EDED4066F9FA28FD55133940E", hash_generated_method = "7366CF376D8C95D9F0D5F7B8756779E4")
        @Override
        public String toString() {
            String result = "Provider " + provider.getName() + " Service "
                    + type + "." + algorithm + " " + className;
    if(aliases != null)            
            {
                result = result + "\nAliases " + aliases.toString();
            } 
    if(attributes != null)            
            {
                result = result + "\nAttributes " + attributes.toString();
            } 
String varDC838461EE2FA0CA4C9BBB70A15456B0_1470314333 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_1470314333.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1470314333;
            
            
                    
            
                
            
            
                
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.369 -0400", hash_original_field = "7CC76EFC2B264F3D1AA5774D56F0CEA6", hash_generated_field = "6AA3DBE008BE39E45A084DC1795F57FB")

    private static final long serialVersionUID = -4298000515446427739L;
}

