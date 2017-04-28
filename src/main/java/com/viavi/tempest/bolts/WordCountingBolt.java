package com.viavi.tempest.bolts;

import com.viavi.tempest.common.TempestConstants;
import org.apache.storm.Config;
import org.apache.storm.Constants;
import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by kal60675 on 28/04/2017.
 */
public class WordCountingBolt extends BaseBasicBolt {

    int counter = 0;

    @Override
    public Map<String, Object> getComponentConfiguration() {
        // configure how often a tick tuple will be sent to our bolt
        Config conf = new Config();
        conf.put(Config.TOPOLOGY_TICK_TUPLE_FREQ_SECS, 5);
        return conf;
    }

    protected static boolean isTickTuple(Tuple tuple) {
        return tuple.getSourceComponent().equals(Constants.SYSTEM_COMPONENT_ID)
                && tuple.getSourceStreamId().equals(Constants.SYSTEM_TICK_STREAM_ID);
    }

    @Override
    public void execute(Tuple input, BasicOutputCollector collector) {

        try {
            if (isTickTuple(input)) {
                if(counter > 0) {
                    List<Object> content = new ArrayList<Object>();
                    content.add(content);
                    collector.emit(content);
                    counter = 0;
                }
                return;
            }
            else{
                counter++;
            }
        } catch (Exception e) {
            //LOG.error("Bolt execute error: {}", e);
            collector.reportError(e);
        }
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields(TempestConstants.STORM_FIELD_COUNT));
    }
}
