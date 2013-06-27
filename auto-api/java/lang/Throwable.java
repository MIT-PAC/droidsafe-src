package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import libcore.util.EmptyArray;

public class Throwable implements java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.624 -0400", hash_original_field = "2444D5A1A0CC057BD6374C3E9B4D0F41", hash_generated_field = "5F933F283197F636E634092890034B15")

    private String detailMessage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.629 -0400", hash_original_field = "537E0C2318AE4467324D6EEC7309FB4E", hash_generated_field = "6C1FA207B061A6741951FC650E75192F")

    private Throwable cause = this;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.629 -0400", hash_original_field = "D5FA27B193D534D5AD5A49CD1674F13A", hash_generated_field = "DE9A96CD1773A127DE8B75F7745CAF86")

    private List<Throwable> suppressedExceptions = new ArrayList<Throwable>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.630 -0400", hash_original_field = "666085C8F3DC985E339BC454CD720C07", hash_generated_field = "5F29D314996BC5D7FD0952BE7C7301C2")

    private volatile Object stackState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.630 -0400", hash_original_field = "FCD4E36FD80F450979495718DBDDAACF", hash_generated_field = "3998EFB68B1CCA38FEA7032A25D26EC5")

    private StackTraceElement[] stackTrace;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.630 -0400", hash_original_method = "8CAF8D74185B0F181EC07276079C4966", hash_generated_method = "ACE1512A04AE15D2CD3E4D74C045CEF1")
    public  Throwable() {
        fillInStackTrace();
        // ---------- Original Method ----------
        //fillInStackTrace();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.630 -0400", hash_original_method = "22D8176BCA749706DC2B313EF94A4BA5", hash_generated_method = "C53B6C21B245FD8522B6A4526E3446CC")
    public  Throwable(String detailMessage) {
        this();
        this.detailMessage = detailMessage;
        // ---------- Original Method ----------
        //this.detailMessage = detailMessage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.631 -0400", hash_original_method = "60881CAC7A5ED0481A49F5467094E82C", hash_generated_method = "ABF63812C746C36205FAAB0BFD541C77")
    public  Throwable(String detailMessage, Throwable throwable) {
        this();
        this.detailMessage = detailMessage;
        cause = throwable;
        // ---------- Original Method ----------
        //this.detailMessage = detailMessage;
        //cause = throwable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.631 -0400", hash_original_method = "1CFFD54DEC9660238586E7A30681A82F", hash_generated_method = "EB00FCD528A423742D80C0AB8B1295C6")
    public  Throwable(Throwable throwable) {
        this();
        this.detailMessage = throwable == null ? null : throwable.toString();
        cause = throwable;
        // ---------- Original Method ----------
        //this.detailMessage = throwable == null ? null : throwable.toString();
        //cause = throwable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.631 -0400", hash_original_method = "E90AFC6F1FC322D1AB2CAA72835C3192", hash_generated_method = "C29B7A17245E02E4EC6E89F9F91645DA")
    protected  Throwable(String detailMessage, Throwable throwable, boolean enableSuppression) {
        this(detailMessage, throwable);
        {
            this.suppressedExceptions = null;
        } //End block
        addTaint(detailMessage.getTaint());
        addTaint(throwable.getTaint());
        addTaint(enableSuppression);
        // ---------- Original Method ----------
        //if (!enableSuppression) {
            //this.suppressedExceptions = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.632 -0400", hash_original_method = "1BF0D9E451222474F2DDB047C74BA127", hash_generated_method = "5331E162C711AE4C28E10E37E032D036")
    public Throwable fillInStackTrace() {
        Throwable varB4EAC82CA7396A68D541C85D26508E83_450696565 = null; //Variable for return #1
        stackState = nativeFillInStackTrace();
        stackTrace = null;
        varB4EAC82CA7396A68D541C85D26508E83_450696565 = this;
        varB4EAC82CA7396A68D541C85D26508E83_450696565.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_450696565;
        // ---------- Original Method ----------
        //stackState = nativeFillInStackTrace();
        //stackTrace = null;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.633 -0400", hash_original_method = "DB11282615D634E343F956A1D91DEDE9", hash_generated_method = "08D284B1E6C63B7BBB233224AF737019")
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_994268167 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_994268167 = detailMessage;
        varB4EAC82CA7396A68D541C85D26508E83_994268167.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_994268167;
        // ---------- Original Method ----------
        //return detailMessage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.642 -0400", hash_original_method = "A2EE7B7852887DFBE3A27B61B4F72974", hash_generated_method = "E1119E3E6B277C34C4C35C379E6FF634")
    public String getLocalizedMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_728876401 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_728876401 = getMessage();
        varB4EAC82CA7396A68D541C85D26508E83_728876401.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_728876401;
        // ---------- Original Method ----------
        //return getMessage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.643 -0400", hash_original_method = "45FE0FF583AFF2392C672B8C003FC38F", hash_generated_method = "D5507F7ECC5E0F8B2F5542DED2481AFA")
    public StackTraceElement[] getStackTrace() {
        StackTraceElement[] varB4EAC82CA7396A68D541C85D26508E83_276981530 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_276981530 = getInternalStackTrace().clone();
        varB4EAC82CA7396A68D541C85D26508E83_276981530.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_276981530;
        // ---------- Original Method ----------
        //return getInternalStackTrace().clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.657 -0400", hash_original_method = "5E6079B0EA3605E8298E1D15C30F6678", hash_generated_method = "20412A8CF2763D77770177A6CE6CEF65")
    public void setStackTrace(StackTraceElement[] trace) {
        StackTraceElement[] newTrace;
        newTrace = trace.clone();
        {
            Iterator<StackTraceElement> var67311226A26F7AA344538713AA2E780A_1872775215 = (newTrace).iterator();
            var67311226A26F7AA344538713AA2E780A_1872775215.hasNext();
            StackTraceElement element = var67311226A26F7AA344538713AA2E780A_1872775215.next();
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
                } //End block
            } //End block
        } //End collapsed parenthetic
        stackTrace = newTrace;
        addTaint(trace[0].getTaint());
        // ---------- Original Method ----------
        //StackTraceElement[] newTrace = trace.clone();
        //for (StackTraceElement element : newTrace) {
            //if (element == null) {
                //throw new NullPointerException();
            //}
        //}
        //stackTrace = newTrace;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.666 -0400", hash_original_method = "325BA3C27FA0D6128256227B9178A07C", hash_generated_method = "0A8D9DAF6B72F03425FA01ACFEA76A6C")
    public void printStackTrace() {
        printStackTrace(System.err);
        // ---------- Original Method ----------
        //printStackTrace(System.err);
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.666 -0400", hash_original_method = "5A8373E0D01D66F3E38F3485979BD426", hash_generated_method = "3616798CF3AE863B43D153C5CD317A1E")
    private StackTraceElement[] getInternalStackTrace() {
        StackTraceElement[] varB4EAC82CA7396A68D541C85D26508E83_1074850772 = null; //Variable for return #1
        {
            stackTrace = nativeGetStackTrace(stackState);
            stackState = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1074850772 = stackTrace;
        varB4EAC82CA7396A68D541C85D26508E83_1074850772.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1074850772;
        // ---------- Original Method ----------
        //if (stackTrace == null) {
            //stackTrace = nativeGetStackTrace(stackState);
            //stackState = null; 
        //}
        //return stackTrace;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.667 -0400", hash_original_method = "721611E9E00924F0C591FE9FD87A98DF", hash_generated_method = "C404D824E1ECBBAF73A40E8301223ED8")
    public void printStackTrace(PrintStream err) {
        try 
        {
            printStackTrace(err, "", null);
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError();
        } //End block
        addTaint(err.getTaint());
        // ---------- Original Method ----------
        //try {
            //printStackTrace(err, "", null);
        //} catch (IOException e) {
            //throw new AssertionError();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.667 -0400", hash_original_method = "83BBC2719839E738869257F8A62E26AC", hash_generated_method = "42CEAA1E6F3A404086A6739A739A0BC0")
    public void printStackTrace(PrintWriter err) {
        try 
        {
            printStackTrace(err, "", null);
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError();
        } //End block
        addTaint(err.getTaint());
        // ---------- Original Method ----------
        //try {
            //printStackTrace(err, "", null);
        //} catch (IOException e) {
            //throw new AssertionError();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.692 -0400", hash_original_method = "9161BE82060982591CF587E371FF5EC1", hash_generated_method = "0545667F29580EF5F0E4AC18CB36FB5A")
    private void printStackTrace(Appendable err, String indent, StackTraceElement[] parentStack) throws IOException {
        err.append(toString());
        err.append("\n");
        StackTraceElement[] stack;
        stack = getInternalStackTrace();
        {
            int duplicates;
            duplicates = countDuplicates(stack, parentStack);
            duplicates = 0;
            {
                int i;
                i = 0;
                {
                    err.append(indent);
                    err.append("\tat ");
                    err.append(stack[i].toString());
                    err.append("\n");
                } //End block
            } //End collapsed parenthetic
            {
                err.append(indent);
                err.append("\t... ");
                err.append(Integer.toString(duplicates));
                err.append(" more\n");
            } //End block
        } //End block
        {
            {
                Iterator<Throwable> var0FF3FD76858DB4AF60FC96A39A1E9C6A_498726142 = (suppressedExceptions).iterator();
                var0FF3FD76858DB4AF60FC96A39A1E9C6A_498726142.hasNext();
                Throwable throwable = var0FF3FD76858DB4AF60FC96A39A1E9C6A_498726142.next();
                {
                    err.append(indent);
                    err.append("\tSuppressed: ");
                    throwable.printStackTrace(err, indent + "\t", stack);
                } //End block
            } //End collapsed parenthetic
        } //End block
        Throwable cause;
        cause = getCause();
        {
            err.append(indent);
            err.append("Caused by: ");
            cause.printStackTrace(err, indent, stack);
        } //End block
        addTaint(err.getTaint());
        addTaint(indent.getTaint());
        addTaint(parentStack[0].getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.700 -0400", hash_original_method = "D135C496474AE8F48C2BC1E13C422ADC", hash_generated_method = "5F0078906837E029AC560AE6A847A107")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1470437037 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2126421375 = null; //Variable for return #2
        String msg;
        msg = getLocalizedMessage();
        String name;
        name = getClass().getName();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1470437037 = name;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2126421375 = name + ": " + msg;
        String varA7E53CE21691AB073D9660D615818899_1315030632; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1315030632 = varB4EAC82CA7396A68D541C85D26508E83_1470437037;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1315030632 = varB4EAC82CA7396A68D541C85D26508E83_2126421375;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1315030632.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1315030632;
        // ---------- Original Method ----------
        //String msg = getLocalizedMessage();
        //String name = getClass().getName();
        //if (msg == null) {
            //return name;
        //}
        //return name + ": " + msg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.700 -0400", hash_original_method = "C6146D344F8C29A6B259252212744901", hash_generated_method = "C4903CE4C652861A85556F8272B3EE04")
    public Throwable initCause(Throwable throwable) {
        Throwable varB4EAC82CA7396A68D541C85D26508E83_1479724 = null; //Variable for return #1
        {
            boolean varB05AA5E101053C5176A660C03B088B9D_348781830 = (cause != this);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Cause already initialized");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varA6800162B0D4E243175AB8FD0DB3A8EC_1170983294 = (throwable == this);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("throwable == this");
            } //End block
        } //End collapsed parenthetic
        cause = throwable;
        varB4EAC82CA7396A68D541C85D26508E83_1479724 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1479724.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1479724;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.701 -0400", hash_original_method = "22464C579A8BDBBA630699F5CFE21CE6", hash_generated_method = "C02572B20E95E0D6375D38F4A44A305E")
    public Throwable getCause() {
        Throwable varB4EAC82CA7396A68D541C85D26508E83_80481205 = null; //Variable for return #1
        Throwable varB4EAC82CA7396A68D541C85D26508E83_895255350 = null; //Variable for return #2
        {
            boolean var974C88151AE5388A12E2F75475C2D5B4_1945910036 = (cause == this);
            {
                varB4EAC82CA7396A68D541C85D26508E83_80481205 = null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_895255350 = cause;
        Throwable varA7E53CE21691AB073D9660D615818899_943118665; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_943118665 = varB4EAC82CA7396A68D541C85D26508E83_80481205;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_943118665 = varB4EAC82CA7396A68D541C85D26508E83_895255350;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_943118665.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_943118665;
        // ---------- Original Method ----------
        //if (cause == this) {
            //return null;
        //}
        //return cause;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.701 -0400", hash_original_method = "FE7E0A038916A44CD2EDEB98621E4496", hash_generated_method = "EA3269A10D90B890AFC737AC72A50035")
    public final void addSuppressed(Throwable throwable) {
        {
            boolean varA6800162B0D4E243175AB8FD0DB3A8EC_261760770 = (throwable == this);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("suppressed == this");
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("suppressed == null");
        } //End block
        {
            suppressedExceptions.add(throwable);
        } //End block
        addTaint(throwable.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.705 -0400", hash_original_method = "8B184B5B883F2271AE4A6DCD97FDDD74", hash_generated_method = "518C7AE407C607E61C5217E57091F5FC")
    public final Throwable[] getSuppressed() {
        Throwable[] varB4EAC82CA7396A68D541C85D26508E83_1388967622 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1388967622 = (suppressedExceptions != null)
                ? suppressedExceptions.toArray(new Throwable[suppressedExceptions.size()])
                : EmptyArray.THROWABLE;
        varB4EAC82CA7396A68D541C85D26508E83_1388967622.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1388967622;
        // ---------- Original Method ----------
        //return (suppressedExceptions != null)
                //? suppressedExceptions.toArray(new Throwable[suppressedExceptions.size()])
                //: EmptyArray.THROWABLE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.705 -0400", hash_original_method = "9B67B0A60488A3B6BF6B1F8E333B2B37", hash_generated_method = "FA51E0848E70D4E81F528907BD16A2D1")
    private void writeObject(ObjectOutputStream out) throws IOException {
        getInternalStackTrace();
        out.defaultWriteObject();
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //getInternalStackTrace();
        //out.defaultWriteObject();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.706 -0400", hash_original_method = "D9E2A8DEA9D5CE3A923EF2188BD1E0E9", hash_generated_method = "EB6495AE9BF601FAB76CE9B36360B378")
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        {
            suppressedExceptions = new ArrayList<Throwable>(suppressedExceptions);
        } //End block
        addTaint(in.getTaint());
        // ---------- Original Method ----------
        //in.defaultReadObject();
        //if (suppressedExceptions != null) {
            //suppressedExceptions = new ArrayList<Throwable>(suppressedExceptions);
        //}
    }

    
        private static Object nativeFillInStackTrace() {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        private static StackTraceElement[] nativeGetStackTrace(Object stackState) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.711 -0400", hash_original_field = "148A70AC82907F97956B1718282EB51D", hash_generated_field = "12BF9B3F18ED231B05FEA8A187EEB78F")

    private static long serialVersionUID = -3042686055658047285L;
}

