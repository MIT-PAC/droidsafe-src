package gov.nist.javax.sip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.ServerLogger;
import gov.nist.core.StackLogger;
import gov.nist.core.net.AddressResolver;
import gov.nist.core.net.NetworkLayer;
import gov.nist.core.net.SslNetworkLayer;
import gov.nist.javax.sip.clientauthutils.AccountManager;
import gov.nist.javax.sip.clientauthutils.AuthenticationHelper;
import gov.nist.javax.sip.clientauthutils.AuthenticationHelperImpl;
import gov.nist.javax.sip.clientauthutils.SecureAccountManager;
import gov.nist.javax.sip.parser.StringMsgParser;
import gov.nist.javax.sip.stack.DefaultMessageLogFactory;
import gov.nist.javax.sip.stack.DefaultRouter;
import gov.nist.javax.sip.stack.MessageProcessor;
import gov.nist.javax.sip.stack.SIPTransactionStack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import javax.sip.InvalidArgumentException;
import javax.sip.ListeningPoint;
import javax.sip.ObjectInUseException;
import javax.sip.PeerUnavailableException;
import javax.sip.ProviderDoesNotExistException;
import javax.sip.SipException;
import javax.sip.SipListener;
import javax.sip.SipProvider;
import javax.sip.SipStack;
import javax.sip.TransportNotSupportedException;
import javax.sip.address.Router;
import javax.sip.header.HeaderFactory;
import javax.sip.message.Request;






public class SipStackImpl extends SIPTransactionStack implements javax.sip.SipStack, SipStackExt {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:41.587 -0500", hash_original_field = "37FD84666920824F7C1E8C2BF1715713", hash_generated_field = "DC1BA291E655CE21E8210560B23E074D")

	public static final Integer MAX_DATAGRAM_SIZE = 8 * 1024;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:41.579 -0500", hash_original_field = "69E36DC2AAFBF80C0D45C129628BD358", hash_generated_field = "B13D933CCB9027F950F0F782A6866769")


	private EventScanner eventScanner;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:41.581 -0500", hash_original_field = "D78D26E4029046D32144DBB64200532C", hash_generated_field = "3AEF05BEBD52A17EF95A5D808F4FFFA4")


	private Hashtable<String, ListeningPointImpl> listeningPoints;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:41.584 -0500", hash_original_field = "6BEBC7E786F8A9BD33EB606A20200A7E", hash_generated_field = "4D9EE92C5E84922DC5B8DC3AD8BDEAEF")


	private LinkedList<SipProviderImpl> sipProviders;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:41.589 -0500", hash_original_field = "C05D7B5683B60CB11426E6CCECD30C55", hash_generated_field = "4A9068D8EC31DF0150BC24FF654DE497")

	// Use this flag with caution.
	boolean reEntrantListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:41.591 -0500", hash_original_field = "B9D95CF1DDB3EF5E2FB32454D5FBE60B", hash_generated_field = "B9D95CF1DDB3EF5E2FB32454D5FBE60B")


	SipListener sipListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:41.594 -0500", hash_original_field = "14BC1D7F6107A47B988CB81CBFA69682", hash_generated_field = "36858158C63585F0CA9C60A9D20D534C")

	// delivered for ACK transactions.
	boolean deliverTerminatedEventForAck = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:41.596 -0500", hash_original_field = "30FBBF692AD048CF0FD21C922D56959C", hash_generated_field = "4DEDBD29FF7FE92697D0DB9196DE43B8")

	// unsolicited NOTIFYs, ie NOTIFYs that don't match any dialog
	boolean deliverUnsolicitedNotify = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:41.599 -0500", hash_original_field = "E1EF273D7E4E761937D9E070D7F42008", hash_generated_field = "3D24F5BF02841FC581DDB4BFBB9A4EDB")

	private Semaphore stackSemaphore = new Semaphore(1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:41.602 -0500", hash_original_field = "A822CD52DA1C865AB7AA9339ACE1587A", hash_generated_field = "72714A172A118A69C4D65CAE0670E9BE")

	// RFC3261: TLS_RSA_WITH_3DES_EDE_CBC_SHA SHOULD be supported for backwards
	// compat
	private String[] cipherSuites = {
			"TLS_RSA_WITH_AES_128_CBC_SHA", // AES difficult to get with
											// c++/Windows
			// "TLS_RSA_WITH_3DES_EDE_CBC_SHA", // Unsupported by Sun impl,
			"SSL_RSA_WITH_3DES_EDE_CBC_SHA", // For backwards comp., C++

			// JvB: patch from Sebastien Mazy, issue with mismatching
			// ciphersuites
			"TLS_DH_anon_WITH_AES_128_CBC_SHA",
			"SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:41.604 -0500", hash_original_field = "BF95DFA0C959841932D7DD2ACB6A7554", hash_generated_field = "8206EF99B37B84E105B4852E2EE7C8F0")

	private String[] enabledProtocols = {
			"SSLv3",
			"SSLv2Hello",
			"TLSv1"
	};

	/**
	 * Creates a new instance of SipStackImpl.
	 */

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:41.607 -0500", hash_original_method = "BD80EAD073CED4ACABB1B92EBB481070", hash_generated_method = "AD468FA240B2CFDF2CB2457F1BA5A08C")
	
protected SipStackImpl() {
		super();
		NistSipMessageFactoryImpl msgFactory = new NistSipMessageFactoryImpl(
				this);
		super.setMessageFactory(msgFactory);
		this.eventScanner = new EventScanner(this);
		this.listeningPoints = new Hashtable<String, ListeningPointImpl>();
		this.sipProviders = new LinkedList<SipProviderImpl>();

	}

	/**
	 * Constructor for the stack.
	 * 
	 * @param configurationProperties
	 *            -- stack configuration properties including NIST-specific
	 *            extensions.
	 * @throws PeerUnavailableException
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:41.624 -0500", hash_original_method = "31E9570F9C2C0C73DA51527B7C89A7AA", hash_generated_method = "6758CD25A3623EADF6671D563F37C326")
	
public SipStackImpl(Properties configurationProperties)
			throws PeerUnavailableException {
		this();
		String address = configurationProperties
				.getProperty("javax.sip.IP_ADDRESS");
		try {
			/** Retrieve the stack IP address */
			if (address != null) {
				// In version 1.2 of the spec the IP address is
				// associated with the listening point and
				// is not madatory.
				super.setHostAddress(address);

			}
		} catch (java.net.UnknownHostException ex) {
			throw new PeerUnavailableException("bad address " + address);
		}

		/** Retrieve the stack name */
		String name = configurationProperties
				.getProperty("javax.sip.STACK_NAME");
		if (name == null)
			throw new PeerUnavailableException("stack name is missing");
		super.setStackName(name);
		String stackLoggerClassName = configurationProperties
				.getProperty("gov.nist.javax.sip.STACK_LOGGER");
		// To log debug messages.
		if (stackLoggerClassName == null)
			stackLoggerClassName = "gov.nist.core.LogWriter";
			try {
				Class<?> stackLoggerClass = Class.forName(stackLoggerClassName);
				Class<?>[] constructorArgs = new Class[0];
				Constructor<?> cons = stackLoggerClass
						.getConstructor(constructorArgs);
				Object[] args = new Object[0];
				StackLogger stackLogger = (StackLogger) cons.newInstance(args);
				stackLogger.setStackProperties(configurationProperties);
				super.setStackLogger(stackLogger);
			} catch (InvocationTargetException ex1) {
				throw new IllegalArgumentException(
						"Cound not instantiate stack logger "
								+ stackLoggerClassName
								+ "- check that it is present on the classpath and that there is a no-args constructor defined",
						ex1);
			} catch (Exception ex) {
				throw new IllegalArgumentException(
						"Cound not instantiate stack logger "
								+ stackLoggerClassName
								+ "- check that it is present on the classpath and that there is a no-args constructor defined",
						ex);
			}

		String serverLoggerClassName = configurationProperties
				.getProperty("gov.nist.javax.sip.SERVER_LOGGER");
		// To log debug messages.
		if (serverLoggerClassName == null)
			serverLoggerClassName = "gov.nist.javax.sip.stack.ServerLog";
			try {
				Class<?> serverLoggerClass = Class
						.forName(serverLoggerClassName);
				Class<?>[] constructorArgs = new Class[0];
				Constructor<?> cons = serverLoggerClass
						.getConstructor(constructorArgs);
				Object[] args = new Object[0];
				this.serverLogger = (ServerLogger) cons.newInstance(args);
				serverLogger.setSipStack(this);
				serverLogger.setStackProperties(configurationProperties);
			} catch (InvocationTargetException ex1) {
				throw new IllegalArgumentException(
						"Cound not instantiate server logger "
								+ stackLoggerClassName
								+ "- check that it is present on the classpath and that there is a no-args constructor defined",
						ex1);
			} catch (Exception ex) {
				throw new IllegalArgumentException(
						"Cound not instantiate server logger "
								+ stackLoggerClassName
								+ "- check that it is present on the classpath and that there is a no-args constructor defined",
						ex);
			}

		// Default router -- use this for routing SIP URIs.
		// Our router does not do DNS lookups.
		this.outboundProxy = configurationProperties
				.getProperty("javax.sip.OUTBOUND_PROXY");

		this.defaultRouter = new DefaultRouter(this, outboundProxy);

		/** Retrieve the router path */
		String routerPath = configurationProperties
				.getProperty("javax.sip.ROUTER_PATH");
		if (routerPath == null)
			routerPath = "gov.nist.javax.sip.stack.DefaultRouter";

		try {
			Class<?> routerClass = Class.forName(routerPath);
			Class<?>[] constructorArgs = new Class[2];
			constructorArgs[0] = javax.sip.SipStack.class;
			constructorArgs[1] = String.class;
			Constructor<?> cons = routerClass.getConstructor(constructorArgs);
			Object[] args = new Object[2];
			args[0] = (SipStack) this;
			args[1] = outboundProxy;
			Router router = (Router) cons.newInstance(args);
			super.setRouter(router);
		} catch (InvocationTargetException ex1) {
			getStackLogger()
					.logError(
							"could not instantiate router -- invocation target problem",
							(Exception) ex1.getCause());
			throw new PeerUnavailableException(
					"Cound not instantiate router - check constructor", ex1);
		} catch (Exception ex) {
			getStackLogger().logError("could not instantiate router",
					(Exception) ex.getCause());
			throw new PeerUnavailableException("Could not instantiate router",
					ex);
		}

		// The flag that indicates that the default router is to be ignored.
		String useRouterForAll = configurationProperties
				.getProperty("javax.sip.USE_ROUTER_FOR_ALL_URIS");
		this.useRouterForAll = true;
		if (useRouterForAll != null) {
			this.useRouterForAll = "true".equalsIgnoreCase(useRouterForAll);
		}

		/*
		 * Retrieve the EXTENSION Methods. These are used for instantiation of
		 * Dialogs.
		 */
		String extensionMethods = configurationProperties
				.getProperty("javax.sip.EXTENSION_METHODS");

		if (extensionMethods != null) {
			java.util.StringTokenizer st = new java.util.StringTokenizer(
					extensionMethods);
			while (st.hasMoreTokens()) {
				String em = st.nextToken(":");
				if (em.equalsIgnoreCase(Request.BYE)
						|| em.equalsIgnoreCase(Request.INVITE)
						|| em.equalsIgnoreCase(Request.SUBSCRIBE)
						|| em.equalsIgnoreCase(Request.NOTIFY)
						|| em.equalsIgnoreCase(Request.ACK)
						|| em.equalsIgnoreCase(Request.OPTIONS))
					throw new PeerUnavailableException("Bad extension method "
							+ em);
				else
					this.addExtensionMethod(em);
			}
		}
		String keyStoreFile = configurationProperties
				.getProperty("javax.net.ssl.keyStore");
		String trustStoreFile = configurationProperties
				.getProperty("javax.net.ssl.trustStore");
		if (keyStoreFile != null) {
			if (trustStoreFile == null) {
				trustStoreFile = keyStoreFile;
			}
			String keyStorePassword = configurationProperties
					.getProperty("javax.net.ssl.keyStorePassword");
			try {
				this.networkLayer = new SslNetworkLayer(trustStoreFile,
						keyStoreFile, keyStorePassword.toCharArray(),
						configurationProperties
								.getProperty("javax.net.ssl.keyStoreType"));
			} catch (Exception e1) {
				getStackLogger().logError(
						"could not instantiate SSL networking", e1);
			}
		}

		// Set the auto dialog support flag.
		super.isAutomaticDialogSupportEnabled = configurationProperties
				.getProperty("javax.sip.AUTOMATIC_DIALOG_SUPPORT", "on")
				.equalsIgnoreCase("on");

		super.isAutomaticDialogErrorHandlingEnabled = configurationProperties
					.getProperty("gov.nist.javax.sip.AUTOMATIC_DIALOG_ERROR_HANDLING","true")
					.equals(Boolean.TRUE.toString());
		if ( super.isAutomaticDialogSupportEnabled ) {
			super.isAutomaticDialogErrorHandlingEnabled = true;
		}
	
		if (configurationProperties
				.getProperty("gov.nist.javax.sip.MAX_LISTENER_RESPONSE_TIME") != null) {
			super.maxListenerResponseTime = Integer
					.parseInt(configurationProperties
							.getProperty("gov.nist.javax.sip.MAX_LISTENER_RESPONSE_TIME"));
			if (super.maxListenerResponseTime <= 0)
				throw new PeerUnavailableException(
						"Bad configuration parameter gov.nist.javax.sip.MAX_LISTENER_RESPONSE_TIME : should be positive");
		} else {
			super.maxListenerResponseTime = -1;
		}

		

		this.deliverTerminatedEventForAck = configurationProperties
				.getProperty(
						"gov.nist.javax.sip.DELIVER_TERMINATED_EVENT_FOR_ACK",
						"false").equalsIgnoreCase("true");

		this.deliverUnsolicitedNotify = configurationProperties.getProperty(
				"gov.nist.javax.sip.DELIVER_UNSOLICITED_NOTIFY", "false")
				.equalsIgnoreCase("true");

		String forkedSubscriptions = configurationProperties
				.getProperty("javax.sip.FORKABLE_EVENTS");
		if (forkedSubscriptions != null) {
			StringTokenizer st = new StringTokenizer(forkedSubscriptions);
			while (st.hasMoreTokens()) {
				String nextEvent = st.nextToken();
				this.forkedEvents.add(nextEvent);
			}
		}

		// The following features are unique to the NIST implementation.

		/*
		 * gets the NetworkLayer implementation, if any. Note that this is a
		 * NIST only feature.
		 */

		final String NETWORK_LAYER_KEY = "gov.nist.javax.sip.NETWORK_LAYER";

		if (configurationProperties.containsKey(NETWORK_LAYER_KEY)) {
			String path = configurationProperties
					.getProperty(NETWORK_LAYER_KEY);
			try {
				Class<?> clazz = Class.forName(path);
				Constructor<?> c = clazz.getConstructor(new Class[0]);
				networkLayer = (NetworkLayer) c.newInstance(new Object[0]);
			} catch (Exception e) {
				throw new PeerUnavailableException(
						"can't find or instantiate NetworkLayer implementation: "
								+ path);
			}
		}

		final String ADDRESS_RESOLVER_KEY = "gov.nist.javax.sip.ADDRESS_RESOLVER";

		if (configurationProperties.containsKey(ADDRESS_RESOLVER_KEY)) {
			String path = configurationProperties
					.getProperty(ADDRESS_RESOLVER_KEY);
			try {
				Class<?> clazz = Class.forName(path);
				Constructor<?> c = clazz.getConstructor(new Class[0]);
				this.addressResolver = (AddressResolver) c
						.newInstance(new Object[0]);
			} catch (Exception e) {
				throw new PeerUnavailableException(
						"can't find or instantiate AddressResolver implementation: "
								+ path);
			}
		}

		String maxConnections = configurationProperties
				.getProperty("gov.nist.javax.sip.MAX_CONNECTIONS");
		if (maxConnections != null) {
			try {
				this.maxConnections = new Integer(maxConnections).intValue();
			} catch (NumberFormatException ex) {
				if (isLoggingEnabled())
					getStackLogger().logError(
						"max connections - bad value " + ex.getMessage());
			}
		}

		String threadPoolSize = configurationProperties
				.getProperty("gov.nist.javax.sip.THREAD_POOL_SIZE");
		if (threadPoolSize != null) {
			try {
				this.threadPoolSize = new Integer(threadPoolSize).intValue();
			} catch (NumberFormatException ex) {
				if (isLoggingEnabled())
					this.getStackLogger().logError(
						"thread pool size - bad value " + ex.getMessage());
			}
		}

		String serverTransactionTableSize = configurationProperties
				.getProperty("gov.nist.javax.sip.MAX_SERVER_TRANSACTIONS");
		if (serverTransactionTableSize != null) {
			try {
				this.serverTransactionTableHighwaterMark = new Integer(
						serverTransactionTableSize).intValue();
				this.serverTransactionTableLowaterMark = this.serverTransactionTableHighwaterMark * 80 / 100;
				// Lowater is 80% of highwater
			} catch (NumberFormatException ex) {
				if (isLoggingEnabled())
					this.getStackLogger()
						.logError(
								"transaction table size - bad value "
										+ ex.getMessage());
			}
		} else {
			// Issue 256 : consistent with MAX_CLIENT_TRANSACTIONS, if the MAX_SERVER_TRANSACTIONS is not set
			// we assume the transaction table size can grow unlimited
			this.unlimitedServerTransactionTableSize = true;
		}

		String clientTransactionTableSize = configurationProperties
				.getProperty("gov.nist.javax.sip.MAX_CLIENT_TRANSACTIONS");
		if (clientTransactionTableSize != null) {
			try {
				this.clientTransactionTableHiwaterMark = new Integer(
						clientTransactionTableSize).intValue();
				this.clientTransactionTableLowaterMark = this.clientTransactionTableLowaterMark * 80 / 100;
				// Lowater is 80% of highwater
			} catch (NumberFormatException ex) {
				if (isLoggingEnabled())
					this.getStackLogger()
						.logError(
								"transaction table size - bad value "
										+ ex.getMessage());
			}
		} else {
			this.unlimitedClientTransactionTableSize = true;
		}

		super.cacheServerConnections = true;
		String flag = configurationProperties
				.getProperty("gov.nist.javax.sip.CACHE_SERVER_CONNECTIONS");

		if (flag != null && "false".equalsIgnoreCase(flag.trim())) {
			super.cacheServerConnections = false;
		}

		super.cacheClientConnections = true;
		String cacheflag = configurationProperties
				.getProperty("gov.nist.javax.sip.CACHE_CLIENT_CONNECTIONS");

		if (cacheflag != null && "false".equalsIgnoreCase(cacheflag.trim())) {
			super.cacheClientConnections = false;
		}

		String readTimeout = configurationProperties
				.getProperty("gov.nist.javax.sip.READ_TIMEOUT");
		if (readTimeout != null) {
			try {

				int rt = Integer.parseInt(readTimeout);
				if (rt >= 100) {
					super.readTimeout = rt;
				} else {
					System.err.println("Value too low " + readTimeout);
				}
			} catch (NumberFormatException nfe) {
				// Ignore.
				if (isLoggingEnabled())
					getStackLogger().logError("Bad read timeout " + readTimeout);
			}
		}

		// Get the address of the stun server.

		String stunAddr = configurationProperties
				.getProperty("gov.nist.javax.sip.STUN_SERVER");

		if (stunAddr != null)
			this.getStackLogger().logWarning(
					"Ignoring obsolete property "
							+ "gov.nist.javax.sip.STUN_SERVER");

		String maxMsgSize = configurationProperties
				.getProperty("gov.nist.javax.sip.MAX_MESSAGE_SIZE");

		try {
			if (maxMsgSize != null) {
				super.maxMessageSize = new Integer(maxMsgSize).intValue();
				if (super.maxMessageSize < 4096)
					super.maxMessageSize = 4096;
			} else {
				// Allow for "infinite" size of message
				super.maxMessageSize = 0;
			}
		} catch (NumberFormatException ex) {
			if (isLoggingEnabled())
				getStackLogger().logError(
					"maxMessageSize - bad value " + ex.getMessage());
		}

		String rel = configurationProperties
				.getProperty("gov.nist.javax.sip.REENTRANT_LISTENER");
		this.reEntrantListener = (rel != null && "true".equalsIgnoreCase(rel));

		// Check if a thread audit interval is specified
		String interval = configurationProperties
				.getProperty("gov.nist.javax.sip.THREAD_AUDIT_INTERVAL_IN_MILLISECS");
		if (interval != null) {
			try {
				// Make the monitored threads ping the auditor twice as fast as
				// the audits
				getThreadAuditor().setPingIntervalInMillisecs(
						Long.valueOf(interval).longValue() / 2);
			} catch (NumberFormatException ex) {
				if (isLoggingEnabled())
					getStackLogger().logError(
						"THREAD_AUDIT_INTERVAL_IN_MILLISECS - bad value ["
								+ interval + "] " + ex.getMessage());
			}
		}

		// JvB: added property for testing
		this
				.setNon2XXAckPassedToListener(Boolean
						.valueOf(
								configurationProperties
										.getProperty(
												"gov.nist.javax.sip.PASS_INVITE_NON_2XX_ACK_TO_LISTENER",
												"false")).booleanValue());

		this.generateTimeStampHeader = Boolean.valueOf(
				configurationProperties.getProperty(
						"gov.nist.javax.sip.AUTO_GENERATE_TIMESTAMP", "false"))
				.booleanValue();

		String messageLogFactoryClasspath = configurationProperties
				.getProperty("gov.nist.javax.sip.LOG_FACTORY");
		if (messageLogFactoryClasspath != null) {
			try {
				Class<?> clazz = Class.forName(messageLogFactoryClasspath);
				Constructor<?> c = clazz.getConstructor(new Class[0]);
				this.logRecordFactory = (LogRecordFactory) c
						.newInstance(new Object[0]);
			} catch (Exception ex) {
				if (isLoggingEnabled())
					getStackLogger()
						.logError(
								"Bad configuration value for LOG_FACTORY -- using default logger");
				this.logRecordFactory = new DefaultMessageLogFactory();
			}

		} else {
			this.logRecordFactory = new DefaultMessageLogFactory();
		}

		boolean computeContentLength = configurationProperties.getProperty(
				"gov.nist.javax.sip.COMPUTE_CONTENT_LENGTH_FROM_MESSAGE_BODY",
				"false").equalsIgnoreCase("true");
		StringMsgParser
				.setComputeContentLengthFromMessage(computeContentLength);

		String tlsClientProtocols = configurationProperties.getProperty(
				"gov.nist.javax.sip.TLS_CLIENT_PROTOCOLS");
		if (tlsClientProtocols != null)
		{
			StringTokenizer st = new StringTokenizer(tlsClientProtocols, " ,");
			String[] protocols = new String[st.countTokens()];
			
			int i=0;
			while (st.hasMoreTokens()) {
				protocols[i++] = st.nextToken();
			}
			this.enabledProtocols = protocols;
		}

		super.rfc2543Supported = configurationProperties.getProperty(
				"gov.nist.javax.sip.RFC_2543_SUPPORT_ENABLED", "true")
				.equalsIgnoreCase("true");

		super.cancelClientTransactionChecked = configurationProperties
				.getProperty(
						"gov.nist.javax.sip.CANCEL_CLIENT_TRANSACTION_CHECKED",
						"true").equalsIgnoreCase("true");
		super.logStackTraceOnMessageSend = configurationProperties.getProperty(
				"gov.nist.javax.sip.LOG_STACK_TRACE_ON_MESSAGE_SEND", "false")
				.equalsIgnoreCase("true");
		if (isLoggingEnabled())
			getStackLogger().logDebug(
				"created Sip stack. Properties = " + configurationProperties);
		InputStream in = getClass().getResourceAsStream("/TIMESTAMP");
		if (in != null) {
			BufferedReader streamReader = new BufferedReader(
					new InputStreamReader(in));

			try {
				String buildTimeStamp = streamReader.readLine();
				if (in != null) {
					in.close();
				}
				getStackLogger().setBuildTimeStamp(buildTimeStamp);
			} catch (IOException ex) {
				getStackLogger().logError("Could not open build timestamp.");
			}
		}

		String bufferSize = configurationProperties.getProperty(
				"gov.nist.javax.sip.RECEIVE_UDP_BUFFER_SIZE", MAX_DATAGRAM_SIZE
						.toString());
		int bufferSizeInteger = new Integer(bufferSize).intValue();
		super.setReceiveUdpBufferSize(bufferSizeInteger);

		bufferSize = configurationProperties.getProperty(
				"gov.nist.javax.sip.SEND_UDP_BUFFER_SIZE", MAX_DATAGRAM_SIZE
						.toString());
		bufferSizeInteger = new Integer(bufferSize).intValue();
		super.setSendUdpBufferSize(bufferSizeInteger);

		boolean congetstionControlEnabled = Boolean
				.parseBoolean(configurationProperties.getProperty(
						"gov.nist.javax.sip.CONGESTION_CONTROL_ENABLED",
						Boolean.TRUE.toString()));
		super.stackDoesCongestionControl = congetstionControlEnabled;

		super.isBackToBackUserAgent = Boolean
				.parseBoolean(configurationProperties.getProperty(
						"gov.nist.javax.sip.IS_BACK_TO_BACK_USER_AGENT",
						Boolean.FALSE.toString()));
		super.checkBranchId = Boolean.parseBoolean(configurationProperties
				.getProperty("gov.nist.javax.sip.REJECT_STRAY_RESPONSES",
						Boolean.FALSE.toString()));
		
		super.isDialogTerminatedEventDeliveredForNullDialog = (Boolean.parseBoolean(configurationProperties.getProperty("gov.nist.javax.sip.DELIVER_TERMINATED_EVENT_FOR_NULL_DIALOG",
		        Boolean.FALSE.toString())));
		
		
		super.maxForkTime = Integer.parseInt(
		        configurationProperties.getProperty("gov.nist.javax.sip.MAX_FORK_TIME_SECONDS","0"));
		
	}

	/**
	 * ReInitialize the stack instance.
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:41.610 -0500", hash_original_method = "4F314CDF94BE73A82A3392DB747CDD4B", hash_generated_method = "873F6E29B2A7D42140DFD4860764E1F5")
	
private void reInitialize() {
		super.reInit();
		this.eventScanner = new EventScanner(this);
		this.listeningPoints = new Hashtable<String, ListeningPointImpl>();
		this.sipProviders = new LinkedList<SipProviderImpl>();
		this.sipListener = null;

	}

	/**
	 * Return true if automatic dialog support is enabled for this stack.
	 * 
	 * @return boolean, true if automatic dialog support is enabled for this
	 *         stack
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:41.612 -0500", hash_original_method = "1B8FCD54ED5E137B1A38ACB963DE1ED8", hash_generated_method = "1B8FCD54ED5E137B1A38ACB963DE1ED8")
	
boolean isAutomaticDialogSupportEnabled() {
		return super.isAutomaticDialogSupportEnabled;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.sip.SipStack#createListeningPoint(java.lang.String, int,
	 * java.lang.String)
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:41.628 -0500", hash_original_method = "20194A28F7CD206898B50945BA95F1CA", hash_generated_method = "669CAF6AD7E3C887112FB3DF071280FE")
	
public synchronized ListeningPoint createListeningPoint(String address,
			int port, String transport) throws TransportNotSupportedException,
			InvalidArgumentException {
		if (isLoggingEnabled())
			getStackLogger().logDebug(
				"createListeningPoint : address = " + address + " port = "
						+ port + " transport = " + transport);

		if (address == null)
			throw new NullPointerException(
					"Address for listening point is null!");
		if (transport == null)
			throw new NullPointerException("null transport");
		if (port <= 0)
			throw new InvalidArgumentException("bad port");

		if (!transport.equalsIgnoreCase("UDP")
				&& !transport.equalsIgnoreCase("TLS")
				&& !transport.equalsIgnoreCase("TCP")
				&& !transport.equalsIgnoreCase("SCTP"))
			throw new TransportNotSupportedException("bad transport "
					+ transport);

		/** Reusing an old stack instance */
		if (!this.isAlive()) {
			this.toExit = false;
			this.reInitialize();
		}

		String key = ListeningPointImpl.makeKey(address, port, transport);

		ListeningPointImpl lip = (ListeningPointImpl) listeningPoints.get(key);
		if (lip != null) {
			return lip;
		} else {
			try {
				InetAddress inetAddr = InetAddress.getByName(address);
				MessageProcessor messageProcessor = this
						.createMessageProcessor(inetAddr, port, transport);
				if (this.isLoggingEnabled()) {
					this.getStackLogger().logDebug(
							"Created Message Processor: " + address
									+ " port = " + port + " transport = "
									+ transport);
				}
				lip = new ListeningPointImpl(this, port, transport);
				lip.messageProcessor = messageProcessor;
				messageProcessor.setListeningPoint(lip);
				this.listeningPoints.put(key, lip);
				// start processing messages.
				messageProcessor.start();
				return (ListeningPoint) lip;
			} catch (java.io.IOException ex) {
				if (isLoggingEnabled())
					getStackLogger().logError(
						"Invalid argument address = " + address + " port = "
								+ port + " transport = " + transport);
				throw new InvalidArgumentException(ex.getMessage(), ex);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.sip.SipStack#createSipProvider(javax.sip.ListeningPoint)
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:41.631 -0500", hash_original_method = "BBB69BC5565AF0A227A798564DF93404", hash_generated_method = "ED75EB15C897AE04B37A90E28D617156")
	
public SipProvider createSipProvider(ListeningPoint listeningPoint)
			throws ObjectInUseException {
		if (listeningPoint == null)
			throw new NullPointerException("null listeningPoint");
		if (this.isLoggingEnabled())
			this.getStackLogger().logDebug(
					"createSipProvider: " + listeningPoint);
		ListeningPointImpl listeningPointImpl = (ListeningPointImpl) listeningPoint;
		if (listeningPointImpl.sipProvider != null)
			throw new ObjectInUseException("Provider already attached!");

		SipProviderImpl provider = new SipProviderImpl(this);

		provider.setListeningPoint(listeningPointImpl);
		listeningPointImpl.sipProvider = provider;
		this.sipProviders.add(provider);
		return provider;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.sip.SipStack#deleteListeningPoint(javax.sip.ListeningPoint)
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:41.634 -0500", hash_original_method = "A92DFE7C9B9D7EE522B2B525B8C69A65", hash_generated_method = "C6DE48921302F63DFF9C6307E4D3918B")
	
public void deleteListeningPoint(ListeningPoint listeningPoint)
			throws ObjectInUseException {
		if (listeningPoint == null)
			throw new NullPointerException("null listeningPoint arg");
		ListeningPointImpl lip = (ListeningPointImpl) listeningPoint;
		// Stop the message processing thread in the listening point.
		super.removeMessageProcessor(lip.messageProcessor);
		String key = lip.getKey();
		this.listeningPoints.remove(key);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.sip.SipStack#deleteSipProvider(javax.sip.SipProvider)
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:41.637 -0500", hash_original_method = "0933EE30851621D7E3F65B407D39A5B8", hash_generated_method = "B03BDFE3074B82772805532DFA76B17C")
	
public void deleteSipProvider(SipProvider sipProvider)
			throws ObjectInUseException {

		if (sipProvider == null)
			throw new NullPointerException("null provider arg");
		SipProviderImpl sipProviderImpl = (SipProviderImpl) sipProvider;

		// JvB: API doc is not clear, but in_use ==
		// sipProviderImpl.sipListener!=null
		// so we should throw if app did not call removeSipListener
		// sipProviderImpl.sipListener = null;
		if (sipProviderImpl.getSipListener() != null) {
			throw new ObjectInUseException(
					"SipProvider still has an associated SipListener!");
		}

		sipProviderImpl.removeListeningPoints();

		// Bug reported by Rafael Barriuso
		sipProviderImpl.stop();
		sipProviders.remove(sipProvider);
		if (sipProviders.isEmpty()) {
			this.stopStack();
		}
	}

	/**
	 * Get the IP Address of the stack.
	 * 
	 * @see javax.sip.SipStack#getIPAddress()
	 * @deprecated
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:41.640 -0500", hash_original_method = "81685A4D06B7F9B5E6CCB2DE2C1BD9F0", hash_generated_method = "3FCB29A879796788E0D660F1D5F0287A")
	
public String getIPAddress() {
		return super.getHostAddress();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.sip.SipStack#getListeningPoints()
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:41.642 -0500", hash_original_method = "287349EDD4D46CE4DB7C5F6D8E2D772E", hash_generated_method = "C4A044E2D05BB74F932C795398C1AB93")
	
public java.util.Iterator getListeningPoints() {
		return this.listeningPoints.values().iterator();
	}

	/**
	 * Return true if retransmission filter is active.
	 * 
	 * @see javax.sip.SipStack#isRetransmissionFilterActive()
	 * @deprecated
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:41.645 -0500", hash_original_method = "BCFD29C2FE3D7BF7BBC15432578BF66F", hash_generated_method = "4FEA5BAF7761C27311CDD7D7CA310926")
	
public boolean isRetransmissionFilterActive() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.sip.SipStack#getSipProviders()
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:41.647 -0500", hash_original_method = "88A6DC9DED9CE5F7635E348CD4A3C5F8", hash_generated_method = "99C037C51F80037D9165675CE1D386BD")
	
public java.util.Iterator<SipProviderImpl> getSipProviders() {
		return this.sipProviders.iterator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.sip.SipStack#getStackName()
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:41.650 -0500", hash_original_method = "98CDA556C50A8E057D89E8EADBB5B35E", hash_generated_method = "B8626D5DB02CCCFA3FFB57D151DD02D1")
	
public String getStackName() {
		return this.stackName;
	}

	/**
	 * Finalization -- stop the stack on finalization. Exit the transaction
	 * scanner and release all resources.
	 * 
	 * @see java.lang.Object#finalize()
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:41.652 -0500", hash_original_method = "E5E5510E122401D8059641DFB570004B", hash_generated_method = "3DE78C565F73DA56CFFAB5CDE44EF625")
	
protected void finalize() {
		this.stopStack();
	}

	/**
	 * This uses the default stack address to create a listening point.
	 * 
	 * @see javax.sip.SipStack#createListeningPoint(java.lang.String, int,
	 *      java.lang.String)
	 * @deprecated
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:41.655 -0500", hash_original_method = "E9BAFB829F6434607FADA475E44C9773", hash_generated_method = "61E86E51AB142C9AB603C2EE2DC86D2A")
	
public ListeningPoint createListeningPoint(int port, String transport)
			throws TransportNotSupportedException, InvalidArgumentException {
		if (super.stackAddress == null)
			throw new NullPointerException(
					"Stack does not have a default IP Address!");
		return this.createListeningPoint(super.stackAddress, port, transport);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.sip.SipStack#stop()
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:41.657 -0500", hash_original_method = "8379090E51BF18D65A472A61653181B8", hash_generated_method = "96E645A22524865976A29AB8F877DE4D")
	
public void stop() {
		if (isLoggingEnabled()) {
			getStackLogger().logDebug("stopStack -- stoppping the stack");
		}
		this.stopStack();
		this.sipProviders = new LinkedList<SipProviderImpl>();
		this.listeningPoints = new Hashtable<String, ListeningPointImpl>();
		/*
		 * Check for presence of an event scanner ( may happen if stack is
		 * stopped before listener is attached ).
		 */
		if (this.eventScanner != null)
			this.eventScanner.forceStop();
		this.eventScanner = null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.sip.SipStack#start()
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:41.660 -0500", hash_original_method = "64980175D45C88025DB0BF7ED31DD55C", hash_generated_method = "DE5F568AB97EC2170F09BD059D7E21FB")
	
public void start() throws ProviderDoesNotExistException, SipException {
		// Start a new event scanner if one does not exist.
		if (this.eventScanner == null) {
			this.eventScanner = new EventScanner(this);
		}

	}

	/**
	 * Get the listener for the stack. A stack can have only one listener. To
	 * get an event from a provider, the listener has to be registered with the
	 * provider. The SipListener is application code.
	 * 
	 * @return -- the stack SipListener
	 * 
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:41.663 -0500", hash_original_method = "007AB23FB90DEFAA901334391BCA8574", hash_generated_method = "1EDE2942A56DCC6F94B54FC9E7276D02")
	
public SipListener getSipListener() {
		return this.sipListener;
	}

	/**
	 * Get the message log factory registered with the stack.
	 * 
	 * @return -- the messageLogFactory of the stack.
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:41.665 -0500", hash_original_method = "41341CEB98E5DA012DCAACB9910CCA31", hash_generated_method = "398B161D7AFEA30AA4E99EFF2C24F6E4")
	
public LogRecordFactory getLogRecordFactory() {
		return super.logRecordFactory;
	}

	/**
	 * Set the log appender ( this is useful if you want to specify a particular
	 * log format or log to something other than a file for example). This method
	 * is will be removed May 11, 2010 or shortly there after.
	 * 
	 * @param Appender
	 *            - the log4j appender to add.
	 * @deprecated TODO: remove this method May 11, 2010.
	 */
        // BEGIN android-deleted
	/*
        @Deprecated
	public void addLogAppender(org.apache.log4j.Appender appender) {
		if (this.getStackLogger() instanceof gov.nist.core.LogWriter) {
			((gov.nist.core.LogWriter) this.getStackLogger()).addAppender(appender);
		}
	}
        */
        // END android-deleted

	/**
	 * Get the log4j logger ( for log stream integration ).
	 * This method will be removed May 11, 2010 or shortly there after.
	 * 
	 * @return  the log4j logger.
	 * @deprecated TODO: This method will be removed May 11, 2010.
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:41.667 -0500", hash_original_method = "DD6917F16C5DC825A79D8F74525C77AA", hash_generated_method = "3F5155FA615770326CAC12881792C099")
	
@Deprecated
        // BEGIN andoird-deleted
        /*
	public org.apache.log4j.Logger getLogger() {
		if (this.getStackLogger() instanceof gov.nist.core.LogWriter) {
			return ((gov.nist.core.LogWriter) this.getStackLogger()).getLogger();
		}
		return null;
	}
        */
        // END android-deleted

	public EventScanner getEventScanner() {
		return eventScanner;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gov.nist.javax.sip.SipStackExt#getAuthenticationHelper(gov.nist.javax
	 * .sip.clientauthutils.AccountManager, javax.sip.header.HeaderFactory)
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:41.670 -0500", hash_original_method = "DDBB9B823124CA2B241AC7D56A934729", hash_generated_method = "E9106E527CEC1456C6DCAED2D1E3F1B8")
	
public AuthenticationHelper getAuthenticationHelper(
			AccountManager accountManager, HeaderFactory headerFactory) {
		return new AuthenticationHelperImpl(this, accountManager, headerFactory);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * gov.nist.javax.sip.SipStackExt#getAuthenticationHelper(gov.nist.javax
	 * .sip.clientauthutils.AccountManager, javax.sip.header.HeaderFactory)
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:41.672 -0500", hash_original_method = "9BC4A63758F96D1DFC890C8072E9A8F9", hash_generated_method = "A094C07BC0B5B3898DEA26F2F72B2B4F")
	
public AuthenticationHelper getSecureAuthenticationHelper(
			SecureAccountManager accountManager, HeaderFactory headerFactory) {
		return new AuthenticationHelperImpl(this, accountManager, headerFactory);
	}

	/**
	 * Set the list of cipher suites supported by the stack. A stack can have
	 * only one set of suites. These are not validated against the supported
	 * cipher suites of the java runtime, so specifying a cipher here does not
	 * guarantee that it will work.<br>
	 * The stack has a default cipher suite of:
	 * <ul>
	 * <li>TLS_RSA_WITH_AES_128_CBC_SHA</li>
	 * <li>SSL_RSA_WITH_3DES_EDE_CBC_SHA</li>
	 * <li>TLS_DH_anon_WITH_AES_128_CBC_SHA</li>
	 * <li>SSL_DH_anon_WITH_3DES_EDE_CBC_SHA</li>
	 * </ul>
	 * 
	 * <b>NOTE: This function must be called before adding a TLS listener</b>
	 * 
	 * @param String
	 *            [] The new set of ciphers to support.
	 * @return
	 * 
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:41.675 -0500", hash_original_method = "23CB36659469F37B2B1A4E89C6C5A109", hash_generated_method = "260B2AE320616E51DAC2FD8FB1250639")
	
public void setEnabledCipherSuites(String[] newCipherSuites) {
		cipherSuites = newCipherSuites;
	}

	/**
	 * Return the currently enabled cipher suites of the Stack.
	 * 
	 * @return The currently enabled cipher suites.
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:41.677 -0500", hash_original_method = "15C35F67057574B0384681051DA88AFD", hash_generated_method = "6EA108A4A8E52057B8581D69859CD646")
	
public String[] getEnabledCipherSuites() {
		return cipherSuites;
	}

	/**
	 * Set the list of protocols supported by the stack for outgoing TLS connections.
	 * A stack can have only one set of protocols.
	 * These are not validated against the supported
	 * protocols of the java runtime, so specifying a protocol here does not
	 * guarantee that it will work.<br>
	 * The stack has a default protocol suite of:
	 * <ul>
	 * <li>SSLv3</li>
	 * <li>SSLv2Hello</li>
	 * <li>TLSv1</li>
	 * </ul>
	 * 
	 * <b>NOTE: This function must be called before creating a TLSMessageChannel.</b>
	 * 
	 * @param String
	 *            [] The new set of protocols to use for outgoing TLS connections.
	 * @return
	 * 
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:41.680 -0500", hash_original_method = "146720FA6D9E688CD139244E691C1622", hash_generated_method = "ECD58E5D112584783CFCD37626E9E765")
	
public void setEnabledProtocols(String[] newProtocols) {
		enabledProtocols = newProtocols;
	}

	/**
	 * Return the currently enabled protocols to use when creating TLS connection.
	 * 
	 * @return The currently enabled protocols.
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:41.682 -0500", hash_original_method = "36B040AE4C1B32E20301E5CF570A7C53", hash_generated_method = "C0D2C7F9B9343B90BB8EB0FBED0208A4")
	
public String[] getEnabledProtocols() {
		return enabledProtocols;
	}

	/**
	 * Set the "back to back User Agent" flag.
	 * 
	 * @param flag
	 *            - boolean flag to set.
	 * 
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:41.686 -0500", hash_original_method = "B3A8DF498FA0698B770F05249042765A", hash_generated_method = "B8CA6C7717D869C348E9BD04C2B89E95")
	
public void setIsBackToBackUserAgent(boolean flag) {
		super.isBackToBackUserAgent = flag;
	}
	
	/**
	 * Get the "back to back User Agent" flag.
	 * 
	 * return the value of the flag
	 * 
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:41.688 -0500", hash_original_method = "1623111994CBCA0890DA0FF2A1E140E0", hash_generated_method = "478ACA79A313929F4EF55B9242DEEF4D")
	
public boolean isBackToBackUserAgent() {
		return super.isBackToBackUserAgent;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:41.691 -0500", hash_original_method = "8A30592F142C300BD40BD8A31AEE1D8D", hash_generated_method = "A8563BAF693F06C7A30FFEBF01335795")
	
public boolean isAutomaticDialogErrorHandlingEnabled() {
		return super.isAutomaticDialogErrorHandlingEnabled;
	}

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:41.693 -0500", hash_original_method = "1CDF5A6FEBA76AB1A61A70742324066C", hash_generated_method = "78E90ECF2D1A092A4D4363FB364CD229")
	
public boolean acquireSem() {
        try {
            return this.stackSemaphore.tryAcquire(10, TimeUnit.SECONDS);
        } catch ( InterruptedException ex) {
            return false;
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:41.695 -0500", hash_original_method = "2B4EDB484E691FD8761CF130C9353BAF", hash_generated_method = "6A034943569B82E228D92E04675D28EA")
	
public void releaseSem() {
        this.stackSemaphore.release();
    }
}

