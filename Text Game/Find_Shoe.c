/*
Edited by: Rafael Christian V. Sanchez

Last Edited: September 27, 2020

Sources:
1.) Randomizer - https://www.tutorialspoint.com/c_standard_library/c_function_rand.htm#:~:text=The%20C%20library%20function%20int,to%20be%20at%20least%2032767.
2.) RollingDie - https://codereview.stackexchange.com/questions/143834/dice-roll-program-in-c.
3.) Runtime - https://levelup.gitconnected.com/8-ways-to-measure-execution-time-in-c-c-48634458d0f9.
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <sys/time.h>

//Global Variables//
int nTime = 0;
int nHeart = 0;
int nFind = 0;
int nToy = 0;
int nStep = 0;

//Function declaration for Randomizer//
int Randomizer ( int nRange );

//Function declaration for rolling a die//
int RollingDice ( int *nDie );

//Function declaration for rolling two dice//
int RollingTwoDice ( int *nDie1, int *nDie2 );

//Function declaration for actions when a player enters a room//
void DisplayActions ( int *nShoe, int *nRoom, int *nEndgame, char *cDogName );

//Function declaration for quiting//
void Quit ( int *nShoe, int *nEndgame, int *nContinue, char *cDogName );

int main( void ) 
{
  int nShoe,
      nChoice,
      nEndgame = 0,
      nContinue = 0,
      nInputGender = 0,
      //Variables for Locations//
      nBedroom2 = 1,
      nBath2 = 2,
      nWIC2 = 3,
      nHallway = 4,
      nGuestSuite = 5,
      nLaundry = 6,
      nLinen = 7,
      nMasterBedroom = 8,
      nLeftMasterWIC = 9,
      nRightMasterWIC = 10,
      nMasterBath = 11,
      nStairs = 12,
      nFoyer = 13,
      nCoveredEntry = 14,
      nGarage = 15,
      nPowder = 16,
      nLivingroom = 17,
      nDiningroom = 18,
      nKitchen = 19,
      nCoveredTerrace = 20,
      nGarden = 21;
  char  cDogName,
        cBuffer;
  //Variables for computing time//
  double dElapsed;
  long lSeconds,
       lMicroseconds;

  //Time count starts//
  struct timeval begin, end;
  gettimeofday(&begin, 0);

  //Hides the shoe in one of the locations//
  //+1 so that the nShoe will never be equal to 0 and reach the value of 21//
  nShoe = Randomizer( 21 )+1 ;

  //Introduction for the player//
  printf( "\n---------------------------------------------------------------------\n" );
  printf( "\nWelcome to the text-based game 'Find Shoe'\n" );
  printf( "Your goal is to find the shoe that your dog hid\n" );
  printf( "\nRules:\n"  );
  printf( "1. You roll dice everytime you go into a location\n" );
  printf( "2. You can only go to the location adjacent to where you are\n" );
  printf( "3. You win the game when you find the shoe without holding any toys\n" );
  printf( "\nToybin locations:\n"  );
  printf( "1. Bedroom #2\n" );
  printf( "2. Garage\n" );
  printf( "3. Covered terrace\n" );
  printf( "\n---------------------------------------------------------------------\n" );
  
  //Gets the input for the gender of the dog//
  printf( "\nWhat is the gender of your dog?\n" );
  printf( "[M] for Male\n" );
  printf( "[F] for Female\n" );

    //While loop for gender choice//
    while( nInputGender != 1 )
    {
       printf( "\nChoice : " );
       scanf( "%c", &cDogName ); 
       scanf( "%c", &cBuffer );
       
        //Conditions for determining the gender of the dog//
        if( *&cDogName == 'M'  || *&cDogName == 'm' )   
        {             
          nInputGender = 1;
          char *cDogName = "Bailey";
          printf( "\nYour dog's name is %s\n",cDogName );
        }
        else if( *&cDogName == 'F' || *&cDogName == 'f' )
        {
          nInputGender = 1;
          char *cDogName = "Kahlua";
          printf( "\nYour dog's name is %s\n",cDogName );
        }
        else
        {
          printf( "\nINVALID GENDER\n" );
        }
    }
  printf( "\n---------------------------------------------------------------------\n" );
	
  //First Turn//
  printf( "\nAre you ready to find your shoe?\n"  );
  printf( "[1] - To Start\n" );

    //Loops the locations together//
    //While nEndgame is not equal to 1, the game will continue//
    while( nEndgame != 1 )
    { 
      //Loop scan for locations//
      printf( "\nChoice: ");
      scanf( "%d", &nChoice );
      scanf( "%c", &cBuffer ); 
    
        //Scans for the chosen location of the player//
        if( nChoice == 1 )
        {
          printf( "\n---------------------------------------------------------------------\n" );
          printf( "\nYOU ARE CURRENTLY IN YOUR BEDROOM (#2)\n"  );

          //Calls the function to display available actions when entering a location//
          DisplayActions( &nShoe, &nBedroom2, &nEndgame, &cDogName );
          
          //Will not display if the game ends//
          if( nEndgame != 1 )
          {
            //Gives the player the option to quit//
            Quit( &nShoe, &nEndgame, &nContinue, &cDogName );

              //Will continue the game when the player choose no to quiting//
              if( nContinue == 1 )
              {
                printf( "\n---------------------------------------------------------------------\n" );
                printf( "\nWhere do you want to go?\n" );
                printf( "[1] - Go back to bedroom\n" );
                printf( "[2] - Go to the 2nd floor bathroom\n" );
                printf( "[3] - Go to the bedroom's walk-in-closet\n" );
                printf( "[4] - Go to the hallway\n"  );
              }
          }
        }
        else if( nChoice == 2 )
        {
          printf( "\n---------------------------------------------------------------------\n" );
          printf( "\nYOU ARE NOW AT YOUR 2ND FLOOR BATHROOM\n" );
          DisplayActions( &nShoe , &nBath2, &nEndgame, &cDogName );
          
          if( nEndgame != 1 )
          {
            Quit( &nShoe, &nEndgame, &nContinue, &cDogName );

              if( nContinue == 1 )
              {
                printf( "\n---------------------------------------------------------------------\n" );
                printf( "\nWhere do you want to go next?\n" );
                printf( "[2] - Go back to 2nd floor bathroom\n" );
                printf( "[1] - Go to bedroom #2\n" );
                printf( "[4] - Go to the hallway\n"  );
              }
          }
        }
        else if( nChoice == 3 )
        {
          printf( "\n---------------------------------------------------------------------\n" );
          printf( "\nYOU ARE NOW AT YOUR BEDROOM'S WALK-IN-CLOSET\n" );
          DisplayActions( &nShoe , &nWIC2, &nEndgame, &cDogName );
          
          if( nEndgame != 1 )
          {
            Quit( &nShoe, &nEndgame, &nContinue, &cDogName );

              if( nContinue == 1 )
              {
                printf( "\n---------------------------------------------------------------------\n" );
                printf( "\nWhere do you want to go next?\n" );
                printf( "[3] - Go back to bedroom's walk-in-closet\n" );
                printf( "[1] - Go to bedroom #2\n" );
              }
          }
        }
        else if( nChoice == 4 )
        {
          printf( "\n---------------------------------------------------------------------\n" );
          printf( "\nYOU ARE NOW AT THE 2ND FLOOR HALLWAY\n" );
          DisplayActions( &nShoe, &nHallway, &nEndgame, &cDogName );
          
          if( nEndgame != 1 )
          {
            Quit( &nShoe, &nEndgame, &nContinue, &cDogName );

              if( nContinue == 1 )
              {
                printf( "\n---------------------------------------------------------------------\n" );
                printf( "\nWhere do you want to go next?\n" );
                printf( "[4] - Go back to the 2nd floor hallway\n" );
                printf( "[1] - Go to bedroom #2\n" );
                printf( "[2] - Go to the 2nd floor bathroom\n" );
                printf( "[5] - Go to the Guest Suite\n" );
                printf( "[6] - Go to the Laundry\n" );
                printf( "[7] - Go to the Linen\n" );
                printf( "[8] - Go to the Master bedroom\n" );
                printf( "[12] - Go to stairs (To go down)\n" );
              }
          }
        }
        else if( nChoice == 5 )
        {
          printf( "\n---------------------------------------------------------------------\n" );
          printf( "\nYOUR ARE NOW AT THE GUEST SUITE\n" );
          DisplayActions( &nShoe, &nGuestSuite, &nEndgame, &cDogName );
          
          if( nEndgame != 1 )
          {
            Quit( &nShoe, &nEndgame, &nContinue, &cDogName );

              if( nContinue == 1 )
              {
                printf( "\n---------------------------------------------------------------------\n" );
                printf( "\nWhere do you want to go next?\n" );
                printf( "[5] - Go back to the guest suite\n" );
                printf( "[1] - Go to the bedroom #2\n" );
                printf( "[4] - Go to the 2nd floor hallway\n" );
                printf( "[8] - Go to the Master bedroom\n" );
              }
          }
        }
        else if( nChoice == 6 )
        {
          printf( "\n---------------------------------------------------------------------\n" );
          printf( "\nYOU ARE NOW AT THE LAUNDRY ROOM\n" );
          DisplayActions( &nShoe, &nLaundry, &nEndgame, &cDogName );
          
          if( nEndgame != 1 )
          {
            Quit( &nShoe, &nEndgame, &nContinue, &cDogName );

            if( nContinue == 1 )
            {
              printf( "\n---------------------------------------------------------------------\n" );
              printf( "\nWhere do you want to go next?\n" );
              printf( "[6] - Go back to the laundry room\n" );
              printf( "[4] - Go to the 2nd floor hallway\n" );
              printf( "[7] - Go to the Linen\n" );
              printf( "[12] - Go to stairs (To go down)\n" );
            }
          }
        }
        else if( nChoice == 7 )
        {
          printf( "\n---------------------------------------------------------------------\n" );
          printf( "\nYOU ARE NOW AT THE LINEN\n" );
          DisplayActions( &nShoe, &nLinen, &nEndgame, &cDogName );
          
          if( nEndgame != 1 )
          {
            Quit( &nShoe, &nEndgame, &nContinue, &cDogName );

            if( nContinue == 1 )
            {
              printf( "\n---------------------------------------------------------------------\n" );
              printf( "\nWhere do you want to go next?\n" );
              printf( "[7] - Go back to the linen\n" );
              printf( "[4] - Go to the 2nd floor hallway\n" );
              printf( "[6] - Go to the Laundry\n" );
              printf( "[8] - Go to the Master bedroom\n" );
            }
          }
        }
        else if( nChoice == 8 )
        {
          printf( "\n---------------------------------------------------------------------\n" );
          printf( "\nYOU ARE NOW AT THE MASTER BEDROOM\n" );
          DisplayActions ( &nShoe, &nMasterBedroom, &nEndgame, &cDogName );
          
          if ( nEndgame != 1 )
          {
            Quit( &nShoe, &nEndgame, &nContinue, &cDogName );

            if ( nContinue == 1 )
            {
              printf( "\n---------------------------------------------------------------------\n" );
              printf( "\nWhere do you want to go next?\n" );
              printf( "[8] - Go back to Master bedroom\n" );
              printf( "[4] - Go to the 2nd floor hallway\n" );
              printf( "[9] - Go to the Master bedroom's walk-in-closet (Left)\n" );
              printf( "[10] - Go to the Master bedroom's walk-in-closet (Right)\n" );
            }
          }
        }
        else if( nChoice == 9 )
        {
          printf( "\n---------------------------------------------------------------------\n" );
          printf( "\nYOU ARE NOW AT THE MASTER BEDROOM'S WALK-IN-CLOSET (LEFT)\n" );
          DisplayActions( &nShoe , &nLeftMasterWIC, &nEndgame, &cDogName );

          
          if( nEndgame != 1 )
          {
            Quit( &nShoe, &nEndgame, &nContinue, &cDogName );

              if ( nContinue == 1 )
              {
                printf( "\n---------------------------------------------------------------------\n" );
                printf( "\nWhere do you want to go next?\n" );
                printf( "[9] - Go back to the Master bedroom's walk-in-closet (Left)\n" );
                printf( "[8] - Go to the Master bedroom\n" );
                printf( "[10] - Go to the Master bedroom's walk-in-closet (Right)\n" );
                printf( "[11] - Go to the Master bedroom's bathroom\n" );
              }
          }
        }
        else if( nChoice == 10 )
        {
          printf( "\n---------------------------------------------------------------------\n" );
          printf( "\nYOU ARE NOW AT THE MASTER BEDROOM'S WALK-IN-CLOSET (RIGHT)\n" );
          DisplayActions( &nShoe , &nRightMasterWIC, &nEndgame, &cDogName );
          
          if( nEndgame != 1 )
          {
            Quit( &nShoe, &nEndgame, &nContinue, &cDogName );

            if ( nContinue == 1 )
            {
              printf( "\n---------------------------------------------------------------------\n" );
              printf( "\nWhere do you want to go next?\n" );
              printf( "[10] - Go back to the Master bedroom's walk-in-closet (Right)\n" );
              printf( "[8] - Go to the Master bedroom\n" );
              printf( "[9] - Go to the Master bedroom's walk-in-closet (Left)\n" );
              printf( "[11] - Go to the Master bedroom's bathroom\n" );
            }
          }
        }
        else if( nChoice == 11 )
        {
          printf( "\n---------------------------------------------------------------------\n" );
          printf( "\nYOU ARE NOW AT THE MASTER BEDROOM'S BATHROOM\n" );
          DisplayActions( &nShoe , &nMasterBath, &nEndgame, &cDogName );
          
          if( nEndgame != 1 )
          {
            Quit( &nShoe, &nEndgame, &nContinue, &cDogName );

              if ( nContinue == 1 )
              {
                printf( "\n---------------------------------------------------------------------\n" );
                printf( "\nWhere do you want to go next?\n" );
                printf( "[11] - Go back to the Master bedroom's bathroom\n" );
                printf( "[9] - Go to the Master bedroom's walk-in-closet (Left)\n" );
                printf( "[10] - Go to the Master bedroom's walk-in-closet (Right)\n" );
              }
          }
        }
        else if( nChoice == 12 )
        {
          printf( "\n---------------------------------------------------------------------\n" );
          printf( "\nYOU ARE NOW THE STAIRS\n" );
          DisplayActions( &nShoe , &nStairs, &nEndgame, &cDogName );
          
          if( nEndgame != 1 )
          {
            Quit( &nShoe, &nEndgame, &nContinue, &cDogName );

            if( nContinue == 1 )
            {
              printf( "\n---------------------------------------------------------------------\n" );
              printf( "\nWhere do you want to go next?\n" );
              printf( "[12] - Go back to the stairs\n" );
              printf( "[4] - Go to the 2nd floor hallway (to go up)\n" );
              printf( "[13] - Go to the Foyer (to go down)\n" );
            }
          }
        }
        else if( nChoice == 13 )
        {
          printf( "\n---------------------------------------------------------------------\n" );
          printf( "\nYOUR ARE NOW AT THE FOYER\n" );
          DisplayActions( &nShoe , &nFoyer, &nEndgame, &cDogName );
          
          if( nEndgame != 1 )
          {
            Quit( &nShoe, &nEndgame, &nContinue, &cDogName );

            if( nContinue == 1 )
            {
              printf( "\n---------------------------------------------------------------------\n" );
              printf( "\nWhere do you want to go next?\n" );
              printf( "[13] - Go back to the foyer\n" );
              printf( "[14] - Go to the garage\n" );
              printf( "[16] - Go to the living room\n" );
            }
          }
        }
        else if( nChoice == 14 )
        {
          printf( "\n---------------------------------------------------------------------\n" );
          printf( "\nYOU ARE NOW AT THE COVERED ENTRY\n" );
          DisplayActions( &nShoe , &nCoveredEntry, &nEndgame, &cDogName );
          
          if( nEndgame != 1 )
          {
            Quit( &nShoe, &nEndgame, &nContinue, &cDogName );

              if ( nContinue == 1 )
              {
                printf( "\n---------------------------------------------------------------------\n" );
                printf( "\nWhere do you want to go next?\n" );
                printf( "[14] - Go back to the covered entry\n" );
                printf( "[13] - Go to the foyer\n" );
              }
          }
        }
        else if( nChoice == 15 )
        {
          printf( "\n---------------------------------------------------------------------\n" );
          printf( "\nYOU ARE NOW AT THE GARAGE\n" );
          DisplayActions( &nShoe , &nGarage, &nEndgame, &cDogName );
          
          if( nEndgame != 1 )
          {
            Quit( &nShoe, &nEndgame, &nContinue, &cDogName );

              if ( nContinue == 1 )
              {
                printf( "\n---------------------------------------------------------------------\n" );
                printf( "\nWhere do you want to go next?\n" );
                printf( "[15] - Go back to the garage\n" );
                printf( "[13] - Go to the foyer\n" );
              }
          }
        }
        else if( nChoice == 16 )
        {
          printf( "\n---------------------------------------------------------------------\n" );
          printf( "\nYOU ARE NOW AT THE POWDER ROOM\n" );
          DisplayActions( &nShoe , &nPowder, &nEndgame, &cDogName );
          
          if( nEndgame != 1 )
          {
            Quit( &nShoe, &nEndgame, &nContinue, &cDogName );
            
              if ( nContinue == 1 )
              {
                printf( "\n---------------------------------------------------------------------\n" );
                printf( "\nWhere do you want to go next?\n" );
                printf( "[16] - Go back to the powder room\n" );
                printf( "[17] - Go to the living room\n" );
              }
          }
        }
        else if( nChoice == 17 )
        {
          printf( "\n---------------------------------------------------------------------\n" );
          printf( "\nYOUR ARE NOW AT THE LIVING ROOM\n" );
          DisplayActions( &nShoe , &nLivingroom, &nEndgame, &cDogName );
          
          if( nEndgame != 1 )
          {
           Quit( &nShoe, &nEndgame, &nContinue, &cDogName );

              if ( nContinue == 1 )
              {
                printf( "\n---------------------------------------------------------------------\n" );
                printf( "\nWhere do you want to go next?\n" );
                printf( "[17] - Go back to the living room\n" );
                printf( "[13] - Go to the foyer\n" );
                printf( "[16] - Go to the powder room\n" );
                printf( "[18] - Go to the dining room\n" );
                printf( "[20] - Go to the covered terrace\n" );
              }
          }
        } 
        else if( nChoice == 18 )
        {
          printf( "\n---------------------------------------------------------------------\n" );
          printf( "\nYOUR ARE NOW AT THE DINING ROOM\n" );
          DisplayActions( &nShoe , &nDiningroom, &nEndgame, &cDogName );
          
          if ( nEndgame != 1 )
          {
            Quit( &nShoe, &nEndgame, &nContinue, &cDogName );

            if ( nContinue == 1 )
              {
                printf( "\n---------------------------------------------------------------------\n" );
                printf( "\nWhere do you want to go next?\n" );
                printf( "[18] - Go back to the dining room\n" );
                printf( "[17] - Go to the living room\n" );
                printf( "[19] - Go to the kitchen\n" );
                printf( "[20] - Go to the covered terrace\n" );
              }
          }
        } 
        else if( nChoice == 19 )
        {
          printf( "\n---------------------------------------------------------------------\n" );
          printf( "\nYOUR ARE NOW AT THE KITCHEN\n" );
          DisplayActions( &nShoe , &nKitchen, &nEndgame, &cDogName );
          
          if ( nEndgame != 1 )
          {
            Quit( &nShoe, &nEndgame, &nContinue, &cDogName );

              if( nContinue == 1 )
              {
                printf( "\n---------------------------------------------------------------------\n" );
                printf( "\nWhere do you want to go next?\n" );
                printf( "[19] - Go back to the kitchen\n" );
                printf( "[18] - Go to the dining room\n" );
              }
          }
        } 
        else if( nChoice == 20 )
        {
          printf( "\n---------------------------------------------------------------------\n" );
          printf( "\nYOUR ARE NOW AT THE COVERED TERRACE\n" );
          DisplayActions( &nShoe, &nCoveredTerrace, &nEndgame, &cDogName );
          
          if( nEndgame != 1 )
          {
            Quit( &nShoe, &nEndgame, &nContinue, &cDogName );

              if ( nContinue == 1 )
              {
                printf( "\n---------------------------------------------------------------------\n" );
                printf( "\nWhere do you want to go next?\n" );
                printf( "[20] - Go back to the covered terrace\n" );
                printf( "[17] - Go to the living room\n" );
                printf( "[18] - Go to the dining room\n" );
                printf( "[21] - Go to the garden\n" );
              }
          }
        }
        else if( nChoice == 21 )
        {
          printf( "\n---------------------------------------------------------------------\n" );
          printf( "\nYOUR ARE NOW AT THE GARDEN\n" );
          DisplayActions( &nShoe, &nGarden, &nEndgame, &cDogName );
          
          if( nEndgame != 1 )
          {
            Quit( &nShoe, &nEndgame, &nContinue, &cDogName );

              if ( nContinue == 1 )
              {
                printf( "\n---------------------------------------------------------------------\n" );
                printf( "\nWhere do you want to go next?\n" );
                printf( "[21] - Go back to garden\n" );
                printf( "[20] - Go to the covered terrace\n" );
              }
          }
        }
        else 
        {
          printf( "\nINVALID INPUT, Please enter the corresponding number\n" );
		    }
      //Resets the value of nChoice//
      nChoice = 0;
    }
    
  //Clock Ends//
  gettimeofday(&end, 0);
  lSeconds = end.tv_sec - begin.tv_sec;
  lMicroseconds = end.tv_usec - begin.tv_usec;
  dElapsed = lSeconds + lMicroseconds*1e-6;

  //Displays the time//
  nTime = dElapsed;
  //Computes the total time//
  nTime += nFind += nStep -= nHeart;
  printf( "Your total time is %d seconds\n",nTime );
		
  return 0;
}

//Function for Randomizer//
int Randomizer ( int nRange )
{
   int nI,
       nNum,
       nRandomNum;
       time_t t;
  
  //Determines the range//
  nNum = nRange;
 
  //Intializes random number generator//
  srand(( unsigned ) time( &t ));

    //Randomize numbers from the range given by nNum//
    //The upper range will not reach the equal value of nNum//
    for( nI = 0; nI <= 1; nI++ ) 
    {
      nRandomNum = rand() % nNum;
    }

  return nRandomNum;
}

//Function for rolling a die//
int RollingDice ( int *nDie )
{
  srand(time(NULL));

  //Indicates that the range of dice is 1-6//
  *nDie = ( ( rand() % 6 ) + 1 );
  printf( "\nYou rolled a: %d\n", *nDie );  

  return *nDie;
}

//Function for rolling two dice//
int RollingTwoDice ( int *nDie1, int *nDie2 )
{
  srand(time(NULL));

  //Indicates that the range of dice is 1-6//
  *nDie1 = ( ( rand() % 6 ) + 1 );
  *nDie2 = ( ( rand() % 6 ) + 1 );

  return nDie1 && nDie2 ;
}

//Function for actions when a player enters a room//
void DisplayActions ( int *nShoe, int *nRoom, int *nEndgame, char *cDogName )
{
  int nDie,
      nDie1,
      nDie2,
      nInputcheck = 0;
  char cChoice1,
       cChoice2,
       cChoice3,
       cChoice4,
       cChoice5,
       cBuffer;
   
  //Function to roll dice 1 and 2//
  RollingTwoDice( &nDie1, &nDie2 ); 
     
    //First Dice Roll//
    printf( "\nYour 1st die roll is: %d\n",nDie1 );  
    if( nDie1 == 5 || nDie1 == 6 )      
    {  
      //Statement if dog not in the room//
      //Checks for the name of the dog//
      if( *cDogName == 'M'  || *cDogName == 'm' )   
      {
        char *cDogName = "Bailey";
        printf( "%s is not in the room\n",cDogName ); 
      }
      else if( *cDogName == 'F'  || *cDogName == 'f' )
      {
        char *cDogName = "Kahlua";
        printf( "%s is not in the room\n",cDogName ); 
      }    
    }
    else                                     
    {
      //Statement if dog is in room//
      if( *cDogName == 'M'  || *cDogName == 'm' )   
      {
        char *cDogName = "Bailey";
        printf( "%s is in the room\n",cDogName );
      }  
      else if( *cDogName == 'F'  || *cDogName == 'f' )
      {
        char *cDogName = "Kahlua";
        printf( "%s is in the room\n",cDogName ); 
      }  
        //Condition if dog appears//
        //Checks if the player can pet the dog//
        if ( nToy != 2 )
        {
          if( *cDogName == 'M'  || *cDogName == 'm' )   
          {
            char *cDogName = "Bailey";
            printf( "\nDo you want to pet %s\n",cDogName );
            printf( "[Y] Yes, pet %s\n",cDogName );
            printf( "[N] No, don't pet %s\n",cDogName );
          }
          else if( *cDogName == 'F'  || *cDogName == 'f' )   
          {
            char *cDogName = "Kahlua";
            printf( "\nDo you want to pet %s\n",cDogName );
            printf( "[Y] Yes, pet %s\n",cDogName );
            printf( "[N] No, don't pet %s\n",cDogName );
          }
            //Condition to be able to pet the dog//
            if( nToy == 1 || nToy == 0 )
            {
              //While loop for choice if the user wants to pet the dog//
              while( nInputcheck != 1 )
              {
                printf( "\nChoice: ");
                scanf( "%c", &cChoice1 );
                scanf( "%c", &cBuffer );
              
                  //Checks if the user input is yes//
                  if( ( cChoice1 == 'Y' ) || ( cChoice1 == 'y' ) )
                  {
                    //To exit the loop//
                    nInputcheck = 1;

                    printf("\nHeart added\n");
                    nHeart += 1;
                    printf( "Current heart score: %d\n", nHeart );
                  }
                  //Checks if the user input is no//
                  else if( ( cChoice1 == 'N' ) || ( cChoice1 == 'n' ) ) 
                  {
                    nInputcheck = 1;
                      if( *cDogName == 'M'  || *cDogName == 'm' )   
                      {
                        char *cDogName = "Bailey";
                        printf( "%s is sad\n",cDogName );
                      }  
                      else if( *cDogName == 'F'  || *cDogName == 'f' )
                      {
                        char *cDogName = "Kahlua";
                        printf( "%s is sad\n",cDogName ); 
                      }     
                  }
                //Default output if invalid//
                else
                {
                  printf( "\nINVALID INPUT, please type Y or N\n" );
                }
            }
          }
        }
        //Displays a message when the player can't pet the dog//
        else if( nToy == 2 )
        {
          if( *cDogName == 'M'  || *cDogName == 'm' )   
          {
            char *cDogName = "Bailey";
            printf( "\nUnfortunately you cannot pet %s because your hands are full\n",cDogName ); 
          }  
          else if( *cDogName == 'F'  || *cDogName == 'f' )
          {
            char *cDogName = "Kahlua";
            printf( "\nUnfortunately you cannot pet %s because your hands are full\n",cDogName ); 
          }  
        }
    }

  //Second die roll//
  printf( "\nYour 2nd die roll is: %d\n",nDie2 );
  if ( nDie2 == 1 || nDie2 == 2 || nDie2 == 3 )  
  {
    printf( "There is a toy in the room\n" );
    
      //Condition if the player is already carrying two toys//
      if ( nToy == 2 )
      {
        printf( "\nUnfortunately, you have the max number of toys\n" );
      }
      //Condition for the player to be able to pick up the toy//
      else if( nToy == 1 || nToy == 0 )
      {
        printf( "\nYou have %d free hand, will you take the toy?\n" ,2-nToy );
        printf( "[Y] - Take the toy\n" );
        printf( "[N] - Don't take the toy\n" );
        
        //While loop choice for picking up the toy//
          while ( nInputcheck != 2 )
          {
            printf( "\nChoice: " );
            scanf( "%c", &cChoice2 );
            scanf( "%c", &cBuffer );
            
              //Condition for picking up the toy//
              if( ( cChoice2 == 'Y' ) || ( cChoice2 == 'y') )
              {
                nInputcheck = 2;
                nToy += 1;
                printf( "\nYou are now holding %d toy\n",nToy );
              }
              //Condition for not picking up the toy//
              else if ( ( cChoice2 == 'N' ) || ( cChoice2 == 'n') ) 
              {
                nInputcheck = 2;
                printf ( "\nWARNING! You might step on the toy on your way out!\n" );
              }
              //Default output if invalid//
              else
              {
                printf( "\nINVALID INPUT, please type Y or N\n" );
              }
          }
        }
  }
  else
  {
    printf( "There is no toy in the room\n" );
  }

  //Option to throw a toy to a toy bin//
  if( nToy != 0 )
  {
	  if( ( *nRoom == 1 ) || ( *nRoom == 15 ) || ( *nRoom == 20 ) )
	  {
	    printf ( "\nDo you want to throw all your toys to the toybin?\n" );
	    printf ( "Reminders! You need a emtpy hand to win\n" );
	    printf( "[Y] - Yes\n" );
	    printf( "[N] - No\n" );
	
	      //While loop choice for throwing toy to toybin//
	      while( nInputcheck != 3 )
	      {
	        printf( "\nChoice: ");
	        scanf( "%c", &cChoice3 );
	        scanf( "%c", &cBuffer );
	
	          //Condition if the player decides to throw the toys into the toy bin//
	          if( ( cChoice3 == 'Y' ) || ( cChoice3 == 'y' ) )
	          {
	            nInputcheck = 3;
              	nHeart += 1;
              	
              		if ( nToy == 1 )
              		{
                		nToy -= 1;
              		}
	            	else if ( nToy == 2)
              		{
                		nToy -= 2;
              		}
              		
                printf( "\nThe toy has been thrown into the toybin\n" );
                printf( "You have now one less toy in your hand\n" );
                printf( "\nYou are now holding %d toy\n",nToy );
                printf("\nHeart added\n");
                printf( "Current heart score: %d\n",nHeart );
	          }
	          else if( ( cChoice3 == 'N' ) || ( cChoice3 == 'n' ) )
	          {
	            nInputcheck = 3;
	            printf ( "WARNING! You need empty hands to win\n" );
	            printf( "\nYou are now holding %d toy\n",nToy );
	          }
	          else
	          {
	            printf( "\nINVALID INPUT, please type Y or N\n" );
	          }
	      }
	  }
  }
	
  //Option to find the shoe//
  printf( "\nDo you want to find the shoe?\n" );
  printf( "Reminders! Finding the shoe will add 2 seconds to your total time\n" );
  printf( "[Y] - Yes\n" );
  printf( "[N] - No\n" );

    //While loop choice for finding shoe//
    while ( nInputcheck != 4 )
    {
      printf( "\nChoice: ");
      scanf( "%c", &cChoice4 );
      scanf( "%c", &cBuffer );
      
        if( ( cChoice4 == 'Y' ) || ( cChoice4 == 'y' ) )
        {
          nInputcheck = 4;
          printf( "\n2 seconds has been added to your total time\n" );
          nFind += 2;
          
            //Condition for winning//
            if( ( *nShoe == *nRoom ) && ( nToy == 0 ) )
            {
              printf( "\n---------------------------------------------------------------------\n" );
              printf( "\nCONGRATULATIONS! You have found the shoe!\n" );
              printf( "The total hearts you have earnd is %d\n",nHeart );
              nHeart *= 2;
              printf( "%d seconds has been deducted to your total time\n",nHeart );

              //To exit the loop in int main and end the process//
              *nEndgame = 1;
            }
            //The player will not win if s/he is holding a toy//
            else if( ( *nShoe == *nRoom ) && ( nToy != 0 ) )
            {
              printf( "\nYou are still holding a toy, Please put the toy your holding in a to a toybin bin\n" );
              //Will continue the loop in int main//
              *nEndgame = 0;
            }
            else if( ( *nShoe != *nRoom ) )
            {
              printf( "\nThe shoe is not in the room\n" );
              *nEndgame = 0;
            }
        }
        else if( ( cChoice4 == 'N' ) || ( cChoice4 == 'n' ) )
        {
          nInputcheck = 4;
        }
        else
        {
          printf( "\nINVALID INPUT, please type Y or N\n" );
        }
    }

  //Option to leave the room//
  if( *nShoe != *nRoom )
  {
    printf ( "\nDo you want to leave the room?\n" );
    printf( "[Y] - Yes\n" );
    printf( "[N] - No\n" );
      
      //While loop choice for leaving the room//
      while( nInputcheck != 5 )
      {
        printf( "\nChoice: ");
        scanf( "%c", &cChoice5 );
        scanf( "%c", &cBuffer );
          
          //Condition if player decides to leave the room//
          if( ( cChoice5 == 'Y' ) || ( cChoice5 == 'y' ) )
          {
            nInputcheck = 5;
            printf( "\nYou are leaving the room\n" );
              
              //Checks back if the player picked up the toy to create the random event of stepping on the toy//
              if( ( cChoice2 == 'N' ) || ( cChoice2 == 'n' ) || ( nToy == 2 ) )
              {
                //Calling the function to roll a dice//
                RollingDice( &nDie );
                  
                  //Condition to step on the toy//
                  if( nDie == 2 || nDie == 4 || nDie == 6 )
                  {
                    printf( "You stepped on the toy\n" );
                    nStep += 3;
                    printf( "\n3 seconds have been added to your total time\n" );
                  }
                  else
                  {
                    printf( "You did not step on the toy\n" );
                  }
              }
          }
          //Condition if the player wants to stay at the room//
          else if( ( cChoice5 == 'N' ) || ( cChoice5 == 'n' ) )
          {
            printf( "\nYou are staying in the room\n" );
            printf( "[Y] - To leave the room\n" ); 
            printf( "[N] - To keep staying in the room\n" ); 
          }
          else
          {
            printf( "\nINVALID INPUT, please type Y or N\n" );
          } 
      }
  }
  
  return;
}

//Function for quiting//
void Quit ( int *nShoe, int *nEndgame, int *nContinue, char *cDogName )
{
  int nInputquit = 0;
  char cQuit,
  	   cBuffer;
  	   
    //Option to Quit//
    printf( "\n---------------------------------------------------------------------\n" );
    printf( "\nDo you want to quit now?\n" );
    printf( "[Y] - Yes\n" );
    printf( "[N] - No\n" );

      //While loop choice for quiting//
      while( nInputquit != 1 )
      {
        printf( "\nChoice: ");
        scanf( "%c", &cQuit );
        scanf( "%c", &cBuffer );
          
          if( ( cQuit == 'Y' ) || ( cQuit == 'y' ) )
          {
            //To exit the nInputquit loop//
            nInputquit = 1;

            //So that it won't display the next options after quitting//
            *nContinue = 0;
              
              //Display where the shoe is//
              if( *nShoe == 1 )
              {
                //Determines the name of the dog//
                if( *cDogName == 'M'  || *cDogName == 'm' )   
                {
                  char *cDogName = "Bailey";
                  printf( "\n%s hid the shoe at bedroom #2\n",cDogName );
                }  
                else if( *cDogName == 'F'  || *cDogName == 'f' )
                {
                  char *cDogName = "Kahlua";
                  printf( "\n%s hid the shoe at bedroom #2\n",cDogName ); 
                }  
                *nEndgame = 1;
              }
              else if( *nShoe == 2 )
              {
                if( *cDogName == 'M'  || *cDogName == 'm' )   
                {
                  char *cDogName = "Bailey";
                  printf( "\n%s hid the shoe at 2nd floor bathroom\n",cDogName );
                }  
                else if( *cDogName == 'F'  || *cDogName == 'f' )
                {
                  char *cDogName = "Kahlua";
                  printf( "\n%s hid the shoe at 2nd floor bathroom\n",cDogName ); 
                }
                *nEndgame = 1;
              }
              else if( *nShoe == 3 )
              {
                if( *cDogName == 'M'  || *cDogName == 'm' )   
                {
                  char *cDogName = "Bailey";
                  printf( "\n%s hid the shoe at bedroom's walk-in-close\n",cDogName );
                }  
                else if( *cDogName == 'F'  || *cDogName == 'f' )
                {
                  char *cDogName = "Kahlua";
                  printf( "\n%s hid the shoe at bedroom's walk-in-close\n",cDogName ); 
                }
                *nEndgame = 1;
              }
              else if( *nShoe == 4 )
              {
                if( *cDogName == 'M'  || *cDogName == 'm' )   
                {
                  char *cDogName = "Bailey";
                  printf( "\n%s hid the shoe at the hallway\n",cDogName );
                }  
                else if( *cDogName == 'F'  || *cDogName == 'f' )
                {
                  char *cDogName = "Kahlua";
                  printf( "\n%s hid the shoe at the hallway\n",cDogName ); 
                }
                *nEndgame = 1;
              }
              else if( *nShoe == 5 )
              {
                if( *cDogName == 'M'  || *cDogName == 'm' )   
                {
                  char *cDogName = "Bailey";
                  printf( "\n%s hid the shoe at the guest suit\n",cDogName );
                }  
                else if( *cDogName == 'F'  || *cDogName == 'f' )
                {
                  char *cDogName = "Kahlua";
                  printf( "\n%s hid the shoe at the guest suit\n",cDogName ); 
                }
                *nEndgame = 1;
              }
              else if( *nShoe == 6 )
              {
                if( *cDogName == 'M'  || *cDogName == 'm' )   
                {
                  char *cDogName = "Bailey";
                  printf( "\n%s hid the shoe at the laundry\n",cDogName );
                }  
                else if( *cDogName == 'F'  || *cDogName == 'f' )
                {
                  char *cDogName = "Kahlua";
                  printf( "\n%s hid the shoe at the laundry\n",cDogName ); 
                }
                *nEndgame = 1;
              }
              else if( *nShoe == 7 )
              {
                if( *cDogName == 'M'  || *cDogName == 'm' )   
                {
                  char *cDogName = "Bailey";
                  printf( "\n%s hid the shoe at the linen\n",cDogName );
                }  
                else if( *cDogName == 'F'  || *cDogName == 'f' )
                {
                  char *cDogName = "Kahlua";
                  printf( "\n%s hid the shoe at the linen\n",cDogName ); 
                }
                *nEndgame = 1;
              }
              else if( *nShoe == 8 )
              {
                if( *cDogName == 'M'  || *cDogName == 'm' )   
                {
                  char *cDogName = "Bailey";
                  printf( "\n%s hid the shoe at Master bedroom\n",cDogName );
                }  
                else if( *cDogName == 'F'  || *cDogName == 'f' )
                {
                  char *cDogName = "Kahlua";
                  printf( "\n%s hid the shoe at Master bedroom\n",cDogName ); 
                }
                *nEndgame = 1;
              }
              else if ( *nShoe == 9 )
              {
                if( *cDogName == 'M'  || *cDogName == 'm' )   
                {
                  char *cDogName = "Bailey";
                  printf( "\n%s hid the shoe at the Master bedroom's walk-in-closet (left)\n",cDogName );
                }  
                else if( *cDogName == 'F'  || *cDogName == 'f' )
                {
                  char *cDogName = "Kahlua";
                  printf( "\n%s hid the shoe at the Master bedroom's walk-in-closet (left)\n",cDogName ); 
                }
                *nEndgame = 1;
              }
              else if( *nShoe == 10 )
              {
                if( *cDogName == 'M'  || *cDogName == 'm' )   
                {
                  char *cDogName = "Bailey";
                  printf( "\n%s hid the shoe at the Master bedroom's walk-in-closet (right)\n",cDogName );
                }  
                else if( *cDogName == 'F'  || *cDogName == 'f' )
                {
                  char *cDogName = "Kahlua";
                  printf( "\n%s hid the shoe at the Master bedroom's walk-in-closet (right)\n",cDogName ); 
                }
                *nEndgame = 1;
              }
              else if( *nShoe == 11 )
              {
                if( *cDogName == 'M'  || *cDogName == 'm' )   
                {
                  char *cDogName = "Bailey";
                  printf( "\n%s hid the shoe at the Master bedroom's bathroom\n",cDogName );
                }  
                else if( *cDogName == 'F'  || *cDogName == 'f' )
                {
                  char *cDogName = "Kahlua";
                  printf( "\n%s hid the shoe at the Master bedroom's bathroom\n",cDogName ); 
                }
                *nEndgame = 1;
              }
              else if( *nShoe == 12 )
              {
                if( *cDogName == 'M'  || *cDogName == 'm' )   
                {
                  char *cDogName = "Bailey";
                  printf( "\n%s hid the shoe at the stairs\n",cDogName );
                }  
                else if( *cDogName == 'F'  || *cDogName == 'f' )
                {
                  char *cDogName = "Kahlua";
                  printf( "\n%s hid the shoe at the stairs\n",cDogName ); 
                }
                *nEndgame = 1;
              }
              else if( *nShoe == 13 )
              {
                if( *cDogName == 'M'  || *cDogName == 'm' )   
                {
                  char *cDogName = "Bailey";
                  printf( "\n%s hid the shoe at the foyer\n",cDogName );
                }  
                else if( *cDogName == 'F'  || *cDogName == 'f' )
                {
                  char *cDogName = "Kahlua";
                  printf( "\n%s hid the shoe at the foyer\n",cDogName ); 
                }
                *nEndgame = 1;
              }
              else if( *nShoe == 14 )
              {
                if( *cDogName == 'M'  || *cDogName == 'm' )   
                {
                  char *cDogName = "Bailey";
                  printf( "\n%s hid the shoe at the covered entry\n",cDogName );
                }  
                else if( *cDogName == 'F'  || *cDogName == 'f' )
                {
                  char *cDogName = "Kahlua";
                  printf( "\n%s hid the shoe at the covered entry\n",cDogName ); 
                }
                *nEndgame = 1;
              }
              else if( *nShoe == 15 )
              {
                if( *cDogName == 'M'  || *cDogName == 'm' )   
                {
                  char *cDogName = "Bailey";
                  printf( "\n%s hid the shoe at the garage\n",cDogName );
                }  
                else if( *cDogName == 'F'  || *cDogName == 'f' )
                {
                  char *cDogName = "Kahlua";
                  printf( "\n%s hid the shoe at the garage\n",cDogName ); 
                }
                *nEndgame = 1;
              }
              else if( *nShoe == 16 )
              {
                if( *cDogName == 'M'  || *cDogName == 'm' )   
                {
                  char *cDogName = "Bailey";
                  printf( "\n%s hid the shoe at the powder room\n",cDogName );
                }  
                else if( *cDogName == 'F'  || *cDogName == 'f' )
                {
                  char *cDogName = "Kahlua";
                  printf( "\n%s hid the shoe at the powder room\n",cDogName ); 
                }
                *nEndgame = 1;
              }
              else if( *nShoe == 17 )
              {
                if( *cDogName == 'M'  || *cDogName == 'm' )   
                {
                  char *cDogName = "Bailey";
                  printf( "\n%s hid the shoe at living room\n",cDogName );
                }  
                else if( *cDogName == 'F'  || *cDogName == 'f' )
                {
                  char *cDogName = "Kahlua";
                  printf( "\n%s hid the shoe at living room\n",cDogName ); 
                }
                *nEndgame = 1;
              }
              else if( *nShoe == 18 )
              {
                if( *cDogName == 'M'  || *cDogName == 'm' )   
                {
                  char *cDogName = "Bailey";
                  printf( "\n%s hid the shoe at the dining room\n",cDogName );
                }  
                else if( *cDogName == 'F'  || *cDogName == 'f' )
                {
                  char *cDogName = "Kahlua";
                  printf( "\n%s hid the shoe at the dining room\n",cDogName ); 
                }
                *nEndgame = 1;
              }
              else if( *nShoe == 19 )
              {
                if( *cDogName == 'M'  || *cDogName == 'm' )   
                {
                  char *cDogName = "Bailey";
                  printf( "\n%s hid the shoe at the kitchen\n",cDogName );
                }  
                else if( *cDogName == 'F'  || *cDogName == 'f' )
                {
                  char *cDogName = "Kahlua";
                  printf( "\n%s hid the shoe at the kitchen\n",cDogName ); 
                }
                *nEndgame = 1;
              }
              else if( *nShoe == 20 )
              {
                if( *cDogName == 'M'  || *cDogName == 'm' )   
                {
                  char *cDogName = "Bailey";
                  printf( "\n%s hid the shoe at the covered terrace\n",cDogName );
                }  
                else if( *cDogName == 'F'  || *cDogName == 'f' )
                {
                  char *cDogName = "Kahlua";
                  printf( "\n%s hid the shoe at the covered terrace\n",cDogName ); 
                }
                *nEndgame = 1;
              }
              else if( *nShoe == 21 )
              {
                if( *cDogName == 'M'  || *cDogName == 'm' )   
                {
                  char *cDogName = "Bailey";
                  printf( "\n%s hid the shoe at the garden\n",cDogName );
                }  
                else if( *cDogName == 'F'  || *cDogName == 'f' )
                {
                  char *cDogName = "Kahlua";
                  printf( "\n%s hid the shoe at the garden\n",cDogName ); 
                }
                *nEndgame = 1;
              }
            }
            else if( ( cQuit == 'N' ) || ( cQuit == 'n' ) )
            {
              nInputquit = 1;

              //To be able to display the next options//
              *nContinue = 1;
            }
            else
            {
              printf( "\nINVALID INPUT, please type Y or N\n" );
            }
      }

	return;
}
