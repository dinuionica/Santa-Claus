# Project - Object Oriented Programming

- ##### Ion- Irinel Dinu ACS, UPB
- ##### [dinuionirinel10@gmail.com] 
- ##### [Github Repo Link] (https://github.com/dinuionica/Santa-Claus)

##### Time spent solving:
+ ~ 1 week - Stage 1
+ 1 day - Stage 2

## Archive Content
* src / -> folder contains implemented packages and classes
* .git -> contains code versioning details
* README.md -> contains details about the structure and implementation


### Santa Claus is coming to ACS students - Stage 2
-------------------------------------------------- -------------------
In stage 2 of the project we implemented a new series of classes
and packages as follows:
+ strategy
    + NiceScoreStrategy -> class specific to a score-based strategy
    of good manners
    + IdStrategy -> class specific to an id-based strategy
    + NiceScoreCityStrategy -> class specific to a media-based strategy
    scores of a city
+ visitor
+ BlackElfVisitor -> the class specific to a Black elf used for the pattern
     Visitor
+ PinkElfVisitor -> the class specific to a Pink elf used for the pattern
     Visitor
+ YellowElfVisitor -> Black elf-specific class used for the pattern
     Visitor
+ interfaces
+ Strategy -> interface used to implement the design pattern
    strategy
+ Visitable -> interfaces used for design implementation
     visitor pattern
+ output
+ GiftOutputData -> the class specific to an output gift

## Logic

##### NiceScoreBonus
In the Command class CalculateBudgetUnit function it has been implemented
the new functionality related to the good score bonus. After it has been calculated
average child-specific score, the new value is updated using the bonus
input. If the value exceeds the maximum value of an average score, this
is truncated at 10.

##### Elves

Designed by elves, it was simulated using the Visitor design pattern. Each child
is visited by an elf, depending on the specific type of each.
+ BlackElfVisitor
    + A method specific to the Black Elf is implemented in this class,
    which decreases the value of the budget allocated to the child by 30%. Also,
    the amount of the budget that the child has available is also updated.
+ PinkElfVisitor
+ Within this class, a similar method is implemented
    the value of the two budgets increases by 30%;
+ YellowElfVisitor
+ Within this class a method is implemented through which
     a gift is given to a child who has not received any gift. It's sorting
     gift list and check
     the existence of the cheapest gift from the favorite category of the child chosen by the elf.

##### Strategy
Strategies for giving gifts to children have been implemented using Strategy.
The list of children is sorted differently depending on the type of strategy.
+ NiceScoreStrategy
    + This class contains a method in which the list of children is sorted
    descending according to averageScore and in case of equality according to id. The children's list is
    then sent for gifts.
+ IdStrategy
   + This class contains a strategy method in which the list of children is
   sorted by id;
+ NiceScoreStrategy
+ Within this class the strategy method is implemented. For starters
create a list of all cities.
+ The average amount is calculated for each city
scores and number of children.
+ The specific score is calculated for each average.
+ Sort the list of cities in descending order by average score
+ The final list of children is built according to the average score of each city

The Enum Cities has been modified, adding a number of new arguments:
averageScore, sumScore and numberChildren. They were in the Command class
implemented the following methods:
 + applyStrategies:
 + Different strategies are executed depending on the input strategy parameter
+ applyChangesBlackPinkElves
+ Apply the changes made by the Black and Pink elves using Visitor
+ applyChangesYellowElf
 + Apply the changes made by the Yellow Elf using Visitor

### Santa Claus is coming to ACS students - Stage 1

## Class Structure and Specific Relationships
To solve stage 1, we implemented a series of classes and packages:
+ child
    + Child -> the class that contains all the information specific to a child
    + Baby -> the class that inherits the Child class, specific to a type child
Baby
    + Kid -> class that inherits the Child class, specific to a type child
Kid
    + Teen -> class that inherits the Child class, specific to a type child
Teen
+ Young Adult -> class that inherits the Child class, specific to a child of
Young Adult type
+ Gift -> the class that contains information specific to a gift

+ input
    + ChildInputData -> class specific to a child received as input
    + GiftInputData -> the specific class of a gift received as input
    + ChildUpdate -> class specific to an annual update received as input for
a child
+ AnnualChanges -> class specific to an annual update received as input for
list of children
+ Input -> the class that contains all the information received as input
+ InputLoader -> the class that handles input data loading

+ output
    + ChildInputData -> class specific to a child transmitted as final output
    + ChildOutputList -> class specific to the final list of children transmitted as
output
+ Output -> the class that contains all the information transmitted as output
+ Writer -> the class that deals with creating and writing the final output

+ simulation
+ DataBase -> the class that creates the lists of children and gifts received as
input
+ ChildFactory -> the class that deals with the application of the factory pattern
for raising children
+ Simulation -> Singleton class that applies simulations and
generates the final output

+ actions
+ Command -> the class that contains the commands applied to the copy list for
each round
+ InitialRound -> the class that applies the commands specific to the initial round
+ AnnualRound -> the class that applies the commands specific to an annual round
+ CreateOutput -> the class that builds the final list of copies as output

+ interfaces
    + ChildInterface -> child-specific interface used to compute AverageScore

## Logic
To run each test we created a folder called output. This folder
contains a number of 25 tests, called out_X.json where X represents the number
current test.

* Main class * runs tests in tests / and compares the results obtained in
output / with those from ref. It also runs in the Main class
checkstyle.

* InputLoader class * reads JSON files using the Jackson library
and maps the fields of the Input class object. For this execution, it is
receives the path to the input file.

* Writer class * maps and writes the Output object that contains the results
simulated in a JSON file whose path is also transmitted.

Simulation is performed using the Simulation class. In it they take over
input data using the Database class that builds the initial list of
children and gift list. The final Output object is created, applied
the initial simulation and then a copy of the list is created for each round
to the current round, which is used to simulate a new annual round and
applying new updates.
Finally, the final object is sent for mapping and writing.

## Implementation

### Simulation
+ In this method the input data is taken over, it is modified later
applied simulations and the resulting final output is returned.

### ChildFactory
+ This class simulates a Singleton Factory design pattern
+ * createChildInput *
+ In this method, each type of child is created according to
of his age using the specific constructors
+ * createChild *
-Create the types of children in a similar way, but the reasoning applies
for children in the database, not for children received as input.

### DataBase
+ This Singleton class simulates a database.
+ * createChildrenList *
+ the factory object is instantiated
+ scroll through the list of copies received as input
+ a new type of child is created according to his age, then
add to final list
+ * createGiftList *
+ similarly scroll through the inpu list, create a new gift that
is added to the list
the final of gifts
+ * createCopyList *
+ a copy of the child list is created using a type constructor
deep copy

### InitialRound
+ Within this class a method is implemented that simulates and applies
commands specific to the initial round.

### AnnualRound
+ Within this class a method is implemented that simulates and applies
 orders specific to an annual round.

### Command
+ A number of commands apply to this Singleton class
specific to a round
+ * annualUpdate *
    + add niceScore update to the list of niceScores for the child
with the desired id
+ the list of new preferences is scrolled and if within the list of
The child's preferences are already found this category is deleted. Then
the new category is added to the first position in the child's preference list.
+ * increaseAge *
+ increases the age of each child in the list
+ using the factory design pattern, the type of each child is updated
depending on his new age.
+ * addNewChildren *
+ the list of new children is scrolled
+ a new child is created based on the input data, it is updated
fields and add
to the final list of children
+ * addNewGift *
+ scroll through the list of gifts received as input and create a new one
gift based on the information received, which is added to the final list of
Gifts
+ * updateSantaBudget *
+ the value of Santa's budget is updated based on the new budget received
as input
+ * removeYoungAdults *
+ children over the age of one (those who have become
Young Adult)
+ * calculateBudgetUnit *
+ the average score for each child is calculated according to the category
to which the child falls
+ the amount of average scores is determined, the assigned budget is calculated
to each child
+ for ease of solving, a new field specific to one was used
child who will remember the budget that the child spent
+ * awardingGifts *
+ sort the list of gifts according to price
+ the list of gifts is scrolled, and if a child's preference falls
in the requirements, the desired gift is given to the child
+ to determine if a child has already received a gift from someone
category, a new list was used to retain this information
+ * addInitialScore *
+ the list of children is also scrolled for each child who has not become one
adult, the initial score is added to the child's niceScores list.

### CreateOutput
+ In this function the final output is created which will be mapped and written in
JSON file. The list of children is processed and for each child
an output object is created that will be added to the final list.
Children who have become adults will be wiped out.

To perform sorting and reversing applied to lists, I used
* Collections *.
I used the * Jackson library * to read and write files.
