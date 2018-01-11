package CasaLubetkin.JDBCModels;

import java.sql.Timestamp;
import java.util.GregorianCalendar;
import org.javalite.activejdbc.Model;

/**
 *This class is a model that represents the table expenses in the database.
 *Creation date 22/12/2017.
 *Last Update 11/01/2018.
 *@author Gonzalez,Cristian.
*/
public class Egress extends Model{
    static{
        validatePresenceOf("incNum").message("Please provide your incNum.");
        validatePresenceOf("duration").message("Please provide your duration.");
        validatePresenceOf("deliveryItems").message("Please provide your deliveryItems");
        validatePresenceOf("paid").message("Please provide your paid.");
        validatePresenceOf("psychoAssis").message("Please provide your psychoAssis.");
        validatePresenceOf("registrant").message("Please provide your registrant");
        validatePresenceOf("date").message("Please provide your date.");
        validatePresenceOf("month").message("Please provide your month.");
        validatePresenceOf("year").message("Please provide your year.");
    }

    /**
     *function that creates and stores a "egress" in the database.
     *@param incNum it is a number of ingress related to the egress.
     *@param duration it's time to stay in the house.
     *@param lactation is the type of lactation.
     *@param deliveryItems is the state of the elements provided in the ingress.
     *@param paid is an indicator of payment of an optional fee for the stay.
     *@param psychoAssis indicates if the mother withdraws with psychological assistance.
     *@param talks 
     *@param registrant
     *@param child Indicates if the child retires with the mother.
     *@param pendingControl Indicates if the mother withdraws with a pending control in the future.
     * @param date it's the day of the exit.
     * @param month it's the month of the exit.
     * @param year it's the year of the exit.
     *@return true if the record can be stored correctly,otherwise false.
    */
    public static boolean setEgress(int incNum,int duration,String lactation,boolean deliveryItems,
        boolean paid,boolean psychoAssis,String talks,String registrant,boolean child,
        Timestamp pendingControl,int date,int month,int year)
    {
        Egress egress = new Egress();
        egress.set("incNum",incNum);
        egress.set("duration",duration);
        egress.set("lactation",lactation);
        egress.set("deliveryItems",deliveryItems);
        egress.set("paid",paid);
        egress.set("psychoAssis",psychoAssis);
        egress.set("talks",talks);
        egress.set("registrant",registrant);
        egress.set("child",child);
        egress.set("pendingControl",pendingControl);
        egress.set("date",date);
        egress.set("month",month);
        egress.set("year",year);
        return egress.save();        
    }
    
    /**
     * function that returns the date of an exit.
     * @param incomeId is the income id associated with a particular egress.
     * @return the date of an exit.
     */
    public static GregorianCalendar getExitDate(int incomeId){
        Egress egress = Egress.findFirst("incNum = ?",incomeId);
        int year = (int) egress.get("year");
        int month = (int) egress.get("month");
        int day = (int) egress.get("day");
        GregorianCalendar date = new GregorianCalendar(year,month,day);
        return date;
    }
}