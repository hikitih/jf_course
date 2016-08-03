package javase04.t04;

import java.util.ArrayList;
import java.util.Date;
import java.text.*;

public class FilmCollection implements java.io.Serializable {
	private ArrayList<Film> films = new ArrayList<Film>();
	private ArrayList<Actor> actors = new ArrayList<Actor>();

	public Actor getActor(String surname, String name){
		Actor actor = new Actor(surname,name);
		int k = findActor(actor);
		if (k>0) return actors.get(k);
		else return null;
	}

	public void addFilm(String title, String genre, int year){
		Film film = new Film(title,genre,year);
		if (findFilm(film)<0) films.add(film);
	}

	public void addActor(String surname, String name, boolean sex){
		addActor(surname,name,sex,"01.01.1980");
	}

	public void addActor(String surname, String name, boolean sex, String birthdate){
		DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		try {
			Date date = format.parse(birthdate);
			addActor(surname,name,sex,date);
		} catch(ParseException e){
			System.out.println("Wrong birthdate of "+surname+" "+name);
		}
	}

	public void addActor(String surname, String name, boolean sex, Date birthdate){
		Actor actor = new Actor(surname,name,sex,birthdate);
		if (findActor(actor)<0) actors.add(actor);
	}

	public boolean addActorToFilm(String surname, String name, String title, int year){
		Actor actor = new Actor(surname,name);
		Film film = new Film(title,"",year);
		int k = findFilm(film);
		if (k>-1) {
			film = films.get(k);
			if (!film.hasActor(actor)) film.addActor(actor);
			return true;
		} else return false;
	}

	public boolean addActorToFilm(Actor actor, String title, int year){
		Film film = new Film(title,"",year);
		int k = findFilm(film);
		if (k>0) {
			film = films.get(k);
			if (!film.hasActor(actor)) film.addActor(actor);
			return true;
		} else return false;
	}

	public boolean deleteFilm(String title, int year){
		Film film = new Film(title,"",year);
		int k = findFilm(film);
		if (k>0) {
			films.remove(k);
			return true;
		} else return false;
	}

	public int findFilm(Film film){		
		int k = -1;
		for (Film oldFilm: films){
			if (film.equals(oldFilm)) k = films.indexOf(oldFilm);
		}
		return k;
	}

	public int findActor(Actor actor){		
		int k = -1;
		for (Actor oldActor: actors){
			if (actor.equals(oldActor)) k = actors.indexOf(oldActor);
		}
		return k;
	}

	public void viewCollection(){
		System.out.println("There are "+films.size()+" films in collection");
		for (Film film: films){
			film.viewInfo();
		}
	}
}