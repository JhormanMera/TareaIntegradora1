import java.util.Scanner;
package ui:
import model.*;
public class Main {
	public static Scanner in = new Scanner(System.in);
	public static ROUGH_CONSTRUCTION=1300000;
	public static FINAL_CONSTRUCTION=2600000;
	public static PAINTING=980000;
	public static void main (String [] args){
	}
	public static int  cantProducts(Scanner in){
			System.out.println("Digite la cantidad de productos a ingresar");
			int cant_products = in.nextInt();
			in.nextLine();
			return cant_products;
	}
		public static String [] getMaterials (Scanner in,int cant_products){
			String[] products_name = new string[cantProducts];
			for (int i=0; i<cantProducts;i++){
				System.out.println("Ingrese el material numero"+(i+1));
				products_name[i]=in.nexLine();
			}
			return products_name;
		}
		public static double [] amountProducts (Scanner in,int cant_products,String[] products_name){
			 [] amount = new int [cant_products];
			for (int i=0; i<cantProducts;i++){
				System.out.println("Ingrese la cantidad del material"+products_name[i]);
				amount[i]=in.nexInt();
				in.nextLine();
			}
			return amount;
		}
		public static double [] homecenterPrice (Scanner in, int cant_products,String [] products_name){
			double [] price_homecenter = new double [cant_products]; 
			for (int i=0; i<cant_products;i++){
				System.out.println("Digite el costo del material "+products_name[i]+" en la tienda homecenter");
				price_homecenter[i]=in.nextDouble();
				in.nextLine();
			}
			return price_homecenter;
		}
		public static double [] downTownStore (Scanner in, int cant_products,String [] products_name){
			double [] price_downtowns = new double [cant_products]; 
			for (int i=0; i<cant_products;i++){
				System.out.println("Digite el costo del material "+products_name[i]+" en la tienda del centro");
				price_downtowns[i]=in.nextDouble();
				in.nextLine();
			}
			return price_downtowns;
		}
		public static double [] neighborhoodStore (Scanner in, int cant_products,String [] products_name){
			double [] price_neighborhood = new double [cant_products]; 
			for (int i=0; i<cant_products;i++){
				System.out.println("Digite el costo del material "+products_name[i]+" en la tienda de barrio");
				price_neighborhood[i]=in.nextDouble();
				in.nextLine();
			}
			return price_neighborhood;
		}
		public static int [] getMaterialsUse(Scanner in, int cant_products, String []products_name){
			int [] material_use = new int [cant_products]; 
			for (int i=0; i<cant_products;i++){
				System.out.println("¿Cual será el uso del material "+products_name[i]);
				System.out.println("Obra negra: 1, Obra blanca: 2, Pintura 3");
				material_use[i]=in.nextInt();
				in.nextLine();
			}
			return material_use;
		}
		public static int productType(Scanner in){
			System.out.println("¿De que utilidad desea ver sus productos?");
			System.out.println("Obra negra: 1, Obra blanca: 2, Pintura: 3");
			int utility=in.nextInt();
			in.nextLine();
			return utility;
		}
		
		public static int houseLocation(Scanner in){
			System.out.println("¿Donde se encuentra ubicado su domiciliio?");
			System.out.println("Norte: 1, Centro: 2, Sur: 3");
			int location=in.nextInt();
			in.nextLine();
			return location;			
		}
		
}