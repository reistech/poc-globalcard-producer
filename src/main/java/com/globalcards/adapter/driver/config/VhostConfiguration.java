package com.globalcards.adapter.driver.config;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithName;

@ConfigMapping(prefix = "vhost-router")
public interface VhostConfiguration {

    @WithName("vhost")
    String getVhost();

    @WithName("user")
    String getUser();

    @WithName("pass")
    String getPassword();

    @WithName("host")
    String getHost();

    @WithName("port")
    Integer getPort();

    @WithName("connection.timeout")
    Integer getConnectionTimeout();

    @WithName("requested.heartbeat")
    Integer getRequestedHeartbeat();

    @WithName("handshake.timeout")
    Integer getHandshakeTimeout();

    @WithName("requested.channel.max")
    Integer getRequestedChannelMax();

    @WithName("network.recovery.interval")
    Integer getNetworkRecoveryInterval();

}
