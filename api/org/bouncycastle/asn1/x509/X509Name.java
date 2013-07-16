package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.DERString;
import org.bouncycastle.asn1.DERUniversalString;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

public class X509Name extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.541 -0400", hash_original_field = "A34048331D21536E4DEEECC5E8A1DED5", hash_generated_field = "9B1A952CEBF3178959A402DABEDC0A6B")

    private X509NameEntryConverter converter = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.541 -0400", hash_original_field = "1E8C32F4C6EEE7D3CD7F8426CD048BA3", hash_generated_field = "C8A65116741473EAA58816E75213B0AF")

    private Vector ordering = new Vector();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.541 -0400", hash_original_field = "7BCFB62748A3418E1EB532A92A7C5C78", hash_generated_field = "F7859DDEE63780863860095D2E4D0AB7")

    private Vector values = new Vector();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.541 -0400", hash_original_field = "ADFA51CFEE10A2F9F8E091B21ABE19E2", hash_generated_field = "93EE51D59E70850C8E38EBF0508102EE")

    private Vector added = new Vector();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.541 -0400", hash_original_field = "E068C2DE26D760F20CF10AFC4B87EF0F", hash_generated_field = "37E06257AFCE21CC4EDFE67F34DC271C")

    private ASN1Sequence seq;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.541 -0400", hash_original_field = "DE525AA08E2B8CBA006E16ED96D38FAC", hash_generated_field = "FFD3E18FB59EA084D3FD8E8945E2AACA")

    private boolean isHashCodeCalculated;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.541 -0400", hash_original_field = "4D002D69417019F289C8061B82207DD2", hash_generated_field = "D4D90810E0E6D99534BB2E8797B7FFA9")

    private int hashCodeValue;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.541 -0400", hash_original_method = "E0A402814C87C5337199B2B0EDD62792", hash_generated_method = "057550D58678CB656F886F7D19F48820")
    protected  X509Name() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.542 -0400", hash_original_method = "88A842BBAF40DA82D57137327D6884BA", hash_generated_method = "BE9A59C9EA5D8A9C68DDF5AB07FDC37C")
    public  X509Name(
        ASN1Sequence  seq) {
        this.seq = seq;
        Enumeration e = seq.getObjects();
        while
(e.hasMoreElements())        
        {
            ASN1Set set = ASN1Set.getInstance(((DEREncodable)e.nextElement()).getDERObject());
for(int i = 0;i < set.size();i++)
            {
                ASN1Sequence s = ASN1Sequence.getInstance(set.getObjectAt(i));
    if(s.size() != 2)                
                {
                    IllegalArgumentException var8225E7D760902CE5C3E99FCCFDE6CA09_773004755 = new IllegalArgumentException("badly sized pair");
                    var8225E7D760902CE5C3E99FCCFDE6CA09_773004755.addTaint(taint);
                    throw var8225E7D760902CE5C3E99FCCFDE6CA09_773004755;
                } //End block
                ordering.addElement(DERObjectIdentifier.getInstance(s.getObjectAt(0)));
                DEREncodable value = s.getObjectAt(1);
    if(value instanceof DERString && !(value instanceof DERUniversalString))                
                {
                    String v = ((DERString)value).getString();
    if(v.length() > 0 && v.charAt(0) == '#')                    
                    {
                        values.addElement("\\" + v);
                    } //End block
                    else
                    {
                        values.addElement(v);
                    } //End block
                } //End block
                else
                {
                    values.addElement("#" + bytesToString(Hex.encode(value.getDERObject().getDEREncoded())));
                } //End block
                added.addElement(Boolean.valueOf(i != 0));
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.542 -0400", hash_original_method = "E338E099196C520643EABA462B148868", hash_generated_method = "4F3D38547E82E9E318C39F8B7A6E3207")
    public  X509Name(
        Hashtable  attributes) {
        this(null, attributes);
        addTaint(attributes.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.543 -0400", hash_original_method = "0E56A2506DE147DC0FDCD121F4661515", hash_generated_method = "A49EF6B0C5B62CA69F33510749DE931F")
    public  X509Name(
        Vector      ordering,
        Hashtable   attributes) {
        this(ordering, attributes, new X509DefaultEntryConverter());
        addTaint(attributes.getTaint());
        addTaint(ordering.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.544 -0400", hash_original_method = "391D1DCB58738C4647988CF64EC70334", hash_generated_method = "5DFA82F8F52F6ECD9EF61688F3564783")
    public  X509Name(
        Vector                   ordering,
        Hashtable                attributes,
        X509NameEntryConverter   converter) {
        addTaint(attributes.getTaint());
        addTaint(ordering.getTaint());
        this.converter = converter;
    if(ordering != null)        
        {
for(int i = 0;i != ordering.size();i++)
            {
                this.ordering.addElement(ordering.elementAt(i));
                this.added.addElement(FALSE);
            } //End block
        } //End block
        else
        {
            Enumeration e = attributes.keys();
            while
(e.hasMoreElements())            
            {
                this.ordering.addElement(e.nextElement());
                this.added.addElement(FALSE);
            } //End block
        } //End block
for(int i = 0;i != this.ordering.size();i++)
        {
            DERObjectIdentifier oid = (DERObjectIdentifier)this.ordering.elementAt(i);
    if(attributes.get(oid) == null)            
            {
                IllegalArgumentException var395EF524058B951BA48FFDB657C8D23C_634208704 = new IllegalArgumentException("No attribute for object id - " + oid.getId() + " - passed to distinguished name");
                var395EF524058B951BA48FFDB657C8D23C_634208704.addTaint(taint);
                throw var395EF524058B951BA48FFDB657C8D23C_634208704;
            } //End block
            this.values.addElement(attributes.get(oid));
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.544 -0400", hash_original_method = "09339315E74F09704223BAA476796553", hash_generated_method = "0F41C1E3C1E5E881D2C0FD837D91BC14")
    public  X509Name(
        Vector  oids,
        Vector  values) {
        this(oids, values, new X509DefaultEntryConverter());
        addTaint(values.getTaint());
        addTaint(oids.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.545 -0400", hash_original_method = "492C8BC9ACE864159B4ED5D85649FE7D", hash_generated_method = "437276E6F5ACA00F0D3FE027F5AFE237")
    public  X509Name(
        Vector                  oids,
        Vector                  values,
        X509NameEntryConverter  converter) {
        addTaint(values.getTaint());
        addTaint(oids.getTaint());
        this.converter = converter;
    if(oids.size() != values.size())        
        {
            IllegalArgumentException var8B9F22F4CB47AB28A0E3D6B76D1B1D06_548635471 = new IllegalArgumentException("oids vector must be same length as values.");
            var8B9F22F4CB47AB28A0E3D6B76D1B1D06_548635471.addTaint(taint);
            throw var8B9F22F4CB47AB28A0E3D6B76D1B1D06_548635471;
        } //End block
for(int i = 0;i < oids.size();i++)
        {
            this.ordering.addElement(oids.elementAt(i));
            this.values.addElement(values.elementAt(i));
            this.added.addElement(FALSE);
        } //End block
        // ---------- Original Method ----------
        //this.converter = converter;
        //if (oids.size() != values.size())
        //{
            //throw new IllegalArgumentException("oids vector must be same length as values.");
        //}
        //for (int i = 0; i < oids.size(); i++)
        //{
            //this.ordering.addElement(oids.elementAt(i));
            //this.values.addElement(values.elementAt(i));
            //this.added.addElement(FALSE);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.545 -0400", hash_original_method = "4DE51E849F59B0AA80C7ECB38F0D9925", hash_generated_method = "3DC3E88039FCBFD7D79B0174FAD45B0F")
    public  X509Name(
        String  dirName) {
        this(DefaultReverse, DefaultLookUp, dirName);
        addTaint(dirName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.545 -0400", hash_original_method = "225E7940DFC3CDF11421E5A31C692555", hash_generated_method = "A024263123D4A3F4C04E171635CEFE11")
    public  X509Name(
        String                  dirName,
        X509NameEntryConverter  converter) {
        this(DefaultReverse, DefaultLookUp, dirName, converter);
        addTaint(converter.getTaint());
        addTaint(dirName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.546 -0400", hash_original_method = "A1386F925B8F997747CFC9FBEC64818C", hash_generated_method = "3E05FD368AB3F462CC34AD8AA65CF293")
    public  X509Name(
        boolean reverse,
        String  dirName) {
        this(reverse, DefaultLookUp, dirName);
        addTaint(dirName.getTaint());
        addTaint(reverse);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.546 -0400", hash_original_method = "0ED99673E1BB44384871E74A0AAAAEE6", hash_generated_method = "6D8DC8B4F730D61439367E6EA1D209AB")
    public  X509Name(
        boolean                 reverse,
        String                  dirName,
        X509NameEntryConverter  converter) {
        this(reverse, DefaultLookUp, dirName, converter);
        addTaint(converter.getTaint());
        addTaint(dirName.getTaint());
        addTaint(reverse);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.546 -0400", hash_original_method = "AD0C5D6A617F7C4CAD4929B6BAF77A7F", hash_generated_method = "2E465D7394BE3FD3FEFE3A3D438D8658")
    public  X509Name(
        boolean     reverse,
        Hashtable   lookUp,
        String      dirName) {
        this(reverse, lookUp, dirName, new X509DefaultEntryConverter());
        addTaint(dirName.getTaint());
        addTaint(lookUp.getTaint());
        addTaint(reverse);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.547 -0400", hash_original_method = "E0536EE704C9789715788F9D659749FC", hash_generated_method = "2596761C8F58DD37F2972C2B01A8576E")
    public  X509Name(
        boolean                 reverse,
        Hashtable               lookUp,
        String                  dirName,
        X509NameEntryConverter  converter) {
        addTaint(dirName.getTaint());
        addTaint(lookUp.getTaint());
        addTaint(reverse);
        this.converter = converter;
        X509NameTokenizer nTok = new X509NameTokenizer(dirName);
        while
(nTok.hasMoreTokens())        
        {
            String token = nTok.nextToken();
            int index = token.indexOf('=');
    if(index == -1)            
            {
                IllegalArgumentException var0F4662F40FB0E6B066ACA52697955804_728798144 = new IllegalArgumentException("badly formatted directory string");
                var0F4662F40FB0E6B066ACA52697955804_728798144.addTaint(taint);
                throw var0F4662F40FB0E6B066ACA52697955804_728798144;
            } //End block
            String name = token.substring(0, index);
            String value = token.substring(index + 1);
            DERObjectIdentifier oid = decodeOID(name, lookUp);
    if(value.indexOf('+') > 0)            
            {
                X509NameTokenizer vTok = new X509NameTokenizer(value, '+');
                String v = vTok.nextToken();
                this.ordering.addElement(oid);
                this.values.addElement(v);
                this.added.addElement(FALSE);
                while
(vTok.hasMoreTokens())                
                {
                    String sv = vTok.nextToken();
                    int ndx = sv.indexOf('=');
                    String nm = sv.substring(0, ndx);
                    String vl = sv.substring(ndx + 1);
                    this.ordering.addElement(decodeOID(nm, lookUp));
                    this.values.addElement(vl);
                    this.added.addElement(TRUE);
                } //End block
            } //End block
            else
            {
                this.ordering.addElement(oid);
                this.values.addElement(value);
                this.added.addElement(FALSE);
            } //End block
        } //End block
    if(reverse)        
        {
            Vector o = new Vector();
            Vector v = new Vector();
            Vector a = new Vector();
            int count = 1;
for(int i = 0;i < this.ordering.size();i++)
            {
    if(((Boolean)this.added.elementAt(i)).booleanValue())                
                {
                    o.insertElementAt(this.ordering.elementAt(i), count);
                    v.insertElementAt(this.values.elementAt(i), count);
                    a.insertElementAt(this.added.elementAt(i), count);
                    count++;
                } //End block
                else
                {
                    o.insertElementAt(this.ordering.elementAt(i), 0);
                    v.insertElementAt(this.values.elementAt(i), 0);
                    a.insertElementAt(this.added.elementAt(i), 0);
                    count = 1;
                } //End block
            } //End block
            this.ordering = o;
            this.values = v;
            this.added = a;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        public static X509Name getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }

    
        @DSModeled(DSC.SAFE)
    public static X509Name getInstance(
        Object  obj) {
        if (obj == null || obj instanceof X509Name)
        {
            return (X509Name)obj;
        }
        else if (obj instanceof X500Name)
        {
            return new X509Name(ASN1Sequence.getInstance(((X500Name)obj).getDERObject()));
        }
        else if (obj != null)
        {
            return new X509Name(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.549 -0400", hash_original_method = "964F6D63AF200DB73DB551657282148F", hash_generated_method = "29C7DAA51AB4C9640A5DC464276002AB")
    private DERObjectIdentifier decodeOID(
        String      name,
        Hashtable   lookUp) {
        addTaint(lookUp.getTaint());
        addTaint(name.getTaint());
    if(Strings.toUpperCase(name).startsWith("OID."))        
        {
DERObjectIdentifier varD445AEFB1A26516FDA5584BF11DCB649_2042788301 =             new DERObjectIdentifier(name.substring(4));
            varD445AEFB1A26516FDA5584BF11DCB649_2042788301.addTaint(taint);
            return varD445AEFB1A26516FDA5584BF11DCB649_2042788301;
        } //End block
        else
    if(name.charAt(0) >= '0' && name.charAt(0) <= '9')        
        {
DERObjectIdentifier varDB076E8F3C9AA5817E9BAB61D656C690_92891868 =             new DERObjectIdentifier(name);
            varDB076E8F3C9AA5817E9BAB61D656C690_92891868.addTaint(taint);
            return varDB076E8F3C9AA5817E9BAB61D656C690_92891868;
        } //End block
        DERObjectIdentifier oid = (DERObjectIdentifier)lookUp.get(Strings.toLowerCase(name));
    if(oid == null)        
        {
            IllegalArgumentException varA0F19C560D30A8661B2D4483C63CCEC3_1988848752 = new IllegalArgumentException("Unknown object id - " + name + " - passed to distinguished name");
            varA0F19C560D30A8661B2D4483C63CCEC3_1988848752.addTaint(taint);
            throw varA0F19C560D30A8661B2D4483C63CCEC3_1988848752;
        } //End block
DERObjectIdentifier var6EE0E520E830DF58CC7591C0A7BECFB6_1659859947 =         oid;
        var6EE0E520E830DF58CC7591C0A7BECFB6_1659859947.addTaint(taint);
        return var6EE0E520E830DF58CC7591C0A7BECFB6_1659859947;
        // ---------- Original Method ----------
        //if (Strings.toUpperCase(name).startsWith("OID."))
        //{
            //return new DERObjectIdentifier(name.substring(4));
        //}
        //else if (name.charAt(0) >= '0' && name.charAt(0) <= '9')
        //{
            //return new DERObjectIdentifier(name);
        //}
        //DERObjectIdentifier oid = (DERObjectIdentifier)lookUp.get(Strings.toLowerCase(name));
        //if (oid == null)
        //{
            //throw new IllegalArgumentException("Unknown object id - " + name + " - passed to distinguished name");
        //}
        //return oid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.549 -0400", hash_original_method = "2D101B81AA4F7CB6B72317966361C7FD", hash_generated_method = "4A751D866434C1D5328254E4A96D8AEB")
    public Vector getOIDs() {
        Vector v = new Vector();
for(int i = 0;i != ordering.size();i++)
        {
            v.addElement(ordering.elementAt(i));
        } //End block
Vector var6DC76BC51820DD65E8396280E884AA78_2032605580 =         v;
        var6DC76BC51820DD65E8396280E884AA78_2032605580.addTaint(taint);
        return var6DC76BC51820DD65E8396280E884AA78_2032605580;
        // ---------- Original Method ----------
        //Vector  v = new Vector();
        //for (int i = 0; i != ordering.size(); i++)
        //{
            //v.addElement(ordering.elementAt(i));
        //}
        //return v;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.549 -0400", hash_original_method = "F648A0377CD08E6DCA69D49343904A7E", hash_generated_method = "B819E21AD03C22AC327EA20A8C94AA25")
    public Vector getValues() {
        Vector v = new Vector();
for(int i = 0;i != values.size();i++)
        {
            v.addElement(values.elementAt(i));
        } //End block
Vector var6DC76BC51820DD65E8396280E884AA78_1835844584 =         v;
        var6DC76BC51820DD65E8396280E884AA78_1835844584.addTaint(taint);
        return var6DC76BC51820DD65E8396280E884AA78_1835844584;
        // ---------- Original Method ----------
        //Vector  v = new Vector();
        //for (int i = 0; i != values.size(); i++)
        //{
            //v.addElement(values.elementAt(i));
        //}
        //return v;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.550 -0400", hash_original_method = "B5B05F9A72085C1CEE80B6960CBCC4AA", hash_generated_method = "14ABF4668C8C28968D62B00F63978A7D")
    public Vector getValues(
        DERObjectIdentifier oid) {
        addTaint(oid.getTaint());
        Vector v = new Vector();
for(int i = 0;i != values.size();i++)
        {
    if(ordering.elementAt(i).equals(oid))            
            {
                String val = (String)values.elementAt(i);
    if(val.length() > 2 && val.charAt(0) == '\\' && val.charAt(1) == '#')                
                {
                    v.addElement(val.substring(1));
                } //End block
                else
                {
                    v.addElement(val);
                } //End block
            } //End block
        } //End block
Vector var6DC76BC51820DD65E8396280E884AA78_1016318996 =         v;
        var6DC76BC51820DD65E8396280E884AA78_1016318996.addTaint(taint);
        return var6DC76BC51820DD65E8396280E884AA78_1016318996;
        // ---------- Original Method ----------
        //Vector  v = new Vector();
        //for (int i = 0; i != values.size(); i++)
        //{
            //if (ordering.elementAt(i).equals(oid))
            //{
                //String val = (String)values.elementAt(i);
                //if (val.length() > 2 && val.charAt(0) == '\\' && val.charAt(1) == '#')
                //{
                    //v.addElement(val.substring(1));
                //}
                //else
                //{
                    //v.addElement(val);
                //}
            //}
        //}
        //return v;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.551 -0400", hash_original_method = "3947A3064A86A512C4391326C6ABB01D", hash_generated_method = "43A153AF2C88C45CE354ED1E64D55B9B")
    public DERObject toASN1Object() {
    if(seq == null)        
        {
            ASN1EncodableVector vec = new ASN1EncodableVector();
            ASN1EncodableVector sVec = new ASN1EncodableVector();
            DERObjectIdentifier lstOid = null;
for(int i = 0;i != ordering.size();i++)
            {
                ASN1EncodableVector v = new ASN1EncodableVector();
                DERObjectIdentifier oid = (DERObjectIdentifier)ordering.elementAt(i);
                v.add(oid);
                String str = (String)values.elementAt(i);
                v.add(converter.getConvertedValue(oid, str));
    if(lstOid == null 
                    || ((Boolean)this.added.elementAt(i)).booleanValue())                
                {
                    sVec.add(new DERSequence(v));
                } //End block
                else
                {
                    vec.add(new DERSet(sVec));
                    sVec = new ASN1EncodableVector();
                    sVec.add(new DERSequence(v));
                } //End block
                lstOid = oid;
            } //End block
            vec.add(new DERSet(sVec));
            seq = new DERSequence(vec);
        } //End block
DERObject var42A78C062640017A329FA085150BC1B8_68209434 =         seq;
        var42A78C062640017A329FA085150BC1B8_68209434.addTaint(taint);
        return var42A78C062640017A329FA085150BC1B8_68209434;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.552 -0400", hash_original_method = "280DBAE44A81315C42DC75BD60909480", hash_generated_method = "CEE50CA56F49CDEFBB9872E3DEDEA468")
    public boolean equals(Object obj, boolean inOrder) {
        addTaint(inOrder);
        addTaint(obj.getTaint());
    if(!inOrder)        
        {
            boolean var6B45452ACCD7D93A4F0BF18AB7DE1D52_585740524 = (this.equals(obj));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1610657310 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1610657310;
        } //End block
    if(obj == this)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1192321487 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1914051954 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1914051954;
        } //End block
    if(!(obj instanceof X509Name || obj instanceof ASN1Sequence))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1520553430 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_398909898 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_398909898;
        } //End block
        DERObject derO = ((DEREncodable)obj).getDERObject();
    if(this.getDERObject().equals(derO))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_914240726 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1525049158 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1525049158;
        } //End block
        X509Name other;
        try 
        {
            other = X509Name.getInstance(obj);
        } //End block
        catch (IllegalArgumentException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_644760002 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1513826260 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1513826260;
        } //End block
        int orderingSize = ordering.size();
    if(orderingSize != other.ordering.size())        
        {
            boolean var68934A3E9455FA72420237EB05902327_378611377 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_487584994 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_487584994;
        } //End block
for(int i = 0;i < orderingSize;i++)
        {
            DERObjectIdentifier oid = (DERObjectIdentifier)ordering.elementAt(i);
            DERObjectIdentifier oOid = (DERObjectIdentifier)other.ordering.elementAt(i);
    if(oid.equals(oOid))            
            {
                String value = (String)values.elementAt(i);
                String oValue = (String)other.values.elementAt(i);
    if(!equivalentStrings(value, oValue))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_268357589 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1401414397 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1401414397;
                } //End block
            } //End block
            else
            {
                boolean var68934A3E9455FA72420237EB05902327_1608549074 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1636147556 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1636147556;
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1397242372 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1612933480 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1612933480;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.553 -0400", hash_original_method = "F1AF8C1EFC711A1D842EED436165BEED", hash_generated_method = "A651A2F0492F791885CED3AD752F2A95")
    public int hashCode() {
    if(isHashCodeCalculated)        
        {
            int var4D002D69417019F289C8061B82207DD2_1832425368 = (hashCodeValue);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2093863364 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2093863364;
        } //End block
        isHashCodeCalculated = true;
for(int i = 0;i != ordering.size();i += 1)
        {
            String value = (String)values.elementAt(i);
            value = canonicalize(value);
            value = stripInternalSpaces(value);
            hashCodeValue ^= ordering.elementAt(i).hashCode();
            hashCodeValue ^= value.hashCode();
        } //End block
        int var4D002D69417019F289C8061B82207DD2_707233725 = (hashCodeValue);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1825901988 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1825901988;
        // ---------- Original Method ----------
        //if (isHashCodeCalculated)
        //{
            //return hashCodeValue;
        //}
        //isHashCodeCalculated = true;
        //for (int i = 0; i != ordering.size(); i += 1)
        //{
            //String value = (String)values.elementAt(i);
            //value = canonicalize(value);
            //value = stripInternalSpaces(value);
            //hashCodeValue ^= ordering.elementAt(i).hashCode();
            //hashCodeValue ^= value.hashCode();
        //}
        //return hashCodeValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.555 -0400", hash_original_method = "9BE112C8870FAD3CF61652B8C6BD4A74", hash_generated_method = "739F2FBF9FE350DE23ED8B0B8F7AA09F")
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
    if(obj == this)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_137052969 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1350025720 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1350025720;
        } //End block
    if(!(obj instanceof X509Name || obj instanceof ASN1Sequence))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1092711850 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1515723848 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1515723848;
        } //End block
        DERObject derO = ((DEREncodable)obj).getDERObject();
    if(this.getDERObject().equals(derO))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1428644540 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1886221594 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1886221594;
        } //End block
        X509Name other;
        try 
        {
            other = X509Name.getInstance(obj);
        } //End block
        catch (IllegalArgumentException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_856203833 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1656377094 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1656377094;
        } //End block
        int orderingSize = ordering.size();
    if(orderingSize != other.ordering.size())        
        {
            boolean var68934A3E9455FA72420237EB05902327_304471494 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_219733873 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_219733873;
        } //End block
        boolean[] indexes = new boolean[orderingSize];
        int start;
        int end;
        int delta;
    if(ordering.elementAt(0).equals(other.ordering.elementAt(0)))        
        {
            start = 0;
            end = orderingSize;
            delta = 1;
        } //End block
        else
        {
            start = orderingSize - 1;
            end = -1;
            delta = -1;
        } //End block
for(int i = start;i != end;i += delta)
        {
            boolean found = false;
            DERObjectIdentifier oid = (DERObjectIdentifier)ordering.elementAt(i);
            String value = (String)values.elementAt(i);
for(int j = 0;j < orderingSize;j++)
            {
    if(indexes[j])                
                {
                    continue;
                } //End block
                DERObjectIdentifier oOid = (DERObjectIdentifier)other.ordering.elementAt(j);
    if(oid.equals(oOid))                
                {
                    String oValue = (String)other.values.elementAt(j);
    if(equivalentStrings(value, oValue))                    
                    {
                        indexes[j] = true;
                        found      = true;
                        break;
                    } //End block
                } //End block
            } //End block
    if(!found)            
            {
                boolean var68934A3E9455FA72420237EB05902327_259578190 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_338525796 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_338525796;
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_454292857 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1825813002 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1825813002;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.557 -0400", hash_original_method = "4C05CDE4A9C2B68738F6FCFBDDBEA55B", hash_generated_method = "9F08E6670F71888F7B8443A4827140AB")
    private boolean equivalentStrings(String s1, String s2) {
        addTaint(s2.getTaint());
        addTaint(s1.getTaint());
        String value = canonicalize(s1);
        String oValue = canonicalize(s2);
    if(!value.equals(oValue))        
        {
            value = stripInternalSpaces(value);
            oValue = stripInternalSpaces(oValue);
    if(!value.equals(oValue))            
            {
                boolean var68934A3E9455FA72420237EB05902327_1486673825 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1591996193 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1591996193;
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_90241157 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2039591321 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2039591321;
        // ---------- Original Method ----------
        //String value = canonicalize(s1);
        //String oValue = canonicalize(s2);
        //if (!value.equals(oValue))
        //{
            //value = stripInternalSpaces(value);
            //oValue = stripInternalSpaces(oValue);
            //if (!value.equals(oValue))
            //{
                //return false;
            //}
        //}
        //return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.558 -0400", hash_original_method = "94F49650EDA8FF5038678A71C47387EA", hash_generated_method = "7C2D9870A33CE33959BCA782AE37A117")
    private String canonicalize(String s) {
        addTaint(s.getTaint());
        String value = Strings.toLowerCase(s.trim());
    if(value.length() > 0 && value.charAt(0) == '#')        
        {
            DERObject obj = decodeObject(value);
    if(obj instanceof DERString)            
            {
                value = Strings.toLowerCase(((DERString)obj).getString().trim());
            } //End block
        } //End block
String varAF280DA2BC37D8BE783D8499160168DE_1041148621 =         value;
        varAF280DA2BC37D8BE783D8499160168DE_1041148621.addTaint(taint);
        return varAF280DA2BC37D8BE783D8499160168DE_1041148621;
        // ---------- Original Method ----------
        //String value = Strings.toLowerCase(s.trim());
        //if (value.length() > 0 && value.charAt(0) == '#')
        //{
            //DERObject obj = decodeObject(value);
            //if (obj instanceof DERString)
            //{
                //value = Strings.toLowerCase(((DERString)obj).getString().trim());
            //}
        //}
        //return value;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.558 -0400", hash_original_method = "DA9861DC0244404A041AD42C955600B0", hash_generated_method = "F25703653FA2E8E6B9EA76F8094584A3")
    private ASN1Object decodeObject(String oValue) {
        addTaint(oValue.getTaint());
        try 
        {
ASN1Object varDC836AD1738524F460698D3D090F44A0_860754255 =             ASN1Object.fromByteArray(Hex.decode(oValue.substring(1)));
            varDC836AD1738524F460698D3D090F44A0_860754255.addTaint(taint);
            return varDC836AD1738524F460698D3D090F44A0_860754255;
        } //End block
        catch (IOException e)
        {
            IllegalStateException var6000C227E791C30DAB9C9FD41D40B372_1699825641 = new IllegalStateException("unknown encoding in name: " + e);
            var6000C227E791C30DAB9C9FD41D40B372_1699825641.addTaint(taint);
            throw var6000C227E791C30DAB9C9FD41D40B372_1699825641;
        } //End block
        // ---------- Original Method ----------
        //try
        //{
            //return ASN1Object.fromByteArray(Hex.decode(oValue.substring(1)));
        //}
        //catch (IOException e)
        //{
            //throw new IllegalStateException("unknown encoding in name: " + e);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.559 -0400", hash_original_method = "1E1DA2E49EB072DAE70813000ABE2315", hash_generated_method = "6C0FBCBB76741300137C57BBEF8410AB")
    private String stripInternalSpaces(
        String str) {
        addTaint(str.getTaint());
        StringBuffer res = new StringBuffer();
    if(str.length() != 0)        
        {
            char c1 = str.charAt(0);
            res.append(c1);
for(int k = 1;k < str.length();k++)
            {
                char c2 = str.charAt(k);
    if(!(c1 == ' ' && c2 == ' '))                
                {
                    res.append(c2);
                } //End block
                c1 = c2;
            } //End block
        } //End block
String varEC7EB75EF3C7FA633C54FC66A0358174_720957858 =         res.toString();
        varEC7EB75EF3C7FA633C54FC66A0358174_720957858.addTaint(taint);
        return varEC7EB75EF3C7FA633C54FC66A0358174_720957858;
        // ---------- Original Method ----------
        //StringBuffer res = new StringBuffer();
        //if (str.length() != 0)
        //{
            //char    c1 = str.charAt(0);
            //res.append(c1);
            //for (int k = 1; k < str.length(); k++)
            //{
                //char    c2 = str.charAt(k);
                //if (!(c1 == ' ' && c2 == ' '))
                //{
                    //res.append(c2);
                //}
                //c1 = c2;
            //}
        //}
        //return res.toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.560 -0400", hash_original_method = "276C610AF86C7F7EC8233E2E5B295559", hash_generated_method = "72C683AF7BF2C0498E9BE64DE54A298D")
    private void appendValue(
        StringBuffer        buf,
        Hashtable           oidSymbols,
        DERObjectIdentifier oid,
        String              value) {
        addTaint(value.getTaint());
        addTaint(oid.getTaint());
        addTaint(oidSymbols.getTaint());
        addTaint(buf.getTaint());
        String sym = (String)oidSymbols.get(oid);
    if(sym != null)        
        {
            buf.append(sym);
        } //End block
        else
        {
            buf.append(oid.getId());
        } //End block
        buf.append('=');
        int index = buf.length();
        buf.append(value);
        int end = buf.length();
    if(value.length() >= 2 && value.charAt(0) == '\\' && value.charAt(1) == '#')        
        {
            index += 2;
        } //End block
        while
(index != end)        
        {
    if((buf.charAt(index) == ',')
               || (buf.charAt(index) == '"')
               || (buf.charAt(index) == '\\')
               || (buf.charAt(index) == '+')
               || (buf.charAt(index) == '=')
               || (buf.charAt(index) == '<')
               || (buf.charAt(index) == '>')
               || (buf.charAt(index) == ';'))            
            {
                buf.insert(index, "\\");
                index++;
                end++;
            } //End block
            index++;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.561 -0400", hash_original_method = "656BABE23C68D82FE6D3AB319F560E81", hash_generated_method = "F02FAB279C27CAED0A4E9F97C04EA6F5")
    public String toString(
        boolean     reverse,
        Hashtable   oidSymbols) {
        addTaint(oidSymbols.getTaint());
        addTaint(reverse);
        StringBuffer buf = new StringBuffer();
        Vector components = new Vector();
        boolean first = true;
        StringBuffer ava = null;
for(int i = 0;i < ordering.size();i++)
        {
    if(((Boolean)added.elementAt(i)).booleanValue())            
            {
                ava.append('+');
                appendValue(ava, oidSymbols,
                    (DERObjectIdentifier)ordering.elementAt(i),
                    (String)values.elementAt(i));
            } //End block
            else
            {
                ava = new StringBuffer();
                appendValue(ava, oidSymbols,
                    (DERObjectIdentifier)ordering.elementAt(i),
                    (String)values.elementAt(i));
                components.addElement(ava);
            } //End block
        } //End block
    if(reverse)        
        {
for(int i = components.size() - 1;i >= 0;i--)
            {
    if(first)                
                {
                    first = false;
                } //End block
                else
                {
                    buf.append(',');
                } //End block
                buf.append(components.elementAt(i).toString());
            } //End block
        } //End block
        else
        {
for(int i = 0;i < components.size();i++)
            {
    if(first)                
                {
                    first = false;
                } //End block
                else
                {
                    buf.append(',');
                } //End block
                buf.append(components.elementAt(i).toString());
            } //End block
        } //End block
String var4FC680801218E6372BC708D6FA44AE60_1456740391 =         buf.toString();
        var4FC680801218E6372BC708D6FA44AE60_1456740391.addTaint(taint);
        return var4FC680801218E6372BC708D6FA44AE60_1456740391;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.562 -0400", hash_original_method = "B6C7D564A6D3D0BE9A656CE0C6CFB554", hash_generated_method = "6BB3F11F9C8DF35E1F330EE6F8FA8D2D")
    private String bytesToString(
        byte[] data) {
        addTaint(data[0]);
        char[] cs = new char[data.length];
for(int i = 0;i != cs.length;i++)
        {
            cs[i] = (char)(data[i] & 0xff);
        } //End block
String varEE3C15FF17401E8EE402ABCA933B75C8_2005073165 =         new String(cs);
        varEE3C15FF17401E8EE402ABCA933B75C8_2005073165.addTaint(taint);
        return varEE3C15FF17401E8EE402ABCA933B75C8_2005073165;
        // ---------- Original Method ----------
        //char[]  cs = new char[data.length];
        //for (int i = 0; i != cs.length; i++)
        //{
            //cs[i] = (char)(data[i] & 0xff);
        //}
        //return new String(cs);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.562 -0400", hash_original_method = "E860E9E8B8CF997531DC86A289D376AE", hash_generated_method = "35AA799D63EFB7B455090F2B9F31264B")
    public String toString() {
String varD00BB2E4A865BC001F6C25F341B09FCC_925325489 =         toString(DefaultReverse, DefaultSymbols);
        varD00BB2E4A865BC001F6C25F341B09FCC_925325489.addTaint(taint);
        return varD00BB2E4A865BC001F6C25F341B09FCC_925325489;
        // ---------- Original Method ----------
        //return toString(DefaultReverse, DefaultSymbols);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.562 -0400", hash_original_field = "E177AA3BCF90C6371FF59014C82D88D2", hash_generated_field = "82D687239E3C86279A9A387C3E8AE15F")

    public static final DERObjectIdentifier C = new DERObjectIdentifier("2.5.4.6");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.562 -0400", hash_original_field = "7015CC2DE8BD3D7E95B89FA0CD2F2666", hash_generated_field = "9A0BCC4B2444A7BF0405630803C2F2D0")

    public static final DERObjectIdentifier O = new DERObjectIdentifier("2.5.4.10");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.562 -0400", hash_original_field = "9A5D4B7E4ECE2A9BB425C3345B998E46", hash_generated_field = "6326280D591C30719B3DB5C13338F0A3")

    public static final DERObjectIdentifier OU = new DERObjectIdentifier("2.5.4.11");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.562 -0400", hash_original_field = "A4A00A65CC8B84CBAB3B3F883DE3FF99", hash_generated_field = "E8B45184A7115EE6111EDB1B37A68019")

    public static final DERObjectIdentifier T = new DERObjectIdentifier("2.5.4.12");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.562 -0400", hash_original_field = "BFA71FD8EC8226C6E62235868202C6A4", hash_generated_field = "CF9435847FFC6C3C7927992F9EE3FAFF")

    public static final DERObjectIdentifier CN = new DERObjectIdentifier("2.5.4.3");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.562 -0400", hash_original_field = "9F650D1C8A874B962150648810632848", hash_generated_field = "1C5FE81E2DBFFB02A7D19673EC4A90E2")

    public static final DERObjectIdentifier SN = new DERObjectIdentifier("2.5.4.5");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.562 -0400", hash_original_field = "50FA3A65F1BF8421A7EB643D999BA6AA", hash_generated_field = "2F85801FBF51C8EE5695ECB3E05715B4")

    public static final DERObjectIdentifier STREET = new DERObjectIdentifier("2.5.4.9");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.563 -0400", hash_original_field = "5AC9323E3AB7013AFF904A3D9E7AE793", hash_generated_field = "BDDAF789362E72D2FF3111AE8E110F7A")

    public static final DERObjectIdentifier SERIALNUMBER = SN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.563 -0400", hash_original_field = "83E634BE0BD02D990AFD5FE5C22B868F", hash_generated_field = "CBB2A0091E475910A1B9F56755855304")

    public static final DERObjectIdentifier L = new DERObjectIdentifier("2.5.4.7");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.563 -0400", hash_original_field = "CE43E33A8A444765C4CC410459950723", hash_generated_field = "FA86D310F2857FB8F860635B33CDE85B")

    public static final DERObjectIdentifier ST = new DERObjectIdentifier("2.5.4.8");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.563 -0400", hash_original_field = "900C53B4AA95A8DF8A53C6824593741F", hash_generated_field = "59FFCD55B0D0B45F483BC2293E395377")

    public static final DERObjectIdentifier SURNAME = new DERObjectIdentifier("2.5.4.4");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.563 -0400", hash_original_field = "1A941C6061399864B810187E9795E1A8", hash_generated_field = "E97C7C5B7041A426BC30CC1454C5DBF7")

    public static final DERObjectIdentifier GIVENNAME = new DERObjectIdentifier("2.5.4.42");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.563 -0400", hash_original_field = "3B788DA4453226CBD0BE4B7A432EF6E0", hash_generated_field = "A5FD4B35D111D951F8765946D5A83284")

    public static final DERObjectIdentifier INITIALS = new DERObjectIdentifier("2.5.4.43");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.563 -0400", hash_original_field = "A2557D3D54AF5E3AE31A9E53F6CB85F0", hash_generated_field = "533BDABA5EA8217D595157FA1EE80ABF")

    public static final DERObjectIdentifier GENERATION = new DERObjectIdentifier("2.5.4.44");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.563 -0400", hash_original_field = "6554E8B92D20941B0A52552C31DD327C", hash_generated_field = "4F43AC9282AD9798244BC73AEDAA5A8D")

    public static final DERObjectIdentifier UNIQUE_IDENTIFIER = new DERObjectIdentifier("2.5.4.45");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.563 -0400", hash_original_field = "5EC2CC421BAEE892929844AF98CC386D", hash_generated_field = "B855455F4EDB294C798C9D3C9026BF51")

    public static final DERObjectIdentifier BUSINESS_CATEGORY = new DERObjectIdentifier(
                    "2.5.4.15");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.563 -0400", hash_original_field = "5FA3FC0B0C13B35F0314B3478EACE2F1", hash_generated_field = "AFCF615F7F4AD23472ADBFCF9493AE20")

    public static final DERObjectIdentifier POSTAL_CODE = new DERObjectIdentifier(
                    "2.5.4.17");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.563 -0400", hash_original_field = "D1AC0C308E6330692C598894228A894D", hash_generated_field = "3BEB0664EEAAC66C4E6B3507A541A961")

    public static final DERObjectIdentifier DN_QUALIFIER = new DERObjectIdentifier(
                    "2.5.4.46");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.563 -0400", hash_original_field = "680CF654F71DAF4F8D2E34F81109BE8B", hash_generated_field = "8BDA30822F069D0EF535FB88FF8A1F36")

    public static final DERObjectIdentifier PSEUDONYM = new DERObjectIdentifier(
                    "2.5.4.65");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.563 -0400", hash_original_field = "7559D4BCC6B41CF1F1591E5313D3D96C", hash_generated_field = "9420DBC6483B34D87C2038353B444C41")

    public static final DERObjectIdentifier DATE_OF_BIRTH = new DERObjectIdentifier(
                    "1.3.6.1.5.5.7.9.1");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.563 -0400", hash_original_field = "BBF1794F0A17E2E42707F6ACE95AA8FF", hash_generated_field = "DD23A595DF652DF1A4A46D9CF34396D1")

    public static final DERObjectIdentifier PLACE_OF_BIRTH = new DERObjectIdentifier(
                    "1.3.6.1.5.5.7.9.2");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.564 -0400", hash_original_field = "D0E9FB33B291E4536A8FB1F8A2D73FEB", hash_generated_field = "653665F25666ED2418201CB7491A2E83")

    public static final DERObjectIdentifier GENDER = new DERObjectIdentifier(
                    "1.3.6.1.5.5.7.9.3");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.564 -0400", hash_original_field = "E14448FDD84DD8C7143C71E9CB988AEC", hash_generated_field = "60C31DC383F5B2CBA146E21EF7DBE62C")

    public static final DERObjectIdentifier COUNTRY_OF_CITIZENSHIP = new DERObjectIdentifier(
                    "1.3.6.1.5.5.7.9.4");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.564 -0400", hash_original_field = "23D0CB6366D0BCE573F5EE2192F2AA98", hash_generated_field = "298A701F0CC84796B2E4DA6C024B48DE")

    public static final DERObjectIdentifier COUNTRY_OF_RESIDENCE = new DERObjectIdentifier(
                    "1.3.6.1.5.5.7.9.5");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.564 -0400", hash_original_field = "D71309D586C2FA6034AFF2E0B1673E1B", hash_generated_field = "543131AACA3F47053FDEC53A1C384306")

    public static final DERObjectIdentifier NAME_AT_BIRTH =  new DERObjectIdentifier("1.3.36.8.3.14");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.564 -0400", hash_original_field = "D32E8904B3B1909A368EA22DEA55AEAE", hash_generated_field = "587BAD00A55BF518298D870F21FA8435")

    public static final DERObjectIdentifier POSTAL_ADDRESS = new DERObjectIdentifier("2.5.4.16");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.564 -0400", hash_original_field = "7393274E24112AE209E570068E2CB377", hash_generated_field = "EFCF83D1673ED3AA566EA2CBA7E1FCE8")

    public static final DERObjectIdentifier DMD_NAME = new DERObjectIdentifier("2.5.4.54");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.564 -0400", hash_original_field = "ABCD051D2584EDF4C7DAC45C2213D37A", hash_generated_field = "9E94AA66AACE8B4A0BE080CCD0FAC70F")

    public static final DERObjectIdentifier TELEPHONE_NUMBER = X509ObjectIdentifiers.id_at_telephoneNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.564 -0400", hash_original_field = "E931C7B03A64786863967F0BC14890C6", hash_generated_field = "FFAD4425897D716BCD593C09C46AFD73")

    public static final DERObjectIdentifier NAME = X509ObjectIdentifiers.id_at_name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.564 -0400", hash_original_field = "AB5376EA36F8610FEC8AE6621D7491D9", hash_generated_field = "584A7AECA4B0ACA0DBBC90E0BD7C9332")

    public static final DERObjectIdentifier EmailAddress = PKCSObjectIdentifiers.pkcs_9_at_emailAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.564 -0400", hash_original_field = "CCCA67DADCF824B36D120A0A0E7847F2", hash_generated_field = "CCAA56F97463C5118260AD6DD1DDC80F")

    public static final DERObjectIdentifier UnstructuredName = PKCSObjectIdentifiers.pkcs_9_at_unstructuredName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.564 -0400", hash_original_field = "A1069D8572967482B49C98AED67A215B", hash_generated_field = "342508E8CA88924FDFDA1D381AFD3338")

    public static final DERObjectIdentifier UnstructuredAddress = PKCSObjectIdentifiers.pkcs_9_at_unstructuredAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.564 -0400", hash_original_field = "05C9073B7E40A1D4E6C8466E0DDA9A6F", hash_generated_field = "021E5BC1569FD92F01DB6A01724523C2")

    public static final DERObjectIdentifier E = EmailAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.565 -0400", hash_original_field = "FF41B5069397DB28084CF5A9EA58927A", hash_generated_field = "1334C446DFB8D545DC3107A020531330")

    public static final DERObjectIdentifier DC = new DERObjectIdentifier("0.9.2342.19200300.100.1.25");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.565 -0400", hash_original_field = "A5CF3CCCCD787F36C43EB5EB32ADB0BF", hash_generated_field = "E4CD602AF9770F8D3B9404D5F2532570")

    public static final DERObjectIdentifier UID = new DERObjectIdentifier("0.9.2342.19200300.100.1.1");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.565 -0400", hash_original_field = "93EAA62615B304AC8EF691777F01487C", hash_generated_field = "BB46BFBE07BCC7526C461E59C789AB8E")

    public static boolean DefaultReverse = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.565 -0400", hash_original_field = "F5684916D3BA1C14EACDDDD00DA1C309", hash_generated_field = "158D1B2B36F24863D1B8E7C3B9D7F7A2")

    public static final Hashtable DefaultSymbols = new Hashtable();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.565 -0400", hash_original_field = "B36EDAD4E06FB368958AF79EF01DB8F2", hash_generated_field = "C9354DE849CFE049572C4221C51E7309")

    public static final Hashtable RFC2253Symbols = new Hashtable();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.565 -0400", hash_original_field = "453F4DA5E0995DE0291DC6BE429E78D1", hash_generated_field = "10F89287F10A6638EB4EE375195390E2")

    public static final Hashtable RFC1779Symbols = new Hashtable();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.565 -0400", hash_original_field = "80F42D6B53063097AA147CC39ED38975", hash_generated_field = "9EEF14EBA4A5D75E5091872B5F8BAEFC")

    public static final Hashtable DefaultLookUp = new Hashtable();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.565 -0400", hash_original_field = "553A55526C7B5E0DCD086FBD4EDC9B90", hash_generated_field = "914593EB818CF28AF7D26BC6344231F7")

    public static final Hashtable OIDLookUp = DefaultSymbols;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.565 -0400", hash_original_field = "862868D7B55C07F13D3F93635BF0228A", hash_generated_field = "777E54E742DACB0C5BCAD8347B24CD80")

    public static final Hashtable SymbolLookUp = DefaultLookUp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.565 -0400", hash_original_field = "F9CC458E79700B174BE3EEB0E2933EF6", hash_generated_field = "D283B4A736D2AC5091CFA69743A46FDD")

    private static final Boolean TRUE = Boolean.TRUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.565 -0400", hash_original_field = "FAF750A21704D3B76419462A3FBB66E1", hash_generated_field = "0C266C5D45C3B38D3B96B825C1C5DA0B")

    private static final Boolean FALSE = Boolean.FALSE;
    static {
        DefaultSymbols.put(C, "C");
        DefaultSymbols.put(O, "O");
        DefaultSymbols.put(T, "T");
        DefaultSymbols.put(OU, "OU");
        DefaultSymbols.put(CN, "CN");
        DefaultSymbols.put(L, "L");
        DefaultSymbols.put(ST, "ST");
        DefaultSymbols.put(SN, "SERIALNUMBER");
        DefaultSymbols.put(EmailAddress, "E");
        DefaultSymbols.put(DC, "DC");
        DefaultSymbols.put(UID, "UID");
        DefaultSymbols.put(STREET, "STREET");
        DefaultSymbols.put(SURNAME, "SURNAME");
        DefaultSymbols.put(GIVENNAME, "GIVENNAME");
        DefaultSymbols.put(INITIALS, "INITIALS");
        DefaultSymbols.put(GENERATION, "GENERATION");
        DefaultSymbols.put(UnstructuredAddress, "unstructuredAddress");
        DefaultSymbols.put(UnstructuredName, "unstructuredName");
        DefaultSymbols.put(UNIQUE_IDENTIFIER, "UniqueIdentifier");
        DefaultSymbols.put(DN_QUALIFIER, "DN");
        DefaultSymbols.put(PSEUDONYM, "Pseudonym");
        DefaultSymbols.put(POSTAL_ADDRESS, "PostalAddress");
        DefaultSymbols.put(NAME_AT_BIRTH, "NameAtBirth");
        DefaultSymbols.put(COUNTRY_OF_CITIZENSHIP, "CountryOfCitizenship");
        DefaultSymbols.put(COUNTRY_OF_RESIDENCE, "CountryOfResidence");
        DefaultSymbols.put(GENDER, "Gender");
        DefaultSymbols.put(PLACE_OF_BIRTH, "PlaceOfBirth");
        DefaultSymbols.put(DATE_OF_BIRTH, "DateOfBirth");
        DefaultSymbols.put(POSTAL_CODE, "PostalCode");
        DefaultSymbols.put(BUSINESS_CATEGORY, "BusinessCategory");
        DefaultSymbols.put(TELEPHONE_NUMBER, "TelephoneNumber");
        DefaultSymbols.put(NAME, "Name");
        RFC2253Symbols.put(C, "C");
        RFC2253Symbols.put(O, "O");
        RFC2253Symbols.put(OU, "OU");
        RFC2253Symbols.put(CN, "CN");
        RFC2253Symbols.put(L, "L");
        RFC2253Symbols.put(ST, "ST");
        RFC2253Symbols.put(STREET, "STREET");
        RFC2253Symbols.put(DC, "DC");
        RFC2253Symbols.put(UID, "UID");
        RFC1779Symbols.put(C, "C");
        RFC1779Symbols.put(O, "O");
        RFC1779Symbols.put(OU, "OU");
        RFC1779Symbols.put(CN, "CN");
        RFC1779Symbols.put(L, "L");
        RFC1779Symbols.put(ST, "ST");
        RFC1779Symbols.put(STREET, "STREET");
        DefaultLookUp.put("c", C);
        DefaultLookUp.put("o", O);
        DefaultLookUp.put("t", T);
        DefaultLookUp.put("ou", OU);
        DefaultLookUp.put("cn", CN);
        DefaultLookUp.put("l", L);
        DefaultLookUp.put("st", ST);
        DefaultLookUp.put("sn", SN);
        DefaultLookUp.put("serialnumber", SN);
        DefaultLookUp.put("street", STREET);
        DefaultLookUp.put("emailaddress", E);
        DefaultLookUp.put("dc", DC);
        DefaultLookUp.put("e", E);
        DefaultLookUp.put("uid", UID);
        DefaultLookUp.put("surname", SURNAME);
        DefaultLookUp.put("givenname", GIVENNAME);
        DefaultLookUp.put("initials", INITIALS);
        DefaultLookUp.put("generation", GENERATION);
        DefaultLookUp.put("unstructuredaddress", UnstructuredAddress);
        DefaultLookUp.put("unstructuredname", UnstructuredName);
        DefaultLookUp.put("uniqueidentifier", UNIQUE_IDENTIFIER);
        DefaultLookUp.put("dn", DN_QUALIFIER);
        DefaultLookUp.put("pseudonym", PSEUDONYM);
        DefaultLookUp.put("postaladdress", POSTAL_ADDRESS);
        DefaultLookUp.put("nameofbirth", NAME_AT_BIRTH);
        DefaultLookUp.put("countryofcitizenship", COUNTRY_OF_CITIZENSHIP);
        DefaultLookUp.put("countryofresidence", COUNTRY_OF_RESIDENCE);
        DefaultLookUp.put("gender", GENDER);
        DefaultLookUp.put("placeofbirth", PLACE_OF_BIRTH);
        DefaultLookUp.put("dateofbirth", DATE_OF_BIRTH);
        DefaultLookUp.put("postalcode", POSTAL_CODE);
        DefaultLookUp.put("businesscategory", BUSINESS_CATEGORY);
        DefaultLookUp.put("telephonenumber", TELEPHONE_NUMBER);
        DefaultLookUp.put("name", NAME);
    }
    
}

