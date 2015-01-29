/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.net.util;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A class that performs some subnet calculations given a network address and a subnet mask.
 * @see "http://www.faqs.org/rfcs/rfc1519.html"
 * @author <rwinston@apache.org>
 * @since 2.0
 */
public class SubnetUtils {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 14:49:42.685 -0500", hash_original_field = "078859BB78851652159CDA90430278C6", hash_generated_field = "E93300977CFD119C4F7826792F0617E5")


    private static final String IP_ADDRESS = "(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 14:49:42.698 -0500", hash_original_field = "A0B510BB4983603686E69B51EA49E47A", hash_generated_field = "D3BE09424D413EBF35ADEEAA926A5A37")

    private static final String SLASH_FORMAT = IP_ADDRESS + "/(\\d{1,3})";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 14:49:42.707 -0500", hash_original_field = "7A914D8C8DA065C6FAA5FECBA592985B", hash_generated_field = "44D3455426A81B521966DD8AB54C480C")

    private static final Pattern addressPattern = Pattern.compile(IP_ADDRESS);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 14:49:42.716 -0500", hash_original_field = "B141F51E841634C12B3FF4EE0A1E1BA9", hash_generated_field = "1EEDDE5DC1A6707198551A1882C43A52")

    private static final Pattern cidrPattern = Pattern.compile(SLASH_FORMAT);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 14:49:42.724 -0500", hash_original_field = "9BD5627E1240F8AC788C1E162437E540", hash_generated_field = "EC17BA8EAC5DDDB8912669962DD90B92")

    private static final int NBITS = 32;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 14:49:42.743 -0500", hash_original_field = "096A485BD5A2C97121E8653DC69AACAA", hash_generated_field = "A3F0CC08EE8D0E83ECCE032350A0B11B")


    private int netmask = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 14:49:42.750 -0500", hash_original_field = "4FC2ECB3C1321C49BDED3C4C6BF4E7DD", hash_generated_field = "58C42A10085500FAA1727E457EB0C0A1")

    private int address = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 14:49:42.758 -0500", hash_original_field = "519E0A13EB67078A399585B7F61C2598", hash_generated_field = "EA5FDAF2B86F73E2AC28B7B9CED1A453")

    private int network = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 14:49:42.765 -0500", hash_original_field = "4A5E69474A392185F55319E6D0BAC7F0", hash_generated_field = "4FC578530A391E6985162B613A1092A1")

    private int broadcast = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 14:49:42.772 -0500", hash_original_field = "F0839D8E3A8CFB4CFADB56C2CE056189", hash_generated_field = "8071F6E4DA331B0EE6F17FD33D55178E")

    private boolean inclusiveHostCount = false;


    /**
     * Constructor that takes a CIDR-notation string, e.g. "192.168.0.1/16"
     * @param cidrNotation A CIDR-notation string, e.g. "192.168.0.1/16"
     * @throws IllegalArgumentException if the parameter is invalid,
     * i.e. does not match n.n.n.n/m where n=1-3 decimal digits, m = 1-3 decimal digits in range 1-32
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 14:49:42.781 -0500", hash_original_method = "157BB975C48803AD0928ECBAE08F8FA8", hash_generated_method = "3728C55DD1BF19F6ACBAEFE33C839068")
    @DSVerified
    @DSSafe(DSCat.UTIL_FUNCTION)
public SubnetUtils(String cidrNotation) {
        calculate(cidrNotation);
    }

    /**
     * Constructor that takes a dotted decimal address and a dotted decimal mask.
     * @param address An IP address, e.g. "192.168.0.1"
     * @param mask A dotted decimal netmask e.g. "255.255.0.0"
     * @throws IllegalArgumentException if the address or mask is invalid,
     * i.e. does not match n.n.n.n where n=1-3 decimal digits and the mask is not all zeros
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 14:49:42.790 -0500", hash_original_method = "63BA1C908926027A946446536D66DAAF", hash_generated_method = "911EC2C3B1AD4177E67E0E1E1A04E166")
    @DSVerified
    @DSSafe(DSCat.UTIL_FUNCTION)
public SubnetUtils(String address, String mask) {
        calculate(toCidrNotation(address, mask));
    }


    /**
     * Returns <code>true</code> if the return value of {@link SubnetInfo#getAddressCount()}
     * includes the network address and broadcast addresses.
     * @since 2.2
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 14:49:42.797 -0500", hash_original_method = "97DC8A9ACEB96AAF44AFE497CD059B8A", hash_generated_method = "234E95A704AD9C7333492C6809915331")
    @DSVerified
    @DSSafe(DSCat.UTIL_FUNCTION)
public boolean isInclusiveHostCount() {
        return inclusiveHostCount;
    }

    /**
     * Set to <code>true</code> if you want the return value of {@link SubnetInfo#getAddressCount()}
     * to include the network and broadcast addresses.
     * @param inclusiveHostCount
     * @since 2.2
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 14:49:42.805 -0500", hash_original_method = "D3924945CC7AD46803D5505BE72CABA8", hash_generated_method = "A8C42B047F6F10A9D1DE579B33F07839")
    @DSVerified
    @DSSafe(DSCat.UTIL_FUNCTION)
public void setInclusiveHostCount(boolean inclusiveHostCount) {
        this.inclusiveHostCount = inclusiveHostCount;
    }



    /**
     * Convenience container for subnet summary information.
     *
     */
    public final class SubnetInfo {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 14:49:42.814 -0500", hash_original_method = "ECA8FFB33BFD26B9461873FB8ED0ABD8", hash_generated_method = "6CA11C46DA8183238393B8E5D5D359BB")
        @DSVerified
        @DSBan(DSCat.PRIVATE_METHOD)
private SubnetInfo() {}

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 14:49:42.820 -0500", hash_original_method = "EC08EB826CA531B05275838618729F3F", hash_generated_method = "23E537B9867008E0FF1392127CEC0231")
        @DSVerified
        @DSBan(DSCat.PRIVATE_METHOD)
private int netmask()       { return netmask; }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 14:49:42.827 -0500", hash_original_method = "64E1A1A91A94A97D1D028EA0D1082DDE", hash_generated_method = "E118063E3E89D7973F581C1296264BE0")
        @DSVerified
        @DSBan(DSCat.PRIVATE_METHOD)
private int network()       { return network; }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 14:49:42.834 -0500", hash_original_method = "17C68FDA84A51971BAC21F1A6A079273", hash_generated_method = "B41981CF8FAF3ABD9F2610173FC40FFD")
        @DSVerified
        @DSBan(DSCat.PRIVATE_METHOD)
private int address()       { return address; }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 14:49:42.841 -0500", hash_original_method = "2B407E8FD3F4CD100F1CFD44758B00BB", hash_generated_method = "BFE0315F9EF2E10A1C4F528A2B65AD84")
        @DSVerified
        @DSBan(DSCat.PRIVATE_METHOD)
private int broadcast()     { return broadcast; }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 14:49:42.849 -0500", hash_original_method = "8EEC8AD5CA02569D719C0C0BE460EA58", hash_generated_method = "F77AC2342CA293D496EC5769C6816AE6")
        @DSVerified
        @DSBan(DSCat.PRIVATE_METHOD)
private int low() {
            return (isInclusiveHostCount() ? network() :
                broadcast() - network() > 1 ? network() + 1 : 0);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 14:49:42.858 -0500", hash_original_method = "A4F31DD0D1809B50592638A7238F4E6E", hash_generated_method = "0CD22A945F173FA12A5B7FA51215D188")
        @DSVerified
        @DSBan(DSCat.PRIVATE_METHOD)
private int high() {
            return (isInclusiveHostCount() ? broadcast() :
                broadcast() - network() > 1 ? broadcast() -1  : 0);
        }

        /**
         * Returns true if the parameter <code>address</code> is in the
         * range of usable endpoint addresses for this subnet. This excludes the
         * network and broadcast adresses.
         * @param address A dot-delimited IPv4 address, e.g. "192.168.0.1"
         * @return True if in range, false otherwise
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 14:49:42.865 -0500", hash_original_method = "166508A5E98263F6BA2CE5E6C3C1F730", hash_generated_method = "D3592D1127BC45FEC730AC24C77DA816")
        @DSVerified
        @DSBan(DSCat.PRIVATE_METHOD)
public boolean isInRange(String address) {
            return isInRange(toInteger(address));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 14:49:42.873 -0500", hash_original_method = "F98C554A06612F278625B90570B88EE9", hash_generated_method = "E77B09D59CF1037F75F5BED426CE99B5")
        @DSVerified
        @DSBan(DSCat.PRIVATE_METHOD)
private boolean isInRange(int address) {
            int diff = address - low();
            return (diff >= 0 && (diff <= (high() - low())));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 14:49:42.879 -0500", hash_original_method = "7E759A378AAD27E4AE0326CE2048F978", hash_generated_method = "0F48B6FCD33A675E0258BBA72079B47D")
        @DSVerified
        @DSSafe(DSCat.DATA_STRUCTURE) 
public String getBroadcastAddress() {
            return format(toArray(broadcast()));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 14:49:42.887 -0500", hash_original_method = "E688440F7473904A1E4AE55001A7A67C", hash_generated_method = "1478BAB72805127F0CAAEC52FBF2DFAA")
        @DSVerified
        @DSSafe(DSCat.DATA_STRUCTURE)
public String getNetworkAddress() {
            return format(toArray(network()));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 14:49:42.893 -0500", hash_original_method = "5FB2544CE8489ACB3B20E8011BBDA4FD", hash_generated_method = "17369670B8AEE5C270C5449F7C5E6A36")
        @DSVerified
        @DSSafe(DSCat.DATA_STRUCTURE)
public String getNetmask() {
            return format(toArray(netmask()));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 14:49:42.901 -0500", hash_original_method = "19AC23CC72072AF42519AE4735D61E28", hash_generated_method = "4381FB130A31135792B02B6DDEE2F28F")
        @DSVerified
        @DSSafe(DSCat.DATA_STRUCTURE)
public String getAddress() {
            return format(toArray(address()));
        }

        /**
         * Return the low address as a dotted IP address.
         * Will be zero for CIDR/31 and CIDR/32 if the inclusive flag is false.
         *
         * @return the IP address in dotted format, may be "0.0.0.0" if there is no valid address
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 14:49:42.907 -0500", hash_original_method = "DF0D0146BD58DD402215DECB2B3314DD", hash_generated_method = "6B7831AE6EBE369A10AF9D4AE3A79245")
        @DSVerified
        @DSSafe(DSCat.DATA_STRUCTURE)
public String getLowAddress() {
            return format(toArray(low()));
        }

        /**
         * Return the high address as a dotted IP address.
         * Will be zero for CIDR/31 and CIDR/32 if the inclusive flag is false.
         *
         * @return the IP address in dotted format, may be "0.0.0.0" if there is no valid address
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 14:49:42.914 -0500", hash_original_method = "F5BD798171F01197216739C132F687F2", hash_generated_method = "37F17D443F8CB02DF12A25F808210B0E")
        @DSVerified
        @DSSafe(DSCat.DATA_STRUCTURE)
public String getHighAddress() {
            return format(toArray(high()));
        }

        /**
         * Get the count of available addresses.
         * Will be zero for CIDR/31 and CIDR/32 if the inclusive flag is false.
         * @return the count of addresses, may be zero.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 14:49:42.922 -0500", hash_original_method = "E7AAA73660418A45489496657F2C97CE", hash_generated_method = "9CC865C3EE02E8A5FD1C7F9C688647F4")
        @DSVerified
        @DSSafe(DSCat.DATA_STRUCTURE)
public int getAddressCount()                {
            int count = broadcast() - network() + (isInclusiveHostCount() ? 1 : -1);
            return count < 0 ? 0 : count;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 14:49:42.930 -0500", hash_original_method = "5BA0CC2BEE415CC7F36E7EBD8BED4E5F", hash_generated_method = "EF2E15E2EADC338636B6774E028C21D7")
        @DSVerified
        @DSSafe(DSCat.DATA_STRUCTURE)
public int asInteger(String address) {
            return toInteger(address);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 14:49:42.939 -0500", hash_original_method = "1333816BFDD6169878244F06C7EF4F30", hash_generated_method = "98F7B4BC99AA8113DA42F15930D30D3C")
        @DSVerified
        @DSSafe(DSCat.DATA_STRUCTURE)
public String getCidrSignature() {
            return toCidrNotation(
                    format(toArray(address())),
                    format(toArray(netmask()))
            );
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 14:49:42.949 -0500", hash_original_method = "E3FEF78345824E68E187B1AE0322CEBF", hash_generated_method = "57EEF827B18C6D305FDB5F2B3C32BE7B")
        @DSVerified
        @DSSafe(DSCat.DATA_STRUCTURE)
public String[] getAllAddresses() {
            int ct = getAddressCount();
            String[] addresses = new String[ct];
            if (ct == 0) {
                return addresses;
            }
            for (int add = low(), j=0; add <= high(); ++add, ++j) {
                addresses[j] = format(toArray(add));
            }
            return addresses;
        }

        /**
         * {@inheritDoc}
         * @since 2.2
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 14:49:42.963 -0500", hash_original_method = "42A07CBF2747F35C59C900FD6C62EF89", hash_generated_method = "AC4DB5381C3059F4FE879D862B20ECCD")
        @DSVerified
        @DSSafe(DSCat.DATA_STRUCTURE)
@Override
        public String toString() {
            final StringBuilder buf = new StringBuilder();
            buf.append("CIDR Signature:\t[").append(getCidrSignature()).append("]")
                .append(" Netmask: [").append(getNetmask()).append("]\n")
                .append("Network:\t[").append(getNetworkAddress()).append("]\n")
                .append("Broadcast:\t[").append(getBroadcastAddress()).append("]\n")
                 .append("First Address:\t[").append(getLowAddress()).append("]\n")
                 .append("Last Address:\t[").append(getHighAddress()).append("]\n")
                 .append("# Addresses:\t[").append(getAddressCount()).append("]\n");
            return buf.toString();
        }
    }

    /**
     * Return a {@link SubnetInfo} instance that contains subnet-specific statistics
     * @return new instance
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 14:49:43.004 -0500", hash_original_method = "2EED01BBC27165ACCACB66DFEB3BE149", hash_generated_method = "686E070DAEE43248ACCEA6C6CA479C45")
    
public final SubnetInfo getInfo() { return new SubnetInfo(); }

    /*
     * Initialize the internal fields from the supplied CIDR mask
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 14:49:43.019 -0500", hash_original_method = "E579F643F4AEC795B0C878B30394ADDC", hash_generated_method = "610CD05025E5BFDE2E477EC2374D1DF9")
    @DSVerified
    @DSBan(DSCat.PRIVATE_METHOD)
private void calculate(String mask) {
        Matcher matcher = cidrPattern.matcher(mask);

        if (matcher.matches()) {
            address = matchAddress(matcher);

            /* Create a binary netmask from the number of bits specification /x */
            int cidrPart = rangeCheck(Integer.parseInt(matcher.group(5)), 0, NBITS);
            for (int j = 0; j < cidrPart; ++j) {
                netmask |= (1 << 31-j);
            }

            /* Calculate base network address */
            network = (address & netmask);

            /* Calculate broadcast address */
            broadcast = network | ~(netmask);
        } else {
            throw new IllegalArgumentException("Could not parse [" + mask + "]");
        }
    }

    /*
     * Convert a dotted decimal format address to a packed integer format
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 14:49:43.030 -0500", hash_original_method = "BD9F27BEA4C350DC6D902FD253CBFAA6", hash_generated_method = "BBF614951707EA39FEF59AE067E52060")
    @DSVerified
    @DSBan(DSCat.PRIVATE_METHOD)
private int toInteger(String address) {
        Matcher matcher = addressPattern.matcher(address);
        if (matcher.matches()) {
            return matchAddress(matcher);
        } else {
            throw new IllegalArgumentException("Could not parse [" + address + "]");
        }
    }

    /*
     * Convenience method to extract the components of a dotted decimal address and
     * pack into an integer using a regex match
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 14:49:43.037 -0500", hash_original_method = "3D2BB004DF59072B4D35138A8A5018A7", hash_generated_method = "3B2E70720A9575B47E8A05EF8A785B93")
    @DSVerified
    @DSBan(DSCat.PRIVATE_METHOD)
private int matchAddress(Matcher matcher) {
        int addr = 0;
        for (int i = 1; i <= 4; ++i) {
            int n = (rangeCheck(Integer.parseInt(matcher.group(i)), -1, 255));
            addr |= ((n & 0xff) << 8*(4-i));
        }
        return addr;
    }

    /*
     * Convert a packed integer address into a 4-element array
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 14:49:43.044 -0500", hash_original_method = "960286A7EEFECD24DCDAC5A7EBBCEB8A", hash_generated_method = "2A7B29E46346BA2CDC528712C2202F5E")
    @DSVerified
    @DSBan(DSCat.PRIVATE_METHOD)
private int[] toArray(int val) {
        int ret[] = new int[4];
        for (int j = 3; j >= 0; --j) {
            ret[j] |= ((val >>> 8*(3-j)) & (0xff));
        }
        return ret;
    }

    /*
     * Convert a 4-element array into dotted decimal format
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 14:49:43.057 -0500", hash_original_method = "12AACE97B7ED91E864AAB76678893AD0", hash_generated_method = "CD0BBCACBD6D3D40EFC6878C92652909")
    @DSVerified
    @DSBan(DSCat.PRIVATE_METHOD)
private String format(int[] octets) {
        StringBuilder str = new StringBuilder();
        for (int i =0; i < octets.length; ++i){
            str.append(octets[i]);
            if (i != octets.length - 1) {
                str.append(".");
            }
        }
        return str.toString();
    }

    /*
     * Convenience function to check integer boundaries.
     * Checks if a value x is in the range (begin,end].
     * Returns x if it is in range, throws an exception otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 14:49:43.065 -0500", hash_original_method = "0E9827B7F838F03682EB2BCF6A3AC4CB", hash_generated_method = "191E0E4FBDE1E0B5E6855D6D089A3786")
    @DSVerified
    @DSBan(DSCat.PRIVATE_METHOD)
private int rangeCheck(int value, int begin, int end) {
        if (value > begin && value <= end) { // (begin,end]
            return value;
        }

        throw new IllegalArgumentException("Value [" + value + "] not in range ("+begin+","+end+"]");
    }

    /*
     * Count the number of 1-bits in a 32-bit integer using a divide-and-conquer strategy
     * see Hacker's Delight section 5.1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 14:49:43.072 -0500", hash_original_method = "537D9F675C428BDEAB845CE7F323BC2A", hash_generated_method = "537D9F675C428BDEAB845CE7F323BC2A")
    @DSVerified
    @DSBan(DSCat.PRIVATE_METHOD)
int pop(int x) {
        x = x - ((x >>> 1) & 0x55555555);
        x = (x & 0x33333333) + ((x >>> 2) & 0x33333333);
        x = (x + (x >>> 4)) & 0x0F0F0F0F;
        x = x + (x >>> 8);
        x = x + (x >>> 16);
        return x & 0x0000003F;
    }

    /* Convert two dotted decimal addresses to a single xxx.xxx.xxx.xxx/yy format
     * by counting the 1-bit population in the mask address. (It may be better to count
     * NBITS-#trailing zeroes for this case)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 14:49:43.078 -0500", hash_original_method = "0F9BEEB22D77691EAB6F2B03A57AE55C", hash_generated_method = "46CE0CF06A0DB302BA4674D202A2A0CE")
    @DSVerified
    @DSBan(DSCat.PRIVATE_METHOD)
private String toCidrNotation(String addr, String mask) {
        return addr + "/" + pop(toInteger(mask));
    }
}
