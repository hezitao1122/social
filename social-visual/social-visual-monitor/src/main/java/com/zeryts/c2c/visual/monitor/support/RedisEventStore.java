package com.zeryts.c2c.visual.monitor.support;

import cn.agree.amap.common.core.constant.CacheConstants;
import cn.hutool.core.util.StrUtil;
import de.codecentric.boot.admin.server.domain.events.InstanceEvent;
import de.codecentric.boot.admin.server.eventstore.InMemoryEventStore;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author zeryts
 * @date 2018/11/12
 * <p>
 * redis store event default 100
 */
@Slf4j
@Configuration
@AllArgsConstructor
public class RedisEventStore extends InMemoryEventStore {

	private final RedisTemplate redisTemplate;

	@Override
	public Mono<Void> append(List<InstanceEvent> events) {
		events.forEach(event -> {
			String key = event.getInstance().getValue() + StrUtil.UNDERLINE + event.getTimestamp().toString();
			log.info("保存实例事件的KEY：{},EVENT: {}", key, event.getType());
			redisTemplate.setKeySerializer(new StringRedisSerializer());
			redisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(InstanceEvent.class));
			redisTemplate.opsForHash().put(CacheConstants.EVENT_KEY, key, event);
		});
		return super.append(events);
	}

}
