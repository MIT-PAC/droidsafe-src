package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import libcore.util.BasicLruCache;

class AddressCache {
    private BasicLruCache<String, AddressCacheEntry> cache
            = new BasicLruCache<String, AddressCacheEntry>(MAX_ENTRIES);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.738 -0400", hash_original_method = "3DCF391C8B45AD39A499CE9482712CDD", hash_generated_method = "3DCF391C8B45AD39A499CE9482712CDD")
        public AddressCache ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.738 -0400", hash_original_method = "D1FF7490F54CF1A82BA3C6629046B5CD", hash_generated_method = "AAA1ED0CE5EB800F50693357CCB1D777")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clear() {
        cache.evictAll();
        // ---------- Original Method ----------
        //cache.evictAll();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.738 -0400", hash_original_method = "C8196E240B99FD0E66DB7F26CD4EF8D1", hash_generated_method = "8C5AE564E80A8811223B64F617829228")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object get(String hostname) {
        dsTaint.addTaint(hostname);
        AddressCacheEntry entry;
        entry = cache.get(hostname);
        {
            boolean var54B7B6573FE6BF58F9F84CC96B046902_2063301817 = (entry != null && entry.expiryNanos >= System.nanoTime());
        } //End collapsed parenthetic
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //AddressCacheEntry entry = cache.get(hostname);
        //if (entry != null && entry.expiryNanos >= System.nanoTime()) {
            //return entry.value;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.739 -0400", hash_original_method = "BAB205076FF7DD8DB52E2A3E48EC287C", hash_generated_method = "D59B82FC890AA5287D8EBBA4A82C31FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void put(String hostname, InetAddress[] addresses) {
        dsTaint.addTaint(hostname);
        dsTaint.addTaint(addresses[0].dsTaint);
        put(hostname, addresses, true);
        // ---------- Original Method ----------
        //put(hostname, addresses, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.739 -0400", hash_original_method = "BE11705FB1BB92402BBB6B9F4331FB04", hash_generated_method = "46F601196ACCEEAB10C651EB26563918")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void put(String hostname, String detailMessage) {
        dsTaint.addTaint(detailMessage);
        dsTaint.addTaint(hostname);
        put(hostname, detailMessage, false);
        // ---------- Original Method ----------
        //put(hostname, detailMessage, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.739 -0400", hash_original_method = "DDAF9FE3FD0F9348B3B8E9E8698F0E22", hash_generated_method = "C3E3B8F4AE323DF71C2E696569ED165F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void put(String hostname, Object value, boolean isPositive) {
        dsTaint.addTaint(isPositive);
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(hostname);
        String propertyName;
        propertyName = "networkaddress.cache.ttl";
        propertyName = "networkaddress.cache.negative.ttl";
        long defaultTtlNanos;
        defaultTtlNanos = DEFAULT_POSITIVE_TTL_NANOS;
        defaultTtlNanos = DEFAULT_NEGATIVE_TTL_NANOS;
        long expiryNanos;
        expiryNanos = System.nanoTime() + defaultTtlNanos;
        cache.put(hostname, new AddressCacheEntry(value, expiryNanos));
        // ---------- Original Method ----------
        //String propertyName = isPositive ? "networkaddress.cache.ttl" : "networkaddress.cache.negative.ttl";
        //long defaultTtlNanos = isPositive ? DEFAULT_POSITIVE_TTL_NANOS : DEFAULT_NEGATIVE_TTL_NANOS;
        //long expiryNanos = System.nanoTime() + defaultTtlNanos;
        //cache.put(hostname, new AddressCacheEntry(value, expiryNanos));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.739 -0400", hash_original_method = "9E6C3A8E77106C45FBFB86AD320286A9", hash_generated_method = "B3A49C3C98BB85D0F9E2BF082617B39A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void putUnknownHost(String hostname, String detailMessage) {
        dsTaint.addTaint(detailMessage);
        dsTaint.addTaint(hostname);
        put(hostname, detailMessage);
        // ---------- Original Method ----------
        //put(hostname, detailMessage);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.740 -0400", hash_original_method = "CA6BD7BD54236FC7C97CCB9D1828122E", hash_generated_method = "647D75119DE28988362932B4C26425CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private long customTtl(String propertyName, long defaultTtlNanos) {
        dsTaint.addTaint(propertyName);
        dsTaint.addTaint(defaultTtlNanos);
        String ttlString;
        ttlString = System.getProperty(propertyName, null);
        {
            long var231788D81D965470B4E7AD92E5AE6B41_1697697351 = (System.nanoTime() + defaultTtlNanos);
        } //End block
        try 
        {
            long ttlS;
            ttlS = Long.parseLong(ttlString);
            {
                long var93C7485D514464F98DE280BDFA940DDE_1640438654 = (System.nanoTime() + ttlS * 1000000000L);
            } //End block
        } //End block
        catch (NumberFormatException ex)
        {
            long var231788D81D965470B4E7AD92E5AE6B41_944913244 = (System.nanoTime() + defaultTtlNanos);
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //String ttlString = System.getProperty(propertyName, null);
        //if (ttlString == null) {
            //return System.nanoTime() + defaultTtlNanos;
        //}
        //try {
            //long ttlS = Long.parseLong(ttlString);
            //if (ttlS == -1) {
                //return Long.MAX_VALUE;
            //} else if (ttlS == 0) {
                //return Long.MIN_VALUE;
            //} else {
                //return System.nanoTime() + ttlS * 1000000000L;
            //}
        //} catch (NumberFormatException ex) {
            //return System.nanoTime() + defaultTtlNanos;
        //}
    }

    
    static class AddressCacheEntry {
        Object value;
        long expiryNanos;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.740 -0400", hash_original_method = "B930CA112737DBCA1D7B360D8F80699C", hash_generated_method = "FF28527085CB1F4E1B7F5AAF5A6E8D43")
        @DSModeled(DSC.SAFE)
         AddressCacheEntry(Object value, long expiryNanos) {
            dsTaint.addTaint(expiryNanos);
            dsTaint.addTaint(value.dsTaint);
            // ---------- Original Method ----------
            //this.value = value;
            //this.expiryNanos = expiryNanos;
        }

        
    }


    
    private static final int MAX_ENTRIES = 512;
    private static final long DEFAULT_POSITIVE_TTL_NANOS = 600 * 1000000000L;
    private static final long DEFAULT_NEGATIVE_TTL_NANOS = 10 * 1000000000L;
}

