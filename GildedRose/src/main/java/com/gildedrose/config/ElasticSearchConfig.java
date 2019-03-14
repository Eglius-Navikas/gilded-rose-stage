package com.gildedrose.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.gildedrose.repositories")
public class ElasticSearchConfig {

    @Value("${elasticsearch.host}")
    private String host;

    @Value("${elasticsearch.port}")
    private int port;

    @Value("${elasticsearch.clustername}")
    private String clusterName;

    @Bean
    public Client client() {
        Settings elasticSettings = Settings.builder()
                .put("cluster.name", this.clusterName)
                .build();
        try (TransportClient client = new PreBuiltTransportClient(elasticSettings)) {
                client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(this.host), this.port));
            return client;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchTemplate(client());
    }
}
