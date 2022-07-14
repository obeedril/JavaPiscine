package ex01;

import java.io.FileInputStream;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {

        //прочитать файлы по словам
        List<String> file1 = readFile("D_02/src/ex01/"+args[0]);
         List<String> file2 = readFile("D_02/src/ex01/"+args[1]);
        //создать общий словарь
        Set<String> dictionary = new TreeSet<>();
        dictionary.addAll(file1);
        dictionary.addAll(file2);

       // System.out.printf("dict "+dictionary);

        //создать вектор файл
        Map<String, Integer> map1 =  getWordCount(createEmptyVector(dictionary), file1);
        Map<String, Integer> map2 =  getWordCount(createEmptyVector(dictionary), file2);
        //считаем близость векторов по формуле
//        System.out.println("map1_full = "+map1);
//        System.out.println("map2_full = "+map2);
        String numer = "";
        numer += getCosLength(map1, map2);
//        System.out.printf("Similarity = %.3f", getCosLength(map1, map2));
        System.out.println("Similarity = " +  numer.substring(0, 4));
    }

    public static List<String> readFile(String path) {
//        List<String> words = new ArrayList<>();
//        int k = 0;
//        String str = "";
//
//        try (FileInputStream fileInputStream = new FileInputStream(path)) {
//
//            while ((k = fileInputStream.read()) != -1) {
//                if (k == '\n' || k == ' ') {
//                    words.add(str);
//                    str = "";
//                    continue;
//                }
//                str += (char)k;
//            }
//            if (str != "") {
//                words.add(str);
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//        Iterator<String> iterator = words.iterator();
//        while (iterator.hasNext()) {
//            String item = iterator.next();
//            System.out.println(item);
//        }
//        return words;
            List<String> words = new ArrayList<>();
            String str;
            int k = 0;

            try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
                while ((str = reader.readLine()) != null) {
                    words.addAll(Arrays.asList(str.split(" +")));
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            words.remove("");
            return words;
        }

    public static Map<String, Integer> createEmptyVector(Set<String> dictionary) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : dictionary) {
            map.put(word, 0);
            //System.out.println("map = "+map);
        }
        return map;
    }

    public static Map<String, Integer> getWordCount(Map<String, Integer> map, List<String> words) {
        for (String word : words) {
            map.put(word, map.get(word) + 1);
        }
//        System.out.println("map_full = "+map);
        return map;
    }

    public static Double getCosLength(Map<String, Integer> map1, Map<String, Integer> map2) {
//        System.out.println("map1_full = "+map1);
//        System.out.println("map2_full = "+map2);
        double num = 0;
        double den = 0, den1 = 0, den2 = 0;

//        map1.forEach((k, v) -> map2.merge(k, v, Integer::sum));

        Iterator<Map.Entry<String, Integer>> iter1 = map1.entrySet().iterator();
        Iterator<Map.Entry<String, Integer>> iter2 = map2.entrySet().iterator();
        while (iter1.hasNext() && iter2.hasNext()) {
            Map.Entry<String, Integer> entry1 = iter1.next();
            Map.Entry<String, Integer> entry2 = iter2.next();
            num+= entry1.getValue() * entry2.getValue();
           // System.out.println("num = "+num);
            //System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        iter1 = map1.entrySet().iterator();
        iter2 = map2.entrySet().iterator();
        while (iter1.hasNext()) {
            Map.Entry<String, Integer> entry3 = iter1.next();
            den1 += entry3.getValue() * entry3.getValue();
        }
        while (iter2.hasNext()) {
            Map.Entry<String, Integer> entry4 = iter2.next();
            den2 += entry4.getValue() * entry4.getValue();
        }

        den = Math.sqrt(den1) * Math.sqrt(den2);
        System.out.println("den ="+den);
        double similarity;
        similarity =  num / den;

        System.out.println("sim ="+similarity);

        return similarity;
    }
}
