package CasaLubetkin.JDBCModels;

import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.Model;

/**
 *This class is a model that represents the table mothers in the database.
 *Creation date 03/01/2018.
 *Last Update 03/01/2018.
 *@author Gonzalez,Cristian.
*/
public class Mother extends Model {
    static{
        validatePresenceOf("educLevel").message("Please provide your educLevel.");
        validatePresenceOf("job").message("Please provide your job.");
        validatePresenceOf("address").message("Please provide your address.");
        validatePresenceOf("numChildren").message("Please provide your numChildren.");
        validatePresenceOf("numFamily").message("Please provide your numfamily.");
        validatePresenceOf("GP").message("Please provide your GP.");
        validatePresenceOf("medCenter").message("Please provide your medCenter.");        
    }

    /**
     *function that creates and stores a "Mother" in the database.
     * @param educLevel is the level of education of a mother.
     * @param job is the work that a mother does.
     * @param address is the address of the mother's residence.
     * @param numChildren 
     * @param numFamily
     * @param gp
     * @param medCenter is the id of a record of a "center" in the database.
     * @return true if the record can be stored correctly,otherwise false.
     */
    public static boolean setMom(String educLevel,String job,String address,
            int numChildren,int numFamily,int gp,int medCenter)
    {
        Mother mom = new Mother();
        mom.set("educLevel",educLevel);
        mom.set("job",job);
        mom.set("address",address);
        mom.set("numChildren",numChildren);
        mom.set("numFamily",numFamily);
        mom.set("GP",gp);
        mom.set("medCenter",medCenter);
        return mom.save();
    }
}
