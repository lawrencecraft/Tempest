package com.viavi.tempest.bolts;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * Created by cra63729 on 13/04/2017.
 */
public class WordSplitter {
    public List<String> splitLine(String line) {
        String[] words = StringUtils.split(line, " ,!.\t");
        return Arrays.asList(words);
    }
}
