package com.android.internal.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class Protocol {
    public static final int MAX_MESSAGE                                             = 0x0000FFFF;
    public static final int BASE_SYSTEM_RESERVED                                    = 0x00010000;
    public static final int BASE_SYSTEM_ASYNC_CHANNEL                               = 0x00011000;
    public static final int BASE_WIFI                                               = 0x00020000;
    public static final int BASE_WIFI_WATCHDOG                                      = 0x00021000;
    public static final int BASE_WIFI_P2P_MANAGER                                   = 0x00022000;
    public static final int BASE_WIFI_P2P_SERVICE                                   = 0x00023000;
    public static final int BASE_WIFI_MONITOR                                       = 0x00024000;
    public static final int BASE_DHCP                                               = 0x00030000;
    public static final int BASE_DATA_CONNECTION                                    = 0x00040000;
    public static final int BASE_DATA_CONNECTION_AC                                 = 0x00041000;
    public static final int BASE_DATA_CONNECTION_TRACKER                            = 0x00042000;
    public static final int BASE_DNS_PINGER                                         = 0x00050000;
    
}


