package javax.xml.datatype;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.reflect.Method;

public class DatatypeConfigurationException extends Exception {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.351 -0400", hash_original_field = "0219E6C3A5F150BDF5BA3B6F59A3E457", hash_generated_field = "FDEAAF15B853EF09260D09DA4CFBCF57")

    private Throwable causeOnJDK13OrBelow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.367 -0400", hash_original_field = "19A2DC37ECF714783F3BB13D393D8C03", hash_generated_field = "68E41A1D0B481732ED30B41746671A02")

    private transient boolean isJDK14OrAbove = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.368 -0400", hash_original_method = "FA9B26A3FDAB1D1435C1EE09FF5CBDA4", hash_generated_method = "EF6F7C05D75E625DDBD76F811F0CA833")
    public  DatatypeConfigurationException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.368 -0400", hash_original_method = "8CB0B83BDE3C724873DDAC89D0491251", hash_generated_method = "54BB7CD73921D3C5EAA1AA5AD5888BEB")
    public  DatatypeConfigurationException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.368 -0400", hash_original_method = "5F5CD764FA5693F913873AD45FCEF4A7", hash_generated_method = "B43D9E5C7EAACD0DEBD8D4BCAA5E3DA8")
    public  DatatypeConfigurationException(String message, Throwable cause) {
        super(message);
        initCauseByReflection(cause);
        addTaint(message.getTaint());
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
        //initCauseByReflection(cause);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.368 -0400", hash_original_method = "D68A6888AADD5D22D6843D717C0207BD", hash_generated_method = "43C73CDFAAD1B0E26F222AF6F3303D39")
    public  DatatypeConfigurationException(Throwable cause) {
        super(cause == null ? null : cause.toString());
        initCauseByReflection(cause);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
        //initCauseByReflection(cause);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.369 -0400", hash_original_method = "CCE4521801FE6F597C78D6C168B382AB", hash_generated_method = "3752FFA9378700C6F95880D7C1526F87")
    public void printStackTrace() {
        {
            printStackTrace0(new PrintWriter(System.err, true));
        } //End block
        {
            super.printStackTrace();
        } //End block
        // ---------- Original Method ----------
        //if (!isJDK14OrAbove && causeOnJDK13OrBelow != null) {
            //printStackTrace0(new PrintWriter(System.err, true));
        //}
        //else {
            //super.printStackTrace();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.369 -0400", hash_original_method = "95D2E13F17DCF7DA7C7DF3B620874594", hash_generated_method = "FE7A94BB32100F98F7133A86E7B208CF")
    public void printStackTrace(PrintStream s) {
        {
            printStackTrace0(new PrintWriter(s));
        } //End block
        {
            super.printStackTrace(s);
        } //End block
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //if (!isJDK14OrAbove && causeOnJDK13OrBelow != null) {
            //printStackTrace0(new PrintWriter(s));
        //}
        //else {
            //super.printStackTrace(s);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.369 -0400", hash_original_method = "A5330178C54B8D14125F5B342A0C5097", hash_generated_method = "07190128A3ACB0EF522746FE784B3944")
    public void printStackTrace(PrintWriter s) {
        {
            printStackTrace0(s);
        } //End block
        {
            super.printStackTrace(s);
        } //End block
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //if (!isJDK14OrAbove && causeOnJDK13OrBelow != null) {
            //printStackTrace0(s);
        //}
        //else {
            //super.printStackTrace(s);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.481 -0400", hash_original_method = "201997E377D1A9819050705CDC59C69C", hash_generated_method = "AEDA32A600DBB53F52187310E9B6746E")
    private void printStackTrace0(PrintWriter s) {
        causeOnJDK13OrBelow.printStackTrace(s);
        s.println("------------------------------------------");
        super.printStackTrace(s);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //causeOnJDK13OrBelow.printStackTrace(s);
        //s.println("------------------------------------------");
        //super.printStackTrace(s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.481 -0400", hash_original_method = "0D16643DF8DCD1D306FB0B7D763D3EEC", hash_generated_method = "EDF23E753F7810F59AC13B0A160CD8FD")
    private void initCauseByReflection(Throwable cause) {
        causeOnJDK13OrBelow = cause;
        try 
        {
            Method m;
            m = this.getClass().getMethod("initCause", new Class[] {Throwable.class});
            m.invoke(this, new Object[] {cause});
            isJDK14OrAbove = true;
        } //End block
        catch (Exception e)
        { }
        // ---------- Original Method ----------
        //causeOnJDK13OrBelow = cause;
        //try {
            //Method m = this.getClass().getMethod("initCause", new Class[] {Throwable.class});
            //m.invoke(this, new Object[] {cause});
            //isJDK14OrAbove = true;
        //}
        //catch (Exception e) {}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.482 -0400", hash_original_method = "9F6FAC775CE9C55C625DEF5D55F39862", hash_generated_method = "1B904E0E22E504F2B9918BC69113EDBF")
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        try 
        {
            Method m1;
            m1 = this.getClass().getMethod("getCause", new Class[] {});
            Throwable cause;
            cause = (Throwable) m1.invoke(this, new Object[] {});
            {
                causeOnJDK13OrBelow = cause;
            } //End block
            {
                Method m2;
                m2 = this.getClass().getMethod("initCause", new Class[] {Throwable.class});
                m2.invoke(this, new Object[] {causeOnJDK13OrBelow});
            } //End block
            isJDK14OrAbove = true;
        } //End block
        catch (Exception e)
        { }
        addTaint(in.getTaint());
        // ---------- Original Method ----------
        //in.defaultReadObject();
        //try {
            //Method m1 = this.getClass().getMethod("getCause", new Class[] {});
            //Throwable cause = (Throwable) m1.invoke(this, new Object[] {});
            //if (causeOnJDK13OrBelow == null) {
                //causeOnJDK13OrBelow = cause;
            //}
            //else if (cause == null) {
                //Method m2 = this.getClass().getMethod("initCause", new Class[] {Throwable.class});
                //m2.invoke(this, new Object[] {causeOnJDK13OrBelow});
            //}
            //isJDK14OrAbove = true;
        //}
        //catch (Exception e) {}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.482 -0400", hash_original_field = "DD0C9B88D47F5BDF2E6D1DDF53FD7928", hash_generated_field = "FC91909089CA0451082EF2FDECC55354")

    private static long serialVersionUID = -1699373159027047238L;
}

