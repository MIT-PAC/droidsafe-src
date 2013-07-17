package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class PropertyResourceBundle extends ResourceBundle {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.506 -0400", hash_original_field = "55B558C7EF820E6E00E5993B9E55D93B", hash_generated_field = "8C97A55243F1F4D2EF7A784DA96E106B")

    Properties resources;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.506 -0400", hash_original_method = "3D88428E114136417B3FF5D84DADF880", hash_generated_method = "CF01C44F4E081721EC22DA47523BCD97")
    public  PropertyResourceBundle(InputStream stream) throws IOException {
        addTaint(stream.getTaint());
        if(stream == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_175625007 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_175625007.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_175625007;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.507 -0400", hash_original_method = "51B0205103DDC756BC77F911CC2E7B89", hash_generated_method = "585E5D540BC25846CCF84EF424ECB2B2")
    public  PropertyResourceBundle(Reader reader) throws IOException {
        addTaint(reader.getTaint());
        resources = new Properties();
        resources.load(reader);
        // ---------- Original Method ----------
        //resources = new Properties();
        //resources.load(reader);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.507 -0400", hash_original_method = "18F63E7C5AB3934B8351CB4BC2CE0CC3", hash_generated_method = "6A84E7D2947BB0F7C2BAF1ADE4ECE47D")
    protected Set<String> handleKeySet() {
Set<String> var0EAA476BE58006F42D4C65D603A3959B_708214916 =         resources.stringPropertyNames();
        var0EAA476BE58006F42D4C65D603A3959B_708214916.addTaint(taint);
        return var0EAA476BE58006F42D4C65D603A3959B_708214916;
        // ---------- Original Method ----------
        //return resources.stringPropertyNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.507 -0400", hash_original_method = "94C0F4CF2CD414C406604EC575DAD3DD", hash_generated_method = "95E3F1EAAAE7EA9BF9CB2133A7BF3ABA")
    @SuppressWarnings("unchecked")
    private Enumeration<String> getLocalKeys() {
Enumeration<String> varA865D04F5518808831D04C06BBF9E25E_2015124119 =         (Enumeration<String>) resources.propertyNames();
        varA865D04F5518808831D04C06BBF9E25E_2015124119.addTaint(taint);
        return varA865D04F5518808831D04C06BBF9E25E_2015124119;
        // ---------- Original Method ----------
        //return (Enumeration<String>) resources.propertyNames();
    }

    
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.508 -0400", hash_original_method = "7E529D209593DF12DACEC799F2DDAEB1", hash_generated_method = "A7E8C01149F02276671393F6572A7041")
        private boolean findNext() {
            if(nextElement != null)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_37492560 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_677153756 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_677153756;
            } //End block
            while
(pEnum.hasMoreElements())            
            {
                String next = pEnum.nextElement();
                if(!resources.containsKey(next))                
                {
                    nextElement = next;
                    boolean varB326B5062B2F0E69046810717534CB09_1274780324 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_740737005 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_740737005;
                } //End block
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_1652735369 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1017547520 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1017547520;
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.509 -0400", hash_original_method = "0C8D02D40B56817F2309824D8D7773D2", hash_generated_method = "458498149C6BB16F362C57086834C7C0")
        public boolean hasMoreElements() {
            if(local.hasMoreElements())            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1287054530 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_408347524 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_408347524;
            } //End block
            boolean var1B0169DB7518C68DDFF6F3046195CB57_1968854923 = (findNext());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1251730113 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1251730113;
            // ---------- Original Method ----------
            //if (local.hasMoreElements()) {
                    //return true;
                //}
            //return findNext();
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.509 -0400", hash_original_method = "BE1AA467D8342A7EF3FB49068D3D4458", hash_generated_method = "F5317B576E04907C39CFCD171AAEC9EF")
        public String nextElement() {
            if(local.hasMoreElements())            
            {
String varB945B0A7BBA20D33AF59AD34C191B850_61202448 =                 local.nextElement();
                varB945B0A7BBA20D33AF59AD34C191B850_61202448.addTaint(taint);
                return varB945B0A7BBA20D33AF59AD34C191B850_61202448;
            } //End block
            if(findNext())            
            {
                String result = nextElement;
                nextElement = null;
String varDC838461EE2FA0CA4C9BBB70A15456B0_1510026641 =                 result;
                varDC838461EE2FA0CA4C9BBB70A15456B0_1510026641.addTaint(taint);
                return varDC838461EE2FA0CA4C9BBB70A15456B0_1510026641;
            } //End block
String varC31A54EE9D4A2AA28C7FB87214BBE87B_991493834 =             pEnum.nextElement();
            varC31A54EE9D4A2AA28C7FB87214BBE87B_991493834.addTaint(taint);
            return varC31A54EE9D4A2AA28C7FB87214BBE87B_991493834;
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
        var4CA9A63005EB1C17FE61CAE8215EBA5B_1061038075.addTaint(taint);
        return var4CA9A63005EB1C17FE61CAE8215EBA5B_1061038075;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.510 -0400", hash_original_method = "23544B256E22E0E7C2784DAFEBE5A56C", hash_generated_method = "EB942733D3C1ED702581DE463B8CED44")
    @Override
    public Object handleGetObject(String key) {
        addTaint(key.getTaint());
Object varA4014D977EFFED8D43A4516F0A521C26_824898648 =         resources.get(key);
        varA4014D977EFFED8D43A4516F0A521C26_824898648.addTaint(taint);
        return varA4014D977EFFED8D43A4516F0A521C26_824898648;
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

