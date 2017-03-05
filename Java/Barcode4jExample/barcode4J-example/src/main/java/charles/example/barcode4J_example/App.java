package charles.example.barcode4J_example;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	//Create the barcode bean
    	Code128Bean bean = new Code128Bean();

    	final int dpi = 150;

    	//Configure the barcode generator
    	bean.setModuleWidth(UnitConv.in2mm(1.0f / dpi)); //makes the narrow bar 
    	                                                 //width exactly one pixel
//    	bean.setWideFactor(3);
    	bean.doQuietZone(false);

    	//Open output file
    	File outputFile = new File("/Users/charles/TestFolder/out.png");
    	OutputStream out = new FileOutputStream(outputFile);
    	try {
    	    //Set up the canvas provider for monochrome PNG output 
    	    BitmapCanvasProvider canvas = new BitmapCanvasProvider(
    	            out, "image/x-png", dpi, BufferedImage.TYPE_BYTE_BINARY, false, 0);

    	    //Generate the barcode
    	    bean.generateBarcode(canvas, "adfafasfefq!@#$%%^&");

    	    //Signal end of generation
    	    canvas.finish();
    	} finally {
    	    out.close();
    	}
    }
}
