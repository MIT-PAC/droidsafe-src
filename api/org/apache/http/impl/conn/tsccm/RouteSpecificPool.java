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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.147 -0400", hash_original_field = "0B7469F2850D918A96D1C36E99B23F5C", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

    private final Log log = LogFactory.getLog(getClass());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.147 -0400", hash_original_field = "9C46408A3BC655C68505C57A11D6C4EE", hash_generated_field = "082455967E4D3C7BAE7FAA337B8F6279")

    protected HttpRoute route;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.147 -0400", hash_original_field = "022A4C15823CE7278C9858329BFF2442", hash_generated_field = "B16B544ABBD3A4529A473E69C2437062")

    protected int maxEntries;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.147 -0400", hash_original_field = "7D71202D90DCC488424DBCB3DB4D3CED", hash_generated_field = "CCBF9696EA0BD792BC0BF375C338D5EA")

    protected LinkedList<BasicPoolEntry> freeEntries;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.147 -0400", hash_original_field = "EDA389023301AC22C2ECA1E2C34DC3F8", hash_generated_field = "E267A7FAC4E8E5B414A36EEBC5A1B7B4")

    protected Queue<WaitingThread> waitingThreads;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.148 -0400", hash_original_field = "FEC1FCC4A89DEF29A9B7C6D06198C501", hash_generated_field = "E0B89688F125EDBE00AAE3D04B90A8C2")

    protected int numEntries;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.149 -0400", hash_original_method = "CD96C9BBB654EF18C372B5A0EBA556A4", hash_generated_method = "228ECBEAEACE08DBCE16C50514D60B5A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.149 -0400", hash_original_method = "A51AC1237DD43D471744BBD4E881146C", hash_generated_method = "435EE333E08FE8E5D51578B6DEE8B6FA")
    public final HttpRoute getRoute() {
HttpRoute var6679678B82FF79D06F753D1737D68FA6_955473407 =         route;
        var6679678B82FF79D06F753D1737D68FA6_955473407.addTaint(taint);
        return var6679678B82FF79D06F753D1737D68FA6_955473407;
        // ---------- Original Method ----------
        //return route;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.149 -0400", hash_original_method = "3F262A29EAD0FCC787330E9B7CECC306", hash_generated_method = "391AC5878058991878A469F1880FD561")
    public final int getMaxEntries() {
        int var022A4C15823CE7278C9858329BFF2442_1190166276 = (maxEntries);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1177056957 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1177056957;
        // ---------- Original Method ----------
        //return maxEntries;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.150 -0400", hash_original_method = "039A6CD61F0359B07E2C6E71E77BA3EE", hash_generated_method = "B82F5696F44FC5D7B6FF326F444FCD2B")
    public boolean isUnused() {
        boolean varE4D00959D5CE7056280ED4FBD9A29A09_457004068 = ((numEntries < 1) && waitingThreads.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1196741276 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1196741276;
        // ---------- Original Method ----------
        //return (numEntries < 1) && waitingThreads.isEmpty();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.150 -0400", hash_original_method = "177416E45C86DBFDF7EC5AE9EA15CB02", hash_generated_method = "CCE2EDAD615404468DAD47D799B6F726")
    public int getCapacity() {
        int varF0DF104E5FB14BBB04D0FF91029B1428_1533721888 = (maxEntries - numEntries);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2010277496 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2010277496;
        // ---------- Original Method ----------
        //return maxEntries - numEntries;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.150 -0400", hash_original_method = "3C2F8D494E1F1F56A9CA8A3544522ED0", hash_generated_method = "0B72E687422BAE62BD98B1F7BB589CE0")
    public final int getEntryCount() {
        int varFEC1FCC4A89DEF29A9B7C6D06198C501_809982832 = (numEntries);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_899157961 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_899157961;
        // ---------- Original Method ----------
        //return numEntries;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.150 -0400", hash_original_method = "7F86BE46F7391BA2A7A5B9B0529BB73E", hash_generated_method = "A6790FC832EC32B4CD2212F65D6336AF")
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
BasicPoolEntry varF26DBE38545460D6F6AE1D948FF53869_427526505 =                     entry;
                    varF26DBE38545460D6F6AE1D948FF53869_427526505.addTaint(taint);
                    return varF26DBE38545460D6F6AE1D948FF53869_427526505;
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
BasicPoolEntry varF26DBE38545460D6F6AE1D948FF53869_1291616885 =             entry;
            varF26DBE38545460D6F6AE1D948FF53869_1291616885.addTaint(taint);
            return varF26DBE38545460D6F6AE1D948FF53869_1291616885;
        } //End block
BasicPoolEntry var540C13E9E156B687226421B24F2DF178_112265363 =         null;
        var540C13E9E156B687226421B24F2DF178_112265363.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_112265363;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.151 -0400", hash_original_method = "1F2F8066B3FF3FBE25C7998F0003547E", hash_generated_method = "2152A6380A7BD9F02B431DE0A7F2C534")
    public void freeEntry(BasicPoolEntry entry) {
        addTaint(entry.getTaint());
    if(numEntries < 1)        
        {
            IllegalStateException var97052892074BFE397EB54388A01A3DD8_2008844125 = new IllegalStateException
                ("No entry created for this pool. " + route);
            var97052892074BFE397EB54388A01A3DD8_2008844125.addTaint(taint);
            throw var97052892074BFE397EB54388A01A3DD8_2008844125;
        } //End block
    if(numEntries <= freeEntries.size())        
        {
            IllegalStateException var63D4C75F2E14BE8C0D7F691D0982841F_1545760725 = new IllegalStateException
                ("No entry allocated from this pool. " + route);
            var63D4C75F2E14BE8C0D7F691D0982841F_1545760725.addTaint(taint);
            throw var63D4C75F2E14BE8C0D7F691D0982841F_1545760725;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.151 -0400", hash_original_method = "89E23A0834C1E349262FA5BF4999548A", hash_generated_method = "C59F6980A96EF138BE9247FF6A8769AF")
    public void createdEntry(BasicPoolEntry entry) {
        addTaint(entry.getTaint());
    if(!route.equals(entry.getPlannedRoute()))        
        {
            IllegalArgumentException varE7CEF37D948BA0AE0E9A252BF1BBE192_783259913 = new IllegalArgumentException
                ("Entry not planned for this pool." +
                 "\npool: " + route +
                 "\nplan: " + entry.getPlannedRoute());
            varE7CEF37D948BA0AE0E9A252BF1BBE192_783259913.addTaint(taint);
            throw varE7CEF37D948BA0AE0E9A252BF1BBE192_783259913;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.152 -0400", hash_original_method = "77FA36706319170F1442C426C0507BB4", hash_generated_method = "6615E3F93AC34B1C0AB2C76BCF07536F")
    public boolean deleteEntry(BasicPoolEntry entry) {
        addTaint(entry.getTaint());
        final boolean found = freeEntries.remove(entry);
    if(found)        
        numEntries--;
        boolean var6CFE61694EE1BB13AE719D47C2F80B7A_1529983707 = (found);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1215182221 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1215182221;
        // ---------- Original Method ----------
        //final boolean found = freeEntries.remove(entry);
        //if (found)
            //numEntries--;
        //return found;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.152 -0400", hash_original_method = "E1123D840A968B4EB04AEFB90EABFC3B", hash_generated_method = "FDED45370F506F05C64020C450E8EF5B")
    public void dropEntry() {
    if(numEntries < 1)        
        {
            IllegalStateException var7618D01496C56614C09D99F360D75B84_1501348756 = new IllegalStateException
                ("There is no entry that could be dropped.");
            var7618D01496C56614C09D99F360D75B84_1501348756.addTaint(taint);
            throw var7618D01496C56614C09D99F360D75B84_1501348756;
        } //End block
        numEntries--;
        // ---------- Original Method ----------
        //if (numEntries < 1) {
            //throw new IllegalStateException
                //("There is no entry that could be dropped.");
        //}
        //numEntries--;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.152 -0400", hash_original_method = "5F9CEBE3D4D005B8F7D968A4703E6CB7", hash_generated_method = "0853313A97DEBF5E0E45B94CA2DEABAA")
    public void queueThread(WaitingThread wt) {
        addTaint(wt.getTaint());
    if(wt == null)        
        {
            IllegalArgumentException varE7A397C11EE73262E0E7D1D782F386E2_718199496 = new IllegalArgumentException
                ("Waiting thread must not be null.");
            varE7A397C11EE73262E0E7D1D782F386E2_718199496.addTaint(taint);
            throw varE7A397C11EE73262E0E7D1D782F386E2_718199496;
        } //End block
        this.waitingThreads.add(wt);
        // ---------- Original Method ----------
        //if (wt == null) {
            //throw new IllegalArgumentException
                //("Waiting thread must not be null.");
        //}
        //this.waitingThreads.add(wt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.153 -0400", hash_original_method = "C6B8ECCB9FBEF4C7E1D5D0DF0E82610C", hash_generated_method = "78C6895ED16394CEE9B51924D67A5779")
    public boolean hasThread() {
        boolean var1320EBDABB6286E60BD44B1DF87EF187_1743901251 = (!this.waitingThreads.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1769894459 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1769894459;
        // ---------- Original Method ----------
        //return !this.waitingThreads.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.153 -0400", hash_original_method = "AB0F908D6786932ABD8D14E657997D12", hash_generated_method = "EE1F33B5BA07E1A9AD251008F4D0530C")
    public WaitingThread nextThread() {
WaitingThread varBA6E3F9522C05D3B4902E46DC13137EB_1664517790 =         this.waitingThreads.peek();
        varBA6E3F9522C05D3B4902E46DC13137EB_1664517790.addTaint(taint);
        return varBA6E3F9522C05D3B4902E46DC13137EB_1664517790;
        // ---------- Original Method ----------
        //return this.waitingThreads.peek();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.153 -0400", hash_original_method = "E4B9C02A964F427588494E2D80051654", hash_generated_method = "C2BF0BD751689D1BFF99EF0576111769")
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

