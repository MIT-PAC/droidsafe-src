package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

public abstract class ASN1Sequence extends ASN1Object {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.653 -0400", hash_original_field = "393195A079C882476F3D5AA22C5A8674", hash_generated_field = "1C6134BBF67C6927627E9694230C698B")

    private Vector seq = new Vector();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.653 -0400", hash_original_method = "A2B39ADE0CCBD8FB2D75DB3228C401C7", hash_generated_method = "A2B39ADE0CCBD8FB2D75DB3228C401C7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.654 -0400", hash_original_method = "CC34A39B9814871A0958BEBA7EE6E2F9", hash_generated_method = "633B7AD35F9AB6839D2947B3D704D42B")
    public Enumeration getObjects() {
Enumeration var6402A8306CC01C7C438AB9A6E14F53B6_197654340 =         seq.elements();
        var6402A8306CC01C7C438AB9A6E14F53B6_197654340.addTaint(taint);
        return var6402A8306CC01C7C438AB9A6E14F53B6_197654340;
        // ---------- Original Method ----------
        //return seq.elements();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.656 -0400", hash_original_method = "43ADC5A8CCFA8153E5DA918392680258", hash_generated_method = "12C236568524CADE4CE4ED024A9719CB")
    public ASN1SequenceParser parser() {
        final ASN1Sequence outer = this;
ASN1SequenceParser varE723BAB1DECCC34402FAFCD6CCEC2AFA_655481868 =         new ASN1SequenceParser() {        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.654 -0400", hash_original_field = "AF8DE777B25121CBA56AF409B9C79B72", hash_generated_field = "D2E8168F8D49E25944D5BC65100B260E")
        private final int max = size();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.654 -0400", hash_original_field = "6A992D5529F459A44FEE58C733255E86", hash_generated_field = "56A277C77B76B31C1E1045C8C11CA802")
        private int index;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.655 -0400", hash_original_method = "BEBFD2E59C81385F3717CD5615389B19", hash_generated_method = "ADC050E8B036EB3EE7B17737BD7559A4")
        public DEREncodable readObject() throws IOException {
    if(index == max)            
            {
DEREncodable var540C13E9E156B687226421B24F2DF178_243144688 =                 null;
                var540C13E9E156B687226421B24F2DF178_243144688.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_243144688;
            } //End block
            DEREncodable obj = getObjectAt(index++);
    if(obj instanceof ASN1Sequence)            
            {
DEREncodable var93B2F8DABA43E64C68B9390D8EFB94F8_1608650368 =                 ((ASN1Sequence)obj).parser();
                var93B2F8DABA43E64C68B9390D8EFB94F8_1608650368.addTaint(taint);
                return var93B2F8DABA43E64C68B9390D8EFB94F8_1608650368;
            } //End block
    if(obj instanceof ASN1Set)            
            {
DEREncodable varEFF9C9DFB6F10194B7C07F0F65838891_1123120619 =                 ((ASN1Set)obj).parser();
                varEFF9C9DFB6F10194B7C07F0F65838891_1123120619.addTaint(taint);
                return varEFF9C9DFB6F10194B7C07F0F65838891_1123120619;
            } //End block
DEREncodable var2FDE1120F80AA4E8798ECDBDB1C0E85C_384827481 =             obj;
            var2FDE1120F80AA4E8798ECDBDB1C0E85C_384827481.addTaint(taint);
            return var2FDE1120F80AA4E8798ECDBDB1C0E85C_384827481;
            // ---------- Original Method ----------
            //if (index == max)
                //{
                    //return null;
                //}
            //DEREncodable obj = getObjectAt(index++);
            //if (obj instanceof ASN1Sequence)
                //{
                    //return ((ASN1Sequence)obj).parser();
                //}
            //if (obj instanceof ASN1Set)
                //{
                    //return ((ASN1Set)obj).parser();
                //}
            //return obj;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.655 -0400", hash_original_method = "D852EEAF1DA4AF081125D411C2A8F904", hash_generated_method = "451CC45967EF455D9553D95222EBA9F3")
        public DERObject getLoadedObject() {
DERObject var9F6A5CC5D0E8FDBA0198C27DF56526D2_1740537942 =             outer;
            var9F6A5CC5D0E8FDBA0198C27DF56526D2_1740537942.addTaint(taint);
            return var9F6A5CC5D0E8FDBA0198C27DF56526D2_1740537942;
            // ---------- Original Method ----------
            //return outer;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.655 -0400", hash_original_method = "4FE555C2610E9C432E83EB0CA479A77A", hash_generated_method = "B145802BBE2C2412EAB00CAD30AA48F8")
        public DERObject getDERObject() {
DERObject var9F6A5CC5D0E8FDBA0198C27DF56526D2_232400701 =             outer;
            var9F6A5CC5D0E8FDBA0198C27DF56526D2_232400701.addTaint(taint);
            return var9F6A5CC5D0E8FDBA0198C27DF56526D2_232400701;
            // ---------- Original Method ----------
            //return outer;
        }
};
        varE723BAB1DECCC34402FAFCD6CCEC2AFA_655481868.addTaint(taint);
        return varE723BAB1DECCC34402FAFCD6CCEC2AFA_655481868;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.656 -0400", hash_original_method = "09A8CA93ED2ECABA19E96E21E19C2A5D", hash_generated_method = "FF87C34F2B850A4E5E42447838EBF887")
    public DEREncodable getObjectAt(
        int index) {
        addTaint(index);
DEREncodable varD80E22438A65327AC831683B7CA408E3_2065308160 =         (DEREncodable)seq.elementAt(index);
        varD80E22438A65327AC831683B7CA408E3_2065308160.addTaint(taint);
        return varD80E22438A65327AC831683B7CA408E3_2065308160;
        // ---------- Original Method ----------
        //return (DEREncodable)seq.elementAt(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.656 -0400", hash_original_method = "18AB5743B6289573A8FB502D4D80C9A6", hash_generated_method = "D124AC85C558D8608D94E5CC98FB7C44")
    public int size() {
        int var5EFC25CE1E8361D0828BA092FBAD16A7_455411983 = (seq.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1516368322 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1516368322;
        // ---------- Original Method ----------
        //return seq.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.657 -0400", hash_original_method = "169312DEA8D054B4F83730CF694439C2", hash_generated_method = "35F0F4A895051FFDC519E2803D67C0E2")
    public int hashCode() {
        Enumeration e = this.getObjects();
        int hashCode = size();
        while
(e.hasMoreElements())        
        {
            Object o = getNext(e);
            hashCode *= 17;
            hashCode ^= o.hashCode();
        } //End block
        int var550D1CC054A1B23A411DDDA46FD64811_718334558 = (hashCode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1437708511 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1437708511;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.658 -0400", hash_original_method = "736827C8F8F39EC68A9619F02A5000FC", hash_generated_method = "FF3B700B24E674A06DBCFC59B28AF7FE")
     boolean asn1Equals(
        DERObject  o) {
        addTaint(o.getTaint());
    if(!(o instanceof ASN1Sequence))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1158840792 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_113918737 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_113918737;
        } //End block
        ASN1Sequence other = (ASN1Sequence)o;
    if(this.size() != other.size())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1173127391 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1036887336 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1036887336;
        } //End block
        Enumeration s1 = this.getObjects();
        Enumeration s2 = other.getObjects();
        while
(s1.hasMoreElements())        
        {
            DEREncodable obj1 = getNext(s1);
            DEREncodable obj2 = getNext(s2);
            DERObject o1 = obj1.getDERObject();
            DERObject o2 = obj2.getDERObject();
    if(o1 == o2 || o1.equals(o2))            
            {
                continue;
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_1766620340 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_359080032 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_359080032;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1665287023 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_237205400 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_237205400;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.659 -0400", hash_original_method = "A69C6C665FC9D3DE250A324544079C85", hash_generated_method = "01BC97E0A9D390C7E7C73AC5401EDEE9")
    private DEREncodable getNext(Enumeration e) {
        addTaint(e.getTaint());
        DEREncodable encObj = (DEREncodable)e.nextElement();
    if(encObj == null)        
        {
DEREncodable var1E3D3B7EF2DA7DB00405B805195FA465_1525506141 =             DERNull.INSTANCE;
            var1E3D3B7EF2DA7DB00405B805195FA465_1525506141.addTaint(taint);
            return var1E3D3B7EF2DA7DB00405B805195FA465_1525506141;
        } //End block
DEREncodable var142E4525AFF6FB7F5C03BA975A3F000D_591508489 =         encObj;
        var142E4525AFF6FB7F5C03BA975A3F000D_591508489.addTaint(taint);
        return var142E4525AFF6FB7F5C03BA975A3F000D_591508489;
        // ---------- Original Method ----------
        //DEREncodable encObj = (DEREncodable)e.nextElement();
        //if (encObj == null)
        //{
            //return DERNull.INSTANCE;
        //}
        //return encObj;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.660 -0400", hash_original_method = "FBD504B361191BF80361CE4D106B6193", hash_generated_method = "3F9FC6976441C1CBDB636D332E2C8FA9")
    protected void addObject(
        DEREncodable obj) {
        addTaint(obj.getTaint());
        seq.addElement(obj);
        // ---------- Original Method ----------
        //seq.addElement(obj);
    }

    
    abstract void encode(DEROutputStream out)
        throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.661 -0400", hash_original_method = "467BC9BFB84385F84F9590AA6DD6E2BE", hash_generated_method = "0B72FC77F03E7A655AAA0B3976DA9F2E")
    public String toString() {
String var43DF3944A9E5E6474F85343D56AB8D4F_1006346644 =         seq.toString();
        var43DF3944A9E5E6474F85343D56AB8D4F_1006346644.addTaint(taint);
        return var43DF3944A9E5E6474F85343D56AB8D4F_1006346644;
        // ---------- Original Method ----------
        //return seq.toString();
    }

    
    // orphaned legacy field
    private int index;
    
    // orphaned legacy field
    private final int max = size();
    
}

