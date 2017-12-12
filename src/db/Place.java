package lubetkin;

import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.validation.UniquenessValidator;

public class Place extends Model {

  static {
    validatePresenceOf("city").menssage("Pleas, insert the name of the city");
    validatePresenceOf("departament").menssage("Pleas, insert the name of the departament");
    validatePresenceOf("province").menssage("Pleas, insert the name of the province");
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
  public static Boolean createPlace(String c, String d, String p){
    Place p = new Place();
    p.set("city",c);
    p.set("departament",d);
    p.set("province",p);
    Boolean res = p.save();
    return res;
  }
}