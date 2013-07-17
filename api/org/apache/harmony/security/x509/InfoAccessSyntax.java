package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import org.apache.harmony.security.asn1.ASN1SequenceOf;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

public final class InfoAccessSyntax extends ExtensionValue {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.400 -0400", hash_original_field = "791E34A4C4E0B8B231743C7BE60C4EB0", hash_generated_field = "677A1C50FB50E227670E2B82296409DA")

    private List<?> accessDescriptions;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.400 -0400", hash_original_method = "4CEC0F2DDF7912449CE6AD3ED26DAD30", hash_generated_method = "B2D15DF2D768110F682400EF6ED92BE7")
    private  InfoAccessSyntax(List<?> accessDescriptions, byte[] encoding) throws IOException {
        addTaint(encoding[0]);
        if(accessDescriptions == null || accessDescriptions.isEmpty())        
        {
            IOException var8BFBE5BE2F846B70A77DF509D27293C3_247117781 = new IOException("AccessDescriptions list is null or empty");
            var8BFBE5BE2F846B70A77DF509D27293C3_247117781.addTaint(taint);
            throw var8BFBE5BE2F846B70A77DF509D27293C3_247117781;
        } //End block
        this.accessDescriptions = accessDescriptions;
        this.encoding = encoding;
        // ---------- Original Method ----------
        //if (accessDescriptions == null || accessDescriptions.isEmpty()) {
            //throw new IOException("AccessDescriptions list is null or empty");
        //}
        //this.accessDescriptions = accessDescriptions;
        //this.encoding = encoding;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.401 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "FEBB2338904EAB5D5F73A38C6BD01B1B")
    @Override
    public byte[] getEncoded() {
        if(encoding == null)        
        {
            encoding = ASN1.encode(this);
        } //End block
        byte[] var84BEA1F0FD2CE16F7E562A9F06EF03D3_401285852 = (encoding);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1868676552 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1868676552;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(this);
        //}
        //return encoding;
    }

    
    @DSModeled(DSC.SAFE)
    public static InfoAccessSyntax decode(byte[] encoding) throws IOException {
        return ((InfoAccessSyntax) ASN1.decode(encoding));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.401 -0400", hash_original_method = "CB86A2DBB1FE1A1292A1258597C50E5F", hash_generated_method = "02F1E36209FD26BEACD077DC2706E9D1")
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("\n---- InfoAccessSyntax:");
        if(accessDescriptions != null)        
        {
for(Object accessDescription : accessDescriptions)
            {
                res.append('\n');
                res.append(accessDescription);
            } //End block
        } //End block
        res.append("\n---- InfoAccessSyntax END\n");
String varEC7EB75EF3C7FA633C54FC66A0358174_188951126 =         res.toString();
        varEC7EB75EF3C7FA633C54FC66A0358174_188951126.addTaint(taint);
        return varEC7EB75EF3C7FA633C54FC66A0358174_188951126;
        // ---------- Original Method ----------
        //StringBuilder res = new StringBuilder();
        //res.append("\n---- InfoAccessSyntax:");
        //if (accessDescriptions != null) {
            //for (Object accessDescription : accessDescriptions) {
                //res.append('\n');
                //res.append(accessDescription);
            //}
        //}
        //res.append("\n---- InfoAccessSyntax END\n");
        //return res.toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.402 -0400", hash_original_method = "781E3C6C6D65C7307F0C093EFF5048AD", hash_generated_method = "C1FFA07B3D8EE88D7BBFDD4921489C51")
    @Override
    public void dumpValue(StringBuilder sb, String prefix) {
        addTaint(prefix.getTaint());
        addTaint(sb.getTaint());
        sb.append(prefix).append("AccessDescriptions:\n");
        if(accessDescriptions == null || accessDescriptions.isEmpty())        
        {
            sb.append("NULL\n");
        } //End block
        else
        {
for(Object accessDescription : accessDescriptions)
            {
                sb.append(accessDescription.toString());
            } //End block
        } //End block
        // ---------- Original Method ----------
        //sb.append(prefix).append("AccessDescriptions:\n");
        //if (accessDescriptions == null || accessDescriptions.isEmpty()) {
            //sb.append("NULL\n");
        //} else {
            //for (Object accessDescription : accessDescriptions) {
                //sb.append(accessDescription.toString());
            //}
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.403 -0400", hash_original_field = "E611BBC850EAC486F3CEF9633B2E6F73", hash_generated_field = "5FA1DEAA374D887C0615B0A6E5AC612B")

    public static final ASN1Type ASN1 = new ASN1SequenceOf(AccessDescription.ASN1) {
        @Override public Object getDecodedObject(BerInputStream in) throws IOException {
            return new InfoAccessSyntax((List<?>) in.content, in.getEncoded());
        }

        @Override public Collection getValues(Object object) {
            return ((InfoAccessSyntax) object).accessDescriptions;
        }
    };
}

