package org.newtutorials.rabbitmq.cofiguration;

import org.newtutorials.rabbitmq.receiver.MessageReceiver;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.JsonMessageConverter;
import org.springframework.amqp.support.converter.SerializerMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dani on 5/22/2017.
 */
@Configuration
public class RabbitConfiguration {

    public static final String JSON_QUEUE_NAME = "jsonQueue";
    public static final String SERIALIZER_QUEUE_NAME = "serializerQueue";

    @Value("${spring.rabbitmq.host:#{null}}")
    String host;
    @Value("${spring.rabbitmq.port:#{null}}")
    Integer port;
    @Value("${spring.rabbitmq.username:#{null}}")
    String username;
    @Value("${spring.rabbitmq.password:#{null}}")
    String password;

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(
                host, port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setConnectionTimeout(100);
        return connectionFactory;
    }




}
