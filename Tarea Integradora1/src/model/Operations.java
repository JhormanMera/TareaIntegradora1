package model;
public class Operations{
	public static int ROUGH_CONSTRUCTION=1300000;
	public static int FINAL_CONSTRUCTION=2600000;
	public static int PAINTING=980000;
	public static double totalStoresPrices (double[]price_homecenter, double [] amountProducts,int cant_products,int location){
		double total_price=0;
		for (int i=0;i<cant_products;i++){
			double total_products=price_homecenter[i]*amountProducts[i];
			total_price=total_products+total_price;
		}
		switch (location){
			case 1:
			if (total_price<80000){
				total_price=+ 120000;
				
			} else if (total_price<300000){
				total_price+=28000;
			}
			break;
			case 2:
			if (total_price<300000){
				total_price=+50000;				
			}
			break;
			case 3:
			if (total_price<80000){
				total_price=+ 120000;				
			} else if (total_price<300000){
				total_price+=55000;
			}
			break;
			default:
			}
		total_price=total_price+ROUGH_CONSTRUCTION+FINAL_CONSTRUCTION+PAINTING;
		return total_price;
		
	}
	public static double bestPrice(double[]price_homecenter,double[]price_neighborhood,double[]price_downtowns, double[]amountProducts, int cant_products,int location){
		double total_best_price=0;
		double total_products;
		for(int i=0;i<cant_products;i++){
			if(price_homecenter[i]<price_downtowns[i] && price_homecenter[i]<price_neighborhood[i]){				
				total_products=price_homecenter[i]*amountProducts[i];
				total_best_price=total_products+total_best_price;
			}
			if(price_downtowns[i]<price_homecenter[i] && price_downtowns[i]<price_neighborhood[i]){
				total_products=price_downtowns[i]*amountProducts[i];
				total_best_price=total_products+total_best_price;
			}
			if(price_neighborhood[i]<price_homecenter[i] && price_neighborhood[i]<price_downtowns[i]){
				total_products=price_neighborhood[i]*amountProducts[i];
				total_best_price=total_products+total_best_price;
			}
		}	
			switch (location){
				case 1:
				if (total_best_price<80000){
					total_best_price=+ 120000;				
				} else if (total_best_price<300000){
					total_best_price+=28000;
				}
				break;
				case 2:
					if (total_best_price<300000){
					total_best_price=+50000;				
				}
				break;
				case 3:
				if (total_best_price<80000){
					total_best_price=+ 120000;				
				} else if (total_best_price<300000){
					total_best_price+=55000;
				}
				break;
				default:
			}
			return total_best_price;
	}
	public static int[] bestPlaceToBuy(double[]price_homecenter,double[]price_neighborhood,double[]price_downtowns, int cant_products){
		int[] best_place= new int[cant_products];
		for(int i=0;i<cant_products;i++){
			if(price_homecenter[i]<price_downtowns[i] && price_homecenter[i]<price_neighborhood[i]){				
				best_place[i]=1;
			}
			if(price_downtowns[i]<price_homecenter[i] && price_downtowns[i]<price_neighborhood[i]){
				best_place[i]=2;
			}
			if(price_neighborhood[i]<price_homecenter[i] && price_neighborhood[i]<price_downtowns[i]){
				best_place[i]=3;
			}
		}
		return best_place;		
	}
}
