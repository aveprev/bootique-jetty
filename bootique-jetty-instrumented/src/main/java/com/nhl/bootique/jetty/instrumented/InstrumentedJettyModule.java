package com.nhl.bootique.jetty.instrumented;

import com.codahale.metrics.MetricRegistry;
import com.google.inject.Provides;
import com.nhl.bootique.ConfigModule;
import com.nhl.bootique.config.ConfigurationFactory;
import com.nhl.bootique.jetty.instrumented.server.InstrumentedServerFactory;
import com.nhl.bootique.jetty.server.ServerFactory;

/**
 * @since 0.11
 */
public class InstrumentedJettyModule extends ConfigModule {

	public InstrumentedJettyModule() {
		// reusing overridden module prefix
		super("jetty");
	}

	public InstrumentedJettyModule(String configPrefix) {
		super(configPrefix);
	}

	@Provides
	public ServerFactory createServerFactory(ConfigurationFactory configFactory, MetricRegistry metricRegistry) {
		return configFactory.config(InstrumentedServerFactory.class, configPrefix).initMetricRegistry(metricRegistry);
	}
}
