package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;

public abstract class ASN1TaggedObject extends ASN1Object implements ASN1TaggedObjectParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.760 -0400", hash_original_field = "5725D710258369113D712F6D4ABF6730", hash_generated_field = "FA62A32896A7308D5C3ACC05B62DCB16")

    int tagNo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.761 -0400", hash_original_field = "B4A8E09BB57CCF7D96716F9A43485E3E", hash_generated_field = "A3C5A9AF358FD2BFCBE0C2693903BB82")

    boolean empty = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.761 -0400", hash_original_field = "3E40242F1A39AB0A286E83CF367BEE19", hash_generated_field = "83237803BCA36CFD769F62D64B3B892F")

    boolean explicit = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.762 -0400", hash_original_field = "47189E8EF2397EADF5CDF5F3A182EACB", hash_generated_field = "27B23743F26E5B0F431105D2841F3A3B")

    DEREncodable obj = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.762 -0400", hash_original_method = "00E51A508FDFE6A586E84CD8A518A30A", hash_generated_method = "DA23F9717F5F756F2361C3E8C1AED031")
    public  ASN1TaggedObject(
        int             tagNo,
        DEREncodable    obj) {
        this.explicit = true;
        this.tagNo = tagNo;
        this.obj = obj;
        // ---------- Original Method ----------
        //this.explicit = true;
        //this.tagNo = tagNo;
        //this.obj = obj;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.763 -0400", hash_original_method = "9F7BD38C3B2D03C6929A27397833F44D", hash_generated_method = "BCCA2545AEB85D5C456E91F6E5661421")
    public  ASN1TaggedObject(
        boolean         explicit,
        int             tagNo,
        DEREncodable    obj) {
    if(obj instanceof ASN1Choice)        
        {
            this.explicit = true;
        } //End block
        else
        {
            this.explicit = explicit;
        } //End block
        this.tagNo = tagNo;
        this.obj = obj;
        // ---------- Original Method ----------
        //if (obj instanceof ASN1Choice)
        //{
            //this.explicit = true;
        //}
        //else
        //{
            //this.explicit = explicit;
        //}
        //this.tagNo = tagNo;
        //this.obj = obj;
    }

    
        static public ASN1TaggedObject getInstance(
        ASN1TaggedObject    obj,
        boolean             explicit) {
        if (explicit)
        {
            return (ASN1TaggedObject)obj.getObject();
        }
        throw new IllegalArgumentException("implicitly tagged tagged object");
    }

    
        static public ASN1TaggedObject getInstance(
        Object obj) {
        if (obj == null || obj instanceof ASN1TaggedObject) 
        {
                return (ASN1TaggedObject)obj;
        }
        throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.765 -0400", hash_original_method = "68AE9CCB33F87A12C7FA4AA63E83BFDC", hash_generated_method = "5F40F94E4DFE69529BB62A5F3DC12AC3")
     boolean asn1Equals(
        DERObject o) {
        addTaint(o.getTaint());
    if(!(o instanceof ASN1TaggedObject))        
        {
            boolean var68934A3E9455FA72420237EB05902327_618653033 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_66194918 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_66194918;
        } //End block
        ASN1TaggedObject other = (ASN1TaggedObject)o;
    if(tagNo != other.tagNo || empty != other.empty || explicit != other.explicit)        
        {
            boolean var68934A3E9455FA72420237EB05902327_774630914 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_818364688 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_818364688;
        } //End block
    if(obj == null)        
        {
    if(other.obj != null)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1781513890 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_748288726 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_748288726;
            } //End block
        } //End block
        else
        {
    if(!(obj.getDERObject().equals(other.obj.getDERObject())))            
            {
                boolean var68934A3E9455FA72420237EB05902327_56097485 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1534625665 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1534625665;
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1216176437 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1265051185 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1265051185;
        // ---------- Original Method ----------
        //if (!(o instanceof ASN1TaggedObject))
        //{
            //return false;
        //}
        //ASN1TaggedObject other = (ASN1TaggedObject)o;
        //if (tagNo != other.tagNo || empty != other.empty || explicit != other.explicit)
        //{
            //return false;
        //}
        //if(obj == null)
        //{
            //if (other.obj != null)
            //{
                //return false;
            //}
        //}
        //else
        //{
            //if (!(obj.getDERObject().equals(other.obj.getDERObject())))
            //{
                //return false;
            //}
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.766 -0400", hash_original_method = "996889D0C05CC309872B8EE7FF5C4369", hash_generated_method = "21F1AD2C23694D64180670DBECC55E70")
    public int hashCode() {
        int code = tagNo;
    if(obj != null)        
        {
            code ^= obj.hashCode();
        } //End block
        int varC13367945D5D4C91047B3B50234AA7AB_2137126456 = (code);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1641713193 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1641713193;
        // ---------- Original Method ----------
        //int code = tagNo;
        //if (obj != null)
        //{
            //code ^= obj.hashCode();
        //}
        //return code;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.767 -0400", hash_original_method = "CB42AFB8AF1DB9A93243A50229C66A0D", hash_generated_method = "B1A1027EF7B0F431825F0B0DFDA35A67")
    public int getTagNo() {
        int var5725D710258369113D712F6D4ABF6730_1823030249 = (tagNo);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_377679827 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_377679827;
        // ---------- Original Method ----------
        //return tagNo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.768 -0400", hash_original_method = "AF6534B2BC536C6B2446F0C361A4EC15", hash_generated_method = "6D4AABB4D9C8538C52537AAB2D35A57E")
    public boolean isExplicit() {
        boolean varE2A3307DD8A12A0B820132B2C1C27819_1264277310 = (explicit);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2113671719 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2113671719;
        // ---------- Original Method ----------
        //return explicit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.769 -0400", hash_original_method = "A3A283EA275283949A16122176F95537", hash_generated_method = "CF611EADFBAA4D9D7614D159E9CCC9AC")
    public boolean isEmpty() {
        boolean varA2E4822A98337283E39F7B60ACF85EC9_832320839 = (empty);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1754806719 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1754806719;
        // ---------- Original Method ----------
        //return empty;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.769 -0400", hash_original_method = "71996C10B1D68BDB26DD531066806FCB", hash_generated_method = "1C19F3EE15A42DB8FE8C914808EE649E")
    public DERObject getObject() {
    if(obj != null)        
        {
DERObject var23A4222CF5292FF705C5DA2A104D1850_1113373120 =             obj.getDERObject();
            var23A4222CF5292FF705C5DA2A104D1850_1113373120.addTaint(taint);
            return var23A4222CF5292FF705C5DA2A104D1850_1113373120;
        } //End block
DERObject var540C13E9E156B687226421B24F2DF178_1409160162 =         null;
        var540C13E9E156B687226421B24F2DF178_1409160162.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1409160162;
        // ---------- Original Method ----------
        //if (obj != null)
        //{
            //return obj.getDERObject();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.770 -0400", hash_original_method = "45814A62D9590995EE34A14DC507BC36", hash_generated_method = "40CB3D3A90104FFC5AFB2667A97F8810")
    public DEREncodable getObjectParser(
        int     tag,
        boolean isExplicit) {
        addTaint(isExplicit);
        addTaint(tag);
switch(tag){
        case DERTags.SET:
DEREncodable var880E67636514E4B8374190F8474A6E7F_906441727 =         ASN1Set.getInstance(this, isExplicit).parser();
        var880E67636514E4B8374190F8474A6E7F_906441727.addTaint(taint);
        return var880E67636514E4B8374190F8474A6E7F_906441727;
        case DERTags.SEQUENCE:
DEREncodable var3FDD8B7B0223B31D3B1C97D5E884302E_11846342 =         ASN1Sequence.getInstance(this, isExplicit).parser();
        var3FDD8B7B0223B31D3B1C97D5E884302E_11846342.addTaint(taint);
        return var3FDD8B7B0223B31D3B1C97D5E884302E_11846342;
        case DERTags.OCTET_STRING:
DEREncodable varBD62BAA67427D1C13A0898EAAD77920C_797936256 =         ASN1OctetString.getInstance(this, isExplicit).parser();
        varBD62BAA67427D1C13A0898EAAD77920C_797936256.addTaint(taint);
        return varBD62BAA67427D1C13A0898EAAD77920C_797936256;
}    if(isExplicit)        
        {
DEREncodable var63D6E0ED18B2DCD697AD4DA88AE04A3A_1352356018 =             getObject();
            var63D6E0ED18B2DCD697AD4DA88AE04A3A_1352356018.addTaint(taint);
            return var63D6E0ED18B2DCD697AD4DA88AE04A3A_1352356018;
        } //End block
        RuntimeException var0F0AECC06703C00CA3D5496CE88A4347_540171058 = new RuntimeException("implicit tagging not implemented for tag: " + tag);
        var0F0AECC06703C00CA3D5496CE88A4347_540171058.addTaint(taint);
        throw var0F0AECC06703C00CA3D5496CE88A4347_540171058;
        // ---------- Original Method ----------
        //switch (tag)
        //{
        //case DERTags.SET:
            //return ASN1Set.getInstance(this, isExplicit).parser();
        //case DERTags.SEQUENCE:
            //return ASN1Sequence.getInstance(this, isExplicit).parser();
        //case DERTags.OCTET_STRING:
            //return ASN1OctetString.getInstance(this, isExplicit).parser();
        //}
        //if (isExplicit)
        //{
            //return getObject();
        //}
        //throw new RuntimeException("implicit tagging not implemented for tag: " + tag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.770 -0400", hash_original_method = "D3363286272FDA8D05900543905FFBE8", hash_generated_method = "9C712BFDA0A21A97B1441721C0E17A12")
    public DERObject getLoadedObject() {
DERObject var637323B1C4EE7CAF17B2CD40E14254B5_94608418 =         this.getDERObject();
        var637323B1C4EE7CAF17B2CD40E14254B5_94608418.addTaint(taint);
        return var637323B1C4EE7CAF17B2CD40E14254B5_94608418;
        // ---------- Original Method ----------
        //return this.getDERObject();
    }

    
    abstract void encode(DEROutputStream  out)
        throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.771 -0400", hash_original_method = "5750585E0FAF2C7F60E10F96F297B6DF", hash_generated_method = "6484C29F6466B6CF068A4DD24F26E7D3")
    public String toString() {
String varD4481D92D04117EB9AC946380B8C587E_470716193 =         "[" + tagNo + "]" + obj;
        varD4481D92D04117EB9AC946380B8C587E_470716193.addTaint(taint);
        return varD4481D92D04117EB9AC946380B8C587E_470716193;
        // ---------- Original Method ----------
        //return "[" + tagNo + "]" + obj;
    }

    
}

