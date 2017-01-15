#include "iGraphics.h"
#include<stdio.h>
#include<string.h>
#include<math.h>

#include<iostream>
#include<string>
using namespace std;
#define g 9.8/100
#define G 9.8
#define PI 3.14159265
int xCircle;
int yCircle;
int radius = 80;
double qeta = 0;
int qeta2 = 180;
int xLine = xCircle + (radius + 30)*cos(qeta * PI / 180);
int yLine = yCircle + (radius + 30)*sin(qeta * PI / 180);
int xBall = xCircle;
int yBall = yCircle;
int radiusBall = 5;
int xAxisDraw;
int yAxisDraw;

int v = 10;
int vx = v*cos(qeta*PI / 180);
int vy = v*sin(qeta*PI / 180);

int p;
int mposx, mposy;
int check = 0;
int curveCenterX = 250 + 100;
int curveCenterY = 100;
int diameter;
int screenRadius = 250;
int ballDown = 0;
int i = 0;
int iCheck = 0;
int timeChange = 1;
int timeMax;
int rMax;

int xBox = 500, yBox = 0;

typedef struct dotLine{
	int x;
	int y;
};
dotLine line[100];
void change();

void iDraw()
{

	iClear();
	iSetColor(255, 0, 0);
	iLine(0, yAxisDraw, 800, yAxisDraw);
	iLine(xAxisDraw, 0, xAxisDraw, 500);
	iSetColor(255, 255, 255);
	iCircle(xCircle, yCircle, radius, 1000);
	iSetColor(0, 0, 255);
	iLine(xCircle, yCircle, xLine, yLine);
	iSetColor(0, 255, 0);
	iFilledCircle(xBall, yBall, radiusBall*2, 1000);
	///iShowBMP2(xBox, yBox, "b3.bmp", 0);
	///iShowBMP2(xBall, yBall, "angry2.bmp", 0);


	//change();
}


void iMouseMove(int mx, int my)
{
	//place your codes here
	////cout << mx << " " << my << endl;
}


void iMouse(int button, int state, int mx, int my)
{
	//cout << mx << " " << my << endl;
	double a = mx - 100;
	double b = my - 100;
	//cout << a << " " << b << endl;
	//cout << qeta << endl;
	qeta = atan2(b, a) * 180 / PI;

	xLine = xCircle + (radius + 30)*cos(qeta * PI / 180);
	yLine = yCircle + (radius + 30)*sin(qeta * PI / 180);
	vx = v*cos(qeta*PI / 180);
	vy = v*sin(qeta*PI / 180);

	diameter = curveCenterX + (screenRadius)*cos(qeta * PI / 180);
	diameter = diameter / 2;
	if (button == GLUT_LEFT_BUTTON && state == GLUT_DOWN)
	{
		//place your codes here
	}
	if (button == GLUT_RIGHT_BUTTON && state == GLUT_DOWN)
	{
		//place your codes here
	}
}


void iPassiveMouseMove(int mx, int my)
{
	//place your code here

	mposx = mx;
	mposy = my;
	//cout << mx << " " << my << endl;
	if (mx == 2){}        /*Something to do with mx*/
	else if (my == 2){}   /*Something to do with my*/

}


void iKeyboard(unsigned char key)
{
	if (key == ' ')
	{
		check = 1;
		cout << "The Bird Started " << check << endl;
	}
	//place your codes for other keys here
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

	if (key == GLUT_KEY_END)
	{
		exit(0);
	}
	if (key == GLUT_KEY_UP)
	{
		if (qeta <= 80 && check == 0)
		{
			qeta += 5;
			xLine = xCircle + (radius + 30)*cos(qeta * PI / 180); // x2
			yLine = yCircle + (radius + 30)*sin(qeta * PI / 180); // y2
			vx = v*cos(qeta*PI / 180);
			vy = v*sin(qeta*PI / 180);
			timeMax = v*sin(qeta*PI / 180) / g;
			rMax = v*v*sin(2 * qeta*PI / 180) / g;


		}


		//cout << vx << " " << vy << endl;

	}
	if (key == GLUT_KEY_DOWN)
	{
		if (qeta >= 0 && check == 0)
		{
			qeta -= 5;
			xLine = xCircle + (radius + 30)*cos(qeta * PI / 180);
			yLine = yCircle + (radius + 30)*sin(qeta * PI / 180);
			vx = v*cos(qeta*PI / 180);
			vy = v*sin(qeta*PI / 180);
			timeMax = v*sin(qeta*PI / 180) / g;
			rMax = v*v*sin(2 * qeta*PI / 180) / g;


		}


		//cout << vx << " " << vy << endl;
	}
	if (key == GLUT_KEY_LEFT)
	{
		if (qeta <= 80 && check == 0)
		{
			qeta += 5;
			xLine = xCircle + (radius + 30)*cos(qeta * PI / 180);
			yLine = yCircle + (radius + 30)*sin(qeta * PI / 180);
			vx = v*cos(qeta*PI / 180);
			vy = v*sin(qeta*PI / 180);
			timeMax = v*sin(qeta*PI / 180) / g;
			rMax = v*v*sin(2 * qeta*PI / 180) / g;


		}


		//cout << vx << " " << vy << endl;
	}
	if (key == GLUT_KEY_RIGHT)
	{
		if (qeta > 0 && check == 0)
		{
			qeta -= 5;
			xLine = xCircle + (radius + 30)*cos(qeta * PI / 180);
			yLine = yCircle + (radius + 30)*sin(qeta * PI / 180);
			vx = v*cos(qeta*PI / 180);
			vy = v*sin(qeta*PI / 180);
			timeMax = v*sin(qeta*PI / 180) / g;
			rMax = v*v*sin(2 * qeta*PI / 180) / g;


		}


		//cout << vx << " " << vy << endl;
	}
}

int main()
{
	//place your own initialization codes here.
	p = iSetTimer(1, change);
	iInitialize(1200, 500, "Angry Bird");
	return 0;
}

void change()
{
	if (check == 1)
	{

		xBall = v*cos(qeta*PI / 180)*timeChange;
		yBall = xBall*tan(qeta*PI / 180) - 0.5*g*xBall*xBall / (v*cos(qeta*PI / 180)) / (v*cos(qeta*PI / 180));

		if (timeChange != timeMax)
			timeChange++;

		if (yBall < 0)
		{
			timeChange = 1;
			timeMax = 0;
			check = 0;
			xBall = yBall = 0;
			//cout << "The Bird cordinate" << xBall << " " << yBall << endl;
			//cout << "check " << check << endl;
			//cout << "timeChange " << timeChange << " timeMax" << timeMax << endl;
		}
		//else if (xBall + 80 >= xBox && xBall <= xBox + 256 && yBall + 89 >= yBox && yBall <= yBox + 256)
		//{
			//if (yBall >= yBox && yBall <= yBox + 100)

			//playerScore += 100;
			//scorePrint(playerScoreS, playerScore);
			//timeChange = 1;
			//timeMax = 0;
			//check = 0;
			//xBall = yBall = 0;
			//xBox = yBox = 2000;
			//cout << "The Bird cordinate" << xBall << " " << yBall << endl;
			//cout << "check " << check << endl;
			//cout << "timeChange " << timeChange << " timeMax" << timeMax << endl;

		//}
	}
}

