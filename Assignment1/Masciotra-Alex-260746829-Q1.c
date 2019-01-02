/*
 ============================================================================
 Name        : Masciotra-Alex-260746829-Q1.c
 Author      : Alex Masciotra
 Version     :
 Copyright   : Your copyright notice
 Description : toString C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

/* I will first declare my toString and append functions before the main*/
void toString(int argc, char*argv[], char buffer[]);
void append(char out[],char in[]);

void toString(int argc, char *argv[], char buffer[])
{
	int y;
	for (y=1; y< argc; y++)
	{/*this adds each word from the string to buffer*/
		append(buffer, argv[y]);

	}
}


void append (char out[], char in[])
{
	int l,i;
	l=0;/* here l represents the length of the string*/
	while (out[l]!='\0')
	{
		l++;
	}
	i=0;
	while (in[i]!='\0')
	{
		out[l]=in[i];
	i++;
	l++;
	}
}
