package com.viavi.tempest;

import com.viavi.tempest.bolts.WordSplitter;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class GivenAWordSplitterClass {

    @Test
    public void LineCanBeSplitIntoWords() {
        WordSplitter splitter = new WordSplitter();
        List<String> words = splitter.splitLine("\ttwenty to follow mine own teaching. The brain may");
        Assert.assertEquals(9, words.size());
    }
}
