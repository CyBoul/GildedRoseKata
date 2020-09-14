### Notes: ###

*At first, when I received the email with the invitation to do this kata,* 

*I took 5-10 minutes to just have a look, i read briefly the description and requirements.*

*And also took around 10-15min playing with codedojo, basically i wrote few unit tests just to try.*

*I knew I was not going to do it right away, but was curious. (ofc I saved my tests)*

* *Read kata description*
* *Read documentations and articles linked within, but not too much (spoiler alerts)*
* *Read requirements*
* *Have a look at the java folder on the git repo*
* *Try few tests on codedojo*

*(Another time) As I noticed, there are a pom.xml, a build.gradle, a settings.gradle and a gradle folder,*

*I choose to take time to install and try gradle. A new tool for my collection.*

*More informations about those optionnal steps can be found here: https://github.com/CyBoul/GildedRoseKata/blob/master/gradle-steps.md*

*And, also at another time (another day actually), I did the kata.*

*Corresponding to the <"Repo">,<"jUnit Tests"> and <"Refacto"> parts*


## Repo ##
----------
Create Repo on github (did it via the website)

Clone it locally and import the java fldr of the kata within

*As we are in the project-fldr, we move to the parent fldr*

```
cd ..
git clone https://github.com/CyBoul/GildedRoseKata.git
cp -r <project-folder>/* <git-cloned-folder>/
cd <git-cloned-folder>
```

==> First commit, java code untouched, only updated gradle wrapper.

==> And, push it remotely so other developpers (eventual colleagues..) can start from here.
```
git status
git add --all
git commit -m "import with wrapper updated"
git push
```

==> Create a new branch, because i am about to alter the original (working) code.
```
git branch refacto
git checkout refacto
```

## jUnit Tests ##
-----------------
First, I will start writting few unit tests according to the requirements, 

- to check if everything work properly as intended 

- and in the same time, to use them during refactoring as non-regression checks.

As I already wrote few tests by trying codedojo previously, I paste those in <GildedRoseTest.java>

For the tests, I gathered the redondant lines into the "getCustomUpdatedItem(...)" method, I only left lines needed for lisibility/understandability of test cases.

After writting tests, I executed them with:
```
./gradlew build
```

When tests passes ==> commit. 
```
git status
git add src/
git commit -m "added tests"
git push origin refacto
```


## Refactoring ##
-----------------
*There are 3 <IF> statements at the highest/outermost level:*
* *the two first ones act depending on the name of the item*
* *the 3rd one handling negative sellIn only*

*As it seems that everything depends mostly on the name, I start a new IF/ElSE block conditionned on names above the existing one.*

*I will add lines into it while reading original code conditions and try to delete doubled and useless conditions.*

*So, first IF block: decrement [quality] if not agedbrie, backstage pass or sulfuras, And, [quality] > 0*

--> This can be summarized easily into 1 line in the last "else" condition block (when not agedbrie, not sulfu, not a pass)

*Within the first else (high level), there are redundant IF conditions ( item.quality < 50 ), we can delete those*

*This part increment quality with specifications for "Backstage passes"*

I pasted those conditions into my new if/else under "Backstage passes" condition.

I kept the 2nd (high level) IF block (sellIn = sellIn-1 except sulfuras) for the moment.

*The 3rd IF (higher level) condition is base on negative [sellIn], in this block, like in the first initial IF:  
decrement [quality] if not agedbrie, backstage pass or sulfuras, And, [quality] > 0*

*And for Backstage passes, [quality] = 0 when expired*

--> I put both of those quality updates under corresponding conditions of my new IF/ELSE

*The final IF, increment agedbrie quality if [quality] < 50 (and still sellIn < 0), 
I paste this incrementation into the agedbrie condition of my IF/ELSE*

*As my condition "else if ( item.name.equals("Sulfuras, Hand of Ragnaros") )" is empty, I will replace the last "else" (without if condition) by "else if ( !item.name.equals("Sulfuras, Hand of Ragnaros") )" and delete the empty "else if ( item.name.equals("Sulfuras, Hand of Ragnaros") )" block.*

*Now I will implement the "Conjured" condition. Something I wonder is, if conjured item degrades 2x faster and expired items also... Does an expired and conjured item degrades 4x faster ? I will assume that yes.*

I try to build with gradle, tests passed, build successful. Im gonna commit.
```
git status
git add src/ 
git commit -m "refacto"
```

Make it a bit shorter
```
git status
git add src/ 
git commit -m "shorter"
```

Enabling the conjured test in <GildedRoseTest.java>
```
git status
git add src/ 
git commit -m "enabled conjured test"
```

Finish writing my notes, commit them
```
git status
git add steps.md README.md gradle-steps.md
git commit -m "adding notes"
```

==> Push it remotly
```
git push origin refacto
```

==> Merge the master and the refacto branches
```
git checkout master
git merge refacto
git push
```




### Conclusion ###

*In total, I guess I exceeded the time recommandation for this kata.*

*Taking into account, my first play with codedojo, trying gradle, and writting those progression notes.*

*But I tried to not exceed 1h30, when I really did the kata (tests + refacto)*

*I am now really looking forward the feedback :)*