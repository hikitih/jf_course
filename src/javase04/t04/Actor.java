package javase04.t04;

import java.util.Date;
import java.util.ArrayList;

public class Actor implements java.io.Serializable {
	private String surname;
	private String name;
	private boolean sex = false; //true = male, false = female
	private Date birthdate;
	private ArrayList<Film> films = new ArrayList<>();

	public Actor(){
	}

	public Actor(String surname, String name){
		setSurname(surname);
		setName(name);
	}

	public Actor(String surname, String name, boolean sex, Date birthdate){
		setSurname(surname);
		setName(name);
		setSex(sex);
		setBirthdate(birthdate);
	}

	public void addFilm(Film film){
		films.add(film);
	}

	public boolean deleteFilm(Film film){
		int k = films.indexOf(film);
		if (k>-1){
			films.remove(k);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean equals(Object ob){
		if ((ob == null)||(getClass() != ob.getClass())) {
			return false;
		} else {
			Actor actor = (Actor) ob;
			if ((this.surname == actor.surname)&&(this.name==actor.name)
				/*&&(this.birthdate==actor.birthdate)*/){
				return true;
			} else return false;
		}
	} 

	@Override
	public int hashCode(){
		char c1 = surname.charAt(0);
		char c2 = name.charAt(0);
		return c1*57+c2;
	}


	public String getSurname(){
		return surname;
	}
	public String getName(){
		return name;
	}
	public Date getBirthdate(){
		return birthdate;
	}
	public boolean getSex(){
		return sex;
	}
	public void setSurname(String newSurname){
		if (newSurname.length()>0) surname = newSurname;
	}
	public void setName(String newName){
		if (newName.length()>0) name = newName;		
	}
	public void setBirthdate(Date newBirthdate){
		birthdate = newBirthdate;
	}
	public void setSex(boolean newSex){
		sex = newSex;
	}
}