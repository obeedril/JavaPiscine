package ex02;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

    public class Program {
        public static void main(String[] args) throws IOException, URISyntaxException {
            if (args.length != 1)
            {
                System.err.println("One argument");
                System.exit(-1);
            }
            String path = "file://" + args[0].substring(17);
            System.out.println(path);
            Scanner s = new Scanner(System.in);
            // System.out.println("-> ");
            String str;
            while (s.hasNext()) {
                str = s.nextLine();
                if (str.equals("exit")) {
                    System.exit(0);
                } else if (str.equals("ls")) {
                    Files.list(Paths.get(URI.create(path))).forEach(file -> {
                        System.out.println(file.getFileName()+" " + (long)Math.ceil((double)getSize(file) / 1024) + " KB");
                    });
                } else if (str.startsWith("cd ")) {
                    str = str.substring(3);
                    String newFolder = path + "/" + str;
                    Path newPath = Paths.get(URI.create(newFolder)).normalize();
                    File file = new File(newPath.toString());
                    if (file.isDirectory()) {
                        System.out.println(newPath);
                        path = newFolder;
                    } else {
                        System.out.println("Wrong directory!");
                    }

                } else if (str.startsWith("mv ")) {
                    str = str.substring(3);
                    String argsMv[] = new String[2];
                    argsMv = str.split(" ");

                    Path way1, way2;
                    way1 = Paths.get(path.substring(7) + '/' + argsMv[0]).normalize();
                    way2 = Paths.get(path.substring(7) + '/' + argsMv[1]).normalize();

                    String wayStr1, wayStr2;
                    wayStr1 = way1.toString();
                    wayStr2 = way2.toString();

                    File file1 = new File(wayStr1);
                    File file2 = new File(wayStr2);
                    if (file2.isDirectory()) {
                        wayStr2 = wayStr2 + '/' + argsMv[0];
                    }
                    moveFile(wayStr1, wayStr2);
                }
            }
        }

        public static long getSize(Path path) {
            long size = 0;

            try {
                if (Files.isDirectory(path) && Files.isReadable(path)) {
                    List<Path> collect = Files.list(path).collect(Collectors.toList());
                    for (Path p : collect) {
                        size += getSize(p);
                    }
                }
                return size + Files.size(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return size;
        }

        private static void moveFile(String src, String dest) {
            Path result = null;
            try {
                result = Files.move(Paths.get(src), Paths.get(dest));
            } catch (IOException e) {
                System.out.println("Exception while moving file: " + e.getMessage());
            }
            if (result != null) {
                System.out.println("File moved successfully.");
            } else {
                System.out.println("File movement failed.");
            }
        }
    }