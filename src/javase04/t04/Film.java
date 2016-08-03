package javase04.t04;

import java.util.ArrayList;

public class Film implements java.io.Serializable {
	private String title = " ";
	private Genre genre;
	private int year = 0;
	private ArrayList<Actor> actors = new ArrayList<>();

	public Film(){
	}

	public Film(String title, String genre, int year){
		setTitle(title);
		setGenre(genre);
		setYear(year);
	}

	public boolean hasActor(Actor actor){
		boolean result = false;
		for (Actor a: actors) {
			if (a.equals(actor)) result = true;
		}
		return result;
	}

	public void addActor(Actor actor){
		actors.add(actor);
	}

	public boolean deleteActor(Actor actor){
		int k = actors.indexOf(actor);
		if (k>-1){
			actors.remove(k);
			return true;
		} else {
			return false;
		}
	}

	public void viewInfo(){
		String s=" : ";
		for (Actor actor: actors) {s=s+actor.getSurname()+" "+actor.getName()+", ";}
		System.out.print(title + ", " + genre + ", " + year);
		System.out.println(s);
	}

	@Override
	public boolean equals(Object ob){
		if ((ob == null)||(getClass() != ob.getClass())) {
			return false;
		} else {
			Film film = (Film) ob;
			if ((this.title == film.title)&&(this.year==film.year)){
				return true;
			} else return false;
		}
	} 

	@Override
	public int hashCode(){
		char c = title.charAt(0);
		return year*37+c;
	}

	public String getTitle(){
		return title;
	}
	public Genre getGenre(){
		return genre;
	}
	public int getYear(){
		return year;
	}
	public void setTitle(String newTitle){
		if (newTitle=="") title = " ";
		else title = newTitle;
	}
	public void setGenre(Genre newGenre){
		genre = newGenre;
	}
	public void setGenre(String newGenre){
		switch (newGenre.toUpperCase()){
			case "ACTION": 		this.setGenre(Genre.ACTION);
						break;
			case "ADVENTURE": 	this.setGenre(Genre.ADVENTURE);
						break;
			case "COMEDY": 		this.setGenre(Genre.COMEDY);
						break;
			case "DOCUMENTARY": 	this.setGenre(Genre.DOCUMENTARY);
						break;
			case "DRAMA": 		this.setGenre(Genre.DRAMA);
						break;
			case "TRILLER": 	this.setGenre(Genre.TRILLER);
						break;
			case "HORROR": 		this.setGenre(Genre.HORROR);
						break;
			case "SCIFI": 		this.setGenre(Genre.SCIFI);
						break;
			case "SCI-FI": 		this.setGenre(Genre.SCIFI);
						break;
			default:		this.setGenre(Genre.ANOTHER);
		}	
	}
	public void setYear(int newYear){
		year = newYear;
	}
}