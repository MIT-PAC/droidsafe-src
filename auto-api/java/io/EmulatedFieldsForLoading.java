package java.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

class EmulatedFieldsForLoading extends ObjectInputStream.GetField {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.750 -0400", hash_original_field = "8E24EB6B53474FDF2FBF5AA57C86B263", hash_generated_field = "BB7D93F7E285B6B6ABC207AB64AE3D33")

    private ObjectStreamClass streamClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.750 -0400", hash_original_field = "F6140DD74E8B37A12ABECC3B9897BAA5", hash_generated_field = "B94E58D5D6568A9EC985C6A7207CC5BA")

    private EmulatedFields emulatedFields;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.751 -0400", hash_original_method = "3A92EA3385CE026A7E99F46A314647AE", hash_generated_method = "03F664C66BEC51A816D3478D15CC7B51")
      EmulatedFieldsForLoading(ObjectStreamClass streamClass) {
        this.streamClass = streamClass;
        emulatedFields = new EmulatedFields(streamClass.getLoadFields(), streamClass.fields());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.751 -0400", hash_original_method = "9CACF5DB880CF5C328FFD8A9BF6477FA", hash_generated_method = "5AE1782E868D931FE45B920B8FC9C35C")
    @Override
    public boolean defaulted(String name) throws IOException,
            IllegalArgumentException {
        boolean var2D8F5507C12052930B02EE0D95FEAF56_1409198356 = (emulatedFields.defaulted(name));
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_68044101 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_68044101;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.752 -0400", hash_original_method = "F09D38B717E770EDAB76B08B81548137", hash_generated_method = "B68FE63CF7E102F35D79881FE7EF70BF")
     EmulatedFields emulatedFields() {
        EmulatedFields varB4EAC82CA7396A68D541C85D26508E83_1017670543 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1017670543 = emulatedFields;
        varB4EAC82CA7396A68D541C85D26508E83_1017670543.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1017670543;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.752 -0400", hash_original_method = "E2EF3BE82D42EA9EDACA51530EC46031", hash_generated_method = "995EDEC70FF39882F5FC79E4BB722F37")
    @Override
    public byte get(String name, byte defaultValue) throws IOException,
            IllegalArgumentException {
        byte varC489F1A2DC32293B9EACB999DD2BEC9A_1191990797 = (emulatedFields.get(name, defaultValue));
        addTaint(name.getTaint());
        addTaint(defaultValue);
        byte var40EA57D3EE3C07BF1C102B466E1C3091_1928179041 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1928179041;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.752 -0400", hash_original_method = "7F476519C93586AA18DAE834C31099C5", hash_generated_method = "273C26A53CA2AD98AF925F7A8FAE482C")
    @Override
    public char get(String name, char defaultValue) throws IOException,
            IllegalArgumentException {
        char varC489F1A2DC32293B9EACB999DD2BEC9A_1436789399 = (emulatedFields.get(name, defaultValue));
        addTaint(name.getTaint());
        addTaint(defaultValue);
        char varA87DEB01C5F539E6BDA34829C8EF2368_475674266 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_475674266;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.753 -0400", hash_original_method = "6EEAC0F2FE3228611FBEB2F317C71229", hash_generated_method = "88C3A6B725E97D6D5853C7AB1BDE8D6A")
    @Override
    public double get(String name, double defaultValue) throws IOException,
            IllegalArgumentException {
        double varC489F1A2DC32293B9EACB999DD2BEC9A_1730794168 = (emulatedFields.get(name, defaultValue));
        addTaint(name.getTaint());
        addTaint(defaultValue);
        double varE8CD7DA078A86726031AD64F35F5A6C0_1489068528 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1489068528;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.753 -0400", hash_original_method = "656F0985EB6DC9E8197CCDD755BCC8B1", hash_generated_method = "5B02170C0EBBAE562623B24617E3F5EE")
    @Override
    public float get(String name, float defaultValue) throws IOException,
            IllegalArgumentException {
        float varC489F1A2DC32293B9EACB999DD2BEC9A_1739888644 = (emulatedFields.get(name, defaultValue));
        addTaint(name.getTaint());
        addTaint(defaultValue);
        float var546ADE640B6EDFBC8A086EF31347E768_1904988149 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1904988149;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.753 -0400", hash_original_method = "6047986AF632F142A25FB2722F77D86C", hash_generated_method = "1339E4046D4CC2FB2935DA702B5F4569")
    @Override
    public int get(String name, int defaultValue) throws IOException,
            IllegalArgumentException {
        int varC489F1A2DC32293B9EACB999DD2BEC9A_348302535 = (emulatedFields.get(name, defaultValue));
        addTaint(name.getTaint());
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_739280471 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_739280471;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.753 -0400", hash_original_method = "6EAC14C93DA75CAEC3046B717CAB55B5", hash_generated_method = "7C80CF4636176F1D80E2A02BB08DDAB4")
    @Override
    public long get(String name, long defaultValue) throws IOException,
            IllegalArgumentException {
        long varC489F1A2DC32293B9EACB999DD2BEC9A_977808545 = (emulatedFields.get(name, defaultValue));
        addTaint(name.getTaint());
        addTaint(defaultValue);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_993620046 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_993620046;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.754 -0400", hash_original_method = "C001C2593281B8C12D4D30B1599FB136", hash_generated_method = "FB8B1DDC4AA660B2F5907447E03DFC3F")
    @Override
    public Object get(String name, Object defaultValue) throws IOException,
            IllegalArgumentException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1107039097 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1107039097 = emulatedFields.get(name, defaultValue);
        addTaint(name.getTaint());
        addTaint(defaultValue.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1107039097.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1107039097;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.754 -0400", hash_original_method = "10DCCBE6C4EE0FC6DB857351027C9025", hash_generated_method = "145B0CA1D6D5FC52A3D74DF5FE1DCDE8")
    @Override
    public short get(String name, short defaultValue) throws IOException,
            IllegalArgumentException {
        short varC489F1A2DC32293B9EACB999DD2BEC9A_1461311497 = (emulatedFields.get(name, defaultValue));
        addTaint(name.getTaint());
        addTaint(defaultValue);
        short var4F09DAA9D95BCB166A302407A0E0BABE_47800735 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_47800735;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.754 -0400", hash_original_method = "076C341B7F018B893749E08DE221153C", hash_generated_method = "D282C313ADDC4F457B9FB88459671D90")
    @Override
    public boolean get(String name, boolean defaultValue) throws IOException,
            IllegalArgumentException {
        boolean varC489F1A2DC32293B9EACB999DD2BEC9A_619852098 = (emulatedFields.get(name, defaultValue));
        addTaint(name.getTaint());
        addTaint(defaultValue);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1905422671 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1905422671;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.755 -0400", hash_original_method = "C05B1B5B49C9CD804F2B010781383CF8", hash_generated_method = "653838968D1E2151D457859653120202")
    @Override
    public ObjectStreamClass getObjectStreamClass() {
        ObjectStreamClass varB4EAC82CA7396A68D541C85D26508E83_348316330 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_348316330 = streamClass;
        varB4EAC82CA7396A68D541C85D26508E83_348316330.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_348316330;
        
        
    }

    
}

