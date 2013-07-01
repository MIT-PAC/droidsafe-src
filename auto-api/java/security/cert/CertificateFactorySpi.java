package java.security.cert;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class CertificateFactorySpi {

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.987 -0400", hash_original_method = "5D6CCD92AEFDD2109C84465ED1C78995", hash_generated_method = "C286B4EE0E22EDBF9018054D79D5D19E")
	public CertificateFactorySpi() {
		// ---------- Original Method ----------
	}

	public abstract Certificate engineGenerateCertificate(InputStream inStream) throws CertificateException;

	public abstract Collection<? extends Certificate> engineGenerateCertificates(InputStream inStream) throws CertificateException;

	public abstract CRL engineGenerateCRL(InputStream inStream) throws CRLException;

	public abstract Collection<? extends CRL> engineGenerateCRLs(InputStream inStream) throws CRLException;

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.989 -0400", hash_original_method = "2C4FAAEF9B20A7D507A4295CE3E76AED", hash_generated_method = "7AECBF6EF09BC078E2A1AA9766A90B87")
	public CertPath engineGenerateCertPath(InputStream inStream) throws CertificateException {
			throw new UnsupportedOperationException();
		// ---------- Original Method ----------
		// throw new UnsupportedOperationException();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.989 -0400", hash_original_method = "CCA28EB94758BBDA1626E2C95F3A6CB6", hash_generated_method = "E14D0EEB041EB363C65634785477D93B")
	public CertPath engineGenerateCertPath(InputStream inStream, String encoding) throws CertificateException {
		throw new UnsupportedOperationException();
		// ---------- Original Method ----------
		// throw new UnsupportedOperationException();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.991 -0400", hash_original_method = "3277FA5FC53B837612594B707D8CC5BB", hash_generated_method = "EB4E3374A2FCEFEF7ED4954656743A00")
	public CertPath engineGenerateCertPath(List<? extends Certificate> certificates) throws CertificateException {
		throw new UnsupportedOperationException();
		// ---------- Original Method ----------
		// throw new UnsupportedOperationException();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.992 -0400", hash_original_method = "D60EF50967AE5C5FE3CD2559F27951D5", hash_generated_method = "45694A1DEDEDCA206E8BB3F35D96CADE")
	public Iterator<String> engineGetCertPathEncodings() {
		throw new UnsupportedOperationException();
		// ---------- Original Method ----------
		// throw new UnsupportedOperationException();
	}

}
