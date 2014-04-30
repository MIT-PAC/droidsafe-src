package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

abstract public class ASN1Set extends ASN1Object {

    /**
     * return an ASN1Set from the given object.
     *
     * @param obj the object we want converted.
     * @exception IllegalArgumentException if the object cannot be converted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.503 -0500", hash_original_method = "82683EBDF6866D998457F0D78202D8D5", hash_generated_method = "77C9539C5E046753FA41066B575CB413")
    
public static ASN1Set getInstance(
        Object  obj)
    {
        if (obj == null || obj instanceof ASN1Set)
        {
            return (ASN1Set)obj;
        }

        throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
    }

    /**
     * Return an ASN1 set from a tagged object. There is a special
     * case here, if an object appears to have been explicitly tagged on 
     * reading but we were expecting it to be implicitly tagged in the 
     * normal course of events it indicates that we lost the surrounding
     * set - so we need to add it back (this will happen if the tagged
     * object is a sequence that contains other sequences). If you are
     * dealing with implicitly tagged sets you really <b>should</b>
     * be using this method.
     *
     * @param obj the tagged object.
     * @param explicit true if the object is meant to be explicitly tagged
     *          false otherwise.
     * @exception IllegalArgumentException if the tagged object cannot
     *          be converted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.507 -0500", hash_original_method = "B17315F7900B46C8A7430B0BA6EBA2D9", hash_generated_method = "40A202615B214EF005CA76E48E28CD44")
    
public static ASN1Set getInstance(
        ASN1TaggedObject    obj,
        boolean             explicit)
    {
        if (explicit)
        {
            if (!obj.isExplicit())
            {
                throw new IllegalArgumentException("object implicit - explicit expected.");
            }

            return (ASN1Set)obj.getObject();
        }
        else
        {
            //
            // constructed object which appears to be explicitly tagged
            // and it's really implicit means we have to add the
            // surrounding sequence.
            //
            if (obj.isExplicit())
            {
                ASN1Set    set = new DERSet(obj.getObject());

                return set;
            }
            else
            {
                if (obj.getObject() instanceof ASN1Set)
                {
                    return (ASN1Set)obj.getObject();
                }

                //
                // in this case the parser returns a sequence, convert it
                // into a set.
                //
                ASN1EncodableVector  v = new ASN1EncodableVector();

                if (obj.getObject() instanceof ASN1Sequence)
                {
                    ASN1Sequence s = (ASN1Sequence)obj.getObject();
                    Enumeration e = s.getObjects();

                    while (e.hasMoreElements())
                    {
                        v.add((DEREncodable)e.nextElement());
                    }

                    return new DERSet(v, false);
                }
            }
        }

        throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.501 -0500", hash_original_field = "57CE1C29237493F7FEF6CE19D04E1024", hash_generated_field = "B61BB4FD9E03C235F8AEC9C8695ACDDC")

    protected Vector set = new Vector();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.530 -0500", hash_original_field = "8BD524D6245D998B3BBC44EB9313082E", hash_generated_field = "56A277C77B76B31C1E1045C8C11CA802")

            private int index;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.527 -0500", hash_original_field = "FE6035598DC4A50E38F7DA885A8391F1", hash_generated_field = "D2E8168F8D49E25944D5BC65100B260E")

            private final int max = size();

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.511 -0500", hash_original_method = "565D53F8B19BD627340B9CF494B1B831", hash_generated_method = "726CDC3CD2E34F5070D0A6F729BA86FA")
    
public ASN1Set()
    {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.514 -0500", hash_original_method = "393FBC2C672442D54683C7A8066AFBAA", hash_generated_method = "B93ECA28BF823730441F0ADE80CAACAD")
    
public Enumeration getObjects()
    {
        return set.elements();
    }

    /**
     * return the object at the set position indicated by index.
     *
     * @param index the set number (starting at zero) of the object
     * @return the object at the set position indicated by index.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.517 -0500", hash_original_method = "2EC03929E91899921E681A1E59657958", hash_generated_method = "846D9D7D3B15D6B5398470E0D9AC973A")
    
public DEREncodable getObjectAt(
        int index)
    {
        return (DEREncodable)set.elementAt(index);
    }

    /**
     * return the number of objects in this set.
     *
     * @return the number of objects in this set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.521 -0500", hash_original_method = "283365B7154686D5E09A8541EE47F429", hash_generated_method = "357C4F7A3AB6F76F7971FD49DE2E828E")
    
public int size()
    {
        return set.size();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.524 -0500", hash_original_method = "D576BF738CB2D30F1DA36EF06815D882", hash_generated_method = "388CC1569E3EAD57BB7A1A77F393A5C0")
    
public ASN1Encodable[] toArray()
    {
        ASN1Encodable[] values = new ASN1Encodable[this.size()];

        for (int i = 0; i != this.size(); i++)
        {
            values[i] = (ASN1Encodable)this.getObjectAt(i);
        }

        return values;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.820 -0400", hash_original_method = "3480E58BA04F290D4393ED7D48EF6B9C", hash_generated_method = "2F5149AE3B97380B1162AFD136050A12")
    public ASN1SetParser parser() {
        final ASN1Set outer = this;
ASN1SetParser varFEF15DF2C04179BD8EB2593AF5B49D65_1012881334 =         new ASN1SetParser() {        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.818 -0400", hash_original_field = "AF8DE777B25121CBA56AF409B9C79B72", hash_generated_field = "D2E8168F8D49E25944D5BC65100B260E")
        private final int max = size();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.819 -0400", hash_original_field = "6A992D5529F459A44FEE58C733255E86", hash_generated_field = "56A277C77B76B31C1E1045C8C11CA802")
        private int index;

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.533 -0500", hash_original_method = "BEBFD2E59C81385F3717CD5615389B19", hash_generated_method = "EEB83FF896D04FE8CA5A28BE281CE69D")
            
public DEREncodable readObject() throws IOException
            {
                if (index == max)
                {
                    return null;
                }

                DEREncodable obj = getObjectAt(index++);
                if (obj instanceof ASN1Sequence)
                {
                    return ((ASN1Sequence)obj).parser();
                }
                if (obj instanceof ASN1Set)
                {
                    return ((ASN1Set)obj).parser();
                }

                return obj;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.536 -0500", hash_original_method = "D852EEAF1DA4AF081125D411C2A8F904", hash_generated_method = "4AB9590B3C45CC3D0EFEEBA6EF56F456")
            
public DERObject getLoadedObject()
            {
                return outer;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.539 -0500", hash_original_method = "4FE555C2610E9C432E83EB0CA479A77A", hash_generated_method = "28EF2E886E789C49BBAA8822B9091A42")
            
public DERObject getDERObject()
            {
                return outer;
            }
};
        varFEF15DF2C04179BD8EB2593AF5B49D65_1012881334.addTaint(getTaint());
        return varFEF15DF2C04179BD8EB2593AF5B49D65_1012881334;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.546 -0500", hash_original_method = "169312DEA8D054B4F83730CF694439C2", hash_generated_method = "30BCB15E7964E7556EB51535BFA9820D")
    
public int hashCode()
    {
        Enumeration             e = this.getObjects();
        int                     hashCode = size();

        while (e.hasMoreElements())
        {
            Object o = getNext(e);
            hashCode *= 17;

            hashCode ^= o.hashCode();
        }

        return hashCode;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.549 -0500", hash_original_method = "4061A2825C144C76460287466E375CA1", hash_generated_method = "4061A2825C144C76460287466E375CA1")
    
boolean asn1Equals(
        DERObject  o)
    {
        if (!(o instanceof ASN1Set))
        {
            return false;
        }

        ASN1Set   other = (ASN1Set)o;

        if (this.size() != other.size())
        {
            return false;
        }

        Enumeration s1 = this.getObjects();
        Enumeration s2 = other.getObjects();

        while (s1.hasMoreElements())
        {
            DEREncodable  obj1 = getNext(s1);
            DEREncodable  obj2 = getNext(s2);

            DERObject  o1 = obj1.getDERObject();
            DERObject  o2 = obj2.getDERObject();

            if (o1 == o2 || o1.equals(o2))
            {
                continue;
            }

            return false;
        }

        return true;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.552 -0500", hash_original_method = "A69C6C665FC9D3DE250A324544079C85", hash_generated_method = "71F8019F43835013203D7AD69C0E7F8C")
    
private DEREncodable getNext(Enumeration e)
    {
        DEREncodable encObj = (DEREncodable)e.nextElement();

        // unfortunately null was allowed as a substitute for DER null
        if (encObj == null)
        {
            return DERNull.INSTANCE;
        }

        return encObj;
    }

    /**
     * return true if a <= b (arrays are assumed padded with zeros).
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.556 -0500", hash_original_method = "207A76DA1E8D21F977EB59C485DCA4E9", hash_generated_method = "D2B42EF0B1A3BFDDC8C331C0A9DD377D")
    
private boolean lessThanOrEqual(
         byte[] a,
         byte[] b)
    {
        int len = Math.min(a.length, b.length);
        for (int i = 0; i != len; ++i)
        {
            if (a[i] != b[i])
            {
                return (a[i] & 0xff) < (b[i] & 0xff);
            }
        }
        return len == a.length;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.559 -0500", hash_original_method = "522D47B99F0E20F7487ED5107F130A00", hash_generated_method = "5EC8527A9A7B17E76DBC3F5377BFEA21")
    
private byte[] getEncoded(
        DEREncodable obj)
    {
        ByteArrayOutputStream   bOut = new ByteArrayOutputStream();
        ASN1OutputStream        aOut = new ASN1OutputStream(bOut);

        try
        {
            aOut.writeObject(obj);
        }
        catch (IOException e)
        {
            throw new IllegalArgumentException("cannot encode object added to SET");
        }

        return bOut.toByteArray();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.561 -0500", hash_original_method = "8F80C00B71E62E5E32912D37725353DB", hash_generated_method = "19B7E61315494DC2AA327D8C1018AE35")
    
protected void sort()
    {
        if (set.size() > 1)
        {
            boolean    swapped = true;
            int        lastSwap = set.size() - 1;

            while (swapped)
            {
                int    index = 0;
                int    swapIndex = 0;
                byte[] a = getEncoded((DEREncodable)set.elementAt(0));
                
                swapped = false;

                while (index != lastSwap)
                {
                    byte[] b = getEncoded((DEREncodable)set.elementAt(index + 1));

                    if (lessThanOrEqual(a, b))
                    {
                        a = b;
                    }
                    else
                    {
                        Object  o = set.elementAt(index);

                        set.setElementAt(set.elementAt(index + 1), index);
                        set.setElementAt(o, index + 1);

                        swapped = true;
                        swapIndex = index;
                    }

                    index++;
                }

                lastSwap = swapIndex;
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.564 -0500", hash_original_method = "DAE6351DB6B0C6C803835987F16403A5", hash_generated_method = "9C9142A8730B432279C612C755A18ECF")
    
protected void addObject(
        DEREncodable obj)
    {
        set.addElement(obj);
    }

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.566 -0500", hash_original_method = "A1E289DFE0364C85836C0C8908499825", hash_generated_method = "877693E84D45EBE13EC3671BCE6F2F0C")
    
abstract void encode(DEROutputStream out)
            throws IOException;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.569 -0500", hash_original_method = "41D154F65E4EBBCBC7C30CB48ECE000A", hash_generated_method = "B6E945C93269E4763C71B3A12A473EEE")
    
public String toString() 
    {
      return set.toString();
    }
    
}

