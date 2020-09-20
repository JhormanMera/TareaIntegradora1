package ui;
import java.util.Scanner;
import model.*;
public class Main {
	public static Scanner in = new Scanner(System.in);
	public static void main (String [] args){
		int cantofproducts = cantProducts(in);
		String [] materials = getMaterials(in,cantofproducts);
		int[] ammount_of_materials=amountProducts(in,cantofproducts,materials);
		int [] materials_use=getMaterialsUse(in,cantofproducts,materials);
		int[]homecenter_prices=homecenterPrice(in,cantofproducts,materials);
		int[]down_town_prices=downTownStore (in,cantofproducts,materials);
		int[]neighborhood_prices=neighborhoodStore (in,cantofproducts,materials);	
		int house_location=houseLocation(in);
		System.out.println("El total a pagar por la obra (con envio incluido) si se compran los materiales en la tienda homecenter es: "+Operations.totalStoresPrices(homecenter_prices,ammount_of_materials,cantofproducts,house_location));
		System.out.println("El total a pagar por la obra (con envio incluido) si se compran los materiales en la tienda del centro es: "+Operations.totalStoresPrices(down_town_prices,ammount_of_materials,cantofproducts,house_location));
		System.out.println("El total a pagar por la obra (con envio incluido) si se compran los materiales en la tienda del barrio es: "+Operations.totalStoresPrices(neighborhood_prices,ammount_of_materials,cantofproducts,house_location));
		int [] bestplace=Operations.bestPlaceToBuy(homecenter_prices,neighborhood_prices,down_town_prices,cantofproducts);
		for (int i=0;i<cantofproducts;i++){
			if(bestplace[i]==1){
			System.out.println("El mejor precio del producto "+materials[i]+" es: "+bestplace[i]+" y se encuentra en la tienda Homecenter");
			}
			if(bestplace[i]==2){
			System.out.println("El mejor precio del producto "+materials[i]+" es: "+bestplace[i]+" y se encuentra en la tienda del centro");
			}
			if(bestplace[i]==3){
			System.out.println("El mejor precio del producto "+materials[i]+" es: "+bestplace[i]+" y se encuentra en la tienda del Barrio");
			}
		}	
		System.out.println("El total a pagar por la obra (con envio incluido) teniendo en cuenta los mejores precios de cada producto es: "+Operations.bestPrice(homecenter_prices,neighborhood_prices,down_town_prices,ammount_of_materials,cantofproducts,house_location));
		productType(in,cantofproducts,materials,materials_use);

	}
	public static int cantProducts(Scanner in){
			System.out.println("Digite la cantidad de productos a ingresar");
			int cant_products = in.nextInt();
			in.nextLine();
			return cant_products;
	}
		public static String [] getMaterials (Scanner in,int cantofproducts){
			String [] products_name = new String [cantofproducts];
			for (int i=0; i<cantofproducts;i++){
				System.out.println("Ingrese el material numero "+(i+1));
				products_name[i]=in.nextLine();
			}
			return products_name;
		}
		public static int [] amountProducts (Scanner in,int cantofproducts,String[] materials){
			int[] amount = new int [cantofproducts];
			for (int i=0; i<cantofproducts;i++){
				System.out.println("Ingrese la cantidad del material "+materials[i]);
				amount[i]=in.nextInt();
				in.nextLine();
			}
			return amount;
		}
		public static int [] homecenterPrice (Scanner in, int cantofproducts,String [] products_name){
			int [] price_homecenter = new int [cantofproducts]; 
			for (int i=0; i<cantofproducts;i++){
				System.out.println("Digite el costo del material "+products_name[i]+" en la tienda homecenter");
				price_homecenter[i]=in.nextInt();
				in.nextLine();
			}
			return price_homecenter;
		}
		public static int [] downTownStore (Scanner in, int cantofproducts,String [] products_name){
			int [] price_downtowns = new int [cantofproducts]; 
			for (int i=0; i<cantofproducts;i++){
				System.out.println("Digite el costo del material "+products_name[i]+" en la tienda del centro");
				price_downtowns[i]=in.nextInt();
				in.nextLine();
			}
			return price_downtowns;
		}
		public static int [] neighborhoodStore (Scanner in, int cantofproducts,String [] products_name){
			int [] price_neighborhood = new int [cantofproducts]; 
			for (int i=0; i<cantofproducts;i++){
				System.out.println("Digite el costo del material "+products_name[i]+" en la tienda de barrio");
				price_neighborhood[i]=in.nextInt();
				in.nextLine();
			}
			return price_neighborhood;
		}
		public static int [] getMaterialsUse(Scanner in, int cantofproducts, String []products_name){
			int [] material_use = new int [cantofproducts]; 
			for (int i=0; i<cantofproducts;i++){
				System.out.println("¿Cual será el uso del material "+products_name[i]);
				System.out.println("Obra negra: 1, Obra blanca: 2, Pintura 3");
				material_use[i]=in.nextInt();
				in.nextLine();
			}
			return material_use;
		}
		public static void productType(Scanner in,int cantofproducts,String[] products_name,int[] material_use){
			System.out.println("¿De que utilidad desea ver sus productos?");
			System.out.println("Obra negra: 1, Obra blanca: 2, Pintura: 3");
			int utility=in.nextInt();
			in.nextLine();
			for(int i=0;i<cantofproducts;i++){
				switch (utility){
				case 1:
				if (material_use[i]==1){
					System.out.println(products_name[i]);					
				}
				break;
				case 2:
				if (material_use[i]==2){
					System.out.println(products_name[i]);					
				}
				break;
				case 3:
				if (material_use[i]==3){
					System.out.println(products_name[i]);					
				}
				break;
				default:
				}
			}
		}
		public static int houseLocation(Scanner in){
			System.out.println("¿Donde se encuentra ubicado su domiciliio?");
			System.out.println("Norte: 1, Centro: 2, Sur: 3");
			int location=in.nextInt();
			in.nextLine();
			return location;			
		}
	}