import java.util.Scanner;


// Prime number must be divided by 1 or, by itself. 
// And it must be a whole number greater than 1
public class TestPrimeNumber {

	
	public TestPrimeNumber() {
		
	}
	public static void test(int countRange){
		
		if(countRange > 1){System.out.println("Please enter correct range");}
		int sum = 0;
		
		for(int i = 2; i<=countRange; i++){
		int count = i/2;
		boolean flag = true;
		for(int j = 2; j <= count; j++){
			if(i%j == 0){
				flag = false;
				break;
			}
		}

		if(flag) {
			System.out.println(i+" is a prime number");
			sum+=i;
		}
	}
		System.out.println("prime number::sum="+sum);
	}
	///////////////////
	public int sumAllPrime(int num){
		int sum = 0;
		int count = 0;
		while(count <= num){
			if(isPrimeNumber(count)){
				sum += count;
				System.out.println("prime::"+count);
			}
			count++;
		}
		return sum;
	}
	public boolean isPrimeNumber(int num){
		boolean isPrime = true;
		
		if(num == 0 || num ==1){
			isPrime = false;
		}
		
		int loopCount = num/2;
			
		for(int count = 2; count <=loopCount; count++){
			if(num%count == 0){
				isPrime = false;
				break;
			}
		}
		
		return isPrime;
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner (System.in);
		int val1 = scan.nextInt();
		TestPrimeNumber testPrimeNumber =new TestPrimeNumber();
		System.out.println("Sum of Prime Number("+val1+")= "+testPrimeNumber.sumAllPrime(val1));
		test(val1);
		/*while(true){
			int val = scan.nextInt();
			if(val==-1) break;
			if (testPrimeNumber.isPrimeNumber(val)){
				System.out.println(val+ " Prime number");
			}else{
				System.out.println(val+ " Not Prime Number");
			}
			
		}*/
	}

}
