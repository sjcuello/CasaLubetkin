package lubetkin;

import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.validation.UniquenessValidator;

public class Doctor extends Model{
  static {
    validatePresenceOf("name").menssage("Pleas, insert the name of the doctor");
  }


  /** 
     * function that return true if the doctor was created correctly
     * otherwise false.
     * @param n is the name of the doctor
     * @pre n != null
     * @post. true is returned if the doctor was created correctly otherwise
     * false.
  **/

  public static Boolean createCenter(String n){
    Doctor d = new Doctor();
    d.set("name",n);
    Boolean res = d.save();
    return res;
  }

  
}