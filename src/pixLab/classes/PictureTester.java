package pixLab.classes;
/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Braeden Moffat 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  public static void testMirrorHorizontalBottomToTop()
  {
	  Picture caterpillar = new Picture("caterpillar.jpg");
	  caterpillar.explore();
	  caterpillar.mirrorHorizontalBottomToTop();
	  caterpillar.explore();
  }
  
  public static void testMirrorVerticalRightToLeft()
  {
	  Picture koala = new Picture("robot.jpg");
	  koala.explore();
	  koala.mirrorVerticalRightToLeft();
	  koala.explore();
	  koala.zeroBlue();
	  koala.explore();
  }
  
  public static void testMirrorDiagonal()
  {
	  Picture arch = new Picture("seagull.jpg");
	  arch.explore();
	  arch.mirrorDiagonal();
	  arch.explore();
  }
  
  public static void testMirrorBottomRightToTopLeft()
  {
	  Picture demon = new Picture("KatieFancy.jpg");
	  demon.explore();
	  demon.mirrorBottomRightToTopLeft();
	  demon.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  public static void testEdgeDetection2()
  {
	  Picture swan = new Picture("swan.jpg");
	  swan.edgeDetection2(10);
	  swan.explore();
	  swan.edgeDetection2(20);
	  swan.explore();
  }
  
  public static void testCopyCustom()
  {
	  Picture swan = new Picture("swan.jpg");
	  swan.copyCustom(swan, 105, 130, 239, 330);
	  swan.explore();
  }
  
  public static void testMirrorSnowman()
  {
	  Picture snowman = new Picture("snowman.jpg");
	  snowman.explore();
	  snowman.mirrorSnowman();
	  snowman.explore();
  }
  
  public static void testMirrorGull()
  {
	  Picture gull = new Picture("seagull.jpg");
	  gull.explore();
	  gull.mirrorGull();
	  gull.explore();
  }
  
  public static void testFullRandom()
  {
	  Picture robot = new Picture("wall.jpg");
	  robot.explore();
	  robot.fullRandom();
	  robot.explore();
  }
  
  public static void testGrayscale()
  {
	  Picture forrest = new Picture("CumberlandIsland.jpg");
	  forrest.explore();
	  forrest.Grayscale();
	  forrest.explore();
  }
  
  public static void testNegateColor()
  {
	  Picture girl = new Picture("jenny-red.jpg");
	  girl.explore();
	  girl.negateColor();
	  girl.explore();
  }
  
  public static void testFiveFilters()
  {
	  Picture city = new Picture("city.jpg");
	  city.explore();
	  city.mirrorVertical();
	  city.mirrorDiagonal();
	  city.mirrorBackwardsDiagonal();
	  city.negateColor();
	  city.Grayscale();
	  city.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
	//testNegateColor();
	//testFiveFilters();
    //testFixUnderwater();
    //testMirrorVertical();
    //testMirrorVerticalRightToLeft();
	//testMirrorHorizontalBottomToTop();
	//testMirrorDiagonal();
	//testMirrorBottomRightToTopLeft();
    //testMirrorTemple();
    //testMirrorSnowman();
    //testMirrorGull();
	//testFullRandom();
    //testMirrorDiagonal();
    //testCollage();
    //testCopyOriginal();
	testCopyCustom();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}