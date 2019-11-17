package ro.amihaescu.elastic.config;

import lombok.extern.java.Log;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
@Log
public class ElasticConfig {

    @Value("${elasticsearch.host:localhost}")
    public String host;
    @Value("${elasticsearch.port:9300}")
    public int port;
    @Value("${elasticsearch.cluster:docker-cluster}")
    public String clusterName;

    @Bean
    public Client client() {
        TransportClient client = null;
        try {
            log.info(String.format("Creating elastic client for host %s and port %d ...", host, port));
            Settings settings = Settings.builder()
                    .put("cluster.name", clusterName)
                    .build();
            client = new PreBuiltTransportClient(settings)
                    .addTransportAddress(new TransportAddress(InetAddress.getByName(host), port));
        } catch (UnknownHostException e) {
            log.severe(String.format("Failed to create elastic client due to exception: %s", e.getMessage()));
        }
        log.info("Successfully created elastic client...");
        return client;
    }
}
