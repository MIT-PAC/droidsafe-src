package org.apache.commons.logging.impl;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.logging.Log;

public class Jdk14Logger implements Log, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:28.017 -0400", hash_original_field = "4400709C3053BCEA3D08290498B4E677", hash_generated_field = "025246D335C438AB38D500F038665755")

    protected transient Logger logger = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:28.017 -0400", hash_original_field = "6D6832C945CE1F820B62E7ED6D65FF6B", hash_generated_field = "A65B7A2EB7276989EDAA9F8572439D68")

    protected String name = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:28.017 -0400", hash_original_method = "7BF4C742F8C5ACA23F214E18E295ECBB", hash_generated_method = "6B46B2B2E363B95E607D2463C3D691C8")
    public  Jdk14Logger(String name) {
        this.name = name;
        logger = getLogger();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:28.018 -0400", hash_original_method = "C5765CC5B1B39AF0EFD6226D38EFAF69", hash_generated_method = "DF79140CA2C8A36FDFD15D65F4CBAC19")
    private void log( Level level, String msg, Throwable ex ) {
        addTaint(ex.getTaint());
        addTaint(msg.getTaint());
        addTaint(level.getTaint());
        Logger logger = getLogger();
    if(logger.isLoggable(level))        
        {
            Throwable dummyException = new Throwable();
            StackTraceElement locations[] = dummyException.getStackTrace();
            String cname = "unknown";
            String method = "unknown";
    if(locations!=null && locations.length >2)            
            {
                StackTraceElement caller = locations[2];
                cname=caller.getClassName();
                method=caller.getMethodName();
            } 
    if(ex==null)            
            {
                logger.logp( level, cname, method, msg );
            } 
            else
            {
                logger.logp( level, cname, method, msg, ex );
            } 
        } 
        
        
        
            
            
            
            
            
                
                
                
            
            
                
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:28.018 -0400", hash_original_method = "B2D3144426F7F3C4C82468ADF000A2A4", hash_generated_method = "413BD276102E00F8262E4F7E3B3C5CC3")
    public void debug(Object message) {
        addTaint(message.getTaint());
        log(Level.FINE, String.valueOf(message), null);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:28.018 -0400", hash_original_method = "67E70CE5ABA347B2A58E5303263E33C3", hash_generated_method = "796E96FB634DDD8F8B4CB175A4910AC3")
    public void debug(Object message, Throwable exception) {
        addTaint(exception.getTaint());
        addTaint(message.getTaint());
        log(Level.FINE, String.valueOf(message), exception);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:28.018 -0400", hash_original_method = "07041611E15894BBB578208C2F3AAD76", hash_generated_method = "40F4A97444B07BA48B134E5E7ABE7E93")
    public void error(Object message) {
        addTaint(message.getTaint());
        log(Level.SEVERE, String.valueOf(message), null);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:28.018 -0400", hash_original_method = "50074BA46CE711F7C7225760B0DBD702", hash_generated_method = "EC4B82111037AE56F47AFF0AD6AEF97F")
    public void error(Object message, Throwable exception) {
        addTaint(exception.getTaint());
        addTaint(message.getTaint());
        log(Level.SEVERE, String.valueOf(message), exception);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:28.018 -0400", hash_original_method = "EE858F66DF718641EEB790378894310A", hash_generated_method = "77A98CA44CCEF8C8F088F1BAD4C5EA2E")
    public void fatal(Object message) {
        addTaint(message.getTaint());
        log(Level.SEVERE, String.valueOf(message), null);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:28.018 -0400", hash_original_method = "E991CC87C4293999DC349BC54F0EAD62", hash_generated_method = "F60FBD90840CE073FFD65879306A0973")
    public void fatal(Object message, Throwable exception) {
        addTaint(exception.getTaint());
        addTaint(message.getTaint());
        log(Level.SEVERE, String.valueOf(message), exception);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:28.019 -0400", hash_original_method = "4AF846FE0103434E8DCD79250F0704EC", hash_generated_method = "80F8105A1D75537D28649D6209F74D56")
    public Logger getLogger() {
    if(logger == null)        
        {
            logger = Logger.getLogger(name);
        } 
Logger varE333E6411FB9531C7E180672E74CC8C8_803495923 =         (logger);
        varE333E6411FB9531C7E180672E74CC8C8_803495923.addTaint(taint);
        return varE333E6411FB9531C7E180672E74CC8C8_803495923;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:28.019 -0400", hash_original_method = "F26DF600BAA1C269DA55D89F10A0C288", hash_generated_method = "A13714DE70055CAEC53F8F72B8F632E8")
    public void info(Object message) {
        addTaint(message.getTaint());
        log(Level.INFO, String.valueOf(message), null);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:28.019 -0400", hash_original_method = "2E6509BB2E24DB9AA8C338F19EA4BC2D", hash_generated_method = "A74DBA5AF4EA61BFE73B47B6D4D58C51")
    public void info(Object message, Throwable exception) {
        addTaint(exception.getTaint());
        addTaint(message.getTaint());
        log(Level.INFO, String.valueOf(message), exception);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:28.019 -0400", hash_original_method = "1B54E28475DEC6550B23EDEA7E3734FF", hash_generated_method = "DFCBE974446F9D05DD6F29E0606AF9F1")
    public boolean isDebugEnabled() {
        boolean varDD73793EF97DF51FAAD856438D6F1EFE_1953492612 = ((getLogger().isLoggable(Level.FINE)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1466442485 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1466442485;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:28.019 -0400", hash_original_method = "A353E7BDC7FDA36E1EC9624F6104E3C2", hash_generated_method = "173BD293B6B1003C575AD10F19AA9A07")
    public boolean isErrorEnabled() {
        boolean var946003032585D8CB4DB2D0701CA899DA_460657393 = ((getLogger().isLoggable(Level.SEVERE)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_286108961 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_286108961;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:28.019 -0400", hash_original_method = "C0C75B09E38C8D039719CECFB87B9F15", hash_generated_method = "27390014CA6C2C93D5DE6D07ABDE9BE8")
    public boolean isFatalEnabled() {
        boolean var946003032585D8CB4DB2D0701CA899DA_630491357 = ((getLogger().isLoggable(Level.SEVERE)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_929970550 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_929970550;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:28.019 -0400", hash_original_method = "968DC873065A180C45D5B3688E2E9998", hash_generated_method = "E81615464E48123FF90FA0F14DE2471D")
    public boolean isInfoEnabled() {
        boolean varB4612D10E53F2B348D25A50348D93CC8_982360180 = ((getLogger().isLoggable(Level.INFO)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_731961225 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_731961225;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:28.019 -0400", hash_original_method = "336E472D067E61968C1967D8BD9529A8", hash_generated_method = "F49FD803AA12940463AB201DC4936421")
    public boolean isTraceEnabled() {
        boolean var6F2486D95809F038754E9F532584C843_148582363 = ((getLogger().isLoggable(Level.FINEST)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1705689029 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1705689029;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:28.020 -0400", hash_original_method = "48F2D19FF694A6F1CFBD6A7273C48B76", hash_generated_method = "3231A438BC1614C469CA5A5B3C50E88B")
    public boolean isWarnEnabled() {
        boolean var10D184CB0838B22D18453625D87A2ABF_1429925548 = ((getLogger().isLoggable(Level.WARNING)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_385281740 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_385281740;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:28.020 -0400", hash_original_method = "DED91A2285B6A66DFD74CDE391880914", hash_generated_method = "E67374A2D5D8FD034DD6D8B506D7CF3A")
    public void trace(Object message) {
        addTaint(message.getTaint());
        log(Level.FINEST, String.valueOf(message), null);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:28.020 -0400", hash_original_method = "CC5526DB6A3104361CDD33B14CCC4EB8", hash_generated_method = "12B979FBC381FE1707147FB2FC8A8A46")
    public void trace(Object message, Throwable exception) {
        addTaint(exception.getTaint());
        addTaint(message.getTaint());
        log(Level.FINEST, String.valueOf(message), exception);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:28.020 -0400", hash_original_method = "C2F32BB12488093B2694DF46B22F28A8", hash_generated_method = "6F2F2799FCAC7751E5AE7215CF82E8E8")
    public void warn(Object message) {
        addTaint(message.getTaint());
        log(Level.WARNING, String.valueOf(message), null);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:28.020 -0400", hash_original_method = "57044B9D87A0326EE4B43E6606266C00", hash_generated_method = "23CB3720803E40EEB75C906809D41D6C")
    public void warn(Object message, Throwable exception) {
        addTaint(exception.getTaint());
        addTaint(message.getTaint());
        log(Level.WARNING, String.valueOf(message), exception);
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:28.020 -0400", hash_original_field = "9DD23A7A98CF15847583A8E9BE6B1953", hash_generated_field = "B6015FBC4023476FF3F25CFD133F1252")

    protected static final Level dummyLevel = Level.FINE;
}

