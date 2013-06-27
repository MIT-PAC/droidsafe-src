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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.756 -0400", hash_original_field = "DE525AA08E2B8CBA006E16ED96D38FAC", hash_generated_field = "FFD3E18FB59EA084D3FD8E8945E2AACA")

    private boolean isHashCodeCalculated;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.756 -0400", hash_original_field = "4D002D69417019F289C8061B82207DD2", hash_generated_field = "D4D90810E0E6D99534BB2E8797B7FFA9")

    private int hashCodeValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.756 -0400", hash_original_field = "A1B01E734B573FCA08EB1A65E6DF9A38", hash_generated_field = "ADD2EF6022A4B310B9B3CAE42CBA0F8A")

    private X500NameStyle style;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.756 -0400", hash_original_field = "CDDC180FA2C8DCC315071EA06C918937", hash_generated_field = "E6F265C5A2A75524751364DE8BEDA76F")

    private RDN[] rdns;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.758 -0400", hash_original_method = "A073765FBB48105361A5471731765C3D", hash_generated_method = "093B2FEDED0BC18154E34520F6C498C4")
    public  X500Name(X500NameStyle style, X500Name name) {
        this.rdns = name.rdns;
        this.style = style;
        // ---------- Original Method ----------
        //this.rdns = name.rdns;
        //this.style = style;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.765 -0400", hash_original_method = "90B05234255C50E94C255BAB8A26A1D2", hash_generated_method = "4DB22E6019187943E3BB415B7274E1D4")
    private  X500Name(
        ASN1Sequence  seq) {
        this(defaultStyle, seq);
        addTaint(seq.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.765 -0400", hash_original_method = "8A5D5B23394E3163B760506B172464EC", hash_generated_method = "7DF1D3A91C9CF6C1E89AD27E81C18C5E")
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
            boolean var3EB0A96682EDBE15308427BAC1EC4A4E_1269712983 = (e.hasMoreElements());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.765 -0400", hash_original_method = "A1AF24A6A66F9AA8032E8762CECAE163", hash_generated_method = "69E2F80B6124FA423B7E6C6A1781254E")
    public  X500Name(
        RDN[] rDNs) {
        this(defaultStyle, rDNs);
        addTaint(rDNs[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.766 -0400", hash_original_method = "DBB344B9E2C452B4F0EF3A22549C0276", hash_generated_method = "6BE0AEF6BEA980DE15D8648A58D50D5B")
    public  X500Name(
        X500NameStyle style,
        RDN[]         rDNs) {
        this.rdns = rDNs;
        this.style = style;
        // ---------- Original Method ----------
        //this.rdns = rDNs;
        //this.style = style;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.766 -0400", hash_original_method = "3F7EF5F2D5D32EA7D1792E59FB00B21E", hash_generated_method = "4D2AD5C19F9F366370E3DA365F2B86D0")
    public  X500Name(
        String dirName) {
        this(defaultStyle, dirName);
        addTaint(dirName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.766 -0400", hash_original_method = "1876E348797BFE6D82540F4D5D4BC70E", hash_generated_method = "943F6FF12406CCB3C2C65461C7C29196")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.774 -0400", hash_original_method = "075988A0D732A4D3EE3D4A08C1D0111C", hash_generated_method = "D08C52A282B47B84311CC89DC3B0B3D0")
    public RDN[] getRDNs() {
        RDN[] varB4EAC82CA7396A68D541C85D26508E83_738384455 = null; //Variable for return #1
        RDN[] tmp;
        tmp = new RDN[this.rdns.length];
        System.arraycopy(rdns, 0, tmp, 0, tmp.length);
        varB4EAC82CA7396A68D541C85D26508E83_738384455 = tmp;
        varB4EAC82CA7396A68D541C85D26508E83_738384455.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_738384455;
        // ---------- Original Method ----------
        //RDN[] tmp = new RDN[this.rdns.length];
        //System.arraycopy(rdns, 0, tmp, 0, tmp.length);
        //return tmp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.779 -0400", hash_original_method = "58CE63756668BEA23514975180A77707", hash_generated_method = "F62F9F6B5C064AD2F3F0A68A7875C8BD")
    public RDN[] getRDNs(ASN1ObjectIdentifier oid) {
        RDN[] varB4EAC82CA7396A68D541C85D26508E83_1050512672 = null; //Variable for return #1
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
                    boolean var324791A7653661E2385ECA08978799A1_1726835251 = (rdn.isMultiValued());
                    {
                        AttributeTypeAndValue[] attr;
                        attr = rdn.getTypesAndValues();
                        {
                            int j;
                            j = 0;
                            {
                                {
                                    boolean var30920379F084E110ECB4D395D55D8488_2113978051 = (attr[j].getType().equals(oid));
                                    {
                                        res[count++] = rdn;
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        {
                            boolean varB832FCD64633BCFB4C20747F413D94DE_592371013 = (rdn.getFirst().getType().equals(oid));
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
        varB4EAC82CA7396A68D541C85D26508E83_1050512672 = tmp;
        addTaint(oid.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1050512672.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1050512672;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.780 -0400", hash_original_method = "F0EEE66F5B12B6A45E4A635050172EB9", hash_generated_method = "09092F741CA819833B51D83F222C2D92")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1021189244 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1021189244 = new DERSequence(rdns);
        varB4EAC82CA7396A68D541C85D26508E83_1021189244.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1021189244;
        // ---------- Original Method ----------
        //return new DERSequence(rdns);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.781 -0400", hash_original_method = "ECFD9A32E241F4FBD41987B44388CEAF", hash_generated_method = "AE5796F660FD3B2AAAF377045EE5EDAE")
    public int hashCode() {
        isHashCodeCalculated = true;
        hashCodeValue = style.calculateHashCode(this);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1190363789 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1190363789;
        // ---------- Original Method ----------
        //if (isHashCodeCalculated)
        //{
            //return hashCodeValue;
        //}
        //isHashCodeCalculated = true;
        //hashCodeValue = style.calculateHashCode(this);
        //return hashCodeValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.781 -0400", hash_original_method = "75F09C9D81AE7E21861BB145326A0585", hash_generated_method = "94F6D2E5D2E357942995672F2F0C8EEC")
    public boolean equals(Object obj) {
        {
            boolean var8D1D3E5F4C020ED4FA594AED365B4BD8_350265433 = (obj == this);
        } //End collapsed parenthetic
        DERObject derO;
        derO = ((DEREncodable)obj).getDERObject();
        {
            boolean var68F84D0793BBFC5B2D2B404A60842FDE_1002936380 = (this.getDERObject().equals(derO));
        } //End collapsed parenthetic
        try 
        {
            boolean var23B33C9C999A096729C223C2A0CAF2C5_1260834791 = (style.areEqual(this, new X500Name(ASN1Sequence.getInstance(((DEREncodable)obj).getDERObject()))));
        } //End block
        catch (Exception e)
        { }
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1859932309 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1859932309;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.789 -0400", hash_original_method = "567E5D4F3D1A0F74E3A26BABA7FE2561", hash_generated_method = "B504BC75E45C92C24E63A65FED0610D6")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_426536187 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_426536187 = style.toString(this);
        varB4EAC82CA7396A68D541C85D26508E83_426536187.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_426536187;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.789 -0400", hash_original_field = "EE9E3E68915122912754B36D50B6CA63", hash_generated_field = "0022D6097CD2C8C1CB15974BBD83B021")

    private static X500NameStyle defaultStyle = BCStyle.INSTANCE;
}

