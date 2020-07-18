package aforo255.ms.tes.Pay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import aforo255.ms.tes.Pay.domain.OperationRedis;
@SpringBootApplication
public class Application {
	
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	}

	@Bean
	RedisTemplate<String, OperationRedis> redisTemplate() {
		RedisTemplate<String, OperationRedis> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
 	}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
