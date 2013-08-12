package org.bouncycastle.asn1.x500;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.Enumeration;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x500.style.BCStyle;
import org.bouncycastle.asn1.x509.X509Name;






public class X500Name extends ASN1Encodable implements ASN1Choice {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.333 -0400", hash_original_field = "DE525AA08E2B8CBA006E16ED96D38FAC", hash_generated_field = "FFD3E18FB59EA084D3FD8E8945E2AACA")

    private boolean isHashCodeCalculated;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.333 -0400", hash_original_field = "4D002D69417019F289C8061B82207DD2", hash_generated_field = "D4D90810E0E6D99534BB2E8797B7FFA9")

    private int hashCodeValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.333 -0400", hash_original_field = "A1B01E734B573FCA08EB1A65E6DF9A38", hash_generated_field = "ADD2EF6022A4B310B9B3CAE42CBA0F8A")

    private X500NameStyle style;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.333 -0400", hash_original_field = "CDDC180FA2C8DCC315071EA06C918937", hash_generated_field = "E6F265C5A2A75524751364DE8BEDA76F")

    private RDN[] rdns;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.334 -0400", hash_original_method = "A073765FBB48105361A5471731765C3D", hash_generated_method = "093B2FEDED0BC18154E34520F6C498C4")
    public  X500Name(X500NameStyle style, X500Name name) {
        this.rdns = name.rdns;
        this.style = style;
        // ---------- Original Method ----------
        //this.rdns = name.rdns;
        //this.style = style;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.334 -0400", hash_original_method = "90B05234255C50E94C255BAB8A26A1D2", hash_generated_method = "4DB22E6019187943E3BB415B7274E1D4")
    private  X500Name(
        ASN1Sequence  seq) {
        this(defaultStyle, seq);
        addTaint(seq.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.335 -0400", hash_original_method = "8A5D5B23394E3163B760506B172464EC", hash_generated_method = "1ADD0A41D24D5FA136503581204D2FE1")
    private  X500Name(
        X500NameStyle style,
        ASN1Sequence  seq) {
        this.style = style;
        this.rdns = new RDN[seq.size()];
        int index = 0;
for(Enumeration e = seq.getObjects();e.hasMoreElements();)
        {
            rdns[index++] = RDN.getInstance(e.nextElement());
        } //End block
        // ---------- Original Method ----------
        //this.style = style;
        //this.rdns = new RDN[seq.size()];
        //int index = 0;
        //for (Enumeration e = seq.getObjects(); e.hasMoreElements();)
        //{
            //rdns[index++] = RDN.getInstance(e.nextElement());
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.335 -0400", hash_original_method = "A1AF24A6A66F9AA8032E8762CECAE163", hash_generated_method = "69E2F80B6124FA423B7E6C6A1781254E")
    public  X500Name(
        RDN[] rDNs) {
        this(defaultStyle, rDNs);
        addTaint(rDNs[0].getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.336 -0400", hash_original_method = "DBB344B9E2C452B4F0EF3A22549C0276", hash_generated_method = "6BE0AEF6BEA980DE15D8648A58D50D5B")
    public  X500Name(
        X500NameStyle style,
        RDN[]         rDNs) {
        this.rdns = rDNs;
        this.style = style;
        // ---------- Original Method ----------
        //this.rdns = rDNs;
        //this.style = style;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.336 -0400", hash_original_method = "3F7EF5F2D5D32EA7D1792E59FB00B21E", hash_generated_method = "4D2AD5C19F9F366370E3DA365F2B86D0")
    public  X500Name(
        String dirName) {
        this(defaultStyle, dirName);
        addTaint(dirName.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.337 -0400", hash_original_method = "1876E348797BFE6D82540F4D5D4BC70E", hash_generated_method = "055B504C6120FB44555E494659EAA9A2")
    public  X500Name(
        X500NameStyle style,
        String        dirName) {
        this(style.fromString(dirName));
        addTaint(dirName.getTaint());
        this.style = style;
        // ---------- Original Method ----------
        //this.style = style;
    }

    
    @DSModeled(DSC.SAFE)
    public static X500Name getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        return getInstance(ASN1Sequence.getInstance(obj, true));
    }

    
    @DSModeled(DSC.SAFE)
    public static X500Name getInstance(
        Object  obj) {
        if (obj instanceof X500Name)
        {
            return (X500Name)obj;
        }
        else if (obj instanceof X509Name)
        {
            return new X500Name(ASN1Sequence.getInstance(((X509Name)obj).getDERObject()));
        }
        else if (obj != null)
        {
            return new X500Name(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.337 -0400", hash_original_method = "075988A0D732A4D3EE3D4A08C1D0111C", hash_generated_method = "E68A61EFF663EEDCCC8FA7DB9018F4DA")
    public RDN[] getRDNs() {
        RDN[] tmp = new RDN[this.rdns.length];
        System.arraycopy(rdns, 0, tmp, 0, tmp.length);
RDN[] var3F12A0424932F6B5155AA6C49B63FE6E_990329292 =         tmp;
        var3F12A0424932F6B5155AA6C49B63FE6E_990329292.addTaint(taint);
        return var3F12A0424932F6B5155AA6C49B63FE6E_990329292;
        // ---------- Original Method ----------
        //RDN[] tmp = new RDN[this.rdns.length];
        //System.arraycopy(rdns, 0, tmp, 0, tmp.length);
        //return tmp;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.338 -0400", hash_original_method = "58CE63756668BEA23514975180A77707", hash_generated_method = "6D0FA1CBB0388E52A534689048146445")
    public RDN[] getRDNs(ASN1ObjectIdentifier oid) {
        addTaint(oid.getTaint());
        RDN[] res = new RDN[rdns.length];
        int count = 0;
for(int i = 0;i != rdns.length;i++)
        {
            RDN rdn = rdns[i];
            if(rdn.isMultiValued())            
            {
                AttributeTypeAndValue[] attr = rdn.getTypesAndValues();
for(int j = 0;j != attr.length;j++)
                {
                    if(attr[j].getType().equals(oid))                    
                    {
                        res[count++] = rdn;
                        break;
                    } //End block
                } //End block
            } //End block
            else
            {
                if(rdn.getFirst().getType().equals(oid))                
                {
                    res[count++] = rdn;
                } //End block
            } //End block
        } //End block
        RDN[] tmp = new RDN[count];
        System.arraycopy(res, 0, tmp, 0, tmp.length);
RDN[] var3F12A0424932F6B5155AA6C49B63FE6E_1976529358 =         tmp;
        var3F12A0424932F6B5155AA6C49B63FE6E_1976529358.addTaint(taint);
        return var3F12A0424932F6B5155AA6C49B63FE6E_1976529358;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.339 -0400", hash_original_method = "F0EEE66F5B12B6A45E4A635050172EB9", hash_generated_method = "22C4E3F94B6067FAC8A12D5B56C96A9D")
    public DERObject toASN1Object() {
DERObject varC9775E03431426A026E62F2D736073FB_1479882083 =         new DERSequence(rdns);
        varC9775E03431426A026E62F2D736073FB_1479882083.addTaint(taint);
        return varC9775E03431426A026E62F2D736073FB_1479882083;
        // ---------- Original Method ----------
        //return new DERSequence(rdns);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.340 -0400", hash_original_method = "ECFD9A32E241F4FBD41987B44388CEAF", hash_generated_method = "EED187B5F64CADCA7D33FF4D4E1EA803")
    public int hashCode() {
        if(isHashCodeCalculated)        
        {
            int var4D002D69417019F289C8061B82207DD2_1313231421 = (hashCodeValue);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_523085224 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_523085224;
        } //End block
        isHashCodeCalculated = true;
        hashCodeValue = style.calculateHashCode(this);
        int var4D002D69417019F289C8061B82207DD2_664522159 = (hashCodeValue);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_334679126 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_334679126;
        // ---------- Original Method ----------
        //if (isHashCodeCalculated)
        //{
            //return hashCodeValue;
        //}
        //isHashCodeCalculated = true;
        //hashCodeValue = style.calculateHashCode(this);
        //return hashCodeValue;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.341 -0400", hash_original_method = "75F09C9D81AE7E21861BB145326A0585", hash_generated_method = "208F5B1D69E4D80A58E2AE040F9D79D1")
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
        if(obj == this)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_648272686 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1221088791 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1221088791;
        } //End block
        if(!(obj instanceof X500Name || obj instanceof ASN1Sequence))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1674046849 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1127586644 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1127586644;
        } //End block
        DERObject derO = ((DEREncodable)obj).getDERObject();
        if(this.getDERObject().equals(derO))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_442606710 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_926475788 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_926475788;
        } //End block
        try 
        {
            boolean var7F5984DD2F8FCC1B66FD236DC3257198_1386971391 = (style.areEqual(this, new X500Name(ASN1Sequence.getInstance(((DEREncodable)obj).getDERObject()))));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_833367121 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_833367121;
        } //End block
        catch (Exception e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1220951853 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1244392964 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1244392964;
        } //End block
        // ---------- Original Method ----------
        //if (obj == this)
        //{
            //return true;
        //}
        //if (!(obj instanceof X500Name || obj instanceof ASN1Sequence))
        //{
            //return false;
        //}
        //DERObject derO = ((DEREncodable)obj).getDERObject();
        //if (this.getDERObject().equals(derO))
        //{
            //return true;
        //}
        //try
        //{
            //return style.areEqual(this, new X500Name(ASN1Sequence.getInstance(((DEREncodable)obj).getDERObject())));
        //}
        //catch (Exception e)
        //{
            //return false;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.342 -0400", hash_original_method = "567E5D4F3D1A0F74E3A26BABA7FE2561", hash_generated_method = "9B4B1C06507E5D50EAABA1B781D3DD72")
    public String toString() {
String var5C06B59BC1D23B5BBA16F9412A6A7844_758939931 =         style.toString(this);
        var5C06B59BC1D23B5BBA16F9412A6A7844_758939931.addTaint(taint);
        return var5C06B59BC1D23B5BBA16F9412A6A7844_758939931;
        // ---------- Original Method ----------
        //return style.toString(this);
    }

    
    @DSModeled(DSC.SAFE)
    public static void setDefaultStyle(X500NameStyle style) {
        if (style == null)
        {
            throw new NullPointerException("cannot set style to null");
        }
        defaultStyle = style;
    }

    
    @DSModeled(DSC.SAFE)
    public static X500NameStyle getDefaultStyle() {
        return defaultStyle;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.342 -0400", hash_original_field = "EE9E3E68915122912754B36D50B6CA63", hash_generated_field = "0022D6097CD2C8C1CB15974BBD83B021")

    private static X500NameStyle defaultStyle = BCStyle.INSTANCE;
}

