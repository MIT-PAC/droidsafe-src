package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

import org.apache.harmony.security.asn1.ASN1Boolean;
import org.apache.harmony.security.asn1.ASN1Explicit;
import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;






public final class IssuingDistributionPoint extends ExtensionValue {

    /**
     * Creates the extension object on the base of its encoded form.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.377 -0500", hash_original_method = "006A266C2AF487BC68B2B3E1762E4A9B", hash_generated_method = "E656F0061A5D0B51468D11AEE7DA96A6")
    
public static IssuingDistributionPoint decode(byte[] encoding)
            throws IOException {
        IssuingDistributionPoint idp =
            (IssuingDistributionPoint) ASN1.decode(encoding);
        idp.encoding = encoding;
        return idp;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.458 -0400", hash_original_field = "DFF85DC774D5EF73A048B0D504801D92", hash_generated_field = "5BA18BFCED65E5DF9764BC88362AA883")

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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.395 -0500", hash_original_method = "F5189D21B9E9E64EECA520233F4C56C2", hash_generated_method = "05C4211F8BEB1A8FE9513910D1DB27C8")
        
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.397 -0500", hash_original_method = "3F7F15893EFCDB156C220AF2C1AA9CC3", hash_generated_method = "0964EF85500DD40175A06A114DC5F0A7")
        
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.360 -0500", hash_original_field = "0C84BAD625229025752DA12A1FFF0D16", hash_generated_field = "C80BD58F96027F5568A9D89DFE20A460")

    private DistributionPointName distributionPoint;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.362 -0500", hash_original_field = "6598A514DC05F46D47EF48F61BF3B045", hash_generated_field = "7D7EC9B83892398601256E7FCB69A6A3")

    private boolean onlyContainsUserCerts = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.364 -0500", hash_original_field = "CCB02621AA896296CD740C928E08AB05", hash_generated_field = "EAECA1779EC9802CE014E84B22EEB9D9")

    private boolean onlyContainsCACerts = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.367 -0500", hash_original_field = "37D0352877BD6EE01E9C3805CD51C4A5", hash_generated_field = "29CAE1AFE653F2C762FAEF2C39EBB137")

    private ReasonFlags onlySomeReasons;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.369 -0500", hash_original_field = "9F168268409F360EF8F77107BCD358F0", hash_generated_field = "985B57FD04887D4F3D03AF78AC55138C")

    private boolean indirectCRL = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.371 -0500", hash_original_field = "11D82790EB9FC34E5DA16199E83284C6", hash_generated_field = "85447E857FA0A95849BB571D30F8B504")

    private boolean onlyContainsAttributeCerts = false;

    /**
     * Constructs the object on the base of its distributionPoint and
     * onlySomeReasons fields values.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.373 -0500", hash_original_method = "5DAD3F148ACCC07E280B84A8DEBF40F1", hash_generated_method = "9BE834C01C8A098E09C0FD53B58DEE38")
    
public IssuingDistributionPoint(DistributionPointName distributionPoint,
            ReasonFlags onlySomeReasons) {
        this.distributionPoint = distributionPoint;
        this.onlySomeReasons = onlySomeReasons;
    }

    /**
     * Sets the value of onlyContainsUserCerts field of the structure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.379 -0500", hash_original_method = "03922EAD5E2F9F2AB784075C187D5E70", hash_generated_method = "5992E0E519DE2E587AEF085A83711E4D")
    
public void setOnlyContainsUserCerts(boolean onlyContainsUserCerts) {
        this.onlyContainsUserCerts = onlyContainsUserCerts;
    }

    /**
     * Sets the value of onlyContainsCACerts field of the structure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.381 -0500", hash_original_method = "6830D99EF8C3DC25A9447803CA3D9DFD", hash_generated_method = "1A98C58989645658D762D067EEC5D149")
    
public void setOnlyContainsCACerts(boolean onlyContainsCACerts) {
        this.onlyContainsCACerts = onlyContainsCACerts;
    }

    /**
     * Sets the value of indirectCRL field of the structure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.383 -0500", hash_original_method = "36EDEF780E7094A51B0A764BC2947568", hash_generated_method = "0A2638519EAE987F986F557E81F757EF")
    
public void setIndirectCRL(boolean indirectCRL) {
        this.indirectCRL = indirectCRL;
    }

    /**
     * Sets the value of onlyContainsAttributeCerts field of the structure.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.385 -0500", hash_original_method = "58BDD73BA57E97A28C9513E87278364E", hash_generated_method = "EAFD8F81AE7631FFA296473FCFD6F1CD")
    
public void setOnlyContainsAttributeCerts(
            boolean onlyContainsAttributeCerts) {
        this.onlyContainsAttributeCerts = onlyContainsAttributeCerts;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.388 -0500", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "552F71A862C62513AAC32037F4D2FC1B")
    
@Override public byte[] getEncoded() {
        if (encoding == null) {
            encoding = ASN1.encode(this);
        }
        return encoding;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.390 -0500", hash_original_method = "CFA4D64F052CACDD48400E19E895ABEB", hash_generated_method = "19E139B2248082A1E760369FB681E48E")
    
@Override public void dumpValue(StringBuilder sb, String prefix) {
        sb.append(prefix).append("Issuing Distribution Point: [\n");
        if (distributionPoint != null) {
            distributionPoint.dumpValue(sb, "  " + prefix);
        }
        sb.append(prefix).append("  onlyContainsUserCerts: ").append(onlyContainsUserCerts).append('\n');
        sb.append(prefix).append("  onlyContainsCACerts: ").append(onlyContainsCACerts).append('\n');
        if (onlySomeReasons != null) {
            onlySomeReasons.dumpValue(sb, prefix + "  ");
        }
        sb.append(prefix).append("  indirectCRL: ").append(indirectCRL).append('\n');
        sb.append(prefix).append("  onlyContainsAttributeCerts: ").append(onlyContainsAttributeCerts).append('\n');
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
    
}

