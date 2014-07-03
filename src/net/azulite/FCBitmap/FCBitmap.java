package net.azulite.FCBitmap;

import android.graphics.Bitmap;

public class FCBitmap
{
	/**
	 * Family Computer Color Table
	 */
	public static int[] table =
	{
		0xFF000000, 0xFF757575, 0xFFBCBCBC, 0xFFFFFFFF,
		0xFF271B8F, 0xFF0073EF, 0xFF3FBFFF, 0xFFABE7FF,
		0xFF0000AB, 0xFF233BEF, 0xFF5F73FF, 0xFFC7D7FF,
		0xFF47009F, 0xFF8300F3, 0xFFA78BFD, 0xFFD7CBFF,
		0xFF8F0077, 0xFFBF00BF, 0xFFF77BFF, 0xFFFFC7FF,
		0xFFAB0013, 0xFFE7005B, 0xFFFF77B7, 0xFFFFC7DB,
		0xFFA70000, 0xFFDB2B00, 0xFFFF7763, 0xFFFFBFB3,
		0xFF7F0B00, 0xFFCB4F0F, 0xFFFF9B3B, 0xFFFFDBAB,
		0xFF432F00, 0xFF8B7300, 0xFFF3BF3F, 0xFFFFE7A3,
		0xFF004700, 0xFF009700, 0xFF83D313, 0xFFE3FFA3,
		0xFF005100, 0xFF00AB00, 0xFF4FDF4B, 0xFFABF3BF,
		0xFF003F17, 0xFF00933B, 0xFF58F898, 0xFFB3FFCF,
		0xFF1B3F5F, 0xFF00838B, 0xFF00EBDB, 0xFF9FFFF3,
	};

	/**
	 * Create Bitmap from char array.
	 * @param width Image width.
	 * @param height Image height.
	 * @param data FCBitmap string.
	 * @return Bitmap data.
	 */
	public static Bitmap createBitmap( int width, int height, String data )
	{
		return FCBitmap.createBitmap( width, height, data.toCharArray() );
	}

	/**
	 * Create Bitmap from char array.
	 * @param width Image width.
	 * @param height Image height.
	 * @param data Char array from FCBitmap string.
	 * @return Bitmap data.
	 */
	public static Bitmap createBitmap( int width, int height, char[] data )
	{
		int x, y, num;
		Bitmap bitmap = Bitmap.createBitmap( width, height, Bitmap.Config.ARGB_8888 );

		for ( y = 0 ; y < height ; ++y )
		{
			for ( x = 0 ; x < width ; ++x )
			{
				num = data[ y * width + x ];
				if ( 'A' <= num && num <= 'Z' )
				{
					num -= 'A';
					bitmap.setPixel( x, y, table[ num ] );
				} else if ( 'a' <= num && num <= 'z' )
				{
					num -= 'a' - 26;
					bitmap.setPixel( x, y, table[ num ] );
				} else if ( num == 0 )
				{
					break;
				}
			}
		}

		return bitmap;
	}

	/**
	 * Color to char.
	 * @param color Pixel color(Color).
	 * @return FCBitmap Color character. Not supported color or transparent color is '_'.
	 */
	public static char colorChar( int color )
	{
		int n;
		for ( n = 0 ; n < 26 ; ++n )
		{
			if ( table[ n ] == color ){ return (char)('A' + n); }
		}
		for ( ; n < 52 ; ++n )
		{
			if ( table[ n ] == color ){ return (char)('a' + n - 26); }
		}
		return '_';
	}

	/**
	 * Create FCBitmap string.
	 * @param bitmap Image.
	 * @return FCBitmap string.
	 */
	public static String createString( Bitmap bitmap )
	{
		int x, y, w, h;
		char[] ret;

		w = bitmap.getWidth();
		h = bitmap.getHeight();

		ret = new char[ w * h ];

		for ( y = 0 ; y < h ; ++y )
		{
			for ( x = 0 ; x < w ; ++x )
			{
				ret[ y * w + x ] = FCBitmap.colorChar( bitmap.getPixel( x, y ) );
			}
		}

		return String.valueOf( ret );
	}
}
