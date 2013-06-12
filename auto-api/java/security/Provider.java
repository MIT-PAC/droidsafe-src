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
    private static final long serialVersionUID = -4298000515446427739L;
    private String name;
    private double version;
    private transient String versionString;
    private String info;
    private transient int providerNumber = -1;
    private transient TwoKeyHashMap<String, String, Service> serviceTable;
    private transient TwoKeyHashMap<String, String, Service> aliasTable;
    private transient TwoKeyHashMap<String, String, Service> propertyServiceTable;
    private transient TwoKeyHashMap<String, String, Service> propertyAliasTable;
    private transient Properties changedProperties;
    private transient Provider.Service returnedService;
    private transient String lastAlgorithm;
    private transient String lastServiceName;
    private transient Set<Service> lastServicesSet;
    private transient String lastType;
    private transient Provider.Service lastServicesByType;
    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.681 -0400",hash_original_method="CD20F19EDED4066F9FA28FD55133940E",hash_generated_method="1CE071B6762BDB597F028E26FF3E2760")
protected Provider(String name, double version, String info) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(version);
        dsTaint.addTaint(info);
        versionString = String.valueOf(version);
        putProviderInfo();
        // ---------- Original Method ----------
        //this.name = name;
        //this.version = version;
        //this.info = info;
        //versionString = String.valueOf(version);
        //putProviderInfo();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:01:53.692 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "F47755EA38582EE7C3877DD72123E9B0")
    @DSModeled(DSC.SAFE)
    public String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:01:53.696 -0400", hash_original_method = "849DADC9512AC29CFF5A5EB4D1517425", hash_generated_method = "357D7F9B618AB414E6E6DBBDFE525B7E")
    @DSModeled(DSC.SAFE)
    public double getVersion() {
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //return version;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:01:53.697 -0400", hash_original_method = "90F1C2C1B854E8544A3CF05D4B3BD6E7", hash_generated_method = "81F650B189D54EAB726C6EFAE06B761A")
    @DSModeled(DSC.SAFE)
    public String getInfo() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return info;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:01:53.702 -0400", hash_original_method = "58EC0A1A07497E3FA377B5366380E5E3", hash_generated_method = "598E3123C1B9993C3555ABC553FA6CF3")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return name + " version " + version;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:01:53.707 -0400", hash_original_method = "53793BFB01C9C5B2BDDE9F63C2E38535", hash_generated_method = "A3119A9C3C7C97CA499A1B3AC68BDDAE")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:01:53.710 -0400", hash_original_method = "EB6BD048CAF9E12CFD99EC1891725291", hash_generated_method = "3FD7D591C6C6C9B598AD7DB133417D94")
    @DSModeled(DSC.SAFE)
    @Override
    public synchronized void load(InputStream inStream) throws IOException {
        dsTaint.addTaint(inStream.dsTaint);
        Properties tmp;
        tmp = new Properties();
        tmp.load(inStream);
        myPutAll(tmp);
        // ---------- Original Method ----------
        //Properties tmp = new Properties();
        //tmp.load(inStream);
        //myPutAll(tmp);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:01:53.711 -0400", hash_original_method = "CE4C2613BF29D966F3F961299EB30975", hash_generated_method = "B766309E65137ACC8A7818A30E92A8E6")
    @DSModeled(DSC.SAFE)
    @Override
    public synchronized void putAll(Map<?,?> t) {
        dsTaint.addTaint(t.dsTaint);
        myPutAll(t);
        // ---------- Original Method ----------
        //myPutAll(t);
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.681 -0400",hash_original_method="CD20F19EDED4066F9FA28FD55133940E",hash_generated_method="1CE071B6762BDB597F028E26FF3E2760")
private void myPutAll(Map<?,?> t) {
        dsTaint.addTaint(t.dsTaint);
        {
            changedProperties = new Properties();
        } //End block
        Iterator<? extends Map.Entry<?, ?>> it;
        it = t.entrySet().iterator();
        Object key;
        Object value;
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_350447673 = (it.hasNext());
            {
                Map.Entry<?, ?> entry;
                entry = it.next();
                key = entry.getKey();
                {
                    boolean var39D76CDDB13616FD0D42E75AC7C012F1_2040604319 = (key instanceof String && ((String) key).startsWith("Provider."));
                } //End collapsed parenthetic
                value = entry.getValue();
                super.put(key, value);
                {
                    boolean var557FC3098495809338F3BC3135E1280B_1869061527 = (changedProperties.remove(key) == null);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.681 -0400",hash_original_method="CD20F19EDED4066F9FA28FD55133940E",hash_generated_method="1CE071B6762BDB597F028E26FF3E2760")
@Override
    public synchronized Set<Map.Entry<Object,Object>> entrySet() {
        Set<Map.Entry<Object,Object>> var892416AEF0B54CAC53D8AA6BB26194AB_930381112 = (Collections.unmodifiableSet(super.entrySet()));
        return (Set<Map.Entry<Object,Object>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Collections.unmodifiableSet(super.entrySet());
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.681 -0400",hash_original_method="CD20F19EDED4066F9FA28FD55133940E",hash_generated_method="1CE071B6762BDB597F028E26FF3E2760")
@Override
    public Set<Object> keySet() {
        Set<Object> var46B2F611574D8BC5F48B8909B57175B2_1075403632 = (Collections.unmodifiableSet(super.keySet()));
        return (Set<Object>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Collections.unmodifiableSet(super.keySet());
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.681 -0400",hash_original_method="CD20F19EDED4066F9FA28FD55133940E",hash_generated_method="1CE071B6762BDB597F028E26FF3E2760")
@Override
    public Collection<Object> values() {
        Collection<Object> varBA06436CFEB7347D9D4F4B0646498795_2066608941 = (Collections.unmodifiableCollection(super.values()));
        return (Collection<Object>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Collections.unmodifiableCollection(super.values());
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.681 -0400",hash_original_method="CD20F19EDED4066F9FA28FD55133940E",hash_generated_method="1CE071B6762BDB597F028E26FF3E2760")
@Override
    public synchronized Object put(Object key, Object value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        {
            boolean var615FFDC8C58E5DA9131CFD1E840EB61D_1985753849 = (key instanceof String && ((String) key).startsWith("Provider."));
        } //End collapsed parenthetic
        {
            Services.setNeedRefresh();
        } //End block
        {
            boolean varF5120E22219DB168E3E6D91BEC202FF4_359826829 = (changedProperties != null && changedProperties.remove(key) == null);
            {
                removeFromPropertyServiceTable(key);
            } //End block
        } //End collapsed parenthetic
        {
            changedProperties = new Properties();
        } //End block
        changedProperties.put(key, value);
        Object var541F9B4BCE199766DA03F8AC52187EDE_47426167 = (super.put(key, value));
        return (Object)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.681 -0400",hash_original_method="CD20F19EDED4066F9FA28FD55133940E",hash_generated_method="1CE071B6762BDB597F028E26FF3E2760")
@Override
    public synchronized Object remove(Object key) {
        dsTaint.addTaint(key.dsTaint);
        {
            boolean var615FFDC8C58E5DA9131CFD1E840EB61D_529102121 = (key instanceof String && ((String) key).startsWith("Provider."));
        } //End collapsed parenthetic
        {
            Services.setNeedRefresh();
        } //End block
        {
            boolean varF5120E22219DB168E3E6D91BEC202FF4_596514700 = (changedProperties != null && changedProperties.remove(key) == null);
            {
                removeFromPropertyServiceTable(key);
                {
                    boolean var88F5A1A88583F68F084FEAD07CBA365C_1208226840 = (changedProperties.size() == 0);
                    {
                        changedProperties = null;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        Object varF330EE4886E00ED263965B0A75038D04_1166562548 = (super.remove(key));
        return (Object)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.681 -0400",hash_original_method="CD20F19EDED4066F9FA28FD55133940E",hash_generated_method="1CE071B6762BDB597F028E26FF3E2760")
boolean implementsAlg(String serv, String alg, String attribute, String val) {
        dsTaint.addTaint(alg);
        dsTaint.addTaint(val);
        dsTaint.addTaint(attribute);
        dsTaint.addTaint(serv);
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
            boolean var83392DFFAC381D73DD8A3765EFB03BDF_714002336 = (checkAttribute(servAlg, attribute, val));
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.681 -0400",hash_original_method="CD20F19EDED4066F9FA28FD55133940E",hash_generated_method="1CE071B6762BDB597F028E26FF3E2760")
private boolean checkAttribute(String servAlg, String attribute, String val) {
        dsTaint.addTaint(val);
        dsTaint.addTaint(attribute);
        dsTaint.addTaint(servAlg);
        String attributeValue;
        attributeValue = getPropertyIgnoreCase(servAlg + ' ' + attribute);
        {
            {
                boolean var9AAE8A593FFFFD550F3379BD45AFB455_231368818 = (attribute.equalsIgnoreCase("KeySize"));
                {
                    {
                        boolean var2CCBDA5D9949774AEDDE95DD101E1B5B_1726687317 = (Integer.parseInt(attributeValue) >= Integer.parseInt(val));
                    } //End collapsed parenthetic
                } //End block
                {
                    {
                        boolean varBE561380D0BC947AE323F09089366FE2_654938803 = (attributeValue.equalsIgnoreCase(val));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:01:53.738 -0400", hash_original_method = "6418C82159D4FAB251CB16B6C408D61D", hash_generated_method = "9D3171D68789AE5D46437E00A2B03511")
    @DSModeled(DSC.SAFE)
     void setProviderNumber(int n) {
        dsTaint.addTaint(n);
        // ---------- Original Method ----------
        //providerNumber = n;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:01:53.739 -0400", hash_original_method = "6209D7B36FBC76163C52BAAF1CE53C35", hash_generated_method = "21DD0B1B2F36E868A69CD2DBD35F31CA")
    @DSModeled(DSC.SAFE)
     int getProviderNumber() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return providerNumber;
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.681 -0400",hash_original_method="CD20F19EDED4066F9FA28FD55133940E",hash_generated_method="1CE071B6762BDB597F028E26FF3E2760")
synchronized Provider.Service getService(String type) {
        dsTaint.addTaint(type);
        updatePropertyServiceTable();
        {
            boolean varE8D1884AAD74E2F5DA1CD399B1822ECD_700592503 = (lastServicesByType != null && type.equals(lastType));
        } //End collapsed parenthetic
        Provider.Service service;
        {
            Iterator<Service> it;
            it = getServices().iterator();
            boolean var03729FD53960D8DCA3A41A13A0229637_137697034 = (it.hasNext());
            {
                service = it.next();
                {
                    boolean var4C71E495B2DBF2BB72C8225160CEBE9A_259588265 = (type.equals(service.type));
                    {
                        lastServicesByType = service;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (Provider.Service)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.681 -0400",hash_original_method="CD20F19EDED4066F9FA28FD55133940E",hash_generated_method="1CE071B6762BDB597F028E26FF3E2760")
public synchronized Provider.Service getService(String type,
            String algorithm) {
        dsTaint.addTaint(type);
        dsTaint.addTaint(algorithm);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            boolean var5D9786D09CE430680B17444C7FCE5061_1674361215 = (type.equals(lastServiceName) && algorithm.equalsIgnoreCase(lastAlgorithm));
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
            returnedService = (Provider.Service) o;
        } //End block
        return (Provider.Service)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.681 -0400",hash_original_method="CD20F19EDED4066F9FA28FD55133940E",hash_generated_method="1CE071B6762BDB597F028E26FF3E2760")
public synchronized Set<Provider.Service> getServices() {
        updatePropertyServiceTable();
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
        return (Set<Provider.Service>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.681 -0400",hash_original_method="CD20F19EDED4066F9FA28FD55133940E",hash_generated_method="1CE071B6762BDB597F028E26FF3E2760")
protected synchronized void putService(Provider.Service s) {
        dsTaint.addTaint(s.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            boolean varF52B1BD6E65C5078A2BDD1FFCE56BDE7_395862720 = ("Provider".equals(s.getType()));
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
                Iterator<String> seatecAstronomy42 = s.getAliases().iterator();
                seatecAstronomy42.hasNext();
                String alias = seatecAstronomy42.next();
                {
                    aliasTable.put(s.type, alias.toUpperCase(Locale.US), s);
                } //End block
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.681 -0400",hash_original_method="CD20F19EDED4066F9FA28FD55133940E",hash_generated_method="1CE071B6762BDB597F028E26FF3E2760")
protected synchronized void removeService(Provider.Service s) {
        dsTaint.addTaint(s.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control)  throw new NullPointerException();
        } //End block
        servicesChanged();
        {
            serviceTable.remove(s.type, s.algorithm.toUpperCase(Locale.US));
        } //End block
        {
            {
                Iterator<String> seatecAstronomy42 = s.getAliases().iterator();
                seatecAstronomy42.hasNext();
                String alias = seatecAstronomy42.next();
                {
                    aliasTable.remove(s.type, alias.toUpperCase(Locale.US));
                } //End block
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.681 -0400",hash_original_method="CD20F19EDED4066F9FA28FD55133940E",hash_generated_method="1CE071B6762BDB597F028E26FF3E2760")
private void serviceInfoToProperties(Provider.Service s) {
        dsTaint.addTaint(s.dsTaint);
        super.put(s.type + "." + s.algorithm, s.className);
        {
            {
                Iterator<String> i;
                i = s.aliases.iterator();
                boolean varD8B5E52A597500CBD863E52A46B42708_1206253829 = (i.hasNext());
                {
                    super.put("Alg.Alias." + s.type + "." + i.next(), s.algorithm);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                Iterator<Map.Entry<String, String>> seatecAstronomy42 = s.attributes.entrySet().iterator();
                seatecAstronomy42.hasNext();
                Map.Entry<String, String> entry = seatecAstronomy42.next();
                {
                    super.put(s.type + "." + s.algorithm + " " + entry.getKey(),
                        entry.getValue());
                } //End block
            } //End collapsed parenthetic
        } //End block
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

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.681 -0400",hash_original_method="CD20F19EDED4066F9FA28FD55133940E",hash_generated_method="1CE071B6762BDB597F028E26FF3E2760")
private void serviceInfoFromProperties(Provider.Service s) {
        dsTaint.addTaint(s.dsTaint);
        super.remove(s.type + "." + s.algorithm);
        {
            {
                Iterator<String> i;
                i = s.aliases.iterator();
                boolean varD8B5E52A597500CBD863E52A46B42708_1998103155 = (i.hasNext());
                {
                    super.remove("Alg.Alias." + s.type + "." + i.next());
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                Iterator<Map.Entry<String, String>> seatecAstronomy42 = s.attributes.entrySet().iterator();
                seatecAstronomy42.hasNext();
                Map.Entry<String, String> entry = seatecAstronomy42.next();
                {
                    super.remove(s.type + "." + s.algorithm + " " + entry.getKey());
                } //End block
            } //End collapsed parenthetic
        } //End block
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

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.681 -0400",hash_original_method="CD20F19EDED4066F9FA28FD55133940E",hash_generated_method="1CE071B6762BDB597F028E26FF3E2760")
private void removeFromPropertyServiceTable(Object key) {
        dsTaint.addTaint(key.dsTaint);
        String k;
        k = (String) key;
        {
            boolean var51D0AB19C0E4EAD46591A8C66CC40542_9306470 = (k.startsWith("Provider."));
        } //End collapsed parenthetic
        Provider.Service s;
        String serviceName;
        String algorithm;
        algorithm = null;
        String attribute;
        attribute = null;
        int i;
        {
            boolean varB2EA1E0E9D7C7EEC2C9BF24E8B1510EA_1924349185 = (k.startsWith("Alg.Alias."));
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
                        boolean var4A1B8BE89C779B21458638B02948AC2A_1817480914 = (it
                        .hasNext());
                        {
                            s = it.next();
                            {
                                boolean var6F8C4AE25185D3231A2E4FD7E4E357C3_1917054881 = (s.aliases.contains(aliasName));
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
                        Iterator<String> seatecAstronomy42 = ser.aliases.iterator();
                        seatecAstronomy42.hasNext();
                        String alias = seatecAstronomy42.next();
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.681 -0400",hash_original_method="CD20F19EDED4066F9FA28FD55133940E",hash_generated_method="1CE071B6762BDB597F028E26FF3E2760")
private void updatePropertyServiceTable() {
        Object _key;
        Object _value;
        Provider.Service s;
        String serviceName;
        String algorithm;
        {
            boolean var9C86F49586631F13D865CF4B9FA9A44B_921249034 = (changedProperties == null || changedProperties.isEmpty());
        } //End collapsed parenthetic
        {
            Iterator<Map.Entry<Object, Object>> it;
            it = changedProperties.entrySet().iterator();
            boolean var9D0EDA54CCAB017AFE33C830CCA36C58_1072485703 = (it
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
                    boolean var2F2AA442FA156A8F8BA53B7B622AD8C8_436089193 = (key.startsWith("Provider"));
                } //End collapsed parenthetic
                int i;
                {
                    boolean var95164A0B30E45315F7A1F2560FE7C960_2047896051 = (key.startsWith("Alg.Alias."));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:01:53.777 -0400", hash_original_method = "FD7619437CD0960F1AEBA32A154F0328", hash_generated_method = "CB41C70BD9F0FAF2E7FBD358EB7A9DB1")
    @DSModeled(DSC.SAFE)
    private void servicesChanged() {
        lastServicesByType = null;
        lastServiceName = null;
        lastServicesSet = null;
        // ---------- Original Method ----------
        //lastServicesByType = null;
        //lastServiceName = null;
        //lastServicesSet = null;
    }

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.681 -0400",hash_original_method="CD20F19EDED4066F9FA28FD55133940E",hash_generated_method="1CE071B6762BDB597F028E26FF3E2760")
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

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.681 -0400",hash_original_method="CD20F19EDED4066F9FA28FD55133940E",hash_generated_method="1CE071B6762BDB597F028E26FF3E2760")
private String getPropertyIgnoreCase(String key) {
        dsTaint.addTaint(key);
        String res;
        res = getProperty(key);
        {
            Enumeration<?> e;
            e = propertyNames();
            boolean var3EB0A96682EDBE15308427BAC1EC4A4E_1346718132 = (e.hasMoreElements());
            {
                String propertyName;
                propertyName = (String) e.nextElement();
                {
                    boolean var7026A60BEF5468325737B39ADF42B3F9_217512898 = (key.equalsIgnoreCase(propertyName));
                    {
                        String varA60B53B021D153DADCA3B1D6043D379B_1885047132 = (getProperty(propertyName));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.681 -0400",hash_original_method="CD20F19EDED4066F9FA28FD55133940E",hash_generated_method="1CE071B6762BDB597F028E26FF3E2760")
private void readObject(java.io.ObjectInputStream in) throws NotActiveException, IOException, ClassNotFoundException {
        dsTaint.addTaint(in.dsTaint);
        in.defaultReadObject();
        versionString = String.valueOf(version);
        providerNumber = -1;
        // ---------- Original Method ----------
        //in.defaultReadObject();
        //versionString = String.valueOf(version);
        //providerNumber = -1;
    }

    
    public static class Service {
        private Provider provider;
        private String type;
        private String algorithm;
        private String className;
        private List<String> aliases;
        private Map<String,String> attributes;
        private Class<?> implementation;
        private String lastClassName;
        
        @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.681 -0400",hash_original_method="CD20F19EDED4066F9FA28FD55133940E",hash_generated_method="1CE071B6762BDB597F028E26FF3E2760")
public Service(Provider provider, String type, String algorithm,
                String className, List<String> aliases, Map<String, String> attributes) {
            dsTaint.addTaint(provider.dsTaint);
            dsTaint.addTaint(className);
            dsTaint.addTaint(attributes.dsTaint);
            dsTaint.addTaint(type);
            dsTaint.addTaint(aliases.dsTaint);
            dsTaint.addTaint(algorithm);
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
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

        
        @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.681 -0400",hash_original_method="CD20F19EDED4066F9FA28FD55133940E",hash_generated_method="1CE071B6762BDB597F028E26FF3E2760")
void addAlias(String alias) {
            dsTaint.addTaint(alias);
            {
                boolean var5374BEA4A10DF1C27BAE96F18BD3D766_1996494560 = ((aliases == null) || (aliases.size() == 0));
                {
                    aliases = new ArrayList<String>();
                } //End block
            } //End collapsed parenthetic
            aliases.add(alias);
            // ---------- Original Method ----------
            //if ((aliases == null) || (aliases.size() == 0)) {
                //aliases = new ArrayList<String>();
            //}
            //aliases.add(alias);
        }

        
        @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.681 -0400",hash_original_method="CD20F19EDED4066F9FA28FD55133940E",hash_generated_method="1CE071B6762BDB597F028E26FF3E2760")
void putAttribute(String name, String value) {
            dsTaint.addTaint(name);
            dsTaint.addTaint(value);
            {
                boolean varEB4E27A2355C4FBDE3011F0D25AF36B4_1416583882 = ((attributes == null) || (attributes.size() == 0));
                {
                    attributes = new HashMap<String,String>();
                } //End block
            } //End collapsed parenthetic
            attributes.put(name, value);
            // ---------- Original Method ----------
            //if ((attributes == null) || (attributes.size() == 0)) {
                //attributes = new HashMap<String,String>();
            //}
            //attributes.put(name, value);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:01:53.801 -0400", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "C33423799F46A4D983B8408DB9A92B86")
        @DSModeled(DSC.SAFE)
        public final String getType() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return type;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:01:53.804 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "4A58ADD94C981C54C4328FD02BFEBA19")
        @DSModeled(DSC.SAFE)
        public final String getAlgorithm() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return algorithm;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:01:53.806 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "45F6335264F85F3B8D73CAC979348AC1")
        @DSModeled(DSC.SAFE)
        public final Provider getProvider() {
            return (Provider)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return provider;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:01:53.809 -0400", hash_original_method = "8415940D3A1E5651F883E391EC68DA41", hash_generated_method = "3E715F9B2BAD076888FA9B36FB56AF32")
        @DSModeled(DSC.SAFE)
        public final String getClassName() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return className;
        }

        
        @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.681 -0400",hash_original_method="CD20F19EDED4066F9FA28FD55133940E",hash_generated_method="1CE071B6762BDB597F028E26FF3E2760")
public final String getAttribute(String name) {
            dsTaint.addTaint(name);
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            String var06E87D5FB99CE656F39053A5211F274D_569938748 = (attributes.get(name));
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //if (name == null) {
                //throw new NullPointerException();
            //}
            //if (attributes == null) {
                //return null;
            //}
            //return attributes.get(name);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:01:53.813 -0400", hash_original_method = "7A6F8F40D5019A1C644CF7CAD3518923", hash_generated_method = "62DF9CC14B52ACF7FAACC02919E391A7")
        @DSModeled(DSC.SAFE)
         List<String> getAliases() {
            {
                aliases = new ArrayList<String>(0);
            } //End block
            return (List<String>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (aliases == null){
                //aliases = new ArrayList<String>(0);
            //}
            //return aliases;
        }

        
        @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.681 -0400",hash_original_method="CD20F19EDED4066F9FA28FD55133940E",hash_generated_method="1CE071B6762BDB597F028E26FF3E2760")
public Object newInstance(Object constructorParameter) throws NoSuchAlgorithmException {
            dsTaint.addTaint(constructorParameter.dsTaint);
            {
                boolean var3339E2EE99840D316B470BF831351DB9_854297238 = (implementation == null || !className.equals(lastClassName));
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
                        throw new NoSuchAlgorithmException(type + " " + algorithm + " implementation not found: " + e);
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                try 
                {
                    Object varFAEBF1B2015D295127C79EBF7547DDF8_66648118 = (implementation.newInstance());
                } //End block
                catch (Exception e)
                {
                    throw new NoSuchAlgorithmException(
                            type + " " + algorithm + " implementation not found", e);
                } //End block
            } //End block
            {
                boolean varF38959283B90E1EE47D3A31C8BA89AD9_463741811 = (!supportsParameter(constructorParameter));
                {
                    if (DroidSafeAndroidRuntime.control) throw new InvalidParameterException(type + ": service cannot use the parameter");
                } //End block
            } //End collapsed parenthetic
            Class[] parameterTypes;
            parameterTypes = new Class[1];
            Object[] initargs = null;
            try 
            {
                {
                    boolean var51E19F4634C2BA7E86B66347BB7D2C93_812996466 = (type.equalsIgnoreCase("CertStore"));
                    {
                        parameterTypes[0] = Class.forName("java.security.cert.CertStoreParameters");
                    } //End block
                    {
                        parameterTypes[0] = constructorParameter.getClass();
                    } //End block
                } //End collapsed parenthetic
                Object var252BC147BD0552C3BFB58DC214FF4DF3_178652720 = (implementation.getConstructor(parameterTypes)
                        .newInstance(initargs));
            } //End block
            catch (Exception e)
            {
                throw new NoSuchAlgorithmException(type + " " + algorithm
                        + " implementation not found", e);
            } //End block
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:01:53.822 -0400", hash_original_method = "A158C77880B526D8A49B8720A1D647AC", hash_generated_method = "DB00DA13554A544BC195F5E487477012")
        @DSModeled(DSC.SAFE)
        public boolean supportsParameter(Object parameter) {
            dsTaint.addTaint(parameter.dsTaint);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return true;
        }

        
        @DSGenerator(tool_name="Doppelganger",tool_version="0.4",generated_on="2013-06-11 11:15:12.681 -0400",hash_original_method="CD20F19EDED4066F9FA28FD55133940E",hash_generated_method="1CE071B6762BDB597F028E26FF3E2760")
@Override
        public String toString() {
            String result;
            result = "Provider " + provider.getName() + " Service "
                    + type + "." + algorithm + " " + className;
            {
                result = result + "\nAliases " + aliases.toString();
            } //End block
            {
                result = result + "\nAttributes " + attributes.toString();
            } //End block
            return dsTaint.getTaintString();
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


    
}


