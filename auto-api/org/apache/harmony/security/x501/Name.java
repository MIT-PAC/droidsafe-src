package org.apache.harmony.security.x501;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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

public final class Name {
    private volatile byte[] encoded;
    private String rfc1779String;
    private String rfc2253String;
    private String canonicalString;
    private List<List<AttributeTypeAndValue>> rdn;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.513 -0400", hash_original_method = "7EBA5C9ECD25887AF5B543E5839AFD7E", hash_generated_method = "2DA9BB5CE64B79217B7AF3B2433732FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Name(byte[] encoding) throws IOException {
        dsTaint.addTaint(encoding[0]);
        DerInputStream in;
        in = new DerInputStream(encoding);
        {
            boolean var7BCB0509788D553E8FA912AF9C311FBA_571017162 = (in.getEndOffset() != encoding.length);
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Wrong content length");
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.514 -0400", hash_original_method = "C2DB210B9AE13E0849500530EB26AF9F", hash_generated_method = "A4AB72AE71D6A300FF216EDFCB7B1735")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Name(String name) throws IOException {
        dsTaint.addTaint(name);
        rdn = new DNParser(name).parse();
        // ---------- Original Method ----------
        //rdn = new DNParser(name).parse();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.514 -0400", hash_original_method = "31033A15DF0AC22272F2A1E0E5DFAD4C", hash_generated_method = "839D8BA75D3AED4FB1D28086A4476120")
    @DSModeled(DSC.SAFE)
    private Name(List<List<AttributeTypeAndValue>> rdn) {
        dsTaint.addTaint(rdn.dsTaint);
        // ---------- Original Method ----------
        //this.rdn = rdn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.514 -0400", hash_original_method = "0542B71517FD35CAEA3075D7EB945221", hash_generated_method = "4290DCD4C35C51A21AE6D9626A955025")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public X500Principal getX500Principal() {
        X500Principal varA891852699D4DBF15C94A632B0328BCE_1562007866 = (new X500Principal(getEncoded()));
        return (X500Principal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new X500Principal(getEncoded());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.514 -0400", hash_original_method = "5BEC09DB13BD8A96A72F05D9AA4FB5FA", hash_generated_method = "9F53ACC61D6412A28C6DA1230A205D18")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getName(String format) {
        dsTaint.addTaint(format);
        {
            boolean var9F3E2E2B2C63C7BA67AE80E135A949C7_140482019 = (X500Principal.RFC1779.equals(format));
            {
                {
                    rfc1779String = getName0(format);
                } //End block
            } //End block
            {
                boolean var635B3366C601FAF6F89B027A5B4C0FBB_1491724687 = (X500Principal.RFC2253.equals(format));
                {
                    {
                        rfc2253String = getName0(format);
                    } //End block
                } //End block
                {
                    boolean var8458FA31BAAF6CD07D7E0DCEE6BB7213_2014159177 = (X500Principal.CANONICAL.equals(format));
                    {
                        {
                            canonicalString = getName0(format);
                        } //End block
                    } //End block
                    {
                        boolean varBBDF17E278B208711BBFE0B7A0326264_1005626085 = (X500Principal.RFC1779.equalsIgnoreCase(format));
                        {
                            {
                                rfc1779String = getName0(X500Principal.RFC1779);
                            } //End block
                        } //End block
                        {
                            boolean varAB40B8C6605B7679B4FE08F3C1B2698B_1216853230 = (X500Principal.RFC2253.equalsIgnoreCase(format));
                            {
                                {
                                    rfc2253String = getName0(X500Principal.RFC2253);
                                } //End block
                            } //End block
                            {
                                boolean var9FF9CDC2F36283DAF8FFAA752D307F5F_1105166806 = (X500Principal.CANONICAL.equalsIgnoreCase(format));
                                {
                                    {
                                        canonicalString = getName0(X500Principal.CANONICAL);
                                    } //End block
                                } //End block
                                {
                                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Illegal format: " + format);
                                } //End block
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.515 -0400", hash_original_method = "F650F61C4EF367763857B0C83C9384E7", hash_generated_method = "5E3F6B9B9E78148EC1681C1FC53FCA13")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String getName0(String format) {
        dsTaint.addTaint(format);
        StringBuilder name;
        name = new StringBuilder();
        {
            int i;
            i = rdn.size() - 1;
            {
                List<AttributeTypeAndValue> atavList;
                atavList = rdn.get(i);
                {
                    atavList = new ArrayList<AttributeTypeAndValue>(atavList);
                    Collections.sort(atavList, new AttributeTypeAndValueComparator());
                } //End block
                Iterator<AttributeTypeAndValue> it;
                it = atavList.iterator();
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_1103229734 = (it.hasNext());
                    {
                        AttributeTypeAndValue attributeTypeAndValue;
                        attributeTypeAndValue = it.next();
                        attributeTypeAndValue.appendName(format, name);
                        {
                            boolean var19710F7E505762555D6239218929D393_607053639 = (it.hasNext());
                            {
                                {
                                    name.append(" + ");
                                } //End block
                                {
                                    name.append('+');
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    name.append(',');
                    {
                        name.append(' ');
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        String sName;
        sName = name.toString();
        {
            boolean var03913642DFC5582E852E52BB2FD4098E_1782322330 = (X500Principal.CANONICAL.equals(format));
            {
                sName = sName.toLowerCase(Locale.US);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.516 -0400", hash_original_method = "2981EA1A601F56A7B701653790363606", hash_generated_method = "4C3C29DC3174018BE81CBB1396382131")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getEncoded() {
        {
            encoded = ASN1.encode(this);
        } //End block
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (encoded == null) {
            //encoded = ASN1.encode(this);
        //}
        //return encoded;
    }

    
    public static final ASN1SetOf ASN1_RDN = new ASN1SetOf(
            AttributeTypeAndValue.ASN1);
    public static final ASN1SequenceOf ASN1 = new ASN1SequenceOf(ASN1_RDN) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.516 -0400", hash_original_method = "AE12B5F4C720C4DD20E3FB3F6A6065AA", hash_generated_method = "8CA7CF5703BAB0DBE6DB5CE2CCA3DFB8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Object getDecodedObject(BerInputStream in) {
            dsTaint.addTaint(in.dsTaint);
            Object var83CE37079A7D6B1E79B368A839345A3C_845394239 = (new Name((List<List<AttributeTypeAndValue>>) in.content));
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Name((List<List<AttributeTypeAndValue>>) in.content);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.516 -0400", hash_original_method = "016399535C7822D693ADBCE49E7AA104", hash_generated_method = "3560D40D6AFB5E58C108C7160D2E9BD1")
        @DSModeled(DSC.SAFE)
        public Collection getValues(Object object) {
            dsTaint.addTaint(object.dsTaint);
            return (Collection)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return ((Name) object).rdn;
        }

        
}; //Transformed anonymous class
}

