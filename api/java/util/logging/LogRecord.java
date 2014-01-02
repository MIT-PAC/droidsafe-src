package java.util.logging;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.MissingResourceException;
import java.util.ResourceBundle;






public class LogRecord implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.842 -0500", hash_original_field = "05F7C212D1892772FFC8D57E127D6A8A", hash_generated_field = "CAE9E558857FCF7C7C7CECCC5AA0F51B")


    private static final long serialVersionUID = 5372048053134512534L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.845 -0500", hash_original_field = "6328632054321DC0BA9988891FDD2E4C", hash_generated_field = "39FDEF400FCCABBE75040FB1511C9506")

    private static final int MAJOR = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.847 -0500", hash_original_field = "EF26D4CD2D527DF00E42F8DD6BE97E33", hash_generated_field = "F7B9D06369E918F7E4CC99B9737AEF9E")

    private static final int MINOR = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.850 -0500", hash_original_field = "0B2313760F369991112924525BB3FB6B", hash_generated_field = "CC2F29FD42442009803272BEA1684586")

    private static long currentSequenceNumber = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.852 -0500", hash_original_field = "E5CDE3EB35809D89713E76EF6A7B4938", hash_generated_field = "5D45E26224F98EDE48676A277432CF17")

    private static ThreadLocal<Integer> currentThreadId = new ThreadLocal<Integer>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.854 -0500", hash_original_field = "E16B90010B021D433E8EDEB46C934087", hash_generated_field = "8B68CCE7CA2AE773B1F76EB86CA3AA2E")

    private static int initThreadId = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.857 -0500", hash_original_field = "7DBF1FB792653374CFA4FCA98BFC3768", hash_generated_field = "D176117E1979538AD7BA6376A3FC48D1")

    private Level level;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.859 -0500", hash_original_field = "581F60A6D443ADFC2ED9EAB5D0FA287B", hash_generated_field = "BC5948EFF55F237F777F173C3B803F01")

    private long sequenceNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.861 -0500", hash_original_field = "EE48E7D322A4CAC5A1CD1BFEE3C282D1", hash_generated_field = "E7484D132988AB8A218EBBB6F4C937EF")

    private String sourceClassName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.863 -0500", hash_original_field = "85E109FFC6B76C228E81CB447D890736", hash_generated_field = "81FA7CA43AE91B1E32F984A641166061")

    private String sourceMethodName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.866 -0500", hash_original_field = "C9795C94D34B39950C581203743BD4FC", hash_generated_field = "B2821CE5540C52B19670BB2C4012F012")

    private String message;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.868 -0500", hash_original_field = "837244B49A9BCE670C52E3B850836001", hash_generated_field = "5AB23C2D89794456F0D764D36F383221")

    private int threadID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.871 -0500", hash_original_field = "7DA43804555D56CDB0EC00ED31AF9C3F", hash_generated_field = "E3CD630B97ABFDE87A9DC271D58DE1ED")

    private long millis;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.873 -0500", hash_original_field = "9C1CE0536C1E7D92C00B215702ED91D5", hash_generated_field = "E32F8106A85DC08D94773FEA1421B50C")

    private Throwable thrown;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.875 -0500", hash_original_field = "178637748123506EB697E884D758CB70", hash_generated_field = "78418409580FEF5261250A822405992B")

    private String loggerName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.877 -0500", hash_original_field = "35CC6187306CFB2B68FF26D1B6A58A2F", hash_generated_field = "4BDB4C6F49EE0D4ED40E32BE56CE6580")

    private String resourceBundleName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.880 -0500", hash_original_field = "0BC5764EC59B8E2CBA669D3725A3F394", hash_generated_field = "82DE0F7C7F7A3179590FF9326C8E9161")

    private transient ResourceBundle resourceBundle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.882 -0500", hash_original_field = "22C8CC0B7B476A63112860B8240AE9EF", hash_generated_field = "D325420CF44BA7CE0D67532042AEB224")

    private transient Object[] parameters;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.884 -0500", hash_original_field = "9F4784EBC499F8C4AA1C3FC0919BC155", hash_generated_field = "2E420C590FA5A2985360004D724DB08D")

    private transient boolean sourceInitialized;

    /**
     * Constructs a {@code LogRecord} object using the supplied the logging
     * level and message. The millis property is set to the current time. The
     * sequence property is set to a new unique value, allocated in increasing
     * order within the VM. The thread ID is set to a unique value
     * for the current thread. All other properties are set to {@code null}.
     *
     * @param level
     *            the logging level, may not be {@code null}.
     * @param msg
     *            the raw message.
     * @throws NullPointerException
     *             if {@code level} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.888 -0500", hash_original_method = "022A0341917C5DE72EB88D3FD14C370E", hash_generated_method = "90CB8AE59A260B518D5DE475EB5559DB")
    
public LogRecord(Level level, String msg) {
        if (level == null) {
            throw new NullPointerException("level == null");
        }
        this.level = level;
        this.message = msg;
        this.millis = System.currentTimeMillis();

        synchronized (LogRecord.class) {
            this.sequenceNumber = currentSequenceNumber++;
            Integer id = currentThreadId.get();
            if (id == null) {
                this.threadID = initThreadId;
                currentThreadId.set(Integer.valueOf(initThreadId++));
            } else {
                this.threadID = id.intValue();
            }
        }

        this.sourceClassName = null;
        this.sourceMethodName = null;
        this.loggerName = null;
        this.parameters = null;
        this.resourceBundle = null;
        this.resourceBundleName = null;
        this.thrown = null;
    }

    /**
     * Gets the logging level.
     *
     * @return the logging level.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.890 -0500", hash_original_method = "0FEEFD0C4767A5B5B477CADC6D101FDE", hash_generated_method = "6B045C8FB7F9440E56BF0B5D84422425")
    
public Level getLevel() {
        return level;
    }

    /**
     * Sets the logging level.
     *
     * @param level
     *            the level to set.
     * @throws NullPointerException
     *             if {@code level} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.892 -0500", hash_original_method = "1C71253C97024F86DF08173E2DC14542", hash_generated_method = "6DF250C304B2F84C7AC43C62249E99DD")
    
public void setLevel(Level level) {
        if (level == null) {
            throw new NullPointerException("level == null");
        }
        this.level = level;
    }

    /**
     * Gets the name of the logger.
     *
     * @return the logger name.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.895 -0500", hash_original_method = "F91ED8A8026304D4EB26E347DCDA5498", hash_generated_method = "DEE9478D801FF8FA0DD8BF46B374164F")
    
public String getLoggerName() {
        return loggerName;
    }

    /**
     * Sets the name of the logger.
     *
     * @param loggerName
     *            the logger name to set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.897 -0500", hash_original_method = "A458AA58D2D6B65ABAE0935E2AD2D855", hash_generated_method = "C55202ADA5441F1B9194F41F4850371E")
    
public void setLoggerName(String loggerName) {
        this.loggerName = loggerName;
    }

    /**
     * Gets the raw message.
     *
     * @return the raw message, may be {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.899 -0500", hash_original_method = "AF20B727F6E1F2FE1F73E3107355CAA7", hash_generated_method = "90D22C2CF9BCEC06A37161C90B3C0462")
    
public String getMessage() {
        return message;
    }

    /**
     * Sets the raw message. When this record is formatted by a logger that has
     * a localization resource bundle that contains an entry for {@code message},
     * then the raw message is replaced with its localized version.
     *
     * @param message
     *            the raw message to set, may be {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.901 -0500", hash_original_method = "9A40E46319AC2A39DCEE47C689D1B957", hash_generated_method = "FDFD407E625C2817308BFE3E7E683A7A")
    
public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the time when this event occurred, in milliseconds since 1970.
     *
     * @return the time when this event occurred, in milliseconds since 1970.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.904 -0500", hash_original_method = "06B95E2D5570D6B3A84011B34076B5C7", hash_generated_method = "6278E2044DFF930CA79D820F6FB572A6")
    
public long getMillis() {
        return millis;
    }

    /**
     * Sets the time when this event occurred, in milliseconds since 1970.
     *
     * @param millis
     *            the time when this event occurred, in milliseconds since 1970.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.906 -0500", hash_original_method = "AAA6B913A1F36A93830487DCD9FBEB6E", hash_generated_method = "5DFDC88CDB35A709F04E2D049AD002F6")
    
public void setMillis(long millis) {
        this.millis = millis;
    }

    /**
     * Gets the parameters.
     *
     * @return the array of parameters or {@code null} if there are no
     *         parameters.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.908 -0500", hash_original_method = "7E2CB3B3486574EE0A68176991A0ECCF", hash_generated_method = "00E48544FD6A064CD391B423EF593E68")
    
public Object[] getParameters() {
        return parameters;
    }

    /**
     * Sets the parameters.
     *
     * @param parameters
     *            the array of parameters to set, may be {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.911 -0500", hash_original_method = "A8B44ED180D604C73C7E6D3CC47CE208", hash_generated_method = "8EEB445397669CB319CEE2A07B96F544")
    
public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

    /**
     * Gets the resource bundle used to localize the raw message during
     * formatting.
     *
     * @return the associated resource bundle, {@code null} if none is
     *         available or the message is not localizable.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.913 -0500", hash_original_method = "A55D46251237391AC4070653DF8FD1F0", hash_generated_method = "C671A99A9F1C793089F11BD332FD5CEB")
    
public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }

    /**
     * Sets the resource bundle used to localize the raw message during
     * formatting.
     *
     * @param resourceBundle
     *            the resource bundle to set, may be {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.915 -0500", hash_original_method = "22E19C2BD30D13ED1AEAB526931847D2", hash_generated_method = "08ACF7C60C0FE24C03A5E5DEC78810E1")
    
public void setResourceBundle(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    /**
     * Gets the name of the resource bundle.
     *
     * @return the name of the resource bundle, {@code null} if none is
     *         available or the message is not localizable.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.917 -0500", hash_original_method = "73FB3843FBEEE5F85EEE27DAD4E6665A", hash_generated_method = "3308BAB56A2FF7F9677DD915FE00D96F")
    
public String getResourceBundleName() {
        return resourceBundleName;
    }

    /**
     * Sets the name of the resource bundle.
     *
     * @param resourceBundleName
     *            the name of the resource bundle to set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.920 -0500", hash_original_method = "953EDB4ADFDF1563BD9A241A7063EF86", hash_generated_method = "B748E3AAE401C2A5C7A57CAAE5BFF79B")
    
public void setResourceBundleName(String resourceBundleName) {
        this.resourceBundleName = resourceBundleName;
    }

    /**
     * Gets the sequence number.
     *
     * @return the sequence number.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.922 -0500", hash_original_method = "5B99D7AA47A1BEEC3DF03D05A32BB6DB", hash_generated_method = "1ED8E4C497B5D0169EC3BE45595B3CE9")
    
public long getSequenceNumber() {
        return sequenceNumber;
    }

    /**
     * Sets the sequence number. It is usually not necessary to call this method
     * to change the sequence number because the number is allocated when this
     * instance is constructed.
     *
     * @param sequenceNumber
     *            the sequence number to set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.925 -0500", hash_original_method = "A872117CAF84BB70B3F50AB7DBB15709", hash_generated_method = "0BD911D3BDA35C959D49C0AFF6EC1981")
    
public void setSequenceNumber(long sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    /**
     * Gets the name of the class that is the source of this log record. This
     * information can be changed, may be {@code null} and is untrusted.
     *
     * @return the name of the source class of this log record (possiblity {@code null})
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.927 -0500", hash_original_method = "17474CC4607EF1F80968125D954E4F2F", hash_generated_method = "6C63A0D50FCF19DA20A9825678436CE7")
    
public String getSourceClassName() {
        initSource();
        return sourceClassName;
    }

    /*
     *  Init the sourceClass and sourceMethod fields.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.929 -0500", hash_original_method = "598A8AAA0AD5798486DE87D6CFFB0E3D", hash_generated_method = "A0E15108FF969AD026EFF44C0BE042E5")
    
private void initSource() {
        if (sourceInitialized) {
            return;
        }

        boolean sawLogger = false;
        for (StackTraceElement element : new Throwable().getStackTrace()) {
            String current = element.getClassName();
            if (current.startsWith(Logger.class.getName())) {
                sawLogger = true;
            } else if (sawLogger) {
                this.sourceClassName = element.getClassName();
                this.sourceMethodName = element.getMethodName();
                break;
            }
        }

        sourceInitialized = true;
    }

    /**
     * Sets the name of the class that is the source of this log record.
     *
     * @param sourceClassName
     *            the name of the source class of this log record, may be
     *            {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.932 -0500", hash_original_method = "4073B854D67A7DD73FA3797FFA5DDD0A", hash_generated_method = "9AC50DEDB08090D7B9275647FB85A90E")
    
public void setSourceClassName(String sourceClassName) {
        sourceInitialized = true;
        this.sourceClassName = sourceClassName;
    }

    /**
     * Gets the name of the method that is the source of this log record.
     *
     * @return the name of the source method of this log record.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.934 -0500", hash_original_method = "997894DE44F9E4C217C990670A2096CD", hash_generated_method = "9698EBFC106E5DC19687DE1B388A8E24")
    
public String getSourceMethodName() {
        initSource();
        return sourceMethodName;
    }

    /**
     * Sets the name of the method that is the source of this log record.
     *
     * @param sourceMethodName
     *            the name of the source method of this log record, may be
     *            {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.936 -0500", hash_original_method = "6DB80156486F9B3573D791516F5BFF16", hash_generated_method = "964B289C7F331CADECC6E8E141454054")
    
public void setSourceMethodName(String sourceMethodName) {
        sourceInitialized = true;
        this.sourceMethodName = sourceMethodName;
    }

    /**
     * Gets a unique ID of the thread originating the log record. Every thread
     * becomes a different ID.
     * <p>
     * Notice : the ID doesn't necessary map the OS thread ID
     * </p>
     *
     * @return the ID of the thread originating this log record.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.939 -0500", hash_original_method = "23D166A70BC333A13745104EBA97F318", hash_generated_method = "087792ED180246341333D8A3A8470BCE")
    
public int getThreadID() {
        return threadID;
    }

    /**
     * Sets the ID of the thread originating this log record.
     *
     * @param threadID
     *            the new ID of the thread originating this log record.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.942 -0500", hash_original_method = "BFD778F3BC25BE448B5B49F6297DA90A", hash_generated_method = "E30ED58FF23749E913991CF7A912913F")
    
public void setThreadID(int threadID) {
        this.threadID = threadID;
    }

    /**
     * Gets the {@code Throwable} object associated with this log record.
     *
     * @return the {@code Throwable} object associated with this log record.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.944 -0500", hash_original_method = "9281C9177DD0647B668ECFF1744AEA20", hash_generated_method = "9B4404C7FE2B7BD8EC0FC6B71C6E9BBE")
    
public Throwable getThrown() {
        return thrown;
    }

    /**
     * Sets the {@code Throwable} object associated with this log record.
     *
     * @param thrown
     *            the new {@code Throwable} object to associate with this log
     *            record.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.946 -0500", hash_original_method = "11A0184E1F2F67806A14E7D6384E1936", hash_generated_method = "315A10AFC71C8935DFC49AA4E422C68D")
    
public void setThrown(Throwable thrown) {
        this.thrown = thrown;
    }

    /*
     * Customized serialization.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.949 -0500", hash_original_method = "D3EC386C5EF05328C43DBAC50DDD8B32", hash_generated_method = "9561A9EFDC3E72033A5E7A9E30107D02")
    
private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeByte(MAJOR);
        out.writeByte(MINOR);
        if (parameters == null) {
            out.writeInt(-1);
        } else {
            out.writeInt(parameters.length);
            for (Object element : parameters) {
                out.writeObject((element == null) ? null : element.toString());
            }
        }
    }

    /*
     * Customized deserialization.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:35.951 -0500", hash_original_method = "807ED1C9D5895C8055BA2AC3A6A18BB7", hash_generated_method = "CAF4BB874624B30FED77A5DC3DE70198")
    
private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        in.defaultReadObject();
        byte major = in.readByte();
        byte minor = in.readByte();
        // only check MAJOR version
        if (major != MAJOR) {
            throw new IOException("Different version " + Byte.valueOf(major) + "." + Byte.valueOf(minor));
        }

        int length = in.readInt();
        if (length >= 0) {
            parameters = new Object[length];
            for (int i = 0; i < parameters.length; i++) {
                parameters[i] = in.readObject();
            }
        }
        if (resourceBundleName != null) {
            try {
                resourceBundle = Logger.loadResourceBundle(resourceBundleName);
            } catch (MissingResourceException e) {
                // Cannot find the specified resource bundle
                resourceBundle = null;
            }
        }
    }
}

