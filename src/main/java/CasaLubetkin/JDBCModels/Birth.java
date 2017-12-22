package CasaLubetkin.JDBCModels;

import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.Model;

/**
 *This class is a model that represents the table births in the database.
 *Creation date 22/12/2017.
 *Last Update 22/12/2017.
 *@author Gonzalez,Cristian.
*/
public class Birth extends Model{
    static{
        validatePresenceOf("idMom").message("Please provide your idMom.");
        validatePresenceOf("idChild").message("Please provide your idChild");
        validatePresenceOf("birth").message("Please provide your birth status");
        validatePresenceOf("gestWeek").message("Please provide your gestWeek");
        validatePresenceOf("pregControl").message("Please provide your pregControl");
        validatePresenceOf("tBirth").message("Please provide your tBirth");
        validatePresenceOf("birthWeigth").message("Please provide your birthWeigth");
        validatePresenceOf("birthPlace").message("Please provide your birthPlace");
        validatePresenceOf("idMed").message("Please provide your idMed.");
        validatePresenceOf("medCenter").message("Please provide your medCenter");
    }

    /**
     *function that creates and stores a "Birth" in the database.
     *@param idMom is the id of a record of a "mother" in the database.
     *@param idChild is the id of a record of a "child" in the database.
     *@param birth it is a state of birth.
     *@param gestWeek is a number of weeks of gestation.
     *@param pregControl it is an indicator of pregnancy control.
     *@param tBirth it´s a type of birt.
     *@param birthWeigth is the weight of the child at birth.
     *@param birthPlace is a birthplace of a child.
     *@param idMed is the id of a record of a "doctor" in the database.
     *@param medCenter is the id of a record of a "center" in the database.
     *@return true if the record can be stored correctly,otherwise false.
    */
    public static boolean setBirth(int idMom,int idChild,String birth,int gestWeek,
        boolean pregControl,String tBirth,int birthWeigth,int birthplace,int idMed,
        int medCenter)
    {
        Birth birth = new Birth();
        birth.set("idMom",idMom);
        birth.set("idChild",idChild);
        birth.set("birth",birth);
        birth.set("gestWeek",gestWeek);
        birth.set("pregControl",pregControl);
        birth.set("tBirth",tBirth);
        birth.set("birthWeigth",birthWeigth);
        birth.set("birthplace",birthplace);
        birth.set("idMed",idMed);
        birth.set("medCenter",medCenter);
        return birth.save();
    }
}