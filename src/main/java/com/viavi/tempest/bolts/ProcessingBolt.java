package com.viavi.tempest.bolts;

import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Tuple;

/**
 * Created by cra63729 on 13/04/2017.
 */
public class ProcessingBolt extends BaseBasicBolt {
    @Override
    public void execute(Tuple input, BasicOutputCollector collector) {
        // TODO: Extract line from Tuple
        // TODO: Use WordSplitter
        // TODO: Emit each word to Storm
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {

    }
}
