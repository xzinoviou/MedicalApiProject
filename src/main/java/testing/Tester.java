package testing;

import model.Medicine;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by xzinoviou
 * 16/10/2018
 */
public class Tester {

    public static void main(String[] args){


        Medicine medicine = new Medicine();

        //String str = {"data":{"id":1,"key":"EMEA000520","name":"Advate","description":"Advate is indicated for treatment and prophylaxis of bleeding in patients with haemophilia A (congenital factor-VIII deficiency. AAAAA","price":59.85,"isValid":true,"producer":"Baxter AG"}};

        //String

        //String s1 = "{\"id":1,"key":"EMEA000520","name":"Advate","description":"Advate is indicated for treatment and prophylaxis of bleeding in patients with haemophilia A (congenital factor-VIII deficiency. AAAA","price":59.85,"isValid":true,"producer":"Baxter AG"}"";




/*

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String dateStr = request.getParameter("date");
        Date dateConverted = simpleDateFormat.format(dateStr);


*/
        String dateStr = "10/01/2018";
        String htmlPattern = "MM-dd-yyyy";
        String sqlPattern = "yyyy-MM-dd";
        //Date myDate =

        //System.out.println(myDate);


    }
}
