package org.apache.http.impl.conn.tsccm;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.771 -0400", hash_original_field = "0B7469F2850D918A96D1C36E99B23F5C", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

    private final Log log = LogFactory.getLog(getClass());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.772 -0400", hash_original_field = "9C46408A3BC655C68505C57A11D6C4EE", hash_generated_field = "082455967E4D3C7BAE7FAA337B8F6279")

    protected HttpRoute route;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.772 -0400", hash_original_field = "022A4C15823CE7278C9858329BFF2442", hash_generated_field = "B16B544ABBD3A4529A473E69C2437062")

    protected int maxEntries;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.772 -0400", hash_original_field = "7D71202D90DCC488424DBCB3DB4D3CED", hash_generated_field = "CCBF9696EA0BD792BC0BF375C338D5EA")

    protected LinkedList<BasicPoolEntry> freeEntries;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.772 -0400", hash_original_field = "EDA389023301AC22C2ECA1E2C34DC3F8", hash_generated_field = "E267A7FAC4E8E5B414A36EEBC5A1B7B4")

    protected Queue<WaitingThread> waitingThreads;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.772 -0400", hash_original_field = "FEC1FCC4A89DEF29A9B7C6D06198C501", hash_generated_field = "E0B89688F125EDBE00AAE3D04B90A8C2")

    protected int numEntries;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.773 -0400", hash_original_method = "CD96C9BBB654EF18C372B5A0EBA556A4", hash_generated_method = "228ECBEAEACE08DBCE16C50514D60B5A")
    public  RouteSpecificPool(HttpRoute route, int maxEntries) {
        this.route = route;
        this.maxEntries = maxEntries;
        this.freeEntries = new LinkedList<BasicPoolEntry>();
        this.waitingThreads = new LinkedList<WaitingThread>();
        this.numEntries = 0;
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.774 -0400", hash_original_method = "A51AC1237DD43D471744BBD4E881146C", hash_generated_method = "31338F92F4AF582A28E1C4406B93A121")
    public final HttpRoute getRoute() {
        HttpRoute varB4EAC82CA7396A68D541C85D26508E83_1004366105 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1004366105 = route;
        varB4EAC82CA7396A68D541C85D26508E83_1004366105.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1004366105;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.775 -0400", hash_original_method = "3F262A29EAD0FCC787330E9B7CECC306", hash_generated_method = "841C738E685149D37EC4F6013F5877B1")
    public final int getMaxEntries() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1724384994 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1724384994;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.775 -0400", hash_original_method = "039A6CD61F0359B07E2C6E71E77BA3EE", hash_generated_method = "DD78B718F6D79CA57D871C0C52660589")
    public boolean isUnused() {
        boolean var4F862F236C6B94449E929BC72D5EA775_833561767 = ((numEntries < 1) && waitingThreads.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_476289430 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_476289430;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.775 -0400", hash_original_method = "177416E45C86DBFDF7EC5AE9EA15CB02", hash_generated_method = "FA3F7C709650CA4758C4F104551E28D0")
    public int getCapacity() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_306534461 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_306534461;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.775 -0400", hash_original_method = "3C2F8D494E1F1F56A9CA8A3544522ED0", hash_generated_method = "983517F7BAD02B00C2967495DE5954B8")
    public final int getEntryCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1802480826 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1802480826;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.776 -0400", hash_original_method = "7F86BE46F7391BA2A7A5B9B0529BB73E", hash_generated_method = "A59D71598B0156F5981011613CB5548B")
    public BasicPoolEntry allocEntry(final Object state) {
        BasicPoolEntry varB4EAC82CA7396A68D541C85D26508E83_1173672380 = null; 
        BasicPoolEntry varB4EAC82CA7396A68D541C85D26508E83_2085788480 = null; 
        BasicPoolEntry varB4EAC82CA7396A68D541C85D26508E83_1454711022 = null; 
        {
            boolean varCA4A88A9BD0576BD2AD4C28B0F740C62_1835932226 = (!freeEntries.isEmpty());
            {
                ListIterator<BasicPoolEntry> it = freeEntries.listIterator(freeEntries.size());
                {
                    boolean varDF527FB13A755DBAA1BD15163F8FE079_333361838 = (it.hasPrevious());
                    {
                        BasicPoolEntry entry = it.previous();
                        {
                            boolean var20031F497AFDBC6C1305B43215967B57_432485188 = (LangUtils.equals(state, entry.getState()));
                            {
                                it.remove();
                                varB4EAC82CA7396A68D541C85D26508E83_1173672380 = entry;
                            } 
                        } 
                    } 
                } 
            } 
        } 
        {
            boolean varCA4A88A9BD0576BD2AD4C28B0F740C62_953330007 = (!freeEntries.isEmpty());
            {
                BasicPoolEntry entry = freeEntries.remove();
                entry.setState(null);
                OperatedClientConnection conn = entry.getConnection();
                try 
                {
                    conn.close();
                } 
                catch (IOException ex)
                {
                    log.debug("I/O error closing connection", ex);
                } 
                varB4EAC82CA7396A68D541C85D26508E83_2085788480 = entry;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1454711022 = null;
        addTaint(state.getTaint());
        BasicPoolEntry varA7E53CE21691AB073D9660D615818899_49298371; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_49298371 = varB4EAC82CA7396A68D541C85D26508E83_1173672380;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_49298371 = varB4EAC82CA7396A68D541C85D26508E83_2085788480;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_49298371 = varB4EAC82CA7396A68D541C85D26508E83_1454711022;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_49298371.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_49298371;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.777 -0400", hash_original_method = "1F2F8066B3FF3FBE25C7998F0003547E", hash_generated_method = "3090D56704BE3BA9622250ECCCE4DD28")
    public void freeEntry(BasicPoolEntry entry) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException
                ("No entry created for this pool. " + route);
        } 
        {
            boolean varDEA0E0B979C7A24481B66E82D079F8AE_354618176 = (numEntries <= freeEntries.size());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException
                ("No entry allocated from this pool. " + route);
            } 
        } 
        freeEntries.add(entry);
        addTaint(entry.getTaint());
        
        
            
                
        
        
            
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.778 -0400", hash_original_method = "89E23A0834C1E349262FA5BF4999548A", hash_generated_method = "696D18D87F635A2E52072F0EB2D37918")
    public void createdEntry(BasicPoolEntry entry) {
        {
            boolean varA8DF0D9E568BA212A33113C790095F75_583107237 = (!route.equals(entry.getPlannedRoute()));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Entry not planned for this pool." +
                 "\npool: " + route +
                 "\nplan: " + entry.getPlannedRoute());
            } 
        } 
        addTaint(entry.getTaint());
        
        
            
                
                 
                 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.779 -0400", hash_original_method = "77FA36706319170F1442C426C0507BB4", hash_generated_method = "855C96D0EC78AAB87A8E09570688C788")
    public boolean deleteEntry(BasicPoolEntry entry) {
        final boolean found = freeEntries.remove(entry);
        addTaint(entry.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2123350257 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2123350257;
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.779 -0400", hash_original_method = "E1123D840A968B4EB04AEFB90EABFC3B", hash_generated_method = "8A9E0915338880A71A1B9A36A81EA60C")
    public void dropEntry() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException
                ("There is no entry that could be dropped.");
        } 
        
        
            
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.780 -0400", hash_original_method = "5F9CEBE3D4D005B8F7D968A4703E6CB7", hash_generated_method = "7791500A3875EAF64A3A7279C593C56F")
    public void queueThread(WaitingThread wt) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Waiting thread must not be null.");
        } 
        this.waitingThreads.add(wt);
        addTaint(wt.getTaint());
        
        
            
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.780 -0400", hash_original_method = "C6B8ECCB9FBEF4C7E1D5D0DF0E82610C", hash_generated_method = "226F59EAE9886397AEC229D82944B6AA")
    public boolean hasThread() {
        boolean varCB1185E953B8DD83492CB6A85FCF2AA5_1695603733 = (!this.waitingThreads.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_449602311 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_449602311;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.781 -0400", hash_original_method = "AB0F908D6786932ABD8D14E657997D12", hash_generated_method = "7A2B4AB10E2590786EBCE199FCA4FB84")
    public WaitingThread nextThread() {
        WaitingThread varB4EAC82CA7396A68D541C85D26508E83_1899593485 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1899593485 = this.waitingThreads.peek();
        varB4EAC82CA7396A68D541C85D26508E83_1899593485.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1899593485;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.781 -0400", hash_original_method = "E4B9C02A964F427588494E2D80051654", hash_generated_method = "2804D5975A58578620B7B749C41B12E6")
    public void removeThread(WaitingThread wt) {
        this.waitingThreads.remove(wt);
        addTaint(wt.getTaint());
        
        
            
        
    }

    
}

