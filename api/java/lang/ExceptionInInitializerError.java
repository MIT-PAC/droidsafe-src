package java.lang;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ExceptionInInitializerError extends LinkageError {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.909 -0400", hash_original_field = "42552B1F133F9F8EB406D4F306EA9FD1", hash_generated_field = "3848780C3E4557B7B025FBB998A1DBF6")

    private Throwable exception;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.909 -0400", hash_original_method = "6D1A3A1944D703E56CAA922913525A43", hash_generated_method = "FD2365B6B4CCF743258ED4506CBE1824")
    public  ExceptionInInitializerError() {
        initCause(null);
        // ---------- Original Method ----------
        //initCause(null);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.910 -0400", hash_original_method = "CDE8F850C70A27B83A36A148C961A5A1", hash_generated_method = "0D34310760947E007C2EA633765CA516")
    public  ExceptionInInitializerError(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        initCause(null);
        // ---------- Original Method ----------
        //initCause(null);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.911 -0400", hash_original_method = "C6EE88DB95324F4EE61EE6CA197E1367", hash_generated_method = "90578C0383D83BA5A895D7BA4F8F9AD9")
    public  ExceptionInInitializerError(Throwable exception) {
        this.exception = exception;
        initCause(exception);
        // ---------- Original Method ----------
        //this.exception = exception;
        //initCause(exception);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.911 -0400", hash_original_method = "7090E247F85246652792FDABBC14B51F", hash_generated_method = "C66C3470363B425BC229160B094A743A")
    public Throwable getException() {
Throwable varB0A8CAD4B1C89FFC19A72F5757E92C21_164399392 =         exception;
        varB0A8CAD4B1C89FFC19A72F5757E92C21_164399392.addTaint(taint);
        return varB0A8CAD4B1C89FFC19A72F5757E92C21_164399392;
        // ---------- Original Method ----------
        //return exception;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.911 -0400", hash_original_method = "28A8EFFB85C5CFA84BB4445EFA004CE6", hash_generated_method = "07046B3A9595BCE3CAFC4219A6E56AE3")
    @Override
    public Throwable getCause() {
Throwable varB0A8CAD4B1C89FFC19A72F5757E92C21_410448300 =         exception;
        varB0A8CAD4B1C89FFC19A72F5757E92C21_410448300.addTaint(taint);
        return varB0A8CAD4B1C89FFC19A72F5757E92C21_410448300;
        // ---------- Original Method ----------
        //return exception;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.911 -0400", hash_original_field = "4B8E39DAC3C5732C9EB5AB8EA55581C9", hash_generated_field = "7192C69596784210497884AC1F9F31E5")

    private static final long serialVersionUID = 1521711792217232256L;
}

