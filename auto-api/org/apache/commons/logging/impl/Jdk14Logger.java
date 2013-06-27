package org.apache.commons.logging.impl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.logging.Log;

public class Jdk14Logger implements Log, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.744 -0400", hash_original_field = "4400709C3053BCEA3D08290498B4E677", hash_generated_field = "025246D335C438AB38D500F038665755")

    protected transient Logger logger = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.744 -0400", hash_original_field = "6D6832C945CE1F820B62E7ED6D65FF6B", hash_generated_field = "A65B7A2EB7276989EDAA9F8572439D68")

    protected String name = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.745 -0400", hash_original_method = "7BF4C742F8C5ACA23F214E18E295ECBB", hash_generated_method = "6B46B2B2E363B95E607D2463C3D691C8")
    public  Jdk14Logger(String name) {
        this.name = name;
        logger = getLogger();
        // ---------- Original Method ----------
        //this.name = name;
        //logger = getLogger();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.761 -0400", hash_original_method = "C5765CC5B1B39AF0EFD6226D38EFAF69", hash_generated_method = "928A667C14C1B6DDF5996985CD472829")
    private void log( Level level, String msg, Throwable ex ) {
        Logger logger;
        logger = getLogger();
        {
            boolean var5C8720650EF11EB1289A873585A1D6AF_1704683967 = (logger.isLoggable(level));
            {
                Throwable dummyException;
                dummyException = new Throwable();
                StackTraceElement locations[];
                locations = dummyException.getStackTrace();
                String cname;
                cname = "unknown";
                String method;
                method = "unknown";
                {
                    StackTraceElement caller;
                    caller = locations[2];
                    cname=caller.getClassName();
                    method=caller.getMethodName();
                } //End block
                {
                    logger.logp( level, cname, method, msg );
                } //End block
                {
                    logger.logp( level, cname, method, msg, ex );
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(level.getTaint());
        addTaint(msg.getTaint());
        addTaint(ex.getTaint());
        // ---------- Original Method ----------
        //Logger logger = getLogger();
        //if (logger.isLoggable(level)) {
            //Throwable dummyException=new Throwable();
            //StackTraceElement locations[]=dummyException.getStackTrace();
            //String cname="unknown";
            //String method="unknown";
            //if( locations!=null && locations.length >2 ) {
                //StackTraceElement caller=locations[2];
                //cname=caller.getClassName();
                //method=caller.getMethodName();
            //}
            //if( ex==null ) {
                //logger.logp( level, cname, method, msg );
            //} else {
                //logger.logp( level, cname, method, msg, ex );
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.762 -0400", hash_original_method = "B2D3144426F7F3C4C82468ADF000A2A4", hash_generated_method = "827541029A355E0DB954495480D531FF")
    public void debug(Object message) {
        log(Level.FINE, String.valueOf(message), null);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //log(Level.FINE, String.valueOf(message), null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.762 -0400", hash_original_method = "67E70CE5ABA347B2A58E5303263E33C3", hash_generated_method = "D1511C012C947923456203DD3A1AA8B5")
    public void debug(Object message, Throwable exception) {
        log(Level.FINE, String.valueOf(message), exception);
        addTaint(message.getTaint());
        addTaint(exception.getTaint());
        // ---------- Original Method ----------
        //log(Level.FINE, String.valueOf(message), exception);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.763 -0400", hash_original_method = "07041611E15894BBB578208C2F3AAD76", hash_generated_method = "1098E59F24432659F61E12798C6D0A63")
    public void error(Object message) {
        log(Level.SEVERE, String.valueOf(message), null);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //log(Level.SEVERE, String.valueOf(message), null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.764 -0400", hash_original_method = "50074BA46CE711F7C7225760B0DBD702", hash_generated_method = "10FF3A4CA7191BEE1214DA346606ECBC")
    public void error(Object message, Throwable exception) {
        log(Level.SEVERE, String.valueOf(message), exception);
        addTaint(message.getTaint());
        addTaint(exception.getTaint());
        // ---------- Original Method ----------
        //log(Level.SEVERE, String.valueOf(message), exception);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.764 -0400", hash_original_method = "EE858F66DF718641EEB790378894310A", hash_generated_method = "3B9E9D4F8FC9B685377B6E6492200D7F")
    public void fatal(Object message) {
        log(Level.SEVERE, String.valueOf(message), null);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //log(Level.SEVERE, String.valueOf(message), null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.774 -0400", hash_original_method = "E991CC87C4293999DC349BC54F0EAD62", hash_generated_method = "88C6C95EBAAC0AE4A9ABDFA94A7BCB0D")
    public void fatal(Object message, Throwable exception) {
        log(Level.SEVERE, String.valueOf(message), exception);
        addTaint(message.getTaint());
        addTaint(exception.getTaint());
        // ---------- Original Method ----------
        //log(Level.SEVERE, String.valueOf(message), exception);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.774 -0400", hash_original_method = "4AF846FE0103434E8DCD79250F0704EC", hash_generated_method = "D2C3EFA2FD8F9DF7E0EC63A877EA21B2")
    public Logger getLogger() {
        Logger varB4EAC82CA7396A68D541C85D26508E83_206851052 = null; //Variable for return #1
        {
            logger = Logger.getLogger(name);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_206851052 = (logger);
        varB4EAC82CA7396A68D541C85D26508E83_206851052.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_206851052;
        // ---------- Original Method ----------
        //if (logger == null) {
            //logger = Logger.getLogger(name);
        //}
        //return (logger);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.775 -0400", hash_original_method = "F26DF600BAA1C269DA55D89F10A0C288", hash_generated_method = "12B835027B7BED6BB5DD0D01309EA53A")
    public void info(Object message) {
        log(Level.INFO, String.valueOf(message), null);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //log(Level.INFO, String.valueOf(message), null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.775 -0400", hash_original_method = "2E6509BB2E24DB9AA8C338F19EA4BC2D", hash_generated_method = "69E85B27C155FB229CDA75B8856F20ED")
    public void info(Object message, Throwable exception) {
        log(Level.INFO, String.valueOf(message), exception);
        addTaint(message.getTaint());
        addTaint(exception.getTaint());
        // ---------- Original Method ----------
        //log(Level.INFO, String.valueOf(message), exception);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.775 -0400", hash_original_method = "1B54E28475DEC6550B23EDEA7E3734FF", hash_generated_method = "9275ABB7B7D2E53B0E145B3C91C03EC6")
    public boolean isDebugEnabled() {
        boolean var41E0591EC13648BEC651983C8E8D1F2E_1256729930 = ((getLogger().isLoggable(Level.FINE)));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1368991657 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1368991657;
        // ---------- Original Method ----------
        //return (getLogger().isLoggable(Level.FINE));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.783 -0400", hash_original_method = "A353E7BDC7FDA36E1EC9624F6104E3C2", hash_generated_method = "CF344DA5A9DCE607F1858A844314F3D3")
    public boolean isErrorEnabled() {
        boolean varBBCB0E3EB022CD3DFF180853CA8E4C89_1367174373 = ((getLogger().isLoggable(Level.SEVERE)));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1178297728 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1178297728;
        // ---------- Original Method ----------
        //return (getLogger().isLoggable(Level.SEVERE));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.783 -0400", hash_original_method = "C0C75B09E38C8D039719CECFB87B9F15", hash_generated_method = "90CB83AE49E354A3748DDE8CBFFD16DA")
    public boolean isFatalEnabled() {
        boolean varBBCB0E3EB022CD3DFF180853CA8E4C89_827407133 = ((getLogger().isLoggable(Level.SEVERE)));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1488220052 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1488220052;
        // ---------- Original Method ----------
        //return (getLogger().isLoggable(Level.SEVERE));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.784 -0400", hash_original_method = "968DC873065A180C45D5B3688E2E9998", hash_generated_method = "4E70A76F5BE0CB1270333E1CFFFD4D1A")
    public boolean isInfoEnabled() {
        boolean var850197ED7F7AE892F8EB2B385D6234C7_1927108603 = ((getLogger().isLoggable(Level.INFO)));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_313604773 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_313604773;
        // ---------- Original Method ----------
        //return (getLogger().isLoggable(Level.INFO));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.784 -0400", hash_original_method = "336E472D067E61968C1967D8BD9529A8", hash_generated_method = "5A4FA9166C2CE62CAFC36AC1E704E3A7")
    public boolean isTraceEnabled() {
        boolean var7A31555DCC64F0A17EA9FCCF2E43BDF2_830412029 = ((getLogger().isLoggable(Level.FINEST)));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1502874017 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1502874017;
        // ---------- Original Method ----------
        //return (getLogger().isLoggable(Level.FINEST));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.784 -0400", hash_original_method = "48F2D19FF694A6F1CFBD6A7273C48B76", hash_generated_method = "48FC226041246022748CD41D3478B44D")
    public boolean isWarnEnabled() {
        boolean var6243382178DFD1432B724CAE5A9A48AD_908241177 = ((getLogger().isLoggable(Level.WARNING)));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2142833481 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2142833481;
        // ---------- Original Method ----------
        //return (getLogger().isLoggable(Level.WARNING));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.792 -0400", hash_original_method = "DED91A2285B6A66DFD74CDE391880914", hash_generated_method = "B0762F8B408830B96C209551ECBC0908")
    public void trace(Object message) {
        log(Level.FINEST, String.valueOf(message), null);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //log(Level.FINEST, String.valueOf(message), null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.792 -0400", hash_original_method = "CC5526DB6A3104361CDD33B14CCC4EB8", hash_generated_method = "BB1D5D79342A2CEDD671244F0F876BCD")
    public void trace(Object message, Throwable exception) {
        log(Level.FINEST, String.valueOf(message), exception);
        addTaint(message.getTaint());
        addTaint(exception.getTaint());
        // ---------- Original Method ----------
        //log(Level.FINEST, String.valueOf(message), exception);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.793 -0400", hash_original_method = "C2F32BB12488093B2694DF46B22F28A8", hash_generated_method = "7EE9E28540E331AFD5CAB03CD1900E77")
    public void warn(Object message) {
        log(Level.WARNING, String.valueOf(message), null);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //log(Level.WARNING, String.valueOf(message), null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.800 -0400", hash_original_method = "57044B9D87A0326EE4B43E6606266C00", hash_generated_method = "F3B01172A575FA58EFED2926B6283CED")
    public void warn(Object message, Throwable exception) {
        log(Level.WARNING, String.valueOf(message), exception);
        addTaint(message.getTaint());
        addTaint(exception.getTaint());
        // ---------- Original Method ----------
        //log(Level.WARNING, String.valueOf(message), exception);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.800 -0400", hash_original_field = "9DD23A7A98CF15847583A8E9BE6B1953", hash_generated_field = "A9A15E594C8C6EE76482B5295024E04E")

    protected static Level dummyLevel = Level.FINE;
}

