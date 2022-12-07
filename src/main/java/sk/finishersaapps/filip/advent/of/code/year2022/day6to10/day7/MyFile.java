package sk.finishersaapps.filip.advent.of.code.year2022.day6to10.day7;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyFile {

    private List<MyFile> files;

    private boolean isDirectory;

    private long size;

    private String name;

    private MyFile parent;

    public MyFile() {

        files = new ArrayList<>();
    }

    public List<MyFile> getFiles() {
        return files;
    }

    public void setFiles(List<MyFile> files) {
        this.files = files;
    }

    public boolean isDirectory() {
        return isDirectory;
    }

    public void setDirectory(boolean directory) {
        isDirectory = directory;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addFile(MyFile file) {
        files.add(file);
    }

    public MyFile findDir(String value) {
        if ("..".equals(value)) {
            return parent;
        }
        Optional<MyFile> file = files.stream().filter(searchedFile -> value.equals(searchedFile.getName())).findFirst();
        if (file.isEmpty()) {
            throw new IllegalArgumentException("cannot happen");
        }
        return file.get();
    }

    public void setParent(MyFile parent) {
        this.parent = parent;
    }

    public long calculateSize() {
        if (!isDirectory) {
            return size;
        }
        size = files.stream().mapToLong(MyFile::calculateSize).sum();
        return size;
    }

    public long findSizeOfDirsAtMost(long maxSize) {
        long myDirs = files.stream()
                .filter(file -> file.isDirectory && file.size <= maxSize)
                .mapToLong(file -> file.size)
                .sum();
        long subDirs = files.stream()
                .filter(file -> file.isDirectory)
                .mapToLong(file -> file.findSizeOfDirsAtMost(maxSize))
                .sum();
        return myDirs + subDirs;
    }

    public List<MyFile> getAllDirsWithMinSize(long minSize) {
        List<MyFile> myDirs = files.stream()
                .filter(file -> file.isDirectory && file.size >= minSize)
                .collect(Collectors.toList());

        List<MyFile> subDirs = files.stream()
                .filter(file -> file.isDirectory)
                .flatMap(file -> file.getAllDirsWithMinSize(minSize).stream())
                .collect(Collectors.toList());


        return Stream.concat(myDirs.stream(), subDirs.stream()).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return name + " " + size;
    }
}
