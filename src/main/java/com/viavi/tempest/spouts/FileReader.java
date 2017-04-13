package com.viavi.tempest.spouts;

import java.util.stream.Stream;

/**
 * Created by cra63729 on 13/04/2017.
 */
public interface FileReader {
    Stream<String> getFileLines(String file);
}
