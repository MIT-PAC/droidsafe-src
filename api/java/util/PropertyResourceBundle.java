package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class PropertyResourceBundle extends ResourceBundle {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.465 -0400", hash_original_field = "55B558C7EF820E6E00E5993B9E55D93B", hash_generated_field = "8C97A55243F1F4D2EF7A784DA96E106B")

    Properties resources;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.466 -0400", hash_original_method = "3D88428E114136417B3FF5D84DADF880", hash_generated_method = "8DE0A2B3C1D1947C182BE8679A283779")
    public  PropertyResourceBundle(InputStream stream) throws IOException {
        addTaint(stream.getTaint());
    if(stream == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_433076017 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_433076017.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_433076017;
        } //End block
        resources = new Properties();
        resources.load(stream);
        // ---------- Original Method ----------
        //if (stream == null) {
            //throw new NullPointerException();
        //}
        //resources = new Properties();
        //resources.load(stream);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.466 -0400", hash_original_method = "51B0205103DDC756BC77F911CC2E7B89", hash_generated_method = "585E5D540BC25846CCF84EF424ECB2B2")
    public  PropertyResourceBundle(Reader reader) throws IOException {
        addTaint(reader.getTaint());
        resources = new Properties();
        resources.load(reader);
        // ---------- Original Method ----------
        //resources = new Properties();
        //resources.load(reader);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.466 -0400", hash_original_method = "18F63E7C5AB3934B8351CB4BC2CE0CC3", hash_generated_method = "3BEBFBD1687EFC19C9B80AC9B4E780D0")
    protected Set<String> handleKeySet() {
Set<String> var0EAA476BE58006F42D4C65D603A3959B_20943247 =         resources.stringPropertyNames();
        var0EAA476BE58006F42D4C65D603A3959B_20943247.addTaint(taint);
        return var0EAA476BE58006F42D4C65D603A3959B_20943247;
        // ---------- Original Method ----------
        //return resources.stringPropertyNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.467 -0400", hash_original_method = "94C0F4CF2CD414C406604EC575DAD3DD", hash_generated_method = "EE6AE5F8D984077418214CDEFFF0FB81")
    @SuppressWarnings("unchecked")
    private Enumeration<String> getLocalKeys() {
Enumeration<String> varA865D04F5518808831D04C06BBF9E25E_1552242915 =         (Enumeration<String>) resources.propertyNames();
        varA865D04F5518808831D04C06BBF9E25E_1552242915.addTaint(taint);
        return varA865D04F5518808831D04C06BBF9E25E_1552242915;
        // ---------- Original Method ----------
        //return (Enumeration<String>) resources.propertyNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.469 -0400", hash_original_method = "8070DEE7B7CBE3EB8E3AF8AF6FE9DBC6", hash_generated_method = "1FC4F2876773D5C33FD51D3FECF2BA7E")
    @Override
    public Enumeration<String> getKeys() {
    if(parent == null)        
        {
Enumeration<String> var6BDB3A965228957FB4A93D8CFE026B07_1828917257 =             getLocalKeys();
            var6BDB3A965228957FB4A93D8CFE026B07_1828917257.addTaint(taint);
            return var6BDB3A965228957FB4A93D8CFE026B07_1828917257;
        } //End block
Enumeration<String> var4CA9A63005EB1C17FE61CAE8215EBA5B_672783187 =         new Enumeration<String>() {        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.467 -0400", hash_original_field = "86E09BF7152A875F2EB007DC9547307A", hash_generated_field = "975E55A4433F6ABC0D4D089A47474FE3")
        Enumeration<String> local = getLocalKeys();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.467 -0400", hash_original_field = "57F37C14C65A377A117E2FA9BCD9E124", hash_generated_field = "FAE3DF1DF9E3B04E9DEEE6F9A562DFE9")
        Enumeration<String> pEnum = parent.getKeys();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.467 -0400", hash_original_field = "597A00560349D4451A3F2269B8E761F0", hash_generated_field = "FF87A8DA236D1EFD9A42BCA9DA4A458F")
        String nextElement;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.468 -0400", hash_original_method = "7E529D209593DF12DACEC799F2DDAEB1", hash_generated_method = "6AF1BAB236668570E181D510B294F357")
        private boolean findNext() {
    if(nextElement != null)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1241395090 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1872001220 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1872001220;
            } //End block
            while
(pEnum.hasMoreElements())            
            {
                String next = pEnum.nextElement();
    if(!resources.containsKey(next))                
                {
                    nextElement = next;
                    boolean varB326B5062B2F0E69046810717534CB09_1115586652 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1536334996 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1536334996;
                } //End block
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_2002103439 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1842185429 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1842185429;
            // ---------- Original Method ----------
            //if (nextElement != null) {
                    //return true;
                //}
            //while (pEnum.hasMoreElements()) {
                    //String next = pEnum.nextElement();
                    //if (!resources.containsKey(next)) {
                        //nextElement = next;
                        //return true;
                    //}
                //}
            //return false;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.468 -0400", hash_original_method = "0C8D02D40B56817F2309824D8D7773D2", hash_generated_method = "C09F21E08A8340718F8F3E567C4E8293")
        public boolean hasMoreElements() {
    if(local.hasMoreElements())            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1937281872 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2002591907 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2002591907;
            } //End block
            boolean var1B0169DB7518C68DDFF6F3046195CB57_1218597314 = (findNext());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1159946095 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1159946095;
            // ---------- Original Method ----------
            //if (local.hasMoreElements()) {
                    //return true;
                //}
            //return findNext();
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.469 -0400", hash_original_method = "BE1AA467D8342A7EF3FB49068D3D4458", hash_generated_method = "24EE999573ECF2A755F77FB9EDB00185")
        public String nextElement() {
    if(local.hasMoreElements())            
            {
String varB945B0A7BBA20D33AF59AD34C191B850_463673979 =                 local.nextElement();
                varB945B0A7BBA20D33AF59AD34C191B850_463673979.addTaint(taint);
                return varB945B0A7BBA20D33AF59AD34C191B850_463673979;
            } //End block
    if(findNext())            
            {
                String result = nextElement;
                nextElement = null;
String varDC838461EE2FA0CA4C9BBB70A15456B0_853660897 =                 result;
                varDC838461EE2FA0CA4C9BBB70A15456B0_853660897.addTaint(taint);
                return varDC838461EE2FA0CA4C9BBB70A15456B0_853660897;
            } //End block
String varC31A54EE9D4A2AA28C7FB87214BBE87B_30465780 =             pEnum.nextElement();
            varC31A54EE9D4A2AA28C7FB87214BBE87B_30465780.addTaint(taint);
            return varC31A54EE9D4A2AA28C7FB87214BBE87B_30465780;
            // ---------- Original Method ----------
            //if (local.hasMoreElements()) {
                    //return local.nextElement();
                //}
            //if (findNext()) {
                    //String result = nextElement;
                    //nextElement = null;
                    //return result;
                //}
            //return pEnum.nextElement();
        }
};
        var4CA9A63005EB1C17FE61CAE8215EBA5B_672783187.addTaint(taint);
        return var4CA9A63005EB1C17FE61CAE8215EBA5B_672783187;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.470 -0400", hash_original_method = "23544B256E22E0E7C2784DAFEBE5A56C", hash_generated_method = "9920EDE4B3ECE4BF7B1FE328112FD175")
    @Override
    public Object handleGetObject(String key) {
        addTaint(key.getTaint());
Object varA4014D977EFFED8D43A4516F0A521C26_255694483 =         resources.get(key);
        varA4014D977EFFED8D43A4516F0A521C26_255694483.addTaint(taint);
        return varA4014D977EFFED8D43A4516F0A521C26_255694483;
        // ---------- Original Method ----------
        //return resources.get(key);
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
    
    // orphaned legacy field
    Enumeration<String> local = getLocalKeys();
    
    // orphaned legacy field
    Enumeration<String> pEnum = parent.getKeys();
    
    // orphaned legacy field
    String nextElement;
    
}

