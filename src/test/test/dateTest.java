package test;

import org.junit.Test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Auther: dc
 * @Date: 2019/8/31 11:33
 * @Description:
 */
public class dateTest {

    @Test
    public void demo(){
        try {
            String str = "2018-08-19 24:00:00";
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = format.parse(str);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
