import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	Scanner scan = new Scanner(System.in);
	ArrayList <Data> aData = new ArrayList<>();
	
	
	void view() {
		int choose;
		if(aData.size()==0) {
			System.out.printf("No. |%-20s |%-20s|\n", "Type" ,"Name");
			for(int i = 0; i <1; i++) {
				System.out.printf("%2d. |%-20s |%-20s|\n",(i+1), " ", " ");
			}
			System.out.println("Input data first!");
			scan.nextLine();
			menu();
		}
		else {
			System.out.printf("No. |%-20s |%-20s|\n", "Type" ,"Name");
			for(int i = 0; i <aData.size(); i++) {
				System.out.printf("%2d. |%-20s |%-20s|\n",(i+1), aData.get(i).type ,aData.get(i).name);
			}
			do {
			System.out.print("Pick a vehicle number to test drive [Enter 0 to exit]:");
			choose=scan.nextInt();scan.nextLine();
			}while(choose<0||choose>aData.size()+1);
			if(choose==0) {
				menu();
			}else {		
		
			choose-=1;
			String typeL = aData.get(choose).type;
			String boost = aData.get(choose).tType;
			System.out.println("Brand: "+aData.get(choose).brand);
			System.out.println("Name: "+aData.get(choose).name);
			System.out.println("License Plate: "+aData.get(choose).license);
			System.out.println("Type: "+aData.get(choose).tType);
			System.out.println("Gas Capacity: "+aData.get(choose).gas);
			System.out.println("Top speed: "+aData.get(choose).speed);
			System.out.println("Wheel(s): "+aData.get(choose).wheel);
			if(typeL.equals("Car")) {
			System.out.println("Entertainment systems: "+aData.get(choose).detail);
			if(boost.equals("Supercar")) {
				System.out.println("Boosting!");
			}else {
				System.out.println("Turning on entertainment system....");
				scan.nextLine();
			}
			}else if(typeL.equals("Motorcycle")) {
			System.out.println(aData.get(choose).name+" is standing!");
			int harga = aData.get(choose).detail*1000;
			System.out.println("Price: "+harga );
			scan.nextLine();
			}
			}
		}
	}
	
	
	
	void input() {
		String type;
		String brand;
		String name;
		String license;
		int speed;
		int gas;
		int wheel;
		String tType = null;
		int detail=0;
		
		do {
		System.out.print("Input type [ Car | Motorcycle ]: ");
		type=scan.nextLine();
		}while(!type.equals("Car")&&!type.equals("Motorcycle"));
		
		do {
		System.out.print("Input brand [ >= 5 ]: ");
		brand=scan.nextLine();
		}while(brand.length()<5);
		
		
		do {
		System.out.print("Input name [ >= 5 ]: ");
		name=scan.nextLine();
		}while(name.length()<5);
		
			System.out.print("Input license: ");
			license=scan.nextLine();
		
		do {
		System.out.print("Input top speed [100 <= Top Speed <= 250 ]: ");
		speed=scan.nextInt();scan.nextLine();
		}while(speed<100||speed>250);
		
		do {
		System.out.print("Input gas capacity [ 30 <= gasCap <= 60 ]: ");
		gas=scan.nextInt();scan.nextLine();
		}while(gas<30||gas>60);
		
		do {
		System.out.print("Input wheel [ 4 <= wheel <= 6 ]: ");
		wheel=scan.nextInt();scan.nextLine();
		}while(wheel<4||wheel>6);
		
		
		
		if(type.equals("Car")) {
			do {
			System.out.print("Input type [ SUV | Supercar | Minivan ]: ");
			tType=scan.nextLine();
			}while(!tType.equals("SUV")&&!tType.equals("Supercar")&&!tType.equals("Minivan"));
			
			do {
			System.out.print("Input entertainment system amount [ >=1 ]: ");
			detail=scan.nextInt();scan.nextLine();
			}while(detail<1);
			
		}else if(type.equals("Motorcycle")) {
			do {
			System.out.print("Input type [ Automatic | Manual ]: ");
			tType=scan.nextLine();
			}while(!tType.equals("Automatic")&&!tType.equals("Manual"));
				
			do {
			System.out.print("Input helm amount [ >=1 ]: ");
			detail=scan.nextInt();scan.nextLine();
			}while(detail<1);
		}
		Data d = new Data(type,brand,name,license,speed,gas,wheel,tType,detail);
		aData.add(d);
		System.out.println("Enter to return");
		scan.nextLine();
		menu();
		
	}
	
	void menu() {
		int choose;
		do {
		System.out.println("========= PT Meksiko =========");
		System.out.println("1. Input");
		System.out.println("2. View");
		System.out.println("3. Exit");
		System.out.print(">>>");
		choose=scan.nextInt();scan.nextLine();
		if(choose==1) {
			input();
		}else if(choose==2) {
			view();
		}
		}while(choose!=3);
	}
	
	public Main() {
		menu();
	}

	public static void main(String[] args) {
		new Main();
	}
}
