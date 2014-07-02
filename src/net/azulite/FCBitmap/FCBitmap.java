package net.azulite.FCBitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class FCBitmap
{
	public static short[][] table =
	{
		{ 0x00, 0x00, 0x00 }, // 000000
		{ 0x75, 0x75, 0x75 }, // 757575
		{ 0xBC, 0xBC, 0xBC }, // BCBCBC
		{ 0xFF, 0xFF, 0xFF }, // FFFFFF

		{ 0x27, 0x1B, 0x8F }, // 271B8F
		{ 0x00, 0x73, 0xEF }, // 0073EF
		{ 0x3F, 0xBF, 0xFF }, // 3FBFFF
		{ 0xAB, 0xE7, 0xFF }, // ABE7FF

		{ 0x00, 0x00, 0xAB }, // 0000AB
		{ 0x23, 0x3B, 0xEF }, // 233BEF
		{ 0x5F, 0x73, 0xFF }, // 5F73FF
		{ 0xC7, 0xD7, 0xFF }, // C7D7FF

		{ 0x47, 0x00, 0x9F }, // 47009F
		{ 0x83, 0x00, 0xF3 }, // 8300F3
		{ 0xA7, 0x8B, 0xFD }, // A78BFD
		{ 0xD7, 0xCB, 0xFF }, // D7CBFF

		{ 0x8F, 0x00, 0x77 }, // 8F0077
		{ 0xBF, 0x00, 0xBF }, // BF00BF
		{ 0xF7, 0x7B, 0xFF }, // F77BFF
		{ 0xFF, 0xC7, 0xFF }, // FFC7FF

		{ 0xAB, 0x00, 0x13 }, // AB0013
		{ 0xE7, 0x00, 0x5B }, // E7005B
		{ 0xFF, 0x77, 0xB7 }, // FF77B7
		{ 0xFF, 0xC7, 0xDB }, // FFC7DB

		{ 0xA7, 0x00, 0x00 }, // A70000
		{ 0xDB, 0x2B, 0x00 }, // DB2B00
		{ 0xFF, 0x77, 0x63 }, // FF7763
		{ 0xFF, 0xBF, 0xB3 }, // FFBFB3

		{ 0x7F, 0x0B, 0x00 }, // 7F0B00
		{ 0xCB, 0x4F, 0x0F }, // CB4F0F
		{ 0xFF, 0x9B, 0x3B }, // FF9B3B
		{ 0xFF, 0xDB, 0xAB }, // FFDBAB

		{ 0x43, 0x2F, 0x00 }, // 432F00
		{ 0x8B, 0x73, 0x00 }, // 8B7300
		{ 0xF3, 0xBF, 0x3F }, // F3BF3F
		{ 0xFF, 0xE7, 0xA3 }, // FFE7A3

		{ 0x00, 0x47, 0x00 }, // 004700
		{ 0x00, 0x97, 0x00 }, // 009700
		{ 0x83, 0xD3, 0x13 }, // 83D313
		{ 0xE3, 0xFF, 0xA3 }, // E3FFA3

		{ 0x00, 0x51, 0x00 }, // 005100
		{ 0x00, 0xAB, 0x00 }, // 00AB00
		{ 0x4F, 0xDF, 0x4B }, // 4FDF4B
		{ 0xAB, 0xF3, 0xBF }, // ABF3BF

		{ 0x00, 0x3F, 0x17 }, // 003F17
		{ 0x00, 0x93, 0x3B }, // 00933B
		{ 0x58, 0xF8, 0x98 }, // 58F898
		{ 0xB3, 0xFF, 0xCF }, // B3FFCF

		{ 0x1B, 0x3F, 0x5F }, // 1B3F5F
		{ 0x00, 0x83, 0x8B }, // 00838B
		{ 0x00, 0xEB, 0xDB }, // 00EBDB
		{ 0x9F, 0xFF, 0xF3 }, // 9FFFF3
	};

	public static int[] rtable =
	{
		0x000000FF, 0x757575FF, 0xBCBCBCFF, 0xFFFFFF,
		0x271B8FFF, 0x0073EFFF, 0x3FBFFFFF, 0xABE7FF,
		0x0000ABFF, 0x233BEFFF, 0x5F73FFFF, 0xC7D7FF,
		0x47009FFF, 0x8300F3FF, 0xA78BFDFF, 0xD7CBFF,
		0x8F0077FF, 0xBF00BFFF, 0xF77BFFFF, 0xFFC7FF,
		0xAB0013FF, 0xE7005BFF, 0xFF77B7FF, 0xFFC7DB,
		0xA70000FF, 0xDB2B00FF, 0xFF7763FF, 0xFFBFB3,
		0x7F0B00FF, 0xCB4F0FFF, 0xFF9B3BFF, 0xFFDBAB,
		0x432F00FF, 0x8B7300FF, 0xF3BF3FFF, 0xFFE7A3,
		0x004700FF, 0x009700FF, 0x83D313FF, 0xE3FFA3,
		0x005100FF, 0x00AB00FF, 0x4FDF4BFF, 0xABF3BF,
		0x003F17FF, 0x00933BFF, 0x58F898FF, 0xB3FFCF,
		0x1B3F5FFF, 0x00838BFF, 0x00EBDBFF, 0x9FFFF3,
	};

	public static Bitmap createBitmap( int width, int height, char[] data )
	{
		int x, y, num;
		Bitmap bitmap = Bitmap.createBitmap( width, height, Bitmap.Config.ARGB_8888 );
		Canvas canvas = new Canvas( bitmap );
		Paint paint = new Paint();

		for ( y = 0 ; y < height ; ++y )
		{
			for ( x = 0 ; x < width ; ++x )
			{
				num = data[ y * width + x ];
				if ( ('A' <= num && num <= 'Z') )
				{
					num -= 'A';
					paint.setColor( Color.argb( 255, table[ num ][ 0 ], table[ num ][ 1 ], table[ num ][ 2 ] ) );
					canvas.drawRect( x, y, x + 1, y + 1, paint );
				} else if ('a' <= num && num <= 'z')
				{
					num -= 'a' - 26;
					paint.setColor( Color.argb( 255, table[ num ][ 0 ], table[ num ][ 1 ], table[ num ][ 2 ] ) );
					canvas.drawRect( x, y, x + 1, y + 1, paint );
				} else if ( num == 0 )
				{
					break;
				}
			}
		}

		return bitmap;
	}

	public static char colorChar( int color )
	{
		int n;
		for ( n = 0 ; n < 26 ; ++n )
		{
			if ( rtable[ n ] == color ){ return (char)('A' + n); }
		}
		for ( ; n < 52 ; ++n )
		{
			if ( rtable[ n ] == color ){ return (char)('a' + n - 26); }
		}
		return '_';
	}

	public static String createString( Bitmap bitmap )
	{
		int x, y, w, h;
		char[] ret;

		w = bitmap.getWidth();
		h = bitmap.getHeight();

		ret = new char[ w * h + 1 ];

		for ( y = 0 ; y < h ; ++y )
		{
			for ( x = 0 ; x < w ; ++x )
			{
				ret[ y * w + x ] = FCBitmap.colorChar( bitmap.getPixel( x, y ) );
			}
		}

		return ret.toString();
	}
}