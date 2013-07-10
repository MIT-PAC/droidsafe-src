package org.apache.harmony.security.x509;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import org.apache.harmony.security.asn1.ASN1SequenceOf;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

public final class InfoAccessSyntax extends ExtensionValue {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.113 -0400", hash_original_field = "791E34A4C4E0B8B231743C7BE60C4EB0", hash_generated_field = "677A1C50FB50E227670E2B82296409DA")

    private List<?> accessDescriptions;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.114 -0400", hash_original_method = "4CEC0F2DDF7912449CE6AD3ED26DAD30", hash_generated_method = "FB8BA1127AC034039A2160EAB2A8E29F")
    private  InfoAccessSyntax(List<?> accessDescriptions, byte[] encoding) throws IOException {
        {
            boolean varEDA4CC78796AF28C94BCF92FF99890A6_812621047 = (accessDescriptions == null || accessDescriptions.isEmpty());
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("AccessDescriptions list is null or empty");
            } 
        } 
        this.accessDescriptions = accessDescriptions;
        this.encoding = encoding;
        addTaint(encoding[0]);
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.114 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "87B6CA4D1F83CEDFEFB44950A1E1A012")
    @Override
    public byte[] getEncoded() {
        {
            encoding = ASN1.encode(this);
        } 
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1334861319 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1334861319;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static InfoAccessSyntax decode(byte[] encoding) throws IOException {
        return ((InfoAccessSyntax) ASN1.decode(encoding));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.119 -0400", hash_original_method = "CB86A2DBB1FE1A1292A1258597C50E5F", hash_generated_method = "7AF004182B3B225E3D9E5F184C06770B")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_550703251 = null; 
        StringBuilder res = new StringBuilder();
        res.append("\n---- InfoAccessSyntax:");
        {
            {
                Iterator<Object> var5E094A91BA5D34A81EEFA278B694B106_332091518 = (Iterator<Object>) (accessDescriptions).iterator();
                var5E094A91BA5D34A81EEFA278B694B106_332091518.hasNext();
                Object accessDescription = var5E094A91BA5D34A81EEFA278B694B106_332091518.next();
                {
                    res.append('\n');
                    res.append(accessDescription);
                } 
            } 
        } 
        res.append("\n---- InfoAccessSyntax END\n");
        varB4EAC82CA7396A68D541C85D26508E83_550703251 = res.toString();
        varB4EAC82CA7396A68D541C85D26508E83_550703251.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_550703251;
        
        
        
        
            
                
                
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.127 -0400", hash_original_method = "781E3C6C6D65C7307F0C093EFF5048AD", hash_generated_method = "396EBDF3356C7B085DC2E0C2F274B6B6")
    @Override
    public void dumpValue(StringBuilder sb, String prefix) {
        sb.append(prefix).append("AccessDescriptions:\n");
        {
            boolean varEDA4CC78796AF28C94BCF92FF99890A6_323283257 = (accessDescriptions == null || accessDescriptions.isEmpty());
            {
                sb.append("NULL\n");
            } 
            {
                {
                    Iterator<Object> var5E094A91BA5D34A81EEFA278B694B106_1625829309 = (Iterator<Object>) (accessDescriptions).iterator();
                    var5E094A91BA5D34A81EEFA278B694B106_1625829309.hasNext();
                    Object accessDescription = var5E094A91BA5D34A81EEFA278B694B106_1625829309.next();
                    {
                        sb.append(accessDescription.toString());
                    } 
                } 
            } 
        } 
        addTaint(sb.getTaint());
        addTaint(prefix.getTaint());
        
        
        
            
        
            
                
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.127 -0400", hash_original_field = "E611BBC850EAC486F3CEF9633B2E6F73", hash_generated_field = "5FA1DEAA374D887C0615B0A6E5AC612B")

    public static final ASN1Type ASN1 = new ASN1SequenceOf(AccessDescription.ASN1) {
        @Override public Object getDecodedObject(BerInputStream in) throws IOException {
            return new InfoAccessSyntax((List<?>) in.content, in.getEncoded());
        }

        @Override public Collection getValues(Object object) {
            return ((InfoAccessSyntax) object).accessDescriptions;
        }
    };
    
}

