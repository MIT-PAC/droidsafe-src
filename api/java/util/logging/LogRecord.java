package java.util.logging;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class LogRecord implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.213 -0400", hash_original_field = "C9E9A848920877E76685B2E4E76DE38D", hash_generated_field = "D176117E1979538AD7BA6376A3FC48D1")

    private Level level;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.213 -0400", hash_original_field = "1C021ADF174562C07D271E889F46BABF", hash_generated_field = "BC5948EFF55F237F777F173C3B803F01")

    private long sequenceNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.213 -0400", hash_original_field = "C8F28615620E0FDF6D068627412C9C60", hash_generated_field = "E7484D132988AB8A218EBBB6F4C937EF")

    private String sourceClassName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.213 -0400", hash_original_field = "EE7A35AFE35C441E1A548E403E317D64", hash_generated_field = "81FA7CA43AE91B1E32F984A641166061")

    private String sourceMethodName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.213 -0400", hash_original_field = "78E731027D8FD50ED642340B7C9A63B3", hash_generated_field = "B2821CE5540C52B19670BB2C4012F012")

    private String message;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.213 -0400", hash_original_field = "77FF125E7D621F2339535A6CB37AB5EA", hash_generated_field = "5AB23C2D89794456F0D764D36F383221")

    private int threadID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.213 -0400", hash_original_field = "259A879E32720D127D38B39F2F1385B5", hash_generated_field = "E3CD630B97ABFDE87A9DC271D58DE1ED")

    private long millis;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.213 -0400", hash_original_field = "357498E03A88A17F471ABA561D9FE677", hash_generated_field = "E32F8106A85DC08D94773FEA1421B50C")

    private Throwable thrown;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.213 -0400", hash_original_field = "56275512C01CD2AF07FEDE66357B8E45", hash_generated_field = "78418409580FEF5261250A822405992B")

    private String loggerName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.213 -0400", hash_original_field = "9623BCEF06C4EDCE06D889B615841D11", hash_generated_field = "4BDB4C6F49EE0D4ED40E32BE56CE6580")

    private String resourceBundleName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.213 -0400", hash_original_field = "228A0F6DF977A45B5000D16BFD04B1D8", hash_generated_field = "82DE0F7C7F7A3179590FF9326C8E9161")

    private transient ResourceBundle resourceBundle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.213 -0400", hash_original_field = "166E64F6C3677D0C513901242A3E702D", hash_generated_field = "D325420CF44BA7CE0D67532042AEB224")

    private transient Object[] parameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.213 -0400", hash_original_field = "92CC66101B4F91BB70A782AC7E706090", hash_generated_field = "2E420C590FA5A2985360004D724DB08D")

    private transient boolean sourceInitialized;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.231 -0400", hash_original_method = "022A0341917C5DE72EB88D3FD14C370E", hash_generated_method = "BDA97495A8DA9E3048676180EA8B9675")
    public  LogRecord(Level level, String msg) {
    if(level == null)        
        {
            NullPointerException var04D39AD1AE7512C3677AEC50E1DB2FD5_2064485357 = new NullPointerException("level == null");
            var04D39AD1AE7512C3677AEC50E1DB2FD5_2064485357.addTaint(taint);
            throw var04D39AD1AE7512C3677AEC50E1DB2FD5_2064485357;
        } //End block
        this.level = level;
        this.message = msg;
        this.millis = System.currentTimeMillis();
        synchronized
(LogRecord.class)        {
            this.sequenceNumber = currentSequenceNumber++;
            Integer id = currentThreadId.get();
    if(id == null)            
            {
                this.threadID = initThreadId;
                currentThreadId.set(Integer.valueOf(initThreadId++));
            } //End block
            else
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.232 -0400", hash_original_method = "0FEEFD0C4767A5B5B477CADC6D101FDE", hash_generated_method = "2220A3AC89C4E7A3AA49996060C48B72")
    public Level getLevel() {
Level varBBB01F92FFE3DDEF2182A71AE5793430_1513851799 =         level;
        varBBB01F92FFE3DDEF2182A71AE5793430_1513851799.addTaint(taint);
        return varBBB01F92FFE3DDEF2182A71AE5793430_1513851799;
        // ---------- Original Method ----------
        //return level;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.232 -0400", hash_original_method = "1C71253C97024F86DF08173E2DC14542", hash_generated_method = "070C672193DA3DB83E76254D9F5B371F")
    public void setLevel(Level level) {
    if(level == null)        
        {
            NullPointerException var04D39AD1AE7512C3677AEC50E1DB2FD5_268030743 = new NullPointerException("level == null");
            var04D39AD1AE7512C3677AEC50E1DB2FD5_268030743.addTaint(taint);
            throw var04D39AD1AE7512C3677AEC50E1DB2FD5_268030743;
        } //End block
        this.level = level;
        // ---------- Original Method ----------
        //if (level == null) {
            //throw new NullPointerException("level == null");
        //}
        //this.level = level;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.233 -0400", hash_original_method = "F91ED8A8026304D4EB26E347DCDA5498", hash_generated_method = "BA3F3F3AC84B63651FBF38386C9D26AD")
    public String getLoggerName() {
String var6AE45EC7DF15F0C56515E791110DC732_600034348 =         loggerName;
        var6AE45EC7DF15F0C56515E791110DC732_600034348.addTaint(taint);
        return var6AE45EC7DF15F0C56515E791110DC732_600034348;
        // ---------- Original Method ----------
        //return loggerName;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.233 -0400", hash_original_method = "A458AA58D2D6B65ABAE0935E2AD2D855", hash_generated_method = "4107C4AC85EC187BD5ACF284D6F4D27F")
    public void setLoggerName(String loggerName) {
        this.loggerName = loggerName;
        // ---------- Original Method ----------
        //this.loggerName = loggerName;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.233 -0400", hash_original_method = "AF20B727F6E1F2FE1F73E3107355CAA7", hash_generated_method = "E96C9EB7FA5AAEC8FAA690BD5011B7CB")
    public String getMessage() {
String varFD182D7074F3848E773A38B067BBB880_65060135 =         message;
        varFD182D7074F3848E773A38B067BBB880_65060135.addTaint(taint);
        return varFD182D7074F3848E773A38B067BBB880_65060135;
        // ---------- Original Method ----------
        //return message;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.234 -0400", hash_original_method = "9A40E46319AC2A39DCEE47C689D1B957", hash_generated_method = "ECD2FD94E8E1263A481FCAA4BA79136D")
    public void setMessage(String message) {
        this.message = message;
        // ---------- Original Method ----------
        //this.message = message;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.234 -0400", hash_original_method = "06B95E2D5570D6B3A84011B34076B5C7", hash_generated_method = "422ACA6B9A4612EDE3E70387FB1FB47F")
    public long getMillis() {
        long var259A879E32720D127D38B39F2F1385B5_1484034343 = (millis);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_2147112792 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2147112792;
        // ---------- Original Method ----------
        //return millis;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.234 -0400", hash_original_method = "AAA6B913A1F36A93830487DCD9FBEB6E", hash_generated_method = "4A5286A8D3BAD575DF87ABE37A21528A")
    public void setMillis(long millis) {
        this.millis = millis;
        // ---------- Original Method ----------
        //this.millis = millis;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.234 -0400", hash_original_method = "7E2CB3B3486574EE0A68176991A0ECCF", hash_generated_method = "207D26893D48CB8AED8E78242AEC04FD")
    public Object[] getParameters() {
Object[] var3CB0A38B794BDEDADB1F50256E0AE35B_1393699480 =         parameters;
        var3CB0A38B794BDEDADB1F50256E0AE35B_1393699480.addTaint(taint);
        return var3CB0A38B794BDEDADB1F50256E0AE35B_1393699480;
        // ---------- Original Method ----------
        //return parameters;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.234 -0400", hash_original_method = "A8B44ED180D604C73C7E6D3CC47CE208", hash_generated_method = "EAAF5364DA7321CF27F377D30F3727EC")
    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
        // ---------- Original Method ----------
        //this.parameters = parameters;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.234 -0400", hash_original_method = "A55D46251237391AC4070653DF8FD1F0", hash_generated_method = "D5D7207B7859C2B275231EF92EB28BCC")
    public ResourceBundle getResourceBundle() {
ResourceBundle varD5B8822BB1F67E996F69C6A3B1291C5B_1178084692 =         resourceBundle;
        varD5B8822BB1F67E996F69C6A3B1291C5B_1178084692.addTaint(taint);
        return varD5B8822BB1F67E996F69C6A3B1291C5B_1178084692;
        // ---------- Original Method ----------
        //return resourceBundle;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.234 -0400", hash_original_method = "22E19C2BD30D13ED1AEAB526931847D2", hash_generated_method = "82DB922AF0E3D816DBC8DF664756776E")
    public void setResourceBundle(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
        // ---------- Original Method ----------
        //this.resourceBundle = resourceBundle;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.234 -0400", hash_original_method = "73FB3843FBEEE5F85EEE27DAD4E6665A", hash_generated_method = "964F1E0A9ABAF27F5A12569886C38CD6")
    public String getResourceBundleName() {
String var506B431B3C5514F7A1B8B5DDED2D5487_575737794 =         resourceBundleName;
        var506B431B3C5514F7A1B8B5DDED2D5487_575737794.addTaint(taint);
        return var506B431B3C5514F7A1B8B5DDED2D5487_575737794;
        // ---------- Original Method ----------
        //return resourceBundleName;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.235 -0400", hash_original_method = "953EDB4ADFDF1563BD9A241A7063EF86", hash_generated_method = "DB340DADBDA61DCE3A5BCDCFF788C469")
    public void setResourceBundleName(String resourceBundleName) {
        this.resourceBundleName = resourceBundleName;
        // ---------- Original Method ----------
        //this.resourceBundleName = resourceBundleName;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.235 -0400", hash_original_method = "5B99D7AA47A1BEEC3DF03D05A32BB6DB", hash_generated_method = "01FBA460F416A4BDA2B82285E2DC2113")
    public long getSequenceNumber() {
        long var1C021ADF174562C07D271E889F46BABF_42004157 = (sequenceNumber);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1918541958 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1918541958;
        // ---------- Original Method ----------
        //return sequenceNumber;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.235 -0400", hash_original_method = "A872117CAF84BB70B3F50AB7DBB15709", hash_generated_method = "36A35E268F041883EE2560486480F2F4")
    public void setSequenceNumber(long sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
        // ---------- Original Method ----------
        //this.sequenceNumber = sequenceNumber;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.235 -0400", hash_original_method = "17474CC4607EF1F80968125D954E4F2F", hash_generated_method = "7E03822AC130AFD36B195E27D84287D7")
    public String getSourceClassName() {
        initSource();
String varCE6263497718737993944F6381168118_1740851297 =         sourceClassName;
        varCE6263497718737993944F6381168118_1740851297.addTaint(taint);
        return varCE6263497718737993944F6381168118_1740851297;
        // ---------- Original Method ----------
        //initSource();
        //return sourceClassName;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.235 -0400", hash_original_method = "598A8AAA0AD5798486DE87D6CFFB0E3D", hash_generated_method = "D658DF5E810848F30FF85C03420AD37D")
    private void initSource() {
    if(sourceInitialized)        
        {
            return;
        } //End block
        boolean sawLogger = false;
for(StackTraceElement element : new Throwable().getStackTrace())
        {
            String current = element.getClassName();
    if(current.startsWith(Logger.class.getName()))            
            {
                sawLogger = true;
            } //End block
            else
    if(sawLogger)            
            {
                this.sourceClassName = element.getClassName();
                this.sourceMethodName = element.getMethodName();
                break;
            } //End block
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.235 -0400", hash_original_method = "4073B854D67A7DD73FA3797FFA5DDD0A", hash_generated_method = "B1E4EB455B67315901A563571AF6A0E5")
    public void setSourceClassName(String sourceClassName) {
        sourceInitialized = true;
        this.sourceClassName = sourceClassName;
        // ---------- Original Method ----------
        //sourceInitialized = true;
        //this.sourceClassName = sourceClassName;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.235 -0400", hash_original_method = "997894DE44F9E4C217C990670A2096CD", hash_generated_method = "C84F6B63C780BCBD3137E8BE4BC1D4B7")
    public String getSourceMethodName() {
        initSource();
String varE932A73D87763A704173CF8783AEB9D1_1159837548 =         sourceMethodName;
        varE932A73D87763A704173CF8783AEB9D1_1159837548.addTaint(taint);
        return varE932A73D87763A704173CF8783AEB9D1_1159837548;
        // ---------- Original Method ----------
        //initSource();
        //return sourceMethodName;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.235 -0400", hash_original_method = "6DB80156486F9B3573D791516F5BFF16", hash_generated_method = "2100A9D45537A528897DE9D1784E0F3D")
    public void setSourceMethodName(String sourceMethodName) {
        sourceInitialized = true;
        this.sourceMethodName = sourceMethodName;
        // ---------- Original Method ----------
        //sourceInitialized = true;
        //this.sourceMethodName = sourceMethodName;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.236 -0400", hash_original_method = "23D166A70BC333A13745104EBA97F318", hash_generated_method = "C45D7EF1AA1EBE0A00433863F9682510")
    public int getThreadID() {
        int var77FF125E7D621F2339535A6CB37AB5EA_895396761 = (threadID);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1304557236 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1304557236;
        // ---------- Original Method ----------
        //return threadID;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.236 -0400", hash_original_method = "BFD778F3BC25BE448B5B49F6297DA90A", hash_generated_method = "242E8DAC4BAF6C1976325C1A9D10F46A")
    public void setThreadID(int threadID) {
        this.threadID = threadID;
        // ---------- Original Method ----------
        //this.threadID = threadID;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.236 -0400", hash_original_method = "9281C9177DD0647B668ECFF1744AEA20", hash_generated_method = "F9AD231837338DAC02936D84336E6316")
    public Throwable getThrown() {
Throwable var40084472BF9BAFD590E7F3643D5F17C8_1599886481 =         thrown;
        var40084472BF9BAFD590E7F3643D5F17C8_1599886481.addTaint(taint);
        return var40084472BF9BAFD590E7F3643D5F17C8_1599886481;
        // ---------- Original Method ----------
        //return thrown;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.236 -0400", hash_original_method = "11A0184E1F2F67806A14E7D6384E1936", hash_generated_method = "D3014FF7E704F60A198DAA6CB1A11C82")
    public void setThrown(Throwable thrown) {
        this.thrown = thrown;
        // ---------- Original Method ----------
        //this.thrown = thrown;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.236 -0400", hash_original_method = "D3EC386C5EF05328C43DBAC50DDD8B32", hash_generated_method = "84609218223FCD271ED79489DCE3DB13")
    private void writeObject(ObjectOutputStream out) throws IOException {
        addTaint(out.getTaint());
        out.defaultWriteObject();
        out.writeByte(MAJOR);
        out.writeByte(MINOR);
    if(parameters == null)        
        {
            out.writeInt(-1);
        } //End block
        else
        {
            out.writeInt(parameters.length);
for(Object element : parameters)
            {
                out.writeObject((element == null) ? null : element.toString());
            } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.236 -0400", hash_original_method = "807ED1C9D5895C8055BA2AC3A6A18BB7", hash_generated_method = "BAB1337A0F1A1D1B77803770958A0118")
    private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        in.defaultReadObject();
        byte major = in.readByte();
        byte minor = in.readByte();
    if(major != MAJOR)        
        {
            IOException varA24FABAC91A100EC76E386BAA573F7F4_139111704 = new IOException("Different version " + Byte.valueOf(major) + "." + Byte.valueOf(minor));
            varA24FABAC91A100EC76E386BAA573F7F4_139111704.addTaint(taint);
            throw varA24FABAC91A100EC76E386BAA573F7F4_139111704;
        } //End block
        int length = in.readInt();
    if(length >= 0)        
        {
            parameters = new Object[length];
for(int i = 0;i < parameters.length;i++)
            {
                parameters[i] = in.readObject();
            } //End block
        } //End block
    if(resourceBundleName != null)        
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.237 -0400", hash_original_field = "3C7CD3FF45A11B4588E66C095240288A", hash_generated_field = "CAE9E558857FCF7C7C7CECCC5AA0F51B")

    private static final long serialVersionUID = 5372048053134512534L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.237 -0400", hash_original_field = "49EF833FEE3AC02E8ABC060A6F96D34C", hash_generated_field = "39FDEF400FCCABBE75040FB1511C9506")

    private static final int MAJOR = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.237 -0400", hash_original_field = "FE1AF383C9FB02C4FD7A83431F9ECF56", hash_generated_field = "F7B9D06369E918F7E4CC99B9737AEF9E")

    private static final int MINOR = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.237 -0400", hash_original_field = "8BADAB71E0DFCA09302867D884003FA1", hash_generated_field = "CC2F29FD42442009803272BEA1684586")

    private static long currentSequenceNumber = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.237 -0400", hash_original_field = "FD354ACE7726546771AB7005175FBC1C", hash_generated_field = "5D45E26224F98EDE48676A277432CF17")

    private static ThreadLocal<Integer> currentThreadId = new ThreadLocal<Integer>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:18.237 -0400", hash_original_field = "6FC8380FDB8AEA549BE3D45FAB237BF5", hash_generated_field = "8B68CCE7CA2AE773B1F76EB86CA3AA2E")

    private static int initThreadId = 0;
}

