package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import libcore.util.BasicLruCache;

class AddressCache {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.003 -0400", hash_original_field = "05F5B634845D92FA0490913D8D84B01F", hash_generated_field = "66F36FCE191D24F1E090B75C9CC1CFED")

    private final BasicLruCache<String, AddressCacheEntry> cache = new BasicLruCache<String, AddressCacheEntry>(MAX_ENTRIES);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.003 -0400", hash_original_method = "FAF57634870A3B339F1CC57081189EF2", hash_generated_method = "FAF57634870A3B339F1CC57081189EF2")
    public AddressCache ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.003 -0400", hash_original_method = "D1FF7490F54CF1A82BA3C6629046B5CD", hash_generated_method = "AAA1ED0CE5EB800F50693357CCB1D777")
    public void clear() {
        cache.evictAll();
        // ---------- Original Method ----------
        //cache.evictAll();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.004 -0400", hash_original_method = "C8196E240B99FD0E66DB7F26CD4EF8D1", hash_generated_method = "25B50C3A605CD09733E6A38BCC6D799F")
    public Object get(String hostname) {
        Object varB4EAC82CA7396A68D541C85D26508E83_624334457 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_2074626742 = null; //Variable for return #2
        AddressCacheEntry entry = cache.get(hostname);
        {
            boolean var54B7B6573FE6BF58F9F84CC96B046902_915761540 = (entry != null && entry.expiryNanos >= System.nanoTime());
            {
                varB4EAC82CA7396A68D541C85D26508E83_624334457 = entry.value;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_2074626742 = null;
        addTaint(hostname.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_2077394985; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2077394985 = varB4EAC82CA7396A68D541C85D26508E83_624334457;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2077394985 = varB4EAC82CA7396A68D541C85D26508E83_2074626742;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2077394985.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2077394985;
        // ---------- Original Method ----------
        //AddressCacheEntry entry = cache.get(hostname);
        //if (entry != null && entry.expiryNanos >= System.nanoTime()) {
            //return entry.value;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.004 -0400", hash_original_method = "BAB205076FF7DD8DB52E2A3E48EC287C", hash_generated_method = "D8671831D351BEFF6279F1D1D2202205")
    public void put(String hostname, InetAddress[] addresses) {
        put(hostname, addresses, true);
        addTaint(hostname.getTaint());
        addTaint(addresses[0].getTaint());
        // ---------- Original Method ----------
        //put(hostname, addresses, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.004 -0400", hash_original_method = "BE11705FB1BB92402BBB6B9F4331FB04", hash_generated_method = "919352DC32215AE21283E139DE0289CF")
    public void put(String hostname, String detailMessage) {
        put(hostname, detailMessage, false);
        addTaint(hostname.getTaint());
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
        //put(hostname, detailMessage, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.005 -0400", hash_original_method = "DDAF9FE3FD0F9348B3B8E9E8698F0E22", hash_generated_method = "18A0F1FF066692287C6C4C0A3A4828C4")
    public void put(String hostname, Object value, boolean isPositive) {
        String propertyName;
        propertyName = "networkaddress.cache.ttl";
        propertyName = "networkaddress.cache.negative.ttl";
        long defaultTtlNanos;
        defaultTtlNanos = DEFAULT_POSITIVE_TTL_NANOS;
        defaultTtlNanos = DEFAULT_NEGATIVE_TTL_NANOS;
        long expiryNanos = System.nanoTime() + defaultTtlNanos;
        cache.put(hostname, new AddressCacheEntry(value, expiryNanos));
        addTaint(hostname.getTaint());
        addTaint(value.getTaint());
        addTaint(isPositive);
        // ---------- Original Method ----------
        //String propertyName = isPositive ? "networkaddress.cache.ttl" : "networkaddress.cache.negative.ttl";
        //long defaultTtlNanos = isPositive ? DEFAULT_POSITIVE_TTL_NANOS : DEFAULT_NEGATIVE_TTL_NANOS;
        //long expiryNanos = System.nanoTime() + defaultTtlNanos;
        //cache.put(hostname, new AddressCacheEntry(value, expiryNanos));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.005 -0400", hash_original_method = "9E6C3A8E77106C45FBFB86AD320286A9", hash_generated_method = "66A5710672748DC5388D47004E9AD18E")
    public void putUnknownHost(String hostname, String detailMessage) {
        put(hostname, detailMessage);
        addTaint(hostname.getTaint());
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
        //put(hostname, detailMessage);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.005 -0400", hash_original_method = "CA6BD7BD54236FC7C97CCB9D1828122E", hash_generated_method = "A47ED0303C1A4646D990571B38253842")
    private long customTtl(String propertyName, long defaultTtlNanos) {
        String ttlString = System.getProperty(propertyName, null);
        {
            long var231788D81D965470B4E7AD92E5AE6B41_1113892107 = (System.nanoTime() + defaultTtlNanos);
        } //End block
        try 
        {
            long ttlS = Long.parseLong(ttlString);
            {
                long var93C7485D514464F98DE280BDFA940DDE_1332729608 = (System.nanoTime() + ttlS * 1000000000L);
            } //End block
        } //End block
        catch (NumberFormatException ex)
        {
            long var231788D81D965470B4E7AD92E5AE6B41_548841464 = (System.nanoTime() + defaultTtlNanos);
        } //End block
        addTaint(propertyName.getTaint());
        addTaint(defaultTtlNanos);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1930170638 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1930170638;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.005 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "01495BEB834F5098BB0B06183674C819")

        Object value;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.005 -0400", hash_original_field = "56325C96FA32E1289B72ACE108E90F44", hash_generated_field = "A447C4D484B83310A83258B8B8C7A617")

        long expiryNanos;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.006 -0400", hash_original_method = "B930CA112737DBCA1D7B360D8F80699C", hash_generated_method = "BFC56695F6C33AF0097E4C4530359872")
          AddressCacheEntry(Object value, long expiryNanos) {
            this.value = value;
            this.expiryNanos = expiryNanos;
            // ---------- Original Method ----------
            //this.value = value;
            //this.expiryNanos = expiryNanos;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.006 -0400", hash_original_field = "1241F7F88F12573FDB6205F93DAF73A1", hash_generated_field = "5204922FABD23C1FBC7ABD47FD1AA264")

    private static final int MAX_ENTRIES = 512;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.006 -0400", hash_original_field = "B7A9B9010E60F922C5DFA434C7FD3396", hash_generated_field = "9F780CB53316C496BFCC1A791534397F")

    private static final long DEFAULT_POSITIVE_TTL_NANOS = 600 * 1000000000L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.006 -0400", hash_original_field = "473D76D531A1FBC6947C09E7D93D342E", hash_generated_field = "AA9C0C42C92AC71FEC3F0CA2012D1562")

    private static final long DEFAULT_NEGATIVE_TTL_NANOS = 10 * 1000000000L;
}

