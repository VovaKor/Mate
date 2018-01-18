package com.korobko.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.mem.InMemoryUsersConnectionRepository;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;

/**
 * @author Vova Korobko
 */
@EnableSocial
@Configuration
public class SocialConfig implements SocialConfigurer {
    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer connectionFactoryConfigurer, Environment environment) {
        connectionFactoryConfigurer.addConnectionFactory(new FacebookConnectionFactory(
                environment.getProperty("app.id"),
                environment.getProperty("app.secret")));
    }

    @Override
    public UserIdSource getUserIdSource() {
        return new UserIdSource() {
            @Override
            public String getUserId() {
                return "userId";
            }
        };
    }

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        return new InMemoryUsersConnectionRepository(connectionFactoryLocator);
    }

    @Bean
    public FacebookTemplate facebookTemplate(Environment env) {
        return new FacebookTemplate(env.getProperty("access.token"), env.getProperty("app.name"));
    }
}
