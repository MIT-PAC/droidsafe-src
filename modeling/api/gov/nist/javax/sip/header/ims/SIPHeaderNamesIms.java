/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
* Conditions Of Use
*
* This software was developed by employees of the National Institute of
* Standards and Technology (NIST), an agency of the Federal Government.
* Pursuant to title 15 Untied States Code Section 105, works of NIST
* employees are not subject to copyright protection in the United States
* and are considered to be in the public domain.  As a result, a formal
* license is not needed to use the software.
*
* This software is provided by NIST as a service and is expressly
* provided "AS IS."  NIST MAKES NO WARRANTY OF ANY KIND, EXPRESS, IMPLIED
* OR STATUTORY, INCLUDING, WITHOUT LIMITATION, THE IMPLIED WARRANTY OF
* MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, NON-INFRINGEMENT
* AND DATA ACCURACY.  NIST does not warrant or make any representations
* regarding the use of the software or the results thereof, including but
* not limited to the correctness, accuracy, reliability or usefulness of
* the software.
*
* Permission to use this software is contingent upon your acceptance
* of the terms of this agreement
*
* .
*
*/
/*******************************************
 * PRODUCT OF PT INOVACAO - EST DEPARTMENT *
 *******************************************/


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface SIPHeaderNamesIms
    extends gov.nist.javax.sip.header.SIPHeaderNames {

    public static final String PATH = PathHeader.NAME;
    public static final String SERVICE_ROUTE = ServiceRouteHeader.NAME;
    public static final String P_ASSERTED_IDENTITY = PAssertedIdentityHeader.NAME;
    public static final String P_PREFERRED_IDENTITY = PPreferredIdentityHeader.NAME;
    public static final String CALLED_PARTY_ID = PCalledPartyIDHeader.NAME;
    public static final String P_VISITED_NETWORK_ID = PVisitedNetworkIDHeader.NAME;
    public static final String P_CHARGING_FUNCTION_ADDRESSES = PChargingFunctionAddressesHeader.NAME;
    public static final String P_CHARGING_VECTOR = PChargingVectorHeader.NAME;


    
    public static final String PRIVACY = PrivacyHeader.NAME;
    public static final String P_ASSOCIATED_URI = PAssociatedURIHeader.NAME;
    public static final String P_MEDIA_AUTHORIZATION = PMediaAuthorizationHeader.NAME;
    public static final String P_ACCESS_NETWORK_INFO = PAccessNetworkInfoHeader.NAME;
    public static final String SECURITY_SERVER = SecurityServerHeader.NAME;
    public static final String SECURITY_CLIENT = SecurityClientHeader.NAME;
    public static final String SECURITY_VERIFY = SecurityVerifyHeader.NAME;

    
    public static final String P_USER_DATABASE = PUserDatabaseHeader.NAME;
    
    public static final String P_PROFILE_KEY = PProfileKeyHeader.NAME;
    
    public static final String P_SERVED_USER = PServedUserHeader.NAME;
    
    public static final String P_PREFERRED_SERVICE = PPreferredServiceHeader.NAME;
    
    public static final String P_ASSERTED_SERVICE = PAssertedServiceHeader.NAME;


}
