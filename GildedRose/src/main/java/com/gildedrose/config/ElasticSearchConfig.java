package com.gildedrose.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
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

    private String elasticHome = "C:\\ProgramData\\Elastic\\Elasticsearch";
    private String clustername = "elasticsearch";

    @Bean
    public Client client() {
        Settings elasticSettings = Settings.builder()
                .put("client.transport.sniff", true)
                .put("path.home", elasticHome)
                .put("cluster.name", clustername)
                .build();
        TransportClient client = new PreBuiltTransportClient(elasticSettings);
        try {
            client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
        return client;
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchTemplate(client());
    }
}
