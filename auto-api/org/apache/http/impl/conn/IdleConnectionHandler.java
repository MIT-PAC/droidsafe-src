package org.apache.http.impl.conn;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpConnection;

public class IdleConnectionHandler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.491 -0400", hash_original_field = "0B7469F2850D918A96D1C36E99B23F5C", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

    private final Log log = LogFactory.getLog(getClass());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.491 -0400", hash_original_field = "11259197E9F2FD0337F26EC48EBACD5D", hash_generated_field = "2F5EF38A07EA6A9636288F530673294A")

    private Map<HttpConnection,TimeValues> connectionToTimes;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.492 -0400", hash_original_method = "3E916BA1101D3583C84AA90CF4FC67D4", hash_generated_method = "4BD14E84E6BEF8BC711F8ACA39C0C62B")
    public  IdleConnectionHandler() {
        super();
        connectionToTimes = new HashMap<HttpConnection,TimeValues>();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.492 -0400", hash_original_method = "3D4804DC68DE62BE888340914D1164A1", hash_generated_method = "16F8D4513449A41B0A8EC6DAFC207019")
    public void add(HttpConnection connection, long validDuration, TimeUnit unit) {
        Long timeAdded = Long.valueOf(System.currentTimeMillis());
        {
            boolean var983CD6AA124987301747A815A5742497_2122871601 = (log.isDebugEnabled());
            {
                log.debug("Adding connection at: " + timeAdded);
            } 
        } 
        connectionToTimes.put(connection, new TimeValues(timeAdded, validDuration, unit));
        addTaint(connection.getTaint());
        addTaint(validDuration);
        addTaint(unit.getTaint());
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.493 -0400", hash_original_method = "1D31D4C3FCFC5F71DF82BB85794AF70A", hash_generated_method = "D5E3ECDA42167006F9E41E8C4B53FDC5")
    public boolean remove(HttpConnection connection) {
        TimeValues times = connectionToTimes.remove(connection);
        {
            log.warn("Removing a connection that never existed!");
        } 
        {
            boolean var68ABEAB36C37B2208D81C31C56B2390C_2119827807 = (System.currentTimeMillis() <= times.timeExpires);
        } 
        addTaint(connection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2022080491 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2022080491;
        
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.493 -0400", hash_original_method = "7AF66332DEC016DA2AA9D0945D3022F8", hash_generated_method = "A48EFFE9E0FDB5EF17F54AE30B159084")
    public void removeAll() {
        this.connectionToTimes.clear();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.494 -0400", hash_original_method = "1B5843932F53A941705DBD73966AF816", hash_generated_method = "F47E33ED4C64D49DB4C1D694990F0938")
    public void closeIdleConnections(long idleTime) {
        long idleTimeout = System.currentTimeMillis() - idleTime;
        {
            boolean var983CD6AA124987301747A815A5742497_678823116 = (log.isDebugEnabled());
            {
                log.debug("Checking for connections, idleTimeout: "  + idleTimeout);
            } 
        } 
        Iterator<HttpConnection> connectionIter = connectionToTimes.keySet().iterator();
        {
            boolean var7D1D4944B83B2A9376B72A2F65A81964_751422987 = (connectionIter.hasNext());
            {
                HttpConnection conn = connectionIter.next();
                TimeValues times = connectionToTimes.get(conn);
                Long connectionTime = times.timeAdded;
                {
                    boolean varFCAEEA5D7EBBB7E6CDA1ECDBD815823B_992629821 = (connectionTime.longValue() <= idleTimeout);
                    {
                        {
                            boolean varF1685CB26B0999B3A47E854C01691B8F_893776321 = (log.isDebugEnabled());
                            {
                                log.debug("Closing connection, connection time: "  + connectionTime);
                            } 
                        } 
                        connectionIter.remove();
                        try 
                        {
                            conn.close();
                        } 
                        catch (IOException ex)
                        {
                            log.debug("I/O error closing connection", ex);
                        } 
                    } 
                } 
            } 
        } 
        addTaint(idleTime);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.495 -0400", hash_original_method = "1F224929907ADC4A2755470D6C0EBC61", hash_generated_method = "0A0F7A7CF7C3A9A4435CF2952A85338B")
    public void closeExpiredConnections() {
        long now = System.currentTimeMillis();
        {
            boolean var983CD6AA124987301747A815A5742497_1592879860 = (log.isDebugEnabled());
            {
                log.debug("Checking for expired connections, now: "  + now);
            } 
        } 
        Iterator<HttpConnection> connectionIter = connectionToTimes.keySet().iterator();
        {
            boolean var7D1D4944B83B2A9376B72A2F65A81964_1810233621 = (connectionIter.hasNext());
            {
                HttpConnection conn = connectionIter.next();
                TimeValues times = connectionToTimes.get(conn);
                {
                    {
                        boolean varB5EA13E236059479AA556C9226E19405_128400542 = (log.isDebugEnabled());
                        {
                            log.debug("Closing connection, expired @: "  + times.timeExpires);
                        } 
                    } 
                    connectionIter.remove();
                    try 
                    {
                        conn.close();
                    } 
                    catch (IOException ex)
                    {
                        log.debug("I/O error closing connection", ex);
                    } 
                } 
            } 
        } 
        
        
    }

    
    private static class TimeValues {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.495 -0400", hash_original_field = "C5898A47DA208DD0939DA04CEF31DFE3", hash_generated_field = "40BAAF0C7A31F5A05875046903303AFA")

        private long timeAdded;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.495 -0400", hash_original_field = "77B76A602562FEAEE08C9740658298D5", hash_generated_field = "AB9F405E92086F3B1BDE350A1E939FA3")

        private long timeExpires;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.496 -0400", hash_original_method = "3DD4099178F08AFF793AFE03575649DF", hash_generated_method = "6069AA5BA7FAAA825555B6B23E0EA559")
          TimeValues(long now, long validDuration, TimeUnit validUnit) {
            this.timeAdded = now;
            {
                this.timeExpires = now + validUnit.toMillis(validDuration);
            } 
            {
                this.timeExpires = Long.MAX_VALUE;
            } 
            
            
            
                
            
                
            
        }

        
    }


    
}

