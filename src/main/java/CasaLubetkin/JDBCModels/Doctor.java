package CasaLubetkin.JDBCModels;

import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.validation.UniquenessValidator;

public class Doctor extends Model{
  static {
    validatePresenceOf("name").message("Please, insert the name of the doctor");
  }


  /** 
     * function that return true if the doctor was created correctly
     * otherwise false.
     * @param n is the name of the doctor
     * @pre n != null
     * @post. true is returned if the doctor was created correctly otherwise
     * false.
  **/

  public static boolean createCenter(String n){
    Doctor d = new Doctor();
    d.set("name",n);
    boolean res = d.save();
    return res;
  }

  
}