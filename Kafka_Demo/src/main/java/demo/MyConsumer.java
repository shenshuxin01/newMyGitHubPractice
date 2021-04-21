package demo;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

public class MyConsumer {
    public static void runFun() {
        Properties properties = new Properties();
        //kafka集群地址
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.192.131:9092,192.168.192.132:9092,192.168.192.133:9092");
        properties.put(ConsumerConfig.GROUP_ID_CONFIG,"xiaofeizhezu");
        properties.put(ConsumerConfig.GROUP_ID_CONFIG,"xiaofeizhezu");
        properties.put("enable.auto.commit", "true");//自动提交offset
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(properties);
        kafkaConsumer.subscribe(Arrays.asList("first"));


        while (true) {
//            System.out.println("消费者打印消息1");
            ConsumerRecords<String, String> records = kafkaConsumer.poll(10110);
//            System.out.println("消费者打印消息2");
            for (ConsumerRecord<String, String> record : records) {
//                System.out.println("消费者打印消息3");
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
            }
        }

    }
}
