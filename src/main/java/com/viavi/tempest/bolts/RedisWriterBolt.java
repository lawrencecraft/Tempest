package com.viavi.tempest.bolts;

import com.viavi.tempest.common.TempestConstants;
import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Tuple;
import redis.clients.jedis.Jedis;

/**
 * Created by kal60675 on 28/04/2017.
 */
public class RedisWriterBolt extends BaseBasicBolt {
    public void incrRedis(int value) {
        Jedis jedis = new Jedis("localhost");
        jedis.incrBy("wordCount", value);
        jedis.close();

    }
    @Override
    public void execute(Tuple input, BasicOutputCollector collector) {
        //String line = input.getStringByField(TempestConstants.STORM_FIELD_LINE);
        int count = input.getIntegerByField(TempestConstants.STORM_FIELD_COUNT);
        incrRedis(count);
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {

    }
}
