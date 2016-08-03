package javase04.t04;

//import java.util.ArrayList;
import java.lang.Object;
import java.io.*;

public class Try {
	public static void main(String[] args){
		FilmCollection collection = new FilmCollection();
		
		collection.addFilm("First","action",1990);
		collection.addFilm("Second","DrAmA",1993);
		collection.addFilm("Third","sci-fi",1994);
		collection.addFilm("Fourth","Adventure",1997);
		collection.addFilm("Fifth","HoRRoR",2009);
		collection.addFilm("Sixth","COMEDY",2017);

		collection.addActor("Black","Jim",true,"02.03.1956");
		collection.addActor("White","Jim",true,"03.01.1986");
		collection.addActor("Brown","Adam",true,"05.06.1977");
		collection.addActor("Blue","Samantha",true,"06.11.1975");
		collection.addActor("Blue","Carry",true,"13.08.1998");
		collection.addActor("Clay","Slay",true,"19.03.1985");

		collection.addActorToFilm("Black","Jim","First",1990);
		collection.addActorToFilm("Brown","Adam","Second",1993);
		collection.addActorToFilm("White","Jim","Second",1993);
		collection.addActorToFilm("Blue","Samantha","Third",1994);
		collection.addActorToFilm("Blue","Carry","Fourth",1997);
		collection.addActorToFilm("Clay","Slay","Second",1997);
		collection.addActorToFilm("Clay","Slay","Ferst",1990);
		collection.addActorToFilm("Brown","Adam","First",1990);
		collection.addActorToFilm("Brown","Adam","First",1990);

		collection.viewCollection();

		if (FilmCollectionEditor.saveCollection(collection,"MyFirst.bin")) {
			System.out.println("\nCollection successfully saved to MyFirst.bin");
		} else  System.out.println("\nFailed to save the collection");


		System.out.println("\nLoading collection from file MyFirst.bin\n");
		collection = FilmCollectionEditor.loadCollection("MyFirst.bin");
		collection.viewCollection();
	}	
}