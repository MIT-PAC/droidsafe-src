package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class PropertyResourceBundle extends ResourceBundle {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.728 -0500", hash_original_field = "8C97A55243F1F4D2EF7A784DA96E106B", hash_generated_field = "8C97A55243F1F4D2EF7A784DA96E106B")

    Properties resources;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.743 -0500", hash_original_field = "975E55A4433F6ABC0D4D089A47474FE3", hash_generated_field = "975E55A4433F6ABC0D4D089A47474FE3")

            Enumeration<String> local = getLocalKeys();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.745 -0500", hash_original_field = "FAE3DF1DF9E3B04E9DEEE6F9A562DFE9", hash_generated_field = "FAE3DF1DF9E3B04E9DEEE6F9A562DFE9")

            Enumeration<String> pEnum = parent.getKeys();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.748 -0500", hash_original_field = "FF87A8DA236D1EFD9A42BCA9DA4A458F", hash_generated_field = "FF87A8DA236D1EFD9A42BCA9DA4A458F")

            String nextElement;

    /**
     * Constructs a new instance of {@code PropertyResourceBundle} and loads the
     * properties file from the specified {@code InputStream}.
     *
     * @param stream
     *            the {@code InputStream}.
     * @throws IOException
     *             if an error occurs during a read operation on the
     *             {@code InputStream}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.732 -0500", hash_original_method = "3D88428E114136417B3FF5D84DADF880", hash_generated_method = "3194B03B089A93D6463684DFC69D6F50")
    
public PropertyResourceBundle(InputStream stream) throws IOException {
        if (stream == null) {
            throw new NullPointerException();
        }
        resources = new Properties();
        resources.load(stream);
    }

    /**
     * Constructs a new resource bundle with properties read from {@code reader}.
     *
     * @param reader the {@code Reader}
     * @throws IOException
     * @since 1.6
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.735 -0500", hash_original_method = "51B0205103DDC756BC77F911CC2E7B89", hash_generated_method = "CC37C88192FB4C086F7EC5BD6987157A")
    
public PropertyResourceBundle(Reader reader) throws IOException {
        resources = new Properties();
        resources.load(reader);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.737 -0500", hash_original_method = "18F63E7C5AB3934B8351CB4BC2CE0CC3", hash_generated_method = "C72677F3EC58A35DD625E99528B9144E")
    
protected Set<String> handleKeySet(){
        return resources.stringPropertyNames();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.740 -0500", hash_original_method = "94C0F4CF2CD414C406604EC575DAD3DD", hash_generated_method = "B78F2820BC5D9559917C4E7B0A6D4DBB")
    
@SuppressWarnings("unchecked")
    private Enumeration<String> getLocalKeys() {
        return (Enumeration<String>) resources.propertyNames();
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.509 -0400", hash_original_method = "8070DEE7B7CBE3EB8E3AF8AF6FE9DBC6", hash_generated_method = "3D01932958A4F18257C01F21A74B1E7B")
    @Override
    public Enumeration<String> getKeys() {
        if(parent == null)        
        {
Enumeration<String> var6BDB3A965228957FB4A93D8CFE026B07_1233927182 =             getLocalKeys();
            var6BDB3A965228957FB4A93D8CFE026B07_1233927182.addTaint(taint);
            return var6BDB3A965228957FB4A93D8CFE026B07_1233927182;
        } //End block
Enumeration<String> var4CA9A63005EB1C17FE61CAE8215EBA5B_1061038075 =         new Enumeration<String>() {        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.508 -0400", hash_original_field = "86E09BF7152A875F2EB007DC9547307A", hash_generated_field = "975E55A4433F6ABC0D4D089A47474FE3")
        Enumeration<String> local = getLocalKeys();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.508 -0400", hash_original_field = "57F37C14C65A377A117E2FA9BCD9E124", hash_generated_field = "FAE3DF1DF9E3B04E9DEEE6F9A562DFE9")
        Enumeration<String> pEnum = parent.getKeys();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.508 -0400", hash_original_field = "597A00560349D4451A3F2269B8E761F0", hash_generated_field = "FF87A8DA236D1EFD9A42BCA9DA4A458F")
        String nextElement;

            @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.751 -0500", hash_original_method = "7E529D209593DF12DACEC799F2DDAEB1", hash_generated_method = "C8EB56A16F0592A9C0229794EA62C50D")
            
private boolean findNext() {
                if (nextElement != null) {
                    return true;
                }
                while (pEnum.hasMoreElements()) {
                    String next = pEnum.nextElement();
                    if (!resources.containsKey(next)) {
                        nextElement = next;
                        return true;
                    }
                }
                return false;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.753 -0500", hash_original_method = "0C8D02D40B56817F2309824D8D7773D2", hash_generated_method = "5ADB6DE9484CA7D74BE3178191CB527C")
            
public boolean hasMoreElements() {
                if (local.hasMoreElements()) {
                    return true;
                }
                return findNext();
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.756 -0500", hash_original_method = "BE1AA467D8342A7EF3FB49068D3D4458", hash_generated_method = "1C519444C9B1D12270F3414AC60E3B19")
            
public String nextElement() {
                if (local.hasMoreElements()) {
                    return local.nextElement();
                }
                if (findNext()) {
                    String result = nextElement;
                    nextElement = null;
                    return result;
                }
                // Cause an exception
                return pEnum.nextElement();
            }
};
        var4CA9A63005EB1C17FE61CAE8215EBA5B_1061038075.addTaint(taint);
        return var4CA9A63005EB1C17FE61CAE8215EBA5B_1061038075;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.762 -0500", hash_original_method = "23544B256E22E0E7C2784DAFEBE5A56C", hash_generated_method = "4E529C8B8C31521875714D968CBBB6E9")
    
@Override
    public Object handleGetObject(String key) {
        return resources.get(key);
    }
    
    // orphaned legacy method
    public String nextElement() {
                if (local.hasMoreElements()) {
                    return local.nextElement();
                }
                if (findNext()) {
                    String result = nextElement;
                    nextElement = null;
                    return result;
                }
                return pEnum.nextElement();
            }
    
    // orphaned legacy method
    private boolean findNext() {
                if (nextElement != null) {
                    return true;
                }
                while (pEnum.hasMoreElements()) {
                    String next = pEnum.nextElement();
                    if (!resources.containsKey(next)) {
                        nextElement = next;
                        return true;
                    }
                }
                return false;
            }
    
    // orphaned legacy method
    public boolean hasMoreElements() {
                if (local.hasMoreElements()) {
                    return true;
                }
                return findNext();
            }
    
}

