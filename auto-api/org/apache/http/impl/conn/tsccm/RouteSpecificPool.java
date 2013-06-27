package org.apache.http.impl.conn.tsccm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.979 -0400", hash_original_field = "0B7469F2850D918A96D1C36E99B23F5C", hash_generated_field = "4E4E630304492253CB8147CAE1C7D2A5")

    private Log log = LogFactory.getLog(getClass());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.979 -0400", hash_original_field = "9C46408A3BC655C68505C57A11D6C4EE", hash_generated_field = "082455967E4D3C7BAE7FAA337B8F6279")

    protected HttpRoute route;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.979 -0400", hash_original_field = "022A4C15823CE7278C9858329BFF2442", hash_generated_field = "B16B544ABBD3A4529A473E69C2437062")

    protected int maxEntries;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.979 -0400", hash_original_field = "7D71202D90DCC488424DBCB3DB4D3CED", hash_generated_field = "CCBF9696EA0BD792BC0BF375C338D5EA")

    protected LinkedList<BasicPoolEntry> freeEntries;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.979 -0400", hash_original_field = "EDA389023301AC22C2ECA1E2C34DC3F8", hash_generated_field = "E267A7FAC4E8E5B414A36EEBC5A1B7B4")

    protected Queue<WaitingThread> waitingThreads;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.979 -0400", hash_original_field = "FEC1FCC4A89DEF29A9B7C6D06198C501", hash_generated_field = "E0B89688F125EDBE00AAE3D04B90A8C2")

    protected int numEntries;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.980 -0400", hash_original_method = "CD96C9BBB654EF18C372B5A0EBA556A4", hash_generated_method = "228ECBEAEACE08DBCE16C50514D60B5A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.980 -0400", hash_original_method = "A51AC1237DD43D471744BBD4E881146C", hash_generated_method = "A4C86ACD9761ABB5D2D1939AD3A6F832")
    public final HttpRoute getRoute() {
        HttpRoute varB4EAC82CA7396A68D541C85D26508E83_1790202641 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1790202641 = route;
        varB4EAC82CA7396A68D541C85D26508E83_1790202641.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1790202641;
        // ---------- Original Method ----------
        //return route;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.990 -0400", hash_original_method = "3F262A29EAD0FCC787330E9B7CECC306", hash_generated_method = "E19F50B456ADAD47B131CEA7719FAA3E")
    public final int getMaxEntries() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_391453964 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_391453964;
        // ---------- Original Method ----------
        //return maxEntries;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.991 -0400", hash_original_method = "039A6CD61F0359B07E2C6E71E77BA3EE", hash_generated_method = "DEC97B93FD5BDC018AB98976B49FDA42")
    public boolean isUnused() {
        boolean var4F862F236C6B94449E929BC72D5EA775_130538743 = ((numEntries < 1) && waitingThreads.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1967940420 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1967940420;
        // ---------- Original Method ----------
        //return (numEntries < 1) && waitingThreads.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.991 -0400", hash_original_method = "177416E45C86DBFDF7EC5AE9EA15CB02", hash_generated_method = "3A67971F1D3F4DB9D88C7AF8C554012C")
    public int getCapacity() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1568228346 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1568228346;
        // ---------- Original Method ----------
        //return maxEntries - numEntries;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.991 -0400", hash_original_method = "3C2F8D494E1F1F56A9CA8A3544522ED0", hash_generated_method = "8FDF0CA84FF03CEF8FA6931CB2513A91")
    public final int getEntryCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_663240521 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_663240521;
        // ---------- Original Method ----------
        //return numEntries;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.992 -0400", hash_original_method = "7F86BE46F7391BA2A7A5B9B0529BB73E", hash_generated_method = "D3948BEA10E012C259C2F7AD57F6DB0D")
    public BasicPoolEntry allocEntry(final Object state) {
        BasicPoolEntry varB4EAC82CA7396A68D541C85D26508E83_21869437 = null; //Variable for return #1
        BasicPoolEntry varB4EAC82CA7396A68D541C85D26508E83_369971167 = null; //Variable for return #2
        BasicPoolEntry varB4EAC82CA7396A68D541C85D26508E83_1309117783 = null; //Variable for return #3
        {
            boolean varCA4A88A9BD0576BD2AD4C28B0F740C62_1474356865 = (!freeEntries.isEmpty());
            {
                ListIterator<BasicPoolEntry> it;
                it = freeEntries.listIterator(freeEntries.size());
                {
                    boolean varDF527FB13A755DBAA1BD15163F8FE079_877543839 = (it.hasPrevious());
                    {
                        BasicPoolEntry entry;
                        entry = it.previous();
                        {
                            boolean var20031F497AFDBC6C1305B43215967B57_1266147221 = (LangUtils.equals(state, entry.getState()));
                            {
                                it.remove();
                                varB4EAC82CA7396A68D541C85D26508E83_21869437 = entry;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean varCA4A88A9BD0576BD2AD4C28B0F740C62_1615514656 = (!freeEntries.isEmpty());
            {
                BasicPoolEntry entry;
                entry = freeEntries.remove();
                entry.setState(null);
                OperatedClientConnection conn;
                conn = entry.getConnection();
                try 
                {
                    conn.close();
                } //End block
                catch (IOException ex)
                {
                    log.debug("I/O error closing connection", ex);
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_369971167 = entry;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1309117783 = null;
        addTaint(state.getTaint());
        BasicPoolEntry varA7E53CE21691AB073D9660D615818899_542940190; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_542940190 = varB4EAC82CA7396A68D541C85D26508E83_21869437;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_542940190 = varB4EAC82CA7396A68D541C85D26508E83_369971167;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_542940190 = varB4EAC82CA7396A68D541C85D26508E83_1309117783;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_542940190.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_542940190;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.040 -0400", hash_original_method = "1F2F8066B3FF3FBE25C7998F0003547E", hash_generated_method = "8F2C1368FA684E52903C8F85BBD2693D")
    public void freeEntry(BasicPoolEntry entry) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException
                ("No entry created for this pool. " + route);
        } //End block
        {
            boolean varDEA0E0B979C7A24481B66E82D079F8AE_764572836 = (numEntries <= freeEntries.size());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException
                ("No entry allocated from this pool. " + route);
            } //End block
        } //End collapsed parenthetic
        freeEntries.add(entry);
        addTaint(entry.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.040 -0400", hash_original_method = "89E23A0834C1E349262FA5BF4999548A", hash_generated_method = "41743B65C3A0D87BB1B97E3374935DFA")
    public void createdEntry(BasicPoolEntry entry) {
        {
            boolean varA8DF0D9E568BA212A33113C790095F75_2080749779 = (!route.equals(entry.getPlannedRoute()));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Entry not planned for this pool." +
                 "\npool: " + route +
                 "\nplan: " + entry.getPlannedRoute());
            } //End block
        } //End collapsed parenthetic
        addTaint(entry.getTaint());
        // ---------- Original Method ----------
        //if (!route.equals(entry.getPlannedRoute())) {
            //throw new IllegalArgumentException
                //("Entry not planned for this pool." +
                 //"\npool: " + route +
                 //"\nplan: " + entry.getPlannedRoute());
        //}
        //numEntries++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.040 -0400", hash_original_method = "77FA36706319170F1442C426C0507BB4", hash_generated_method = "1B98C6C8D118D7AF9EE47CA953BB94D1")
    public boolean deleteEntry(BasicPoolEntry entry) {
        boolean found;
        found = freeEntries.remove(entry);
        addTaint(entry.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1126583110 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1126583110;
        // ---------- Original Method ----------
        //final boolean found = freeEntries.remove(entry);
        //if (found)
            //numEntries--;
        //return found;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.041 -0400", hash_original_method = "E1123D840A968B4EB04AEFB90EABFC3B", hash_generated_method = "8A9E0915338880A71A1B9A36A81EA60C")
    public void dropEntry() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException
                ("There is no entry that could be dropped.");
        } //End block
        // ---------- Original Method ----------
        //if (numEntries < 1) {
            //throw new IllegalStateException
                //("There is no entry that could be dropped.");
        //}
        //numEntries--;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.041 -0400", hash_original_method = "5F9CEBE3D4D005B8F7D968A4703E6CB7", hash_generated_method = "7791500A3875EAF64A3A7279C593C56F")
    public void queueThread(WaitingThread wt) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Waiting thread must not be null.");
        } //End block
        this.waitingThreads.add(wt);
        addTaint(wt.getTaint());
        // ---------- Original Method ----------
        //if (wt == null) {
            //throw new IllegalArgumentException
                //("Waiting thread must not be null.");
        //}
        //this.waitingThreads.add(wt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.041 -0400", hash_original_method = "C6B8ECCB9FBEF4C7E1D5D0DF0E82610C", hash_generated_method = "FE15B1DFC4CE753AD1B7CC121D95B498")
    public boolean hasThread() {
        boolean varCB1185E953B8DD83492CB6A85FCF2AA5_239786627 = (!this.waitingThreads.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1299306898 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1299306898;
        // ---------- Original Method ----------
        //return !this.waitingThreads.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.042 -0400", hash_original_method = "AB0F908D6786932ABD8D14E657997D12", hash_generated_method = "C07CBF1E350C7E572908555DBFA36D2B")
    public WaitingThread nextThread() {
        WaitingThread varB4EAC82CA7396A68D541C85D26508E83_790243635 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_790243635 = this.waitingThreads.peek();
        varB4EAC82CA7396A68D541C85D26508E83_790243635.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_790243635;
        // ---------- Original Method ----------
        //return this.waitingThreads.peek();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.042 -0400", hash_original_method = "E4B9C02A964F427588494E2D80051654", hash_generated_method = "2804D5975A58578620B7B749C41B12E6")
    public void removeThread(WaitingThread wt) {
        this.waitingThreads.remove(wt);
        addTaint(wt.getTaint());
        // ---------- Original Method ----------
        //if (wt == null)
            //return;
        //this.waitingThreads.remove(wt);
    }

    
}

