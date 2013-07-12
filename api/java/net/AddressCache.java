package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import libcore.util.BasicLruCache;

class AddressCache {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.435 -0400", hash_original_field = "05F5B634845D92FA0490913D8D84B01F", hash_generated_field = "66F36FCE191D24F1E090B75C9CC1CFED")

    private final BasicLruCache<String, AddressCacheEntry> cache = new BasicLruCache<String, AddressCacheEntry>(MAX_ENTRIES);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.436 -0400", hash_original_method = "FAF57634870A3B339F1CC57081189EF2", hash_generated_method = "FAF57634870A3B339F1CC57081189EF2")
    public AddressCache ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.436 -0400", hash_original_method = "D1FF7490F54CF1A82BA3C6629046B5CD", hash_generated_method = "AAA1ED0CE5EB800F50693357CCB1D777")
    public void clear() {
        cache.evictAll();
        // ---------- Original Method ----------
        //cache.evictAll();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.437 -0400", hash_original_method = "C8196E240B99FD0E66DB7F26CD4EF8D1", hash_generated_method = "8E87DD7C14DCFF21C99792C259259691")
    public Object get(String hostname) {
        addTaint(hostname.getTaint());
        AddressCacheEntry entry = cache.get(hostname);
    if(entry != null && entry.expiryNanos >= System.nanoTime())        
        {
Object varD2C0624DDD8A4F8F307477F36B405DFB_1478442212 =             entry.value;
            varD2C0624DDD8A4F8F307477F36B405DFB_1478442212.addTaint(taint);
            return varD2C0624DDD8A4F8F307477F36B405DFB_1478442212;
        } //End block
Object var540C13E9E156B687226421B24F2DF178_1435379857 =         null;
        var540C13E9E156B687226421B24F2DF178_1435379857.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1435379857;
        // ---------- Original Method ----------
        //AddressCacheEntry entry = cache.get(hostname);
        //if (entry != null && entry.expiryNanos >= System.nanoTime()) {
            //return entry.value;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.437 -0400", hash_original_method = "BAB205076FF7DD8DB52E2A3E48EC287C", hash_generated_method = "F8B4454ED081510486FE9BED788DDA0F")
    public void put(String hostname, InetAddress[] addresses) {
        addTaint(addresses[0].getTaint());
        addTaint(hostname.getTaint());
        put(hostname, addresses, true);
        // ---------- Original Method ----------
        //put(hostname, addresses, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.438 -0400", hash_original_method = "BE11705FB1BB92402BBB6B9F4331FB04", hash_generated_method = "DFCA78BD850711BCB96A45C8F290A0AE")
    public void put(String hostname, String detailMessage) {
        addTaint(detailMessage.getTaint());
        addTaint(hostname.getTaint());
        put(hostname, detailMessage, false);
        // ---------- Original Method ----------
        //put(hostname, detailMessage, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.438 -0400", hash_original_method = "DDAF9FE3FD0F9348B3B8E9E8698F0E22", hash_generated_method = "44D00E73C96045930F89B772F1884EED")
    public void put(String hostname, Object value, boolean isPositive) {
        addTaint(isPositive);
        addTaint(value.getTaint());
        addTaint(hostname.getTaint());
        String propertyName = isPositive ? "networkaddress.cache.ttl" : "networkaddress.cache.negative.ttl";
        long defaultTtlNanos = isPositive ? DEFAULT_POSITIVE_TTL_NANOS : DEFAULT_NEGATIVE_TTL_NANOS;
        long expiryNanos = System.nanoTime() + defaultTtlNanos;
        cache.put(hostname, new AddressCacheEntry(value, expiryNanos));
        // ---------- Original Method ----------
        //String propertyName = isPositive ? "networkaddress.cache.ttl" : "networkaddress.cache.negative.ttl";
        //long defaultTtlNanos = isPositive ? DEFAULT_POSITIVE_TTL_NANOS : DEFAULT_NEGATIVE_TTL_NANOS;
        //long expiryNanos = System.nanoTime() + defaultTtlNanos;
        //cache.put(hostname, new AddressCacheEntry(value, expiryNanos));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.439 -0400", hash_original_method = "9E6C3A8E77106C45FBFB86AD320286A9", hash_generated_method = "5D68100CA4449BE8F012E7B7A3EF0263")
    public void putUnknownHost(String hostname, String detailMessage) {
        addTaint(detailMessage.getTaint());
        addTaint(hostname.getTaint());
        put(hostname, detailMessage);
        // ---------- Original Method ----------
        //put(hostname, detailMessage);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.440 -0400", hash_original_method = "CA6BD7BD54236FC7C97CCB9D1828122E", hash_generated_method = "C546BD860C377025B0E05D918355C0B2")
    private long customTtl(String propertyName, long defaultTtlNanos) {
        addTaint(defaultTtlNanos);
        addTaint(propertyName.getTaint());
        String ttlString = System.getProperty(propertyName, null);
    if(ttlString == null)        
        {
            long var2F9E00B275DD994638791D91872E5D48_1607769688 = (System.nanoTime() + defaultTtlNanos);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_567497938 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_567497938;
        } //End block
        try 
        {
            long ttlS = Long.parseLong(ttlString);
    if(ttlS == -1)            
            {
                long var85712C72209F40438E81734FCEEB0717_1907358774 = (Long.MAX_VALUE);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_1715523365 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_1715523365;
            } //End block
            else
    if(ttlS == 0)            
            {
                long var3C8E60A5FA3722D6B0A8842B383A1743_595707301 = (Long.MIN_VALUE);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_1730666608 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_1730666608;
            } //End block
            else
            {
                long varB106ACDC7D4EC2C901913EEAB9BBD0BF_636062863 = (System.nanoTime() + ttlS * 1000000000L);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_341760949 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_341760949;
            } //End block
        } //End block
        catch (NumberFormatException ex)
        {
            long var2F9E00B275DD994638791D91872E5D48_1568596515 = (System.nanoTime() + defaultTtlNanos);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_396673506 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_396673506;
        } //End block
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.442 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "01495BEB834F5098BB0B06183674C819")

        Object value;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.442 -0400", hash_original_field = "56325C96FA32E1289B72ACE108E90F44", hash_generated_field = "A447C4D484B83310A83258B8B8C7A617")

        long expiryNanos;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.443 -0400", hash_original_method = "B930CA112737DBCA1D7B360D8F80699C", hash_generated_method = "BFC56695F6C33AF0097E4C4530359872")
          AddressCacheEntry(Object value, long expiryNanos) {
            this.value = value;
            this.expiryNanos = expiryNanos;
            // ---------- Original Method ----------
            //this.value = value;
            //this.expiryNanos = expiryNanos;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.443 -0400", hash_original_field = "1241F7F88F12573FDB6205F93DAF73A1", hash_generated_field = "5204922FABD23C1FBC7ABD47FD1AA264")

    private static final int MAX_ENTRIES = 512;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.443 -0400", hash_original_field = "B7A9B9010E60F922C5DFA434C7FD3396", hash_generated_field = "9F780CB53316C496BFCC1A791534397F")

    private static final long DEFAULT_POSITIVE_TTL_NANOS = 600 * 1000000000L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.443 -0400", hash_original_field = "473D76D531A1FBC6947C09E7D93D342E", hash_generated_field = "AA9C0C42C92AC71FEC3F0CA2012D1562")

    private static final long DEFAULT_NEGATIVE_TTL_NANOS = 10 * 1000000000L;
}

