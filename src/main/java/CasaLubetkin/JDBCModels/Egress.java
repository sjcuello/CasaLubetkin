package CasaLubetkin.JDBCModels;

import java.sql.Timestamp;
import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.Model;

/**
 *This class is a model that represents the table expenses in the database.
 *Creation date 22/12/2017.
 *Last Update 03/01/2018.
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
     *@return true if the record can be stored correctly,otherwise false.
    */
    public static boolean setEgress(int incNum,int duration,String lactation,boolean deliveryItems,
        boolean paid,boolean psychoAssis,String talks,String registrant,boolean child,
        Timestamp pendingControl)
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
        return egress.save();        
    }
}