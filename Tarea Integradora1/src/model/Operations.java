package model;
public class Operations{
	public static int ROUGH_CONSTRUCTION=1300000;
	public static int FINAL_CONSTRUCTION=2600000;
	public static int PAINTING=980000;
	 /** 
     *Calculate the total price of each store with the shipping price <br>
     * <b> pre: </b> The array price_homecenter has to be !=null
	 * <b> pre: </b> The amountProducts has to be !=null
	 * <b> post: </b> returns the total price of the construction with the shipping price
     * @param cant_products type int
	 * @param location type int
     */
	public static int totalStoresPrices (int[]price_homecenter, int [] amountProducts,int cant_products,int location){
		int total_price=0;
		for (int i=0;i<cant_products;i++){
			int total_products=price_homecenter[i]*amountProducts[i];
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
	public static int bestPrice(int[]price_homecenter,int[]price_neighborhood,int[]price_downtowns, int[]amountProducts, int cant_products,int location){
		int total_best_price=0;
		int total_products;
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
	public static int[] bestPlaceToBuy(int[]price_homecenter,int[]price_neighborhood,int[]price_downtowns, int cant_products){
		int[] best_place= new int [cant_products];
		for(int i=0;i<cant_products;i++){
			if(price_homecenter[i]<price_downtowns[i] && price_homecenter[i]<price_neighborhood[i]){				
				best_place[i]=price_homecenter[i];
			}
			if(price_downtowns[i]<price_homecenter[i] && price_downtowns[i]<price_neighborhood[i]){
				best_place[i]=price_downtowns[i];
			}
			if(price_neighborhood[i]<price_homecenter[i] && price_neighborhood[i]<price_downtowns[i]){
				best_place[i]=price_neighborhood[i];
			}
		}
		return best_place;		
	}
}
