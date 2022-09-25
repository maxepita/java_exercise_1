import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Freq implements Command{
    @Override
    public String name() {
        return "freq";
    }

    @Override
    public boolean run(Scanner testing){
        System.out.println(freq());
        return false;
    }


    public static String freq() {
        List<String> myList5 = new ArrayList<>();
        try {
            System.out.println("entrez votre path file");
            Scanner scan = new Scanner(System.in);
            String fichier = Files.readString(Path.of(scan.nextLine()));

            String result = fichier.toLowerCase().replaceAll("\\p{Punct}", "");
            String test = result.trim().replaceAll(" +", " ");
            String test2 = test.trim().replaceAll("\\n", " ");

            List<String> myList = Arrays.asList(test2.split(" "));
            Map<String, Integer> total = new HashMap<>();

            List<Object> myList4 = new ArrayList<>();


            for (int i=0 ; i < myList.size(); i++) {
                total.putIfAbsent(myList.get(i),Collections.frequency(myList, myList.get(i)));
            }

            List<Map.Entry<String, Integer>> myList3 = new ArrayList<>(total.entrySet());

            myList3.sort((e1, e2) -> e2.getValue() - e1.getValue());

            int count = 0;
            int i =0;

            while (count<3){

                if (myList3.get(i).toString().charAt(0) != '=' ){
                    myList4.add(myList3.get(i));
                    count+=1;
                }
                i++;

            }
            String str;
            int tmp;

            for (Object o : myList4) {
                tmp = o.toString().indexOf("=");
                str = o.toString().substring(0, tmp);
                myList5.add(str);
            }


        } catch (IOException e) {
            System.out.println("Unreadable file: "+ e);

        }
        return String.join(" ", myList5);
    }
}