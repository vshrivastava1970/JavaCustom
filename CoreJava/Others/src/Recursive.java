
public class Recursive {

	public Recursive() {
		// TODO Auto-generated constructor stub
	}

	public static void printChar(String str, int index){
			if(index < str.length()){
				System.out.println(str.charAt(index));
				index++;
				printChar(str, index);
			}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 printChar("printChar", 0);
	}

}
