package com.viavi.tempest.spouts;

import com.viavi.tempest.common.TempestConstants;
import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

import java.util.List;
import java.util.Map;

/**
 * Created by cra63729 on 13/04/2017.
 */
public class LineEmittingSpout extends BaseRichSpout{

    private List<String> _filesToEmmit;
    private FileReader _fileReader;
    private SpoutOutputCollector _collector;


    @Override
    public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
        DirectoryEnumerator directoryEnumerator = new FilesystemDirectoryEnumerator();
        _filesToEmmit = directoryEnumerator.getFilePathsFromDirectory("C:\\Git\\Tempest\\plays\\Shakespeare");
        _collector = collector;
        _fileReader = new FilesystemFileReader();
    }

    @Override
    public void nextTuple() {
        for (String file: _filesToEmmit) {
            _fileReader.getFileLines(file).forEach(line -> emitToStorm(line));
        }
    }

    private void emitToStorm(String line) {
        _collector.emit(new Values(line));
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields(TempestConstants.STORM_FIELD_LINE));
    }
}
