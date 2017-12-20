package CasaLubetkin.JDBCModels;

import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.validation.UniquenessValidator;

public class Place extends Model {

  static {
    validatePresenceOf("city").message("Pleas, insert the name of the city");
    validatePresenceOf("departament").message("Pleas, insert the name of the departament");
    validatePresenceOf("province").message("Pleas, insert the name of the province");
  }
  
  /** 
     * function that return true if the palce was created correctly
     * otherwise false.
     * @param c is the name of the city created
     * @param d is the name of the departament of the city created
     * @param p is the name of the province of the city created
     * @pre c,d,p != null
     * @post. true is returned if the palce was created correctly otherwise
     * false.
     */
  public static boolean createPlace(String c, String d, String p){
    Place pl = new Place();
    pl.set("city",c);
    pl.set("departament",d);
    pl.set("province",p);
    boolean res = pl.save();
    return res;
  }
}