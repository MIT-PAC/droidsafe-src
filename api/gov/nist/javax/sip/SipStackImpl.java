package gov.nist.javax.sip;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.877 -0400", hash_original_field = "0C887D575D34CEEB43215C9C2EB3F7E0", hash_generated_field = "B13D933CCB9027F950F0F782A6866769")

    private EventScanner eventScanner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.877 -0400", hash_original_field = "3CEAB7318649FC55E6D462942E769E7E", hash_generated_field = "3AEF05BEBD52A17EF95A5D808F4FFFA4")

    private Hashtable<String, ListeningPointImpl> listeningPoints;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.877 -0400", hash_original_field = "70438560708F29EEC903E8857CAD5F87", hash_generated_field = "4D9EE92C5E84922DC5B8DC3AD8BDEAEF")

    private LinkedList<SipProviderImpl> sipProviders;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.877 -0400", hash_original_field = "1E7A0E62B6D1C3ABE8645330F49CA7A4", hash_generated_field = "C05D7B5683B60CB11426E6CCECD30C55")

    boolean reEntrantListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.878 -0400", hash_original_field = "C2742B0786D982D4EE3DCECCEC00E889", hash_generated_field = "B9D95CF1DDB3EF5E2FB32454D5FBE60B")

    SipListener sipListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.878 -0400", hash_original_field = "9AFB2542ACFDA41CD0B947306A200374", hash_generated_field = "14BC1D7F6107A47B988CB81CBFA69682")

    boolean deliverTerminatedEventForAck = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.878 -0400", hash_original_field = "E7CFB3101E29334B0125A1F7E7C03AD9", hash_generated_field = "30FBBF692AD048CF0FD21C922D56959C")

    boolean deliverUnsolicitedNotify = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.878 -0400", hash_original_field = "FFD25253325702F7B54013D4F86C77C7", hash_generated_field = "3D24F5BF02841FC581DDB4BFBB9A4EDB")

    private Semaphore stackSemaphore = new Semaphore(1);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.878 -0400", hash_original_field = "CC92C21F17FEFA346C3D963B8A88779D", hash_generated_field = "93F48895C4F48861DEB454B4E221258D")

    private String[] cipherSuites = {
			"TLS_RSA_WITH_AES_128_CBC_SHA", 
											
			
			"SSL_RSA_WITH_3DES_EDE_CBC_SHA", 

			
			
			"TLS_DH_anon_WITH_AES_128_CBC_SHA",
			"SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.878 -0400", hash_original_field = "09CE383C325D1DAAE0EF1312788048B5", hash_generated_field = "8206EF99B37B84E105B4852E2EE7C8F0")

    private String[] enabledProtocols = {
			"SSLv3",
			"SSLv2Hello",
			"TLSv1"
	};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.879 -0400", hash_original_method = "BD80EAD073CED4ACABB1B92EBB481070", hash_generated_method = "61A3FAE21B49746705B2C029ACAAFB9F")
    protected  SipStackImpl() {
        super();
        NistSipMessageFactoryImpl msgFactory = new NistSipMessageFactoryImpl(
				this);
        super.setMessageFactory(msgFactory);
        this.eventScanner = new EventScanner(this);
        this.listeningPoints = new Hashtable<String, ListeningPointImpl>();
        this.sipProviders = new LinkedList<SipProviderImpl>();
        
        
				
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.891 -0400", hash_original_method = "31E9570F9C2C0C73DA51527B7C89A7AA", hash_generated_method = "BA3EB3092242ABC5B998CB5185F58A00")
    public  SipStackImpl(Properties configurationProperties) throws PeerUnavailableException {
        this();
        String address = configurationProperties
				.getProperty("javax.sip.IP_ADDRESS");
        try 
        {
    if(address != null)            
            {
                super.setHostAddress(address);
            } 
        } 
        catch (java.net.UnknownHostException ex)
        {
            PeerUnavailableException var79C71E2AB85511B2D9D687BD472FE841_1531583359 = new PeerUnavailableException("bad address " + address);
            var79C71E2AB85511B2D9D687BD472FE841_1531583359.addTaint(taint);
            throw var79C71E2AB85511B2D9D687BD472FE841_1531583359;
        } 
        String name = configurationProperties
				.getProperty("javax.sip.STACK_NAME");
    if(name == null)        
        {
        PeerUnavailableException var5746084F4CE9DACCD3C8281E327B5361_306293167 = new PeerUnavailableException("stack name is missing");
        var5746084F4CE9DACCD3C8281E327B5361_306293167.addTaint(taint);
        throw var5746084F4CE9DACCD3C8281E327B5361_306293167;
        }
        super.setStackName(name);
        String stackLoggerClassName = configurationProperties
				.getProperty("gov.nist.javax.sip.STACK_LOGGER");
    if(stackLoggerClassName == null)        
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
            IllegalArgumentException var7D798764E311E9F9E93265E25929C45E_117006421 = new IllegalArgumentException(
						"Cound not instantiate stack logger "
								+ stackLoggerClassName
								+ "- check that it is present on the classpath and that there is a no-args constructor defined",
						ex1);
            var7D798764E311E9F9E93265E25929C45E_117006421.addTaint(taint);
            throw var7D798764E311E9F9E93265E25929C45E_117006421;
        } 
        catch (Exception ex)
        {
            IllegalArgumentException var564B928265409E40595D1F55215CFB23_1693135208 = new IllegalArgumentException(
						"Cound not instantiate stack logger "
								+ stackLoggerClassName
								+ "- check that it is present on the classpath and that there is a no-args constructor defined",
						ex);
            var564B928265409E40595D1F55215CFB23_1693135208.addTaint(taint);
            throw var564B928265409E40595D1F55215CFB23_1693135208;
        } 
        String serverLoggerClassName = configurationProperties
				.getProperty("gov.nist.javax.sip.SERVER_LOGGER");
    if(serverLoggerClassName == null)        
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
            IllegalArgumentException varE9E229A0C6E7BED507D4C8EC83D382B5_300243710 = new IllegalArgumentException(
						"Cound not instantiate server logger "
								+ stackLoggerClassName
								+ "- check that it is present on the classpath and that there is a no-args constructor defined",
						ex1);
            varE9E229A0C6E7BED507D4C8EC83D382B5_300243710.addTaint(taint);
            throw varE9E229A0C6E7BED507D4C8EC83D382B5_300243710;
        } 
        catch (Exception ex)
        {
            IllegalArgumentException var2E929D9A877CB7CB839DD5DD545BBDA5_1259671375 = new IllegalArgumentException(
						"Cound not instantiate server logger "
								+ stackLoggerClassName
								+ "- check that it is present on the classpath and that there is a no-args constructor defined",
						ex);
            var2E929D9A877CB7CB839DD5DD545BBDA5_1259671375.addTaint(taint);
            throw var2E929D9A877CB7CB839DD5DD545BBDA5_1259671375;
        } 
        this.outboundProxy = configurationProperties
				.getProperty("javax.sip.OUTBOUND_PROXY");
        this.defaultRouter = new DefaultRouter(this, outboundProxy);
        String routerPath = configurationProperties
				.getProperty("javax.sip.ROUTER_PATH");
    if(routerPath == null)        
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
            PeerUnavailableException var4FC531EE4A1E22F20B25F785EAB55F17_435729257 = new PeerUnavailableException(
					"Cound not instantiate router - check constructor", ex1);
            var4FC531EE4A1E22F20B25F785EAB55F17_435729257.addTaint(taint);
            throw var4FC531EE4A1E22F20B25F785EAB55F17_435729257;
        } 
        catch (Exception ex)
        {
            getStackLogger().logError("could not instantiate router",
					(Exception) ex.getCause());
            PeerUnavailableException varF3C9C7F34D7B650E4494E760ADA8448D_571121037 = new PeerUnavailableException("Could not instantiate router",
					ex);
            varF3C9C7F34D7B650E4494E760ADA8448D_571121037.addTaint(taint);
            throw varF3C9C7F34D7B650E4494E760ADA8448D_571121037;
        } 
        String useRouterForAll = configurationProperties
				.getProperty("javax.sip.USE_ROUTER_FOR_ALL_URIS");
        this.useRouterForAll = true;
    if(useRouterForAll != null)        
        {
            this.useRouterForAll = "true".equalsIgnoreCase(useRouterForAll);
        } 
        String extensionMethods = configurationProperties
				.getProperty("javax.sip.EXTENSION_METHODS");
    if(extensionMethods != null)        
        {
            java.util.StringTokenizer st = new java.util.StringTokenizer(
					extensionMethods);
            while
(st.hasMoreTokens())            
            {
                String em = st.nextToken(":");
    if(em.equalsIgnoreCase(Request.BYE)
						|| em.equalsIgnoreCase(Request.INVITE)
						|| em.equalsIgnoreCase(Request.SUBSCRIBE)
						|| em.equalsIgnoreCase(Request.NOTIFY)
						|| em.equalsIgnoreCase(Request.ACK)
						|| em.equalsIgnoreCase(Request.OPTIONS))                
                {
                PeerUnavailableException var398F277A69CF4A2DB38565F6703E2E77_861903465 = new PeerUnavailableException("Bad extension method "
							+ em);
                var398F277A69CF4A2DB38565F6703E2E77_861903465.addTaint(taint);
                throw var398F277A69CF4A2DB38565F6703E2E77_861903465;
                }
                else
                this.addExtensionMethod(em);
            } 
        } 
        String keyStoreFile = configurationProperties
				.getProperty("javax.net.ssl.keyStore");
        String trustStoreFile = configurationProperties
				.getProperty("javax.net.ssl.trustStore");
    if(keyStoreFile != null)        
        {
    if(trustStoreFile == null)            
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
    if(super.isAutomaticDialogSupportEnabled)        
        {
            super.isAutomaticDialogErrorHandlingEnabled = true;
        } 
    if(configurationProperties
				.getProperty("gov.nist.javax.sip.MAX_LISTENER_RESPONSE_TIME") != null)        
        {
            super.maxListenerResponseTime = Integer
					.parseInt(configurationProperties
							.getProperty("gov.nist.javax.sip.MAX_LISTENER_RESPONSE_TIME"));
    if(super.maxListenerResponseTime <= 0)            
            {
            PeerUnavailableException var5CDDDDACF0A02121E1452850BF8E82F7_654544388 = new PeerUnavailableException(
						"Bad configuration parameter gov.nist.javax.sip.MAX_LISTENER_RESPONSE_TIME : should be positive");
            var5CDDDDACF0A02121E1452850BF8E82F7_654544388.addTaint(taint);
            throw var5CDDDDACF0A02121E1452850BF8E82F7_654544388;
            }
        } 
        else
        {
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
    if(forkedSubscriptions != null)        
        {
            StringTokenizer st = new StringTokenizer(forkedSubscriptions);
            while
(st.hasMoreTokens())            
            {
                String nextEvent = st.nextToken();
                this.forkedEvents.add(nextEvent);
            } 
        } 
        final String NETWORK_LAYER_KEY = "gov.nist.javax.sip.NETWORK_LAYER";
    if(configurationProperties.containsKey(NETWORK_LAYER_KEY))        
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
                PeerUnavailableException var553A62B3106AC68D35EB4AFF2140F444_1466946006 = new PeerUnavailableException(
						"can't find or instantiate NetworkLayer implementation: "
								+ path);
                var553A62B3106AC68D35EB4AFF2140F444_1466946006.addTaint(taint);
                throw var553A62B3106AC68D35EB4AFF2140F444_1466946006;
            } 
        } 
        final String ADDRESS_RESOLVER_KEY = "gov.nist.javax.sip.ADDRESS_RESOLVER";
    if(configurationProperties.containsKey(ADDRESS_RESOLVER_KEY))        
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
                PeerUnavailableException varCC0CC54199A2E67C871A7562BD97A30C_415796867 = new PeerUnavailableException(
						"can't find or instantiate AddressResolver implementation: "
								+ path);
                varCC0CC54199A2E67C871A7562BD97A30C_415796867.addTaint(taint);
                throw varCC0CC54199A2E67C871A7562BD97A30C_415796867;
            } 
        } 
        String maxConnections = configurationProperties
				.getProperty("gov.nist.javax.sip.MAX_CONNECTIONS");
    if(maxConnections != null)        
        {
            try 
            {
                this.maxConnections = new Integer(maxConnections).intValue();
            } 
            catch (NumberFormatException ex)
            {
    if(isLoggingEnabled())                
                getStackLogger().logError(
						"max connections - bad value " + ex.getMessage());
            } 
        } 
        String threadPoolSize = configurationProperties
				.getProperty("gov.nist.javax.sip.THREAD_POOL_SIZE");
    if(threadPoolSize != null)        
        {
            try 
            {
                this.threadPoolSize = new Integer(threadPoolSize).intValue();
            } 
            catch (NumberFormatException ex)
            {
    if(isLoggingEnabled())                
                this.getStackLogger().logError(
						"thread pool size - bad value " + ex.getMessage());
            } 
        } 
        String serverTransactionTableSize = configurationProperties
				.getProperty("gov.nist.javax.sip.MAX_SERVER_TRANSACTIONS");
    if(serverTransactionTableSize != null)        
        {
            try 
            {
                this.serverTransactionTableHighwaterMark = new Integer(
						serverTransactionTableSize).intValue();
                this.serverTransactionTableLowaterMark = this.serverTransactionTableHighwaterMark * 80 / 100;
            } 
            catch (NumberFormatException ex)
            {
    if(isLoggingEnabled())                
                this.getStackLogger()
						.logError(
								"transaction table size - bad value "
										+ ex.getMessage());
            } 
        } 
        else
        {
            this.unlimitedServerTransactionTableSize = true;
        } 
        String clientTransactionTableSize = configurationProperties
				.getProperty("gov.nist.javax.sip.MAX_CLIENT_TRANSACTIONS");
    if(clientTransactionTableSize != null)        
        {
            try 
            {
                this.clientTransactionTableHiwaterMark = new Integer(
						clientTransactionTableSize).intValue();
                this.clientTransactionTableLowaterMark = this.clientTransactionTableLowaterMark * 80 / 100;
            } 
            catch (NumberFormatException ex)
            {
    if(isLoggingEnabled())                
                this.getStackLogger()
						.logError(
								"transaction table size - bad value "
										+ ex.getMessage());
            } 
        } 
        else
        {
            this.unlimitedClientTransactionTableSize = true;
        } 
        super.cacheServerConnections = true;
        String flag = configurationProperties
				.getProperty("gov.nist.javax.sip.CACHE_SERVER_CONNECTIONS");
    if(flag != null && "false".equalsIgnoreCase(flag.trim()))        
        {
            super.cacheServerConnections = false;
        } 
        super.cacheClientConnections = true;
        String cacheflag = configurationProperties
				.getProperty("gov.nist.javax.sip.CACHE_CLIENT_CONNECTIONS");
    if(cacheflag != null && "false".equalsIgnoreCase(cacheflag.trim()))        
        {
            super.cacheClientConnections = false;
        } 
        String readTimeout = configurationProperties
				.getProperty("gov.nist.javax.sip.READ_TIMEOUT");
    if(readTimeout != null)        
        {
            try 
            {
                int rt = Integer.parseInt(readTimeout);
    if(rt >= 100)                
                {
                    super.readTimeout = rt;
                } 
                else
                {
                    System.err.println("Value too low " + readTimeout);
                } 
            } 
            catch (NumberFormatException nfe)
            {
    if(isLoggingEnabled())                
                getStackLogger().logError("Bad read timeout " + readTimeout);
            } 
        } 
        String stunAddr = configurationProperties
				.getProperty("gov.nist.javax.sip.STUN_SERVER");
    if(stunAddr != null)        
        this.getStackLogger().logWarning(
					"Ignoring obsolete property "
							+ "gov.nist.javax.sip.STUN_SERVER");
        String maxMsgSize = configurationProperties
				.getProperty("gov.nist.javax.sip.MAX_MESSAGE_SIZE");
        try 
        {
    if(maxMsgSize != null)            
            {
                super.maxMessageSize = new Integer(maxMsgSize).intValue();
    if(super.maxMessageSize < 4096)                
                super.maxMessageSize = 4096;
            } 
            else
            {
                super.maxMessageSize = 0;
            } 
        } 
        catch (NumberFormatException ex)
        {
    if(isLoggingEnabled())            
            getStackLogger().logError(
					"maxMessageSize - bad value " + ex.getMessage());
        } 
        String rel = configurationProperties
				.getProperty("gov.nist.javax.sip.REENTRANT_LISTENER");
        this.reEntrantListener = (rel != null && "true".equalsIgnoreCase(rel));
        String interval = configurationProperties
				.getProperty("gov.nist.javax.sip.THREAD_AUDIT_INTERVAL_IN_MILLISECS");
    if(interval != null)        
        {
            try 
            {
                getThreadAuditor().setPingIntervalInMillisecs(
						Long.valueOf(interval).longValue() / 2);
            } 
            catch (NumberFormatException ex)
            {
    if(isLoggingEnabled())                
                getStackLogger().logError(
						"THREAD_AUDIT_INTERVAL_IN_MILLISECS - bad value ["
								+ interval + "] " + ex.getMessage());
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
    if(messageLogFactoryClasspath != null)        
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
    if(isLoggingEnabled())                
                getStackLogger()
						.logError(
								"Bad configuration value for LOG_FACTORY -- using default logger");
                this.logRecordFactory = new DefaultMessageLogFactory();
            } 
        } 
        else
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
    if(tlsClientProtocols != null)        
        {
            StringTokenizer st = new StringTokenizer(tlsClientProtocols, " ,");
            String[] protocols = new String[st.countTokens()];
            int i = 0;
            while
(st.hasMoreTokens())            
            {
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
    if(isLoggingEnabled())        
        getStackLogger().logDebug(
				"created Sip stack. Properties = " + configurationProperties);
        InputStream in = getClass().getResourceAsStream("/TIMESTAMP");
    if(in != null)        
        {
            BufferedReader streamReader = new BufferedReader(
					new InputStreamReader(in));
            try 
            {
                String buildTimeStamp = streamReader.readLine();
    if(in != null)                
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.896 -0400", hash_original_method = "4F314CDF94BE73A82A3392DB747CDD4B", hash_generated_method = "8970D290BC5634C680040A422CAB7B77")
    private void reInitialize() {
        super.reInit();
        this.eventScanner = new EventScanner(this);
        this.listeningPoints = new Hashtable<String, ListeningPointImpl>();
        this.sipProviders = new LinkedList<SipProviderImpl>();
        this.sipListener = null;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.896 -0400", hash_original_method = "1B8FCD54ED5E137B1A38ACB963DE1ED8", hash_generated_method = "8FB73A076E8D550506F30F9BE4ACA619")
     boolean isAutomaticDialogSupportEnabled() {
        boolean varA4E4B3DE7DBDF061DF4732544DBE6768_1367034064 = (super.isAutomaticDialogSupportEnabled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1067071150 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1067071150;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.899 -0400", hash_original_method = "20194A28F7CD206898B50945BA95F1CA", hash_generated_method = "E697A82E0BF0E93455B57F37A52B65FE")
    public synchronized ListeningPoint createListeningPoint(String address,
			int port, String transport) throws TransportNotSupportedException,
			InvalidArgumentException {
        addTaint(transport.getTaint());
        addTaint(port);
        addTaint(address.getTaint());
    if(isLoggingEnabled())        
        getStackLogger().logDebug(
				"createListeningPoint : address = " + address + " port = "
						+ port + " transport = " + transport);
    if(address == null)        
        {
        NullPointerException var278D6FE1FA1EBA26FC9FBB0BE8685ED7_1406137946 = new NullPointerException(
					"Address for listening point is null!");
        var278D6FE1FA1EBA26FC9FBB0BE8685ED7_1406137946.addTaint(taint);
        throw var278D6FE1FA1EBA26FC9FBB0BE8685ED7_1406137946;
        }
    if(transport == null)        
        {
        NullPointerException varEB3C267A135B8286E6EA7EC4BE095ED2_19919558 = new NullPointerException("null transport");
        varEB3C267A135B8286E6EA7EC4BE095ED2_19919558.addTaint(taint);
        throw varEB3C267A135B8286E6EA7EC4BE095ED2_19919558;
        }
    if(port <= 0)        
        {
        InvalidArgumentException var6A47E3FF81032496D5DBF4F21B7FE9C2_509570655 = new InvalidArgumentException("bad port");
        var6A47E3FF81032496D5DBF4F21B7FE9C2_509570655.addTaint(taint);
        throw var6A47E3FF81032496D5DBF4F21B7FE9C2_509570655;
        }
    if(!transport.equalsIgnoreCase("UDP")
				&& !transport.equalsIgnoreCase("TLS")
				&& !transport.equalsIgnoreCase("TCP")
				&& !transport.equalsIgnoreCase("SCTP"))        
        {
        TransportNotSupportedException var9FC2468853BFA31090227F1B698CF057_1090221698 = new TransportNotSupportedException("bad transport "
					+ transport);
        var9FC2468853BFA31090227F1B698CF057_1090221698.addTaint(taint);
        throw var9FC2468853BFA31090227F1B698CF057_1090221698;
        }
    if(!this.isAlive())        
        {
            this.toExit = false;
            this.reInitialize();
        } 
        String key = ListeningPointImpl.makeKey(address, port, transport);
        ListeningPointImpl lip = (ListeningPointImpl) listeningPoints.get(key);
    if(lip != null)        
        {
ListeningPoint var258B3606D2892CBE12D92EDF68F0CCA7_1799040659 =             lip;
            var258B3606D2892CBE12D92EDF68F0CCA7_1799040659.addTaint(taint);
            return var258B3606D2892CBE12D92EDF68F0CCA7_1799040659;
        } 
        else
        {
            try 
            {
                InetAddress inetAddr = InetAddress.getByName(address);
                MessageProcessor messageProcessor = this
						.createMessageProcessor(inetAddr, port, transport);
    if(this.isLoggingEnabled())                
                {
                    this.getStackLogger().logDebug(
							"Created Message Processor: " + address
									+ " port = " + port + " transport = "
									+ transport);
                } 
                lip = new ListeningPointImpl(this, port, transport);
                lip.messageProcessor = messageProcessor;
                messageProcessor.setListeningPoint(lip);
                this.listeningPoints.put(key, lip);
                messageProcessor.start();
ListeningPoint varEDD8C3CE21711D14F297069661EFACFC_71718540 =                 (ListeningPoint) lip;
                varEDD8C3CE21711D14F297069661EFACFC_71718540.addTaint(taint);
                return varEDD8C3CE21711D14F297069661EFACFC_71718540;
            } 
            catch (java.io.IOException ex)
            {
    if(isLoggingEnabled())                
                getStackLogger().logError(
						"Invalid argument address = " + address + " port = "
								+ port + " transport = " + transport);
                InvalidArgumentException var48353FB47CA2EB5F188C47B84BC0734C_947180730 = new InvalidArgumentException(ex.getMessage(), ex);
                var48353FB47CA2EB5F188C47B84BC0734C_947180730.addTaint(taint);
                throw var48353FB47CA2EB5F188C47B84BC0734C_947180730;
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.900 -0400", hash_original_method = "BBB69BC5565AF0A227A798564DF93404", hash_generated_method = "AFA0174F7BDCC46A570470E0AB9E6078")
    public SipProvider createSipProvider(ListeningPoint listeningPoint) throws ObjectInUseException {
        addTaint(listeningPoint.getTaint());
    if(listeningPoint == null)        
        {
        NullPointerException var0F2709F9D2E9A637CD15BCBB9A689B1A_746605345 = new NullPointerException("null listeningPoint");
        var0F2709F9D2E9A637CD15BCBB9A689B1A_746605345.addTaint(taint);
        throw var0F2709F9D2E9A637CD15BCBB9A689B1A_746605345;
        }
    if(this.isLoggingEnabled())        
        this.getStackLogger().logDebug(
					"createSipProvider: " + listeningPoint);
        ListeningPointImpl listeningPointImpl = (ListeningPointImpl) listeningPoint;
    if(listeningPointImpl.sipProvider != null)        
        {
        ObjectInUseException varEEB33B680F2D9DEED19F35E67E1B1139_1004568199 = new ObjectInUseException("Provider already attached!");
        varEEB33B680F2D9DEED19F35E67E1B1139_1004568199.addTaint(taint);
        throw varEEB33B680F2D9DEED19F35E67E1B1139_1004568199;
        }
        SipProviderImpl provider = new SipProviderImpl(this);
        provider.setListeningPoint(listeningPointImpl);
        listeningPointImpl.sipProvider = provider;
        this.sipProviders.add(provider);
SipProvider varC1EB7B12CCABB27D431E5B91E5FF9ECB_557650480 =         provider;
        varC1EB7B12CCABB27D431E5B91E5FF9ECB_557650480.addTaint(taint);
        return varC1EB7B12CCABB27D431E5B91E5FF9ECB_557650480;
        
        
			
        
			
					
        
        
			
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.901 -0400", hash_original_method = "A92DFE7C9B9D7EE522B2B525B8C69A65", hash_generated_method = "ADC2B42DD1261C6A6C7BB4353436F07A")
    public void deleteListeningPoint(ListeningPoint listeningPoint) throws ObjectInUseException {
        addTaint(listeningPoint.getTaint());
    if(listeningPoint == null)        
        {
        NullPointerException var4DBBCAA6E23772D8053134EFD44AFCF6_525682324 = new NullPointerException("null listeningPoint arg");
        var4DBBCAA6E23772D8053134EFD44AFCF6_525682324.addTaint(taint);
        throw var4DBBCAA6E23772D8053134EFD44AFCF6_525682324;
        }
        ListeningPointImpl lip = (ListeningPointImpl) listeningPoint;
        super.removeMessageProcessor(lip.messageProcessor);
        String key = lip.getKey();
        this.listeningPoints.remove(key);
        
        
			
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.901 -0400", hash_original_method = "0933EE30851621D7E3F65B407D39A5B8", hash_generated_method = "8BB060B76254D0CDB03CC67F76C99035")
    public void deleteSipProvider(SipProvider sipProvider) throws ObjectInUseException {
        addTaint(sipProvider.getTaint());
    if(sipProvider == null)        
        {
        NullPointerException var7497BE8318B85F1CAD106459DA12FBB0_474033487 = new NullPointerException("null provider arg");
        var7497BE8318B85F1CAD106459DA12FBB0_474033487.addTaint(taint);
        throw var7497BE8318B85F1CAD106459DA12FBB0_474033487;
        }
        SipProviderImpl sipProviderImpl = (SipProviderImpl) sipProvider;
    if(sipProviderImpl.getSipListener() != null)        
        {
            ObjectInUseException varD9B945B7028C10AAA32379888E3AE4A2_274142136 = new ObjectInUseException(
					"SipProvider still has an associated SipListener!");
            varD9B945B7028C10AAA32379888E3AE4A2_274142136.addTaint(taint);
            throw varD9B945B7028C10AAA32379888E3AE4A2_274142136;
        } 
        sipProviderImpl.removeListeningPoints();
        sipProviderImpl.stop();
        sipProviders.remove(sipProvider);
    if(sipProviders.isEmpty())        
        {
            this.stopStack();
        } 
        
        
			
        
        
			
					
		
        
        
        
        
			
		
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.902 -0400", hash_original_method = "81685A4D06B7F9B5E6CCB2DE2C1BD9F0", hash_generated_method = "06520D72FA2C1E211A204557C64FA19B")
    public String getIPAddress() {
String var46CF8C589BF424F75B525BB7945D7C14_195588848 =         super.getHostAddress();
        var46CF8C589BF424F75B525BB7945D7C14_195588848.addTaint(taint);
        return var46CF8C589BF424F75B525BB7945D7C14_195588848;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.902 -0400", hash_original_method = "287349EDD4D46CE4DB7C5F6D8E2D772E", hash_generated_method = "EBD1D8A7ABE400CA738CDCD319B5DE86")
    public java.util.Iterator getListeningPoints() {
java.util.Iterator var4D981ED554566F59753BE5601AF226A4_1156275411 =         this.listeningPoints.values().iterator();
        var4D981ED554566F59753BE5601AF226A4_1156275411.addTaint(taint);
        return var4D981ED554566F59753BE5601AF226A4_1156275411;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.902 -0400", hash_original_method = "BCFD29C2FE3D7BF7BBC15432578BF66F", hash_generated_method = "FC4F9F0C005ADAEF9F4631324C37C7FB")
    public boolean isRetransmissionFilterActive() {
        boolean varB326B5062B2F0E69046810717534CB09_546277299 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_66030138 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_66030138;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.903 -0400", hash_original_method = "88A6DC9DED9CE5F7635E348CD4A3C5F8", hash_generated_method = "5FCE48CBA1E7903BF0F179837EA95E08")
    public java.util.Iterator<SipProviderImpl> getSipProviders() {
java.util.Iterator<SipProviderImpl> varBBD9EF8FEF4ABF5F5900D59FEB2D1D43_2028524297 =         this.sipProviders.iterator();
        varBBD9EF8FEF4ABF5F5900D59FEB2D1D43_2028524297.addTaint(taint);
        return varBBD9EF8FEF4ABF5F5900D59FEB2D1D43_2028524297;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.903 -0400", hash_original_method = "98CDA556C50A8E057D89E8EADBB5B35E", hash_generated_method = "E49340069CC2CC05E1C2CED97084EC91")
    public String getStackName() {
String varC2137E9EB123770CB7478D5F61C27769_1168740663 =         this.stackName;
        varC2137E9EB123770CB7478D5F61C27769_1168740663.addTaint(taint);
        return varC2137E9EB123770CB7478D5F61C27769_1168740663;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.903 -0400", hash_original_method = "E5E5510E122401D8059641DFB570004B", hash_generated_method = "4F65158BCEAB41157A8538BE408747AF")
    protected void finalize() {
        this.stopStack();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.904 -0400", hash_original_method = "E9BAFB829F6434607FADA475E44C9773", hash_generated_method = "B3CB718672063409F76A3FC60B524FD4")
    public ListeningPoint createListeningPoint(int port, String transport) throws TransportNotSupportedException, InvalidArgumentException {
        addTaint(transport.getTaint());
        addTaint(port);
    if(super.stackAddress == null)        
        {
        NullPointerException var4420489AF0E9394229069FFD525274B6_813865045 = new NullPointerException(
					"Stack does not have a default IP Address!");
        var4420489AF0E9394229069FFD525274B6_813865045.addTaint(taint);
        throw var4420489AF0E9394229069FFD525274B6_813865045;
        }
ListeningPoint varC76A5AB4EF9BE4415C98DD677081F562_1969237127 =         this.createListeningPoint(super.stackAddress, port, transport);
        varC76A5AB4EF9BE4415C98DD677081F562_1969237127.addTaint(taint);
        return varC76A5AB4EF9BE4415C98DD677081F562_1969237127;
        
        
			
					
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.905 -0400", hash_original_method = "8379090E51BF18D65A472A61653181B8", hash_generated_method = "872F97B4ABB94B6BCB2022C33C2A393C")
    public void stop() {
    if(isLoggingEnabled())        
        {
            getStackLogger().logDebug("stopStack -- stoppping the stack");
        } 
        this.stopStack();
        this.sipProviders = new LinkedList<SipProviderImpl>();
        this.listeningPoints = new Hashtable<String, ListeningPointImpl>();
    if(this.eventScanner != null)        
        this.eventScanner.forceStop();
        this.eventScanner = null;
        
        
			
		
        
        
        
        
			
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.905 -0400", hash_original_method = "64980175D45C88025DB0BF7ED31DD55C", hash_generated_method = "17474A70929CBA0332B5C093BCCBD059")
    public void start() throws ProviderDoesNotExistException, SipException {
    if(this.eventScanner == null)        
        {
            this.eventScanner = new EventScanner(this);
        } 
        
        
			
		
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.905 -0400", hash_original_method = "007AB23FB90DEFAA901334391BCA8574", hash_generated_method = "69DA03729688EEE8FA419D1DB7240760")
    public SipListener getSipListener() {
SipListener var189888A7EF3E414546D5F75D14E9FE29_1492532210 =         this.sipListener;
        var189888A7EF3E414546D5F75D14E9FE29_1492532210.addTaint(taint);
        return var189888A7EF3E414546D5F75D14E9FE29_1492532210;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.906 -0400", hash_original_method = "41341CEB98E5DA012DCAACB9910CCA31", hash_generated_method = "6B237842CA626BC83307F2B59EDE8BA9")
    public LogRecordFactory getLogRecordFactory() {
LogRecordFactory varC0BD5E5950F2449E6352DB87354BBE7A_208506924 =         super.logRecordFactory;
        varC0BD5E5950F2449E6352DB87354BBE7A_208506924.addTaint(taint);
        return varC0BD5E5950F2449E6352DB87354BBE7A_208506924;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.906 -0400", hash_original_method = "DD6917F16C5DC825A79D8F74525C77AA", hash_generated_method = "F957FAA7AAA786D636BE4EDD9C4A6ACE")
    @Deprecated
    public EventScanner getEventScanner() {
EventScanner varEC8DCC64E62D14B969E9954E069178A2_269111287 =         eventScanner;
        varEC8DCC64E62D14B969E9954E069178A2_269111287.addTaint(taint);
        return varEC8DCC64E62D14B969E9954E069178A2_269111287;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.906 -0400", hash_original_method = "DDBB9B823124CA2B241AC7D56A934729", hash_generated_method = "7BA92E01BAB3F8C5833BA57C8144A3E1")
    public AuthenticationHelper getAuthenticationHelper(
			AccountManager accountManager, HeaderFactory headerFactory) {
        addTaint(headerFactory.getTaint());
        addTaint(accountManager.getTaint());
AuthenticationHelper var732376F2B9141CE48EB214AC35D81570_1424124786 =         new AuthenticationHelperImpl(this, accountManager, headerFactory);
        var732376F2B9141CE48EB214AC35D81570_1424124786.addTaint(taint);
        return var732376F2B9141CE48EB214AC35D81570_1424124786;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.906 -0400", hash_original_method = "9BC4A63758F96D1DFC890C8072E9A8F9", hash_generated_method = "583F3D810777FDE9F33C18B50D0AA1E4")
    public AuthenticationHelper getSecureAuthenticationHelper(
			SecureAccountManager accountManager, HeaderFactory headerFactory) {
        addTaint(headerFactory.getTaint());
        addTaint(accountManager.getTaint());
AuthenticationHelper var732376F2B9141CE48EB214AC35D81570_1483267925 =         new AuthenticationHelperImpl(this, accountManager, headerFactory);
        var732376F2B9141CE48EB214AC35D81570_1483267925.addTaint(taint);
        return var732376F2B9141CE48EB214AC35D81570_1483267925;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.907 -0400", hash_original_method = "23CB36659469F37B2B1A4E89C6C5A109", hash_generated_method = "EEF876C7AA37CA82F9A54624D848F42A")
    public void setEnabledCipherSuites(String[] newCipherSuites) {
        cipherSuites = newCipherSuites;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.907 -0400", hash_original_method = "15C35F67057574B0384681051DA88AFD", hash_generated_method = "6B05C6559215EF84181B4820C0115C5D")
    public String[] getEnabledCipherSuites() {
String[] var382771CDA26F32E6DB40996913F253EB_468438106 =         cipherSuites;
        var382771CDA26F32E6DB40996913F253EB_468438106.addTaint(taint);
        return var382771CDA26F32E6DB40996913F253EB_468438106;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.907 -0400", hash_original_method = "146720FA6D9E688CD139244E691C1622", hash_generated_method = "367AACC0BB535AEDE0F21EE0BE1604FA")
    public void setEnabledProtocols(String[] newProtocols) {
        enabledProtocols = newProtocols;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.908 -0400", hash_original_method = "36B040AE4C1B32E20301E5CF570A7C53", hash_generated_method = "4EC2E38BA847C26F445D3326E3EA720B")
    public String[] getEnabledProtocols() {
String[] varCDC9FC5D6BF49D946160BBB7AB8D9E24_1937560044 =         enabledProtocols;
        varCDC9FC5D6BF49D946160BBB7AB8D9E24_1937560044.addTaint(taint);
        return varCDC9FC5D6BF49D946160BBB7AB8D9E24_1937560044;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.908 -0400", hash_original_method = "B3A8DF498FA0698B770F05249042765A", hash_generated_method = "247832BB6BF1399D5698679FB8A2FC77")
    public void setIsBackToBackUserAgent(boolean flag) {
        addTaint(flag);
        super.isBackToBackUserAgent = flag;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.908 -0400", hash_original_method = "1623111994CBCA0890DA0FF2A1E140E0", hash_generated_method = "EBF85D4D1976F1BE1F9FA6FD6348D61D")
    public boolean isBackToBackUserAgent() {
        boolean varD0E1830B3357AC4B6481944298D5F3BB_669957186 = (super.isBackToBackUserAgent);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2136889892 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2136889892;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.908 -0400", hash_original_method = "8A30592F142C300BD40BD8A31AEE1D8D", hash_generated_method = "AB4A3571E2D8AC7ECB324BBD96B947D9")
    public boolean isAutomaticDialogErrorHandlingEnabled() {
        boolean var4C59287474C8A9A71E185C320E3F3925_645251092 = (super.isAutomaticDialogErrorHandlingEnabled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_976239745 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_976239745;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.909 -0400", hash_original_method = "1CDF5A6FEBA76AB1A61A70742324066C", hash_generated_method = "3C9BB6DC5DD37E0DE70FEC2D5D44006D")
    public boolean acquireSem() {
        try 
        {
            boolean var526AB99300F043EC436878FAFAA3E3AE_1666946913 = (this.stackSemaphore.tryAcquire(10, TimeUnit.SECONDS));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_346657205 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_346657205;
        } 
        catch (InterruptedException ex)
        {
            boolean var68934A3E9455FA72420237EB05902327_1909554127 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1694988349 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1694988349;
        } 
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.909 -0400", hash_original_method = "2B4EDB484E691FD8761CF130C9353BAF", hash_generated_method = "ABCF4EEA47ACCF6FD64218E3A8D948F5")
    public void releaseSem() {
        this.stackSemaphore.release();
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:34.909 -0400", hash_original_field = "26B86A1C916CC4B7BAB489AF94B9502C", hash_generated_field = "DC1BA291E655CE21E8210560B23E074D")

    public static final Integer MAX_DATAGRAM_SIZE = 8 * 1024;
}

