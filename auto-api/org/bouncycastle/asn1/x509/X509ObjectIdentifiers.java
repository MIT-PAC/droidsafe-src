package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;

public interface X509ObjectIdentifiers
{
    
    
    
    static final String                 id                      = "2.5.4";

    static final ASN1ObjectIdentifier    commonName              = new ASN1ObjectIdentifier(id + ".3");
    static final ASN1ObjectIdentifier    countryName             = new ASN1ObjectIdentifier(id + ".6");
    static final ASN1ObjectIdentifier    localityName            = new ASN1ObjectIdentifier(id + ".7");
    static final ASN1ObjectIdentifier    stateOrProvinceName     = new ASN1ObjectIdentifier(id + ".8");
    static final ASN1ObjectIdentifier    organization            = new ASN1ObjectIdentifier(id + ".10");
    static final ASN1ObjectIdentifier    organizationalUnitName  = new ASN1ObjectIdentifier(id + ".11");

    static final ASN1ObjectIdentifier    id_at_telephoneNumber   = new ASN1ObjectIdentifier("2.5.4.20");
    static final ASN1ObjectIdentifier    id_at_name              = new ASN1ObjectIdentifier(id + ".41");

    
    
    static final ASN1ObjectIdentifier    id_SHA1                 = new ASN1ObjectIdentifier("1.3.14.3.2.26");

    
    
    
    
    static final ASN1ObjectIdentifier    ripemd160               = new ASN1ObjectIdentifier("1.3.36.3.2.1");

    
    
    
    
    static final ASN1ObjectIdentifier    ripemd160WithRSAEncryption = new ASN1ObjectIdentifier("1.3.36.3.3.1.2");


    static final ASN1ObjectIdentifier    id_ea_rsa = new ASN1ObjectIdentifier("2.5.8.1.1");
    
    
    static final ASN1ObjectIdentifier id_pkix = new ASN1ObjectIdentifier("1.3.6.1.5.5.7");

    
    
    
    static final ASN1ObjectIdentifier  id_pe = new ASN1ObjectIdentifier(id_pkix + ".1");

    
    
    
    static final ASN1ObjectIdentifier  id_ad = new ASN1ObjectIdentifier(id_pkix + ".48");
    static final ASN1ObjectIdentifier  id_ad_caIssuers = new ASN1ObjectIdentifier(id_ad + ".2");
    static final ASN1ObjectIdentifier  id_ad_ocsp = new ASN1ObjectIdentifier(id_ad + ".1");

    
    
    
    static final ASN1ObjectIdentifier ocspAccessMethod = id_ad_ocsp;
    static final ASN1ObjectIdentifier crlAccessMethod = id_ad_caIssuers;
}
