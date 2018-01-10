package CasaLubetkin.JDBCModels;

import java.util.List;
import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.Model;

/**
 *This class is a model that represents the table incomes in the database.
 *Creation date 22/12/2017.
 *Last Update 10/01/2018.
 *@author Gonzalez,Cristian.
*/
public class Ingress extends Model{
    static{
        validatePresenceOf("idMom").message("Please provide your idMom.");
        validatePresenceOf("idLocality").message("Please provide your idLocality.");
        validatePresenceOf("reasonHospit").message("Please provide your reasonHospit.");
        validatePresenceOf("idChild").message("Please provide your idChild.");
        validatePresenceOf("companions").message("Please provide your companions.");
        validatePresenceOf("idComp").message("Please provide your idComp.");
        validatePresenceOf("registrant").message("Please provide your registrant.");
        validatePresenceOf("date").message("Please provide your date.");
        validatePresenceOf("month").message("Please provide your month.");
        validatePresenceOf("year").message("Please provide your year.");
    }

    /**
     *function that creates and stores a "ingress" in the database.
     *@param idMom is the id of a record of a "mother" in the database.
     *@param idLocality is the id from the town of origin.
     *@param reasonHospit 
     *@param idChild is the id of a record of a "child" in the database.
     *@param companions 
     *@param idComp
     *@param registrant
     *@param date it's the day of entry.
     *@param month it's the month of entry.
     *@param year it's the year of entry.
     *@return true if the record can be stored correctly,otherwise false.
    */
    public static boolean setIngress(int idMom,int idLocality,String reasonHospit,int idChild,
        boolean companions,int idComp,String registrant,int date,int month,int year){
        Ingress ingress = new Ingress();
        ingress.set("idMom",idMom);
        ingress.set("idLocality",idLocality);
        ingress.set("reasonHospit",reasonHospit);
        ingress.set("idChild",idChild);
        ingress.set("companions",companions);
        ingress.set("idComp",idComp);
        ingress.set("registrant",registrant);
        ingress.set("date",date);
        ingress.set("month",month);
        ingress.set("year",year);
        return ingress.save();
    }
    
    /**
     * this function returns the number of annual revenues from a given location in a particular year.
     * @param year is the year to consult.
     * @param locality is the town to consult.
     * @return the number of annual revenues from a given location in a particular year.
     */
    public static int getAnnualIncomeByLocality(int year,String locality){
        int idPlace = Place.getIdByLocality(locality);
        List<Ingress> annualIncomes = Ingress.where("year = '"+year+"'and idPlace = '"+idPlace+"'");
        return annualIncomes.size();
    }
    
    /**
     * this function returns the number of monthly revenues from a given location in a particular year.
     * @param month is the monthly to consult.
     * @param locality is the town to consult.
     * @return the number of monthly revenues from a given location in a particular year.
     */
    public static int getMonthlyIncomeByLocality(int month,String locality){
        int idPlace = Place.getIdByLocality(locality);
        List<Ingress> annualIncomes = Ingress.where("month = '"+month+"'and idPlace = '"+idPlace+"'");
        return annualIncomes.size();
    }
    
    /**
     * this function returns the number of annual revenues from a given location in a particular year.
     * @param year is the year to consult.
     * @param department is the department to consult.
     * @return the number of annual revenues from a given location in a particular year.
     */
    public static int getAnnualIncomeByDepartment(int year,String department){
        int idPlace = Place.getIdByDepartment(department);
        List<Ingress> annualIncomes = Ingress.where("year = '"+year+"'and idPlace = '"+idPlace+"'");
        return annualIncomes.size();
    }
    
    /**
     * this function returns the number of monthly revenues from a given location in a particular year.
     * @param month is the year to consult.
     * @param department is the department to consult.
     * @return the number of monthly revenues from a given location in a particular year.
     */
    public static int getMonthlyIncomeByDepartment(int month,String department){
        int idPlace = Place.getIdByDepartment(department);
        List<Ingress> annualIncomes = Ingress.where("month = '"+month+"'and idPlace = '"+idPlace+"'");
        return annualIncomes.size();
    }
    
}