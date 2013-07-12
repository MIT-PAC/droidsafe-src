package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

abstract public class ASN1Set extends ASN1Object {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.687 -0400", hash_original_field = "BDECEFA98886A378E1E58B7CE4D15A5D", hash_generated_field = "B61BB4FD9E03C235F8AEC9C8695ACDDC")

    protected Vector set = new Vector();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.688 -0400", hash_original_method = "565D53F8B19BD627340B9CF494B1B831", hash_generated_method = "A7A4698FFAA3E81DDA1516C3A63BE8D1")
    public  ASN1Set() {
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.689 -0400", hash_original_method = "393FBC2C672442D54683C7A8066AFBAA", hash_generated_method = "22408FA4AEB14BAF5048EC2D22C45A65")
    public Enumeration getObjects() {
Enumeration varA1727DEC63199D9B4CED8021F1EF3128_2084691083 =         set.elements();
        varA1727DEC63199D9B4CED8021F1EF3128_2084691083.addTaint(taint);
        return varA1727DEC63199D9B4CED8021F1EF3128_2084691083;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.689 -0400", hash_original_method = "2EC03929E91899921E681A1E59657958", hash_generated_method = "302FC4DE49E73058FE0748E2CD98F7EF")
    public DEREncodable getObjectAt(
        int index) {
        addTaint(index);
DEREncodable var6CD5E39B7034494BC59B1A7630973DF6_1547332896 =         (DEREncodable)set.elementAt(index);
        var6CD5E39B7034494BC59B1A7630973DF6_1547332896.addTaint(taint);
        return var6CD5E39B7034494BC59B1A7630973DF6_1547332896;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.689 -0400", hash_original_method = "283365B7154686D5E09A8541EE47F429", hash_generated_method = "1F68B017594BD31E42CD6C4544B2F4A3")
    public int size() {
        int varC11C5BB059CE54FB66F4294B0D28BA2A_1690840946 = (set.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_521421668 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_521421668;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.690 -0400", hash_original_method = "D576BF738CB2D30F1DA36EF06815D882", hash_generated_method = "472B3035BF7FDF04027BFEE8A3914E94")
    public ASN1Encodable[] toArray() {
        ASN1Encodable[] values = new ASN1Encodable[this.size()];
for(int i = 0;i != this.size();i++)
        {
            values[i] = (ASN1Encodable)this.getObjectAt(i);
        } 
ASN1Encodable[] var674B10C763DBAAF9696AD9A3DDAE07B3_548331865 =         values;
        var674B10C763DBAAF9696AD9A3DDAE07B3_548331865.addTaint(taint);
        return var674B10C763DBAAF9696AD9A3DDAE07B3_548331865;
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.692 -0400", hash_original_method = "3480E58BA04F290D4393ED7D48EF6B9C", hash_generated_method = "F7B5C823E8E221243D3AABF608BFC336")
    public ASN1SetParser parser() {
        final ASN1Set outer = this;
ASN1SetParser varFEF15DF2C04179BD8EB2593AF5B49D65_2077366615 =         new ASN1SetParser() {        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.691 -0400", hash_original_field = "AF8DE777B25121CBA56AF409B9C79B72", hash_generated_field = "D2E8168F8D49E25944D5BC65100B260E")
        private final int max = size();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.691 -0400", hash_original_field = "6A992D5529F459A44FEE58C733255E86", hash_generated_field = "56A277C77B76B31C1E1045C8C11CA802")
        private int index;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.691 -0400", hash_original_method = "BEBFD2E59C81385F3717CD5615389B19", hash_generated_method = "36CB6BE9726A1F5B3FAE95C17300C10D")
        public DEREncodable readObject() throws IOException {
    if(index == max)            
            {
DEREncodable var540C13E9E156B687226421B24F2DF178_779574794 =                 null;
                var540C13E9E156B687226421B24F2DF178_779574794.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_779574794;
            } 
            DEREncodable obj = getObjectAt(index++);
    if(obj instanceof ASN1Sequence)            
            {
DEREncodable var93B2F8DABA43E64C68B9390D8EFB94F8_1603028295 =                 ((ASN1Sequence)obj).parser();
                var93B2F8DABA43E64C68B9390D8EFB94F8_1603028295.addTaint(taint);
                return var93B2F8DABA43E64C68B9390D8EFB94F8_1603028295;
            } 
    if(obj instanceof ASN1Set)            
            {
DEREncodable varEFF9C9DFB6F10194B7C07F0F65838891_1790945859 =                 ((ASN1Set)obj).parser();
                varEFF9C9DFB6F10194B7C07F0F65838891_1790945859.addTaint(taint);
                return varEFF9C9DFB6F10194B7C07F0F65838891_1790945859;
            } 
DEREncodable var2FDE1120F80AA4E8798ECDBDB1C0E85C_1931793912 =             obj;
            var2FDE1120F80AA4E8798ECDBDB1C0E85C_1931793912.addTaint(taint);
            return var2FDE1120F80AA4E8798ECDBDB1C0E85C_1931793912;
            
            
                
                    
                
            
            
                
                    
                
            
                
                    
                
            
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.691 -0400", hash_original_method = "D852EEAF1DA4AF081125D411C2A8F904", hash_generated_method = "6D87C593B7E5E5575B839126FA0EEDBA")
        public DERObject getLoadedObject() {
DERObject var9F6A5CC5D0E8FDBA0198C27DF56526D2_1089184725 =             outer;
            var9F6A5CC5D0E8FDBA0198C27DF56526D2_1089184725.addTaint(taint);
            return var9F6A5CC5D0E8FDBA0198C27DF56526D2_1089184725;
            
            
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.692 -0400", hash_original_method = "4FE555C2610E9C432E83EB0CA479A77A", hash_generated_method = "90EADD340ACAF17CC0CF440ED8677A5D")
        public DERObject getDERObject() {
DERObject var9F6A5CC5D0E8FDBA0198C27DF56526D2_1701115850 =             outer;
            var9F6A5CC5D0E8FDBA0198C27DF56526D2_1701115850.addTaint(taint);
            return var9F6A5CC5D0E8FDBA0198C27DF56526D2_1701115850;
            
            
        }
};
        varFEF15DF2C04179BD8EB2593AF5B49D65_2077366615.addTaint(taint);
        return varFEF15DF2C04179BD8EB2593AF5B49D65_2077366615;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.692 -0400", hash_original_method = "169312DEA8D054B4F83730CF694439C2", hash_generated_method = "94165174A2F46D51AE15E67FC9733D14")
    public int hashCode() {
        Enumeration e = this.getObjects();
        int hashCode = size();
        while
(e.hasMoreElements())        
        {
            Object o = getNext(e);
            hashCode *= 17;
            hashCode ^= o.hashCode();
        } 
        int var550D1CC054A1B23A411DDDA46FD64811_1261259872 = (hashCode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1290094285 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1290094285;
        
        
        
        
        
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.693 -0400", hash_original_method = "4061A2825C144C76460287466E375CA1", hash_generated_method = "51CD69B38C4C9C563DBA937C9A355C81")
     boolean asn1Equals(
        DERObject  o) {
        addTaint(o.getTaint());
    if(!(o instanceof ASN1Set))        
        {
            boolean var68934A3E9455FA72420237EB05902327_710085995 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2050774289 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2050774289;
        } 
        ASN1Set other = (ASN1Set)o;
    if(this.size() != other.size())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1810262193 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1689403947 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1689403947;
        } 
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
            } 
            boolean var68934A3E9455FA72420237EB05902327_484525516 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_303901819 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_303901819;
        } 
        boolean varB326B5062B2F0E69046810717534CB09_1085249196 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1970919590 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1970919590;
        
        
        
            
        
        
        
        
            
        
        
        
        
        
            
            
            
            
            
            
                
            
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.694 -0400", hash_original_method = "A69C6C665FC9D3DE250A324544079C85", hash_generated_method = "262AB73FFC64AA0C364D4039324AEF62")
    private DEREncodable getNext(Enumeration e) {
        addTaint(e.getTaint());
        DEREncodable encObj = (DEREncodable)e.nextElement();
    if(encObj == null)        
        {
DEREncodable var1E3D3B7EF2DA7DB00405B805195FA465_968593791 =             DERNull.INSTANCE;
            var1E3D3B7EF2DA7DB00405B805195FA465_968593791.addTaint(taint);
            return var1E3D3B7EF2DA7DB00405B805195FA465_968593791;
        } 
DEREncodable var142E4525AFF6FB7F5C03BA975A3F000D_1901256887 =         encObj;
        var142E4525AFF6FB7F5C03BA975A3F000D_1901256887.addTaint(taint);
        return var142E4525AFF6FB7F5C03BA975A3F000D_1901256887;
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.694 -0400", hash_original_method = "207A76DA1E8D21F977EB59C485DCA4E9", hash_generated_method = "3B4490DCEEC0B899D6E0F2CAD2A18B45")
    private boolean lessThanOrEqual(
         byte[] a,
         byte[] b) {
        addTaint(b[0]);
        addTaint(a[0]);
        int len = Math.min(a.length, b.length);
for(int i = 0;i != len;++i)
        {
    if(a[i] != b[i])            
            {
                boolean var97F166E1B0A1C80CD24C5F8B485204EE_1409381112 = ((a[i] & 0xff) < (b[i] & 0xff));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1314465580 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1314465580;
            } 
        } 
        boolean var96A6477DE9BDA92A5D66BD7039452F9D_590555648 = (len == a.length);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_26962665 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_26962665;
        
        
        
        
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.695 -0400", hash_original_method = "522D47B99F0E20F7487ED5107F130A00", hash_generated_method = "6499BF8F29715FCB1B23DA031DE75AD9")
    private byte[] getEncoded(
        DEREncodable obj) {
        addTaint(obj.getTaint());
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        ASN1OutputStream aOut = new ASN1OutputStream(bOut);
        try 
        {
            aOut.writeObject(obj);
        } 
        catch (IOException e)
        {
            IllegalArgumentException var9D6BA3DFDD07A4AE4FED53269D6A12A6_1861375604 = new IllegalArgumentException("cannot encode object added to SET");
            var9D6BA3DFDD07A4AE4FED53269D6A12A6_1861375604.addTaint(taint);
            throw var9D6BA3DFDD07A4AE4FED53269D6A12A6_1861375604;
        } 
        byte[] varFBF1B634B1C8DDF7D794A26F16D73A6E_507802721 = (bOut.toByteArray());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_284110932 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_284110932;
        
        
        
        
        
            
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.697 -0400", hash_original_method = "8F80C00B71E62E5E32912D37725353DB", hash_generated_method = "FAA0CDC049B2068ABCDF4C48CCC7FCDE")
    protected void sort() {
    if(set.size() > 1)        
        {
            boolean swapped = true;
            int lastSwap = set.size() - 1;
            while
(swapped)            
            {
                int index = 0;
                int swapIndex = 0;
                byte[] a = getEncoded((DEREncodable)set.elementAt(0));
                swapped = false;
                while
(index != lastSwap)                
                {
                    byte[] b = getEncoded((DEREncodable)set.elementAt(index + 1));
    if(lessThanOrEqual(a, b))                    
                    {
                        a = b;
                    } 
                    else
                    {
                        Object o = set.elementAt(index);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.697 -0400", hash_original_method = "DAE6351DB6B0C6C803835987F16403A5", hash_generated_method = "8D039727FFFA6ADBE9EB04B451631A9F")
    protected void addObject(
        DEREncodable obj) {
        addTaint(obj.getTaint());
        set.addElement(obj);
        
        
    }

    
    abstract void encode(DEROutputStream out)
            throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.698 -0400", hash_original_method = "41D154F65E4EBBCBC7C30CB48ECE000A", hash_generated_method = "BE3E17D42432F88731C843741E1B2460")
    public String toString() {
String varD9E92111BC211C24F86F9BA2DDF44C5C_885377064 =         set.toString();
        varD9E92111BC211C24F86F9BA2DDF44C5C_885377064.addTaint(taint);
        return varD9E92111BC211C24F86F9BA2DDF44C5C_885377064;
        
        
    }

    
    
    private int index;
    
    
    private final int max = size();
    
}

