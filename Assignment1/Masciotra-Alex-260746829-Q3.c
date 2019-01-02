/*
 ============================================================================
 Name        : Masciotra-Alex-260746829-Q3.c
 Author      : Alex Masciotra
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>


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
