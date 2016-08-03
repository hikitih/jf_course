package javase04.t04;

import java.lang.Object;
import java.io.*;

public class FilmCollectionEditor {
	public static FilmCollection loadCollection(String filename){
		try{
			FileInputStream is = new FileInputStream(System.getProperty("user.dir")
				+"/src/javase04/t04/"+filename);
			ObjectInputStream ois = new ObjectInputStream(is);
			//while(ois.available() > 0){
				FilmCollection collection = (FilmCollection) ois.readObject();
				//collection.viewCollection();
				return collection;
			//}
		} catch (FileNotFoundException e){
			System.out.println(e);
		} catch (IOException e){
			System.out.println(e);
		} catch (ClassNotFoundException e){
			System.out.println(e);
		}
		return null;
	}

	public static boolean saveCollection(FilmCollection collection, String filename){
		try{
			OutputStream os = new FileOutputStream(System.getProperty("user.dir")
				+"/src/javase04/t04/"+filename);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(collection);
			oos.flush();
			oos.close();
			os.close();
			return true;
		} catch (FileNotFoundException e){
			System.out.println(e);
		} catch (IOException e){
			System.out.println(e);
		} return false;
	}

}