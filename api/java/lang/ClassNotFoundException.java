package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class ClassNotFoundException extends Exception {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.715 -0400", hash_original_field = "54D54A126A783BC9CBA8C06137136943", hash_generated_field = "F73E8300D821D42895FBD4F8215B8AE6")

    private Throwable ex;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.715 -0400", hash_original_method = "0639B59AB447390D4DDFBD24616B4C1C", hash_generated_method = "1E5153620BBC3A8E1E248DD972E06BD5")
    public  ClassNotFoundException() {
        super((Throwable) null);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.715 -0400", hash_original_method = "298BE36926392F30C6A667D05BCFC9E5", hash_generated_method = "6ADA4533E6B0190347B8DB281C46029B")
    public  ClassNotFoundException(String detailMessage) {
        super(detailMessage, null);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.715 -0400", hash_original_method = "3941F53B9B07ECD0ECA0F56417778218", hash_generated_method = "900E83B98E626A6E2C47CFB3A061CCDD")
    public  ClassNotFoundException(String detailMessage, Throwable exception) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        ex = exception;
        // ---------- Original Method ----------
        //ex = exception;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.715 -0400", hash_original_method = "4088520C94C7E98A0F8384BC5CAC9A7D", hash_generated_method = "D44708C9A453304178760BE417137051")
    public Throwable getException() {
Throwable varD25D46DC39114B3B025BF73A68F87E69_26527000 =         ex;
        varD25D46DC39114B3B025BF73A68F87E69_26527000.addTaint(taint);
        return varD25D46DC39114B3B025BF73A68F87E69_26527000;
        // ---------- Original Method ----------
        //return ex;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.715 -0400", hash_original_method = "8471E555B70ADD40A898DC66BF7F4D1C", hash_generated_method = "64A3B193533A34A6EEEE03DAC13CC903")
    @Override
    public Throwable getCause() {
Throwable varD25D46DC39114B3B025BF73A68F87E69_1846499017 =         ex;
        varD25D46DC39114B3B025BF73A68F87E69_1846499017.addTaint(taint);
        return varD25D46DC39114B3B025BF73A68F87E69_1846499017;
        // ---------- Original Method ----------
        //return ex;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.715 -0400", hash_original_field = "1ED7BB21E00FE119FAC2A7C8AF6A93B9", hash_generated_field = "FA7E6F5FBCB6CD253D61495BAEBC0CED")

    private static final long serialVersionUID = 9176873029745254542L;
}

