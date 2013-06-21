package java.util.logging;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class LogRecord implements Serializable {
    private Level level;
    private long sequenceNumber;
    private String sourceClassName;
    private String sourceMethodName;
    private String message;
    private int threadID;
    private long millis;
    private Throwable thrown;
    private String loggerName;
    private String resourceBundleName;
    private transient ResourceBundle resourceBundle;
    private transient Object[] parameters;
    private transient boolean sourceInitialized;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.490 -0400", hash_original_method = "022A0341917C5DE72EB88D3FD14C370E", hash_generated_method = "8F86A8AF5B2EF4FB1DC209DE69064FD5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LogRecord(Level level, String msg) {
        dsTaint.addTaint(level.dsTaint);
        dsTaint.addTaint(msg);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("level == null");
        } //End block
        this.millis = System.currentTimeMillis();
        {
            this.sequenceNumber = currentSequenceNumber++;
            Integer id;
            id = currentThreadId.get();
            {
                this.threadID = initThreadId;
                currentThreadId.set(Integer.valueOf(initThreadId++));
            } //End block
            {
                this.threadID = id.intValue();
            } //End block
        } //End block
        this.sourceClassName = null;
        this.sourceMethodName = null;
        this.loggerName = null;
        this.parameters = null;
        this.resourceBundle = null;
        this.resourceBundleName = null;
        this.thrown = null;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.491 -0400", hash_original_method = "0FEEFD0C4767A5B5B477CADC6D101FDE", hash_generated_method = "BD72C79CD74D35CE385007F1B0CB258D")
    @DSModeled(DSC.SAFE)
    public Level getLevel() {
        return (Level)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return level;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.491 -0400", hash_original_method = "1C71253C97024F86DF08173E2DC14542", hash_generated_method = "199644E12AB4D4C58EC0126C164049EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setLevel(Level level) {
        dsTaint.addTaint(level.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("level == null");
        } //End block
        // ---------- Original Method ----------
        //if (level == null) {
            //throw new NullPointerException("level == null");
        //}
        //this.level = level;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.491 -0400", hash_original_method = "F91ED8A8026304D4EB26E347DCDA5498", hash_generated_method = "1E0763F8D22F3EC9A1761F6A381979DA")
    @DSModeled(DSC.SAFE)
    public String getLoggerName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return loggerName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.491 -0400", hash_original_method = "A458AA58D2D6B65ABAE0935E2AD2D855", hash_generated_method = "DA216FD361CC84E5286189E56088E674")
    @DSModeled(DSC.SAFE)
    public void setLoggerName(String loggerName) {
        dsTaint.addTaint(loggerName);
        // ---------- Original Method ----------
        //this.loggerName = loggerName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.491 -0400", hash_original_method = "AF20B727F6E1F2FE1F73E3107355CAA7", hash_generated_method = "BF2F0FFC016428E3339CF8EE854D5667")
    @DSModeled(DSC.SAFE)
    public String getMessage() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return message;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.491 -0400", hash_original_method = "9A40E46319AC2A39DCEE47C689D1B957", hash_generated_method = "98D26CA7EF7AA5647D57B824380441DF")
    @DSModeled(DSC.SAFE)
    public void setMessage(String message) {
        dsTaint.addTaint(message);
        // ---------- Original Method ----------
        //this.message = message;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.492 -0400", hash_original_method = "06B95E2D5570D6B3A84011B34076B5C7", hash_generated_method = "AD681A3336803E42352CC8C1B83FAA31")
    @DSModeled(DSC.SAFE)
    public long getMillis() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return millis;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.492 -0400", hash_original_method = "AAA6B913A1F36A93830487DCD9FBEB6E", hash_generated_method = "1454470375988EBD4606D4FEF97A1011")
    @DSModeled(DSC.SAFE)
    public void setMillis(long millis) {
        dsTaint.addTaint(millis);
        // ---------- Original Method ----------
        //this.millis = millis;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.492 -0400", hash_original_method = "7E2CB3B3486574EE0A68176991A0ECCF", hash_generated_method = "4D42B7357B48942EB9166F6D18CA3DD7")
    @DSModeled(DSC.SAFE)
    public Object[] getParameters() {
        return (Object[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return parameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.492 -0400", hash_original_method = "A8B44ED180D604C73C7E6D3CC47CE208", hash_generated_method = "B1D5FBECC732AE915842915DECED226A")
    @DSModeled(DSC.SAFE)
    public void setParameters(Object[] parameters) {
        dsTaint.addTaint(parameters[0].dsTaint);
        // ---------- Original Method ----------
        //this.parameters = parameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.492 -0400", hash_original_method = "A55D46251237391AC4070653DF8FD1F0", hash_generated_method = "16670675201F76AD926C45DA3BFAC732")
    @DSModeled(DSC.SAFE)
    public ResourceBundle getResourceBundle() {
        return (ResourceBundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return resourceBundle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.492 -0400", hash_original_method = "22E19C2BD30D13ED1AEAB526931847D2", hash_generated_method = "6AB820B7FF2234E8ECE66197E56EAD86")
    @DSModeled(DSC.SAFE)
    public void setResourceBundle(ResourceBundle resourceBundle) {
        dsTaint.addTaint(resourceBundle.dsTaint);
        // ---------- Original Method ----------
        //this.resourceBundle = resourceBundle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.493 -0400", hash_original_method = "73FB3843FBEEE5F85EEE27DAD4E6665A", hash_generated_method = "7F31B032338F1EACB1B9D6DA057B2E7A")
    @DSModeled(DSC.SAFE)
    public String getResourceBundleName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return resourceBundleName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.493 -0400", hash_original_method = "953EDB4ADFDF1563BD9A241A7063EF86", hash_generated_method = "20950A432CE004093325B270FE354BCE")
    @DSModeled(DSC.SAFE)
    public void setResourceBundleName(String resourceBundleName) {
        dsTaint.addTaint(resourceBundleName);
        // ---------- Original Method ----------
        //this.resourceBundleName = resourceBundleName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.493 -0400", hash_original_method = "5B99D7AA47A1BEEC3DF03D05A32BB6DB", hash_generated_method = "D7E94135005FC5BFA38996359A75CD0C")
    @DSModeled(DSC.SAFE)
    public long getSequenceNumber() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return sequenceNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.493 -0400", hash_original_method = "A872117CAF84BB70B3F50AB7DBB15709", hash_generated_method = "ED3BB03E591BAA3CFD43D85DDAB1A863")
    @DSModeled(DSC.SAFE)
    public void setSequenceNumber(long sequenceNumber) {
        dsTaint.addTaint(sequenceNumber);
        // ---------- Original Method ----------
        //this.sequenceNumber = sequenceNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.494 -0400", hash_original_method = "17474CC4607EF1F80968125D954E4F2F", hash_generated_method = "7F6B4AEE333C90A5330CEF97263D8E52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getSourceClassName() {
        initSource();
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //initSource();
        //return sourceClassName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.499 -0400", hash_original_method = "598A8AAA0AD5798486DE87D6CFFB0E3D", hash_generated_method = "DCC1B4A01A24265D9629E2753E705233")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void initSource() {
        boolean sawLogger;
        sawLogger = false;
        {
            StackTraceElement element = new Throwable().getStackTrace()[0];
            {
                String current;
                current = element.getClassName();
                {
                    boolean varD3C8C54B33E01F84E69DE674172CDD86_1103004669 = (current.startsWith(Logger.class.getName()));
                    {
                        sawLogger = true;
                    } //End block
                    {
                        this.sourceClassName = element.getClassName();
                        this.sourceMethodName = element.getMethodName();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        sourceInitialized = true;
        // ---------- Original Method ----------
        //if (sourceInitialized) {
            //return;
        //}
        //boolean sawLogger = false;
        //for (StackTraceElement element : new Throwable().getStackTrace()) {
            //String current = element.getClassName();
            //if (current.startsWith(Logger.class.getName())) {
                //sawLogger = true;
            //} else if (sawLogger) {
                //this.sourceClassName = element.getClassName();
                //this.sourceMethodName = element.getMethodName();
                //break;
            //}
        //}
        //sourceInitialized = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.500 -0400", hash_original_method = "4073B854D67A7DD73FA3797FFA5DDD0A", hash_generated_method = "6C8421015C3FC8F2E4C46B5DDCA0CEF0")
    @DSModeled(DSC.SAFE)
    public void setSourceClassName(String sourceClassName) {
        dsTaint.addTaint(sourceClassName);
        sourceInitialized = true;
        // ---------- Original Method ----------
        //sourceInitialized = true;
        //this.sourceClassName = sourceClassName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.500 -0400", hash_original_method = "997894DE44F9E4C217C990670A2096CD", hash_generated_method = "554B99EFE2ACBF847F6E3A5AC22CF689")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getSourceMethodName() {
        initSource();
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //initSource();
        //return sourceMethodName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.501 -0400", hash_original_method = "6DB80156486F9B3573D791516F5BFF16", hash_generated_method = "111BD6D16AD11F512D2B64E242D7A904")
    @DSModeled(DSC.SAFE)
    public void setSourceMethodName(String sourceMethodName) {
        dsTaint.addTaint(sourceMethodName);
        sourceInitialized = true;
        // ---------- Original Method ----------
        //sourceInitialized = true;
        //this.sourceMethodName = sourceMethodName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.502 -0400", hash_original_method = "23D166A70BC333A13745104EBA97F318", hash_generated_method = "885043E7E6B8BA2BFC88FD99C59C2C63")
    @DSModeled(DSC.SAFE)
    public int getThreadID() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return threadID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.502 -0400", hash_original_method = "BFD778F3BC25BE448B5B49F6297DA90A", hash_generated_method = "737E366B89872636F5FC2BF0B8892BA7")
    @DSModeled(DSC.SAFE)
    public void setThreadID(int threadID) {
        dsTaint.addTaint(threadID);
        // ---------- Original Method ----------
        //this.threadID = threadID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.503 -0400", hash_original_method = "9281C9177DD0647B668ECFF1744AEA20", hash_generated_method = "66CF9FD821ED356C8D855CF15B4740A3")
    @DSModeled(DSC.SAFE)
    public Throwable getThrown() {
        return (Throwable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return thrown;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.503 -0400", hash_original_method = "11A0184E1F2F67806A14E7D6384E1936", hash_generated_method = "15C2003A791947178DE51C6D723C777D")
    @DSModeled(DSC.SAFE)
    public void setThrown(Throwable thrown) {
        dsTaint.addTaint(thrown.dsTaint);
        // ---------- Original Method ----------
        //this.thrown = thrown;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.507 -0400", hash_original_method = "D3EC386C5EF05328C43DBAC50DDD8B32", hash_generated_method = "7C6698AF990F54AA5E612492A9EE31EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeObject(ObjectOutputStream out) throws IOException {
        dsTaint.addTaint(out.dsTaint);
        out.defaultWriteObject();
        out.writeByte(MAJOR);
        out.writeByte(MINOR);
        {
            out.writeInt(-1);
        } //End block
        {
            out.writeInt(parameters.length);
            {
                Object element = parameters[0];
                {
                    out.writeObject((element == null) ? null : element.toString());
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //out.defaultWriteObject();
        //out.writeByte(MAJOR);
        //out.writeByte(MINOR);
        //if (parameters == null) {
            //out.writeInt(-1);
        //} else {
            //out.writeInt(parameters.length);
            //for (Object element : parameters) {
                //out.writeObject((element == null) ? null : element.toString());
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.507 -0400", hash_original_method = "807ED1C9D5895C8055BA2AC3A6A18BB7", hash_generated_method = "CDBDD72A745A0C7974866391ABD8A54E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        dsTaint.addTaint(in.dsTaint);
        in.defaultReadObject();
        byte major;
        major = in.readByte();
        byte minor;
        minor = in.readByte();
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Different version " + Byte.valueOf(major) + "." + Byte.valueOf(minor));
        } //End block
        int length;
        length = in.readInt();
        {
            parameters = new Object[length];
            {
                int i;
                i = 0;
                {
                    parameters[i] = in.readObject();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            try 
            {
                resourceBundle = Logger.loadResourceBundle(resourceBundleName);
            } //End block
            catch (MissingResourceException e)
            {
                resourceBundle = null;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //in.defaultReadObject();
        //byte major = in.readByte();
        //byte minor = in.readByte();
        //if (major != MAJOR) {
            //throw new IOException("Different version " + Byte.valueOf(major) + "." + Byte.valueOf(minor));
        //}
        //int length = in.readInt();
        //if (length >= 0) {
            //parameters = new Object[length];
            //for (int i = 0; i < parameters.length; i++) {
                //parameters[i] = in.readObject();
            //}
        //}
        //if (resourceBundleName != null) {
            //try {
                //resourceBundle = Logger.loadResourceBundle(resourceBundleName);
            //} catch (MissingResourceException e) {
                //resourceBundle = null;
            //}
        //}
    }

    
    private static final long serialVersionUID = 5372048053134512534L;
    private static final int MAJOR = 1;
    private static final int MINOR = 4;
    private static long currentSequenceNumber = 0;
    private static ThreadLocal<Integer> currentThreadId = new ThreadLocal<Integer>();
    private static int initThreadId = 0;
}

