# Proiect  - Programare Orientata pe Obiect

- ##### Ion- Irinel Dinu 325CA, ACS, UPB
- #####	 [ion_irinel.dinu@stud.acs.upb.ro]()
- #####  [Github Repo Link](https://github.com/dinuionica/Santa-Claus )

##### Timp petrecut pentru rezolvare:
+ ~ 1 saptamana - Etapa 1
+ 1 zi - Etapa 2

## Continut Arhiva
* folderul src/ -> contine pachetele si clase implementate
* .git -> contine detalii despre versionarea codului
* README.md -> contine detalii despre structura si implementare


### Santa Claus is coming to ACS students - Etapa 2
---------------------------------------------------------------------
In cadrul etapei 2 a proiectului am implementat o serie noua de clase 
si pachete dupa cum urmeaza:
+ strategy
    + NiceScoreStrategy -> clasa specifica unui strategii bazate pe scorul 
    de cumintenie
    + IdStrategy -> clasa specifica unei strategii bazate pe id
    + NiceScoreCityStrategy  -> clasa specifica unei strategii bazate pe media 
    scorurilor unui oras
+ visitor
	+ BlackElfVisitor -> clasa specifica unui elf Black folosita pentru patternul
     Visitor
	+ PinkElfVisitor -> clasa specifica unui elf Pink folosita pentru patternul
     Visitor
	+ YellowElfVisitor -> clasa specifica unui elf Black folosita pentru patternul
     Visitor
+ interfaces
	+ Strategy -> interfata folosita pentru implementarea design patternului 
    strategy
	+ Visitable / Visitor -> interfete folosite pentru implementarea design
     patternului visitor
+ output
	+ GiftOutputData -> clasa specifica unui cadou de tip output

## Logica

##### NiceScoreBonus
In cadrul functiei de calculateBudgetUnit din clasa Command a fost implementata
noua functionalitate legata de bonusul scorului de cumintenie. Dupa ce s-a calculat
average scorul specific unui copil, se actualizeaza noua valoare folosind bonusul 
de input. Daca valoarea depaseste  valoarea maxima a unui average scor, aceasta
este trunchiata la 10.

##### Elves

Conceput de elfi a fost simulat folosind design patternul Visitor. Fiecare copil
este vizitat de un elf, in functie de tipul specific fiecaruia. 
+  BlackElfVisitor
    + In cadrul acestei clase este implementata o metoda specifica elfului Black, 
    prin care se scade valoarea bugetului asignat copilului cu 30%. De asemenea,
    este actualizata si valoarea bugetului de cheltuit pe care copilul il are disponibil.
+  PinkElfVisitor
	+ In cadrul acestei clase este implementata in mod similar o metoda prin care 
    se mareste valoarea celor doua bugete cu 30%;
+  YellowElfVisitor
	+ In cadrul acestei clase este implementata o metoda prin intermediul careia
     se atribuie un cadou unui copil care nu a primit niciun cadou. Se sorteaza 
     lista de cadouri si se verifica
     existenta celui mai ieftin cadou din categoria preferata a copilului ales de elf.

##### Strategy
Strategiile de acordare a cadourilor pentru copii au fost implementate folosind Strategy.
Lista de copii este sortata diferit in functie de tipul de strategie.
+  NiceScoreStrategy
    +  Aceasta clasa contine o metoda in cadrul careia este sortata lista de copii 
    descrescator dupa averageScore si in caz de egalitate dupa id. Lista de copii este
    transmisa apoi pentru acordarea cadourilor.
+  IdStrategy
   + Aceasta clasa contine o metoda de strategie in cadrul careia lista de copii este 
   sortata dupa id;
+  NiceScoreStrategy
	+ In cadrul acestei clase este implementata metoda de strategie. Pentru inceput se 
	creeaza o liste cu toate orasele. 
	+ Pentru fiecare oras se calculeaza suma de average 
	scoruri si numarul de copii. 
	+ Se calculeaza pentru fiecare average scorul specific.
	+ Se sorteaza lista de orase descrescator dupa average scor
	+ Se construieste lista finala de copii in functie de average scorul fiecarui oras

Enum-ul Cities a fost modificat, adaugandu-se o serie de noua de argumente:
averageScore, sumScore si numberChildren. In cadrul clasei Command au fost 
implementate urmatoarele metode :
 + applyStrategies:
 	+ Se exectua diferite strategii in functie de parametru de strategie de input
+ applyChangesBlackPinkElves
	+ Aplica schimbarile realizate de elfii Black si Pink folosind Visitor
+ applyChangesYellowElf
 	+ Aplica schimbarile realizate de elful Yellow folosind Visitor

### Santa Claus is coming to ACS students - Etapa 1

## Structura Claselor si Relatii Specifice
Pentru rezolvarea etapei 1, am implementat o serie de clase si pachete :
+ child
    + Child -> clasa care contine toate informatiile specifice unui copil
    + Baby -> clasa care mosteneste clasa Child, specifica unui copil de tip
	 Baby
    + Kid -> clasa care mosteneste clasa Child, specifica unui copil de tip 
	Kid
    + Teen -> clasa care mosteneste clasa Child, specifica unui copil de tip 
	Teen
	+ Young Adult -> clasa care mosteneste clasa Child, specifica unui copil de 
	tip Young Adult
	+ Gift -> clasa care contine informatiile specifice unui cadou

+ input
    + ChildInputData -> clasa specifica unui copil primit drept input
    + GiftInputData -> clasa specifica unui cadou primit drept input
    + ChildUpdate -> clasa specifica unui update anual primit ca input pentru 
	un copil
	+ AnnualChanges -> clasa specifica unui update anual primit ca input pentru
	 lista de copii
	+ Input -> clasa care contine toate informatiile primite ca input 
	+ InputLoader -> clasa care se ocupa cu incarcare datelor de input

+ output
    + ChildInputData -> clasa specifica unui copil transmis ca output final
    + ChildOutputList -> clasa specifica listei finale de copii transmisa ca 
	output
	+ Output -> clasa care contine toate informatiile transmise ca output
	+ Writer -> clasa care se ocupa de crearea si scrierea output-ului final

+ simulation
	+ DataBase -> clasa care creeaza listele de copii si cadouri primite ca
	 input
	+ ChildFactory -> clasa care se ocupa cu aplicarea pattern-ului factory 
	pentru crearea copiilor
	+ Simulation ->  clasa de tip Singleton care aplica simularile si 
	genereaza outputul final

+ actions
	+ Command -> clasa care contine comenzile aplicate pe lista de copii pentru 
	fiecare runda
	+ InitialRound -> clasa care aplica comenzile specifice rundei initiale
	+ AnnualRound -> clasa care aplica comenzile specifice unei runde anuale
	+ CreateOutput -> clasa care construieste lista finala de copii ca si output

+ interfaces
    + ChildInterface -> interfata specifica unui copil folosita pentru a calcula
	 AverageScore-ul

## Logica
Pentru rularea fiecarui test am create un folder numit output. Acest folder 
contine un numar de 25 de teste, denumit out_X.json unde X reprezinta numarul 
testului curent.

*Clasa Main* ruleaza testele din tests/ si compara rezultatele obtinute in
output/ cu cele din ref. De asemenea in cadrul clasei Main se ruleaza si 
checkstyle-ul.

*Clasa InputLoader* citeste fisierele in format JSON folosind biblioteca Jackson
si mapeaza campurile obiectului clasei Input. Pentru aceasta executie, se 
primeste path-ul catre fisierul cu datele de intrare.

*Clasa Writer* mapeaza si scrie obiectul de tip Output care contine rezultatele
simulate intr-un fisier JSON al carui path este de asemenea transmis.

Simularea se realizeaza folosind clasa Simulation. In cadrul acesteia se preiau
datele de input, folosind clasa Database care construieste lista initiala de
copii si lista de cadouri. Se creaza obiectul final de tip Output, se aplica
simularea initiala si apoi se creeaza pentru fiecare runda o copie a listei de
la runda curenta, care este folosita pentru a simula o noua runda anuala si 
aplicarea unor noi update-uri.
In final se transmite spre mapare si scriere obiectul final.

## Implementare

### Simulation
+ In cadrul acestei metode se preiau datele de input, se modifica in urma 
simularilor aplicate si se returneaza outputul final rezultat.

### ChildFactory
+ Aceasta clasa simuleaza un design pattern Singleton Factory
+ *createChildInput*
	+ in cadrul acestei metode se creeaza fiecare tip de copil in functie 
	de varsta acestuia folosind constructorii specificii
+ *createChild*
	-Se creeaza tipurile de copii in mod similar, dar rationamentul se aplica 
	pentru copii din baza de date, nu pentru copiii primiti drept input.

### DataBase 
+ Acesta clasa de tip Singleton simuleaza o baza de date. 
+ *createChildrenList*
	+ se instantieaza obiectul de tip factory
	+ se parcurge lista de copii primita ca input
	+ se creeaza un nou tip de copil in functie de varsta acestuia, apoi se 
	adauga in lista finala
+ *createGiftList*
	+ in mod similar se parcurge lista de inpu, se creeaz un nou cadou care 
	este adaugat la lista
	finala de cadouri
+ *createCopyList*
	+ se creeaza o copie a listei de copii folosind un constructor de tip 
	deep copy

### InitialRound
+ In cadrul acestei clase este implementata o metoda care simuleaza si aplica 
comenzile specifice rundei initiale.

### AnnualRound
+ In cadrul acestei clase este implementata o metoda care simuleaza si aplica
 comenzile specifice unei runde anuale.

### Command
+ In cadrul acestei clase de tip Singleton se aplica o serie de comenzi 
specifice unei runde
+  *annualUpdate*
    + se adauga niceScorul de update la lista de niceScoruri pentru copilul 
	cu id-ul dorit
	+ se parcurge lista de noi preferinte si daca in cadrul listei de 
	preferinte a copilul se gaseste deja categoria aceasta este stearsa. Apoi 
	se adauga pe prima pozitie in lista de preferinte a copilul noua categorie.
+  *increaseAge*
	+ se incrementeaza varsta fiecarui copil din lista
	+ folosind design pattern-ul factory se reactualizeaza tipul fiecarui copil 
	in functie de noua varsta a acestuia. 
+  *addNewChildren*
	+ se parcurge lista de noi copii
	+ se creeaza un nou copil pe baza datelor de input, se actualizeaza 
	campurile si se adauga
	la lista finala de copii
+ *addNewGift*
	+ se parcurge lista de cadouri primite drept input si se creeaza un nou 
	cadou pe baza informatiilor primite, care se adauga in lista finala de 
	cadouri
+ *updateSantaBudget*
	+ se actualizeaza valorea bugetului mosului pe baza noul buget primit 
	ca input
+ *removeYoungAdults*
	+ se sterg din lista copii care depasesc varsta maxima, (cei care au devenit
	 Young Adult)
+ *calculateBudgetUnit*
	+ se calculeaza pentru fiecare copil average scorul in functie de categoria
	la care se incadreaza copilul
	+ se determina suma de average scoruri, se calculeaza bugetul atribuit 
	fiecarui copil
	+ pentru usurinta rezolvarii, s-a folosit un nou camp specific unui 
	copil care va tine minte bugetul pe care l-a cheltuit copilul respectiv
+ *awardingGifts*
	+ se sorteaza lista de cadouri in functie de pret
	+ se parcurge lista de cadouri, si daca preferinta unui copil se incadreaza
	in cerinte, se atribuie cadoul dorit copilul
	+ pentru a determina daca un copil a primit deja un cadou dintr-o anumita 
	categorie, s-a folosit o noua lista care retine acesta informatie
+ * addInitialScore*
	+ se parcurge lista de copii  si pentru fiecare copil care nu a devenit 
	adult, se adauga scorul initial la lista de niceScoruri a copilului.

### CreateOutput
+ In cadrul acestei functii se creaza output final care va fi mapat si scris in 
fisierul JSON. Se parcurge lista de copii prelucrata, si pentru fiecare copil 
se creaza un obiect de tip output care va fi adaugat in lista finala. 
Copii care au devenit adulti vor fi stersi.

Pentru realizeaza sortarilor si inversarilor aplicate pe liste, am folosit 
*Collections*.
Pentru citirea si scriere fisierelor am folosit *biblioteca Jackson*.