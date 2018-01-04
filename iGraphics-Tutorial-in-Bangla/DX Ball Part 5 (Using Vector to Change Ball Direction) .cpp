/*
	Project Name : Youtube Project
	Author		 : Sayef Reyadh Khan
	Language	 : C/C++
	*/
#include<iostream>
using namespace std;
# include "iGraphics.h"
#define totalBricks 5*10
#define screenWidth 1200
#define screenHight 650
#define yAxisMargin 50
#define qetaDefine 0
#define PI 3.14159265


int mposx, mposy;


char backGroundImage[20] = "bc\\1.bmp";

struct brickStructure
{
	int x;
	int y;
	int dx = 100;
	int dy = 20;
	bool show = false;
	int red;
	int green;
	int blue;
};

brickStructure bricks[totalBricks];

int red = 0;
int green = 0;
int blue = 0;

int xBall = (int) screenWidth/2;
int yBall = yAxisMargin;
int radiusBall = 10;
//int dx = 7;
//int dy = 5;
int v = 10;
int qeta = 30;
int dx = (int) v*cos(qeta*PI / 180);
int dy = (int) v*sin(qeta*PI / 180);

int xBoard = xBall - 50;
int yBoard = yBall - 20;
int dxBoard = 100;
int dyBoard = 10;

bool isStarted = false;


void ballChange();
void restartBall();
void defineBricks();
void iDraw()
{
	iClear();
	iShowBMP(0, 0, backGroundImage);
	iSetColor(red, green, blue);
	iFilledCircle(xBall, yBall, radiusBall, 1000);
	iFilledRectangle(xBoard, yBoard, dxBoard, dyBoard);

	for (int i = 0; i < totalBricks; i++)
	{
		if (bricks[i].show)
		{

			iSetColor(bricks[i].red, bricks[i].green, bricks[i].blue);
			iFilledRectangle(bricks[i].x, bricks[i].y, bricks[i].dx, bricks[i].dy);
		}
	}

}


void iMouseMove(int mx, int my)
{

}


void iMouse(int button, int state, int mx, int my)
{

}


void iPassiveMouseMove(int mx, int my)
{
	//place your code here

	mposx = mx;
	mposy = my;
	if (mx == 2){}        /*Something to do with mx*/
	else if (my == 2){}   /*Something to do with my*/

}


void iKeyboard(unsigned char key)
{
	if (key == 'w')
	{

	}
	else if (key == 's')
	{

	}
	else if (key == 'a')
	{

	}
	else if (key == 'd')
	{

	}
	else if (key == ' ')
	{
		if (!isStarted)
		{
			isStarted = true;
		}
	}




}

/*
	function iSpecialKeyboard() is called whenver user hits special keys like-
	function keys, home, end, pg up, pg down, arraows etc. you have to use
	appropriate constants to detect them. A list is:
	GLUT_KEY_F1, GLUT_KEY_F2, GLUT_KEY_F3, GLUT_KEY_F4, GLUT_KEY_F5, GLUT_KEY_F6,
	GLUT_KEY_F7, GLUT_KEY_F8, GLUT_KEY_F9, GLUT_KEY_F10, GLUT_KEY_F11, GLUT_KEY_F12,
	GLUT_KEY_LEFT, GLUT_KEY_UP, GLUT_KEY_RIGHT, GLUT_KEY_DOWN, GLUT_KEY_PAGE UP,
	GLUT_KEY_PAGE DOWN, GLUT_KEY_HOME, GLUT_KEY_END, GLUT_KEY_INSERT
	*/
void iSpecialKeyboard(unsigned char key)
{

	if (key == GLUT_KEY_UP)
	{

	}
	else if (key == GLUT_KEY_DOWN)
	{

	}
	else if (key == GLUT_KEY_LEFT)
	{
		if (xBoard > 0)
		{
			xBoard -= 10;
			if (!isStarted)
			{
				xBall -= 10;
			}
		}

	}
	else if (key == GLUT_KEY_RIGHT)
	{
		if (xBoard < screenWidth - dxBoard )
		{
			xBoard += 10;
			if (!isStarted)
			{
				xBall += 10;
			}
		}

	}
	else if (key == GLUT_KEY_HOME)
	{

	}
	else if (key == GLUT_KEY_INSERT)
	{

	}
	//place your codes for other keys here
}


//


void ballChange()
{
	if (isStarted)
	{
		xBall += dx;
		yBall += dy;

		if (xBall >= screenWidth || xBall <= 0)
			dx *= (-1);
		if (yBall >= screenHight || yBall <= 0)
			dy *= (-1);

		//Collision

		for (int i = 0; i < totalBricks; i++)
		{
			if (bricks[i].show)
			{
				if (xBall >= bricks[i].x && xBall <= bricks[i].x + bricks[i].dx)
				{
					if (yBall >= bricks[i].y && yBall <= bricks[i].y + bricks[i].dy)
					{
						dy *= (-1);
						bricks[i].show = false;
					}

				}
				else if (yBall >= bricks[i].y && yBall <= bricks[i].y + bricks[i].dy)
				{
					if (xBall >= bricks[i].x && xBall <= bricks[i].x + bricks[i].dx)
					{
						dx *= (-1);
						bricks[i].show = false;
					}
				}
			}
		}


		if (xBall >= xBoard && xBall <= xBoard + dxBoard && yBall >= yBoard && yBall <= yBoard + dyBoard)
		{
			/*
			xBoard = 200;
			dxBoard = 100;
			xBall = 150;
			*/
			qeta = (xBoard + dxBoard - xBall) + 40;
			dx = (int)v*cos(qeta*PI / 180);
			dy = (int)v*sin(qeta*PI / 180);

			cout << qeta << "\t\t" << dx << "\t\t" << dy << endl;
		}
		else
		{
			if (yBall < yBoard)
			{
				///restartBall();
			}
		}

	}
}


void restartBall()
{
	xBall = (int)screenWidth / 2;
	yBall = yAxisMargin;
	dx = 7;
	dy = 5;

	xBoard = xBall - 50;
	yBoard = yBall - 20;

	isStarted = false;

}

void defineBricks()
{
	int sumx = 100;
	int sumy = 450;
	for (int i = 0; i < totalBricks; i++)
	{
		bricks[i].red = rand() % 255;
		bricks[i].green = rand() % 255;
		bricks[i].blue = rand() % 255;
		bricks[i].x = sumx;
		bricks[i].y = sumy;
		sumx += 100;
		if (sumx > 1000){
			sumx = 100;
			sumy += 20;
		}
	}
}

int main()
{
	defineBricks();
	iSetTimer(10, ballChange);
	iInitialize(screenWidth, screenHight, "Youtube Project");
	return 0;
}
