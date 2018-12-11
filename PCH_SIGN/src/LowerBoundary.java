import java.io.IOException;
import java.util.stream.IntStream;

import param.coord;


public class LowerBoundary {
	
	public static void main(String args[])throws IOException{
		
		
		coord rightVertex =new coord();
		coord leftVerex= new coord();
		coord firstCoordinate= new coord();
		coord lastCoordinate= new coord();
		coord currentCoordinate=new coord();
		int mat[][]=new int [3][3];
		
		Img myimg = new Img("d:\\projectImage\\MatlabResult1.png");
		
		coord gradeMat[]=new coord[myimg.width];
		for( int i=0;i<myimg.width;i++){
			gradeMat[i] = new coord();
		}
		
		coord boundaryArr[] = new coord[myimg.width];
		for( int i=0;i<myimg.width;i++){
			boundaryArr[i] = new coord();
		}

		
		int matCount=0;
		int counter=0;
		
		//System.out.println(myimg.height);
		//System.out.println(myimg.width);
		
		//System.out.println(boundaryArr.length);
		
		rightVertex.setX(90);
		rightVertex.setY(90);
		leftVerex.setX(0);
		leftVerex.setY(0);
		
		//Finding last coordinate of the lower boundary
		for (int i=leftVerex.x; i<myimg.height; i++ )
		{
			
			for(int j=leftVerex.y; j<myimg.width; j++)
			{
				if((myimg.Arr[i][j])==255)
				{
					lastCoordinate.x=i;
					lastCoordinate.y=j;
					break;
				}	
			}	
		}
		
		//Finding first coordinate of the lower boundary
		for (int i=rightVertex.x; i>0; i-- )
		{
			
			for(int j=rightVertex.y; j>0; j--)
			{
				if((myimg.Arr[i][j])==255)
				{
					firstCoordinate.setX(i);
					firstCoordinate.setY(j);
					
				}	
			}	
		}
		
		boundaryArr[counter].x=firstCoordinate.x;
		boundaryArr[counter].y=firstCoordinate.y;
		counter++;
		//System.out.println("("+boundaryArr[counter].x +","+boundaryArr[counter].y+")");
	
		
		System.out.println("("+firstCoordinate.x +","+firstCoordinate.y+")");
		System.out.println("("+lastCoordinate.x +","+lastCoordinate.y+")");
		
		currentCoordinate=firstCoordinate;
			for (int j=((currentCoordinate.y)-1); j <=((currentCoordinate.y)+1); j++)
			{
				for (int i=((currentCoordinate.x)-1);i<=((currentCoordinate.x)+1); i++)
				{
				
					if(myimg.Arr[i][j]==0){
						
						gradeMat[matCount].grade=0;
						gradeMat[matCount].x=i;
						gradeMat[matCount].y=j;
						matCount++;
					}
					else if(myimg.Arr[i][j]==255)
					{
							for (coord x : boundaryArr)
							{ //start of search
								if (x.x==i && x.y == j)
								{
									gradeMat[matCount].grade=1;
									gradeMat[matCount].x=i;
									gradeMat[matCount].y=j;
									matCount++;
								}
								else {
									
									gradeMat[matCount].grade=2;
									gradeMat[matCount].x=i;
									gradeMat[matCount].y=j;
									matCount++;
									break;
									}
								}//end of search
					
					}
			
				}
			}
			
			for(int i=0;i<gradeMat.length;i++)
			{
				System.out.println(gradeMat[i].grade);
			}
}
}

