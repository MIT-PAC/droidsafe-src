package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

class EmulatedFieldsForLoading extends ObjectInputStream.GetField {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.715 -0400", hash_original_field = "8E24EB6B53474FDF2FBF5AA57C86B263", hash_generated_field = "BB7D93F7E285B6B6ABC207AB64AE3D33")

    private ObjectStreamClass streamClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.715 -0400", hash_original_field = "F6140DD74E8B37A12ABECC3B9897BAA5", hash_generated_field = "B94E58D5D6568A9EC985C6A7207CC5BA")

    private EmulatedFields emulatedFields;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.716 -0400", hash_original_method = "3A92EA3385CE026A7E99F46A314647AE", hash_generated_method = "03F664C66BEC51A816D3478D15CC7B51")
      EmulatedFieldsForLoading(ObjectStreamClass streamClass) {
        this.streamClass = streamClass;
        emulatedFields = new EmulatedFields(streamClass.getLoadFields(), streamClass.fields());
        // ---------- Original Method ----------
        //this.streamClass = streamClass;
        //emulatedFields = new EmulatedFields(streamClass.getLoadFields(), streamClass.fields());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.716 -0400", hash_original_method = "9CACF5DB880CF5C328FFD8A9BF6477FA", hash_generated_method = "E37F434F184D0445D80267B7F0B1C2A1")
    @Override
    public boolean defaulted(String name) throws IOException,
            IllegalArgumentException {
        boolean var2D8F5507C12052930B02EE0D95FEAF56_1271984457 = (emulatedFields.defaulted(name));
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1682870940 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1682870940;
        // ---------- Original Method ----------
        //return emulatedFields.defaulted(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.716 -0400", hash_original_method = "F09D38B717E770EDAB76B08B81548137", hash_generated_method = "92BA8F2CAFBF4E44AEFB9708923EADD1")
     EmulatedFields emulatedFields() {
        EmulatedFields varB4EAC82CA7396A68D541C85D26508E83_1762534675 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1762534675 = emulatedFields;
        varB4EAC82CA7396A68D541C85D26508E83_1762534675.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1762534675;
        // ---------- Original Method ----------
        //return emulatedFields;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.723 -0400", hash_original_method = "E2EF3BE82D42EA9EDACA51530EC46031", hash_generated_method = "C6FC024E0D9B17E4C26688D4AE10C912")
    @Override
    public byte get(String name, byte defaultValue) throws IOException,
            IllegalArgumentException {
        byte varC489F1A2DC32293B9EACB999DD2BEC9A_1457274971 = (emulatedFields.get(name, defaultValue));
        addTaint(name.getTaint());
        addTaint(defaultValue);
        byte var40EA57D3EE3C07BF1C102B466E1C3091_940214968 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_940214968;
        // ---------- Original Method ----------
        //return emulatedFields.get(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.723 -0400", hash_original_method = "7F476519C93586AA18DAE834C31099C5", hash_generated_method = "897CBBE08416C3B2DCA3F7B51F97D19D")
    @Override
    public char get(String name, char defaultValue) throws IOException,
            IllegalArgumentException {
        char varC489F1A2DC32293B9EACB999DD2BEC9A_1683145134 = (emulatedFields.get(name, defaultValue));
        addTaint(name.getTaint());
        addTaint(defaultValue);
        char varA87DEB01C5F539E6BDA34829C8EF2368_1031336152 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1031336152;
        // ---------- Original Method ----------
        //return emulatedFields.get(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.723 -0400", hash_original_method = "6EEAC0F2FE3228611FBEB2F317C71229", hash_generated_method = "F30D92318F5D7262FB2121AC0B5AC1D8")
    @Override
    public double get(String name, double defaultValue) throws IOException,
            IllegalArgumentException {
        double varC489F1A2DC32293B9EACB999DD2BEC9A_243626436 = (emulatedFields.get(name, defaultValue));
        addTaint(name.getTaint());
        addTaint(defaultValue);
        double varE8CD7DA078A86726031AD64F35F5A6C0_408735971 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_408735971;
        // ---------- Original Method ----------
        //return emulatedFields.get(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.724 -0400", hash_original_method = "656F0985EB6DC9E8197CCDD755BCC8B1", hash_generated_method = "A8B87935BB84E75DC367418AC510A1E1")
    @Override
    public float get(String name, float defaultValue) throws IOException,
            IllegalArgumentException {
        float varC489F1A2DC32293B9EACB999DD2BEC9A_836209794 = (emulatedFields.get(name, defaultValue));
        addTaint(name.getTaint());
        addTaint(defaultValue);
        float var546ADE640B6EDFBC8A086EF31347E768_1720839061 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1720839061;
        // ---------- Original Method ----------
        //return emulatedFields.get(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.724 -0400", hash_original_method = "6047986AF632F142A25FB2722F77D86C", hash_generated_method = "96FD9DE2A3FA60724D0E8390E651E8B5")
    @Override
    public int get(String name, int defaultValue) throws IOException,
            IllegalArgumentException {
        int varC489F1A2DC32293B9EACB999DD2BEC9A_2143037290 = (emulatedFields.get(name, defaultValue));
        addTaint(name.getTaint());
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_82753950 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_82753950;
        // ---------- Original Method ----------
        //return emulatedFields.get(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.724 -0400", hash_original_method = "6EAC14C93DA75CAEC3046B717CAB55B5", hash_generated_method = "4527D20A2D9F09C0D7A61BCAF3161BAB")
    @Override
    public long get(String name, long defaultValue) throws IOException,
            IllegalArgumentException {
        long varC489F1A2DC32293B9EACB999DD2BEC9A_722513482 = (emulatedFields.get(name, defaultValue));
        addTaint(name.getTaint());
        addTaint(defaultValue);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_587514545 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_587514545;
        // ---------- Original Method ----------
        //return emulatedFields.get(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.726 -0400", hash_original_method = "C001C2593281B8C12D4D30B1599FB136", hash_generated_method = "0E9DF5765ED67853E20F6C0B4CC513ED")
    @Override
    public Object get(String name, Object defaultValue) throws IOException,
            IllegalArgumentException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1992257929 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1992257929 = emulatedFields.get(name, defaultValue);
        addTaint(name.getTaint());
        addTaint(defaultValue.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1992257929.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1992257929;
        // ---------- Original Method ----------
        //return emulatedFields.get(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.732 -0400", hash_original_method = "10DCCBE6C4EE0FC6DB857351027C9025", hash_generated_method = "5052C55D9869C5CA6831A6FA21AC16A1")
    @Override
    public short get(String name, short defaultValue) throws IOException,
            IllegalArgumentException {
        short varC489F1A2DC32293B9EACB999DD2BEC9A_1864269104 = (emulatedFields.get(name, defaultValue));
        addTaint(name.getTaint());
        addTaint(defaultValue);
        short var4F09DAA9D95BCB166A302407A0E0BABE_1987370339 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1987370339;
        // ---------- Original Method ----------
        //return emulatedFields.get(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.732 -0400", hash_original_method = "076C341B7F018B893749E08DE221153C", hash_generated_method = "35A17D227F5989A7806CEFE6D31BA731")
    @Override
    public boolean get(String name, boolean defaultValue) throws IOException,
            IllegalArgumentException {
        boolean varC489F1A2DC32293B9EACB999DD2BEC9A_367920060 = (emulatedFields.get(name, defaultValue));
        addTaint(name.getTaint());
        addTaint(defaultValue);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1307513685 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1307513685;
        // ---------- Original Method ----------
        //return emulatedFields.get(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.733 -0400", hash_original_method = "C05B1B5B49C9CD804F2B010781383CF8", hash_generated_method = "3BC6883FBC8E280058BAA52B76BED1C6")
    @Override
    public ObjectStreamClass getObjectStreamClass() {
        ObjectStreamClass varB4EAC82CA7396A68D541C85D26508E83_750001904 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_750001904 = streamClass;
        varB4EAC82CA7396A68D541C85D26508E83_750001904.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_750001904;
        // ---------- Original Method ----------
        //return streamClass;
    }

    
}

