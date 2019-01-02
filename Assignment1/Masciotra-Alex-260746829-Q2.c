/*
 ============================================================================
 Name        : Masciotra-Alex-260746829-Q2.c
 Author      : Alex Masciotra
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>



int doHist(char buffer[], char hist[])
{
	for (int i=0;i<256;i++)
	{
		hist[i]='0';/*set each hist value to 0*/
	}
	int i=0;
	while (buffer[i]!='\0')
	{/*changing the char value of 0 to the corresponding ascii code*/
		int character;
		character=(int)buffer[i];
		hist[character]++;
		i++;
	}
	return 0;
}





