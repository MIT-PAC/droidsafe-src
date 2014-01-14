package java.util.logging;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public abstract class Handler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.025 -0500", hash_original_field = "90F05FE1DFDC4E0068180F3B43B847AB", hash_generated_field = "0B783B0E3115CE13A6D1488431F3D781")

    private static final Level DEFAULT_LEVEL = Level.ALL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.027 -0500", hash_original_field = "9DE2E78F384201F0ED6502B37413B1FB", hash_generated_field = "DEE7EAAE0C2AC4A8B1FAFE0F9E9DFB7A")

    private ErrorManager errorMan;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.029 -0500", hash_original_field = "C7941A2E59CC2DF1A97D47295C728725", hash_generated_field = "AA03A19AA54A465901EEA798BB232EAE")

    private String encoding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.031 -0500", hash_original_field = "7DBF1FB792653374CFA4FCA98BFC3768", hash_generated_field = "D176117E1979538AD7BA6376A3FC48D1")

    private Level level;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.033 -0500", hash_original_field = "BE2CD803EB730A438EA8B5DA042AF087", hash_generated_field = "83002D5DCA7A99652BD6403E70FD4EB0")

    private Formatter formatter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.036 -0500", hash_original_field = "EF9962899F2EFF8A0104DADC91C5765D", hash_generated_field = "74C4F31F2046DF3317E23CAC988BE234")

    private Filter filter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.039 -0500", hash_original_field = "D07D332701F9B92847141D46D8B2C7CF", hash_generated_field = "F717D382565968ED95842821FAEC62F9")

    private String prefix;

    /**
     * Constructs a {@code Handler} object with a default error manager instance
     * {@code ErrorManager}, the default encoding, and the default logging
     * level {@code Level.ALL}. It has no filter and no formatter.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.042 -0500", hash_original_method = "E5C195C4F6A42ED3922A908BC2F6920A", hash_generated_method = "B9DA729A221FCE9BA92D54083EEF491B")
    
protected Handler() {
        this.errorMan = new ErrorManager();
        this.level = DEFAULT_LEVEL;
        this.encoding = null;
        this.filter = null;
        this.formatter = null;
        this.prefix = this.getClass().getName();
    }

    // get a instance from given class name, using Class.forName()
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.044 -0500", hash_original_method = "505322F9A2F9CDB1C20F31F6B7CB4718", hash_generated_method = "AE795027D8D6A69AC119A4F2724DD466")
    
private Object getDefaultInstance(String className) {
        Object result = null;
        if (className == null) {
            return result;
        }
        try {
            result = Class.forName(className).newInstance();
        } catch (Exception e) {
            // ignore
        }
        return result;
    }

    // get a instance from given class name, using context classloader
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.046 -0500", hash_original_method = "B808F11DA6FC61C942B2D7F2A86E3C09", hash_generated_method = "FE7C5AD44F44DD77FB77C4BFE44AB72A")
    
private Object getCustomizeInstance(final String className) throws Exception {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        if (loader == null) {
            loader = ClassLoader.getSystemClassLoader();
        }
        Class<?> c = loader.loadClass(className);
        return c.newInstance();
    }

    // print error message in some format
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.048 -0500", hash_original_method = "B5D56DC5C4B8FE4C311A48E44264ABBB", hash_generated_method = "B5D56DC5C4B8FE4C311A48E44264ABBB")
    
void printInvalidPropMessage(String key, String value, Exception e) {
        String msg = "Invalid property value for " + prefix + ":" + key + "/" + value;
        errorMan.error(msg, e, ErrorManager.GENERIC_FAILURE);
    }

    /**
     * init the common properties, including filter, level, formatter, and
     * encoding
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.051 -0500", hash_original_method = "329775ED115F17D9C0AB62A79233F4A6", hash_generated_method = "A4988AE51019DA26CFF3114E7614B5A0")
    
void initProperties(String defaultLevel, String defaultFilter,
            String defaultFormatter, String defaultEncoding) {
        LogManager manager = LogManager.getLogManager();

        // set filter
        final String filterName = manager.getProperty(prefix + ".filter");
        if (filterName != null) {
            try {
                filter = (Filter) getCustomizeInstance(filterName);
            } catch (Exception e1) {
                printInvalidPropMessage("filter", filterName, e1);
                filter = (Filter) getDefaultInstance(defaultFilter);
            }
        } else {
            filter = (Filter) getDefaultInstance(defaultFilter);
        }

        // set level
        String levelName = manager.getProperty(prefix + ".level");
        if (levelName != null) {
            try {
                level = Level.parse(levelName);
            } catch (Exception e) {
                printInvalidPropMessage("level", levelName, e);
                level = Level.parse(defaultLevel);
            }
        } else {
            level = Level.parse(defaultLevel);
        }

        // set formatter
        final String formatterName = manager.getProperty(prefix + ".formatter");
        if (formatterName != null) {
            try {
                formatter = (Formatter) getCustomizeInstance(formatterName);
            } catch (Exception e) {
                printInvalidPropMessage("formatter", formatterName, e);
                formatter = (Formatter) getDefaultInstance(defaultFormatter);
            }
        } else {
            formatter = (Formatter) getDefaultInstance(defaultFormatter);
        }

        // set encoding
        final String encodingName = manager.getProperty(prefix + ".encoding");
        try {
            internalSetEncoding(encodingName);
        } catch (UnsupportedEncodingException e) {
            printInvalidPropMessage("encoding", encodingName, e);
        }
    }

    /**
     * Closes this handler. A flush operation will be performed and all the
     * associated resources will be freed. Client applications should not use
     * this handler after closing it.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.053 -0500", hash_original_method = "D50D7BA65C2BEB3EB436584B5735F108", hash_generated_method = "01CBB4D2860961B039FF408E6402870A")
    
public abstract void close();

    /**
     * Flushes any buffered output.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.056 -0500", hash_original_method = "7DF46C8DE5607DCFD7FF19DAD73048C8", hash_generated_method = "5C061C799C43604AD9581B5D5FEA838D")
    
public abstract void flush();

    /**
     * Accepts a logging request and sends it to the the target.
     *
     * @param record
     *            the log record to be logged; {@code null} records are ignored.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.059 -0500", hash_original_method = "E7251C97AA1B6AEB0AABBC157B4CA364", hash_generated_method = "F7EBA5A619C416109F7EE0B0FB0EC99C")
    
public abstract void publish(LogRecord record);

    /**
     * Gets the character encoding used by this handler, {@code null} for
     * default encoding.
     *
     * @return the character encoding used by this handler.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.061 -0500", hash_original_method = "B6DA448E779CA9929D0D7B4D988D1AFB", hash_generated_method = "02D9BCCBCE42910B6D70E5623FC29FB4")
    
public String getEncoding() {
        return this.encoding;
    }

    /**
     * Gets the error manager used by this handler to report errors during
     * logging.
     *
     * @return the error manager used by this handler.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.063 -0500", hash_original_method = "E0C8CBFEDB627F2BA4CE76D0A71E633A", hash_generated_method = "D8B7A1DEB706CB487E14D805DE3F2076")
    
public ErrorManager getErrorManager() {
        LogManager.getLogManager().checkAccess();
        return this.errorMan;
    }

    /**
     * Gets the filter used by this handler.
     *
     * @return the filter used by this handler (possibly {@code null}).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.066 -0500", hash_original_method = "D58C134707557B2D24085330800528E0", hash_generated_method = "CD9F61EC2D214FA63221AF047D239731")
    
public Filter getFilter() {
        return this.filter;
    }

    /**
     * Gets the formatter used by this handler to format the logging messages.
     *
     * @return the formatter used by this handler (possibly {@code null}).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.069 -0500", hash_original_method = "A74BB1584114C9889E52E1E2254AF36C", hash_generated_method = "AE8DA20E0234AF39099B197B83CA28A1")
    
public Formatter getFormatter() {
        return this.formatter;
    }

    /**
     * Gets the logging level of this handler, records with levels lower than
     * this value will be dropped.
     *
     * @return the logging level of this handler.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.071 -0500", hash_original_method = "56C01E3C36F1CAAB6EC71D0FEE2F8D34", hash_generated_method = "54336132241FEE82935A7AC62C7D03B8")
    
public Level getLevel() {
        return this.level;
    }

    /**
     * Determines whether the supplied log record needs to be logged. The
     * logging levels will be checked as well as the filter.
     *
     * @param record
     *            the log record to be checked.
     * @return {@code true} if the supplied log record needs to be logged,
     *         otherwise {@code false}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.073 -0500", hash_original_method = "CE8301478397D9840767CF11CB8E453A", hash_generated_method = "6E1B9BEA0885F76CFA10D0749C3E9BE2")
    
public boolean isLoggable(LogRecord record) {
        if (record == null) {
            throw new NullPointerException();
        }
        if (this.level.intValue() == Level.OFF.intValue()) {
            return false;
        } else if (record.getLevel().intValue() >= this.level.intValue()) {
            return this.filter == null || this.filter.isLoggable(record);
        }
        return false;
    }

    /**
     * Reports an error to the error manager associated with this handler,
     * {@code ErrorManager} is used for that purpose. No security checks are
     * done, therefore this is compatible with environments where the caller
     * is non-privileged.
     *
     * @param msg
     *            the error message, may be {@code null}.
     * @param ex
     *            the associated exception, may be {@code null}.
     * @param code
     *            an {@code ErrorManager} error code.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.076 -0500", hash_original_method = "F62113B5966ABE7DC6200BD5FC9C8FC5", hash_generated_method = "1D0873FC4881D9701F390E2F0B4B34B3")
    
protected void reportError(String msg, Exception ex, int code) {
        this.errorMan.error(msg, ex, code);
    }

    /**
     * Sets the character encoding used by this handler. A {@code null} value
     * indicates the use of the default encoding. This internal method does
     * not check security.
     *
     * @param newEncoding
     *            the character encoding to set.
     * @throws UnsupportedEncodingException
     *             if the specified encoding is not supported by the runtime.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.078 -0500", hash_original_method = "DC978F88261D557C3638CA74D49294AA", hash_generated_method = "AF2DC33E6C423451F626BB2C7573293C")
    
void internalSetEncoding(String newEncoding) throws UnsupportedEncodingException {
        // accepts "null" because it indicates using default encoding
        if (newEncoding == null) {
            this.encoding = null;
        } else {
            if (Charset.isSupported(newEncoding)) {
                this.encoding = newEncoding;
            } else {
                throw new UnsupportedEncodingException(newEncoding);
            }
        }
    }

    /**
     * Sets the character encoding used by this handler, {@code null} indicates
     * a default encoding.
     *
     * @param encoding
     *            the character encoding to set.
     * @throws UnsupportedEncodingException
     *             if the specified encoding is not supported by the runtime.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.080 -0500", hash_original_method = "E46261745C62E25D2001A68F77BA37B9", hash_generated_method = "C449DC42DC06A7608BA35E63FC20EE16")
    
public void setEncoding(String encoding) throws UnsupportedEncodingException {
        LogManager.getLogManager().checkAccess();
        internalSetEncoding(encoding);
    }

    /**
     * Sets the error manager for this handler.
     *
     * @param em
     *            the error manager to set.
     * @throws NullPointerException
     *             if {@code em} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.083 -0500", hash_original_method = "041C6EB6ECB5770848F1CB62B0AB93B7", hash_generated_method = "EE32AF6ACC39EC952CAD402CC1E5A737")
    
public void setErrorManager(ErrorManager em) {
        LogManager.getLogManager().checkAccess();
        if (em == null) {
            throw new NullPointerException();
        }
        this.errorMan = em;
    }

    /**
     * Sets the filter to be used by this handler.
     *
     * @param newFilter
     *            the filter to set, may be {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.085 -0500", hash_original_method = "18CF3005E196F8EBECF3068D37979086", hash_generated_method = "A36C67B0C22BFB9550E29734D402F742")
    
public void setFilter(Filter newFilter) {
        LogManager.getLogManager().checkAccess();
        this.filter = newFilter;
    }

    /**
     * Sets the formatter to be used by this handler. This internal method does
     * not check security.
     *
     * @param newFormatter
     *            the formatter to set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.087 -0500", hash_original_method = "DEDBD4D0DEEB998F333BEBDE35469176", hash_generated_method = "DEDBD4D0DEEB998F333BEBDE35469176")
    
void internalSetFormatter(Formatter newFormatter) {
        if (newFormatter == null) {
            throw new NullPointerException();
        }
        this.formatter = newFormatter;
    }

    /**
     * Sets the formatter to be used by this handler.
     *
     * @param newFormatter
     *            the formatter to set.
     * @throws NullPointerException
     *             if {@code newFormatter} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.090 -0500", hash_original_method = "C9CA011EA2B703B6BFC998B221D30A9E", hash_generated_method = "71E42C29F91E40239BE7F75701BA9951")
    
public void setFormatter(Formatter newFormatter) {
        LogManager.getLogManager().checkAccess();
        internalSetFormatter(newFormatter);
    }

    /**
     * Sets the logging level of the messages logged by this handler, levels
     * lower than this value will be dropped.
     *
     * @param newLevel
     *            the logging level to set.
     * @throws NullPointerException
     *             if {@code newLevel} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:37.092 -0500", hash_original_method = "AEDF55860BF7C8EC74AABF9FCD3CABC4", hash_generated_method = "8D53D3630CFA5A81A67BEAAFAFEA3DFB")
    
public void setLevel(Level newLevel) {
        if (newLevel == null) {
            throw new NullPointerException();
        }
        LogManager.getLogManager().checkAccess();
        this.level = newLevel;
    }
}

