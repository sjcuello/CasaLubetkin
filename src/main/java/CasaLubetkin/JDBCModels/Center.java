package CasaLubetkin.JDBCModels;

import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.validation.UniquenessValidator;

public class Center extends Model{
  
    static {    
  	validatePresenceOf("name").message("Please, insert the name of the center");
        validatePresenceOf("city").message("Say the city where the center is");  
    }

  /** 
     * function that return true if the center was created correctly
     * otherwise false.
     * @param n is the name of the center created
     * @param i is the id of the city of the city where is the center
     * @pre n != null, i>0
     * @post. true is returned if the center was created correctly otherwise
     * false.
  **/

  public static boolean createCenter(String n, int i){
    Center c = new Center();
    c.set("name",n);
    c.set("id",i);
    boolean res = c.save();
    return res;
  }
}