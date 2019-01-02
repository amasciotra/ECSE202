/*
 ============================================================================
 Name        :ECSE202ASSIGNMENT2.c
 Author      :Alex Masciotra 260746829
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#define NUMRECORDS 50
#define MAXNAMELENGTH 15
#include <stdio.h>
#include <stdlib.h>
//Define structure to hold student data
struct StudentRecord
{
	char FirstNames[MAXNAMELENGTH];
	char LastNames[MAXNAMELENGTH];
	int IDNums;
	int Marks;
};
/*creating swap function with arrays to be used in my quicksort function*/
void swap (struct StudentRecord v[], int i, int j){
	struct StudentRecord temp;
	temp=v[i];
	v[i]=v[j];
	v[j]=temp;

}
/*this quicksort function will order the IDnums in increasing order*/
void quicksort(struct StudentRecord currentRecords[],int left, int right )
{
	int i, last;

	if (left>=right)
		return;
	swap(currentRecords,left,(left+right)/2);
	last = left;
	for (i = left+1; i<=right; i++)
		if (currentRecords[i].IDNums < currentRecords[left].IDNums)
			swap(currentRecords,++last, i);
	swap(currentRecords, left, last);
	quicksort(currentRecords, left, last-1);
	quicksort(currentRecords,last+1,right);

}
/*this binary search will search for the argv[3] student id that is inputted*/
int binarysearch(int x, struct StudentRecord v[], int n) {
	int low, high, mid;

	low=0;
	high=n-1;
	while (low <= high){
		mid = (low+high)/2;
		if(x<v[mid].IDNums){
			high=mid-1;
		}else if(x>v[mid].IDNums){
			low = mid + 1;
		}else{
			return mid;
		}
	}
	return -1;
}

void printStruct (struct StudentRecord record){
	printf("\nID:%d Student:%s,%s Mark:%d \n",record.IDNums, record.LastNames,record.FirstNames, record.Marks);
}

int main(int argc, char * argv[]) {

	struct StudentRecord SRecords[NUMRECORDS];
	int recordnum;

	//Read in Names and ID data
	FILE * NamesIDsDataFile;
	if((NamesIDsDataFile = fopen(argv[1], "r")) == NULL){
		printf("Can't read from file %s\n", argv[1]);
		exit(1);
	}
	for (recordnum=0;recordnum<NUMRECORDS;recordnum++){
		fscanf (NamesIDsDataFile, "%s%s%d", &(SRecords[recordnum].FirstNames[0]),&(SRecords[recordnum].LastNames[0]),&(SRecords[recordnum].IDNums));
	}
	fclose(NamesIDsDataFile);

	//Read in marks data
	FILE * MarksDataFile;
	if((MarksDataFile = fopen(argv[2], "r")) == NULL){
		printf("Can't read from file %s\n", argv[2]);
		exit(1);
	}
	for (recordnum=0;recordnum<NUMRECORDS;recordnum++){
		fscanf (MarksDataFile, "%d", &(SRecords[recordnum].Marks));
	}
	fclose(MarksDataFile);

	//Print out data as read in
	for(recordnum=0;recordnum<NUMRECORDS;recordnum++){
		printf("%s %s %d %d\n",SRecords[recordnum].FirstNames,SRecords[recordnum].LastNames,SRecords[recordnum].IDNums, SRecords[recordnum].Marks);
	}


	int testID;
		testID= atoi(argv[3]);/* atoi converts my string value to an integer value*/

		printf("\n\nRecords sorted by ID:\n");
		quicksort(SRecords, 0, recordnum);
		for(recordnum=0;recordnum<NUMRECORDS;recordnum++){/*printing the sorted IDs*/
				printf("%s %s %d %d\n",SRecords[recordnum].FirstNames,SRecords[recordnum].LastNames,SRecords[recordnum].IDNums, SRecords[recordnum].Marks);
		}


		int index;
		index=binarysearch(testID, SRecords, recordnum);

/* if statement to see whether or not the ID entered in argv[3] is valid or not. either returning
 * does not exist or the correct student information
 */
		if(index == -1){
			printf("\nID: %d does not exist\n",testID);
		}else {
			printStruct( SRecords[index]);
		}

	return EXIT_SUCCESS;


}

