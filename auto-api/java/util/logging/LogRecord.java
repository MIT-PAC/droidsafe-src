package java.util.logging;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class LogRecord implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.416 -0400", hash_original_field = "C9E9A848920877E76685B2E4E76DE38D", hash_generated_field = "D176117E1979538AD7BA6376A3FC48D1")

    private Level level;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.416 -0400", hash_original_field = "1C021ADF174562C07D271E889F46BABF", hash_generated_field = "BC5948EFF55F237F777F173C3B803F01")

    private long sequenceNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.416 -0400", hash_original_field = "C8F28615620E0FDF6D068627412C9C60", hash_generated_field = "E7484D132988AB8A218EBBB6F4C937EF")

    private String sourceClassName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.416 -0400", hash_original_field = "EE7A35AFE35C441E1A548E403E317D64", hash_generated_field = "81FA7CA43AE91B1E32F984A641166061")

    private String sourceMethodName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.416 -0400", hash_original_field = "78E731027D8FD50ED642340B7C9A63B3", hash_generated_field = "B2821CE5540C52B19670BB2C4012F012")

    private String message;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.416 -0400", hash_original_field = "77FF125E7D621F2339535A6CB37AB5EA", hash_generated_field = "5AB23C2D89794456F0D764D36F383221")

    private int threadID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.416 -0400", hash_original_field = "259A879E32720D127D38B39F2F1385B5", hash_generated_field = "E3CD630B97ABFDE87A9DC271D58DE1ED")

    private long millis;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.416 -0400", hash_original_field = "357498E03A88A17F471ABA561D9FE677", hash_generated_field = "E32F8106A85DC08D94773FEA1421B50C")

    private Throwable thrown;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.416 -0400", hash_original_field = "56275512C01CD2AF07FEDE66357B8E45", hash_generated_field = "78418409580FEF5261250A822405992B")

    private String loggerName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.416 -0400", hash_original_field = "9623BCEF06C4EDCE06D889B615841D11", hash_generated_field = "4BDB4C6F49EE0D4ED40E32BE56CE6580")

    private String resourceBundleName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.416 -0400", hash_original_field = "228A0F6DF977A45B5000D16BFD04B1D8", hash_generated_field = "82DE0F7C7F7A3179590FF9326C8E9161")

    private transient ResourceBundle resourceBundle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.416 -0400", hash_original_field = "166E64F6C3677D0C513901242A3E702D", hash_generated_field = "D325420CF44BA7CE0D67532042AEB224")

    private transient Object[] parameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.416 -0400", hash_original_field = "92CC66101B4F91BB70A782AC7E706090", hash_generated_field = "2E420C590FA5A2985360004D724DB08D")

    private transient boolean sourceInitialized;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.417 -0400", hash_original_method = "022A0341917C5DE72EB88D3FD14C370E", hash_generated_method = "C007CDA802CCD7A79000D99113298A1C")
    public  LogRecord(Level level, String msg) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("level == null");
        } 
        this.level = level;
        this.message = msg;
        this.millis = System.currentTimeMillis();
        {
            this.sequenceNumber = currentSequenceNumber++;
            Integer id = currentThreadId.get();
            {
                this.threadID = initThreadId;
                currentThreadId.set(Integer.valueOf(initThreadId++));
            } 
            {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.418 -0400", hash_original_method = "0FEEFD0C4767A5B5B477CADC6D101FDE", hash_generated_method = "45A23A1F549667DCF00F280FB8B55B41")
    public Level getLevel() {
        Level varB4EAC82CA7396A68D541C85D26508E83_1375430504 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1375430504 = level;
        varB4EAC82CA7396A68D541C85D26508E83_1375430504.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1375430504;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.418 -0400", hash_original_method = "1C71253C97024F86DF08173E2DC14542", hash_generated_method = "9F039328858FB7C37A14527D741AC03E")
    public void setLevel(Level level) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("level == null");
        } 
        this.level = level;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.418 -0400", hash_original_method = "F91ED8A8026304D4EB26E347DCDA5498", hash_generated_method = "34E313F6B36AE110E3CE2B2738D12262")
    public String getLoggerName() {
        String varB4EAC82CA7396A68D541C85D26508E83_810886459 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_810886459 = loggerName;
        varB4EAC82CA7396A68D541C85D26508E83_810886459.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_810886459;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.419 -0400", hash_original_method = "A458AA58D2D6B65ABAE0935E2AD2D855", hash_generated_method = "4107C4AC85EC187BD5ACF284D6F4D27F")
    public void setLoggerName(String loggerName) {
        this.loggerName = loggerName;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.419 -0400", hash_original_method = "AF20B727F6E1F2FE1F73E3107355CAA7", hash_generated_method = "00D049DA67AF45421E1C22C5BB9A070D")
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_805800289 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_805800289 = message;
        varB4EAC82CA7396A68D541C85D26508E83_805800289.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_805800289;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.419 -0400", hash_original_method = "9A40E46319AC2A39DCEE47C689D1B957", hash_generated_method = "ECD2FD94E8E1263A481FCAA4BA79136D")
    public void setMessage(String message) {
        this.message = message;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.420 -0400", hash_original_method = "06B95E2D5570D6B3A84011B34076B5C7", hash_generated_method = "8D4502A873B319312AB164A5D4080B9D")
    public long getMillis() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_68827217 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_68827217;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.420 -0400", hash_original_method = "AAA6B913A1F36A93830487DCD9FBEB6E", hash_generated_method = "4A5286A8D3BAD575DF87ABE37A21528A")
    public void setMillis(long millis) {
        this.millis = millis;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.421 -0400", hash_original_method = "7E2CB3B3486574EE0A68176991A0ECCF", hash_generated_method = "CE7895FA0FC6E10EEC5AD24DE2D4B61E")
    public Object[] getParameters() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_845789163 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_845789163 = parameters;
        varB4EAC82CA7396A68D541C85D26508E83_845789163.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_845789163;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.421 -0400", hash_original_method = "A8B44ED180D604C73C7E6D3CC47CE208", hash_generated_method = "EAAF5364DA7321CF27F377D30F3727EC")
    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.422 -0400", hash_original_method = "A55D46251237391AC4070653DF8FD1F0", hash_generated_method = "931FA60E09637C4210C4C24B0ABC516D")
    public ResourceBundle getResourceBundle() {
        ResourceBundle varB4EAC82CA7396A68D541C85D26508E83_2050728300 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2050728300 = resourceBundle;
        varB4EAC82CA7396A68D541C85D26508E83_2050728300.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2050728300;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.422 -0400", hash_original_method = "22E19C2BD30D13ED1AEAB526931847D2", hash_generated_method = "82DB922AF0E3D816DBC8DF664756776E")
    public void setResourceBundle(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.422 -0400", hash_original_method = "73FB3843FBEEE5F85EEE27DAD4E6665A", hash_generated_method = "A9C157F1F3F98ACE5B39E95FF385F95E")
    public String getResourceBundleName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1125593951 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1125593951 = resourceBundleName;
        varB4EAC82CA7396A68D541C85D26508E83_1125593951.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1125593951;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.423 -0400", hash_original_method = "953EDB4ADFDF1563BD9A241A7063EF86", hash_generated_method = "DB340DADBDA61DCE3A5BCDCFF788C469")
    public void setResourceBundleName(String resourceBundleName) {
        this.resourceBundleName = resourceBundleName;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.423 -0400", hash_original_method = "5B99D7AA47A1BEEC3DF03D05A32BB6DB", hash_generated_method = "C7CC961D30645890DFEEF7F7A8F52812")
    public long getSequenceNumber() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_263774235 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_263774235;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.423 -0400", hash_original_method = "A872117CAF84BB70B3F50AB7DBB15709", hash_generated_method = "36A35E268F041883EE2560486480F2F4")
    public void setSequenceNumber(long sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.424 -0400", hash_original_method = "17474CC4607EF1F80968125D954E4F2F", hash_generated_method = "139467894BC7B86EE190A30D4E2646EA")
    public String getSourceClassName() {
        String varB4EAC82CA7396A68D541C85D26508E83_901781790 = null; 
        initSource();
        varB4EAC82CA7396A68D541C85D26508E83_901781790 = sourceClassName;
        varB4EAC82CA7396A68D541C85D26508E83_901781790.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_901781790;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.428 -0400", hash_original_method = "598A8AAA0AD5798486DE87D6CFFB0E3D", hash_generated_method = "74734CBFADD829FA5E5200B169A0FAFA")
    private void initSource() {
        boolean sawLogger = false;
        {
            StackTraceElement element = new Throwable().getStackTrace()[0];
            {
                String current = element.getClassName();
                {
                    boolean varD3C8C54B33E01F84E69DE674172CDD86_371894112 = (current.startsWith(Logger.class.getName()));
                    {
                        sawLogger = true;
                    } 
                    {
                        this.sourceClassName = element.getClassName();
                        this.sourceMethodName = element.getMethodName();
                    } 
                } 
            } 
        } 
        sourceInitialized = true;
        
        
            
        
        
        
            
            
                
            
                
                
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.429 -0400", hash_original_method = "4073B854D67A7DD73FA3797FFA5DDD0A", hash_generated_method = "B1E4EB455B67315901A563571AF6A0E5")
    public void setSourceClassName(String sourceClassName) {
        sourceInitialized = true;
        this.sourceClassName = sourceClassName;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.430 -0400", hash_original_method = "997894DE44F9E4C217C990670A2096CD", hash_generated_method = "EDAB12E4C0C9CDF48EC0FFC55CEC63FB")
    public String getSourceMethodName() {
        String varB4EAC82CA7396A68D541C85D26508E83_300329053 = null; 
        initSource();
        varB4EAC82CA7396A68D541C85D26508E83_300329053 = sourceMethodName;
        varB4EAC82CA7396A68D541C85D26508E83_300329053.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_300329053;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.431 -0400", hash_original_method = "6DB80156486F9B3573D791516F5BFF16", hash_generated_method = "2100A9D45537A528897DE9D1784E0F3D")
    public void setSourceMethodName(String sourceMethodName) {
        sourceInitialized = true;
        this.sourceMethodName = sourceMethodName;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.431 -0400", hash_original_method = "23D166A70BC333A13745104EBA97F318", hash_generated_method = "F8289B1B0A03C4E6193432A0A2E6B0A5")
    public int getThreadID() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_505062828 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_505062828;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.432 -0400", hash_original_method = "BFD778F3BC25BE448B5B49F6297DA90A", hash_generated_method = "242E8DAC4BAF6C1976325C1A9D10F46A")
    public void setThreadID(int threadID) {
        this.threadID = threadID;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.433 -0400", hash_original_method = "9281C9177DD0647B668ECFF1744AEA20", hash_generated_method = "56F4E53206B361591F1106665EB76430")
    public Throwable getThrown() {
        Throwable varB4EAC82CA7396A68D541C85D26508E83_1810693441 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1810693441 = thrown;
        varB4EAC82CA7396A68D541C85D26508E83_1810693441.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1810693441;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.433 -0400", hash_original_method = "11A0184E1F2F67806A14E7D6384E1936", hash_generated_method = "D3014FF7E704F60A198DAA6CB1A11C82")
    public void setThrown(Throwable thrown) {
        this.thrown = thrown;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.439 -0400", hash_original_method = "D3EC386C5EF05328C43DBAC50DDD8B32", hash_generated_method = "487AC3F2F1B42EFFBD0E4F541FD37679")
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeByte(MAJOR);
        out.writeByte(MINOR);
        {
            out.writeInt(-1);
        } 
        {
            out.writeInt(parameters.length);
            {
                Object element = parameters[0];
                {
                    out.writeObject((element == null) ? null : element.toString());
                } 
            } 
        } 
        addTaint(out.getTaint());
        
        
        
        
        
            
        
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.440 -0400", hash_original_method = "807ED1C9D5895C8055BA2AC3A6A18BB7", hash_generated_method = "4F94F78B3079506F1BCE08FD9AE55CB7")
    private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        in.defaultReadObject();
        byte major = in.readByte();
        byte minor = in.readByte();
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Different version " + Byte.valueOf(major) + "." + Byte.valueOf(minor));
        } 
        int length = in.readInt();
        {
            parameters = new Object[length];
            {
                int i = 0;
                {
                    parameters[i] = in.readObject();
                } 
            } 
        } 
        {
            try 
            {
                resourceBundle = Logger.loadResourceBundle(resourceBundleName);
            } 
            catch (MissingResourceException e)
            {
                resourceBundle = null;
            } 
        } 
        
        
        
        
        
            
        
        
        
            
            
                
            
        
        
            
                
            
                
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.440 -0400", hash_original_field = "3C7CD3FF45A11B4588E66C095240288A", hash_generated_field = "CAE9E558857FCF7C7C7CECCC5AA0F51B")

    private static final long serialVersionUID = 5372048053134512534L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.440 -0400", hash_original_field = "49EF833FEE3AC02E8ABC060A6F96D34C", hash_generated_field = "39FDEF400FCCABBE75040FB1511C9506")

    private static final int MAJOR = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.440 -0400", hash_original_field = "FE1AF383C9FB02C4FD7A83431F9ECF56", hash_generated_field = "F7B9D06369E918F7E4CC99B9737AEF9E")

    private static final int MINOR = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.440 -0400", hash_original_field = "8BADAB71E0DFCA09302867D884003FA1", hash_generated_field = "CC2F29FD42442009803272BEA1684586")

    private static long currentSequenceNumber = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.440 -0400", hash_original_field = "FD354ACE7726546771AB7005175FBC1C", hash_generated_field = "5D45E26224F98EDE48676A277432CF17")

    private static ThreadLocal<Integer> currentThreadId = new ThreadLocal<Integer>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.440 -0400", hash_original_field = "6FC8380FDB8AEA549BE3D45FAB237BF5", hash_generated_field = "8B68CCE7CA2AE773B1F76EB86CA3AA2E")

    private static int initThreadId = 0;
}

