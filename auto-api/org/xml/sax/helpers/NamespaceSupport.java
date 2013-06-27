package org.xml.sax.helpers;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.Enumeration;
import java.util.Hashtable;

public class NamespaceSupport {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.337 -0400", hash_original_field = "7E0A10944FD50182E16E23B0A3D9335C", hash_generated_field = "C9FE6E28AC860EBE1DBAB5714D1187ED")

    private Context contexts[];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.337 -0400", hash_original_field = "A1F907D66151216045ACBF9ABBF0333F", hash_generated_field = "16BCC2B5B5C19EE2FA8800AE041E507F")

    private Context currentContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.337 -0400", hash_original_field = "34DD546BFAFA2A58B969006E4646341D", hash_generated_field = "6E7F5C2FF9D13C809071AD4BD4B43575")

    private int contextPos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.337 -0400", hash_original_field = "1B0E32CE3D1C65D78D4D87360D96EF74", hash_generated_field = "93D47AA8737E27469EC5299DD6FB86D0")

    private boolean namespaceDeclUris;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.337 -0400", hash_original_method = "1F62AD2938072A93E19EAFFCDA555D07", hash_generated_method = "5851AF68D843BB425B4FF66193756222")
    public  NamespaceSupport() {
        reset();
        // ---------- Original Method ----------
        //reset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.339 -0400", hash_original_method = "2A27A75937E4BE02DA5FD7B031C4079A", hash_generated_method = "AD54F05B2FA16CFBF38021AFA9C2A42C")
    public void reset() {
        contexts = new Context[32];
        namespaceDeclUris = false;
        contextPos = 0;
        contexts[contextPos] = currentContext = new Context();
        currentContext.declarePrefix("xml", XMLNS);
        // ---------- Original Method ----------
        //contexts = new Context[32];
        //namespaceDeclUris = false;
        //contextPos = 0;
        //contexts[contextPos] = currentContext = new Context();
        //currentContext.declarePrefix("xml", XMLNS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.341 -0400", hash_original_method = "B186F7F0BF353B1A746862E337C50A69", hash_generated_method = "92014D447E292E0B17DCC515DB962E03")
    public void pushContext() {
        int max;
        max = contexts.length;
        contexts [contextPos].declsOK = false;
        {
            Context newContexts[];
            newContexts = new Context[max*2];
            System.arraycopy(contexts, 0, newContexts, 0, max);
            max *= 2;
            contexts = newContexts;
        } //End block
        currentContext = contexts[contextPos];
        {
            contexts[contextPos] = currentContext = new Context();
        } //End block
        {
            currentContext.setParent(contexts[contextPos - 1]);
        } //End block
        // ---------- Original Method ----------
        //int max = contexts.length;
        //contexts [contextPos].declsOK = false;
        //contextPos++;
        //if (contextPos >= max) {
        //Context newContexts[] = new Context[max*2];
        //System.arraycopy(contexts, 0, newContexts, 0, max);
        //max *= 2;
        //contexts = newContexts;
    //}
        //currentContext = contexts[contextPos];
        //if (currentContext == null) {
        //contexts[contextPos] = currentContext = new Context();
    //}
        //if (contextPos > 0) {
        //currentContext.setParent(contexts[contextPos - 1]);
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.342 -0400", hash_original_method = "D28ACF4ED7DED6C7ED370F52380381BA", hash_generated_method = "ED5C2325002017E243DEE0E4AD88FB26")
    public void popContext() {
        contexts[contextPos].clear();
        {
            if (DroidSafeAndroidRuntime.control) throw new EmptyStackException();
        } //End block
        currentContext = contexts[contextPos];
        // ---------- Original Method ----------
        //contexts[contextPos].clear();
        //contextPos--;
        //if (contextPos < 0) {
        //throw new EmptyStackException();
    //}
        //currentContext = contexts[contextPos];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.342 -0400", hash_original_method = "90A3EE210CAE689DFC3CD58893529A76", hash_generated_method = "ED1B6CFBBFB46E1C60E016A3E0F32094")
    public boolean declarePrefix(String prefix, String uri) {
        {
            boolean var6CD89D1BDC90A7556F69D069AB4E587C_183873562 = (prefix.equals("xml") || prefix.equals("xmlns"));
            {
                currentContext.declarePrefix(prefix, uri);
            } //End block
        } //End collapsed parenthetic
        addTaint(prefix.getTaint());
        addTaint(uri.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_605097398 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_605097398;
        // ---------- Original Method ----------
        //if (prefix.equals("xml") || prefix.equals("xmlns")) {
        //return false;
    //} else {
        //currentContext.declarePrefix(prefix, uri);
        //return true;
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.378 -0400", hash_original_method = "568BC23E816C8735D1D944210F1F3C08", hash_generated_method = "C897A8766E3F005CE71FCDD1359239B1")
    public String [] processName(String qName, String parts[],
                  boolean isAttribute) {
        String [] varB4EAC82CA7396A68D541C85D26508E83_666597505 = null; //Variable for return #1
        String [] varB4EAC82CA7396A68D541C85D26508E83_1857727528 = null; //Variable for return #2
        String myParts[];
        myParts = currentContext.processName(qName, isAttribute);
        {
            varB4EAC82CA7396A68D541C85D26508E83_666597505 = null;
        } //End block
        {
            parts[0] = myParts[0];
            parts[1] = myParts[1];
            parts[2] = myParts[2];
            varB4EAC82CA7396A68D541C85D26508E83_1857727528 = parts;
        } //End block
        addTaint(qName.getTaint());
        addTaint(parts.getTaint());
        addTaint(isAttribute);
        String [] varA7E53CE21691AB073D9660D615818899_1566160818; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1566160818 = varB4EAC82CA7396A68D541C85D26508E83_666597505;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1566160818 = varB4EAC82CA7396A68D541C85D26508E83_1857727528;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1566160818.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1566160818;
        // ---------- Original Method ----------
        //String myParts[] = currentContext.processName(qName, isAttribute);
        //if (myParts == null) {
        //return null;
    //} else {
        //parts[0] = myParts[0];
        //parts[1] = myParts[1];
        //parts[2] = myParts[2];
        //return parts;
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.380 -0400", hash_original_method = "AC6673E983BE229DBE393CCBB4A72E75", hash_generated_method = "BF4BA51ED01D22E929150DCA4F0EAEF8")
    public String getURI(String prefix) {
        String varB4EAC82CA7396A68D541C85D26508E83_758793701 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_758793701 = currentContext.getURI(prefix);
        addTaint(prefix.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_758793701.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_758793701;
        // ---------- Original Method ----------
        //return currentContext.getURI(prefix);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.381 -0400", hash_original_method = "A5B18FED447546E052ABC48FA9E4C291", hash_generated_method = "FF56A3DEBE71AFEB3E74C82934164BB0")
    public Enumeration getPrefixes() {
        Enumeration varB4EAC82CA7396A68D541C85D26508E83_1348899458 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1348899458 = currentContext.getPrefixes();
        varB4EAC82CA7396A68D541C85D26508E83_1348899458.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1348899458;
        // ---------- Original Method ----------
        //return currentContext.getPrefixes();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.382 -0400", hash_original_method = "EEA9ABC8ACBC17B2454F5F5D40E93A34", hash_generated_method = "AA1DCF5A5089AFB64AAE79AAD6A3846C")
    public String getPrefix(String uri) {
        String varB4EAC82CA7396A68D541C85D26508E83_572969256 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_572969256 = currentContext.getPrefix(uri);
        addTaint(uri.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_572969256.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_572969256;
        // ---------- Original Method ----------
        //return currentContext.getPrefix(uri);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.382 -0400", hash_original_method = "E9FAC6924E2013A13EA977C97AEA2AF7", hash_generated_method = "48ECD5E9F8E99E95B08EB4D17AEA9150")
    public Enumeration getPrefixes(String uri) {
        Enumeration varB4EAC82CA7396A68D541C85D26508E83_208195892 = null; //Variable for return #1
        ArrayList<String> prefixes;
        prefixes = new ArrayList<String>();
        Enumeration allPrefixes;
        allPrefixes = getPrefixes();
        {
            boolean varDBBFC8F355EEE732F9043D484C30C2DC_302710654 = (allPrefixes.hasMoreElements());
            {
                String prefix;
                prefix = (String) allPrefixes.nextElement();
                {
                    boolean varAACADE59064A2A7EDFAD29068544E51A_1213710483 = (uri.equals(getURI(prefix)));
                    {
                        prefixes.add(prefix);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_208195892 = Collections.enumeration(prefixes);
        addTaint(uri.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_208195892.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_208195892;
        // ---------- Original Method ----------
        //ArrayList<String> prefixes = new ArrayList<String>();
        //Enumeration allPrefixes = getPrefixes();
        //while (allPrefixes.hasMoreElements()) {
            //String prefix = (String) allPrefixes.nextElement();
            //if (uri.equals(getURI(prefix))) {
                //prefixes.add(prefix);
            //}
        //}
        //return Collections.enumeration(prefixes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.383 -0400", hash_original_method = "410BA98433560BB4462E66EC18960649", hash_generated_method = "A07DCA6E1336D2FC88490BA4342D0F08")
    public Enumeration getDeclaredPrefixes() {
        Enumeration varB4EAC82CA7396A68D541C85D26508E83_440485929 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_440485929 = currentContext.getDeclaredPrefixes();
        varB4EAC82CA7396A68D541C85D26508E83_440485929.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_440485929;
        // ---------- Original Method ----------
        //return currentContext.getDeclaredPrefixes();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.383 -0400", hash_original_method = "D57A861BE58AF20E8C88DE55C319347D", hash_generated_method = "D1210C57E7481D7D6CDF790F18C12553")
    public void setNamespaceDeclUris(boolean value) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException ();
        namespaceDeclUris = value;
        currentContext.declarePrefix ("xmlns", NSDECL);
        {
            contexts[contextPos] = currentContext = new Context();
            currentContext.declarePrefix("xml", XMLNS);
        } //End block
        // ---------- Original Method ----------
        //if (contextPos != 0)
        //throw new IllegalStateException ();
        //if (value == namespaceDeclUris)
        //return;
        //namespaceDeclUris = value;
        //if (value)
        //currentContext.declarePrefix ("xmlns", NSDECL);
    //else {
        //contexts[contextPos] = currentContext = new Context();
        //currentContext.declarePrefix("xml", XMLNS);
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.384 -0400", hash_original_method = "704394E46FC1A63E6F1F5F09E7A57B00", hash_generated_method = "0EB807A9A0D87AF74C0245CCAA395CB4")
    public boolean isNamespaceDeclUris() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1714732525 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1714732525;
        // ---------- Original Method ----------
        //return namespaceDeclUris;
    }

    
    final class Context {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.384 -0400", hash_original_field = "035128C78EF8EF590DC2A6BE24B22A1A", hash_generated_field = "CF0B92985AF9DC8DD4202061605E7021")

        Hashtable prefixTable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.384 -0400", hash_original_field = "7E4BD57C5C72BD9876DAD2340D471A30", hash_generated_field = "40686847BD0275762FCF55168889D3C9")

        Hashtable uriTable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.384 -0400", hash_original_field = "44CCDF7C9576313C2D9C16F194F180B0", hash_generated_field = "90E334191890A4914B17EA7FAF986992")

        Hashtable elementNameTable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.384 -0400", hash_original_field = "4F74DAC4D5F48FC66247937B7391F69E", hash_generated_field = "F042A8F63CE2471660EB97BB2E6F44AE")

        Hashtable attributeNameTable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.384 -0400", hash_original_field = "5DF04A8A7C3AE94CD04F766BC98D5AB1", hash_generated_field = "8E657056ECC4C162CFF6080FBFCD63F6")

        String defaultNS = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.384 -0400", hash_original_field = "5C2CE4E634A5DA1308C377D5D90CDF86", hash_generated_field = "E1C9F736B16FF7122A0BB4347159B956")

        boolean declsOK = true;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.384 -0400", hash_original_field = "8F5247FBD2FCFC727CADA90DED40054B", hash_generated_field = "D21C86635E482E529A9C74D897AA1D2E")

        private ArrayList<String> declarations = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.384 -0400", hash_original_field = "8C9FCA91D9B91531DD304DC9111FA9FF", hash_generated_field = "98CD992C81C807EFBCB961B2F6E16972")

        private boolean declSeen = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.384 -0400", hash_original_field = "EB17B6F54220F5E4DBB78B0010FAEFA6", hash_generated_field = "1E04AB28ECFE4BCC38F06ACD519BB459")

        private Context parent = null;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.384 -0400", hash_original_method = "CD5C82C799E78C74801FDB521CEE7324", hash_generated_method = "D7F93DBD3C237D58A202C82545BE75D2")
          Context() {
            copyTables();
            // ---------- Original Method ----------
            //copyTables();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.391 -0400", hash_original_method = "E1D3B844E1B48DBC46153D5E5632428F", hash_generated_method = "F6B9FE4E8E2EA47CF3F793A45547CC1D")
         void setParent(Context parent) {
            this.parent = parent;
            declarations = null;
            prefixTable = parent.prefixTable;
            uriTable = parent.uriTable;
            elementNameTable = parent.elementNameTable;
            attributeNameTable = parent.attributeNameTable;
            defaultNS = parent.defaultNS;
            declSeen = false;
            declsOK = true;
            // ---------- Original Method ----------
            //this.parent = parent;
            //declarations = null;
            //prefixTable = parent.prefixTable;
            //uriTable = parent.uriTable;
            //elementNameTable = parent.elementNameTable;
            //attributeNameTable = parent.attributeNameTable;
            //defaultNS = parent.defaultNS;
            //declSeen = false;
            //declsOK = true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.391 -0400", hash_original_method = "9488BC4AFF7634EA1262BEB181C9541E", hash_generated_method = "B008A6AC94D4B276D1CE38273E644999")
         void clear() {
            parent = null;
            prefixTable = null;
            uriTable = null;
            elementNameTable = null;
            attributeNameTable = null;
            defaultNS = null;
            // ---------- Original Method ----------
            //parent = null;
            //prefixTable = null;
            //uriTable = null;
            //elementNameTable = null;
            //attributeNameTable = null;
            //defaultNS = null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.392 -0400", hash_original_method = "4549801F41C68E0A6A490696C062C72D", hash_generated_method = "75BE991CBD73C23CF2EAC8432CC6CF89")
         void declarePrefix(String prefix, String uri) {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException ("can't declare any more prefixes in this context");
            } //End block
            {
                copyTables();
            } //End block
            {
                declarations = new ArrayList<String>();
            } //End block
            prefix = prefix.intern();
            uri = uri.intern();
            {
                boolean varDBBBA4DCDEBBCD715FEB48F06D1616D2_734474618 = ("".equals(prefix));
                {
                    {
                        boolean var2DF53AC7D79E90697CD530900E95E03A_1106930107 = ("".equals(uri));
                        {
                            defaultNS = null;
                        } //End block
                        {
                            defaultNS = uri;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    prefixTable.put(prefix, uri);
                    uriTable.put(uri, prefix);
                } //End block
            } //End collapsed parenthetic
            declarations.add(prefix);
            addTaint(prefix.getTaint());
            // ---------- Original Method ----------
            //if (!declsOK) {
            //throw new IllegalStateException ("can't declare any more prefixes in this context");
        //}
            //if (!declSeen) {
            //copyTables();
        //}
            //if (declarations == null) {
            //declarations = new ArrayList<String>();
        //}
            //prefix = prefix.intern();
            //uri = uri.intern();
            //if ("".equals(prefix)) {
            //if ("".equals(uri)) {
                //defaultNS = null;
            //} else {
                //defaultNS = uri;
            //}
        //} else {
            //prefixTable.put(prefix, uri);
            //uriTable.put(uri, prefix); 
        //}
            //declarations.add(prefix);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.409 -0400", hash_original_method = "33259345EBD99FFF49F4E1AAD2529013", hash_generated_method = "7E3181B0AD82504D94CDDA22FE8013E9")
         String [] processName(String qName, boolean isAttribute) {
            String [] varB4EAC82CA7396A68D541C85D26508E83_1390631484 = null; //Variable for return #1
            String [] varB4EAC82CA7396A68D541C85D26508E83_1684749966 = null; //Variable for return #2
            String [] varB4EAC82CA7396A68D541C85D26508E83_439234007 = null; //Variable for return #3
            String name[];
            Hashtable table;
            declsOK = false;
            {
                table = attributeNameTable;
            } //End block
            {
                table = elementNameTable;
            } //End block
            name = (String[])table.get(qName);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1390631484 = name;
            } //End block
            name = new String[3];
            name[2] = qName.intern();
            int index;
            index = qName.indexOf(':');
            {
                {
                    name[0] = NSDECL;
                    name[0] = "";
                } //End block
                {
                    name[0] = "";
                } //End block
                {
                    name[0] = defaultNS;
                } //End block
                name[1] = name[2];
            } //End block
            {
                String prefix;
                prefix = qName.substring(0, index);
                String local;
                local = qName.substring(index+1);
                String uri;
                {
                    boolean var26D4D01AFDE79579ACA9E51155E63317_687190188 = ("".equals(prefix));
                    {
                        uri = defaultNS;
                    } //End block
                    {
                        uri = (String)prefixTable.get(prefix);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varECB97B621C72072AD1B6C8D2176BA33B_250084167 = (uri == null
            || (!isAttribute && "xmlns".equals (prefix)));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1684749966 = null;
                    } //End block
                } //End collapsed parenthetic
                name[0] = uri;
                name[1] = local.intern();
            } //End block
            table.put(name[2], name);
            varB4EAC82CA7396A68D541C85D26508E83_439234007 = name;
            addTaint(qName.getTaint());
            addTaint(isAttribute);
            String [] varA7E53CE21691AB073D9660D615818899_2133133034; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_2133133034 = varB4EAC82CA7396A68D541C85D26508E83_1390631484;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_2133133034 = varB4EAC82CA7396A68D541C85D26508E83_1684749966;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_2133133034 = varB4EAC82CA7396A68D541C85D26508E83_439234007;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_2133133034.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_2133133034;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.410 -0400", hash_original_method = "33F968ABABCEBD2BA0661937EB8377F0", hash_generated_method = "93918D58B0967EC83FF6178378D8ABCC")
         String getURI(String prefix) {
            String varB4EAC82CA7396A68D541C85D26508E83_1495476190 = null; //Variable for return #1
            String varB4EAC82CA7396A68D541C85D26508E83_1979132872 = null; //Variable for return #2
            String varB4EAC82CA7396A68D541C85D26508E83_1223185040 = null; //Variable for return #3
            {
                boolean varDBBBA4DCDEBBCD715FEB48F06D1616D2_1432986198 = ("".equals(prefix));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1495476190 = defaultNS;
                } //End block
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1979132872 = null;
                } //End block
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1223185040 = (String)prefixTable.get(prefix);
                } //End block
            } //End collapsed parenthetic
            addTaint(prefix.getTaint());
            String varA7E53CE21691AB073D9660D615818899_189246382; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_189246382 = varB4EAC82CA7396A68D541C85D26508E83_1495476190;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_189246382 = varB4EAC82CA7396A68D541C85D26508E83_1979132872;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_189246382 = varB4EAC82CA7396A68D541C85D26508E83_1223185040;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_189246382.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_189246382;
            // ---------- Original Method ----------
            //if ("".equals(prefix)) {
        //return defaultNS;
        //} else if (prefixTable == null) {
        //return null;
        //} else {
        //return (String)prefixTable.get(prefix);
        //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.410 -0400", hash_original_method = "62121EA4CFF0891BFB2032F7AF8FE7A1", hash_generated_method = "6807E0A3003157E37DAD48D9CB3F58B6")
         String getPrefix(String uri) {
            String varB4EAC82CA7396A68D541C85D26508E83_873692604 = null; //Variable for return #1
            String varB4EAC82CA7396A68D541C85D26508E83_1823776577 = null; //Variable for return #2
            {
                varB4EAC82CA7396A68D541C85D26508E83_873692604 = null;
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1823776577 = (String)uriTable.get(uri);
            } //End block
            addTaint(uri.getTaint());
            String varA7E53CE21691AB073D9660D615818899_708301381; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_708301381 = varB4EAC82CA7396A68D541C85D26508E83_873692604;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_708301381 = varB4EAC82CA7396A68D541C85D26508E83_1823776577;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_708301381.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_708301381;
            // ---------- Original Method ----------
            //if (uriTable == null) {
        //return null;
        //} else {
        //return (String)uriTable.get(uri);
        //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.411 -0400", hash_original_method = "B116CF358C1D0DA8CF46DFF106939FC0", hash_generated_method = "B41FD70026E950DA75B1196F1BE3FB21")
         Enumeration getDeclaredPrefixes() {
            Enumeration varB4EAC82CA7396A68D541C85D26508E83_1782059578 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1782059578 = (declarations == null) ? EMPTY_ENUMERATION : Collections.enumeration(declarations);
            varB4EAC82CA7396A68D541C85D26508E83_1782059578.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1782059578;
            // ---------- Original Method ----------
            //return (declarations == null) ? EMPTY_ENUMERATION : Collections.enumeration(declarations);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.415 -0400", hash_original_method = "D02303EBFA8DB4A97AF291339C2FB52B", hash_generated_method = "1F1B0092C3B7E11F864D9DE04F376BB9")
         Enumeration getPrefixes() {
            Enumeration varB4EAC82CA7396A68D541C85D26508E83_287717458 = null; //Variable for return #1
            Enumeration varB4EAC82CA7396A68D541C85D26508E83_195059120 = null; //Variable for return #2
            {
                varB4EAC82CA7396A68D541C85D26508E83_287717458 = EMPTY_ENUMERATION;
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_195059120 = prefixTable.keys();
            } //End block
            Enumeration varA7E53CE21691AB073D9660D615818899_1422682524; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1422682524 = varB4EAC82CA7396A68D541C85D26508E83_287717458;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1422682524 = varB4EAC82CA7396A68D541C85D26508E83_195059120;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1422682524.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1422682524;
            // ---------- Original Method ----------
            //if (prefixTable == null) {
        //return EMPTY_ENUMERATION;
        //} else {
        //return prefixTable.keys();
        //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.419 -0400", hash_original_method = "26D71A046B8A5E21DEFC65FB89CD9FDA", hash_generated_method = "81292E8AF676318A51EFB032C324D408")
        private void copyTables() {
            {
                prefixTable = (Hashtable)prefixTable.clone();
            } //End block
            {
                prefixTable = new Hashtable();
            } //End block
            {
                uriTable = (Hashtable)uriTable.clone();
            } //End block
            {
                uriTable = new Hashtable();
            } //End block
            elementNameTable = new Hashtable();
            attributeNameTable = new Hashtable();
            declSeen = true;
            // ---------- Original Method ----------
            //if (prefixTable != null) {
        //prefixTable = (Hashtable)prefixTable.clone();
        //} else {
        //prefixTable = new Hashtable();
        //}
            //if (uriTable != null) {
        //uriTable = (Hashtable)uriTable.clone();
        //} else {
        //uriTable = new Hashtable();
        //}
            //elementNameTable = new Hashtable();
            //attributeNameTable = new Hashtable();
            //declSeen = true;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.420 -0400", hash_original_field = "A4E29D7FEF12BB1BA5EF68A64621892E", hash_generated_field = "E2237A0DCAD2773A6CC25F576EAF7F53")

    public static final String XMLNS =
    "http://www.w3.org/XML/1998/namespace";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.420 -0400", hash_original_field = "52DCBC4E195EDCDDD5C502199F884871", hash_generated_field = "1571E423031924244408A7D28A741EE6")

    public static final String NSDECL =
    "http://www.w3.org/xmlns/2000/";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:22.421 -0400", hash_original_field = "49A583D17F7F788F509CDB87E67F0800", hash_generated_field = "0E2B9D7225FC08919D897C8C3D44A949")

    private static Enumeration EMPTY_ENUMERATION = Collections.enumeration(Collections.emptyList());
}

