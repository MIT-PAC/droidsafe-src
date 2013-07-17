package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

public abstract class ASN1Sequence extends ASN1Object {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.775 -0400", hash_original_field = "393195A079C882476F3D5AA22C5A8674", hash_generated_field = "1C6134BBF67C6927627E9694230C698B")

    private Vector seq = new Vector();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.775 -0400", hash_original_method = "A2B39ADE0CCBD8FB2D75DB3228C401C7", hash_generated_method = "A2B39ADE0CCBD8FB2D75DB3228C401C7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.776 -0400", hash_original_method = "CC34A39B9814871A0958BEBA7EE6E2F9", hash_generated_method = "6CC9A6B1B42D3A3F7D4FAD0B85DC88D4")
    public Enumeration getObjects() {
Enumeration var6402A8306CC01C7C438AB9A6E14F53B6_721265775 =         seq.elements();
        var6402A8306CC01C7C438AB9A6E14F53B6_721265775.addTaint(taint);
        return var6402A8306CC01C7C438AB9A6E14F53B6_721265775;
        // ---------- Original Method ----------
        //return seq.elements();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.778 -0400", hash_original_method = "43ADC5A8CCFA8153E5DA918392680258", hash_generated_method = "688B3E7DD00954858DC6DB9A210BD8C5")
    public ASN1SequenceParser parser() {
        final ASN1Sequence outer = this;
ASN1SequenceParser varE723BAB1DECCC34402FAFCD6CCEC2AFA_488909682 =         new ASN1SequenceParser() {        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.776 -0400", hash_original_field = "AF8DE777B25121CBA56AF409B9C79B72", hash_generated_field = "D2E8168F8D49E25944D5BC65100B260E")
        private final int max = size();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.777 -0400", hash_original_field = "6A992D5529F459A44FEE58C733255E86", hash_generated_field = "56A277C77B76B31C1E1045C8C11CA802")
        private int index;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.777 -0400", hash_original_method = "BEBFD2E59C81385F3717CD5615389B19", hash_generated_method = "E1B6ECF0D9B82D5598CB3B5505EE03EC")
        public DEREncodable readObject() throws IOException {
            if(index == max)            
            {
DEREncodable var540C13E9E156B687226421B24F2DF178_894513918 =                 null;
                var540C13E9E156B687226421B24F2DF178_894513918.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_894513918;
            } //End block
            DEREncodable obj = getObjectAt(index++);
            if(obj instanceof ASN1Sequence)            
            {
DEREncodable var93B2F8DABA43E64C68B9390D8EFB94F8_1041147474 =                 ((ASN1Sequence)obj).parser();
                var93B2F8DABA43E64C68B9390D8EFB94F8_1041147474.addTaint(taint);
                return var93B2F8DABA43E64C68B9390D8EFB94F8_1041147474;
            } //End block
            if(obj instanceof ASN1Set)            
            {
DEREncodable varEFF9C9DFB6F10194B7C07F0F65838891_661632172 =                 ((ASN1Set)obj).parser();
                varEFF9C9DFB6F10194B7C07F0F65838891_661632172.addTaint(taint);
                return varEFF9C9DFB6F10194B7C07F0F65838891_661632172;
            } //End block
DEREncodable var2FDE1120F80AA4E8798ECDBDB1C0E85C_1694734405 =             obj;
            var2FDE1120F80AA4E8798ECDBDB1C0E85C_1694734405.addTaint(taint);
            return var2FDE1120F80AA4E8798ECDBDB1C0E85C_1694734405;
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.777 -0400", hash_original_method = "D852EEAF1DA4AF081125D411C2A8F904", hash_generated_method = "122E8A36451112778C63B73E94D842D4")
        public DERObject getLoadedObject() {
DERObject var9F6A5CC5D0E8FDBA0198C27DF56526D2_2023305039 =             outer;
            var9F6A5CC5D0E8FDBA0198C27DF56526D2_2023305039.addTaint(taint);
            return var9F6A5CC5D0E8FDBA0198C27DF56526D2_2023305039;
            // ---------- Original Method ----------
            //return outer;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.777 -0400", hash_original_method = "4FE555C2610E9C432E83EB0CA479A77A", hash_generated_method = "304D8E9F1A4D2ECF8A4ABFE251237D64")
        public DERObject getDERObject() {
DERObject var9F6A5CC5D0E8FDBA0198C27DF56526D2_1793505502 =             outer;
            var9F6A5CC5D0E8FDBA0198C27DF56526D2_1793505502.addTaint(taint);
            return var9F6A5CC5D0E8FDBA0198C27DF56526D2_1793505502;
            // ---------- Original Method ----------
            //return outer;
        }
};
        varE723BAB1DECCC34402FAFCD6CCEC2AFA_488909682.addTaint(taint);
        return varE723BAB1DECCC34402FAFCD6CCEC2AFA_488909682;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.778 -0400", hash_original_method = "09A8CA93ED2ECABA19E96E21E19C2A5D", hash_generated_method = "6D2AF6C93E8C7C5123AC4512BF9AA525")
    public DEREncodable getObjectAt(
        int index) {
        addTaint(index);
DEREncodable varD80E22438A65327AC831683B7CA408E3_1763743089 =         (DEREncodable)seq.elementAt(index);
        varD80E22438A65327AC831683B7CA408E3_1763743089.addTaint(taint);
        return varD80E22438A65327AC831683B7CA408E3_1763743089;
        // ---------- Original Method ----------
        //return (DEREncodable)seq.elementAt(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.779 -0400", hash_original_method = "18AB5743B6289573A8FB502D4D80C9A6", hash_generated_method = "510AD34A15C116F918E9CDD6C6101A7F")
    public int size() {
        int var5EFC25CE1E8361D0828BA092FBAD16A7_658499223 = (seq.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_198193795 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_198193795;
        // ---------- Original Method ----------
        //return seq.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.780 -0400", hash_original_method = "169312DEA8D054B4F83730CF694439C2", hash_generated_method = "D7F2D087E5F9F4161358281F3C34D236")
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
        int var550D1CC054A1B23A411DDDA46FD64811_1435731829 = (hashCode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1618926105 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1618926105;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.781 -0400", hash_original_method = "736827C8F8F39EC68A9619F02A5000FC", hash_generated_method = "ABB69871DF021FF0626D2DF77A89539E")
     boolean asn1Equals(
        DERObject  o) {
        addTaint(o.getTaint());
        if(!(o instanceof ASN1Sequence))        
        {
            boolean var68934A3E9455FA72420237EB05902327_345968863 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1215371638 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1215371638;
        } //End block
        ASN1Sequence other = (ASN1Sequence)o;
        if(this.size() != other.size())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1253630791 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_583559578 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_583559578;
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
            boolean var68934A3E9455FA72420237EB05902327_1358756842 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_237793313 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_237793313;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1313946012 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_18443688 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_18443688;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.782 -0400", hash_original_method = "A69C6C665FC9D3DE250A324544079C85", hash_generated_method = "79431ED0D7572E0FB0F87F072A0F4A05")
    private DEREncodable getNext(Enumeration e) {
        addTaint(e.getTaint());
        DEREncodable encObj = (DEREncodable)e.nextElement();
        if(encObj == null)        
        {
DEREncodable var1E3D3B7EF2DA7DB00405B805195FA465_708898018 =             DERNull.INSTANCE;
            var1E3D3B7EF2DA7DB00405B805195FA465_708898018.addTaint(taint);
            return var1E3D3B7EF2DA7DB00405B805195FA465_708898018;
        } //End block
DEREncodable var142E4525AFF6FB7F5C03BA975A3F000D_80569021 =         encObj;
        var142E4525AFF6FB7F5C03BA975A3F000D_80569021.addTaint(taint);
        return var142E4525AFF6FB7F5C03BA975A3F000D_80569021;
        // ---------- Original Method ----------
        //DEREncodable encObj = (DEREncodable)e.nextElement();
        //if (encObj == null)
        //{
            //return DERNull.INSTANCE;
        //}
        //return encObj;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.783 -0400", hash_original_method = "FBD504B361191BF80361CE4D106B6193", hash_generated_method = "3F9FC6976441C1CBDB636D332E2C8FA9")
    protected void addObject(
        DEREncodable obj) {
        addTaint(obj.getTaint());
        seq.addElement(obj);
        // ---------- Original Method ----------
        //seq.addElement(obj);
    }

    
    @DSModeled(DSC.SAFE)
    abstract void encode(DEROutputStream out)
        throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.783 -0400", hash_original_method = "467BC9BFB84385F84F9590AA6DD6E2BE", hash_generated_method = "E2CDFBE245FDBB1BC6EB6C22F7E6D07B")
    public String toString() {
String var43DF3944A9E5E6474F85343D56AB8D4F_1580012001 =         seq.toString();
        var43DF3944A9E5E6474F85343D56AB8D4F_1580012001.addTaint(taint);
        return var43DF3944A9E5E6474F85343D56AB8D4F_1580012001;
        // ---------- Original Method ----------
        //return seq.toString();
    }

    
    // orphaned legacy field
    private int index;
    
    // orphaned legacy field
    private final int max = size();
    
}

