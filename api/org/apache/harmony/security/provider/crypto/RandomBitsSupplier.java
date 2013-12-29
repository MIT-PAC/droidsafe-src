package org.apache.harmony.security.provider.crypto;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.ProviderException;






public class RandomBitsSupplier implements SHA1_Data {


    /**
     * The method is called by provider to determine if a device is available.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:08.804 -0500", hash_original_method = "3259964D642F1E81BEF73199EA8A73AC", hash_generated_method = "9E5E54730E70BE586A1A95C1A642A8DE")
    static boolean isServiceAvailable() {
        return serviceAvailable;
    }


    /**
     * On platforms with "random" devices available,
     * the method reads random bytes from the device.  <BR>
     *
     * In case of any runtime failure ProviderException gets thrown.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:08.805 -0500", hash_original_method = "A38BCE2020D253BC2B60805DDBFC4023", hash_generated_method = "195046E5C35B050C5174F241E9486995")
    private static synchronized byte[] getUnixDeviceRandom(int numBytes) {

        byte[] bytes = new byte[numBytes];

        int total = 0;
        int bytesRead;
        int offset = 0;
        try {
            for ( ; ; ) {

                bytesRead = fis.read(bytes, offset, numBytes-total);


                // the below case should not occur because /dev/random or /dev/urandom is a special file
                // hence, if it is happened there is some internal problem
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

            // actually there should be no IOException because device is a special file;
            // hence, there is either some internal problem or, for instance,
            // device was removed in runtime, or something else
            throw new ProviderException("ATTENTION: IOException in RandomBitsSupplier.getLinuxRandomBits(): " + e);
        }
        return bytes;
    }

    /**
     * The method returns byte array of requested length provided service is available.
     * ProviderException gets thrown otherwise.
     *
     * @param
     *       numBytes - length of bytes requested
     * @return
     *       byte array
     * @throws
     *       InvalidArgumentException - if numBytes <= 0
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:08.806 -0500", hash_original_method = "AC6ABEE79D7DD42398E45F6C2A11844E", hash_generated_method = "AD19D944B8C9506DD38C71483134531F")
    public static byte[] getRandomBits(int numBytes) {
        if (numBytes <= 0) {
            throw new IllegalArgumentException(Integer.toString(numBytes));
        }

        // We have been unable to get a random device or fall back to the
        // native security module code - throw an exception.
        if ( !serviceAvailable ) {
            throw new ProviderException("ATTENTION: service is not available : no random devices");
        }

        return getUnixDeviceRandom(numBytes);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:08.801 -0500", hash_original_field = "670080ABF3760AFAA308F08D01CEFE67", hash_generated_field = "5953C13EEC4748E72DBEEA524CB92C42")

    private static FileInputStream fis = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:08.802 -0500", hash_original_field = "49CB41E63418DDFE0D00335A2EC6CF12", hash_generated_field = "8AB48E545C9A9079E8984894A324FFDB")

    private static File randomFile = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:08.803 -0500", hash_original_field = "9218B431CE7CD6BA2016BBED0F446830", hash_generated_field = "311846FC929AEDC17ACEFCD58751F46E")

    private static boolean serviceAvailable = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:08.804 -0500", hash_original_field = "6B2F18B12A9932334E3A5FCC8A9EED3C", hash_generated_field = "5BCAD3A625DEF166032C261CBA27C9CF")

    private static final String DEVICE_NAMES[] = { "/dev/urandom" /*, "/dev/random" */ };
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.222 -0400", hash_original_method = "C2EAC1E8FB299AA5C7A70ED055C01714", hash_generated_method = "C2EAC1E8FB299AA5C7A70ED055C01714")
    public RandomBitsSupplier ()
    {
        //Synthesized constructor
    }
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

