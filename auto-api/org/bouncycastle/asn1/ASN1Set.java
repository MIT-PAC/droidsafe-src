package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

abstract public class ASN1Set extends ASN1Object {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.004 -0400", hash_original_field = "BDECEFA98886A378E1E58B7CE4D15A5D", hash_generated_field = "B61BB4FD9E03C235F8AEC9C8695ACDDC")

    protected Vector set = new Vector();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.004 -0400", hash_original_method = "565D53F8B19BD627340B9CF494B1B831", hash_generated_method = "A7A4698FFAA3E81DDA1516C3A63BE8D1")
    public  ASN1Set() {
        // ---------- Original Method ----------
    }

    
    public static ASN1Set getInstance(
        Object  obj) {
        if (obj == null || obj instanceof ASN1Set)
        {
            return (ASN1Set)obj;
        }
        throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
    }

    
    public static ASN1Set getInstance(
        ASN1TaggedObject    obj,
        boolean             explicit) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.006 -0400", hash_original_method = "393FBC2C672442D54683C7A8066AFBAA", hash_generated_method = "60817AFD4995BE7437F434CAEBA9D93B")
    public Enumeration getObjects() {
        Enumeration varB4EAC82CA7396A68D541C85D26508E83_2003814938 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2003814938 = set.elements();
        varB4EAC82CA7396A68D541C85D26508E83_2003814938.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2003814938;
        // ---------- Original Method ----------
        //return set.elements();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.006 -0400", hash_original_method = "2EC03929E91899921E681A1E59657958", hash_generated_method = "BDA47C5A0484AC48CEC7F6F950CE614C")
    public DEREncodable getObjectAt(
        int index) {
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1363956535 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1363956535 = (DEREncodable)set.elementAt(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1363956535.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1363956535;
        // ---------- Original Method ----------
        //return (DEREncodable)set.elementAt(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.007 -0400", hash_original_method = "283365B7154686D5E09A8541EE47F429", hash_generated_method = "EFCFA65A4FE4644CA24DEF8DB520FE8A")
    public int size() {
        int varEE5ADB60422E8329553BAF084BE43373_1200809596 = (set.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1774390248 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1774390248;
        // ---------- Original Method ----------
        //return set.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.009 -0400", hash_original_method = "D576BF738CB2D30F1DA36EF06815D882", hash_generated_method = "171639C06AE79181796D633D51A97049")
    public ASN1Encodable[] toArray() {
        ASN1Encodable[] varB4EAC82CA7396A68D541C85D26508E83_1199378695 = null; //Variable for return #1
        ASN1Encodable[] values = new ASN1Encodable[this.size()];
        {
            int i = 0;
            boolean varB5C33AE5876233CEC94BF3D22B0E7804_1653114636 = (i != this.size());
            {
                values[i] = (ASN1Encodable)this.getObjectAt(i);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1199378695 = values;
        varB4EAC82CA7396A68D541C85D26508E83_1199378695.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1199378695;
        // ---------- Original Method ----------
        //ASN1Encodable[] values = new ASN1Encodable[this.size()];
        //for (int i = 0; i != this.size(); i++)
        //{
            //values[i] = (ASN1Encodable)this.getObjectAt(i);
        //}
        //return values;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.011 -0400", hash_original_method = "3480E58BA04F290D4393ED7D48EF6B9C", hash_generated_method = "72DC5E95B4CE552AAF07734E364F4C38")
    public ASN1SetParser parser() {
        ASN1SetParser varB4EAC82CA7396A68D541C85D26508E83_1779838611 = null; //Variable for return #1
        final ASN1Set outer = this;
        varB4EAC82CA7396A68D541C85D26508E83_1779838611 = new ASN1SetParser()
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
        varB4EAC82CA7396A68D541C85D26508E83_1779838611.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1779838611;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.011 -0400", hash_original_method = "169312DEA8D054B4F83730CF694439C2", hash_generated_method = "DF21CABEEEEE242B3F6B01A7D7341611")
    public int hashCode() {
        Enumeration e = this.getObjects();
        int hashCode = size();
        {
            boolean var3EB0A96682EDBE15308427BAC1EC4A4E_657226856 = (e.hasMoreElements());
            {
                Object o = getNext(e);
                hashCode *= 17;
                hashCode ^= o.hashCode();
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1155782512 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1155782512;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.012 -0400", hash_original_method = "4061A2825C144C76460287466E375CA1", hash_generated_method = "3F389A2699FD1FC69AFD84BBE39842DE")
     boolean asn1Equals(
        DERObject  o) {
        ASN1Set other = (ASN1Set)o;
        {
            boolean var2C133262A01F5383D21713B37E6EF923_181679654 = (this.size() != other.size());
        } //End collapsed parenthetic
        Enumeration s1 = this.getObjects();
        Enumeration s2 = other.getObjects();
        {
            boolean var4BBE26B6E7A98E9534A54097D058E29F_643219534 = (s1.hasMoreElements());
            {
                DEREncodable obj1 = getNext(s1);
                DEREncodable obj2 = getNext(s2);
                DERObject o1 = obj1.getDERObject();
                DERObject o2 = obj2.getDERObject();
                {
                    boolean varAB9C9B0E876B284A03745A0C6408523A_1723902135 = (o1 == o2 || o1.equals(o2));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1381105664 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1381105664;
        // ---------- Original Method ----------
        //if (!(o instanceof ASN1Set))
        //{
            //return false;
        //}
        //ASN1Set   other = (ASN1Set)o;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.013 -0400", hash_original_method = "A69C6C665FC9D3DE250A324544079C85", hash_generated_method = "223F43E08B0585DAAD3317AA8B3B00C5")
    private DEREncodable getNext(Enumeration e) {
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_392685192 = null; //Variable for return #1
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1152269333 = null; //Variable for return #2
        DEREncodable encObj = (DEREncodable)e.nextElement();
        {
            varB4EAC82CA7396A68D541C85D26508E83_392685192 = DERNull.INSTANCE;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1152269333 = encObj;
        addTaint(e.getTaint());
        DEREncodable varA7E53CE21691AB073D9660D615818899_1426528375; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1426528375 = varB4EAC82CA7396A68D541C85D26508E83_392685192;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1426528375 = varB4EAC82CA7396A68D541C85D26508E83_1152269333;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1426528375.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1426528375;
        // ---------- Original Method ----------
        //DEREncodable encObj = (DEREncodable)e.nextElement();
        //if (encObj == null)
        //{
            //return DERNull.INSTANCE;
        //}
        //return encObj;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.013 -0400", hash_original_method = "207A76DA1E8D21F977EB59C485DCA4E9", hash_generated_method = "7243471A6CBD926F61811E6A3015E7C9")
    private boolean lessThanOrEqual(
         byte[] a,
         byte[] b) {
        int len = Math.min(a.length, b.length);
        {
            int i = 0;
        } //End collapsed parenthetic
        addTaint(a[0]);
        addTaint(b[0]);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_431327763 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_431327763;
        // ---------- Original Method ----------
        //int len = Math.min(a.length, b.length);
        //for (int i = 0; i != len; ++i)
        //{
            //if (a[i] != b[i])
            //{
                //return (a[i] & 0xff) < (b[i] & 0xff);
            //}
        //}
        //return len == a.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.014 -0400", hash_original_method = "522D47B99F0E20F7487ED5107F130A00", hash_generated_method = "BF2734111701FFA18781322E014E8CB8")
    private byte[] getEncoded(
        DEREncodable obj) {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        ASN1OutputStream aOut = new ASN1OutputStream(bOut);
        try 
        {
            aOut.writeObject(obj);
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("cannot encode object added to SET");
        } //End block
        byte[] var16BD2DDC58D2D23DE6338127D5E7BC71_889945585 = (bOut.toByteArray());
        addTaint(obj.getTaint());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1482883925 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1482883925;
        // ---------- Original Method ----------
        //ByteArrayOutputStream   bOut = new ByteArrayOutputStream();
        //ASN1OutputStream        aOut = new ASN1OutputStream(bOut);
        //try
        //{
            //aOut.writeObject(obj);
        //}
        //catch (IOException e)
        //{
            //throw new IllegalArgumentException("cannot encode object added to SET");
        //}
        //return bOut.toByteArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.015 -0400", hash_original_method = "8F80C00B71E62E5E32912D37725353DB", hash_generated_method = "4936DF0A7BD04E266DDACFD76F567163")
    protected void sort() {
        {
            boolean var4769D392C297D845B722A60E1E4F803D_730279903 = (set.size() > 1);
            {
                boolean swapped = true;
                int lastSwap = set.size() - 1;
                {
                    int index = 0;
                    int swapIndex = 0;
                    byte[] a = getEncoded((DEREncodable)set.elementAt(0));
                    swapped = false;
                    {
                        byte[] b = getEncoded((DEREncodable)set.elementAt(index + 1));
                        {
                            boolean varC6F2F84F5881D126CD75C2A94DC61371_444521113 = (lessThanOrEqual(a, b));
                            {
                                a = b;
                            } //End block
                            {
                                Object o = set.elementAt(index);
                                set.setElementAt(set.elementAt(index + 1), index);
                                set.setElementAt(o, index + 1);
                                swapped = true;
                                swapIndex = index;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    lastSwap = swapIndex;
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.015 -0400", hash_original_method = "DAE6351DB6B0C6C803835987F16403A5", hash_generated_method = "7CD2B6676E039FF74850EDBB44D63424")
    protected void addObject(
        DEREncodable obj) {
        set.addElement(obj);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //set.addElement(obj);
    }

    
    abstract void encode(DEROutputStream out)
            throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.016 -0400", hash_original_method = "41D154F65E4EBBCBC7C30CB48ECE000A", hash_generated_method = "153498D909E16CF9F3CFE22271ECCA7C")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_165602540 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_165602540 = set.toString();
        varB4EAC82CA7396A68D541C85D26508E83_165602540.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_165602540;
        // ---------- Original Method ----------
        //return set.toString();
    }

    
    // orphaned legacy method
    public DERObject getLoadedObject()
            {
                return outer;
            }
    
    // orphaned legacy method
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
    
    // orphaned legacy method
    public DERObject getDERObject()
            {
                return outer;
            }
    
    // orphaned legacy field
    private int index;
    
    // orphaned legacy field
    private final int max = size();
    
}

