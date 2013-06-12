package android.net.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.RemoteException;
import android.util.Log;

public final class SipSession {
	private static final String TAG = "SipSession";
	private final ISipSession mSession;
	private Listener mListener;

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.367 -0400", hash_original_method = "B71DAA3D1365DDABF697A1D97F8D88A8", hash_generated_method = "2851B8E9221E80B50ABE64DC3E32CE7F")
	// DSFIXME: CODE0002: Requires DSC value to be set
	SipSession(ISipSession realSession) {
		dsTaint.addTaint(realSession.dsTaint);
		mSession = realSession;
		{
			try {
				realSession.setListener(createListener());
			} // End block
			catch (RemoteException e) {
			}
		} // End block
			// ---------- Original Method ----------
			// mSession = realSession;
			// if (realSession != null) {
			// try {
			// realSession.setListener(createListener());
		// } catch (RemoteException e) {
		// Log.e(TAG, "SipSession.setListener(): " + e);
		// }
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.367 -0400", hash_original_method = "26EA80DBAC1B6413B57EA6A425A19EE9", hash_generated_method = "E6695D4E23012ED9EBCFB33C8DB62EDA")
	// DSFIXME: CODE0002: Requires DSC value to be set
	SipSession(ISipSession realSession, Listener listener) {
		this(realSession);
		dsTaint.addTaint(listener.dsTaint);
		dsTaint.addTaint(realSession.dsTaint);
		setListener(listener);
		// ---------- Original Method ----------
		// setListener(listener);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.367 -0400", hash_original_method = "E9A721906097EBC1FEB98095FAB057F5", hash_generated_method = "DB1F2889414E912F61CEECD7893FEC6B")
	// DSFIXME: CODE0002: Requires DSC value to be set
	public String getLocalIp() {
		try {
			String var0ADCD22A05C2B1D0284B748801B30A93_2074890904 = (mSession
					.getLocalIp());
		} // End block
		catch (RemoteException e) {
		}
		return dsTaint.getTaintString();
		// ---------- Original Method ----------
		// try {
		// return mSession.getLocalIp();
		// } catch (RemoteException e) {
		// Log.e(TAG, "getLocalIp(): " + e);
		// return "127.0.0.1";
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.367 -0400", hash_original_method = "87F54D512869FBB2D14566F63922D1B6", hash_generated_method = "6704E55777D5D14CD594896CD8A5ABF3")
	// DSFIXME: CODE0002: Requires DSC value to be set
	public SipProfile getLocalProfile() {
		try {
			SipProfile var5E1E1E65123BEE29A9CB22EAD573CFD8_1902832524 = (mSession
					.getLocalProfile());
		} // End block
		catch (RemoteException e) {
		}
		return (SipProfile) dsTaint.getTaint();
		// ---------- Original Method ----------
		// try {
		// return mSession.getLocalProfile();
		// } catch (RemoteException e) {
		// Log.e(TAG, "getLocalProfile(): " + e);
		// return null;
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.367 -0400", hash_original_method = "D61110CB083F8C813E52FD778D269E44", hash_generated_method = "F38438585F7B381AC0AD51EC0625ABD1")
	// DSFIXME: CODE0002: Requires DSC value to be set
	public SipProfile getPeerProfile() {
		try {
			SipProfile varA061DC31E8E2562D99E981A239D7EED5_752172555 = (mSession
					.getPeerProfile());
		} // End block
		catch (RemoteException e) {
		}
		return (SipProfile) dsTaint.getTaint();
		// ---------- Original Method ----------
		// try {
		// return mSession.getPeerProfile();
		// } catch (RemoteException e) {
		// Log.e(TAG, "getPeerProfile(): " + e);
		// return null;
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.367 -0400", hash_original_method = "9EA9E21B58E34C7FB49C45688377E72F", hash_generated_method = "53A185A0EEFD84628DE8AC07D94FA6C2")
	// DSFIXME: CODE0002: Requires DSC value to be set
	public int getState() {
		try {
			int var5C9BD891D63C83243CB7DCB3EA826EE9_1681928348 = (mSession
					.getState());
		} // End block
		catch (RemoteException e) {
		}
		return dsTaint.getTaintInt();
		// ---------- Original Method ----------
		// try {
		// return mSession.getState();
		// } catch (RemoteException e) {
		// Log.e(TAG, "getState(): " + e);
		// return State.NOT_DEFINED;
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.368 -0400", hash_original_method = "9EAE3F24E2C650B2D541A86A9F9A7795", hash_generated_method = "820AF66C5AC7068F897F9307D009CD4E")
	// DSFIXME: CODE0002: Requires DSC value to be set
	public boolean isInCall() {
		try {
			boolean var756F7B5AF584B3E3C76961D5CC547EFB_903212054 = (mSession
					.isInCall());
		} // End block
		catch (RemoteException e) {
		}
		return dsTaint.getTaintBoolean();
		// ---------- Original Method ----------
		// try {
		// return mSession.isInCall();
		// } catch (RemoteException e) {
		// Log.e(TAG, "isInCall(): " + e);
		// return false;
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.368 -0400", hash_original_method = "A52F1B195D0D0A598BE5EAF9C188D1E2", hash_generated_method = "1F98F663634563E380EF1D0E7B9AE974")
	// DSFIXME: CODE0002: Requires DSC value to be set
	public String getCallId() {
		try {
			String varE47AB60BE9B4BCFFEC05E6A601322D1F_2088487529 = (mSession
					.getCallId());
		} // End block
		catch (RemoteException e) {
		}
		return dsTaint.getTaintString();
		// ---------- Original Method ----------
		// try {
		// return mSession.getCallId();
		// } catch (RemoteException e) {
		// Log.e(TAG, "getCallId(): " + e);
		// return null;
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.368 -0400", hash_original_method = "DF1CB7C0481108A53612C7FB72F6204A", hash_generated_method = "6717CBA545B33F3F87A27FCA31DACA92")
	@DSModeled(DSC.SAFE)
	public void setListener(Listener listener) {
		dsTaint.addTaint(listener.dsTaint);
		// ---------- Original Method ----------
		// mListener = listener;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.368 -0400", hash_original_method = "8D2FD08823732E1C2D815A7E90C0FC77", hash_generated_method = "655EC538DBD5AF64FD523DC4CBC89FC5")
	@DSModeled(DSC.SAFE)
	public void register(int duration) {
		dsTaint.addTaint(duration);
		try {
			mSession.register(duration);
		} // End block
		catch (RemoteException e) {
		}
		// ---------- Original Method ----------
		// try {
		// mSession.register(duration);
		// } catch (RemoteException e) {
		// Log.e(TAG, "register(): " + e);
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.368 -0400", hash_original_method = "E4AB4EE14705E79FAB12EC8A1515405F", hash_generated_method = "AF4032891FC83EDCAEF82914C465710F")
	@DSModeled(DSC.SAFE)
	public void unregister() {
		try {
			mSession.unregister();
		} // End block
		catch (RemoteException e) {
		}
		// ---------- Original Method ----------
		// try {
		// mSession.unregister();
		// } catch (RemoteException e) {
		// Log.e(TAG, "unregister(): " + e);
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.368 -0400", hash_original_method = "D9BC3F90AB4006B9EA6C3281D0F8E8EF", hash_generated_method = "57829F7DBB9D23D5F7862E92D3F46A9F")
	@DSModeled(DSC.SAFE)
	public void makeCall(SipProfile callee, String sessionDescription,
			int timeout) {
		dsTaint.addTaint(sessionDescription);
		dsTaint.addTaint(callee.dsTaint);
		dsTaint.addTaint(timeout);
		try {
			mSession.makeCall(callee, sessionDescription, timeout);
		} // End block
		catch (RemoteException e) {
		}
		// ---------- Original Method ----------
		// try {
		// mSession.makeCall(callee, sessionDescription, timeout);
		// } catch (RemoteException e) {
		// Log.e(TAG, "makeCall(): " + e);
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.368 -0400", hash_original_method = "A5A5F75F0E41462274C36F9EA8217848", hash_generated_method = "2CF7D06FB6FF2DDBF9ACBBEE4120CBE5")
	@DSModeled(DSC.SAFE)
	public void answerCall(String sessionDescription, int timeout) {
		dsTaint.addTaint(sessionDescription);
		dsTaint.addTaint(timeout);
		try {
			mSession.answerCall(sessionDescription, timeout);
		} // End block
		catch (RemoteException e) {
		}
		// ---------- Original Method ----------
		// try {
		// mSession.answerCall(sessionDescription, timeout);
		// } catch (RemoteException e) {
		// Log.e(TAG, "answerCall(): " + e);
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.368 -0400", hash_original_method = "B98ACA998657ED3CD995605D9A274D2E", hash_generated_method = "7EC23D2FF95F9CCB645666770CABF3CB")
	@DSModeled(DSC.SAFE)
	public void endCall() {
		try {
			mSession.endCall();
		} // End block
		catch (RemoteException e) {
		}
		// ---------- Original Method ----------
		// try {
		// mSession.endCall();
		// } catch (RemoteException e) {
		// Log.e(TAG, "endCall(): " + e);
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.369 -0400", hash_original_method = "0DCF9DE8E2729C90E933890D545801E4", hash_generated_method = "6DE3EB67939653A9C20CD760D0E183AE")
	@DSModeled(DSC.SAFE)
	public void changeCall(String sessionDescription, int timeout) {
		dsTaint.addTaint(sessionDescription);
		dsTaint.addTaint(timeout);
		try {
			mSession.changeCall(sessionDescription, timeout);
		} // End block
		catch (RemoteException e) {
		}
		// ---------- Original Method ----------
		// try {
		// mSession.changeCall(sessionDescription, timeout);
		// } catch (RemoteException e) {
		// Log.e(TAG, "changeCall(): " + e);
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.369 -0400", hash_original_method = "457DE503669A22F9796CDD5163AC081E", hash_generated_method = "B0AB477AB248A646FC24B2FB499CC6BE")
	@DSModeled(DSC.SAFE)
	ISipSession getRealSession() {
		return (ISipSession) dsTaint.getTaint();
		// ---------- Original Method ----------
		// return mSession;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.369 -0400", hash_original_method = "346C5E2A278D0A9A8B61352C5712D581", hash_generated_method = "8CF4F0B04FB590F1583C6D1C46F4C0B0")
	@DSModeled(DSC.SAFE)
	private ISipSessionListener createListener() {
		return (ISipSessionListener) dsTaint.getTaint();
		// ---------- Original Method ----------
		// Original Method Too Long, Refer to Original Implementation
	}

	public static class State {
		public static final int READY_TO_CALL = 0;
		public static final int REGISTERING = 1;
		public static final int DEREGISTERING = 2;
		public static final int INCOMING_CALL = 3;
		public static final int INCOMING_CALL_ANSWERING = 4;
		public static final int OUTGOING_CALL = 5;
		public static final int OUTGOING_CALL_RING_BACK = 6;
		public static final int OUTGOING_CALL_CANCELING = 7;
		public static final int IN_CALL = 8;
		public static final int PINGING = 9;
		public static final int ENDING_CALL = 10;
		public static final int NOT_DEFINED = 101;

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.369 -0400", hash_original_method = "1314C653F2455ACB4C7CC9637DF86BCF", hash_generated_method = "DAC54337419F2BB6A5857B8FDAA81645")
		@DSModeled(DSC.SAFE)
		private State() {
			// ---------- Original Method ----------
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.369 -0400", hash_original_method = "568E659DC654AF7F82B3FE327FE2A97B", hash_generated_method = "F153B60BE1575A843B5EC2EC8D1A33BE")
		public static String toString(int state) {
			switch (state) {
			case READY_TO_CALL:
				return "READY_TO_CALL";
			case REGISTERING:
				return "REGISTERING";
			case DEREGISTERING:
				return "DEREGISTERING";
			case INCOMING_CALL:
				return "INCOMING_CALL";
			case INCOMING_CALL_ANSWERING:
				return "INCOMING_CALL_ANSWERING";
			case OUTGOING_CALL:
				return "OUTGOING_CALL";
			case OUTGOING_CALL_RING_BACK:
				return "OUTGOING_CALL_RING_BACK";
			case OUTGOING_CALL_CANCELING:
				return "OUTGOING_CALL_CANCELING";
			case IN_CALL:
				return "IN_CALL";
			case PINGING:
				return "PINGING";
			default:
				return "NOT_DEFINED";
			}
		}

	}

	public static class Listener {

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.369 -0400", hash_original_method = "AE0E913F9E3F8804DBC653BF8673EC2F", hash_generated_method = "47CD149B6F5E4B93B7230716A76633FA")
		@DSModeled(DSC.SAFE)
		public void onCalling(SipSession session) {
			// DSFIXME: CODE0009: Possible callback target function detected
			dsTaint.addTaint(session.dsTaint);
			// ---------- Original Method ----------
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.369 -0400", hash_original_method = "A6495E0C14482D9554C3F987B616D040", hash_generated_method = "E64AEEF2D20B02E2B9ADA4E190B51AD1")
		@DSModeled(DSC.SAFE)
		public void onRinging(SipSession session, SipProfile caller,
				String sessionDescription) {
			// DSFIXME: CODE0009: Possible callback target function detected
			dsTaint.addTaint(caller.dsTaint);
			dsTaint.addTaint(session.dsTaint);
			dsTaint.addTaint(sessionDescription);
			// ---------- Original Method ----------
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.370 -0400", hash_original_method = "3040682D1BCFEA9BA338FA9FE200A62D", hash_generated_method = "2BF350F59EA7022CB636EFA6C33CEF3E")
		@DSModeled(DSC.SAFE)
		public void onRingingBack(SipSession session) {
			// DSFIXME: CODE0009: Possible callback target function detected
			dsTaint.addTaint(session.dsTaint);
			// ---------- Original Method ----------
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.370 -0400", hash_original_method = "E5D299BA3CDE0EE166AC2795783FB427", hash_generated_method = "04BD2343AD1EAD2C08BCD4874CF8D0E4")
		@DSModeled(DSC.SAFE)
		public void onCallEstablished(SipSession session,
				String sessionDescription) {
			// DSFIXME: CODE0009: Possible callback target function detected
			dsTaint.addTaint(session.dsTaint);
			dsTaint.addTaint(sessionDescription);
			// ---------- Original Method ----------
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.370 -0400", hash_original_method = "711404AF80F30F53943AF0817E2DC7DA", hash_generated_method = "AF377F3132B1B713D0F3CBDA2B4D56A4")
		@DSModeled(DSC.SAFE)
		public void onCallEnded(SipSession session) {
			// DSFIXME: CODE0009: Possible callback target function detected
			dsTaint.addTaint(session.dsTaint);
			// ---------- Original Method ----------
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.370 -0400", hash_original_method = "DF73FA582D888219D7BAD8AC6A6DFD56", hash_generated_method = "BCEE320DB2AD9BA10E18FC5B3011F62C")
		@DSModeled(DSC.SAFE)
		public void onCallBusy(SipSession session) {
			// DSFIXME: CODE0009: Possible callback target function detected
			dsTaint.addTaint(session.dsTaint);
			// ---------- Original Method ----------
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.370 -0400", hash_original_method = "BA5AD9CB5800C0FF06E65720317D213F", hash_generated_method = "CEDEF204C9ACD4966FD9A96C3B322A8C")
		@DSModeled(DSC.SAFE)
		public void onCallTransferring(SipSession newSession,
				String sessionDescription) {
			// DSFIXME: CODE0009: Possible callback target function detected
			dsTaint.addTaint(sessionDescription);
			dsTaint.addTaint(newSession.dsTaint);
			// ---------- Original Method ----------
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.370 -0400", hash_original_method = "4CD681E2D11D80A916993A5E2A67B6D2", hash_generated_method = "440E76E85F635E2EF0F3344DFA9EDE50")
		@DSModeled(DSC.SAFE)
		public void onError(SipSession session, int errorCode,
				String errorMessage) {
			// DSFIXME: CODE0009: Possible callback target function detected
			dsTaint.addTaint(errorMessage);
			dsTaint.addTaint(session.dsTaint);
			dsTaint.addTaint(errorCode);
			// ---------- Original Method ----------
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.370 -0400", hash_original_method = "98747504BDA403336DDC3899112D7C4E", hash_generated_method = "06C62BE385EC8753373D20772E665A67")
		@DSModeled(DSC.SAFE)
		public void onCallChangeFailed(SipSession session, int errorCode,
				String errorMessage) {
			// DSFIXME: CODE0009: Possible callback target function detected
			dsTaint.addTaint(errorMessage);
			dsTaint.addTaint(session.dsTaint);
			dsTaint.addTaint(errorCode);
			// ---------- Original Method ----------
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.370 -0400", hash_original_method = "20558DF6BFC1217A7001B14AA50A9A03", hash_generated_method = "2A77A11EE42C10AB75B7AA4FBCC2E0C1")
		@DSModeled(DSC.SAFE)
		public void onRegistering(SipSession session) {
			// DSFIXME: CODE0009: Possible callback target function detected
			dsTaint.addTaint(session.dsTaint);
			// ---------- Original Method ----------
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.370 -0400", hash_original_method = "7504CEF239C11FEA532F08720FD2042B", hash_generated_method = "321E678E43DA4918E801AE89828DB21A")
		@DSModeled(DSC.SAFE)
		public void onRegistrationDone(SipSession session, int duration) {
			// DSFIXME: CODE0009: Possible callback target function detected
			dsTaint.addTaint(duration);
			dsTaint.addTaint(session.dsTaint);
			// ---------- Original Method ----------
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.370 -0400", hash_original_method = "3E873AF3736F468DF3025CAE14D73D95", hash_generated_method = "B516413AA218F8CEB09236EAFA99B73E")
		@DSModeled(DSC.SAFE)
		public void onRegistrationFailed(SipSession session, int errorCode,
				String errorMessage) {
			// DSFIXME: CODE0009: Possible callback target function detected
			dsTaint.addTaint(errorMessage);
			dsTaint.addTaint(session.dsTaint);
			dsTaint.addTaint(errorCode);
			// ---------- Original Method ----------
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.371 -0400", hash_original_method = "43D598AFE19AB6009363638DB64C1F7B", hash_generated_method = "129F439B02A71F1C6585EA147E57F0F0")
		@DSModeled(DSC.SAFE)
		public void onRegistrationTimeout(SipSession session) {
			// DSFIXME: CODE0009: Possible callback target function detected
			dsTaint.addTaint(session.dsTaint);
			// ---------- Original Method ----------
		}

	}

}
