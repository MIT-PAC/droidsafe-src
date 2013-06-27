package org.apache.harmony.security.provider.crypto;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.ProviderException;

public class RandomBitsSupplier implements SHA1_Data {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.885 -0400", hash_original_method = "C2EAC1E8FB299AA5C7A70ED055C01714", hash_generated_method = "C2EAC1E8FB299AA5C7A70ED055C01714")
    public RandomBitsSupplier ()
    {
        //Synthesized constructor
    }


        static boolean isServiceAvailable() {
        return serviceAvailable;
    }

    
        private static synchronized byte[] getUnixDeviceRandom(int numBytes) {
        byte[] bytes = new byte[numBytes];
        int total = 0;
        int bytesRead;
        int offset = 0;
        try {
            for ( ; ; ) {
                bytesRead = fis.read(bytes, offset, numBytes-total);
                if ( bytesRead == -1 ) {
                    throw new ProviderException("bytesRead == -1");
                }
                total  += bytesRead;
                offset += bytesRead;
                if ( total >= numBytes ) {
                    break;
                }
            }
        } catch (IOException e) {
            throw new ProviderException("ATTENTION: IOException in RandomBitsSupplier.getLinuxRandomBits(): " + e);
        }
        return bytes;
    }

    
        public static byte[] getRandomBits(int numBytes) {
        if (numBytes <= 0) {
            throw new IllegalArgumentException(Integer.toString(numBytes));
        }
        if ( !serviceAvailable ) {
            throw new ProviderException("ATTENTION: service is not available : no random devices");
        }
        return getUnixDeviceRandom(numBytes);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.887 -0400", hash_original_field = "C9EF4CE3B74843B383E0FEF956CB7C02", hash_generated_field = "5953C13EEC4748E72DBEEA524CB92C42")

    private static FileInputStream fis = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.887 -0400", hash_original_field = "C5EFB803831AE17B96DDC5FF8C9F1521", hash_generated_field = "8AB48E545C9A9079E8984894A324FFDB")

    private static File randomFile = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.887 -0400", hash_original_field = "A0A7B8CAC73E02478C8F4E4920BB836F", hash_generated_field = "311846FC929AEDC17ACEFCD58751F46E")

    private static boolean serviceAvailable = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.887 -0400", hash_original_field = "0A4B917F226B12841AB5214AED425CB8", hash_generated_field = "CFEF4A6E70A198B12EDD931CB7B2B4FA")

    private static String DEVICE_NAMES[] = ;
    static {
        for (String deviceName : DEVICE_NAMES) {
            try {
                File file = new File(deviceName);
                if (file.canRead()) {
                    fis = new FileInputStream(file);
                    randomFile = file;
                    serviceAvailable = true;
                }
            } catch (FileNotFoundException e) {
            }
        }
    }
    
}

