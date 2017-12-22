package CasaLubetkin.JDBCModels;

import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.Model;

/**
 *This class is a model that represents the table derivations in the database.
 *Creation date 22/12/2017.
 *Last Update 22/12/2017.
 *@author Gonzalez,Cristian.
*/
public class Derivation extends Model{
    static{
        validatePresenceOf("idMom").message("Please provide your idMom.");
        validatePresenceOf("idMed").message("Please provide your idMed.");
        validatePresenceOf("medCenter").message("Please provide your medCenter");
    }

    /**
     *function that creates and stores a "derivation" in the database.
     *@param idMom is the id of a record of a "mother" in the database.
     *@param idMed is the id of a record of a "doctor" in the database.
     *@param medCenter is the id of a record of a "center" in the database.
     *@return true if the record can be stored correctly,otherwise false.
    */
    public static boolean setDerivation(int idMom,int idMed,int medCenter){
        Derivation derivation = new Derivation();
        derivation.set("idMom",idMom);
        derivation.set("idMed",idMed);
        derivation.set("medCenter",medCenter);
        return derivation.save();
    }
}