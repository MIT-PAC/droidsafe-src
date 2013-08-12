package java.io;

// Droidsafe Imports
import droidsafe.annotations.*;





class EmulatedFieldsForLoading extends ObjectInputStream.GetField {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.714 -0400", hash_original_field = "8E24EB6B53474FDF2FBF5AA57C86B263", hash_generated_field = "BB7D93F7E285B6B6ABC207AB64AE3D33")

    private ObjectStreamClass streamClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.714 -0400", hash_original_field = "F6140DD74E8B37A12ABECC3B9897BAA5", hash_generated_field = "B94E58D5D6568A9EC985C6A7207CC5BA")

    private EmulatedFields emulatedFields;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.715 -0400", hash_original_method = "3A92EA3385CE026A7E99F46A314647AE", hash_generated_method = "03F664C66BEC51A816D3478D15CC7B51")
      EmulatedFieldsForLoading(ObjectStreamClass streamClass) {
        this.streamClass = streamClass;
        emulatedFields = new EmulatedFields(streamClass.getLoadFields(), streamClass.fields());
        // ---------- Original Method ----------
        //this.streamClass = streamClass;
        //emulatedFields = new EmulatedFields(streamClass.getLoadFields(), streamClass.fields());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.716 -0400", hash_original_method = "9CACF5DB880CF5C328FFD8A9BF6477FA", hash_generated_method = "1D98DBC5D1E6E672E8C4CD54DA19757B")
    @Override
    public boolean defaulted(String name) throws IOException,
            IllegalArgumentException {
        addTaint(name.getTaint());
        boolean varCCC9452EBC351CBBB20CE431921323C4_1815546919 = (emulatedFields.defaulted(name));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1316837064 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1316837064;
        // ---------- Original Method ----------
        //return emulatedFields.defaulted(name);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.717 -0400", hash_original_method = "F09D38B717E770EDAB76B08B81548137", hash_generated_method = "B8EA9965F5E3CEA289E9A407612B1459")
     EmulatedFields emulatedFields() {
EmulatedFields var18247BC109AF7C66D9FA0EEEECBE3638_1478556145 =         emulatedFields;
        var18247BC109AF7C66D9FA0EEEECBE3638_1478556145.addTaint(taint);
        return var18247BC109AF7C66D9FA0EEEECBE3638_1478556145;
        // ---------- Original Method ----------
        //return emulatedFields;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.717 -0400", hash_original_method = "E2EF3BE82D42EA9EDACA51530EC46031", hash_generated_method = "F7C229F3E424890C53B7893AFE9160CD")
    @Override
    public byte get(String name, byte defaultValue) throws IOException,
            IllegalArgumentException {
        addTaint(defaultValue);
        addTaint(name.getTaint());
        byte var167B1DF425E67AA0E63022B3EA69C87B_393777154 = (emulatedFields.get(name, defaultValue));
                byte var40EA57D3EE3C07BF1C102B466E1C3091_1249121729 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1249121729;
        // ---------- Original Method ----------
        //return emulatedFields.get(name, defaultValue);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.718 -0400", hash_original_method = "7F476519C93586AA18DAE834C31099C5", hash_generated_method = "C1820894108928C3739AAA9E850A3D61")
    @Override
    public char get(String name, char defaultValue) throws IOException,
            IllegalArgumentException {
        addTaint(defaultValue);
        addTaint(name.getTaint());
        char var167B1DF425E67AA0E63022B3EA69C87B_42251265 = (emulatedFields.get(name, defaultValue));
                char varA87DEB01C5F539E6BDA34829C8EF2368_1325731788 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1325731788;
        // ---------- Original Method ----------
        //return emulatedFields.get(name, defaultValue);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.719 -0400", hash_original_method = "6EEAC0F2FE3228611FBEB2F317C71229", hash_generated_method = "45D4CDD7B3AB89730F18598C075D0BFD")
    @Override
    public double get(String name, double defaultValue) throws IOException,
            IllegalArgumentException {
        addTaint(defaultValue);
        addTaint(name.getTaint());
        double var167B1DF425E67AA0E63022B3EA69C87B_1440115944 = (emulatedFields.get(name, defaultValue));
                double varE8CD7DA078A86726031AD64F35F5A6C0_254279352 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_254279352;
        // ---------- Original Method ----------
        //return emulatedFields.get(name, defaultValue);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.720 -0400", hash_original_method = "656F0985EB6DC9E8197CCDD755BCC8B1", hash_generated_method = "C557BB2DDB0453A3EFAF374F651E17ED")
    @Override
    public float get(String name, float defaultValue) throws IOException,
            IllegalArgumentException {
        addTaint(defaultValue);
        addTaint(name.getTaint());
        float var167B1DF425E67AA0E63022B3EA69C87B_1277519035 = (emulatedFields.get(name, defaultValue));
                float var546ADE640B6EDFBC8A086EF31347E768_1354865716 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1354865716;
        // ---------- Original Method ----------
        //return emulatedFields.get(name, defaultValue);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.721 -0400", hash_original_method = "6047986AF632F142A25FB2722F77D86C", hash_generated_method = "9D51E65CEFAB05AFB9FA4A8FFC7C2279")
    @Override
    public int get(String name, int defaultValue) throws IOException,
            IllegalArgumentException {
        addTaint(defaultValue);
        addTaint(name.getTaint());
        int var167B1DF425E67AA0E63022B3EA69C87B_845449986 = (emulatedFields.get(name, defaultValue));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_998424736 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_998424736;
        // ---------- Original Method ----------
        //return emulatedFields.get(name, defaultValue);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.723 -0400", hash_original_method = "6EAC14C93DA75CAEC3046B717CAB55B5", hash_generated_method = "24629A9E1EA323A01B6A5B5B342EDE42")
    @Override
    public long get(String name, long defaultValue) throws IOException,
            IllegalArgumentException {
        addTaint(defaultValue);
        addTaint(name.getTaint());
        long var167B1DF425E67AA0E63022B3EA69C87B_1680407465 = (emulatedFields.get(name, defaultValue));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_125048503 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_125048503;
        // ---------- Original Method ----------
        //return emulatedFields.get(name, defaultValue);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.724 -0400", hash_original_method = "C001C2593281B8C12D4D30B1599FB136", hash_generated_method = "73D52C0C014FBDB247DCDC32811885EC")
    @Override
    public Object get(String name, Object defaultValue) throws IOException,
            IllegalArgumentException {
        addTaint(defaultValue.getTaint());
        addTaint(name.getTaint());
Object varDA6D5552B979C6493B8792E91CCA076D_126225243 =         emulatedFields.get(name, defaultValue);
        varDA6D5552B979C6493B8792E91CCA076D_126225243.addTaint(taint);
        return varDA6D5552B979C6493B8792E91CCA076D_126225243;
        // ---------- Original Method ----------
        //return emulatedFields.get(name, defaultValue);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.724 -0400", hash_original_method = "10DCCBE6C4EE0FC6DB857351027C9025", hash_generated_method = "A5E950622137415FE623CF5AF0E781F5")
    @Override
    public short get(String name, short defaultValue) throws IOException,
            IllegalArgumentException {
        addTaint(defaultValue);
        addTaint(name.getTaint());
        short var167B1DF425E67AA0E63022B3EA69C87B_1378218016 = (emulatedFields.get(name, defaultValue));
                short var4F09DAA9D95BCB166A302407A0E0BABE_1005639311 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1005639311;
        // ---------- Original Method ----------
        //return emulatedFields.get(name, defaultValue);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.725 -0400", hash_original_method = "076C341B7F018B893749E08DE221153C", hash_generated_method = "A63568EA8AFDBEB18FE8C695CD8B504F")
    @Override
    public boolean get(String name, boolean defaultValue) throws IOException,
            IllegalArgumentException {
        addTaint(defaultValue);
        addTaint(name.getTaint());
        boolean var167B1DF425E67AA0E63022B3EA69C87B_780565017 = (emulatedFields.get(name, defaultValue));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1148662090 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1148662090;
        // ---------- Original Method ----------
        //return emulatedFields.get(name, defaultValue);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.725 -0400", hash_original_method = "C05B1B5B49C9CD804F2B010781383CF8", hash_generated_method = "7FC8ABC74B85D244CA444A6FE5E6C915")
    @Override
    public ObjectStreamClass getObjectStreamClass() {
ObjectStreamClass varB15C7012F89088D5E62C8E84F0D75364_1436959068 =         streamClass;
        varB15C7012F89088D5E62C8E84F0D75364_1436959068.addTaint(taint);
        return varB15C7012F89088D5E62C8E84F0D75364_1436959068;
        // ---------- Original Method ----------
        //return streamClass;
    }

    
}

