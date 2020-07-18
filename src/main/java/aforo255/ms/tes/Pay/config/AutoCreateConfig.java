package aforo255.ms.tes.Pay.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class AutoCreateConfig {
	@Bean
	public NewTopic depositEvents() {

		return TopicBuilder.name("operation-events")
				.partitions(3)
				.replicas(1)
				.build();
	}
}
