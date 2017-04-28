package com.viavi.tempest.bolts;

import com.viavi.tempest.common.TempestConstants;
import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cra63729 on 13/04/2017.
 */
public class ProcessingBolt extends BaseBasicBolt {

    private final WordSplitter _wordSplitter;

    public ProcessingBolt() {
        _wordSplitter = new WordSplitter();
    }

    @Override
    public void execute(Tuple input, BasicOutputCollector collector) {
        String line = input.getStringByField(TempestConstants.STORM_FIELD_LINE);
        for ( String word: _wordSplitter.splitLine(line) ) {
            emitToStorm(word, collector);
        }
    }

    private void emitToStorm(String word, BasicOutputCollector collector) {
        List<Object> content = new ArrayList<Object>();
        content.add(word);
        collector.emit(content);
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields(TempestConstants.STORM_FIELD_WORD));
    }
}
