package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

class EmulatedFieldsForLoading extends ObjectInputStream.GetField {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.960 -0400", hash_original_field = "8E24EB6B53474FDF2FBF5AA57C86B263", hash_generated_field = "BB7D93F7E285B6B6ABC207AB64AE3D33")

    private ObjectStreamClass streamClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.961 -0400", hash_original_field = "F6140DD74E8B37A12ABECC3B9897BAA5", hash_generated_field = "B94E58D5D6568A9EC985C6A7207CC5BA")

    private EmulatedFields emulatedFields;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.963 -0400", hash_original_method = "3A92EA3385CE026A7E99F46A314647AE", hash_generated_method = "03F664C66BEC51A816D3478D15CC7B51")
      EmulatedFieldsForLoading(ObjectStreamClass streamClass) {
        this.streamClass = streamClass;
        emulatedFields = new EmulatedFields(streamClass.getLoadFields(), streamClass.fields());
        // ---------- Original Method ----------
        //this.streamClass = streamClass;
        //emulatedFields = new EmulatedFields(streamClass.getLoadFields(), streamClass.fields());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.965 -0400", hash_original_method = "9CACF5DB880CF5C328FFD8A9BF6477FA", hash_generated_method = "2FFE78596813B73D203D131069CB90D3")
    @Override
    public boolean defaulted(String name) throws IOException,
            IllegalArgumentException {
        addTaint(name.getTaint());
        boolean varCCC9452EBC351CBBB20CE431921323C4_228914415 = (emulatedFields.defaulted(name));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_969775229 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_969775229;
        // ---------- Original Method ----------
        //return emulatedFields.defaulted(name);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.967 -0400", hash_original_method = "F09D38B717E770EDAB76B08B81548137", hash_generated_method = "2B626B4A29FA0B7B3BE1B2A7B774FB44")
     EmulatedFields emulatedFields() {
EmulatedFields var18247BC109AF7C66D9FA0EEEECBE3638_1795574153 =         emulatedFields;
        var18247BC109AF7C66D9FA0EEEECBE3638_1795574153.addTaint(taint);
        return var18247BC109AF7C66D9FA0EEEECBE3638_1795574153;
        // ---------- Original Method ----------
        //return emulatedFields;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.968 -0400", hash_original_method = "E2EF3BE82D42EA9EDACA51530EC46031", hash_generated_method = "EE3BF2F1D119962E4E2A65DD60C38CE0")
    @Override
    public byte get(String name, byte defaultValue) throws IOException,
            IllegalArgumentException {
        addTaint(defaultValue);
        addTaint(name.getTaint());
        byte var167B1DF425E67AA0E63022B3EA69C87B_1597408289 = (emulatedFields.get(name, defaultValue));
                byte var40EA57D3EE3C07BF1C102B466E1C3091_416655728 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_416655728;
        // ---------- Original Method ----------
        //return emulatedFields.get(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.973 -0400", hash_original_method = "7F476519C93586AA18DAE834C31099C5", hash_generated_method = "BE7F669F86FF10B7C54C9DDED4523DDD")
    @Override
    public char get(String name, char defaultValue) throws IOException,
            IllegalArgumentException {
        addTaint(defaultValue);
        addTaint(name.getTaint());
        char var167B1DF425E67AA0E63022B3EA69C87B_578232964 = (emulatedFields.get(name, defaultValue));
                char varA87DEB01C5F539E6BDA34829C8EF2368_897757415 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_897757415;
        // ---------- Original Method ----------
        //return emulatedFields.get(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.976 -0400", hash_original_method = "6EEAC0F2FE3228611FBEB2F317C71229", hash_generated_method = "9D73E7577954CF69184EAD1704303482")
    @Override
    public double get(String name, double defaultValue) throws IOException,
            IllegalArgumentException {
        addTaint(defaultValue);
        addTaint(name.getTaint());
        double var167B1DF425E67AA0E63022B3EA69C87B_1889233393 = (emulatedFields.get(name, defaultValue));
                double varE8CD7DA078A86726031AD64F35F5A6C0_1667707558 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1667707558;
        // ---------- Original Method ----------
        //return emulatedFields.get(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.980 -0400", hash_original_method = "656F0985EB6DC9E8197CCDD755BCC8B1", hash_generated_method = "34E488A82DFB7F90BC810A02D4556805")
    @Override
    public float get(String name, float defaultValue) throws IOException,
            IllegalArgumentException {
        addTaint(defaultValue);
        addTaint(name.getTaint());
        float var167B1DF425E67AA0E63022B3EA69C87B_860989014 = (emulatedFields.get(name, defaultValue));
                float var546ADE640B6EDFBC8A086EF31347E768_2004113153 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2004113153;
        // ---------- Original Method ----------
        //return emulatedFields.get(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.982 -0400", hash_original_method = "6047986AF632F142A25FB2722F77D86C", hash_generated_method = "4B0E4EACF4F7A1FEFE68DB9A37F2C207")
    @Override
    public int get(String name, int defaultValue) throws IOException,
            IllegalArgumentException {
        addTaint(defaultValue);
        addTaint(name.getTaint());
        int var167B1DF425E67AA0E63022B3EA69C87B_236120011 = (emulatedFields.get(name, defaultValue));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_200280268 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_200280268;
        // ---------- Original Method ----------
        //return emulatedFields.get(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.984 -0400", hash_original_method = "6EAC14C93DA75CAEC3046B717CAB55B5", hash_generated_method = "7767673C4C046099EEA6DAAF1DB39630")
    @Override
    public long get(String name, long defaultValue) throws IOException,
            IllegalArgumentException {
        addTaint(defaultValue);
        addTaint(name.getTaint());
        long var167B1DF425E67AA0E63022B3EA69C87B_1889449991 = (emulatedFields.get(name, defaultValue));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_548678329 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_548678329;
        // ---------- Original Method ----------
        //return emulatedFields.get(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.986 -0400", hash_original_method = "C001C2593281B8C12D4D30B1599FB136", hash_generated_method = "BC3A6966A9C67F184C5AC432F763BE19")
    @Override
    public Object get(String name, Object defaultValue) throws IOException,
            IllegalArgumentException {
        addTaint(defaultValue.getTaint());
        addTaint(name.getTaint());
Object varDA6D5552B979C6493B8792E91CCA076D_1425877305 =         emulatedFields.get(name, defaultValue);
        varDA6D5552B979C6493B8792E91CCA076D_1425877305.addTaint(taint);
        return varDA6D5552B979C6493B8792E91CCA076D_1425877305;
        // ---------- Original Method ----------
        //return emulatedFields.get(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.991 -0400", hash_original_method = "10DCCBE6C4EE0FC6DB857351027C9025", hash_generated_method = "70E48F911B78E6FFC102D3E3BE3AD5E6")
    @Override
    public short get(String name, short defaultValue) throws IOException,
            IllegalArgumentException {
        addTaint(defaultValue);
        addTaint(name.getTaint());
        short var167B1DF425E67AA0E63022B3EA69C87B_248073252 = (emulatedFields.get(name, defaultValue));
                short var4F09DAA9D95BCB166A302407A0E0BABE_2101571529 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_2101571529;
        // ---------- Original Method ----------
        //return emulatedFields.get(name, defaultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.993 -0400", hash_original_method = "076C341B7F018B893749E08DE221153C", hash_generated_method = "56DD6CC5E1D605BEB033A514085B5E9F")
    @Override
    public boolean get(String name, boolean defaultValue) throws IOException,
            IllegalArgumentException {
        addTaint(defaultValue);
        addTaint(name.getTaint());
        boolean var167B1DF425E67AA0E63022B3EA69C87B_952561920 = (emulatedFields.get(name, defaultValue));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_26647015 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_26647015;
        // ---------- Original Method ----------
        //return emulatedFields.get(name, defaultValue);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.995 -0400", hash_original_method = "C05B1B5B49C9CD804F2B010781383CF8", hash_generated_method = "DFF795B584BFB440EBFCF467D507067D")
    @Override
    public ObjectStreamClass getObjectStreamClass() {
ObjectStreamClass varB15C7012F89088D5E62C8E84F0D75364_1401674660 =         streamClass;
        varB15C7012F89088D5E62C8E84F0D75364_1401674660.addTaint(taint);
        return varB15C7012F89088D5E62C8E84F0D75364_1401674660;
        // ---------- Original Method ----------
        //return streamClass;
    }

    
}

