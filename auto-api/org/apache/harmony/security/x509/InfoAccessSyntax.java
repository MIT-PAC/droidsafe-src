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
    private List<?> accessDescriptions;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.801 -0400", hash_original_method = "4CEC0F2DDF7912449CE6AD3ED26DAD30", hash_generated_method = "F1DC0EDEFBFB0536A730865AFC64895D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private InfoAccessSyntax(List<?> accessDescriptions, byte[] encoding) throws IOException {
        dsTaint.addTaint(accessDescriptions.dsTaint);
        dsTaint.addTaint(encoding[0]);
        {
            boolean varEDA4CC78796AF28C94BCF92FF99890A6_894175466 = (accessDescriptions == null || accessDescriptions.isEmpty());
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("AccessDescriptions list is null or empty");
            } //End block
        } //End collapsed parenthetic
        this.encoding = encoding;
        // ---------- Original Method ----------
        //if (accessDescriptions == null || accessDescriptions.isEmpty()) {
            //throw new IOException("AccessDescriptions list is null or empty");
        //}
        //this.accessDescriptions = accessDescriptions;
        //this.encoding = encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.802 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "07B62BEE8032AB4E194FDF661E084439")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public byte[] getEncoded() {
        {
            encoding = ASN1.encode(this);
        } //End block
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(this);
        //}
        //return encoding;
    }

    
        public static InfoAccessSyntax decode(byte[] encoding) throws IOException {
        return ((InfoAccessSyntax) ASN1.decode(encoding));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.804 -0400", hash_original_method = "CB86A2DBB1FE1A1292A1258597C50E5F", hash_generated_method = "04DBCD4987A6832F0A19B6C1F2686624")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder res;
        res = new StringBuilder();
        res.append("\n---- InfoAccessSyntax:");
        {
            {
                Iterator<Object> var5E094A91BA5D34A81EEFA278B694B106_1370060644 = (accessDescriptions).iterator();
                var5E094A91BA5D34A81EEFA278B694B106_1370060644.hasNext();
                Object accessDescription = var5E094A91BA5D34A81EEFA278B694B106_1370060644.next();
                {
                    res.append('\n');
                    res.append(accessDescription);
                } //End block
            } //End collapsed parenthetic
        } //End block
        res.append("\n---- InfoAccessSyntax END\n");
        String var3F7A63C0290A7D59CE78DF2F46EB4AAE_1661897968 = (res.toString());
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.806 -0400", hash_original_method = "781E3C6C6D65C7307F0C093EFF5048AD", hash_generated_method = "C639FA18BE5851A7E3AD2DAD93246B80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void dumpValue(StringBuilder sb, String prefix) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(sb.dsTaint);
        sb.append(prefix).append("AccessDescriptions:\n");
        {
            boolean varEDA4CC78796AF28C94BCF92FF99890A6_925014848 = (accessDescriptions == null || accessDescriptions.isEmpty());
            {
                sb.append("NULL\n");
            } //End block
            {
                {
                    Iterator<Object> var5E094A91BA5D34A81EEFA278B694B106_1739242528 = (accessDescriptions).iterator();
                    var5E094A91BA5D34A81EEFA278B694B106_1739242528.hasNext();
                    Object accessDescription = var5E094A91BA5D34A81EEFA278B694B106_1739242528.next();
                    {
                        sb.append(accessDescription.toString());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
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

    
    public static final ASN1Type ASN1 = new ASN1SequenceOf(AccessDescription.ASN1) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.807 -0400", hash_original_method = "128D0B05BCF58CF172653E030B1C2EFF", hash_generated_method = "3AE991E398B4054BCEC81C8044B0292F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Object getDecodedObject(BerInputStream in) throws IOException {
            dsTaint.addTaint(in.dsTaint);
            Object var0B9F4262A860A3FE618F585D95F071C3_1084040284 = (new InfoAccessSyntax((List<?>) in.content, in.getEncoded()));
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new InfoAccessSyntax((List<?>) in.content, in.getEncoded());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.807 -0400", hash_original_method = "138F8598CC0F155B5334CA1116D2BA97", hash_generated_method = "1BDD5835AAA0EC87D0C5716C37112F2A")
        @DSModeled(DSC.SAFE)
        @Override
        public Collection getValues(Object object) {
            dsTaint.addTaint(object.dsTaint);
            return (Collection)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return ((InfoAccessSyntax) object).accessDescriptions;
        }

        
}; //Transformed anonymous class
}

