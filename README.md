# Programming Project: Dense Scrabble

## Clone Project

Begin by cloning the provided project and importing it into your workspace.

`git clone <url for github repository>`

After cloning this repository you want to run these commands

`git checkout -b development`

This will create a branch named development and switch you to it. The development branch is where you will make all your commits.

## Import into Eclipse

You should then go to Eclipse, which hopefully has finished installing.

In the top toolbar, click File --> Import. Double-click on General and then `Projects from Folder or Archive`. Click `Directory` and find the folder inside the repository named `DenseScrabble` and click Open. The project should pop up in the text box Projects. Click finish and you should be good to go!

## Complete Dense Scrabble Assignment

The board game Scrabble works by assigning points to wooden tiles that are marked with printed letters, and are arranged as interlocking words on a Scrabble board. It's described here: Scrabble.
We'll simplify this considerably, and consider the following question. We begin with the letter-scoring scheme from Scrabble:

`a = 1, b = 3, c = 3, d = 2, ..., z = 10.`

Given a text file - a novel for example, what is the token (word) in the file with the highest scoring density? Token density is calculated as follows: First, letters are assigned their scrabble score. All non-letters (e.g., period, comma, etc.) have score 0. A token's density equals the sum of the scrabble values of its characters, divided by the length of the token.

Some examples:

```
Token     Score
cab        7/3 = 2.33  (note: standard division, not Java integer division)
cab!       7/4 = 1.75  (token length is now 4, '!' has value 0)
zzz        30/3 = 10.0
```

Your solution should be in two classes, a driver class called DenseScrabbleTester, which includes main and uses Scanner to identify an external file for dense Scrabble study, and a class called DenseScrabble, which does the heavy lifting for the application. The DenseScrabble class must extend TextFileAccesor, in the way you did in ScrabbleFrequencies.

## Output

Your program should report the (or a) highest density token in the input file, along with the density value for that token, and the line number in the file the token appeared on.

Two sample files are provided: sampletext.txt is silly but useful, and HeartOfDarkness.txt is the famous novella by Joseph Conrad.

Some sample output:

```
enter file name
 sampletext.txt
winner: now   score 2.0   Line number: 1
-------------------------------
enter file name
 HeartOfDarkness.txt
winner: buzz   score 6.0   Line number: 759
```

## Tips:

Here is a list from a to z of the letter scores from Scrabble (so a has score 1, b has score 3, c has score 3, and so forth):

```
{1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10}
```

Notice that this list is in proper format for copying and pasting directly into your program as an int array.

It's far easier to convert lines of text to lowercase before processing.

Use MUST use the String method [split](https://www.geeksforgeeks.org/split-string-java-examples/), to extract the tokens in a line of text. You are going to be spliting on whitespace so use the method in this form: `split(" ")`.

Model your driver class after the ScrabbleDriver class in the ScrabbleFrequencies project

You need to comment your methods according to this [Javadoc Guide](https://github.com/jd12/liferay-portal/blob/master/readme/ADVANCED_JAVADOC_GUIDELINES.markdown).
