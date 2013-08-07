package org.apache.http.impl.conn;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpConnection;




public class IdleConnectionHandler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.127 -0400", hash_original_field = "0B7469F2850D918A96D1C36E99B23F5C", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

    private final Log log = LogFactory.getLog(getClass());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.127 -0400", hash_original_field = "11259197E9F2FD0337F26EC48EBACD5D", hash_generated_field = "2F5EF38A07EA6A9636288F530673294A")

    private Map<HttpConnection,TimeValues> connectionToTimes;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.128 -0400", hash_original_method = "3E916BA1101D3583C84AA90CF4FC67D4", hash_generated_method = "4BD14E84E6BEF8BC711F8ACA39C0C62B")
    public  IdleConnectionHandler() {
        super();
        connectionToTimes = new HashMap<HttpConnection,TimeValues>();
        // ---------- Original Method ----------
        //connectionToTimes = new HashMap<HttpConnection,TimeValues>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.128 -0400", hash_original_method = "3D4804DC68DE62BE888340914D1164A1", hash_generated_method = "33F4304779B880E25E2A8DE92713FE51")
    public void add(HttpConnection connection, long validDuration, TimeUnit unit) {
        addTaint(unit.getTaint());
        addTaint(validDuration);
        addTaint(connection.getTaint());
        Long timeAdded = Long.valueOf(System.currentTimeMillis());
        if(log.isDebugEnabled())        
        {
            log.debug("Adding connection at: " + timeAdded);
        } //End block
        connectionToTimes.put(connection, new TimeValues(timeAdded, validDuration, unit));
        // ---------- Original Method ----------
        //Long timeAdded = Long.valueOf(System.currentTimeMillis());
        //if (log.isDebugEnabled()) {
            //log.debug("Adding connection at: " + timeAdded);
        //}
        //connectionToTimes.put(connection, new TimeValues(timeAdded, validDuration, unit));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.129 -0400", hash_original_method = "1D31D4C3FCFC5F71DF82BB85794AF70A", hash_generated_method = "1E7FAA6D0274B1771F94A091210E3FB2")
    public boolean remove(HttpConnection connection) {
        addTaint(connection.getTaint());
        TimeValues times = connectionToTimes.remove(connection);
        if(times == null)        
        {
            log.warn("Removing a connection that never existed!");
            boolean varB326B5062B2F0E69046810717534CB09_1452341321 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2049247890 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2049247890;
        } //End block
        else
        {
            boolean var5975939083C962F496F7E1A3835149AE_1800418712 = (System.currentTimeMillis() <= times.timeExpires);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1823183097 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1823183097;
        } //End block
        // ---------- Original Method ----------
        //TimeValues times = connectionToTimes.remove(connection);
        //if(times == null) {
            //log.warn("Removing a connection that never existed!");
            //return true;
        //} else {
            //return System.currentTimeMillis() <= times.timeExpires;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.129 -0400", hash_original_method = "7AF66332DEC016DA2AA9D0945D3022F8", hash_generated_method = "A48EFFE9E0FDB5EF17F54AE30B159084")
    public void removeAll() {
        this.connectionToTimes.clear();
        // ---------- Original Method ----------
        //this.connectionToTimes.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.130 -0400", hash_original_method = "1B5843932F53A941705DBD73966AF816", hash_generated_method = "45A57EBB5ED53A9ACCA9E40CE0C9782F")
    public void closeIdleConnections(long idleTime) {
        addTaint(idleTime);
        long idleTimeout = System.currentTimeMillis() - idleTime;
        if(log.isDebugEnabled())        
        {
            log.debug("Checking for connections, idleTimeout: "  + idleTimeout);
        } //End block
        Iterator<HttpConnection> connectionIter = connectionToTimes.keySet().iterator();
        while
(connectionIter.hasNext())        
        {
            HttpConnection conn = connectionIter.next();
            TimeValues times = connectionToTimes.get(conn);
            Long connectionTime = times.timeAdded;
            if(connectionTime.longValue() <= idleTimeout)            
            {
                if(log.isDebugEnabled())                
                {
                    log.debug("Closing connection, connection time: "  + connectionTime);
                } //End block
                connectionIter.remove();
                try 
                {
                    conn.close();
                } //End block
                catch (IOException ex)
                {
                    log.debug("I/O error closing connection", ex);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.131 -0400", hash_original_method = "1F224929907ADC4A2755470D6C0EBC61", hash_generated_method = "19860B93064298EF649E13E3CFFAF416")
    public void closeExpiredConnections() {
        long now = System.currentTimeMillis();
        if(log.isDebugEnabled())        
        {
            log.debug("Checking for expired connections, now: "  + now);
        } //End block
        Iterator<HttpConnection> connectionIter = connectionToTimes.keySet().iterator();
        while
(connectionIter.hasNext())        
        {
            HttpConnection conn = connectionIter.next();
            TimeValues times = connectionToTimes.get(conn);
            if(times.timeExpires <= now)            
            {
                if(log.isDebugEnabled())                
                {
                    log.debug("Closing connection, expired @: "  + times.timeExpires);
                } //End block
                connectionIter.remove();
                try 
                {
                    conn.close();
                } //End block
                catch (IOException ex)
                {
                    log.debug("I/O error closing connection", ex);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static class TimeValues {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.131 -0400", hash_original_field = "C5898A47DA208DD0939DA04CEF31DFE3", hash_generated_field = "40BAAF0C7A31F5A05875046903303AFA")

        private long timeAdded;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.131 -0400", hash_original_field = "77B76A602562FEAEE08C9740658298D5", hash_generated_field = "AB9F405E92086F3B1BDE350A1E939FA3")

        private long timeExpires;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.132 -0400", hash_original_method = "3DD4099178F08AFF793AFE03575649DF", hash_generated_method = "C3298F8E5FFB6F7EC946607E1A99D4C8")
          TimeValues(long now, long validDuration, TimeUnit validUnit) {
            this.timeAdded = now;
            if(validDuration > 0)            
            {
                this.timeExpires = now + validUnit.toMillis(validDuration);
            } //End block
            else
            {
                this.timeExpires = Long.MAX_VALUE;
            } //End block
            // ---------- Original Method ----------
            //this.timeAdded = now;
            //if(validDuration > 0) {
                //this.timeExpires = now + validUnit.toMillis(validDuration);
            //} else {
                //this.timeExpires = Long.MAX_VALUE;
            //}
        }

        
    }


    
}

