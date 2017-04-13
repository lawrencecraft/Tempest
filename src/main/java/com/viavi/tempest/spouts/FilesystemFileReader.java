package com.viavi.tempest.spouts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by cra63729 on 13/04/2017.
 */
public class FilesystemFileReader implements FileReader {
    @Override
    public Stream<String> getFileLines(String file) {
        try {
            return Files.lines(Paths.get(file));
        } catch (IOException iox) {
            return null;
        }
    }
}
