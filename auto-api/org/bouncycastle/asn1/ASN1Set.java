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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.741 -0400", hash_original_field = "BDECEFA98886A378E1E58B7CE4D15A5D", hash_generated_field = "B61BB4FD9E03C235F8AEC9C8695ACDDC")

    protected Vector set = new Vector();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.741 -0400", hash_original_method = "565D53F8B19BD627340B9CF494B1B831", hash_generated_method = "A7A4698FFAA3E81DDA1516C3A63BE8D1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.753 -0400", hash_original_method = "393FBC2C672442D54683C7A8066AFBAA", hash_generated_method = "E32AD7A41C3DBD33DAA6C776CEA19746")
    public Enumeration getObjects() {
        Enumeration varB4EAC82CA7396A68D541C85D26508E83_2044715421 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2044715421 = set.elements();
        varB4EAC82CA7396A68D541C85D26508E83_2044715421.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2044715421;
        // ---------- Original Method ----------
        //return set.elements();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.753 -0400", hash_original_method = "2EC03929E91899921E681A1E59657958", hash_generated_method = "7098560154D75B5092AA258BFC24B8A3")
    public DEREncodable getObjectAt(
        int index) {
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1756865787 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1756865787 = (DEREncodable)set.elementAt(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1756865787.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1756865787;
        // ---------- Original Method ----------
        //return (DEREncodable)set.elementAt(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.753 -0400", hash_original_method = "283365B7154686D5E09A8541EE47F429", hash_generated_method = "ADBE38B2987211ABDEC0E9522766F3FF")
    public int size() {
        int varEE5ADB60422E8329553BAF084BE43373_2003731660 = (set.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_460200772 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_460200772;
        // ---------- Original Method ----------
        //return set.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.754 -0400", hash_original_method = "D576BF738CB2D30F1DA36EF06815D882", hash_generated_method = "F2B2F1192D559B6BE4775EBEC4D73098")
    public ASN1Encodable[] toArray() {
        ASN1Encodable[] varB4EAC82CA7396A68D541C85D26508E83_338708986 = null; //Variable for return #1
        ASN1Encodable[] values;
        values = new ASN1Encodable[this.size()];
        {
            int i;
            i = 0;
            boolean varB5C33AE5876233CEC94BF3D22B0E7804_1512894764 = (i != this.size());
            {
                values[i] = (ASN1Encodable)this.getObjectAt(i);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_338708986 = values;
        varB4EAC82CA7396A68D541C85D26508E83_338708986.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_338708986;
        // ---------- Original Method ----------
        //ASN1Encodable[] values = new ASN1Encodable[this.size()];
        //for (int i = 0; i != this.size(); i++)
        //{
            //values[i] = (ASN1Encodable)this.getObjectAt(i);
        //}
        //return values;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.755 -0400", hash_original_method = "3480E58BA04F290D4393ED7D48EF6B9C", hash_generated_method = "3B5F777DCF66948F18AE705BB88A2A57")
    public ASN1SetParser parser() {
        ASN1SetParser varB4EAC82CA7396A68D541C85D26508E83_159378735 = null; //Variable for return #1
        ASN1Set outer;
        outer = this;
        varB4EAC82CA7396A68D541C85D26508E83_159378735 = new ASN1SetParser()
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
        varB4EAC82CA7396A68D541C85D26508E83_159378735.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_159378735;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.756 -0400", hash_original_method = "169312DEA8D054B4F83730CF694439C2", hash_generated_method = "493715516D7BBC9BE860D94E3B6D7995")
    public int hashCode() {
        Enumeration e;
        e = this.getObjects();
        int hashCode;
        hashCode = size();
        {
            boolean var3EB0A96682EDBE15308427BAC1EC4A4E_1244201529 = (e.hasMoreElements());
            {
                Object o;
                o = getNext(e);
                hashCode *= 17;
                hashCode ^= o.hashCode();
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1695407784 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1695407784;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.757 -0400", hash_original_method = "4061A2825C144C76460287466E375CA1", hash_generated_method = "AD6F37B847A58DDBBD97EE2C997B0A92")
     boolean asn1Equals(
        DERObject  o) {
        ASN1Set other;
        other = (ASN1Set)o;
        {
            boolean var2C133262A01F5383D21713B37E6EF923_409711159 = (this.size() != other.size());
        } //End collapsed parenthetic
        Enumeration s1;
        s1 = this.getObjects();
        Enumeration s2;
        s2 = other.getObjects();
        {
            boolean var4BBE26B6E7A98E9534A54097D058E29F_299346455 = (s1.hasMoreElements());
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
                    boolean varAB9C9B0E876B284A03745A0C6408523A_76782995 = (o1 == o2 || o1.equals(o2));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1488913577 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1488913577;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.762 -0400", hash_original_method = "A69C6C665FC9D3DE250A324544079C85", hash_generated_method = "DBCFD452ECA407868F47E005479DCD00")
    private DEREncodable getNext(Enumeration e) {
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_846113633 = null; //Variable for return #1
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_163424169 = null; //Variable for return #2
        DEREncodable encObj;
        encObj = (DEREncodable)e.nextElement();
        {
            varB4EAC82CA7396A68D541C85D26508E83_846113633 = DERNull.INSTANCE;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_163424169 = encObj;
        addTaint(e.getTaint());
        DEREncodable varA7E53CE21691AB073D9660D615818899_446453670; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_446453670 = varB4EAC82CA7396A68D541C85D26508E83_846113633;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_446453670 = varB4EAC82CA7396A68D541C85D26508E83_163424169;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_446453670.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_446453670;
        // ---------- Original Method ----------
        //DEREncodable encObj = (DEREncodable)e.nextElement();
        //if (encObj == null)
        //{
            //return DERNull.INSTANCE;
        //}
        //return encObj;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.762 -0400", hash_original_method = "207A76DA1E8D21F977EB59C485DCA4E9", hash_generated_method = "E2960897B8B0543CBD2569EF62219B95")
    private boolean lessThanOrEqual(
         byte[] a,
         byte[] b) {
        int len;
        len = Math.min(a.length, b.length);
        {
            int i;
            i = 0;
        } //End collapsed parenthetic
        addTaint(a[0]);
        addTaint(b[0]);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2014955076 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2014955076;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.762 -0400", hash_original_method = "522D47B99F0E20F7487ED5107F130A00", hash_generated_method = "32F6005C1C0ED6ECFA17990E85AB27C7")
    private byte[] getEncoded(
        DEREncodable obj) {
        ByteArrayOutputStream bOut;
        bOut = new ByteArrayOutputStream();
        ASN1OutputStream aOut;
        aOut = new ASN1OutputStream(bOut);
        try 
        {
            aOut.writeObject(obj);
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("cannot encode object added to SET");
        } //End block
        byte[] var16BD2DDC58D2D23DE6338127D5E7BC71_1802969711 = (bOut.toByteArray());
        addTaint(obj.getTaint());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_923249721 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_923249721;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.763 -0400", hash_original_method = "8F80C00B71E62E5E32912D37725353DB", hash_generated_method = "256E4858694BC7CD670EA8C9F1FB51E8")
    protected void sort() {
        {
            boolean var4769D392C297D845B722A60E1E4F803D_453432609 = (set.size() > 1);
            {
                boolean swapped;
                swapped = true;
                int lastSwap;
                lastSwap = set.size() - 1;
                {
                    int index;
                    index = 0;
                    int swapIndex;
                    swapIndex = 0;
                    byte[] a;
                    a = getEncoded((DEREncodable)set.elementAt(0));
                    swapped = false;
                    {
                        byte[] b;
                        b = getEncoded((DEREncodable)set.elementAt(index + 1));
                        {
                            boolean varC6F2F84F5881D126CD75C2A94DC61371_941080345 = (lessThanOrEqual(a, b));
                            {
                                a = b;
                            } //End block
                            {
                                Object o;
                                o = set.elementAt(index);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.763 -0400", hash_original_method = "DAE6351DB6B0C6C803835987F16403A5", hash_generated_method = "7CD2B6676E039FF74850EDBB44D63424")
    protected void addObject(
        DEREncodable obj) {
        set.addElement(obj);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //set.addElement(obj);
    }

    
    abstract void encode(DEROutputStream out)
            throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.777 -0400", hash_original_method = "41D154F65E4EBBCBC7C30CB48ECE000A", hash_generated_method = "39BD1924D134E6B345C7FCF390D35C56")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1891283819 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1891283819 = set.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1891283819.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1891283819;
        // ---------- Original Method ----------
        //return set.toString();
    }

    
}

