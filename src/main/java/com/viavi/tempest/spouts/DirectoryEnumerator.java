package com.viavi.tempest.spouts;

import java.util.List;

/**
 * Created by cra63729 on 13/04/2017.
 */
public interface DirectoryEnumerator {
    List<String> getFilePathsFromDirectory(String directory);
}
