package org.bouncycastle.asn1.x500;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.687 -0400", hash_original_field = "DE525AA08E2B8CBA006E16ED96D38FAC", hash_generated_field = "FFD3E18FB59EA084D3FD8E8945E2AACA")

    private boolean isHashCodeCalculated;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.687 -0400", hash_original_field = "4D002D69417019F289C8061B82207DD2", hash_generated_field = "D4D90810E0E6D99534BB2E8797B7FFA9")

    private int hashCodeValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.687 -0400", hash_original_field = "A1B01E734B573FCA08EB1A65E6DF9A38", hash_generated_field = "ADD2EF6022A4B310B9B3CAE42CBA0F8A")

    private X500NameStyle style;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.687 -0400", hash_original_field = "CDDC180FA2C8DCC315071EA06C918937", hash_generated_field = "E6F265C5A2A75524751364DE8BEDA76F")

    private RDN[] rdns;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.698 -0400", hash_original_method = "A073765FBB48105361A5471731765C3D", hash_generated_method = "093B2FEDED0BC18154E34520F6C498C4")
    public  X500Name(X500NameStyle style, X500Name name) {
        this.rdns = name.rdns;
        this.style = style;
        // ---------- Original Method ----------
        //this.rdns = name.rdns;
        //this.style = style;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.698 -0400", hash_original_method = "90B05234255C50E94C255BAB8A26A1D2", hash_generated_method = "4DB22E6019187943E3BB415B7274E1D4")
    private  X500Name(
        ASN1Sequence  seq) {
        this(defaultStyle, seq);
        addTaint(seq.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.699 -0400", hash_original_method = "8A5D5B23394E3163B760506B172464EC", hash_generated_method = "94DAF8CC35FBAD1BBC14D893F9C97404")
    private  X500Name(
        X500NameStyle style,
        ASN1Sequence  seq) {
        this.style = style;
        this.rdns = new RDN[seq.size()];
        int index;
        index = 0;
        {
            Enumeration e;
            e = seq.getObjects();
            boolean var3EB0A96682EDBE15308427BAC1EC4A4E_1579284617 = (e.hasMoreElements());
            {
                rdns[index++] = RDN.getInstance(e.nextElement());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //this.style = style;
        //this.rdns = new RDN[seq.size()];
        //int index = 0;
        //for (Enumeration e = seq.getObjects(); e.hasMoreElements();)
        //{
            //rdns[index++] = RDN.getInstance(e.nextElement());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.700 -0400", hash_original_method = "A1AF24A6A66F9AA8032E8762CECAE163", hash_generated_method = "69E2F80B6124FA423B7E6C6A1781254E")
    public  X500Name(
        RDN[] rDNs) {
        this(defaultStyle, rDNs);
        addTaint(rDNs[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.700 -0400", hash_original_method = "DBB344B9E2C452B4F0EF3A22549C0276", hash_generated_method = "6BE0AEF6BEA980DE15D8648A58D50D5B")
    public  X500Name(
        X500NameStyle style,
        RDN[]         rDNs) {
        this.rdns = rDNs;
        this.style = style;
        // ---------- Original Method ----------
        //this.rdns = rDNs;
        //this.style = style;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.701 -0400", hash_original_method = "3F7EF5F2D5D32EA7D1792E59FB00B21E", hash_generated_method = "4D2AD5C19F9F366370E3DA365F2B86D0")
    public  X500Name(
        String dirName) {
        this(defaultStyle, dirName);
        addTaint(dirName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.701 -0400", hash_original_method = "1876E348797BFE6D82540F4D5D4BC70E", hash_generated_method = "943F6FF12406CCB3C2C65461C7C29196")
    public  X500Name(
        X500NameStyle style,
        String        dirName) {
        this(style.fromString(dirName));
        this.style = style;
        addTaint(dirName.getTaint());
        // ---------- Original Method ----------
        //this.style = style;
    }

    
        public static X500Name getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        return getInstance(ASN1Sequence.getInstance(obj, true));
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.707 -0400", hash_original_method = "075988A0D732A4D3EE3D4A08C1D0111C", hash_generated_method = "01611D44A2A1AFC27CB9EEAA4201ADD4")
    public RDN[] getRDNs() {
        RDN[] varB4EAC82CA7396A68D541C85D26508E83_1001418257 = null; //Variable for return #1
        RDN[] tmp;
        tmp = new RDN[this.rdns.length];
        System.arraycopy(rdns, 0, tmp, 0, tmp.length);
        varB4EAC82CA7396A68D541C85D26508E83_1001418257 = tmp;
        varB4EAC82CA7396A68D541C85D26508E83_1001418257.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1001418257;
        // ---------- Original Method ----------
        //RDN[] tmp = new RDN[this.rdns.length];
        //System.arraycopy(rdns, 0, tmp, 0, tmp.length);
        //return tmp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.716 -0400", hash_original_method = "58CE63756668BEA23514975180A77707", hash_generated_method = "E496164C94BE30D156EEB06EA21B416B")
    public RDN[] getRDNs(ASN1ObjectIdentifier oid) {
        RDN[] varB4EAC82CA7396A68D541C85D26508E83_151229206 = null; //Variable for return #1
        RDN[] res;
        res = new RDN[rdns.length];
        int count;
        count = 0;
        {
            int i;
            i = 0;
            {
                RDN rdn;
                rdn = rdns[i];
                {
                    boolean var324791A7653661E2385ECA08978799A1_215961948 = (rdn.isMultiValued());
                    {
                        AttributeTypeAndValue[] attr;
                        attr = rdn.getTypesAndValues();
                        {
                            int j;
                            j = 0;
                            {
                                {
                                    boolean var30920379F084E110ECB4D395D55D8488_439857042 = (attr[j].getType().equals(oid));
                                    {
                                        res[count++] = rdn;
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        {
                            boolean varB832FCD64633BCFB4C20747F413D94DE_2109821743 = (rdn.getFirst().getType().equals(oid));
                            {
                                res[count++] = rdn;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        RDN[] tmp;
        tmp = new RDN[count];
        System.arraycopy(res, 0, tmp, 0, tmp.length);
        varB4EAC82CA7396A68D541C85D26508E83_151229206 = tmp;
        addTaint(oid.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_151229206.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_151229206;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.716 -0400", hash_original_method = "F0EEE66F5B12B6A45E4A635050172EB9", hash_generated_method = "EA69CFB6FA57B7A293CFC413B98C6566")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1045899190 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1045899190 = new DERSequence(rdns);
        varB4EAC82CA7396A68D541C85D26508E83_1045899190.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1045899190;
        // ---------- Original Method ----------
        //return new DERSequence(rdns);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.717 -0400", hash_original_method = "ECFD9A32E241F4FBD41987B44388CEAF", hash_generated_method = "26D347D60D9F72B30E254B6323E8B2D2")
    public int hashCode() {
        isHashCodeCalculated = true;
        hashCodeValue = style.calculateHashCode(this);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_638492675 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_638492675;
        // ---------- Original Method ----------
        //if (isHashCodeCalculated)
        //{
            //return hashCodeValue;
        //}
        //isHashCodeCalculated = true;
        //hashCodeValue = style.calculateHashCode(this);
        //return hashCodeValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.729 -0400", hash_original_method = "75F09C9D81AE7E21861BB145326A0585", hash_generated_method = "59121C39989BB3C9051B4455837C5FC6")
    public boolean equals(Object obj) {
        {
            boolean var8D1D3E5F4C020ED4FA594AED365B4BD8_1136187395 = (obj == this);
        } //End collapsed parenthetic
        DERObject derO;
        derO = ((DEREncodable)obj).getDERObject();
        {
            boolean var68F84D0793BBFC5B2D2B404A60842FDE_298269106 = (this.getDERObject().equals(derO));
        } //End collapsed parenthetic
        try 
        {
            boolean var23B33C9C999A096729C223C2A0CAF2C5_1901594094 = (style.areEqual(this, new X500Name(ASN1Sequence.getInstance(((DEREncodable)obj).getDERObject()))));
        } //End block
        catch (Exception e)
        { }
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1961921083 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1961921083;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.730 -0400", hash_original_method = "567E5D4F3D1A0F74E3A26BABA7FE2561", hash_generated_method = "CD67B2C23B43A674BDE86474E80EE68F")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1008210329 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1008210329 = style.toString(this);
        varB4EAC82CA7396A68D541C85D26508E83_1008210329.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1008210329;
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

    
        public static X500NameStyle getDefaultStyle() {
        return defaultStyle;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.730 -0400", hash_original_field = "EE9E3E68915122912754B36D50B6CA63", hash_generated_field = "0022D6097CD2C8C1CB15974BBD83B021")

    private static X500NameStyle defaultStyle = BCStyle.INSTANCE;
}

