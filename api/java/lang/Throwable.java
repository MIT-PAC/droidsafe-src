package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import libcore.util.EmptyArray;

public class Throwable implements java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.615 -0400", hash_original_field = "2444D5A1A0CC057BD6374C3E9B4D0F41", hash_generated_field = "5F933F283197F636E634092890034B15")

    private String detailMessage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.615 -0400", hash_original_field = "537E0C2318AE4467324D6EEC7309FB4E", hash_generated_field = "6C1FA207B061A6741951FC650E75192F")

    private Throwable cause = this;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.615 -0400", hash_original_field = "D5FA27B193D534D5AD5A49CD1674F13A", hash_generated_field = "DE9A96CD1773A127DE8B75F7745CAF86")

    private List<Throwable> suppressedExceptions = new ArrayList<Throwable>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.615 -0400", hash_original_field = "666085C8F3DC985E339BC454CD720C07", hash_generated_field = "5F29D314996BC5D7FD0952BE7C7301C2")

    private volatile Object stackState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.615 -0400", hash_original_field = "FCD4E36FD80F450979495718DBDDAACF", hash_generated_field = "3998EFB68B1CCA38FEA7032A25D26EC5")

    private StackTraceElement[] stackTrace;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.615 -0400", hash_original_method = "8CAF8D74185B0F181EC07276079C4966", hash_generated_method = "ACE1512A04AE15D2CD3E4D74C045CEF1")
    public  Throwable() {
        fillInStackTrace();
        // ---------- Original Method ----------
        //fillInStackTrace();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.616 -0400", hash_original_method = "22D8176BCA749706DC2B313EF94A4BA5", hash_generated_method = "C53B6C21B245FD8522B6A4526E3446CC")
    public  Throwable(String detailMessage) {
        this();
        this.detailMessage = detailMessage;
        // ---------- Original Method ----------
        //this.detailMessage = detailMessage;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.617 -0400", hash_original_method = "60881CAC7A5ED0481A49F5467094E82C", hash_generated_method = "ABF63812C746C36205FAAB0BFD541C77")
    public  Throwable(String detailMessage, Throwable throwable) {
        this();
        this.detailMessage = detailMessage;
        cause = throwable;
        // ---------- Original Method ----------
        //this.detailMessage = detailMessage;
        //cause = throwable;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.618 -0400", hash_original_method = "1CFFD54DEC9660238586E7A30681A82F", hash_generated_method = "EB00FCD528A423742D80C0AB8B1295C6")
    public  Throwable(Throwable throwable) {
        this();
        this.detailMessage = throwable == null ? null : throwable.toString();
        cause = throwable;
        // ---------- Original Method ----------
        //this.detailMessage = throwable == null ? null : throwable.toString();
        //cause = throwable;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.619 -0400", hash_original_method = "E90AFC6F1FC322D1AB2CAA72835C3192", hash_generated_method = "F59C306B1BC63EC8029895A88BBF35D8")
    protected  Throwable(String detailMessage, Throwable throwable, boolean enableSuppression) {
        this(detailMessage, throwable);
        addTaint(enableSuppression);
        addTaint(throwable.getTaint());
        addTaint(detailMessage.getTaint());
        if(!enableSuppression)        
        {
            this.suppressedExceptions = null;
        } //End block
        // ---------- Original Method ----------
        //if (!enableSuppression) {
            //this.suppressedExceptions = null;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.620 -0400", hash_original_method = "1BF0D9E451222474F2DDB047C74BA127", hash_generated_method = "1F75BFA71B994B51A8F11B6A3FC3E3E8")
    public Throwable fillInStackTrace() {
        stackState = nativeFillInStackTrace();
        stackTrace = null;
Throwable var72A74007B2BE62B849F475C7BDA4658B_1606023924 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1606023924.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1606023924;
        // ---------- Original Method ----------
        //stackState = nativeFillInStackTrace();
        //stackTrace = null;
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.620 -0400", hash_original_method = "DB11282615D634E343F956A1D91DEDE9", hash_generated_method = "EEB9F0BC96779E0561D300FFBFB881C4")
    public String getMessage() {
String var914F0E3A6F3E0C9A3F7C87C0A85A26CF_1674407605 =         detailMessage;
        var914F0E3A6F3E0C9A3F7C87C0A85A26CF_1674407605.addTaint(taint);
        return var914F0E3A6F3E0C9A3F7C87C0A85A26CF_1674407605;
        // ---------- Original Method ----------
        //return detailMessage;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.621 -0400", hash_original_method = "A2EE7B7852887DFBE3A27B61B4F72974", hash_generated_method = "2F1158EC0F6791A276BBFA6918A845DA")
    public String getLocalizedMessage() {
String var161DE919C6E3D4B838448EC95B86CE9B_1636571261 =         getMessage();
        var161DE919C6E3D4B838448EC95B86CE9B_1636571261.addTaint(taint);
        return var161DE919C6E3D4B838448EC95B86CE9B_1636571261;
        // ---------- Original Method ----------
        //return getMessage();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.621 -0400", hash_original_method = "45FE0FF583AFF2392C672B8C003FC38F", hash_generated_method = "A873520F7DDCA9730040D42ADC7EF742")
    public StackTraceElement[] getStackTrace() {
StackTraceElement[] var5697AB0544D7BD869395C498F717468B_358984184 =         getInternalStackTrace().clone();
        var5697AB0544D7BD869395C498F717468B_358984184.addTaint(taint);
        return var5697AB0544D7BD869395C498F717468B_358984184;
        // ---------- Original Method ----------
        //return getInternalStackTrace().clone();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.623 -0400", hash_original_method = "5E6079B0EA3605E8298E1D15C30F6678", hash_generated_method = "8F5011A0C22E83C977794986C020214A")
    public void setStackTrace(StackTraceElement[] trace) {
        addTaint(trace[0].getTaint());
        StackTraceElement[] newTrace = trace.clone();
for(StackTraceElement element : newTrace)
        {
            if(element == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1058601312 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_1058601312.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_1058601312;
            } //End block
        } //End block
        stackTrace = newTrace;
        // ---------- Original Method ----------
        //StackTraceElement[] newTrace = trace.clone();
        //for (StackTraceElement element : newTrace) {
            //if (element == null) {
                //throw new NullPointerException();
            //}
        //}
        //stackTrace = newTrace;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.624 -0400", hash_original_method = "325BA3C27FA0D6128256227B9178A07C", hash_generated_method = "0A8D9DAF6B72F03425FA01ACFEA76A6C")
    public void printStackTrace() {
        printStackTrace(System.err);
        // ---------- Original Method ----------
        //printStackTrace(System.err);
    }

    
    @DSModeled(DSC.SAFE)
    private static int countDuplicates(StackTraceElement[] currentStack,
            StackTraceElement[] parentStack) {
        int duplicates = 0;
        int parentIndex = parentStack.length;
        for (int i = currentStack.length; --i >= 0 && --parentIndex >= 0;) {
            StackTraceElement parentFrame = parentStack[parentIndex];
            if (parentFrame.equals(currentStack[i])) {
                duplicates++;
            } else {
                break;
            }
        }
        return duplicates;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.625 -0400", hash_original_method = "5A8373E0D01D66F3E38F3485979BD426", hash_generated_method = "CA40D027FB0933464078815A8A279275")
    private StackTraceElement[] getInternalStackTrace() {
        if(stackTrace == null)        
        {
            stackTrace = nativeGetStackTrace(stackState);
            stackState = null;
        } //End block
StackTraceElement[] var34BB737E13D79EA416E90CF26ABC237E_1378528702 =         stackTrace;
        var34BB737E13D79EA416E90CF26ABC237E_1378528702.addTaint(taint);
        return var34BB737E13D79EA416E90CF26ABC237E_1378528702;
        // ---------- Original Method ----------
        //if (stackTrace == null) {
            //stackTrace = nativeGetStackTrace(stackState);
            //stackState = null; 
        //}
        //return stackTrace;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.626 -0400", hash_original_method = "721611E9E00924F0C591FE9FD87A98DF", hash_generated_method = "A3A15664E8292EA1C653493A9B7664F4")
    public void printStackTrace(PrintStream err) {
        addTaint(err.getTaint());
        try 
        {
            printStackTrace(err, "", null);
        } //End block
        catch (IOException e)
        {
            AssertionError varA81442E36297E737EB908877E58260E8_241256347 = new AssertionError();
            varA81442E36297E737EB908877E58260E8_241256347.addTaint(taint);
            throw varA81442E36297E737EB908877E58260E8_241256347;
        } //End block
        // ---------- Original Method ----------
        //try {
            //printStackTrace(err, "", null);
        //} catch (IOException e) {
            //throw new AssertionError();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.627 -0400", hash_original_method = "83BBC2719839E738869257F8A62E26AC", hash_generated_method = "B3E6605B6B6B9377A80F8A793776B01A")
    public void printStackTrace(PrintWriter err) {
        addTaint(err.getTaint());
        try 
        {
            printStackTrace(err, "", null);
        } //End block
        catch (IOException e)
        {
            AssertionError varA81442E36297E737EB908877E58260E8_778494787 = new AssertionError();
            varA81442E36297E737EB908877E58260E8_778494787.addTaint(taint);
            throw varA81442E36297E737EB908877E58260E8_778494787;
        } //End block
        // ---------- Original Method ----------
        //try {
            //printStackTrace(err, "", null);
        //} catch (IOException e) {
            //throw new AssertionError();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.629 -0400", hash_original_method = "9161BE82060982591CF587E371FF5EC1", hash_generated_method = "A69A1B0472FD5DA53C293B7A5B8152EF")
    private void printStackTrace(Appendable err, String indent, StackTraceElement[] parentStack) throws IOException {
        addTaint(parentStack[0].getTaint());
        addTaint(indent.getTaint());
        addTaint(err.getTaint());
        err.append(toString());
        err.append("\n");
        StackTraceElement[] stack = getInternalStackTrace();
        if(stack != null)        
        {
            int duplicates = parentStack != null ? countDuplicates(stack, parentStack) : 0;
for(int i = 0;i < stack.length - duplicates;i++)
            {
                err.append(indent);
                err.append("\tat ");
                err.append(stack[i].toString());
                err.append("\n");
            } //End block
            if(duplicates > 0)            
            {
                err.append(indent);
                err.append("\t... ");
                err.append(Integer.toString(duplicates));
                err.append(" more\n");
            } //End block
        } //End block
        if(suppressedExceptions != null)        
        {
for(Throwable throwable : suppressedExceptions)
            {
                err.append(indent);
                err.append("\tSuppressed: ");
                throwable.printStackTrace(err, indent + "\t", stack);
            } //End block
        } //End block
        Throwable cause = getCause();
        if(cause != null)        
        {
            err.append(indent);
            err.append("Caused by: ");
            cause.printStackTrace(err, indent, stack);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.631 -0400", hash_original_method = "D135C496474AE8F48C2BC1E13C422ADC", hash_generated_method = "74FD90071B4FA1A30ED8D4EFD3EFBB43")
    @Override
    public String toString() {
        String msg = getLocalizedMessage();
        String name = getClass().getName();
        if(msg == null)        
        {
String varB017984728AC60AD1F0BF8734F33F15C_1736303080 =             name;
            varB017984728AC60AD1F0BF8734F33F15C_1736303080.addTaint(taint);
            return varB017984728AC60AD1F0BF8734F33F15C_1736303080;
        } //End block
String var35530EECD2FCDEAD41FFCFC99552BF10_145925295 =         name + ": " + msg;
        var35530EECD2FCDEAD41FFCFC99552BF10_145925295.addTaint(taint);
        return var35530EECD2FCDEAD41FFCFC99552BF10_145925295;
        // ---------- Original Method ----------
        //String msg = getLocalizedMessage();
        //String name = getClass().getName();
        //if (msg == null) {
            //return name;
        //}
        //return name + ": " + msg;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.631 -0400", hash_original_method = "C6146D344F8C29A6B259252212744901", hash_generated_method = "C5FA19F35FE8BC99CF81D1D910759AC7")
    public Throwable initCause(Throwable throwable) {
        if(cause != this)        
        {
            IllegalStateException var3F41D29A62A76FDCE33DF5C6FB6B6F7D_674764054 = new IllegalStateException("Cause already initialized");
            var3F41D29A62A76FDCE33DF5C6FB6B6F7D_674764054.addTaint(taint);
            throw var3F41D29A62A76FDCE33DF5C6FB6B6F7D_674764054;
        } //End block
        if(throwable == this)        
        {
            IllegalArgumentException var1965C38C7B755512BFCCD2A47B240FDA_1585532537 = new IllegalArgumentException("throwable == this");
            var1965C38C7B755512BFCCD2A47B240FDA_1585532537.addTaint(taint);
            throw var1965C38C7B755512BFCCD2A47B240FDA_1585532537;
        } //End block
        cause = throwable;
Throwable var72A74007B2BE62B849F475C7BDA4658B_1689600004 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1689600004.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1689600004;
        // ---------- Original Method ----------
        //if (cause != this) {
            //throw new IllegalStateException("Cause already initialized");
        //}
        //if (throwable == this) {
            //throw new IllegalArgumentException("throwable == this");
        //}
        //cause = throwable;
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.632 -0400", hash_original_method = "22464C579A8BDBBA630699F5CFE21CE6", hash_generated_method = "D5FBC3D2820A705CD496B0A0702D5C2D")
    public Throwable getCause() {
        if(cause == this)        
        {
Throwable var540C13E9E156B687226421B24F2DF178_1025994416 =             null;
            var540C13E9E156B687226421B24F2DF178_1025994416.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1025994416;
        } //End block
Throwable var3C8F3313F49435961542E8707E527956_1458256153 =         cause;
        var3C8F3313F49435961542E8707E527956_1458256153.addTaint(taint);
        return var3C8F3313F49435961542E8707E527956_1458256153;
        // ---------- Original Method ----------
        //if (cause == this) {
            //return null;
        //}
        //return cause;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.632 -0400", hash_original_method = "FE7E0A038916A44CD2EDEB98621E4496", hash_generated_method = "436F8FDD701EDD1BFA95D48667315EE2")
    public final void addSuppressed(Throwable throwable) {
        addTaint(throwable.getTaint());
        if(throwable == this)        
        {
            IllegalArgumentException var0D83DF8785B43495C5AF1B3C951249A3_157912188 = new IllegalArgumentException("suppressed == this");
            var0D83DF8785B43495C5AF1B3C951249A3_157912188.addTaint(taint);
            throw var0D83DF8785B43495C5AF1B3C951249A3_157912188;
        } //End block
        if(throwable == null)        
        {
            NullPointerException var229669F0A2699659A1AE1A55ECDE7868_1320097088 = new NullPointerException("suppressed == null");
            var229669F0A2699659A1AE1A55ECDE7868_1320097088.addTaint(taint);
            throw var229669F0A2699659A1AE1A55ECDE7868_1320097088;
        } //End block
        if(suppressedExceptions != null)        
        {
            suppressedExceptions.add(throwable);
        } //End block
        // ---------- Original Method ----------
        //if (throwable == this) {
            //throw new IllegalArgumentException("suppressed == this");
        //}
        //if (throwable == null) {
            //throw new NullPointerException("suppressed == null");
        //}
        //if (suppressedExceptions != null) {
            //suppressedExceptions.add(throwable);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.633 -0400", hash_original_method = "8B184B5B883F2271AE4A6DCD97FDDD74", hash_generated_method = "C79E6C1B6074A8ABF867B44AA0A63F96")
    public final Throwable[] getSuppressed() {
Throwable[] var3A15AFB91A649D7F40FA832976B63DE8_675596110 =         (suppressedExceptions != null)
                ? suppressedExceptions.toArray(new Throwable[suppressedExceptions.size()])
                : EmptyArray.THROWABLE;
        var3A15AFB91A649D7F40FA832976B63DE8_675596110.addTaint(taint);
        return var3A15AFB91A649D7F40FA832976B63DE8_675596110;
        // ---------- Original Method ----------
        //return (suppressedExceptions != null)
                //? suppressedExceptions.toArray(new Throwable[suppressedExceptions.size()])
                //: EmptyArray.THROWABLE;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.633 -0400", hash_original_method = "9B67B0A60488A3B6BF6B1F8E333B2B37", hash_generated_method = "69B9BD3E909BC1656E915C2D03DA1729")
    private void writeObject(ObjectOutputStream out) throws IOException {
        addTaint(out.getTaint());
        getInternalStackTrace();
        out.defaultWriteObject();
        // ---------- Original Method ----------
        //getInternalStackTrace();
        //out.defaultWriteObject();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.633 -0400", hash_original_method = "D9E2A8DEA9D5CE3A923EF2188BD1E0E9", hash_generated_method = "B93F62DC035F095BBCAF219EA2AC3384")
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        addTaint(in.getTaint());
        in.defaultReadObject();
        if(suppressedExceptions != null)        
        {
            suppressedExceptions = new ArrayList<Throwable>(suppressedExceptions);
        } //End block
        // ---------- Original Method ----------
        //in.defaultReadObject();
        //if (suppressedExceptions != null) {
            //suppressedExceptions = new ArrayList<Throwable>(suppressedExceptions);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    private static Object nativeFillInStackTrace() {
    	return new Object();
    }

    
    @DSModeled(DSC.SAFE)
    private static StackTraceElement[] nativeGetStackTrace(Object stackState) {
    	StackTraceElement[] ret = new StackTraceElement[0];
    	ret[0].addTaint(stackState.taint);
    	return ret;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.634 -0400", hash_original_field = "148A70AC82907F97956B1718282EB51D", hash_generated_field = "02CA67A79E3766B4E9DFDCEAEB0383C0")

    private static final long serialVersionUID = -3042686055658047285L;
}

