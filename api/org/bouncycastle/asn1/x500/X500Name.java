package org.bouncycastle.asn1.x500;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.712 -0400", hash_original_field = "DE525AA08E2B8CBA006E16ED96D38FAC", hash_generated_field = "FFD3E18FB59EA084D3FD8E8945E2AACA")

    private boolean isHashCodeCalculated;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.713 -0400", hash_original_field = "4D002D69417019F289C8061B82207DD2", hash_generated_field = "D4D90810E0E6D99534BB2E8797B7FFA9")

    private int hashCodeValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.713 -0400", hash_original_field = "A1B01E734B573FCA08EB1A65E6DF9A38", hash_generated_field = "ADD2EF6022A4B310B9B3CAE42CBA0F8A")

    private X500NameStyle style;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.713 -0400", hash_original_field = "CDDC180FA2C8DCC315071EA06C918937", hash_generated_field = "E6F265C5A2A75524751364DE8BEDA76F")

    private RDN[] rdns;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.714 -0400", hash_original_method = "A073765FBB48105361A5471731765C3D", hash_generated_method = "093B2FEDED0BC18154E34520F6C498C4")
    public  X500Name(X500NameStyle style, X500Name name) {
        this.rdns = name.rdns;
        this.style = style;
        // ---------- Original Method ----------
        //this.rdns = name.rdns;
        //this.style = style;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.714 -0400", hash_original_method = "90B05234255C50E94C255BAB8A26A1D2", hash_generated_method = "4DB22E6019187943E3BB415B7274E1D4")
    private  X500Name(
        ASN1Sequence  seq) {
        this(defaultStyle, seq);
        addTaint(seq.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.715 -0400", hash_original_method = "8A5D5B23394E3163B760506B172464EC", hash_generated_method = "1ADD0A41D24D5FA136503581204D2FE1")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.716 -0400", hash_original_method = "A1AF24A6A66F9AA8032E8762CECAE163", hash_generated_method = "69E2F80B6124FA423B7E6C6A1781254E")
    public  X500Name(
        RDN[] rDNs) {
        this(defaultStyle, rDNs);
        addTaint(rDNs[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.716 -0400", hash_original_method = "DBB344B9E2C452B4F0EF3A22549C0276", hash_generated_method = "6BE0AEF6BEA980DE15D8648A58D50D5B")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.716 -0400", hash_original_method = "3F7EF5F2D5D32EA7D1792E59FB00B21E", hash_generated_method = "4D2AD5C19F9F366370E3DA365F2B86D0")
    public  X500Name(
        String dirName) {
        this(defaultStyle, dirName);
        addTaint(dirName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.717 -0400", hash_original_method = "1876E348797BFE6D82540F4D5D4BC70E", hash_generated_method = "055B504C6120FB44555E494659EAA9A2")
    public  X500Name(
        X500NameStyle style,
        String        dirName) {
        this(style.fromString(dirName));
        addTaint(dirName.getTaint());
        this.style = style;
        // ---------- Original Method ----------
        //this.style = style;
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.718 -0400", hash_original_method = "075988A0D732A4D3EE3D4A08C1D0111C", hash_generated_method = "BFBF067ECF8193E24A0C511E5A72D523")
    public RDN[] getRDNs() {
        RDN[] tmp = new RDN[this.rdns.length];
        System.arraycopy(rdns, 0, tmp, 0, tmp.length);
RDN[] var3F12A0424932F6B5155AA6C49B63FE6E_1137994310 =         tmp;
        var3F12A0424932F6B5155AA6C49B63FE6E_1137994310.addTaint(taint);
        return var3F12A0424932F6B5155AA6C49B63FE6E_1137994310;
        // ---------- Original Method ----------
        //RDN[] tmp = new RDN[this.rdns.length];
        //System.arraycopy(rdns, 0, tmp, 0, tmp.length);
        //return tmp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.730 -0400", hash_original_method = "58CE63756668BEA23514975180A77707", hash_generated_method = "B553333EC1FAC46EF14A17DCD79B168F")
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
RDN[] var3F12A0424932F6B5155AA6C49B63FE6E_1123839864 =         tmp;
        var3F12A0424932F6B5155AA6C49B63FE6E_1123839864.addTaint(taint);
        return var3F12A0424932F6B5155AA6C49B63FE6E_1123839864;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.731 -0400", hash_original_method = "F0EEE66F5B12B6A45E4A635050172EB9", hash_generated_method = "FD8A11F5A990123A56C5C1D98D387866")
    public DERObject toASN1Object() {
DERObject varC9775E03431426A026E62F2D736073FB_1531193550 =         new DERSequence(rdns);
        varC9775E03431426A026E62F2D736073FB_1531193550.addTaint(taint);
        return varC9775E03431426A026E62F2D736073FB_1531193550;
        // ---------- Original Method ----------
        //return new DERSequence(rdns);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.731 -0400", hash_original_method = "ECFD9A32E241F4FBD41987B44388CEAF", hash_generated_method = "E1448229CFB96868EF59EF11390899FB")
    public int hashCode() {
    if(isHashCodeCalculated)        
        {
            int var4D002D69417019F289C8061B82207DD2_303956965 = (hashCodeValue);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1012473123 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1012473123;
        } //End block
        isHashCodeCalculated = true;
        hashCodeValue = style.calculateHashCode(this);
        int var4D002D69417019F289C8061B82207DD2_1383544502 = (hashCodeValue);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_410688707 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_410688707;
        // ---------- Original Method ----------
        //if (isHashCodeCalculated)
        //{
            //return hashCodeValue;
        //}
        //isHashCodeCalculated = true;
        //hashCodeValue = style.calculateHashCode(this);
        //return hashCodeValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.731 -0400", hash_original_method = "75F09C9D81AE7E21861BB145326A0585", hash_generated_method = "1FC555E53648767B12052580407E44DC")
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
    if(obj == this)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_647986282 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1849596163 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1849596163;
        } //End block
    if(!(obj instanceof X500Name || obj instanceof ASN1Sequence))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1394216918 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1448085834 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1448085834;
        } //End block
        DERObject derO = ((DEREncodable)obj).getDERObject();
    if(this.getDERObject().equals(derO))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1261781127 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_55143610 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_55143610;
        } //End block
        try 
        {
            boolean var7F5984DD2F8FCC1B66FD236DC3257198_504047385 = (style.areEqual(this, new X500Name(ASN1Sequence.getInstance(((DEREncodable)obj).getDERObject()))));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_942441439 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_942441439;
        } //End block
        catch (Exception e)
        {
            boolean var68934A3E9455FA72420237EB05902327_700407708 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_524349420 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_524349420;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.731 -0400", hash_original_method = "567E5D4F3D1A0F74E3A26BABA7FE2561", hash_generated_method = "C4E815B9C8431B6BEFADAE17100C64C9")
    public String toString() {
String var5C06B59BC1D23B5BBA16F9412A6A7844_1588339791 =         style.toString(this);
        var5C06B59BC1D23B5BBA16F9412A6A7844_1588339791.addTaint(taint);
        return var5C06B59BC1D23B5BBA16F9412A6A7844_1588339791;
        // ---------- Original Method ----------
        //return style.toString(this);
    }

    
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:39.732 -0400", hash_original_field = "EE9E3E68915122912754B36D50B6CA63", hash_generated_field = "0022D6097CD2C8C1CB15974BBD83B021")

    private static X500NameStyle defaultStyle = BCStyle.INSTANCE;
}

