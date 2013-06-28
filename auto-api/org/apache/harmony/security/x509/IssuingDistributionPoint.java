package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import org.apache.harmony.security.asn1.ASN1Boolean;
import org.apache.harmony.security.asn1.ASN1Explicit;
import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

public final class IssuingDistributionPoint extends ExtensionValue {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.159 -0400", hash_original_field = "D5E154C7A3634B6FC49AD3EE6A58CF84", hash_generated_field = "C80BD58F96027F5568A9D89DFE20A460")

    private DistributionPointName distributionPoint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.159 -0400", hash_original_field = "3FB434A681D927F88523F12704F383EC", hash_generated_field = "7D7EC9B83892398601256E7FCB69A6A3")

    private boolean onlyContainsUserCerts = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.159 -0400", hash_original_field = "3DB1541D0D9EFD962E35B4732ED5B6E2", hash_generated_field = "EAECA1779EC9802CE014E84B22EEB9D9")

    private boolean onlyContainsCACerts = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.159 -0400", hash_original_field = "A9CABF9967E7A1DA8F28239559271D6F", hash_generated_field = "29CAE1AFE653F2C762FAEF2C39EBB137")

    private ReasonFlags onlySomeReasons;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.159 -0400", hash_original_field = "EC5A14CDD92220F04449BBFD09D3C2C6", hash_generated_field = "985B57FD04887D4F3D03AF78AC55138C")

    private boolean indirectCRL = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.159 -0400", hash_original_field = "2B1C5C7E3F23B341BD4E0A98EA7D7A31", hash_generated_field = "85447E857FA0A95849BB571D30F8B504")

    private boolean onlyContainsAttributeCerts = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.159 -0400", hash_original_method = "5DAD3F148ACCC07E280B84A8DEBF40F1", hash_generated_method = "5F1FB5B4AFDE276C1F722AA473CBA495")
    public  IssuingDistributionPoint(DistributionPointName distributionPoint,
            ReasonFlags onlySomeReasons) {
        this.distributionPoint = distributionPoint;
        this.onlySomeReasons = onlySomeReasons;
        // ---------- Original Method ----------
        //this.distributionPoint = distributionPoint;
        //this.onlySomeReasons = onlySomeReasons;
    }

    
    public static IssuingDistributionPoint decode(byte[] encoding) throws IOException {
        IssuingDistributionPoint idp =
            (IssuingDistributionPoint) ASN1.decode(encoding);
        idp.encoding = encoding;
        return idp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.160 -0400", hash_original_method = "03922EAD5E2F9F2AB784075C187D5E70", hash_generated_method = "001164D0F86A35E6C0E014A195A52B2D")
    public void setOnlyContainsUserCerts(boolean onlyContainsUserCerts) {
        this.onlyContainsUserCerts = onlyContainsUserCerts;
        // ---------- Original Method ----------
        //this.onlyContainsUserCerts = onlyContainsUserCerts;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.160 -0400", hash_original_method = "6830D99EF8C3DC25A9447803CA3D9DFD", hash_generated_method = "5D96BEC6C002F45CA0C2532E084F39E9")
    public void setOnlyContainsCACerts(boolean onlyContainsCACerts) {
        this.onlyContainsCACerts = onlyContainsCACerts;
        // ---------- Original Method ----------
        //this.onlyContainsCACerts = onlyContainsCACerts;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.160 -0400", hash_original_method = "36EDEF780E7094A51B0A764BC2947568", hash_generated_method = "CD3096752BC07691383D6F71ADF7F0E6")
    public void setIndirectCRL(boolean indirectCRL) {
        this.indirectCRL = indirectCRL;
        // ---------- Original Method ----------
        //this.indirectCRL = indirectCRL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.160 -0400", hash_original_method = "58BDD73BA57E97A28C9513E87278364E", hash_generated_method = "75AE7B67E9A4F59328BBA875F3CF861E")
    public void setOnlyContainsAttributeCerts(
            boolean onlyContainsAttributeCerts) {
        this.onlyContainsAttributeCerts = onlyContainsAttributeCerts;
        // ---------- Original Method ----------
        //this.onlyContainsAttributeCerts = onlyContainsAttributeCerts;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.161 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "D33147B937246085A9D06A07A90233FB")
    @Override
    public byte[] getEncoded() {
        {
            encoding = ASN1.encode(this);
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_442950919 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_442950919;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(this);
        //}
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.161 -0400", hash_original_method = "CFA4D64F052CACDD48400E19E895ABEB", hash_generated_method = "203D38F94547050BB36F7557D99CAFD1")
    @Override
    public void dumpValue(StringBuilder sb, String prefix) {
        sb.append(prefix).append("Issuing Distribution Point: [\n");
        {
            distributionPoint.dumpValue(sb, "  " + prefix);
        } //End block
        sb.append(prefix).append("  onlyContainsUserCerts: ").append(onlyContainsUserCerts).append('\n');
        sb.append(prefix).append("  onlyContainsCACerts: ").append(onlyContainsCACerts).append('\n');
        {
            onlySomeReasons.dumpValue(sb, prefix + "  ");
        } //End block
        sb.append(prefix).append("  indirectCRL: ").append(indirectCRL).append('\n');
        sb.append(prefix).append("  onlyContainsAttributeCerts: ").append(onlyContainsAttributeCerts).append('\n');
        addTaint(sb.getTaint());
        addTaint(prefix.getTaint());
        // ---------- Original Method ----------
        //sb.append(prefix).append("Issuing Distribution Point: [\n");
        //if (distributionPoint != null) {
            //distributionPoint.dumpValue(sb, "  " + prefix);
        //}
        //sb.append(prefix).append("  onlyContainsUserCerts: ").append(onlyContainsUserCerts).append('\n');
        //sb.append(prefix).append("  onlyContainsCACerts: ").append(onlyContainsCACerts).append('\n');
        //if (onlySomeReasons != null) {
            //onlySomeReasons.dumpValue(sb, prefix + "  ");
        //}
        //sb.append(prefix).append("  indirectCRL: ").append(indirectCRL).append('\n');
        //sb.append(prefix).append("  onlyContainsAttributeCerts: ").append(onlyContainsAttributeCerts).append('\n');
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.162 -0400", hash_original_field = "DFF85DC774D5EF73A048B0D504801D92", hash_generated_field = "5BA18BFCED65E5DF9764BC88362AA883")

    public static final ASN1Type ASN1 = new ASN1Sequence(
            new ASN1Type[] {
                
                new ASN1Explicit(0, DistributionPointName.ASN1),
                new ASN1Implicit(1, ASN1Boolean.getInstance()),
                new ASN1Implicit(2, ASN1Boolean.getInstance()),
                new ASN1Implicit(3, ReasonFlags.ASN1),
                new ASN1Implicit(4, ASN1Boolean.getInstance()),
                new ASN1Implicit(5, ASN1Boolean.getInstance())
            }) {
        {
            setOptional(0);
            setOptional(3);
            setDefault(Boolean.FALSE, 1);
            setDefault(Boolean.FALSE, 2);
            setDefault(Boolean.FALSE, 4);
            setDefault(Boolean.FALSE, 5);
        }

        protected Object getDecodedObject(BerInputStream in) {
            Object[] values = (Object[]) in.content;
            IssuingDistributionPoint idp = new IssuingDistributionPoint(
                    (DistributionPointName) values[0], (ReasonFlags) values[3]);
            idp.encoding = in.getEncoded();
            if (values[1] != null) {
                idp.setOnlyContainsUserCerts((Boolean) values[1]);
            }
            if (values[2] != null) {
                idp.setOnlyContainsCACerts((Boolean) values[2]);
            }
            if (values[4] != null) {
                idp.setIndirectCRL((Boolean) values[4]);
            }
            if (values[5] != null) {
                idp.setOnlyContainsAttributeCerts((Boolean) values[5]);
            }
            return idp;
        }

        protected void getValues(Object object, Object[] values) {
            IssuingDistributionPoint idp = (IssuingDistributionPoint) object;
            values[0] = idp.distributionPoint;
            values[1] = (idp.onlyContainsUserCerts) ? Boolean.TRUE : null;
            values[2] = (idp.onlyContainsCACerts) ? Boolean.TRUE : null;
            values[3] = idp.onlySomeReasons;
            values[4] = (idp.indirectCRL) ? Boolean.TRUE : null;
            values[5] = (idp.onlyContainsAttributeCerts) ? Boolean.TRUE : null;
        }
    };
    // orphaned legacy method
    protected void getValues(Object object, Object[] values) {
            IssuingDistributionPoint idp = (IssuingDistributionPoint) object;
            values[0] = idp.distributionPoint;
            values[1] = (idp.onlyContainsUserCerts) ? Boolean.TRUE : null;
            values[2] = (idp.onlyContainsCACerts) ? Boolean.TRUE : null;
            values[3] = idp.onlySomeReasons;
            values[4] = (idp.indirectCRL) ? Boolean.TRUE : null;
            values[5] = (idp.onlyContainsAttributeCerts) ? Boolean.TRUE : null;
        }
    
    // orphaned legacy method
    protected Object getDecodedObject(BerInputStream in) {
            Object[] values = (Object[]) in.content;
            IssuingDistributionPoint idp = new IssuingDistributionPoint(
                    (DistributionPointName) values[0], (ReasonFlags) values[3]);
            idp.encoding = in.getEncoded();
            if (values[1] != null) {
                idp.setOnlyContainsUserCerts((Boolean) values[1]);
            }
            if (values[2] != null) {
                idp.setOnlyContainsCACerts((Boolean) values[2]);
            }
            if (values[4] != null) {
                idp.setIndirectCRL((Boolean) values[4]);
            }
            if (values[5] != null) {
                idp.setOnlyContainsAttributeCerts((Boolean) values[5]);
            }
            return idp;
        }
    
}

