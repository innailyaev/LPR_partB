import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import javax.imageio.ImageIO;


public class Img {
	
    public String path;
	public int Arr[][];
	public int width;
	public int height;
	
	
   Img(String mypath){
    	this.path = mypath;
    	try {
		  this.readImage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    	
    }
			
	public void readImage() throws IOException {
		
	    BufferedImage img = null;
	    File f = null;
		
		try{
		  f = new File(this.path);
	      img = ImageIO.read(f);
	      this.width = img.getWidth();
	      this.height = img.getHeight();
	      this.Arr = new int[height][width];
	      Raster raster = img.getData();
	      
	      for (int i = 0; i < height; i++) {
	    	 // System.out.println();
	          for (int j = 0; j < width; j++) {
	              Arr[i][j] = raster.getSample(j, i, 0);
	              //if (Arr[i][j] < 10)
	            	 //System.out.print("00");
	            //  else if (Arr[i][j] <99)
	            	  //System.out.print("0");  
	             // System.out.print(Arr[i][j]);
	          }   

	      }
	        
			}catch(IOException e){
		      System.out.println(e);
		    }
		   
		  }//main() ends here
		}//class ends here

