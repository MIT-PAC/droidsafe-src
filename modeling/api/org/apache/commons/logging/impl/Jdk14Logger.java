package org.apache.commons.logging.impl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.logging.Log;

public class Jdk14Logger implements Log, Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.733 -0500", hash_original_field = "50BD4BC6666C59DC935E30AEA7191D2D", hash_generated_field = "B6015FBC4023476FF3F25CFD133F1252")

    protected static final Level dummyLevel = Level.FINE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.739 -0500", hash_original_field = "C56A82118B0BCDD9EBAF598E2B36C2E3", hash_generated_field = "C9BAB7357C9C71999E161758737AC735")

    /**
     * The underlying Logger implementation we are using.
     */
    protected transient Logger logger = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.741 -0500", hash_original_field = "BC3C85A81DD987708D9857262FFEAD3F", hash_generated_field = "A65B7A2EB7276989EDAA9F8572439D68")

    protected String name = null;

    // ----------------------------------------------------------- Constructors

    /**
     * Construct a named instance of this Logger.
     *
     * @param name Name of the logger to be constructed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.736 -0500", hash_original_method = "7BF4C742F8C5ACA23F214E18E295ECBB", hash_generated_method = "6253D394DA17AE541493989B9FCA6641")
    
public Jdk14Logger(String name) {

        this.name = name;
        logger = getLogger();

    }

    // --------------------------------------------------------- Public Methods

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.743 -0500", hash_original_method = "C5765CC5B1B39AF0EFD6226D38EFAF69", hash_generated_method = "3B8A9EBFFF89165FD04CE1366AC6CA64")
    
private void log( Level level, String msg, Throwable ex ) {

        Logger logger = getLogger();
        if (logger.isLoggable(level)) {
            // Hack (?) to get the stack trace.
            Throwable dummyException=new Throwable();
            StackTraceElement locations[]=dummyException.getStackTrace();
            // Caller will be the third element
            String cname="unknown";
            String method="unknown";
            if( locations!=null && locations.length >2 ) {
                StackTraceElement caller=locations[2];
                cname=caller.getClassName();
                method=caller.getMethodName();
            }
            if( ex==null ) {
                logger.logp( level, cname, method, msg );
            } else {
                logger.logp( level, cname, method, msg, ex );
            }
        }

    }

    /**
     * Logs a message with <code>java.util.logging.Level.FINE</code>.
     *
     * @param message to log
     * @see org.apache.commons.logging.Log#debug(Object)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.746 -0500", hash_original_method = "B2D3144426F7F3C4C82468ADF000A2A4", hash_generated_method = "67223B5A737323B177077CDC729F247B")
    
public void debug(Object message) {
        log(Level.FINE, String.valueOf(message), null);
    }

    /**
     * Logs a message with <code>java.util.logging.Level.FINE</code>.
     *
     * @param message to log
     * @param exception log this cause
     * @see org.apache.commons.logging.Log#debug(Object, Throwable)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.748 -0500", hash_original_method = "67E70CE5ABA347B2A58E5303263E33C3", hash_generated_method = "42DB9D434CFAFC3CDDF35D10DFCB7C02")
    
public void debug(Object message, Throwable exception) {
        log(Level.FINE, String.valueOf(message), exception);
    }

    /**
     * Logs a message with <code>java.util.logging.Level.SEVERE</code>.
     *
     * @param message to log
     * @see org.apache.commons.logging.Log#error(Object)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.750 -0500", hash_original_method = "07041611E15894BBB578208C2F3AAD76", hash_generated_method = "A2EF317EABB0FA996ACCB8FD2BFD835D")
    
public void error(Object message) {
        log(Level.SEVERE, String.valueOf(message), null);
    }

    /**
     * Logs a message with <code>java.util.logging.Level.SEVERE</code>.
     *
     * @param message to log
     * @param exception log this cause
     * @see org.apache.commons.logging.Log#error(Object, Throwable)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.752 -0500", hash_original_method = "50074BA46CE711F7C7225760B0DBD702", hash_generated_method = "80C77194FFCD32BB305D561965B5100C")
    
public void error(Object message, Throwable exception) {
        log(Level.SEVERE, String.valueOf(message), exception);
    }

    /**
     * Logs a message with <code>java.util.logging.Level.SEVERE</code>.
     *
     * @param message to log
     * @see org.apache.commons.logging.Log#fatal(Object)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.754 -0500", hash_original_method = "EE858F66DF718641EEB790378894310A", hash_generated_method = "094A33EA9471FB13E5326825C0B4619D")
    
public void fatal(Object message) {
        log(Level.SEVERE, String.valueOf(message), null);
    }

    /**
     * Logs a message with <code>java.util.logging.Level.SEVERE</code>.
     *
     * @param message to log
     * @param exception log this cause
     * @see org.apache.commons.logging.Log#fatal(Object, Throwable)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.757 -0500", hash_original_method = "E991CC87C4293999DC349BC54F0EAD62", hash_generated_method = "335AA15B01538D8EEE3697FCE8CC5FE1")
    
public void fatal(Object message, Throwable exception) {
        log(Level.SEVERE, String.valueOf(message), exception);
    }

    /**
     * Return the native Logger instance we are using.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.759 -0500", hash_original_method = "4AF846FE0103434E8DCD79250F0704EC", hash_generated_method = "FC738BE797EFFAB473E4D836543C191D")
    
public Logger getLogger() {
        if (logger == null) {
            logger = Logger.getLogger(name);
        }
        return (logger);
    }

    /**
     * Logs a message with <code>java.util.logging.Level.INFO</code>.
     *
     * @param message to log
     * @see org.apache.commons.logging.Log#info(Object)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.761 -0500", hash_original_method = "F26DF600BAA1C269DA55D89F10A0C288", hash_generated_method = "DCA866CF6051ABCF94E32379CF95396C")
    
public void info(Object message) {
        log(Level.INFO, String.valueOf(message), null);
    }

    /**
     * Logs a message with <code>java.util.logging.Level.INFO</code>.
     *
     * @param message to log
     * @param exception log this cause
     * @see org.apache.commons.logging.Log#info(Object, Throwable)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.763 -0500", hash_original_method = "2E6509BB2E24DB9AA8C338F19EA4BC2D", hash_generated_method = "ED28D68FDCA718D798635F39E97C71BD")
    
public void info(Object message, Throwable exception) {
        log(Level.INFO, String.valueOf(message), exception);
    }

    /**
     * Is debug logging currently enabled?
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.765 -0500", hash_original_method = "1B54E28475DEC6550B23EDEA7E3734FF", hash_generated_method = "8C9718B707C8AD6173B3ED10AC70B180")
    
public boolean isDebugEnabled() {
        return (getLogger().isLoggable(Level.FINE));
    }

    /**
     * Is error logging currently enabled?
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.767 -0500", hash_original_method = "A353E7BDC7FDA36E1EC9624F6104E3C2", hash_generated_method = "6B1EE76508F69753203669C02453636B")
    
public boolean isErrorEnabled() {
        return (getLogger().isLoggable(Level.SEVERE));
    }

    /**
     * Is fatal logging currently enabled?
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.770 -0500", hash_original_method = "C0C75B09E38C8D039719CECFB87B9F15", hash_generated_method = "FD0E7F16DFC917AC768A0178B98570F0")
    
public boolean isFatalEnabled() {
        return (getLogger().isLoggable(Level.SEVERE));
    }

    /**
     * Is info logging currently enabled?
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.772 -0500", hash_original_method = "968DC873065A180C45D5B3688E2E9998", hash_generated_method = "D656DF762F4FE5EF04E4DB97CB0F038F")
    
public boolean isInfoEnabled() {
        return (getLogger().isLoggable(Level.INFO));
    }

    /**
     * Is trace logging currently enabled?
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.774 -0500", hash_original_method = "336E472D067E61968C1967D8BD9529A8", hash_generated_method = "AB037BFB4F7B08D8E50858CDBC4D9CFF")
    
public boolean isTraceEnabled() {
        return (getLogger().isLoggable(Level.FINEST));
    }

    /**
     * Is warn logging currently enabled?
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.777 -0500", hash_original_method = "48F2D19FF694A6F1CFBD6A7273C48B76", hash_generated_method = "389902067CA44622F4D094DA524E30AD")
    
public boolean isWarnEnabled() {
        return (getLogger().isLoggable(Level.WARNING));
    }

    /**
     * Logs a message with <code>java.util.logging.Level.FINEST</code>.
     *
     * @param message to log
     * @see org.apache.commons.logging.Log#trace(Object)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.779 -0500", hash_original_method = "DED91A2285B6A66DFD74CDE391880914", hash_generated_method = "15DF850964FF7508BC7301DC4A4331A2")
    
public void trace(Object message) {
        log(Level.FINEST, String.valueOf(message), null);
    }

    /**
     * Logs a message with <code>java.util.logging.Level.FINEST</code>.
     *
     * @param message to log
     * @param exception log this cause
     * @see org.apache.commons.logging.Log#trace(Object, Throwable)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.781 -0500", hash_original_method = "CC5526DB6A3104361CDD33B14CCC4EB8", hash_generated_method = "1F8C4851622F9EC8D371D8D36157952C")
    
public void trace(Object message, Throwable exception) {
        log(Level.FINEST, String.valueOf(message), exception);
    }

    /**
     * Logs a message with <code>java.util.logging.Level.WARNING</code>.
     *
     * @param message to log
     * @see org.apache.commons.logging.Log#warn(Object)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.783 -0500", hash_original_method = "C2F32BB12488093B2694DF46B22F28A8", hash_generated_method = "5FC61C32B37CC358D05CD0BB8A865408")
    
public void warn(Object message) {
        log(Level.WARNING, String.valueOf(message), null);
    }

    /**
     * Logs a message with <code>java.util.logging.Level.WARNING</code>.
     *
     * @param message to log
     * @param exception log this cause
     * @see org.apache.commons.logging.Log#warn(Object, Throwable)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:51.786 -0500", hash_original_method = "57044B9D87A0326EE4B43E6606266C00", hash_generated_method = "9190A97EBCED6B8A7FD2C6BD8694A3B2")
    
public void warn(Object message, Throwable exception) {
        log(Level.WARNING, String.valueOf(message), exception);
    }
}

