package CasaLubetkin.JDBCModels;

import java.util.ArrayList;
import java.util.List;
import org.javalite.activejdbc.Model;

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
     * @return true if the palce was created correctly otherwise
     * false.
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

    /**
     * Function that returns the id of a given place a locality.
     * @param locality is the locality to consult.
     * @return the id of a given place a locality.
     */
    public static int getIdByLocality(String locality) {
        Place place = Place.findFirst("city",locality);
        return (int) place.get("id");
    }

    /**
     * Function that returns all the localities.
     * @return a list with all the localities.
     */
    public static List<String> getAllLocalities(){
        List<Place> places = Place.where("id > 0");
        List<String> localities = new ArrayList<>();
      for(Place place : places) {
          localities.add(place.getString("city"));
      }
      return localities;
    } 
    /**
     * Function that returns all the departments.
     * @return a list with all the departments.
     */
    public static List<String> getAllDepartments(){
        List<String> departments = new ArrayList<>();
        List<Place> places = Place.where("id > 0");
        String department = "";
        for (Place place : places) {
            department =  place.getString("department");
            if(!departments.contains(department)){
                departments.add(department);
            }
        }
        return departments;
    }
    
    /**
     * function that returns all the locations of a department.
     * @param department is the department to consult.
     * @return a list with the ids of all the locations of a department.
     */
    public static List<String> getLocationsOfADepartment(String department){
        List<Place> places = Place.where("department = ?",department);
        List<String> localities = new ArrayList<>();
        for (Place place : places) {
            localities.add(place.getString("city"));
        }
        return localities;
    }
}