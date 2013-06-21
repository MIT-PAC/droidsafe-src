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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.272 -0400", hash_original_method = "2BA7FCCCB0B1A5166409E758532E1350", hash_generated_method = "2BA7FCCCB0B1A5166409E758532E1350")
        public RandomBitsSupplier ()
    {
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

    
    private static FileInputStream fis = null;
    private static File randomFile = null;
    private static boolean serviceAvailable = false;
    private static final String DEVICE_NAMES[] = { "/dev/urandom"  };
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

