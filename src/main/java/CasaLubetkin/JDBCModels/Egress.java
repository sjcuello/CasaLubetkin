package CasaLubetkin.JDBCModels;

import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.Model;

/**
 *This class is a model that represents the table expenses in the database.
 *Creation date 22/12/2017.
 *Last Update 22/12/2017.
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
        set("incNum",incNum);
        set("duration",duration);
        set("lactation",lactation);
        set("deliveryItems",deliveryItems);
        set("paid",paid);
        set("psychoAssis",psychoAssis);
        set("talks",talks);
        set("registrant",registrant);
        set("child",child);
        set("pendingControl",pendingControl);
        return egress.save();        
    }
}