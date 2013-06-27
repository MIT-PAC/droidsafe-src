package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

class EmulatedFieldsForLoading extends ObjectInputStream.GetField {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.731 -0400", hash_original_field = "8E24EB6B53474FDF2FBF5AA57C86B263", hash_generated_field = "BB7D93F7E285B6B6ABC207AB64AE3D33")

    private ObjectStreamClass streamClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.731 -0400", hash_original_field = "F6140DD74E8B37A12ABECC3B9897BAA5", hash_generated_field = "B94E58D5D6568A9EC985C6A7207CC5BA")

    private EmulatedFields emulatedFields;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.732 -0400", hash_original_method = "3A92EA3385CE026A7E99F46A314647AE", hash_generated_method = "03F664C66BEC51A816D3478D15CC7B51")
      EmulatedFieldsForLoading(ObjectStreamClass streamClass) {
        this.streamClass = streamClass;
        emulatedFields = new EmulatedFields(streamClass.getLoadFields(), streamClass.fields());
        // ---------- Original Method ----------
        //this.streamClass = streamClass;
        //emulatedFields = new EmulatedFields(streamClass.getLoadFields(), streamClass.fields());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.732 -0400", hash_original_method = "9CACF5DB880CF5C328FFD8A9BF6477FA", hash_generated_method = "C22CB2A4B54C8A334B734EAA9B64B2D7")
    @Override
    public boolean defaulted(String name) throws IOException,
            IllegalArgumentException {
        boolean var2D8F5507C12052930B02EE0D95FEAF56_551951306 = (emulatedFields.defaulted(name));
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1619420311 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1619420311;
        // ---------- Original Method ----------
        //return emulatedFields.defaulted(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.736 -0400", hash_original_method = "F09D38B717E770EDAB76B08B81548137", hash_generated_method = "F373BA506F36A704DBBC4232D2303606")
     EmulatedFields emulatedFields() {
        EmulatedFields varB4EAC82CA7396A68D541C85D26508E83_717582095 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_717582095 = emulatedFields;
        varB4EAC82CA7396A68D541C85D26508E83_717582095.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_717582095;
        // ---------- Original Method ----------
        //return emulatedFields;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.737 -0400", hash_original_method = "E2EF3BE82D42EA9EDACA51530EC46031", hash_generated_method = "4DF25AF493BF0817BC6A75D27073BBF0")
    @Override
    public byte get(String name, byte defaultValue) throws IOException,
            IllegalArgumentException {
        byte varC489F1A2DC32293B9EACB999DD2BEC9A_1156897779 = (emulatedFields.get(name, defaultValue));
        addTaint(name.getTaint());
        addTaint(defaultValue);
        byte var40EA57D3EE3C07BF1C102B466E1C3091_159631916 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_159631916;
        // ---------- Original Method ----------
        //return emulatedFields.get(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.739 -0400", hash_original_method = "7F476519C93586AA18DAE834C31099C5", hash_generated_method = "AD557667C65FB9F5CE0EAFA32525E02C")
    @Override
    public char get(String name, char defaultValue) throws IOException,
            IllegalArgumentException {
        char varC489F1A2DC32293B9EACB999DD2BEC9A_1036111090 = (emulatedFields.get(name, defaultValue));
        addTaint(name.getTaint());
        addTaint(defaultValue);
        char varA87DEB01C5F539E6BDA34829C8EF2368_118857259 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_118857259;
        // ---------- Original Method ----------
        //return emulatedFields.get(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.741 -0400", hash_original_method = "6EEAC0F2FE3228611FBEB2F317C71229", hash_generated_method = "8D9FAEB64FCA6418BCC2EC60552134DA")
    @Override
    public double get(String name, double defaultValue) throws IOException,
            IllegalArgumentException {
        double varC489F1A2DC32293B9EACB999DD2BEC9A_743903346 = (emulatedFields.get(name, defaultValue));
        addTaint(name.getTaint());
        addTaint(defaultValue);
        double varE8CD7DA078A86726031AD64F35F5A6C0_455265886 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_455265886;
        // ---------- Original Method ----------
        //return emulatedFields.get(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.741 -0400", hash_original_method = "656F0985EB6DC9E8197CCDD755BCC8B1", hash_generated_method = "7CCDA88EEBAE52446C0D27D22C2FD26B")
    @Override
    public float get(String name, float defaultValue) throws IOException,
            IllegalArgumentException {
        float varC489F1A2DC32293B9EACB999DD2BEC9A_1698646198 = (emulatedFields.get(name, defaultValue));
        addTaint(name.getTaint());
        addTaint(defaultValue);
        float var546ADE640B6EDFBC8A086EF31347E768_1777986835 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1777986835;
        // ---------- Original Method ----------
        //return emulatedFields.get(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.743 -0400", hash_original_method = "6047986AF632F142A25FB2722F77D86C", hash_generated_method = "94D7D495C77D1FBDCD4D64D358531A58")
    @Override
    public int get(String name, int defaultValue) throws IOException,
            IllegalArgumentException {
        int varC489F1A2DC32293B9EACB999DD2BEC9A_1513896882 = (emulatedFields.get(name, defaultValue));
        addTaint(name.getTaint());
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1302287492 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1302287492;
        // ---------- Original Method ----------
        //return emulatedFields.get(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.743 -0400", hash_original_method = "6EAC14C93DA75CAEC3046B717CAB55B5", hash_generated_method = "BD84AF64E2B538D0E461117B7FAAC5BF")
    @Override
    public long get(String name, long defaultValue) throws IOException,
            IllegalArgumentException {
        long varC489F1A2DC32293B9EACB999DD2BEC9A_73617799 = (emulatedFields.get(name, defaultValue));
        addTaint(name.getTaint());
        addTaint(defaultValue);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1435622008 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1435622008;
        // ---------- Original Method ----------
        //return emulatedFields.get(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.747 -0400", hash_original_method = "C001C2593281B8C12D4D30B1599FB136", hash_generated_method = "E78330E155BC7375900B96DD2071E6AC")
    @Override
    public Object get(String name, Object defaultValue) throws IOException,
            IllegalArgumentException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1739997269 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1739997269 = emulatedFields.get(name, defaultValue);
        addTaint(name.getTaint());
        addTaint(defaultValue.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1739997269.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1739997269;
        // ---------- Original Method ----------
        //return emulatedFields.get(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.750 -0400", hash_original_method = "10DCCBE6C4EE0FC6DB857351027C9025", hash_generated_method = "6BC14FEFD82659675A5212CB3B5681E2")
    @Override
    public short get(String name, short defaultValue) throws IOException,
            IllegalArgumentException {
        short varC489F1A2DC32293B9EACB999DD2BEC9A_2135337279 = (emulatedFields.get(name, defaultValue));
        addTaint(name.getTaint());
        addTaint(defaultValue);
        short var4F09DAA9D95BCB166A302407A0E0BABE_336012349 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_336012349;
        // ---------- Original Method ----------
        //return emulatedFields.get(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.760 -0400", hash_original_method = "076C341B7F018B893749E08DE221153C", hash_generated_method = "DA3F982B1E1E6F5D90015D6A60EEC684")
    @Override
    public boolean get(String name, boolean defaultValue) throws IOException,
            IllegalArgumentException {
        boolean varC489F1A2DC32293B9EACB999DD2BEC9A_1742492219 = (emulatedFields.get(name, defaultValue));
        addTaint(name.getTaint());
        addTaint(defaultValue);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_294930181 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_294930181;
        // ---------- Original Method ----------
        //return emulatedFields.get(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.761 -0400", hash_original_method = "C05B1B5B49C9CD804F2B010781383CF8", hash_generated_method = "79D30305E70899CA549573E5D7E26247")
    @Override
    public ObjectStreamClass getObjectStreamClass() {
        ObjectStreamClass varB4EAC82CA7396A68D541C85D26508E83_1711816347 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1711816347 = streamClass;
        varB4EAC82CA7396A68D541C85D26508E83_1711816347.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1711816347;
        // ---------- Original Method ----------
        //return streamClass;
    }

    
}

