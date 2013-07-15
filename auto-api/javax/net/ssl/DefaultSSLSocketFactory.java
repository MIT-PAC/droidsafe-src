package javax.net.ssl;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import libcore.util.EmptyArray;

class DefaultSSLSocketFactory extends SSLSocketFactory {
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.499 -0400", hash_original_field = "A35A1CBBA413D923284FE4F467EA17EB", hash_generated_field = "9CF404529F089526CB6A4794BF7634AB")
	private String errMessage;

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.500 -0400", hash_original_method = "518A173F954BA705CC3BF505F9E13E1E", hash_generated_method = "5F8808C0137C671CECF9FCB4803684EB")
	DefaultSSLSocketFactory(String mes) {
		errMessage = mes;
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.500 -0400", hash_original_method = "12108FA96648EC8E1683C3067260A382", hash_generated_method = "A5031B2964713D5E5A8E73EBE378C033")
	@Override
	public String[] getDefaultCipherSuites() {
		String[] varB4EAC82CA7396A68D541C85D26508E83_667857806 = null; 
																		
																		
																		
		varB4EAC82CA7396A68D541C85D26508E83_667857806 = EmptyArray.STRING;
		varB4EAC82CA7396A68D541C85D26508E83_667857806.addTaint(getTaint()); 
																			
																			
																			
		return varB4EAC82CA7396A68D541C85D26508E83_667857806;
		
		
	}

	@DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.500 -0400", hash_original_method = "02FB44E3332A242283DAD5FC179FF843", hash_generated_method = "D9CC18D6E4EEA2E042DDA1F7ED0BBF6B")
	@Override
	public String[] getSupportedCipherSuites() {
		String[] varB4EAC82CA7396A68D541C85D26508E83_1769301601 = null; 
																		
																		
																		
		varB4EAC82CA7396A68D541C85D26508E83_1769301601 = EmptyArray.STRING;
		varB4EAC82CA7396A68D541C85D26508E83_1769301601.addTaint(getTaint()); 
																				
																				
																				
		return varB4EAC82CA7396A68D541C85D26508E83_1769301601;
		
		
	}

	@DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.501 -0400", hash_original_method = "80973C4D16E76F8CBD9DC9AFB2C6FFD0", hash_generated_method = "3D7D477365F0D2FD7CDB9AE71F501847")
	@Override
	public Socket createSocket(Socket s, String host, int port, boolean autoClose) throws IOException {
		throw new SocketException(errMessage);

		
		
	}

	@DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.501 -0400", hash_original_method = "DA3DD563FBA8107A1A984067F5EE0D59", hash_generated_method = "13266D8DB93DC91D064EDC48625FB745")
	@Override
	public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
		throw new SocketException(errMessage);
		
		
	}

	@DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.502 -0400", hash_original_method = "8FF7B0825A4C1BFCEAEA97A8A771852A", hash_generated_method = "4C691C4237B2212CAFBF644211E3D7A7")
	@Override
	public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException, UnknownHostException {
		throw new SocketException(errMessage);
		
		
	}

	@DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.502 -0400", hash_original_method = "F1FA6E0F26B33554BE365A5605459FC6", hash_generated_method = "76EDCD58FD496DE1B63D4A11ED982D17")
	@Override
	public Socket createSocket(InetAddress host, int port) throws IOException {
		throw new SocketException(errMessage);
		
		
	}

	@DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.502 -0400", hash_original_method = "5A01435F50BC90BAF50A86E164E9FD29", hash_generated_method = "2B140B6CA7BF7309D246E8256206159F")
	@Override
	public Socket createSocket(InetAddress address, int port, InetAddress localAddress, int localPort) throws IOException {
		throw new SocketException(errMessage);
		
		
	}

}
