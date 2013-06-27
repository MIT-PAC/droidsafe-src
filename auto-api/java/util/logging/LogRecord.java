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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.217 -0400", hash_original_field = "C9E9A848920877E76685B2E4E76DE38D", hash_generated_field = "D176117E1979538AD7BA6376A3FC48D1")

    private Level level;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.217 -0400", hash_original_field = "1C021ADF174562C07D271E889F46BABF", hash_generated_field = "BC5948EFF55F237F777F173C3B803F01")

    private long sequenceNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.217 -0400", hash_original_field = "C8F28615620E0FDF6D068627412C9C60", hash_generated_field = "E7484D132988AB8A218EBBB6F4C937EF")

    private String sourceClassName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.217 -0400", hash_original_field = "EE7A35AFE35C441E1A548E403E317D64", hash_generated_field = "81FA7CA43AE91B1E32F984A641166061")

    private String sourceMethodName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.217 -0400", hash_original_field = "78E731027D8FD50ED642340B7C9A63B3", hash_generated_field = "B2821CE5540C52B19670BB2C4012F012")

    private String message;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.217 -0400", hash_original_field = "77FF125E7D621F2339535A6CB37AB5EA", hash_generated_field = "5AB23C2D89794456F0D764D36F383221")

    private int threadID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.217 -0400", hash_original_field = "259A879E32720D127D38B39F2F1385B5", hash_generated_field = "E3CD630B97ABFDE87A9DC271D58DE1ED")

    private long millis;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.217 -0400", hash_original_field = "357498E03A88A17F471ABA561D9FE677", hash_generated_field = "E32F8106A85DC08D94773FEA1421B50C")

    private Throwable thrown;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.218 -0400", hash_original_field = "56275512C01CD2AF07FEDE66357B8E45", hash_generated_field = "78418409580FEF5261250A822405992B")

    private String loggerName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.218 -0400", hash_original_field = "9623BCEF06C4EDCE06D889B615841D11", hash_generated_field = "4BDB4C6F49EE0D4ED40E32BE56CE6580")

    private String resourceBundleName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.218 -0400", hash_original_field = "228A0F6DF977A45B5000D16BFD04B1D8", hash_generated_field = "82DE0F7C7F7A3179590FF9326C8E9161")

    private transient ResourceBundle resourceBundle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.218 -0400", hash_original_field = "166E64F6C3677D0C513901242A3E702D", hash_generated_field = "D325420CF44BA7CE0D67532042AEB224")

    private transient Object[] parameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.218 -0400", hash_original_field = "92CC66101B4F91BB70A782AC7E706090", hash_generated_field = "2E420C590FA5A2985360004D724DB08D")

    private transient boolean sourceInitialized;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.239 -0400", hash_original_method = "022A0341917C5DE72EB88D3FD14C370E", hash_generated_method = "75B7BB9F2E15835256DE1C30AAECA1E4")
    public  LogRecord(Level level, String msg) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("level == null");
        } //End block
        this.level = level;
        this.message = msg;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.240 -0400", hash_original_method = "0FEEFD0C4767A5B5B477CADC6D101FDE", hash_generated_method = "B598B208EA393166E0E20369C1DACF2C")
    public Level getLevel() {
        Level varB4EAC82CA7396A68D541C85D26508E83_1900972432 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1900972432 = level;
        varB4EAC82CA7396A68D541C85D26508E83_1900972432.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1900972432;
        // ---------- Original Method ----------
        //return level;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.269 -0400", hash_original_method = "1C71253C97024F86DF08173E2DC14542", hash_generated_method = "9F039328858FB7C37A14527D741AC03E")
    public void setLevel(Level level) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("level == null");
        } //End block
        this.level = level;
        // ---------- Original Method ----------
        //if (level == null) {
            //throw new NullPointerException("level == null");
        //}
        //this.level = level;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.270 -0400", hash_original_method = "F91ED8A8026304D4EB26E347DCDA5498", hash_generated_method = "C530E5435C801085317F3AB183977141")
    public String getLoggerName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1925804974 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1925804974 = loggerName;
        varB4EAC82CA7396A68D541C85D26508E83_1925804974.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1925804974;
        // ---------- Original Method ----------
        //return loggerName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.270 -0400", hash_original_method = "A458AA58D2D6B65ABAE0935E2AD2D855", hash_generated_method = "4107C4AC85EC187BD5ACF284D6F4D27F")
    public void setLoggerName(String loggerName) {
        this.loggerName = loggerName;
        // ---------- Original Method ----------
        //this.loggerName = loggerName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.271 -0400", hash_original_method = "AF20B727F6E1F2FE1F73E3107355CAA7", hash_generated_method = "3478AEE766CB31F428F30892572F06BF")
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_1294509567 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1294509567 = message;
        varB4EAC82CA7396A68D541C85D26508E83_1294509567.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1294509567;
        // ---------- Original Method ----------
        //return message;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.277 -0400", hash_original_method = "9A40E46319AC2A39DCEE47C689D1B957", hash_generated_method = "ECD2FD94E8E1263A481FCAA4BA79136D")
    public void setMessage(String message) {
        this.message = message;
        // ---------- Original Method ----------
        //this.message = message;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.278 -0400", hash_original_method = "06B95E2D5570D6B3A84011B34076B5C7", hash_generated_method = "5CC56BFEDB70A0CA4C224E8E4C1AA324")
    public long getMillis() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1434402453 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1434402453;
        // ---------- Original Method ----------
        //return millis;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.278 -0400", hash_original_method = "AAA6B913A1F36A93830487DCD9FBEB6E", hash_generated_method = "4A5286A8D3BAD575DF87ABE37A21528A")
    public void setMillis(long millis) {
        this.millis = millis;
        // ---------- Original Method ----------
        //this.millis = millis;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.306 -0400", hash_original_method = "7E2CB3B3486574EE0A68176991A0ECCF", hash_generated_method = "3850FB9E4A8DD64551AB75924235C2E6")
    public Object[] getParameters() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_1615315119 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1615315119 = parameters;
        varB4EAC82CA7396A68D541C85D26508E83_1615315119.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1615315119;
        // ---------- Original Method ----------
        //return parameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.307 -0400", hash_original_method = "A8B44ED180D604C73C7E6D3CC47CE208", hash_generated_method = "EAAF5364DA7321CF27F377D30F3727EC")
    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
        // ---------- Original Method ----------
        //this.parameters = parameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.310 -0400", hash_original_method = "A55D46251237391AC4070653DF8FD1F0", hash_generated_method = "D98592B56661AD34CC580EE2284B8249")
    public ResourceBundle getResourceBundle() {
        ResourceBundle varB4EAC82CA7396A68D541C85D26508E83_2091149431 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2091149431 = resourceBundle;
        varB4EAC82CA7396A68D541C85D26508E83_2091149431.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2091149431;
        // ---------- Original Method ----------
        //return resourceBundle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.311 -0400", hash_original_method = "22E19C2BD30D13ED1AEAB526931847D2", hash_generated_method = "82DB922AF0E3D816DBC8DF664756776E")
    public void setResourceBundle(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
        // ---------- Original Method ----------
        //this.resourceBundle = resourceBundle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.311 -0400", hash_original_method = "73FB3843FBEEE5F85EEE27DAD4E6665A", hash_generated_method = "0C25C9642EB783530526C4FF339E5E5F")
    public String getResourceBundleName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1855899077 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1855899077 = resourceBundleName;
        varB4EAC82CA7396A68D541C85D26508E83_1855899077.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1855899077;
        // ---------- Original Method ----------
        //return resourceBundleName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.312 -0400", hash_original_method = "953EDB4ADFDF1563BD9A241A7063EF86", hash_generated_method = "DB340DADBDA61DCE3A5BCDCFF788C469")
    public void setResourceBundleName(String resourceBundleName) {
        this.resourceBundleName = resourceBundleName;
        // ---------- Original Method ----------
        //this.resourceBundleName = resourceBundleName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.312 -0400", hash_original_method = "5B99D7AA47A1BEEC3DF03D05A32BB6DB", hash_generated_method = "C957250CBAC9B1E2315EA159455F6845")
    public long getSequenceNumber() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2010826275 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2010826275;
        // ---------- Original Method ----------
        //return sequenceNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.313 -0400", hash_original_method = "A872117CAF84BB70B3F50AB7DBB15709", hash_generated_method = "36A35E268F041883EE2560486480F2F4")
    public void setSequenceNumber(long sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
        // ---------- Original Method ----------
        //this.sequenceNumber = sequenceNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.348 -0400", hash_original_method = "17474CC4607EF1F80968125D954E4F2F", hash_generated_method = "A9DF87D0A4C1EB9A3D8B0F40A597CCC6")
    public String getSourceClassName() {
        String varB4EAC82CA7396A68D541C85D26508E83_978838318 = null; //Variable for return #1
        initSource();
        varB4EAC82CA7396A68D541C85D26508E83_978838318 = sourceClassName;
        varB4EAC82CA7396A68D541C85D26508E83_978838318.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_978838318;
        // ---------- Original Method ----------
        //initSource();
        //return sourceClassName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.388 -0400", hash_original_method = "598A8AAA0AD5798486DE87D6CFFB0E3D", hash_generated_method = "DEF8B972CEA13ABA483A79AABFE171F9")
    private void initSource() {
        boolean sawLogger;
        sawLogger = false;
        {
            Iterator<StackTraceElement> var412260696C7699D2B1F269A8E633565D_1695875032 = (new Throwable().getStackTrace()).iterator();
            var412260696C7699D2B1F269A8E633565D_1695875032.hasNext();
            StackTraceElement element = var412260696C7699D2B1F269A8E633565D_1695875032.next();
            {
                String current;
                current = element.getClassName();
                {
                    boolean varD3C8C54B33E01F84E69DE674172CDD86_202243459 = (current.startsWith(Logger.class.getName()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.389 -0400", hash_original_method = "4073B854D67A7DD73FA3797FFA5DDD0A", hash_generated_method = "B1E4EB455B67315901A563571AF6A0E5")
    public void setSourceClassName(String sourceClassName) {
        sourceInitialized = true;
        this.sourceClassName = sourceClassName;
        // ---------- Original Method ----------
        //sourceInitialized = true;
        //this.sourceClassName = sourceClassName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.403 -0400", hash_original_method = "997894DE44F9E4C217C990670A2096CD", hash_generated_method = "644CED3ECBB50B0A06CFED46C62E2147")
    public String getSourceMethodName() {
        String varB4EAC82CA7396A68D541C85D26508E83_678111140 = null; //Variable for return #1
        initSource();
        varB4EAC82CA7396A68D541C85D26508E83_678111140 = sourceMethodName;
        varB4EAC82CA7396A68D541C85D26508E83_678111140.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_678111140;
        // ---------- Original Method ----------
        //initSource();
        //return sourceMethodName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.404 -0400", hash_original_method = "6DB80156486F9B3573D791516F5BFF16", hash_generated_method = "2100A9D45537A528897DE9D1784E0F3D")
    public void setSourceMethodName(String sourceMethodName) {
        sourceInitialized = true;
        this.sourceMethodName = sourceMethodName;
        // ---------- Original Method ----------
        //sourceInitialized = true;
        //this.sourceMethodName = sourceMethodName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.404 -0400", hash_original_method = "23D166A70BC333A13745104EBA97F318", hash_generated_method = "DCD1963B416939689FF76A199CE01DCA")
    public int getThreadID() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_212763702 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_212763702;
        // ---------- Original Method ----------
        //return threadID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.405 -0400", hash_original_method = "BFD778F3BC25BE448B5B49F6297DA90A", hash_generated_method = "242E8DAC4BAF6C1976325C1A9D10F46A")
    public void setThreadID(int threadID) {
        this.threadID = threadID;
        // ---------- Original Method ----------
        //this.threadID = threadID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.406 -0400", hash_original_method = "9281C9177DD0647B668ECFF1744AEA20", hash_generated_method = "8FB9E3FD8B4DCE0F2AEE5937806C2183")
    public Throwable getThrown() {
        Throwable varB4EAC82CA7396A68D541C85D26508E83_1517462447 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1517462447 = thrown;
        varB4EAC82CA7396A68D541C85D26508E83_1517462447.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1517462447;
        // ---------- Original Method ----------
        //return thrown;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.424 -0400", hash_original_method = "11A0184E1F2F67806A14E7D6384E1936", hash_generated_method = "D3014FF7E704F60A198DAA6CB1A11C82")
    public void setThrown(Throwable thrown) {
        this.thrown = thrown;
        // ---------- Original Method ----------
        //this.thrown = thrown;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.483 -0400", hash_original_method = "D3EC386C5EF05328C43DBAC50DDD8B32", hash_generated_method = "ECDFE7C8F62E4B13B5F2C91132C2DC6F")
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeByte(MAJOR);
        out.writeByte(MINOR);
        {
            out.writeInt(-1);
        } //End block
        {
            out.writeInt(parameters.length);
            {
                Iterator<Object> var35A55D5F929598A448AA3E472A6670DC_453868799 = (parameters).iterator();
                var35A55D5F929598A448AA3E472A6670DC_453868799.hasNext();
                Object element = var35A55D5F929598A448AA3E472A6670DC_453868799.next();
                {
                    out.writeObject((element == null) ? null : element.toString());
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(out.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.485 -0400", hash_original_method = "807ED1C9D5895C8055BA2AC3A6A18BB7", hash_generated_method = "7295FC328C66A41C2669D7850A37DEC7")
    private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.485 -0400", hash_original_field = "3C7CD3FF45A11B4588E66C095240288A", hash_generated_field = "1114DC9F6E8DC1FAD18DA3506B6F4251")

    private static long serialVersionUID = 5372048053134512534L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.485 -0400", hash_original_field = "49EF833FEE3AC02E8ABC060A6F96D34C", hash_generated_field = "418FD7D7F30B746CD4D1FF982C357785")

    private static int MAJOR = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.486 -0400", hash_original_field = "FE1AF383C9FB02C4FD7A83431F9ECF56", hash_generated_field = "8F246E20459C10C14EE12E70EA0A617A")

    private static int MINOR = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.486 -0400", hash_original_field = "8BADAB71E0DFCA09302867D884003FA1", hash_generated_field = "CC2F29FD42442009803272BEA1684586")

    private static long currentSequenceNumber = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.486 -0400", hash_original_field = "FD354ACE7726546771AB7005175FBC1C", hash_generated_field = "5D45E26224F98EDE48676A277432CF17")

    private static ThreadLocal<Integer> currentThreadId = new ThreadLocal<Integer>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.486 -0400", hash_original_field = "6FC8380FDB8AEA549BE3D45FAB237BF5", hash_generated_field = "8B68CCE7CA2AE773B1F76EB86CA3AA2E")

    private static int initThreadId = 0;
}

