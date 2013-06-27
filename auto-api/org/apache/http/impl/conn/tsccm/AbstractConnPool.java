package org.apache.http.impl.conn.tsccm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.conn.IdleConnectionHandler;

public abstract class AbstractConnPool implements RefQueueHandler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.877 -0400", hash_original_field = "0B7469F2850D918A96D1C36E99B23F5C", hash_generated_field = "4E4E630304492253CB8147CAE1C7D2A5")

    private Log log = LogFactory.getLog(getClass());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.877 -0400", hash_original_field = "BB45480D134359D22C0418B5C7FB5E3B", hash_generated_field = "89BB43C794864E61314387B43B6FF59C")

    protected Lock poolLock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.877 -0400", hash_original_field = "9349352E06EF5D6E72E672CBF9EA89A9", hash_generated_field = "A0FE2E9181E5A1497BEE93B62E29B3A1")

    protected Set<BasicPoolEntryRef> issuedConnections;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.877 -0400", hash_original_field = "6070A315A4FC63D44EABB4D9ABF1D7CE", hash_generated_field = "55EE522AC0C1CB0DA5968035C4BCC85D")

    protected IdleConnectionHandler idleConnHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.877 -0400", hash_original_field = "EC37B3D66CC45ECC733525D3988188FE", hash_generated_field = "329E7708843E3730009ED3B91C5F4D39")

    protected int numConnections;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.877 -0400", hash_original_field = "B82FB46AF129A517A66F7204F172DDA9", hash_generated_field = "60A7C2B675EA491A9BF5C18637CD724D")

    protected ReferenceQueue<Object> refQueue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.877 -0400", hash_original_field = "8C1110C9C69404D1963F025E378F57FC", hash_generated_field = "E5D3DE402E8B1BA965AA00AC6191EDD8")

    private RefQueueWorker refWorker;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.878 -0400", hash_original_field = "39E5F82929A2140F9EAABEA99A57C705", hash_generated_field = "F15F5E1E3CD7B6799921EE9E4A605FC3")

    protected volatile boolean isShutDown;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.878 -0400", hash_original_method = "51DB8B1C7B1E70F4AD996E9EEB946CC0", hash_generated_method = "FE17DF56C2DA39EE91F1668FD2FB6742")
    protected  AbstractConnPool() {
        issuedConnections = new HashSet<BasicPoolEntryRef>();
        idleConnHandler = new IdleConnectionHandler();
        boolean fair;
        fair = false;
        poolLock = new ReentrantLock(fair);
        // ---------- Original Method ----------
        //issuedConnections = new HashSet<BasicPoolEntryRef>();
        //idleConnHandler = new IdleConnectionHandler();
        //boolean fair = false;
        //poolLock = new ReentrantLock(fair);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.882 -0400", hash_original_method = "68FD2DF4471AB38D5F7B2F768AE2EB0E", hash_generated_method = "22401AC8E43A25F365AF92CD78D59283")
    public void enableConnectionGC() throws IllegalStateException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Connection GC already enabled.");
        } //End block
        poolLock.lock();
        try 
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Pool already in use.");
            } //End block
        } //End block
        finally 
        {
            poolLock.unlock();
        } //End block
        refQueue  = new ReferenceQueue<Object>();
        refWorker = new RefQueueWorker(refQueue, this);
        Thread t;
        t = new Thread(refWorker);
        t.setDaemon(true);
        t.setName("RefQueueWorker@" + this);
        t.start();
        // ---------- Original Method ----------
        //if (refQueue != null) {
            //throw new IllegalStateException("Connection GC already enabled.");
        //}
        //poolLock.lock();
        //try {
            //if (numConnections > 0) { 
                //throw new IllegalStateException("Pool already in use.");
            //}
        //} finally {
            //poolLock.unlock();
        //}
        //refQueue  = new ReferenceQueue<Object>();
        //refWorker = new RefQueueWorker(refQueue, this);
        //Thread t = new Thread(refWorker);
        //t.setDaemon(true);
        //t.setName("RefQueueWorker@" + this);
        //t.start();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.882 -0400", hash_original_method = "0742A6A1F2B8CF3FE44B75781825E20C", hash_generated_method = "0DE75FA8808B0013A2711FC8C8677065")
    public final BasicPoolEntry getEntry(
                HttpRoute route, 
                Object state,
                long timeout, 
                TimeUnit tunit) throws ConnectionPoolTimeoutException, InterruptedException {
        BasicPoolEntry varB4EAC82CA7396A68D541C85D26508E83_862515179 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_862515179 = requestPoolEntry(route, state).getPoolEntry(timeout, tunit);
        addTaint(route.getTaint());
        addTaint(state.getTaint());
        addTaint(timeout);
        addTaint(tunit.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_862515179.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_862515179;
        // ---------- Original Method ----------
        //return requestPoolEntry(route, state).getPoolEntry(timeout, tunit);
    }

    
    public abstract PoolEntryRequest requestPoolEntry(HttpRoute route, Object state);

    
    public abstract void freeEntry(BasicPoolEntry entry, boolean reusable, long validDuration, TimeUnit timeUnit)
        ;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.893 -0400", hash_original_method = "005D09627953355817D3D23BD1B8063B", hash_generated_method = "BBE69A4EF99A82F688B3A41A838C9C97")
    public void handleReference(Reference ref) {
        poolLock.lock();
        try 
        {
            {
                boolean lost;
                lost = issuedConnections.remove(ref);
                {
                    HttpRoute route;
                    route = ((BasicPoolEntryRef)ref).getRoute();
                    {
                        boolean varB5EA13E236059479AA556C9226E19405_1973034113 = (log.isDebugEnabled());
                        {
                            log.debug("Connection garbage collected. " + route);
                        } //End block
                    } //End collapsed parenthetic
                    handleLostEntry(route);
                } //End block
            } //End block
        } //End block
        finally 
        {
            poolLock.unlock();
        } //End block
        addTaint(ref.getTaint());
        // ---------- Original Method ----------
        //poolLock.lock();
        //try {
            //if (ref instanceof BasicPoolEntryRef) {
                //final boolean lost = issuedConnections.remove(ref);
                //if (lost) {
                    //final HttpRoute route =
                        //((BasicPoolEntryRef)ref).getRoute();
                    //if (log.isDebugEnabled()) {
                        //log.debug("Connection garbage collected. " + route);
                    //}
                    //handleLostEntry(route);
                //}
            //}
        //} finally {
            //poolLock.unlock();
        //}
    }

    
    protected abstract void handleLostEntry(HttpRoute route)
        ;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.902 -0400", hash_original_method = "B6A3F225A0D4D9B69A4C0D73B6FA8390", hash_generated_method = "CA13B903E92F9B1DADF8BA0FB1859811")
    public void closeIdleConnections(long idletime, TimeUnit tunit) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Time unit must not be null.");
        } //End block
        poolLock.lock();
        try 
        {
            idleConnHandler.closeIdleConnections(tunit.toMillis(idletime));
        } //End block
        finally 
        {
            poolLock.unlock();
        } //End block
        addTaint(idletime);
        addTaint(tunit.getTaint());
        // ---------- Original Method ----------
        //if (tunit == null) {
            //throw new IllegalArgumentException("Time unit must not be null.");
        //}
        //poolLock.lock();
        //try {
            //idleConnHandler.closeIdleConnections(tunit.toMillis(idletime));
        //} finally {
            //poolLock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.903 -0400", hash_original_method = "9DA7FEECE19DD407DF46C6AFBD499B72", hash_generated_method = "F7BA16EF71C26C6BD53A5B22944401AE")
    public void closeExpiredConnections() {
        poolLock.lock();
        try 
        {
            idleConnHandler.closeExpiredConnections();
        } //End block
        finally 
        {
            poolLock.unlock();
        } //End block
        // ---------- Original Method ----------
        //poolLock.lock();
        //try {
            //idleConnHandler.closeExpiredConnections();
        //} finally {
            //poolLock.unlock();
        //}
    }

    
    public abstract void deleteClosedConnections()
        ;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.904 -0400", hash_original_method = "74B1E1F35A0ABEB335D073A37540DF82", hash_generated_method = "9E6D67CE87901CEFC8F7D7EC13994543")
    public void shutdown() {
        poolLock.lock();
        try 
        {
            refWorker.shutdown();
            Iterator<BasicPoolEntryRef> iter;
            iter = issuedConnections.iterator();
            {
                boolean var8492AE2C695A56B730381A28B8BA3F6D_456987440 = (iter.hasNext());
                {
                    BasicPoolEntryRef per;
                    per = iter.next();
                    iter.remove();
                    BasicPoolEntry entry;
                    entry = per.get();
                    {
                        closeConnection(entry.getConnection());
                    } //End block
                } //End block
            } //End collapsed parenthetic
            idleConnHandler.removeAll();
            isShutDown = true;
        } //End block
        finally 
        {
            poolLock.unlock();
        } //End block
        // ---------- Original Method ----------
        //poolLock.lock();
        //try {
            //if (isShutDown)
                //return;
            //if (refWorker != null)
                //refWorker.shutdown();
            //Iterator<BasicPoolEntryRef> iter = issuedConnections.iterator();
            //while (iter.hasNext()) {
                //BasicPoolEntryRef per = iter.next();
                //iter.remove();
                //BasicPoolEntry entry = per.get();
                //if (entry != null) {
                    //closeConnection(entry.getConnection());
                //}
            //}
            //idleConnHandler.removeAll();
            //isShutDown = true;
        //} finally {
            //poolLock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.904 -0400", hash_original_method = "88CD04F545A262F2432C3D0F1CF09056", hash_generated_method = "742B11B2DF2FA92D4ED6901A6D6E4B49")
    protected void closeConnection(final OperatedClientConnection conn) {
        {
            try 
            {
                conn.close();
            } //End block
            catch (IOException ex)
            {
                log.debug("I/O error closing connection", ex);
            } //End block
        } //End block
        addTaint(conn.getTaint());
        // ---------- Original Method ----------
        //if (conn != null) {
            //try {
                //conn.close();
            //} catch (IOException ex) {
                //log.debug("I/O error closing connection", ex);
            //}
        //}
    }

    
}

