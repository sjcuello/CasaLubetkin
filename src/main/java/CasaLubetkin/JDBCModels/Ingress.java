package CasaLubetkin.JDBCModels;

import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.Model;

/**
 *This class is a model that represents the table incomes in the database.
 *Creation date 22/12/2017.
 *Last Update 22/12/2017.
 *@author Gonzalez,Cristian.
*/
public class Ingress extends Model{
    static{
        validatePresenceOf("idMom").message("Please provide your idMom.");
        validatePresenceOf("reasonHospit").message("Please provide your reasonHospit.");
        validatePresenceOf("idChild").message("Please provide your idChild.");
        validatePresenceOf("companions").message("Please provide your companions.");
        validatePresenceOf("idComp").message("Please provide your idComp.");
        validatePresenceOf("registrant").message("Please provide your registrant.");
    }

    /**
     *function that creates and stores a "ingress" in the database.
     *@param idMom is the id of a record of a "mother" in the database.
     *@param reasonHospit 
     *@param idChild is the id of a record of a "child" in the database.
     *@param companions 
     *@param idComp
     *@param registrant
     *@return true if the record can be stored correctly,otherwise false.
    */
    public static boolean setIngress(int idMom,String reasonHospit,int idChild,boolean companions,int idComp,String registrant){
        Ingress ingress = new Ingress();
        ingress.set("idMom",idMom);
        ingress.set("reasonHospit",reasonHospit);
        ingress.set("idChild",idChild);
        ingress.set("companions",companions);
        ingress.set("idComp",idComp);
        ingress.set("registrant",registrant);
        return ingress.save();
    }
}