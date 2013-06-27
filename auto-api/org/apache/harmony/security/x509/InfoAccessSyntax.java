package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import org.apache.harmony.security.asn1.ASN1SequenceOf;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

public final class InfoAccessSyntax extends ExtensionValue {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.938 -0400", hash_original_field = "791E34A4C4E0B8B231743C7BE60C4EB0", hash_generated_field = "677A1C50FB50E227670E2B82296409DA")

    private List<?> accessDescriptions;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.952 -0400", hash_original_method = "4CEC0F2DDF7912449CE6AD3ED26DAD30", hash_generated_method = "857EBEC6C4D2E090805359FC2E5A3E88")
    private  InfoAccessSyntax(List<?> accessDescriptions, byte[] encoding) throws IOException {
        {
            boolean varEDA4CC78796AF28C94BCF92FF99890A6_273541225 = (accessDescriptions == null || accessDescriptions.isEmpty());
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("AccessDescriptions list is null or empty");
            } //End block
        } //End collapsed parenthetic
        this.accessDescriptions = accessDescriptions;
        this.encoding = encoding;
        addTaint(encoding[0]);
        // ---------- Original Method ----------
        //if (accessDescriptions == null || accessDescriptions.isEmpty()) {
            //throw new IOException("AccessDescriptions list is null or empty");
        //}
        //this.accessDescriptions = accessDescriptions;
        //this.encoding = encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.952 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "BA166B2EF5DE4797A274204673DEF900")
    @Override
    public byte[] getEncoded() {
        {
            encoding = ASN1.encode(this);
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1436896912 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1436896912;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(this);
        //}
        //return encoding;
    }

    
        public static InfoAccessSyntax decode(byte[] encoding) throws IOException {
        return ((InfoAccessSyntax) ASN1.decode(encoding));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.988 -0400", hash_original_method = "CB86A2DBB1FE1A1292A1258597C50E5F", hash_generated_method = "27769E74DD35C988B5D7217C5EB07D5F")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_540246884 = null; //Variable for return #1
        StringBuilder res;
        res = new StringBuilder();
        res.append("\n---- InfoAccessSyntax:");
        {
            {
                Iterator<Object> var5E094A91BA5D34A81EEFA278B694B106_1399686347 = (accessDescriptions).iterator();
                var5E094A91BA5D34A81EEFA278B694B106_1399686347.hasNext();
                Object accessDescription = var5E094A91BA5D34A81EEFA278B694B106_1399686347.next();
                {
                    res.append('\n');
                    res.append(accessDescription);
                } //End block
            } //End collapsed parenthetic
        } //End block
        res.append("\n---- InfoAccessSyntax END\n");
        varB4EAC82CA7396A68D541C85D26508E83_540246884 = res.toString();
        varB4EAC82CA7396A68D541C85D26508E83_540246884.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_540246884;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.026 -0400", hash_original_method = "781E3C6C6D65C7307F0C093EFF5048AD", hash_generated_method = "8EA5A26DA15301FF731126EEA6942F03")
    @Override
    public void dumpValue(StringBuilder sb, String prefix) {
        sb.append(prefix).append("AccessDescriptions:\n");
        {
            boolean varEDA4CC78796AF28C94BCF92FF99890A6_79863651 = (accessDescriptions == null || accessDescriptions.isEmpty());
            {
                sb.append("NULL\n");
            } //End block
            {
                {
                    Iterator<Object> var5E094A91BA5D34A81EEFA278B694B106_1705494230 = (accessDescriptions).iterator();
                    var5E094A91BA5D34A81EEFA278B694B106_1705494230.hasNext();
                    Object accessDescription = var5E094A91BA5D34A81EEFA278B694B106_1705494230.next();
                    {
                        sb.append(accessDescription.toString());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(sb.getTaint());
        addTaint(prefix.getTaint());
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.026 -0400", hash_original_field = "E611BBC850EAC486F3CEF9633B2E6F73", hash_generated_field = "5FA1DEAA374D887C0615B0A6E5AC612B")

    public static final ASN1Type ASN1 = new ASN1SequenceOf(AccessDescription.ASN1) {
        @Override public Object getDecodedObject(BerInputStream in) throws IOException {
            return new InfoAccessSyntax((List<?>) in.content, in.getEncoded());
        }

        @Override public Collection getValues(Object object) {
            return ((InfoAccessSyntax) object).accessDescriptions;
        }
    };
}

