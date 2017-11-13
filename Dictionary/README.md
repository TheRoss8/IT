# Dictionary
###### Searching the meaning of "dictionary" in a dictionary

A small English dictionary made using a .csv file with a wordlist and each word's meaning found on the Internet.

The dictionary itself is **not** well optimized because the .csv file is already in alphabetical order, so the tree will have a layout similar to this:
```
A
  \
    B
      \
        C
          \
            D
```
and not like this one:
```
      D
    /   \
   B      F
 /   \  /   \
A     CE     G
```
and this difference is noticeable when you perform a search on the tree because the *divide et impera* algorythm becomes useless as the search becomes linear.
On the first tree the worst case occurs when you have to search for the last element and it is a very unstable way of searching items, as the time variates a lot depending on the position of the element.

On the other hand, the second tree is more balanced and more stable since the time is almost the same for every element you have to search for.


>Impossible is a word to be found only in the dictionary of fools.

*Napoleon Bonaparte*
