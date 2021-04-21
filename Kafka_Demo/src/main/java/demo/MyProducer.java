package demo;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class MyProducer {
    public static boolean runFun() {
        try {


            Properties properties = new Properties();
            properties.put("bootstrap.servers", "192.168.192.131:9092,192.168.192.132:9092,192.168.192.133:9092");//kafka集群，broker-list
            properties.put("acks", "0");//ack模式，all是最慢但最安全的
            properties.put("retries", 1);//重试次数
            properties.put("batch.size", 16384);//批次大小
            properties.put("linger.ms", 1);//等待时间
            properties.put("buffer.memory", 33554432);//RecordAccumulator缓冲区大小
            properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
            properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

            KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(properties);

            for (int i = 0; i < 111; i++) {
                kafkaProducer.send(new ProducerRecord<String, String>("first","kk->"+i, "vv->"+i));
            }
            kafkaProducer.close();

        }catch (Exception e){
            return false;
        }
        System.out.println("生产者执行结束！");
        return true;
    }
}
