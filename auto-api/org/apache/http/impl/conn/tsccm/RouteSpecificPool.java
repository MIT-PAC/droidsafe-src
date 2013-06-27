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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.093 -0400", hash_original_field = "0B7469F2850D918A96D1C36E99B23F5C", hash_generated_field = "4E4E630304492253CB8147CAE1C7D2A5")

    private Log log = LogFactory.getLog(getClass());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.093 -0400", hash_original_field = "9C46408A3BC655C68505C57A11D6C4EE", hash_generated_field = "082455967E4D3C7BAE7FAA337B8F6279")

    protected HttpRoute route;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.093 -0400", hash_original_field = "022A4C15823CE7278C9858329BFF2442", hash_generated_field = "B16B544ABBD3A4529A473E69C2437062")

    protected int maxEntries;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.093 -0400", hash_original_field = "7D71202D90DCC488424DBCB3DB4D3CED", hash_generated_field = "CCBF9696EA0BD792BC0BF375C338D5EA")

    protected LinkedList<BasicPoolEntry> freeEntries;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.093 -0400", hash_original_field = "EDA389023301AC22C2ECA1E2C34DC3F8", hash_generated_field = "E267A7FAC4E8E5B414A36EEBC5A1B7B4")

    protected Queue<WaitingThread> waitingThreads;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.093 -0400", hash_original_field = "FEC1FCC4A89DEF29A9B7C6D06198C501", hash_generated_field = "E0B89688F125EDBE00AAE3D04B90A8C2")

    protected int numEntries;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.098 -0400", hash_original_method = "CD96C9BBB654EF18C372B5A0EBA556A4", hash_generated_method = "228ECBEAEACE08DBCE16C50514D60B5A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.099 -0400", hash_original_method = "A51AC1237DD43D471744BBD4E881146C", hash_generated_method = "B32A1DA77A3B8BCEEEC931B3FE8696EC")
    public final HttpRoute getRoute() {
        HttpRoute varB4EAC82CA7396A68D541C85D26508E83_135897158 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_135897158 = route;
        varB4EAC82CA7396A68D541C85D26508E83_135897158.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_135897158;
        // ---------- Original Method ----------
        //return route;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.099 -0400", hash_original_method = "3F262A29EAD0FCC787330E9B7CECC306", hash_generated_method = "936BC6768758D64B3CED97C57ED66176")
    public final int getMaxEntries() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1903555340 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1903555340;
        // ---------- Original Method ----------
        //return maxEntries;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.099 -0400", hash_original_method = "039A6CD61F0359B07E2C6E71E77BA3EE", hash_generated_method = "EA6359B44F2F9E74199364F2AB95F26E")
    public boolean isUnused() {
        boolean var4F862F236C6B94449E929BC72D5EA775_1206811693 = ((numEntries < 1) && waitingThreads.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_134896491 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_134896491;
        // ---------- Original Method ----------
        //return (numEntries < 1) && waitingThreads.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.105 -0400", hash_original_method = "177416E45C86DBFDF7EC5AE9EA15CB02", hash_generated_method = "DA823F5A743C463D3AE3D81B105DE2AF")
    public int getCapacity() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1645908658 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1645908658;
        // ---------- Original Method ----------
        //return maxEntries - numEntries;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.105 -0400", hash_original_method = "3C2F8D494E1F1F56A9CA8A3544522ED0", hash_generated_method = "9CFF59C3A57736C7570FB1DFA1CB2FF4")
    public final int getEntryCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2096594462 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2096594462;
        // ---------- Original Method ----------
        //return numEntries;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.119 -0400", hash_original_method = "7F86BE46F7391BA2A7A5B9B0529BB73E", hash_generated_method = "6102A7ABFE314AAACACCB21D4969C129")
    public BasicPoolEntry allocEntry(final Object state) {
        BasicPoolEntry varB4EAC82CA7396A68D541C85D26508E83_1463690357 = null; //Variable for return #1
        BasicPoolEntry varB4EAC82CA7396A68D541C85D26508E83_1142428443 = null; //Variable for return #2
        BasicPoolEntry varB4EAC82CA7396A68D541C85D26508E83_327731782 = null; //Variable for return #3
        {
            boolean varCA4A88A9BD0576BD2AD4C28B0F740C62_1771357960 = (!freeEntries.isEmpty());
            {
                ListIterator<BasicPoolEntry> it;
                it = freeEntries.listIterator(freeEntries.size());
                {
                    boolean varDF527FB13A755DBAA1BD15163F8FE079_576519758 = (it.hasPrevious());
                    {
                        BasicPoolEntry entry;
                        entry = it.previous();
                        {
                            boolean var20031F497AFDBC6C1305B43215967B57_1007984625 = (LangUtils.equals(state, entry.getState()));
                            {
                                it.remove();
                                varB4EAC82CA7396A68D541C85D26508E83_1463690357 = entry;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean varCA4A88A9BD0576BD2AD4C28B0F740C62_1076115801 = (!freeEntries.isEmpty());
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
                varB4EAC82CA7396A68D541C85D26508E83_1142428443 = entry;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_327731782 = null;
        addTaint(state.getTaint());
        BasicPoolEntry varA7E53CE21691AB073D9660D615818899_566174690; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_566174690 = varB4EAC82CA7396A68D541C85D26508E83_1463690357;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_566174690 = varB4EAC82CA7396A68D541C85D26508E83_1142428443;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_566174690 = varB4EAC82CA7396A68D541C85D26508E83_327731782;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_566174690.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_566174690;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.120 -0400", hash_original_method = "1F2F8066B3FF3FBE25C7998F0003547E", hash_generated_method = "BA841865DE11346FE86E27A67B93BDCC")
    public void freeEntry(BasicPoolEntry entry) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException
                ("No entry created for this pool. " + route);
        } //End block
        {
            boolean varDEA0E0B979C7A24481B66E82D079F8AE_1461720253 = (numEntries <= freeEntries.size());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.120 -0400", hash_original_method = "89E23A0834C1E349262FA5BF4999548A", hash_generated_method = "55575BCA17E58E6D2F09E437B37ED828")
    public void createdEntry(BasicPoolEntry entry) {
        {
            boolean varA8DF0D9E568BA212A33113C790095F75_326512271 = (!route.equals(entry.getPlannedRoute()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.120 -0400", hash_original_method = "77FA36706319170F1442C426C0507BB4", hash_generated_method = "B3B49AD2654A032D65365734510CC8AA")
    public boolean deleteEntry(BasicPoolEntry entry) {
        boolean found;
        found = freeEntries.remove(entry);
        addTaint(entry.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_357076882 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_357076882;
        // ---------- Original Method ----------
        //final boolean found = freeEntries.remove(entry);
        //if (found)
            //numEntries--;
        //return found;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.121 -0400", hash_original_method = "E1123D840A968B4EB04AEFB90EABFC3B", hash_generated_method = "8A9E0915338880A71A1B9A36A81EA60C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.121 -0400", hash_original_method = "5F9CEBE3D4D005B8F7D968A4703E6CB7", hash_generated_method = "7791500A3875EAF64A3A7279C593C56F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.121 -0400", hash_original_method = "C6B8ECCB9FBEF4C7E1D5D0DF0E82610C", hash_generated_method = "68CC320481917B2BABAC7BC7D9522A9B")
    public boolean hasThread() {
        boolean varCB1185E953B8DD83492CB6A85FCF2AA5_544811303 = (!this.waitingThreads.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_120164373 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_120164373;
        // ---------- Original Method ----------
        //return !this.waitingThreads.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.135 -0400", hash_original_method = "AB0F908D6786932ABD8D14E657997D12", hash_generated_method = "0A48A23EDF2F5535AC7565D02AFF32CB")
    public WaitingThread nextThread() {
        WaitingThread varB4EAC82CA7396A68D541C85D26508E83_292193472 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_292193472 = this.waitingThreads.peek();
        varB4EAC82CA7396A68D541C85D26508E83_292193472.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_292193472;
        // ---------- Original Method ----------
        //return this.waitingThreads.peek();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.136 -0400", hash_original_method = "E4B9C02A964F427588494E2D80051654", hash_generated_method = "2804D5975A58578620B7B749C41B12E6")
    public void removeThread(WaitingThread wt) {
        this.waitingThreads.remove(wt);
        addTaint(wt.getTaint());
        // ---------- Original Method ----------
        //if (wt == null)
            //return;
        //this.waitingThreads.remove(wt);
    }

    
}

