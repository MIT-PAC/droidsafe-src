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
    private DistributionPointName distributionPoint;
    private boolean onlyContainsUserCerts = false;
    private boolean onlyContainsCACerts = false;
    private ReasonFlags onlySomeReasons;
    private boolean indirectCRL = false;
    private boolean onlyContainsAttributeCerts = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.828 -0400", hash_original_method = "5DAD3F148ACCC07E280B84A8DEBF40F1", hash_generated_method = "4220DC9FF127331F95A9B624230EC8CE")
    @DSModeled(DSC.SAFE)
    public IssuingDistributionPoint(DistributionPointName distributionPoint,
            ReasonFlags onlySomeReasons) {
        dsTaint.addTaint(onlySomeReasons.dsTaint);
        dsTaint.addTaint(distributionPoint.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.828 -0400", hash_original_method = "03922EAD5E2F9F2AB784075C187D5E70", hash_generated_method = "8989D19A53F76B911B95233E1459D6B6")
    @DSModeled(DSC.SAFE)
    public void setOnlyContainsUserCerts(boolean onlyContainsUserCerts) {
        dsTaint.addTaint(onlyContainsUserCerts);
        // ---------- Original Method ----------
        //this.onlyContainsUserCerts = onlyContainsUserCerts;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.829 -0400", hash_original_method = "6830D99EF8C3DC25A9447803CA3D9DFD", hash_generated_method = "9729EB1CEC36502645DFE9F2B6132296")
    @DSModeled(DSC.SAFE)
    public void setOnlyContainsCACerts(boolean onlyContainsCACerts) {
        dsTaint.addTaint(onlyContainsCACerts);
        // ---------- Original Method ----------
        //this.onlyContainsCACerts = onlyContainsCACerts;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.829 -0400", hash_original_method = "36EDEF780E7094A51B0A764BC2947568", hash_generated_method = "A884FA805DD814E0F128015E740D0363")
    @DSModeled(DSC.SAFE)
    public void setIndirectCRL(boolean indirectCRL) {
        dsTaint.addTaint(indirectCRL);
        // ---------- Original Method ----------
        //this.indirectCRL = indirectCRL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.829 -0400", hash_original_method = "58BDD73BA57E97A28C9513E87278364E", hash_generated_method = "96159CDB0A48AE9FBFE7CB06B44017B0")
    @DSModeled(DSC.SAFE)
    public void setOnlyContainsAttributeCerts(
            boolean onlyContainsAttributeCerts) {
        dsTaint.addTaint(onlyContainsAttributeCerts);
        // ---------- Original Method ----------
        //this.onlyContainsAttributeCerts = onlyContainsAttributeCerts;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.829 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "07B62BEE8032AB4E194FDF661E084439")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.830 -0400", hash_original_method = "CFA4D64F052CACDD48400E19E895ABEB", hash_generated_method = "C512AF38FE056A5BF68820D2AC82AC67")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void dumpValue(StringBuilder sb, String prefix) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(sb.dsTaint);
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

    
    public static final ASN1Type ASN1 = new ASN1Sequence(
            new ASN1Type[] {
                
                new ASN1Explicit(0, DistributionPointName.ASN1),
                new ASN1Implicit(1, ASN1Boolean.getInstance()),
                new ASN1Implicit(2, ASN1Boolean.getInstance()),
                new ASN1Implicit(3, ReasonFlags.ASN1),
                new ASN1Implicit(4, ASN1Boolean.getInstance()),
                new ASN1Implicit(5, ASN1Boolean.getInstance())
            }) {        {
            setOptional(0);
            setOptional(3);
            setDefault(Boolean.FALSE, 1);
            setDefault(Boolean.FALSE, 2);
            setDefault(Boolean.FALSE, 4);
            setDefault(Boolean.FALSE, 5);
        }
        
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.830 -0400", hash_original_method = "F5189D21B9E9E64EECA520233F4C56C2", hash_generated_method = "314107998070E97B951860996C19AEC5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected Object getDecodedObject(BerInputStream in) {
            dsTaint.addTaint(in.dsTaint);
            Object[] values;
            values = (Object[]) in.content;
            IssuingDistributionPoint idp;
            idp = new IssuingDistributionPoint(
                    (DistributionPointName) values[0], (ReasonFlags) values[3]);
            idp.encoding = in.getEncoded();
            {
                idp.setOnlyContainsUserCerts((Boolean) values[1]);
            } //End block
            {
                idp.setOnlyContainsCACerts((Boolean) values[2]);
            } //End block
            {
                idp.setIndirectCRL((Boolean) values[4]);
            } //End block
            {
                idp.setOnlyContainsAttributeCerts((Boolean) values[5]);
            } //End block
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Object[] values = (Object[]) in.content;
            //IssuingDistributionPoint idp = new IssuingDistributionPoint(
                    //(DistributionPointName) values[0], (ReasonFlags) values[3]);
            //idp.encoding = in.getEncoded();
            //if (values[1] != null) {
                //idp.setOnlyContainsUserCerts((Boolean) values[1]);
            //}
            //if (values[2] != null) {
                //idp.setOnlyContainsCACerts((Boolean) values[2]);
            //}
            //if (values[4] != null) {
                //idp.setIndirectCRL((Boolean) values[4]);
            //}
            //if (values[5] != null) {
                //idp.setOnlyContainsAttributeCerts((Boolean) values[5]);
            //}
            //return idp;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.831 -0400", hash_original_method = "3F7F15893EFCDB156C220AF2C1AA9CC3", hash_generated_method = "62F93EB9B3A31ACF984846B82527BE24")
        @DSModeled(DSC.SAFE)
        protected void getValues(Object object, Object[] values) {
            dsTaint.addTaint(values[0].dsTaint);
            dsTaint.addTaint(object.dsTaint);
            IssuingDistributionPoint idp;
            idp = (IssuingDistributionPoint) object;
            values[0] = idp.distributionPoint;
            values[1] = (idp.onlyContainsUserCerts) ? Boolean.TRUE : null;
            values[2] = (idp.onlyContainsCACerts) ? Boolean.TRUE : null;
            values[3] = idp.onlySomeReasons;
            values[4] = (idp.indirectCRL) ? Boolean.TRUE : null;
            values[5] = (idp.onlyContainsAttributeCerts) ? Boolean.TRUE : null;
            // ---------- Original Method ----------
            //IssuingDistributionPoint idp = (IssuingDistributionPoint) object;
            //values[0] = idp.distributionPoint;
            //values[1] = (idp.onlyContainsUserCerts) ? Boolean.TRUE : null;
            //values[2] = (idp.onlyContainsCACerts) ? Boolean.TRUE : null;
            //values[3] = idp.onlySomeReasons;
            //values[4] = (idp.indirectCRL) ? Boolean.TRUE : null;
            //values[5] = (idp.onlyContainsAttributeCerts) ? Boolean.TRUE : null;
        }

        
}; //Transformed anonymous class
}

