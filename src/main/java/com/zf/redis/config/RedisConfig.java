//package com.zf.redis.config;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.core.*;
//
//@Configuration
//public class RedisConfig {
//
//    /**
//     * 对hash类型的数据操作
//     *
//     * @param redisTemplate
//     * @return
//     */
//    @Bean
//    public HashOperations<String, String, Object> hashOperations(RedisTemplate redisTemplate) {
//        HashOperations hashOperations = redisTemplate.opsForHash();
//        return hashOperations;
//    }
//
//    /**
//     * 对redis字符串类型数据操作
//     *
//     * @param redisTemplate
//     * @return
//     */
//    @Bean
//    public ValueOperations<String, Object> valueOperations(RedisTemplate redisTemplate) {
//        ValueOperations<String, Object> stringObjectValueOperations = redisTemplate.opsForValue();
//        return stringObjectValueOperations;
//    }
//
//    /**
//     * 对链表类型的数据操作
//     *
//     * @param redisTemplate
//     * @return
//     */
//    @Bean
//    public ListOperations<String, Object> listOperations(RedisTemplate redisTemplate) {
//        ListOperations listOperations = redisTemplate.opsForList();
//        return listOperations;
//    }
//
//    /**
//     * 对无序集合类型的数据操作
//     *
//     * @param redisTemplate
//     * @return
//     */
//    @Bean
//    public SetOperations<String, Object> setOperations(RedisTemplate redisTemplate) {
//        SetOperations setOperations = redisTemplate.opsForSet();
//        return setOperations;
//    }
//
//    /**
//     * 对有序集合类型的数据操作
//     *
//     * @param redisTemplate
//     * @return
//     */
//    @Bean
//    public ZSetOperations<String, Object> zSetOperations(RedisTemplate redisTemplate) {
//        final ZSetOperations zSetOperations = redisTemplate.opsForZSet();
//        return zSetOperations;
//    }
//
//}
