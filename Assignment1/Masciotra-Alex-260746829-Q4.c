/*
 ============================================================================
 Name        : Masciotra-Alex-260746829-Q4.c
 Author      : Alex Masciotra
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

void toString(int argc, char *argv[], char buffer[]);
void append (char out[], char in[]);
int doHist(char buffer[], char hist[]);
void displayHist(char hist[], int distinct_chars);

int main(int argc, char *argv[])
{
	char buffer[256];
	char hist[256];
	int distinct_chars=0;

	/* I will now call in my functions */
	toString(argc,argv,buffer);
	doHist (buffer, hist);
	displayHist(hist,distinct_chars);
	return 0;
}
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



void displayHist(char hist[], int distinct_chars)
{

	int maximum=0;
	const int MAXSCALE=25;
	int i;
		for (i=0; i<256; i++)
		{
			if (hist[i]!='0')
			{
				distinct_chars++;
				if(hist[i]-'0'>maximum)
				{
					maximum=hist[i]-'0';
				}
			}
		}
		printf("%d distinct characters found\n",distinct_chars);
		int character;
		for(character=0; character<256; character++)
		{
			if (hist[character]!='0')
			{
				int barlength= (int)(((double)hist[character]-'0')/
				((double)maximum)*((double)MAXSCALE));
				printf("%c [%c]", (char) character, hist[character]);
				for (int i=0;i<barlength;i++)
				{
					printf("*");

				}
				printf("\n");

			}
		}
}










