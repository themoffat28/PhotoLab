package pixLab.classes;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  public void zeroGreen()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setGreen(0);
      }
    }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  public void mirrorHorizontalBottomToTop()
  {
	  Pixel [][] pixels = this.getPixels2D();
	  Pixel topPixel = null;
	  Pixel bottomPixel = null;
	  int height = pixels.length;
	  for (int col = 0; col < pixels[0].length; col++)
	  {
		  for (int row = (height / 2) - 1; row < height / 2; row--)
		  {
			  topPixel = pixels[row][col];
			  bottomPixel = pixels[row][height - 1 - col];
			  topPixel.setColor(bottomPixel.getColor());
		  }
	  }
	  
	  
	  
  }
  
  public void mirrorVerticalRightToLeft()
  {
	  Pixel [][] pixels = this.getPixels2D();
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  
	  int width = pixels[0].length;
	  
	  for (int row = pixels.length - 1; row >= 0; row--)
	  {
		  for (int col = width / 2 - 1; col >= 0; col--)
		  {
			  leftPixel = pixels[row][col];
			  rightPixel = pixels[row][width - 1 - col];
			  leftPixel.setColor(rightPixel.getColor());
		  }
	  }
  }
  
  public void mirrorDiagonal()
  {
	  Pixel [][] pixels = this.getPixels2D();
	  Pixel topRight = null;
	  Pixel botLeft = null;
	  
	  for(int row = 0; row < pixels.length; row++)
	  {
		  for(int col = 0; col < pixels[0].length; col++)
		  {
			   if(row != col && row < pixels[0].length && col < pixels.length)
			  {
				  topRight = pixels[row][col];
				  botLeft = pixels[col][row];
				  botLeft.setColor(topRight.getColor());
			  }
		  }
	  }
  }
  
  public void mirrorBackwardsDiagonal()
  {
	  Pixel [][] pixels = this.getPixels2D();
	  Pixel topRight = null;
	  Pixel botLeft = null;
	  
	  for(int row = 0; row < pixels.length; row++)
	  {
		  for(int col = 0; col < pixels[0].length; col++)
		  {
			   if(row != col && row < pixels[0].length && col < pixels.length)
			  {
				  topRight = pixels[row][col];
				  botLeft = pixels[col][row];
				  botLeft.setColor(topRight.getColor());
			  }
		  }
	  }
  }
  
  public void mirrorBottomRightToTopLeft()
  {
	  Pixel topLeft = null;
	  Pixel botRight = null;
	  
	  Pixel[][] pixels = this.getPixels2D();
	  int mirrorPoint = Math.min(pixels.length, pixels[0].length) - 1;
	  
	  for(int row = 0; row < pixels.length; row++)
	  {
		  for(int col = 0; col < pixels[0].length; col++)
		  {
			  if(row + col != mirrorPoint && row < pixels[0].length && col < pixels.length)
			  {
				  botRight = pixels[row][col];
				  topLeft = pixels[mirrorPoint-col][mirrorPoint-row];
				  
				  topLeft.setColor(botRight.getColor());
			  }
		  }
	  }
	  
	  
	  
	  
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copyOriginal(Picture fromPic, int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }
  
  public void copyCustom(Picture fromPic, int startRow, int startCol, int endRow, int endCol)
  {
	  Pixel fromPixel = null;
	  Pixel toPixel = null;
	  Pixel[][] toPixels = this.getPixels2D();
	  Pixel[][] fromPixels = fromPic.getPixels2D();
	  
	  int copyRow = Math.min(endRow, toPixels.length - 1);
	  int copyCol = Math.min(endCol, toPixels[0].length - 1);
	  
	  for (int fromRow = 0, toRow = startRow;
			  fromRow < copyRow &&
			  toRow < toPixels.length;
			  fromRow++, toRow++)
			  {
				  for (int fromCol = 0, toCol = startCol;
						  fromCol < copyCol &&
						  toCol < toPixels[0].length;
						  fromCol++, toCol++)
				  {
					  fromPixel = fromPixels[fromRow][fromCol];
					  toPixel = toPixels[toRow][toCol];
					  toPixel.setColor(fromPixel.getColor());
				  }
			  }
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copyOriginal(flower1,0,0);
    this.copyOriginal(flower2,100,0);
    this.copyOriginal(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copyOriginal(flowerNoBlue,300,0);
    this.copyOriginal(flower1,400,0);
    this.copyOriginal(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  public void createCollageCustom()
  {
    Picture flower1 = new Picture("arch.jpg");
    Picture flower2 = new Picture("temple.jpg");
    Picture flower3 = new Picture("gorge.jpg");
    this.copyOriginal(flower1,0,0);
    this.copyOriginal(flower2,100,0);
    this.copyOriginal(flower3, 150, 0);
    this.copyOriginal(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copyOriginal(flowerNoBlue,300,0);
    this.copyOriginal(flower1,400,0);
    this.copyOriginal(flower3, 450, 0);
    this.copyOriginal(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  public void edgeDetection2(int edgeDist)
  {
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  Pixel [][] pixels = this.getPixels2D();
	  Color rightColor = null;
	  
	  for (int row = 0; row < pixels.length -1; row++)
	  {
		  for (int col = 0; col < pixels[0].length - 1; col++)
		  {
			  leftPixel = pixels[row][col];
			  rightPixel = pixels[row+1][col+1];
			  rightColor = rightPixel.getColor();
			  if(leftPixel.colorDistance(rightColor) > edgeDist)
				  leftPixel.setColor(Color.WHITE);
			  else
				  leftPixel.setColor(Color.BLACK);
		  }
	  }
  }
  
  public void mirrorSnowman()
  {
	  int mirrorPoint = 208;
	    Pixel topPixel = null;
	    Pixel botPixel = null;
	    
	    Pixel[][] pixels = this.getPixels2D();
	    
	    // loop through the rows
	    for (int row = 158; row < mirrorPoint; row++)
	    {
	      // loop from 13 to just before the mirror point
	      for (int col = 95; col < 295; col++)
	      {
	        
	        topPixel = pixels[row][col];      
	        botPixel = pixels[mirrorPoint - row + mirrorPoint][col];
	        botPixel.setColor(topPixel.getColor());
	      }
	    }
  }
  
  public void mirrorGull()
  {
	  int mirrorPoint = 350;
	    Pixel topPixel = null;
	    Pixel botPixel = null;
	    
	    Pixel[][] pixels = this.getPixels2D();
	    
	    for (int row = 220; row < 360; row++)
	    {
	      
	      for (int col = 120; col < 400; col++)
	      {
	        
	        topPixel = pixels[row][col];      
	        botPixel = pixels[row][mirrorPoint - col + mirrorPoint];
	        botPixel.setColor(topPixel.getColor());
	      }
	    }
  }
  
  public void fullRandom()
  {
	  Pixel [][] currentPicture = this.getPixels2D();
	  for (Pixel [] row :currentPicture)
	  {
		  for(Pixel currentPixel : row)
		  {
			  int red = (int) (Math.random() * 256);
			  int green = (int) (Math.random() * 256);
			  int blue = (int) (Math.random() * 256);
			  
			  currentPixel.setColor(new Color (red, green, blue));
		  }
	  }
  }
  
  public void Grayscale()
  {
	    Pixel[][] pixels = this.getPixels2D();
	    for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	        int avg = (int)((pixelObj.getRed() + pixelObj.getGreen() + pixelObj.getBlue()) / 3);
	        pixelObj.setRed(avg);
	        pixelObj.setGreen(avg);
	        pixelObj.setBlue(avg);
	      }
	    }
	    write("grayed out.jpg");
	  }
  
  
  public void valentine()
  {
	  Pixel[][] currentPicture = this.getPixels2D();
	  
	  for(Pixel [] row : currentPicture)
	  {
		  for(Pixel current : row)
		  {
			  current.setBlue(0);
			  current.setGreen(0);
		  }
	  }
	  drawString("I watch you.", 180, 100);
	  drawString("Be my Valentine.", 165, 200);
	  write("/Users/bmof0507/beMyValentine.jpg");
	  write("/Users/bmof0507/123.png");
	  explore();
	  write("/Users/bmof0507/Documents/other.png");
	  write("/Users/bmof0507/beMyValentine2.jpg");
  }
 
  public void negateColor()
  {
    Pixel[][] currentPicture = this.getPixels2D();
    for (Pixel[] row : currentPicture)
    {
      for (Pixel currentPixel : row)
      {
    	  currentPixel.setRed(255 - currentPixel.getRed());
    	  currentPixel.setGreen(255 - currentPixel.getGreen());
    	  currentPixel.setBlue(255 - currentPixel.getBlue());
      }
    }
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("MyValentine.png");
    beach.explore();
    beach.valentine();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
