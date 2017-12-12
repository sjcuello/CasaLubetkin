package lubetkin;

import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.validation.UniquenessValidator;

public class Person extends Model{
  static{
    validatePresenceOf("DNI").menssage("Pleas, insert the DNI of the person");
    validatePresenceOf("lastname").menssage("Pleas, insert the last name of the person");
    validatePresenceOf("firstname").menssage("Pleas, insert the first name of the person");
    validatePresenceOf("birthDay").menssage("Pleas, insert the birth day of the person");
    validatePresenceOf("city").menssage("Pleas, insert the city whos live the person");
  }

  public static Boolena Person (Integer d, String lm, String fm, Date bd, Integer c){
    Person p = new Person();
    p.set("DNI",d);
    p.set("lastname",lm);
    p.set("firstname",fm);
    p.set("")
  }
}