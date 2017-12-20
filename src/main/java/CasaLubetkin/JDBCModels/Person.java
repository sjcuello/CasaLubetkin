package CasaLubetkin.JDBCModels;

import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.validation.UniquenessValidator;

public class Person extends Model{
  static{
    validatePresenceOf("DNI").message("Please, insert the DNI of the person");
    validatePresenceOf("lastName").message("Please, insert the last name of the person");
    validatePresenceOf("firstName").message("Please, insert the first name of the person");
    validatePresenceOf("birthDay").message("Please, insert the birth day of the person");
    validatePresenceOf("city").message("Please, insert the city whos live the person");
  }

  public static boolean Person (Integer d, String lm, String fm, int year, int month, int date, Integer c){
    Person p = new Person();
    //Date bd = new Date(year,month,date);
    p.set("DNI",d);
    p.set("lastName",lm);
    p.set("firsName",fm);
    //p.set("birthDay",bd);
    p.set("age",c);
    return p.save();
  }
}