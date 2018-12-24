/*
	Project Name : Youtube Project
	Author		 : Sayef Reyadh Khan
	Language	 : C/C++
	*/
#include<iostream>
using namespace std;
# include "iGraphics.h"

#define screenWidth 1200
#define screenHight 600
#define JUMPLIMIT 200
#define BIRDSNUMBER 100
int mposx, mposy;
bool musicOn = false;
int x = 0;
int y = 0;

int r = 255;
int g = 255;
int b = 255;

int dx = 10;
int dy = 10;

void change();

char bc[4][20] = { "bc\\1.bmp", "bc\\2.bmp", "bc\\3.bmp", "bc\\4.bmp" };
int bcIndex = 0;

char naruto[8][15] = { "char\\1.bmp", "char\\2.bmp", "char\\3.bmp", "char\\4.bmp", "char\\5.bmp", "char\\6.bmp", "char\\7.bmp", "char\\8.bmp" };
char narutoJ[2][15] = { "char\\Jump.bmp", "char\\Jump2.bmp" }; // jump image
char narutoShoot[15] = "char\\z.bmp";
char narutoHit[20] = "char\\narutoHit.bmp";

char narutoStand[15] = "char\\11.bmp";

int narutoCordinateX = 0;
int narutoCordinateY = 0;
int narutoIndex = 0;

bool standPosition = true;
int standCounter = 0;

bool jump = false;
bool jumpUp = false;

int narutoCordinateJump = 0;

//Enemy variables
char birdOne[10][20] = { "enemy\\birdone1.bmp", "enemy\\birdone2.bmp", "enemy\\birdone3.bmp", "enemy\\birdone4.bmp", "enemy\\birdone5.bmp", "enemy\\birdone6.bmp", "enemy\\birdone7.bmp", "enemy\\birdone8.bmp", "enemy\\birdone9.bmp", "enemy\\birdone10.bmp" };

struct habijabi
{
	int bird_x;
	int bird_y;
	int birdIndex;
	bool birdShow;
};

habijabi enemy[BIRDSNUMBER];

void narutoMovement()
{
	if (jump)
	{
		if (jumpUp)
		{
			iShowBMP2(narutoCordinateX, narutoCordinateY + narutoCordinateJump, narutoJ[0], 0);
		}
		else
		{
			iShowBMP2(narutoCordinateX, narutoCordinateY + narutoCordinateJump, narutoJ[1], 0);
		}
	}
	else
	{
		if (!standPosition)
		{
			iShowBMP2(narutoCordinateX, narutoCordinateY, naruto[narutoIndex], 0);
			standCounter++;
			if (standCounter >= 20)
			{
				standCounter = 0;
				narutoIndex = 0;
				standPosition = true;
			}
		}
		else
		{
			iShowBMP2(narutoCordinateX, narutoCordinateY, narutoStand, 0);
		}
	}
}

void enemyMovement()
{
	for (int i = 0; i < BIRDSNUMBER; i++)
	{
		if (enemy[i].birdShow)
		{
			iShowBMP2(enemy[i].bird_x, enemy[i].bird_y, birdOne[enemy[i].birdIndex], 0);
		}
	}
}

void iDraw()
{
	iClear();
	iSetColor(r, g, b);
	//background
	iShowBMP(0, 0, bc[bcIndex]);
	enemyMovement();
	narutoMovement();



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
		if (!jump)
		{
			jump = true;
			jumpUp = true;
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
		narutoCordinateX -= 10;

		narutoIndex--;
		if (narutoIndex < 0)
			narutoIndex = 7;

		standPosition = false;
	}
	else if (key == GLUT_KEY_RIGHT)
	{
		narutoCordinateX += 10;

		narutoIndex++;
		if (narutoIndex >= 8)
			narutoIndex = 0;

		standPosition = false;
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

void change(){

	if (jump)
	{
		if (jumpUp)
		{
			narutoCordinateJump += 5;
			if (narutoCordinateJump >= JUMPLIMIT)
			{
				jumpUp = false;
			}

		}
		else
		{
			narutoCordinateJump -= 5;
			if (narutoCordinateJump < 0)
			{
				jump = false;
				narutoCordinateJump = 0;
			}
		}
	}

	for (int i = 0; i < BIRDSNUMBER; i++)
	{
		enemy[i].bird_x -= 10;
		if (enemy[i].bird_x <= 0)
		{
			enemy[i].bird_x = screenWidth + rand()%300;
		}
		enemy[i].birdIndex++;
		if (enemy[i].birdIndex >= 10)
		{
			enemy[i].birdIndex = 0;
		}
	}


}

void setEnemyVariables()
{
	for (int i = 0; i < BIRDSNUMBER ; i++)
	{
		enemy[i].bird_x = screenWidth + rand() % 300;
		enemy[i].bird_y = 200 + rand() % 300;
		enemy[i].birdIndex = rand() % 10;
		enemy[i].birdShow = true;
	}
}

int main()
{

	setEnemyVariables();
	iSetTimer(25, change);
	if (musicOn)
		PlaySound("music\\playgame3.wav", NULL, SND_LOOP | SND_ASYNC);
	iInitialize(screenWidth, screenHight, "Youtube Project");
	return 0;
}
