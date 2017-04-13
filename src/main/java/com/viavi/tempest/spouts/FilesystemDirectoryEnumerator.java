package com.viavi.tempest.spouts;

import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.util.stream.Collectors;

/**
 * Created by cra63729 on 13/04/2017.
 */
public class FilesystemDirectoryEnumerator implements DirectoryEnumerator {
    @Override
    public List<String> getFilePathsFromDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        File[] listing = directory.listFiles();
        List<String> paths = Arrays.stream(listing).map(File::getAbsolutePath).collect(Collectors.toList());
        return paths;
    }
}
