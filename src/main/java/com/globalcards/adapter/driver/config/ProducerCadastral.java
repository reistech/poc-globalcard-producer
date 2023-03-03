package com.globalcards.adapter.driver.config;


import io.smallrye.common.annotation.Identifier;
import io.vertx.rabbitmq.RabbitMQOptions;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Produces;

@ApplicationScoped
public class ProducerCadastral {

    @Inject
    VhostConfiguration config;

    @Produces
    @Identifier("options")
    public RabbitMQOptions getNamedOptions() {

        // You can use the produced options to configure the TLS connection
        return new RabbitMQOptions()
                .setTrustAll(true)
                .setSsl(true)
                .setUser(config.getUser())
                .setPassword(config.getPassword())
                .setHost(config.getHost())
                .setPort(config.getPort())
                .setVirtualHost(config.getVhost())
                .setConnectionTimeout(config.getConnectionTimeout())
                .setRequestedHeartbeat(config.getRequestedHeartbeat())
                .setHandshakeTimeout(config.getHandshakeTimeout())
                .setRequestedChannelMax(config.getRequestedChannelMax())
                .setNetworkRecoveryInterval(config.getNetworkRecoveryInterval())
                .setAutomaticRecoveryEnabled(true);
    }
}
