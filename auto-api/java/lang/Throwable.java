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
    private String detailMessage;
    private Throwable cause = this;
    private List<Throwable> suppressedExceptions = new ArrayList<Throwable>();
    private volatile Object stackState;
    private StackTraceElement[] stackTrace;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.573 -0400", hash_original_method = "8CAF8D74185B0F181EC07276079C4966", hash_generated_method = "ACE1512A04AE15D2CD3E4D74C045CEF1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Throwable() {
        fillInStackTrace();
        // ---------- Original Method ----------
        //fillInStackTrace();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.573 -0400", hash_original_method = "22D8176BCA749706DC2B313EF94A4BA5", hash_generated_method = "A3421DBCA68A7E906F57C63D655FB36D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Throwable(String detailMessage) {
        this();
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
        //this.detailMessage = detailMessage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.573 -0400", hash_original_method = "60881CAC7A5ED0481A49F5467094E82C", hash_generated_method = "0063077F616EBF66AB3A8136B787A424")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Throwable(String detailMessage, Throwable throwable) {
        this();
        dsTaint.addTaint(throwable.dsTaint);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
        //this.detailMessage = detailMessage;
        //cause = throwable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.573 -0400", hash_original_method = "1CFFD54DEC9660238586E7A30681A82F", hash_generated_method = "22573A033FA7D3AEAA79075311A65124")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Throwable(Throwable throwable) {
        this();
        dsTaint.addTaint(throwable.dsTaint);
        this.detailMessage = throwable == null ? null : throwable.toString();
        // ---------- Original Method ----------
        //this.detailMessage = throwable == null ? null : throwable.toString();
        //cause = throwable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.574 -0400", hash_original_method = "E90AFC6F1FC322D1AB2CAA72835C3192", hash_generated_method = "8DECDB872402DCF7FAFDFBFA13917772")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Throwable(String detailMessage, Throwable throwable, boolean enableSuppression) {
        this(detailMessage, throwable);
        dsTaint.addTaint(throwable.dsTaint);
        dsTaint.addTaint(detailMessage);
        dsTaint.addTaint(enableSuppression);
        {
            this.suppressedExceptions = null;
        } //End block
        // ---------- Original Method ----------
        //if (!enableSuppression) {
            //this.suppressedExceptions = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.574 -0400", hash_original_method = "1BF0D9E451222474F2DDB047C74BA127", hash_generated_method = "45AA68ED04C1F1F2D3A8C0A5EC50D936")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Throwable fillInStackTrace() {
        stackState = nativeFillInStackTrace();
        stackTrace = null;
        return (Throwable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //stackState = nativeFillInStackTrace();
        //stackTrace = null;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.574 -0400", hash_original_method = "DB11282615D634E343F956A1D91DEDE9", hash_generated_method = "5AD436B3183E29091981A7B1085D4183")
    @DSModeled(DSC.SAFE)
    public String getMessage() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return detailMessage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.574 -0400", hash_original_method = "A2EE7B7852887DFBE3A27B61B4F72974", hash_generated_method = "1E530AB0B9C63C6189814981C27A7DD0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getLocalizedMessage() {
        String var00B89656DBC4A557EC1B04ADBC5951F6_446348302 = (getMessage());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getMessage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.574 -0400", hash_original_method = "45FE0FF583AFF2392C672B8C003FC38F", hash_generated_method = "49648CE954F1B0755A3ACE45596336B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StackTraceElement[] getStackTrace() {
        StackTraceElement[] varA76866BD08C086E02D5851261ED3C015_723737965 = (getInternalStackTrace().clone());
        return (StackTraceElement[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getInternalStackTrace().clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.577 -0400", hash_original_method = "5E6079B0EA3605E8298E1D15C30F6678", hash_generated_method = "9FD3C0216313477D89171B420AF02064")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setStackTrace(StackTraceElement[] trace) {
        dsTaint.addTaint(trace[0].dsTaint);
        StackTraceElement[] newTrace;
        newTrace = trace.clone();
        {
            StackTraceElement element = newTrace[0];
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
                } //End block
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.577 -0400", hash_original_method = "325BA3C27FA0D6128256227B9178A07C", hash_generated_method = "0A8D9DAF6B72F03425FA01ACFEA76A6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.578 -0400", hash_original_method = "5A8373E0D01D66F3E38F3485979BD426", hash_generated_method = "39C89BE01FC9841DC059EA6D33C6BD6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private StackTraceElement[] getInternalStackTrace() {
        {
            stackTrace = nativeGetStackTrace(stackState);
            stackState = null;
        } //End block
        return (StackTraceElement[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (stackTrace == null) {
            //stackTrace = nativeGetStackTrace(stackState);
            //stackState = null; 
        //}
        //return stackTrace;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.578 -0400", hash_original_method = "721611E9E00924F0C591FE9FD87A98DF", hash_generated_method = "B232735E306191697D1FA1BA4C14C13C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void printStackTrace(PrintStream err) {
        dsTaint.addTaint(err.dsTaint);
        try 
        {
            printStackTrace(err, "", null);
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError();
        } //End block
        // ---------- Original Method ----------
        //try {
            //printStackTrace(err, "", null);
        //} catch (IOException e) {
            //throw new AssertionError();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.578 -0400", hash_original_method = "83BBC2719839E738869257F8A62E26AC", hash_generated_method = "4AB840F96B21E3221E7DAB0B6553F649")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void printStackTrace(PrintWriter err) {
        dsTaint.addTaint(err.dsTaint);
        try 
        {
            printStackTrace(err, "", null);
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError();
        } //End block
        // ---------- Original Method ----------
        //try {
            //printStackTrace(err, "", null);
        //} catch (IOException e) {
            //throw new AssertionError();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.594 -0400", hash_original_method = "9161BE82060982591CF587E371FF5EC1", hash_generated_method = "11362F52DACA1CED64A9DA624765F46C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void printStackTrace(Appendable err, String indent, StackTraceElement[] parentStack) throws IOException {
        dsTaint.addTaint(indent);
        dsTaint.addTaint(err.dsTaint);
        dsTaint.addTaint(parentStack[0].dsTaint);
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
                Iterator<Throwable> var0FF3FD76858DB4AF60FC96A39A1E9C6A_157701596 = (suppressedExceptions).iterator();
                var0FF3FD76858DB4AF60FC96A39A1E9C6A_157701596.hasNext();
                Throwable throwable = var0FF3FD76858DB4AF60FC96A39A1E9C6A_157701596.next();
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.606 -0400", hash_original_method = "D135C496474AE8F48C2BC1E13C422ADC", hash_generated_method = "026BC15FE42FCAB30662CD8519C4CD43")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String msg;
        msg = getLocalizedMessage();
        String name;
        name = getClass().getName();
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String msg = getLocalizedMessage();
        //String name = getClass().getName();
        //if (msg == null) {
            //return name;
        //}
        //return name + ": " + msg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.606 -0400", hash_original_method = "C6146D344F8C29A6B259252212744901", hash_generated_method = "842AE678D95323F26D036438CA18F3FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Throwable initCause(Throwable throwable) {
        dsTaint.addTaint(throwable.dsTaint);
        {
            boolean varB05AA5E101053C5176A660C03B088B9D_1203340931 = (cause != this);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Cause already initialized");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varA6800162B0D4E243175AB8FD0DB3A8EC_1238770796 = (throwable == this);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("throwable == this");
            } //End block
        } //End collapsed parenthetic
        return (Throwable)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.615 -0400", hash_original_method = "22464C579A8BDBBA630699F5CFE21CE6", hash_generated_method = "FB6B6581F02A99B9EB8384AAC3D2EC41")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Throwable getCause() {
        {
            boolean var974C88151AE5388A12E2F75475C2D5B4_1490025511 = (cause == this);
        } //End collapsed parenthetic
        return (Throwable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (cause == this) {
            //return null;
        //}
        //return cause;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.616 -0400", hash_original_method = "FE7E0A038916A44CD2EDEB98621E4496", hash_generated_method = "87C314B70CE4D49703FD6BA1555C79B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void addSuppressed(Throwable throwable) {
        dsTaint.addTaint(throwable.dsTaint);
        {
            boolean varA6800162B0D4E243175AB8FD0DB3A8EC_1619650639 = (throwable == this);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.620 -0400", hash_original_method = "8B184B5B883F2271AE4A6DCD97FDDD74", hash_generated_method = "691FB88C96D56358C90E888E474752FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Throwable[] getSuppressed() {
        {
            Object var146EFFE8DB6D2DDD56A69E23FA8E747E_226909538 = (suppressedExceptions.toArray(new Throwable[suppressedExceptions.size()]));
        } //End flattened ternary
        return (Throwable[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (suppressedExceptions != null)
                //? suppressedExceptions.toArray(new Throwable[suppressedExceptions.size()])
                //: EmptyArray.THROWABLE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.620 -0400", hash_original_method = "9B67B0A60488A3B6BF6B1F8E333B2B37", hash_generated_method = "FDDFD7404E0D2A8F8C5098C963501BD4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeObject(ObjectOutputStream out) throws IOException {
        dsTaint.addTaint(out.dsTaint);
        getInternalStackTrace();
        out.defaultWriteObject();
        // ---------- Original Method ----------
        //getInternalStackTrace();
        //out.defaultWriteObject();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.621 -0400", hash_original_method = "D9E2A8DEA9D5CE3A923EF2188BD1E0E9", hash_generated_method = "DBB2E8479B417AD7B10A8FEB6BED50D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        dsTaint.addTaint(in.dsTaint);
        in.defaultReadObject();
        {
            suppressedExceptions = new ArrayList<Throwable>(suppressedExceptions);
        } //End block
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

    
    private static final long serialVersionUID = -3042686055658047285L;
}

