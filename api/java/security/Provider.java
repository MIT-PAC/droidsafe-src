package java.security;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.495 -0500", hash_original_field = "38A3EA133D52C6E6AAE27ABA3FE0A21A", hash_generated_field = "6AA3DBE008BE39E45A084DC1795F57FB")

    private static final long serialVersionUID = -4298000515446427739L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.497 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")


    private String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.499 -0500", hash_original_field = "CB072D85BF854AC8B162DD5974AED1AE", hash_generated_field = "F3CA80FC5F7B3B542DC8B1C8FD91731C")


    private double version;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.502 -0500", hash_original_field = "01281B0159A804B14C349FAF09113D36", hash_generated_field = "AEF8D804C6A6E39F2A136B97DEDD88CA")

    private transient String versionString;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.504 -0500", hash_original_field = "51A3ED67E300F80A591B74C6FCA4A0D2", hash_generated_field = "1F50CB615F8F0AB19DCF28D9BAFF4DD4")


    private String info;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.508 -0500", hash_original_field = "4050B7CF42930BF2195CFAD5FCC370DF", hash_generated_field = "16EB2A91BC3F969A9F3D8BB99C39D6E7")

    // Equals -1 for non registered provider.
    private transient int providerNumber = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.510 -0500", hash_original_field = "7A6183AB5E984E3358D385E8633558A9", hash_generated_field = "6C64394A9452D2B2184E586FA289F795")

    // putService()
    private transient TwoKeyHashMap<String, String, Service> serviceTable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.513 -0500", hash_original_field = "AF8B1AAA1053F0A32DACCF687203909B", hash_generated_field = "849CF0ECE54321596A39E3FC5CECD4B9")

    // putService()
    private transient TwoKeyHashMap<String, String, Service> aliasTable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.516 -0500", hash_original_field = "D6EB584580E420E380FE95EA1A0038F3", hash_generated_field = "449BF1C0EE5F207685D9ADB846F4019C")

    // put()
    private transient TwoKeyHashMap<String, String, Service> propertyServiceTable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.518 -0500", hash_original_field = "501A88469BDE687914317996F8BE66CF", hash_generated_field = "496EDC5FF7DCB745D06FD58901D71D88")

    private transient TwoKeyHashMap<String, String, Service> propertyAliasTable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.520 -0500", hash_original_field = "4F9FABEC07416FB1D6B97BA3211E146C", hash_generated_field = "8BBAB31DBAA82BF49B07B5E12D0CF85B")

    private transient Properties changedProperties;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.523 -0500", hash_original_field = "49A7DF9EA6C3AAA2E6CC87E3D7A12826", hash_generated_field = "C0C3BF522A98534C12A9AE99EE79A87B")

    // previous result
    private transient Provider.Service returnedService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.525 -0500", hash_original_field = "F3D9ECEA816A0602E74CBD27EFDA43F8", hash_generated_field = "A17CE05D31CA338777E2E3315B0B2BB2")

    private transient String lastAlgorithm;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.528 -0500", hash_original_field = "05127C5C1F3A2D948206E416F62427DC", hash_generated_field = "26FDBDCE6D172CC943C76DDD3CE0C4F1")

    private transient String lastServiceName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.530 -0500", hash_original_field = "D6E5800BF85654C41072397A14861DCC", hash_generated_field = "BA27D1D25E16A8C025C9D2F64E31C9C5")

    private transient Set<Service> lastServicesSet;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.533 -0500", hash_original_field = "901A97646E3EAD194AED85C91FD357D0", hash_generated_field = "3F98FC0FC213ABB6A1D68A8492E264D1")

    private transient String lastType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.535 -0500", hash_original_field = "BFBF7EB7C820B580641B8CB7CFE19B5C", hash_generated_field = "734DC09FAD571851B677CBD6C2E18D22")

    private transient Provider.Service lastServicesByType;

    /**
     * Constructs a new instance of {@code Provider} with its name, version and
     * description.
     *
     * @param name
     *            the name of the provider.
     * @param version
     *            the version of the provider.
     * @param info
     *            a description of the provider.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.538 -0500", hash_original_method = "CD3EC30E89504BC69886C014A5CD7A7E", hash_generated_method = "192B4921ED29068800591E237C1224F0")
    
protected Provider(String name, double version, String info) {
        this.name = name;
        this.version = version;
        this.info = info;
        versionString = String.valueOf(version);
        putProviderInfo();
    }

    /**
     * Returns the name of this provider.
     *
     * @return the name of this provider.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.540 -0500", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "50860709F8CC9FE19B604881E59FBA54")
    
public String getName() {
        return name;
    }

    /**
     * Returns the version number for the services being provided.
     *
     * @return the version number for the services being provided.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.542 -0500", hash_original_method = "849DADC9512AC29CFF5A5EB4D1517425", hash_generated_method = "5EFC4F4078A0B69A60E0F371FF683665")
    
public double getVersion() {
        return version;
    }

    /**
     * Returns a description of the services being provided.
     *
     * @return a description of the services being provided.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.545 -0500", hash_original_method = "90F1C2C1B854E8544A3CF05D4B3BD6E7", hash_generated_method = "68C60099DFA11F525DDAC7E8AE6EF591")
    
public String getInfo() {
        return info;
    }

    /**
     * Returns a string containing a concise, human-readable description of
     * this {@code Provider} including its name and its version.
     *
     * @return a printable representation for this {@code Provider}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.547 -0500", hash_original_method = "58EC0A1A07497E3FA377B5366380E5E3", hash_generated_method = "2E9E37CD5E99D8AC5B8D1686DFC4A9EA")
    
@Override
    public String toString() {
        return name + " version " + version;
    }

    /**
     * Clears all properties used to look up services implemented by this
     * {@code Provider}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.551 -0500", hash_original_method = "53793BFB01C9C5B2BDDE9F63C2E38535", hash_generated_method = "65D366CDE14B87952DF194942174A97A")
    
@Override
    public synchronized void clear() {
        super.clear();
        if (serviceTable != null) {
            serviceTable.clear();
        }
        if (propertyServiceTable != null) {
            propertyServiceTable.clear();
        }
        if (aliasTable != null) {
            aliasTable.clear();
        }
        if (propertyAliasTable != null) {
            propertyAliasTable.clear();
        }
        changedProperties = null;
        putProviderInfo();
        if (providerNumber != -1) {
            // if registered then refresh Services
            Services.setNeedRefresh();
        }
        servicesChanged();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.554 -0500", hash_original_method = "EB6BD048CAF9E12CFD99EC1891725291", hash_generated_method = "8F1CFFC62F53EFB7244D82A848DDDBDF")
    
@Override
    public synchronized void load(InputStream inStream) throws IOException {
        Properties tmp = new Properties();
        tmp.load(inStream);
        myPutAll(tmp);
    }

    /**
     * Copies all from the provided map to this {@code Provider}.
     * @param t
     *            the mappings to copy to this provider.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.557 -0500", hash_original_method = "CE4C2613BF29D966F3F961299EB30975", hash_generated_method = "79B75A2D3060FEF6EFCF23774314BE25")
    
@Override
    public synchronized void putAll(Map<?,?> t) {
        myPutAll(t);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.559 -0500", hash_original_method = "F898BA9F30F0CED7EAABA59AE5C4F6F9", hash_generated_method = "E6B8AC8931D35A85ED90712FC4BC5FC1")
    
private void myPutAll(Map<?,?> t) {
        if (changedProperties == null) {
            changedProperties = new Properties();
        }
        Iterator<? extends Map.Entry<?, ?>> it = t.entrySet().iterator();
        Object key;
        Object value;
        while (it.hasNext()) {
            Map.Entry<?, ?> entry = it.next();
            key = entry.getKey();
            if (key instanceof String && ((String) key).startsWith("Provider.")) {
                // Provider service type is reserved
                continue;
            }
            value = entry.getValue();
            super.put(key, value);
            if (changedProperties.remove(key) == null) {
                removeFromPropertyServiceTable(key);
            }
            changedProperties.put(key, value);
        }
        if (providerNumber != -1) {
            // if registered then refresh Services
            Services.setNeedRefresh();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.562 -0500", hash_original_method = "70D9A28808783B7E2708BCE915ECB209", hash_generated_method = "00AC6EA0A2E9E856DCBCB219E7BA4E7A")
    
@Override
    public synchronized Set<Map.Entry<Object,Object>> entrySet() {
        return Collections.unmodifiableSet(super.entrySet());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.565 -0500", hash_original_method = "45BA03BABBCEC97C3CDEDDFAAD34C546", hash_generated_method = "78AAE48FC6E3F7D30B2CB0FBCF935512")
    
@Override
    public Set<Object> keySet() {
        return Collections.unmodifiableSet(super.keySet());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.567 -0500", hash_original_method = "4FF8F6E11AAD8FB860F173913A5840CE", hash_generated_method = "DD2756C9DCC3289C75E65E3EF0924EDF")
    
@Override
    public Collection<Object> values() {
        return Collections.unmodifiableCollection(super.values());
    }

    /**
     * Maps the specified {@code key} property name to the specified {@code
     * value}.
     *
     * @param key
     *            the name of the property.
     * @param value
     *            the value of the property.
     * @return the value that was previously mapped to the specified {@code key}
     *         ,or {@code null} if it did not have one.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.570 -0500", hash_original_method = "6B0BAE35C6955DE6DEF5897424A78326", hash_generated_method = "AFE5BBFE43147BD33DAB25AA98E7900C")
    
@Override
    public synchronized Object put(Object key, Object value) {
        if (key instanceof String && ((String) key).startsWith("Provider.")) {
            // Provider service type is reserved
            return null;
        }
        if (providerNumber != -1) {
            // if registered then refresh Services
            Services.setNeedRefresh();
        }
        if (changedProperties != null && changedProperties.remove(key) == null) {
            removeFromPropertyServiceTable(key);
        }
        if (changedProperties == null) {
            changedProperties = new Properties();
        }
        changedProperties.put(key, value);
        return super.put(key, value);
    }

    /**
     * Removes the specified {@code key} and its associated value from this
     * {@code Provider}.
     *
     * @param key
     *            the name of the property
     * @return the value that was mapped to the specified {@code key} ,or
     *         {@code null} if no mapping was present
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.573 -0500", hash_original_method = "8EA23C4ABA882E49A95AE531F4BFEB20", hash_generated_method = "7E227177B651CE0EF658962A73104F03")
    
@Override
    public synchronized Object remove(Object key) {
        if (key instanceof String && ((String) key).startsWith("Provider.")) {
            // Provider service type is reserved
            return null;
        }
        if (providerNumber != -1) {
            // if registered then refresh Services
            Services.setNeedRefresh();
        }
        if (changedProperties != null && changedProperties.remove(key) == null) {
            removeFromPropertyServiceTable(key);
            if (changedProperties.size() == 0) {
                changedProperties = null;
            }
        }
        return super.remove(key);
    }

    /**
     * Returns true if this provider implements the given algorithm. Caller
     * must specify the cryptographic service and specify constraints via the
     * attribute name and value.
     *
     * @param serv
     *            Crypto service.
     * @param alg
     *            Algorithm or type.
     * @param attribute
     *            The attribute name or {@code null}.
     * @param val
     *            The attribute value.
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.575 -0500", hash_original_method = "73ADEB588A693290C2EBE420EE1B60DD", hash_generated_method = "73ADEB588A693290C2EBE420EE1B60DD")
    
boolean implementsAlg(String serv, String alg, String attribute, String val) {
        String servAlg = serv + "." + alg;
        String prop = getPropertyIgnoreCase(servAlg);
        if (prop == null) {
            alg = getPropertyIgnoreCase("Alg.Alias." + servAlg);
            if (alg != null) {
                servAlg = serv + "." + alg;
                prop = getPropertyIgnoreCase(servAlg);
            }
        }
        if (prop != null) {
            if (attribute == null) {
                return true;
            }
            return checkAttribute(servAlg, attribute, val);
        }
        return false;
    }

    /**
     * Returns true if this provider has the same value as is given for the
     * given attribute
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.579 -0500", hash_original_method = "205FEBDC4595F3CAF3DB8C26A01A3B21", hash_generated_method = "A183CBD9E1CF30868F2BB1F12CE4231F")
    
private boolean checkAttribute(String servAlg, String attribute, String val) {

        String attributeValue = getPropertyIgnoreCase(servAlg + ' ' + attribute);
        if (attributeValue != null) {
            if (attribute.equalsIgnoreCase("KeySize")) {
                if (Integer.parseInt(attributeValue) >= Integer.parseInt(val)) {
                    return true;
                }
            } else { // other attributes
                if (attributeValue.equalsIgnoreCase(val)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * Set the provider preference order number.
     *
     * @param n
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.581 -0500", hash_original_method = "6418C82159D4FAB251CB16B6C408D61D", hash_generated_method = "6418C82159D4FAB251CB16B6C408D61D")
    
void setProviderNumber(int n) {
        providerNumber = n;
    }

    /**
     *
     * Get the provider preference order number.
     *
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.583 -0500", hash_original_method = "6209D7B36FBC76163C52BAAF1CE53C35", hash_generated_method = "6209D7B36FBC76163C52BAAF1CE53C35")
    
int getProviderNumber() {
        return providerNumber;
    }

    /**
     * Get the service of the specified type
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.586 -0500", hash_original_method = "6BFCD4E62487080CD7F60A29BC4CC43B", hash_generated_method = "385E20844007FA1E258754900640876B")
    
synchronized Provider.Service getService(String type) {
        updatePropertyServiceTable();
        if (lastServicesByType != null && type.equals(lastType)) {
            return lastServicesByType;
        }
        Provider.Service service;
        for (Iterator<Service> it = getServices().iterator(); it.hasNext();) {
            service = it.next();
            if (type.equals(service.type)) {
                lastType = type;
                lastServicesByType = service;
                return service;
            }
        }
        return null;
    }

    /**
     * Returns the service with the specified {@code type} implementing the
     * specified {@code algorithm}, or {@code null} if no such implementation
     * exists.
     * <p>
     * If two services match the requested type and algorithm, the one added
     * with the {@link #putService(Service)} is returned (as opposed to the one
     * added via {@link #put(Object, Object)}.
     *
     * @param type
     *            the type of the service (for example {@code KeyPairGenerator})
     * @param algorithm
     *            the algorithm name (case insensitive)
     * @return the requested service, or {@code null} if no such implementation
     *         exists
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.589 -0500", hash_original_method = "6DABE02DE2A4DD1C36F9592BEF5E1C73", hash_generated_method = "6092AEA38120DE95C74BA12F8C7105D1")
    
public synchronized Provider.Service getService(String type,
            String algorithm) {
        if (type == null || algorithm == null) {
            throw new NullPointerException();
        }

        if (type.equals(lastServiceName) && algorithm.equalsIgnoreCase(lastAlgorithm)) {
            return returnedService;
        }

        String alg = algorithm.toUpperCase(Locale.US);
        Object o = null;
        if (serviceTable != null) {
            o = serviceTable.get(type, alg);
        }
        if (o == null && aliasTable != null) {
            o = aliasTable.get(type, alg);
        }
        if (o == null) {
            updatePropertyServiceTable();
        }
        if (o == null && propertyServiceTable != null) {
            o = propertyServiceTable.get(type, alg);
        }
        if (o == null && propertyAliasTable != null) {
            o = propertyAliasTable.get(type, alg);
        }

        if (o != null) {
            lastServiceName = type;
            lastAlgorithm = algorithm;
            returnedService = (Provider.Service) o;
            return returnedService;
        }
        return null;
    }

    /**
     * Returns an unmodifiable {@code Set} of all services registered by this
     * provider.
     *
     * @return an unmodifiable {@code Set} of all services registered by this
     *         provider
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.591 -0500", hash_original_method = "8008CDA805FE131E4E7ECE670E22E200", hash_generated_method = "B64E4CFF7AEDEFCDD558FB1844E14BEF")
    
public synchronized Set<Provider.Service> getServices() {
        updatePropertyServiceTable();
        if (lastServicesSet != null) {
            return lastServicesSet;
        }
        if (serviceTable != null) {
            lastServicesSet = new HashSet<Service>(serviceTable.values());
        } else {
            lastServicesSet = new HashSet<Service>();
        }
        if (propertyServiceTable != null) {
            lastServicesSet.addAll(propertyServiceTable.values());
        }
        lastServicesSet = Collections.unmodifiableSet(lastServicesSet);
        return lastServicesSet;
    }

    /**
     * Adds a {@code Service} to this {@code Provider}. If a service with the
     * same name was registered via this method, it is replace.
     *
     * @param s
     *            the {@code Service} to register
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.594 -0500", hash_original_method = "3E5E06298B83C020AD9BCF69B9E3CE94", hash_generated_method = "C59B79EF5BF44A0C59EAB028193B3D38")
    
protected synchronized void putService(Provider.Service s) {
        if (s == null) {
            throw new NullPointerException();
        }
        if ("Provider".equals(s.getType())) { // Provider service type cannot be added
            return;
        }
        servicesChanged();
        if (serviceTable == null) {
            serviceTable = new TwoKeyHashMap<String, String, Service>(128);
        }
        serviceTable.put(s.type, s.algorithm.toUpperCase(Locale.US), s);
        if (s.aliases != null) {
            if (aliasTable == null) {
                aliasTable = new TwoKeyHashMap<String, String, Service>(256);
            }
            for (String alias : s.getAliases()) {
                aliasTable.put(s.type, alias.toUpperCase(Locale.US), s);
            }
        }
        serviceInfoToProperties(s);
    }

    /**
     * Removes a previously registered {@code Service} from this {@code
     * Provider}.
     *
     * @param s
     *            the {@code Service} to remove
     * @throws NullPointerException
     *             if {@code s} is {@code null}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.597 -0500", hash_original_method = "D2521231A8F61254D866781010E5F7B6", hash_generated_method = "9B2C122AC640171E096D7904A3212310")
    
protected synchronized void removeService(Provider.Service s) {
        if (s == null) {
            throw new NullPointerException();
        }
        servicesChanged();
        if (serviceTable != null) {
            serviceTable.remove(s.type, s.algorithm.toUpperCase(Locale.US));
        }
        if (aliasTable != null && s.aliases != null) {
            for (String alias: s.getAliases()) {
                aliasTable.remove(s.type, alias.toUpperCase(Locale.US));
            }
        }
        serviceInfoFromProperties(s);
    }

    /**
     * Add Service information to the provider's properties.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.600 -0500", hash_original_method = "FD9674DD64603638CEEAFAAECA2377E1", hash_generated_method = "D7D0290F8321AC414FB87D88F9C34541")
    
private void serviceInfoToProperties(Provider.Service s) {
        super.put(s.type + "." + s.algorithm, s.className);
        if (s.aliases != null) {
            for (Iterator<String> i = s.aliases.iterator(); i.hasNext();) {
                super.put("Alg.Alias." + s.type + "." + i.next(), s.algorithm);
            }
        }
        if (s.attributes != null) {
            for (Map.Entry<String, String> entry : s.attributes.entrySet()) {
                super.put(s.type + "." + s.algorithm + " " + entry.getKey(),
                        entry.getValue());
            }
        }
        if (providerNumber != -1) {
            // if registered then refresh Services
            Services.setNeedRefresh();
        }
    }

    /**
     * Remove Service information from the provider's properties.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.603 -0500", hash_original_method = "E3342D080F10DDAA1FF9ED29EA29694F", hash_generated_method = "4D61001B9F1439AD2DB614C0F3C1D851")
    
private void serviceInfoFromProperties(Provider.Service s) {
        super.remove(s.type + "." + s.algorithm);
        if (s.aliases != null) {
            for (Iterator<String> i = s.aliases.iterator(); i.hasNext();) {
                super.remove("Alg.Alias." + s.type + "." + i.next());
            }
        }
        if (s.attributes != null) {
            for (Map.Entry<String, String> entry : s.attributes.entrySet()) {
                super.remove(s.type + "." + s.algorithm + " " + entry.getKey());
            }
        }
        if (providerNumber != -1) {
            // if registered then refresh Services
            Services.setNeedRefresh();
        }
    }

    // Remove property information from provider Services
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.607 -0500", hash_original_method = "C88E49400116B5906A9CAC0E8D20528B", hash_generated_method = "C2B497AAF7C2D27EC7C8F2192303ED71")
    
private void removeFromPropertyServiceTable(Object key) {
        if (key == null || !(key instanceof String)) {
            return;
        }
        String k = (String) key;
        if (k.startsWith("Provider.")) { // Provider service type is reserved
            return;
        }
        Provider.Service s;
        String serviceName;
        String algorithm = null;
        String attribute = null;
        int i;
        if (k.startsWith("Alg.Alias.")) { // Alg.Alias.<crypto_service>.<aliasName>=<standardName>
            String aliasName;
            String service_alias = k.substring(10);
            i = service_alias.indexOf('.');
            serviceName = service_alias.substring(0, i);
            aliasName = service_alias.substring(i + 1);
            if (propertyAliasTable != null) {
                propertyAliasTable.remove(serviceName, aliasName.toUpperCase(Locale.US));
            }
            if (propertyServiceTable != null) {
                for (Iterator<Service> it = propertyServiceTable.values().iterator(); it
                        .hasNext();) {
                    s = it.next();
                    if (s.aliases.contains(aliasName)) {
                        s.aliases.remove(aliasName);
                        return;
                    }
                }
            }
            return;
        }
        int j = k.indexOf('.');
        if (j == -1) { // unknown format
            return;
        }

        i = k.indexOf(' ');
        if (i == -1) { // <crypto_service>.<algorithm_or_type>=<className>
            serviceName = k.substring(0, j);
            algorithm = k.substring(j + 1);
            if (propertyServiceTable != null) {
                Provider.Service ser = propertyServiceTable.remove(serviceName,
                        algorithm.toUpperCase(Locale.US));
                if (ser != null && propertyAliasTable != null
                        && ser.aliases != null) {
                    for (String alias : ser.aliases) {
                        propertyAliasTable.remove(serviceName, alias.toUpperCase(Locale.US));
                    }
                }
            }
        } else {
            // <crypto_service>.<algorithm_or_type>
            // <attribute_name>=<attrValue>
            attribute = k.substring(i + 1);
            serviceName = k.substring(0, j);
            algorithm = k.substring(j + 1, i);
            if (propertyServiceTable != null) {
                Object o = propertyServiceTable.get(serviceName, algorithm.toUpperCase(Locale.US));
                if (o != null) {
                    s = (Provider.Service) o;
                    s.attributes.remove(attribute);
                }
            }
        }
    }

    // Update provider Services if the properties was changed
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.612 -0500", hash_original_method = "C12B51396475B7F4EF23B74D619C33FD", hash_generated_method = "8B9158D5624B40A3A7946D1814E13306")
    
private void updatePropertyServiceTable() {
        Object _key;
        Object _value;
        Provider.Service s;
        String serviceName;
        String algorithm;
        if (changedProperties == null || changedProperties.isEmpty()) {
            return;
        }
        for (Iterator<Map.Entry<Object, Object>> it = changedProperties.entrySet().iterator(); it
                .hasNext();) {
            Map.Entry<Object, Object> entry = it.next();
            _key = entry.getKey();
            _value = entry.getValue();
            if (_key == null || _value == null || !(_key instanceof String)
                    || !(_value instanceof String)) {
                continue;
            }
            String key = (String) _key;
            String value = (String) _value;
            if (key.startsWith("Provider")) {
                // Provider service type is reserved
                continue;
            }
            int i;
            if (key.startsWith("Alg.Alias.")) {
                // Alg.Alias.<crypto_service>.<aliasName>=<standardName>
                String aliasName;
                String service_alias = key.substring(10);
                i = service_alias.indexOf('.');
                serviceName = service_alias.substring(0, i);
                aliasName = service_alias.substring(i + 1);
                algorithm = value;
                String algUp = algorithm.toUpperCase(Locale.US);
                Object o = null;
                if (propertyServiceTable == null) {
                    propertyServiceTable = new TwoKeyHashMap<String, String, Service>(128);
                } else {
                    o = propertyServiceTable.get(serviceName, algUp);
                }
                if (o != null) {
                    s = (Provider.Service) o;
                    s.addAlias(aliasName);
                    if (propertyAliasTable == null) {
                        propertyAliasTable = new TwoKeyHashMap<String, String, Service>(256);
                    }
                    propertyAliasTable.put(serviceName, aliasName.toUpperCase(Locale.US), s);
                } else {
                    String className = (String) changedProperties
                            .get(serviceName + "." + algorithm);
                    if (className != null) {
                        List<String> l = new ArrayList<String>();
                        l.add(aliasName);
                        s = new Provider.Service(this, serviceName, algorithm,
                                className, l, new HashMap<String, String>());
                        propertyServiceTable.put(serviceName, algUp, s);
                        if (propertyAliasTable == null) {
                            propertyAliasTable = new TwoKeyHashMap<String, String, Service>(256);
                        }
                        propertyAliasTable.put(serviceName, aliasName.toUpperCase(Locale.US), s);
                    }
                }
                continue;
            }
            int j = key.indexOf('.');
            if (j == -1) { // unknown format
                continue;
            }
            i = key.indexOf(' ');
            if (i == -1) { // <crypto_service>.<algorithm_or_type>=<className>
                serviceName = key.substring(0, j);
                algorithm = key.substring(j + 1);
                String alg = algorithm.toUpperCase(Locale.US);
                Object o = null;
                if (propertyServiceTable != null) {
                    o = propertyServiceTable.get(serviceName, alg);
                }
                if (o != null) {
                    s = (Provider.Service) o;
                    s.className = value;
                } else {
                    s = new Provider.Service(this, serviceName, algorithm,
                            value, Collections.<String>emptyList(),
                            Collections.<String,String>emptyMap());
                    if (propertyServiceTable == null) {
                        propertyServiceTable = new TwoKeyHashMap<String, String, Service>(128);
                    }
                    propertyServiceTable.put(serviceName, alg, s);

                }
            } else {
                // <crypto_service>.<algorithm_or_type>
                // <attribute_name>=<attrValue>
                serviceName = key.substring(0, j);
                algorithm = key.substring(j + 1, i);
                String attribute = key.substring(i + 1);
                String alg = algorithm.toUpperCase(Locale.US);
                Object o = null;
                if (propertyServiceTable != null) {
                    o = propertyServiceTable.get(serviceName, alg);
                }
                if (o != null) {
                    s = (Provider.Service) o;
                    s.putAttribute(attribute, value);
                } else {
                    String className = (String) changedProperties
                            .get(serviceName + "." + algorithm);
                    if (className != null) {
                        Map<String, String> m = new HashMap<String, String>();
                        m.put(attribute, value);
                        s = new Provider.Service(this, serviceName, algorithm,
                                className, new ArrayList<String>(), m);
                        if (propertyServiceTable == null) {
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.615 -0500", hash_original_method = "FD7619437CD0960F1AEBA32A154F0328", hash_generated_method = "50491896FAEB0E038FDF5FAAA30D570E")
    
private void servicesChanged() {
        lastServicesByType = null;
        lastServiceName = null;
        lastServicesSet = null;
    }

    /**
     * These attributes should be placed in each Provider object:
     * Provider.id name, Provider.id version, Provider.id info,
     * Provider.id className
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.617 -0500", hash_original_method = "768CFC89B63FD1F782E3758D2BCFC6C0", hash_generated_method = "5015F2E16C69CBCFCDD551A44B3B427A")
    
private void putProviderInfo() {
        super.put("Provider.id name", (name != null) ? name : "null");
        super.put("Provider.id version", versionString);
        super.put("Provider.id info", (info != null) ? info : "null");
        super.put("Provider.id className", this.getClass().getName());
    }

    /**
     * Returns the property with the specified key in the provider properties.
     * The name is not case-sensitive.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.620 -0500", hash_original_method = "62DD35352FE8FA7B38C17798ED376C47", hash_generated_method = "37F9540DCE2170D70E8B0274ECC1D5A1")
    
private String getPropertyIgnoreCase(String key) {
        String res = getProperty(key);
        if (res != null) {
            return res;
        }
        for (Enumeration<?> e = propertyNames(); e.hasMoreElements(); ) {
            String propertyName = (String) e.nextElement();
            if (key.equalsIgnoreCase(propertyName)) {
                return getProperty(propertyName);
            }
        }
        return null;
    }

    
    public static class Service {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.623 -0500", hash_original_field = "70389BF55D92237F4948951640719A18", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

        private Provider provider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.626 -0500", hash_original_field = "1B03D0EF3E71EB350936336F82D5E0C5", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

        private String type;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.628 -0500", hash_original_field = "1DDAED4286CC7F9A2BC49502885440CE", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

        private String algorithm;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.630 -0500", hash_original_field = "CA6BE7A479C5F3E68F3687DBA3A4A48F", hash_generated_field = "B28341EF6B88AA3CAD2D37FF14C9DC00")

        private String className;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.633 -0500", hash_original_field = "415C814CE169EAD34693D0F995E1A19B", hash_generated_field = "7D96162B1AE01DA7357D6662D8D2C584")

        private List<String> aliases;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.635 -0500", hash_original_field = "7BD070E0DF05CBBC32CE293883F53D7D", hash_generated_field = "1CEAC23D4A656E23182C27FC3A78AEDE")

        private Map<String,String> attributes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.637 -0500", hash_original_field = "B94DDC1B82FD51FADE5A2597B7A711FB", hash_generated_field = "28101B8550628F94A8DDB23FAF399E56")

        private Class<?> implementation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.640 -0500", hash_original_field = "E1CFBE46315EAA712AA37DF524EC67A9", hash_generated_field = "668E14A773F053D0B44156BD480B724E")

        private String lastClassName;

        /**
         * Constructs a new instance of {@code Service} with the given
         * attributes.
         *
         * @param provider
         *            the provider to which this service belongs.
         * @param type
         *            the type of this service (for example {@code
         *            KeyPairGenerator}).
         * @param algorithm
         *            the algorithm this service implements.
         * @param className
         *            the name of the class implementing this service.
         * @param aliases
         *            {@code List} of aliases for the algorithm name, or {@code
         *            null} if the implemented algorithm has no aliases.
         * @param attributes
         *            {@code Map} of additional attributes, or {@code null} if
         *            this {@code Service} has no attributed.
         * @throws NullPointerException
         *             if {@code provider, type, algorithm} or {@code className}
         *             is {@code null}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.644 -0500", hash_original_method = "82CB06DCD943152835D64FFE915BA566", hash_generated_method = "8C01A874BC7D09D79004065917F5D41C")
        
public Service(Provider provider, String type, String algorithm,
                String className, List<String> aliases, Map<String, String> attributes) {
            if (provider == null || type == null || algorithm == null
                    || className == null) {
                throw new NullPointerException();
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

        /**
         * Adds an alias.
         *
         * @param alias the alias to add
         */
        /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.646 -0500", hash_original_method = "4CA8000463C36260BD9C3E4A41E197CE", hash_generated_method = "4CA8000463C36260BD9C3E4A41E197CE")
        
void addAlias(String alias) {
            if ((aliases == null) || (aliases.size() == 0)) {
                aliases = new ArrayList<String>();
            }
            aliases.add(alias);
        }

        /**
         * Puts a new attribute mapping.
         *
         * @param name the attribute name.
         * @param value the attribute value.
         */
        /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.649 -0500", hash_original_method = "2623207C72797F9950DF9980B680F416", hash_generated_method = "2623207C72797F9950DF9980B680F416")
        
void putAttribute(String name, String value) {
            if ((attributes == null) || (attributes.size() == 0)) {
                attributes = new HashMap<String,String>();
            }
            attributes.put(name, value);
        }

        /**
         * Returns the type of this {@code Service}. For example {@code
         * KeyPairGenerator}.
         *
         * @return the type of this {@code Service}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.651 -0500", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "B5025B3379E65F477B29B0C5C8B783DF")
        
public final String getType() {
            return type;
        }

        /**
         * Returns the name of the algorithm implemented by this {@code
         * Service}.
         *
         * @return the name of the algorithm implemented by this {@code
         *         Service}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.654 -0500", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "8A7AA6162519FFB2228039F3D6331CE9")
        
public final String getAlgorithm() {
            return algorithm;
        }

        /**
         * Returns the {@code Provider} this {@code Service} belongs to.
         *
         * @return the {@code Provider} this {@code Service} belongs to.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.657 -0500", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "443000CF13C77ABCABFC8B67E2DE556F")
        
public final Provider getProvider() {
            return provider;
        }

        /**
         * Returns the name of the class implementing this {@code Service}.
         *
         * @return the name of the class implementing this {@code Service}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.659 -0500", hash_original_method = "8415940D3A1E5651F883E391EC68DA41", hash_generated_method = "6F8397AF6B6307E3E16D7AA5343B4357")
        
public final String getClassName() {
            return className;
        }

        /**
         * Returns the value of the attribute with the specified {@code name}.
         *
         * @param name
         *            the name of the attribute.
         * @return the value of the attribute, or {@code null} if no attribute
         *         with the given name is set.
         * @throws NullPointerException
         *             if {@code name} is {@code null}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.662 -0500", hash_original_method = "0C10317D01C11D1034B9356679E58CA0", hash_generated_method = "C0E670EE7DC6D3A2B10A0AC8916D30AF")
        
public final String getAttribute(String name) {
            if (name == null) {
                throw new NullPointerException();
            }
            if (attributes == null) {
                return null;
            }
            return attributes.get(name);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.664 -0500", hash_original_method = "7A6F8F40D5019A1C644CF7CAD3518923", hash_generated_method = "7A6F8F40D5019A1C644CF7CAD3518923")
        
List<String> getAliases() {
            if (aliases == null){
                aliases = new ArrayList<String>(0);
            }
            return aliases;
        }

        /**
         * Creates and returns a new instance of the implementation described by
         * this {@code Service}.
         *
         * @param constructorParameter
         *            the parameter that is used by the constructor, or {@code
         *            null} if the implementation does not declare a constructor
         *            parameter.
         * @return a new instance of the implementation described by this
         *         {@code Service}.
         * @throws NoSuchAlgorithmException
         *             if the instance could not be constructed.
         * @throws InvalidParameterException
         *             if the implementation does not support the specified
         *             {@code constructorParameter}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.668 -0500", hash_original_method = "802A5A00EF15D2BF7FB674CB175B5DD7", hash_generated_method = "ED1124F77657D1F0F82CEA96D81121C3")
        
public Object newInstance(Object constructorParameter) throws NoSuchAlgorithmException {
            if (implementation == null || !className.equals(lastClassName)) {
                ClassLoader cl = provider.getClass().getClassLoader();
                if (cl == null) {
                    cl = ClassLoader.getSystemClassLoader();
                }
                try {
                    implementation = Class.forName(className, true, cl);
                    lastClassName = className;
                } catch (Exception e) {
                    throw new NoSuchAlgorithmException(type + " " + algorithm + " implementation not found: " + e);
                }
            }
            if (constructorParameter == null) {
                try {
                    return implementation.newInstance();
                } catch (Exception e) {
                    throw new NoSuchAlgorithmException(
                            type + " " + algorithm + " implementation not found", e);
                }
            }
            if (!supportsParameter(constructorParameter)) {
                throw new InvalidParameterException(type + ": service cannot use the parameter");
            }

            Class[] parameterTypes = new Class[1];
            Object[] initargs = { constructorParameter };
            try {
                if (type.equalsIgnoreCase("CertStore")) {
                    parameterTypes[0] = Class.forName("java.security.cert.CertStoreParameters");
                } else {
                    parameterTypes[0] = constructorParameter.getClass();
                }
                return implementation.getConstructor(parameterTypes)
                        .newInstance(initargs);
            } catch (Exception e) {
                throw new NoSuchAlgorithmException(type + " " + algorithm
                        + " implementation not found", e);
            }
        }

        /**
         * Indicates whether this {@code Service} supports the specified
         * constructor parameter.
         *
         * @param parameter
         *            the parameter to test.
         * @return {@code true} if this {@code Service} supports the specified
         *         constructor parameter, {@code false} otherwise.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.671 -0500", hash_original_method = "A158C77880B526D8A49B8720A1D647AC", hash_generated_method = "202C14D3D0A4609F8DB71319237AE9F2")
        
public boolean supportsParameter(Object parameter) {
            return true;
        }

        /**
         * Returns a string containing a concise, human-readable description of
         * this {@code Service}.
         *
         * @return a printable representation for this {@code Service}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.674 -0500", hash_original_method = "CD20F19EDED4066F9FA28FD55133940E", hash_generated_method = "675135E2E35D5FD4AB2F8A57F9F70EB1")
        
@Override
        public String toString() {
            String result = "Provider " + provider.getName() + " Service "
                    + type + "." + algorithm + " " + className;
            if (aliases != null) {
                result = result + "\nAliases " + aliases.toString();
            }
            if (attributes != null) {
                result = result + "\nAttributes " + attributes.toString();
            }
            return result;
        }

        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.679 -0500", hash_original_method = "C9BE26B06AA230EA20C77B7F366C53C8", hash_generated_method = "D50942787AE2BFE587FDA0A0E3563B48")
    
private void readObject(java.io.ObjectInputStream in)
            throws NotActiveException, IOException, ClassNotFoundException {
        in.defaultReadObject();
        versionString = String.valueOf(version);
        providerNumber = -1;
    }
}

