package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.harmony.security.asn1.ASN1SequenceOf;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;






public final class GeneralNames {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.348 -0400", hash_original_field = "08F24DEBB4A72445D5EE1F22A819AF4F", hash_generated_field = "12F5E55FAE92B8BE0DECC643C9318F42")

    private List<GeneralName> generalNames;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.348 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.349 -0400", hash_original_method = "900922C5A2333ABDC3D6DB9D2843B6C9", hash_generated_method = "8A74688EB414143E6D1C7929DFB8071B")
    public  GeneralNames() {
        generalNames = new ArrayList<GeneralName>();
        // ---------- Original Method ----------
        //generalNames = new ArrayList<GeneralName>();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.349 -0400", hash_original_method = "FCF1D75BDAE857F225708496A2E96EC2", hash_generated_method = "6E3DE6D078A590F1F6C1BDB13C3E782D")
    public  GeneralNames(List<GeneralName> generalNames) {
        this.generalNames = generalNames;
        // ---------- Original Method ----------
        //this.generalNames = generalNames;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.350 -0400", hash_original_method = "84AB2B2BC22C66DEEE9A4059D9B177CB", hash_generated_method = "47666260E35014D1A86CB6DA4464F1BC")
    private  GeneralNames(List<GeneralName> generalNames, byte[] encoding) {
        this.generalNames = generalNames;
        this.encoding = encoding;
        // ---------- Original Method ----------
        //this.generalNames = generalNames;
        //this.encoding = encoding;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.350 -0400", hash_original_method = "0BE5F893124FC75916B0920319238607", hash_generated_method = "D517692B15C2EF8775FB3DA1EBA1085D")
    public List<GeneralName> getNames() {
        if((generalNames == null) || (generalNames.size() == 0))        
        {
List<GeneralName> var540C13E9E156B687226421B24F2DF178_949795953 =             null;
            var540C13E9E156B687226421B24F2DF178_949795953.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_949795953;
        } //End block
List<GeneralName> var474A8DB69B4D755AD016C60DFD7D53DB_891452025 =         new ArrayList<GeneralName>(generalNames);
        var474A8DB69B4D755AD016C60DFD7D53DB_891452025.addTaint(taint);
        return var474A8DB69B4D755AD016C60DFD7D53DB_891452025;
        // ---------- Original Method ----------
        //if ((generalNames == null) || (generalNames.size() == 0)) {
            //return null;
        //}
        //return new ArrayList<GeneralName>(generalNames);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.351 -0400", hash_original_method = "393D0968412D8AD2DE170EB074DB113A", hash_generated_method = "F35138AF7ACB9275FF6DD0C91ACDB5A5")
    public Collection<List<?>> getPairsList() {
        Collection<List<?>> result = new ArrayList<List<?>>();
        if(generalNames == null)        
        {
Collection<List<?>> varDC838461EE2FA0CA4C9BBB70A15456B0_1866874156 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_1866874156.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1866874156;
        } //End block
for(GeneralName generalName : generalNames)
        {
            result.add(generalName.getAsList());
        } //End block
Collection<List<?>> varDC838461EE2FA0CA4C9BBB70A15456B0_573025941 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_573025941.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_573025941;
        // ---------- Original Method ----------
        //Collection<List<?>> result = new ArrayList<List<?>>();
        //if (generalNames == null) {
            //return result;
        //}
        //for (GeneralName generalName : generalNames) {
            //result.add(generalName.getAsList());
        //}
        //return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.351 -0400", hash_original_method = "62FCFAA5CD61EB40B84DD9F5E8E0A72D", hash_generated_method = "8F691EEA5E6D395143447EB83ED647D4")
    public void addName(GeneralName name) {
        addTaint(name.getTaint());
        encoding = null;
        if(generalNames == null)        
        {
            generalNames = new ArrayList<GeneralName>();
        } //End block
        generalNames.add(name);
        // ---------- Original Method ----------
        //encoding = null;
        //if (generalNames == null) {
            //generalNames = new ArrayList<GeneralName>();
        //}
        //generalNames.add(name);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.352 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "C8884F6D3255047C716D6897865CBAD1")
    public byte[] getEncoded() {
        if(encoding == null)        
        {
            encoding = ASN1.encode(this);
        } //End block
        byte[] var84BEA1F0FD2CE16F7E562A9F06EF03D3_1800450113 = (encoding);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1539776550 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1539776550;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(this);
        //}
        //return encoding;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.352 -0400", hash_original_method = "78509CF3CFA7027FFCDFED35C29E300D", hash_generated_method = "683FDAC3570FD76E83AF721E6DEF8483")
    public void dumpValue(StringBuilder sb, String prefix) {
        addTaint(prefix.getTaint());
        addTaint(sb.getTaint());
        if(generalNames == null)        
        {
            return;
        } //End block
for(GeneralName generalName : generalNames)
        {
            sb.append(prefix);
            sb.append(generalName);
            sb.append('\n');
        } //End block
        // ---------- Original Method ----------
        //if (generalNames == null) {
            //return;
        //}
        //for (GeneralName generalName : generalNames) {
            //sb.append(prefix);
            //sb.append(generalName);
            //sb.append('\n');
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.352 -0400", hash_original_field = "F9F6263E38C505EB7173C59BEEA7DE3D", hash_generated_field = "D64C2D3B9F619417B7A91D4BDC12D942")

    public static final ASN1Type ASN1 = new ASN1SequenceOf(GeneralName.ASN1) {
        @Override public Object getDecodedObject(BerInputStream in) {
            return new GeneralNames((List<GeneralName>) in.content, in.getEncoded());
        }

        @Override public Collection getValues(Object object) {
            GeneralNames gns = (GeneralNames) object;
            return gns.generalNames;
        }
    };
}

