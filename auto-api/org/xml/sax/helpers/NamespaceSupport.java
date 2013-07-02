package org.xml.sax.helpers;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.Enumeration;
import java.util.Hashtable;

public class NamespaceSupport {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.932 -0400", hash_original_field = "7E0A10944FD50182E16E23B0A3D9335C", hash_generated_field = "C9FE6E28AC860EBE1DBAB5714D1187ED")

    private Context contexts[];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.932 -0400", hash_original_field = "A1F907D66151216045ACBF9ABBF0333F", hash_generated_field = "16BCC2B5B5C19EE2FA8800AE041E507F")

    private Context currentContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.932 -0400", hash_original_field = "34DD546BFAFA2A58B969006E4646341D", hash_generated_field = "6E7F5C2FF9D13C809071AD4BD4B43575")

    private int contextPos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.932 -0400", hash_original_field = "1B0E32CE3D1C65D78D4D87360D96EF74", hash_generated_field = "93D47AA8737E27469EC5299DD6FB86D0")

    private boolean namespaceDeclUris;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.933 -0400", hash_original_method = "1F62AD2938072A93E19EAFFCDA555D07", hash_generated_method = "5851AF68D843BB425B4FF66193756222")
    public  NamespaceSupport() {
        reset();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.933 -0400", hash_original_method = "2A27A75937E4BE02DA5FD7B031C4079A", hash_generated_method = "AD54F05B2FA16CFBF38021AFA9C2A42C")
    public void reset() {
        contexts = new Context[32];
        namespaceDeclUris = false;
        contextPos = 0;
        contexts[contextPos] = currentContext = new Context();
        currentContext.declarePrefix("xml", XMLNS);
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.934 -0400", hash_original_method = "B186F7F0BF353B1A746862E337C50A69", hash_generated_method = "B2DEF4CF177D990D9AE81A6169C24230")
    public void pushContext() {
        int max = contexts.length;
        contexts [contextPos].declsOK = false;
        {
            Context newContexts[] = new Context[max*2];
            System.arraycopy(contexts, 0, newContexts, 0, max);
            max *= 2;
            contexts = newContexts;
        } 
        currentContext = contexts[contextPos];
        {
            contexts[contextPos] = currentContext = new Context();
        } 
        {
            currentContext.setParent(contexts[contextPos - 1]);
        } 
        
        
        
        
        
        
        
        
        
    
        
        
        
    
        
        
    
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.934 -0400", hash_original_method = "D28ACF4ED7DED6C7ED370F52380381BA", hash_generated_method = "ED5C2325002017E243DEE0E4AD88FB26")
    public void popContext() {
        contexts[contextPos].clear();
        {
            if (DroidSafeAndroidRuntime.control) throw new EmptyStackException();
        } 
        currentContext = contexts[contextPos];
        
        
        
        
        
    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.934 -0400", hash_original_method = "90A3EE210CAE689DFC3CD58893529A76", hash_generated_method = "13D68B7734C8FBB3EEA0C68FF7EE3D5D")
    public boolean declarePrefix(String prefix, String uri) {
        {
            boolean var6CD89D1BDC90A7556F69D069AB4E587C_1891082739 = (prefix.equals("xml") || prefix.equals("xmlns"));
            {
                currentContext.declarePrefix(prefix, uri);
            } 
        } 
        addTaint(prefix.getTaint());
        addTaint(uri.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1019637492 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1019637492;
        
        
        
    
        
        
    
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.935 -0400", hash_original_method = "568BC23E816C8735D1D944210F1F3C08", hash_generated_method = "0FFDE5EE46486233B28E32E455F21C56")
    public String [] processName(String qName, String parts[],
                  boolean isAttribute) {
        String [] varB4EAC82CA7396A68D541C85D26508E83_834374897 = null; 
        String [] varB4EAC82CA7396A68D541C85D26508E83_1728722062 = null; 
        String myParts[] = currentContext.processName(qName, isAttribute);
        {
            varB4EAC82CA7396A68D541C85D26508E83_834374897 = null;
        } 
        {
            parts[0] = myParts[0];
            parts[1] = myParts[1];
            parts[2] = myParts[2];
            varB4EAC82CA7396A68D541C85D26508E83_1728722062 = parts;
        } 
        addTaint(qName.getTaint());
        addTaint(parts[0].getTaint());
        addTaint(isAttribute);
        String [] varA7E53CE21691AB073D9660D615818899_1598977241; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1598977241 = varB4EAC82CA7396A68D541C85D26508E83_834374897;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1598977241 = varB4EAC82CA7396A68D541C85D26508E83_1728722062;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1598977241.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1598977241;
        
        
        
        
    
        
        
        
        
    
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.937 -0400", hash_original_method = "AC6673E983BE229DBE393CCBB4A72E75", hash_generated_method = "55CA8A44E3A90B35CB70019CD44FFD61")
    public String getURI(String prefix) {
        String varB4EAC82CA7396A68D541C85D26508E83_709249020 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_709249020 = currentContext.getURI(prefix);
        addTaint(prefix.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_709249020.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_709249020;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.939 -0400", hash_original_method = "A5B18FED447546E052ABC48FA9E4C291", hash_generated_method = "3E5C833471A8002101C0576FD00FE4A4")
    public Enumeration getPrefixes() {
        Enumeration varB4EAC82CA7396A68D541C85D26508E83_463015657 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_463015657 = currentContext.getPrefixes();
        varB4EAC82CA7396A68D541C85D26508E83_463015657.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_463015657;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.940 -0400", hash_original_method = "EEA9ABC8ACBC17B2454F5F5D40E93A34", hash_generated_method = "3D6ACB652CEE29A1A4BF9A5D51202AE4")
    public String getPrefix(String uri) {
        String varB4EAC82CA7396A68D541C85D26508E83_1657681916 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1657681916 = currentContext.getPrefix(uri);
        addTaint(uri.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1657681916.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1657681916;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.940 -0400", hash_original_method = "E9FAC6924E2013A13EA977C97AEA2AF7", hash_generated_method = "0A329FC332D8F9661168B854FBFAE3F2")
    public Enumeration getPrefixes(String uri) {
        Enumeration varB4EAC82CA7396A68D541C85D26508E83_1941844879 = null; 
        ArrayList<String> prefixes = new ArrayList<String>();
        Enumeration allPrefixes = getPrefixes();
        {
            boolean varDBBFC8F355EEE732F9043D484C30C2DC_733284029 = (allPrefixes.hasMoreElements());
            {
                String prefix = (String) allPrefixes.nextElement();
                {
                    boolean varAACADE59064A2A7EDFAD29068544E51A_1097239464 = (uri.equals(getURI(prefix)));
                    {
                        prefixes.add(prefix);
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1941844879 = Collections.enumeration(prefixes);
        addTaint(uri.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1941844879.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1941844879;
        
        
        
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.941 -0400", hash_original_method = "410BA98433560BB4462E66EC18960649", hash_generated_method = "150190C1F821BEEB80880DA7AEB42056")
    public Enumeration getDeclaredPrefixes() {
        Enumeration varB4EAC82CA7396A68D541C85D26508E83_1618962288 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1618962288 = currentContext.getDeclaredPrefixes();
        varB4EAC82CA7396A68D541C85D26508E83_1618962288.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1618962288;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.942 -0400", hash_original_method = "D57A861BE58AF20E8C88DE55C319347D", hash_generated_method = "D1210C57E7481D7D6CDF790F18C12553")
    public void setNamespaceDeclUris(boolean value) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException ();
        namespaceDeclUris = value;
        currentContext.declarePrefix ("xmlns", NSDECL);
        {
            contexts[contextPos] = currentContext = new Context();
            currentContext.declarePrefix("xml", XMLNS);
        } 
        
        
        
        
        
        
        
        
    
        
        
    
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.942 -0400", hash_original_method = "704394E46FC1A63E6F1F5F09E7A57B00", hash_generated_method = "BB524FFBC96D0C89512EC5DE1C4D8AF8")
    public boolean isNamespaceDeclUris() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_592357278 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_592357278;
        
        
    }

    
    final class Context {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.942 -0400", hash_original_field = "035128C78EF8EF590DC2A6BE24B22A1A", hash_generated_field = "CF0B92985AF9DC8DD4202061605E7021")

        Hashtable prefixTable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.942 -0400", hash_original_field = "7E4BD57C5C72BD9876DAD2340D471A30", hash_generated_field = "40686847BD0275762FCF55168889D3C9")

        Hashtable uriTable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.942 -0400", hash_original_field = "44CCDF7C9576313C2D9C16F194F180B0", hash_generated_field = "90E334191890A4914B17EA7FAF986992")

        Hashtable elementNameTable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.942 -0400", hash_original_field = "4F74DAC4D5F48FC66247937B7391F69E", hash_generated_field = "F042A8F63CE2471660EB97BB2E6F44AE")

        Hashtable attributeNameTable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.942 -0400", hash_original_field = "5DF04A8A7C3AE94CD04F766BC98D5AB1", hash_generated_field = "8E657056ECC4C162CFF6080FBFCD63F6")

        String defaultNS = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.942 -0400", hash_original_field = "5C2CE4E634A5DA1308C377D5D90CDF86", hash_generated_field = "E1C9F736B16FF7122A0BB4347159B956")

        boolean declsOK = true;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.942 -0400", hash_original_field = "8F5247FBD2FCFC727CADA90DED40054B", hash_generated_field = "D21C86635E482E529A9C74D897AA1D2E")

        private ArrayList<String> declarations = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.942 -0400", hash_original_field = "8C9FCA91D9B91531DD304DC9111FA9FF", hash_generated_field = "98CD992C81C807EFBCB961B2F6E16972")

        private boolean declSeen = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.942 -0400", hash_original_field = "EB17B6F54220F5E4DBB78B0010FAEFA6", hash_generated_field = "1E04AB28ECFE4BCC38F06ACD519BB459")

        private Context parent = null;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.943 -0400", hash_original_method = "CD5C82C799E78C74801FDB521CEE7324", hash_generated_method = "D7F93DBD3C237D58A202C82545BE75D2")
          Context() {
            copyTables();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.943 -0400", hash_original_method = "E1D3B844E1B48DBC46153D5E5632428F", hash_generated_method = "F6B9FE4E8E2EA47CF3F793A45547CC1D")
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
            
            
            
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.944 -0400", hash_original_method = "9488BC4AFF7634EA1262BEB181C9541E", hash_generated_method = "B008A6AC94D4B276D1CE38273E644999")
         void clear() {
            parent = null;
            prefixTable = null;
            uriTable = null;
            elementNameTable = null;
            attributeNameTable = null;
            defaultNS = null;
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.944 -0400", hash_original_method = "4549801F41C68E0A6A490696C062C72D", hash_generated_method = "FBD1C5F34BC5F9E976E68AE8B2902CAC")
         void declarePrefix(String prefix, String uri) {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException ("can't declare any more prefixes in this context");
            } 
            {
                copyTables();
            } 
            {
                declarations = new ArrayList<String>();
            } 
            prefix = prefix.intern();
            uri = uri.intern();
            {
                boolean varDBBBA4DCDEBBCD715FEB48F06D1616D2_2059878046 = ("".equals(prefix));
                {
                    {
                        boolean var2DF53AC7D79E90697CD530900E95E03A_46674699 = ("".equals(uri));
                        {
                            defaultNS = null;
                        } 
                        {
                            defaultNS = uri;
                        } 
                    } 
                } 
                {
                    prefixTable.put(prefix, uri);
                    uriTable.put(uri, prefix);
                } 
            } 
            declarations.add(prefix);
            addTaint(prefix.getTaint());
            
            
            
        
            
            
        
            
            
        
            
            
            
            
                
            
                
            
        
            
            
        
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.946 -0400", hash_original_method = "33259345EBD99FFF49F4E1AAD2529013", hash_generated_method = "92F1CA758E2D2CB93CE2D5CB3AF94D37")
         String [] processName(String qName, boolean isAttribute) {
            String [] varB4EAC82CA7396A68D541C85D26508E83_1995901396 = null; 
            String [] varB4EAC82CA7396A68D541C85D26508E83_1558242450 = null; 
            String [] varB4EAC82CA7396A68D541C85D26508E83_1420964328 = null; 
            String name[];
            Hashtable table;
            declsOK = false;
            {
                table = attributeNameTable;
            } 
            {
                table = elementNameTable;
            } 
            name = (String[])table.get(qName);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1995901396 = name;
            } 
            name = new String[3];
            name[2] = qName.intern();
            int index = qName.indexOf(':');
            {
                {
                    name[0] = NSDECL;
                    name[0] = "";
                } 
                {
                    name[0] = "";
                } 
                {
                    name[0] = defaultNS;
                } 
                name[1] = name[2];
            } 
            {
                String prefix = qName.substring(0, index);
                String local = qName.substring(index+1);
                String uri;
                {
                    boolean var26D4D01AFDE79579ACA9E51155E63317_1492793935 = ("".equals(prefix));
                    {
                        uri = defaultNS;
                    } 
                    {
                        uri = (String)prefixTable.get(prefix);
                    } 
                } 
                {
                    boolean varECB97B621C72072AD1B6C8D2176BA33B_2034848432 = (uri == null
            || (!isAttribute && "xmlns".equals (prefix)));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1558242450 = null;
                    } 
                } 
                name[0] = uri;
                name[1] = local.intern();
            } 
            table.put(name[2], name);
            varB4EAC82CA7396A68D541C85D26508E83_1420964328 = name;
            addTaint(qName.getTaint());
            addTaint(isAttribute);
            String [] varA7E53CE21691AB073D9660D615818899_1216218175; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_1216218175 = varB4EAC82CA7396A68D541C85D26508E83_1995901396;
                    break;
                case 2: 
                    varA7E53CE21691AB073D9660D615818899_1216218175 = varB4EAC82CA7396A68D541C85D26508E83_1558242450;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1216218175 = varB4EAC82CA7396A68D541C85D26508E83_1420964328;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1216218175.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_1216218175;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.948 -0400", hash_original_method = "33F968ABABCEBD2BA0661937EB8377F0", hash_generated_method = "920D63C6D4A4080D1B9127E3BD19185F")
         String getURI(String prefix) {
            String varB4EAC82CA7396A68D541C85D26508E83_840452651 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_1154323899 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_1746749238 = null; 
            {
                boolean varDBBBA4DCDEBBCD715FEB48F06D1616D2_830438262 = ("".equals(prefix));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_840452651 = defaultNS;
                } 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1154323899 = null;
                } 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1746749238 = (String)prefixTable.get(prefix);
                } 
            } 
            addTaint(prefix.getTaint());
            String varA7E53CE21691AB073D9660D615818899_1020641639; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_1020641639 = varB4EAC82CA7396A68D541C85D26508E83_840452651;
                    break;
                case 2: 
                    varA7E53CE21691AB073D9660D615818899_1020641639 = varB4EAC82CA7396A68D541C85D26508E83_1154323899;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1020641639 = varB4EAC82CA7396A68D541C85D26508E83_1746749238;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1020641639.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_1020641639;
            
            
        
        
        
        
        
        
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.949 -0400", hash_original_method = "62121EA4CFF0891BFB2032F7AF8FE7A1", hash_generated_method = "08BB68716D002BA466DF72F81D844D97")
         String getPrefix(String uri) {
            String varB4EAC82CA7396A68D541C85D26508E83_791069883 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_480419103 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_791069883 = null;
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_480419103 = (String)uriTable.get(uri);
            } 
            addTaint(uri.getTaint());
            String varA7E53CE21691AB073D9660D615818899_597535949; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_597535949 = varB4EAC82CA7396A68D541C85D26508E83_791069883;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_597535949 = varB4EAC82CA7396A68D541C85D26508E83_480419103;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_597535949.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_597535949;
            
            
        
        
        
        
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.950 -0400", hash_original_method = "B116CF358C1D0DA8CF46DFF106939FC0", hash_generated_method = "3200168A124EA2CB356C2E6C0216FB1A")
         Enumeration getDeclaredPrefixes() {
            Enumeration varB4EAC82CA7396A68D541C85D26508E83_107593497 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_107593497 = (declarations == null) ? EMPTY_ENUMERATION : Collections.enumeration(declarations);
            varB4EAC82CA7396A68D541C85D26508E83_107593497.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_107593497;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.951 -0400", hash_original_method = "D02303EBFA8DB4A97AF291339C2FB52B", hash_generated_method = "84C4C4F69E06BDD06244C7B6F2CD94E9")
         Enumeration getPrefixes() {
            Enumeration varB4EAC82CA7396A68D541C85D26508E83_229916810 = null; 
            Enumeration varB4EAC82CA7396A68D541C85D26508E83_1453886222 = null; 
            {
                varB4EAC82CA7396A68D541C85D26508E83_229916810 = EMPTY_ENUMERATION;
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1453886222 = prefixTable.keys();
            } 
            Enumeration varA7E53CE21691AB073D9660D615818899_476755830; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_476755830 = varB4EAC82CA7396A68D541C85D26508E83_229916810;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_476755830 = varB4EAC82CA7396A68D541C85D26508E83_1453886222;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_476755830.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_476755830;
            
            
        
        
        
        
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.952 -0400", hash_original_method = "26D71A046B8A5E21DEFC65FB89CD9FDA", hash_generated_method = "81292E8AF676318A51EFB032C324D408")
        private void copyTables() {
            {
                prefixTable = (Hashtable)prefixTable.clone();
            } 
            {
                prefixTable = new Hashtable();
            } 
            {
                uriTable = (Hashtable)uriTable.clone();
            } 
            {
                uriTable = new Hashtable();
            } 
            elementNameTable = new Hashtable();
            attributeNameTable = new Hashtable();
            declSeen = true;
            
            
        
        
        
        
            
        
        
        
        
            
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.952 -0400", hash_original_field = "A4E29D7FEF12BB1BA5EF68A64621892E", hash_generated_field = "E2237A0DCAD2773A6CC25F576EAF7F53")

    public static final String XMLNS =
    "http://www.w3.org/XML/1998/namespace";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.952 -0400", hash_original_field = "52DCBC4E195EDCDDD5C502199F884871", hash_generated_field = "1571E423031924244408A7D28A741EE6")

    public static final String NSDECL =
    "http://www.w3.org/xmlns/2000/";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.952 -0400", hash_original_field = "49A583D17F7F788F509CDB87E67F0800", hash_generated_field = "0A58893494FE31226DF50FC333D4E439")

    private static final Enumeration EMPTY_ENUMERATION = Collections.enumeration(Collections.emptyList());
}

