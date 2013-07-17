package org.apache.http.impl.conn.tsccm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.util.ListIterator;
import java.util.Queue;
import java.util.LinkedList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.util.LangUtils;

public class RouteSpecificPool {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.443 -0400", hash_original_field = "0B7469F2850D918A96D1C36E99B23F5C", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

    private final Log log = LogFactory.getLog(getClass());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.443 -0400", hash_original_field = "9C46408A3BC655C68505C57A11D6C4EE", hash_generated_field = "082455967E4D3C7BAE7FAA337B8F6279")

    protected HttpRoute route;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.443 -0400", hash_original_field = "022A4C15823CE7278C9858329BFF2442", hash_generated_field = "B16B544ABBD3A4529A473E69C2437062")

    protected int maxEntries;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.444 -0400", hash_original_field = "7D71202D90DCC488424DBCB3DB4D3CED", hash_generated_field = "CCBF9696EA0BD792BC0BF375C338D5EA")

    protected LinkedList<BasicPoolEntry> freeEntries;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.444 -0400", hash_original_field = "EDA389023301AC22C2ECA1E2C34DC3F8", hash_generated_field = "E267A7FAC4E8E5B414A36EEBC5A1B7B4")

    protected Queue<WaitingThread> waitingThreads;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.444 -0400", hash_original_field = "FEC1FCC4A89DEF29A9B7C6D06198C501", hash_generated_field = "E0B89688F125EDBE00AAE3D04B90A8C2")

    protected int numEntries;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.447 -0400", hash_original_method = "CD96C9BBB654EF18C372B5A0EBA556A4", hash_generated_method = "228ECBEAEACE08DBCE16C50514D60B5A")
    public  RouteSpecificPool(HttpRoute route, int maxEntries) {
        this.route = route;
        this.maxEntries = maxEntries;
        this.freeEntries = new LinkedList<BasicPoolEntry>();
        this.waitingThreads = new LinkedList<WaitingThread>();
        this.numEntries = 0;
        // ---------- Original Method ----------
        //this.route = route;
        //this.maxEntries = maxEntries;
        //this.freeEntries = new LinkedList<BasicPoolEntry>();
        //this.waitingThreads = new LinkedList<WaitingThread>();
        //this.numEntries = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.448 -0400", hash_original_method = "A51AC1237DD43D471744BBD4E881146C", hash_generated_method = "9B22CDF44C8565E7C36C17F8E8562F11")
    public final HttpRoute getRoute() {
HttpRoute var6679678B82FF79D06F753D1737D68FA6_1056331611 =         route;
        var6679678B82FF79D06F753D1737D68FA6_1056331611.addTaint(taint);
        return var6679678B82FF79D06F753D1737D68FA6_1056331611;
        // ---------- Original Method ----------
        //return route;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.449 -0400", hash_original_method = "3F262A29EAD0FCC787330E9B7CECC306", hash_generated_method = "BFF128832B75317697F9BDC407A60A6B")
    public final int getMaxEntries() {
        int var022A4C15823CE7278C9858329BFF2442_799982181 = (maxEntries);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1268734222 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1268734222;
        // ---------- Original Method ----------
        //return maxEntries;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.449 -0400", hash_original_method = "039A6CD61F0359B07E2C6E71E77BA3EE", hash_generated_method = "42CC9FED38EB249968591F9077F9F1E5")
    public boolean isUnused() {
        boolean varE4D00959D5CE7056280ED4FBD9A29A09_858405426 = ((numEntries < 1) && waitingThreads.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1490536038 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1490536038;
        // ---------- Original Method ----------
        //return (numEntries < 1) && waitingThreads.isEmpty();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.450 -0400", hash_original_method = "177416E45C86DBFDF7EC5AE9EA15CB02", hash_generated_method = "98CB5D58793AFBC8DB24985AE6F510EB")
    public int getCapacity() {
        int varF0DF104E5FB14BBB04D0FF91029B1428_1077835807 = (maxEntries - numEntries);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_463423153 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_463423153;
        // ---------- Original Method ----------
        //return maxEntries - numEntries;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.450 -0400", hash_original_method = "3C2F8D494E1F1F56A9CA8A3544522ED0", hash_generated_method = "93E553CAA17AB8965D6C94DCE45DC6E6")
    public final int getEntryCount() {
        int varFEC1FCC4A89DEF29A9B7C6D06198C501_1045429158 = (numEntries);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1901385786 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1901385786;
        // ---------- Original Method ----------
        //return numEntries;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.451 -0400", hash_original_method = "7F86BE46F7391BA2A7A5B9B0529BB73E", hash_generated_method = "E56FCD7A79DCB59B630BDFAD07DB10F1")
    public BasicPoolEntry allocEntry(final Object state) {
        addTaint(state.getTaint());
        if(!freeEntries.isEmpty())        
        {
            ListIterator<BasicPoolEntry> it = freeEntries.listIterator(freeEntries.size());
            while
(it.hasPrevious())            
            {
                BasicPoolEntry entry = it.previous();
                if(LangUtils.equals(state, entry.getState()))                
                {
                    it.remove();
BasicPoolEntry varF26DBE38545460D6F6AE1D948FF53869_428017583 =                     entry;
                    varF26DBE38545460D6F6AE1D948FF53869_428017583.addTaint(taint);
                    return varF26DBE38545460D6F6AE1D948FF53869_428017583;
                } //End block
            } //End block
        } //End block
        if(!freeEntries.isEmpty())        
        {
            BasicPoolEntry entry = freeEntries.remove();
            entry.setState(null);
            OperatedClientConnection conn = entry.getConnection();
            try 
            {
                conn.close();
            } //End block
            catch (IOException ex)
            {
                log.debug("I/O error closing connection", ex);
            } //End block
BasicPoolEntry varF26DBE38545460D6F6AE1D948FF53869_207283632 =             entry;
            varF26DBE38545460D6F6AE1D948FF53869_207283632.addTaint(taint);
            return varF26DBE38545460D6F6AE1D948FF53869_207283632;
        } //End block
BasicPoolEntry var540C13E9E156B687226421B24F2DF178_1928359719 =         null;
        var540C13E9E156B687226421B24F2DF178_1928359719.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1928359719;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.453 -0400", hash_original_method = "1F2F8066B3FF3FBE25C7998F0003547E", hash_generated_method = "3DFBC9478CC0E660D682F32ED1A9AB31")
    public void freeEntry(BasicPoolEntry entry) {
        addTaint(entry.getTaint());
        if(numEntries < 1)        
        {
            IllegalStateException var97052892074BFE397EB54388A01A3DD8_1750894986 = new IllegalStateException
                ("No entry created for this pool. " + route);
            var97052892074BFE397EB54388A01A3DD8_1750894986.addTaint(taint);
            throw var97052892074BFE397EB54388A01A3DD8_1750894986;
        } //End block
        if(numEntries <= freeEntries.size())        
        {
            IllegalStateException var63D4C75F2E14BE8C0D7F691D0982841F_1361131779 = new IllegalStateException
                ("No entry allocated from this pool. " + route);
            var63D4C75F2E14BE8C0D7F691D0982841F_1361131779.addTaint(taint);
            throw var63D4C75F2E14BE8C0D7F691D0982841F_1361131779;
        } //End block
        freeEntries.add(entry);
        // ---------- Original Method ----------
        //if (numEntries < 1) {
            //throw new IllegalStateException
                //("No entry created for this pool. " + route);
        //}
        //if (numEntries <= freeEntries.size()) {
            //throw new IllegalStateException
                //("No entry allocated from this pool. " + route);
        //}
        //freeEntries.add(entry);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.454 -0400", hash_original_method = "89E23A0834C1E349262FA5BF4999548A", hash_generated_method = "987F03D59278E6CB9C7FC0C53AB0021E")
    public void createdEntry(BasicPoolEntry entry) {
        addTaint(entry.getTaint());
        if(!route.equals(entry.getPlannedRoute()))        
        {
            IllegalArgumentException varE7CEF37D948BA0AE0E9A252BF1BBE192_465046475 = new IllegalArgumentException
                ("Entry not planned for this pool." +
                 "\npool: " + route +
                 "\nplan: " + entry.getPlannedRoute());
            varE7CEF37D948BA0AE0E9A252BF1BBE192_465046475.addTaint(taint);
            throw varE7CEF37D948BA0AE0E9A252BF1BBE192_465046475;
        } //End block
        numEntries++;
        // ---------- Original Method ----------
        //if (!route.equals(entry.getPlannedRoute())) {
            //throw new IllegalArgumentException
                //("Entry not planned for this pool." +
                 //"\npool: " + route +
                 //"\nplan: " + entry.getPlannedRoute());
        //}
        //numEntries++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.454 -0400", hash_original_method = "77FA36706319170F1442C426C0507BB4", hash_generated_method = "60DB4A3DC08E449EF44E50AC25984B24")
    public boolean deleteEntry(BasicPoolEntry entry) {
        addTaint(entry.getTaint());
        final boolean found = freeEntries.remove(entry);
        if(found)        
        numEntries--;
        boolean var6CFE61694EE1BB13AE719D47C2F80B7A_1865810416 = (found);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1826770027 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1826770027;
        // ---------- Original Method ----------
        //final boolean found = freeEntries.remove(entry);
        //if (found)
            //numEntries--;
        //return found;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.454 -0400", hash_original_method = "E1123D840A968B4EB04AEFB90EABFC3B", hash_generated_method = "42FFD9D0FF8162C89E438455F38D5E8B")
    public void dropEntry() {
        if(numEntries < 1)        
        {
            IllegalStateException var7618D01496C56614C09D99F360D75B84_209911228 = new IllegalStateException
                ("There is no entry that could be dropped.");
            var7618D01496C56614C09D99F360D75B84_209911228.addTaint(taint);
            throw var7618D01496C56614C09D99F360D75B84_209911228;
        } //End block
        numEntries--;
        // ---------- Original Method ----------
        //if (numEntries < 1) {
            //throw new IllegalStateException
                //("There is no entry that could be dropped.");
        //}
        //numEntries--;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.455 -0400", hash_original_method = "5F9CEBE3D4D005B8F7D968A4703E6CB7", hash_generated_method = "6593C41D253D707BAF2027CF7C6FB39E")
    public void queueThread(WaitingThread wt) {
        addTaint(wt.getTaint());
        if(wt == null)        
        {
            IllegalArgumentException varE7A397C11EE73262E0E7D1D782F386E2_344974402 = new IllegalArgumentException
                ("Waiting thread must not be null.");
            varE7A397C11EE73262E0E7D1D782F386E2_344974402.addTaint(taint);
            throw varE7A397C11EE73262E0E7D1D782F386E2_344974402;
        } //End block
        this.waitingThreads.add(wt);
        // ---------- Original Method ----------
        //if (wt == null) {
            //throw new IllegalArgumentException
                //("Waiting thread must not be null.");
        //}
        //this.waitingThreads.add(wt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.455 -0400", hash_original_method = "C6B8ECCB9FBEF4C7E1D5D0DF0E82610C", hash_generated_method = "AF714CF4BFBC34FC7A35A323AFC8758C")
    public boolean hasThread() {
        boolean var1320EBDABB6286E60BD44B1DF87EF187_1496859035 = (!this.waitingThreads.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_417405003 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_417405003;
        // ---------- Original Method ----------
        //return !this.waitingThreads.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.456 -0400", hash_original_method = "AB0F908D6786932ABD8D14E657997D12", hash_generated_method = "E183D3CCC4B5CF3465B68EA087AEC510")
    public WaitingThread nextThread() {
WaitingThread varBA6E3F9522C05D3B4902E46DC13137EB_862875085 =         this.waitingThreads.peek();
        varBA6E3F9522C05D3B4902E46DC13137EB_862875085.addTaint(taint);
        return varBA6E3F9522C05D3B4902E46DC13137EB_862875085;
        // ---------- Original Method ----------
        //return this.waitingThreads.peek();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.456 -0400", hash_original_method = "E4B9C02A964F427588494E2D80051654", hash_generated_method = "C2BF0BD751689D1BFF99EF0576111769")
    public void removeThread(WaitingThread wt) {
        addTaint(wt.getTaint());
        if(wt == null)        
        return;
        this.waitingThreads.remove(wt);
        // ---------- Original Method ----------
        //if (wt == null)
            //return;
        //this.waitingThreads.remove(wt);
    }

    
}

