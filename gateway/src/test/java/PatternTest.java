import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {


    public static void main(String[] args){


        String str = "/moment/users/599/detail";
        String str2 = "/moments/asdfasdfasdf";


        Pattern pt = Pattern.compile("/moments/*");
        Matcher match = pt.matcher(str);

        System.out.println(str.matches("/moment/*"));
        System.out.println(str2.matches("[/moments/** || /moment/**]"));
    }
}
