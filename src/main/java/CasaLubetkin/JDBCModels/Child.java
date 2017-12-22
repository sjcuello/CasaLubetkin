package CasaLubetkin.JDBCModels;

import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.Model;

/**
 *This class is a model that represents the table childrens in the database.
 *Creation date 22/12/2017.
 *Last Update 22/12/2017.
 *@author Gonzalez,Cristian.
*/
public class Child extends Model{
    static{
        validatePresenceOf("hospit").message("Please provide your hospit");
        validatePresenceOf("reasonHospit").message("Please provide your reasonHospit");
        validatePresenceOf("previuosHospit").message("Please provide your previousHospit");
        validatePresenceOf("GP").message("Please provide your GP");
        validatePresenceOf("medCenter").message("Please provide your medCenter");
    }

    /**
     *function that creates and stores a "child" in the database.
     *@param hospit is the type of hospitalization that the child has.
     *@param reasonHospit is the reason why the child was hospitalized.
     *@param previousHospit indicates whether the child was previously hospitalized.
     *@param GP is the id of a record of a "doctor" in the database.
     *@param medCenter is the id of a record of a "center" in the database.
     *@return true if the record can be stored correctly,otherwise false.
    */
    public static boolean setChild(String hospit,String reasonHospit,boolean previousHospit,int gp,int medCenter){
        Child child = new Child();
        child.set("hospit",hospit);
        child.set("reasonHospit",reasonHospit);
        child.set("previousHospit",previousHospit);
        child.set("GP",gp);
        child.set("medCenter",medCenter);
        return child.save();
    }
}