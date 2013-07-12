package org.xml.sax.helpers;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.Enumeration;
import java.util.Hashtable;

public class NamespaceSupport {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.445 -0400", hash_original_field = "7E0A10944FD50182E16E23B0A3D9335C", hash_generated_field = "C9FE6E28AC860EBE1DBAB5714D1187ED")

    private Context contexts[];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.445 -0400", hash_original_field = "A1F907D66151216045ACBF9ABBF0333F", hash_generated_field = "16BCC2B5B5C19EE2FA8800AE041E507F")

    private Context currentContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.445 -0400", hash_original_field = "34DD546BFAFA2A58B969006E4646341D", hash_generated_field = "6E7F5C2FF9D13C809071AD4BD4B43575")

    private int contextPos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.445 -0400", hash_original_field = "1B0E32CE3D1C65D78D4D87360D96EF74", hash_generated_field = "93D47AA8737E27469EC5299DD6FB86D0")

    private boolean namespaceDeclUris;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.445 -0400", hash_original_method = "1F62AD2938072A93E19EAFFCDA555D07", hash_generated_method = "5851AF68D843BB425B4FF66193756222")
    public  NamespaceSupport() {
        reset();
        // ---------- Original Method ----------
        //reset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.446 -0400", hash_original_method = "2A27A75937E4BE02DA5FD7B031C4079A", hash_generated_method = "AD54F05B2FA16CFBF38021AFA9C2A42C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.448 -0400", hash_original_method = "B186F7F0BF353B1A746862E337C50A69", hash_generated_method = "D108F0539C2F4DB4D6D6946CC349EC15")
    public void pushContext() {
        int max = contexts.length;
        contexts [contextPos].declsOK = false;
        contextPos++;
    if(contextPos >= max)        
        {
            Context newContexts[] = new Context[max*2];
            System.arraycopy(contexts, 0, newContexts, 0, max);
            max *= 2;
            contexts = newContexts;
        } //End block
        currentContext = contexts[contextPos];
    if(currentContext == null)        
        {
            contexts[contextPos] = currentContext = new Context();
        } //End block
    if(contextPos > 0)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.449 -0400", hash_original_method = "D28ACF4ED7DED6C7ED370F52380381BA", hash_generated_method = "4C395C5A51790F695AF0E654482F863B")
    public void popContext() {
        contexts[contextPos].clear();
        contextPos--;
    if(contextPos < 0)        
        {
            EmptyStackException varD2F310AAC69D0B44FED139E8A8976F2D_473927112 = new EmptyStackException();
            varD2F310AAC69D0B44FED139E8A8976F2D_473927112.addTaint(taint);
            throw varD2F310AAC69D0B44FED139E8A8976F2D_473927112;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.449 -0400", hash_original_method = "90A3EE210CAE689DFC3CD58893529A76", hash_generated_method = "FA4C203B34925F0B6839DDFE01377032")
    public boolean declarePrefix(String prefix, String uri) {
        addTaint(uri.getTaint());
        addTaint(prefix.getTaint());
    if(prefix.equals("xml") || prefix.equals("xmlns"))        
        {
            boolean var68934A3E9455FA72420237EB05902327_984568944 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_832291445 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_832291445;
        } //End block
        else
        {
            currentContext.declarePrefix(prefix, uri);
            boolean varB326B5062B2F0E69046810717534CB09_674935115 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_863674180 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_863674180;
        } //End block
        // ---------- Original Method ----------
        //if (prefix.equals("xml") || prefix.equals("xmlns")) {
        //return false;
    //} else {
        //currentContext.declarePrefix(prefix, uri);
        //return true;
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.451 -0400", hash_original_method = "568BC23E816C8735D1D944210F1F3C08", hash_generated_method = "9978AB4631AAA69F04E2A39624F689A3")
    public String [] processName(String qName, String parts[],
                  boolean isAttribute) {
        addTaint(isAttribute);
        addTaint(parts[0].getTaint());
        addTaint(qName.getTaint());
        String myParts[] = currentContext.processName(qName, isAttribute);
    if(myParts == null)        
        {
String [] var540C13E9E156B687226421B24F2DF178_142857790 =             null;
            var540C13E9E156B687226421B24F2DF178_142857790.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_142857790;
        } //End block
        else
        {
            parts[0] = myParts[0];
            parts[1] = myParts[1];
            parts[2] = myParts[2];
String [] var6651EAC2994005EE903B8D00ACB7442E_2053651687 =             parts;
            var6651EAC2994005EE903B8D00ACB7442E_2053651687.addTaint(taint);
            return var6651EAC2994005EE903B8D00ACB7442E_2053651687;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.451 -0400", hash_original_method = "AC6673E983BE229DBE393CCBB4A72E75", hash_generated_method = "02561532A039006311B57FE17B80A69E")
    public String getURI(String prefix) {
        addTaint(prefix.getTaint());
String varD3CF03DF424233A5E957366D467BAD2C_1816095142 =         currentContext.getURI(prefix);
        varD3CF03DF424233A5E957366D467BAD2C_1816095142.addTaint(taint);
        return varD3CF03DF424233A5E957366D467BAD2C_1816095142;
        // ---------- Original Method ----------
        //return currentContext.getURI(prefix);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.452 -0400", hash_original_method = "A5B18FED447546E052ABC48FA9E4C291", hash_generated_method = "31B0A2705D6D8F0FAA20F0DF2A5F22DB")
    public Enumeration getPrefixes() {
Enumeration var3CA484C1F7A55DC8EC9DBC77D6F685ED_896987217 =         currentContext.getPrefixes();
        var3CA484C1F7A55DC8EC9DBC77D6F685ED_896987217.addTaint(taint);
        return var3CA484C1F7A55DC8EC9DBC77D6F685ED_896987217;
        // ---------- Original Method ----------
        //return currentContext.getPrefixes();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.452 -0400", hash_original_method = "EEA9ABC8ACBC17B2454F5F5D40E93A34", hash_generated_method = "705C3FE62F5953A130CB6AA3CACC7C40")
    public String getPrefix(String uri) {
        addTaint(uri.getTaint());
String varE7C2CB7CEAA80FA05F8C25692B7C653A_68227346 =         currentContext.getPrefix(uri);
        varE7C2CB7CEAA80FA05F8C25692B7C653A_68227346.addTaint(taint);
        return varE7C2CB7CEAA80FA05F8C25692B7C653A_68227346;
        // ---------- Original Method ----------
        //return currentContext.getPrefix(uri);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.453 -0400", hash_original_method = "E9FAC6924E2013A13EA977C97AEA2AF7", hash_generated_method = "347F5C1B4E3AE8FF6BE815DA11FFA4FF")
    public Enumeration getPrefixes(String uri) {
        addTaint(uri.getTaint());
        ArrayList<String> prefixes = new ArrayList<String>();
        Enumeration allPrefixes = getPrefixes();
        while
(allPrefixes.hasMoreElements())        
        {
            String prefix = (String) allPrefixes.nextElement();
    if(uri.equals(getURI(prefix)))            
            {
                prefixes.add(prefix);
            } //End block
        } //End block
Enumeration var5FC42751E2C21DAF9B65440664E8FC85_811166772 =         Collections.enumeration(prefixes);
        var5FC42751E2C21DAF9B65440664E8FC85_811166772.addTaint(taint);
        return var5FC42751E2C21DAF9B65440664E8FC85_811166772;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.453 -0400", hash_original_method = "410BA98433560BB4462E66EC18960649", hash_generated_method = "588CE7C9CF2814B1F681476087B0478B")
    public Enumeration getDeclaredPrefixes() {
Enumeration varA9270AE0813CF099F45329C62E1BFAD9_248812930 =         currentContext.getDeclaredPrefixes();
        varA9270AE0813CF099F45329C62E1BFAD9_248812930.addTaint(taint);
        return varA9270AE0813CF099F45329C62E1BFAD9_248812930;
        // ---------- Original Method ----------
        //return currentContext.getDeclaredPrefixes();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.454 -0400", hash_original_method = "D57A861BE58AF20E8C88DE55C319347D", hash_generated_method = "2E3DDEC025B138310DF2858D2D1E3CDE")
    public void setNamespaceDeclUris(boolean value) {
    if(contextPos != 0)        
        {
        IllegalStateException varC311A989A119B96A6232C22ABFE87C25_124656759 = new IllegalStateException ();
        varC311A989A119B96A6232C22ABFE87C25_124656759.addTaint(taint);
        throw varC311A989A119B96A6232C22ABFE87C25_124656759;
        }
    if(value == namespaceDeclUris)        
        return;
        namespaceDeclUris = value;
    if(value)        
        currentContext.declarePrefix ("xmlns", NSDECL);
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.455 -0400", hash_original_method = "704394E46FC1A63E6F1F5F09E7A57B00", hash_generated_method = "746739353838227EF4E1E7CCE13C91B5")
    public boolean isNamespaceDeclUris() {
        boolean var1B0E32CE3D1C65D78D4D87360D96EF74_2138014273 = (namespaceDeclUris);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_791866524 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_791866524;
        // ---------- Original Method ----------
        //return namespaceDeclUris;
    }

    
    final class Context {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.455 -0400", hash_original_field = "035128C78EF8EF590DC2A6BE24B22A1A", hash_generated_field = "CF0B92985AF9DC8DD4202061605E7021")

        Hashtable prefixTable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.455 -0400", hash_original_field = "7E4BD57C5C72BD9876DAD2340D471A30", hash_generated_field = "40686847BD0275762FCF55168889D3C9")

        Hashtable uriTable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.455 -0400", hash_original_field = "44CCDF7C9576313C2D9C16F194F180B0", hash_generated_field = "90E334191890A4914B17EA7FAF986992")

        Hashtable elementNameTable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.455 -0400", hash_original_field = "4F74DAC4D5F48FC66247937B7391F69E", hash_generated_field = "F042A8F63CE2471660EB97BB2E6F44AE")

        Hashtable attributeNameTable;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.455 -0400", hash_original_field = "5DF04A8A7C3AE94CD04F766BC98D5AB1", hash_generated_field = "8E657056ECC4C162CFF6080FBFCD63F6")

        String defaultNS = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.456 -0400", hash_original_field = "5C2CE4E634A5DA1308C377D5D90CDF86", hash_generated_field = "E1C9F736B16FF7122A0BB4347159B956")

        boolean declsOK = true;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.456 -0400", hash_original_field = "8F5247FBD2FCFC727CADA90DED40054B", hash_generated_field = "D21C86635E482E529A9C74D897AA1D2E")

        private ArrayList<String> declarations = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.456 -0400", hash_original_field = "8C9FCA91D9B91531DD304DC9111FA9FF", hash_generated_field = "98CD992C81C807EFBCB961B2F6E16972")

        private boolean declSeen = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.456 -0400", hash_original_field = "EB17B6F54220F5E4DBB78B0010FAEFA6", hash_generated_field = "1E04AB28ECFE4BCC38F06ACD519BB459")

        private Context parent = null;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.456 -0400", hash_original_method = "CD5C82C799E78C74801FDB521CEE7324", hash_generated_method = "D7F93DBD3C237D58A202C82545BE75D2")
          Context() {
            copyTables();
            // ---------- Original Method ----------
            //copyTables();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.458 -0400", hash_original_method = "E1D3B844E1B48DBC46153D5E5632428F", hash_generated_method = "F6B9FE4E8E2EA47CF3F793A45547CC1D")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.461 -0400", hash_original_method = "9488BC4AFF7634EA1262BEB181C9541E", hash_generated_method = "B008A6AC94D4B276D1CE38273E644999")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.463 -0400", hash_original_method = "4549801F41C68E0A6A490696C062C72D", hash_generated_method = "6E669535A0900F564A23D4A71A29597A")
         void declarePrefix(String prefix, String uri) {
            addTaint(prefix.getTaint());
    if(!declsOK)            
            {
                IllegalStateException var1E7B469211DA15CFDAAE3CA89DA13BE1_497351274 = new IllegalStateException ("can't declare any more prefixes in this context");
                var1E7B469211DA15CFDAAE3CA89DA13BE1_497351274.addTaint(taint);
                throw var1E7B469211DA15CFDAAE3CA89DA13BE1_497351274;
            } //End block
    if(!declSeen)            
            {
                copyTables();
            } //End block
    if(declarations == null)            
            {
                declarations = new ArrayList<String>();
            } //End block
            prefix = prefix.intern();
            uri = uri.intern();
    if("".equals(prefix))            
            {
    if("".equals(uri))                
                {
                    defaultNS = null;
                } //End block
                else
                {
                    defaultNS = uri;
                } //End block
            } //End block
            else
            {
                prefixTable.put(prefix, uri);
                uriTable.put(uri, prefix);
            } //End block
            declarations.add(prefix);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.466 -0400", hash_original_method = "33259345EBD99FFF49F4E1AAD2529013", hash_generated_method = "B7A2747CBF499796EC9963597222F201")
         String [] processName(String qName, boolean isAttribute) {
            addTaint(isAttribute);
            addTaint(qName.getTaint());
            String name[];
            Hashtable table;
            declsOK = false;
    if(isAttribute)            
            {
                table = attributeNameTable;
            } //End block
            else
            {
                table = elementNameTable;
            } //End block
            name = (String[])table.get(qName);
    if(name != null)            
            {
String [] varB017984728AC60AD1F0BF8734F33F15C_724744092 =                 name;
                varB017984728AC60AD1F0BF8734F33F15C_724744092.addTaint(taint);
                return varB017984728AC60AD1F0BF8734F33F15C_724744092;
            } //End block
            name = new String[3];
            name[2] = qName.intern();
            int index = qName.indexOf(':');
    if(index == -1)            
            {
    if(isAttribute)                
                {
    if(qName == "xmlns" && namespaceDeclUris)                    
                    name[0] = NSDECL;
                    else
                    name[0] = "";
                } //End block
                else
    if(defaultNS == null)                
                {
                    name[0] = "";
                } //End block
                else
                {
                    name[0] = defaultNS;
                } //End block
                name[1] = name[2];
            } //End block
            else
            {
                String prefix = qName.substring(0, index);
                String local = qName.substring(index+1);
                String uri;
    if("".equals(prefix))                
                {
                    uri = defaultNS;
                } //End block
                else
                {
                    uri = (String)prefixTable.get(prefix);
                } //End block
    if(uri == null
            || (!isAttribute && "xmlns".equals (prefix)))                
                {
String [] var540C13E9E156B687226421B24F2DF178_313198878 =                     null;
                    var540C13E9E156B687226421B24F2DF178_313198878.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_313198878;
                } //End block
                name[0] = uri;
                name[1] = local.intern();
            } //End block
            table.put(name[2], name);
String [] varB017984728AC60AD1F0BF8734F33F15C_141970397 =             name;
            varB017984728AC60AD1F0BF8734F33F15C_141970397.addTaint(taint);
            return varB017984728AC60AD1F0BF8734F33F15C_141970397;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.468 -0400", hash_original_method = "33F968ABABCEBD2BA0661937EB8377F0", hash_generated_method = "9D9A4F52417BCF325DE2B971580817A5")
         String getURI(String prefix) {
            addTaint(prefix.getTaint());
    if("".equals(prefix))            
            {
String varFCE0B69A9C44C483F2D75E6F31B4A5C1_1490539059 =                 defaultNS;
                varFCE0B69A9C44C483F2D75E6F31B4A5C1_1490539059.addTaint(taint);
                return varFCE0B69A9C44C483F2D75E6F31B4A5C1_1490539059;
            } //End block
            else
    if(prefixTable == null)            
            {
String var540C13E9E156B687226421B24F2DF178_1494214353 =                 null;
                var540C13E9E156B687226421B24F2DF178_1494214353.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1494214353;
            } //End block
            else
            {
String var4ADD76D79BB28EDB1A2636B311F90B44_1063791693 =                 (String)prefixTable.get(prefix);
                var4ADD76D79BB28EDB1A2636B311F90B44_1063791693.addTaint(taint);
                return var4ADD76D79BB28EDB1A2636B311F90B44_1063791693;
            } //End block
            // ---------- Original Method ----------
            //if ("".equals(prefix)) {
        //return defaultNS;
        //} else if (prefixTable == null) {
        //return null;
        //} else {
        //return (String)prefixTable.get(prefix);
        //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.469 -0400", hash_original_method = "62121EA4CFF0891BFB2032F7AF8FE7A1", hash_generated_method = "978403B59C87E1A40FD4B8121AADB781")
         String getPrefix(String uri) {
            addTaint(uri.getTaint());
    if(uriTable == null)            
            {
String var540C13E9E156B687226421B24F2DF178_296176240 =                 null;
                var540C13E9E156B687226421B24F2DF178_296176240.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_296176240;
            } //End block
            else
            {
String varD66BEA98E2A9549F3CCA4F534E7D70AE_1200326035 =                 (String)uriTable.get(uri);
                varD66BEA98E2A9549F3CCA4F534E7D70AE_1200326035.addTaint(taint);
                return varD66BEA98E2A9549F3CCA4F534E7D70AE_1200326035;
            } //End block
            // ---------- Original Method ----------
            //if (uriTable == null) {
        //return null;
        //} else {
        //return (String)uriTable.get(uri);
        //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.469 -0400", hash_original_method = "B116CF358C1D0DA8CF46DFF106939FC0", hash_generated_method = "F9006525F9B083D6D446B8AC65AD15EB")
         Enumeration getDeclaredPrefixes() {
Enumeration var6D101BA062498AE3A785D3901BC4F2E7_1649917791 =             (declarations == null) ? EMPTY_ENUMERATION : Collections.enumeration(declarations);
            var6D101BA062498AE3A785D3901BC4F2E7_1649917791.addTaint(taint);
            return var6D101BA062498AE3A785D3901BC4F2E7_1649917791;
            // ---------- Original Method ----------
            //return (declarations == null) ? EMPTY_ENUMERATION : Collections.enumeration(declarations);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.470 -0400", hash_original_method = "D02303EBFA8DB4A97AF291339C2FB52B", hash_generated_method = "47E9A3A42E2B69641E2520BEA2689559")
         Enumeration getPrefixes() {
    if(prefixTable == null)            
            {
Enumeration var03B3C703BC5375AB3A8C9B9127FB0C4D_1806466133 =                 EMPTY_ENUMERATION;
                var03B3C703BC5375AB3A8C9B9127FB0C4D_1806466133.addTaint(taint);
                return var03B3C703BC5375AB3A8C9B9127FB0C4D_1806466133;
            } //End block
            else
            {
Enumeration varBFCD16886F1317652E333795EE580297_1752172125 =                 prefixTable.keys();
                varBFCD16886F1317652E333795EE580297_1752172125.addTaint(taint);
                return varBFCD16886F1317652E333795EE580297_1752172125;
            } //End block
            // ---------- Original Method ----------
            //if (prefixTable == null) {
        //return EMPTY_ENUMERATION;
        //} else {
        //return prefixTable.keys();
        //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.471 -0400", hash_original_method = "26D71A046B8A5E21DEFC65FB89CD9FDA", hash_generated_method = "01B5A4107A0C0CF2E1BDF9FC42DC4E82")
        private void copyTables() {
    if(prefixTable != null)            
            {
                prefixTable = (Hashtable)prefixTable.clone();
            } //End block
            else
            {
                prefixTable = new Hashtable();
            } //End block
    if(uriTable != null)            
            {
                uriTable = (Hashtable)uriTable.clone();
            } //End block
            else
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.472 -0400", hash_original_field = "A4E29D7FEF12BB1BA5EF68A64621892E", hash_generated_field = "E2237A0DCAD2773A6CC25F576EAF7F53")

    public static final String XMLNS =
    "http://www.w3.org/XML/1998/namespace";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.472 -0400", hash_original_field = "52DCBC4E195EDCDDD5C502199F884871", hash_generated_field = "1571E423031924244408A7D28A741EE6")

    public static final String NSDECL =
    "http://www.w3.org/xmlns/2000/";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:44.472 -0400", hash_original_field = "49A583D17F7F788F509CDB87E67F0800", hash_generated_field = "0A58893494FE31226DF50FC333D4E439")

    private static final Enumeration EMPTY_ENUMERATION = Collections.enumeration(Collections.emptyList());
}

