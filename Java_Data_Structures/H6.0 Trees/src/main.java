/*this histogram will show the words in the first two verses of the raven by edgar allen poe
*/
import java.util.Scanner;
import java.io.Reader;
import java.io.FileReader;
public class main {

	public static void main(String[] args) {
		Tree t = new Tree();
		String filename = "src/raven.txt";
		/*t.insert("data");
		t.insert("structures");
		t.insert("file");
		t.insert("analysis");
		t.insert("file");
		t.insert("data");
		t.insert("data");*/
		
		
		//This is the filereader that scans for words in a .txt file
		try{
			Scanner s = new Scanner(new FileReader(filename));
			while(s.hasNext()){
				t.insert(s.next());
			}
			s.close();
		}
		catch(Exception e){
			System.err.format("Exception occurred trying to read '%s'.", filename);
		    e.printStackTrace();
		}
		t.inorder();
		

	}

}
