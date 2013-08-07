package android.text.method;

// Droidsafe Imports
import droidsafe.annotations.*;





public class SingleLineTransformationMethod extends ReplacementTransformationMethod {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.728 -0400", hash_original_method = "D4568A7EAB6F00728EAF3C3E423FA0FE", hash_generated_method = "D4568A7EAB6F00728EAF3C3E423FA0FE")
    public SingleLineTransformationMethod ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.728 -0400", hash_original_method = "64C6D73F3773427C2A2F245DBEBF22E0", hash_generated_method = "CE7C9D239DB20BF6D57569F6764C5E48")
    protected char[] getOriginal() {
        char[] varA87D5006E1DE1BFC07D5C56086AD20F1_806646478 = (ORIGINAL);
                char[] var50607924ABD4C17119BAF3A1CE41C0EC_1488557477 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1488557477;
        // ---------- Original Method ----------
        //return ORIGINAL;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.729 -0400", hash_original_method = "44611EB51BD7B665366AA2036C731932", hash_generated_method = "9243216681496FE363058C50FACD93D8")
    protected char[] getReplacement() {
        char[] varF4CC968AA79ED281D13413445DE24D82_1713938786 = (REPLACEMENT);
                char[] var50607924ABD4C17119BAF3A1CE41C0EC_1839401820 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1839401820;
        // ---------- Original Method ----------
        //return REPLACEMENT;
    }

    
    @DSModeled(DSC.SAFE)
    public static SingleLineTransformationMethod getInstance() {
        if (sInstance != null)
            return sInstance;
        sInstance = new SingleLineTransformationMethod();
        return sInstance;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.729 -0400", hash_original_field = "4AC4EB788451F78EBC24616F6EFC82B2", hash_generated_field = "98B422AB3100EE03E170C8673A5F0723")

    private static char[] ORIGINAL = new char[] { '\n', '\r' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.729 -0400", hash_original_field = "185EEC0054C0F25266726A820450EC7F", hash_generated_field = "4BECEA87476210D9FCD61E1027EFAAFB")

    private static char[] REPLACEMENT = new char[] { ' ', '\uFEFF' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.729 -0400", hash_original_field = "06E23A628CBDEAB09E91C69789BB1974", hash_generated_field = "6480497BDC465266B7D9E18C73F9BE9F")

    private static SingleLineTransformationMethod sInstance;
}

