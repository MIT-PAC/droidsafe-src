package org.apache.harmony.security.x501;

// Droidsafe Imports
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.security.auth.x500.X500Principal;

import org.apache.harmony.security.asn1.ASN1SequenceOf;
import org.apache.harmony.security.asn1.ASN1SetOf;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.DerInputStream;
import org.apache.harmony.security.x509.DNParser;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public final class Name {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.750 -0400", hash_original_field = "4B719ACEE4A1D5E30577F59E80D06205", hash_generated_field = "30CBCFF31EBF02BAF8CCE8746893E2BE")

    private volatile byte[] encoded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.750 -0400", hash_original_field = "D3D447AF80DE9C9F3D9B63CF94F55184", hash_generated_field = "E9B4D5E56AD2A3335D3949EE5A0BDAE4")

    private String rfc1779String;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.751 -0400", hash_original_field = "664A0E8FFD9C61643C45E3F591AD329D", hash_generated_field = "4EB0ACB941F165E12B4051EF94EDEC10")

    private String rfc2253String;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.751 -0400", hash_original_field = "B29221210691C6B855770C8489C5F896", hash_generated_field = "176833DBCE1C94B471D76BC4A5F6B374")

    private String canonicalString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.751 -0400", hash_original_field = "A7C4EB7A67911D7C03FB9703168ED3E7", hash_generated_field = "613FBB7F6EF0BF172336FED0F72DF53F")

    private List<List<AttributeTypeAndValue>> rdn;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.751 -0400", hash_original_method = "7EBA5C9ECD25887AF5B543E5839AFD7E", hash_generated_method = "6FE4AA6E633098CBBAF9897E06B74B3F")
    public  Name(byte[] encoding) throws IOException {
        addTaint(encoding[0]);
        DerInputStream in = new DerInputStream(encoding);
        if(in.getEndOffset() != encoding.length)        
        {
            IOException varAB47338E7FFFC7C5ED8E5096A46169C7_582792987 = new IOException("Wrong content length");
            varAB47338E7FFFC7C5ED8E5096A46169C7_582792987.addTaint(taint);
            throw varAB47338E7FFFC7C5ED8E5096A46169C7_582792987;
        } //End block
        ASN1.decode(in);
        this.rdn = (List<List<AttributeTypeAndValue>>) in.content;
        // ---------- Original Method ----------
        //DerInputStream in = new DerInputStream(encoding);
        //if (in.getEndOffset() != encoding.length) {
            //throw new IOException("Wrong content length");
        //}
        //ASN1.decode(in);
        //this.rdn = (List<List<AttributeTypeAndValue>>) in.content;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.752 -0400", hash_original_method = "C2DB210B9AE13E0849500530EB26AF9F", hash_generated_method = "99987687812445E7EE166CCEBCAFD37E")
    public  Name(String name) throws IOException {
        rdn = new DNParser(name).parse();
        // ---------- Original Method ----------
        //rdn = new DNParser(name).parse();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.752 -0400", hash_original_method = "31033A15DF0AC22272F2A1E0E5DFAD4C", hash_generated_method = "8232F001CAB6A6D20D5565435712EF88")
    private  Name(List<List<AttributeTypeAndValue>> rdn) {
        this.rdn = rdn;
        // ---------- Original Method ----------
        //this.rdn = rdn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.753 -0400", hash_original_method = "0542B71517FD35CAEA3075D7EB945221", hash_generated_method = "EF24A9673132B01D4811115706B3576B")
    public X500Principal getX500Principal() {
X500Principal varDAA92896EE3532444EC597CD40E21AB2_640524390 =         new X500Principal(getEncoded());
        varDAA92896EE3532444EC597CD40E21AB2_640524390.addTaint(taint);
        return varDAA92896EE3532444EC597CD40E21AB2_640524390;
        // ---------- Original Method ----------
        //return new X500Principal(getEncoded());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.754 -0400", hash_original_method = "5BEC09DB13BD8A96A72F05D9AA4FB5FA", hash_generated_method = "B0EFB3AD395ABA157F41E9257CAF6185")
    public String getName(String format) {
        if(X500Principal.RFC1779.equals(format))        
        {
            if(rfc1779String == null)            
            {
                rfc1779String = getName0(format);
            } //End block
String var0D48121B66F6CAEBAAB97E281579A1E8_2115851109 =             rfc1779String;
            var0D48121B66F6CAEBAAB97E281579A1E8_2115851109.addTaint(taint);
            return var0D48121B66F6CAEBAAB97E281579A1E8_2115851109;
        } //End block
        else
        if(X500Principal.RFC2253.equals(format))        
        {
            if(rfc2253String == null)            
            {
                rfc2253String = getName0(format);
            } //End block
String var3829092DB096211EB6A6EAE848B76893_1789170527 =             rfc2253String;
            var3829092DB096211EB6A6EAE848B76893_1789170527.addTaint(taint);
            return var3829092DB096211EB6A6EAE848B76893_1789170527;
        } //End block
        else
        if(X500Principal.CANONICAL.equals(format))        
        {
            if(canonicalString == null)            
            {
                canonicalString = getName0(format);
            } //End block
String varA736130F7261BDD046BD91E8F9411BA0_820705166 =             canonicalString;
            varA736130F7261BDD046BD91E8F9411BA0_820705166.addTaint(taint);
            return varA736130F7261BDD046BD91E8F9411BA0_820705166;
        } //End block
        else
        if(X500Principal.RFC1779.equalsIgnoreCase(format))        
        {
            if(rfc1779String == null)            
            {
                rfc1779String = getName0(X500Principal.RFC1779);
            } //End block
String var0D48121B66F6CAEBAAB97E281579A1E8_599835462 =             rfc1779String;
            var0D48121B66F6CAEBAAB97E281579A1E8_599835462.addTaint(taint);
            return var0D48121B66F6CAEBAAB97E281579A1E8_599835462;
        } //End block
        else
        if(X500Principal.RFC2253.equalsIgnoreCase(format))        
        {
            if(rfc2253String == null)            
            {
                rfc2253String = getName0(X500Principal.RFC2253);
            } //End block
String var3829092DB096211EB6A6EAE848B76893_1880758218 =             rfc2253String;
            var3829092DB096211EB6A6EAE848B76893_1880758218.addTaint(taint);
            return var3829092DB096211EB6A6EAE848B76893_1880758218;
        } //End block
        else
        if(X500Principal.CANONICAL.equalsIgnoreCase(format))        
        {
            if(canonicalString == null)            
            {
                canonicalString = getName0(X500Principal.CANONICAL);
            } //End block
String varA736130F7261BDD046BD91E8F9411BA0_2039158447 =             canonicalString;
            varA736130F7261BDD046BD91E8F9411BA0_2039158447.addTaint(taint);
            return varA736130F7261BDD046BD91E8F9411BA0_2039158447;
        } //End block
        else
        {
            IllegalArgumentException var18E1AB404773CEF862E70CD7C0D8BEDC_1947542738 = new IllegalArgumentException("Illegal format: " + format);
            var18E1AB404773CEF862E70CD7C0D8BEDC_1947542738.addTaint(taint);
            throw var18E1AB404773CEF862E70CD7C0D8BEDC_1947542738;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.756 -0400", hash_original_method = "F650F61C4EF367763857B0C83C9384E7", hash_generated_method = "A90CC2F918F4CD8ACDB99F53F93ED3A6")
    private String getName0(String format) {
        addTaint(format.getTaint());
        StringBuilder name = new StringBuilder();
for(int i = rdn.size() - 1;i >= 0;i--)
        {
            List<AttributeTypeAndValue> atavList = rdn.get(i);
            if(X500Principal.CANONICAL == format)            
            {
                atavList = new ArrayList<AttributeTypeAndValue>(atavList);
                Collections.sort(atavList, new AttributeTypeAndValueComparator());
            } //End block
            Iterator<AttributeTypeAndValue> it = atavList.iterator();
            while
(it.hasNext())            
            {
                AttributeTypeAndValue attributeTypeAndValue = it.next();
                attributeTypeAndValue.appendName(format, name);
                if(it.hasNext())                
                {
                    if(X500Principal.RFC1779 == format)                    
                    {
                        name.append(" + ");
                    } //End block
                    else
                    {
                        name.append('+');
                    } //End block
                } //End block
            } //End block
            if(i != 0)            
            {
                name.append(',');
                if(format == X500Principal.RFC1779)                
                {
                    name.append(' ');
                } //End block
            } //End block
        } //End block
        String sName = name.toString();
        if(X500Principal.CANONICAL.equals(format))        
        {
            sName = sName.toLowerCase(Locale.US);
        } //End block
String var6130110C1AB32206E1BE85A4D254C151_739474773 =         sName;
        var6130110C1AB32206E1BE85A4D254C151_739474773.addTaint(taint);
        return var6130110C1AB32206E1BE85A4D254C151_739474773;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.757 -0400", hash_original_method = "2981EA1A601F56A7B701653790363606", hash_generated_method = "0DCFE99290687781238E59380A3DA79A")
    public byte[] getEncoded() {
        if(encoded == null)        
        {
            encoded = ASN1.encode(this);
        } //End block
        byte[] var4B719ACEE4A1D5E30577F59E80D06205_568722643 = (encoded);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_289438826 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_289438826;
        // ---------- Original Method ----------
        //if (encoded == null) {
            //encoded = ASN1.encode(this);
        //}
        //return encoded;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.757 -0400", hash_original_field = "7583F52F0E9C85B2DF53D66BFAA66FF7", hash_generated_field = "292A5C4C3AF0A6F5B034171E032DDEFA")

    public static final ASN1SetOf ASN1_RDN = new ASN1SetOf(
            AttributeTypeAndValue.ASN1);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.757 -0400", hash_original_field = "8455297A18620927B582292F082B718B", hash_generated_field = "597EE65661FDE3B49FE8B0352BA399B9")

    public static final ASN1SequenceOf ASN1 = new ASN1SequenceOf(ASN1_RDN) {

        public Object getDecodedObject(BerInputStream in) {
            return new Name((List<List<AttributeTypeAndValue>>) in.content);
        }

        public Collection getValues(Object object) {
            return ((Name) object).rdn;
        }
    };
    // orphaned legacy method
    public Collection getValues(Object object) {
            return ((Name) object).rdn;
        }
    
    // orphaned legacy method
    public Object getDecodedObject(BerInputStream in) {
            return new Name((List<List<AttributeTypeAndValue>>) in.content);
        }
    
}

