package pl.bae.csv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {

    public static Path
            file = Paths.get("file_tmp.csv");

    public static void readFile() {
        try {

            byte[] lines = Files.readAllBytes(file);
            System.out.println(lines);
            String l = new String(lines);
            System.out.println(l);

            String[] allLines = l.split("\\r");
            Line[] linesObj = new Line[allLines.length-1];

            for(int i=0; i<linesObj.length; i++){
                String[] result =  allLines[i+1].split(",");
                System.out.println(result[0]);

                linesObj[i] = new Line(
                        result[0],
                        result[1],
                        result[2],
                        result[3],
                        Integer.parseInt(result[4]),
                        Integer.parseInt(result[5]),
                        Integer.parseInt(result[6]),
                        result[7],
                        result[8],
                        Integer.parseInt(result[9]),
                        Double.parseDouble(result[10]),
                        Double.parseDouble(result[11]));
            }
            //file_tmp.csv = 10 lini
            Map<String, List<Line>> map = new HashMap<>();

            for (Line line: linesObj){

                String key = line.getCity();
                System.out.println(key);
                List<Line> lista = map.get(key);
                if (lista == null){
                    List<Line> lineList = new ArrayList<>();
                    lineList.add(line);
                    map.put(key, lineList);
                }else {
                    List<Line> newList = map.get(key);
                    newList.add(line);
                    map.put(key,newList);
                }
            }
            System.out.println(map);



        } catch (IOException error) {
            error.printStackTrace();
        }
    }
}
