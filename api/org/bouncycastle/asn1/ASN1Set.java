package org.bouncycastle.asn1;

// Droidsafe Imports
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

abstract public class ASN1Set extends ASN1Object {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.816 -0400", hash_original_field = "BDECEFA98886A378E1E58B7CE4D15A5D", hash_generated_field = "B61BB4FD9E03C235F8AEC9C8695ACDDC")

    protected Vector set = new Vector();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.816 -0400", hash_original_method = "565D53F8B19BD627340B9CF494B1B831", hash_generated_method = "A7A4698FFAA3E81DDA1516C3A63BE8D1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.817 -0400", hash_original_method = "393FBC2C672442D54683C7A8066AFBAA", hash_generated_method = "73020A4D8051ED985A5FF8754510636E")
    public Enumeration getObjects() {
Enumeration varA1727DEC63199D9B4CED8021F1EF3128_2064756083 =         set.elements();
        varA1727DEC63199D9B4CED8021F1EF3128_2064756083.addTaint(taint);
        return varA1727DEC63199D9B4CED8021F1EF3128_2064756083;
        // ---------- Original Method ----------
        //return set.elements();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.817 -0400", hash_original_method = "2EC03929E91899921E681A1E59657958", hash_generated_method = "A1B7584111E71B2D0CE32A7D2EB6BE5D")
    public DEREncodable getObjectAt(
        int index) {
        addTaint(index);
DEREncodable var6CD5E39B7034494BC59B1A7630973DF6_328326539 =         (DEREncodable)set.elementAt(index);
        var6CD5E39B7034494BC59B1A7630973DF6_328326539.addTaint(taint);
        return var6CD5E39B7034494BC59B1A7630973DF6_328326539;
        // ---------- Original Method ----------
        //return (DEREncodable)set.elementAt(index);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.817 -0400", hash_original_method = "283365B7154686D5E09A8541EE47F429", hash_generated_method = "5216EA15E9D75E14B71A5D38E591A2EC")
    public int size() {
        int varC11C5BB059CE54FB66F4294B0D28BA2A_1803723837 = (set.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_590679516 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_590679516;
        // ---------- Original Method ----------
        //return set.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.818 -0400", hash_original_method = "D576BF738CB2D30F1DA36EF06815D882", hash_generated_method = "CF6AE514DC44402A47B03CFDE2F4AAB7")
    public ASN1Encodable[] toArray() {
        ASN1Encodable[] values = new ASN1Encodable[this.size()];
for(int i = 0;i != this.size();i++)
        {
            values[i] = (ASN1Encodable)this.getObjectAt(i);
        } //End block
ASN1Encodable[] var674B10C763DBAAF9696AD9A3DDAE07B3_1245713984 =         values;
        var674B10C763DBAAF9696AD9A3DDAE07B3_1245713984.addTaint(taint);
        return var674B10C763DBAAF9696AD9A3DDAE07B3_1245713984;
        // ---------- Original Method ----------
        //ASN1Encodable[] values = new ASN1Encodable[this.size()];
        //for (int i = 0; i != this.size(); i++)
        //{
            //values[i] = (ASN1Encodable)this.getObjectAt(i);
        //}
        //return values;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.820 -0400", hash_original_method = "3480E58BA04F290D4393ED7D48EF6B9C", hash_generated_method = "2F5149AE3B97380B1162AFD136050A12")
    public ASN1SetParser parser() {
        final ASN1Set outer = this;
ASN1SetParser varFEF15DF2C04179BD8EB2593AF5B49D65_1012881334 =         new ASN1SetParser() {        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.818 -0400", hash_original_field = "AF8DE777B25121CBA56AF409B9C79B72", hash_generated_field = "D2E8168F8D49E25944D5BC65100B260E")
        private final int max = size();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.819 -0400", hash_original_field = "6A992D5529F459A44FEE58C733255E86", hash_generated_field = "56A277C77B76B31C1E1045C8C11CA802")
        private int index;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.819 -0400", hash_original_method = "BEBFD2E59C81385F3717CD5615389B19", hash_generated_method = "8ECC569E47EB68AFEF8F3475ABFDF692")
        public DEREncodable readObject() throws IOException {
            if(index == max)            
            {
DEREncodable var540C13E9E156B687226421B24F2DF178_163012291 =                 null;
                var540C13E9E156B687226421B24F2DF178_163012291.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_163012291;
            } //End block
            DEREncodable obj = getObjectAt(index++);
            if(obj instanceof ASN1Sequence)            
            {
DEREncodable var93B2F8DABA43E64C68B9390D8EFB94F8_130212654 =                 ((ASN1Sequence)obj).parser();
                var93B2F8DABA43E64C68B9390D8EFB94F8_130212654.addTaint(taint);
                return var93B2F8DABA43E64C68B9390D8EFB94F8_130212654;
            } //End block
            if(obj instanceof ASN1Set)            
            {
DEREncodable varEFF9C9DFB6F10194B7C07F0F65838891_149718534 =                 ((ASN1Set)obj).parser();
                varEFF9C9DFB6F10194B7C07F0F65838891_149718534.addTaint(taint);
                return varEFF9C9DFB6F10194B7C07F0F65838891_149718534;
            } //End block
DEREncodable var2FDE1120F80AA4E8798ECDBDB1C0E85C_619864538 =             obj;
            var2FDE1120F80AA4E8798ECDBDB1C0E85C_619864538.addTaint(taint);
            return var2FDE1120F80AA4E8798ECDBDB1C0E85C_619864538;
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.819 -0400", hash_original_method = "D852EEAF1DA4AF081125D411C2A8F904", hash_generated_method = "5E84557BF792E93FB9DF3EDE82AC60AE")
        public DERObject getLoadedObject() {
DERObject var9F6A5CC5D0E8FDBA0198C27DF56526D2_479894625 =             outer;
            var9F6A5CC5D0E8FDBA0198C27DF56526D2_479894625.addTaint(taint);
            return var9F6A5CC5D0E8FDBA0198C27DF56526D2_479894625;
            // ---------- Original Method ----------
            //return outer;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.820 -0400", hash_original_method = "4FE555C2610E9C432E83EB0CA479A77A", hash_generated_method = "175E674B0B8887C7C40A7C305040A814")
        public DERObject getDERObject() {
DERObject var9F6A5CC5D0E8FDBA0198C27DF56526D2_1098449876 =             outer;
            var9F6A5CC5D0E8FDBA0198C27DF56526D2_1098449876.addTaint(taint);
            return var9F6A5CC5D0E8FDBA0198C27DF56526D2_1098449876;
            // ---------- Original Method ----------
            //return outer;
        }
};
        varFEF15DF2C04179BD8EB2593AF5B49D65_1012881334.addTaint(taint);
        return varFEF15DF2C04179BD8EB2593AF5B49D65_1012881334;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.820 -0400", hash_original_method = "169312DEA8D054B4F83730CF694439C2", hash_generated_method = "38AFE83207DD7C01739DF2F845E23BB5")
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
        int var550D1CC054A1B23A411DDDA46FD64811_1232074501 = (hashCode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_209859755 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_209859755;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.821 -0400", hash_original_method = "4061A2825C144C76460287466E375CA1", hash_generated_method = "20F8B8F4610D97DA4A27FE29D2A30E58")
     boolean asn1Equals(
        DERObject  o) {
        addTaint(o.getTaint());
        if(!(o instanceof ASN1Set))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1357564559 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_851552150 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_851552150;
        } //End block
        ASN1Set other = (ASN1Set)o;
        if(this.size() != other.size())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1848680575 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_358545009 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_358545009;
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
            boolean var68934A3E9455FA72420237EB05902327_17905678 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1846917972 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1846917972;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_429240113 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1186101960 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1186101960;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.821 -0400", hash_original_method = "A69C6C665FC9D3DE250A324544079C85", hash_generated_method = "B25F9DDCED0DEE33F68DF296B19DAC4D")
    private DEREncodable getNext(Enumeration e) {
        addTaint(e.getTaint());
        DEREncodable encObj = (DEREncodable)e.nextElement();
        if(encObj == null)        
        {
DEREncodable var1E3D3B7EF2DA7DB00405B805195FA465_1580126842 =             DERNull.INSTANCE;
            var1E3D3B7EF2DA7DB00405B805195FA465_1580126842.addTaint(taint);
            return var1E3D3B7EF2DA7DB00405B805195FA465_1580126842;
        } //End block
DEREncodable var142E4525AFF6FB7F5C03BA975A3F000D_919367333 =         encObj;
        var142E4525AFF6FB7F5C03BA975A3F000D_919367333.addTaint(taint);
        return var142E4525AFF6FB7F5C03BA975A3F000D_919367333;
        // ---------- Original Method ----------
        //DEREncodable encObj = (DEREncodable)e.nextElement();
        //if (encObj == null)
        //{
            //return DERNull.INSTANCE;
        //}
        //return encObj;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.822 -0400", hash_original_method = "207A76DA1E8D21F977EB59C485DCA4E9", hash_generated_method = "ABEF6A97E62B71397F17D2B4E4755AFB")
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
                boolean var97F166E1B0A1C80CD24C5F8B485204EE_648233133 = ((a[i] & 0xff) < (b[i] & 0xff));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_903447888 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_903447888;
            } //End block
        } //End block
        boolean var96A6477DE9BDA92A5D66BD7039452F9D_1043245127 = (len == a.length);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1235206906 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1235206906;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.822 -0400", hash_original_method = "522D47B99F0E20F7487ED5107F130A00", hash_generated_method = "A1123B22C053F206087C7C78C5D4350A")
    private byte[] getEncoded(
        DEREncodable obj) {
        addTaint(obj.getTaint());
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        ASN1OutputStream aOut = new ASN1OutputStream(bOut);
        try 
        {
            aOut.writeObject(obj);
        } //End block
        catch (IOException e)
        {
            IllegalArgumentException var9D6BA3DFDD07A4AE4FED53269D6A12A6_1117846139 = new IllegalArgumentException("cannot encode object added to SET");
            var9D6BA3DFDD07A4AE4FED53269D6A12A6_1117846139.addTaint(taint);
            throw var9D6BA3DFDD07A4AE4FED53269D6A12A6_1117846139;
        } //End block
        byte[] varFBF1B634B1C8DDF7D794A26F16D73A6E_254573785 = (bOut.toByteArray());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_545099284 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_545099284;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.823 -0400", hash_original_method = "8F80C00B71E62E5E32912D37725353DB", hash_generated_method = "FAA0CDC049B2068ABCDF4C48CCC7FCDE")
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
                    } //End block
                    else
                    {
                        Object o = set.elementAt(index);
                        set.setElementAt(set.elementAt(index + 1), index);
                        set.setElementAt(o, index + 1);
                        swapped = true;
                        swapIndex = index;
                    } //End block
                    index++;
                } //End block
                lastSwap = swapIndex;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.824 -0400", hash_original_method = "DAE6351DB6B0C6C803835987F16403A5", hash_generated_method = "8D039727FFFA6ADBE9EB04B451631A9F")
    protected void addObject(
        DEREncodable obj) {
        addTaint(obj.getTaint());
        set.addElement(obj);
        // ---------- Original Method ----------
        //set.addElement(obj);
    }

    
    @DSModeled(DSC.SAFE)
    abstract void encode(DEROutputStream out)
            throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.825 -0400", hash_original_method = "41D154F65E4EBBCBC7C30CB48ECE000A", hash_generated_method = "6DCA3FC6D4C4073F0CB5CB7A462F4852")
    public String toString() {
String varD9E92111BC211C24F86F9BA2DDF44C5C_1046091604 =         set.toString();
        varD9E92111BC211C24F86F9BA2DDF44C5C_1046091604.addTaint(taint);
        return varD9E92111BC211C24F86F9BA2DDF44C5C_1046091604;
        // ---------- Original Method ----------
        //return set.toString();
    }

    
    // orphaned legacy field
    private int index;
    
    // orphaned legacy field
    private final int max = size();
    
}

