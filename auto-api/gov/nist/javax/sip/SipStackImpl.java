package gov.nist.javax.sip;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.999 -0400", hash_original_field = "0C887D575D34CEEB43215C9C2EB3F7E0", hash_generated_field = "B13D933CCB9027F950F0F782A6866769")

    private EventScanner eventScanner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.999 -0400", hash_original_field = "3CEAB7318649FC55E6D462942E769E7E", hash_generated_field = "3AEF05BEBD52A17EF95A5D808F4FFFA4")

    private Hashtable<String, ListeningPointImpl> listeningPoints;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.999 -0400", hash_original_field = "70438560708F29EEC903E8857CAD5F87", hash_generated_field = "4D9EE92C5E84922DC5B8DC3AD8BDEAEF")

    private LinkedList<SipProviderImpl> sipProviders;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.999 -0400", hash_original_field = "1E7A0E62B6D1C3ABE8645330F49CA7A4", hash_generated_field = "C05D7B5683B60CB11426E6CCECD30C55")

    boolean reEntrantListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.999 -0400", hash_original_field = "C2742B0786D982D4EE3DCECCEC00E889", hash_generated_field = "B9D95CF1DDB3EF5E2FB32454D5FBE60B")

    SipListener sipListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.999 -0400", hash_original_field = "9AFB2542ACFDA41CD0B947306A200374", hash_generated_field = "14BC1D7F6107A47B988CB81CBFA69682")

    boolean deliverTerminatedEventForAck = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.999 -0400", hash_original_field = "E7CFB3101E29334B0125A1F7E7C03AD9", hash_generated_field = "30FBBF692AD048CF0FD21C922D56959C")

    boolean deliverUnsolicitedNotify = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.999 -0400", hash_original_field = "FFD25253325702F7B54013D4F86C77C7", hash_generated_field = "3D24F5BF02841FC581DDB4BFBB9A4EDB")

    private Semaphore stackSemaphore = new Semaphore(1);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.999 -0400", hash_original_field = "CC92C21F17FEFA346C3D963B8A88779D", hash_generated_field = "93F48895C4F48861DEB454B4E221258D")

    private String[] cipherSuites = {
			"TLS_RSA_WITH_AES_128_CBC_SHA", 
											
			
			"SSL_RSA_WITH_3DES_EDE_CBC_SHA", 

			
			
			"TLS_DH_anon_WITH_AES_128_CBC_SHA",
			"SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:37.999 -0400", hash_original_field = "09CE383C325D1DAAE0EF1312788048B5", hash_generated_field = "8206EF99B37B84E105B4852E2EE7C8F0")

    private String[] enabledProtocols = {
			"SSLv3",
			"SSLv2Hello",
			"TLSv1"
	};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.000 -0400", hash_original_method = "BD80EAD073CED4ACABB1B92EBB481070", hash_generated_method = "61A3FAE21B49746705B2C029ACAAFB9F")
    protected  SipStackImpl() {
        super();
        NistSipMessageFactoryImpl msgFactory = new NistSipMessageFactoryImpl(
				this);
        super.setMessageFactory(msgFactory);
        this.eventScanner = new EventScanner(this);
        this.listeningPoints = new Hashtable<String, ListeningPointImpl>();
        this.sipProviders = new LinkedList<SipProviderImpl>();
        
        
				
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.005 -0400", hash_original_method = "31E9570F9C2C0C73DA51527B7C89A7AA", hash_generated_method = "2837A47D99E071BA74772246998283DB")
    public  SipStackImpl(Properties configurationProperties) throws PeerUnavailableException {
        this();
        String address = configurationProperties
				.getProperty("javax.sip.IP_ADDRESS");
        try 
        {
            {
                super.setHostAddress(address);
            } 
        } 
        catch (java.net.UnknownHostException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new PeerUnavailableException("bad address " + address);
        } 
        String name = configurationProperties
				.getProperty("javax.sip.STACK_NAME");
        if (DroidSafeAndroidRuntime.control) throw new PeerUnavailableException("stack name is missing");
        super.setStackName(name);
        String stackLoggerClassName = configurationProperties
				.getProperty("gov.nist.javax.sip.STACK_LOGGER");
        stackLoggerClassName = "gov.nist.core.LogWriter";
        try 
        {
            Class<?> stackLoggerClass = Class.forName(stackLoggerClassName);
            Class<?>[] constructorArgs = new Class[0];
            Constructor<?> cons = stackLoggerClass
						.getConstructor(constructorArgs);
            Object[] args = new Object[0];
            StackLogger stackLogger = (StackLogger) cons.newInstance(args);
            stackLogger.setStackProperties(configurationProperties);
            super.setStackLogger(stackLogger);
        } 
        catch (InvocationTargetException ex1)
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
						"Cound not instantiate stack logger "
								+ stackLoggerClassName
								+ "- check that it is present on the classpath and that there is a no-args constructor defined",
						ex1);
        } 
        catch (Exception ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
						"Cound not instantiate stack logger "
								+ stackLoggerClassName
								+ "- check that it is present on the classpath and that there is a no-args constructor defined",
						ex);
        } 
        String serverLoggerClassName = configurationProperties
				.getProperty("gov.nist.javax.sip.SERVER_LOGGER");
        serverLoggerClassName = "gov.nist.javax.sip.stack.ServerLog";
        try 
        {
            Class<?> serverLoggerClass = Class
						.forName(serverLoggerClassName);
            Class<?>[] constructorArgs = new Class[0];
            Constructor<?> cons = serverLoggerClass
						.getConstructor(constructorArgs);
            Object[] args = new Object[0];
            this.serverLogger = (ServerLogger) cons.newInstance(args);
            serverLogger.setSipStack(this);
            serverLogger.setStackProperties(configurationProperties);
        } 
        catch (InvocationTargetException ex1)
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
						"Cound not instantiate server logger "
								+ stackLoggerClassName
								+ "- check that it is present on the classpath and that there is a no-args constructor defined",
						ex1);
        } 
        catch (Exception ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
						"Cound not instantiate server logger "
								+ stackLoggerClassName
								+ "- check that it is present on the classpath and that there is a no-args constructor defined",
						ex);
        } 
        this.outboundProxy = configurationProperties
				.getProperty("javax.sip.OUTBOUND_PROXY");
        this.defaultRouter = new DefaultRouter(this, outboundProxy);
        String routerPath = configurationProperties
				.getProperty("javax.sip.ROUTER_PATH");
        routerPath = "gov.nist.javax.sip.stack.DefaultRouter";
        try 
        {
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
        } 
        catch (InvocationTargetException ex1)
        {
            getStackLogger()
					.logError(
							"could not instantiate router -- invocation target problem",
							(Exception) ex1.getCause());
            if (DroidSafeAndroidRuntime.control) throw new PeerUnavailableException(
					"Cound not instantiate router - check constructor", ex1);
        } 
        catch (Exception ex)
        {
            getStackLogger().logError("could not instantiate router",
					(Exception) ex.getCause());
            if (DroidSafeAndroidRuntime.control) throw new PeerUnavailableException("Could not instantiate router",
					ex);
        } 
        String useRouterForAll = configurationProperties
				.getProperty("javax.sip.USE_ROUTER_FOR_ALL_URIS");
        this.useRouterForAll = true;
        {
            this.useRouterForAll = "true".equalsIgnoreCase(useRouterForAll);
        } 
        String extensionMethods = configurationProperties
				.getProperty("javax.sip.EXTENSION_METHODS");
        {
            java.util.StringTokenizer st = new java.util.StringTokenizer(
					extensionMethods);
            {
                boolean varA9BBA9119DD90070115272E6F9D4D419_605003359 = (st.hasMoreTokens());
                {
                    String em = st.nextToken(":");
                    {
                        boolean var1C9F764402151B0CADD6690CAF645002_1303071658 = (em.equalsIgnoreCase(Request.BYE)
						|| em.equalsIgnoreCase(Request.INVITE)
						|| em.equalsIgnoreCase(Request.SUBSCRIBE)
						|| em.equalsIgnoreCase(Request.NOTIFY)
						|| em.equalsIgnoreCase(Request.ACK)
						|| em.equalsIgnoreCase(Request.OPTIONS));
                        if (DroidSafeAndroidRuntime.control) throw new PeerUnavailableException("Bad extension method "
							+ em);
                        this.addExtensionMethod(em);
                    } 
                } 
            } 
        } 
        String keyStoreFile = configurationProperties
				.getProperty("javax.net.ssl.keyStore");
        String trustStoreFile = configurationProperties
				.getProperty("javax.net.ssl.trustStore");
        {
            {
                trustStoreFile = keyStoreFile;
            } 
            String keyStorePassword = configurationProperties
					.getProperty("javax.net.ssl.keyStorePassword");
            try 
            {
                this.networkLayer = new SslNetworkLayer(trustStoreFile,
						keyStoreFile, keyStorePassword.toCharArray(),
						configurationProperties
								.getProperty("javax.net.ssl.keyStoreType"));
            } 
            catch (Exception e1)
            {
                getStackLogger().logError(
						"could not instantiate SSL networking", e1);
            } 
        } 
        super.isAutomaticDialogSupportEnabled = configurationProperties
				.getProperty("javax.sip.AUTOMATIC_DIALOG_SUPPORT", "on")
				.equalsIgnoreCase("on");
        super.isAutomaticDialogErrorHandlingEnabled = configurationProperties
					.getProperty("gov.nist.javax.sip.AUTOMATIC_DIALOG_ERROR_HANDLING","true")
					.equals(Boolean.TRUE.toString());
        {
            super.isAutomaticDialogErrorHandlingEnabled = true;
        } 
        {
            boolean var1C3541C2E25E99D1D76736CA13213A2E_1467328893 = (configurationProperties
				.getProperty("gov.nist.javax.sip.MAX_LISTENER_RESPONSE_TIME") != null);
            {
                super.maxListenerResponseTime = Integer
					.parseInt(configurationProperties
							.getProperty("gov.nist.javax.sip.MAX_LISTENER_RESPONSE_TIME"));
                if (DroidSafeAndroidRuntime.control) throw new PeerUnavailableException(
						"Bad configuration parameter gov.nist.javax.sip.MAX_LISTENER_RESPONSE_TIME : should be positive");
            } 
            {
                super.maxListenerResponseTime = -1;
            } 
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
        {
            StringTokenizer st = new StringTokenizer(forkedSubscriptions);
            {
                boolean varA9BBA9119DD90070115272E6F9D4D419_1858158947 = (st.hasMoreTokens());
                {
                    String nextEvent = st.nextToken();
                    this.forkedEvents.add(nextEvent);
                } 
            } 
        } 
        final String NETWORK_LAYER_KEY = "gov.nist.javax.sip.NETWORK_LAYER";
        {
            boolean varF258C0FAA8E1F85954E47A799F455F6E_430247571 = (configurationProperties.containsKey(NETWORK_LAYER_KEY));
            {
                String path = configurationProperties
					.getProperty(NETWORK_LAYER_KEY);
                try 
                {
                    Class<?> clazz = Class.forName(path);
                    Constructor<?> c = clazz.getConstructor(new Class[0]);
                    networkLayer = (NetworkLayer) c.newInstance(new Object[0]);
                } 
                catch (Exception e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new PeerUnavailableException(
						"can't find or instantiate NetworkLayer implementation: "
								+ path);
                } 
            } 
        } 
        final String ADDRESS_RESOLVER_KEY = "gov.nist.javax.sip.ADDRESS_RESOLVER";
        {
            boolean var886A0DD9CBB41591ABEEBB662D860AF3_877824847 = (configurationProperties.containsKey(ADDRESS_RESOLVER_KEY));
            {
                String path = configurationProperties
					.getProperty(ADDRESS_RESOLVER_KEY);
                try 
                {
                    Class<?> clazz = Class.forName(path);
                    Constructor<?> c = clazz.getConstructor(new Class[0]);
                    this.addressResolver = (AddressResolver) c
						.newInstance(new Object[0]);
                } 
                catch (Exception e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new PeerUnavailableException(
						"can't find or instantiate AddressResolver implementation: "
								+ path);
                } 
            } 
        } 
        String maxConnections = configurationProperties
				.getProperty("gov.nist.javax.sip.MAX_CONNECTIONS");
        {
            try 
            {
                this.maxConnections = new Integer(maxConnections).intValue();
            } 
            catch (NumberFormatException ex)
            {
                {
                    boolean var31F413A3670DDB7C3047C6D6166E3CCF_2023973577 = (isLoggingEnabled());
                    getStackLogger().logError(
						"max connections - bad value " + ex.getMessage());
                } 
            } 
        } 
        String threadPoolSize = configurationProperties
				.getProperty("gov.nist.javax.sip.THREAD_POOL_SIZE");
        {
            try 
            {
                this.threadPoolSize = new Integer(threadPoolSize).intValue();
            } 
            catch (NumberFormatException ex)
            {
                {
                    boolean var31F413A3670DDB7C3047C6D6166E3CCF_1784291241 = (isLoggingEnabled());
                    this.getStackLogger().logError(
						"thread pool size - bad value " + ex.getMessage());
                } 
            } 
        } 
        String serverTransactionTableSize = configurationProperties
				.getProperty("gov.nist.javax.sip.MAX_SERVER_TRANSACTIONS");
        {
            try 
            {
                this.serverTransactionTableHighwaterMark = new Integer(
						serverTransactionTableSize).intValue();
                this.serverTransactionTableLowaterMark = this.serverTransactionTableHighwaterMark * 80 / 100;
            } 
            catch (NumberFormatException ex)
            {
                {
                    boolean var31F413A3670DDB7C3047C6D6166E3CCF_134533143 = (isLoggingEnabled());
                    this.getStackLogger()
						.logError(
								"transaction table size - bad value "
										+ ex.getMessage());
                } 
            } 
        } 
        {
            this.unlimitedServerTransactionTableSize = true;
        } 
        String clientTransactionTableSize = configurationProperties
				.getProperty("gov.nist.javax.sip.MAX_CLIENT_TRANSACTIONS");
        {
            try 
            {
                this.clientTransactionTableHiwaterMark = new Integer(
						clientTransactionTableSize).intValue();
                this.clientTransactionTableLowaterMark = this.clientTransactionTableLowaterMark * 80 / 100;
            } 
            catch (NumberFormatException ex)
            {
                {
                    boolean var31F413A3670DDB7C3047C6D6166E3CCF_209636312 = (isLoggingEnabled());
                    this.getStackLogger()
						.logError(
								"transaction table size - bad value "
										+ ex.getMessage());
                } 
            } 
        } 
        {
            this.unlimitedClientTransactionTableSize = true;
        } 
        super.cacheServerConnections = true;
        String flag = configurationProperties
				.getProperty("gov.nist.javax.sip.CACHE_SERVER_CONNECTIONS");
        {
            boolean var62D017072D65FD1D09DBD7F6061DE1CE_451957681 = (flag != null && "false".equalsIgnoreCase(flag.trim()));
            {
                super.cacheServerConnections = false;
            } 
        } 
        super.cacheClientConnections = true;
        String cacheflag = configurationProperties
				.getProperty("gov.nist.javax.sip.CACHE_CLIENT_CONNECTIONS");
        {
            boolean var5C60FBB93A7763124F4B58FC1DB64B9C_511771354 = (cacheflag != null && "false".equalsIgnoreCase(cacheflag.trim()));
            {
                super.cacheClientConnections = false;
            } 
        } 
        String readTimeout = configurationProperties
				.getProperty("gov.nist.javax.sip.READ_TIMEOUT");
        {
            try 
            {
                int rt = Integer.parseInt(readTimeout);
                {
                    super.readTimeout = rt;
                } 
                {
                    System.err.println("Value too low " + readTimeout);
                } 
            } 
            catch (NumberFormatException nfe)
            {
                {
                    boolean var31F413A3670DDB7C3047C6D6166E3CCF_1554621331 = (isLoggingEnabled());
                    getStackLogger().logError("Bad read timeout " + readTimeout);
                } 
            } 
        } 
        String stunAddr = configurationProperties
				.getProperty("gov.nist.javax.sip.STUN_SERVER");
        this.getStackLogger().logWarning(
					"Ignoring obsolete property "
							+ "gov.nist.javax.sip.STUN_SERVER");
        String maxMsgSize = configurationProperties
				.getProperty("gov.nist.javax.sip.MAX_MESSAGE_SIZE");
        try 
        {
            {
                super.maxMessageSize = new Integer(maxMsgSize).intValue();
                super.maxMessageSize = 4096;
            } 
            {
                super.maxMessageSize = 0;
            } 
        } 
        catch (NumberFormatException ex)
        {
            {
                boolean var3AA2E1654FE39F4FB102DBD7DEE5C388_1990095697 = (isLoggingEnabled());
                getStackLogger().logError(
					"maxMessageSize - bad value " + ex.getMessage());
            } 
        } 
        String rel = configurationProperties
				.getProperty("gov.nist.javax.sip.REENTRANT_LISTENER");
        this.reEntrantListener = (rel != null && "true".equalsIgnoreCase(rel));
        String interval = configurationProperties
				.getProperty("gov.nist.javax.sip.THREAD_AUDIT_INTERVAL_IN_MILLISECS");
        {
            try 
            {
                getThreadAuditor().setPingIntervalInMillisecs(
						Long.valueOf(interval).longValue() / 2);
            } 
            catch (NumberFormatException ex)
            {
                {
                    boolean var31F413A3670DDB7C3047C6D6166E3CCF_1528211975 = (isLoggingEnabled());
                    getStackLogger().logError(
						"THREAD_AUDIT_INTERVAL_IN_MILLISECS - bad value ["
								+ interval + "] " + ex.getMessage());
                } 
            } 
        } 
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
        {
            try 
            {
                Class<?> clazz = Class.forName(messageLogFactoryClasspath);
                Constructor<?> c = clazz.getConstructor(new Class[0]);
                this.logRecordFactory = (LogRecordFactory) c
						.newInstance(new Object[0]);
            } 
            catch (Exception ex)
            {
                {
                    boolean var31F413A3670DDB7C3047C6D6166E3CCF_669142636 = (isLoggingEnabled());
                    getStackLogger()
						.logError(
								"Bad configuration value for LOG_FACTORY -- using default logger");
                } 
                this.logRecordFactory = new DefaultMessageLogFactory();
            } 
        } 
        {
            this.logRecordFactory = new DefaultMessageLogFactory();
        } 
        boolean computeContentLength = configurationProperties.getProperty(
				"gov.nist.javax.sip.COMPUTE_CONTENT_LENGTH_FROM_MESSAGE_BODY",
				"false").equalsIgnoreCase("true");
        StringMsgParser
				.setComputeContentLengthFromMessage(computeContentLength);
        String tlsClientProtocols = configurationProperties.getProperty(
				"gov.nist.javax.sip.TLS_CLIENT_PROTOCOLS");
        {
            StringTokenizer st = new StringTokenizer(tlsClientProtocols, " ,");
            String[] protocols = new String[st.countTokens()];
            int i = 0;
            {
                boolean varA9BBA9119DD90070115272E6F9D4D419_1750603143 = (st.hasMoreTokens());
                {
                    protocols[i++] = st.nextToken();
                } 
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
        {
            boolean var53869E3A88D96F4415B2EAEAC904AA86_2108698630 = (isLoggingEnabled());
            getStackLogger().logDebug(
				"created Sip stack. Properties = " + configurationProperties);
        } 
        InputStream in = getClass().getResourceAsStream("/TIMESTAMP");
        {
            BufferedReader streamReader = new BufferedReader(
					new InputStreamReader(in));
            try 
            {
                String buildTimeStamp = streamReader.readLine();
                {
                    in.close();
                } 
                getStackLogger().setBuildTimeStamp(buildTimeStamp);
            } 
            catch (IOException ex)
            {
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.006 -0400", hash_original_method = "4F314CDF94BE73A82A3392DB747CDD4B", hash_generated_method = "8970D290BC5634C680040A422CAB7B77")
    private void reInitialize() {
        super.reInit();
        this.eventScanner = new EventScanner(this);
        this.listeningPoints = new Hashtable<String, ListeningPointImpl>();
        this.sipProviders = new LinkedList<SipProviderImpl>();
        this.sipListener = null;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.006 -0400", hash_original_method = "1B8FCD54ED5E137B1A38ACB963DE1ED8", hash_generated_method = "7A552385BBE4270B0B01A30ABBB0F4F5")
     boolean isAutomaticDialogSupportEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1226970552 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1226970552;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.007 -0400", hash_original_method = "20194A28F7CD206898B50945BA95F1CA", hash_generated_method = "52C97510CC0136503A5C828D2E87C9D6")
    public synchronized ListeningPoint createListeningPoint(String address,
			int port, String transport) throws TransportNotSupportedException,
			InvalidArgumentException {
        ListeningPoint varB4EAC82CA7396A68D541C85D26508E83_725923256 = null; 
        ListeningPoint varB4EAC82CA7396A68D541C85D26508E83_1399950834 = null; 
        {
            boolean var53869E3A88D96F4415B2EAEAC904AA86_990772077 = (isLoggingEnabled());
            getStackLogger().logDebug(
				"createListeningPoint : address = " + address + " port = "
						+ port + " transport = " + transport);
        } 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
					"Address for listening point is null!");
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null transport");
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("bad port");
        {
            boolean varCC577C6206F9622B8D4018CF7CFE5AA3_843893190 = (!transport.equalsIgnoreCase("UDP")
				&& !transport.equalsIgnoreCase("TLS")
				&& !transport.equalsIgnoreCase("TCP")
				&& !transport.equalsIgnoreCase("SCTP"));
            if (DroidSafeAndroidRuntime.control) throw new TransportNotSupportedException("bad transport "
					+ transport);
        } 
        {
            boolean var77293F5E778B02817B1FCCDD8603CFF1_197607817 = (!this.isAlive());
            {
                this.toExit = false;
                this.reInitialize();
            } 
        } 
        String key = ListeningPointImpl.makeKey(address, port, transport);
        ListeningPointImpl lip = (ListeningPointImpl) listeningPoints.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_725923256 = lip;
        } 
        {
            try 
            {
                InetAddress inetAddr = InetAddress.getByName(address);
                MessageProcessor messageProcessor = this
						.createMessageProcessor(inetAddr, port, transport);
                {
                    boolean varA9D08F7458A1E36C8AEA7D0F50E63182_981507724 = (this.isLoggingEnabled());
                    {
                        this.getStackLogger().logDebug(
							"Created Message Processor: " + address
									+ " port = " + port + " transport = "
									+ transport);
                    } 
                } 
                lip = new ListeningPointImpl(this, port, transport);
                lip.messageProcessor = messageProcessor;
                messageProcessor.setListeningPoint(lip);
                this.listeningPoints.put(key, lip);
                messageProcessor.start();
                varB4EAC82CA7396A68D541C85D26508E83_1399950834 = (ListeningPoint) lip;
            } 
            catch (java.io.IOException ex)
            {
                {
                    boolean var31F413A3670DDB7C3047C6D6166E3CCF_487166607 = (isLoggingEnabled());
                    getStackLogger().logError(
						"Invalid argument address = " + address + " port = "
								+ port + " transport = " + transport);
                } 
                if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(ex.getMessage(), ex);
            } 
        } 
        addTaint(address.getTaint());
        addTaint(port);
        addTaint(transport.getTaint());
        ListeningPoint varA7E53CE21691AB073D9660D615818899_1945251141; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1945251141 = varB4EAC82CA7396A68D541C85D26508E83_725923256;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1945251141 = varB4EAC82CA7396A68D541C85D26508E83_1399950834;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1945251141.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1945251141;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.008 -0400", hash_original_method = "BBB69BC5565AF0A227A798564DF93404", hash_generated_method = "B29777EFDCF8DDD141402C4520DEC959")
    public SipProvider createSipProvider(ListeningPoint listeningPoint) throws ObjectInUseException {
        SipProvider varB4EAC82CA7396A68D541C85D26508E83_1317245184 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null listeningPoint");
        {
            boolean var3D7F860628E378FC3C92E3EDB5A5C1DB_1620889294 = (this.isLoggingEnabled());
            this.getStackLogger().logDebug(
					"createSipProvider: " + listeningPoint);
        } 
        ListeningPointImpl listeningPointImpl = (ListeningPointImpl) listeningPoint;
        if (DroidSafeAndroidRuntime.control) throw new ObjectInUseException("Provider already attached!");
        SipProviderImpl provider = new SipProviderImpl(this);
        provider.setListeningPoint(listeningPointImpl);
        listeningPointImpl.sipProvider = provider;
        this.sipProviders.add(provider);
        varB4EAC82CA7396A68D541C85D26508E83_1317245184 = provider;
        addTaint(listeningPoint.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1317245184.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1317245184;
        
        
			
        
			
					
        
        
			
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.008 -0400", hash_original_method = "A92DFE7C9B9D7EE522B2B525B8C69A65", hash_generated_method = "242DD40FB2C4F6EB31DCF011D4821E29")
    public void deleteListeningPoint(ListeningPoint listeningPoint) throws ObjectInUseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null listeningPoint arg");
        ListeningPointImpl lip = (ListeningPointImpl) listeningPoint;
        super.removeMessageProcessor(lip.messageProcessor);
        String key = lip.getKey();
        this.listeningPoints.remove(key);
        addTaint(listeningPoint.getTaint());
        
        
			
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.009 -0400", hash_original_method = "0933EE30851621D7E3F65B407D39A5B8", hash_generated_method = "F5DE79122DD497F8379A4765DC5DEDF3")
    public void deleteSipProvider(SipProvider sipProvider) throws ObjectInUseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null provider arg");
        SipProviderImpl sipProviderImpl = (SipProviderImpl) sipProvider;
        {
            boolean var262CC069AC78E6BC358C9AD7EB716837_608177312 = (sipProviderImpl.getSipListener() != null);
            {
                if (DroidSafeAndroidRuntime.control) throw new ObjectInUseException(
					"SipProvider still has an associated SipListener!");
            } 
        } 
        sipProviderImpl.removeListeningPoints();
        sipProviderImpl.stop();
        sipProviders.remove(sipProvider);
        {
            boolean varC8D7C599E8FF3D1091C8CDC607D82580_1676039272 = (sipProviders.isEmpty());
            {
                this.stopStack();
            } 
        } 
        addTaint(sipProvider.getTaint());
        
        
			
        
        
			
					
		
        
        
        
        
			
		
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.009 -0400", hash_original_method = "81685A4D06B7F9B5E6CCB2DE2C1BD9F0", hash_generated_method = "671E4C934E872BCA7FEF74EFBD011F76")
    public String getIPAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_879614913 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_879614913 = super.getHostAddress();
        varB4EAC82CA7396A68D541C85D26508E83_879614913.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_879614913;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.010 -0400", hash_original_method = "287349EDD4D46CE4DB7C5F6D8E2D772E", hash_generated_method = "79646B574DF103EFDCDD72E2569246FA")
    public java.util.Iterator getListeningPoints() {
        java.util.Iterator varB4EAC82CA7396A68D541C85D26508E83_1825245872 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1825245872 = this.listeningPoints.values().iterator();
        varB4EAC82CA7396A68D541C85D26508E83_1825245872.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1825245872;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.010 -0400", hash_original_method = "BCFD29C2FE3D7BF7BBC15432578BF66F", hash_generated_method = "6DA9411C1BBA42CEC93D8F3964A881A2")
    public boolean isRetransmissionFilterActive() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_345140295 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_345140295;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.010 -0400", hash_original_method = "88A6DC9DED9CE5F7635E348CD4A3C5F8", hash_generated_method = "0D37A2D3A22BAB3D1279C5DDD80BF792")
    public java.util.Iterator<SipProviderImpl> getSipProviders() {
        java.util.Iterator<SipProviderImpl> varB4EAC82CA7396A68D541C85D26508E83_322421843 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_322421843 = this.sipProviders.iterator();
        varB4EAC82CA7396A68D541C85D26508E83_322421843.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_322421843;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.011 -0400", hash_original_method = "98CDA556C50A8E057D89E8EADBB5B35E", hash_generated_method = "BE796237B61AB11826ADD34248C4D4A7")
    public String getStackName() {
        String varB4EAC82CA7396A68D541C85D26508E83_159206260 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_159206260 = this.stackName;
        varB4EAC82CA7396A68D541C85D26508E83_159206260.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_159206260;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.011 -0400", hash_original_method = "E5E5510E122401D8059641DFB570004B", hash_generated_method = "4F65158BCEAB41157A8538BE408747AF")
    protected void finalize() {
        this.stopStack();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.012 -0400", hash_original_method = "E9BAFB829F6434607FADA475E44C9773", hash_generated_method = "A23DE73F56ED3E13611C41374F4B437B")
    public ListeningPoint createListeningPoint(int port, String transport) throws TransportNotSupportedException, InvalidArgumentException {
        ListeningPoint varB4EAC82CA7396A68D541C85D26508E83_1833494621 = null; 
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
					"Stack does not have a default IP Address!");
        varB4EAC82CA7396A68D541C85D26508E83_1833494621 = this.createListeningPoint(super.stackAddress, port, transport);
        addTaint(port);
        addTaint(transport.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1833494621.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1833494621;
        
        
			
					
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.013 -0400", hash_original_method = "8379090E51BF18D65A472A61653181B8", hash_generated_method = "6A6A995BD3D843B40CFECFFBBCCFAFA0")
    public void stop() {
        {
            boolean var53869E3A88D96F4415B2EAEAC904AA86_1284550409 = (isLoggingEnabled());
            {
                getStackLogger().logDebug("stopStack -- stoppping the stack");
            } 
        } 
        this.stopStack();
        this.sipProviders = new LinkedList<SipProviderImpl>();
        this.listeningPoints = new Hashtable<String, ListeningPointImpl>();
        this.eventScanner.forceStop();
        this.eventScanner = null;
        
        
			
		
        
        
        
        
			
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.013 -0400", hash_original_method = "64980175D45C88025DB0BF7ED31DD55C", hash_generated_method = "66A76CF67CCD26E199C0BC50C8ED70B6")
    public void start() throws ProviderDoesNotExistException, SipException {
        {
            this.eventScanner = new EventScanner(this);
        } 
        
        
			
		
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.014 -0400", hash_original_method = "007AB23FB90DEFAA901334391BCA8574", hash_generated_method = "32DFA3A2C8407BC6AF990736A11A7D35")
    public SipListener getSipListener() {
        SipListener varB4EAC82CA7396A68D541C85D26508E83_318573002 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_318573002 = this.sipListener;
        varB4EAC82CA7396A68D541C85D26508E83_318573002.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_318573002;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.014 -0400", hash_original_method = "41341CEB98E5DA012DCAACB9910CCA31", hash_generated_method = "B23B6FD6389726F40148A30D2321BBCA")
    public LogRecordFactory getLogRecordFactory() {
        LogRecordFactory varB4EAC82CA7396A68D541C85D26508E83_1518828465 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1518828465 = super.logRecordFactory;
        varB4EAC82CA7396A68D541C85D26508E83_1518828465.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1518828465;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.014 -0400", hash_original_method = "DD6917F16C5DC825A79D8F74525C77AA", hash_generated_method = "EC0D82D717281AF44D905CDE0BE8A54E")
    @Deprecated
    public EventScanner getEventScanner() {
        EventScanner varB4EAC82CA7396A68D541C85D26508E83_677870536 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_677870536 = eventScanner;
        varB4EAC82CA7396A68D541C85D26508E83_677870536.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_677870536;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.015 -0400", hash_original_method = "DDBB9B823124CA2B241AC7D56A934729", hash_generated_method = "66B0E669B3EBB706E1AF7F86F7E4C365")
    public AuthenticationHelper getAuthenticationHelper(
			AccountManager accountManager, HeaderFactory headerFactory) {
        AuthenticationHelper varB4EAC82CA7396A68D541C85D26508E83_1177474625 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1177474625 = new AuthenticationHelperImpl(this, accountManager, headerFactory);
        addTaint(accountManager.getTaint());
        addTaint(headerFactory.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1177474625.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1177474625;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.016 -0400", hash_original_method = "9BC4A63758F96D1DFC890C8072E9A8F9", hash_generated_method = "E2A8CCD771189AF61F226F471447E59D")
    public AuthenticationHelper getSecureAuthenticationHelper(
			SecureAccountManager accountManager, HeaderFactory headerFactory) {
        AuthenticationHelper varB4EAC82CA7396A68D541C85D26508E83_258344022 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_258344022 = new AuthenticationHelperImpl(this, accountManager, headerFactory);
        addTaint(accountManager.getTaint());
        addTaint(headerFactory.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_258344022.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_258344022;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.016 -0400", hash_original_method = "23CB36659469F37B2B1A4E89C6C5A109", hash_generated_method = "EEF876C7AA37CA82F9A54624D848F42A")
    public void setEnabledCipherSuites(String[] newCipherSuites) {
        cipherSuites = newCipherSuites;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.017 -0400", hash_original_method = "15C35F67057574B0384681051DA88AFD", hash_generated_method = "E3A8A09491B24509780FCB84717941D4")
    public String[] getEnabledCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1713122065 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1713122065 = cipherSuites;
        varB4EAC82CA7396A68D541C85D26508E83_1713122065.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1713122065;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.018 -0400", hash_original_method = "146720FA6D9E688CD139244E691C1622", hash_generated_method = "367AACC0BB535AEDE0F21EE0BE1604FA")
    public void setEnabledProtocols(String[] newProtocols) {
        enabledProtocols = newProtocols;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.021 -0400", hash_original_method = "36B040AE4C1B32E20301E5CF570A7C53", hash_generated_method = "D4BF67CAAB7DD2572AC64211035654F4")
    public String[] getEnabledProtocols() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_595502972 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_595502972 = enabledProtocols;
        varB4EAC82CA7396A68D541C85D26508E83_595502972.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_595502972;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.022 -0400", hash_original_method = "B3A8DF498FA0698B770F05249042765A", hash_generated_method = "03886AAE7E894E0D90DA83D6366182F2")
    public void setIsBackToBackUserAgent(boolean flag) {
        super.isBackToBackUserAgent = flag;
        addTaint(flag);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.023 -0400", hash_original_method = "1623111994CBCA0890DA0FF2A1E140E0", hash_generated_method = "8ADFF0762EA61966E180D8885F78BD1D")
    public boolean isBackToBackUserAgent() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2082214435 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2082214435;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.024 -0400", hash_original_method = "8A30592F142C300BD40BD8A31AEE1D8D", hash_generated_method = "7D82E33835F8411698B3B92E48400CDC")
    public boolean isAutomaticDialogErrorHandlingEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1663982792 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1663982792;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.025 -0400", hash_original_method = "1CDF5A6FEBA76AB1A61A70742324066C", hash_generated_method = "E22EBB38C88902561FC85A582C9E340B")
    public boolean acquireSem() {
        try 
        {
            boolean var6CD91398C6667EFBFA92956988AFCF80_1410270279 = (this.stackSemaphore.tryAcquire(10, TimeUnit.SECONDS));
        } 
        catch (InterruptedException ex)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2008737483 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2008737483;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.025 -0400", hash_original_method = "2B4EDB484E691FD8761CF130C9353BAF", hash_generated_method = "ABCF4EEA47ACCF6FD64218E3A8D948F5")
    public void releaseSem() {
        this.stackSemaphore.release();
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.025 -0400", hash_original_field = "26B86A1C916CC4B7BAB489AF94B9502C", hash_generated_field = "DC1BA291E655CE21E8210560B23E074D")

    public static final Integer MAX_DATAGRAM_SIZE = 8 * 1024;
}

