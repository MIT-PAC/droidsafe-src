package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import libcore.util.BasicLruCache;





class AddressCache {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.880 -0500", hash_original_field = "2E4A7E0ADB7AD2DD3408B12728E13C2F", hash_generated_field = "5204922FABD23C1FBC7ABD47FD1AA264")

    private static final int MAX_ENTRIES = 512;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.883 -0500", hash_original_field = "076239377362375FF6E7887EEA7E9AFB", hash_generated_field = "9F780CB53316C496BFCC1A791534397F")

    private static final long DEFAULT_POSITIVE_TTL_NANOS = 600 * 1000000000L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.885 -0500", hash_original_field = "AC2485A9186364539653E9F7499D2127", hash_generated_field = "AA9C0C42C92AC71FEC3F0CA2012D1562")

    private static final long DEFAULT_NEGATIVE_TTL_NANOS = 10 * 1000000000L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.888 -0500", hash_original_field = "D7EAF6C10F41B9A7A77B84EF9E4C1608", hash_generated_field = "66F36FCE191D24F1E090B75C9CC1CFED")

    private final BasicLruCache<String, AddressCacheEntry> cache
            = new BasicLruCache<String, AddressCacheEntry>(MAX_ENTRIES);
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.250 -0400", hash_original_method = "FAF57634870A3B339F1CC57081189EF2", hash_generated_method = "FAF57634870A3B339F1CC57081189EF2")
    public AddressCache ()
    {
        //Synthesized constructor
    }

    /**
     * Removes all entries from the cache.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.901 -0500", hash_original_method = "D1FF7490F54CF1A82BA3C6629046B5CD", hash_generated_method = "562997D5907F1BA3F5258B853973CC1C")
    
public void clear() {
        cache.evictAll();
    }

    /**
     * Returns the cached InetAddress[] associated with 'hostname'. Returns null if nothing is known
     * about 'hostname'. Returns a String suitable for use as an UnknownHostException detail
     * message if 'hostname' is known not to exist.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.904 -0500", hash_original_method = "C8196E240B99FD0E66DB7F26CD4EF8D1", hash_generated_method = "93E1795ECF5D8B0742F3159E34FC6CC8")
    
public Object get(String hostname) {
        AddressCacheEntry entry = cache.get(hostname);
        // Do we have a valid cache entry?
        if (entry != null && entry.expiryNanos >= System.nanoTime()) {
            return entry.value;
        }
        // Either we didn't find anything, or it had expired.
        // No need to remove expired entries: the caller will provide a replacement shortly.
        return null;
    }

    /**
     * Associates the given 'addresses' with 'hostname'. The association will expire after a
     * certain length of time.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.906 -0500", hash_original_method = "BAB205076FF7DD8DB52E2A3E48EC287C", hash_generated_method = "FFE39D199E88D962B97D134A047A6004")
    
public void put(String hostname, InetAddress[] addresses) {
        put(hostname, addresses, true);
    }

    /**
     * Associates the given 'detailMessage' with 'hostname'. The association will expire after a
     * certain length of time.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.908 -0500", hash_original_method = "BE11705FB1BB92402BBB6B9F4331FB04", hash_generated_method = "9679846F14674BBCF1733A34EAF385DD")
    
public void put(String hostname, String detailMessage) {
        put(hostname, detailMessage, false);
    }

    
    static class AddressCacheEntry {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.891 -0500", hash_original_field = "01495BEB834F5098BB0B06183674C819", hash_generated_field = "D933278613C352684A53A2027DDBD11D")

        // or a String detail message for a negative entry.
         Object value;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.893 -0500", hash_original_field = "A447C4D484B83310A83258B8B8C7A617", hash_generated_field = "A447C4D484B83310A83258B8B8C7A617")

         long expiryNanos;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.897 -0500", hash_original_method = "B930CA112737DBCA1D7B360D8F80699C", hash_generated_method = "B930CA112737DBCA1D7B360D8F80699C")
        
AddressCacheEntry(Object value, long expiryNanos) {
            this.value = value;
            this.expiryNanos = expiryNanos;
        }

        
    }

    /**
     * Associates the given 'addresses' with 'hostname'. The association will expire after a
     * certain length of time.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.912 -0500", hash_original_method = "DDAF9FE3FD0F9348B3B8E9E8698F0E22", hash_generated_method = "34B2FB0DEA43CFFC00CEB0B13E0786BC")
    
public void put(String hostname, Object value, boolean isPositive) {
        // Calculate the expiry time.
        String propertyName = isPositive ? "networkaddress.cache.ttl" : "networkaddress.cache.negative.ttl";
        long defaultTtlNanos = isPositive ? DEFAULT_POSITIVE_TTL_NANOS : DEFAULT_NEGATIVE_TTL_NANOS;
        long expiryNanos = System.nanoTime() + defaultTtlNanos;
        // Update the cache.
        cache.put(hostname, new AddressCacheEntry(value, expiryNanos));
    }

    /**
     * Records that 'hostname' is known not to have any associated addresses. (I.e. insert a
     * negative cache entry.)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.914 -0500", hash_original_method = "9E6C3A8E77106C45FBFB86AD320286A9", hash_generated_method = "090A502C5C4A40551CC36324ED090E43")
    
public void putUnknownHost(String hostname, String detailMessage) {
        put(hostname, detailMessage);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.917 -0500", hash_original_method = "CA6BD7BD54236FC7C97CCB9D1828122E", hash_generated_method = "35E51F4714A5A762FA6448BA689E9AFB")
    
private long customTtl(String propertyName, long defaultTtlNanos) {
        String ttlString = System.getProperty(propertyName, null);
        if (ttlString == null) {
            return System.nanoTime() + defaultTtlNanos;
        }
        try {
            long ttlS = Long.parseLong(ttlString);
            // For the system properties, -1 means "cache forever" and 0 means "don't cache".
            if (ttlS == -1) {
                return Long.MAX_VALUE;
            } else if (ttlS == 0) {
                return Long.MIN_VALUE;
            } else {
                return System.nanoTime() + ttlS * 1000000000L;
            }
        } catch (NumberFormatException ex) {
            return System.nanoTime() + defaultTtlNanos;
        }
    }
}

