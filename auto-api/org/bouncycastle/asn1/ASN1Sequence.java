package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

public abstract class ASN1Sequence extends ASN1Object {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.762 -0400", hash_original_field = "393195A079C882476F3D5AA22C5A8674", hash_generated_field = "1C6134BBF67C6927627E9694230C698B")

    private Vector seq = new Vector();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.763 -0400", hash_original_method = "A2B39ADE0CCBD8FB2D75DB3228C401C7", hash_generated_method = "A2B39ADE0CCBD8FB2D75DB3228C401C7")
    public ASN1Sequence ()
    {
        //Synthesized constructor
    }


        public static ASN1Sequence getInstance(
        Object  obj) {
        if (obj == null || obj instanceof ASN1Sequence)
        {
            return (ASN1Sequence)obj;
        }
        else if (obj instanceof byte[])
        {
            try
            {
                return ASN1Sequence.getInstance(ASN1Object.fromByteArray((byte[])obj));
            }
            catch (IOException e)
            {
                throw new IllegalArgumentException("failed to construct sequence from byte[]: " + e.getMessage());
            }
        }
        throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
    }

    
        public static ASN1Sequence getInstance(
        ASN1TaggedObject    obj,
        boolean             explicit) {
        if (explicit)
        {
            if (!obj.isExplicit())
            {
                throw new IllegalArgumentException("object implicit - explicit expected.");
            }
            return (ASN1Sequence)obj.getObject();
        }
        else
        {
            if (obj.isExplicit())
            {
                if (obj instanceof BERTaggedObject)
                {
                    return new BERSequence(obj.getObject());
                }
                else
                {
                    return new DERSequence(obj.getObject());
                }
            }
            else
            {
                if (obj.getObject() instanceof ASN1Sequence)
                {
                    return (ASN1Sequence)obj.getObject();
                }
            }
        }
        throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.775 -0400", hash_original_method = "CC34A39B9814871A0958BEBA7EE6E2F9", hash_generated_method = "F3CAD8E34E63647D5606A6D2666D7E0D")
    public Enumeration getObjects() {
        Enumeration varB4EAC82CA7396A68D541C85D26508E83_1400937879 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1400937879 = seq.elements();
        varB4EAC82CA7396A68D541C85D26508E83_1400937879.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1400937879;
        // ---------- Original Method ----------
        //return seq.elements();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.776 -0400", hash_original_method = "43ADC5A8CCFA8153E5DA918392680258", hash_generated_method = "038017056B302514C2DC2C813D8593F3")
    public ASN1SequenceParser parser() {
        ASN1SequenceParser varB4EAC82CA7396A68D541C85D26508E83_68119161 = null; //Variable for return #1
        ASN1Sequence outer;
        outer = this;
        varB4EAC82CA7396A68D541C85D26508E83_68119161 = new ASN1SequenceParser()
        {
            private final int max = size();
            private int index;
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
            public DERObject getLoadedObject()
            {
                return outer;
            }
            public DERObject getDERObject()
            {
                return outer;
            }
        };
        varB4EAC82CA7396A68D541C85D26508E83_68119161.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_68119161;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.780 -0400", hash_original_method = "09A8CA93ED2ECABA19E96E21E19C2A5D", hash_generated_method = "3C411B99112326623B89512F512E3648")
    public DEREncodable getObjectAt(
        int index) {
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_530571147 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_530571147 = (DEREncodable)seq.elementAt(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_530571147.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_530571147;
        // ---------- Original Method ----------
        //return (DEREncodable)seq.elementAt(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.780 -0400", hash_original_method = "18AB5743B6289573A8FB502D4D80C9A6", hash_generated_method = "A00E1CAEA6A1B0636BB04E594D45A182")
    public int size() {
        int var7B54241EFA3F9F49831EFA84564E4B16_1400662787 = (seq.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1331758776 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1331758776;
        // ---------- Original Method ----------
        //return seq.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.783 -0400", hash_original_method = "169312DEA8D054B4F83730CF694439C2", hash_generated_method = "7820569B065436A489AC4A67E224F97B")
    public int hashCode() {
        Enumeration e;
        e = this.getObjects();
        int hashCode;
        hashCode = size();
        {
            boolean var3EB0A96682EDBE15308427BAC1EC4A4E_815851147 = (e.hasMoreElements());
            {
                Object o;
                o = getNext(e);
                hashCode *= 17;
                hashCode ^= o.hashCode();
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1513287803 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1513287803;
        // ---------- Original Method ----------
        //Enumeration             e = this.getObjects();
        //int                     hashCode = size();
        //while (e.hasMoreElements())
        //{
            //Object o = getNext(e);
            //hashCode *= 17;
            //hashCode ^= o.hashCode();
        //}
        //return hashCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.784 -0400", hash_original_method = "736827C8F8F39EC68A9619F02A5000FC", hash_generated_method = "4F4A653E4EB089A72F6DDCB2C921D020")
     boolean asn1Equals(
        DERObject  o) {
        ASN1Sequence other;
        other = (ASN1Sequence)o;
        {
            boolean var2C133262A01F5383D21713B37E6EF923_1988576534 = (this.size() != other.size());
        } //End collapsed parenthetic
        Enumeration s1;
        s1 = this.getObjects();
        Enumeration s2;
        s2 = other.getObjects();
        {
            boolean var4BBE26B6E7A98E9534A54097D058E29F_1705680001 = (s1.hasMoreElements());
            {
                DEREncodable obj1;
                obj1 = getNext(s1);
                DEREncodable obj2;
                obj2 = getNext(s2);
                DERObject o1;
                o1 = obj1.getDERObject();
                DERObject o2;
                o2 = obj2.getDERObject();
                {
                    boolean varAB9C9B0E876B284A03745A0C6408523A_1513473122 = (o1 == o2 || o1.equals(o2));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2046497438 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2046497438;
        // ---------- Original Method ----------
        //if (!(o instanceof ASN1Sequence))
        //{
            //return false;
        //}
        //ASN1Sequence   other = (ASN1Sequence)o;
        //if (this.size() != other.size())
        //{
            //return false;
        //}
        //Enumeration s1 = this.getObjects();
        //Enumeration s2 = other.getObjects();
        //while (s1.hasMoreElements())
        //{
            //DEREncodable  obj1 = getNext(s1);
            //DEREncodable  obj2 = getNext(s2);
            //DERObject  o1 = obj1.getDERObject();
            //DERObject  o2 = obj2.getDERObject();
            //if (o1 == o2 || o1.equals(o2))
            //{
                //continue;
            //}
            //return false;
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.796 -0400", hash_original_method = "A69C6C665FC9D3DE250A324544079C85", hash_generated_method = "114F6B6482ED2A4B11A68E6585CB5AC8")
    private DEREncodable getNext(Enumeration e) {
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_903789008 = null; //Variable for return #1
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1221626423 = null; //Variable for return #2
        DEREncodable encObj;
        encObj = (DEREncodable)e.nextElement();
        {
            varB4EAC82CA7396A68D541C85D26508E83_903789008 = DERNull.INSTANCE;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1221626423 = encObj;
        addTaint(e.getTaint());
        DEREncodable varA7E53CE21691AB073D9660D615818899_805195668; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_805195668 = varB4EAC82CA7396A68D541C85D26508E83_903789008;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_805195668 = varB4EAC82CA7396A68D541C85D26508E83_1221626423;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_805195668.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_805195668;
        // ---------- Original Method ----------
        //DEREncodable encObj = (DEREncodable)e.nextElement();
        //if (encObj == null)
        //{
            //return DERNull.INSTANCE;
        //}
        //return encObj;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.796 -0400", hash_original_method = "FBD504B361191BF80361CE4D106B6193", hash_generated_method = "C53DBF0E150BB67AEEAF6ED219DEB177")
    protected void addObject(
        DEREncodable obj) {
        seq.addElement(obj);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //seq.addElement(obj);
    }

    
    abstract void encode(DEROutputStream out)
        throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.797 -0400", hash_original_method = "467BC9BFB84385F84F9590AA6DD6E2BE", hash_generated_method = "C6FB1FD8F63E9643F405D2F3CCC73229")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1116665497 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1116665497 = seq.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1116665497.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1116665497;
        // ---------- Original Method ----------
        //return seq.toString();
    }

    
}

